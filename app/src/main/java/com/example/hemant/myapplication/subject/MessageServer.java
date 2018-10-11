package com.example.hemant.myapplication.subject;

import com.example.hemant.myapplication.observer.IObserver;

import java.util.ArrayList;
import java.util.List;


public class MessageServer implements ISubject{
	
	public List<IObserver> clients;
	String message;
	
	public MessageServer(){
		this.clients = new ArrayList<IObserver>();
		message = "";
	}

	@Override
	public void register(IObserver client) {
		if( !clients.contains(client) ) 
			clients.add(client);
	}

	@Override
	public void unregister(IObserver client) {
		clients.remove(client);
	}

	@Override
	public void notifyObservers(String new_message) {
		for(IObserver client : clients){
			client.updateListener(new_message);
		}
	}
	
	public void postMessage(String new_message){
		this.message = new_message;
		notifyObservers(this.message);
	}

}