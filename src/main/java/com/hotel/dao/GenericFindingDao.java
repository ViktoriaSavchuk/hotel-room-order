package com.hotel.dao;

import java.util.List;
import java.util.Optional;

public interface GenericFindingDao<T> {
    Optional<T> findById(Long id);

    List<T> findAll();
}
