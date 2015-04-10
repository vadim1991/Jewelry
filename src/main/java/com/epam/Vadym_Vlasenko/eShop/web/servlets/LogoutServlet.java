package com.epam.Vadym_Vlasenko.eShop.web.servlets;

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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String previous = null;
        try {
            previous = new URI(req.getHeader("referer")).getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        HttpSession session = req.getSession();
        session.invalidate();
        resp.sendRedirect(previous);
    }
}
