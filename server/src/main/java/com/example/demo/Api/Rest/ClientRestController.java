package com.example.demo.Api.Rest;

import com.example.demo.Services.MainClasses.ClientInfo.Client;
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
@RequestMapping(value = "/client")
public class ClientRestController {
    private final RestTemplate template = new RestTemplate();
    private final String address = "http://clientserver:8085/client/";

    @PostMapping
    public ResponseEntity<Client> create(@RequestParam String name, @RequestParam double cash,
                                         @RequestParam boolean isVip) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", name).
                queryParam("cash", cash).
                queryParam("isVip", isVip);
        HttpEntity<Client> response = template.exchange(builder.toUriString(), HttpMethod.POST, null, Client.class);
        return ResponseEntity.ok(response.getBody());
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
        return ResponseEntity.ok(response.getBody());
    }


}
