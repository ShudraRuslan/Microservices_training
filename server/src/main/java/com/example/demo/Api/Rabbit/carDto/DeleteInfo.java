package com.example.demo.Api.Rabbit.carDto;

import com.example.demo.Api.Rest.MappingModule;
import com.example.demo.Services.MainClasses.CarInfo.CarStatus;

public class DeleteInfo {
    private final String name;
    private final CarStatus status;
    private final MappingModule module;

    public DeleteInfo(String name, CarStatus status, MappingModule module) {
        this.name = name;
        this.status = status;
        this.module = module;
    }

    public String getName() {
        return name;
    }

    public CarStatus getStatus() {
        return status;
    }

    public MappingModule getModule() {
        return module;
    }
}
