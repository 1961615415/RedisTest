package com.RedisTest.RedisTest;

import org.junit.After;
import org.junit.Test;

import redis.clients.jedis.Jedis;

public class PubSubDemo {
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Jedis jedis=null;
		jedis=new Jedis("127.0.0.1", 6379, 1000);
		jedis.auth("test");
		jedis.publish("dcx1", "你好1");
		jedis.publish("dcx2", "你好2");
		TestPubSub testPubSub=new TestPubSub();
		jedis.subscribe(testPubSub, "dcx1","dcx2");
		jedis.subscribe(testPubSub, "dcx1");
	
		
		jedis.disconnect();
	}

}
