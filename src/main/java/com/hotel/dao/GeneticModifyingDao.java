package com.hotel.dao;

public interface GeneticModifyingDao<T> {
    void create(T entity);

    void deleteById(Long id);
}
