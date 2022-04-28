package com.victimas.victimas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity()
@Table(name = "cita")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita", unique = true, nullable = false)
    private Integer idCita;

    @Column(name = "fecha", unique = true, nullable = false)
    private Date fecha;

    @Column(name = "funcionario", unique = true, nullable = false)
    private Integer funcionario;

    @Column(name = "id_Victima", unique = true, nullable = false)
    private Integer idVictima;


}
