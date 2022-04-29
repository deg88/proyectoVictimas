package com.victimas.victimas.exception;

import com.victimas.victimas.dto.response.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@ControllerAdvice(annotations = RestController.class)
public class ApiExceptionHandler {

    @ExceptionHandler(ResourceNotFountException.class)
    public ResponseEntity<ErrorDTO> resourceNotFountException (ResourceNotFountException e){

        ErrorDTO error = new ErrorDTO("Resource Not Fount Exception", e.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorDTO> invalidArgumentsException(MethodArgumentNotValidException e){

        ErrorDTO errorDTO = new ErrorDTO();

        errorDTO.setCode("Campos invalidos en el payload");

        errorDTO.setMessage("Algunos campos no cumplen con los requerimientos");

        HashMap<String, List<String>> errors = new HashMap<>();

        e.getFieldErrors().forEach( error -> {

            String campo = error.getField();

            String msg = error.getDefaultMessage();

            errors.compute(campo, ($,l)->
                    new ArrayList<>(){
                        {
                            addAll(!Objects.isNull(l) ? l : new ArrayList<>());
                            add(msg);
                        }
                    });
        });
        errorDTO.setErrors(errors);

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceAlreadyExists.class)
    public ResponseEntity<ErrorDTO> resourceAlreadyExist (ResourceAlreadyExists e){

        ErrorDTO error = new ErrorDTO("Resource Already Exception", e.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
