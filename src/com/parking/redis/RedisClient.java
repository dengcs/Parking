package com.parking.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisClient {
	    
	private static JedisPool jedisPool = null;

    static {
        try {
        	ConfigUtils config = ConfigUtils.getInstance();
        	String ADDR = config.getKey("addr");
        	String postStr = config.getKey("port");	
        	int PORT = Integer.parseInt(postStr);
        	String AUTH = config.getKey("auth");;
        	
            JedisPoolConfig jedisConfig = new JedisPoolConfig();
            jedisConfig.setBlockWhenExhausted(true);
            jedisConfig.setEvictionPolicyClassName("org.apache.commons.pool2.impl.DefaultEvictionPolicy");
            jedisConfig.setJmxEnabled(true);
            jedisConfig.setMaxIdle(8);
            jedisConfig.setMaxTotal(200);
            jedisConfig.setMaxWaitMillis(1000 * 100);
            jedisConfig.setTestOnBorrow(true);
            jedisPool = new JedisPool(jedisConfig, ADDR, PORT, 3000, AUTH);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized static Jedis getJedis() {
        try {
            if (jedisPool != null) {
                Jedis resource = jedisPool.getResource();
                return resource;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void close(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
        if (jedisPool != null) {
        	jedisPool.close();
        }
    }
}
