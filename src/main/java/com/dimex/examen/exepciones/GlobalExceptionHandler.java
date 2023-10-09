package com.dimex.examen.exepciones;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class GlobalExceptionHandler
{

    @ExceptionHandler(ErrorDimex.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleException(ErrorDimex ex)
    {
        // Customize the error response
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMensaje(ex.getTexto());

        return ResponseEntity.status(ex.getCodigo()).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleException(Exception ex)
    {
        // Customize the error response
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMensaje(ex.getLocalizedMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    // Add more exception handlers for specific exceptions if needed
}
