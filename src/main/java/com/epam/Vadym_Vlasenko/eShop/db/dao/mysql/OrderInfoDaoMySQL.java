package com.epam.Vadym_Vlasenko.eShop.db.dao.mysql;

import com.epam.Vadym_Vlasenko.eShop.db.DBConnectionHolder;
import com.epam.Vadym_Vlasenko.eShop.db.dao.IOrderInfoDAO;
import com.epam.Vadym_Vlasenko.eShop.db.query_builder.QueryCreator;
import com.epam.Vadym_Vlasenko.eShop.entity.OrderInfo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by swift-seeker-89717 on 16.04.2015.
 */
public class OrderInfoDaoMySQL implements IOrderInfoDAO {

    private static final Logger LOG = Logger.getLogger(OrderInfoDaoMySQL.class);

    private static final String TABLE_NAME = "order_info";

    private static final String ID_COLUMN = "id";
    private static final String PRODUCT_ID_COLUMN = "product_id";
    private static final String PRICE_COLUMN = "price";
    private static final String AMOUNT_COLUMN = "amount";
    private static final String ORDER_ID_COLUMN = "order_id";

    private static final String CREATE_ORDER_INFO_QUERY = "INSERT INTO order_info VALUES(?,?,?,?,?)";


    @Override
    public void createOrderInfo(OrderInfo orderInfo, int orderId) throws SQLException {
        Connection connection = DBConnectionHolder.getConnectionHolder().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_ORDER_INFO_QUERY)) {
            int index = 1;
            preparedStatement.setInt(index++, orderInfo.getId());
            preparedStatement.setInt(index++, orderInfo.getProduct().getId());
            preparedStatement.setInt(index++, orderInfo.getPrice());
            preparedStatement.setInt(index++, orderInfo.getAmount());
            preparedStatement.setInt(index++, orderId);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<OrderInfo> getAll() throws SQLException {
        List<OrderInfo> orderInfoList = new ArrayList<>();
        QueryCreator creator = new QueryCreator();
        String query = creator.selectAll(TABLE_NAME);
        Connection connection = DBConnectionHolder.getConnectionHolder().getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                orderInfoList.add(extractOrderInfo(resultSet));
            }
        }
        return orderInfoList;
    }

    @Override
    public List<OrderInfo> getOrderInfoById(int orderId) throws SQLException {
        List<OrderInfo> orderInfoList = new ArrayList<>();
        QueryCreator creator = new QueryCreator();
        String query = creator.where(TABLE_NAME, ORDER_ID_COLUMN, String.valueOf(orderId));
        Connection connection = DBConnectionHolder.getConnectionHolder().getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                orderInfoList.add(extractOrderInfo(resultSet));
            }
        }
        return orderInfoList;
    }

    private OrderInfo extractOrderInfo(ResultSet resultSet) throws SQLException {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(resultSet.getInt(ID_COLUMN));
        orderInfo.setProduct(new ProductDaoMySQL().getProductByID(resultSet.getInt(PRODUCT_ID_COLUMN)));
        orderInfo.setPrice(resultSet.getInt(PRICE_COLUMN));
        orderInfo.setAmount(resultSet.getInt(AMOUNT_COLUMN));
        return orderInfo;
    }

}
