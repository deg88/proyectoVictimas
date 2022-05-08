package com.victimas.victimas.service.rol;

import com.victimas.victimas.dto.request.rol.RolDTOReq;
import com.victimas.victimas.dto.request.rol.RolDTOUpdate;
import com.victimas.victimas.dto.response.rol.RolDTO;
import com.victimas.victimas.dto.response.rol.RolDTOSinID;
import com.victimas.victimas.exception.ResourceNotFountException;
import com.victimas.victimas.model.Rol;
import com.victimas.victimas.repository.RolRepository;
import com.victimas.victimas.service.rol.RolService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;

    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public RolDTOSinID getRolById(int idRol) {

        Rol rol = rolRepository.findById(idRol)
                .orElseThrow(() -> new ResourceNotFountException("El rol con id: " + idRol + " no existe."));

        RolDTOSinID rolDTO = new RolDTOSinID(rol.getNombreRol(), rol.getDescripcion());

        return rolDTO;
    }

    @Override
    public List<RolDTO> getAllRols() {
        return rolRepository.findAll()
                .stream()
                .map(rol -> new RolDTO(rol.getIdRol(),rol.getNombreRol(), rol.getDescripcion()))
                .collect(Collectors.toList());
    }

    @Override
    public RolDTO createRol(RolDTOReq rol) {

        Optional<Rol> rolExistente = rolRepository.findRolByNombreRol(rol.getNombreRol());

        if(rolExistente.isPresent()){
            throw new ResourceNotFountException("El rol con nombre " + rol.getNombreRol() + " ya existe y no puede ser creado nuevamente.");
        }

        Rol saveRol = rolRepository.save(new Rol(rol.getNombreRol(), rol.getDescripcion()));

        return new RolDTO(saveRol.getIdRol(), saveRol.getNombreRol(), saveRol.getDescripcion());
    }

    @Override
    public void deleteRolById(int idRol) {

        Rol rol = rolRepository.findById(idRol)
                .orElseThrow(() -> new ResourceNotFountException("El rol con id: " + idRol + " no existe."));

        rolRepository.deleteById(idRol);
    }

    @Override
    public RolDTO updateRol(RolDTOUpdate rol) {

        Rol rolExistente = rolRepository.findById(rol.getIdRol())
                .orElseThrow( () -> new ResourceNotFountException("El rol con id: " + rol.getIdRol() + " no existe." ));

        if(Objects.nonNull(rol.getNombreRol())){
            rolExistente.setNombreRol(rol.getNombreRol());
        }

        if(Objects.nonNull(rol.getDescripcion())){
            rolExistente.setDescripcion(rol.getDescripcion());
        }

        Rol rolResponse = rolRepository.save(rolExistente);

        return new RolDTO(rolResponse.getIdRol(), rolResponse.getNombreRol(), rolResponse.getDescripcion());
    }
}
