package com.luv2code.springboot.Ertapp.service;

import java.util.List;

import com.luv2code.springboot.Ertapp.entity.Employee1;

public interface EmployeeService1 {
	public List<Employee1> findAll();
	  
	  public Employee1 findById(int theId);
	  
	  public void save(Employee1 theEmployee);
	  
	  public void deleteById(int theId);
}
