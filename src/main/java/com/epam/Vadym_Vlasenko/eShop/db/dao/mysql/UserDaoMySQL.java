package com.epam.Vadym_Vlasenko.eShop.db.dao.mysql;

import com.epam.Vadym_Vlasenko.eShop.db.DBConnection;
import com.epam.Vadym_Vlasenko.eShop.db.dao.IUserDAO;
import com.epam.Vadym_Vlasenko.eShop.entity.Role;
import com.epam.Vadym_Vlasenko.eShop.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by swift-seeker-89717 on 07.04.2015.
 */
public class UserDaoMySQL implements IUserDAO {

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String ROLE_ID = "role";
    private static final String ROLE_NAME = "role_name";
    private static final String AGE = "age";
    private static final String EMAIL = "email";

    private static final String ADD_USER = "INSERT INTO users VALUES (?,?,?,?,?,?,?,?)";
    private static final String GET_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String GET_USER_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
    private static final String GET_ALL_USERS = "SELECT * FROM users";
    private static final String DELETE_USER = "DELETE FROM users WHERE (id=?)";
    private static final String UPDATE_USER = "UPDATE users SET name=?,surname=?,age=?,email=?,password=?,login=?,role=? WHERE id=?";

    @Override
    public void addUser(User user) {
        try (Connection connection = DBConnection.getConnectionHolder().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER)) {
            int index = 1;
            preparedStatement.setInt(index++, user.getId());
            preparedStatement.setString(index++, user.getName());
            preparedStatement.setString(index++, user.getSurname());
            preparedStatement.setInt(index++, user.getAge());
            preparedStatement.setString(index++, user.getEmail());
            preparedStatement.setString(index++, user.getPassword());
            preparedStatement.setString(index++, user.getLogin());
            preparedStatement.setInt(index++, user.getRole().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(int id) {
        try (Connection connection = DBConnection.getConnectionHolder().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)) {
            int index = 1;
            preparedStatement.setInt(index, id);
            preparedStatement.executeQuery();
        } catch (SQLException e) {

        }
    }

    @Override
    public User getUserById(int id) {
        User user = new User();
        try (Connection connection = DBConnection.getConnectionHolder().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID)) {
            int index = 1;
            preparedStatement.setInt(index++, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = extractUser(resultSet);
            }
        } catch (SQLException e) {

        }
        return user;
    }

    @Override
    public User getUserByLogin(String login) {
        User user = null;
        try (Connection connection = DBConnection.getConnectionHolder().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_LOGIN)) {
            int index = 1;
            preparedStatement.setString(index++, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = extractUser(resultSet);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = DBConnection.getConnectionHolder().getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL_USERS);
            while (resultSet.next()) {
                users.add(extractUser(resultSet));
            }
        } catch (SQLException e) {

        }
        return users;
    }

    private User extractUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt(ID));
        user.setName(resultSet.getString(NAME));
        user.setSurname(resultSet.getString(SURNAME));
        user.setAge(resultSet.getInt(AGE));
        user.setEmail(resultSet.getString(EMAIL));
        user.setLogin(resultSet.getString(LOGIN));
        user.setPassword(resultSet.getString(PASSWORD));
        user.setRole(new Role(resultSet.getInt(ROLE_ID), "client"));
        return user;
    }
}
