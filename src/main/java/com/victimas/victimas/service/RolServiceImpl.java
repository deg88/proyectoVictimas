package com.victimas.victimas.service;

import com.victimas.victimas.dto.request.RolDTOReq;
import com.victimas.victimas.dto.response.RolDTO;
import com.victimas.victimas.dto.response.RolDTOSinID;
import com.victimas.victimas.exception.ResourceNotFountException;
import com.victimas.victimas.model.Rol;
import com.victimas.victimas.repository.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService{

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
        return null;
    }

    @Override
    public RolDTO createRol(RolDTOReq rol) {

        Rol saveRol = rolRepository.save(new Rol(rol.getNombreRol(), rol.getDescripcion()));

        return new RolDTO(saveRol.getIdRol(), saveRol.getNombreRol(), saveRol.getDescripcion());
    }

    @Override
    public RolDTO deleteRolById(int idRol) {
        return null;
    }

    @Override
    public RolDTO updateRol(RolDTOReq rol) {
        return null;
    }
}