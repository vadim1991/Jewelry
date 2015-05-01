package com.epam.Vadym_Vlasenko.eShop.web.filters;

import com.epam.Vadym_Vlasenko.eShop.web.Constants;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by swift-seeker-89717 on 29.04.2015.
 */
@WebFilter(urlPatterns = "/*")
public class BrowserFilter implements Filter {

    private static final String USER_AGENT = "user-agent";
    private static final String CHROME = "Chrome";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String userAgent = request.getHeader(USER_AGENT);
        if (!userAgent.contains(CHROME)) {
            request.getRequestDispatcher(Constants.IE).forward(request, servletResponse);
            return;
        }
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
