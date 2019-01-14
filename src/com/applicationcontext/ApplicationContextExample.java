package com.applicationcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ApplicationContextExample {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		EmailService emailService = (EmailService) context.getBean("emailservice");
		emailService.sendMessage();
		
		ApplicationContext context1 = new AnnotationConfigApplicationContext(JavaBasedConfig.class);
		SMSService smsService = (SMSService) context1.getBean("smsservice");
		smsService.sendMessage();
		
		ApplicationContext context2 = new FileSystemXmlApplicationContext("E:/Practice/SpringLearning/src/application-context.xml");
		EmailService emailService2 = (EmailService) context2.getBean("emailservice");
		emailService2.sendMessage();
		
	      

	}

}
