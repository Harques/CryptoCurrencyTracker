package crypto.currency.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class CurrencyOutput {
    private String name;
    private String symbol;
    private Double currentPrice;
}
