package com.parking.redis;

import redis.clients.jedis.Jedis;

import com.parking.mode.User.UserBase;

public class ClientTest {
	
	public static void main(String[] args) throws Exception {
		
		Jedis jedis = RedisClient.getJedis();
		
		ConfigUtils config = ConfigUtils.getInstance();
		String db_index = config.getKey("db");
		jedis.select(Integer.parseInt(db_index));
		
		UserBase.Builder user = UserBase.newBuilder();
		user.setUid(1001);
		user.setAge(18);
		user.setNickName("dengcs");
		
		jedis.set("1001", "dengcs");
		 
		RedisClient.close(jedis);
	}

}
