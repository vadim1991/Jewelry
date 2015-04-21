package com.epam.Vadym_Vlasenko.eShop.db.dao.mysql;

import com.epam.Vadym_Vlasenko.eShop.db.DBConnectionHolder;
import com.epam.Vadym_Vlasenko.eShop.db.dao.IOrderStatusDAO;
import com.epam.Vadym_Vlasenko.eShop.db.query_builder.QueryCreator;
import com.epam.Vadym_Vlasenko.eShop.entity.OrderStatus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by swift-seeker-89717 on 16.04.2015.
 */
public class OrderStatusDaoMySQL implements IOrderStatusDAO {

    private static final String ID_STATUS_COLUMN = "id";
    private static final String STATUS_TYPE_COLUMN = "status";
    private static final String TABLE_NAME = "order_status";

    @Override
    public List<OrderStatus> getAll() throws SQLException {
        List<OrderStatus> orderStatusList = new ArrayList<>();
        QueryCreator creator = new QueryCreator();
        String query = creator.selectAll(TABLE_NAME);
        Connection connection = DBConnectionHolder.getConnectionHolder().getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                orderStatusList.add(extractOrderStatus(resultSet));
            }
        }
        return orderStatusList;
    }

    @Override
    public OrderStatus getOrderStatusById(int id) throws SQLException {
        OrderStatus orderStatus = new OrderStatus();
        QueryCreator creator = new QueryCreator();
        String query = creator.where(TABLE_NAME, ID_STATUS_COLUMN, String.valueOf(id));
        Connection connection = DBConnectionHolder.getConnectionHolder().getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                orderStatus = extractOrderStatus(resultSet);
            }
        }
        return orderStatus;
    }

    private OrderStatus extractOrderStatus(ResultSet resultSet) throws SQLException {
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setId(resultSet.getInt(ID_STATUS_COLUMN));
        orderStatus.setStatus(resultSet.getString(STATUS_TYPE_COLUMN));
        return orderStatus;
    }
}
