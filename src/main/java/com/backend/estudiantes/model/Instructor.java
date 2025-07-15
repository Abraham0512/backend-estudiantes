package com.backend.estudiantes.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "especialidad")
    private String especialidad;

    @Column(name = "fechaContratacion")
    private LocalDate fechaContratacion;

    @Column(name = "fotoPerfil")
    private String fotoPerfil;

    @OneToOne
    @JoinColumn(name = "usuario_id", unique = true, nullable = false)
    private Usuario usuario;


}
