package com.greatlearning.bootEMS.empservice;

import java.util.List;

//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;

import com.greatlearning.bootEMS.entities.Employees;

public interface EmployeeService {
	
	public List <Employees> findAll();
	
	public void save (Employees employee);
	
	public Employees findById (int id);
	
	public List <Employees> findByFirstName (String firstName);
	
	public void deleteById (int id);
	
	//public void update (int id);
	
	public List <Employees> sortByFirstName();

}
