package com.jz.bigdata.myinternet.mynetty.liaotianshi;/**
 * Created by jazzyshi on 2019/10/25.
 */

import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.stream.ChunkedNioFile;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.URL;

/**
 * @ClassName HttpRequestHandle
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/10/25 10:13
 * @Version 1.0
 **/
public class HttpRequestHandle extends SimpleChannelInboundHandler<FullHttpRequest> {//扩展SimpleChannelInboundHandler来处理FullHttpRequest
    private final String wsUri;
    private static final File INDEX;

    static{
        URL location = HttpRequestHandle.class.getProtectionDomain().getCodeSource().getLocation();
        System.out.println(location);


            //String path = location.toURI() + "index.html";
            String path = System.getProperty("user.dir")+ "/index.html";
            path = path.contains("file:") ? path.substring(5):path;
            INDEX = new File(path);


    }
    public HttpRequestHandle(String wsUri){this.wsUri = wsUri;}
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        //1.如果请求了WebSocket协议升级，则增加引用计算（调用retain()方法），并将他传递给下一个ChannelInboundHandler
        if(wsUri.equalsIgnoreCase(request.getUri())){
            ctx.fireChannelRead(request.retain());
        }else{
            //2.处理100 continue请求以符合HTTP1.1规范
            if(HttpHeaders.is100ContinueExpected(request)){
                send100Continue(ctx);
            }

            //读取index.html
            RandomAccessFile file = new RandomAccessFile(INDEX,"r");
            HttpResponse response = new DefaultHttpResponse(request.getProtocolVersion(), HttpResponseStatus.OK);
            response.headers().set(HttpHeaders.Names.CONTENT_TYPE,"text/plain; charset=UTF-8");
            boolean keepAlive = HttpHeaders.isKeepAlive(request);
            if(keepAlive){//如果请求了keep-alive,则添加所需要的HTTP头信息
                response.headers().set(HttpHeaders.Names.CONTENT_LENGTH,file.length());
                response.headers().set(HttpHeaders.Names.CONNECTION,HttpHeaders.Values.KEEP_ALIVE);
            }
            //3.将HttpRequese写到客户端
            ctx.write(response);
            //4.将index.html写到客户端
            if(ctx.pipeline().get(SslHandler.class) == null){
                ctx.write(new DefaultFileRegion(file.getChannel(),0,file.length()));
            }else{
                ctx.write(new ChunkedNioFile(file.getChannel()));
            }
            //5.写LastHttpContent并冲涮至客户端
            ChannelFuture future = ctx.writeAndFlush(LastHttpContent.EMPTY_LAST_CONTENT);
            //6.如果没有请求keep-alive,则在写操作完成后关闭channel
            if(!keepAlive){
                future.addListener(ChannelFutureListener.CLOSE);
            }

        }
    }

    private static void send100Continue(ChannelHandlerContext ctx) {
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,HttpResponseStatus.CONTINUE);
        ctx.writeAndFlush(response);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
