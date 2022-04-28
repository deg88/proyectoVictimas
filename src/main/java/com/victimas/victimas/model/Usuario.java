package com.victimas.victimas.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity()
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", unique = true, nullable = false)
    private Integer idUsuario;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false, unique = true)
    private String password;

    @Column(name = "fecha_registro", columnDefinition = "TIMESTAMP")
    private LocalDateTime fechaRegistro;

    @Column(name = "activo", nullable = false)
    private Boolean activo;

    @ManyToOne()
    @JoinColumn(name="id_rol", nullable = false)
    private Rol rol;

}
