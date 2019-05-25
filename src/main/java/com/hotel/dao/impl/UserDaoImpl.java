package com.hotel.dao.impl;

import com.hotel.dao.UserDao;
import com.hotel.entity.Role;
import com.hotel.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

    private static final String SELECT_FROM_USERS_WHERE_ID = "SELECT users.*,roles.role_name " +
            "FROM users " +
            "LEFT JOIN roles " +
            "ON users.role_id=roles.role_id " +
            "WHERE user_id=?";

    private static final String SELECT_FROM_USERS_WHERE_EMAIL = "SELECT users.*,roles.role_name " +
            "FROM users " +
            "LEFT JOIN roles " +
            "ON users.role_id=roles.role_id " +
            "WHERE email=?";

    private static final String INSERT_INTO_USER = "INSERT INTO public.users " +
            "(role_id, email, password, name, surname,phone) " +
            "VALUES (?,?,?,?,?);";

    private static final String SELECT_ALL_USERS = "SELECT users.*,roles.role_name " +
            "FROM users " +
            "LEFT JOIN roles " +
            "ON users.role_id=roles.role_id ";

    private static final String DELETE_USER_BY_ID = "DELETE FROM users WHERE users.user_id=?";

    public UserDaoImpl(Connector connector) {
        super(connector);
    }


    @Override
    public void create(User entity) {
        create(entity, INSERT_INTO_USER);
    }

    @Override
    public Optional<User> findById(Long id) {
        return findById(id, SELECT_FROM_USERS_WHERE_ID);
    }

    @Override
    public List<User> findAll() {
        return findAll(SELECT_ALL_USERS);
    }

    @Override
    public void deleteById(Long id) {
        deleteById(id, DELETE_USER_BY_ID);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        User user = null;
        try (Connection connection = connector.getConnection()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SELECT_FROM_USERS_WHERE_EMAIL);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = mapResultSetToEntity(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(user);
    }

    @Override
    protected User mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return User.builder()
                .withId(resultSet.getLong("user_id"))
                .withName(resultSet.getString("name"))
                .withSurname(resultSet.getString("surname"))
                .withEmail(resultSet.getString("email"))
                .withPassword(resultSet.getString("password"))
                .withRole(new Role(resultSet.getLong("role_id")
                        , resultSet.getString("role_name")))
                .withPhone(resultSet.getString("phone"))
                .build();
    }

    @Override
    protected void mapRecordToTable(User entity, PreparedStatement preparedStatement) throws SQLException {
        if (entity != null) {
            preparedStatement.setLong(1, entity.getRole().getId());
            preparedStatement.setString(2, entity.getEmail());
            preparedStatement.setString(3, entity.getPassword());
            preparedStatement.setString(4, entity.getName());
            preparedStatement.setString(5, entity.getSurname());
            preparedStatement.setString(6, entity.getPhone());
        }
    }


}
