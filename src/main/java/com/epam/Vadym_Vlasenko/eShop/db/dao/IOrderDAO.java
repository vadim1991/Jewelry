package com.epam.Vadym_Vlasenko.eShop.db.dao;

import com.epam.Vadym_Vlasenko.eShop.entity.Order;
import com.epam.Vadym_Vlasenko.eShop.entity.StatusTypes;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by swift-seeker-89717 on 16.04.2015.
 */
public interface IOrderDAO {

    Order create(Order order) throws SQLException;

    List<Order> getOrders() throws SQLException;

    List<Order> getOrdersByUser(int userId) throws SQLException;

    Order getOrderById(int orderId) throws SQLException;
}
