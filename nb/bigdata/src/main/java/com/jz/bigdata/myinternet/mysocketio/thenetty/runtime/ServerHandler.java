package com.jz.bigdata.myinternet.mysocketio.thenetty.runtime;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {

	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		RequestData request = (RequestData)msg;
		System.out.println("Server : " + request.getId() + ", " + request.getName() + ", " + request.getRequestMessage());
		ResponseData response = new ResponseData();
		response.setId(request.getId());
		response.setName("response" + request.getId());
		response.setResponseMessage("响应内容" + request.getId());
		ctx.writeAndFlush(response);//.addListener(ChannelFutureListener.CLOSE);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

	
	
}
