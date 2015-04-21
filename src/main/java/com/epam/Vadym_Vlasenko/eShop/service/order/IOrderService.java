package com.epam.Vadym_Vlasenko.eShop.service.order;

import com.epam.Vadym_Vlasenko.eShop.entity.Order;
import com.epam.Vadym_Vlasenko.eShop.entity.OrderInfo;
import com.epam.Vadym_Vlasenko.eShop.entity.StatusTypes;

import java.util.Date;
import java.util.List;

/**
 * Created by swift-seeker-89717 on 16.04.2015.
 */
public interface IOrderService {

    void create(Order order);

    void create(Order order, List<OrderInfo> orderInfoList);

    List<Order> getOrders();

    boolean changeOrderStatus(Order order, StatusTypes statusTypes);

    List<Order> getOrdersByUser(int userId);

    List<Order> getOrdersFromDate(Date from, Date toDate);

    Order getOrderById(int orderId);
}
