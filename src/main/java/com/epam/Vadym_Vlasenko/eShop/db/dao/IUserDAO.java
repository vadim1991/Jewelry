package com.epam.Vadym_Vlasenko.eShop.db.dao;

import com.epam.Vadym_Vlasenko.eShop.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by swift-seeker-89717 on 07.04.2015.
 */
public interface IUserDAO {

    void addUser(User user) throws SQLException;

    void updateUser(User user) throws SQLException;

    void deleteUser(int id) throws SQLException;

    User getUserById(int id) throws SQLException;

    User getUserByLogin(String login) throws SQLException;

    List<User> getAllUsers() throws SQLException;

}
