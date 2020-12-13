package com.example.demo.Api.Rest;

import com.example.demo.Services.MainClasses.CashierInfo.Cashier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

@RestController
@RequestMapping("/cashier")
public class CashierRestController {
    private final RestTemplate template = new RestTemplate();
    private final String address = "http://cashierserver:8084/cashier/";


    @PostMapping()
    public ResponseEntity<Cashier> create() {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", "cash");
        HttpEntity<Cashier> response = template.exchange(builder.toUriString(), HttpMethod.POST, null, Cashier.class);
        return ResponseEntity.ok(Objects.requireNonNull(response.getBody()));
    }

    @GetMapping
    public ResponseEntity<String> report() {

        HttpEntity<String> response = template.exchange(address, HttpMethod.GET, null, String.class);
        return ResponseEntity.ok(Objects.requireNonNull(response.getBody()));
    }
}
