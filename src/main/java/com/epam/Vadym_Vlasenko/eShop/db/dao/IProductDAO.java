package com.epam.Vadym_Vlasenko.eShop.db.dao;

import com.epam.Vadym_Vlasenko.eShop.entity.Category;
import com.epam.Vadym_Vlasenko.eShop.entity.Criteria;
import com.epam.Vadym_Vlasenko.eShop.entity.Product;
import com.epam.Vadym_Vlasenko.eShop.entity.criteria.CriteriaResultBean;

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

    public CriteriaResultBean getProductsByCriteria(Criteria criteria) throws SQLException;

    public boolean removeProduct(int id);

}
