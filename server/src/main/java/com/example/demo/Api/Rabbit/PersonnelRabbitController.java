package com.example.demo.Api.Rabbit;


import com.example.demo.Api.Rabbit.driverDto.CreateInfo;
import com.example.demo.Api.Rabbit.driverDto.DeleteInfo;
import com.example.demo.Api.Rest.MappingModule;
import com.example.demo.Services.MainClasses.DriverInfo.Category;
import com.example.demo.Services.MainClasses.DriverInfo.Driver;
import com.example.demo.Services.MainClasses.DriverInfo.DriverStatus;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping(value = "/personnel/rabbit")
public class PersonnelRabbitController {

    private final RestTemplate template;
    private final String address;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public PersonnelRabbitController(ConnectionFactory connectionFactory) {
        this.rabbitTemplate = new RabbitTemplate(connectionFactory);
        this.template = new RestTemplate();
        this.address = "http://driverserver:8086/personnel/";

    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestParam String name, @RequestParam Category category,
                                      @RequestParam double salary, @RequestParam double mileage) {

        CreateInfo info = new CreateInfo(name, category, salary, mileage);
        String request = new Gson().toJson(info);
        Object response = rabbitTemplate.convertSendAndReceive(RabbitConfiguration.EXCHANGE, RabbitConfiguration.Driver_Key_Create, request);
        assert response != null;
        return ResponseEntity.ok(response);
    }


    @GetMapping
    public ResponseEntity<List<Driver>> get(@RequestParam DriverStatus status,
                                            @RequestParam UUID id,
                                            @RequestParam MappingModule module) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("status", status).
                queryParam("id", id).
                queryParam("module", module);
        HttpEntity<List<Driver>> response = template.exchange(builder.toUriString(), HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Driver>>() {
                });
        return ResponseEntity.ok(Objects.requireNonNull(response.getBody()));
    }


    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestParam String name, @RequestParam DriverStatus status,
                                         @RequestParam MappingModule module) {

        DeleteInfo info = new DeleteInfo(name, status, module);
        String request = new Gson().toJson(info);
        Object response = rabbitTemplate.convertSendAndReceive(RabbitConfiguration.EXCHANGE, RabbitConfiguration.Driver_Key_Delete, request);
        assert response != null;
        return ResponseEntity.ok(response);

    }
}