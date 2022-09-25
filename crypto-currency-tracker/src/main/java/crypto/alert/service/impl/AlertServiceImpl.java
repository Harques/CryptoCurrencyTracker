package crypto.alert.service.impl;

import crypto.alert.api.request.AlertCreateInput;
import crypto.alert.dao.entity.AlertEntity;
import crypto.alert.dao.enums.AlertStatus;
import crypto.alert.dao.repository.AlertRepository;
import crypto.alert.service.AlertService;
import crypto.currency.dao.entity.CurrencyEntity;
import crypto.currency.dao.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.NoSuchElementException;



@Service
@RequiredArgsConstructor
public class AlertServiceImpl implements AlertService {

    private final AlertRepository alertRepository;
    private final CurrencyRepository currencyRepository;

    @Override
    public void createAlert(AlertCreateInput alertCreateInput) {
        CurrencyEntity currency = currencyRepository.findBySymbol(alertCreateInput.getCurrencySymbol())
                .orElseThrow(() -> new NoSuchElementException("Currency with the given symbol could not be found in the database."));

        alertRepository.save(AlertEntity.builder()
                .createdAt(LocalDate.now())
                .targetPrice(alertCreateInput.getTargetPrice())
                .currency(currency)
                .status(AlertStatus.NEW).build());
    }

    @Override
    public void deleteAlert(Integer id) {
        AlertEntity alertEntity = alertRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Alert with the given id could not be found in the database."));

        alertRepository.delete(alertEntity);
    }

    @Override
    public void editAlert(Integer id) {
        AlertEntity alertEntity = alertRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Alert with the given id could not be found in the database."));

        if(alertEntity.getStatus() == AlertStatus.NEW)
            alertEntity.setStatus(AlertStatus.CANCELLED);

        else if(alertEntity.getStatus() == AlertStatus.TRIGGERED)
            alertEntity.setStatus(AlertStatus.ACKED);

        alertRepository.save(alertEntity);
    }

}
