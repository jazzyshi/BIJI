package com.jz.bigdata.myinternet.mynetty.liaotianshi;/**
 * Created by jazzyshi on 2019/10/25.
 */

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.ImmediateEventExecutor;

import java.net.InetSocketAddress;

/**
 * @ClassName ChatServer
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/10/25 15:50
 * @Version 1.0
 **/
public class ChatServer {

    //创建DefaultChannelGroup,其将保存所有已经连接的WebSocket Channel
    private final ChannelGroup channelGroup = new DefaultChannelGroup(ImmediateEventExecutor.INSTANCE);

    private final EventLoopGroup group = new NioEventLoopGroup();

    private Channel channel;

    public ChannelFuture start(InetSocketAddress address){
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(group)
                 .channel(NioServerSocketChannel.class)
                 .childHandler(createInitializer(channelGroup));

        ChannelFuture future = bootstrap.bind(address);
        future.syncUninterruptibly();
        channel = future.channel();
        return future;
    }

    protected ChannelInitializer<Channel> createInitializer(ChannelGroup group){
        return new ChatServerInitializer(group);
    }

    public void destroy(){
        if(channel != null){
            channel.close();
        }
        channelGroup.close();
        group.shutdownGracefully();
    }

    public static void main(String[] args) {
        final ChatServer endPoint = new ChatServer();
        ChannelFuture future = endPoint.start(new InetSocketAddress(20000));
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                endPoint.destroy();
            }
        });
        future.channel().closeFuture().syncUninterruptibly();
    }
}
