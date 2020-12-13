package com.example.demo.Api.Rabbit.driverDto;

import com.example.demo.Api.Rest.MappingModule;
import com.example.demo.Services.MainClasses.DriverInfo.DriverStatus;

public class DeleteInfo {
    private final String name;
    private final DriverStatus status;
    private final MappingModule module;

    public DeleteInfo(String name, DriverStatus status, MappingModule module) {
        this.name = name;
        this.status = status;
        this.module = module;
    }

    public String getName() {
        return name;
    }

    public DriverStatus getStatus() {
        return status;
    }

    public MappingModule getModule() {
        return module;
    }
}
