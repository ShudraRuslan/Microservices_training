package com.example.demo.Api.GRPC;

import com.example.demo.Services.MainClasses.DriverInfo.Category;
import com.example.demo.Services.MainClasses.DriverInfo.DriverStatus;
import com.example.demo.Services.ServicesRealization.PersonnelService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@GrpcService
public class PersonnelController extends DriverServiceGrpc.DriverServiceImplBase {
    private final PersonnelService service;

    PersonnelController(PersonnelService service) {
        this.service = service;
    }

    @Override
    public void add(Driver.DriverAddRequest request, StreamObserver<Driver.DriverResponse> responseObserver) {
        Category category = switch (request.getCategory()) {
            case "B" -> Category.B;
            case "C" -> Category.C;
            case "D" -> Category.D;
            default -> Category.A;
        };

        com.example.demo.Services.MainClasses.DriverInfo.Driver driver =
                service.addNewDriverToPersonnel(request.getName(),
                        category,
                        request.getSalary(),
                        request.getMileage());

        Driver.DriverResponse response = Driver.DriverResponse.newBuilder().
                setDriverId(driver.getDriverId().toString())
                .setName(driver.getName())
                .setStatus(driver.getStatus().toString()).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void report(Driver.ListCategoryRequest request, StreamObserver<Driver.ListCategoryResponse> responseObserver) {
        List<Driver.DriverResponse> driverResponse = new ArrayList<>();

        if (request.getMappingModule().equals("fullReport")) {

            List<com.example.demo.Services.MainClasses.DriverInfo.Driver> drivers
                    = service.driversReport();

            driverListResponseMethod(responseObserver, driverResponse, drivers);

        } else if (request.getMappingModule().equals("byId")) {

            List<com.example.demo.Services.MainClasses.DriverInfo.Driver> drivers = service.getDriverById(UUID.fromString(request.getId()));
            List<Driver.DriverResponse> response = new ArrayList<>();

            String driverId = drivers.get(0).getDriverId().toString();
            Driver.DriverResponse responseItem = Driver.DriverResponse.newBuilder().setDriverId(driverId).setName(drivers.get(0).getName()).
                    setStatus(drivers.get(0).getStatus().toString()).build();

            response.add(responseItem);
            Driver.ListCategoryResponse listResponse = Driver.ListCategoryResponse.newBuilder().addAllWorkers(response).build();

            responseObserver.onNext(listResponse);
            responseObserver.onCompleted();

        } else {

            DriverStatus status = switch (request.getStatus()) {
                case "free" -> DriverStatus.free;
                case "atWork" -> DriverStatus.atWork;
                default -> DriverStatus.defaultStat;
            };

            List<com.example.demo.Services.MainClasses.DriverInfo.Driver> drivers
                    = service.getDriversByStatus(status);

            driverListResponseMethod(responseObserver, driverResponse, drivers);

        }
    }

    private void driverListResponseMethod(StreamObserver<Driver.ListCategoryResponse> responseObserver, List<Driver.DriverResponse> driverResponse,
                                       List<com.example.demo.Services.MainClasses.DriverInfo.Driver> drivers) {

        for (com.example.demo.Services.MainClasses.DriverInfo.Driver driver : drivers) {

            String driverId = driver.getDriverId().toString();
            Driver.DriverResponse response = Driver.DriverResponse.newBuilder().setDriverId(driverId).
                    setName(driver.getName()).setStatus(driver.getStatus().toString()).build();
            driverResponse.add(response);

        }

        Driver.ListCategoryResponse listResponse = Driver.ListCategoryResponse.newBuilder().addAllWorkers(driverResponse).build();

        responseObserver.onNext(listResponse);
        responseObserver.onCompleted();

    }

    @Override
    public void update(Driver.DriverUpdateRequest request,StreamObserver<Driver.DriverResponse> responseObserver ){
        com.example.demo.Services.MainClasses.DriverInfo.Driver driver =
                service.updateDriverInformation(UUID.fromString(request.getId()),request.getDistance());

        Driver.DriverResponse response = Driver.DriverResponse.newBuilder().
                setDriverId(driver.getDriverId().toString())
                .setName(driver.getName())
                .setStatus(driver.getStatus().toString()).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }

    @Override
    public void delete(Driver.DriverDeleteRequest request,StreamObserver<Driver.DriverDeleteResponse> responseObserver ){
        if (request.getModule().equals("ByName")) {
            boolean result = service.deleteAllDriverByName(request.getName());

            Driver.DriverDeleteResponse response = Driver.DriverDeleteResponse.newBuilder().setStatus(result).build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } else if (request.getModule().equals("ByStatus")) {
            DriverStatus status = switch (request.getStatus()) {
                case "free" -> DriverStatus.free;
                case "atWork" -> DriverStatus.atWork;
                default -> DriverStatus.defaultStat;
            };

            boolean result = service.deleteAllDriverByStatus(status);

            Driver.DriverDeleteResponse response = Driver.DriverDeleteResponse.newBuilder().setStatus(result).build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } else {

            boolean result = service.deleteAllDrivers();
            Driver.DriverDeleteResponse response = Driver.DriverDeleteResponse.newBuilder().setStatus(result).build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}


