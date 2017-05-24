package com.redispubsub;

import com.redispubsub.RedisUtil;

import redis.clients.jedis.JedisPubSub;

/***
 * 订阅 监听到订阅模式接受到消息时的回调 (onPMessage) 监听到订阅频道接受到消息时的回调 (onMessage ) 订阅频道时的回调(
 * onSubscribe ) 取消订阅频道时的回调( onUnsubscribe ) 订阅频道模式时的回调 ( onPSubscribe )
 * 取消订阅模式时的回调( onPUnsubscribe )
 * 
 * @author duchunxia
 *
 */
public class PubSub extends JedisPubSub {
	/*成员名字*/
    private String clientName;
    /*房间名*/
    private String[] room;
	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String[] getRoom() {
		return room;
	}

	public void setRoom(String[] room) {
		this.room = room;
	}

	@Override
	public void onMessage(String channel, String message) {
		// TODO Auto-generated method stub
		System.out.println("收到来自:" + channel + "房间的消息,message:"
				+ message);
	}

	@Override
	public void onPMessage(String pattern, String channel, String message) {
		// TODO Auto-generated method stub
		System.out.println("监听到订阅频道接受到消息时的回调pattern:" + pattern + "channel:"
				+ channel + ",message:" + message);
	}

	@Override
	public void onSubscribe(String channel, int subscribedChannels) {
		// TODO Auto-generated method stub
		System.out.println("订阅频道时的回调channel:" + channel + "subscribedChannels:"
				+ subscribedChannels+"成员名："+clientName);
	}

	@Override
	public void onUnsubscribe(String channel, int subscribedChannels) {
		// TODO Auto-generated method stub
		System.out.println("取消订阅频道时的回调channel:" + channel
				+ "subscribedChannels:" + subscribedChannels);
		RedisUtil.publish(channel, clientName+":离开房间了");
	}

	@Override
	public void onPUnsubscribe(String pattern, int subscribedChannels) {
		// TODO Auto-generated method stub
		System.out.println("取消订阅频道模式时的回调pattern:" + pattern
				+ "subscribedChannels:" + subscribedChannels);

	}

	@Override
	public void onPSubscribe(String pattern, int subscribedChannels) {
		// TODO Auto-generated method stub
		System.out.println("订阅频道模式时的回调pattern:" + pattern
				+ "subscribedChannels:" + subscribedChannels);
	}

}
