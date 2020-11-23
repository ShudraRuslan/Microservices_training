package com.example.demo.Services.MainClasses.repos;

import com.example.demo.Services.MainClasses.CashierInfo.Cashier;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CashierRepo extends CrudRepository<Cashier, String> {
    Cashier getByName(String id);
    Cashier getById(UUID id);
}
