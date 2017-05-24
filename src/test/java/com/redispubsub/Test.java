package com.redispubsub;

import java.util.Scanner;

public class Test {
public static void main(String[] args) {
	final Client client=new Client();
	client.setName("dcx");
	final String[] rooms = {"movie"};
	new Thread(new Runnable() {
		
		public void run() {
			// TODO Auto-generated method stub
			 String[] rooms = {"peter","Bob"};
			 client.subscribe(rooms);
		}
	}).start();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	while(true){
        System.out.print("say something:");
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine(); 
        if("quit".equals(message)){
            break;
        }else{
            client.say(rooms[0], message);
            System.out.println();
        }
    }
    String[] unSubRoom ={"movie::live::room"}; 
    client.unSubscribe(unSubRoom);
}
}
