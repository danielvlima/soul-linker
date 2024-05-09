package soullinker.com.soullinker.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class UserResponse {
    private UUID id;
    private String name;
    private Date birthDate;
    private String cpf;
    private String email;
}
