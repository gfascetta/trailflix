package com.galu.trailflix.model.exception;

public class EntityAlreadyExistException extends RuntimeException {

    public EntityAlreadyExistException(String entityName, String idValue) {
        super(String.format("%s %s already exists", entityName, idValue));
    }
}
