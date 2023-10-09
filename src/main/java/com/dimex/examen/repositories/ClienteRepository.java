package com.dimex.examen.repositories;

import com.dimex.examen.entities.Cliente;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends
        CrudRepository<Cliente, Long>
{

    @Override
    public List<Cliente> findAll();

    @Query("SELECT c FROM Cliente c WHERE c.nombre = ?1 AND c.apellidoPaterno = ?2 AND c.apellidoMaterno = ?3")
    List<Cliente> buscarPorNombreYApellidos(String nombre, String apellidoPaterno, String apellidoMaterno);

}
