package com.hotel.dao;

import com.hotel.entity.Room;

import java.util.Map;
import java.util.Set;

public interface RoomDao extends GenericDao<Room> {

    Set<Integer> findAllRoomTypeByNumberOfPlaces();

    Map<Long,String> findAllTypesOfServiceLevel();
}
