/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dimex.examen.services;

import com.dimex.examen.entities.Promotor;
import com.dimex.examen.repositories.PromotorRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PromotorService
{

    @Autowired
    PromotorRepository promotorRepository;

    public List<Promotor> obtenerTodosLosPromotors()
    {
        return promotorRepository.findAll();
    }

    public Optional<Promotor> obtenerPromotorPorId(Long id)
    {
        return promotorRepository.findById(id);
    }

    public Promotor guardarPromotor(Promotor promotor)
    {
        return promotorRepository.save(promotor);
    }

    public void eliminarPromotor(Long id)
    {
        promotorRepository.deleteById(id);
    }

    public List<Promotor> obtenerPromotorPorNombre(String promotor)
    {
        return promotorRepository.findByNombre(promotor);
    }
}
