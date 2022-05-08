package com.victimas.victimas.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


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

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false, unique = true)
    private String password;

    @Column(name = "fecha_registro", columnDefinition = "TIMESTAMP")
    private LocalDateTime fechaRegistro;

    @Column(name = "ultima_actualizacion", columnDefinition = "TIMESTAMP")
    private LocalDateTime ultimaActualizacion;

    @Column(name = "activo", nullable = false)
    private Boolean activo;

    @ManyToOne()
    @JoinColumn(name="id_rol", nullable = false)
    private Rol rol;

    @OneToMany(mappedBy = "usuario")
    private List<Victima> victimas;

    @OneToMany(mappedBy = "usuario")
    private List<Funcionario> funcionarios ;

    public Usuario(String username, String password, LocalDateTime fechaRegistro, LocalDateTime ultimaActualizacion, Boolean activo, Rol rol) {
        this.username = username;
        this.password = password;
        this.fechaRegistro = fechaRegistro;
        this.ultimaActualizacion = ultimaActualizacion;
        this.activo = activo;
        this.rol = rol;
    }
}
