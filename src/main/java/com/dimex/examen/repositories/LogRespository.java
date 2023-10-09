/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dimex.examen.repositories;

import com.dimex.examen.entities.Log;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface LogRespository
        extends
        CrudRepository<Log, Long>
{

    @Override
    public List<Log> findAll();

}
