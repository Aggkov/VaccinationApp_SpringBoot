package com.example.demogroup.exceptions;

public enum ExceptionMessagesForExistingValues {

    EMAIL_ALREADY_EXISTS("This email address already exists."),
    AFM_ALREADY_EXISTS("This afm already exists.");

    private String errorResponse;

    ExceptionMessagesForExistingValues(String errorResponse) {
        this.errorResponse = errorResponse;
    }

    public String getErrorResponse() {
        return errorResponse;
    }

}
