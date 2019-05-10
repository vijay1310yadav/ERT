import { Employee } from './models/employee.model';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
// import { Observable } from 'rxjs';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) { }

  public getAllEmployee(): Observable<any> {


    return this.http.get('http://localhost:8080/ert/employeedetails');
  }



  public deleteEmployee(empId: number) {
    console.log(empId);
    let url = 'http://localhost:8080/ert/employeedetails/' + empId;

    console.log(url, "\tThis is the URL");

    return this.http.delete(url, httpOptions);
  }

  public getEmployeeById(empId: number) {
    console.log(empId);
    let url = 'http://localhost:8080/ert/employeedetails/' + empId;
    let response = this.http.get(url);
    response.subscribe(response => (console.log("This is response", response)));
    return response;
  }

  getAllEmployeeStatus() {

    return this.http.get('http://localhost:8080/ert/employeestatus');
  }
}
