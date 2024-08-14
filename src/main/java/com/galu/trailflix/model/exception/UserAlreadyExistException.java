package com.galu.trailflix.model.exception;

import com.galu.trailflix.model.User;

public class UserAlreadyExistException extends EntityAlreadyExistException {
    public UserAlreadyExistException(String username) {
        super(User.class.getSimpleName(), username);
    }
}
