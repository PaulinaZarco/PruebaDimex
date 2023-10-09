package com.dimex.examen.services;

import com.dimex.examen.entities.Log;
import com.dimex.examen.repositories.LogRespository;
import java.util.List;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class LogService
{

    @Autowired
    LogRespository logRepository;

    public List<Log> obtenerTodosLosLogs()
    {
        return logRepository.findAll();
    }

    public Optional<Log> obtenerLogPorId(Long id)
    {
        return logRepository.findById(id);
    }

    public Log guardarLog(Log cliente)
    {
        return logRepository.save(cliente);
    }

    public void eliminarLog(Long id)
    {
        logRepository.deleteById(id);
    }

}
