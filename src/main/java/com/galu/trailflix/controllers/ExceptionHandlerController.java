package com.galu.trailflix.controllers;

import com.galu.trailflix.model.exception.RequestDTOInvalidException;
import com.galu.trailflix.model.exception.UserAlreadyExistException;
import com.galu.trailflix.model.exception.UserNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerController {


    //TODO: Agregar exceptions que se agreguen para otras entidades
    @ExceptionHandler({ UserAlreadyExistException.class })
    public ResponseEntity<Object> handleUserAlreadyExist(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({RequestDTOInvalidException.class })
    public ResponseEntity<Object> handleRequestUsernameInvalid(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ UserNotExistException.class })
    public ResponseEntity<Object> handleUserNotExist(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleAnyException(Exception ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>("Hubo un error inesperado", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

