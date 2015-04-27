package com.epam.Vadym_Vlasenko.eShop.db.dao;

import com.epam.Vadym_Vlasenko.eShop.entity.Image;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by swift-seeker-89717 on 27.04.2015.
 */
public interface IImageDao {

    Image addImage(Image image) throws SQLException;

    Image getImageById(int imageId, Connection connection) throws SQLException;

}
