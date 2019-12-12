package com.dennis.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

public class NioTest01 {
    public static void main(String[] args) {

        IntBuffer intBuffer = IntBuffer.allocate(10);

        for (int i = 0; i < intBuffer.capacity()-5; i++) {
            int i1 = new SecureRandom().nextInt(200);
            intBuffer.put(i1);
        }

        intBuffer.flip();
        System.out.println(intBuffer.position());
        System.out.println(intBuffer.limit());
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.position());
            System.out.println(intBuffer.limit());
            System.out.println(intBuffer.get());
            System.out.println("+++++++++++++++++++++++++++++++++++");
        }


        System.out.println("--------------------------");
        intBuffer.flip();
//        intBuffer.clear();
        System.out.println(intBuffer.position());
        System.out.println(intBuffer.limit());
    }
}
