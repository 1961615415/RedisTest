package com.RedisTest.RedisTest;

import java.util.ResourceBundle;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class DemoRedisPool {
private static JedisPool pool;
static{
	ResourceBundle bundle=ResourceBundle.getBundle("redis");
	if(bundle==null){
		try {
			throw new IllegalAccessException("[redis.properties] not Found");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
	jedisPoolConfig.setMaxActive(Integer.valueOf(bundle.getString("redis.pool.maxActive")));
	jedisPoolConfig.setMaxIdle(Integer.valueOf(bundle.getString("redis.pool.maxIdle")));
	jedisPoolConfig.setMaxWait(Long.valueOf(bundle.getString("redis.pool.maxWait")));
	jedisPoolConfig.setTestOnBorrow(Boolean.valueOf(bundle.getString("redis.pool.testOnBorrow")));
	jedisPoolConfig.setTestOnReturn(Boolean.valueOf(bundle.getString("redis.pool.testOnReturn")));
	pool=new JedisPool(jedisPoolConfig, bundle.getString("redis.ip"), Integer.valueOf(bundle.getString("redis.port")));
	
}
Jedis  jedis=pool.getResource();
public  void addValue(String key,String value){
	jedis.auth("abc123");
	jedis.set(key, value);
}
@Test
public void AddTest(){
	addValue("pass","ok");
}
}
