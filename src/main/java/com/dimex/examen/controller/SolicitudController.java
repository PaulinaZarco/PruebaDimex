package com.dimex.examen.controller;

import com.dimex.examen.entities.Solicitud;
import com.dimex.examen.request.ReqAltaSolicitud;
import com.dimex.examen.request.ReqFijarStatus;
import com.dimex.examen.response.RespEstadoCambiado;
import com.dimex.examen.response.RespSolicitudAceptada;
import com.dimex.examen.services.OperacionesService;
import com.dimex.examen.services.SolicitudService;
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
@RequestMapping("/solicitudes")
public class SolicitudController
{

    @Autowired
    SolicitudService solicitudService;

    @Autowired
    OperacionesService operacionesService;

    @Autowired
    public SolicitudController(SolicitudService solicitudService)
    {
        this.solicitudService = solicitudService;
    }
@Operation(summary = "Obtener todas las solicitudes")
    @ApiResponses(value =
    {
        @ApiResponse(responseCode = "200", description = "Regresa las solicitudes", content =
        {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteController.class))
        }),
        @ApiResponse(responseCode = "400", description = "No se encontraron las solicitudes", content = @Content),
        @ApiResponse(responseCode = "404", description = "No se encontraron las solicitudes registradas", content = @Content)
    })
    @GetMapping
    public List<Solicitud> obtenerTodasLasSolicitudes()
    {
        return solicitudService.obtenerTodasLasSolicitudes();
    }
@Operation(summary = "Obtener una solicitud por id")
    @ApiResponses(value =
    {
        @ApiResponse(responseCode = "200", description = "Regresa la solicitud por id", content =
        {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteController.class))
        }),
        @ApiResponse(responseCode = "400", description = "No se encontro el id de la solicitud", content = @Content),
        @ApiResponse(responseCode = "404", description = "No se encontro la solicitud", content = @Content)
    })
    @GetMapping("/{id}")
    public Optional<Solicitud> obtenerSolicitudPorId(@PathVariable Long id)
    {
        return solicitudService.obtenerSolicitudPorId(id);
    }
@Operation(summary = "Crear una solicitud")
    @ApiResponses(value =
    {
        @ApiResponse(responseCode = "200", description = "Crea una solicitud", content =
        {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteController.class))
        }),
        @ApiResponse(responseCode = "400", description = "No se creo la solicitud", content = @Content),
        @ApiResponse(responseCode = "404", description = "No se genero la solicitud de creacion de solicitud", content = @Content)
    })
    @PostMapping
    public Solicitud crearSolicitud(@RequestBody Solicitud solicitud)
    {
        return solicitudService.guardarSolicitud(solicitud);
    }
@Operation(summary = "Obtener un alta de solicitud")
    @ApiResponses(value =
    {
        @ApiResponse(responseCode = "200", description = "Regresa un alta de solicitud", content =
        {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteController.class))
        }),
        @ApiResponse(responseCode = "400", description = "No se realizo el alta de la solicitud", content = @Content),
        @ApiResponse(responseCode = "404", description = "No se genero el alta de solicitud", content = @Content)
    })
    @PostMapping
    @RequestMapping("/alta")
    public RespSolicitudAceptada altaSolicitud(@RequestBody ReqAltaSolicitud alta)
    {
        return operacionesService.altaSolicitud(alta);
    }
@Operation(summary = "Obtener un cambio de estatus")
    @ApiResponses(value =
    {
        @ApiResponse(responseCode = "200", description = "Regresa el cambio de status", content =
        {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteController.class))
        }),
        @ApiResponse(responseCode = "400", description = "No se encontro el cambio de status", content = @Content),
        @ApiResponse(responseCode = "404", description = "No se realizo el cambio de status", content = @Content)
    })
    @PostMapping
    @RequestMapping("/fijarStatus")
    public RespEstadoCambiado cambiarStatus(@RequestBody ReqFijarStatus cambio)
    {
        return operacionesService.cambioEstadoSolicitud(cambio);
    }
@Operation(summary = "Obtener dispersion")
    @ApiResponses(value =
    {
        @ApiResponse(responseCode = "200", description = "Regresa la dispersion", content =
        {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteController.class))
        }),
        @ApiResponse(responseCode = "400", description = "No se encontro la dispersion", content = @Content),
        @ApiResponse(responseCode = "404", description = "No se realizo la dispersion", content = @Content)
    })
    @PostMapping
    @RequestMapping("/dispersar")
    public Solicitud dispersar(@RequestBody Solicitud alta)
    {
        return operacionesService.dispersarSolicitud(alta);
    }
@Operation(summary = "ELimina una solicitud")
    @ApiResponses(value =
    {
        @ApiResponse(responseCode = "200", description = "Elimina una solicitud", content =
        {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ClienteController.class))
        }),
        @ApiResponse(responseCode = "400", description = "No se elimino la solicitud", content = @Content),
        @ApiResponse(responseCode = "404", description = "No se realizo la eliminacion de la solicitud", content = @Content)
    })
    @DeleteMapping("/{id}")
    public void eliminarSolicitud(@PathVariable Long id)
    {
        solicitudService.eliminarSolicitud(id);
    }

}
