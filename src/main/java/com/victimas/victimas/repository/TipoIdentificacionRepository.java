package com.victimas.victimas.repository;

import com.victimas.victimas.model.TipoIdentificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoIdentificacionRepository extends JpaRepository<TipoIdentificacion, Integer> {

    Optional<TipoIdentificacion> findByTipo (String tipo);
}
