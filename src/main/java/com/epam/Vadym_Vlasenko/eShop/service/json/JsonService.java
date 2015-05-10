package com.epam.Vadym_Vlasenko.eShop.service.json;

import com.epam.Vadym_Vlasenko.eShop.entity.Order;
import com.epam.Vadym_Vlasenko.eShop.entity.OrderInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;
import java.util.Map;

/**
 * Created by Вадим on 09.05.2015.
 */
public class JsonService implements IJsonService {

    private Gson gson;

    public JsonService() {
        gson = new Gson();
    }

    @Override
    public String orderMapToJSON(Map<Order, List<OrderInfo>> orderListMap) {
        JsonObject jsonObject = new JsonObject();
        JsonArray array = new JsonArray();
        for (Map.Entry entry : orderListMap.entrySet()) {
            array.add(orderListToJSON((Order) entry.getKey(), (List<OrderInfo>) entry.getValue()));
        }
        jsonObject.add("orders", array);
        return gson.toJson(jsonObject);
    }

    private JsonArray orderInfoListToJSON(List<OrderInfo> orderInfoList) {
        JsonArray array = new JsonArray();
        for (OrderInfo orderInfo : orderInfoList) {
            JsonObject object = new JsonObject();
            object.addProperty("imageUrl", orderInfo.getProduct().getImage().getUrl());
            object.addProperty("title", orderInfo.getProduct().getTitle());
            object.addProperty("material", orderInfo.getProduct().getMaterial().getName());
            object.addProperty("weight", orderInfo.getProduct().getWeight());
            object.addProperty("amount", orderInfo.getAmount());
            object.addProperty("size", orderInfo.getProduct().getSize());
            object.addProperty("insert", orderInfo.getProduct().getInsert().getTitle());
            object.addProperty("category", orderInfo.getProduct().getCategory().getName());
            object.addProperty("price", orderInfo.getPrice());
            array.add(object);
        }
        return array;
    }

    private JsonObject orderListToJSON(Order order, List<OrderInfo> orderInfoList) {
        JsonObject object = new JsonObject();
        object.addProperty("id", order.getId());
        object.addProperty("orderStatus", order.getOrderStatus().getStatus());
        object.addProperty("orderInfo", order.getOrderInfo());
        object.addProperty("date", order.getDate().toString());
        object.addProperty("totalPrice", order.getTotalPrice());
        object.add("products", orderInfoListToJSON(orderInfoList));
        return object;
    }

}
