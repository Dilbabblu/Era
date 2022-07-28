import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { GraphSharedModule } from 'src/app/shared/graphShared.module';
import { DateTimePickerModule } from 'smart-webcomponents-angular/datetimepicker';
import { InputModule } from 'smart-webcomponents-angular/input';
import { PivotTableModule } from 'smart-webcomponents-angular/pivottable';
import { NewSharedModule } from '../../../shared/shared.module';
import { DataTableComponent } from './data-table/data-table.component';
import { ReportComponent } from './report.component';


const routes: Routes = [
  {path: '', component: ReportComponent},
];

@NgModule({
  declarations: [DataTableComponent, ReportComponent],
  imports: [
    NewSharedModule,
    CommonModule,
    FormsModule,
    HttpClientModule,
    CommonModule,
    GraphSharedModule,
    PivotTableModule,
    DateTimePickerModule,
    InputModule,
    RouterModule.forChild(routes),
  ],
  bootstrap: [ReportComponent],
  providers: []
})
export class ReportModule {}
