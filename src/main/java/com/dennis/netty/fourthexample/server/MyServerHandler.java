package com.dennis.netty.fourthexample.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

public class MyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            String eventType = null;
            switch (event.state()) {
                case READER_IDLE:
                    eventType = "读超时";
                    break;
                case WRITER_IDLE:
                    eventType = "写超时";
                    break;
                case ALL_IDLE:
                    eventType = "读写超时";
                    break;
            }
            System.out.println(ctx.channel().remoteAddress() + "超时事件： " + eventType);
            ctx.channel().close();
        }

    }
}
