import { Location } from '@angular/common';
import { Component } from '@angular/core';
import { Table } from 'primeng/table';
import { RmanLegalEntitiesService } from '../rmanLegalEntities/rmanLegalEntitiesservice';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanReconSosrcToBkingsRep } from './rmanReconSosrcToBkingsRep';
import { RmanReconSosrcToBkingsRepService } from './rmanReconSosrcToBkingsRepservice';

declare var require: any;
const appSettings = require('../appsettings');

declare var $: any;

@Component({
  templateUrl: './rmanReconSosrcToBkingsRep.component.html',
  selector: 'rmanReconSosrcToBkingsRep-data',
  providers: [RmanReconSosrcToBkingsRepService, RmanLegalEntitiesService]
})

export class RmanReconSosrcToBkingsRepComponent {

  displayDialog: boolean;

  displaySearchDialog: boolean;

  rmanReconSosrcToBkingsRep: RmanReconSosrcToBkingsRep = new RmanReconSosrcToBkingsRepImpl();

  rmanReconSosrcToBkingsRepSearch: RmanReconSosrcToBkingsRep = new RmanReconSosrcToBkingsRepImpl();

  isSerached: number = 0;

  selectedRmanReconSosrcToBkingsRep: RmanReconSosrcToBkingsRep;

  newRmanReconSosrcToBkingsRep: boolean;

  rmanReconSosrcToBkingsRepList: RmanReconSosrcToBkingsRep[] = [];

  columns: any[];

  columnOptions: any[];

  paginationOptions = {};

  pages: {};


  datasource: any[];
  pageSize: number;
  totalElements: number;
  collapsed: boolean = true;

  fromDate: any;
  toDate: any;
  legalEntity: any;
  legalEntitiesList: any[] = [];
  entities: any[] = [];
  noData = appSettings.noData;
  loading: boolean;

  showAddColumns = true;
  isSelectAllChecked = true;
  
  globalCols: any[];
  clonedCols: any[];
  userId: number;
  showPaginator: boolean = true;
  startIndex: number;
  exportCols: string[] = [];
  disableExport: boolean = true;

  constructor(private rmanReconSosrcToBkingsRepService: RmanReconSosrcToBkingsRepService, private rmanLegalEntitiesService: RmanLegalEntitiesService, private location: Location, private commonSharedService: CommonSharedService,
    private notificationService: NotificationService) {

    // generate list code
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };

  }

  ngOnInit() {
    this.rmanLegalEntitiesService.getAllRmanLegalEntities(this.paginationOptions, {}, 'Y').then((data: any) => {
      this.legalEntitiesList = data.content;
      this.getEntities();
    })

    this.globalCols = [
      { field: 'arrangementNumber', header: 'Linked Revenue Contract#', showField: true, display: "table-cell", type: 'number', drag: false },
      { field: 'arrangementLineNum', header: 'Linked Revenue Contract Line#', showField: true, display: "table-cell", type: 'number', drag: false },
      { field: 'so', header: 'SO#', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'sourceLineId', header: 'Source Line Id', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'sourceLineNumber', header: 'SO Line#', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'bookingEntityName', header: 'Entity', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'bookedDate', header: 'SO Booked Date', showField: true, display: "table-cell", type: 'date', drag: true },
      { field: 'endCustomer', header: 'Customer Name', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'sku', header: 'Product Name', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'srcQty', header: 'Quantity (Source)', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'trgQty', header: 'Quantity (Destination)', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'srcUnitPrice', header: 'Unit Price (Source)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'trgUnitPrice', header: 'Unit Price (Destination)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'srcAmount', header: 'Amount (Source)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'trgAmount', header: 'Amount (Destination)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'exception', header: 'Exception', showField: true, display: "table-cell", type: 'text', drag: true }
    ];

    this.columns = [];
    this.getTableColumns("rmanReconSosrcToBkingsRep", "Reconciliation Sales Order/Service Contracts to Bookings Report");
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
    this.commonSharedService.saveOrUpdateTableColumns("rmanReconSosrcToBkingsRep", "Reconciliation Sales Order/Service Contracts to Bookings Report", selectedCols, this.userId).then((response) => {
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
    this.rmanReconSosrcToBkingsRep = new RmanReconSosrcToBkingsRepImpl();
    this.rmanReconSosrcToBkingsRepSearch = new RmanReconSosrcToBkingsRepImpl();
    this.fromDate = '';
    this.toDate = '';
    this.legalEntity = '';
    dt.reset();
  }

  goToReconciliationReports() {
    this.location.back();
  }


  getAllRmanReconSosrcToBkingsRep() {
    this.loading = true;
    this.rmanReconSosrcToBkingsRepService.getAllRmanReconSosrcToBkingsRep(this.paginationOptions, this.rmanReconSosrcToBkingsRep).then((rmanReconSosrcToBkingsRepList: any) => {
      this.datasource = rmanReconSosrcToBkingsRepList.content;
      this.rmanReconSosrcToBkingsRepList = rmanReconSosrcToBkingsRepList.content;
      this.totalElements = rmanReconSosrcToBkingsRepList.totalElements;
      this.pageSize = rmanReconSosrcToBkingsRepList.size;
      this.loading = false;
      this.displaySearchDialog = false;
      this.disableExport = false;
    });
  }


  getRmanReconSosrcToBkingsRep(event: any) {

    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loading = true;
    this.rmanReconSosrcToBkingsRepService.searchFields(this.fromDate, this.toDate, this.legalEntity, this.paginationOptions).then((rmanReconSosrcToBkingsRepList: any) => {
      this.datasource = rmanReconSosrcToBkingsRepList.content;
      this.rmanReconSosrcToBkingsRepList = rmanReconSosrcToBkingsRepList.content;
      this.totalElements = rmanReconSosrcToBkingsRepList.totalElements;
      this.pageSize = rmanReconSosrcToBkingsRepList.size;
      this.loading = false;
      this.disableExport = false;
    });

  }


  showDialogToAdd() {

    this.newRmanReconSosrcToBkingsRep = true;
    this.rmanReconSosrcToBkingsRep = new RmanReconSosrcToBkingsRepImpl();
    this.displayDialog = true;

  }




  save() {

    if (this.newRmanReconSosrcToBkingsRep) {
      this.rmanReconSosrcToBkingsRepService.saveRmanReconSosrcToBkingsRep(this.rmanReconSosrcToBkingsRep).then((response: any) => {
        this.getAllRmanReconSosrcToBkingsRep();
      });
    }
    else {
      this.rmanReconSosrcToBkingsRepService.updateRmanReconSosrcToBkingsRep(this.rmanReconSosrcToBkingsRep).then((response: any) => {
        this.getAllRmanReconSosrcToBkingsRep();
      });
    }

    this.rmanReconSosrcToBkingsRep = new RmanReconSosrcToBkingsRepImpl();

    this.displayDialog = false;

  }


  delete(rmanReconSosrcToBkingsRep: any) {
    this.rmanReconSosrcToBkingsRep = rmanReconSosrcToBkingsRep;
    this.displayDialog = false;

    if (window.confirm('Are you sure you want to delete this record?')) {
      this.rmanReconSosrcToBkingsRepList.splice(this.findSelectedRmanReconSosrcToBkingsRepIndex(), 1);
      this.rmanReconSosrcToBkingsRepService.deleteRmanReconSosrcToBkingsRep(this.rmanReconSosrcToBkingsRep).then(response => {
        this.rmanReconSosrcToBkingsRep = new RmanReconSosrcToBkingsRepImpl();
        this.getAllRmanReconSosrcToBkingsRep();
      });
    }

  }

  editRow(rmanReconSosrcToBkingsRep: any) {
    this.newRmanReconSosrcToBkingsRep = false;
    this.rmanReconSosrcToBkingsRep = this.cloneRmanReconSosrcToBkingsRep(rmanReconSosrcToBkingsRep);
    this.displayDialog = true;

  }


  findSelectedRmanReconSosrcToBkingsRepIndex(): number {
    return this.rmanReconSosrcToBkingsRepList.indexOf(this.selectedRmanReconSosrcToBkingsRep);
  }

  onRowSelect(event: any) {

  }

  cloneRmanReconSosrcToBkingsRep(c: RmanReconSosrcToBkingsRep): RmanReconSosrcToBkingsRep {
    let rmanReconSosrcToBkingsRep = new RmanReconSosrcToBkingsRepImpl();
    for (let prop in c) {
      rmanReconSosrcToBkingsRep[prop] = c[prop];
    }
    return rmanReconSosrcToBkingsRep;
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

    this.rmanReconSosrcToBkingsRepSearch = new RmanReconSosrcToBkingsRepImpl();

    if (this.isSerached == 0) {
      this.rmanReconSosrcToBkingsRepSearch = new RmanReconSosrcToBkingsRepImpl();
    }
    this.fromDate = '';
    this.toDate = '';
    this.legalEntity = '';
    this.displaySearchDialog = true;

  }

  search() {

    this.isSerached = 1;
    this.rmanReconSosrcToBkingsRep = this.rmanReconSosrcToBkingsRepSearch;
    this.getAllRmanReconSosrcToBkingsRep();
  }

  onBeforeToggle(evt: any) {
    this.collapsed = evt.collapsed;
  }

  exportExcel() {
    this.exportCols = [];
    for (let index = 0; index < this.columns.length; index++) {
      if (this.columns[index].showField) {
        this.exportCols.push(this.columns[index].field);
      }
    }

    this.loading = true;
    let exportReconSrcBkingsUrl = this.rmanReconSosrcToBkingsRepService.exportReconsrcBkings(this.fromDate, this.toDate, this.legalEntity, this.paginationOptions, this.exportCols);
    window.location.href = exportReconSrcBkingsUrl;
    this.loading = false;
  }

  searchFields(dt: Table) {
    this.loading = true;
    this.rmanReconSosrcToBkingsRepService.searchFields(this.fromDate, this.toDate, this.legalEntity, this.paginationOptions).then((rmanReconSosrcToBkingsRepList: any) => {
      this.displaySearchDialog = false;
      this.rmanReconSosrcToBkingsRepList = rmanReconSosrcToBkingsRepList.content;
      this.totalElements = rmanReconSosrcToBkingsRepList.totalElements;
      this.pageSize = rmanReconSosrcToBkingsRepList.size;
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


class RmanReconSosrcToBkingsRepImpl implements RmanReconSosrcToBkingsRep {
  constructor(public sourceLineNumber?: any, public arrangementNumber?: any, public exception?: any, public bookedDate?: any, public trgQty?: any, public srcUnitPrice?: any, public trgUnitPrice?: any, public arrangementLineNum?: any, public srcQty?: any, public srcAmount?: any, public bookingEntityName?: any, public trgAmount?: any, public so?: any, public endCustomer?: any, public sku?: any) { }
}

interface ILabels {
  [index: string]: string;
}
