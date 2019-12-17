package com.dennis.netty.seconddemo.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class MyServer {
    public static void main(String[] args) throws InterruptedException {
        // 死循环（等待下一个事件发生的死循环）： 可供被选择种channel（可理解为服务端与客户端之间的一个连接）注册到group中
        // 根据本机cpu核心数，初始化eventLoopGroup对象的一些属性参数(线程数：cpu核心数*2，但通常自定义为1 new NioEventLoopGroup(1))
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // 服务器的启动类：（helper class 辅助类）用于简化服务器端创建工作的对象
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            // 属性赋值：
            serverBootstrap
                    // bossGroup赋值给AbstractBootstrap.group
                    // workerGroup赋值给ServerBootstrap.childGroup
                    .group(bossGroup, workerGroup)
                    // NioServerSocketChannel.class赋值给ReflectiveChannelFactory.clazz
                    // ReflectiveChannelFactory的一个实例赋值给AbstractBootstrap.channelFactory
                    .channel(NioServerSocketChannel.class)
                    // 设置bossGroup会用到的handler:AbstractBootstrap.handler
                    .handler(new LoggingHandler(LogLevel.WARN))
                    // 设置workerGroup会用到的childHandler:ServerBootstrap.childHandler
                    .childHandler(new MyInitializer());

            // 创建一个新channel并给该channel绑定一个端口：9901
            // sync()同步调用，即服务器将阻塞在当前位置，一直等待客户端的连接请求（Waits for this future until it is done, and rethrows the cause of the failure if this future failed.）
            ChannelFuture channelFuture = serverBootstrap.bind(9901).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
