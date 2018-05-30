package com.parking.main;

import org.apache.log4j.Logger;

import com.google.protobuf.ByteString;
import com.parking.manage.HandleManager;
import com.parking.protobuf.Base.NetMessage;

import io.netty.channel.Channel;

public class ServerSession {
	
	private Channel channel = null;
	
	private HandleManager handleManager = null;
	
	private static final Logger log = Logger.getLogger(ServerSession.class);

	
	public ServerSession()
	{
		handleManager = new HandleManager();
	}	

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
		
		this.handleManager.setChannel(channel);
	}

	//创建连接
	public void onActive()
	{
		log.debug("onActive----------");
	}
	
	// 断开连接
	public void onInActive()
	{
		log.debug("onInActive----------");
	}
	
	//收到消息
	public void onMessage(NetMessage netMsg)
	{
		if(netMsg != null)
		{
			boolean hasHeader = netMsg.hasHeader();
			if(hasHeader)
			{
				String protoName = netMsg.getHeader().getProto();
				ByteString payload = netMsg.getPayload();
				
				handleManager.messageHandle(protoName, payload);
			}
		}
	}
}
