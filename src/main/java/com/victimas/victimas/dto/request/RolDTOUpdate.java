package com.victimas.victimas.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RolDTOUpdate {

    @Range(min = 1L, message = "Debe ingresar el id_rol del rol que desea actualizar")
    private int idRol;

    @Size(min = 5, message = "La longitud mínima del campo nombre_rol es de 5 carácteres")
    private String nombreRol;

    @Size(min = 5, message = "La longitud mínima del campo descripción es de 5 carácteres")
    private String descripcion;

}
