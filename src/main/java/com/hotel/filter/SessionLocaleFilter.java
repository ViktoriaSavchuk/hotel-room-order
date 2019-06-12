package com.hotel.filter;

import com.hotel.utils.Internationalization;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Locale;


@WebFilter("/*")
public class SessionLocaleFilter implements Filter {

    private static final Logger LOGGER = LogManager.getLogger(SessionLocaleFilter.class);


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        LOGGER.info("locale filter");
        LOGGER.info("locale: "+req.getSession().getAttribute("lang"));

        if (req.getParameter("lang") != null) {
            req.getSession().setAttribute("lang", req.getParameter("lang"));
        }

        if (req.getParameter("lang") == null && req.getSession().getAttribute("lang")==null) {
            req.getSession().setAttribute("lang", req.getLocale().toLanguageTag());
            Internationalization.supportedLocales.set(0,
                    Locale.forLanguageTag((String) req.getSession().getAttribute("lang")));

        }

        Internationalization.supportedLocales.set(0,
                Locale.forLanguageTag((String) req.getSession().getAttribute("lang")));

        chain.doFilter(request, response);
    }

    public void destroy() {
    }

    public void init(FilterConfig arg0) throws ServletException {
    }

}
