package com.backend.estudiantes.controller;

import com.backend.estudiantes.dto.LoginDTO;
import com.backend.estudiantes.model.Usuario;
import com.backend.estudiantes.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // endpoint del login
    @PostMapping("login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDTO loginDTO) {

        try {

            Usuario usuario = this.authService.authenticate(loginDTO.getEmail(), loginDTO.getPassword());
            return ResponseEntity.ok(Map.of(
                    "message", "Login exitoso",
                    "email", usuario.getEmail(),
                    "rol", usuario.getRol().name()
            ));

        } catch (RuntimeException e) {

            return ResponseEntity.badRequest().body(Map.of(
                    "error", e.getMessage()
            ));
        }

    }
}
