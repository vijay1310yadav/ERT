import { HttpClient } from '@angular/common/http';
import { Employee } from './../models/employee.model';
import { EmployeeService } from './../employee.service';
import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss']
})
export class Tab2Page {
  emp;
  status;
  stat;
  employees;

  constructor(private empService: EmployeeService, private http: HttpClient, private route: Router) {
    // empService.getAllEmployee().subscribe((employee) => {
    //   this.employee = employee;
    // });
    this.emp = empService.getAllEmployee();
    this.emp.subscribe((response) => {
      console.log(response);
      this.employees = response;
    })



    this.status = empService.getAllEmployeeStatus().subscribe((response) => {
      console.log("Get ALL EmployeesSTATUS request", response);

      this.status = response;
      console.log("Status - " + this.status[0].id);
    })
    let value = this.status.id;
    console.log("This is value----" + value);


  }
  onRemove(id) {
    this.empService.deleteEmployee(id).subscribe(resp => console.log(resp));
    console.log("Succesfully deleted" + id);
  }


  onDetails(url) {
    console.log(url);
    this.route.navigateByUrl(url);
  }

}
