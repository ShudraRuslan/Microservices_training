package com.example.demo.Api.Rabbit;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@RestController
@RequestMapping("/cashier/rabbit")
public class CashierRabbitController {
    private final RestTemplate template;
    private final String address;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public CashierRabbitController(ConnectionFactory connectionFactory) {
        this.rabbitTemplate = new RabbitTemplate(connectionFactory);
        this.address = "http://cashierserver:8084/cashier/";
        this.template = new RestTemplate();

    }


    @PostMapping()
    public ResponseEntity<Object> create() {

        Object response = rabbitTemplate.convertSendAndReceive(RabbitConfiguration.EXCHANGE, RabbitConfiguration.Cashier_Key_Create, "cash");
        assert response != null;
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<String> report() {

        HttpEntity<String> response = template.exchange(address, HttpMethod.GET, null, String.class);
        return ResponseEntity.ok(Objects.requireNonNull(response.getBody()));
    }
}
