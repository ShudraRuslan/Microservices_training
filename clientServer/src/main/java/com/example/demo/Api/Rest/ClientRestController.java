package com.example.demo.Api.Rest;

import com.example.demo.Services.MainClasses.ClientInfo.Client;
import com.example.demo.Services.ServicesRealization.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/client")
public class ClientRestController {
    private final ClientService service;

    @Autowired
    public ClientRestController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Client> create(@RequestParam String name, @RequestParam double cash, @RequestParam boolean isVip) {

        return ResponseEntity.ok(service.createClient(name, cash, isVip));
    }

    @GetMapping
    public ResponseEntity<Object> report(@RequestParam MappingModule module, @RequestParam UUID id) {
        if (module == MappingModule.vip)
            return ResponseEntity.ok(service.getAllVip());

        else if (module == MappingModule.byId)
            return ResponseEntity.ok(service.getById(id));
        else
            return ResponseEntity.ok(service.clientReport());
    }


}
