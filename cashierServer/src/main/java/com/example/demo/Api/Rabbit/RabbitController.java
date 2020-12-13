package com.example.demo.Api.Rabbit;


import com.example.demo.Api.Rabbit.dto.UpdateInfo;
import com.example.demo.Services.ServicesRealization.CashierService;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class RabbitController {
    private final CashierService service;

    @Autowired
    public RabbitController(CashierService service) {
        this.service = service;
    }

    @RabbitListener(queues = "cashier_queue_create")
    public String create(String name) {
        try {
            service.createCashier(name);
            return "Created!";
        } catch (Exception e) {
            return "Error!";
        }
    }

    @RabbitListener(queues = "cashier_queue_update")
    public String update(String json) {
        try {
            Gson gson = new Gson();
            String result = java.net.URLDecoder.decode(json, StandardCharsets.UTF_8.name());
            UpdateInfo info = gson.fromJson(result, UpdateInfo.class);
            service.updateCashier(info.getDistance(), info.getCarFuelConsumption(), info.getAmountOfPassengers(),
                    info.getDriverSalary(), info.isCarNeedsService(), info.isVip());
            return "Updated!";
        } catch (Exception e) {
            return "Error!";
        }
    }
}
