package com.dimex.examen.repositories;

import com.dimex.examen.entities.Solicitud;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface SolicitudRespository
        extends CrudRepository<Solicitud, Long>
{

    @Override
    public List<Solicitud> findAll();

    public List<Solicitud> findByIdSolicitud(String idSolicitud);
}
