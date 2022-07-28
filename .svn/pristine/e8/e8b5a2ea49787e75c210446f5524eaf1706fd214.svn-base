import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Table } from 'primeng/table';
import { RmanLegalEntitiesService } from '../rmanLegalEntities/rmanLegalEntitiesservice';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanReconDealsArggRep } from './rmanReconDealsArggRep';
import { RmanReconDealsArggRepService } from './rmanReconDealsArggRepservice';

declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
  templateUrl: './rmanReconDealsArggRep.component.html',
  selector: 'rmanReconDealsArggRep-data',
  providers: [RmanReconDealsArggRepService, RmanLegalEntitiesService]
})

export class RmanReconDealsArggRepComponent implements OnInit {

  displayDialog: boolean;

  displaySearchDialog: boolean;

  rmanReconDealsArggRep: RmanReconDealsArggRep = new RmanReconDealsArggRepImpl();

  rmanReconDealsArggRepSearch: RmanReconDealsArggRep = new RmanReconDealsArggRepImpl();

  isSerached: number = 0;

  selectedRmanReconDealsArggRep: RmanReconDealsArggRep;

  newRmanReconDealsArggRep: boolean;

  rmanReconDealsArggRepList: RmanReconDealsArggRep[];

  columns: any[];

  paginationOptions = {};

  pages: {};

  _dataTable: any;

  datasource: any[];
  pageSize: number;
  totalElements: number;
  collapsed: boolean = true;
  fromDate: any;
  toDate: any;
  legalEntity: any;
  legalEntitiesList: any[] = [];
  entities: any[] = [];
  loading: boolean
  noData = appSettings.noData;

  showAddColumns = true;
  isSelectAllChecked = true;
  
  globalCols: any[];
  clonedCols: any[];
  userId: number;
  showPaginator: boolean = true;
  startIndex: number;

  exportCols: string[] = [];
  disableExport: boolean = true;


  constructor(private rmanReconDealsArggRepService: RmanReconDealsArggRepService, private rmanLegalEntitiesService: RmanLegalEntitiesService, private location: Location, private commonSharedService: CommonSharedService,
    private notificationService: NotificationService) {

    // generate list code
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '20' };
  }

  ngOnInit() {

    this.rmanLegalEntitiesService.getAllRmanLegalEntities(this.paginationOptions, {}, 'Y').then((data: any) => {
      this.legalEntitiesList = data.content;
      this.getEntities();
    })

    this.globalCols = [
      { field: 'arrangementNumber', header: 'Revenue Contract#', showField: true, display: "table-cell", type: 'number', drag: false },
      { field: 'arrangementLineNum', header: 'Revenue Contract Line#', showField: true, display: "table-cell", type: 'number', drag: false },
      { field: 'dealNumber', header: 'Deal#', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'dealLineNumber', header: 'Deal Line#', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'so', header: 'SO#', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'sourceLineId', header: 'Source Line Id', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'sourceLineNumber', header: 'SO Line#', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'customerName', header: 'Customer Name', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'creationDate', header: 'Creation Date', showField: true, display: "table-cell", type: 'date', drag: true },
      { field: 'arrangementStatus', header: 'Revenue Contract Status', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'sku', header: 'Product Name', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'srcQty', header: 'Quantity (Source)', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'trgQty', header: 'Quantity (Destination)', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'srcUnitPrice', header: 'Unit Price (Source)', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'trgUnitPrice', header: 'Unit Price (Destination)', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'srcAmount', header: 'Amount (Source)', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'trgAmount', header: 'Amount (Destination)', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'currency', header: 'Currency', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'exception', header: 'Exception', showField: true, display: "table-cell", type: 'text', drag: true }
    ];
    this.columns = [];
    this.getTableColumns("rmanReconDealsArggRep", "Reconciliations Quotes/Deals/Sales Order to Revenue Contracts Report");


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
    this.commonSharedService.saveOrUpdateTableColumns("rmanReconDealsArggRep", "Reconciliations Quotes/Deals/Sales Order to Revenue Contracts Report", selectedCols, this.userId).then((response) => {
      this.columns = this.globalCols.filter(item => item.showField);
      this.userId = response["userId"];
      this.showPaginator = this.columns.length !== 0;
      this.loading = false;
    }).catch(() => {
      this.notificationService.showError('Error occured while getting data');
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


  reset(dt: Table) {
    this.paginationOptions = {};
    this.rmanReconDealsArggRep = new RmanReconDealsArggRepImpl();
    this.fromDate = '';
    this.toDate = '';
    this.legalEntity = '';
    dt.reset();
  }

  goToReconciliationReports() {
    this.location.back();
  }


  exportExcel() {

    this.exportCols = [];

    for (let index = 0; index < this.columns.length; index++) {
      if (this.columns[index].showField) {
        this.exportCols.push(this.columns[index].field);
      }
    }

    this.loading = true;
    let exportReconDealsUrl = this.rmanReconDealsArggRepService.exportReconDeals(this.fromDate, this.toDate, this.legalEntity, this.paginationOptions, this.exportCols);
    window.location.href = exportReconDealsUrl;
    this.loading = false;
  }

  getAllRmanReconDealsArggRep() {
    this.loading = true;
    this.rmanReconDealsArggRepService.getAllRmanReconDealsArggRep(this.paginationOptions, this.rmanReconDealsArggRep).then((rmanReconDealsArggRepList: any) => {
      this.datasource = rmanReconDealsArggRepList.content;
      this.rmanReconDealsArggRepList = rmanReconDealsArggRepList.content;
      this.totalElements = rmanReconDealsArggRepList.totalElements;
      this.pageSize = rmanReconDealsArggRepList.size;
      this.loading = false;
      this.displaySearchDialog = false;
      this.disableExport = false;
    });
  }


  getRmanReconDealsArggRep(event: any) {

    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loading = true;
    this.rmanReconDealsArggRepService.searchFields(this.fromDate, this.toDate, this.legalEntity, this.paginationOptions).then((rmanReconDealsArggRepList: any) => {
      this.datasource = rmanReconDealsArggRepList.content;
      this.rmanReconDealsArggRepList = rmanReconDealsArggRepList.content;
      this.totalElements = rmanReconDealsArggRepList.totalElements;
      this.pageSize = rmanReconDealsArggRepList.size;
      this.loading = false;
      this.disableExport = false;
    });

  }


  showDialogToAdd() {

    this.newRmanReconDealsArggRep = true;
    this.rmanReconDealsArggRep = new RmanReconDealsArggRepImpl();
    this.displayDialog = true;

  }

  save() {

    if (this.newRmanReconDealsArggRep) {
      this.rmanReconDealsArggRepService.saveRmanReconDealsArggRep(this.rmanReconDealsArggRep).then((response: any) => {
        this.getAllRmanReconDealsArggRep();
      });
    }
    else {
      this.rmanReconDealsArggRepService.updateRmanReconDealsArggRep(this.rmanReconDealsArggRep).then((response: any) => {
        this.getAllRmanReconDealsArggRep();
      });
    }
    this.rmanReconDealsArggRep = new RmanReconDealsArggRepImpl();
    this.displayDialog = false;

  }


  delete(rmanReconDealsArggRep: any) {
    this.rmanReconDealsArggRep = rmanReconDealsArggRep;
    this.displayDialog = false;

    if (window.confirm('Are you sure you want to delete this record?')) {
      this.rmanReconDealsArggRepList.splice(this.findSelectedRmanReconDealsArggRepIndex(), 1);
      this.rmanReconDealsArggRepService.deleteRmanReconDealsArggRep(this.rmanReconDealsArggRep).then(response => {
        this.rmanReconDealsArggRep = new RmanReconDealsArggRepImpl();
        this.getAllRmanReconDealsArggRep();
      });
    }

  }

  editRow(rmanReconDealsArggRep: any) {
    this.newRmanReconDealsArggRep = false;
    this.rmanReconDealsArggRep = this.cloneRmanReconDealsArggRep(rmanReconDealsArggRep);
    this.displayDialog = true;

  }


  findSelectedRmanReconDealsArggRepIndex(): number {
    return this.rmanReconDealsArggRepList.indexOf(this.selectedRmanReconDealsArggRep);
  }

  onRowSelect(event: any) {

  }

  cloneRmanReconDealsArggRep(c: RmanReconDealsArggRep): RmanReconDealsArggRep {
    let rmanReconDealsArggRep = new RmanReconDealsArggRepImpl();
    for (let prop in c) {
      rmanReconDealsArggRep[prop] = c[prop];
    }
    return rmanReconDealsArggRep;
  }

  hideColumnMenu: boolean = true;

  toggleColumnMenu() {
    if (this.hideColumnMenu) {
      this.hideColumnMenu = false;
    } else {
      this.hideColumnMenu = true;
    }
  }

  showFilter: boolean = false;

  toggleFilterBox() {
    if (this.showFilter) {
      this.showFilter = false;
    } else {
      this.showFilter = true;
    }
  }

  showDialogToSearch() {

    this.rmanReconDealsArggRepSearch = new RmanReconDealsArggRepImpl();

    if (this.isSerached == 0) {
      this.rmanReconDealsArggRepSearch = new RmanReconDealsArggRepImpl();
    }
    this.fromDate = '';
    this.toDate = '';
    this.legalEntity = '';
    this.displaySearchDialog = true;

  }

  search() {

    this.isSerached = 1;
    this.rmanReconDealsArggRep = this.rmanReconDealsArggRepSearch;
    this.getAllRmanReconDealsArggRep();
  }

  onBeforeToggle(evt: any) {
    this.collapsed = evt.collapsed;
  }

  searchFields(dt: Table) {
    this.loading = true;
    dt.reset();
    this.rmanReconDealsArggRepService.searchFields(this.fromDate, this.toDate, this.legalEntity, this.paginationOptions).then((rmanReconDealsArggRepList: any) => {
      this.displaySearchDialog = false;
      this.rmanReconDealsArggRepList = rmanReconDealsArggRepList.content;
      this.totalElements = rmanReconDealsArggRepList.totalElements;
      this.pageSize = rmanReconDealsArggRepList.size;
      this.loading = false;

    })

  }

  getEntities() {
    let entitiesTemp: any[] = [{ label: '--Select Entity Name--', value: null }];
    this.legalEntitiesList.forEach((obj: any) => {
      entitiesTemp.push({ label: obj.name, value: obj.legalEntityId })
    })
    this.entities = entitiesTemp;
  }
}


class RmanReconDealsArggRepImpl implements RmanReconDealsArggRep {
  constructor(public dealLineNumber?: any, public sourceLineNumber?: any, public arrangementNumber?: any, public creationDate?: any, public arrangementStatus?: any, public trgQty?: any, public srcUnitPrice?: any, public trgUnitPrice?: any, public exception?: any, public customerName?: any, public srcQty?: any, public srcAmount?: any, public currency?: any, public arrangementLineNum?: any, public trgAmount?: any, public dealNumber?: any, public so?: any, public sku?: any) { }
}

interface ILabels {
  [index: string]: string;
}
