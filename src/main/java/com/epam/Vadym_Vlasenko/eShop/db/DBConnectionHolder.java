package com.epam.Vadym_Vlasenko.eShop.db;

import com.epam.Vadym_Vlasenko.eShop.service.exception.ShopException;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Вадим on 22.03.2015.
 */
public class DBConnectionHolder {

    private Properties properties;
    private BasicDataSource basicPooledDataSource;
    private static DBConnectionHolder connectionHolder;

    private static final String PROPERTY_FILE_NAME = "db.properties";
    private static final String JDBC_URL = "jdbcUrl";
    private static final String DRIVER_CLASS = "driverClass";
    private static final String USER_NAME = "username";
    private static final String PASSWORD = "password";
    private static final String MAX_IDLE = "maxIdle";
    private static final String MAX_ACTIVE = "maxActive";

    private static final Logger LOG = Logger.getLogger(DBConnectionHolder.class);

    private static final ThreadLocal<Connection> connectionStorage = new ThreadLocal<>();

    public static DBConnectionHolder getConnectionHolder() {
        if (connectionHolder == null) {
            connectionHolder = new DBConnectionHolder();
            return connectionHolder;
        } else {
            return connectionHolder;
        }
    }

    public Connection getConnection() throws SQLException {
        try {
            if (connectionStorage.get() == null) {
                Connection connection = this.basicPooledDataSource.getConnection();
                connectionStorage.set(connection);
                return connectionStorage.get();
            }
        } catch (SQLException e) {
            LOG.info(e);
            throw e;
        }
        return connectionStorage.get();
    }

    public Connection getConnectionNew() throws SQLException {
        return this.basicPooledDataSource.getConnection();
    }

    public void freeConnection() {
        connectionStorage.remove();
    }

    public BasicDataSource setConnectionPoolDataSource() {
        properties = getPropertiesConfig();
        basicPooledDataSource = new BasicDataSource();
        basicPooledDataSource.setUrl(properties.getProperty(JDBC_URL));
        basicPooledDataSource.setDriverClassName(properties.getProperty(DRIVER_CLASS));
        basicPooledDataSource.setUsername(properties.getProperty(USER_NAME));
        basicPooledDataSource.setPassword(properties.getProperty(PASSWORD));
        basicPooledDataSource.setMaxIdle(Integer.parseInt(properties.getProperty(MAX_IDLE)));
        basicPooledDataSource.setMaxActive(Integer.parseInt(properties.getProperty(MAX_ACTIVE)));
        return basicPooledDataSource;
    }

    private Properties getPropertiesConfig() {
        Properties properties = new Properties();
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = loader.getResourceAsStream(PROPERTY_FILE_NAME);
            properties.load(inputStream);
        } catch (IOException e) {
            throw new ShopException(e);
        }
        return properties;
    }

}
