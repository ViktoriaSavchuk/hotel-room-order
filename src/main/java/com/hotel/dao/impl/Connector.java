package com.hotel.dao.impl;


import com.hotel.configuration.db.DbConnectionPool;
import com.hotel.configuration.db.impl.DbConnectionPoolImpl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Objects;
import java.util.Properties;

public class Connector {

    private final DbConnectionPool connectionPool;

    public Connector() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties")) {

            Properties properties = new Properties();
            properties.load(inputStream);

            String drivers = properties.getProperty("jdbc.driver");
            String connectionURL = properties.getProperty("jdbc.url");
            String username = properties.getProperty("jdbc.username");
            String password = properties.getProperty("jdbc.password");

            Objects.requireNonNull(drivers, "Driver class cannot be null");
            Objects.requireNonNull(connectionURL, "Connection url cannot be null");
            Objects.requireNonNull(username, "User name cannot be null");
            Objects.requireNonNull(password, "Password cannot be null");

            Class.forName(drivers);

            connectionPool = DbConnectionPoolImpl.create(connectionURL, username, password);

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //pull do it as constant

    public Connection getConnection() {
        return connectionPool.getConnection();
    }

    public boolean releaseConnection(Connection usedConnection) {
        if (Objects.nonNull(usedConnection))
            return connectionPool.releaseConnection(usedConnection);
        else return false ;
    }

//    public Connection getConnection() {
//        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties")) {
//            Properties prop = new Properties();
//            prop.load(inputStream);
//
//            String drivers = prop.getProperty("jdbc.driver");
//            String connectionURL = prop.getProperty("jdbc.url");
//            String username = prop.getProperty("jdbc.username");
//            String password = prop.getProperty("jdbc.password");
//
//            Class.forName(drivers);
//            return DriverManager.getConnection(connectionURL, username, password);
//        } catch (SQLException | IOException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
