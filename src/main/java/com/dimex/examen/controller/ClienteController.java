package com.dimex.examen.controller;

import com.dimex.examen.entities.Cliente;
import com.dimex.examen.services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
@Tag(name = "clientes", description = "Controlador de clientes")
public class ClienteController
{

    @Autowired
    ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService)
    {
        this.clienteService = clienteService;
    }

    @GetMapping
    @Operation(summary = "Listar todos los clientes")
    @ApiResponses(value =
    {
        @ApiResponse(responseCode = "200", description = "Listado de clientes", content =
        {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteController.class))
        }),
        @ApiResponse(responseCode = "400", description = "No se encontro el id de cliente", content = @Content),
        @ApiResponse(responseCode = "404", description = "No se encontro cliente", content = @Content)
    })
    public List<Cliente> obtenerTodosLosClientes()
    {
        return clienteService.obtenerTodosLosClientes();
    }

    @Operation(summary = "Obtener un cliente")
    @ApiResponses(value =
    {
        @ApiResponse(responseCode = "200", description = "Regresa el cliente", content =
        {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteController.class))
        }),
        @ApiResponse(responseCode = "400", description = "No se encontro el id de cliente", content = @Content),
        @ApiResponse(responseCode = "404", description = "No se encontro cliente", content = @Content)
    })
    @GetMapping("/{id}")
    public Optional<Cliente> obtenerClientePorId(@PathVariable Long id)
    {
        return clienteService.obtenerClientePorId(id);
    }
@Operation(summary = "Crear un cliente")
    @ApiResponses(value =
    {
        @ApiResponse(responseCode = "200", description = "Crear un cliente", content =
        {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteController.class))
        }),
        @ApiResponse(responseCode = "400", description = "No se encontro el id de cliente", content = @Content),
        @ApiResponse(responseCode = "404", description = "No se creo cliente", content = @Content)
    })
    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente)
    {
        return clienteService.guardarCliente(cliente);
    }
    @Operation(summary = "Borrar un cliente")
    @ApiResponses(value =
    {
        @ApiResponse(responseCode = "200", description = "Borrar el cliente", content =
        {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteController.class))
        }),
        @ApiResponse(responseCode = "400", description = "Se borro el id de cliente", content = @Content),
        @ApiResponse(responseCode = "404", description = "Se borro cliente", content = @Content)
    })

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Long id)
    {
        clienteService.eliminarCliente(id);
    }
}
