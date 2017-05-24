package com.redispubsub;


public class Client  {
	private String name;
	private PubSub roomSubListerner;
/* 进入房间*/
public void subscribe(final String[] room){
	PubSub roomSub = roomSubListerner;
    roomSub.setClientName(name);
    roomSub.setRoom(room);
    RedisUtil.subscribe(room, roomSub);
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
/* 退出房间*/
public void unSubscribe(final String[] room){
    roomSubListerner.unsubscribe(room);
}
public Client() {
	 roomSubListerner = new PubSub();
}
/*说话*/
public void say(final String room,String message){
    RedisUtil.publish(room, name+" say:"+message);
}
}
