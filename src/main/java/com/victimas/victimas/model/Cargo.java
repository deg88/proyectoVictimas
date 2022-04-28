package com.victimas.victimas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity()
@Table(name = "cargos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cargo", unique = true, nullable = false)
    private Integer idCargo;

    @Column(name = "nombre_cargo", nullable = false)
    private String nombreCargo;

    @Column(name = "salario", nullable = false)
    private Integer salario;
}
