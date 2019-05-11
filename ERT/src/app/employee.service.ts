import { Employee } from './models/employee.model';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


const httpOptions = {
  headers: new HttpHeaders({ 'Accept': 'application/json', 'Content-Type': '' })
};

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) { }

  public getAllEmployee(): Observable<any> {


    return this.http.get('http://localhost:8080/ert/employeedetails');
  }



  public deleteEmployee(empId: number, emp: Employee) {
    console.log(empId);
    let url = 'http://localhost:8080/ert/employeedetails/remove/' + empId;

    console.log(url, "\tThis is the URL");

    return this.http.post(url, emp);
  }

  public getEmployeeById(empId: number) {
    console.log(empId);
    let url = 'http://localhost:8080/ert/employeedetails/' + empId;
    let response = this.http.get(url);
    response.subscribe(response => (console.log("This is response", response)));
    return response;
  }


  public updateEmployeeStatus(empId, body: any) {

    let url = 'http://localhost:8080/ert/employeedetails/' + empId;
    let response = this.http.post(url, body, httpOptions);
    response.subscribe(reply => {
      console.log("This is Updates response", reply);
      return reply;
    });
  }

  getAllEmployeeStatus() {

    return this.http.get('http://localhost:8080/ert/employeestatus');
  }
}
