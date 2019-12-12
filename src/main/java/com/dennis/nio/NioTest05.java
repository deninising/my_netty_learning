package com.dennis.nio;

import java.nio.Buffer;
import java.nio.ByteBuffer;
/**
 * ByteBuffer类型化的put与get方法
 */
public class NioTest05 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(512);
        buffer.putInt(32);
        buffer.putChar('你');
        buffer.putDouble(555.02);

        buffer.flip();

        System.out.println(buffer.getInt());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getDouble());
    }
}
