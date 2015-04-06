package com.epam.Vadym_Vlasenko.eShop.service.transaction;

import java.sql.SQLException;

/**
 * Created by Вадим on 22.03.2015.
 */
public interface TransactionOperation<T> {

    T execute() throws SQLException;

}
