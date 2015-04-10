package com.epam.Vadym_Vlasenko.eShop.db.dao;

import com.epam.Vadym_Vlasenko.eShop.entity.User;

import java.util.List;

/**
 * Created by swift-seeker-89717 on 07.04.2015.
 */
public interface IUserDAO {

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    User getUserById(int id);

    User getUserByLogin(String login);

    List<User> getAllUsers();

}
