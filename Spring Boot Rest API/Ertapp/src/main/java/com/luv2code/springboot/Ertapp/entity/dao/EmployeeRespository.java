package com.luv2code.springboot.Ertapp.entity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.Ertapp.entity.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Integer> {

}
