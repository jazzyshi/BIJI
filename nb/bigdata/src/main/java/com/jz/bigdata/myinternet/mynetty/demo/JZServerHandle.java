package com.jz.bigdata.myinternet.mynetty.demo;/**
 * Created by jazzyshi on 2019/10/22.
 */

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

/**
 * @ClassName JZServerHandle
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/10/22 15:28
 * @Version 1.0
 **/
@ChannelHandler.Sharable//标示一个Channel-Handler可以被多个Channel安全的共享
public class JZServerHandle extends ChannelInboundHandlerAdapter {

    /**
     *
     * @param ctx ChannelHandlerContext代表了ChannelHandler和ChannelPipeline之间的绑定
     *            主要作用是用来写出战数据
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        //将消息记录到控制台
        System.out.println("服务端收到消息："+in.toString(Charset.defaultCharset()));
        //将接收到的消息写给发送者，而不冲刷出站消息。
        //write操作是异步的,channelRead返回后可能仍然没有完成。ChannelInboundHandlerAdapter在这个时间点上不会释放消息
        // ，而SimpleChannelInboundHandler中channelRead0这个方法会释放消息
        ctx.write(in);
    }

    /**
     * 当writeAndFlush被调用时消息释放
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //将未决消息冲涮到远程节点，并且关闭该Channel
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
           .addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();//打印异常栈跟踪
        ctx.close();//关闭改channel
    }
}
