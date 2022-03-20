package com.example.demo.adapters.in.api.dto;

public class ErrorResponse {

    private String status;

    private int statusCode;

    private String message;

    public ErrorResponse(String message, int statusCode, String status ) {
        this.status = status;
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
