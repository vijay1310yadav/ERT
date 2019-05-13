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
  // emp;
  // status;
  // stat;
  // statusValue;

  employees: Employee[];
  segmentValue = 'masters';
  newEmployee = {
    employees: []
  };

  masters = {
    employees: []
  };
  safeEmployees = {
    employees: []
  };
  dangerEmployees = {
    employees: []
  };


  constructor(private empService: EmployeeService, private http: HttpClient, private route: Router) {

    empService.getAllEmployee()
      .subscribe((response: Employee[]) => {
        // console.log(response);
        this.masters.employees = response;
        this.safeEmployees.employees = this.masters.employees.filter(i => i.status == 'safe');
        this.dangerEmployees.employees = this.masters.employees.filter(i => i.status == 'danger');

        // console.log(this.safeEmployees.employees, "This is the safe employees list");
        // console.log(this.dangerEmployees.employees, "This is the danger employees list");
        // console.log(this.masters.employees, "This is master.employees, outside the subscribe");
      });

  }

  segmentChanged(value) {
    this.segmentValue = value;

    if (this.segmentValue == 'safeEmployees') {
      this.newEmployee.employees = this.safeEmployees.employees;
    }
    else if (this.segmentValue == 'dangerEmployees') {
      this.newEmployee.employees = this.dangerEmployees.employees;
    }
    else {
      this.newEmployee.employees = this.masters.employees;
    }
  }
}

  // constructor(private empService: EmployeeService, private http: HttpClient, private route: Router) {
  //   this.emp = empService.getAllEmployee();
  //   this.emp.subscribe((response) => {
  //     // console.log(response);
  //     this.employees = response;
  //   })
  // }


    // Update the status of existing employee...

  // onRemove(id, emp: Employee) {
  //   this.empService.deleteEmployee(id, emp).subscribe(resp => console.log(resp));
  //   console.log("Succesfully deleted" + id + emp);
  // }


  // onDetails(url) {
  //   // console.log(url);
  //   this.route.navigateByUrl(url);
  // }

  // onChange(value, empId) {
  //   var temp;
  //   console.log("This is the value", value);
  //   this.statusValue = value;
  //   for (let em of this.employees) {
  //     for (let value in em) {
  //       if (em.id == empId) {

  //         temp = em;
  //       }
  //     }
  //   }
  //   console.log("This is the em " + temp.status);

  //   temp.status = value;
  //   this.empService.updateEmployeeStatus(empId, temp);
  // }
// }
