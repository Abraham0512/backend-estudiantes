package com.backend.estudiantes.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDTO {
    @NotBlank(message = "Debe de ingresar el Email.")
    @Email(message = "El email debe de ser valido")
    private String email;
    @NotBlank(message = "Debe de ingresar la contraseña")
    private String password;


    public LoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
