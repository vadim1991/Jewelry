package com.epam.Vadym_Vlasenko.eShop.web.servlets;

import com.epam.Vadym_Vlasenko.eShop.entity.User;
import com.epam.Vadym_Vlasenko.eShop.service.User.UserService;
import com.epam.Vadym_Vlasenko.eShop.service.captcha.ICaptchaHandler;
import com.epam.Vadym_Vlasenko.eShop.web.Constants;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * Created by swift-seeker-89717 on 09.04.2015.
 */
@WebServlet("/registration")
@MultipartConfig(location = "c:\\Users\\swift-seeker-89717\\IdeaProjects\\Jewelry\\web\\images\\avatar\\", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 10)
public class Registration extends HttpServlet {

    private static final String USER_ATTRIBUTE = "user";
    private static final String SUCCESS_ATTRIBUTE = "success";
    private static final String SUCCESS_MESSAGE = "Пользователь добавлен";

    private UserService userService;
    private ICaptchaHandler captchaHandler;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        userService = (UserService) context.getAttribute(Constants.USER_SERVICE);
        captchaHandler = (ICaptchaHandler) context.getAttribute((Constants.CAPTCHA_HANDLER));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        captchaHandler.init(req, resp);
        req.getRequestDispatcher(Constants.REGISTRATION_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getAttribute(USER_ATTRIBUTE);
        user.setLastLoginDate(new Date());
        user.setUnblockedDate(new Date());
        userService.addUser(user);
        req.setAttribute(SUCCESS_ATTRIBUTE, SUCCESS_MESSAGE);
        req.getRequestDispatcher(Constants.LOGIN_PAGE).forward(req, resp);
    }

}
