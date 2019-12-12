package com.dennis.grpc;


import com.dennis.proto.*;
import io.grpc.stub.StreamObserver;

import java.util.UUID;

public class StudentServiceImpl extends StudentProtoServiceGrpc.StudentProtoServiceImplBase {
    // request--->response
    @Override
    public void getRealNameByUserName(Myrequest request, StreamObserver<Myresponse> responseObserver) {
        System.out.println("客户端传来的参数：" + request.getUsername());

        responseObserver.onNext(Myresponse.newBuilder().setRealname("张三").build());

        responseObserver.onCompleted();
    }

    // request--->stream response
    @Override
    public void getStudentsByAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        System.out.println("接受到客户端信息： " + request.getAge());

        responseObserver.onNext(StudentResponse.newBuilder().setName("张三").setAge(20).setCity("北京").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("李四").setAge(30).setCity("天津").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("王五").setAge(40).setCity("成都").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("赵六").setAge(50).setCity("深圳").build());

        responseObserver.onCompleted();
    }

    // stream request--->response
    @Override
    public StreamObserver<StudentRequest> getStudentsWrapperByAges(StreamObserver<StudentResponseList> responseObserver) {
        return new StreamObserver<StudentRequest>() {
            @Override
            public void onNext(StudentRequest value) {
                System.out.println("onNext:" + value.getAge());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("onError:" + t.getMessage());
            }

            @Override
            public void onCompleted() {
                StudentResponse zhangResponse = StudentResponse.newBuilder().setName("张三").setAge(23).setCity("张家村").build();
                StudentResponse liResponse = StudentResponse.newBuilder().setName("李四").setAge(24).setCity("李家村").build();
                StudentResponseList studentResponseList = StudentResponseList.newBuilder().addStudentResponse(zhangResponse).addStudentResponse(liResponse).build();
                responseObserver.onNext(studentResponseList);
                responseObserver.onCompleted();
            }
        };
    }

    // stream requset--->stream response
    @Override
    public StreamObserver<StreamRequest> biTalk(StreamObserver<StreamResponse> responseObserver) {
        return new StreamObserver<StreamRequest>() {
            @Override
            public void onNext(StreamRequest value) {
                System.out.println(value.getRequestInfo());

                responseObserver.onNext(StreamResponse.newBuilder().setResponseInfo(UUID.randomUUID().toString()).build());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
