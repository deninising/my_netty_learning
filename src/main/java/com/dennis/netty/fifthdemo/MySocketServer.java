package com.dennis.netty.fifthdemo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class MySocketServer {
    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup bossEventGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerEventGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap
                    .group(bossEventGroup, workerEventGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.WARN))
                    .childHandler(new MySocketInitializer());
            ChannelFuture channelFuture = serverBootstrap.bind(9901).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossEventGroup.shutdownGracefully();
            workerEventGroup.shutdownGracefully();
        }

    }
}
