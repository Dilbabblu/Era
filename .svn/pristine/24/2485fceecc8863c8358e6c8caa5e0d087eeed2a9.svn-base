import { Location } from '@angular/common';
import { Component, Injectable } from '@angular/core';
import { Table } from 'primeng/table';
import { RmanFiscalPeriodsService } from '../rmanFiscalPeriods/rmanFiscalPeriodsservice';
import { RmanLegalEntitiesService } from '../rmanLegalEntities/rmanLegalEntitiesservice';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanArrgForecastingDetailReportService } from './rmanArrgForecastingDetailReportservice';


declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Injectable()
@Component({
  templateUrl: './rmanArrgForecastingDetailReport.component.html',
  selector: 'rmanArrgForecastingDetailReport-data',
  providers: [RmanArrgForecastingDetailReportService, RmanFiscalPeriodsService, RmanLegalEntitiesService]
})


export class RmanArrgForecastingDetailReportComponent {

  paginationOptions: any;
  data: any[];
  columns: any[] = [];
  pageSize: number;
  totalElements: number;
  fromPeriod: any;
  toPeriod: any;
  arrgId: any;
  toArrgId: any;
  po: any;
  so: any;
  legalEntity: any;
  rowCount: any;
  arrgForecastRepList: any[];
  arrgForecastList: any[];
  displayDialog: boolean;
  legalEntitiesList: any[] = [];
  fiscalPeriodsList: any[] = [];
  fromPeriodArray: any[] = [];
  entities: any[] = [];
  totalRecords: any;

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

  constructor(private rmanArrgForecastingDetailReportService: RmanArrgForecastingDetailReportService, private rmanFiscalPeriodsService: RmanFiscalPeriodsService, private location: Location, private commonSharedService: CommonSharedService, private notificationService: NotificationService) {
    this.globalCols = [];
    this.getAllRmanForecastingDetailsReport();
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
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
    this.commonSharedService.saveOrUpdateTableColumns("rmanArrgForecastingDetailReport", "Forecasting Details Report", selectedCols, this.userId).then((response) => {
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
    console.log(this.arrgLevelSwitch +"@@@@@@@@@@@"+this.arrgLevel);
   
    this.getAllRmanForecastingDetailsReport();
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
    this.arrgForecastRepList = this.arrgForecastList.slice(data.first, data.first + 10);
    this.loading = false;
  }

  onRowSelect(data) {
  }

  getAllRmanForecastingDetailsReport() {
    this.globalCols = [];
    this.loading = true;
    this.rmanArrgForecastingDetailReportService.getRmanForecastDetailsReport(this.arrgLevel, this.arrgId, this.fromPeriod, this.toPeriod).then((data: any) => {
      this.arrgForecastRepList = data.Content;
      this.arrgForecastList = data.Content;
      let dTemp: any = this.arrgForecastRepList[0];
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

      console.log(this.globalCols);


     let leftAlignItems = ["Revenue Contract Number","Quote Number","Line No","Ayara Line Id"," Parent Line No","Quote Line Id", "Product Name", "Bundle Flag", "Quantity", "Currency"];
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

      this.arrgForecastRepList = data.Content.slice(0, 10);
      this.totalRecords = data.Content.length;
      this.loading = false;

      this.columns = [];
      this.getTableColumns("rmanArrgForecastingDetailReport", "Forecasting Details Report");
      this.disableExport = false;

    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }




  showDialogToSearch() {
    this.fromPeriod = '';
    this.toPeriod = '';
    this.arrgId = null;
    this.displayDialog = true;
  }

  searchPeriod(event: any) {
    let emp = {
      'periodName': event.query
    }
    let temp: any = [];
    this.rmanFiscalPeriodsService.getAllRmanFiscalPeriods(this.paginationOptions, emp).then((data: any) => {
      this.fiscalPeriodsList = data.content;
      this.fiscalPeriodsList.forEach((obj: any) => {
        temp.push(obj.periodName);

      })
      this.fromPeriodArray = temp;

    })
  }

  exportCSVfile() {
    this.exportCols = [];

    for (let index = 0; index < this.columns.length; index++) {
      if (this.columns[index].showField) {
        var header = this.columns[index].header;
        this.exportCols.push(header.replace(/[#$/()]/g, ''));
      }
    }

    let exportServiceUrl = this.rmanArrgForecastingDetailReportService.getRmanForecastingDetailsReportFile(this.arrgLevel, this.arrgId, this.fromPeriod, this.toPeriod, this.exportCols);
    window.location.href = exportServiceUrl;
  }



  search() {
    this.getAllRmanForecastingDetailsReport();
    this.displayDialog = false;
  }

  reset(dt: Table) {
    
    this.arrgId = null;
    this.fromPeriod = '';
    this.toPeriod = '';
    this.arrgLevel = 'S';
    this.arrgLevelSwitch = false;
    this.getAllRmanForecastingDetailsReport();
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


}
