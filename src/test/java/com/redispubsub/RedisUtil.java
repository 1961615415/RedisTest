package com.redispubsub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisPubSub;

public class RedisUtil {

	public  static Jedis jedis;
	static {/*
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxIdle(5);
		poolConfig.setMinIdle(1);
		poolConfig.setTestOnBorrow(true);
		poolConfig.setNumTestsPerEvictionRun(10);
		poolConfig.setTimeBetweenEvictionRunsMillis(60000);
		poolConfig.setMaxWait(10000);
		pool = new JedisPool(poolConfig, "127.0.0.1", 6379);
	*/
		jedis=new Jedis( "127.0.0.1", 6379,1000);
		jedis.auth("test");
	}

	public RedisUtil() {
	}


	/* 发布消息 */
	@SuppressWarnings("null")
	public static void publish(String channel, String message) {
		try {
			jedis.publish(channel, message);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
		}
	};

	/* 订阅房间 */
	public static void subscribe(String[] room, JedisPubSub pubSub) {
		try {
			jedis.subscribe(pubSub, room);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
		}
	}
}
