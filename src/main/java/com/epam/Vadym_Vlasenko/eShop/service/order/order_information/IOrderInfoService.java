package com.epam.Vadym_Vlasenko.eShop.service.order.order_information;

import com.epam.Vadym_Vlasenko.eShop.entity.OrderInfo;

import java.util.List;

/**
 * Created by swift-seeker-89717 on 19.04.2015.
 */
public interface IOrderInfoService {

    void createOrderInfo(OrderInfo orderInfo, int orderId);

    List<OrderInfo> getAll();

    OrderInfo getOrderInfoById(int orderInfoId);
}
