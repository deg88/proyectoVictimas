package com.victimas.victimas.dto.request.tipoIdentificacion;

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
public class TipoIdentificacionDTOPost {

    @NotEmpty(message = "El campo tipo no puede estar vacio")
    @Size(min = 2, message = "La longitud mínima del campo tipo es de 2 carácteres")
    private String tipo;

}
