package com.hotel.service;

import com.hotel.entity.Order;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface OrderService {

    Optional<Order> findById(Long id);

    List<Order> findAll();

    void create(Order entity);

    void deleteById(Long id);

    List<Order> selectAllOrdersOfUser(Long userId);

    Optional<Order> selectFirstNotFullOrder();

    List<Order> ordersBetweenDates(LocalDate checkInDate, LocalDate checkOutDate);

    void update(Order order);

}
