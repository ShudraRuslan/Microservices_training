package com.example.demo.Services.MainClasses.OrderInfo.repos;

import com.example.demo.Services.MainClasses.OrderInfo.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepo extends CrudRepository<Orders, String> {
    List<Orders> getByOrderId(UUID id);
}
