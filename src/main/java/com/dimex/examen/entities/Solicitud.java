package com.dimex.examen.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "dimex_solicitudes")
@Getter
@Setter
@ToString
public class Solicitud
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_solicitud", unique = true)
    String idSolicitud;

    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(name = "id_empresa")
    private Long idEmpresa;

    @Column(name = "id_promotor")
    private Long idPromotor;

    @Column(name = "idStatus")
    private String idStatus;

    @Column(name = "fecha_cambio")
    private String fechaCambio;

    @Column(name = "id_credito")
    private long idCredito;

    @Column(name = "monto")
    private Double monto;

    @Column(name = "producto")
    private String producto;

    @Column(name = "tipo_solicitud_str")
    private String tipoSolicitudStr;

    @Column(name = "id_tipo_solicitud")
    private Integer idTipoSolicitud;

    @Column(name = "tasa")
    private Double tasa;

    @Column(name = "plazo")
    private Integer plazo;

    @Column(name = "frecuencia")
    private String frecuencia;

    @Column(name = "fecha_solicitud")
    private String fechaSolicitud;

    @Column(name = "capital_dispersado")
    private double capitalDispersado;
}
