package com.example.demogroup.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String message, HttpStatus status) {
        super(message);
    }
}
