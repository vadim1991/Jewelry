package com.epam.Vadym_Vlasenko.eShop.service.cart;

import com.epam.Vadym_Vlasenko.eShop.entity.Product;
import com.epam.Vadym_Vlasenko.eShop.entity.cart.Cart;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Vadym_Vlasenko on 20.05.2015.
 */
public class CartServiceTest {

    private static final int AMOUNT = 5;
    private static final int PRICE = 1000;

    private Product product;
    private CartService service;

    @Before
    public void init() {
        product = new Product();
        product.setPrice(PRICE);
        service = new CartService(new Cart());
        service.addProduct(product);
    }

    @Test
    public void addProductTest() {
        assertEquals(service.productAmount(), 1);
    }

    @Test
    public void deleteProductTest() {
        service.delete(product);
        assertEquals(service.productAmount(), 0);
    }

    @Test
    public void addProductWithAmount() {
        service.addProduct(product, AMOUNT);
        assertEquals(service.productAmount(), AMOUNT);
    }

    @Test
    public void totalPriceTest() {
        int totalPrice = service.totalPrice();
        assertEquals(totalPrice, PRICE);
    }

    @Test
    public void clearCartTest() {
        service.clearCart();
        assertEquals(service.productAmount(), 0);
    }

    @Test
    public void getSinglePriceTest() {
        List<Integer> prList = service.getSinglePrice();
        assertEquals(prList.size(),1);
        assertEquals(prList.get(0),PRICE,0);
    }

    @Test
    public void getContentTest() {
        Map<Product, Integer> cart = service.getContent();
        assertNotNull(cart);
        assertEquals(cart.size(),1);
    }

    @Test
    public void getProductsFromCart() {
        List<Product> products = service.getProductsFromCart();
        assertNotNull(products);
        assertEquals(products.size(),1);
        assertEquals(product,products.get(0));
    }


}
