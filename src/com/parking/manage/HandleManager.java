package com.parking.manage;

import java.util.AbstractQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.google.protobuf.ByteString;
import com.parking.handle.AwesomeHandler;
import com.parking.handle.BaseHandler;

import io.netty.channel.Channel;

public class HandleManager {
	
	private AbstractQueue<BaseHandler> handleQueue = new ConcurrentLinkedQueue<BaseHandler>();
	
	public HandleManager()
	{
		register();
	}
	
	public void register()
	{
		handleQueue.add(new AwesomeHandler());
	}

	public void setChannel(Channel channel) {
		for (BaseHandler handler : handleQueue) {
			handler.setChannel(channel);
		}
	}

	public void messageHandle(String protoName, ByteString payload)
	{
		for (BaseHandler handler : handleQueue) {
			if(handler.messageHandle(protoName, payload))
			{
				break;				
			}
		}
	}

}
