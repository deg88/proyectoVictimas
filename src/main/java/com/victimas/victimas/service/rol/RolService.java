package com.victimas.victimas.service.rol;


import com.victimas.victimas.dto.request.rol.RolDTOReq;
import com.victimas.victimas.dto.request.rol.RolDTOUpdate;
import com.victimas.victimas.dto.response.rol.RolDTO;
import com.victimas.victimas.dto.response.rol.RolDTOSinID;

import java.util.List;

public interface RolService {

    RolDTOSinID getRolById(int idRol);

    List<RolDTO> getAllRols();

    RolDTO createRol(RolDTOReq rol);

    void deleteRolById(int idRol);

    RolDTO updateRol(RolDTOUpdate rol);
}
