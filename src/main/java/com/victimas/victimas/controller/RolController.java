package com.victimas.victimas.controller;

import com.victimas.victimas.dto.request.RolDTOReq;
import com.victimas.victimas.dto.request.RolDTOUpdate;
import com.victimas.victimas.dto.response.RolDTO;
import com.victimas.victimas.dto.response.RolDTOSinID;
import com.victimas.victimas.service.RolServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping()
    ResponseEntity<List<RolDTO>> getAllRoles(){
        return ResponseEntity.ok(rolService.getAllRols());
    }

    @DeleteMapping("/{id_rol}")
    ResponseEntity<String> DeleteRolByID(@PathVariable(name = "id_rol") int idRol){
        rolService.deleteRolById(idRol);
        return new ResponseEntity<>("Se ha eliminado el rol con id " + idRol, HttpStatus.OK);
    }

    @PutMapping()
    ResponseEntity<RolDTO> putRol(@Valid @RequestBody RolDTOUpdate rolDTO){
        return new ResponseEntity<>(rolService.updateRol(rolDTO), HttpStatus.OK);
    }

}
