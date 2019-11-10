package com.jz.bigdata.myinternet.mysocketio.thenetty.http;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;

import static io.netty.handler.codec.http.HttpHeaders.Values.KEEP_ALIVE;
import static io.netty.handler.codec.http.HttpResponseStatus.*;
import static io.netty.handler.codec.http.HttpVersion.*;
import static io.netty.handler.codec.rtsp.RtspHeaders.Names.CONNECTION;
import static io.netty.handler.codec.rtsp.RtspHeaders.Names.CONTENT_TYPE;
import static org.apache.http.HttpHeaders.CONTENT_LENGTH;


public class HttpHelloWorldServerHandler extends ChannelInboundHandlerAdapter{
      private static final byte[] CONTENT = { 'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd' };
  
      @Override
      public void channelReadComplete(ChannelHandlerContext ctx) {
          ctx.flush();
      }
  
      @Override
      public void channelRead(ChannelHandlerContext ctx, Object msg) {
          if (msg instanceof HttpRequest) {
              HttpRequest req = (HttpRequest) msg;
  
              if (HttpHeaders.is100ContinueExpected(req)) {
                  ctx.write(new DefaultFullHttpResponse(HTTP_1_1, CONTINUE));
              }
              boolean keepAlive = HttpHeaders.isKeepAlive(req);
              FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(CONTENT));
              response.headers().set(CONTENT_TYPE, "text/plain");
              response.headers().set(CONTENT_LENGTH, response.content().readableBytes());
  
              if (!keepAlive) {
                  ctx.write(response).addListener(ChannelFutureListener.CLOSE);
              } else {
                  response.headers().set(CONNECTION, KEEP_ALIVE);
                  ctx.write(response);
              }
          }
      }
  
      @Override
      public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
          cause.printStackTrace();
          ctx.close();
      }
  }