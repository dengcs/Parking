package com.parking.handle;

import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.InvalidProtocolBufferException;
import com.parking.dao.UserDao;
import com.parking.manage.UserManager;
import com.parking.mode.User.UserBase;
import com.parking.protobuf.Login;
import com.parking.protobuf.Login.*;
import com.parking.user.UserData;

public class LoginHandler extends BaseHandler {
	
	public LoginHandler() {
		register();
	}

	@Override
	public void register() {
		List<Descriptor> aweList = Login.getDescriptor().getMessageTypes();
		for (Descriptor descriptor : aweList) {
			this.setProtocol(descriptor.getName());
		}
	}

	@Override
	public boolean messageHandle(String protoName, ByteString payload) {
		
		long uid = this.getUid();
		if(uid == 0)
		{
			boolean bReturn = true;
			
			List<String> filterList = new ArrayList<String>();
			filterList.add("Req_Login_LoginIn");
			filterList.add("Req_Login_Create");
			
			for (String string : filterList) {
				if(string.equalsIgnoreCase(protoName))
				{
					bReturn = false;
					break;
				}
			}
			
			if(bReturn)
			{
				return false;
			}
		}
		
		if(this.hasProtocol(protoName))
		{
			this.invokeProtocol(this, protoName, payload);
			return true;
		}
		
		return false;
	}
	
	// 登录
	@ProtocolMethod
	public void Req_Login_LoginIn(ByteString payload) throws InvalidProtocolBufferException
	{
		String proto_name = "Resp_Login_LoginIn";
		Req_Login_LoginIn ReqParams = Req_Login_LoginIn.parseFrom(payload);
		Resp_Login_LoginIn.Builder resp_msg = Resp_Login_LoginIn.newBuilder();
		
		long uid = UserDao.getInstance().loginIn(ReqParams.getAccount(), ReqParams.getPassword());
		
		if(uid>0)
		{
			UserData data = UserDao.getInstance().loadUser(uid);
			if(data != null)
			{
				resp_msg.setRet(0);
				this.setUid(uid);
			}else
			{
				resp_msg.setRet(1);
			}
			
		}else
		{
			resp_msg.setRet(1);
			UserDao.getInstance().createAccount(ReqParams.getAccount(), ReqParams.getPassword());
		}
		
		this.responseMessage(proto_name, resp_msg.build().toByteString());
	}
	
	// 登出
	@ProtocolMethod
	public void Req_Login_LoginOut(ByteString payload) throws InvalidProtocolBufferException
	{
		String proto_name = "Resp_Login_LoginOut";
		Resp_Login_LoginOut.Builder resp_msg = Resp_Login_LoginOut.newBuilder();
		
		long uid = this.getUid();	
		UserDao.getInstance().loginOut(uid);
		UserManager.getInstance().removeUser(uid);
		
		this.responseMessage(proto_name, resp_msg.build().toByteString());
	}
	
	// 创建用户
	@ProtocolMethod
	public void Req_Login_Create(ByteString payload) throws InvalidProtocolBufferException
	{
		String proto_name = "Resp_Login_Create";
		Req_Login_Create ReqParams = Req_Login_Create.parseFrom(payload);
		Resp_Login_Create.Builder resp_msg = Resp_Login_Create.newBuilder();
		
		UserData data = new UserData();
		
		UserBase.Builder user = UserBase.newBuilder();
		user.setSex(ReqParams.getSex());
		user.setNickName(ReqParams.getNickName());
		user.setAccount(ReqParams.getAccount());
		
		data.setUser(user.build());
		long uid = UserDao.getInstance().createUser(data);
		
		this.setUid(uid);
		
		UserManager.getInstance().addUser(uid, data);
		
		resp_msg.setRet(0);
		this.responseMessage(proto_name, resp_msg.build().toByteString());
	}
	
	// 进入系统
	@ProtocolMethod
	public void Req_Login_Enter(ByteString payload) throws InvalidProtocolBufferException
	{
		String proto_name = "Resp_Login_Enter";
		Resp_Login_Enter.Builder resp_msg = Resp_Login_Enter.newBuilder();
		long uid = this.getUid();
		UserData data = UserManager.getInstance().getUser(uid);
		if(data != null)
		{
			UserBase user = data.getUser();
			if(user != null)
			{
				resp_msg.setSex(user.getSex());
				resp_msg.setNickName(user.getNickName());
			}
		}
		
		this.responseMessage(proto_name, resp_msg.build().toByteString());
	}
}
