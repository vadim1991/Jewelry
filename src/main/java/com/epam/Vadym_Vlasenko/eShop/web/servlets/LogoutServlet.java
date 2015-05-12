package com.epam.Vadym_Vlasenko.eShop.web.servlets;

import com.epam.Vadym_Vlasenko.eShop.web.Constants;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by swift-seeker-89717 on 10.04.2015.
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(LogoutServlet.class);
    private static final String LOGOUT_MESSAGE = "User logout with login - ";
    private static final String USER_ATTRIBUTE = "user";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String previous;
        try {
            previous = new URI(req.getHeader("referer")).getPath();
        } catch (URISyntaxException | NullPointerException e) {
            previous = Constants.MAIN_PAGE;
        }
        HttpSession session = req.getSession();
        LOG.info(LOGOUT_MESSAGE + session.getAttribute(USER_ATTRIBUTE));
        session.invalidate();
        resp.sendRedirect(previous);
    }
}
