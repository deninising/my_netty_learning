package com.dennis.netty.sixthexample.client;

import com.dennis.netty.sixthexample.MyDataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.Person> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.Person msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        MyDataInfo.Person person = MyDataInfo.Person.newBuilder().setName("张三").setAddress("通天河").setAge(55).build();
        ctx.channel().writeAndFlush(person);
    }
}
