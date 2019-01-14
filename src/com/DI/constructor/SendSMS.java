package com.DI.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SendSMS {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		MessgaeService message = (MessgaeService) context.getBean("service");
		message.sendMessage();

	}

}
