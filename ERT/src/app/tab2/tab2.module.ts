import { IonicModule } from '@ionic/angular';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Tab2Page } from './tab2.page';
import { EmployeeDetailPage } from '../pages/employee-detail/employee-detail.page';

@NgModule({
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    RouterModule.forChild([{ path: '', component: Tab2Page },
      // {
      //   path: 'employee-detail/:id',
      //   outlet: 'employee-detail',
      //   component: EmployeeDetailPage
      // }
    ])
  ],
  declarations: [Tab2Page]
})
export class Tab2PageModule { }
