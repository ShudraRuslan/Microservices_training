package com.example.demo.Api.Rest;


import com.example.demo.Services.MainClasses.CarInfo.Car;
import com.example.demo.Services.MainClasses.CarInfo.CarStatus;
import com.example.demo.Services.ServicesRealization.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value = "/cars")
public class CarsRestController {

    private final CarService service;

    @Autowired
    public CarsRestController(CarService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Car> add(@RequestParam String name, @RequestParam double enginePower,
                                   @RequestParam int capacity, @RequestParam double fuelConsumption,
                                   @RequestParam double mileage) {
        return ResponseEntity.ok(service.addNewCarToCarPark(name, enginePower, capacity,
                fuelConsumption, mileage));
    }

    @GetMapping
    public ResponseEntity<List<Car>> report(@RequestParam CarStatus status,
                                            @RequestParam UUID id,
                                            @RequestParam MappingModule module) {

        if (module == MappingModule.fullReport)

            return ResponseEntity.ok(service.carsReport());

        else if (module == MappingModule.byId)

            return ResponseEntity.ok(service.getCarById(id));

        else

            return ResponseEntity.ok(service.getCarsByStatus(status));
    }

    @PutMapping
    public ResponseEntity<Car> updateInfo(@RequestParam UUID id, @RequestParam double distance) {
        return ResponseEntity.ok(service.updateCarInformation(id, distance));
    }


    @DeleteMapping
    public ResponseEntity<Boolean> delete(@RequestParam String name, @RequestParam CarStatus status,
                                          @RequestParam MappingModule module) {

        if (module == MappingModule.ByName)

            return ResponseEntity.ok(service.deleteAllCarByName(name));

        else if (module == MappingModule.ByStatus)

            return ResponseEntity.ok(service.deleteAllCarByStatus(status));

        else

            return ResponseEntity.ok(service.deleteAllCars());
    }


}
