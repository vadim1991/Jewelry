package com.epam.Vadym_Vlasenko.eShop.db.dao;

import com.epam.Vadym_Vlasenko.eShop.entity.OrderStatus;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by swift-seeker-89717 on 16.04.2015.
 */
public interface IOrderStatusDAO {

    List<OrderStatus> getAll() throws SQLException;

    OrderStatus getOrderStatusById(int id)throws SQLException;

}
