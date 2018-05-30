package com.parking.dao;

import com.parking.manage.UserManager;
import com.parking.mode.User.UserBase;
import com.parking.redis.ConfigUtils;
import com.parking.redis.RedisClient;
import com.parking.user.UserData;

import redis.clients.jedis.Jedis;

public final class UserDao {
	
	private Jedis redisClient = null;
	
	private static UserDao instance = null;
	
	private final String tb_acc_pw = "account:password:";
	private final String tb_acc_uid = "account:uid:";
	private final String tb_user = "user:";
	private final String tb_userID = "ID:user";
	
	private UserDao()
	{
		
	}
	
	public synchronized static UserDao getInstance()
	{
		if(instance == null)
		{
			instance = new UserDao();
		}
		return instance;
	}
	
	private Jedis getJedis()
	{
		if(redisClient == null)
		{
			redisClient = RedisClient.getJedis();
			
			ConfigUtils config = ConfigUtils.getInstance();
			String db_index = config.getKey("db");
			redisClient.select(Integer.parseInt(db_index));
		}
		
		return redisClient;
	}
	
	public Long generateId()
	{
		String str_uid = this.getJedis().get(tb_userID);
		if(str_uid == null)
		{
			this.getJedis().set(tb_userID, "1000000");
		}
		Long g_id = this.getJedis().incr(tb_userID);
		return g_id;
	}
	
	public long loginIn(String account, String password)
	{
		long uid = 0l;
		String key = tb_acc_pw + account;
		String value = this.getJedis().get(key);
		
		if(value != null && value.equals(password))
		{
			String uid_key = tb_acc_uid + account;
			String uid_value = this.getJedis().get(uid_key);
			uid = Long.parseLong(uid_value);
			return uid;
		}
		
		return uid;
	}
	
	public void createAccount(String account, String password)
	{
		String key = tb_acc_pw + account;
		this.getJedis().set(key, password);
		
		Long uid = this.generateId();
		String uid_key = tb_acc_uid + account;
		this.getJedis().set(uid_key, uid.toString());
	}
	
	public void loginOut(long uid)
	{
		UserData userDate = UserManager.getInstance().getUser(uid);
		if(userDate != null)
		{
			UserBase user = userDate.getUser();
			String str_uid = tb_user + String.valueOf(uid);
			this.getJedis().set(str_uid.getBytes(), user.toByteArray());
		}
	}
	
	public long createUser(UserData userDate)
	{
		UserBase user = userDate.getUser();
		
		String uid_key = tb_acc_uid + user.getAccount();
		String uid_value = this.getJedis().get(uid_key);
		long uid = Long.parseLong(uid_value);
		user.toBuilder().setUid(uid);
		
		String str_uid = tb_user + String.valueOf(uid);
		this.getJedis().set(str_uid.getBytes(), user.toByteArray());
		
		return uid;
	}
	
	public UserData loadUser(long uid)
	{
		UserData data = new UserData();
		String str_uid = tb_user + String.valueOf(uid);
		byte[] bt_user = this.getJedis().get(str_uid.getBytes());
		try {
			UserBase user = UserBase.parseFrom(bt_user);
			data.setUser(user);
		} catch (Exception e) {
			return null;
		}
		
		return data;
	}
}
