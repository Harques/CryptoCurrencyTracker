package crypto.alert.api.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlertCreateInput {
    @NotBlank(message = "Currency symbol is required.")
    private String currencySymbol;

    @NotNull(message = "Target price is required.")
    private Double targetPrice;

}
