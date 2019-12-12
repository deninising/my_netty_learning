package com.dennis.grpc.client;

import com.dennis.proto.*;
import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

public class GrpaClient {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建信道
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9901)
                .usePlaintext()
                .build();
        // 普通模式
        StudentProtoServiceGrpc.StudentProtoServiceBlockingStub serviceBlockingStub =
                StudentProtoServiceGrpc.newBlockingStub(managedChannel);
        Myresponse response
                = serviceBlockingStub.getRealNameByUserName(Myrequest.newBuilder()
                .setUsername("zhangsan").build());
        System.out.println(response.getRealname());
        System.out.println("---------------------------------------------");
        // future模式
        StudentProtoServiceGrpc.StudentProtoServiceFutureStub studentProtoServiceFutureStub
                = StudentProtoServiceGrpc.newFutureStub(managedChannel);
        ListenableFuture<Myresponse> zs
                = studentProtoServiceFutureStub
                .getRealNameByUserName(Myrequest.newBuilder()
                        .setUsername("zhangsan")
                        .build());
        Myresponse myresponse = zs.get();
        System.out.println(myresponse.getRealname());
        // request-->stream reponse流模式
        System.out.println("---------------------------------------------");
        Iterator<StudentResponse> iter = serviceBlockingStub.
                getStudentsByAge(StudentRequest.newBuilder().setAge(20).build());
        while (iter.hasNext()) {
            StudentResponse studentResponse = iter.next();
            System.out.println(studentResponse.getName() + ", " + studentResponse.getAge() + ", " + studentResponse.getCity());
        }
        System.out.println("---------------------------------------------");
        // stream request--->response流模型
        StudentProtoServiceGrpc.StudentProtoServiceStub studentProtoServiceStub = StudentProtoServiceGrpc.newStub(managedChannel);

        StreamObserver<StudentResponseList> studentResponseListObserver = new StreamObserver<StudentResponseList>() {

            @Override
            public void onNext(StudentResponseList value) {
                value.getStudentResponseList().forEach(studentResponse -> {

                    System.out.print(studentResponse.getName() + ":");
                    System.out.print(studentResponse.getAge() + ":");
                    System.out.print(studentResponse.getCity() + ":");
                    System.out.println("******");
                });
            }
            @Override
            public void onError(Throwable t) {
                System.out.println("error:" + t.getMessage());
            }
            @Override
            public void onCompleted() {
                System.out.println("completed!");
            }
        };
        StreamObserver<StudentRequest> studentsStreamObserver = studentProtoServiceStub.getStudentsWrapperByAges(studentResponseListObserver);
        for (int i = 0; i<+5;i++){
            Thread.sleep(1000);
            studentsStreamObserver.onNext(StudentRequest.newBuilder().setAge(i+21).build());
        }


        studentsStreamObserver.onCompleted();
        System.out.println("---------------------------------------------");
        // stream request--->stream response流模型
        StreamObserver<StreamRequest> requestStreamObserver = studentProtoServiceStub.biTalk(new StreamObserver<StreamResponse>() {
            @Override
            public void onNext(StreamResponse value) {
                System.out.println(value.getResponseInfo());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }
        });

        for(int i = 0; i < 10; ++i) {
            requestStreamObserver.onNext(StreamRequest.newBuilder().setRequestInfo(LocalDateTime.now().toString()).build());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
