package com.ym.user.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@SuppressWarnings("deprecation")
public class RedisClient {
	private static JedisPool pool = null;
	private static String host ="125.122.30.45";
	private static int port =17379;
	
	static {
		if(pool ==null){
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxTotal(500); //最大连接数
			config.setMaxIdle(8);// 最大空闲连接数  默认 8
			config.setMaxWaitMillis(1000); //最大等待时间 单位毫秒  默认 -1  小于0 阻塞不确定的时间
			config.setTestOnBorrow(true);   //获取连接时检查有效  默认  false
			config.setTestOnReturn(true);   //调用returnObject 时是否检查有效  默认 false
			config.setTestWhileIdle(true);   //  空闲时检查有效性  默认 false
			pool = new JedisPool(config,host,port);
		}
	}

	public static void returnResource(JedisPool pool, Jedis redis){
		if(redis!=null ){
			pool.returnResource(redis);
		}
	}
	public static Object get(String key){
		String value =null;
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			value = jedis.get(key);
		} catch (Exception e) { // 释放资源
			e.printStackTrace();
			pool.returnBrokenResource(jedis);
		} finally{
			returnResource(pool,jedis);
		}
		return value;
	}
	
	public static void set(String key, String value){
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.set(key, value);
			jedis.expire(key, 10000);
		} catch (Exception e) { // 释放资源
			e.printStackTrace();
			pool.returnBrokenResource(jedis);
		}finally{
			returnResource(pool, jedis); 
		}
	}
	
	
	public static void main(String[] args) {
		set("testKey1111","testValue11111");
		System.out.println("testKey: "+get("testKey1111"));
	}
	
	
}
