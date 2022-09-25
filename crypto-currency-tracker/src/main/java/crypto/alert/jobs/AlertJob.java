package crypto.alert.jobs;

import crypto.alert.dao.entity.AlertEntity;
import crypto.alert.dao.enums.AlertStatus;
import crypto.alert.dao.repository.AlertRepository;
import crypto.alert.service.impl.AlertServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
@Profile("tst")
@RequiredArgsConstructor
public class AlertJob {

    private final AlertRepository alertRepository;

    @Scheduled(fixedDelay = 30000)
    private void targetPriceControl() {
        updateAlertStatus();
        sendNotification();
    }

    private void updateAlertStatus(){
        List<AlertEntity> alertEntityList = alertRepository.findAll()
                .stream()
                .filter(a -> a.getCurrency().getCurrentPrice() >= a.getTargetPrice() && a.getStatus() == AlertStatus.NEW)
                .collect(Collectors.toList());

        alertRepository.saveAll(alertEntityList.stream().map(a -> {
            a.setStatus(AlertStatus.TRIGGERED);
            return a;
        }).collect(Collectors.toList()));

    }

    private void sendNotification(){
        List<AlertEntity> alertEntityList = alertRepository.findAll()
                .stream()
                .filter(a -> a.getStatus() == AlertStatus.TRIGGERED)
                .collect(Collectors.toList());

        Logger logger = Logger.getLogger(AlertServiceImpl.class.getName());

        alertEntityList.forEach(a -> logger.log(Level.INFO,"Currency named " + a.getCurrency().getName() +
                " has reached its target price of " + a.getTargetPrice()));
    }
}
