package com.epam.Vadym_Vlasenko.eShop.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by swift-seeker-89717 on 16.04.2015.
 */
public class Order implements Serializable {

    private int id;
    private OrderStatus orderStatus;
    private String orderInfo;
    private User user;
    private Date date;
    private String telephone;
    private String paymentInfo;
    private int totalPrice;

    public Order() {
        this.date = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (orderStatus != null ? !orderStatus.equals(order.orderStatus) : order.orderStatus != null) return false;
        if (orderInfo != null ? !orderInfo.equals(order.orderInfo) : order.orderInfo != null) return false;
        if (user != null ? !user.equals(order.user) : order.user != null) return false;
        if (date != null ? !date.equals(order.date) : order.date != null) return false;
        if (telephone != null ? !telephone.equals(order.telephone) : order.telephone != null) return false;
        return !(paymentInfo != null ? !paymentInfo.equals(order.paymentInfo) : order.paymentInfo != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        result = 31 * result + (orderInfo != null ? orderInfo.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (paymentInfo != null ? paymentInfo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderStatus=" + orderStatus +
                ", orderInfo='" + orderInfo + '\'' +
                ", user=" + user +
                ", date=" + date +
                ", telephone='" + telephone + '\'' +
                ", paymentInfo='" + paymentInfo + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
