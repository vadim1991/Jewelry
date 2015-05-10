package com.epam.Vadym_Vlasenko.eShop.web.servlets;

import com.epam.Vadym_Vlasenko.eShop.entity.Order;
import com.epam.Vadym_Vlasenko.eShop.entity.OrderInfo;
import com.epam.Vadym_Vlasenko.eShop.entity.User;
import com.epam.Vadym_Vlasenko.eShop.service.json.IJsonService;
import com.epam.Vadym_Vlasenko.eShop.service.json.JsonService;
import com.epam.Vadym_Vlasenko.eShop.service.order.IOrderService;
import com.epam.Vadym_Vlasenko.eShop.web.Constants;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Вадим on 01.05.2015.
 */
@WebServlet("/ordersHistory")
public class OrdersHistory extends HttpServlet {

    private IOrderService orderService;
    private IJsonService jsonService;

    @Override
    public void init() throws ServletException {
        orderService = (IOrderService) getServletContext().getAttribute(Constants.ORDER_SERVICE);
        jsonService = new JsonService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            Map<Order, List<OrderInfo>> orderListMap = orderService.getOrdersWithInfo(user.getId());
            if (orderListMap != null) {
                String jsomMap = jsonService.orderMapToJSON(orderListMap);
                System.out.println(jsomMap);
                resp.getWriter().write(jsomMap);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("history.jsp").forward(req, resp);
    }
}
