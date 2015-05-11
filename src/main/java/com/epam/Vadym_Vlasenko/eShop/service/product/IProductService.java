package com.epam.Vadym_Vlasenko.eShop.service.product;

import com.epam.Vadym_Vlasenko.eShop.entity.Category;
import com.epam.Vadym_Vlasenko.eShop.entity.Criteria;
import com.epam.Vadym_Vlasenko.eShop.entity.Product;
import com.epam.Vadym_Vlasenko.eShop.entity.criteria.CriteriaResultBean;

import java.util.List;

/**
 * Created by Вадим on 22.03.2015.
 */
public interface IProductService {

    void addProduct(Product product);

    boolean removeProduct(int id);

    Product getProductByID(int id);

    List<Product> getProducts();

    List<Product> getProducts(int idCategory, int offset, int records);

    List<Product> getProductsByCategory(int idCategory);

    CriteriaResultBean getProductsByCriteria(Criteria criteria);

}
