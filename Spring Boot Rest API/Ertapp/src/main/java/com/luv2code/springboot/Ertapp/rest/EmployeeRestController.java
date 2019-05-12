package com.luv2code.springboot.Ertapp.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@CrossOrigin(origins = "*")
	@GetMapping("/employeedetails")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	//get employee id

	@CrossOrigin(origins = "*")
	@GetMapping("/employeedetails/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		
		if(theEmployee == null) {
			throw new RuntimeException("Exception id not found-  "+ employeeId);
		}
		
		return theEmployee;
	}
	
	//ADD mapping for post employee
	@CrossOrigin(origins = "*")
	@PostMapping("/employeedetails")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
	
	//UPDATE using POST Method...
	
	@CrossOrigin(origins = "*")
	@PostMapping("/employeedetails/{employeeId}")
	public Employee updateEmployee(@RequestBody Employee newEmployee,@PathVariable int employeeId) {
		
	Employee theEmployee = employeeService.findById(employeeId);
	
	
	if(theEmployee == null) {
		throw new RuntimeException("Employee ID not Found: " + employeeId);
	}
	
	 employeeService.save(newEmployee);
	
	return newEmployee;
	
		
//	
//	if(oldEmployee == null) {
//		theEmployee.setId(0);
//
//		employeeService.save(theEmployee);
//
//		return theEmployee;
//	}
//	
//	employeeService.save(theEmployee);
//	
//	return oldEmployee;
}

	@CrossOrigin(origins = "*")
	@PostMapping("/employeedetails/remove/{employeeId}")
	public String removeEmployee(@PathVariable int employeeId) {
		
		
		Employee theEmployee = employeeService.findById(employeeId);
		
		if(theEmployee == null) {
			throw new RuntimeException("Id not found - "+employeeId);
		}
		
		employeeService.deleteById(employeeId);
		return "Id is deleted - " + employeeId;
	}
	
	
//		if(theEmployee == null) {
//			throw new RuntimeException("Exception id not found-  "+ EmployeeId);
//		}
//		
//		employeeService.deleteById(EmployeeId);
//		
//		return "Successfully Deleted Employee with ID: - " + EmployeeId;
//	}
	
	
	
	// DELETE using POST Method..
//	
//	@PostMapping("/employeedetails/{employeeId}")
//	public String removeEmployee(@RequestBody Employee someEmployee,@PathVariable int EmployeeId) {
//		
//	Employee theEmployee = employeeService.findById(EmployeeId);
//		
//		if(theEmployee == null) {
//			throw new RuntimeException("Exception id not found-  "+ EmployeeId);
//		}
//		
//		employeeService.deleteById(EmployeeId);
//		
//		return "Successfully Deleted Employee with ID: - " + EmployeeId;
//	}
	
	
	//add mapping for PUT /employees - update
	
//	@PutMapping("/employeedetails")
//	public Employee updateEmployee(@RequestBody Employee theEmployee) {
//		
//		employeeService.save(theEmployee);
//		
//		return theEmployee;
//	}
	
	
	
	
//	@PutMapping("/employeedetails/{employeeId}")
//	public Employee updateEmployee(@PathVariable(value = "employeeId") int employeeId, @RequestBody Employee theEmployee) {
//		Employee theEmployee2 = employeeService.findById(employeeId);
//	  
//		if(theEmployee2 == null) {
//			throw new RuntimeException("Employee id not found - "+ employeeId);
//		}
//		
//		theEmployee2.setEmailId(theEmployee.getEmailId());
//		theEmployee2.setFirstName(theEmployee.getFirstName());
//		theEmployee2.setLastName(theEmployee.getLastName());
//		theEmployee2.setDepartment(theEmployee.getDepartment());
//	    theEmployee2.setImageUrl(theEmployee.getImageUrl());
//	    employeeService.save(theEmployee2);
//	return theEmployee2;
//	}
//	
//	//add mapping Delete
//	
//	@DeleteMapping("/employeedetails/{employeeId}")
//	public String deleteEmployee(@PathVariable int employeeId) {
//		
//		Employee tempEmployee = employeeService.findById(employeeId);
//		
//		//throwException
//		
//		if(tempEmployee == null) {
//			throw new RuntimeException("Employee id not found - "+ employeeId);
//		}
//		
//		employeeService.deleteById(employeeId);
//		
//		return "Deleted employee id - " + employeeId;
//	}
//	
	
	
	
	
}
