package com.example.demo.Services.MainClasses.OrderInfo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;


@Entity
@EnableAutoConfiguration
public class Orders {
    @Id
    private UUID orderId;
    private int amountOfPassengers;
    private double distance;
    private UUID clientId;
    private UUID driverId;
    private UUID carId;
    private OrderStatus status;

    public Orders() {
    }

    public Orders(int amountOfPassengers, double distance, UUID clientId) {
        this.orderId = UUID.randomUUID();
        this.clientId = clientId;
        this.amountOfPassengers = amountOfPassengers;
        this.distance = distance;
        this.status = OrderStatus.isPreparing;
    }

    public void setAmountOfPassengers(int amountOfPassengers) {
        this.amountOfPassengers = amountOfPassengers;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", amountOfPassengers=" + amountOfPassengers +
                ", distance=" + distance +
                ", clientId=" + clientId +
                ", driverId=" + driverId +
                ", carId=" + carId +
                ", status=" + status +
                '}';
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public UUID getDriverId() {
        return driverId;
    }

    public void setDriverId(UUID driverId) {
        this.driverId = driverId;
    }

    public UUID getCarId() {
        return carId;
    }

    public void setCarId(UUID carId) {
        this.carId = carId;
    }

    public int getAmountOfPassengers() {
        return amountOfPassengers;
    }

    public double getDistance() {
        return distance;
    }


    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}


