package com.dennis.netty.firstdemo;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

// ChannelInitializer通道初始化器指定对SocketChannel类型的通道进行初始化处理
public class MyFirstInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        // 设置编解码器
        pipeline.addLast("HttpServerCodec", new HttpServerCodec());
        // 设置处理器
        pipeline.addLast("MyFirstHandler", new MyFirstHandler());
    }
}
