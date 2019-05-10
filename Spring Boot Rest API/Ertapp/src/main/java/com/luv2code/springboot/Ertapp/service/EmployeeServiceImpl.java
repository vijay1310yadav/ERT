package com.luv2code.springboot.Ertapp.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.luv2code.springboot.Ertapp.entity.Employee;

import com.luv2code.springboot.Ertapp.entity.dao.EmployeeRespository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
//private EntityManager entityManager;
//	
//	//Set up constructor injection
//	
//	@Autowired
//	public EmployeeServiceImpl(EntityManager theEntityManager) {
//		this.entityManager = theEntityManager;
//	}
//    
	private EmployeeRespository employeeRespository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRespository theEmployeeRespository) {
		employeeRespository = theEmployeeRespository;
	}
	
	@Override

	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRespository.findAll();
	}

	@Override
	
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		Optional<Employee> result = employeeRespository.findById(theId);
		
		Employee theEmployee = null;
		
		if(result.isPresent()) {
			theEmployee = result.get();
		}
		else{
		  throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theEmployee;
	}

	@Override
	
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
       employeeRespository.save(theEmployee);
	}

	@Override
	
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
        employeeRespository.deleteById(theId);	
        }

//	@Override
//	public void update(int employeeId, Employee theEmployee,String attendance) {
//		// TODO Auto-generated method stub
//		
//		//get the current hibernet connection
//		Session currentSession = entityManager.unwrap(Session.class);
//
//		//create query
//		
//		Query<Employee> theQuery = 
//				currentSession.createQuery("update from employee_details set attendance=:attend where emp_id=:empId");
//		theQuery.setParameter("empId", employeeId);
//		theQuery.setParameter("attend", attendance);
//		
//		
//		
//		theQuery.executeUpdate();
//		
//		employeeRespository.save(theEmployee);
//		
//	}

}
