package com.parking.handle;

import java.util.List;

import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.InvalidProtocolBufferException;
import com.parking.protobuf.Awesome;
import com.parking.protobuf.Awesome.*;

public class AwesomeHandler extends BaseHandler{
	
	public AwesomeHandler()
	{
		register();
	}

	@Override
	public void register() {
		List<Descriptor> aweList = Awesome.getDescriptor().getMessageTypes();
		for (Descriptor descriptor : aweList) {
			this.setProtocol(descriptor.getName());
		}
	}

	@Override
	public boolean messageHandle(String protoName, ByteString payload) {
		
		if(this.hasProtocol(protoName))
		{
			this.invokeProtocol(this, protoName, payload);
			return true;
		}
		
		return false;
	}
	
	@ProtocolMethod
	public void AwesomeMessage(ByteString payload) throws InvalidProtocolBufferException
	{
		AwesomeMessage bdAwesome = AwesomeMessage.parseFrom(payload);	
		
		System.out.println(bdAwesome.getAwesomeField());
		
		AwesomeMessage.Builder bdAwesome2 = AwesomeMessage.newBuilder();
		bdAwesome2.setAwesomeField("dcs---server");
		
		this.responseMessage("AwesomeMessage", bdAwesome2.build().toByteString());
	}
}
