package com.backend.estudiantes.repository;

import com.backend.estudiantes.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // buscar usuario por email
    Optional<Usuario> findByEmail(String email);

}
