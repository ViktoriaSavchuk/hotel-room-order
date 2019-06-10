package com.hotel.controller;

import com.hotel.dao.UserDao;
import com.hotel.dao.impl.Connector;
import com.hotel.dao.impl.OrderDaoImpl;
import com.hotel.dao.impl.RoomDaoImpl;
import com.hotel.dao.impl.UserDaoImpl;
import com.hotel.service.AdminService;
import com.hotel.service.OrderService;
import com.hotel.service.RoomService;
import com.hotel.service.UserService;
import com.hotel.service.impl.AdminServiceImpl;
import com.hotel.service.impl.OrderServiceImpl;
import com.hotel.service.impl.RoomServiceImpl;
import com.hotel.service.impl.UserServiceImpl;

public class Context {

    private static Connector connector = new Connector();

    public static AdminService getAdminService() {
        return new AdminServiceImpl(getRoomService(), getOrderService());
    }

    public static UserService getUserService() {
        return new UserServiceImpl(getUserDao());
    }

    public static RoomService getRoomService() {
        return new RoomServiceImpl(getRoomDao());
    }

    public static OrderService getOrderService() {
        return new OrderServiceImpl(new OrderDaoImpl(connector, getUserDao(), getRoomDao()));
    }

    private static UserDao getUserDao() {
        return new UserDaoImpl(connector);
    }

    private static RoomDaoImpl getRoomDao() {
        return new RoomDaoImpl(connector);
    }

}
