package com.hotel.service.impl;

import com.hotel.dao.RoomDao;
import com.hotel.entity.Room;
import com.hotel.service.RoomService;

import java.util.*;

public class RoomServiceImpl implements RoomService {

    private RoomDao roomDao;

    public RoomServiceImpl(RoomDao roomDao) {
        this.roomDao = roomDao;
    }


    @Override
    public Optional<Room> findById(Long id) {
        return roomDao.findById(id);
    }

    @Override
    public List<Room> findAll() {
        return roomDao.findAll();
    }

    @Override
    public Set<Integer> findAllRoomTypeByNumberOfPlaces() {
        return roomDao.findAllRoomTypeByNumberOfPlaces();
    }

    @Override
    public Map<Long, String> findAllTypesOfServiceLevel() {
        return roomDao.findAllTypesOfServiceLevel();
    }
}
