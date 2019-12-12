package com.dennis.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest03 {
    public static void main(String[] args) throws IOException {
        FileOutputStream outputStream = new FileOutputStream("NioTest03.txt");
        FileChannel outputStreamChannel = outputStream.getChannel();
        byte[] stringByte = "hello word i am coming".getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        for (int i = 0; i < stringByte.length; i++) {
            byteBuffer.put(stringByte[i]);
        }
        byteBuffer.flip();
        outputStreamChannel.write(byteBuffer);
        outputStream.close();
    }

}
