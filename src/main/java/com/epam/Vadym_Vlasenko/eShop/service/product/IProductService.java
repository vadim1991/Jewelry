package com.epam.Vadym_Vlasenko.eShop.service.product;

import com.epam.Vadym_Vlasenko.eShop.entity.Category;
import com.epam.Vadym_Vlasenko.eShop.entity.Criteria;
import com.epam.Vadym_Vlasenko.eShop.entity.Product;

import java.util.List;

/**
 * Created by Вадим on 22.03.2015.
 */
public interface IProductService {

    public void addProduct(Product product);

    public boolean removeProduct(int id);

    public Product getProductByID(int id);

    public List<Product> getProducts();

    public int getCountOfProduct(int idCategory);

    public List<Product> getProducts(int idCategory, int offset, int records);

    public List<Product> getProductsByCategory(int idCategory);

    public List<Product> getProductsByCriteria(Criteria criteria);

    public List<Product> getProductByName(String name);

    public List<Product> getProductsByRange(int minPrice, int maxPrice);

    public List<Product> getAllByMaterial(int id_material);

    public int getNoOfPages();

}
