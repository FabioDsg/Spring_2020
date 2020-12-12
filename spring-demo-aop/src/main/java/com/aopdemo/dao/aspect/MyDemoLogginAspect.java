package com.aopdemo.dao.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {

	// This is where we add all of our related advices for logging
	
	// Let's start with @Before advice
	
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=======> Executing @Before advice on AddAcount()");
	}
	
}
