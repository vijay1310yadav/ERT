package com.luv2code.springboot.Ertapp.entity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.luv2code.springboot.Ertapp.entity.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Integer> {

//	@Query("update from employee_details set attendance=:attend where employee_id=:empId")
//	String update(@Param("attend") String attendance);
//	String update(@Param("empId") int id);
//	Employee save(String attendance);
//	Employee save(int id);
	
	
}
