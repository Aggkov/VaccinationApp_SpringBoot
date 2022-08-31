package com.example.demogroup.exception;

import com.example.demogroup.payload.response.ApiErrorResponse;

public class ReservationException extends RuntimeException {

    private ApiErrorResponse apiErrorResponse;

    public ReservationException(String message) {
        super(message);
    }
}
