package com.hotel.controller;

import com.hotel.entity.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(UserServlet.class);

    //pagination
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("GET to UserServlet");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/user.jsp");
        request.setAttribute("errorMessage", "     ");

        List<Order> userOrders = Context.getOrderService().selectAllOrdersOfUser(
                (Long) request.getSession().getAttribute("id"));


        int page=1;
        if(request.getParameter("page")!=null){
            page=Integer.parseInt(request.getParameter("page"));

        }
        int pages=userOrders.size()/2;
        System.out.println(pages);
        int s1=pages*(page-1);
        int s2=(page*pages);
        System.out.println(s1+" "+s2);
        List<Order> ordersForPage=userOrders.subList(s1,s2);
        System.out.println(ordersForPage);

        if (userOrders.size() > 0) {
            request.setAttribute("orders", ordersForPage);
            request.setAttribute("pages",userOrders.size()/2 );
            request.setAttribute("page",page );

        } else {
            request.setAttribute("orders", "You already do not have any order");
        }
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // new Order().executeCommand(request, response);
    }
}
