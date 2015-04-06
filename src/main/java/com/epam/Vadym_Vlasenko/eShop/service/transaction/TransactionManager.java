package com.epam.Vadym_Vlasenko.eShop.service.transaction;

import com.epam.Vadym_Vlasenko.eShop.db.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import static com.epam.Vadym_Vlasenko.eShop.db.util.DBUtil.*;

/**
 * Created by Вадим on 22.03.2015.
 */
public class TransactionManager {

    private DBConnection dbConnection;

    private static final String EXCEPTION = "Exception in transaction";

    public TransactionManager(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public <T> T transaction(TransactionOperation<T> operation) {
        Connection connection = null;
        T result = null;
        try {
            connection = dbConnection.getConnection();
            connection.setAutoCommit(false);
            result = operation.execute();
            connection.commit();
        } catch (SQLException e) {
            rollback(connection);
            throw new RuntimeException(EXCEPTION, e);
        } finally {
            closeConnection(connection);
        }
        return result;
    }

}
