package com.hotel.service;

import com.hotel.entity.Order;
import com.hotel.entity.Room;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface RoomService {

    Optional<Room> findById(Long id);

    List<Room> findAll();

    Set<Integer> findAllRoomTypeByNumberOfPlaces();

    Map<Long, String> findAllTypesOfServiceLevel();

}
