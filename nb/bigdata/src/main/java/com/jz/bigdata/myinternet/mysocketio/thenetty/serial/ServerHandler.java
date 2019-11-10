package com.jz.bigdata.myinternet.mysocketio.thenetty.serial;

import com.jz.bigdata.myinternet.mysocketio.thenetty.serial.common.GzipUtils;
import io.netty.channel.ChannelHandlerContext;

import java.io.File;
import java.io.FileOutputStream;

import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

public class ServerHandler extends SimpleChannelInboundHandler {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("服务端activ");
	}

	@Override
	public void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
		Req req = (Req)msg;
		System.out.println("Server : " + req.getId() + ", " + req.getName() + ", " + req.getRequestMessage());
		byte[] attachment = GzipUtils.ungzip(req.getAttachment());
		
		String path = System.getProperty("user.dir") + File.separatorChar + "receive" +  File.separatorChar + "00"+req.getId()+".jpg";
        FileOutputStream fos = new FileOutputStream(path);
        fos.write(attachment);
        fos.close();
		
		Resp resp = new Resp();
		resp.setId(req.getId());
		resp.setName("resp" + req.getId());
		resp.setResponseMessage("响应内容" + req.getId());
		ctx.writeAndFlush(resp);//.addListener(ChannelFutureListener.CLOSE);//加上这个客户端一次请求就关闭了 why
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		System.out.println("服务端读写完成");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

	
	
}
