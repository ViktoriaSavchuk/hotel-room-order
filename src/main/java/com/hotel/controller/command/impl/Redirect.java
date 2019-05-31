package com.hotel.controller.command.impl;

import com.hotel.controller.command.Command;
import com.hotel.entity.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Redirect implements Command {

    private static final Logger LOGGER = LogManager.getLogger(Redirect.class);

    private static final Long USER_ROLE = 2L;
    private static final Long ADMIN_ROLE = 1L;
    private static final Integer DEFAULT_INACTIVE_INTERVAL = 150000;

    @Override
    public void executeCommand(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Integer adminMaxInactiveInterval;
        Integer userMaxInactiveInterval;

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            Properties prop = new Properties();
            prop.load(inputStream);

            userMaxInactiveInterval = Integer.valueOf(prop.getProperty("max.inactive.interval.user"));
            adminMaxInactiveInterval = Integer.valueOf(prop.getProperty("max.inactive.interval.admin"));
        } catch (Exception e) {
            adminMaxInactiveInterval=DEFAULT_INACTIVE_INTERVAL;
            userMaxInactiveInterval=DEFAULT_INACTIVE_INTERVAL;
            LOGGER.warn("time interval in property file is wrong or missing");
        }

        Role role = (Role) request.getSession().getAttribute("role");

        if (ADMIN_ROLE.equals(role.getId())) {
            request.getSession().setMaxInactiveInterval(adminMaxInactiveInterval);
            response.sendRedirect("/admin");
        } else if (USER_ROLE.equals(role.getId())) {
            request.getSession().setMaxInactiveInterval(userMaxInactiveInterval);
            response.sendRedirect("/user");
        }
    }
}
