package soullinker.com.soullinker.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    @JdbcTypeCode(Types.VARCHAR)
    private UUID id;
    private String name;
    private Date birthDate;
    private String password;
    private String cpf;
    private String email;

    @ManyToMany(mappedBy = "users")
    private List<UserRole> roles;
}
