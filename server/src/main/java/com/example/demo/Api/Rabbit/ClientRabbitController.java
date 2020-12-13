package com.example.demo.Api.Rabbit;

import com.example.demo.Api.Rabbit.clientDto.CreateInfo;
import com.example.demo.Api.Rest.MappingModule;
import com.example.demo.Services.MainClasses.ClientInfo.Client;
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
@RequestMapping(value = "/client/rabbit")
public class ClientRabbitController {
    private final RestTemplate template;
    private final String address;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ClientRabbitController(ConnectionFactory connectionFactory) {
        this.rabbitTemplate = new RabbitTemplate(connectionFactory);
        this.address = "http://clientserver:8085/client/";
        this.template = new RestTemplate();

    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestParam String name, @RequestParam double cash,
                                         @RequestParam boolean isVip) {

        CreateInfo info = new CreateInfo(name, cash, isVip);
        String request = new Gson().toJson(info);
        Object response = rabbitTemplate.convertSendAndReceive(RabbitConfiguration.EXCHANGE, RabbitConfiguration.Client_Key_Create, request);
        assert response != null;
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<Client>> report(@RequestParam MappingModule module,
                                               @RequestParam UUID clientId) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("module", module).
                queryParam("id", clientId);
        HttpEntity<List<Client>> response = template.exchange(builder.toUriString(), HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Client>>() {
                });
        return ResponseEntity.ok(Objects.requireNonNull(response.getBody()));
    }


}
