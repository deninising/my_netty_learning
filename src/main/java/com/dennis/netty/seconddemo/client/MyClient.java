package com.dennis.netty.seconddemo.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class MyClient {
    public static void main(String[] args) throws Exception{
        // 客户端只有一个事件循环组：向客户端建立一个连接，并把信息发给服务端，不存在像服务端一样，要接受连接，处理请求，响应消息那么复杂
        // 所以只有一个循环组，而服务端一个循环组（bossGroup）用于接收连接，然后转发给另一个循环组(workerGroup)用户处理和响应
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        try {
            // 客户端辅助类
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).
                    handler(new MyClientInitializer());
            // 指定服务端的连接信息
            ChannelFuture channelFuture = bootstrap.connect("localhost", 9901).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
