package com.epam.Vadym_Vlasenko.eShop.entity.criteria;

import com.epam.Vadym_Vlasenko.eShop.entity.Product;

import java.util.List;

/**
 * Created by Вадим on 11.05.2015.
 */
public class CriteriaResultBean {

    private int amount;
    private List<Product> products;

    public CriteriaResultBean() {
    }

    public CriteriaResultBean(int amount, List<Product> products) {
        this.amount = amount;
        this.products = products;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
