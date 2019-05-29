package com.hotel.dao.impl;

import com.hotel.entity.Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class GenericFindingDaoImpl<T extends Entity> {

    protected final Connector connector;

    protected GenericFindingDaoImpl(Connector connector) {
        this.connector = connector;
    }


    protected Optional<T> findById(Long id, String queryTemplate) {
        T entity = null;
        try (Connection connection = connector.getConnection()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(queryTemplate);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                entity = mapResultSetToEntity(resultSet);
            }
        } catch (SQLException e) {
            //logger
            e.printStackTrace();
        }
        return Optional.ofNullable(entity);
    }

    public List<T> findAll(String queryTemplate) {
        List<T> entities = new ArrayList<>();
        try (Connection connection = connector.getConnection()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(queryTemplate);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                entities.add(mapResultSetToEntity(resultSet));
            }
        } catch (SQLException e) {
            //logger
            e.printStackTrace();
        }
        return entities;
    }

    protected abstract T mapResultSetToEntity(ResultSet resultSet) throws SQLException;
}
