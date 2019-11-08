package com.jz.bigdata.myinternet.mysocketio.thenetty.udp;/**
 * Created by jazzyshi on 2019/11/8.
 */

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

/**
 * @ClassName Client
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/11/8 10:17
 * @Version 1.0
 **/
public class Client {

    public void run(int port) throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();
        try{
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST,true)
                    .handler(new ClientHandler());
            Channel ch = b.bind(0).sync().channel();
            //向内网段中的所有机器广播UDP消息
            ch.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer("cha", CharsetUtil.UTF_8),new InetSocketAddress("127.0.0.1",port))).sync();
            if(!ch.closeFuture().await(5000)){
                System.out.println("查询超时！");
            }
        }finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new Client().run(9113);
    }
}
