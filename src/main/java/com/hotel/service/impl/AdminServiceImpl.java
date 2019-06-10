package com.hotel.service.impl;

import com.hotel.entity.Order;
import com.hotel.entity.Room;
import com.hotel.service.AdminService;
import com.hotel.service.OrderService;
import com.hotel.service.RoomService;

import java.util.List;
import java.util.stream.Collectors;

public class AdminServiceImpl implements AdminService {

    private RoomService roomService;
    private OrderService orderService;

    public AdminServiceImpl(RoomService roomService, OrderService orderService) {
        this.roomService = roomService;
        this.orderService = orderService;
    }

    @Override
    public List<Room> getAllSuitableRooms(Order order) {

        return roomService.findAll().stream()
                .filter(room -> room.getServiceLevel().equals(order.getServiceLevel()))
                .filter(room -> room.getNumberOfPlaces().equals(order.getNumberOfPlaces()))
                .filter(room -> orderService.ordersBetweenDates(order.getCheckIn().toLocalDate(),
                        order.getCheckOut().toLocalDate()).stream()
                        .noneMatch(order1 -> order1.getRoom().getId().equals(room.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public List<Room> getAllAvailableRoomOnDates(Order order) {

        return roomService.findAll().stream()
                .filter(room -> orderService.ordersBetweenDates(order.getCheckIn().toLocalDate(),
                        order.getCheckOut().toLocalDate()).stream()
                        .noneMatch(order1 -> order1.getRoom().getId().equals(room.getId())))
                .collect(Collectors.toList());
    }
}
