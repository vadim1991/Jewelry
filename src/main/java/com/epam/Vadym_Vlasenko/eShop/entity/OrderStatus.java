package com.epam.Vadym_Vlasenko.eShop.entity;

import java.io.Serializable;

/**
 * Created by swift-seeker-89717 on 16.04.2015.
 */
public class OrderStatus implements Serializable {

    private int id;
    private String status;

    public OrderStatus() {
    }

    public OrderStatus(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderStatus{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
