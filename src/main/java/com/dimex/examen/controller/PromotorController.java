/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dimex.examen.controller;

import com.dimex.examen.entities.Promotor;
import com.dimex.examen.services.PromotorService;
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
@RequestMapping("/promotores")
public class PromotorController
{

    @Autowired
    PromotorService clienteService;

    @Autowired
    public PromotorController(PromotorService clienteService)
    {
        this.clienteService = clienteService;
    }
@Operation(summary = "Obtener todos los promotores")
    @ApiResponses(value =
    {
        @ApiResponse(responseCode = "200", description = "Obtener todos los promotores", content =
        {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteController.class))
        }),
        @ApiResponse(responseCode = "400", description = "No se encontraron los id de promotores", content = @Content),
        @ApiResponse(responseCode = "404", description = "No se encontraron los promotores", content = @Content)
    })
    @GetMapping
    public List<Promotor> obtenerTodosLosPromotors()
    {
        return clienteService.obtenerTodosLosPromotors();
    }
@Operation(summary = "Obtener promotor por id")
    @ApiResponses(value =
    {
        @ApiResponse(responseCode = "200", description = "Obtiene promotor por id", content =
        {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteController.class))
        }),
        @ApiResponse(responseCode = "400", description = "No se encontro el id del promotor", content = @Content),
        @ApiResponse(responseCode = "404", description = "No se encontro el promotor", content = @Content)
    })
    @GetMapping("/{id}")
    public Optional<Promotor> obtenerPromotorPorId(@PathVariable Long id)
    {
        return clienteService.obtenerPromotorPorId(id);
    }
@Operation(summary = "Crear un promotor")
    @ApiResponses(value =
    {
        @ApiResponse(responseCode = "200", description = "crear un promotor", content =
        {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteController.class))
        }),
        @ApiResponse(responseCode = "400", description = "No se creo el promotor", content = @Content),
        @ApiResponse(responseCode = "404", description = "No se encontro el promotor", content = @Content)
    })
    @PostMapping
    public Promotor crearPromotor(@RequestBody Promotor cliente)
    {
        return clienteService.guardarPromotor(cliente);
    }
@Operation(summary = "Eliminar un promotor")
    @ApiResponses(value =
    {
        @ApiResponse(responseCode = "200", description = "ELiminar un promotor", content =
        {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteController.class))
        }),
        @ApiResponse(responseCode = "400", description = "No se elimino el promotor", content = @Content),
        @ApiResponse(responseCode = "404", description = "Erro al eliminar el promotor", content = @Content)
    })
    @DeleteMapping("/{id}")
    public void eliminarPromotor(@PathVariable Long id)
    {
        clienteService.eliminarPromotor(id);
    }
}
