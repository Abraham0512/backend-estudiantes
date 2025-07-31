package com.backend.estudiantes.service;

import com.backend.estudiantes.model.Usuario;
import com.backend.estudiantes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario authenticate(String email, String pass) {

        Usuario usuario = this.usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // primero se guarda pass hash
        if (!passwordEncoder.matches(pass, usuario.getPassword())) {

            throw new RuntimeException("la contraseña no es correcta");
        }

        return usuario;
    }

}
