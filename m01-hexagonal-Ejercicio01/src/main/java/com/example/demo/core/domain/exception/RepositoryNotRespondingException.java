package com.example.demo.core.domain.exception;

public class RepositoryNotRespondingException extends Exception{
    public RepositoryNotRespondingException(String errorMessage) {
        super(errorMessage);
    }
}
