package crypto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "deneme")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DenemeEntity {
    @Id
    @Column(name = "data")
    private Integer data;
}
