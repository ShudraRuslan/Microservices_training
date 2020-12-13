package com.example.demo.Api.Rabbit;

import com.example.demo.Api.Rabbit.dto.CreateInfo;
import com.example.demo.Api.Rabbit.dto.DeleteInfo;
import com.example.demo.Api.Rabbit.dto.UpdateInfo;
import com.example.demo.Api.Rest.MappingModule;
import com.example.demo.Services.MainClasses.CarInfo.CarStatus;
import com.example.demo.Services.ServicesRealization.CarService;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class RabbitController {
    private final CarService service;

    @Autowired
    public RabbitController(CarService service) {
        this.service = service;
    }

    @RabbitListener(queues = "car_queue_create")
    public String create(String json) {
        try {
            Gson gson = new Gson();
            String result = java.net.URLDecoder.decode(json, StandardCharsets.UTF_8.name());
            CreateInfo info = gson.fromJson(result, CreateInfo.class);
            service.addNewCarToCarPark(info.getName(), info.getEnginePower(), info.getCapacity(), info.getFuelConsumption(), info.getMileage());
            return "Created!";
        } catch (Exception e) {
            return "Error!";
        }
    }

    @RabbitListener(queues = "car_queue_update")
    public String update(String json) {
        try {
            Gson gson = new Gson();
            String result = java.net.URLDecoder.decode(json, StandardCharsets.UTF_8.name());
            UpdateInfo info = gson.fromJson(result, UpdateInfo.class);
            service.updateCarInformation(info.getCarId(), info.getAdditionMileage());
            return "Updated!";
        } catch (Exception e) {
            return "Error!";
        }

    }

    @RabbitListener(queues = "car_queue_delete")
    public String delete(String json) {
        try {
            Gson gson = new Gson();
            String result = java.net.URLDecoder.decode(json, StandardCharsets.UTF_8.name());
            DeleteInfo info = gson.fromJson(result, DeleteInfo.class);
            MappingModule module = info.getModule();
            String name = info.getName();
            CarStatus status = info.getStatus();

            if (module == MappingModule.ByName) {

                boolean deleteResult = service.deleteAllCarByName(name);
                return Boolean.toString(deleteResult);
            } else if (module == MappingModule.ByStatus) {

                boolean deleteResult = service.deleteAllCarByStatus(status);
                return Boolean.toString(deleteResult);
            } else {

                boolean deleteResult = service.deleteAllCars();
                return Boolean.toString(deleteResult);
            }

        } catch (Exception e) {
            return "Error!";
        }
    }

}
