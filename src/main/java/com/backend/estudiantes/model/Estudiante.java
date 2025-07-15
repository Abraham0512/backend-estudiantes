package com.backend.estudiantes.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "estudiante")
@Data
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "codigo", nullable = false)
    private String codigo;

    @Column(name = "hora_acumuladas")
    private int horaAcumuladas;

    @Column(name = "programa_academico")
    private String programaAcademico;

    @Column(name = "semestre")
    private int semestre;

    @Enumerated(EnumType.STRING)
    private EstadoEstudiante estado = EstadoEstudiante.ACTIVO;

    @OneToOne
    @JoinColumn(name = "usuario_id" , nullable = false)
    private Usuario usuario;


}
