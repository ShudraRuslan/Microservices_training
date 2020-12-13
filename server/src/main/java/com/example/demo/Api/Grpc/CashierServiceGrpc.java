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
        comments = "Source: Cashier.proto")
public final class CashierServiceGrpc {

    public static final String SERVICE_NAME = "CashierService";
    private static final int METHODID_CREATE = 0;
    private static final int METHODID_REPORT = 1;
    private static final int METHODID_UPDATE = 2;
    private static final int METHODID_CURRENT_CASH = 3;
    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<Cashier.CreateRequest,
            Cashier.CashierResponse> getCreateMethod;
    private static volatile io.grpc.MethodDescriptor<Cashier.ReportRequest,
            Cashier.CashierResponse> getReportMethod;
    private static volatile io.grpc.MethodDescriptor<Cashier.UpdateRequest,
            Cashier.CashierResponse> getUpdateMethod;
    private static volatile io.grpc.MethodDescriptor<Cashier.CurrentCashRequest,
            Cashier.CurrentCashResponse> getCurrentCashMethod;
    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    private CashierServiceGrpc() {
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "create",
            requestType = Cashier.CreateRequest.class,
            responseType = Cashier.CashierResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<Cashier.CreateRequest,
            Cashier.CashierResponse> getCreateMethod() {
        io.grpc.MethodDescriptor<Cashier.CreateRequest, Cashier.CashierResponse> getCreateMethod;
        if ((getCreateMethod = CashierServiceGrpc.getCreateMethod) == null) {
            synchronized (CashierServiceGrpc.class) {
                if ((getCreateMethod = CashierServiceGrpc.getCreateMethod) == null) {
                    CashierServiceGrpc.getCreateMethod = getCreateMethod =
                            io.grpc.MethodDescriptor.<Cashier.CreateRequest, Cashier.CashierResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "CashierService", "create"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Cashier.CreateRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Cashier.CashierResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new CashierServiceMethodDescriptorSupplier("create"))
                                    .build();
                }
            }
        }
        return getCreateMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "report",
            requestType = Cashier.ReportRequest.class,
            responseType = Cashier.CashierResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<Cashier.ReportRequest,
            Cashier.CashierResponse> getReportMethod() {
        io.grpc.MethodDescriptor<Cashier.ReportRequest, Cashier.CashierResponse> getReportMethod;
        if ((getReportMethod = CashierServiceGrpc.getReportMethod) == null) {
            synchronized (CashierServiceGrpc.class) {
                if ((getReportMethod = CashierServiceGrpc.getReportMethod) == null) {
                    CashierServiceGrpc.getReportMethod = getReportMethod =
                            io.grpc.MethodDescriptor.<Cashier.ReportRequest, Cashier.CashierResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "CashierService", "report"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Cashier.ReportRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Cashier.CashierResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new CashierServiceMethodDescriptorSupplier("report"))
                                    .build();
                }
            }
        }
        return getReportMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "update",
            requestType = Cashier.UpdateRequest.class,
            responseType = Cashier.CashierResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<Cashier.UpdateRequest,
            Cashier.CashierResponse> getUpdateMethod() {
        io.grpc.MethodDescriptor<Cashier.UpdateRequest, Cashier.CashierResponse> getUpdateMethod;
        if ((getUpdateMethod = CashierServiceGrpc.getUpdateMethod) == null) {
            synchronized (CashierServiceGrpc.class) {
                if ((getUpdateMethod = CashierServiceGrpc.getUpdateMethod) == null) {
                    CashierServiceGrpc.getUpdateMethod = getUpdateMethod =
                            io.grpc.MethodDescriptor.<Cashier.UpdateRequest, Cashier.CashierResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "CashierService", "update"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Cashier.UpdateRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Cashier.CashierResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new CashierServiceMethodDescriptorSupplier("update"))
                                    .build();
                }
            }
        }
        return getUpdateMethod;
    }

    @io.grpc.stub.annotations.RpcMethod(
            fullMethodName = SERVICE_NAME + '/' + "currentCash",
            requestType = Cashier.CurrentCashRequest.class,
            responseType = Cashier.CurrentCashResponse.class,
            methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<Cashier.CurrentCashRequest,
            Cashier.CurrentCashResponse> getCurrentCashMethod() {
        io.grpc.MethodDescriptor<Cashier.CurrentCashRequest, Cashier.CurrentCashResponse> getCurrentCashMethod;
        if ((getCurrentCashMethod = CashierServiceGrpc.getCurrentCashMethod) == null) {
            synchronized (CashierServiceGrpc.class) {
                if ((getCurrentCashMethod = CashierServiceGrpc.getCurrentCashMethod) == null) {
                    CashierServiceGrpc.getCurrentCashMethod = getCurrentCashMethod =
                            io.grpc.MethodDescriptor.<Cashier.CurrentCashRequest, Cashier.CurrentCashResponse>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "CashierService", "currentCash"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Cashier.CurrentCashRequest.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            Cashier.CurrentCashResponse.getDefaultInstance()))
                                    .setSchemaDescriptor(new CashierServiceMethodDescriptorSupplier("currentCash"))
                                    .build();
                }
            }
        }
        return getCurrentCashMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static CashierServiceStub newStub(io.grpc.Channel channel) {
        return new CashierServiceStub(channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static CashierServiceBlockingStub newBlockingStub(
            io.grpc.Channel channel) {
        return new CashierServiceBlockingStub(channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static CashierServiceFutureStub newFutureStub(
            io.grpc.Channel channel) {
        return new CashierServiceFutureStub(channel);
    }

    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (CashierServiceGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new CashierServiceFileDescriptorSupplier())
                            .addMethod(getCreateMethod())
                            .addMethod(getReportMethod())
                            .addMethod(getUpdateMethod())
                            .addMethod(getCurrentCashMethod())
                            .build();
                }
            }
        }
        return result;
    }

    /**
     *
     */
    public static abstract class CashierServiceImplBase implements io.grpc.BindableService {

        /**
         *
         */
        public void create(Cashier.CreateRequest request,
                           io.grpc.stub.StreamObserver<Cashier.CashierResponse> responseObserver) {
            asyncUnimplementedUnaryCall(getCreateMethod(), responseObserver);
        }

        /**
         *
         */
        public void report(Cashier.ReportRequest request,
                           io.grpc.stub.StreamObserver<Cashier.CashierResponse> responseObserver) {
            asyncUnimplementedUnaryCall(getReportMethod(), responseObserver);
        }

        /**
         *
         */
        public void update(Cashier.UpdateRequest request,
                           io.grpc.stub.StreamObserver<Cashier.CashierResponse> responseObserver) {
            asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
        }

        /**
         *
         */
        public void currentCash(Cashier.CurrentCashRequest request,
                                io.grpc.stub.StreamObserver<Cashier.CurrentCashResponse> responseObserver) {
            asyncUnimplementedUnaryCall(getCurrentCashMethod(), responseObserver);
        }

        @java.lang.Override
        public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            getCreateMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            Cashier.CreateRequest,
                                            Cashier.CashierResponse>(
                                            this, METHODID_CREATE)))
                    .addMethod(
                            getReportMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            Cashier.ReportRequest,
                                            Cashier.CashierResponse>(
                                            this, METHODID_REPORT)))
                    .addMethod(
                            getUpdateMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            Cashier.UpdateRequest,
                                            Cashier.CashierResponse>(
                                            this, METHODID_UPDATE)))
                    .addMethod(
                            getCurrentCashMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            Cashier.CurrentCashRequest,
                                            Cashier.CurrentCashResponse>(
                                            this, METHODID_CURRENT_CASH)))
                    .build();
        }
    }

    /**
     *
     */
    public static final class CashierServiceStub extends io.grpc.stub.AbstractStub<CashierServiceStub> {
        private CashierServiceStub(io.grpc.Channel channel) {
            super(channel);
        }

        private CashierServiceStub(io.grpc.Channel channel,
                                   io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected CashierServiceStub build(io.grpc.Channel channel,
                                           io.grpc.CallOptions callOptions) {
            return new CashierServiceStub(channel, callOptions);
        }

        /**
         *
         */
        public void create(Cashier.CreateRequest request,
                           io.grpc.stub.StreamObserver<Cashier.CashierResponse> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getCreateMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void report(Cashier.ReportRequest request,
                           io.grpc.stub.StreamObserver<Cashier.CashierResponse> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getReportMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void update(Cashier.UpdateRequest request,
                           io.grpc.stub.StreamObserver<Cashier.CashierResponse> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void currentCash(Cashier.CurrentCashRequest request,
                                io.grpc.stub.StreamObserver<Cashier.CurrentCashResponse> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(getCurrentCashMethod(), getCallOptions()), request, responseObserver);
        }
    }

    /**
     *
     */
    public static final class CashierServiceBlockingStub extends io.grpc.stub.AbstractStub<CashierServiceBlockingStub> {
        private CashierServiceBlockingStub(io.grpc.Channel channel) {
            super(channel);
        }

        private CashierServiceBlockingStub(io.grpc.Channel channel,
                                           io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected CashierServiceBlockingStub build(io.grpc.Channel channel,
                                                   io.grpc.CallOptions callOptions) {
            return new CashierServiceBlockingStub(channel, callOptions);
        }

        /**
         *
         */
        public Cashier.CashierResponse create(Cashier.CreateRequest request) {
            return blockingUnaryCall(
                    getChannel(), getCreateMethod(), getCallOptions(), request);
        }

        /**
         *
         */
        public Cashier.CashierResponse report(Cashier.ReportRequest request) {
            return blockingUnaryCall(
                    getChannel(), getReportMethod(), getCallOptions(), request);
        }

        /**
         *
         */
        public Cashier.CashierResponse update(Cashier.UpdateRequest request) {
            return blockingUnaryCall(
                    getChannel(), getUpdateMethod(), getCallOptions(), request);
        }

        /**
         *
         */
        public Cashier.CurrentCashResponse currentCash(Cashier.CurrentCashRequest request) {
            return blockingUnaryCall(
                    getChannel(), getCurrentCashMethod(), getCallOptions(), request);
        }
    }

    /**
     *
     */
    public static final class CashierServiceFutureStub extends io.grpc.stub.AbstractStub<CashierServiceFutureStub> {
        private CashierServiceFutureStub(io.grpc.Channel channel) {
            super(channel);
        }

        private CashierServiceFutureStub(io.grpc.Channel channel,
                                         io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected CashierServiceFutureStub build(io.grpc.Channel channel,
                                                 io.grpc.CallOptions callOptions) {
            return new CashierServiceFutureStub(channel, callOptions);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<Cashier.CashierResponse> create(
                Cashier.CreateRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(getCreateMethod(), getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<Cashier.CashierResponse> report(
                Cashier.ReportRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(getReportMethod(), getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<Cashier.CashierResponse> update(
                Cashier.UpdateRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(getUpdateMethod(), getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<Cashier.CurrentCashResponse> currentCash(
                Cashier.CurrentCashRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(getCurrentCashMethod(), getCallOptions()), request);
        }
    }

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final CashierServiceImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(CashierServiceImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_CREATE:
                    serviceImpl.create((Cashier.CreateRequest) request,
                            (io.grpc.stub.StreamObserver<Cashier.CashierResponse>) responseObserver);
                    break;
                case METHODID_REPORT:
                    serviceImpl.report((Cashier.ReportRequest) request,
                            (io.grpc.stub.StreamObserver<Cashier.CashierResponse>) responseObserver);
                    break;
                case METHODID_UPDATE:
                    serviceImpl.update((Cashier.UpdateRequest) request,
                            (io.grpc.stub.StreamObserver<Cashier.CashierResponse>) responseObserver);
                    break;
                case METHODID_CURRENT_CASH:
                    serviceImpl.currentCash((Cashier.CurrentCashRequest) request,
                            (io.grpc.stub.StreamObserver<Cashier.CurrentCashResponse>) responseObserver);
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

    private static abstract class CashierServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
        CashierServiceBaseDescriptorSupplier() {
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return Cashier.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("CashierService");
        }
    }

    private static final class CashierServiceFileDescriptorSupplier
            extends CashierServiceBaseDescriptorSupplier {
        CashierServiceFileDescriptorSupplier() {
        }
    }

    private static final class CashierServiceMethodDescriptorSupplier
            extends CashierServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
        private final String methodName;

        CashierServiceMethodDescriptorSupplier(String methodName) {
            this.methodName = methodName;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(methodName);
        }
    }
}
