import { Component, Input, OnInit } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { Table } from 'primeng/table';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanContReleaseLinesV } from './rmanContReleaseLinesV';
import { RmanContReleaseLinesVService } from './rmanContReleaseLinesVservice';
declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
  templateUrl: './rmanContReleaseLinesV.component.html',
  selector: 'rmanContReleaseLinesV-data',
  providers: [RmanContReleaseLinesVService]
})

export class RmanContReleaseLinesVComponent implements OnInit {
  noData = appSettings.noData;
  displayDialog: boolean;

  displaySearchDialog: boolean;

  rmanContReleaseLinesV: RmanContReleaseLinesV = new RmanContReleaseLinesVImpl();

  rmanContReleaseLinesVSearch: RmanContReleaseLinesV = new RmanContReleaseLinesVImpl();

  isSerached: number = 0;

  selectedRmanContReleaseLinesV: RmanContReleaseLinesV;

  newRmanContReleaseLinesV: boolean;

  rmanContReleaseLinesVList: RmanContReleaseLinesV[];
  columns: any[];
  paginationOptions = {};

  pages: {};

  datasource: any[];
  pageSize: number;
  totalElements: number;

  collapsed: boolean = true;
  arrIdK: any;
  @Input() pTransHeaderId: number;
  @Input() pTransLineId: number;
  loading: boolean;
  masterData: any;
  showAddColumns = true;
  isSelectAllChecked = true;

  globalCols: any[];
  clonedCols: any[];
  userId: number;
  showPaginator: boolean = true;
  startIndex: number;

  exportCols: string[] = [];
  disableExport: boolean = true;

  constructor(private rmanContReleaseLinesVService: RmanContReleaseLinesVService, private router: Router, private commonSharedService: CommonSharedService, private notificationService: NotificationService) {
    // generate list code
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.arrIdK = event.url.split('/')[3];
      }
    });
  }

  ngOnInit() {

    this.getAllRmanContReleaseLinesV();
    this.globalCols = [

      { field: 'releaseLevel', header: 'Release Level', showField: true, display: "table-cell", type: 'text', drag: false },
      { field: 'ruleName', header: 'Rule Name', showField: true, display: "table-cell", type: 'text', drag: false },
      { field: 'templateName', header: 'Template Name', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'sourceHeader', header: 'Doc Number', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'sourceLineNumber', header: 'Doc Line Number', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'elementType', header: 'Element Type', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'productGroup', header: 'Product Group', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'productCategory', header: 'Product Category', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'productName', header: 'Product Name', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'applyType', header: 'Apply Type', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'revenue', header: 'Revenue', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'cogs', header: 'Cogs', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'releaseRevenue', header: 'Release Revenue', showField: true, display: "table-cell", type: 'text' },
      { field: 'releaseCogs', header: 'Release Cogs', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'event', header: 'Event', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'releaseType', header: 'Release Type', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'releaseDate', header: 'Release Date', showField: true, display: "table-cell", type: 'date', drag: true },
      { field: 'customerPayment', header: 'Customer Payment', showField: true, display: "table-cell", type: 'text', drag: true }
    ];
    this.columns = [];
    this.getTableColumns("rmanContReleaseLinesV", "Release Lines");

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
    this.commonSharedService.saveOrUpdateTableColumns("rmanContReleaseLinesV", "Release Lines", selectedCols, this.userId).then((response) => {
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

  exportExcel() {
    this.exportCols = [];
    for (let index = 0; index < this.columns.length; index++) {
      if (this.columns[index].showField) {
        this.exportCols.push(this.columns[index].field);
      }
    }

    let serviceUrl = this.rmanContReleaseLinesVService.getServiceUrl(this.paginationOptions, { 'dealArrangementId': this.arrIdK, 'transHeaderId': this.pTransHeaderId }, 1, this.exportCols);
    window.location.href = serviceUrl;

  }

  reset(dt: Table) {
    dt.reset();
    this.paginationOptions = {};
    this.rmanContReleaseLinesV = new RmanContReleaseLinesVImpl();
    this.getAllRmanContReleaseLinesV();
  }

  parentCall(data) {
    this.masterData = data;
    if (data != '') {
      this.pTransHeaderId = data.transHeaderId;
      this.pTransLineId = data.transLineId;
      this.getAllRmanContReleaseLinesV();
    } else {
      this.pTransHeaderId = null;
      this.rmanContReleaseLinesVList = [];

    }
  }

  getAllRmanContReleaseLinesV() {
    this.rmanContReleaseLinesV.transHeaderId = this.pTransHeaderId;
    this.rmanContReleaseLinesV.transLineId = this.pTransLineId;
    this.loading = true;
    this.rmanContReleaseLinesVService.getAllRmanContReleaseLinesV(this.paginationOptions, { 'dealArrangementId': this.arrIdK, 'transLineId': this.pTransLineId }, this.exportCols).then((rmanContReleaseLinesVList: any) => {
      this.datasource = rmanContReleaseLinesVList.content;
      if (this.pTransHeaderId != null) {
        this.rmanContReleaseLinesVList = rmanContReleaseLinesVList.content.filter((item: any) => item.transHeaderId == this.pTransHeaderId);
      } else {
        this.rmanContReleaseLinesVList = rmanContReleaseLinesVList.content;
      }
      this.totalElements = rmanContReleaseLinesVList.totalElements;
      this.pageSize = rmanContReleaseLinesVList.size;
      this.loading = false;
      this.displaySearchDialog = false;
      this.disableExport = false;
    });
  }


  getRmanContReleaseLinesV(event: any) {
    this.rmanContReleaseLinesV.transHeaderId = this.pTransHeaderId;
    this.rmanContReleaseLinesV.transLineId = this.pTransLineId;

    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loading = true;
    this.rmanContReleaseLinesVService.getAllRmanContReleaseLinesV(this.paginationOptions, { 'dealArrangementId': this.arrIdK }, this.exportCols).then((rmanContReleaseLinesVList: any) => {
      this.datasource = rmanContReleaseLinesVList.content;
      if (this.pTransHeaderId != null) {
        this.rmanContReleaseLinesVList = rmanContReleaseLinesVList.content.filter((item: any) => item.transHeaderId == this.pTransHeaderId);
      } else {
        this.rmanContReleaseLinesVList = rmanContReleaseLinesVList.content;
        this.isSerached = 0;
      }
      this.totalElements = rmanContReleaseLinesVList.totalElements;
      this.pageSize = rmanContReleaseLinesVList.size;
      this.loading = false;
      this.disableExport = false;
    });

  }

  showDialogToAdd() {
    this.newRmanContReleaseLinesV = true;
    this.rmanContReleaseLinesV = new RmanContReleaseLinesVImpl();
    this.displayDialog = true;
  }


  save() {
    if (this.newRmanContReleaseLinesV) {
      this.rmanContReleaseLinesVService.saveRmanContReleaseLinesV(this.rmanContReleaseLinesV).then((response: any) => {
        this.getAllRmanContReleaseLinesV();
      });
    }
    else {
      this.rmanContReleaseLinesVService.updateRmanContReleaseLinesV(this.rmanContReleaseLinesV).then((response: any) => {
        this.getAllRmanContReleaseLinesV();
      });
    }
    this.rmanContReleaseLinesV = new RmanContReleaseLinesVImpl();
    this.displayDialog = false;
  }


  delete(rmanContReleaseLinesV: any) {
    this.rmanContReleaseLinesV = rmanContReleaseLinesV;
    this.displayDialog = false;
    if (window.confirm('Are you sure you want to delete this record?')) {
      this.rmanContReleaseLinesVList.splice(this.findSelectedRmanContReleaseLinesVIndex(), 1);
      this.rmanContReleaseLinesVService.deleteRmanContReleaseLinesV(this.rmanContReleaseLinesV).then(response => {
        this.rmanContReleaseLinesV = new RmanContReleaseLinesVImpl();
        this.getAllRmanContReleaseLinesV();
      });
    }

  }

  editRow(rmanContReleaseLinesV: any) {
    this.newRmanContReleaseLinesV = false;
    this.rmanContReleaseLinesV = this.cloneRmanContReleaseLinesV(rmanContReleaseLinesV);
    this.displayDialog = true;

  }


  findSelectedRmanContReleaseLinesVIndex(): number {
    return this.rmanContReleaseLinesVList.indexOf(this.selectedRmanContReleaseLinesV);
  }

  onRowSelect(event: any) {

  }

  cloneRmanContReleaseLinesV(c: RmanContReleaseLinesV): RmanContReleaseLinesV {
    let rmanContReleaseLinesV = new RmanContReleaseLinesVImpl();
    for (let prop in c) {
      rmanContReleaseLinesV[prop] = c[prop];
    }
    return rmanContReleaseLinesV;
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

    this.rmanContReleaseLinesVSearch = new RmanContReleaseLinesVImpl();

    if (this.isSerached == 0) {
      this.rmanContReleaseLinesVSearch = new RmanContReleaseLinesVImpl();
    }
    this.displaySearchDialog = true;

  }

  search() {

    this.isSerached = 1;
    this.rmanContReleaseLinesV = this.rmanContReleaseLinesVSearch;
    this.getAllRmanContReleaseLinesV();
  }

  onBeforeToggle(evt: any) {
    this.collapsed = evt.collapsed;
  }
}


export class RmanContReleaseLinesVImpl implements RmanContReleaseLinesV {
  constructor(public transHeaderId?: any, public transLineId?: any, public productGroup?: any, public sourceLineNumber?: any, public sourceHeader?: any, public revenue?: any, public releaseCogs?: any, public cogs?: any, public ruleName?: any, public releaseLevel?: any, public elementType?: any, public applyType?: any, public productName?: any, public dealArrangementId?: any, public event?: any, public releaseType?: any, public templateName?: any, public productCategory?: any, public releaseRevenue?: any, public releaseLineId?: any, public customerPayment?: any, public releaseDate?: any) { }
}

interface ILabels {
  [index: string]: string;
}
