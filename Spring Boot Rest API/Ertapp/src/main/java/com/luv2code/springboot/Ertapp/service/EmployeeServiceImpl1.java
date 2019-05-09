package com.luv2code.springboot.Ertapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.Ertapp.entity.Employee1;

import com.luv2code.springboot.Ertapp.entity.dao.EmployeeRespository1;
@Service
public class EmployeeServiceImpl1 implements EmployeeService1 {
private EmployeeRespository1 employeeRespository1;
	
	@Autowired
	public EmployeeServiceImpl1(EmployeeRespository1 theEmployeeRespository1) {
		employeeRespository1 = theEmployeeRespository1;
	}
	@Override
	public List<Employee1> findAll() {
		// TODO Auto-generated method stub
		return employeeRespository1.findAll();
	}

	@Override
	public Employee1 findById(int theId) {
Optional<Employee1> result1 = employeeRespository1.findById(theId);
		
		Employee1 theEmployee = null;
		
		if(result1.isPresent()) {
			theEmployee = result1.get();
		}
		else{
		  throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theEmployee;
	}

	@Override
	public void save(Employee1 theEmployee) {
		// TODO Auto-generated method stub
		employeeRespository1.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		  employeeRespository1.deleteById(theId);
	}

}
