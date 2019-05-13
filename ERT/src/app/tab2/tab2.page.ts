import { HttpClient } from '@angular/common/http';

import { EmployeeService } from './../employee.service';
import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { Employee } from '../models/employee.model';
@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss']
})
export class Tab2Page {
  emp;
  status;
  stat;
  employees: Employee[];
  statusValue;

  constructor(private empService: EmployeeService, private http: HttpClient, private route: Router) {
    // empService.getAllEmployee().subscribe((employee) => {
    //   this.employee = employee;
    // });
    this.emp = empService.getAllEmployee();
    this.emp.subscribe((response) => {
      // console.log(response);
      this.employees = response;
    })



    // Update the status of existing employee...




    // this.status = empService.getAllEmployeeStatus().subscribe((response) => {
    //   console.log("Get ALL EmployeesSTATUS request", response);

    //   this.status = response;
    //   console.log("Status - " + this.status[0].id);
    // })
    // let value = this.status.id;
    // console.log("This is value----" + value);


  }


  onRemove(id, emp: Employee) {
    this.empService.deleteEmployee(id, emp).subscribe(resp => console.log(resp));
    console.log("Succesfully deleted" + id + emp);
  }


  onDetails(url) {
    // console.log(url);
    this.route.navigateByUrl(url);
  }





  onChange(value, empId) {
    var temp;
    console.log("This is the value", value);
    this.statusValue = value;
    for (let em of this.employees) {
      for (let value in em) {
        if (em.id == empId) {

          temp = em;
        }
      }
    }
    console.log("This is the em " + temp.status);

    temp.status = value;
    this.empService.updateEmployeeStatus(empId, temp);

    // let tempEmp: Employee[] = this.employees;
    // console.log(tempEmp, "This is temp Emp");


  }



}
