package com.example.demo.Api.Rabbit;

import com.example.demo.Api.Rabbit.dto.CreateInfo;
import com.example.demo.Services.ServicesRealization.ClientService;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class RabbitController {

    private final ClientService service;

    @Autowired
    public RabbitController(ClientService service) {
        this.service = service;
    }

    @RabbitListener(queues = "client_queue_create")
    public String create(String json) {
        try {
            Gson gson = new Gson();
            String result = java.net.URLDecoder.decode(json, StandardCharsets.UTF_8.name());
            CreateInfo info = gson.fromJson(result, CreateInfo.class);
            service.createClient(info.getName(), info.getCash(), info.isVip());
            return "Created";
        } catch (Exception e) {
            return "Error!";
        }
    }
}
