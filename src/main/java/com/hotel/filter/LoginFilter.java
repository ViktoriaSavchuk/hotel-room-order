package com.hotel.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // HttpServletResponse response = (HttpServletResponse) servletResponse;


    }

    @Override
    public void destroy() {

    }
}
