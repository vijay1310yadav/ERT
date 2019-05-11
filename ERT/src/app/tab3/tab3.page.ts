import { Employee } from './../models/employee.model';
import { Component } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { url } from 'inspector';

@Component({
  selector: 'app-tab3',
  templateUrl: 'tab3.page.html',
  styleUrls: ['tab3.page.scss']
})
export class Tab3Page {

  emp;
  employees
  body: any;
  statusValue;
  changedStatus: string;

  constructor(private empService: EmployeeService, private http: HttpClient, private route: Router) {

    this.emp = this.empService.getAllEmployee();

    this.emp.subscribe((response) => {
      console.log(response);
      this.employees = response;
    });



    console.log("This is new body");


  }



  onChange(value) {
    console.log("This is the value", value);
    this.statusValue = value;
    // let newBody = {
    //   "id": 1,
    //   "imageUrl": "https://i.stack.imgur.com/dWrvS.png",
    //   "firstName": "Vijay",
    //   "lastName": "Yadav",
    //   "emailId": "vijay@karma.com",
    //   "dob": "1994",
    //   "department": "I.T.",
    //   "attendance": false,
    //   "status": this.statusValue
    // };
    return this.statusValue;


    // this.empService.updateEmployeeStatus(newBody);
    // this.http.post('http://localhost:8080/ert/employeedetails', newBody);

    // console.log(newBody);
  }



}


