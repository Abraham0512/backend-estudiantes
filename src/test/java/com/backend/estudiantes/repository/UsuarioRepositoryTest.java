package com.backend.estudiantes.repository;

import com.backend.estudiantes.model.Rol;
import com.backend.estudiantes.model.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class UsuarioRepositoryTest {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    void findByEmail_UsuarioEncontrado_RetornaUsuario() {

        Usuario usuario = new Usuario(
                "Test",
                "pruebaTes",
                "abraham@gmail.com",
                "123",
                Rol.ESTUDIANTE
        );

        Usuario usuarioGuardado =
                this.usuarioRepository.save(usuario);

        Optional<Usuario> usuarioOptional =
                this.usuarioRepository.findByEmail(usuarioGuardado.getEmail());

        assertTrue(usuarioOptional.isPresent(),"El usuario deberia de existir en la base de datos");

        Usuario usuarioEncontrado = usuarioOptional.get();

        assertEquals("abraham@gmail.com", usuarioEncontrado.getEmail(),"el email no coincide con el " +
                "email del usuario encontrado");

    }
}