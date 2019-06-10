package com.hotel.configuration.db.impl;

import com.hotel.configuration.db.DbConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DbConnectionPoolImpl implements DbConnectionPool {

    private final String url;
    private final String user;
    private final String password;
    private final List<Connection> connectionPool;
    private final List<Connection> usedConnections = new ArrayList<>();
    private static final int INITIAL_POOL_SIZE = 10;

    public DbConnectionPoolImpl(String url, String user, String password, List<Connection> connectionPool) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.connectionPool = connectionPool;
    }

    public static DbConnectionPoolImpl create(String url, String user, String password) {

        List<Connection> synchronizedPool = Collections.synchronizedList(new ArrayList<>(INITIAL_POOL_SIZE));

        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            synchronizedPool.add(createConnection(url, user, password));
        }

        return new DbConnectionPoolImpl(url, user, password, synchronizedPool);
    }

    @Override
    public Connection getConnection() {
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }

    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    public String getUser() {
        return this.user;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    private static Connection createConnection(
            String url, String user, String password) {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException("Could not create connection " + e.getMessage());
        }
    }

    public int getSize() {
        return connectionPool.size() + usedConnections.size();
    }
}
