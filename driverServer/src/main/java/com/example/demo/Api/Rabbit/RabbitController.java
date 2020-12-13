package com.example.demo.Api.Rabbit;

import com.example.demo.Api.Rabbit.dto.CreateInfo;
import com.example.demo.Api.Rabbit.dto.DeleteInfo;
import com.example.demo.Api.Rabbit.dto.UpdateInfo;
import com.example.demo.Api.Rest.MappingModule;
import com.example.demo.Services.MainClasses.DriverInfo.DriverStatus;
import com.example.demo.Services.ServicesRealization.PersonnelService;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class RabbitController {

    public final PersonnelService service;

    @Autowired
    public RabbitController(PersonnelService service) {
        this.service = service;
    }

    @RabbitListener(queues = "driver_queue_create")
    public String create(String json) {
        try {
            Gson gson = new Gson();
            String result = java.net.URLDecoder.decode(json, StandardCharsets.UTF_8.name());
            CreateInfo info = gson.fromJson(result, CreateInfo.class);
            service.addNewDriverToPersonnel(info.getName(), info.getCategory(), info.getSalary(), info.getMileage());
            return "Created!";
        } catch (Exception e) {
            return "Error!";
        }
    }

    @RabbitListener(queues = "driver_queue_update")
    public String update(String json) {
        try {
            Gson gson = new Gson();
            String result = java.net.URLDecoder.decode(json, StandardCharsets.UTF_8.name());
            UpdateInfo info = gson.fromJson(result, UpdateInfo.class);
            service.updateDriverInformation(info.getId(), info.getDistance());
            return "Updated!";
        } catch (Exception e) {
            return "Error!";
        }

    }

    @RabbitListener(queues = "driver_queue_delete")
    public String delete(String json) {
        try {
            Gson gson = new Gson();
            String result = java.net.URLDecoder.decode(json, StandardCharsets.UTF_8.name());
            DeleteInfo info = gson.fromJson(result, DeleteInfo.class);
            MappingModule module = info.getModule();
            DriverStatus status = info.getStatus();
            String name = info.getName();
            if (module == MappingModule.ByName) {

                boolean response = service.deleteAllDriverByName(name);
                return Boolean.toString(response);
            } else if (module == MappingModule.ByStatus) {

                boolean response = service.deleteAllDriverByStatus(status);
                return Boolean.toString(response);
            } else {
                boolean response = service.deleteAllDrivers();
                return Boolean.toString(response);
            }
        } catch (Exception e) {
            return "Error!";
        }

    }
}
