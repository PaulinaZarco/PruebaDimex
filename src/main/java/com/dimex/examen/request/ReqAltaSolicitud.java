package com.dimex.examen.request;

import com.dimex.examen.entities.Cliente;
import com.dimex.examen.entities.Solicitud;
import lombok.Data;

@Data
public class ReqAltaSolicitud
{

    String promotor;
    String empresa;
    Cliente cliente;
    Solicitud solicitud;
}
