package com.jz.bigdata.myinternet.mynetty;/**
 * Created by jazzyshi on 2019/10/21.
 */

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @ClassName JZServer
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/10/21 13:50
 * @Version 1.0
 **/
public class JZServer {

    private final int port;

    public JZServer(int port) {
        this.port = port;
    }

    public void start() throws Exception{
        final JZServerHandle serverHandle = new JZServerHandle();
        //1.创建EventLoopGroup
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            //2.创建ServerBootstrap
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
              .channel(NioServerSocketChannel.class)     //3.指定所使用的NIO传输
              .localAddress(new InetSocketAddress(port)) //4.使用指定的端口设置套接字地址
              .childHandler(new ChannelInitializer<SocketChannel>() {//5.添加一个JZServerHandle到子Channeld的ChannelPipeline
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(serverHandle);//JZServerHandle被标准为@shareable,所以我们总是可以使用同样的实列
                    }
              });
            //6.异步地绑定服务器，调用sync()方法阻塞等待直到绑定完成
            ChannelFuture f = b.bind().sync();
            //7.获取Channel的Closefuture,并阻塞当前线程直到它完成
            f.channel().closeFuture().sync();
        }finally {
            //8.关闭EventLoopGroup，释放所有资源
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws Exception {
        new JZServer(20000).start();
    }
}
