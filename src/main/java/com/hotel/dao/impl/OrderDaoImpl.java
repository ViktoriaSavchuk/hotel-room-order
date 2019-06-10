package com.hotel.dao.impl;

import com.hotel.dao.OrderDao;
import com.hotel.dao.RoomDao;
import com.hotel.dao.UserDao;
import com.hotel.entity.Order;
import com.hotel.entity.Room;
import com.hotel.entity.ServiceLevel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class OrderDaoImpl extends GenericDaoImpl<Order> implements OrderDao {

    private static final Logger LOGGER = LogManager.getLogger(OrderDaoImpl.class);


    private static final String SELECT_FROM_ORDERS_WHERE_ID = "SELECT orders.*,service_levels.class_type " +
            "FROM orders " +
            "LEFT JOIN service_levels " +
            "ON orders.service_level_id=service_levels.level_id " +
            "WHERE order_id=?;";

    private static final String SELECT_ALL_ORDERS = "SELECT orders.*,service_levels.class_type " +
            "FROM orders " +
            "LEFT JOIN service_levels " +
            "ON orders.service_level_id=service_levels.level_id ;";
    private static final String INSERT_INTO_ORDERS =
            "INSERT INTO public.orders (user_id, check_in_date, check_out_date, service_level_id," +
                    "room_id, order_time, number_of_places, price) " +
                    "VALUES (?, ?, ?,?, ?, ?,?,?);";

    private static final String SELECT_ALL_ORDERS_WHERE_USER_ID = "SELECT orders.*,service_levels.class_type " +
            "FROM orders " +
            "LEFT JOIN service_levels " +
            "ON orders.service_level_id=service_levels.level_id " +
            "WHERE user_id=?";

    private static final String SELECT_FIRST_NOT_FULL_ORDER = "SELECT orders.*,service_levels.class_type " +
            "FROM orders " +
            "LEFT JOIN service_levels " +
            "ON orders.service_level_id=service_levels.level_id " +
            "WHERE room_id ISNULL " +
            "LIMIT 1";

    private static final String SELECT_ORDERS_BETWEEN_SPECIAL_DATE =
            "SELECT  *, service_levels.class_type " +
                    "FROM orders LEFT JOIN service_levels " +
                    "ON orders.service_level_id = service_levels.level_id " +
                    "WHERE check_in_date >=?" +
                    " AND check_out_date >=?" +
                    " AND room_id NOTNULL; ";

    private static final String UPDATE_ORDER = "UPDATE public.orders SET room_id=?, price=?," +
            " number_of_places=?, service_level_id=? WHERE order_id=?;";

    private static final String DELETE_FROM_ORDERS_WHERE_ID = "DELETE FROM orders WHERE order_id=?";

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
        deleteById(id, DELETE_FROM_ORDERS_WHERE_ID);
    }

    @Override
    public void update(Order order) {
        update(order, UPDATE_ORDER);
    }

    @Override
    public Optional<Order> selectFirstNotFullOrder() {
        return getOne(SELECT_FIRST_NOT_FULL_ORDER);
    }

    @Override
    public List<Order> selectAllOrdersOfUser(Long userId) {
        String query = SELECT_ALL_ORDERS_WHERE_USER_ID.substring(0, SELECT_ALL_ORDERS_WHERE_USER_ID.length() - 1)
                + userId.toString();
        return findAll(query);
    }

    @Override
    public List<Order> ordersBetweenDates(LocalDate checkInDate, LocalDate checkOutDate) {
        return ordersBetweenDates(SELECT_ORDERS_BETWEEN_SPECIAL_DATE, checkInDate, checkOutDate);
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
                .withRoom(roomDao.findById(resultSet.getLong("room_id")).orElse(Room.builder().build()))
                .withOrderTime(resultSet.getTimestamp("order_time").toLocalDateTime())
                .withNumberOfPlaces(resultSet.getInt("number_of_places"))
                .withPrice(resultSet.getLong("price"))
                .build();
    }


    @Override
    protected void mapRecordToTable(Order entity, PreparedStatement preparedStatement) {
        try {
            if (entity != null) {
                preparedStatement.setLong(1, entity.getUser().getId());
                preparedStatement.setTimestamp(2, Timestamp.valueOf(entity.getCheckIn()));
                preparedStatement.setTimestamp(3, Timestamp.valueOf(entity.getCheckOut()));
                preparedStatement.setLong(4, entity.getServiceLevel().getId());
                preparedStatement.setNull(5, Types.BIGINT);
                preparedStatement.setTimestamp(6, Timestamp.valueOf(entity.getOrderTime()));
                preparedStatement.setInt(7, entity.getNumberOfPlaces());
                setLongOrNull(8, preparedStatement, entity.getPrice());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void updateRecordInTable(Order order, PreparedStatement preparedStatement) {
        try {
            if (order != null) {
                preparedStatement.setLong(1, order.getRoom().getId());
                preparedStatement.setLong(2, order.getPrice());
                preparedStatement.setLong(3, order.getNumberOfPlaces());
                preparedStatement.setLong(4, order.getServiceLevel().getId());
                preparedStatement.setLong(5, order.getId());
                System.out.println(preparedStatement);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }

    private void setLongOrNull(final int parameterIndex, final PreparedStatement preparedStatement, final Long value) {
        try {
            if (value != null) {
                preparedStatement.setLong(parameterIndex, value);
            }
            preparedStatement.setNull(parameterIndex, Types.BIGINT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
