package com.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// That's it ... No need to write any code LOL!
	
	// Add a method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
	
}
