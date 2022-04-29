package com.victimas.victimas.repository;

import com.victimas.victimas.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Integer> {

    Optional<Rol> findRolByNombreRol(String nombre);

}
