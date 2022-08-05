package com.example.demogroup.exception;


public class CreateRecordException extends RuntimeException{
    private String errorResponse;

    public CreateRecordException(String errorResponse) {
        super(errorResponse);
        this.errorResponse = errorResponse;
    }

    public String getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(String errorResponse) {
        this.errorResponse = errorResponse;
    }
}
