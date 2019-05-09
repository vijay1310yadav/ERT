import { Employee } from './models/employee.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
// import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) { }

  public getAllEmployee(): Observable<any> {


    return this.http.get('http://localhost:7070/ert/employeedetails');
  }

  public deleteEmployee(empId: number) {
    console.log(empId);
    return this.http.delete('http://localhost:7070/ert/employeedetails/' + empId);
  }
}
