package com.example.demo.Api.Rabbit.dto;

import java.util.UUID;

public class CreateInfo {
    private final int amountOfPassengers;
    private final double distance;
    private final UUID clientId;

    public CreateInfo(int amountOfPassengers, double distance, UUID clientId) {
        this.amountOfPassengers = amountOfPassengers;
        this.distance = distance;
        this.clientId = clientId;
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
}
