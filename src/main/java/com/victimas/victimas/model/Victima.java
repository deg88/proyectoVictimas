package com.victimas.victimas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.Date;

@Entity()
@Table(name = "victimas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Victima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_identificacion", unique = true, nullable = false)
    private Integer identificacion;

    @Column(name = "id_tipo", unique = true, nullable = false)
    private Integer idTipo;

    @Column(name = "nombres", nullable = false)
    private  String nombres;

    @Column(name = "apellidos",nullable = false)
    private String apellidos;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "telefono", unique = true, nullable = false)
    private String telefono;

    @Column(name = "id_victima", nullable = false)
    private Date fechaNacimiento;

    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;






}
