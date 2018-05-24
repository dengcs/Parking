package com.parking.handle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import com.google.protobuf.ByteString;

public abstract class BaseHandler {
	private Set<String> protoSet = new HashSet<String>();
	
	public abstract void register();
	public abstract boolean messageHandle(String protoName, ByteString payload);
	
	public void setProtocol(String protoName)
	{
		protoSet.add(protoName);
	}
	
	public boolean hasProtocol(String protoName)
	{
		return protoSet.contains(protoName);
	}
	
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
}
