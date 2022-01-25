package com.greatlearning.bootEMS.empservice;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.stereotype.Service;

import com.greatlearning.bootEMS.entities.Employees;
import com.greatlearning.bootEMS.repositries.EmployeesRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired 
	private EmployeesRepository x;

	@Override
	public List<Employees> findAll() {
		// TODO Auto-generated method stub
		List <Employees> employees = x.findAll();
		return employees;
	}

	@Override
	public void save(Employees employee) {
		// TODO Auto-generated method stub
		x.save(employee);
		
	}

	@Override
	public Employees findById(int id) {
		// TODO Auto-generated method stub
		Employees employee = x.findById(id).get();
		return employee;
	}

	@Override
	public List<Employees> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		List <Employees> employees = x.findByFirstNameContainsAllIgnoreCase(firstName);
		return employees;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		x.deleteById(id);
		
	}

	//@Override
	//public void update(int id) {
		// TODO Auto-generated method stub
	//}

	@Override
	public List<Employees> sortByFirstName () {
		// TODO Auto-generated method stub
		List <Employees> employees = x.findByOrderByFirstNameDesc();
		return employees;
	}

}
