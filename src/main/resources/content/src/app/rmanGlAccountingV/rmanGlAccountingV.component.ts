import { Location } from '@angular/common';
import { Component, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Table } from 'primeng/table';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanGlAccountingV } from './rmanGlAccountingV';
import { RmanGlAccountingVService } from './rmanGlAccountingVservice';

declare var require: any;
const appSettings = require('../appsettings');

declare var $: any;

@Component({
  templateUrl: './rmanGlAccountingV.component.html',
  selector: 'rmanGlAccountingV-data',
  providers: [RmanGlAccountingVService]
})

export class RmanGlAccountingVComponent {

  displayDialog: boolean;
  loading: boolean = true;

  displaySearchDialog: boolean;

  rmanGlAccountingV: any = {};

  rmanGlAccountingVSearch: any = {};

  isSerached: number = 0;

  @Input() arrId: any;

  selectedRmanGlAccountingV: RmanGlAccountingV;

  newRmanGlAccountingV: boolean;

  rmanGlAccountingVList: any[] = [];

  columns: any[];

  paginationOptions = {};

  pages: {};

  datasource: any[];
  pageSize: number;
  totalElements: number;
  collapsed: boolean = true;
  
  showAddColumns = true;
  isSelectAllChecked = true;

  globalCols: any[];
  clonedCols: any[];
  userId: number;
  showPaginator: boolean = true;
  startIndex: number;

  exportCols: string[] = [];
  noData = appSettings.noData;
  disableExport: boolean = true;



  constructor(private route: ActivatedRoute, private rmanGlAccountingVService: RmanGlAccountingVService, private location: Location, private commonSharedService: CommonSharedService,
    private notificationService: NotificationService) {

    // generate list code
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };

  }

  ngOnInit() {

    this.route.params.subscribe(params => {
      this.arrId = params['id'];
    });

    this.globalCols = [
      { field: 'dealArrangementNumber', header: 'Revenue Contract#', showField: true, display: "table-cell", type: 'number', drag: false },
      { field: 'dealArrangementName', header: 'Revenue Contract Name', showField: true, display: "table-cell", type: 'text', drag: false },
      { field: 'accountClass', header: 'Account Class', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'orderNumber', header: 'SO#', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'sourceLineId', header: 'Source Line Id', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'sourceLineNumber', header: 'SO Line#', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'dealLineNumber', header: 'Deal Line#', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'lineStatus', header: 'Line Status', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'glDate', header: 'GL Date', showField: true, display: "table-cell", type: 'date', drag: true },
      { field: 'periodName', header: 'Period', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'drCr', header: 'Debit/Credit', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'account', header: 'Account', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'accountDescription', header: 'Account Description', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'currencyCode', header: 'Transaction Currency', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'functionalCurrency', header: 'Functional Currency', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'amountTc', header: 'Amount in TC', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'amountFc', header: 'Amount in FC', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'postedFlag', header: 'Posted Flag', showField: true, display: "table-cell", type: 'text', drag: true }
    ];

    this.columns = [];
    this.getTableColumns("rmanGlAccountingV", "Account Analysis Report");
  }

  goToOperationReports() {
    this.location.back();
  }

  reset(dt: Table) {
    this.paginationOptions = {};
    this.rmanGlAccountingV = {};
    this.rmanGlAccountingVSearch = {};
    dt.reset();
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
    this.commonSharedService.saveOrUpdateTableColumns("rmanGlAccountingV", "Account Analysis Report", selectedCols, this.userId).then((response) => {
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
  getAllRmanGlAccountingV() {
    this.loading = true;
    this.rmanGlAccountingVService.getAllRmanGlAccountingV(this.paginationOptions, this.rmanGlAccountingV, this.exportCols).then((rmanGlAccountingVList: any) => {
      this.loading = false;
      this.datasource = rmanGlAccountingVList.content;
      this.rmanGlAccountingVList = rmanGlAccountingVList.content;
      this.rmanGlAccountingVList = this.rmanGlAccountingVList.slice();
      this.totalElements = rmanGlAccountingVList.totalElements;
      this.pageSize = rmanGlAccountingVList.size;
      this.displaySearchDialog = false;
      this.disableExport = false;
    });
  }


  getRmanGlAccountingV(event: any) {
    this.loading = true;
    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.rmanGlAccountingVService.getAllRmanGlAccountingV(this.paginationOptions, this.rmanGlAccountingV, this.exportCols).then((rmanGlAccountingVList: any) => {
      this.loading = false;
      this.datasource = rmanGlAccountingVList.content;
      this.rmanGlAccountingVList = rmanGlAccountingVList.content;
      this.totalElements = rmanGlAccountingVList.totalElements;
      this.pageSize = rmanGlAccountingVList.size;
      this.disableExport = false;
    });

  }

  exportExcel() {
    this.exportCols = [];
    for (let index = 0; index < this.columns.length; index++) {
      if (this.columns[index].showField) {
        this.exportCols.push(this.columns[index].field);
      }
    }

    let serviceUrl = this.rmanGlAccountingVService.getServiceUrl(this.paginationOptions, this.rmanGlAccountingVSearch, this.exportCols, 1);
    window.location.href = serviceUrl;

  }


  showDialogToAdd() {

    this.newRmanGlAccountingV = true;
    this.rmanGlAccountingV = new RmanGlAccountingVImpl();
    this.displayDialog = true;

  }


  save() {

    if (this.newRmanGlAccountingV) {
      this.rmanGlAccountingVService.saveRmanGlAccountingV(this.rmanGlAccountingV).then((response: any) => {
        this.getAllRmanGlAccountingV();
      });
    }
    else {
      this.rmanGlAccountingVService.updateRmanGlAccountingV(this.rmanGlAccountingV).then((response: any) => {
        this.getAllRmanGlAccountingV();
      });
    }

    this.rmanGlAccountingV = new RmanGlAccountingVImpl();

    this.displayDialog = false;

  }


  delete(rmanGlAccountingV: any) {
    this.rmanGlAccountingV = rmanGlAccountingV;
    this.displayDialog = false;

    if (window.confirm('Are you sure you want to delete this record?')) {
      this.rmanGlAccountingVList.splice(this.findSelectedRmanGlAccountingVIndex(), 1);
      this.rmanGlAccountingVService.deleteRmanGlAccountingV(this.rmanGlAccountingV).then(response => {
        this.rmanGlAccountingV = new RmanGlAccountingVImpl();
        this.getAllRmanGlAccountingV();
      });
    }

  }

  editRow(rmanGlAccountingV: any) {
    this.newRmanGlAccountingV = false;
    this.rmanGlAccountingV = this.cloneRmanGlAccountingV(rmanGlAccountingV);
    this.displayDialog = true;

  }


  findSelectedRmanGlAccountingVIndex(): number {
    return this.rmanGlAccountingVList.indexOf(this.selectedRmanGlAccountingV);
  }

  onRowSelect(event: any) {

  }

  cloneRmanGlAccountingV(c: RmanGlAccountingV): RmanGlAccountingV {
    let rmanGlAccountingV = new RmanGlAccountingVImpl();
    for (let prop in c) {
      rmanGlAccountingV[prop] = c[prop];
    }
    return rmanGlAccountingV;
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
    this.rmanGlAccountingVSearch = {};

    if (this.isSerached == 0) {
      this.rmanGlAccountingVSearch = {};
    }
    this.displaySearchDialog = true;

  }

  search() {

    this.isSerached = 1;
    this.rmanGlAccountingV = this.rmanGlAccountingVSearch;
    this.displaySearchDialog = false;
    this.paginationOptions = {};
    this.getAllRmanGlAccountingV();
  }

  onBeforeToggle(evt: any) {
    this.collapsed = evt.collapsed;
  }

}


export class RmanGlAccountingVImpl implements RmanGlAccountingV {
  constructor(public dealArrangementId?: any, public dealLineNumber?: any, public dealLineId?: any, public accountDescription?: any, public amountFc?: any, public sourceLineNumber?: any, public drCr?: any, public postedFlag?: any, public lineStatus?: any, public glDate?: any, public currencyCode?: any, public periodName?: any, public account?: any, public amountTc?: any, public orderNumber?: any, public rmanInterfaceId?: any, public dealArrangementNumber?: any, public dealArrangementName?: any) { }
}

interface ILabels {
  [index: string]: string;
}
