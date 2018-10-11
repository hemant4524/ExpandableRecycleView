package com.example.hemant.myapplication.observer;


import com.example.hemant.myapplication.subject.ISubject;

public interface IObserver {
	
	 void updateListener(String payload);
	
	 void registerToSubject(ISubject sub);
}