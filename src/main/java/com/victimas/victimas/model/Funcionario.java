package com.victimas.victimas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity()
@Table(name = "funcionarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_identificacion", unique = true, nullable = false)
    private Integer idIdentificacion;

    @Column(name = "nombres", unique = true, nullable = false)
    private  String nombres;

    @Column(name = "apellidos", unique = true, nullable = false)
    private String apellidos;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "fecha_nacimiento", unique = true, nullable = false)
    private Date fechaNacimiento;

    @Column(name = "id_profeciones", unique = true, nullable = false)
    private Integer idProfeciones;

    @Column(name = "id_cargos", unique = true, nullable = false)
    private Integer idCargos;

    @Column(name = "id_usuarios", unique = true, nullable = false)
    private  Integer idUsuarios;

    @Column(name = "id_tipo", unique = true, nullable = false)
    private Integer idTipo;
}
