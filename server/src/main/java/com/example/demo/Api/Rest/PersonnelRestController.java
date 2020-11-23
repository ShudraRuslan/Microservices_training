package com.example.demo.Api.Rest;

import com.example.demo.Services.MainClasses.DriverInfo.Category;
import com.example.demo.Services.MainClasses.DriverInfo.Driver;
import com.example.demo.Services.MainClasses.DriverInfo.DriverStatus;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/personnel")
public class PersonnelRestController {

    private final RestTemplate template = new RestTemplate();
    private final String address = "http://driverserver:8086/personnel/";

    @PostMapping
    public ResponseEntity<Driver> add(@RequestParam String name, @RequestParam Category category,
                                      @RequestParam double salary, @RequestParam double mileage) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", name).
                queryParam("category", category).
                queryParam("salary", salary).
                queryParam("mileage", mileage);
        HttpEntity<Driver> response = template.exchange(builder.toUriString(), HttpMethod.POST, null, Driver.class);
        return ResponseEntity.ok(response.getBody());
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
        return ResponseEntity.ok(response.getBody());
    }


    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestParam String name, @RequestParam DriverStatus status,
                                         @RequestParam MappingModule module) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", name).
                queryParam("status", status).
                queryParam("module", module);
        HttpEntity<Object> response = template.exchange(builder.toUriString(), HttpMethod.DELETE, null, Object.class);
        return ResponseEntity.ok(response.getBody());

    }
}