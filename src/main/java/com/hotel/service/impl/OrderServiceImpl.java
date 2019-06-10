package com.hotel.service.impl;

import com.hotel.dao.OrderDao;
import com.hotel.entity.Order;
import com.hotel.service.OrderService;
import com.hotel.service.RoomService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderDao.findById(id);
    }

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Override
    public void create(Order entity) {
        orderDao.create(entity);
    }

    @Override
    public void deleteById(Long id) {
        orderDao.deleteById(id);
    }

    @Override
    public List<Order> selectAllOrdersOfUser(Long userId) {
        return orderDao.selectAllOrdersOfUser(userId);
    }

    @Override
    public Optional<Order> selectFirstNotFullOrder() {
        return orderDao.selectFirstNotFullOrder();
    }

    @Override
    public List<Order> ordersBetweenDates(LocalDate checkInDate, LocalDate checkOutDate) {
        return orderDao.ordersBetweenDates(checkInDate,checkOutDate);
    }

    @Override
    public void update(Order order) {
        orderDao.update(order);
    }
}
