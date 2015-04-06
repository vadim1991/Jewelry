package com.epam.Vadym_Vlasenko.eShop.db;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.ConnectionPoolDataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Вадим on 22.03.2015.
 */
public class DBConnection {

    private Properties properties;
    private BasicDataSource dataSource;

    private static DBConnection connectionHolder;

    private DBConnection() {
        dataSource = getConnectionPoolDataSource();
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static DBConnection getConnectionHolder() {
        if (connectionHolder == null) {
            connectionHolder = new DBConnection();
        }
        return connectionHolder;
    }

    private BasicDataSource  getConnectionPoolDataSource() {
        properties = getPropertiesConfig();
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(properties.getProperty("jdbcUrl"));
        dataSource.setDriverClassName(properties.getProperty("driverClass"));
        dataSource.setUsername(properties.getProperty("username"));
        dataSource.setPassword(properties.getProperty("password"));
        dataSource.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));
        dataSource.setMaxActive(Integer.parseInt(properties.getProperty("maxActive")));
        return dataSource;
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
