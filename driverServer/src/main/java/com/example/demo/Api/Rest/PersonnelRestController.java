package com.example.demo.Api.Rest;

import com.example.demo.Services.MainClasses.DriverInfo.Category;
import com.example.demo.Services.MainClasses.DriverInfo.Driver;
import com.example.demo.Services.MainClasses.DriverInfo.DriverStatus;
import com.example.demo.Services.ServicesRealization.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/personnel")
public class PersonnelRestController {

    private final PersonnelService service;

    @Autowired
    public PersonnelRestController(PersonnelService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Driver> add(@RequestParam String name, @RequestParam Category category,
                                      @RequestParam double salary, @RequestParam double mileage) {
        return ResponseEntity.ok(service.addNewDriverToPersonnel(name, category, salary, mileage));
    }


    @GetMapping
    public ResponseEntity<List<Driver>> get(@RequestParam DriverStatus status, @RequestParam UUID id,
                                            @RequestParam MappingModule module) {
        if (module == MappingModule.ByStatus)

            return ResponseEntity.ok(service.getDriversByStatus(status));

        else if (module == MappingModule.byId)

            return ResponseEntity.ok(service.getDriverById(id));

        else

            return ResponseEntity.ok(service.driversReport());
    }

    @PutMapping
    public ResponseEntity<Driver> updateInfo(@RequestParam UUID id, @RequestParam double distance) {
        return ResponseEntity.ok(service.updateDriverInformation(id, distance));
    }


    @DeleteMapping
    public ResponseEntity<Boolean> delete(@RequestParam String name, @RequestParam DriverStatus status,
                                          @RequestParam MappingModule module) {
        if (module == MappingModule.ByName)

            return ResponseEntity.ok(service.deleteAllDriverByName(name));

        else if (module == MappingModule.ByStatus)

            return ResponseEntity.ok(service.deleteAllDriverByStatus(status));

        else
            return ResponseEntity.ok(service.deleteAllDrivers());

    }
}