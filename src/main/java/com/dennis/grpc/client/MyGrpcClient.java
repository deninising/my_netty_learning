package com.dennis.grpc.client;

import com.dennis.proto.GreetingServiceGrpc;
import com.dennis.proto.HelloRequest;
import com.dennis.proto.HelloResponse;
import com.dennis.proto.Sentiment;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class MyGrpcClient {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        GreetingServiceGrpc.GreetingServiceBlockingStub stub =
                GreetingServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.greeting(
                HelloRequest.newBuilder()
                        .setName("Ray")
                        .setAge(18)
                        .setSentiment(Sentiment.HAPPY)
                        .build());

        System.out.println(helloResponse);

        channel.shutdown();
    }
}
