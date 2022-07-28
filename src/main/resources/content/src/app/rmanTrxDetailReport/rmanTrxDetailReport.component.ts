import { Location } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Table } from 'primeng/table';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanTrxDetailReport } from './rmanTrxDetailReport';
import { RmanTrxDetailReportService } from './rmanTrxDetailReportservice';

declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');


@Component({
  templateUrl: './rmanTrxDetailReport.component.html',
  selector: 'rmanTrxDetailReport-data',
  providers: [RmanTrxDetailReportService]
})

export class RmanTrxDetailReportComponent {

  displayDialog: boolean;

  displaySearchDialog: boolean;

  rmanTrxDetailReport: any = {};

  rmanTrxDetailReportSearch: any = {};

  isSerached: number = 0;
  exportFlag: number = 0;
  selectedRmanTrxDetailReport: RmanTrxDetailReport;

  newRmanTrxDetailReport: boolean;

  rmanTrxDetailReportList: RmanTrxDetailReport[];

  cols: any[];
  columns: any[];

  columnOptions: any[];

  paginationOptions = {};

  pages: {};

  transactionReportForm: FormGroup;
  rmanLookupsVList: any[] = [];
  rmanLookupsV: any[];
  datasource: any[];
  pageSize: number;
  totalElements: number;
  collapsed: boolean = true;
  searchFields: any = {};
  noData = appSettings.noData;
  loading: boolean;
  filteredPeriodNameList: any[];
  periodNamePlaceHolder: string;
  backlogOptions: any[];
  showAddColumns = true;
  isSelectAllChecked = true;
  globalCols: any[];
  clonedCols: any[];
  userId: number;
  showPaginator: boolean = true;
  startIndex: number;

  exportCols: string[] = [];
  disableExport: boolean = true;

  constructor(private rmanTrxDetailReportService: RmanTrxDetailReportService,
    private formBuilder: FormBuilder, private location: Location, private commonSharedService: CommonSharedService,
    private notificationService: NotificationService) {

    // generate list code
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    this.periodNamePlaceHolder = "";
    this.backlogOptions = [
      { label: 'Select Backlog', value: null },
      { label: 'Yes', value: 'Y' },
      { label: 'No', value: 'N' }
    ];
    

  }

  ngOnInit() {

    this.globalCols = [
      { field: 'dealArrangementNumber', header: 'Revenue Contract#', showField: true, display: "table-cell", type: 'number', drag: false },
      { field: 'dealArrangementName', header: 'Revenue Contract', showField: true, display: "table-cell", type: 'text', drag: false },
      { field: 'note', header: 'Note Transaction Type', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'contApply', header: 'Cont Apply', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'elementType', header: 'Element Type', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'customerNumber', header: 'Customer#', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'customerName', header: 'Customer', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'po', header: 'PO#', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'orderNumber', header: 'SO#', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'invoiceNumber', header: 'Invoice#', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'deliveredDate', header: 'Delivered Date', showField: true, display: "table-cell", type: 'date', drag: true },
      { field: 'arrangementType', header: 'Revenue Contract Type', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'salesTheater', header: 'Sales Theater', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'region', header: 'Sales Region', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'territory', header: 'Sales Territory', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'dealNumber', header: 'Deal#', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'dealLineNumber', header: 'Deal Line#', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'salesrep', header: 'Sales Rep', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'sourceHeaderId', header: 'Source Header Id', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'sourceLineId', header: 'Source Line Id', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'sourceLineNumber', header: 'Source Line#', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'productName', header: 'Product Name', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'lineStatus', header: 'Line Status', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'orderedQuantity', header: 'Booked Quantity', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'bookedCurrency', header: 'Transaction Currency', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'bookedDate', header: 'Booked Date', showField: true, display: "table-cell", type: 'date', drag: true },
      { field: 'unitListPrice', header: 'List $/U', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'unitSellingPrice', header: 'Sell $/U', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'transactionPrice', header: 'Line AMT$', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'discountPercent', header: 'Discount%', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'productPorfolio', header: 'Product Porfolio', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'productFamily', header: 'Product Family', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'productLine', header: 'Product Line', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'division', header: 'Division', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'serviceStartDate', header: 'Service Start Date', showField: true, display: "table-cell", type: 'date', drag: true },
      { field: 'serviceEndDate', header: 'Service End Date', showField: true, display: "table-cell", type: 'date', drag: true },
      { field: 'sspMin', header: 'SSP Min', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'sspMean', header: 'SSP Mean', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'sspMax', header: 'SSP Max', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'sspHigh', header: 'SSP High', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'sspLow', header: 'SSP Low', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'ssp', header: 'SSP', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'fmvAmount', header: 'SSP Total', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'fxRate', header: 'Fx Rate', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'fxCurrency', header: 'Fx Currency', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'fxDate', header: 'Fx Date', showField: true, display: "table-cell", type: 'date', drag: true },
      { field: 'allocationAmount', header: 'Allocation Amount (TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'allocationAmountFc', header: 'Allocation Amount (FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'shippedQty', header: 'Shipped Qty', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'deliveredAmount', header: 'Delivered Amount (TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'invoiceLineNumber', header: 'Invoice Line#', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'invoiceQuantity', header: 'Invoice Qty', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'invoiceCurrency', header: 'Invoice Currency', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'invoiceDate', header: 'Invoice Date', showField: true, display: "table-cell", type: 'date', drag: true },
      { field: 'billedAmount', header: 'Billed Amt(TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'billedAmountFc', header: 'Billed Amount (FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'deliveredAllocAmount', header: 'Delivered Allocated Price (TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'deliveredAllocAmountFc', header: 'Delivered Allocated Price (FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'cancelledQty', header: 'Cancelled Qty', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'cancelledDate', header: 'Cancelled Date', showField: true, display: "table-cell", type: 'date', drag: true },
      { field: 'contractModifiedDate', header: 'Contract Modified Date', showField: true, display: "table-cell", type: 'date', drag: true },
      { field: 'deferredAmount', header: 'Revenue Deferred(TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'deferredAmountFc', header: 'Revenue Deferred(FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'contReleaseDate', header: 'Contingency Release Date', showField: true, display: "table-cell", type: 'date', drag: true },
      { field: 'contractAsset', header: 'Contract Asset (TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'contractLiability', header: 'Contract Liability (TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'deferredRevenue', header: 'Deferred Revenue (TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'clearing', header: 'Clearing (TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'contractAssetFc', header: 'Contract Asset (FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'contractLiabilityFc', header: 'Contract Liability (FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'deferredRevenueFc', header: 'Deferred Revenue (FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'clearingFc', header: 'Clearing (FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'beginBal', header: 'Revenue Begin Balance (TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'currBal', header: 'Revenue Current Balance (TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'endBal', header: 'Revenue End Balance (TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'beginBalFc', header: 'Revenue Begin Balance (FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'currBalFc', header: 'Revenue Current Balance (FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'endBalFc', header: 'Revenue End Balance (FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'quarterName', header: 'Quarter Name', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'periodName', header: 'Period Name', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'backlog', header: 'Backlog', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'exceptionMessage', header: 'Exception Message', showField: true, display: "table-cell", type: 'text', drag: true }
    ];

    this.columns = [];
    this.getTableColumns("rmanTrxDetailReport", "Transaction Details Report");


    this.buildForm()
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
    this.commonSharedService.saveOrUpdateTableColumns("rmanTrxDetailReport", "Transaction Details Report", selectedCols, this.userId).then((response) => {
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

  goToOperationReports() {
    this.location.back();
  }

  filterPeriodName(event: any) {
    let query = event.query;
    this.rmanTrxDetailReportService.getPeriodNameList(query).then(response => {
      this.filteredPeriodNameList = response.content.map(item => item.periodName);
    }).catch(err => {
      this.filteredPeriodNameList = [];
    });
  }


  getAllRmanTrxDetailReport() {
    this.loading = true;

    this.rmanTrxDetailReportService.getAllRmanTrxDetailReport(this.paginationOptions, this.searchFields, this.exportCols).then((rmanTrxDetailReportList: any) => {
      this.datasource = rmanTrxDetailReportList.content;
      this.rmanTrxDetailReportList = rmanTrxDetailReportList.content;
      this.totalElements = rmanTrxDetailReportList.totalElements;
      this.pageSize = rmanTrxDetailReportList.size;
      this.displaySearchDialog = false;
      this.loading = false;
      this.disableExport = false;
    }).catch(err => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }


  getRmanTrxDetailReport(event: any) {

    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loading = true;

    this.rmanTrxDetailReportService.getAllRmanTrxDetailReport(this.paginationOptions, this.searchFields, this.exportCols).then((rmanTrxDetailReportList: any) => {
      this.datasource = rmanTrxDetailReportList.content;
      this.rmanTrxDetailReportList = rmanTrxDetailReportList.content;
      this.totalElements = rmanTrxDetailReportList.totalElements;
      this.pageSize = rmanTrxDetailReportList.size;
      this.loading = false;
      this.disableExport = false;
    }).catch(err => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });

  }

  buildForm() {
    this.transactionReportForm = this.formBuilder.group({
      'dealArrangementId': [''],
      'dealArrangementNumber': [''],
      'dealArrangementName': [''],
      'arrangementType': [''],
      'customerName': [''],
      'customerNumber': [''],
      'salesTheater': [''],
      'region': [''],
      'territory': [''],
      'dealNumber': [''],
      'dealLineNumber': [''],
      'productName': [''],
      'productDescription': [''],
      'itemType': [''],
      'po': [''],
      'orderNumber': [''],
      'sourceLineNumber': [''],
      'serviceStartDate': [''],
      'serviceEndDate': [''],
      'orderedQuantity': [''],
      'shippedQty': [''],
      'unitSellingPrice': [''],
      'unitListPrice': [''],
      'transactionPrice': [''],
      'allocatedPrice': [''],
      'revenueRecognize': [''],
      'billedAmount': [],
      'ssp': [],
      'fmvAmount': []


    })
  }

  exportExcel() {

    this.exportCols = [];

    for (let index = 0; index < this.columns.length; index++) {
      if (this.columns[index].showField) {
        this.exportCols.push(this.columns[index].field);
      }
    }
    this.loading = true;
    let serviceUrl = this.rmanTrxDetailReportService.getServiceUrl(this.paginationOptions, this.searchFields, this.exportCols, 1);
    window.location.href = serviceUrl;
    this.loading = false;

  }


  showDialogToAdd() {

    this.newRmanTrxDetailReport = true;
    this.rmanTrxDetailReport = new RmanTrxDetailReportImpl();
    this.displayDialog = true;

  }
  onBeforeToggle(evt: any) {
    this.collapsed = evt.collapsed;
  }
  reset(dt: Table) {
    this.paginationOptions = {};
    this.rmanTrxDetailReport = {};
    this.searchFields = {};
    dt.reset();
    this.isSerached = 0;
  }

  save() {

    if (this.newRmanTrxDetailReport) {
      this.rmanTrxDetailReportService.saveRmanTrxDetailReport(this.rmanTrxDetailReport).then((response: any) => {
        this.getAllRmanTrxDetailReport();
      });
    }
    else {
      this.rmanTrxDetailReportService.updateRmanTrxDetailReport(this.rmanTrxDetailReport).then((response: any) => {
        this.getAllRmanTrxDetailReport();
      });
    }

    this.rmanTrxDetailReport = new RmanTrxDetailReportImpl();

    this.displayDialog = false;

  }


  delete(rmanTrxDetailReport: any) {
    this.rmanTrxDetailReport = rmanTrxDetailReport;
    this.displayDialog = false;

    if (window.confirm('Are you sure you want to delete this record?')) {
      this.rmanTrxDetailReportList.splice(this.findSelectedRmanTrxDetailReportIndex(), 1);
      this.rmanTrxDetailReportService.deleteRmanTrxDetailReport(this.rmanTrxDetailReport).then(response => {
        this.rmanTrxDetailReport = new RmanTrxDetailReportImpl();
        this.getAllRmanTrxDetailReport();
      });
    }

  }

  editRow(rmanTrxDetailReport: any) {
    this.newRmanTrxDetailReport = false;
    this.rmanTrxDetailReport = this.cloneRmanTrxDetailReport(rmanTrxDetailReport);
    this.displayDialog = true;

  }


  findSelectedRmanTrxDetailReportIndex(): number {
    return this.rmanTrxDetailReportList.indexOf(this.selectedRmanTrxDetailReport);
  }

  onRowSelect(event: any) {

  }

  cloneRmanTrxDetailReport(c: RmanTrxDetailReport): any {
    let rmanTrxDetailReport = new RmanTrxDetailReportImpl();
    for (let prop in c) {
      rmanTrxDetailReport[prop] = c[prop];
    }
    return rmanTrxDetailReport;
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

    this.rmanTrxDetailReportSearch = {};
    this.searchFields = {};
    this.displaySearchDialog = true;

  }

  search() {

    this.isSerached = 1;
    this.rmanTrxDetailReport = this.searchFields;
    this.paginationOptions = {};
    this.displaySearchDialog = false;
    this.getAllRmanTrxDetailReport();

  }
}


class RmanTrxDetailReportImpl {
  constructor(public dealArrangementNumber?: any, public shippedQty?: any, public salesTheater?: any, public territory?: any, public billedAmount?: any, public dealArrangementName?: any, public productDescription?: any, public sno?: any, public revenueRecognize?: any, public unitSellingPrice?: any, public unitListPrice?: any, public serviceStartDate?: any, public dealNumber?: any, public itemType?: any, public dealLineNumber?: any, public customerNumber?: any, public sourceLineNumber?: any, public productName?: any, public allocatedPrice?: any, public dealArrangementId?: any, public region?: any, public arrangementType?: any, public serviceEndDate?: any, public transactionPrice?: any, public customerName?: any, public orderNumber?: any, public orderedQuantity?: any
    , public po?: any, public periodYear?: any, public quarterName?: any, public periodName?: any, public backlog?: any, public activeFlag?: any) { }
}

interface ILabels {
  [index: string]: string;
}
