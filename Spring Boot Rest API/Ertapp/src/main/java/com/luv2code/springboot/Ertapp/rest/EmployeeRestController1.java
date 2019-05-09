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

import com.luv2code.springboot.Ertapp.entity.Employee1;
import com.luv2code.springboot.Ertapp.service.EmployeeService1;


@RestController
@RequestMapping("/ert")
public class EmployeeRestController1 {
	
	private EmployeeService1 employeeService1;
	//inject

	public EmployeeRestController1(EmployeeService1 theEmployeeService1) {
		employeeService1 = theEmployeeService1;
	}
	//expose
		@GetMapping("/employeeattendance")
		public List<Employee1> findAll(){
			return employeeService1.findAll();
		}
		//get employee id
		@GetMapping("/employeeattendance/{employeeId}")
		public Employee1 getEmployee(@PathVariable int employeeId) {
			Employee1 theEmployee1 = employeeService1.findById(employeeId);
			
			if(theEmployee1 == null) {
				throw new RuntimeException("Exception id not found-  "+ employeeId);
			}
			
			return theEmployee1;
		}
		
		//add mapping for post employee
		@PostMapping("/employeeattendance")
		public Employee1 addEmployee(@RequestBody Employee1 theEmployee) {
			
			theEmployee.setId(0);
			
			employeeService1.save(theEmployee);
			
			return theEmployee;
		}
		
		//add mapping for PUT /employees - update
		
		
//		public Employee1 updateEmployee(@RequestBody Employee1 theEmployee) {
//			
//			employeeService1.save(theEmployee);
//			
//			return theEmployee;
//		}
//		
		@PutMapping("/employeeattendance/{employeeId}")
		public Employee1 updateEmployee(@PathVariable(value = "employeeId") int employeeId, @RequestBody Employee1 theEmployee) {
			Employee1 theEmployee1 = employeeService1.findById(employeeId);
		  
			if(theEmployee1 == null) {
				throw new RuntimeException("Employee id not found - "+ employeeId);
			}
			
			theEmployee1.setEmailId(theEmployee.getEmailId());
			theEmployee1.setFirstName(theEmployee.getFirstName());
			theEmployee1.setLastName(theEmployee.getLastName());
			theEmployee1.setDepartment(theEmployee.getDepartment());
		    theEmployee1.setImageUrl(theEmployee.getImageUrl());
		    employeeService1.save(theEmployee1);
		return theEmployee1;
		}
		
		
		
		
		
		//add mapping Delete
		@DeleteMapping("/employeeattendance/{employeeId}")
		public String deleteEmployee(@PathVariable int employeeId) {
			
			Employee1 tempEmployee1 = employeeService1.findById(employeeId);
			
			//throwException
			
			if(tempEmployee1 == null) {
				throw new RuntimeException("Employee id not found - "+ employeeId);
			}
			
			employeeService1.deleteById(employeeId);
			
			return "Deleted employee id - " + employeeId;
		}
		
	

}
