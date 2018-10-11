package com.example.hemant.myapplication.subject;


import com.example.hemant.myapplication.observer.IObserver;

public interface ISubject {
	
	public void register(IObserver obj);
	public void unregister(IObserver obj);
	
	public void notifyObservers(String new_payload);
	
	
}