package com.dennis.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

public class NioTest11 {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(9901);
        serverSocketChannel.bind(inetSocketAddress);

        int maxLength = 2 + 3 + 4;
        ByteBuffer[] buffers = new ByteBuffer[3];
        buffers[0] = ByteBuffer.allocate(2);
        buffers[1] = ByteBuffer.allocate(3);
        buffers[2] = ByteBuffer.allocate(4);

        SocketChannel socketChannel = serverSocketChannel.accept();

        while (true) {
            int readLength = 0;
            while (readLength < maxLength) {
                socketChannel.read(buffers);
                readLength++;

                System.out.println("readLength:" + readLength);
                Arrays.asList(buffers).stream().map(buffer -> "position:" + buffer.position() + ",limit:"
                        + buffer.limit()
                ).forEach(System.out::println);
            }

            Arrays.asList(buffers).forEach(buffer -> {
                buffer.clear();
            });

            int writeLength = 0;
            while (writeLength < maxLength) {
                socketChannel.write(buffers);
                writeLength++;
            }


            Arrays.asList(buffers).forEach(buffer -> {
                buffer.clear();
            });

            System.out.println("readLength: " + readLength + ", writeLength: " + writeLength + ", maxLength: " + maxLength);

        }

    }
}
