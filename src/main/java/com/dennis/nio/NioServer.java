package com.dennis.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class NioServer {
    private static Map<String, SocketChannel> clientMap = new HashMap();

    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(9901));

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {

            int selectEventNum = selector.select();
            System.out.println("客户端发起事件数量：" + selectEventNum);

            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            selectionKeys.forEach(selectionKey -> {
                final SocketChannel client;
                try {
                    if (selectionKey.isAcceptable()) {
                        ServerSocketChannel serverChannel = (ServerSocketChannel) selectionKey.channel();
                        client = serverChannel.accept();
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_READ);

                        String key = "【" + UUID.randomUUID().toString() + "】";
                        // 将当前客户端创建的tcp长连接存入map中
                        clientMap.put(key, client);
                    } else if (selectionKey.isReadable()) {
                        client = (SocketChannel) selectionKey.channel();
                        ByteBuffer readBuffer = ByteBuffer.allocate(1024);

                        int count = client.read(readBuffer);

                        if (count > 0) {
                            readBuffer.flip();

                            Charset charset = Charset.forName("utf-8");
                            String receivedMessage = String.valueOf(charset.decode(readBuffer).array());

                            System.out.println(client + ": " + receivedMessage);

                            String senderKey = null;

                            for (Map.Entry<String, SocketChannel> entry : clientMap.entrySet()) {
                                if (client == entry.getValue()) {
                                    senderKey = entry.getKey();
                                    break;
                                }
                            }
                            // 将获取的信息发给其他所有客户端
                            for (Map.Entry<String, SocketChannel> entry : clientMap.entrySet()) {
                                SocketChannel value = entry.getValue();

                                ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

                                writeBuffer.put((senderKey + ": " + receivedMessage).getBytes());
                                writeBuffer.flip();

                                value.write(writeBuffer);
                            }
                        }

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            selectionKeys.clear();
        }

    }
}
