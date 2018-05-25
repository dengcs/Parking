package com.parking.main;

import com.google.protobuf.ByteString;
import com.parking.manage.HandleManager;
import com.parking.protobuf.Base.NetMessage;

import io.netty.channel.Channel;

public class ServerSession {
	
	private Channel channel = null;
	
	private HandleManager handleManager = null;
	
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
		System.out.println("onActive----------");
	}
	
	// 断开连接
	public void onInActive()
	{
		System.out.println("onInActive----------");
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
