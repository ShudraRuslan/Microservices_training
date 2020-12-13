package com.example.demo.Api.Rabbit.carDto;

import java.util.UUID;

public class UpdateInfo {
    private final UUID carId;
    private final double additionMileage;

    public UpdateInfo(UUID carId, double additionMileage) {
        this.carId = carId;
        this.additionMileage = additionMileage;
    }

    public UUID getCarId() {
        return carId;
    }

    public double getAdditionMileage() {
        return additionMileage;
    }
}
