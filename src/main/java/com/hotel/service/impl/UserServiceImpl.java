package com.hotel.service.impl;

import com.hotel.dao.UserDao;
import com.hotel.entity.User;
import com.hotel.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void create(User entity) {
        userDao.create(entity);
    }

    @Override
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }
}
