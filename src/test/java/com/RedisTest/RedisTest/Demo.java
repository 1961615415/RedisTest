package com.RedisTest.RedisTest;
import org.junit.Test;

import redis.clients.jedis.Jedis;
public class Demo  {
	Jedis jedis=new Jedis("127.0.0.1",6379,100000);
	public  void addValue(String key,String value){
		jedis.auth("test");
		jedis.set(key, value);
		//System.out.println(jedis.blpop(0, "list1"));
	}
	@Test
	public void  AddTest(){
		addValue("pass", "ok");
		addValue("pass", "ok1");
	}
	public void delValue(String keys){
		jedis.auth("abc123");
		jedis.del(keys);
	}
	public String selectValue(String keys){
		jedis.auth("abc123");
		return jedis.get(keys);
	}
	@Test
	public void SelectTest(){
		System.out.println(selectValue("pass"));
	}
	@Test
	public void DelTest(){
		delValue("pass");
	}
}
