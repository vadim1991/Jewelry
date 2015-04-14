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

    public Product getProductByID(int id);

    public List<Product> getProducts() throws SQLException;

    public List<Product> getProducts(int idCategory, int offset, int records) throws SQLException;

    public List<Product> getProductsByCategory(int idCategory);

    public List<Product> getProductsByCriteria(Criteria criteria);

    public int getCountOfProduct(int idCategory) throws SQLException;

    public List<Product> getProductByName(String name);

    public List<Product> getProductsByRange(int minPrice, int maxPrice);

    public List<Product> getAllByMaterial(int id_material);

    public List<Product> getAllByCategoryAndInsert(int id_category, int id_insert);

    public boolean removeProduct(int id);

    public int getNoOfPages();

}
