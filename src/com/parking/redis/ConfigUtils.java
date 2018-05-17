package com.parking.redis;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigUtils {
	
	private static ConfigUtils instance = null;
	private Properties properties = null;
	
	private ConfigUtils()
	{
		properties = new Properties();
		InputStream in = null;
		try {
			in = ClassLoader.getSystemResourceAsStream("config.properties");
			properties.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized static ConfigUtils getInstance()
	{
		if (instance == null)
		{
			instance = new ConfigUtils();
		}
		
		return instance;
	}
	
	public String getKey(String key)
	{
		return properties.getProperty(key);
	}
}
