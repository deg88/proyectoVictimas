package com.victimas.victimas.dto.request.usuario;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UsuarioDtoUpdate {

    @NotNull(message = "El campo id_usuario no puede estar vacio")
    private Integer idUsuario;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Pattern(regexp = "^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,16}$"
            , message = "La contraseña debe tener al entre 8 y 16 caracteres," +
            " al menos un dígito, al menos una minúscula, al menos una mayúscula" +
            " y al menos un caracter no alfanumérico.")
    private String password;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer rolId;
}
