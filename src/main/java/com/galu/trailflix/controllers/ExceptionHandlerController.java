package com.galu.trailflix.controllers;

import com.galu.trailflix.dto.ApiErrorDTO;
import com.galu.trailflix.model.exception.EntityAlreadyExistException;
import com.galu.trailflix.model.exception.UserNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerController {


    //TODO: Agregar exceptions que se agreguen para otras entidades
    @ExceptionHandler({EntityAlreadyExistException.class})
    public ResponseEntity<ApiErrorDTO> handleEntityAlreadyExist(Exception ex) {
        log.error(ex.getMessage());
        return getApiErrorDTOResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorDTO> handleRequestUserInvalid(MethodArgumentNotValidException ex) {

        List<String> errorMessages = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorMessages.add(fieldName + ": " + errorMessage);
        });

        return getApiErrorDTOResponse(HttpStatus.BAD_REQUEST, String.join(", ", errorMessages));
    }

    @ExceptionHandler({UserNotExistException.class})
    public ResponseEntity<ApiErrorDTO> handleUserNotExist(Exception ex) {
        log.error(ex.getMessage());
        return getApiErrorDTOResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    // Other General Exceptions
    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiErrorDTO> handleAnyException(Exception ex) throws Exception {
        log.error("handleAnyException with message: {}", ex.getMessage());
        throw ex;
    }

    private ResponseEntity<ApiErrorDTO> getApiErrorDTOResponse(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(new ApiErrorDTO(httpStatus, message), httpStatus);
    }

}

