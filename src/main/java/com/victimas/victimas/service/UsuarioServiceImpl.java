package com.victimas.victimas.service;

import com.victimas.victimas.dto.request.usuario.UsuarioDTOPost;
import com.victimas.victimas.dto.request.usuario.UsuarioDtoUpdate;
import com.victimas.victimas.dto.response.usuario.UsuarioDTO;
import com.victimas.victimas.exception.ResourceAlreadyExists;
import com.victimas.victimas.exception.ResourceNotFountException;
import com.victimas.victimas.model.Rol;
import com.victimas.victimas.model.Usuario;
import com.victimas.victimas.repository.RolRepository;
import com.victimas.victimas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository usuarioRepository;

    private final RolRepository rolRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, RolRepository rolRepository) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    @Override
    public UsuarioDTO getUsuarioById(int idUsuario) {

        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow( () -> new ResourceNotFountException("El usuario con id_usuario:" + idUsuario  + ", no existe."));

        return new UsuarioDTO(usuario.getUsername(), usuario.getFechaRegistro(),
                usuario.getUltimaActualizacion(), usuario.getActivo(), usuario.getRol().getIdRol());
    }

    @Override
    public List<UsuarioDTO> getAllUsuarios() {
        return usuarioRepository.findAll().stream()
                .map( (usuario) -> new UsuarioDTO(usuario.getIdUsuario(), usuario.getUsername(), usuario.getFechaRegistro(),
                        usuario.getUltimaActualizacion(), usuario.getActivo(), usuario.getRol().getIdRol()))
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO createUsuario(UsuarioDTOPost usuarioDTOPost) {

        Optional<Usuario> usuario = usuarioRepository.findByUsername(usuarioDTOPost.getUsername());

        if(usuario.isPresent()){
            throw new ResourceAlreadyExists("El usuario con username: " + usuarioDTOPost.getUsername()
                    + ", ya existe con el id: " + usuario.get().getIdUsuario());
        }

        Rol rol = rolRepository.findById(usuarioDTOPost.getRolId())
                .orElseThrow( () -> new ResourceNotFountException("El rol con id_rol: " +
                        usuarioDTOPost.getRolId() + ", no existe."));

        Usuario nuevoUsuario = usuarioRepository.save(
               new Usuario(usuarioDTOPost.getUsername(), usuarioDTOPost.getPassword(),
                       LocalDateTime.now(), LocalDateTime.now(), false, rol)
        );

        return new UsuarioDTO(nuevoUsuario.getIdUsuario(), nuevoUsuario.getUsername(),
                nuevoUsuario.getFechaRegistro(), nuevoUsuario.getUltimaActualizacion(),
                nuevoUsuario.getActivo(), nuevoUsuario.getRol().getIdRol());
    }

    @Override
    public UsuarioDTO updateUsuario(UsuarioDtoUpdate usuarioDtoUpdate) {

        Usuario usuario = usuarioRepository.findById(usuarioDtoUpdate.getIdUsuario())
                .orElseThrow( () -> new ResourceNotFountException("El usuario con id_usuario:" + usuarioDtoUpdate.getIdUsuario()  + ", no existe."));

        boolean cambio = false;

        if(Objects.nonNull(usuarioDtoUpdate.getPassword())){
            usuario.setPassword(usuarioDtoUpdate.getPassword());
            cambio = true;
        }

        if(Objects.nonNull(usuarioDtoUpdate.getRolId())){

            Rol rol = rolRepository.findById(usuarioDtoUpdate.getRolId())
                    .orElseThrow( () -> new ResourceNotFountException("El rol con id_rol: " +
                            usuarioDtoUpdate.getRolId() + ", no existe."));
            usuario.setRol(rol);
            cambio = true;
        }

        if(cambio){
            usuario.setUltimaActualizacion(LocalDateTime.now());
        }

        Usuario response = usuarioRepository.save(usuario);

        return new UsuarioDTO(response.getIdUsuario(), response.getUsername(),
                response.getFechaRegistro(), response.getUltimaActualizacion(),
                response.getActivo(), response.getRol().getIdRol());
    }

    @Override
    public void desactivarUsuario(int idUsuario) {

        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow( () -> new ResourceNotFountException("El usuario con id_usuario:" + idUsuario  + ", no existe."));

        usuario.setActivo(false);

        usuarioRepository.save(usuario);
    }

    @Override
    public void activarUsuario(int idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow( () -> new ResourceNotFountException("El usuario con id_usuario:" + idUsuario  + ", no existe."));

        usuario.setActivo(true);

        usuarioRepository.save(usuario);
    }
}
