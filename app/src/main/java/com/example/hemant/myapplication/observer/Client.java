package com.example.hemant.myapplication.observer;

import com.example.hemant.myapplication.subject.ISubject;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Client implements IObserver {
	
	public Queue<String> message_queue;
	private ISubject message_server;
	String id;
	
	public Client(String id){
		this.id = id;
		message_queue = new LinkedList<>();
	}
	
	@Override
	public void updateListener(String message) {
		/* This is the onUpdateListner for every Client*/
		message_queue.add(message);
	}

	@Override
	public void registerToSubject(ISubject subject) {
//		message_server = subject;
	}
	
	//When your device gets connected to the server, call this function
	public void onConnect(){
		
		if(!message_queue.isEmpty()){
			
			Iterator<String> iter  = message_queue.iterator();
			while(iter.hasNext()){
				System.out.println(id+" recieved "+iter.next()); //send messages to the device via MQTT
			}
				
			message_queue.clear();
		}
		
	}

}