package com.jz.bigdata.myinternet.mysocketio.thenetty.runtime;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class ClientHandler extends ChannelInboundHandlerAdapter {
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {

	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		try {
			ResponseData resp = (ResponseData)msg;
			System.out.println("Client : " + resp.getId() + ", " + resp.getName() + ", " + resp.getResponseMessage());			
		} finally {
			ReferenceCountUtil.release(msg);
		}
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
	}
	
}
