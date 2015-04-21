package com.epam.Vadym_Vlasenko.eShop.service.order.order_status;

import com.epam.Vadym_Vlasenko.eShop.entity.OrderStatus;

import java.util.List;

/**
 * Created by swift-seeker-89717 on 19.04.2015.
 */
public interface IOrderStatusService {

    List<OrderStatus> getAll();

    OrderStatus getOrderStatusById(int id);

}
