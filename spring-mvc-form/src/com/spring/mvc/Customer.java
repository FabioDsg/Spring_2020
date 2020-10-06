package com.spring.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {

	
	private String firstName;
	
	@NotNull(message="Is required")
	@Size(min=1, message="Is required")
	private String lastName;
	
	@Min(value = 0, message = "Must be greater than or equal 0")
	@Max(value = 10, message = "Must be less than or equal 10")
	private int freePasses;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}
	
	
	
}
