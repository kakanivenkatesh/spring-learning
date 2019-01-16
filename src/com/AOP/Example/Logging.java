package com.AOP.Example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Logging {
	
	
	@Pointcut("execution(* com.AOP.Example.Candidate.getName())")
	   private void selectAll(){
		
	}
	
	@Before("selectAll()")
	public void beforeAdvice(){
		System.out.println("beforeAdvice");
	}
	
	@Around("selectAll()")
	public void aroundAdvice(ProceedingJoinPoint jointpoint) throws Throwable{
		System.out.println("aroundAdvice.");
		jointpoint.proceed();
		System.out.println("After: aroundAdvice");
	}
	
	@AfterReturning("selectAll()")
	public void afterReturningAdvice(){
		System.out.println("afterReturningAdvice");
	}
	
	@AfterThrowing(pointcut= "execution(* com.AOP.Example.Candidate.*(..))", throwing = "error")
	public void AfterThrowingAdvice(Throwable error){
		System.out.println("AfterThrowingAdvice");
		System.out.println("Exception: "+error);  
	}
	
	@After("selectAll()")
	public void afterAdvice(){
		System.out.println("afterAdvice");
	}
	
	
	

}
