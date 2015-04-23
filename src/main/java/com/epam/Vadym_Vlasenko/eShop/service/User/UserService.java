package com.epam.Vadym_Vlasenko.eShop.service.User;

import com.epam.Vadym_Vlasenko.eShop.MessageLog;
import com.epam.Vadym_Vlasenko.eShop.db.dao.IUserDAO;
import com.epam.Vadym_Vlasenko.eShop.entity.User;
import com.epam.Vadym_Vlasenko.eShop.service.transaction.TransactionManager;
import com.epam.Vadym_Vlasenko.eShop.service.transaction.TransactionOperation;
import org.apache.log4j.Logger;

import java.sql.SQLException;

/**
 * Created by swift-seeker-89717 on 09.04.2015.
 */
public class UserService {

    private IUserDAO userDAO;
    private TransactionManager tm;

    private static final Logger LOG = Logger.getLogger(UserService.class);

    public UserService(IUserDAO userDAO, TransactionManager tm) {
        this.userDAO = userDAO;
        this.tm = tm;
    }

    public void updateUser(final User user) {
        tm.transaction(new TransactionOperation<Void>() {
            @Override
            public Void execute() throws SQLException {
                userDAO.updateUser(user);
                return null;
            }
        });
    }

    public void addUser(final User user) {
        tm.transaction(new TransactionOperation<Void>() {
            @Override
            public Void execute() throws SQLException {
                userDAO.addUser(user);
                LOG.info(MessageLog.ADD_NEW_USER + user.getLogin());
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
