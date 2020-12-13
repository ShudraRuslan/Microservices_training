package com.example.demo.Api.Rabbit.dto;

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
