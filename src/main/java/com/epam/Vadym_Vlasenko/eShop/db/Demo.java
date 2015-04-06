package com.epam.Vadym_Vlasenko.eShop.db;

import com.epam.Vadym_Vlasenko.eShop.db.dao.DAOFactory;
import com.epam.Vadym_Vlasenko.eShop.db.dao.IProductDAO;
import com.epam.Vadym_Vlasenko.eShop.entity.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Вадим on 29.03.2015.
 */
public class Demo {

    public static void main (String[] args) throws SQLException {
        IProductDAO productDAO = DAOFactory.getInstance().getProductDAO();
        List<Product> products = productDAO.getProducts();
        for (Product product : products) {
            System.out.println(product);
        }
    }

}
