package com.epam.Vadym_Vlasenko.eShop.service.json;

import com.epam.Vadym_Vlasenko.eShop.entity.Order;
import com.epam.Vadym_Vlasenko.eShop.entity.OrderInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Вадим on 09.05.2015.
 */
public interface IJsonService {

    String orderMapToJSON(Map<Order,List<OrderInfo>> orderListMap);

}
