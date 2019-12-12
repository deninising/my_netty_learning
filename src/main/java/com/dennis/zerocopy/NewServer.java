package com.dennis.zerocopy;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NewServer {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket socket = serverSocketChannel.socket();
        socket.setReuseAddress(true);
        socket.bind(new InetSocketAddress(9901));

        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(true);

            int readCount = 0;
            while (readCount != -1) {
                readCount = socketChannel.read(byteBuffer);
                System.out.println("成功读取到数据：" + readCount);

                byteBuffer.rewind();
            }


        }
    }
}
