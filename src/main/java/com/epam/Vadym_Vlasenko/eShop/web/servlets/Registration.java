package com.epam.Vadym_Vlasenko.eShop.web.servlets;

import com.epam.Vadym_Vlasenko.eShop.entity.User;
import com.epam.Vadym_Vlasenko.eShop.service.User.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by swift-seeker-89717 on 09.04.2015.
 */
@WebServlet("/registration")
public class Registration extends HttpServlet {

    private static final String USER_ATTRIBUTE = "user";
    private static final String SUCCESS_ATTRIBUTE = "success";
    private static final String SUCCESS_MESSAGE = "Пользователь добавлен";

    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        userService = (UserService) context.getAttribute(Constants.USER_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Constants.REGISTRATION_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getAttribute(USER_ATTRIBUTE);
        userService.addUser(user);
        req.setAttribute(SUCCESS_ATTRIBUTE, SUCCESS_MESSAGE);
        req.getRequestDispatcher(Constants.LOGIN_PAGE).forward(req, resp);
    }

}
