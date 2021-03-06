package com.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.dao.AccountDAO;
import com.aopdemo.dao.MemberShipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// Read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// Get the bean from spring container
		MemberShipDAO theMemberShipDAO = context.getBean("memberShipDAO", MemberShipDAO.class);
		
		// Call the business method
		Account myAccount = new Account();
		myAccount.setName("Sparrow");
		myAccount.setLevel("Bronze");
		
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();
		
		// Call the accountdao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		
		// Call the MemberShip business method
		theMemberShipDAO.addAccount();  
		theMemberShipDAO.goToSleep();
		 
		 
		
		// Close the context
		context.close();

	}

}
