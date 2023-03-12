package crypto.currency.api.impl;

import crypto.currency.api.CurrencyApi;
import crypto.currency.api.request.CurrencyCreateInput;
import crypto.currency.api.response.CurrencyOutput;
import crypto.currency.exceptions.UnsupportedCurrencyCreationException;
import crypto.currency.service.CurrencyService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@Api(tags = "Currency API")
@Tag(name = "Currency API", description = "Currency API")
public class CurrencyApiImpl implements CurrencyApi {

    private final CurrencyService currencyService;

    @Override
    public ResponseEntity<Void> createCurrency(CurrencyCreateInput currencyCreateInput) throws UnsupportedCurrencyCreationException {
        currencyService.createCurrency(currencyCreateInput);
        return ResponseEntity.status(201).build();
    }

    @Override
    public ResponseEntity<Void> deleteCurrency(String symbol) {
        currencyService.deleteCurrency(symbol);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<CurrencyOutput>> getAllCurrencies() {
        return ResponseEntity.ok(currencyService.getAllCurrencies());
    }

    @Override
    public ResponseEntity<CurrencyOutput> getCurrency(String symbol) {
        return ResponseEntity.ok(currencyService.getCurrency(symbol));
    }
}
