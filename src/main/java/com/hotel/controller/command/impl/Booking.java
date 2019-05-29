package com.hotel.controller.command.impl;

import com.hotel.controller.command.Command;
import com.hotel.dao.impl.Connector;
import com.hotel.dao.impl.OrderDaoImpl;
import com.hotel.dao.impl.RoomDaoImpl;
import com.hotel.dao.impl.UserDaoImpl;
import com.hotel.entity.Order;
import com.hotel.entity.ServiceLevel;
import com.hotel.service.OrderService;
import com.hotel.service.UserService;
import com.hotel.service.impl.OrderServiceImpl;
import com.hotel.service.impl.UserServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.TextCodec;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Booking implements Command {

    private static final Connector CONNECTOR = new Connector();
    private OrderService orderService = new OrderServiceImpl(
            new OrderDaoImpl(CONNECTOR, new UserDaoImpl(CONNECTOR), new RoomDaoImpl(CONNECTOR)));
    private UserService userService = new UserServiceImpl(new UserDaoImpl(CONNECTOR));
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd MMM yyyy");

    @Override
    public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] serviceLevel = request.getParameter("level").split("=");
        Long userId=0L;
        try {
            Jws<Claims> claimsJws = Jwts.parser()
                    .setSigningKey(TextCodec.BASE64.decode("Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E="))
                    .parseClaimsJws(request.getSession().getAttribute("token").toString());
             userId = Long.valueOf((Integer) claimsJws.getBody().get("id"));
        }catch (NullPointerException e){
            response.sendRedirect("/");
        }

        LocalDate checkInDate = LocalDate.parse(request.getParameter("check_in"), DATE_FORMATTER);
        LocalDate checkOutDate = LocalDate.parse(request.getParameter("check_out"), DATE_FORMATTER);

        if (checkInDate.isAfter(LocalDate.now()) && checkInDate.isBefore(checkOutDate)) {
            orderService.create(Order.builder()
                    .withUser(userService.findById(userId).get())
                    .withOrderTime(LocalDateTime.now())
                    .withCheckIn(checkInDate.atStartOfDay())
                    .withCheckOut(checkOutDate.atStartOfDay())
                    .withServiceLevel(new ServiceLevel(Long.valueOf(serviceLevel[0]), serviceLevel[1]))
                    .withNumberOfPlaces(Integer.valueOf(request.getParameter("number")))
                    .build());
        } else {
            request.setAttribute("errorMessage",
                    "Choose correct dates: \nCheck-in date should be before check-out and after today");
            request.getRequestDispatcher("jsp/booking.js").forward(request, response);
        }
    }
}
