package com.victimas.victimas.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity()
@Table(name = "profesiones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Profesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesion", nullable = false)
    private Integer idProfesion;

    @Column(name = "nombre_profesion", nullable = false)
    private String nombreProfesion;

    @OneToMany(mappedBy = "profesion")
    private List<Funcionario> funcionarios ;
}
