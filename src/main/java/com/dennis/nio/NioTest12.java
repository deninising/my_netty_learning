package com.dennis.nio;

import io.grpc.internal.ReadableBuffer;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NioTest12 {
    public static void main(String[] args) throws Exception {
        // 初始化端口信息
        int[] ports = new int[5];
        ports[0] = 5001;
        ports[1] = 5002;
        ports[2] = 5003;
        ports[3] = 5004;
        ports[4] = 5005;

        // 通过抽象类创建（WindowsSelectorImpl）selector对象:选择器
        Selector selector = Selector.open();
        // 开启五个端口的监听功能：五个端口同时监听客户端的事件
        for (int i = 0; i < ports.length; i++) {
            // 获取信道对象：serverSocketChannel
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // 设置信道为非阻塞状态
            serverSocketChannel.configureBlocking(false);
            // 创建服务器端套接字对象
            ServerSocket serverSocket = serverSocketChannel.socket();
            // 套接字对象指定端口属性
            serverSocket.bind(new InetSocketAddress(ports[i]));
            // 将信道注册到选择器selector上，并‘监听’ACCEPTION事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("监听端口：" + ports[i] + "......");
        }

        while (true) {
            /**
             *  Selects a set of keys whose corresponding channels are ready for I/O
             * operations.
             */
            int keyCountNum = selector.select();
            System.out.println("keyCount:" + keyCountNum);
            /**
             * Returns this selector's selected-key set.
             *
             * <p> Keys may be removed from, but not directly added to, the
             * selected-key set.  Any attempt to add an object to the key set will
             * cause an {@link UnsupportedOperationException} to be thrown.
             *
             * <p> The selected-key set is <a href="#ksc">not thread-safe</a>. </p>
             */
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("selectKeys:" + selectionKeys);

            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()) {
                // 获取到key对象
                SelectionKey selectionKey = iterator.next();
                // 判断selectKey的具体类型
                if (selectionKey.isAcceptable()) {
                    // 获取包含Acception事件的信道对象
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                    // 获取具体的信道:接受连接事件的信道
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    // 非阻塞设置
                    socketChannel.configureBlocking(false);
                    // 获取到一个客户端连接（建立tcp成功），则就对该客户端注册一个监听读事件的信道到选择器中，以供客户端发送信息个体服务端
                    socketChannel.register(selector, SelectionKey.OP_READ);

                    // 完成一个对客户端事件的捕获和处理后，一定要执行对应的remove()方法：从set中剔除事件元素
                    /**
                     * Removes from the underlying collection the last element returned
                     * by this iterator (optional operation).  This method can be called
                     * only once per call to {@link #next}.
                     */
                    iterator.remove();

                    System.out.println("获得客户端连接： " + socketChannel);
                } else if (selectionKey.isReadable()) {
                    // 获取包含读事件的socketChannel对象
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    int byteRead = 0;
                    while (true) {
                        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                        readBuffer.clear();
                        // 单次读到的字节数
                        int read = socketChannel.read(readBuffer);

                        if (read < 1) {
                            break;
                        }
                        readBuffer.flip();
                        // 将单次读取的数据又写回客户端:channel对象既可以读又可以写，体现双工特性
                        socketChannel.write(readBuffer);
                        byteRead += read;
                    }

                    System.out.println("读取： " + byteRead + "，来自于： " + socketChannel);

                    // 完成一个对客户端事件的捕获和处理后，一定要执行对应的remove()方法：从set中剔除事件元素
                    /**
                     * Removes from the underlying collection the last element returned
                     * by this iterator (optional operation).  This method can be called
                     * only once per call to {@link #next}.
                     */
                    iterator.remove();
                }
            }
        }
    }
}
