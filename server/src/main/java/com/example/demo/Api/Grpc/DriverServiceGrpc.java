package com.example.demo.Api.Grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: Driver.proto")
public final class DriverServiceGrpc {

  private DriverServiceGrpc() {}

  public static final String SERVICE_NAME = "DriverService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Driver.DriverAddRequest,
      Driver.DriverResponse> getAddMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "add",
      requestType = Driver.DriverAddRequest.class,
      responseType = Driver.DriverResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Driver.DriverAddRequest,
      Driver.DriverResponse> getAddMethod() {
    io.grpc.MethodDescriptor<Driver.DriverAddRequest, Driver.DriverResponse> getAddMethod;
    if ((getAddMethod = DriverServiceGrpc.getAddMethod) == null) {
      synchronized (DriverServiceGrpc.class) {
        if ((getAddMethod = DriverServiceGrpc.getAddMethod) == null) {
          DriverServiceGrpc.getAddMethod = getAddMethod = 
              io.grpc.MethodDescriptor.<Driver.DriverAddRequest, Driver.DriverResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "DriverService", "add"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Driver.DriverAddRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Driver.DriverResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DriverServiceMethodDescriptorSupplier("add"))
                  .build();
          }
        }
     }
     return getAddMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Driver.ListCategoryRequest,
      Driver.ListCategoryResponse> getReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "report",
      requestType = Driver.ListCategoryRequest.class,
      responseType = Driver.ListCategoryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Driver.ListCategoryRequest,
      Driver.ListCategoryResponse> getReportMethod() {
    io.grpc.MethodDescriptor<Driver.ListCategoryRequest, Driver.ListCategoryResponse> getReportMethod;
    if ((getReportMethod = DriverServiceGrpc.getReportMethod) == null) {
      synchronized (DriverServiceGrpc.class) {
        if ((getReportMethod = DriverServiceGrpc.getReportMethod) == null) {
          DriverServiceGrpc.getReportMethod = getReportMethod = 
              io.grpc.MethodDescriptor.<Driver.ListCategoryRequest, Driver.ListCategoryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "DriverService", "report"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Driver.ListCategoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Driver.ListCategoryResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DriverServiceMethodDescriptorSupplier("report"))
                  .build();
          }
        }
     }
     return getReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Driver.DriverUpdateRequest,
      Driver.DriverResponse> getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "update",
      requestType = Driver.DriverUpdateRequest.class,
      responseType = Driver.DriverResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Driver.DriverUpdateRequest,
      Driver.DriverResponse> getUpdateMethod() {
    io.grpc.MethodDescriptor<Driver.DriverUpdateRequest, Driver.DriverResponse> getUpdateMethod;
    if ((getUpdateMethod = DriverServiceGrpc.getUpdateMethod) == null) {
      synchronized (DriverServiceGrpc.class) {
        if ((getUpdateMethod = DriverServiceGrpc.getUpdateMethod) == null) {
          DriverServiceGrpc.getUpdateMethod = getUpdateMethod = 
              io.grpc.MethodDescriptor.<Driver.DriverUpdateRequest, Driver.DriverResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "DriverService", "update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Driver.DriverUpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Driver.DriverResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DriverServiceMethodDescriptorSupplier("update"))
                  .build();
          }
        }
     }
     return getUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Driver.DriverDeleteRequest,
      Driver.DriverDeleteResponse> getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "delete",
      requestType = Driver.DriverDeleteRequest.class,
      responseType = Driver.DriverDeleteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Driver.DriverDeleteRequest,
      Driver.DriverDeleteResponse> getDeleteMethod() {
    io.grpc.MethodDescriptor<Driver.DriverDeleteRequest, Driver.DriverDeleteResponse> getDeleteMethod;
    if ((getDeleteMethod = DriverServiceGrpc.getDeleteMethod) == null) {
      synchronized (DriverServiceGrpc.class) {
        if ((getDeleteMethod = DriverServiceGrpc.getDeleteMethod) == null) {
          DriverServiceGrpc.getDeleteMethod = getDeleteMethod = 
              io.grpc.MethodDescriptor.<Driver.DriverDeleteRequest, Driver.DriverDeleteResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "DriverService", "delete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Driver.DriverDeleteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Driver.DriverDeleteResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DriverServiceMethodDescriptorSupplier("delete"))
                  .build();
          }
        }
     }
     return getDeleteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DriverServiceStub newStub(io.grpc.Channel channel) {
    return new DriverServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DriverServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DriverServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DriverServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DriverServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class DriverServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void add(Driver.DriverAddRequest request,
                    io.grpc.stub.StreamObserver<Driver.DriverResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddMethod(), responseObserver);
    }

    /**
     */
    public void report(Driver.ListCategoryRequest request,
                       io.grpc.stub.StreamObserver<Driver.ListCategoryResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getReportMethod(), responseObserver);
    }

    /**
     */
    public void update(Driver.DriverUpdateRequest request,
                       io.grpc.stub.StreamObserver<Driver.DriverResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
    }

    /**
     */
    public void delete(Driver.DriverDeleteRequest request,
                       io.grpc.stub.StreamObserver<Driver.DriverDeleteResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Driver.DriverAddRequest,
                Driver.DriverResponse>(
                  this, METHODID_ADD)))
          .addMethod(
            getReportMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Driver.ListCategoryRequest,
                Driver.ListCategoryResponse>(
                  this, METHODID_REPORT)))
          .addMethod(
            getUpdateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Driver.DriverUpdateRequest,
                Driver.DriverResponse>(
                  this, METHODID_UPDATE)))
          .addMethod(
            getDeleteMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Driver.DriverDeleteRequest,
                Driver.DriverDeleteResponse>(
                  this, METHODID_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class DriverServiceStub extends io.grpc.stub.AbstractStub<DriverServiceStub> {
    private DriverServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DriverServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DriverServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DriverServiceStub(channel, callOptions);
    }

    /**
     */
    public void add(Driver.DriverAddRequest request,
                    io.grpc.stub.StreamObserver<Driver.DriverResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void report(Driver.ListCategoryRequest request,
                       io.grpc.stub.StreamObserver<Driver.ListCategoryResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReportMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(Driver.DriverUpdateRequest request,
                       io.grpc.stub.StreamObserver<Driver.DriverResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(Driver.DriverDeleteRequest request,
                       io.grpc.stub.StreamObserver<Driver.DriverDeleteResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DriverServiceBlockingStub extends io.grpc.stub.AbstractStub<DriverServiceBlockingStub> {
    private DriverServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DriverServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DriverServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DriverServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public Driver.DriverResponse add(Driver.DriverAddRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddMethod(), getCallOptions(), request);
    }

    /**
     */
    public Driver.ListCategoryResponse report(Driver.ListCategoryRequest request) {
      return blockingUnaryCall(
          getChannel(), getReportMethod(), getCallOptions(), request);
    }

    /**
     */
    public Driver.DriverResponse update(Driver.DriverUpdateRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public Driver.DriverDeleteResponse delete(Driver.DriverDeleteRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DriverServiceFutureStub extends io.grpc.stub.AbstractStub<DriverServiceFutureStub> {
    private DriverServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DriverServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DriverServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DriverServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Driver.DriverResponse> add(
        Driver.DriverAddRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Driver.ListCategoryResponse> report(
        Driver.ListCategoryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReportMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Driver.DriverResponse> update(
        Driver.DriverUpdateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Driver.DriverDeleteResponse> delete(
        Driver.DriverDeleteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD = 0;
  private static final int METHODID_REPORT = 1;
  private static final int METHODID_UPDATE = 2;
  private static final int METHODID_DELETE = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DriverServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DriverServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD:
          serviceImpl.add((Driver.DriverAddRequest) request,
              (io.grpc.stub.StreamObserver<Driver.DriverResponse>) responseObserver);
          break;
        case METHODID_REPORT:
          serviceImpl.report((Driver.ListCategoryRequest) request,
              (io.grpc.stub.StreamObserver<Driver.ListCategoryResponse>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((Driver.DriverUpdateRequest) request,
              (io.grpc.stub.StreamObserver<Driver.DriverResponse>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((Driver.DriverDeleteRequest) request,
              (io.grpc.stub.StreamObserver<Driver.DriverDeleteResponse>) responseObserver);
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

  private static abstract class DriverServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DriverServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Driver.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DriverService");
    }
  }

  private static final class DriverServiceFileDescriptorSupplier
      extends DriverServiceBaseDescriptorSupplier {
    DriverServiceFileDescriptorSupplier() {}
  }

  private static final class DriverServiceMethodDescriptorSupplier
      extends DriverServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DriverServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DriverServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DriverServiceFileDescriptorSupplier())
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
}
