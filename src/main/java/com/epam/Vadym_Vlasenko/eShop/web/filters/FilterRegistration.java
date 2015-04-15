package com.epam.Vadym_Vlasenko.eShop.web.filters;

import com.epam.Vadym_Vlasenko.eShop.entity.registration.RegistrationBean;
import com.epam.Vadym_Vlasenko.eShop.service.User.UserService;
import com.epam.Vadym_Vlasenko.eShop.web.servlets.Constants;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by swift-seeker-89717 on 09.04.2015.
 */
@WebFilter(urlPatterns = "/registration")
public class FilterRegistration implements Filter {

    private static final String MAP_ATTRIBUTE = "errors";
    private static final String LOGIN_EXISTS_ATTRIBUTE = "loginError";
    private static final String LOGIN_EXISTS_MESSAGE = "Пользователь с таким логином уже существует";
    private static final String USER_ATTRIBUTE = "user";
    private static final String FORM_ATTRIBUTE = "form";
    private static final String POST_REQUEST = "post";

    private UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext context = filterConfig.getServletContext();
        userService = (UserService) context.getAttribute(Constants.USER_SERVICE);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        RegistrationBean registrationBean = getRegistrationBean(request);
        if (request.getMethod().equalsIgnoreCase(POST_REQUEST)) {
            if (!registrationBean.isValid()) {
                request.setAttribute(MAP_ATTRIBUTE, registrationBean.getErrors());
                request.getRequestDispatcher(Constants.REGISTRATION_PAGE).forward(request, servletResponse);
                return;
            }
            if (userService.getUserByLogin(registrationBean.getLogin()) != null) {
                request.setAttribute(LOGIN_EXISTS_ATTRIBUTE, LOGIN_EXISTS_MESSAGE);
                request.setAttribute(FORM_ATTRIBUTE, registrationBean);
                request.getRequestDispatcher(Constants.REGISTRATION_PAGE).forward(request, servletResponse);
                return;
            }
        }
        request.setAttribute(USER_ATTRIBUTE, registrationBean.getUser());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

    private RegistrationBean getRegistrationBean(HttpServletRequest request) {
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String age = request.getParameter("age");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String confirm = request.getParameter("confirm");
        return new RegistrationBean(name, surname, age, login, password, email, confirm);

    }
}
