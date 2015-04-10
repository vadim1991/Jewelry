package com.epam.Vadym_Vlasenko.eShop.entity.cart;

/**
 * Created by swift-seeker-89717 on 09.04.2015.
 */
public class CartBean {

    private double price;
    private int amountProduct;
    private double total;

    public CartBean(double price, int amountProduct, double total) {
        this.price = price;
        this.amountProduct = amountProduct;
        this.total = total;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmountProduct() {
        return amountProduct;
    }

    public void setAmountProduct(int amountProduct) {
        this.amountProduct = amountProduct;
    }

    public double getTotal() {
        return price * amountProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartBean cartBean = (CartBean) o;

        if (Double.compare(cartBean.price, price) != 0) return false;
        if (amountProduct != cartBean.amountProduct) return false;
        return Double.compare(cartBean.total, total) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(price);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + amountProduct;
        temp = Double.doubleToLongBits(total);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

}
