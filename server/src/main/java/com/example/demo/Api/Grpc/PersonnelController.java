package com.example.demo.Api.Grpc;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class PersonnelController extends DriverServiceGrpc.DriverServiceImplBase {

    private final String address = "http://driverserver";
    private final int port = 9086;

    @Override
    public void add(Driver.DriverAddRequest request, StreamObserver<Driver.DriverResponse> responseObserver) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(address, port).usePlaintext().build();
        DriverServiceGrpc.DriverServiceBlockingStub stub = DriverServiceGrpc.newBlockingStub(channel);

        Driver.DriverResponse response = stub.add(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void report(Driver.ListCategoryRequest request, StreamObserver<Driver.ListCategoryResponse> responseObserver) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(address, port).usePlaintext().build();
        DriverServiceGrpc.DriverServiceBlockingStub stub = DriverServiceGrpc.newBlockingStub(channel);

        Driver.ListCategoryResponse response = stub.report(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void update(Driver.DriverUpdateRequest request, StreamObserver<Driver.DriverResponse> responseObserver) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(address, port).usePlaintext().build();
        DriverServiceGrpc.DriverServiceBlockingStub stub = DriverServiceGrpc.newBlockingStub(channel);

        Driver.DriverResponse response = stub.update(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }

    @Override
    public void delete(com.example.demo.Api.Grpc.Driver.DriverDeleteRequest request, StreamObserver<com.example.demo.Api.Grpc.Driver.DriverDeleteResponse> responseObserver) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress(address, port).usePlaintext().build();
        DriverServiceGrpc.DriverServiceBlockingStub stub = DriverServiceGrpc.newBlockingStub(channel);

        Driver.DriverDeleteResponse response = stub.delete(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}


