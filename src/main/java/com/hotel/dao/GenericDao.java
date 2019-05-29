package com.hotel.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {

    Optional<T> findById(Long id);

    List<T> findAll();

    default void create(T entity) {
    }

    default void deleteById(Long id) {
    }

    //add all methods and make it default
    //if not use - throw unsupported operation exception

    //admin can change order

    //add phone number

    //add
}
