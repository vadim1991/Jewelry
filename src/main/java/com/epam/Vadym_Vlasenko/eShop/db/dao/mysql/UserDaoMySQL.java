package com.epam.Vadym_Vlasenko.eShop.db.dao.mysql;

import com.epam.Vadym_Vlasenko.eShop.db.DBConnectionHolder;
import com.epam.Vadym_Vlasenko.eShop.db.dao.IUserDAO;
import com.epam.Vadym_Vlasenko.eShop.db.query_builder.QueryCreator;
import com.epam.Vadym_Vlasenko.eShop.entity.Image;
import com.epam.Vadym_Vlasenko.eShop.entity.Role;
import com.epam.Vadym_Vlasenko.eShop.entity.User;

import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Created by swift-seeker-89717 on 07.04.2015.
 */
public class UserDaoMySQL implements IUserDAO {

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String ROLE_NAME = "role";
    private static final String ROLE_ID = "id";
    private static final String ROLE_TABLE = "roles";
    private static final String AGE = "age";
    private static final String LOGIN_FAIL_AMOUNT = "loginFailAmount";
    private static final String LAST_LOGIN_DATE = "lastLoginDate";
    private static final String UNBLOCK_DATE = "unblockTime";
    private static final String EMAIL = "email";
    private static final String IMAGE_ID = "image_id";

    private static final String ADD_USER = "INSERT INTO users VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String GET_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String GET_USER_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
    private static final String GET_ALL_USERS = "SELECT * FROM users";
    private static final String DELETE_USER = "DELETE FROM users WHERE (id=?)";
    private static final String UPDATE_USER = "UPDATE users SET name=?,surname=?,age=?,email=?,password=?,login=?,image_id=?,role=?, loginFailAmount=?,lastLoginDate=?,unblockTime=? WHERE id=?";

    private static final ImageDaoMySQL imageDao = new ImageDaoMySQL();

    @Override
    public void addUser(User user) throws SQLException {
        Connection connection = DBConnectionHolder.getConnectionHolder().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER)) {
            int index = 1;
            preparedStatement.setInt(index++, user.getId());
            preparedStatement.setString(index++, user.getName());
            preparedStatement.setString(index++, user.getSurname());
            preparedStatement.setInt(index++, user.getAge());
            preparedStatement.setString(index++, user.getEmail());
            preparedStatement.setString(index++, user.getPassword());
            preparedStatement.setString(index++, user.getLogin());
            preparedStatement.setInt(index++, user.getImage().getId());
            preparedStatement.setInt(index++, user.getRole().getId());
            preparedStatement.setInt(index++, user.getLoginFailAmount());
            preparedStatement.setTimestamp(index++, convertToTimestamp(user.getLastLoginDate()));
            preparedStatement.setTimestamp(index++, convertToTimestamp(user.getUnblockedDate()));
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void updateUser(User user) throws SQLException {
        Connection connection = DBConnectionHolder.getConnectionHolder().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)) {
            int index = 1;
            preparedStatement.setString(index++, user.getName());
            preparedStatement.setString(index++, user.getSurname());
            preparedStatement.setInt(index++, user.getAge());
            preparedStatement.setString(index++, user.getEmail());
            preparedStatement.setString(index++, user.getPassword());
            preparedStatement.setString(index++, user.getLogin());
            preparedStatement.setInt(index++, user.getImage().getId());
            preparedStatement.setInt(index++, user.getRole().getId());
            preparedStatement.setInt(index++, user.getLoginFailAmount());
            preparedStatement.setTimestamp(index++, convertToTimestamp(user.getLastLoginDate()));
            preparedStatement.setTimestamp(index++, convertToTimestamp(user.getUnblockedDate()));
            preparedStatement.setInt(index++, user.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        Connection connection = DBConnectionHolder.getConnectionHolder().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)) {
            int index = 1;
            preparedStatement.setInt(index, id);
            preparedStatement.executeQuery();
        }
    }

    @Override
    public User getUserById(int id) throws SQLException {
        User user = new User();
        Connection connection = DBConnectionHolder.getConnectionHolder().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID)) {
            int index = 1;
            preparedStatement.setInt(index++, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = extractUser(resultSet);
            }
        }
        return user;
    }

    @Override
    public User getUserByLogin(String login) throws SQLException {
        User user = null;
        Connection connection = DBConnectionHolder.getConnectionHolder().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_LOGIN)) {
            int index = 1;
            preparedStatement.setString(index++, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = extractUser(resultSet);
            }
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        Connection connection = DBConnectionHolder.getConnectionHolder().getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL_USERS);
            while (resultSet.next()) {
                users.add(extractUser(resultSet));
            }
        }
        return users;
    }

    private Role getRoleById(int idRole) throws SQLException {
        Role role = new Role();
        Connection connection = DBConnectionHolder.getConnectionHolder().getConnection();
        QueryCreator creator = new QueryCreator();
        String query = creator.where(ROLE_TABLE, ROLE_ID, String.valueOf(idRole));
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                role.setId(resultSet.getInt(ROLE_ID));
                role.setRole(resultSet.getString(ROLE_NAME));
            }
        }
        return role;
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
        Image image = imageDao.getImageById(resultSet.getInt(IMAGE_ID), DBConnectionHolder.getConnectionHolder().getConnection());
        user.setImage(image);
        user.setRole(getRoleById(resultSet.getInt(ROLE_NAME)));
        user.setLoginFailAmount(resultSet.getInt(LOGIN_FAIL_AMOUNT));
        Date date = new Date();
        date.setTime(resultSet.getTimestamp(LAST_LOGIN_DATE).getTime());
        user.setLastLoginDate(date);
        date = new Date();
        date.setTime(resultSet.getTimestamp(UNBLOCK_DATE).getTime());
        user.setUnblockedDate(date);
        return user;
    }

    private Timestamp convertToTimestamp(Date date) {
        Timestamp timestamp = null;
        if (date != null) {
            timestamp = new Timestamp(date.getTime());
        }
        return timestamp;
    }

}
