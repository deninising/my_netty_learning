package com.dennis.netty.sixthexample;

import com.google.protobuf.InvalidProtocolBufferException;

public class MyDataInfoTest {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        MyDataInfo.Person student = MyDataInfo.Person.newBuilder().setName("张三").setAge(25).setAddress("通天大道").build();
        byte[] bytesSrc = student.toByteArray();
        MyDataInfo.Person ss = MyDataInfo.Person.parseFrom(bytesSrc);
        System.out.println(ss.getName() + ss.getAddress() + ss.getAge());
    }
}
