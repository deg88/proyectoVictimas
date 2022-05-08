package com.victimas.victimas.dto.request.usuario;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UsuarioDTOPost {

    @NotEmpty(message = "El campo username no puede estar vacio")
    @Size(min = 8, message = "La longitud mínima del campo username es de 8 carácteres")
    private String username;

    @Pattern(regexp = "^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,16}$"
            , message = "La contraseña debe tener al entre 8 y 16 caracteres," +
            " al menos un dígito, al menos una minúscula, al menos una mayúscula" +
            " y al menos un caracter no alfanumérico.")
    private String password;

    @NotNull(message = "El campo rol_id no puede estar vacio")
    private Integer rolId;

}
