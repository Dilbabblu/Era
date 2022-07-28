import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { GraphSharedModule } from 'src/app/shared/graphShared.module';
import { DateTimePickerModule } from 'smart-webcomponents-angular/datetimepicker';
import { InputModule } from 'smart-webcomponents-angular/input';
import { PivotTableModule } from 'smart-webcomponents-angular/pivottable';
import { NewSharedModule } from '../../../../shared/shared.module';
import { DataTableComponent } from '.././data-table/data-table.component';

import { ChartsModule } from 'ng2-charts';
import { DataChartComponent } from './chart.component';

@NgModule({
  declarations: [DataChartComponent],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule.forChild([{ path: '', component: DataChartComponent }]),
    ChartsModule,
    NewSharedModule,
    GraphSharedModule
  ],
  exports: [ChartsModule, GraphSharedModule]
})

export class DataChartModule {}