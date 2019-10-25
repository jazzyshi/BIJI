package com.jz.bigdata.myinternet.mynetty;/**
 * Created by jazzyshi on 2019/10/22.
 */

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @ClassName JZClientHandle
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/10/22 16:25
 * @Version 1.0
 **/
@ChannelHandler.Sharable//可以被多个Channel共享
public class JZClientHandle extends SimpleChannelInboundHandler<ByteBuf> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf in) throws Exception {
        //记录已接收消息的转储
        System.out.println("客户端收到："+in.toString(CharsetUtil.UTF_8));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //当被通知Channel是活跃的时候，发送一条消息(将在一个连接被建立时调用)
        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rockes!",CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //在发生异常的时候，记录错误并关闭Channel
        System.out.println("--------------");
        cause.printStackTrace();
        System.out.println("--------------");
        ctx.close();
    }
}
