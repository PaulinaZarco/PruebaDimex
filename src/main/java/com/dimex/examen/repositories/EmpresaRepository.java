package com.dimex.examen.repositories;

import com.dimex.examen.entities.Empresa;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface EmpresaRepository
        extends CrudRepository<Empresa, Long>
{

    @Override
    public List<Empresa> findAll();

    public List<Empresa> findByNombre(String promotor);
}
