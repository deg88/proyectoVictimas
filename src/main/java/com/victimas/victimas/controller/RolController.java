package com.victimas.victimas.controller;

import com.victimas.victimas.dto.request.RolDTOReq;
import com.victimas.victimas.dto.response.RolDTO;
import com.victimas.victimas.dto.response.RolDTOSinID;
import com.victimas.victimas.service.RolServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/victimas/rol")
public class RolController {

    private final RolServiceImpl rolService;

    public RolController(RolServiceImpl rolService) {
        this.rolService = rolService;
    }

    @GetMapping("/{id_rol}")
    ResponseEntity<RolDTOSinID> getRolByID(@PathVariable(name = "id_rol") int idRol){
        return ResponseEntity.ok(rolService.getRolById(idRol));
    }

    @PostMapping()
    ResponseEntity<RolDTO> postRol(@Valid @RequestBody RolDTOReq rolDTO){
        return new ResponseEntity<>(rolService.createRol(rolDTO), HttpStatus.CREATED);
    }
}
