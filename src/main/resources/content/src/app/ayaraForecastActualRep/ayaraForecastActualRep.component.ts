import { Location } from '@angular/common';
import { Component, Injectable } from '@angular/core';
import { Table } from 'primeng/table';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { AyaraForecastActualRepService } from './ayaraForecastActualRepService';


declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Injectable()
@Component({
  templateUrl: './ayaraForecastActualRep.component.html',
  selector: 'ayaraForecastActualRep-data',
  providers: [AyaraForecastActualRepService,RmanLookupsVService]
})


export class AyaraForecastActualRepComponent {

  paginationOptions: any;
  ayaraForecastActualRepList: any[];
  ayaraForecastActualList: any[];
  data: any[];
  columns: any[] = [];
  pageSize: number;
  totalElements: number;
  periodType: any;
  rowCount: any;
  displayDialog: boolean;
  periodTypesList: any[] = [];
  rmanLookupsVList: any[] = [];
  rmanLookupsV: any[];
  totalRecords: any;

  noData = appSettings.noData;
  loading: boolean;
  collapsed: boolean = false;
  _dataTable: any;

  showAddColumns = true;
  isSelectAllChecked = true;
  //globalCols: any[];
  clonedCols: any[];
  userId: number;
  showPaginator: boolean = true;
  startIndex: number;

  exportCols: string[] = [];
  disableExport: boolean = true;

  constructor(private ayaraForecastActualRepService: AyaraForecastActualRepService, private rmanLookupsVService: RmanLookupsVService,private commonSharedService: CommonSharedService, private notificationService: NotificationService, private location: Location) {
    //this.globalCols = [];
    this.getAllAyaraForecastActualRep();
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
  }

  ngOnInit() {
    this.rowCount = 20;
    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'ACCOUNT_PERIOD_TYPE' }).then((rmanLookupsVList: any) => {
      this.rmanLookupsVList = rmanLookupsVList.content;
      this.prepareRmanLookupsVObject();
    });



  }

  goToOperationReports() {
    this.location.back();
  }

  onBeforeToggle(evt: any) {
    this.collapsed = evt.collapsed;
  }
  
  paginate(data) {
    this.loading = true;
    this.ayaraForecastActualRepList = this.ayaraForecastActualList.slice(data.first, data.first + 10);
    this.loading = false;
  }

  onRowSelect(data) {
  }

  getAllAyaraForecastActualRep() {
    this.loading = true;
    this.ayaraForecastActualRepService.getAyaraForecastActualRep(this.periodType).then((data: any) => {
      this.ayaraForecastActualRepList = data.Content;
      this.ayaraForecastActualList = data.Content;
      let dTemp: any = this.ayaraForecastActualRepList[0];
      this.columns = [];
      for (let prop in dTemp) {
        this.columns.push({
          field: prop,
          header: prop,
          style: { 'width': '100px', 'text-align': 'right' },
          display: 'table-cell',
          showField: true,
          text: "right",
          drag: true
        });

      }


      let leftAlignItems = ["PRODUCT_NAME", "FA_CATEGORY"];

      for (let index = 0; index < this.columns.length; index++) {
        if (leftAlignItems.indexOf(this.columns[index].header) == -1) {
          this.columns[index].text = "right";
        } else {
          this.columns[index].text = "left";
        }
      }

      this.ayaraForecastActualRepList = data.Content.slice(0, 10);
      this.totalRecords = data.Content.length;
      this.loading = false;
      console.log(this.columns);
      //this.columns = [];
     
      this.disableExport = false;

    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }




  showDialogToSearch() {
    this.periodType = '';
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

    let exportServiceUrl = this.ayaraForecastActualRepService.exportAyaraForecastActualRepFile(this.periodType,this.exportCols);
    window.location.href = exportServiceUrl;
  }

  
  prepareRmanLookupsVObject(): any {
		let rmanLookupsVTempObj: any = [];
		rmanLookupsVTempObj.push({ label: '--Select Account Period Type--', value: null });
		this.rmanLookupsVList.forEach((rmanLookupsV) => {
			rmanLookupsVTempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
		});
		this.rmanLookupsV = rmanLookupsVTempObj;
  }


  search() {
    this.getAllAyaraForecastActualRep();
    this.displayDialog = false;
  }

  reset(dt: Table) {
    this.periodType = '';
    this.getAllAyaraForecastActualRep();
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
