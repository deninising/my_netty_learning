package com.dennis.zerocopy;

import io.grpc.ClientStreamTracer;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;

public class OldClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 9901);
        String fileName = "C:\\Users\\deninis\\Desktop\\java_pid13360.hprof";
        FileInputStream fileInputStream = new FileInputStream(fileName);
        byte[] byteArray = new byte[4096];
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        int readCount;
        Long readTotal = 0L;

        long startTime = System.currentTimeMillis();
        while ((readCount = fileInputStream.read(byteArray)) != -1) {
            readTotal += readCount;
            System.out.println("本次读取数据大小：" + readCount);
            dataOutputStream.write(byteArray);
        }

        System.out.println("发送总字节数：" + readTotal + "耗时：" + (System.currentTimeMillis() - startTime));
        dataOutputStream.close();
        fileInputStream.close();
        socket.close();
    }
}
