package com.hotel.dao.impl;

import com.hotel.dao.OrderDao;
import com.hotel.dao.RoomDao;
import com.hotel.dao.UserDao;
import com.hotel.entity.Order;
import com.hotel.entity.ServiceLevel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public class OrderDaoImpl extends GenericDaoImpl<Order> implements OrderDao {

    private static final String SELECT_FROM_ORDERS_WHERE_ID = "SELECT orders.*,service_levels.class_type" +
            "FROM orders" +
            "LEFT JOIN service_levels " +
            "ON orders.service_level_id=service_levels.level_id " +
            "WHERE order_id=?";

    private static final String SELECT_ALL_ORDERS = "SELECT orders.*,service_levels.class_type" +
            "FROM orders" +
            "LEFT JOIN service_levels " +
            "ON orders.service_level_id=service_levels.level_id ";
    private static final String INSERT_INTO_ORDERS =
            "INSERT INTO public.orders (user_id, check_in_date, check_out_date, service_level_id, " +
                    "room_id, order_time, number_of_places) " +
                    "VALUES (?, ?, ?,?, ?, ?,?)";

    private UserDao userDao;
    private RoomDao roomDao;

    public OrderDaoImpl(Connector connector, UserDao userDao, RoomDao roomDao) {
        super(connector);
        this.userDao = userDao;
        this.roomDao = roomDao;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return findById(id, SELECT_FROM_ORDERS_WHERE_ID);
    }

    @Override
    public List<Order> findAll() {
        return findAll(SELECT_ALL_ORDERS);
    }

    @Override
    public void create(Order entity) {
        create(entity, INSERT_INTO_ORDERS);

    }

    @Override
    public void deleteById(Long id) {

    }


    protected void update(Order order) {

    }

    @Override
    protected Order mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return Order.builder()
                .withId(resultSet.getLong("order_id"))
                .withUser(userDao.findById(resultSet.getLong("user_id")).get()) //orElse
                .withCheckIn(resultSet.getTimestamp("check_in_date").toLocalDateTime())
                .withCheckOut(resultSet.getTimestamp("check_out_date").toLocalDateTime())
                .withServiceLevel(new ServiceLevel(
                        resultSet.getLong("service_level_id")
                        , resultSet.getString("class_type")))
                .withRoom(roomDao.findById(resultSet.getLong("room_id")).get())
                .withOrderTime(resultSet.getTimestamp("order_time").toLocalDateTime())
                .withNumberOfPlaces(resultSet.getInt("number_of_places"))
                .build();
    }

    //make utility class which check null and set null make generic and type bring as map

    @Override
    protected void mapRecordToTable(Order entity, PreparedStatement preparedStatement) throws SQLException {
        if (entity != null) {
            preparedStatement.setLong(1, entity.getUser().getId());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(entity.getCheckIn()));
            preparedStatement.setTimestamp(3, Timestamp.valueOf(entity.getCheckOut()));
            preparedStatement.setLong(4, entity.getServiceLevel().getId());
            preparedStatement.setLong(5, entity.getRoom().getId());
            preparedStatement.setTimestamp(6, Timestamp.valueOf(entity.getOrderTime()));
            preparedStatement.setInt(7, entity.getNumberOfPlaces());
        }
    }
}
