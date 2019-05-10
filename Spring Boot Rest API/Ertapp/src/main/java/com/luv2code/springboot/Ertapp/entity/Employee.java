package com.luv2code.springboot.Ertapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_details")
public class Employee {
	
	//define field
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employee_id")
	private int id;
	@Column(name="image_url")
	private String imageUrl;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email_id")
	private String emailId;
	@Column(name="dob")
	private String dob;
	@Column(name="department")
	private String department;
	@Column(name="attendance")
	private boolean attendance;
	@Column(name="status")
	private String status;
	
	//define constructors
	public Employee() {
		
	}
	

	public Employee(int id, String imageUrl, String firstName, String lastName, String emailId, String dob,
			String department, boolean attendance, String status) {
		this.id = id;
		this.imageUrl = imageUrl;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.dob = dob;
		this.department = department;
		this.attendance = attendance;
		this.status = status;
	}


	//define getter/setter

	public boolean isAttendance() {
		return attendance;
	}


	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public void setAttendance(boolean attendance) {
		this.attendance = attendance;
	}





	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getImageUrl() {
		return imageUrl;
	}



	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getDob() {
		return dob;
	}



	public void setDob(String dob) {
		this.dob = dob;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", imageUrl=" + imageUrl + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", dob=" + dob + ", department=" + department + ", attendance=" + attendance
				+ ", status=" + status + "]";
	}
	





	


	
	
	
	

	

}
