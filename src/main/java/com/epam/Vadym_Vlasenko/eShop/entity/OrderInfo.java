package com.epam.Vadym_Vlasenko.eShop.entity;

import java.io.Serializable;

/**
 * Created by swift-seeker-89717 on 16.04.2015.
 */
public class OrderInfo implements Serializable {

    private int id;
    private Product product;
    private int price;
    private int amount;

    public OrderInfo() {
    }

    public OrderInfo(int id, Product product, int price, int amount) {
        this.id = id;
        this.product = product;
        this.price = price;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderInfo orderInfo = (OrderInfo) o;

        if (id != orderInfo.id) return false;
        if (price != orderInfo.price) return false;
        if (amount != orderInfo.amount) return false;
        return !(product != null ? !product.equals(orderInfo.product) : orderInfo.product != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + amount;
        return result;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "id=" + id +
                ", product=" + product +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
