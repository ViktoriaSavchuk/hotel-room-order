package com.hotel.dao.impl;

import com.hotel.dao.GenericDao;
import com.hotel.entity.Entity;
import org.postgresql.jdbc2.optional.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class GenericDaoImpl<T extends Entity> extends GenericFindingDaoImpl implements GenericDao<T> {


    protected GenericDaoImpl(Connector connector) {
        super(connector);
    }

    protected void create(T entity, String queryTemplate) {
        try (Connection connection = new ConnectionPool().getConnection();) {
            PreparedStatement preparedStatement = connection.prepareStatement(queryTemplate);
            mapRecordToTable(entity, preparedStatement);
            preparedStatement.execute();
        } catch (Exception e) {
            System.err.println("SQL exception (request or table failed): " + e);
        }
    }


    public void deleteById(Long id, String queryTemplate) {
        try (Connection connection = connector.getConnection()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(queryTemplate);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            //logger
            e.printStackTrace();
        }

    }

    protected abstract void mapRecordToTable(T entity, PreparedStatement preparedStatement) throws SQLException;
}
