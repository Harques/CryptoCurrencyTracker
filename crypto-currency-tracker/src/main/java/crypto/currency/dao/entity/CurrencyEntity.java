package crypto.currency.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "currency")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrencyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column(unique = true)
    private String symbol;

    @Column
    private Double currentPrice;

    @Column
    private LocalDate createdTime;

    @Column
    private Boolean enabled;
}
