/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dimex.examen.controller;

import com.dimex.examen.entities.Empresa;
import com.dimex.examen.services.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresas")
public class EmpresaController
{

    @Autowired
    EmpresaService clienteService;

    @Autowired
    public EmpresaController(EmpresaService clienteService)
    {
        this.clienteService = clienteService;
    }
@Operation(summary = "Obtener empresas")
    @ApiResponses(value =
    {
        @ApiResponse(responseCode = "200", description = "Obtener empresas", content =
        {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteController.class))
        }),
        @ApiResponse(responseCode = "400", description = "No se encontraron las empresas", content = @Content),
        @ApiResponse(responseCode = "404", description = "No se encontraron las empresas", content = @Content)
    })
    @GetMapping
    public List<Empresa> obtenerTodosLosEmpresas()
    {
        return clienteService.obtenerTodosLosEmpresas();
    }
@Operation(summary = "Obtener una empresa por id")
    @ApiResponses(value =
    {
        @ApiResponse(responseCode = "200", description = "Regresa la empresa por id", content =
        {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteController.class))
        }),
        @ApiResponse(responseCode = "400", description = "No se encontro el id de la empresa", content = @Content),
        @ApiResponse(responseCode = "404", description = "No se encontro la empresa", content = @Content)
    })
    @GetMapping("/{id}")
    public Optional<Empresa> obtenerEmpresaPorId(@PathVariable Long id)
    {
        return clienteService.obtenerEmpresaPorId(id);
    }
@Operation(summary = "Crear una empresa")
    @ApiResponses(value =
    {
        @ApiResponse(responseCode = "200", description = "Crear empresa", content =
        {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteController.class))
        }),
        @ApiResponse(responseCode = "400", description = "No se creo la empresa", content = @Content),
        @ApiResponse(responseCode = "404", description = "No se encontro la empresa", content = @Content)
    })
    @PostMapping
    public Empresa crearEmpresa(@RequestBody Empresa cliente)
    {
        return clienteService.guardarEmpresa(cliente);
    }
@Operation(summary = "Borrar una empresa")
    @ApiResponses(value =
    {
        @ApiResponse(responseCode = "200", description = "Borrar una empresa", content =
        {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteController.class))
        }),
        @ApiResponse(responseCode = "400", description = "No se borro una empresa por id", content = @Content),
        @ApiResponse(responseCode = "404", description = "No se borro la empresa", content = @Content)
    })
    @DeleteMapping("/{id}")
    public void eliminarEmpresa(@PathVariable Long id)
    {
        clienteService.eliminarEmpresa(id);
    }
}
