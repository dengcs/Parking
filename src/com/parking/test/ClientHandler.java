package com.parking.test;

import com.parking.protobuf.Awesome.AwesomeMessage;
import com.parking.protobuf.Base.NetError;
import com.parking.protobuf.Base.NetHeader;
import com.parking.protobuf.Base.NetMessage;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class ClientHandler extends SimpleChannelInboundHandler<NetMessage> {

	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		
		Channel ch = ctx.channel();
		
		NetMessage.Builder bdMessage = NetMessage.newBuilder();
		NetError.Builder bdError =  NetError.newBuilder();
		NetHeader.Builder bdHeader =  NetHeader.newBuilder();
		
		AwesomeMessage.Builder bdAwesome = AwesomeMessage.newBuilder();
		bdAwesome.setAwesomeField("dcs---client");
		
		bdError.setCode(0);
		
		bdHeader.setUid(1001);
		bdHeader.setProto("AwesomeMessage");
		
		bdMessage.setError(bdError);
		bdMessage.setHeader(bdHeader);
		bdMessage.setPayload(bdAwesome.build().toByteString());
		
		ch.writeAndFlush(bdMessage.build());
		
		super.channelActive(ctx);
	}
	
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
		System.out.println(msg.toString());
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
