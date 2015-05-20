package com.epam.Vadym_Vlasenko.eShop.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Vadym_Vlasenko on 20.05.2015.
 */
@WebFilter(urlPatterns = "/*")
public class NoCacheFilter implements Filter {

    private static final String CACHE_CONTROL = "Cache-Control";
    private static final String PRAGMA = "Pragma";
    private static final String EXPIRES = "Expires";
    private static final String NO_CACHE = "no-cache";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        httpResponse.setHeader(CACHE_CONTROL, NO_CACHE + ", no-store, must-revalidate");
        httpResponse.setHeader(PRAGMA, NO_CACHE);
        httpResponse.setDateHeader(EXPIRES, 0);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
