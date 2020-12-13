package com.example.demo.Api.Grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 */
@javax.annotation.Generated(
        value = "by gRPC proto compiler (version 1.15.0)",
        comments = "Source: Cars.proto")
public final class CarServiceGrpc {

    public static final String SERVICE_NAME = "CarService";
    private static final int METHODID_ADD = 0;
    private static final int METHODID_REPORT = 1;
    private static final int METHODID_UPDATE = 2;
    private static final int METHODID_DELETE = 3;
    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<Cars.CarAddRequest,
            Cars.CarsResponse> getAddMethod;
    private static volatile io.grpc.MethodDescriptor<Cars.ListCategoryRequest,
            Cars.ListCategoryResponse> getReportMethod;
    private static volatile io.grpc.MethodDescriptor<Cars.CarUpdateRequest,
            Cars.CarsResponse> getUpdateMethod;
    private static volatile io.grpc.MethodDescriptor<Cars.CarDeleteRequest,
            Cars.CarsDeleteResponse> getDeleteMethod;
    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    private CarServiceGrpc() {
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "add",
            requestType = Cars.CarAddRequest.class,
            responseType = Cars.CarsResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<Cars.CarAddRequest,
            Cars.CarsResponse> getAddMethod() {
        io.grpc.MethodDescriptor<Cars.CarAddRequest, Cars.CarsResponse> getAddMethod;
        if ((getAddMethod = CarServiceGrpc.getAddMethod) == null) {
            synchronized (CarServiceGrpc.class) {
                if ((getAddMethod = CarServiceGrpc.getAddMethod) == null) {
                    CarServiceGrpc.getAddMethod = getAddMethod =
                            io.grpc.MethodDescriptor.<Cars.CarAddRequest, Cars.CarsResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "CarService", "add"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Cars.CarAddRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Cars.CarsResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new CarServiceMethodDescriptorSupplier("add"))
                                    .build();
                }
            }
        }
        return getAddMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "report",
            requestType = Cars.ListCategoryRequest.class,
            responseType = Cars.ListCategoryResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<Cars.ListCategoryRequest,
            Cars.ListCategoryResponse> getReportMethod() {
        io.grpc.MethodDescriptor<Cars.ListCategoryRequest, Cars.ListCategoryResponse> getReportMethod;
        if ((getReportMethod = CarServiceGrpc.getReportMethod) == null) {
            synchronized (CarServiceGrpc.class) {
                if ((getReportMethod = CarServiceGrpc.getReportMethod) == null) {
                    CarServiceGrpc.getReportMethod = getReportMethod =
                            io.grpc.MethodDescriptor.<Cars.ListCategoryRequest, Cars.ListCategoryResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "CarService", "report"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Cars.ListCategoryRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Cars.ListCategoryResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new CarServiceMethodDescriptorSupplier("report"))
                                    .build();
                }
            }
        }
        return getReportMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "update",
            requestType = Cars.CarUpdateRequest.class,
            responseType = Cars.CarsResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<Cars.CarUpdateRequest,
            Cars.CarsResponse> getUpdateMethod() {
        io.grpc.MethodDescriptor<Cars.CarUpdateRequest, Cars.CarsResponse> getUpdateMethod;
        if ((getUpdateMethod = CarServiceGrpc.getUpdateMethod) == null) {
            synchronized (CarServiceGrpc.class) {
                if ((getUpdateMethod = CarServiceGrpc.getUpdateMethod) == null) {
                    CarServiceGrpc.getUpdateMethod = getUpdateMethod =
                            io.grpc.MethodDescriptor.<Cars.CarUpdateRequest, Cars.CarsResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "CarService", "update"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Cars.CarUpdateRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Cars.CarsResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new CarServiceMethodDescriptorSupplier("update"))
                                    .build();
                }
            }
        }
        return getUpdateMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "delete",
            requestType = Cars.CarDeleteRequest.class,
            responseType = Cars.CarsDeleteResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<Cars.CarDeleteRequest,
            Cars.CarsDeleteResponse> getDeleteMethod() {
        io.grpc.MethodDescriptor<Cars.CarDeleteRequest, Cars.CarsDeleteResponse> getDeleteMethod;
        if ((getDeleteMethod = CarServiceGrpc.getDeleteMethod) == null) {
            synchronized (CarServiceGrpc.class) {
                if ((getDeleteMethod = CarServiceGrpc.getDeleteMethod) == null) {
                    CarServiceGrpc.getDeleteMethod = getDeleteMethod =
                            io.grpc.MethodDescriptor.<Cars.CarDeleteRequest, Cars.CarsDeleteResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "CarService", "delete"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Cars.CarDeleteRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Cars.CarsDeleteResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new CarServiceMethodDescriptorSupplier("delete"))
                                    .build();
                }
            }
        }
        return getDeleteMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static CarServiceStub newStub(io.grpc.Channel channel) {
        return new CarServiceStub(channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static CarServiceBlockingStub newBlockingStub(
            io.grpc.Channel channel) {
        return new CarServiceBlockingStub(channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static CarServiceFutureStub newFutureStub(
            io.grpc.Channel channel) {
        return new CarServiceFutureStub(channel);
    }

    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (CarServiceGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new CarServiceFileDescriptorSupplier())
                            .addMethod(getAddMethod())
                            .addMethod(getReportMethod())
                            .addMethod(getUpdateMethod())
                            .addMethod(getDeleteMethod())
                            .build();
                }
            }
        }
        return result;
    }

    /**
     *
     */
    public static abstract class CarServiceImplBase implements io.grpc.BindableService {

        /**
         *
         */
        public void add(Cars.CarAddRequest request,
                        io.grpc.stub.StreamObserver<Cars.CarsResponse> responseObserver) {
            asyncUnimplementedUnaryCall(getAddMethod(), responseObserver);
        }

        /**
         *
         */
        public void report(Cars.ListCategoryRequest request,
                           io.grpc.stub.StreamObserver<Cars.ListCategoryResponse> responseObserver) {
            asyncUnimplementedUnaryCall(getReportMethod(), responseObserver);
        }

        /**
         *
         */
        public void update(Cars.CarUpdateRequest request,
                           io.grpc.stub.StreamObserver<Cars.CarsResponse> responseObserver) {
            asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
        }

        /**
         *
         */
        public void delete(Cars.CarDeleteRequest request,
                           io.grpc.stub.StreamObserver<Cars.CarsDeleteResponse> responseObserver) {
            asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
        }

        @java.lang.Override
        public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            getAddMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            Cars.CarAddRequest,
                                            Cars.CarsResponse>(
                                            this, METHODID_ADD)))
                    .addMethod(
                            getReportMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            Cars.ListCategoryRequest,
                                            Cars.ListCategoryResponse>(
                                            this, METHODID_REPORT)))
                    .addMethod(
                            getUpdateMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            Cars.CarUpdateRequest,
                                            Cars.CarsResponse>(
                                            this, METHODID_UPDATE)))
                    .addMethod(
                            getDeleteMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            Cars.CarDeleteRequest,
                                            Cars.CarsDeleteResponse>(
                                            this, METHODID_DELETE)))
                    .build();
        }
    }

    /**
     *
     */
    public static final class CarServiceStub extends io.grpc.stub.AbstractStub<CarServiceStub> {
        private CarServiceStub(io.grpc.Channel channel) {
            super(channel);
        }

        private CarServiceStub(io.grpc.Channel channel,
                               io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected CarServiceStub build(io.grpc.Channel channel,
                                       io.grpc.CallOptions callOptions) {
            return new CarServiceStub(channel, callOptions);
        }

        /**
         *
         */
        public void add(Cars.CarAddRequest request,
                        io.grpc.stub.StreamObserver<Cars.CarsResponse> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getAddMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void report(Cars.ListCategoryRequest request,
                           io.grpc.stub.StreamObserver<Cars.ListCategoryResponse> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getReportMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void update(Cars.CarUpdateRequest request,
                           io.grpc.stub.StreamObserver<Cars.CarsResponse> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void delete(Cars.CarDeleteRequest request,
                           io.grpc.stub.StreamObserver<Cars.CarsDeleteResponse> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
        }
    }

    /**
     *
     */
    public static final class CarServiceBlockingStub extends io.grpc.stub.AbstractStub<CarServiceBlockingStub> {
        private CarServiceBlockingStub(io.grpc.Channel channel) {
            super(channel);
        }

        private CarServiceBlockingStub(io.grpc.Channel channel,
                                       io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected CarServiceBlockingStub build(io.grpc.Channel channel,
                                               io.grpc.CallOptions callOptions) {
            return new CarServiceBlockingStub(channel, callOptions);
        }

        /**
         *
         */
        public Cars.CarsResponse add(Cars.CarAddRequest request) {
            return blockingUnaryCall(
                    getChannel(), getAddMethod(), getCallOptions(), request);
        }

        /**
         *
         */
        public Cars.ListCategoryResponse report(Cars.ListCategoryRequest request) {
            return blockingUnaryCall(
                    getChannel(), getReportMethod(), getCallOptions(), request);
        }

        /**
         *
         */
        public Cars.CarsResponse update(Cars.CarUpdateRequest request) {
            return blockingUnaryCall(
                    getChannel(), getUpdateMethod(), getCallOptions(), request);
        }

        /**
         *
         */
        public Cars.CarsDeleteResponse delete(Cars.CarDeleteRequest request) {
            return blockingUnaryCall(
                    getChannel(), getDeleteMethod(), getCallOptions(), request);
        }
    }

    /**
     *
     */
    public static final class CarServiceFutureStub extends io.grpc.stub.AbstractStub<CarServiceFutureStub> {
        private CarServiceFutureStub(io.grpc.Channel channel) {
            super(channel);
        }

        private CarServiceFutureStub(io.grpc.Channel channel,
                                     io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected CarServiceFutureStub build(io.grpc.Channel channel,
                                             io.grpc.CallOptions callOptions) {
            return new CarServiceFutureStub(channel, callOptions);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<Cars.CarsResponse> add(
                Cars.CarAddRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(getAddMethod(), getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<Cars.ListCategoryResponse> report(
                Cars.ListCategoryRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(getReportMethod(), getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<Cars.CarsResponse> update(
                Cars.CarUpdateRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(getUpdateMethod(), getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<Cars.CarsDeleteResponse> delete(
                Cars.CarDeleteRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(getDeleteMethod(), getCallOptions()), request);
        }
    }

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final CarServiceImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(CarServiceImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_ADD:
                    serviceImpl.add((Cars.CarAddRequest) request,
                            (io.grpc.stub.StreamObserver<Cars.CarsResponse>) responseObserver);
                    break;
                case METHODID_REPORT:
                    serviceImpl.report((Cars.ListCategoryRequest) request,
                            (io.grpc.stub.StreamObserver<Cars.ListCategoryResponse>) responseObserver);
                    break;
                case METHODID_UPDATE:
                    serviceImpl.update((Cars.CarUpdateRequest) request,
                            (io.grpc.stub.StreamObserver<Cars.CarsResponse>) responseObserver);
                    break;
                case METHODID_DELETE:
                    serviceImpl.delete((Cars.CarDeleteRequest) request,
                            (io.grpc.stub.StreamObserver<Cars.CarsDeleteResponse>) responseObserver);
                    break;
                default:
                    throw new AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(
                io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new AssertionError();
            }
        }
    }

    private static abstract class CarServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
        CarServiceBaseDescriptorSupplier() {
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return Cars.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("CarService");
        }
    }

    private static final class CarServiceFileDescriptorSupplier
            extends CarServiceBaseDescriptorSupplier {
        CarServiceFileDescriptorSupplier() {
        }
    }

    private static final class CarServiceMethodDescriptorSupplier
            extends CarServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
        private final String methodName;

        CarServiceMethodDescriptorSupplier(String methodName) {
            this.methodName = methodName;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(methodName);
        }
    }
}
