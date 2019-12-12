package com.dennis.nio;

import java.nio.ByteBuffer;

/**
 * Slice Buffer与原有buffer共享相同的底层数组
 */
public class NioTest06 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(512);
        for (int i = 0; i < 10; i++) {
            buffer.put((byte) i);
        }

        buffer.position(3);
        buffer.limit(7);

        ByteBuffer sliceBuffer = buffer.slice();
        for (int i = 0; i < sliceBuffer.capacity(); i++) {
            byte b = sliceBuffer.get(i);
            b *= 2;
            sliceBuffer.put(i, b);
            System.out.println(sliceBuffer.get(i));
        }

        buffer.clear();
        for (int i = 0; i < 10; i++) {
            System.out.println(buffer.get(i));
        }
    }
}
