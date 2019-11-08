package com.jz.bigdata.myinternet.mynetty.demo;/**
 * Created by jazzyshi on 2019/10/22.
 */

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;


/**
 * @ClassName JZClient
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/10/22 16:39
 * @Version 1.0
 **/
public class JZClient {
    private final String host;
    private final int port;

    public JZClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try{
            //1.创建bootstrap
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress(host,port))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                                socketChannel.pipeline().addLast(new JZClientHandle());
                        }
                    });
            ChannelFuture f = b.connect().sync();
            f.channel().closeFuture().sync();
        }finally{
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new JZClient("127.0.0.1",20000).start();
    }
}
