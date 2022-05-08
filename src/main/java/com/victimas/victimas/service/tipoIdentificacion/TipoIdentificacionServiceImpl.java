package com.victimas.victimas.service.tipoIdentificacion;

import com.victimas.victimas.dto.request.tipoIdentificacion.TipoIdentificacionDTOPost;
import com.victimas.victimas.dto.request.tipoIdentificacion.TipoIdentificacionDTOUpdate;
import com.victimas.victimas.dto.response.tipoIdentificacion.TipoIdentificacionDTO;
import com.victimas.victimas.exception.ResourceAlreadyExists;
import com.victimas.victimas.exception.ResourceNotFountException;
import com.victimas.victimas.model.TipoIdentificacion;
import com.victimas.victimas.repository.TipoIdentificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoIdentificacionServiceImpl implements TipoIdentificacionService{

    private final TipoIdentificacionRepository tipoIdentificacionRepository;

    public TipoIdentificacionServiceImpl(TipoIdentificacionRepository tipoIdentificacionRepository) {
        this.tipoIdentificacionRepository = tipoIdentificacionRepository;
    }

    @Override
    public TipoIdentificacionDTO getTipoIdentificacionById(int idTipoIdentificacion) {

        TipoIdentificacion tipoIdentificacion  = tipoIdentificacionRepository.findById(idTipoIdentificacion)
                .orElseThrow( () -> new ResourceNotFountException("El tipo de identificacion con el id: "
                        + idTipoIdentificacion + ", no existe."));

        return new TipoIdentificacionDTO(tipoIdentificacion.getTipo());
    }

    @Override
    public List<TipoIdentificacionDTO> getAllTiposIdentificacion() {

        List<TipoIdentificacion> tiposIdentificacion = tipoIdentificacionRepository.findAll();

        return tiposIdentificacion.stream()
                .map((tipoIdentificacion)
                        -> new TipoIdentificacionDTO(tipoIdentificacion.getIdTipo(),tipoIdentificacion.getTipo()))
                .collect(Collectors.toList());
    }

    @Override
    public TipoIdentificacionDTO createTipoIdentificacion(TipoIdentificacionDTOPost tipoIdentificacionDTOPost) {

        Optional<TipoIdentificacion> tipoIdentificacion = tipoIdentificacionRepository
                .findByTipo(tipoIdentificacionDTOPost.getTipo());

        if(tipoIdentificacion.isPresent()){
            TipoIdentificacion tipoIdentificacionResponse = tipoIdentificacion.get();
            throw new ResourceAlreadyExists("El tipo de identificacion con nombre "
                    + tipoIdentificacionResponse.getTipo()  + " ya existe con el id: "
                    + tipoIdentificacionResponse.getIdTipo());
        }

        TipoIdentificacion tipoIdentificacionResponse = tipoIdentificacionRepository
                .save(new TipoIdentificacion(tipoIdentificacionDTOPost.getTipo()));

        return new TipoIdentificacionDTO(tipoIdentificacionResponse.getIdTipo(), tipoIdentificacionDTOPost.getTipo());
    }

    @Override
    public TipoIdentificacionDTO updateTipoIdentificacion(TipoIdentificacionDTOUpdate tipoIdentificacionDTOUpdate) {

        TipoIdentificacion tipoIdentificacion  = tipoIdentificacionRepository
                .findById(tipoIdentificacionDTOUpdate.getIdTipoIdentificacion())
                .orElseThrow( () -> new ResourceNotFountException("El tipo de identificacion con el id: "
                        + tipoIdentificacionDTOUpdate.getIdTipoIdentificacion() + ", no existe."));

        tipoIdentificacion.setTipo(tipoIdentificacionDTOUpdate.getTipo());

        TipoIdentificacion response = tipoIdentificacionRepository.save(tipoIdentificacion);

        return new TipoIdentificacionDTO(response.getIdTipo(), response.getTipo());
    }

    @Override
    public void deleteTipoIdentificacionById(int idTipoIdentificacion) {

        TipoIdentificacion tipoIdentificacion  = tipoIdentificacionRepository.findById(idTipoIdentificacion)
                .orElseThrow( () -> new ResourceNotFountException("El tipo de identificacion con el id: "
                        + idTipoIdentificacion + ", no existe."));

        tipoIdentificacionRepository.deleteById(idTipoIdentificacion);
    }
}
