import { CommonModule } from '@angular/common';
import { NgModule, ModuleWithProviders } from '@angular/core';
import { ChartModule } from 'smart-webcomponents-angular/chart';
import { DateTimePickerModule } from 'smart-webcomponents-angular/datetimepicker';
import { InputModule } from 'smart-webcomponents-angular/input';
import { PivotTableModule } from 'smart-webcomponents-angular/pivottable';
import { DataChartComponent } from '../reports/analyticalReports/report/chart/chart.component';
import { PieDataChartComponent } from '../reports/analyticalReports/report/pieChart/pieChart.component';
import { AppService } from '../reports/analyticalReports/services/app.service';
import { DrillDownService } from '../reports/analyticalReports/services/drill-down.service';
import { ChartsModule } from 'ng2-charts';

@NgModule({
    imports: [CommonModule,ChartModule,PivotTableModule,DateTimePickerModule,InputModule,ChartsModule],
    declarations:[DataChartComponent, PieDataChartComponent],
    exports: [DataChartComponent, PieDataChartComponent, ChartModule,ChartsModule],
    providers: [DrillDownService, AppService],
})

export class GraphSharedModule { 
    static forRoot(): ModuleWithProviders<GraphSharedModule> {
        return {
            ngModule: GraphSharedModule
        };
    }
    
}