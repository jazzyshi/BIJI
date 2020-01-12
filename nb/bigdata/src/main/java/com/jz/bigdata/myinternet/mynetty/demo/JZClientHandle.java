package com.jz.bigdata.myinternet.mynetty.demo;/**
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
    /**
     * 当从服务器接收到一条消息的时候调用
     * @param channelHandlerContext
     * @param in
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf in) throws Exception {
        //记录已接收消息的转储
        System.out.println("客户端收到："+in.toString(CharsetUtil.UTF_8));
    }

    /**
     * 将在到服务器连接被建立后调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
            //当被通知Channel是活跃的时候，发送一条消息
            double a = Math.random();
            ctx.writeAndFlush(Unpooled.copiedBuffer(a+ "Netty rockes!",CharsetUtil.UTF_8));
    }

    /**
     * 在处理过程中引发异常时调用
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //在发生异常的时候，记录错误并关闭Channel
        System.out.println("--------------");
        cause.printStackTrace();
        System.out.println("--------------");
        ctx.close();
    }
}
