package com.galu.trailflix.model.exception;

public class RequestDTOInvalidException extends RuntimeException{
    public RequestDTOInvalidException(String username) {
        super(String.format("Username %s is invalid", username));
    }
}
