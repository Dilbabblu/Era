import { Component, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NotificationService } from 'src/app/shared/notifications.service';
import { DateTimePickerComponent } from 'smart-webcomponents-angular/datetimepicker';
import { InputComponent } from 'smart-webcomponents-angular/input';
import { DrillDownService } from '../services/drill-down.service';
import { DataChartComponent } from './chart/chart.component';
import { DataTableComponent } from './data-table/data-table.component';
import { DownloadAdapter } from './downloadAdapter';
import { PieDataChartComponent } from './pieChart/pieChart.component';
//import { DownloadAdapter } from './downloadAdapter.ts.bkp';

@Component({
  selector: 'drill-down-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css'],
})
export class ReportComponent {
  public dateRange = {
    startDate: null,
    endDate: null,
  };
  columnData;
  reportId;
  saveAsReportId;
  displaySaveAsDialog = false;
  saveAsReportName: any;
  showTable = false;
  showChart = false;
  showLoading = false;
  saveReportLoading = false;
  

  pieChart:boolean = false;
  verticalBarChart:boolean = false;
  horizontalbarChart:boolean = false;
  
  @ViewChild('datetimepickerto', {
    read: DateTimePickerComponent,
    static: false,
  } as any)
  datetimepickerto: DateTimePickerComponent;
  @ViewChild('dataTable', {
    read: DataTableComponent,
    static: false,
  } as any)
  datatable: DataTableComponent;
  @ViewChild('dataChart',{
    read:DataChartComponent,
    static:false,
  }as any)
  dataChart: DataChartComponent;
  @ViewChild('pieDataChart',{
    read:PieDataChartComponent,
    static:false,
  } as any)
  pieDataChart: PieDataChartComponent;
  @ViewChild('datetimepickerfrom', {
    read: DateTimePickerComponent,
    static: false,
  } as any)
  datetimepickerfrom: DateTimePickerComponent;

  @ViewChild('reportName', { read: InputComponent, static: false } as any)
  reportName: InputComponent;
  constructor(
    public drillDownService: DrillDownService,
    private route: ActivatedRoute,
    private notificationService: NotificationService
  ) {
    this.drillDownService.arrangementsData = [];
    this.route.params.subscribe((params) => {
      if (params.id) {
        //@ts-ignore
        this.showLoading = true;
        this.reportId = params.id;
        this.drillDownService.getReport(params.id).then((data1) => {
          
          let data = JSON.parse(data1.clob);
          data.id = data1.id;

          this.columnData = data.columnData;
          this.datetimepickerfrom.value = new Date(data.dateRange.endDate);
          this.datetimepickerto.value = new Date(data.dateRange.startDate);
          this.reportName.value = data.reportName;
          this.drillDownService.columnDataBackup = this.columnData;
          this.showLoading = false;
        });
      }
    });
  }
  getReport() {
    if (this.datetimepickerfrom.ngValue && this.datetimepickerto.ngValue) {
      let dateRange = {
        startDate: this.datetimepickerto.ngValue,
        endDate: this.datetimepickerfrom.ngValue,
      };
      this.showTable = false;
      this.showLoading = true;
      this.drillDownService.getArrangementData(dateRange, null).then((data) => {
        this.showTable = true;
        this.showLoading = false;
      });
    }
  }
  getColumnAndShowChart() {
    this.drillDownService.verticalBarChart = true;
    this.pieChart = false;
    this.horizontalbarChart = false;
    this.drillDownService.showChart = true;
    this.showTable = false;
    this.datatable.getColumns();
    this.columnData = this.datatable.columnData
  }

  saveReport() {
    if (!this.saveReportLoading) {
      this.saveReportLoading = true;
      this.datatable.getColumns();
      let reportNamee = this.reportName.value ? this.reportName.value : 'Untitled';
      let data1 = {
        reportName: reportNamee,
        dateRange: {
          startDate: this.datetimepickerto.ngValue,
          endDate: this.datetimepickerfrom.ngValue,
        },
        columnData: this.datatable.columnData,
      };
      let data = {
        id:this.reportId,
        clob:JSON.stringify(data1),
        reportName: reportNamee,
        favoriteFlag:'N'
      }
      this.drillDownService.saveReport(data, this.reportId).then(() => {
        this.saveReportLoading = false;
        this.notificationService.showSuccess('Report Saved succesfully');
      });
    }
  }
  saveReportAs(){
    this.displaySaveAsDialog = true;
  }
  saveAs(){
    this.displaySaveAsDialog = false;
    if (!this.saveReportLoading) {
      this.saveReportLoading = true;
      let reportNamee = this.reportName.value ? this.reportName.value : 'Untitled';
      this.datatable.getColumns();
      let data1 = {
        reportName: reportNamee,
        dateRange: {
          startDate: this.datetimepickerto.ngValue,
          endDate: this.datetimepickerfrom.ngValue,
        },
        columnData: this.columnData,
      };
      let data = {
        id:this.saveAsReportId,
        clob:JSON.stringify(data1),
        reportName: reportNamee
      }
      this.drillDownService.saveReport(data, this.saveAsReportId).then(() => {
        this.saveReportLoading = false;
        this.notificationService.showSuccess('Report Saved succesfully');
      });
    }
  }
  cancel(){
    this.displaySaveAsDialog = false;
  }
  // downloadReport(type) {
  //   this.datatable.pivottable.exportData(
  //     type.toLowerCase(),
  //     this.reportName.value ? this.reportName.value : 'Untitled'
  //   );
  // }

  downloadReport(type) {
    if(type == 'pdf') {
      DownloadAdapter.PDF({
        name: this.reportName.value,
        startDate: this.datetimepickerto.ngValue.toLocaleDateString(),
        endDate: this.datetimepickerfrom.ngValue.toLocaleDateString(),
      });
    }
    else if (type == 'xlsx' || type == 'csv') {   
      DownloadAdapter.XLSXCSV(type, {
        name: this.reportName.value,
        startDate: this.datetimepickerto.ngValue.toLocaleDateString(),
        endDate: this.datetimepickerfrom.ngValue.toLocaleDateString(),
      });
    }else {
      this.datatable.pivottable.exportData(
        type.toLowerCase(),
        this.reportName.value ? this.reportName.value : 'Untitled'
      );
    }
  
}

  downloadChart(type:string, isPieChart:boolean){
    if(!isPieChart){
      if(type == "PNG"){
        this.dataChart.chart.saveAsPNG(this.reportName.value ? this.reportName.value : 'Untitled');
      }
      if(type == "PDF"){
        this.dataChart.chart.saveAsPDF(this.reportName.value ? this.reportName.value : 'Untitled', 'landscape');
      }
    }else if(isPieChart){
      if(type == "PNG"){
        this.pieDataChart.chart.saveAsPNG(this.reportName.value ? this.reportName.value : 'Untitled');
      }
      if(type == "PDF"){
        this.pieDataChart.chart.saveAsPDF(this.reportName.value ? this.reportName.value : 'Untitled', 'landscape');
      }
    }

  }
  flipChart(){
    this.drillDownService.verticalBarChart = !this.drillDownService.verticalBarChart;
    this.pieChart = !this.pieChart;
  }
  toggle(){
    this.columnData = this.drillDownService.columnDataBackup;
    this.drillDownService.showChart = false;
    this.showTable = true;
  }
}
