package com.example.demogroup.utils;

import org.modelmapper.ModelMapper;

public class ObjectMapperUtils {

    static ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();
    }

    public static <D, T> D map(final T entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }
}
