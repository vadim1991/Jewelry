package com.epam.Vadym_Vlasenko.eShop.service.order.order_information;

import com.epam.Vadym_Vlasenko.eShop.db.dao.IOrderDAO;
import com.epam.Vadym_Vlasenko.eShop.db.dao.IOrderInfoDAO;
import com.epam.Vadym_Vlasenko.eShop.entity.OrderInfo;
import com.epam.Vadym_Vlasenko.eShop.service.transaction.TransactionManager;
import com.epam.Vadym_Vlasenko.eShop.service.transaction.TransactionOperation;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by swift-seeker-89717 on 19.04.2015.
 */
public class OrderInfoService implements IOrderInfoService {

    private TransactionManager tm;
    private IOrderDAO orderDAO;
    private IOrderInfoDAO orderInfoDAO;

    public OrderInfoService(TransactionManager tm, IOrderDAO orderDAO, IOrderInfoDAO orderInfoDAO) {
        this.tm = tm;
        this.orderDAO = orderDAO;
        this.orderInfoDAO = orderInfoDAO;
    }

    @Override
    public void createOrderInfo(OrderInfo orderInfo, int orderId) {
    }

    @Override
    public List<OrderInfo> getAll() {
        return null;
    }

    @Override
    public OrderInfo getOrderInfoById(int orderInfoId) {
        return null;
    }
}
