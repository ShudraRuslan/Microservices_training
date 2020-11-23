package com.example.demo.Services.ServicesRealization;

import com.example.demo.Services.MainClasses.OrderInfo.OrderStatus;
import com.example.demo.Services.MainClasses.OrderInfo.Orders;
import com.example.demo.Services.MainClasses.OrderInfo.repos.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public final class OrderFulfillmentService {

    private final OrderRepo repos;

    @Autowired
    public OrderFulfillmentService(OrderRepo repos) {
        this.repos = repos;
    }

    public Orders createOrder(int amountOfPassengers, double distance, UUID clientId) {
        Orders orders = new Orders(amountOfPassengers, distance, clientId);
        repos.save(orders);
        return orders;
    }

    public List<Orders> getOrderById(UUID orderId) {
        return repos.getByOrderId(orderId);
    }

    public Orders processTheOrder(UUID orderId) {

        List<Orders> list = getOrderById(orderId);
        if (list.isEmpty())
            return null;

        Orders orders = list.get(0);

        if (orders.getCarId() == null) {

            System.out.println("CAN NOT FIND APPROPRIATE CAR FOR THE ORDER!");
            orders.setStatus(OrderStatus.isCancelled);
            repos.save(orders);
            return orders;

        } else if (orders.getDriverId() == null) {

            System.out.println("CAN NOT FIND APPROPRIATE DRIVER FOR THE ORDER!");
            orders.setStatus(OrderStatus.isCancelled);
            repos.save(orders);
            return orders;

        } else {
            
            orders.setStatus(OrderStatus.isCompleted);
            repos.save(orders);
            return orders;
        }
    }


}


