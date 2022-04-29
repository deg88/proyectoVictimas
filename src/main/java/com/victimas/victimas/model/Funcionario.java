package com.victimas.victimas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @ManyToOne()
    @JoinColumn(name="id_profesion", nullable = false)
    private Profesion profesion;

    @ManyToOne()
    @JoinColumn(name="id_cargo", nullable = false)
    private Cargo cargo;

    @ManyToOne()
    @JoinColumn(name="id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne()
    @JoinColumn(name="id_tipo_identificacion", nullable = false)
    private TipoIdentificacion tipoIdentificacion;

    @OneToMany(mappedBy = "funcionario")
    private List<Cita> citas ;
}
