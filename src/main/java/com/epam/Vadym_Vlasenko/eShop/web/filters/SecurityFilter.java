package com.epam.Vadym_Vlasenko.eShop.web.filters;

import com.epam.Vadym_Vlasenko.eShop.entity.Role;
import com.epam.Vadym_Vlasenko.eShop.entity.User;
import com.epam.Vadym_Vlasenko.eShop.service.security_service.SecurityService;
import com.epam.Vadym_Vlasenko.eShop.web.Constants;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by swift-seeker-89717 on 21.04.2015.
 */
@WebFilter(urlPatterns = "/*")
public class SecurityFilter implements Filter {

    private static final String USER_ATTRIBUTE = "user";
    private static final String LOGIN_SERVLET_PATH = "login";

    private SecurityService securityService;
    private Map<String, List<Role>> securityMap;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        securityService = (SecurityService) filterConfig.getServletContext().getAttribute(Constants.SECURITY_SERVICE);
        securityMap = securityService.getMapFromXml();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER_ATTRIBUTE);
        String url = request.getRequestURI().toString();
        if (securityService.isSecureUrl(url, securityMap)) {
            if (user == null) {
                request.getRequestDispatcher(LOGIN_SERVLET_PATH).forward(request, servletResponse);
                return;
            }
            if (!securityService.checkUrlWithRole(url, securityMap, user.getRole())) {
                request.getRequestDispatcher(Constants.FORBIDDEN_PAGE).forward(request, servletResponse);
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
