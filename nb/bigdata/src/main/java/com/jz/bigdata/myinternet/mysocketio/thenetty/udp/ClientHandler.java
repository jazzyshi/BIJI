package com.jz.bigdata.myinternet.mysocketio.thenetty.udp;/**
 * Created by jazzyshi on 2019/11/8.
 */

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

/**
 * @ClassName ClientHandler
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/11/8 10:17
 * @Version 1.0
 **/
public class ClientHandler extends SimpleChannelInboundHandler<DatagramPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket datagramPacket) throws Exception {
        System.out.println("fohfohwqofhn");
       String response = datagramPacket.content().toString(CharsetUtil.UTF_8);
       if(response.startsWith("谚语查询结果：")){
           System.out.println(response);
           ctx.close();
       }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
