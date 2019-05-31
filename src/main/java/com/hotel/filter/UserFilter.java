package com.hotel.filter;

import com.hotel.entity.Role;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter({"/user", "/booking"})
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getSession() != null
                && request.getSession().getAttribute("role") != null) {
            Role role = (Role) request.getSession().getAttribute("role");
            if (role.getId() == 2) {
                filterChain.doFilter(request, response);
                return;
            }
        } else {
            response.sendRedirect("/login");
        }
    }

    @Override
    public void destroy() {

    }
}
