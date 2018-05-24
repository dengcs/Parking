package com.parking.main;

import com.parking.protobuf.Base.NetMessage;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.AttributeKey;

public class ServerHandler extends ChannelInboundHandlerAdapter{	

	private final AttributeKey<ServerSession> SERVERSESSIONKEY = AttributeKey.valueOf("S_SESSION_KEY");
	
	
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
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		
		ServerSession session = new ServerSession();
		ctx.channel().attr(SERVERSESSIONKEY).set(session);
		session.setChannel(ctx.channel());
		session.onActive();
		
		super.channelActive(ctx);
	}	

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		
		ServerSession session = ctx.channel().attr(SERVERSESSIONKEY).get();
		session.onInActive();
		
		super.channelInactive(ctx);		
	}	
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		NetMessage netMsg = (NetMessage)msg;
		ServerSession session = ctx.channel().attr(SERVERSESSIONKEY).get();
		session.onMessage(netMsg);
	}
}
