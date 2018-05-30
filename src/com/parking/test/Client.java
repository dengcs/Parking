package com.parking.test;

import com.parking.protobuf.Base.NetMessage;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class Client {

	public static void main(String[] args) throws InterruptedException {
		EventLoopGroup group = new NioEventLoopGroup();
		try {
				Bootstrap b = new Bootstrap();
				b.group(group)
				.channel(NioSocketChannel.class)
	            .handler(new LoggingHandler(LogLevel.INFO))
				.handler(new ChannelInitializer<SocketChannel>() {
				    @Override
				    public void initChannel(SocketChannel ch) throws Exception {
				   	 ChannelPipeline p = ch.pipeline();
				   	 p.addLast(new ProtobufVarint32FrameDecoder());
				   	 p.addLast(new ProtobufDecoder(NetMessage.getDefaultInstance()));
				   	 p.addLast(new ClientHandler());
				   	 p.addLast(new ProtobufVarint32LengthFieldPrepender());
				   	 p.addLast(new ProtobufEncoder());
				    }
				});
				
				ChannelFuture f = b.connect("127.0.0.1", 9983).sync();			
				f.channel().closeFuture().sync();
			} finally {
				group.shutdownGracefully();
			}
		}

}
