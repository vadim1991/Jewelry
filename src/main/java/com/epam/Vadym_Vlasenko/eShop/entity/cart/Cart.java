package com.epam.Vadym_Vlasenko.eShop.entity.cart;

import com.epam.Vadym_Vlasenko.eShop.entity.Product;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by swift-seeker-89717 on 09.04.2015.
 */
public class Cart {

    private static final int DEFAULT_AMOUNT = 1;

    private Map<Product, Integer> cart;

    public Cart() {
        this.cart = new ConcurrentHashMap<>();
    }

    public boolean addProduct(Product product) {
        boolean result = false;
        if (product != null) {
            if (cart.containsKey(product)) {
                int amount = cart.get(product);
                cart.put(product, ++amount);
            } else {
                cart.put(product, DEFAULT_AMOUNT);
            }
            result = true;
        }
        return result;
    }

    public boolean addProduct(Product product, int amountProduct) {
        boolean result = false;
        if (product != null) {
            if (cart.containsKey(product)) {
                cart.put(product, amountProduct);
                result = true;
            }
        }
        return result;
    }

    public void delete(Product product) {
        cart.remove(product);
    }

    public void clearCart() {
        cart.clear();
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

}
