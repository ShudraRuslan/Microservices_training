package com.example.demo.Api.Grpc;

import com.example.demo.Api.Rest.MappingModule;
import com.example.demo.Services.MainClasses.CarInfo.Car;
import com.example.demo.Services.MainClasses.CarInfo.CarStatus;
import com.example.demo.Services.MainClasses.CashierInfo.Cashier;
import com.example.demo.Services.MainClasses.ClientInfo.Client;
import com.example.demo.Services.MainClasses.DriverInfo.Category;
import com.example.demo.Services.MainClasses.DriverInfo.Driver;
import com.example.demo.Services.MainClasses.DriverInfo.DriverStatus;
import com.example.demo.Services.MainClasses.OrderInfo.OrderStatus;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@GrpcService
public class OrderController extends OrderServiceGrpc.OrderServiceImplBase {


    private final String address = "http://orderserver";
    private final int port = 9087;

    private Client getOrderClient(UUID clientId) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("http://clientserver", 9085).usePlaintext().build();
        ClientsControllerGrpc.ClientsControllerBlockingStub stub = ClientsControllerGrpc.newBlockingStub(channel);

        Clients.ReportRequest request = Clients.ReportRequest.newBuilder().setId(clientId.toString()).
                setModule(MappingModule.byId.toString()).
                build();
        Clients.ClientListResponse response = stub.report(request);
        channel.shutdown();
        return new Client(response.getClients(0).getName(), response.getClients(0).getCash(),
                response.getClients(0).getIsVip());
    }

    private Driver getOrderDriver(UUID driverId) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("http://driverserver", 9086).usePlaintext().build();
        DriverServiceGrpc.DriverServiceBlockingStub stub = DriverServiceGrpc.newBlockingStub(channel);

        com.example.demo.Api.Grpc.Driver.ListCategoryRequest request =
                com.example.demo.Api.Grpc.Driver.ListCategoryRequest.
                        newBuilder().
                        setId(driverId.toString()).
                        setMappingModule(MappingModule.byId.toString()).
                        build();
        com.example.demo.Api.Grpc.Driver.ListCategoryResponse response = stub.report(request);
        channel.shutdown();
        return new Driver(response.getWorkers(0).getName(), Category.A, 0, 0);
    }

    private Car getOrderCar(UUID carId) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("http://carserver", 9083).usePlaintext().build();
        CarServiceGrpc.CarServiceBlockingStub stub = CarServiceGrpc.newBlockingStub(channel);

        Cars.ListCategoryRequest request =
                Cars.ListCategoryRequest.
                        newBuilder().
                        setId(carId.toString()).
                        setMappingModule(MappingModule.byId.toString()).
                        build();
        Cars.ListCategoryResponse response = stub.report(request);
        channel.shutdown();
        return new Car(response.getWorkers(0).getName(), 0, 0, 0, 0);

    }


    private void checkClientsPayAbility(com.example.demo.Services.MainClasses.OrderInfo.Order order, double distance,
                                        int amountOfPassengers, boolean isVip) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("http://cashierserver", 9084).usePlaintext().build();
        CashierServiceGrpc.CashierServiceBlockingStub stub = CashierServiceGrpc.newBlockingStub(channel);

        com.example.demo.Api.Grpc.Cashier.CurrentCashRequest request =
                com.example.demo.Api.Grpc.Cashier.CurrentCashRequest.newBuilder().
                        setDistance(distance).
                        setAmountOfPassengers(amountOfPassengers).
                        setIsVip(isVip).
                        build();
        com.example.demo.Api.Grpc.Cashier.CurrentCashResponse response = stub.currentCash(request);

        channel.shutdown();
        double payload = response.getCurrentCash();


        Client cLient = getOrderClient(order.getClientId());
        boolean haveEnoughMoney = cLient.getCash() >= payload;

        if (haveEnoughMoney) {

            System.out.println("CLIENT DOES NOT HAVE ENOUGH MONEY!");
            order.setStatus(OrderStatus.isCancelled);

        }
    }

    private Car updateCarInformation(UUID carId, double distance) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("http://carserver", 9083).usePlaintext().build();
        CarServiceGrpc.CarServiceBlockingStub stub = CarServiceGrpc.newBlockingStub(channel);

        Cars.CarUpdateRequest request =
                Cars.CarUpdateRequest.
                        newBuilder().
                        setId(carId.toString()).
                        setDistance(distance).
                        build();
        Cars.CarsResponse response = stub.update(request);
        return new Car(response.getName(), 0, 0, 0, 0);
    }

    private Driver updateDriverInformation(UUID driverId, double distance) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("http://driverserver", 9086).usePlaintext().build();
        DriverServiceGrpc.DriverServiceBlockingStub stub = DriverServiceGrpc.newBlockingStub(channel);

        com.example.demo.Api.Grpc.Driver.DriverUpdateRequest request =
                com.example.demo.Api.Grpc.Driver.DriverUpdateRequest.
                        newBuilder().
                        setId(driverId.toString()).
                        setDistance(distance).
                        build();
        com.example.demo.Api.Grpc.Driver.DriverResponse response = stub.update(request);
        channel.shutdown();
        return new Driver(response.getName(), Category.A, 0, 0);
    }

    private Cashier updateCashier(double distance, double carFuelConsumption,
                                  int amountOfPassengers, double driverSalary,
                                  boolean carNeedsService, boolean isVip) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("http://cashierserver", 9084).usePlaintext().build();
        CashierServiceGrpc.CashierServiceBlockingStub stub = CashierServiceGrpc.newBlockingStub(channel);

        com.example.demo.Api.Grpc.Cashier.UpdateRequest request =
                com.example.demo.Api.Grpc.Cashier.UpdateRequest.newBuilder().
                        setDistance(distance).
                        setAmountOfPassengers(amountOfPassengers).
                        setIsVip(isVip).
                        setCarFuelConsumption(carFuelConsumption).
                        setCarNeedsService(carNeedsService).
                        setDriverSalary(driverSalary).
                        build();
        com.example.demo.Api.Grpc.Cashier.CashierResponse response = stub.update(request);
        channel.shutdown();
        return new Cashier(response.getName());
    }

    private void updateInformation(com.example.demo.Services.MainClasses.OrderInfo.Order order) {

        if (order.getStatus() == OrderStatus.isCompleted) {

            Driver driver = getOrderDriver(order.getDriverId());
            Car car = getOrderCar(order.getCarId());

            double distance = order.getDistance();
            int amountOfPassengers = order.getAmountOfPassengers();
            boolean isVip = getOrderClient(order.getClientId()).isVip();
            double carFuelConsumption = car.getFuelConsumption();
            double driverSalary = driver.getSalary();
            boolean carNeedsService = car.getMileage() > 4000;

            updateDriverInformation(order.getDriverId(), distance);
            updateCarInformation(order.getCarId(), distance);
            updateCashier(distance, carFuelConsumption,
                    amountOfPassengers, driverSalary, carNeedsService, isVip);
        }
    }

    public com.example.demo.Services.MainClasses.OrderInfo.Order getOrder(UUID orderId) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress(address, port).usePlaintext().build();
        OrderServiceGrpc.OrderServiceBlockingStub stub = OrderServiceGrpc.newBlockingStub(channel);

        Order.ReportRequest request = Order.ReportRequest.newBuilder().setId(orderId.toString()).build();
        Order.OrderResponse response = stub.report(request);

        OrderStatus status = switch (response.getStatus()) {
            case "isPreparing" -> OrderStatus.isPreparing;
            case "isCompleted" -> OrderStatus.isCompleted;
            case "isCancelled" -> OrderStatus.isCancelled;
            default -> OrderStatus.isCancelled;
        };
        return new com.example.demo.Services.MainClasses.OrderInfo.Order(
                UUID.fromString(response.getOrderId()),
                response.getAmountOfPassengers(),
                response.getDistance(),
                UUID.fromString(response.getClientId()),
                UUID.fromString(response.getDriverId()),
                UUID.fromString(response.getCarId()),
                status);

    }

    public Driver findAppropriateDriver() {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("http://driverserver", 9086).usePlaintext().build();
        DriverServiceGrpc.DriverServiceBlockingStub stub = DriverServiceGrpc.newBlockingStub(channel);

        com.example.demo.Api.Grpc.Driver.ListCategoryRequest request =
                com.example.demo.Api.Grpc.Driver.ListCategoryRequest.
                        newBuilder().
                        setId("").
                        setMappingModule(MappingModule.ByStatus.toString()).
                        setStatus(DriverStatus.free.toString()).
                        build();
        com.example.demo.Api.Grpc.Driver.ListCategoryResponse response = stub.report(request);
        channel.shutdown();
        List<Driver> list = new ArrayList<>();
        for (int i = 0; i < response.getWorkersCount(); i++) {
            list.add(new Driver(response.getWorkers(i).getName(), Category.A, 0, 0));
        }
        if (0 == response.getWorkersCount()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    public Car findAppropriateCar(double distance, int amountOfPassengers) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("http://carserver", 9083).usePlaintext().build();
        CarServiceGrpc.CarServiceBlockingStub stub = CarServiceGrpc.newBlockingStub(channel);

        com.example.demo.Api.Grpc.Cars.ListCategoryRequest request =
                com.example.demo.Api.Grpc.Cars.ListCategoryRequest.
                        newBuilder().
                        setId("").
                        setMappingModule(MappingModule.ByStatus.toString()).
                        setStatus(CarStatus.isFree.toString()).
                        build();
        com.example.demo.Api.Grpc.Cars.ListCategoryResponse response = stub.report(request);
        channel.shutdown();
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < response.getWorkersCount(); i++) {
            list.add(new Car(response.getWorkers(i).getName(), 0, 0, 0, 0));
        }

        if (response.getWorkersCount() == 0)
            return null;
        for (Car car : list) {
            if (car.getCapacity() >= amountOfPassengers && car.getEnginePower() >= distance * 10)
                return car;
        }
        return null;
    }


    @Override
    public void create(Order.CreateRequest request,
                       StreamObserver<Order.OrderResponse> responseObserver) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(address, port).usePlaintext().build();
        OrderServiceGrpc.OrderServiceBlockingStub stub = OrderServiceGrpc.newBlockingStub(channel);

        Order.OrderResponse response = stub.create(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }

    @Override
    public void complete(Order.CompleteRequest request, StreamObserver<Order.OrderResponse> responseObserver) {

        com.example.demo.Services.MainClasses.OrderInfo.Order order = getOrder(UUID.fromString(request.getId()));
        if (order == null)
            responseObserver.onError(Status.INTERNAL.asException());
        System.out.println(order);
        Car car = findAppropriateCar(order.getDistance(), order.getAmountOfPassengers());
        Driver driver = findAppropriateDriver();
        order.setCarId(car.getCarID());
        order.setDriverId(driver.getDriverId());


        ManagedChannel channel = ManagedChannelBuilder.forAddress(address, port).usePlaintext().build();
        OrderServiceGrpc.OrderServiceBlockingStub stub = OrderServiceGrpc.newBlockingStub(channel);

        Order.OrderResponse response = stub.complete(request);


        Client client = getOrderClient(order.getClientId());
        checkClientsPayAbility(order, order.getDistance(), order.getAmountOfPassengers(), client.isVip());
        updateInformation(order);

        Order.OrderResponse orderResponse = Order.OrderResponse.newBuilder().
                setAmountOfPassengers(order.getAmountOfPassengers()).
                setCarId(order.getCarId().toString()).
                setClientId(order.getClientId().toString()).
                setDriverId(order.getDriverId().toString()).
                setOrderId("").
                setDistance(order.getDistance()).
                setStatus(order.getStatus().toString()).build();

        responseObserver.onNext(orderResponse);
        responseObserver.onCompleted();
    }


    @Override
    public void report(Order.ReportRequest request,
                       StreamObserver<Order.OrderResponse> responseObserver) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress(address, port).usePlaintext().build();
        OrderServiceGrpc.OrderServiceBlockingStub stub = OrderServiceGrpc.newBlockingStub(channel);

        Order.OrderResponse response = stub.report(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }


}
