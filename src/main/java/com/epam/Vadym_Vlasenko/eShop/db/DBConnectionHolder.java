package com.epam.Vadym_Vlasenko.eShop.db;

import org.apache.commons.dbcp.BasicDataSource;

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
            throw e;
        }
        return connectionStorage.get();
    }

    public void freeConnection() {
        connectionStorage.remove();
    }

    public BasicDataSource setConnectionPoolDataSource() {
        properties = getPropertiesConfig();
        basicPooledDataSource = new BasicDataSource();
        basicPooledDataSource.setUrl(properties.getProperty("jdbcUrl"));
        basicPooledDataSource.setDriverClassName(properties.getProperty("driverClass"));
        basicPooledDataSource.setUsername(properties.getProperty("username"));
        basicPooledDataSource.setPassword(properties.getProperty("password"));
        basicPooledDataSource.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));
        basicPooledDataSource.setMaxActive(Integer.parseInt(properties.getProperty("maxActive")));
        return basicPooledDataSource;
    }

    private Properties getPropertiesConfig() {
        Properties properties = new Properties();
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = loader.getResourceAsStream("db.properties");
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}
