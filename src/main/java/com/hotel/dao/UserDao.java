package com.hotel.dao;

import com.hotel.entity.User;

import java.util.Optional;

public interface UserDao extends GenericDao<User> {

    Optional<User> findUserByEmail(String email);

}
