package com.hotel.dao.impl;

import com.hotel.dao.GenericDao;
import com.hotel.entity.Entity;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class GenericDaoImpl<T extends Entity> extends GenericFindingDaoImpl implements GenericDao<T> {

    private static final Logger LOGGER = LogManager.getLogger(GenericDaoImpl.class);

    protected GenericDaoImpl(Connector connector) {
        super(connector);
    }

    protected void create(T entity, String queryTemplate) {
        Connection connection = null;
        try {
            connection = connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(queryTemplate);
            mapRecordToTable(entity, preparedStatement);
            System.out.println(queryTemplate);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.error("Could not create ", e);
        }
        connector.releaseConnection(connection);
    }

    protected void deleteById(Long id, String queryTemplate) {
        Connection connection = null;
        try {
            connection = connector.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(queryTemplate);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.error("Could not delete by id ", e);
        }
        connector.releaseConnection(connection);
    }

    protected void update(T entity, String queryTemplate) {
        Connection connection = null;

        try {
            connection = connector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(queryTemplate);
            updateRecordInTable(entity, preparedStatement);
            System.out.println(queryTemplate);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.error("Could not update ", e);
        }
        connector.releaseConnection(connection);

    }

    protected abstract void mapRecordToTable(T entity, PreparedStatement preparedStatement) throws SQLException;

    protected abstract void updateRecordInTable(T entity, PreparedStatement preparedStatement) throws SQLException;
}
