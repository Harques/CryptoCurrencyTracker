package crypto.authentication.dao.entity;

import lombok.Getter;

import javax.persistence.*;

@Table(name = "role")
@Entity
@Getter
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;

}
