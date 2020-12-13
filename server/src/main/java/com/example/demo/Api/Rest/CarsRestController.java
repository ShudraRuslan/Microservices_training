package com.example.demo.Api.Rest;


import com.example.demo.Services.MainClasses.CarInfo.Car;
import com.example.demo.Services.MainClasses.CarInfo.CarStatus;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;
import java.util.UUID;


@RestController
@RequestMapping(value = "/cars")
public class CarsRestController {


    private final RestTemplate template = new RestTemplate();
    private final String address = "http://carserver:8083/cars/";

    @PostMapping
    public ResponseEntity<Car> add(@RequestParam String name, @RequestParam double enginePower,
                                   @RequestParam int capacity, @RequestParam double fuelConsumption,
                                   @RequestParam double mileage) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", name).
                queryParam("enginePower", enginePower).
                queryParam("capacity", capacity).
                queryParam("fuelConsumption", fuelConsumption).
                queryParam("mileage", mileage);
        HttpEntity<Car> response = template.exchange(builder.toUriString(), HttpMethod.POST, null, Car.class);
        return ResponseEntity.ok(Objects.requireNonNull(response.getBody()));
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

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", name).
                queryParam("status", status).
                queryParam("module", module);
        HttpEntity<Object> response = template.exchange(builder.toUriString(), HttpMethod.DELETE, null, Object.class);
        return ResponseEntity.ok(Objects.requireNonNull(response.getBody()));
    }


}
