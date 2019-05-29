package com.hotel.dao.impl;

import com.hotel.dao.RoomDao;
import com.hotel.entity.Room;
import com.hotel.entity.ServiceLevel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class RoomDaoImpl extends GenericFindingDaoImpl<Room> implements RoomDao {

    private static final String SELECT_FROM_ROOMS_WHERE_ID =
            "SELECT  hotel_rooms.*,  service_levels.class_type FROM hotel_rooms  " +
                    " LEFT JOIN service_levels" +
                    " ON hotel_rooms.service_level = service_levels.level_id    " +
                    " WHERE room_id=?;";

    private static final String SELECT_ALL_ROOMS = "SELECT DISTINCT hotel_rooms.*, " +
            " service_levels.class_type FROM hotel_rooms " +
            "  LEFT JOIN service_levels" +
            " ON hotel_rooms.service_level = service_levels.level_id";

    private static final String SELECT_ALL_POSSIBLE_NUMBER_OF_PLACES =
            "SELECT number_of_places FROM hotel_rooms";
    private static final String SELECT_ALL_POSSIBLE_LEVELS_OF_SERVICES =
            "SELECT DISTINCT * FROM service_levels\n" +
                    " JOIN hotel_rooms ON service_levels.level_id = hotel_rooms.service_level";

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
    public Set<Integer> findAllRoomTypeByNumberOfPlaces() {
        Set<Integer> entities = new HashSet<>();
        try (Connection connection = connector.getConnection()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SELECT_ALL_POSSIBLE_NUMBER_OF_PLACES);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                entities.add(resultSet.getInt("number_of_places"));
            }
        } catch (SQLException e) {
            //logger
            e.printStackTrace();
        }
        return entities;
    }



    @Override
    public Map<Long,String> findAllTypesOfServiceLevel() {
        Map<Long,String> serviceLevels = new HashMap<>();
        try (Connection connection = connector.getConnection()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SELECT_ALL_POSSIBLE_LEVELS_OF_SERVICES);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                serviceLevels.put(resultSet.getLong("level_id"),
                        resultSet.getString("class_type"));
            }
        } catch (SQLException e) {
            //logger
            e.printStackTrace();
        }
        return serviceLevels;
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
