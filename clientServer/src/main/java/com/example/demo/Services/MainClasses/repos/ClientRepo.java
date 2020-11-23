package com.example.demo.Services.MainClasses.repos;

import com.example.demo.Services.MainClasses.ClientInfo.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ClientRepo extends CrudRepository<Client, String> {
    List<Client> getAllClientByName(String name);

    List<Client> getAllByIsVip(boolean vip);

    Client getClientByClientId(UUID clientId);
}
