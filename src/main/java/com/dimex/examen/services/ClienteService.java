/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dimex.examen.services;

import com.dimex.examen.entities.Cliente;
import com.dimex.examen.repositories.ClienteRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ClienteService
{

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> obtenerTodosLosClientes()
    {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obtenerClientePorId(Long id)
    {
        return clienteRepository.findById(id);
    }

    public Cliente guardarCliente(Cliente cliente)
    {
        return clienteRepository.save(cliente);
    }

    public void eliminarCliente(Long id)
    {
        clienteRepository.deleteById(id);
    }

    List<Cliente> obtenerEmpresaPorNombreCompleto(Cliente cliente)
    {
        return clienteRepository.buscarPorNombreYApellidos(cliente.getNombre(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno());
    }
}
