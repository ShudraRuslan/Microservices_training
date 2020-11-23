package com.example.demo.Services.ServicesRealization;

import com.example.demo.Services.MainClasses.ClientInfo.Client;
import com.example.demo.Services.MainClasses.repos.ClientRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientService {
    private final ClientRepo repos;

    public ClientService(ClientRepo repos) {
        this.repos = repos;
    }


    public Client createClient(String name, double cash, boolean isVip) {
        Client client = new Client(name, cash, isVip);
        repos.save(client);
        return client;
    }

    public Client getById(UUID clientId) {
        return repos.getClientByClientId(clientId);
    }

    public List<Client> clientReport() {
        return (List<Client>) repos.findAll();
    }

    public List<Client> getAllVip() {
        return repos.getAllByIsVip(true);
    }
}
