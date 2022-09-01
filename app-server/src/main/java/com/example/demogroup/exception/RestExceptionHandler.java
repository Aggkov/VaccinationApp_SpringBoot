package com.example.demogroup.exception;

import com.example.demogroup.payload.response.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiErrorResponse> handleResourceNotFound(
            ResourceNotFoundException ex) {

        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());

        return new ResponseEntity<>(apiErrorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ReservationException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiErrorResponse> handleReservationException(ReservationException ex) {

        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());

        return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ApiErrorResponse> handleAuthenticationException(AuthenticationException ex) {

        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(HttpStatus.UNAUTHORIZED, ex.getMessage());

        return new ResponseEntity<>(apiErrorResponse, HttpStatus.UNAUTHORIZED);
    }

}
