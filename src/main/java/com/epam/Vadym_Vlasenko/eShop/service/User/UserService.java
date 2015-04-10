package com.epam.Vadym_Vlasenko.eShop.service.User;

import com.epam.Vadym_Vlasenko.eShop.db.dao.IUserDAO;
import com.epam.Vadym_Vlasenko.eShop.entity.User;
import com.epam.Vadym_Vlasenko.eShop.service.transaction.TransactionManager;
import com.epam.Vadym_Vlasenko.eShop.service.transaction.TransactionOperation;

import java.sql.SQLException;

/**
 * Created by swift-seeker-89717 on 09.04.2015.
 */
public class UserService {

    private IUserDAO userDAO;
    private TransactionManager tm;

    public UserService(IUserDAO userDAO, TransactionManager tm) {
        this.userDAO = userDAO;
        this.tm = tm;
    }

    public void addUser(final User user) {
        tm.transaction(new TransactionOperation<Void>() {
            @Override
            public Void execute() throws SQLException {
                userDAO.addUser(user);
                return null;
            }
        });
    }

    public User getUserByLogin(final String login) {
        return tm.transaction(new TransactionOperation<User>() {
            @Override
            public User execute() throws SQLException {
                return userDAO.getUserByLogin(login);
            }
        });
    }

}