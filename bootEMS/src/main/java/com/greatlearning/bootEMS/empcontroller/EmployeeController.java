package com.greatlearning.bootEMS.empcontroller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.bootEMS.empservice.EmployeeService;
import com.greatlearning.bootEMS.entities.Employees;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;


	// end point to fetch list of all employees from DB
	@RequestMapping("/list")
	public List<Employees> employeeList() {
		return employeeService.findAll();
	}

	// endpoint to add employees into DB
	@PostMapping("/save")
	public void saveEmployee(String firstName, String lastName, String email) {

		Employees emp = new Employees(firstName, lastName, email);
		employeeService.save(emp);
	}

	// endpoint to fetch employess detail by his/her Id
	@RequestMapping("/emp_id")
	public Employees employeeById(int id) {
		Employees emp = employeeService.findById(id);
		return emp;
	}

	// endpoint to update existing record in DB
	@PutMapping
	public Employees updateEmpDetails(int id, String firstName, String lastName, String email) {
		Employees emp = employeeService.findById(id);
		System.out.println(emp);
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setEmail(email);
		employeeService.save(emp);
		return emp;
	}

	// endpoint to employee record based on id
	@DeleteMapping
	public String deleteEmployee(int id) {
		employeeService.deleteById(id);
		return "deleted employee id -->" + id;
	}

	// endpoint to fetch list of all employees with given first name
	@RequestMapping("/search_firstNmae")
	public List<Employees> searchByFirstName(String firstName) {
		List<Employees> employees = employeeService.findByFirstName(firstName);
		return employees;
	}

	// endpoint to fetch list of all employees arranged in descending order on the
	// basis of first name
	@RequestMapping("/sorted_list")
	public List<Employees> sortedEmployeeList() {
		List<Employees> employees = employeeService.sortByFirstName();
		return employees;
	}

}
