package crypto.currency.service.impl;

import crypto.currency.api.request.CurrencyCreateInput;
import crypto.currency.dao.entity.CurrencyEntity;
import crypto.currency.dao.repository.CurrencyRepository;
import crypto.currency.exceptions.UnsupportedCurrencyCreationException;
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
class CurrencyServiceImplTest {

    @Mock
    public CurrencyRepository currencyRepository;

    @InjectMocks
    CurrencyServiceImpl currencyService;

    @Test
    void whenCreateCurrencyIsCalledWithUnsupportedSymbol_thenThrowUnsupportedCurrencyCreationException(){
        Exception exception = Assertions.assertThrows(UnsupportedCurrencyCreationException.class
                , () -> currencyService.createCurrency(CurrencyCreateInput.builder()
                        .symbol("ETH").build()));
        assertEquals("Unsupported currency type.", exception.getMessage());
    }

    @Test
    void whenCreateCurrencyIsCalledWithSupportedSymbol_thenSaveMethodIsCalled() throws UnsupportedCurrencyCreationException {
        currencyService.createCurrency(CurrencyCreateInput.builder().symbol("AHO").build());

        Mockito.verify(currencyRepository, Mockito.times(1))
                .save(any(CurrencyEntity.class));

    }

    @Test
    void whenDeleteCurrencyIsCalledWithNotFoundSymbol_thenThrowNoSuchElementException(){
        Exception exception = Assertions.assertThrows(NoSuchElementException.class,
                () -> currencyService.deleteCurrency("AHO"));

        assertEquals("Currency with the given symbol could not be found in the database.", exception.getMessage());

    }


    @Test
    void whendeleteCurrencyIsCalled_thenFindBySymbolIsCalled(){
        Mockito.when(currencyRepository.findBySymbol(any(String.class))).thenReturn(Optional.of(new CurrencyEntity()));

        currencyService.deleteCurrency("AHO");

        Mockito.verify(currencyRepository, Mockito.times(1))
                .findBySymbol(any(String.class));
    }

    @Test
    void whenDeleteCurrencyIsCalled_thenDeleteIsCalled(){
        Mockito.when(currencyRepository.findBySymbol(any(String.class))).thenReturn(Optional.of(new CurrencyEntity()));

        currencyService.deleteCurrency("AHO");

        Mockito.verify(currencyRepository, Mockito.times(1))
                .delete(any(CurrencyEntity.class));
    }

    @Test
    void whenGetAllCurrenciesIsCalled_thenFindAllIsCalled(){
        currencyService.getAllCurrencies();

        Mockito.verify(currencyRepository, Mockito.times(1))
                .findAll();
    }

    @Test
    void whenGetCurrencyIsCalledWithNotFoundSymbol_thenThrowNoSuchElementException(){
        Exception exception = Assertions.assertThrows(NoSuchElementException.class,
                () -> currencyService.getCurrency("AHO"));

        assertEquals("Currency with the given symbol could not be found in the database.", exception.getMessage());

    }

    @Test
    void whenGetCurrencyIsCalled_thenFindBySymbolIsCalled(){
        Mockito.when(currencyRepository.findBySymbol(any(String.class))).thenReturn(Optional.of(new CurrencyEntity()));

        currencyService.getCurrency("AHO");

        Mockito.verify(currencyRepository, Mockito.times(1))
                .findBySymbol(any(String.class));
    }

}