package com.victimas.victimas.controller;

import com.victimas.victimas.dto.request.tipoIdentificacion.TipoIdentificacionDTOPost;
import com.victimas.victimas.dto.request.tipoIdentificacion.TipoIdentificacionDTOUpdate;
import com.victimas.victimas.dto.response.tipoIdentificacion.TipoIdentificacionDTO;
import com.victimas.victimas.service.tipoIdentificacion.TipoIdentificacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/victimas/tipo_identificacion")
public class TipoIdentificacionController {

    private final TipoIdentificacionService tipoIdentificacionService;

    public TipoIdentificacionController(TipoIdentificacionService tipoIdentificacionService) {
        this.tipoIdentificacionService = tipoIdentificacionService;
    }

    @GetMapping("/{id_tipo_identificacion}")
    ResponseEntity<TipoIdentificacionDTO> getTipoIdentificacionbyId(@PathVariable(name = "id_tipo_identificacion") int idTipoIdentificacion){
        return ResponseEntity.ok(tipoIdentificacionService.getTipoIdentificacionById(idTipoIdentificacion));
    }

    @PostMapping()
    ResponseEntity<TipoIdentificacionDTO> postTipoIdentificacion(@Valid @RequestBody TipoIdentificacionDTOPost tipoIdentificacionDTOPost){
        return new ResponseEntity<>(tipoIdentificacionService.createTipoIdentificacion(tipoIdentificacionDTOPost),
                HttpStatus.CREATED);
    }

    @GetMapping()
    ResponseEntity<List<TipoIdentificacionDTO>> getAllTiposIdentificacion(){
        return ResponseEntity.ok(tipoIdentificacionService.getAllTiposIdentificacion());
    }


    @DeleteMapping("/{id_tipo_identificacion}")
    ResponseEntity<String> DeleteTipoIdentificacionById(@PathVariable(name = "id_tipo_identificacion") int idTipoIdentificacion){
        tipoIdentificacionService.deleteTipoIdentificacionById(idTipoIdentificacion);
        return new ResponseEntity<>("Se ha eliminado el tipo de identificacion con id "
                + idTipoIdentificacion, HttpStatus.OK);
    }

    @PutMapping()
    ResponseEntity<TipoIdentificacionDTO> putRol(@Valid @RequestBody TipoIdentificacionDTOUpdate tipoIdentificacionDTOUpdate){
        return new ResponseEntity<>(tipoIdentificacionService.updateTipoIdentificacion(tipoIdentificacionDTOUpdate), HttpStatus.OK);
    }
}
