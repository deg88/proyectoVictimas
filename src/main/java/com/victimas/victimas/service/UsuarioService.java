package com.victimas.victimas.service;

import com.victimas.victimas.dto.request.usuario.UsuarioDTOPost;
import com.victimas.victimas.dto.request.usuario.UsuarioDtoUpdate;
import com.victimas.victimas.dto.response.usuario.UsuarioDTO;

import java.util.List;

public interface UsuarioService {

    UsuarioDTO getUsuarioById (int idUsuario);

    List<UsuarioDTO> getAllUsuarios ();

    UsuarioDTO createUsuario (UsuarioDTOPost usuarioDTOPost);

    UsuarioDTO updateUsuario (UsuarioDtoUpdate usuarioDtoUpdate);

    void desactivarUsuario (int idUsuario);

    void activarUsuario (int idUsuario);

}
