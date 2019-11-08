package com.jz.bigdata.myinternet.mysocketio.thenetty.udp;/**
 * Created by jazzyshi on 2019/11/8.
 */

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

/**
 * @ClassName Server
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/11/8 9:55
 * @Version 1.0
 **/
public class Server {
    public void run(int port) throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();
        try{
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST,true)
                    .handler(new ServerHandler());
            ChannelFuture f = b.bind(port).sync();
            f.channel().closeFuture().await();

        }finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new Server().run(9113);
    }
}
