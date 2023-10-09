/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dimex.examen.exepciones;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 *
 * @author matus
 */
@Data
public class ErrorDimex extends RuntimeException
{

    String texto;
    HttpStatus codigo = HttpStatus.INTERNAL_SERVER_ERROR;

    public ErrorDimex(String texto, HttpStatus codigo)
    {
        this.texto = texto;
        this.codigo = codigo;
    }

}
