package com.dennis.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest02 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("NioTest02.txt");

        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        int read = channel.read(byteBuffer);
        System.out.println("+++++++++++++++++++++(read......)++++++++++++++++++++++++++++");
        System.out.println("position:" + byteBuffer.position());
        System.out.println("limit:" + byteBuffer.limit());
        System.out.println("the file byte length:" + read);
        System.out.println("+++++++++++++++++++++(flip......)++++++++++++++++++++++++++++");

        byteBuffer.flip();
        System.out.println("position:" + byteBuffer.position());
        System.out.println("limit:" + byteBuffer.limit());
        System.out.println("+++++++++++++++++++++(writ......)++++++++++++++++++++++++++++");


        while (byteBuffer.remaining() > 0) {
            System.out.println("position:" + byteBuffer.position());
            System.out.println("limit:" + byteBuffer.limit());
            byte b = byteBuffer.get();
            System.out.println("charactor:" + (char) b);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        }

        fileInputStream.close();
    }
}
