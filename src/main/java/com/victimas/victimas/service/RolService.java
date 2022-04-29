package com.victimas.victimas.service;


import com.victimas.victimas.dto.request.RolDTOReq;
import com.victimas.victimas.dto.response.RolDTO;
import com.victimas.victimas.dto.response.RolDTOSinID;

import java.util.List;

public interface RolService {

    RolDTOSinID getRolById(int idRol);

    List<RolDTO> getAllRols();

    RolDTO createRol(RolDTOReq rol);

    RolDTO deleteRolById(int idRol);

    RolDTO updateRol(RolDTOReq rol);
}
