package com.dennis.nio;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class NioTest10 {
    public static void main(String[] args) throws Exception {
        RandomAccessFile rwFile = new RandomAccessFile("NioTest10.txt", "rw");
        FileChannel channel = rwFile.getChannel();
        FileLock lock = channel.lock(3, 10, true);

        System.out.println("valid: " + lock.isValid());
        System.out.println("lock type: " + lock.isShared());

        lock.release();

        channel.close();


    }
}
