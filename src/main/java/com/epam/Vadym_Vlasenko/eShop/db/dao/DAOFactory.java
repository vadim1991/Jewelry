package com.epam.Vadym_Vlasenko.eShop.db.dao;

/**
 * Created by Вадим on 22.03.2015.
 */
public abstract class DAOFactory {

    private static DAOFactory instance;

    private static final String DAO_MYSQL = "com.epam.Vadym_Vlasenko.eShop.db.dao.mysql.DAOFactoryMySQL";

    public static synchronized DAOFactory getInstance() {
        if (instance == null) {
            Class<?> clazz = null;
            try {
                clazz = Class.forName(DAOFactory.DAO_MYSQL);
                instance = (DAOFactory) clazz.newInstance();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        return instance;
    }

    public abstract IProductDAO getProductDAO();

    public abstract IUserDAO getUserDAO();

}
