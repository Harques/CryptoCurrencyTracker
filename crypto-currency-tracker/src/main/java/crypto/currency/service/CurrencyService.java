package crypto.currency.service;

import crypto.currency.api.request.CurrencyCreateInput;
import crypto.currency.api.response.CurrencyOutput;
import crypto.currency.exceptions.UnsupportedCurrencyCreationException;

import java.util.List;

public interface CurrencyService {
    void createCurrency(CurrencyCreateInput currencyCreateInput) throws UnsupportedCurrencyCreationException;
    void deleteCurrency(String symbol);

    List<CurrencyOutput> getAllCurrencies();

    CurrencyOutput getCurrency(String symbol);

}
