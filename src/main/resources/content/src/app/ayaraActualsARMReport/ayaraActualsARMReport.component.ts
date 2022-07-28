import { Location } from '@angular/common';
import { Component, Injectable,Input, ViewChild } from '@angular/core';
import { Table } from 'primeng/table';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { AyaraActualsARMReportService } from './ayaraActualsARMReportservice';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import { Label } from 'ng2-charts';


declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Injectable()
@Component({
  templateUrl: './ayaraActualsARMReport.component.html',
  selector: 'ayaraActualsARMReport-data',
  providers: [AyaraActualsARMReportService]
})


export class AyaraActualsARMReportComponent {

  paginationOptions: any;
  data: any[];
  columns: any[] = [];
  pageSize: number;
  totalElements: number;
  fromDate: any;
  toDate: any;
  quoteStatus: any;
  rowCount: any;
  actualsARMRepList: any[];
  actualsARMList: any[];
  displayDialog: boolean;
  entities: any[] = [];
  totalRecords: any;
  
  quoteStatusList:any[]=[];
  quoteStatuses:any[];

  noData = appSettings.noData;
  loading: boolean;
  collapsed: boolean = false;
  _dataTable: any;

  showAddColumns = true;
  isSelectAllChecked = true;
  globalCols: any[];
  clonedCols: any[];
  userId: number;
  showPaginator: boolean = true;
  startIndex: number;

  exportCols: string[] = [];
  disableExport: boolean = true;
  arrgLevel: string ='S';
  arrgLevelSwitch: boolean = false;

  showCharts:boolean = false;
  public barChartOptions: ChartOptions = {
    responsive: true,
    legend:{
      position: 'bottom',
    }
  };
  public barChartLabels: Label[]; //= ['P1', 'P2', 'P3', 'P4', 'P5'];
  public barChartType: ChartType = 'bar';
  public barChartLegend = true;
  public barChartPlugins = [];

  public barChartData: ChartDataSets[] = [
   // { data: [65, 59, 80, 81, 56, 55, 40], label: 'Allocation Amount' },
  ];
  chartReady:boolean = false;

  constructor(private ayaraActualsARMReportService: AyaraActualsARMReportService, private rmanLookupsVService: RmanLookupsVService, private location: Location, private commonSharedService: CommonSharedService, private notificationService: NotificationService) {
    this.globalCols = [];
    this.getAllAyaraActualsARMReport();
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    this.getChartsData();
  /*  this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'QUOTE_STATUS_LIST' }).then((rmanLookupsVList: any) => {
            this.quoteStatusList = rmanLookupsVList.content;
            this.prepareQuoteStatusObject();
	});*/
  }

  ngOnInit() {
    this.rowCount = 20;
  }

  getTableColumns(pageName: string, tableName: string) {
    this.isSelectAllChecked = true;
    this.commonSharedService.getConfiguredColDetails(pageName, tableName).then((response) => {
      if (response && response != null && response.userId) {
        this.columns = [];
        let colsList = response.tableColumns.split(",");
        if (colsList.length > 0) {
          colsList.forEach((item, index) => {
            if (item) {
              this.startIndex = this.globalCols.findIndex(col => col.field == item);
              this.onDrop(index);
            }
          });
        }
        this.globalCols.forEach(col => {
          if (response.tableColumns.indexOf(col.field) !== -1) {
            this.columns.push(col);
          } else {
            col.showField = false;
          }
        });
        if (this.columns.length != this.globalCols.length) this.isSelectAllChecked = false;
        this.showPaginator = this.columns.length !== 0;
        this.userId = response.userId;
      } else {
        this.columns = this.globalCols;
      }
    }).catch(() => {
      this.notificationService.showError('Error occured while getting table columns data');
      this.loading = false;
    });
  }

  saveColumns() {
    let selectedCols = "";
    this.showAddColumns = !this.showAddColumns;
    const colLength = this.globalCols.length - 1;
    this.globalCols.forEach((col, index) => {
      if (col.showField) {
        selectedCols += col.field;
        if (index < colLength) {
          selectedCols += ",";
        }
      }
    });
    this.loading = true;
    this.commonSharedService.saveOrUpdateTableColumns("ayaraActualsARMReport", "Ayara Actuals ARM Report", selectedCols, this.userId).then((response) => {
      this.columns = this.globalCols.filter(item => item.showField);
      this.userId = response["userId"];
      this.showPaginator = this.columns.length !== 0;
      this.loading = false;
    }).catch(() => {
      this.notificationService.showError('Error occured while saving');
      this.loading = false;
    });
  }

  onDragStart(index: number) {
    this.startIndex = index;
  }
  
 /* prepareQuoteStatusObject() {
        let rmanLookupsVTempObj: any = [{ label: appSettings.dropDownOptions.selectQuoteStatus, value: null }];
        this.quoteStatusList.forEach((rmanLookupsV) => {
            rmanLookupsVTempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
        });

        this.quoteStatuses = rmanLookupsVTempObj;

    }*/

  onDrop(dropIndex: number) {
    const general = this.globalCols[this.startIndex]; // get element
    this.globalCols.splice(this.startIndex, 1);       // delete from old position
    this.globalCols.splice(dropIndex, 0, general);    // add to new position
  }

  selectColumns(col: any) {
    let cols = this.globalCols.filter(item => !item.showField);
    if (cols.length > 0) {
      this.isSelectAllChecked = false;
    } else {
      this.isSelectAllChecked = true;
    }
  }

  
  onSwitch(){
   
    if(this.arrgLevelSwitch == false){
      this.arrgLevel = 'S';
    }else{
      this.arrgLevel = 'L';
    }
    this.getAllAyaraActualsARMReport();
    this.getChartsData();
  }

  onSelectAll() {
    this.isSelectAllChecked = !this.isSelectAllChecked;
    this.globalCols.forEach(col => {
      if (this.isSelectAllChecked) {
        col.showField = true;
      } else {
        if (col.drag) {
          col.showField = false;
        }
      }
    });
  }

  onConfiguringColumns(event: any) {
    this.clonedCols = JSON.parse(JSON.stringify(this.globalCols));
    this.showAddColumns = false;
  }

  closeConfigureColumns(event: any) {
    this.showAddColumns = true;
    this.globalCols = this.clonedCols;
    let configCol = this.globalCols.filter(item => !item.showField);
    this.isSelectAllChecked = !(configCol.length > 0);
  }

  goToOperationReports() {
    this.location.back();
  }


  onBeforeToggle(evt: any) {
    this.collapsed = evt.collapsed;
  }
  paginate(data) {
    this.loading = true;
    this.actualsARMRepList = this.actualsARMList.slice(data.first, data.first + 10);
    this.loading = false;
  }

  onRowSelect(data) {
  }

  getAllAyaraActualsARMReport() {
    this.globalCols = [];
    this.loading = true;
    this.ayaraActualsARMReportService.getAyaraActualsARMReport(this.arrgLevel, this.fromDate, this.toDate).then((data: any) => {
      this.actualsARMRepList = data.Content;
      this.actualsARMList = data.Content;
      let dTemp: any = this.actualsARMRepList[0];
      for (let prop in dTemp) {
        this.globalCols.push({
          field: prop,
          header: prop,
          style: { 'width': '100px', 'text-align': 'right' },
          display: 'table-cell',
          showField: true,
          text: "right",
          drag: true,
          type: "number"
        });

      }

     let leftAlignItems = ["Revenue Contract Number","Quote Number","Quote Status","Order Number","Quote Date","Geo","Country", "Legal Entity Name", "Account Name", "Currency", "Product Name"];
     // let leftAlignItems =[];
      for (let index = 0; index < this.globalCols.length; index++) {
        if (leftAlignItems.indexOf(this.globalCols[index].header) == -1) {
          this.globalCols[index].text = "right";
          this.globalCols[index].type ="number";
        } else {
          this.globalCols[index].text = "left";
          this.globalCols[index].type ="text";
        }
      }

      this.actualsARMRepList = data.Content.slice(0, 10);
      this.totalRecords = data.Content.length;
      this.loading = false;

      this.columns = [];
      this.getTableColumns("ayaraActualsARMReport", "Ayara Actuals ARM Report");
      this.disableExport = false;

    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }




  showDialogToSearch() {
    this.fromDate = '';
    this.toDate = '';
   // this.quoteStatus = '';
   // this.prepareQuoteStatusObject();
    this.displayDialog = true;
  }
  
  exportCSVfile() {
    this.exportCols = [];

    for (let index = 0; index < this.columns.length; index++) {
      if (this.columns[index].showField) {
        var header = this.columns[index].header;
        this.exportCols.push(header.replace(/[#$/()]/g, ''));
      }
    }

    let exportServiceUrl = this.ayaraActualsARMReportService.getAyaraActualsARMReportFile(this.arrgLevel, this.fromDate, this.toDate, this.exportCols);
    window.location.href = exportServiceUrl;
  }



  search() {
    this.getAllAyaraActualsARMReport();
    this.getChartsData();
    this.displayDialog = false;
  }

  reset(dt: Table) {
    
    this.fromDate = '';
    this.toDate = '';
    this.quoteStatus = '';
    this.arrgLevel = 'S';
    this.arrgLevelSwitch = false;
    this.getAllAyaraActualsARMReport();
    this.getChartsData();
    this.displayDialog = false;
  }

  fieldType(fieldValue: any) {
    return typeof fieldValue;
  }

  isDateField(fieldName: any) {

    if (fieldName.search('Date') == -1) {
      return false;
    } else {
      return true;
    }
  }

  displayCharts(){
    this.showCharts = true;
  }

  closeCharts(){
    this.showCharts = false;
  }

  getChartsData() {
  
    this.ayaraActualsARMReportService.getAyaraActualsARMChart(this.arrgLevel, this.fromDate, this.toDate).then((data: any) => {
      let dataSource = data.Content;
      console.log(dataSource);
     if(this.arrgLevel == 'S'){
        let labels: any[] =[];
        let values: any[]=[];
        this.barChartLabels = [];
        this.barChartData=[];
        dataSource.forEach(element => {
          var d = new Date(element["Booked Date"]);
          labels.push(d.getDate() + '-' + (d.getMonth()+1) + '-' + d.getFullYear());
          values.push(element["Total ARM Revenue Price"])
          
        });
        this.barChartLabels = labels; //x-axis
        this.barChartData.push({data: values, label: 'Total ARM Revenue Price'}); //y-axis
        console.log(this.barChartLabels);
        console.log(this.barChartData);
        this.chartReady = true;
    }else if(this.arrgLevel == 'L'){
      let labels: any[] =[];
      let values: any[]=[];
      this.barChartLabels = [];
      this.barChartData=[];
      dataSource.forEach(element => {
        labels.push(element["Product Name"]);
        values.push(element["ARM Revenue Price"]);
        
      });
      this.barChartLabels = labels; //x-axis
      this.barChartData.push({data: values, label: 'ARM Revenue Price'}); //y-axis
      console.log(this.barChartLabels);
      console.log(this.barChartData);
      this.chartReady = true;
    }

    }).catch((err: any) => {
      this.notificationService.showError('Error occured while loading chart data');
     
    });

  }



}
