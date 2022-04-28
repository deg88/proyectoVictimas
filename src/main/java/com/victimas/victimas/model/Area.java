package com.victimas.victimas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity()
@Table(name = "areas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_areas", unique = true, nullable = false)
    private Integer idAreas;

    @Column(name = "nombre_area", unique = true, nullable = false)
    private String nomrbeArea;

    @Column(name = "descripcion", unique = true, nullable = false)
    private String descripcion;

    @Column(name = "id_Cargos", unique = true, nullable = false)
    private Integer idCargos;


}
