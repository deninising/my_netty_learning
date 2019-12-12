package com.dennis.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.20.0)",
    comments = "Source: Student.proto")
public final class StudentProtoServiceGrpc {

  private StudentProtoServiceGrpc() {}

  public static final String SERVICE_NAME = "com.dennis.proto.StudentProtoService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.dennis.proto.Myrequest,
      com.dennis.proto.Myresponse> getGetRealNameByUserNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRealNameByUserName",
      requestType = com.dennis.proto.Myrequest.class,
      responseType = com.dennis.proto.Myresponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.dennis.proto.Myrequest,
      com.dennis.proto.Myresponse> getGetRealNameByUserNameMethod() {
    io.grpc.MethodDescriptor<com.dennis.proto.Myrequest, com.dennis.proto.Myresponse> getGetRealNameByUserNameMethod;
    if ((getGetRealNameByUserNameMethod = StudentProtoServiceGrpc.getGetRealNameByUserNameMethod) == null) {
      synchronized (StudentProtoServiceGrpc.class) {
        if ((getGetRealNameByUserNameMethod = StudentProtoServiceGrpc.getGetRealNameByUserNameMethod) == null) {
          StudentProtoServiceGrpc.getGetRealNameByUserNameMethod = getGetRealNameByUserNameMethod = 
              io.grpc.MethodDescriptor.<com.dennis.proto.Myrequest, com.dennis.proto.Myresponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.dennis.proto.StudentProtoService", "GetRealNameByUserName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dennis.proto.Myrequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dennis.proto.Myresponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentProtoServiceMethodDescriptorSupplier("GetRealNameByUserName"))
                  .build();
          }
        }
     }
     return getGetRealNameByUserNameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dennis.proto.StudentRequest,
      com.dennis.proto.StudentResponse> getGetStudentsByAgeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudentsByAge",
      requestType = com.dennis.proto.StudentRequest.class,
      responseType = com.dennis.proto.StudentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.dennis.proto.StudentRequest,
      com.dennis.proto.StudentResponse> getGetStudentsByAgeMethod() {
    io.grpc.MethodDescriptor<com.dennis.proto.StudentRequest, com.dennis.proto.StudentResponse> getGetStudentsByAgeMethod;
    if ((getGetStudentsByAgeMethod = StudentProtoServiceGrpc.getGetStudentsByAgeMethod) == null) {
      synchronized (StudentProtoServiceGrpc.class) {
        if ((getGetStudentsByAgeMethod = StudentProtoServiceGrpc.getGetStudentsByAgeMethod) == null) {
          StudentProtoServiceGrpc.getGetStudentsByAgeMethod = getGetStudentsByAgeMethod = 
              io.grpc.MethodDescriptor.<com.dennis.proto.StudentRequest, com.dennis.proto.StudentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.dennis.proto.StudentProtoService", "GetStudentsByAge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dennis.proto.StudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dennis.proto.StudentResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentProtoServiceMethodDescriptorSupplier("GetStudentsByAge"))
                  .build();
          }
        }
     }
     return getGetStudentsByAgeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dennis.proto.StudentRequest,
      com.dennis.proto.StudentResponseList> getGetStudentsWrapperByAgesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudentsWrapperByAges",
      requestType = com.dennis.proto.StudentRequest.class,
      responseType = com.dennis.proto.StudentResponseList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.dennis.proto.StudentRequest,
      com.dennis.proto.StudentResponseList> getGetStudentsWrapperByAgesMethod() {
    io.grpc.MethodDescriptor<com.dennis.proto.StudentRequest, com.dennis.proto.StudentResponseList> getGetStudentsWrapperByAgesMethod;
    if ((getGetStudentsWrapperByAgesMethod = StudentProtoServiceGrpc.getGetStudentsWrapperByAgesMethod) == null) {
      synchronized (StudentProtoServiceGrpc.class) {
        if ((getGetStudentsWrapperByAgesMethod = StudentProtoServiceGrpc.getGetStudentsWrapperByAgesMethod) == null) {
          StudentProtoServiceGrpc.getGetStudentsWrapperByAgesMethod = getGetStudentsWrapperByAgesMethod = 
              io.grpc.MethodDescriptor.<com.dennis.proto.StudentRequest, com.dennis.proto.StudentResponseList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.dennis.proto.StudentProtoService", "GetStudentsWrapperByAges"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dennis.proto.StudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dennis.proto.StudentResponseList.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentProtoServiceMethodDescriptorSupplier("GetStudentsWrapperByAges"))
                  .build();
          }
        }
     }
     return getGetStudentsWrapperByAgesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.dennis.proto.StreamRequest,
      com.dennis.proto.StreamResponse> getBiTalkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BiTalk",
      requestType = com.dennis.proto.StreamRequest.class,
      responseType = com.dennis.proto.StreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.dennis.proto.StreamRequest,
      com.dennis.proto.StreamResponse> getBiTalkMethod() {
    io.grpc.MethodDescriptor<com.dennis.proto.StreamRequest, com.dennis.proto.StreamResponse> getBiTalkMethod;
    if ((getBiTalkMethod = StudentProtoServiceGrpc.getBiTalkMethod) == null) {
      synchronized (StudentProtoServiceGrpc.class) {
        if ((getBiTalkMethod = StudentProtoServiceGrpc.getBiTalkMethod) == null) {
          StudentProtoServiceGrpc.getBiTalkMethod = getBiTalkMethod = 
              io.grpc.MethodDescriptor.<com.dennis.proto.StreamRequest, com.dennis.proto.StreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.dennis.proto.StudentProtoService", "BiTalk"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dennis.proto.StreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.dennis.proto.StreamResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentProtoServiceMethodDescriptorSupplier("BiTalk"))
                  .build();
          }
        }
     }
     return getBiTalkMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StudentProtoServiceStub newStub(io.grpc.Channel channel) {
    return new StudentProtoServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StudentProtoServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StudentProtoServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StudentProtoServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StudentProtoServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class StudentProtoServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getRealNameByUserName(com.dennis.proto.Myrequest request,
        io.grpc.stub.StreamObserver<com.dennis.proto.Myresponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRealNameByUserNameMethod(), responseObserver);
    }

    /**
     */
    public void getStudentsByAge(com.dennis.proto.StudentRequest request,
        io.grpc.stub.StreamObserver<com.dennis.proto.StudentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStudentsByAgeMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.dennis.proto.StudentRequest> getStudentsWrapperByAges(
        io.grpc.stub.StreamObserver<com.dennis.proto.StudentResponseList> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetStudentsWrapperByAgesMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.dennis.proto.StreamRequest> biTalk(
        io.grpc.stub.StreamObserver<com.dennis.proto.StreamResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getBiTalkMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetRealNameByUserNameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.dennis.proto.Myrequest,
                com.dennis.proto.Myresponse>(
                  this, METHODID_GET_REAL_NAME_BY_USER_NAME)))
          .addMethod(
            getGetStudentsByAgeMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.dennis.proto.StudentRequest,
                com.dennis.proto.StudentResponse>(
                  this, METHODID_GET_STUDENTS_BY_AGE)))
          .addMethod(
            getGetStudentsWrapperByAgesMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.dennis.proto.StudentRequest,
                com.dennis.proto.StudentResponseList>(
                  this, METHODID_GET_STUDENTS_WRAPPER_BY_AGES)))
          .addMethod(
            getBiTalkMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.dennis.proto.StreamRequest,
                com.dennis.proto.StreamResponse>(
                  this, METHODID_BI_TALK)))
          .build();
    }
  }

  /**
   */
  public static final class StudentProtoServiceStub extends io.grpc.stub.AbstractStub<StudentProtoServiceStub> {
    private StudentProtoServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentProtoServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentProtoServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentProtoServiceStub(channel, callOptions);
    }

    /**
     */
    public void getRealNameByUserName(com.dennis.proto.Myrequest request,
        io.grpc.stub.StreamObserver<com.dennis.proto.Myresponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRealNameByUserNameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getStudentsByAge(com.dennis.proto.StudentRequest request,
        io.grpc.stub.StreamObserver<com.dennis.proto.StudentResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetStudentsByAgeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.dennis.proto.StudentRequest> getStudentsWrapperByAges(
        io.grpc.stub.StreamObserver<com.dennis.proto.StudentResponseList> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getGetStudentsWrapperByAgesMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.dennis.proto.StreamRequest> biTalk(
        io.grpc.stub.StreamObserver<com.dennis.proto.StreamResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getBiTalkMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class StudentProtoServiceBlockingStub extends io.grpc.stub.AbstractStub<StudentProtoServiceBlockingStub> {
    private StudentProtoServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentProtoServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentProtoServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentProtoServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.dennis.proto.Myresponse getRealNameByUserName(com.dennis.proto.Myrequest request) {
      return blockingUnaryCall(
          getChannel(), getGetRealNameByUserNameMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.dennis.proto.StudentResponse> getStudentsByAge(
        com.dennis.proto.StudentRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetStudentsByAgeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StudentProtoServiceFutureStub extends io.grpc.stub.AbstractStub<StudentProtoServiceFutureStub> {
    private StudentProtoServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentProtoServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentProtoServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentProtoServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.dennis.proto.Myresponse> getRealNameByUserName(
        com.dennis.proto.Myrequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRealNameByUserNameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_REAL_NAME_BY_USER_NAME = 0;
  private static final int METHODID_GET_STUDENTS_BY_AGE = 1;
  private static final int METHODID_GET_STUDENTS_WRAPPER_BY_AGES = 2;
  private static final int METHODID_BI_TALK = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StudentProtoServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StudentProtoServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_REAL_NAME_BY_USER_NAME:
          serviceImpl.getRealNameByUserName((com.dennis.proto.Myrequest) request,
              (io.grpc.stub.StreamObserver<com.dennis.proto.Myresponse>) responseObserver);
          break;
        case METHODID_GET_STUDENTS_BY_AGE:
          serviceImpl.getStudentsByAge((com.dennis.proto.StudentRequest) request,
              (io.grpc.stub.StreamObserver<com.dennis.proto.StudentResponse>) responseObserver);
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
        case METHODID_GET_STUDENTS_WRAPPER_BY_AGES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getStudentsWrapperByAges(
              (io.grpc.stub.StreamObserver<com.dennis.proto.StudentResponseList>) responseObserver);
        case METHODID_BI_TALK:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.biTalk(
              (io.grpc.stub.StreamObserver<com.dennis.proto.StreamResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StudentProtoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StudentProtoServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.dennis.proto.StudentProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StudentProtoService");
    }
  }

  private static final class StudentProtoServiceFileDescriptorSupplier
      extends StudentProtoServiceBaseDescriptorSupplier {
    StudentProtoServiceFileDescriptorSupplier() {}
  }

  private static final class StudentProtoServiceMethodDescriptorSupplier
      extends StudentProtoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StudentProtoServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (StudentProtoServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StudentProtoServiceFileDescriptorSupplier())
              .addMethod(getGetRealNameByUserNameMethod())
              .addMethod(getGetStudentsByAgeMethod())
              .addMethod(getGetStudentsWrapperByAgesMethod())
              .addMethod(getBiTalkMethod())
              .build();
        }
      }
    }
    return result;
  }
}
