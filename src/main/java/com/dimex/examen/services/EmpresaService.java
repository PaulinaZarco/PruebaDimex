/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dimex.examen.services;

import com.dimex.examen.entities.Empresa;
import com.dimex.examen.repositories.EmpresaRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EmpresaService
{

    @Autowired
    EmpresaRepository empresaRepository;

    public List<Empresa> obtenerTodosLosEmpresas()
    {
        return empresaRepository.findAll();
    }

    public Optional<Empresa> obtenerEmpresaPorId(Long id)
    {
        return empresaRepository.findById(id);
    }

    public Empresa guardarEmpresa(Empresa cliente)
    {
        return empresaRepository.save(cliente);
    }

    public void eliminarEmpresa(Long id)
    {
        empresaRepository.deleteById(id);
    }

    List<Empresa> obtenerEmpresaPorNombre(String nombreEmpresa)
    {
        return empresaRepository.findByNombre(nombreEmpresa);
    }
}
