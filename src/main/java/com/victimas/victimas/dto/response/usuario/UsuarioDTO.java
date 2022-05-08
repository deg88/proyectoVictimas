package com.victimas.victimas.dto.response.usuario;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UsuarioDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer idUsuario;

    private String username;

    private LocalDateTime fechaRegistro;

    private LocalDateTime ultimaActualizacion;

    private boolean activo;

    private Integer rolId;

    public UsuarioDTO(String username, LocalDateTime fechaRegistro, LocalDateTime ultimaActualizacion, boolean activo, Integer rolId) {
        this.username = username;
        this.fechaRegistro = fechaRegistro;
        this.ultimaActualizacion = ultimaActualizacion;
        this.activo = activo;
        this.rolId = rolId;
    }
}
