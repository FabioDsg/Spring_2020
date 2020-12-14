package com.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MemberShipDAO {
	
	public void addAccount() {
			
			System.out.println(getClass() + ": DOING MY DB WORK: ADDING A MemberShip Account");
		}
	
	public void goToSleep() {
		
		System.out.println(getClass() + ": I'm going to sleep now...");
		
	}
}
