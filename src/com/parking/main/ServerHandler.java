package com.parking.main;

import com.parking.protobuf.Base.NetMessage;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.AttributeKey;

public class ServerHandler extends SimpleChannelInboundHandler<NetMessage>{	

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
	protected void channelRead0(ChannelHandlerContext ctx, NetMessage msg) throws Exception {
		ServerSession session = ctx.channel().attr(SERVERSESSIONKEY).get();
		session.onMessage(msg);
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if (evt instanceof IdleStateEvent) {

			IdleStateEvent event = (IdleStateEvent) evt;
			
			if (event.state().equals(IdleState.READER_IDLE)) {
				//未进行读操作
				System.out.println("READER_IDLE");
			} else if (event.state().equals(IdleState.WRITER_IDLE)) {
				System.out.println("WRITER_IDLE");
			} else if (event.state().equals(IdleState.ALL_IDLE)) {
				//未进行读写
				System.out.println("ALL_IDLE");
			}

		}
		
		super.userEventTriggered(ctx, evt);
	}
}
