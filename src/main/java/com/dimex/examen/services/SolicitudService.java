/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dimex.examen.services;

import com.dimex.examen.entities.Solicitud;
import com.dimex.examen.repositories.SolicitudRespository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class SolicitudService
{

    @Autowired
    SolicitudRespository solicitudRepository;

    public List<Solicitud> obtenerTodasLasSolicitudes()
    {
        return solicitudRepository.findAll();
    }

    public Optional<Solicitud> obtenerSolicitudPorId(Long id)
    {
        return solicitudRepository.findById(id);
    }

    public Solicitud guardarSolicitud(Solicitud solicitud)
    {
        return solicitudRepository.save(solicitud);
    }

    public void eliminarSolicitud(Long id)
    {
        solicitudRepository.deleteById(id);
    }

    List<Solicitud> buscarPorIdSolicitud(String idSolicitud)
    {
        return solicitudRepository.findByIdSolicitud(idSolicitud);
    }

}
