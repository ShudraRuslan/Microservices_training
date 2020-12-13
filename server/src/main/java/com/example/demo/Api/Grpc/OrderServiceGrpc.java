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
        comments = "Source: Order.proto")
public final class OrderServiceGrpc {

    public static final String SERVICE_NAME = "OrderService";
    private static final int METHODID_CREATE = 0;
    private static final int METHODID_COMPLETE = 1;
    private static final int METHODID_REPORT = 2;
    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<com.example.demo.Api.Grpc.Order.CreateRequest,
            com.example.demo.Api.Grpc.Order.OrderResponse> getCreateMethod;
    private static volatile io.grpc.MethodDescriptor<com.example.demo.Api.Grpc.Order.CompleteRequest,
            com.example.demo.Api.Grpc.Order.OrderResponse> getCompleteMethod;
    private static volatile io.grpc.MethodDescriptor<com.example.demo.Api.Grpc.Order.ReportRequest,
            com.example.demo.Api.Grpc.Order.OrderResponse> getReportMethod;
    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    private OrderServiceGrpc() {
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "create",
            requestType = com.example.demo.Api.Grpc.Order.CreateRequest.class,
            responseType = com.example.demo.Api.Grpc.Order.OrderResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<com.example.demo.Api.Grpc.Order.CreateRequest,
            com.example.demo.Api.Grpc.Order.OrderResponse> getCreateMethod() {
        io.grpc.MethodDescriptor<com.example.demo.Api.Grpc.Order.CreateRequest, com.example.demo.Api.Grpc.Order.OrderResponse> getCreateMethod;
        if ((getCreateMethod = OrderServiceGrpc.getCreateMethod) == null) {
            synchronized (OrderServiceGrpc.class) {
                if ((getCreateMethod = OrderServiceGrpc.getCreateMethod) == null) {
                    OrderServiceGrpc.getCreateMethod = getCreateMethod =
                            io.grpc.MethodDescriptor.<com.example.demo.Api.Grpc.Order.CreateRequest, com.example.demo.Api.Grpc.Order.OrderResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "OrderService", "create"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            com.example.demo.Api.Grpc.Order.CreateRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            com.example.demo.Api.Grpc.Order.OrderResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("create"))
                                    .build();
                }
            }
        }
        return getCreateMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "complete",
            requestType = com.example.demo.Api.Grpc.Order.CompleteRequest.class,
            responseType = com.example.demo.Api.Grpc.Order.OrderResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<com.example.demo.Api.Grpc.Order.CompleteRequest,
            com.example.demo.Api.Grpc.Order.OrderResponse> getCompleteMethod() {
        io.grpc.MethodDescriptor<com.example.demo.Api.Grpc.Order.CompleteRequest, com.example.demo.Api.Grpc.Order.OrderResponse> getCompleteMethod;
        if ((getCompleteMethod = OrderServiceGrpc.getCompleteMethod) == null) {
            synchronized (OrderServiceGrpc.class) {
                if ((getCompleteMethod = OrderServiceGrpc.getCompleteMethod) == null) {
                    OrderServiceGrpc.getCompleteMethod = getCompleteMethod =
                            io.grpc.MethodDescriptor.<com.example.demo.Api.Grpc.Order.CompleteRequest, com.example.demo.Api.Grpc.Order.OrderResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "OrderService", "complete"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            com.example.demo.Api.Grpc.Order.CompleteRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            com.example.demo.Api.Grpc.Order.OrderResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("complete"))
                                    .build();
                }
            }
        }
        return getCompleteMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "report",
            requestType = com.example.demo.Api.Grpc.Order.ReportRequest.class,
            responseType = com.example.demo.Api.Grpc.Order.OrderResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<com.example.demo.Api.Grpc.Order.ReportRequest,
            com.example.demo.Api.Grpc.Order.OrderResponse> getReportMethod() {
        io.grpc.MethodDescriptor<com.example.demo.Api.Grpc.Order.ReportRequest, com.example.demo.Api.Grpc.Order.OrderResponse> getReportMethod;
        if ((getReportMethod = OrderServiceGrpc.getReportMethod) == null) {
            synchronized (OrderServiceGrpc.class) {
                if ((getReportMethod = OrderServiceGrpc.getReportMethod) == null) {
                    OrderServiceGrpc.getReportMethod = getReportMethod =
                            io.grpc.MethodDescriptor.<com.example.demo.Api.Grpc.Order.ReportRequest, com.example.demo.Api.Grpc.Order.OrderResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "OrderService", "report"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            com.example.demo.Api.Grpc.Order.ReportRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            com.example.demo.Api.Grpc.Order.OrderResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("report"))
                                    .build();
                }
            }
        }
        return getReportMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static OrderServiceStub newStub(io.grpc.Channel channel) {
        return new OrderServiceStub(channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static OrderServiceBlockingStub newBlockingStub(
            io.grpc.Channel channel) {
        return new OrderServiceBlockingStub(channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static OrderServiceFutureStub newFutureStub(
            io.grpc.Channel channel) {
        return new OrderServiceFutureStub(channel);
    }

    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (OrderServiceGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new OrderServiceFileDescriptorSupplier())
                            .addMethod(getCreateMethod())
                            .addMethod(getCompleteMethod())
                            .addMethod(getReportMethod())
                            .build();
                }
            }
        }
        return result;
    }

    /**
     *
     */
    public static abstract class OrderServiceImplBase implements io.grpc.BindableService {

        /**
         *
         */
        public void create(com.example.demo.Api.Grpc.Order.CreateRequest request,
                           io.grpc.stub.StreamObserver<com.example.demo.Api.Grpc.Order.OrderResponse> responseObserver) {
            asyncUnimplementedUnaryCall(getCreateMethod(), responseObserver);
        }

        /**
         *
         */
        public void complete(com.example.demo.Api.Grpc.Order.CompleteRequest request,
                             io.grpc.stub.StreamObserver<com.example.demo.Api.Grpc.Order.OrderResponse> responseObserver) {
            asyncUnimplementedUnaryCall(getCompleteMethod(), responseObserver);
        }

        /**
         *
         */
        public void report(com.example.demo.Api.Grpc.Order.ReportRequest request,
                           io.grpc.stub.StreamObserver<com.example.demo.Api.Grpc.Order.OrderResponse> responseObserver) {
            asyncUnimplementedUnaryCall(getReportMethod(), responseObserver);
        }

        @java.lang.Override
        public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            getCreateMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.example.demo.Api.Grpc.Order.CreateRequest,
                                            com.example.demo.Api.Grpc.Order.OrderResponse>(
                                            this, METHODID_CREATE)))
                    .addMethod(
                            getCompleteMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.example.demo.Api.Grpc.Order.CompleteRequest,
                                            com.example.demo.Api.Grpc.Order.OrderResponse>(
                                            this, METHODID_COMPLETE)))
                    .addMethod(
                            getReportMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.example.demo.Api.Grpc.Order.ReportRequest,
                                            com.example.demo.Api.Grpc.Order.OrderResponse>(
                                            this, METHODID_REPORT)))
                    .build();
        }
    }

    /**
     *
     */
    public static final class OrderServiceStub extends io.grpc.stub.AbstractStub<OrderServiceStub> {
        private OrderServiceStub(io.grpc.Channel channel) {
            super(channel);
        }

        private OrderServiceStub(io.grpc.Channel channel,
                                 io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected OrderServiceStub build(io.grpc.Channel channel,
                                         io.grpc.CallOptions callOptions) {
            return new OrderServiceStub(channel, callOptions);
        }

        /**
         *
         */
        public void create(com.example.demo.Api.Grpc.Order.CreateRequest request,
                           io.grpc.stub.StreamObserver<com.example.demo.Api.Grpc.Order.OrderResponse> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getCreateMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void complete(com.example.demo.Api.Grpc.Order.CompleteRequest request,
                             io.grpc.stub.StreamObserver<com.example.demo.Api.Grpc.Order.OrderResponse> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getCompleteMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void report(com.example.demo.Api.Grpc.Order.ReportRequest request,
                           io.grpc.stub.StreamObserver<com.example.demo.Api.Grpc.Order.OrderResponse> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getReportMethod(), getCallOptions()), request, responseObserver);
        }
    }

    /**
     *
     */
    public static final class OrderServiceBlockingStub extends io.grpc.stub.AbstractStub<OrderServiceBlockingStub> {
        private OrderServiceBlockingStub(io.grpc.Channel channel) {
            super(channel);
        }

        private OrderServiceBlockingStub(io.grpc.Channel channel,
                                         io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected OrderServiceBlockingStub build(io.grpc.Channel channel,
                                                 io.grpc.CallOptions callOptions) {
            return new OrderServiceBlockingStub(channel, callOptions);
        }

        /**
         *
         */
        public com.example.demo.Api.Grpc.Order.OrderResponse create(com.example.demo.Api.Grpc.Order.CreateRequest request) {
            return blockingUnaryCall(
                    getChannel(), getCreateMethod(), getCallOptions(), request);
        }

        /**
         *
         */
        public com.example.demo.Api.Grpc.Order.OrderResponse complete(com.example.demo.Api.Grpc.Order.CompleteRequest request) {
            return blockingUnaryCall(
                    getChannel(), getCompleteMethod(), getCallOptions(), request);
        }

        /**
         *
         */
        public com.example.demo.Api.Grpc.Order.OrderResponse report(com.example.demo.Api.Grpc.Order.ReportRequest request) {
            return blockingUnaryCall(
                    getChannel(), getReportMethod(), getCallOptions(), request);
        }
    }

    /**
     *
     */
    public static final class OrderServiceFutureStub extends io.grpc.stub.AbstractStub<OrderServiceFutureStub> {
        private OrderServiceFutureStub(io.grpc.Channel channel) {
            super(channel);
        }

        private OrderServiceFutureStub(io.grpc.Channel channel,
                                       io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected OrderServiceFutureStub build(io.grpc.Channel channel,
                                               io.grpc.CallOptions callOptions) {
            return new OrderServiceFutureStub(channel, callOptions);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<com.example.demo.Api.Grpc.Order.OrderResponse> create(
                com.example.demo.Api.Grpc.Order.CreateRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(getCreateMethod(), getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<com.example.demo.Api.Grpc.Order.OrderResponse> complete(
                com.example.demo.Api.Grpc.Order.CompleteRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(getCompleteMethod(), getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<com.example.demo.Api.Grpc.Order.OrderResponse> report(
                com.example.demo.Api.Grpc.Order.ReportRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(getReportMethod(), getCallOptions()), request);
        }
    }

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final OrderServiceImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(OrderServiceImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_CREATE:
                    serviceImpl.create((com.example.demo.Api.Grpc.Order.CreateRequest) request,
                            (io.grpc.stub.StreamObserver<com.example.demo.Api.Grpc.Order.OrderResponse>) responseObserver);
                    break;
                case METHODID_COMPLETE:
                    serviceImpl.complete((com.example.demo.Api.Grpc.Order.CompleteRequest) request,
                            (io.grpc.stub.StreamObserver<com.example.demo.Api.Grpc.Order.OrderResponse>) responseObserver);
                    break;
                case METHODID_REPORT:
                    serviceImpl.report((com.example.demo.Api.Grpc.Order.ReportRequest) request,
                            (io.grpc.stub.StreamObserver<com.example.demo.Api.Grpc.Order.OrderResponse>) responseObserver);
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

    private static abstract class OrderServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
        OrderServiceBaseDescriptorSupplier() {
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return com.example.demo.Api.Grpc.Order.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("OrderService");
        }
    }

    private static final class OrderServiceFileDescriptorSupplier
            extends OrderServiceBaseDescriptorSupplier {
        OrderServiceFileDescriptorSupplier() {
        }
    }

    private static final class OrderServiceMethodDescriptorSupplier
            extends OrderServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
        private final String methodName;

        OrderServiceMethodDescriptorSupplier(String methodName) {
            this.methodName = methodName;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(methodName);
        }
    }
}
