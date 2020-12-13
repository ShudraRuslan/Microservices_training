package com.example.demo.Api.Grpc;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class CarsController extends CarServiceGrpc.CarServiceImplBase {
    private final String address = "http://carserver";
    private final int port = 9083;

    @Override
    public void add(Cars.CarAddRequest request, StreamObserver<Cars.CarsResponse> responseObserver) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(address, port).usePlaintext().build();
        CarServiceGrpc.CarServiceBlockingStub stub = CarServiceGrpc.newBlockingStub(channel);

        Cars.CarsResponse response = stub.add(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void update(Cars.CarUpdateRequest request, StreamObserver<Cars.CarsResponse> responseObserver) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(address, port).usePlaintext().build();
        CarServiceGrpc.CarServiceBlockingStub stub = CarServiceGrpc.newBlockingStub(channel);

        Cars.CarsResponse response = stub.update(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void report(Cars.ListCategoryRequest request, StreamObserver<Cars.ListCategoryResponse> responseObserver) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress(address, port).usePlaintext().build();
        CarServiceGrpc.CarServiceBlockingStub stub = CarServiceGrpc.newBlockingStub(channel);

        Cars.ListCategoryResponse response = stub.report(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }


    @Override
    public void delete(Cars.CarDeleteRequest request, StreamObserver<Cars.CarsDeleteResponse> responseObserver) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(address, port).usePlaintext().build();
        CarServiceGrpc.CarServiceBlockingStub stub = CarServiceGrpc.newBlockingStub(channel);

        Cars.CarsDeleteResponse response = stub.delete(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }
}
