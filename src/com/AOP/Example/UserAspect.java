package com.AOP.Example;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class UserAspect {
	@Before("execution(* com.AOP.Example.UserService+.*(..))")
	public void userAdvice(){
		System.out.println("From UserAspect");
	}
}
