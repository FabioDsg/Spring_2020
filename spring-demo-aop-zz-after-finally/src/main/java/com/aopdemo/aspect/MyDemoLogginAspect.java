package com.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	@After("execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @After (finally) on method: " 
							+ method);
	
	}
	
	@AfterThrowing(
			pointcut="execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(
					JoinPoint theJoinPoint, Throwable theExc) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);
		
		// log the exception
		System.out.println("\n=====>>> The exception is: " + theExc);
	
	}


	// Add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(pointcut = "execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {

		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

		// print out the results of the method call
		System.out.println("\n=====>>> result is: " + result);

		// Post-process the data ... let's modify it :-)

		// Convert the account names to uppercase
		convertAccountNamesToUpperCase(result);

		System.out.println("\n=====>>> result is: " + result);

	}

	private void convertAccountNamesToUpperCase(List<Account> result) {

		// Loop through accounts

		for (Account tempAccount : result) {

			// Get uppercase version of name
			String theUpperName = tempAccount.getName().toUpperCase();

			// Update the name on the account
			tempAccount.setName(theUpperName);
		}

	}

	//  Start with @Before advice
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
