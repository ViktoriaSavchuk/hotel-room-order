package com.hotel.dao.impl;

import com.hotel.entity.Entity;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
        Connection connection = null;
        try {
            connection = connector.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(queryTemplate);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                entity = mapResultSetToEntity(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connector.releaseConnection(connection);
        return Optional.ofNullable(entity);
    }

    protected List<T> findAll(String queryTemplate) {
        List<T> entities = new ArrayList<>();
        Connection connection = null;
        try {
            connection = connector.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(queryTemplate);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                entities.add(mapResultSetToEntity(resultSet));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connector.releaseConnection(connection);

        return entities;
    }

    protected Optional<T> getOne(String queryTemplate) {
        T entity = null;
        Connection connection = null;

        try {
            connection = connector.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(queryTemplate);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                entity = mapResultSetToEntity(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connector.releaseConnection(connection);

        return Optional.ofNullable(entity);
    }

    protected List<T> ordersBetweenDates(String queryTemplate, LocalDate checkInDate, LocalDate checkOutDate) {
        List<T> entities = new ArrayList<>();
        Connection connection = null;
        try {
            connection = connector.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(queryTemplate);
            preparedStatement.setTimestamp(1, Timestamp.valueOf(checkInDate.atStartOfDay()));
            preparedStatement.setTimestamp(2, Timestamp.valueOf(checkOutDate.atStartOfDay()));

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                entities.add(mapResultSetToEntity(resultSet));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connector.releaseConnection(connection);

        return entities;
    }

    protected abstract T mapResultSetToEntity(ResultSet resultSet) throws SQLException;
}
