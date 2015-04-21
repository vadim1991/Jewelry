package com.epam.Vadym_Vlasenko.eShop.service.order;

import com.epam.Vadym_Vlasenko.eShop.db.dao.IOrderDAO;
import com.epam.Vadym_Vlasenko.eShop.db.dao.IOrderInfoDAO;
import com.epam.Vadym_Vlasenko.eShop.entity.Order;
import com.epam.Vadym_Vlasenko.eShop.entity.OrderInfo;
import com.epam.Vadym_Vlasenko.eShop.entity.StatusTypes;
import com.epam.Vadym_Vlasenko.eShop.service.transaction.TransactionManager;
import com.epam.Vadym_Vlasenko.eShop.service.transaction.TransactionOperation;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by swift-seeker-89717 on 19.04.2015.
 */
public class OrderService implements IOrderService {

    private TransactionManager tm;
    private IOrderDAO orderDAO;
    private IOrderInfoDAO orderInfoDAO;

    public OrderService(TransactionManager tm, IOrderDAO orderDAO, IOrderInfoDAO orderInfoDAO) {
        this.tm = tm;
        this.orderDAO = orderDAO;
        this.orderInfoDAO = orderInfoDAO;
    }

    @Override
    public void create(final Order order) {
        tm.transaction(new TransactionOperation<Void>() {
            @Override
            public Void execute() throws SQLException {
                orderDAO.create(order);
                return null;
            }
        });
    }

    @Override
    public void create(final Order order, final List<OrderInfo> orderInfoList) {
        tm.transaction(new TransactionOperation<Void>() {
            @Override
            public Void execute() throws SQLException {
                Order newOrder = orderDAO.create(order);
                for (OrderInfo orderInfo : orderInfoList) {
                    orderInfoDAO.createOrderInfo(orderInfo, newOrder.getId());
                }
                return null;
            }
        });
    }

    @Override
    public List<Order> getOrders() {
        return null;
    }

    @Override
    public boolean changeOrderStatus(Order order, StatusTypes statusTypes) {
        return false;
    }

    @Override
    public List<Order> getOrdersByUser(int userId) {
        return null;
    }

    @Override
    public List<Order> getOrdersFromDate(Date from, Date toDate) {
        return null;
    }

    @Override
    public Order getOrderById(int orderId) {
        return null;
    }
}
