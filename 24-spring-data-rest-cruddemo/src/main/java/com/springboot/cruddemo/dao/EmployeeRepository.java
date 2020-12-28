package com.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springboot.cruddemo.entity.Employee;

// @RepositoryRestResource(path = "members") tell spring to use "members" instead "employees"
@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// That's it ... No need to write any code LOL!
	
}
