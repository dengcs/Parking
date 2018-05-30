package com.parking.manage;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.parking.user.UserData;

public final class UserManager {
	private ConcurrentMap<Long,UserData> userMap = new ConcurrentHashMap<Long,UserData>();
	
	private static UserManager instance = null;
	
	private UserManager()
	{
		
	}
	
	public synchronized static UserManager getInstance()
	{
		if(instance == null)
		{
			instance = new UserManager();
		}
		return instance;
	}
	
	public UserData getUser(Long uid)
	{
		return userMap.get(uid);
	}
	
	public void addUser(Long uid,UserData user)
	{
		userMap.put(uid, user);
	}
	
	public void removeUser(Long uid)
	{
		userMap.remove(uid);
	}
}
