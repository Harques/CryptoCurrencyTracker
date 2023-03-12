package crypto.currency.api.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyCreateInput {
    @NotBlank(message = "Currency name is required.")
    private String name;

    @NotBlank(message = "Currency symbol is required.")
    private String symbol;

    @NotNull(message = "Currency current price is required.")
    private Double currentPrice;
}
