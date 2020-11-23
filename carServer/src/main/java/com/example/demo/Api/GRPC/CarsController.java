package com.example.demo.Api.GRPC;

import com.example.demo.Api.Grpc.CarServiceGrpc;
import com.example.demo.Api.Grpc.Cars;
import com.example.demo.Services.MainClasses.CarInfo.Car;
import com.example.demo.Services.MainClasses.CarInfo.CarStatus;
import com.example.demo.Services.ServicesRealization.CarService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@GrpcService
public class CarsController extends CarServiceGrpc.CarServiceImplBase {
    private final CarService service;

    CarsController(CarService service) {
        this.service = service;
    }

    @Override
    public void add(Cars.CarAddRequest request, StreamObserver<Cars.CarsResponse> responseObserver) {
        Car car = service.addNewCarToCarPark(request.getName(), request.getEnginePower(), request.getCapacity(),
                request.getFuelConsumption(), request.getMileage());

        Cars.CarsResponse response = Cars.CarsResponse.newBuilder().setCarId(car.getCarID().toString())
                .setName(car.getName()).setStatus(car.getStatus().toString()).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void update(Cars.CarUpdateRequest request, StreamObserver<Cars.CarsResponse> responseObserver) {
        service.updateCarInformation(UUID.fromString(request.getId()), request.getDistance());

        Car car = service.getCarById(UUID.fromString(request.getId())).get(0);
        Cars.CarsResponse response = Cars.CarsResponse.newBuilder().setCarId(car.getCarID().toString())
                .setName(car.getName()).setStatus(car.getStatus().toString()).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void report(Cars.ListCategoryRequest request, StreamObserver<Cars.ListCategoryResponse> responseObserver) {
        List<Cars.CarsResponse> carResponse = new ArrayList<>();

        if (request.getMappingModule().equals("fullReport")) {

            List<Car> cars = service.carsReport();
            carListResponseMethod(responseObserver, carResponse, cars);

        } else if (request.getMappingModule().equals("byId")) {

            List<Car> car = service.getCarById(UUID.fromString(request.getId()));
            List<Cars.CarsResponse> response = new ArrayList<>();
            String carId = car.get(0).getCarID().toString();
            Cars.CarsResponse responseItem = Cars.CarsResponse.newBuilder().setCarId(carId).setName(car.get(0).getName()).
                    setStatus(car.get(0).getStatus().toString()).build();
            response.add(responseItem);
            Cars.ListCategoryResponse listResponse = Cars.ListCategoryResponse.newBuilder().addAllWorkers(response).build();
            responseObserver.onNext(listResponse);
            responseObserver.onCompleted();

        } else {

            CarStatus status = switch (request.getStatus()) {
                case "isFree" -> CarStatus.isFree;
                case "isAtWork" -> CarStatus.isAtWork;
                case "isAtService" -> CarStatus.isAtService;
                default -> CarStatus.defaultStat;
            };
            List<Car> cars = service.getCarsByStatus(status);
            carListResponseMethod(responseObserver, carResponse, cars);

        }
    }

    private void carListResponseMethod(StreamObserver<Cars.ListCategoryResponse> responseObserver, List<Cars.CarsResponse> carResponse, List<Car> cars) {

        for (Car car : cars) {
            String carId = car.getCarID().toString();
            Cars.CarsResponse response = Cars.CarsResponse.newBuilder().setCarId(carId).
                    setName(car.getName()).setStatus(car.getStatus().toString()).build();
            carResponse.add(response);
        }

        Cars.ListCategoryResponse listResponse = Cars.ListCategoryResponse.newBuilder().addAllWorkers(carResponse).build();

        responseObserver.onNext(listResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void delete(Cars.CarDeleteRequest request, StreamObserver<Cars.CarsDeleteResponse> responseObserver) {

        if (request.getModule().equals("ByName")) {
            boolean result = service.deleteAllCarByName(request.getName());

            Cars.CarsDeleteResponse response = Cars.CarsDeleteResponse.newBuilder().setStatus(result).build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } else if (request.getModule().equals("ByStatus")) {
            CarStatus status = switch (request.getStatus()) {

                case "isFree" -> CarStatus.isFree;
                case "isAtWork" -> CarStatus.isAtWork;
                case "isAtService" -> CarStatus.isAtService;
                default -> CarStatus.defaultStat;
            };

            boolean result = service.deleteAllCarByStatus(status);

            Cars.CarsDeleteResponse response = Cars.CarsDeleteResponse.newBuilder().setStatus(result).build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } else {

            boolean result = service.deleteAllCars();
            Cars.CarsDeleteResponse response = Cars.CarsDeleteResponse.newBuilder().setStatus(result).build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
