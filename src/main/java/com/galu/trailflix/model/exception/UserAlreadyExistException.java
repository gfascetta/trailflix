package com.galu.trailflix.model.exception;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String username) {
        super(String.format("User %s already exists", username));
    }
}
