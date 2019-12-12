package com.dennis.nio;

import javax.xml.crypto.KeySelector;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NioClient {
    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        Selector selector = Selector.open();

        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        socketChannel.connect(new InetSocketAddress("localhost", 9901));


        while (true) {
            selector.select();
            Set<SelectionKey> keySet = selector.selectedKeys();

            for (SelectionKey selectionKey : keySet) {
                if (selectionKey.isConnectable()) {
                    SocketChannel client = (SocketChannel) selectionKey.channel();
                    if (client.isConnectionPending()) {

                        client.finishConnect();

                        ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                        writeBuffer.put((LocalDate.now() + "：连接成功!").getBytes());
                        writeBuffer.flip();


                        client.write(writeBuffer);


                        // 本地开一个输入线程
                        ExecutorService executorService = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                        executorService.submit(() -> {
                            while (true) {
                                writeBuffer.clear();
                                InputStreamReader inputStream = new InputStreamReader(System.in);
                                BufferedReader br = new BufferedReader(inputStream);

                                String message = br.readLine();

                                writeBuffer.put(message.getBytes());
                                writeBuffer.flip();
                                client.write(writeBuffer);
                            }
                        });
                    }


                    client.register(selector, SelectionKey.OP_READ);

                } else if (selectionKey.isReadable()) {
                    SocketChannel client = (SocketChannel) selectionKey.channel();

                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);


                    int count = client.read(readBuffer);


                    if (count > 0) {
                        String receivedMessage = new String(readBuffer.array(), 0, count);
                        System.out.println(receivedMessage);
                    }
                }
            }
            keySet.clear();
        }
    }
}
