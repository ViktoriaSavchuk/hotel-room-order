package com.hotel.controller;

import com.hotel.controller.command.CommandFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Set;


@WebServlet("/booking")
public class BookingServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(BookingServlet.class);
    public static final LocalDate NOW = LocalDate.now();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LOGGER.info("GET to BookingServlet");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/booking.jsp");
        Set<Integer> allRoomTypeByNumberOfPlaces = Context.getRoomService().findAllRoomTypeByNumberOfPlaces();
        Map<Long, String> allTypesOfServiceLevel = Context.getRoomService().findAllTypesOfServiceLevel();

        request.setAttribute("check_in_min_start_date", dateTimeFormatter.format(NOW));

        LOGGER.info(dateTimeFormatter.format(NOW));

        request.setAttribute("check_in_max_start_date", dateTimeFormatter.format(
                LocalDate.of(NOW.getYear() + 1, NOW.getMonth(), NOW.getDayOfMonth())));
        request.setAttribute("check_out_min_start_date",
                dateTimeFormatter.format(LocalDate.of(NOW.getYear(), NOW.getMonth(), NOW.getDayOfMonth()+1)));
        request.setAttribute("check_out_max_start_date",
                dateTimeFormatter.format(LocalDate.of(NOW.getYear() + 1, NOW.getMonth(), NOW.getDayOfMonth())));
        request.setAttribute("number_of_places", allRoomTypeByNumberOfPlaces);
        request.setAttribute("levels_of_service", allTypesOfServiceLevel);

        requestDispatcher.forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOGGER.info("POST from BookingServlet");
        // new Book().executeCommand(request, response);

        CommandFactory commandFactory = new CommandFactory();
        commandFactory.executeCommand(request, response);
        /*if (request.getParameter("command") != null && request.getParameter("command").equals("logout")) {
            new Logout().executeCommand(request, response);
        } else {
            new Book().executeCommand(request, response);
        } */
    }
}
