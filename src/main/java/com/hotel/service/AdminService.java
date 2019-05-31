package com.hotel.service;

import com.hotel.entity.Order;
import com.hotel.entity.Room;

import java.util.List;

public interface AdminService {

    List<Room> getAllSuitableRooms(Order order);

    List<Room> getAllAvailableRoomOnDates(Order order);

}
