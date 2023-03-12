package crypto.alert.dao.entity;

import crypto.alert.dao.enums.AlertStatus;
import crypto.currency.dao.entity.CurrencyEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "alert")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlertEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "currency_id")
    private CurrencyEntity currency;

    @Column
    private Double targetPrice;

    @Column
    private LocalDate createdAt;

    @Column
    @Enumerated(EnumType.STRING)
    private AlertStatus status;


}
