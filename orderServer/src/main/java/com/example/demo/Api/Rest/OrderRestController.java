package com.example.demo.Api.Rest;


import com.example.demo.Services.MainClasses.OrderInfo.Orders;
import com.example.demo.Services.ServicesRealization.OrderFulfillmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping(value = "/order")
public class OrderRestController {

    private final OrderFulfillmentService orderService;


    @Autowired
    public OrderRestController(OrderFulfillmentService service) {
        this.orderService = service;
    }

    @PostMapping
    public ResponseEntity<Orders> create(@RequestParam int amountOfPassengers, @RequestParam double distance,
                                         @RequestParam UUID clientId) {
        return ResponseEntity.ok(orderService.createOrder(amountOfPassengers, distance, clientId));
    }

    @PutMapping
    public ResponseEntity<Orders> complete(@RequestParam UUID orderId) {
        return ResponseEntity.ok(Objects.requireNonNull(orderService.processTheOrder(orderId)));
    }

    @GetMapping
    public ResponseEntity<List<Orders>> get(@RequestParam UUID orderId) {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }
}
