package com.parking.test;

import org.apache.log4j.Logger;

import com.parking.protobuf.Base.NetError;
import com.parking.protobuf.Base.NetHeader;
import com.parking.protobuf.Base.NetMessage;
import com.parking.protobuf.Login.Req_Login_LoginIn;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class ClientHandler extends SimpleChannelInboundHandler<NetMessage> {

	private static final Logger log = Logger.getLogger(ClientHandler.class);
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		
		Channel ch = ctx.channel();
		
		NetMessage.Builder bdMessage = NetMessage.newBuilder();
		NetError.Builder bdError =  NetError.newBuilder();
		NetHeader.Builder bdHeader =  NetHeader.newBuilder();
		
		Req_Login_LoginIn.Builder bdLoginIn = Req_Login_LoginIn.newBuilder();
		bdLoginIn.setAccount("dengcs");
		bdLoginIn.setPassword("12345678");
		
		bdError.setCode(0);
		
		bdHeader.setUid(1001);
		bdHeader.setProto("Req_Login_LoginIn");
		
		bdMessage.setError(bdError);
		bdMessage.setHeader(bdHeader);
		bdMessage.setPayload(bdLoginIn.build().toByteString());
		
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
		log.debug(msg.toString());
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if (evt instanceof IdleStateEvent) {

			IdleStateEvent event = (IdleStateEvent) evt;
			
			if (event.state().equals(IdleState.READER_IDLE)) {
				//未进行读操作
				log.debug("READER_IDLE");
			} else if (event.state().equals(IdleState.WRITER_IDLE)) {
				log.debug("WRITER_IDLE");
			} else if (event.state().equals(IdleState.ALL_IDLE)) {
				//未进行读写
				log.debug("ALL_IDLE");
			}

		}
		
		super.userEventTriggered(ctx, evt);
	}
}
