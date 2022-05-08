package com.victimas.victimas.controller;

import com.victimas.victimas.dto.request.rol.RolDTOReq;
import com.victimas.victimas.dto.request.rol.RolDTOUpdate;
import com.victimas.victimas.dto.request.usuario.UsuarioDTOPost;
import com.victimas.victimas.dto.request.usuario.UsuarioDtoUpdate;
import com.victimas.victimas.dto.response.rol.RolDTO;
import com.victimas.victimas.dto.response.rol.RolDTOSinID;
import com.victimas.victimas.dto.response.usuario.UsuarioDTO;
import com.victimas.victimas.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/victimas/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController (UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id_usuario}")
    ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable(name = "id_usuario") int idUsuario){
        return ResponseEntity.ok(usuarioService.getUsuarioById(idUsuario));
    }

    @PostMapping()
    ResponseEntity<UsuarioDTO> postUsuario(@Valid @RequestBody UsuarioDTOPost usuarioDTO){
        return new ResponseEntity<>(usuarioService.createUsuario(usuarioDTO), HttpStatus.CREATED);
    }

    @GetMapping()
    ResponseEntity<List<UsuarioDTO>> getAllRoles(){
        return ResponseEntity.ok(usuarioService.getAllUsuarios());
    }

    @PutMapping()
    ResponseEntity<UsuarioDTO> putRol(@Valid @RequestBody UsuarioDtoUpdate usuarioDtoUpdate){
        return new ResponseEntity<>(usuarioService.updateUsuario(usuarioDtoUpdate), HttpStatus.OK);
    }

    @PutMapping("/desactivar/{id_usuario}")
    ResponseEntity<String> desactivarUsuario(@PathVariable(name = "id_usuario") int idUsuario){
        usuarioService.desactivarUsuario(idUsuario);
        return new ResponseEntity<>("Usuario con id_usuario: " + idUsuario + ", ha sido desactivado", HttpStatus.OK);
    }

    @PutMapping("/activar/{id_usuario}")
    ResponseEntity<String> activarUsuario(@PathVariable(name = "id_usuario") int idUsuario){
        usuarioService.activarUsuario(idUsuario);
        return new ResponseEntity<>("Usuario con id_usuario: " + idUsuario + ", ha sido activado", HttpStatus.OK);
    }


}
