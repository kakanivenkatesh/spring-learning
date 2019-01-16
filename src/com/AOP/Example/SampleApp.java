package com.AOP.Example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SampleApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_aop.xml");
		Candidate candidateInfo = (Candidate) context.getBean("candidate");
		
		UserService service = context.getBean(UserService.class);
		
		service.getService();
		
		candidateInfo.getName();
		candidateInfo.printThrowException();

	}

}
