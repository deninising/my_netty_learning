package com.dennis.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest04 {
    public static void main(String[] args) throws Exception {
        FileOutputStream outputStream = new FileOutputStream("output.txt");
        FileInputStream inputStream = new FileInputStream("input.txt");

        FileChannel outChannel = outputStream.getChannel();
        FileChannel inChannel = inputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        while (true) {
            byteBuffer.clear();
            int read = inChannel.read(byteBuffer);
            if (read == -1) {
                break;
            }
            byteBuffer.flip();
            outChannel.write(byteBuffer);
        }

        inChannel.close();
        outChannel.close();
    }
}
