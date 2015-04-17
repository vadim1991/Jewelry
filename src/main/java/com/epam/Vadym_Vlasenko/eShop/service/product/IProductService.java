package com.epam.Vadym_Vlasenko.eShop.service.product;

import com.epam.Vadym_Vlasenko.eShop.entity.Category;
import com.epam.Vadym_Vlasenko.eShop.entity.Criteria;
import com.epam.Vadym_Vlasenko.eShop.entity.Product;

import java.util.List;

/**
 * Created by Вадим on 22.03.2015.
 */
public interface IProductService {

    void addProduct(Product product);

    boolean removeProduct(int id);

    Product getProductByID(int id);

    List<Product> getProducts();

    int getCountOfProduct(int idCategory);

    List<Product> getProducts(int idCategory, int offset, int records);

    List<Product> getProductsByCategory(int idCategory);

    List<Product> getProductsByCriteria(Criteria criteria);

    List<Product> getProductByName(String name);

    List<Product> getProductsByRange(int minPrice, int maxPrice);

    List<Product> getAllByMaterial(int id_material);

    int getNoOfPages();

}
