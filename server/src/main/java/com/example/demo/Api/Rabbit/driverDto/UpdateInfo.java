package com.example.demo.Api.Rabbit.driverDto;

import java.util.UUID;

public class UpdateInfo {

    private final UUID id;
    private final double distance;

    public UpdateInfo(UUID id, double distance) {
        this.id = id;
        this.distance = distance;
    }

    public UUID getId() {
        return id;
    }

    public double getDistance() {
        return distance;
    }
}
