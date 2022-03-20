package com.example.demo.core.domain.exception;

public class NotFoundException extends Exception{
    public NotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
