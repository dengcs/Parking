package com.parking.handle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import com.google.protobuf.ByteString;
import com.parking.protobuf.Base.NetError;
import com.parking.protobuf.Base.NetHeader;
import com.parking.protobuf.Base.NetMessage;

import io.netty.channel.Channel;
import io.netty.util.AttributeKey;

public abstract class BaseHandler {
	private Channel channel = null;
	private Set<String> protoSet = new HashSet<String>();
	
	private final AttributeKey<Long> SERVERUIDKEY = AttributeKey.valueOf("S_UID_KEY");
	
	public abstract void register();
	public abstract boolean messageHandle(String protoName, ByteString payload);	
	
	public Long getUid() {
		if(channel != null)
		{
			Long uid = channel.attr(SERVERUIDKEY).get();
			if(uid != null)
			{
				return uid;
			}
		}
		return 0l;
	}
	
	public void setUid(Long uid) {
		if(channel != null)
		{
			channel.attr(SERVERUIDKEY).set(uid);
		}
	}
	
	public void setProtocol(String protoName)
	{
		protoSet.add(protoName);
	}
	
	public boolean hasProtocol(String protoName)
	{
		return protoSet.contains(protoName);
	}
	
	public Channel getChannel() {
		return channel;
	}
	
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
	// 处理协议
	public void invokeProtocol(BaseHandler handle, String protoName, ByteString payload)
	{
		Class<? extends BaseHandler> c = handle.getClass();
		Method[] methods = c.getDeclaredMethods();
		for (Method method : methods) {
			ProtocolMethod pm = method.getAnnotation(ProtocolMethod.class);
			if (pm != null)
			{
				String methodName = method.getName();
				if(methodName.equalsIgnoreCase(protoName))
				{
					method.setAccessible(true);
					try {
						method.invoke(handle, payload);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	//没有错误的应答
	public void responseMessage(String protoName, ByteString payload)
	{
		this.responseMessage(protoName, payload, 0);
	}
	
	// 应答消息
	public void responseMessage(String protoName, ByteString payload, int ret)
	{
		if(channel != null && channel.isActive())
		{
			NetMessage.Builder bdMessage = NetMessage.newBuilder();
			NetError.Builder bdError =  NetError.newBuilder();
			NetHeader.Builder bdHeader =  NetHeader.newBuilder();
			
			bdError.setCode(ret);
			
			long uid = this.getUid();
			bdHeader.setUid(uid);
			bdHeader.setProto(protoName);
			
			bdMessage.setError(bdError);
			bdMessage.setHeader(bdHeader);
			bdMessage.setPayload(payload);
			
			channel.writeAndFlush(bdMessage.build());
		}
	}
}
