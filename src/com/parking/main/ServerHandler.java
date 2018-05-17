package com.parking.main;

import com.parking.protobuf.Base.NetMessage;

import com.parking.protobuf.Awesome.AwesomeMessage;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ServerHandler extends SimpleChannelInboundHandler<NetMessage>{

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, NetMessage msg) throws Exception {
		String protoName = msg.getHeader().getProto();
		String msgString = msg.toByteString().toString();
		System.out.println(protoName);
		System.out.println(msgString);
		
		AwesomeMessage bdAwesome = AwesomeMessage.parseFrom(msg.getPayload());
		
		System.out.println(bdAwesome.getAwesomeField());
	}

}
