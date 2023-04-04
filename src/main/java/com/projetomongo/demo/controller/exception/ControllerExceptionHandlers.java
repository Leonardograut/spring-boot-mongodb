package com.projetomongo.demo.controller.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.projetomongo.demo.Service.exception.ObjectNotFoundException;


import jakarta.servlet.http.HttpServletRequest;



@ControllerAdvice
public class ControllerExceptionHandlers {
    
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<Error>objectNotFound(ObjectNotFoundException e ,HttpServletRequest request){



        HttpStatus status = HttpStatus.NOT_FOUND;
        Error err =new Error(System.currentTimeMillis(), status.value(), "Nao encontrado", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
