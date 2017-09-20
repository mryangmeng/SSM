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
			config.setMaxTotal(500); //���������
			config.setMaxIdle(8);// ������������  Ĭ�� 8
			config.setMaxWaitMillis(1000); //���ȴ�ʱ�� ��λ����  Ĭ�� -1  С��0 ������ȷ����ʱ��
			config.setTestOnBorrow(true);   //��ȡ����ʱ�����Ч  Ĭ��  false
			config.setTestOnReturn(true);   //����returnObject ʱ�Ƿ�����Ч  Ĭ�� false
			config.setTestWhileIdle(true);   //  ����ʱ�����Ч��  Ĭ�� false
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
		} catch (Exception e) { // �ͷ���Դ
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
		} catch (Exception e) { // �ͷ���Դ
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
