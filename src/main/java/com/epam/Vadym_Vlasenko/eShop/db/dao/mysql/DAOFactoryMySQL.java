package com.epam.Vadym_Vlasenko.eShop.db.dao.mysql;

import com.epam.Vadym_Vlasenko.eShop.db.dao.*;

/**
 * Created by Вадим on 22.03.2015.
 */
public class DAOFactoryMySQL extends DAOFactory {
    @Override
    public IProductDAO getProductDAO() {
        return new ProductDaoMySQL();
    }

    @Override
    public IUserDAO getUserDAO() {
        return new UserDaoMySQL();
    }

    @Override
    public IOrderDAO getOrderDAO() {
        return new OrderDaoMySQL();
    }

    @Override
    public IOrderInfoDAO getOrderInfoDAO() {
        return new OrderInfoDaoMySQL();
    }

    @Override
    public IOrderStatusDAO getOrderStatusDAO() {
        return new OrderStatusDaoMySQL();
    }
}
