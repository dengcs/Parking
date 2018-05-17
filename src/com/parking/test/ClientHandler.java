package com.parking.test;

import com.parking.protobuf.Base.NetMessage;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ClientHandler extends SimpleChannelInboundHandler<NetMessage> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, NetMessage msg) throws Exception {
		
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		super.channelRead(ctx, msg);
	}

}
