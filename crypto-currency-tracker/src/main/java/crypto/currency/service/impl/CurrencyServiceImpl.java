package crypto.currency.service.impl;

import crypto.currency.api.request.CurrencyCreateInput;
import crypto.currency.api.response.CurrencyOutput;
import crypto.currency.dao.entity.CurrencyEntity;
import crypto.currency.dao.repository.CurrencyRepository;
import crypto.currency.exceptions.UnsupportedCurrencyCreationException;
import crypto.currency.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private static final String[] currencySymbols = { "ETH", "LTC", "ZKN", "MRD", "LPR", "GBZ" };
    private final CurrencyRepository currencyRepository;

    @Override
    public void createCurrency(CurrencyCreateInput currencyCreateInput) throws UnsupportedCurrencyCreationException {
        if(Arrays.asList(currencySymbols).contains(currencyCreateInput.getSymbol()))
            throw new UnsupportedCurrencyCreationException("Unsupported currency type.");

        currencyRepository.save(CurrencyEntity
                .builder()
                .name(currencyCreateInput.getName())
                .currentPrice(currencyCreateInput.getCurrentPrice())
                .enabled(true)
                .createdTime(LocalDate.now())
                .symbol(currencyCreateInput.getSymbol())
                .build());
    }

    @Override
    public void deleteCurrency(String symbol) {
        CurrencyEntity currencyEntity = currencyRepository.findBySymbol(symbol)
                .orElseThrow(() -> new NoSuchElementException("Currency with the given symbol could not be found in the database."));

        currencyRepository.delete(currencyEntity);

    }

    @Override
    public List<CurrencyOutput> getAllCurrencies() {
        return currencyRepository.findAll().stream().map(a -> CurrencyOutput.builder()
                .currentPrice(a.getCurrentPrice())
                .name(a.getName())
                .symbol(a.getSymbol()).build())
                .collect(Collectors.toList());
    }

    @Override
    public CurrencyOutput getCurrency(String symbol) {
        CurrencyEntity currencyEntity = currencyRepository.findBySymbol(symbol)
                .orElseThrow(() -> new NoSuchElementException("Currency with the given symbol could not be found in the database."));

        return CurrencyOutput.builder()
                .symbol(currencyEntity.getSymbol())
                .name(currencyEntity.getName())
                .currentPrice(currencyEntity.getCurrentPrice())
                .build();
    }


}
