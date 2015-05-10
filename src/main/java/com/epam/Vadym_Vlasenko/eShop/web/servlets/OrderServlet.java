package com.epam.Vadym_Vlasenko.eShop.web.servlets;

import com.epam.Vadym_Vlasenko.eShop.entity.*;
import com.epam.Vadym_Vlasenko.eShop.service.cart.CartService;
import com.epam.Vadym_Vlasenko.eShop.service.order.IOrderService;
import com.epam.Vadym_Vlasenko.eShop.web.Constants;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    private IOrderService orderService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        orderService = (IOrderService) context.getAttribute(Constants.ORDER_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String makeOrder = req.getParameter(MAKE_ORDER_PARAMETER);
        HttpSession session = req.getSession();
        if (makeOrder != null) {
            resp.getWriter().write(SUCCESS_PARAMETER);
            CartService cartService = (CartService) session.getAttribute(Constants.CART_SERVICE);
            User user = (User) session.getAttribute(USER_ATTRIBUTE);
            Order order = makeOrder(user, cartService);
            List<OrderInfo> orderInfoList = makeOrderInfoList(cartService);
            orderService.create(order, orderInfoList);
            session.removeAttribute(AMOUNT_PARAMETER);
            cartService.clearCart();
            return;
        }
    }

    private Order makeOrder(User user, CartService cartService) {
        Order order = new Order();
        order.setOrderInfo("bla-bla-bla");
        order.setOrderStatus(new OrderStatus(2, StatusTypes.CONFIRMED.toString()));
        order.setUser(user);
        order.setTotalPrice((int) cartService.totalPrice());
        return order;
    }

    private List<OrderInfo> makeOrderInfoList(CartService cartService) {
        List<OrderInfo> orderInfoList = new ArrayList<>();
        for (Map.Entry entry : cartService.getContent().entrySet()) {
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setProduct((Product) entry.getKey());
            orderInfo.setAmount((Integer) entry.getValue());
            orderInfo.setPrice(((Product) entry.getKey()).getPrice());
            orderInfoList.add(orderInfo);
        }
        return orderInfoList;
    }

    private boolean checkUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(USER_ATTRIBUTE);
        return user != null;
    }
}

