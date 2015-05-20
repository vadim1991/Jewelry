package com.epam.Vadym_Vlasenko.eShop.db.dao.mysql;

import com.epam.Vadym_Vlasenko.eShop.db.DBConnectionHolder;
import com.epam.Vadym_Vlasenko.eShop.db.dao.IOrderDAO;
import com.epam.Vadym_Vlasenko.eShop.db.query_builder.QueryCreator;
import com.epam.Vadym_Vlasenko.eShop.entity.Order;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by swift-seeker-89717 on 16.04.2015.
 */
public class OrderDAOMySQL implements IOrderDAO {

    private static final Logger LOG = Logger.getLogger(OrderDAOMySQL.class);

    private static final String ORDERS_TABLE_NAME = "orders";
    private static final String ORDER_ID_COLUMN = "id";
    private static final String STATUS_ID_COLUMN = "status_id";
    private static final String ORDER_INFO_COLUMN = "order_info";
    private static final String USER_ID_COLUMN = "user_id";
    private static final String DATE_COLUMN = "date";
    private static final String TOTAL_PRICE = "total_price";

    private static final String CREATE_ORDER_QUERY = "INSERT INTO orders VALUES(?,?,?,?,?,?)";
    private static final String UPDATE_STATUS_QUERY = "UPDATE orders SET status_id=? WHERE (id=?)";

    @Override
    public Order create(Order order) throws SQLException {
        Order newOrder = new Order();
        Connection connection = DBConnectionHolder.getConnectionHolder().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_ORDER_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            int index = 1;
            preparedStatement.setInt(index++, order.getId());
            preparedStatement.setInt(index++, order.getOrderStatus().getId());
            preparedStatement.setString(index++, order.getOrderInfo());
            preparedStatement.setInt(index++, order.getUser().getId());
            preparedStatement.setTimestamp(index++, new Timestamp(order.getDate().getTime()));
            preparedStatement.setInt(index++, order.getTotalPrice());
            if (preparedStatement.executeUpdate() > 0) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    newOrder.setId(resultSet.getInt(1));
                }
            }
        }
        return newOrder;
    }

    @Override
    public List<Order> getOrders() throws SQLException {
        List<Order> orders = new ArrayList<>();
        QueryCreator creator = new QueryCreator();
        String query = creator.selectAll(ORDERS_TABLE_NAME);
        Connection connection = DBConnectionHolder.getConnectionHolder().getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                orders.add(extractOrder(resultSet));
            }
        }
        return orders;
    }

    @Override
    public List<Order> getOrdersByUser(int userId) throws SQLException {
        List<Order> orders = new ArrayList<>();
        QueryCreator creator = new QueryCreator();
        String query = creator.where(ORDERS_TABLE_NAME, USER_ID_COLUMN, String.valueOf(userId));
        Connection connection = DBConnectionHolder.getConnectionHolder().getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                orders.add(extractOrder(resultSet));
            }
        }
        return orders;
    }

    @Override
    public Order getOrderById(int orderId) throws SQLException {
        Order order = new Order();
        Connection connection = DBConnectionHolder.getConnectionHolder().getConnection();
        QueryCreator creator = new QueryCreator();
        String query = creator.where(ORDERS_TABLE_NAME, ORDER_ID_COLUMN, String.valueOf(orderId));
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                order = extractOrder(resultSet);
            }
        }
        return order;
    }

    public Order extractOrder(ResultSet resultSet) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getInt(ORDER_ID_COLUMN));
        int orderStatusId = resultSet.getInt(STATUS_ID_COLUMN);
        order.setOrderStatus(new OrderStatusDaoMySQL().getOrderStatusById(orderStatusId));
        order.setOrderInfo(resultSet.getString(ORDER_INFO_COLUMN));
        int userId = resultSet.getInt(USER_ID_COLUMN);
        order.setUser(new UserDaoMySQL().getUserById(userId));
        order.setDate(resultSet.getDate(DATE_COLUMN));
        order.setTotalPrice(resultSet.getInt(TOTAL_PRICE));
        return order;
    }

}
