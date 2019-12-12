package com.dennis.netty.firstdemo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class FirstServerDemo {
    public static void main(String[] args) throws InterruptedException {
        // 事件循环组 boss只管分发： 接受客户端的连接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 事件循环组  worker做具体操作：连接内容的处理、计算、响应
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            // 服务器的启动类：（helper class 辅助类）用于简化服务器端创建工作的对象
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap
                    // 配置循环组
                    .group(bossGroup, workerGroup)
                    // NioServerSocketChannel 对 java nio中ServerSocketChannel的一个封装类
                    .channel(NioServerSocketChannel.class)
                    // Handler-->bossGroup    ChildHandler-->workerGroup
                    .childHandler(new MyFirstInitializer());
            // 设置监听端口并调用sync方法进行等待和同步（阻塞方法）
            // channelFuture对Java Future类进行了完善（重点学习）
            ChannelFuture channelFuture = serverBootstrap.bind(9901).sync();
            // netty的关闭操作
            channelFuture.channel().closeFuture().sync();
        } finally {
            // netty的优雅关闭：针对线程中的连接进行妥善处理
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
