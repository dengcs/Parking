package com.parking.test;

import com.parking.protobuf.Base.NetError;
import com.parking.protobuf.Base.NetHeader;
import com.parking.protobuf.Base.NetMessage;

import com.parking.protobuf.Awesome.AwesomeMessage;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
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

public class Client {

	public static void main(String[] args) throws InterruptedException {
		EventLoopGroup group = new NioEventLoopGroup();
		try {
				Bootstrap b = new Bootstrap();
				b.group(group)
				.channel(NioSocketChannel.class)
				.handler(new ChannelInitializer<SocketChannel>() {
				    @Override
				    public void initChannel(SocketChannel ch) throws Exception {
				   	 ChannelPipeline p = ch.pipeline();
				   	 p.addLast(new ProtobufVarint32FrameDecoder());
				   	 p.addLast(new ProtobufDecoder(NetMessage.getDefaultInstance()));
				   	 p.addLast(new ProtobufVarint32LengthFieldPrepender());
				   	 p.addLast(new ProtobufEncoder());
				     p.addLast(new ClientHandler());
				    }
				});
				// Make a new connection.
				Channel ch = b.connect("127.0.0.1", 9981).sync().channel();
				
				NetMessage.Builder bdMessage = NetMessage.newBuilder();
				NetError.Builder bdError =  NetError.newBuilder();
				NetHeader.Builder bdHeader =  NetHeader.newBuilder();
				
				AwesomeMessage.Builder bdAwesome = AwesomeMessage.newBuilder();
				bdAwesome.setAwesomeField("dcs---test");
				
				bdError.setCode(0);
				
				bdHeader.setUid(1001);
				bdHeader.setProto("AwesomeMessage");
				
				bdMessage.setError(bdError);
				bdMessage.setHeader(bdHeader);
				bdMessage.setPayload(bdAwesome.build().toByteString());
				
				for(int i=0;i<10;i++)
				{
					ch.writeAndFlush(bdMessage.build());
				}
				
				// Close the connection.
				ch.close();
			// Print the response at last but not least.
			} finally {
				group.shutdownGracefully();
			}
		}

}
