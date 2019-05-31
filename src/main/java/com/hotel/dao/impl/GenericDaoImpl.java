package com.hotel.dao.impl;

import com.hotel.dao.GenericDao;
import com.hotel.entity.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class GenericDaoImpl<T extends Entity> extends GenericFindingDaoImpl implements GenericDao<T> {

    private static final Logger LOGGER = LogManager.getLogger(GenericDaoImpl.class);


    protected GenericDaoImpl(Connector connector) {
        super(connector);
    }

    protected void create(T entity, String queryTemplate) {
        try (Connection connection = connector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(queryTemplate);
            updateRecordInTable(entity, preparedStatement);
            System.out.println(queryTemplate);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }


    protected void deleteById(Long id, String queryTemplate) {
        try (Connection connection = connector.getConnection()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(queryTemplate);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //logger
            LOGGER.error(e.getMessage());
        }

    }

    protected void update(T entity, String queryTemplate) {
        try (Connection connection = connector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(queryTemplate);
            mapRecordToTable(entity, preparedStatement);
            System.out.println(queryTemplate);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }


    protected abstract void mapRecordToTable(T entity, PreparedStatement preparedStatement) throws SQLException;

    protected abstract void updateRecordInTable(T entity, PreparedStatement preparedStatement) throws SQLException;
}
