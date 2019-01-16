package com.DI.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Message {

	private MessgaeService service;
	
	
	@Autowired
	Message(MessgaeService service){
		this.service= service;
	}
	
	public void sendMessage(){
		service.sendMessage();
	}
}
