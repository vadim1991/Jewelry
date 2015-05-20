package com.epam.Vadym_Vlasenko.eShop.db.dao;

import com.epam.Vadym_Vlasenko.eShop.service.exception.ShopException;

/**
 * Created by Вадим on 22.03.2015.
 */
public abstract class DAOFactory {

    private static DAOFactory instance;

    private static final String DAO_MYSQL = "com.epam.Vadym_Vlasenko.eShop.db.dao.mysql.DAOFactoryMySQL";

    public static synchronized DAOFactory getInstance() {
        if (instance == null) {
            Class<?> clazz;
            try {
                clazz = Class.forName(DAOFactory.DAO_MYSQL);
                instance = (DAOFactory) clazz.newInstance();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                throw new ShopException(e);
            }

        }
        return instance;
    }

    public abstract IProductDAO getProductDAO();

    public abstract IUserDAO getUserDAO();

    public abstract IOrderDAO getOrderDAO();

    public abstract IOrderInfoDAO getOrderInfoDAO();

    public abstract IOrderStatusDAO getOrderStatusDAO();

    public abstract IImageDao getImageDAO();

}
