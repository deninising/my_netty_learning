package com.dennis.zerocopy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class OldServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9901);
        while (true) {
            Socket socket = serverSocket.accept();
            // 可以接受二进制数据
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            byte[] byteArray = new byte[4096];

            while (true) {
                int readNum = dataInputStream.read(byteArray, 0, byteArray.length);
                if (readNum == -1) {
                    System.out.println("数据已经读取完毕");
                    break;
                }
            }
        }
    }
}
