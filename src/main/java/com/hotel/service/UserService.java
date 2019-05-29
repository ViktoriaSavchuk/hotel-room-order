package com.hotel.service;

import com.hotel.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findByEmail(String email);

    Optional<User> findById(Long id);

    List<User> findAll();

    void create(User entity);

    void deleteById(Long id);
}
