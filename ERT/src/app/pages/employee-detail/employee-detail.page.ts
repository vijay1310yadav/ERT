import { Employee } from './../../models/employee.model';
import { EmployeeService } from './../../employee.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { LoaderService } from 'src/app/service/loader.service';

@Component({
  selector: 'app-employee-detail',
  templateUrl: './employee-detail.page.html',
  styleUrls: ['./employee-detail.page.scss'],
})
export class EmployeeDetailPage {
  empId;
  emp;
  constructor(private route: Router, private activatedRoute: ActivatedRoute,
    private empService: EmployeeService,
    private loaderService: LoaderService,
  ) { }


  ionViewWillEnter() {
    this.empId = this.activatedRoute.snapshot.paramMap.get('id');
    // this.loaderService.presentLoading();
    this.empService.getEmployeeById(this.empId).subscribe(
      (emplResp) => {
        // this.loaderService.dismissLoading();
        this.emp = emplResp;

      }
    );

  }



}
