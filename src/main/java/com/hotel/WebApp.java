package com.hotel;

import com.hotel.dao.RoomDao;
import com.hotel.dao.UserDao;
import com.hotel.dao.impl.Connector;
import com.hotel.dao.impl.RoomDaoImpl;
import com.hotel.dao.impl.UserDaoImpl;

public class WebApp {

    public static void main(String[] args) {

        Connector connector = new Connector();
        UserDao userDao=new UserDaoImpl(connector);
        System.out.println(userDao.findAll());
        System.out.println(userDao.findById(2L));

        RoomDao roomDao=new RoomDaoImpl(connector);
        System.out.println(roomDao.findAll());
        System.out.println(roomDao.findById(1L));
        System.out.println(roomDao.findAllRoomTypeByNumberOfPlaces());

    }
}
