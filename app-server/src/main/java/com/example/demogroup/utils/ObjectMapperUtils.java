package com.example.demogroup.utils;

import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectMapperUtils {

    static ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();
    }

    /**
     *
     * @param <D>  type of result object
     * @param <T>  type of source object to map from
     * @param entity  entity that needsto be mapped
     * @param dtoClass class of result object
     * @return  new DTO object

     */public static <D, T> D map(final T entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    /**
     *
     * @param entityList list of entities that needs to be mapped
     * @param outCLass   class of result list element
     * @param <D>        type of objects in result list
     * @param <T>        type of entity in <code>entityList</code>
            * @return list of mapped object with <code><D></code> type.
     */public static <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {
        return entityList.stream()
                .map(entity -> map(entity, outCLass))
                .collect(Collectors.toList());
    }

}
