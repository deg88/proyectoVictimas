package com.victimas.victimas.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RolDTOReq {

    @NotEmpty(message = "El campo nombre_rol no puede estar vacio")
    @Size(min = 5, message = "La longitud mínima del campo nombre_rol es de 5 carácteres")
    private String nombreRol;

    @NotEmpty(message = "El campo descripcion no puede estar vacio")
    @Size(min = 5, message = "La longitud mínima del campo descripción es de 5 carácteres")
    private String descripcion;
}
