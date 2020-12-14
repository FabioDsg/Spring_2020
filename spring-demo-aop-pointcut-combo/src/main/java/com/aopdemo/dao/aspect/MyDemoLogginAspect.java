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
	private void forDaoPackage() {
	}

	// Create pointcut for getter methods
	@Pointcut("execution(* com.aopdemo.dao.*.get*(..))")
	private void getter() {
	}

	// Create pointcut for setter methods
	@Pointcut("execution(* com.aopdemo.dao.*.set*(..))")
	private void setter() {
	}

	// Create a pointcut: include package... Exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() ||setter() )")
	private void forDaoPackageNoGetterSetter() {
	}

	// Let's start with @Before advice
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {

		System.out.println("\n=======> Executing @Before advice on method");

	}

	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {

		System.out.println("\n=======> Performing API Analytics");

	}

}
