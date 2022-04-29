package com.victimas.victimas.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RolDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int idRol;

    private String nombreRol;

    private String descripcion;

    public RolDTO (String nombreRol, String descripcion){
        this.nombreRol = nombreRol;
        this.descripcion = descripcion;
    }

}
