package com.galu.trailflix.model.exception;

public class UserNotExistException extends RuntimeException {
    public UserNotExistException(Long userId) {
        super(String.format("User with id %d not exist", userId));
    }
}
