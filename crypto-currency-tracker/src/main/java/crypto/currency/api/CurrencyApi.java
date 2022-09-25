package crypto.currency.api;

import crypto.currency.api.request.CurrencyCreateInput;
import crypto.currency.api.response.CurrencyOutput;
import crypto.currency.exceptions.UnsupportedCurrencyCreationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/currency")
public interface CurrencyApi {

    @PostMapping
    ResponseEntity<Void> createCurrency(@Valid @RequestBody CurrencyCreateInput currencyCreateInput) throws UnsupportedCurrencyCreationException;

    @DeleteMapping
    ResponseEntity<Void> deleteCurrency(@RequestParam String symbol);

    @GetMapping
    ResponseEntity<List<CurrencyOutput>> getAllCurrencies();

    @GetMapping(params = "symbol")
    ResponseEntity<CurrencyOutput> getCurrency(String symbol);

}
