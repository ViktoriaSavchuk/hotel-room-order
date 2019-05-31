package com.hotel.dao;

import com.hotel.entity.Order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OrderDao extends GenericDao<Order> {

    List<Order> selectAllOrdersOfUser(Long userId);

    Optional<Order> selectFirstNotFullOrder();

    List<Order> ordersBetweenDates(LocalDateTime checkInDate, LocalDateTime checkOutDate);
}
