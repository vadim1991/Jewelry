package com.epam.Vadym_Vlasenko.eShop.service.cart;

import com.epam.Vadym_Vlasenko.eShop.entity.Product;
import com.epam.Vadym_Vlasenko.eShop.entity.cart.Cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by swift-seeker-89717 on 09.04.2015.
 */
public class CartService {

    private Cart cart;

    public CartService(Cart cart) {
        this.cart = cart;
    }

    public boolean addProduct(Product product, int amount) {
        return cart.addProduct(product, amount);
    }

    public void delete(Product product) {
        cart.delete(product);
    }

    public Map<Product, Integer> getContent() {
        return cart.getCart();
    }

    public double totalPrice() {
        int total = 0;
        for (Map.Entry entry : cart.getCart().entrySet()) {
            total += ((Product) entry.getKey()).getPrice() * (Integer) entry.getValue();
        }
        return total;
    }

    public void clearCart() {
        cart.clearCart();
    }

    public List<Integer> getSinglePrice() {
        List<Integer> list = new ArrayList<>();
        for (Map.Entry entry : cart.getCart().entrySet()) {
            list.add(((Product) entry.getKey()).getPrice() * (Integer) entry.getValue());
        }
        return list;
    }

    public int productAmount() {
        int result = 0;
        if (cart != null) {
            for (Map.Entry entry : cart.getCart().entrySet()) {
                result += (Integer) entry.getValue();
            }
        }
        return result;
    }
}
