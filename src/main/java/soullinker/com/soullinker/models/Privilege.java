package soullinker.com.soullinker.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Table(name = "privileges")
@Entity
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "privileges")
    private List<Role> roles;

    public Privilege(final String name) {
        super();
        this.name = name;
    }

}
