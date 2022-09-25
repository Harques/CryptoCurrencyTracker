package crypto.alert.service.impl;

import crypto.alert.api.request.AlertCreateInput;
import crypto.alert.dao.entity.AlertEntity;
import crypto.alert.dao.repository.AlertRepository;
import crypto.currency.dao.entity.CurrencyEntity;
import crypto.currency.dao.repository.CurrencyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class AlertServiceImplTest {

    @Mock
    public CurrencyRepository currencyRepository;

    @Mock
    public AlertRepository alertRepository;

    @InjectMocks
    AlertServiceImpl alertService;

    @Test
    void whenCreateAlertIsCalledWithNotFoundSymbol_thenThrowNoSuchElementException(){
        Exception exception = Assertions.assertThrows(NoSuchElementException.class,
                () -> alertService.createAlert(AlertCreateInput.builder()
                        .currencySymbol("AHO").build()));

        assertEquals("Currency with the given symbol could not be found in the database.", exception.getMessage());
    }

    @Test
    void whenCreateAlertIsCalledWithSupportedSymbol_thenSaveMethodIsCalled(){
        Mockito.when(currencyRepository.findBySymbol(any(String.class))).thenReturn(Optional.of(new CurrencyEntity()));

        alertService.createAlert(AlertCreateInput.builder().currencySymbol("AHH").build());

        Mockito.verify(alertRepository, Mockito.times(1))
                .save(any(AlertEntity.class));
    }

    @Test
    void whenDeleteAlertIsCalledWithNotFoundId_thenThrowNoSuchElementException(){
        Exception exception = Assertions.assertThrows(NoSuchElementException.class,
                () -> alertService.deleteAlert(1));

        assertEquals("Alert with the given id could not be found in the database.", exception.getMessage());
    }

    @Test
    void whenDeleteAlertIsCalledWithFoundId_thenDeleteMethodIsCalled(){
        Mockito.when(alertRepository.findById(any(Integer.class))).thenReturn(Optional.of(new AlertEntity()));

        alertService.deleteAlert(1);

        Mockito.verify(alertRepository, Mockito.times(1)).delete(any(AlertEntity.class));
    }

    @Test
    void whenEditAlertIsCalledWithNotFoundId_thenThrowNoSuchElementException(){
        Exception exception = Assertions.assertThrows(NoSuchElementException.class,
                () -> alertService.editAlert(1));

        assertEquals("Alert with the given id could not be found in the database.", exception.getMessage());

    }

    @Test
    void whenEditAlertIsCalledWithFoundId_thenSaveMethodIsCalled(){
        Mockito.when(alertRepository.findById(any(Integer.class))).thenReturn(Optional.of(new AlertEntity()));

        alertService.editAlert(1);

        Mockito.verify(alertRepository, Mockito.times(1)).save(any(AlertEntity.class));
    }


}