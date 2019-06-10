package com.hotel.configuration.db;

import java.sql.Connection;

public interface DbConnectionPool {
    Connection getConnection();
    boolean releaseConnection(Connection connection);
    String getUrl();
    String getUser();
    String getPassword();
}
