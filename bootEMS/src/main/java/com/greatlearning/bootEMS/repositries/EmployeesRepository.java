package com.greatlearning.bootEMS.repositries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.bootEMS.entities.Employees;

public interface EmployeesRepository extends JpaRepository <Employees, Integer> {
	
	// method declared for fetching list of all employees by first name
	List <Employees> findByFirstNameContainsAllIgnoreCase(String firstName);
	
	//method declared for fetching list of all employees sorted by first name 
	List<Employees> findByOrderByFirstNameDesc();

}
