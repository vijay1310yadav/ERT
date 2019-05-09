import { HttpClient } from '@angular/common/http';
import { Employee } from './../models/employee.model';
import { EmployeeService } from './../employee.service';
import { Component } from '@angular/core';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss']
})
export class Tab2Page {
  emp;
  employees;

  constructor(private empService: EmployeeService, private http: HttpClient) {
    // empService.getAllEmployee().subscribe((employee) => {
    //   this.employee = employee;
    // });
    this.emp = empService.getAllEmployee();
    this.emp.subscribe((response) => {
      console.log(response);
      this.employees = response;
    })
  }
  onRemove(id) {
    this.empService.deleteEmployee(id);
    console.log("Succesfully deleted" + id);
  }
}
