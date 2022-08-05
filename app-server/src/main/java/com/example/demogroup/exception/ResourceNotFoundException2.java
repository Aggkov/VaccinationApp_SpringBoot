package com.example.demogroup.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException2 extends RuntimeException{


    public ResourceNotFoundException2(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s' ",resourceName , fieldName , fieldValue));

    }


}
