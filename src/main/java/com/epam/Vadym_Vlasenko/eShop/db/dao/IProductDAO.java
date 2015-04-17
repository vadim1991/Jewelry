package com.epam.Vadym_Vlasenko.eShop.db.dao;

import com.epam.Vadym_Vlasenko.eShop.entity.Category;
import com.epam.Vadym_Vlasenko.eShop.entity.Criteria;
import com.epam.Vadym_Vlasenko.eShop.entity.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Вадим on 22.03.2015.
 */
public interface IProductDAO {

    public boolean addProduct(Product product) throws SQLException;

    public Product getProductByID(int id) throws SQLException;

    public List<Product> getProducts() throws SQLException;

    public List<Product> getProducts(int idCategory, int offset, int records) throws SQLException;

    public List<Product> getProductsByCategory(int idCategory) throws SQLException;

    public List<Product> getProductsByCriteria(Criteria criteria) throws SQLException;

    public int getCountOfProduct(int idCategory) throws SQLException;

    public List<Product> getProductByName(String name);

    public boolean removeProduct(int id);

    public int getNoOfPages();

}
