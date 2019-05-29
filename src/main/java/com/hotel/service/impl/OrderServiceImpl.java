package com.hotel.service.impl;

import com.hotel.dao.OrderDao;
import com.hotel.entity.Order;
import com.hotel.service.OrderService;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public Optional<Order> findById(Long id) {
        return orderDao.findById(id);
    }

    public List<Order> findAll() {
        return orderDao.findAll();
    }

    public void create(Order entity) {
        orderDao.create(entity);
    }

    public void deleteById(Long id) {
        orderDao.deleteById(id);
    }
}
