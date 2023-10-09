/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dimex.examen.repositories;

import com.dimex.examen.entities.Promotor;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PromotorRepository
        extends CrudRepository<Promotor, Long>
{

    @Override
    public List<Promotor> findAll();

    public List<Promotor> findByNombre(String promotor);
}
