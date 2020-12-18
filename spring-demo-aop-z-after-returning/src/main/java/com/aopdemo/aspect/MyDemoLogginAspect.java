package com.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLogginAspect {
	
	// Add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(
			pointcut = "*com.aopdemo.dao.AccountDAO.findAccounts(..)",
			returning = "result")
	public void afterReturningFindAccountAdvice(
				JoinPoint theJoinPoint, List<Account> result) {
					
		
	}

	// Let's start with @Before advice
	@Before("com.aopdemo.aspect.MyAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n=======> Executing @Before advice on method");
		
		// Display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: " + methodSig);
		
		// Display the method arguments
		
		// Get args
		Object[] args = theJoinPoint.getArgs();
		
		// Loop thru args
		for (Object tempArgs : args) {
			System.out.println(tempArgs);
			
			if (tempArgs instanceof Account) {
				
				// Downcast and print Account specific stuff
				Account theAccount = (Account) tempArgs;
				
				System.out.println("Account name: " + theAccount.getName());
				System.out.println("Account level: " + theAccount.getLevel());
				
			}
		}
		
		
		
		
		
	}


}
