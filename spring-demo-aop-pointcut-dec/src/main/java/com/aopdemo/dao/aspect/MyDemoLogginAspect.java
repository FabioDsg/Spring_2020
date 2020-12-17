package com.aopdemo.dao.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {

	// This is where we add all of our related advices for logging
	
	
	// Create a pointcut declaration
	@Pointcut("execution(* com.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	// Let's start with @Before advice
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=======> Executing @Before advice on method");
		
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		
		System.out.println("\n=======> Performing API Analytics");
		
	}
	
}
