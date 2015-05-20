package com.epam.Vadym_Vlasenko.eShop.db.dao.mysql;

import com.epam.Vadym_Vlasenko.eShop.db.DBConnectionHolder;
import com.epam.Vadym_Vlasenko.eShop.db.dao.IImageDao;
import com.epam.Vadym_Vlasenko.eShop.entity.Image;

import java.sql.*;

/**
 * Created by swift-seeker-89717 on 27.04.2015.
 */
public class ImageDaoMySQL implements IImageDao {

    private static final String ID_COLUMN = "id";
    private static final String TITLE_COLUMN = "title";
    private static final String URL_COLUMN = "url";

    private static final String GET_IMAGE_BY_ID = "SELECT * FROM image WHERE id=?";
    private static final String CREATE_IMAGE_QUERY = "INSERT INTO image VALUES (DEFAULT ,?,?)";

    @Override
    public Image addImage(Image image) throws SQLException {
        Image imageNew = new Image();
        Connection connection = DBConnectionHolder.getConnectionHolder().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE_IMAGE_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            int index = 1;
            preparedStatement.setString(index++, image.getTitle());
            preparedStatement.setString(index++, image.getUrl());
            if (preparedStatement.executeUpdate() > 0) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    imageNew.setId(resultSet.getInt(1));
                }
            }
        }
        return imageNew;
    }

    @Override
    public Image getImageById(int imageId, Connection connection) throws SQLException {
        Image image = new Image();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_IMAGE_BY_ID)) {
            int index = 1;
            preparedStatement.setInt(index, imageId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                image.setId(resultSet.getInt(ID_COLUMN));
                image.setTitle(resultSet.getString(TITLE_COLUMN));
                image.setUrl(resultSet.getString(URL_COLUMN));
            }
            resultSet.close();
        }
        return image;
    }
}
