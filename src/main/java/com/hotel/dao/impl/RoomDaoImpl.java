package com.hotel.dao.impl;

import com.hotel.dao.RoomDao;
import com.hotel.entity.Room;
import com.hotel.entity.ServiceLevel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RoomDaoImpl extends GenericFindingDaoImpl<Room> implements RoomDao {

    private static final String SELECT_FROM_ROOMS_WHERE_ID =
            "SELECT  hotel_rooms.*,  service_levels.class_type FROM hotel_rooms  " +
                    " LEFT JOIN service_levels" +
                    " ON hotel_rooms.service_level = service_levels.level_id    " +
                    " WHERE room_id=?;";

    private static final String SELECT_ALL_ROOMS = "SELECT  hotel_rooms.*, " +
            " service_levels.class_type FROM hotel_rooms " +
            "  LEFT JOIN service_levels" +
            " ON hotel_rooms.service_level = service_levels.level_id";


    public RoomDaoImpl(Connector connector) {
        super(connector);
    }

    @Override
    public Optional<Room> findById(Long id) {
        return findById(id, SELECT_FROM_ROOMS_WHERE_ID);
    }

    @Override
    public List<Room> findAll() {
        return findAll(SELECT_ALL_ROOMS);
    }

    @Override
    protected Room mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return Room.builder()
                .withId(resultSet.getLong("room_id"))
                .withNumberOfPlaces(resultSet.getInt("number_of_places"))
                .withServiceLevel(new ServiceLevel(
                        resultSet.getLong("service_level"),
                        resultSet.getString("class_type")))
                .withPrice(resultSet.getLong("price"))
                .build();
    }
}
