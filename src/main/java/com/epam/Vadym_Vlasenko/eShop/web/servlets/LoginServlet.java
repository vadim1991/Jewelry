package com.epam.Vadym_Vlasenko.eShop.web.servlets;

import com.epam.Vadym_Vlasenko.eShop.entity.User;
import com.epam.Vadym_Vlasenko.eShop.service.User.UserService;
import com.epam.Vadym_Vlasenko.eShop.web.Constants;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

/**
 * Created by swift-seeker-89717 on 10.04.2015.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(LoginServlet.class);

    private static final String LOGIN_PARAM = "login";
    private static final String PASSWORD_PARAM = "password";
    private static final String REFERER = "referer";
    private static final String PREVIOUS_PAGE = "previous";
    private static final String USER_ID = "id";
    private static final String USER_ATTRIBUTE = "user";
    private static final String USER_LOGIN = "login";
    private static final String ERROR_MESSAGE = "Ошибка входа!";
    private static final String ERROR_ATTRIBUTE = "error";
    private static final String BANNED_ATTRIBUTE = "ban";
    private static final String BANNED_MESSAGE = "You have a ban to ";
    private static final long BANNED_TIME = 500000;

    private static final String USER_IS_ENTER_MESSAGE = "User sing up with login - ";


    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        userService = (UserService) context.getAttribute(Constants.USER_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String previousPage;
        try {
            previousPage = new URI(req.getHeader(REFERER)).getPath();
        } catch (URISyntaxException | NullPointerException e) {
            previousPage = Constants.MAIN_PAGE;
        }
        req.getSession().setAttribute(PREVIOUS_PAGE, previousPage);
        req.setAttribute(PREVIOUS_PAGE, previousPage);
        req.getRequestDispatcher(Constants.LOGIN_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN_PARAM);
        String password = req.getParameter(PASSWORD_PARAM);
        String previousPage = (String) req.getSession().getAttribute(PREVIOUS_PAGE);
        HttpSession session = req.getSession();
        if (login != null && password != null && previousPage != null) {
            User user = userService.getUserByLogin(login);
            if (user != null) {
                if (user.isBlocked()) {
                    req.setAttribute(BANNED_ATTRIBUTE, BANNED_MESSAGE + user.getUnblockedDate());
                    req.getRequestDispatcher(Constants.FORBIDDEN_PAGE).forward(req, resp);
                    return;
                }
                if (user.getPassword().equals(password)) {
                    user.setLastLoginDate(new Date());
                    user.setLoginFailAmount(0);
                    user.setUnblockedDate(new Date());
                    userService.updateUser(user);
                    session.setAttribute(USER_ID, user.getId());
                    session.setAttribute(USER_LOGIN, user.getLogin());
                    session.setAttribute(USER_ATTRIBUTE, user);
                    LOG.info(USER_IS_ENTER_MESSAGE + user.getLogin());
                    resp.sendRedirect(previousPage);
                    return;
                }
                int loginFailAmount = user.getLoginFailAmount();
                user.setLoginFailAmount(++loginFailAmount);
                setupBlock(user, loginFailAmount);
                userService.updateUser(user);
            }
        }
        req.setAttribute(ERROR_ATTRIBUTE, ERROR_MESSAGE);
        req.getRequestDispatcher(Constants.LOGIN_PAGE).forward(req, resp);
    }

    private void setupBlock(User user, int loginFailAmount) {
        if (loginFailAmount > 5) {
            long blockTime = new Date().getTime() + BANNED_TIME;
            Date unblockDate = new Date();
            unblockDate.setTime(blockTime);
            user.setUnblockedDate(unblockDate);
            userService.updateUser(user);
        }
    }

}
