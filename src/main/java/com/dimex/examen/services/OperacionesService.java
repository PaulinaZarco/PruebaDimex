package com.dimex.examen.services;

import com.dimex.examen.entities.Cliente;
import com.dimex.examen.entities.Empresa;
import com.dimex.examen.entities.Log;
import com.dimex.examen.entities.Promotor;
import com.dimex.examen.entities.Solicitud;
import com.dimex.examen.exepciones.ErrorDimex;
import com.dimex.examen.request.ReqAltaSolicitud;
import com.dimex.examen.request.ReqFijarStatus;
import com.dimex.examen.request.ReqMotivo;
import com.dimex.examen.response.RespEstadoCambiado;
import com.dimex.examen.response.RespSolicitudAceptada;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class OperacionesService
{

    @Autowired
    SolicitudService solicitudService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    PromotorService promotorService;

    @Autowired
    EmpresaService empresaService;

    @Autowired
    LogService logService;

    public RespSolicitudAceptada altaSolicitud(ReqAltaSolicitud alta)
    {
        Solicitud solicitud = alta.getSolicitud();

        List<Solicitud> l = this.solicitudService.buscarPorIdSolicitud(solicitud.getIdSolicitud());

        if (l != null && l.size() > 0)
        {

            throw new ErrorDimex("Ya existe una solicitud con este numero: " + solicitud.getIdSolicitud(), HttpStatus.CONFLICT);
        }

        Promotor promotor = buscarPromotor(alta.getPromotor());
        solicitud.setIdPromotor(promotor.getId());

        Empresa empresa = this.buscarEmpresa(alta.getEmpresa());
        solicitud.setIdEmpresa(empresa.getId());

        Cliente cl = this.buscarCliente(alta.getCliente());
        solicitud.setIdCliente(cl.getId());

        Solicitud sol = this.solicitudService.guardarSolicitud(solicitud);

        RespSolicitudAceptada resp = new RespSolicitudAceptada();
        resp.setId(sol.getId());
        resp.setMensaje("Solicitud aceptada");

        return resp;
    }

    private Promotor buscarPromotor(String nombrePromotor)
    {
        List<Promotor> l = this.promotorService.obtenerPromotorPorNombre(nombrePromotor);
        if (l == null || l.size() == 0)
        {
            Promotor p = new Promotor();
            p.setNombre(nombrePromotor);
            return this.promotorService.guardarPromotor(p);
        }

        return l.get(0);
    }

    private Empresa buscarEmpresa(String nombreEmpresa)
    {
        List<Empresa> l = this.empresaService.obtenerEmpresaPorNombre(nombreEmpresa);
        if (l == null || l.size() == 0)
        {
            Empresa empresa = new Empresa();
            empresa.setNombre(nombreEmpresa);
            return this.empresaService.guardarEmpresa(empresa);
        }

        return l.get(0);
    }

    private Cliente buscarCliente(Cliente cliente)
    {
        List<Cliente> l = this.clienteService.obtenerEmpresaPorNombreCompleto(cliente);

        if (l == null || l.size() == 0)
        {
            return this.clienteService.guardarCliente(cliente);
        }

        return l.get(0);
    }

    public RespEstadoCambiado cambioEstadoSolicitud(ReqFijarStatus cambio)
    {
        List<Solicitud> l = this.solicitudService.buscarPorIdSolicitud(cambio.getIdSolicitud());

        if (l == null || l.size() == 0)
        {
            throw new ErrorDimex("No se encuentra la solicitud: " + cambio.getIdSolicitud(), HttpStatus.NOT_FOUND);
        }

        if (cambio.getMotivo() == null)
        {
            throw new ErrorDimex("Falta motivo de cambio de estado para la solicitud: " + cambio.getIdSolicitud(), HttpStatus.NOT_FOUND);
        }

        Solicitud solicitud = l.get(0);
        solicitud.setIdStatus(cambio.getStatus());
        solicitud.setFechaCambio(cambio.getFechaCambio());

        ReqMotivo motivo = cambio.getMotivo();

        Log log = new Log();
        log.setCodigo(motivo.getCodigo());
        log.setDescripcion(motivo.getDescripcion());
        log.setIdSolicitud(solicitud.getIdSolicitud());
        this.logService.guardarLog(log);

        this.solicitudService.guardarSolicitud(solicitud);

        RespEstadoCambiado resp = new RespEstadoCambiado();
        resp.setIdsolicitud(solicitud.getIdSolicitud());
        resp.setMensaje("Se ha cambiado el estado de la solicitud a " + cambio.getStatus() + " con fecha " + cambio.getFechaCambio());

        return resp;
    }

    public Solicitud dispersarSolicitud(Solicitud cambio)
    {
        List<Solicitud> l = this.solicitudService.buscarPorIdSolicitud(cambio.getIdSolicitud());

        if (l == null || l.size() == 0)
        {
            throw new ErrorDimex("No se encuentra la solicitud: " + cambio.getIdSolicitud(), HttpStatus.NOT_FOUND);
        }

        Solicitud solicitud = l.get(0);
        solicitud.setIdCredito(cambio.getIdCredito());
        solicitud.setCapitalDispersado(cambio.getCapitalDispersado());
        solicitud.setMonto(cambio.getMonto());
        solicitud.setTasa(cambio.getTasa());
        solicitud.setPlazo(cambio.getPlazo());
        solicitud.setMonto(cambio.getMonto());
        solicitud.setFrecuencia(cambio.getFrecuencia());

        this.solicitudService.guardarSolicitud(solicitud);

        return solicitud;
    }

}
