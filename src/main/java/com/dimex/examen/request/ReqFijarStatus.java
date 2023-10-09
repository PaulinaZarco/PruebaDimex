package com.dimex.examen.request;

import lombok.Data;

@Data
public class ReqFijarStatus
{

    String idSolicitud;
    String status;
    String fechaCambio;
    ReqMotivo motivo;
}
