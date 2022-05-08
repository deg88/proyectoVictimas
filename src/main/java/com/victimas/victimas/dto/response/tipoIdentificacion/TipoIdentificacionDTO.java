package com.victimas.victimas.dto.response.tipoIdentificacion;

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
public class TipoIdentificacionDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer idTipoIdentificacion;

    private String tipo;

    public TipoIdentificacionDTO(String tipo) {
        this.tipo = tipo;
    }
}
