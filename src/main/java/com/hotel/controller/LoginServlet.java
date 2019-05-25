package com.hotel.controller;

import com.hotel.dao.UserDao;
import com.hotel.dao.impl.Connector;
import com.hotel.dao.impl.UserDaoImpl;
import com.hotel.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/login.jsp");
        requestDispatcher.forward(request, response);
        // processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connector connector = new Connector();
        //System.out.println("AC");
      /*  UserDao userDao1=new UserDaoImpl(connector);
        System.out.println(userDao1.findAll());
        System.out.println(userDao1.findById(2L));*/


        UserDao userDao = new UserDaoImpl(connector);
        System.out.println(userDao);
        HttpSession session = request.getSession();
        String login = request.getParameter("login");

        PrintWriter printWriter = response.getWriter();
        String password = request.getParameter("password");
        User loginUser = userDao.findById(1L).get();
        if (loginUser != null && loginUser.getPassword().equals(password)) {
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/success.jsp");
            printWriter.print("<h1>username: " + loginUser.getName() + "</h1>");

            request.setAttribute("login", login);
            rd.forward(request, response);
        } else {
            response.sendRedirect("/jsp/error.jsp");
        }

    }
}
