package soullinker.com.soullinker.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class CreateUserRequest {
    private String name;
    private Date birthDate;
    private String password;
    private String cpf;
    private String email;
}
