package com.victimas.victimas.service.tipoIdentificacion;

import com.victimas.victimas.dto.request.tipoIdentificacion.TipoIdentificacionDTOPost;
import com.victimas.victimas.dto.request.tipoIdentificacion.TipoIdentificacionDTOUpdate;
import com.victimas.victimas.dto.response.tipoIdentificacion.TipoIdentificacionDTO;

import java.util.List;

public interface TipoIdentificacionService {

    TipoIdentificacionDTO getTipoIdentificacionById(int idTipoIdentificacion);

    List<TipoIdentificacionDTO> getAllTiposIdentificacion();

    TipoIdentificacionDTO createTipoIdentificacion(TipoIdentificacionDTOPost tipoIdentificacionDTOPost);

    TipoIdentificacionDTO updateTipoIdentificacion(TipoIdentificacionDTOUpdate tipoIdentificacionDTOUpdate);

    void deleteTipoIdentificacionById(int idTipoIdentificacion);

}
