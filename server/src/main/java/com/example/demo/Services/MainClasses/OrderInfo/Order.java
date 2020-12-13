package com.example.demo.Services.MainClasses.OrderInfo;

import java.util.UUID;


public final class Order {
    private UUID orderID;
    private int amountOfPassengers;
    private double distance;
    private UUID clientId;
    private UUID driverId;
    private UUID carId;
    private OrderStatus status;


    public Order() {
    }

    public Order(UUID orderId,
                 int amountOfPassengers,
                 double distance,
                 UUID clientId,
                 UUID driverId,
                 UUID carId,
                 OrderStatus status) {
        this.amountOfPassengers = amountOfPassengers;
        this.distance = distance;
        this.status = OrderStatus.isPreparing;
        this.clientId = clientId;
        this.driverId = driverId;
        this.carId = carId;
        this.status = status;
        this.orderID = orderId;
    }

    public UUID getOrderID() {
        return orderID;
    }

    public void setOrderID(UUID orderID) {
        this.orderID = orderID;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", amountOfPassengers=" + amountOfPassengers +
                ", distance=" + distance +
                ", clientId=" + clientId +
                ", driverId=" + driverId +
                ", carId=" + carId +
                ", status=" + status +
                '}';
    }

    public int getAmountOfPassengers() {
        return amountOfPassengers;
    }

    public double getDistance() {
        return distance;
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

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}


