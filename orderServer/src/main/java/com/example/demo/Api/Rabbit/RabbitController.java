package com.example.demo.Api.Rabbit;


import com.example.demo.Api.Rabbit.dto.CreateInfo;
import com.example.demo.Services.MainClasses.OrderInfo.OrderStatus;
import com.example.demo.Services.MainClasses.OrderInfo.Orders;
import com.example.demo.Services.ServicesRealization.OrderFulfillmentService;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Component
public class RabbitController {
    private final OrderFulfillmentService service;

    @Autowired
    public RabbitController(OrderFulfillmentService service) {
        this.service = service;
    }

    @RabbitListener(queues = "order_queue_create")
    public String create(String json) {
        try {
            Gson gson = new Gson();
            String result = java.net.URLDecoder.decode(json, StandardCharsets.UTF_8.name());
            CreateInfo info = gson.fromJson(result, CreateInfo.class);
            service.createOrder(info.getAmountOfPassengers(), info.getDistance(), info.getClientId());
            return "Created!";
        } catch (Exception e) {
            return "Error!";
        }

    }

    @RabbitListener(queues = "order_queue_update")
    public String update(String id) {
        try {
            UUID orderId = UUID.fromString(id);
            Orders order = service.processTheOrder(orderId);
            assert order != null;
            if (order.getStatus() == OrderStatus.isCancelled)
                return "Was cancelled!";
            else return "Was completed!";

        } catch (Exception e) {
            return "Error!";
        }
    }
}

