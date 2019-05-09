package com.luv2code.springboot.Ertapp.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.Ertapp.entity.Employee;
import com.luv2code.springboot.Ertapp.service.EmployeeService;

@RestController
@RequestMapping("/ert")
public class EmployeeRestController {
    
	private EmployeeService employeeService;
	//inject

	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	//expose
	@GetMapping("/employeedetails")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	//get employee id
	@GetMapping("/employeedetails/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		
		if(theEmployee == null) {
			throw new RuntimeException("Exception id not found-  "+ employeeId);
		}
		
		return theEmployee;
	}
	
	//add mapping for post employee
	@PostMapping("/employeedetails")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		theEmployee.setId(0);
		
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
	
	//add mapping for PUT /employees - update
	
	@PutMapping("/employeedetails")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
	
	//add mapping Delete
	
	@DeleteMapping("/employeedetails/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee tempEmployee = employeeService.findById(employeeId);
		
		//throwException
		
		if(tempEmployee == null) {
			throw new RuntimeException("Employee id not found - "+ employeeId);
		}
		
		employeeService.deleteById(employeeId);
		
		return "Deleted employee id - " + employeeId;
	}
	
	
	
	
	
}
