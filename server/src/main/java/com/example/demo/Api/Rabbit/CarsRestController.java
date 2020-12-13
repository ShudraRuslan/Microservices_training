package com.example.demo.Api.Rabbit;


import com.example.demo.Api.Rabbit.carDto.CreateInfo;
import com.example.demo.Api.Rabbit.carDto.DeleteInfo;
import com.example.demo.Api.Rest.MappingModule;
import com.example.demo.Services.MainClasses.CarInfo.CarStatus;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;
import java.util.UUID;


@RestController
@RequestMapping(value = "/cars/rabbit")
public class CarsRestController {


    private final RestTemplate template = new RestTemplate();
    private final String address = "http://carserver:8083/cars/";
    private final RabbitTemplate rabbitTemplate = new RabbitTemplate();

    @PostMapping
    public ResponseEntity<Object> add(@RequestParam String name, @RequestParam double enginePower,
                                      @RequestParam int capacity, @RequestParam double fuelConsumption,
                                      @RequestParam double mileage) {

        CreateInfo info = new CreateInfo(name, enginePower, capacity, fuelConsumption, mileage);
        String request = new Gson().toJson(info);
        Object response = rabbitTemplate.convertSendAndReceive("exchange", RabbitConfiguration.Car_Key_Create, request);
        return ResponseEntity.ok(Objects.requireNonNull(response));
    }

    @GetMapping
    public ResponseEntity<Object> report(@RequestParam CarStatus status,
                                         @RequestParam UUID id,
                                         @RequestParam MappingModule module) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("status", status).
                queryParam("id", id).
                queryParam("module", module);
        HttpEntity<Object> response = template.exchange(builder.toUriString(), HttpMethod.GET, null, Object.class);
        return ResponseEntity.ok(Objects.requireNonNull(response.getBody()));
    }


    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestParam String name, @RequestParam CarStatus status,
                                         @RequestParam MappingModule module) {

        DeleteInfo info = new DeleteInfo(name, status, module);
        String request = new Gson().toJson(info);
        Object response = rabbitTemplate.convertSendAndReceive("exchange", RabbitConfiguration.Car_Key_Delete, request);
        return ResponseEntity.ok(response);
    }


}
