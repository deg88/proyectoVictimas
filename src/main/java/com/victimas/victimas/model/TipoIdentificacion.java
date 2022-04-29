package com.victimas.victimas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity()
@Table(name = "tipo_identificacion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TipoIdentificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo", unique = true, nullable = false)
    private Integer idTipo;

    @Column(name = "tipo", unique = true, nullable = false)
    private String tipo;

    @OneToMany(mappedBy = "tipoIdentificacion")
    private List<Victima> victimas ;

    @OneToMany(mappedBy = "tipoIdentificacion")
    private List<Funcionario> funcionarios ;


}
