package com.victimas.victimas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

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

    @Column(name = "nombres", nullable = false)
    private  String nombres;

    @Column(name = "apellidos",nullable = false)
    private String apellidos;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "telefono", unique = true, nullable = false)
    private String telefono;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;

    @ManyToOne()
    @JoinColumn(name="id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne()
    @JoinColumn(name="id_tipo_identificacion", nullable = false)
    private TipoIdentificacion tipoIdentificacion;

    @OneToMany(mappedBy = "victima")
    private List<Cita> citas ;

}
