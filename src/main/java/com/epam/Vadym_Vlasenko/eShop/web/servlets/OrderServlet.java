package com.epam.Vadym_Vlasenko.eShop.web.servlets;

import com.epam.Vadym_Vlasenko.eShop.entity.User;
import com.epam.Vadym_Vlasenko.eShop.service.cart.CartService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by swift-seeker-89717 on 16.04.2015.
 */
@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    private static final String CHECKOUT_PARAMETER = "checkout";
    private static final String SUCCESS_PARAMETER = "success";
    private static final String MAKE_ORDER_PARAMETER = "makeOrder";
    private static final String USER_ATTRIBUTE = "user";
    private static final String AMOUNT_PARAMETER = "amount";


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String checkout = req.getParameter(CHECKOUT_PARAMETER);
        if (checkout != null) {
            if (checkUser(req)) {

            } else {
                resp.sendRedirect("/login");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String makeOrder = req.getParameter(MAKE_ORDER_PARAMETER);
        HttpSession session = req.getSession();
        if (makeOrder != null) {
            resp.getWriter().write(SUCCESS_PARAMETER);
            CartService cartService = (CartService) session.getAttribute(Constants.CART_SERVICE);
            session.removeAttribute(AMOUNT_PARAMETER);
            cartService.clearCart();
            return;
        }
    }

    private boolean checkUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER_ATTRIBUTE);
        return user != null;
    }
}

