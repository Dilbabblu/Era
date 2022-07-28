import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Table } from 'primeng/table';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanDefRollforwardReportV } from './rmanDefRollforwardReportV';
import { RmanDefRollforwardReportVService } from './rmanDefRollforwardReportVservice';

declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
  templateUrl: './rmanDefRollforwardReportV.component.html',
  selector: 'rmanDefRollforwardReportV-data',
  providers: [RmanDefRollforwardReportVService, RmanLookupsVService]
})

export class RmanDefRollforwardReportVComponent implements OnInit {


  displayDialog: boolean;

  displaySearchDialog: boolean;


  rmanDefRollforwardReportV: any = new RmanDefRollforwardReportVImpl();

  rmanDefRollforwardReportVSearch: any = new RmanDefRollforwardReportVImpl();

  isSerached: number = 0;

  selectedRmanDefRollforwardReportV: RmanDefRollforwardReportV;

  newRmanDefRollforwardReportV: boolean;

  rmanDefRollforwardReportVList: any[];
  loading: boolean;
  noData = appSettings.noData;
  cols: any[];
  columns: any[];
  periodType: any;
  asOfPeriod: any;
  dealArrangementNum: any;
  soNumber: any;
  poNumber: any;
  columnOptions: any[];
  rmanLookupsVList: any[] = [];
  rmanLookupsV: any[];
  paginationOptions: any;
  collapsed: boolean = true;
  pages: {};

  filteredPeriodNameList: any[];
  periodNamePlaceHolder: string;
  datasource: any[];
  pageSize: number;
  totalElements: number;

  showAddColumns = true;
  isSelectAllChecked = true;
  globalCols: any[];
  clonedCols: any[];
  userId: number;
  showPaginator: boolean = true;
  startIndex: number;


  exportCols: string[] = [];
  disableExport: boolean = true;

  constructor(private rmanDefRollforwardReportVService: RmanDefRollforwardReportVService, private rmanLookupsVService: RmanLookupsVService, private location: Location, private commonSharedService: CommonSharedService,
    private notificationService: NotificationService) {

    // generate list code
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };

    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'ACCOUNT_PERIOD_TYPE' }).then((rmanLookupsVList: any) => {
      this.rmanLookupsVList = rmanLookupsVList.content;
      this.prepareRmanLookupsVObject();
    });

    this.periodNamePlaceHolder = "";

  }

  ngOnInit() {

    this.globalCols = [
      { field: 'dealArrangementNumber', header: 'Revenue Contract#', showField: true, display: "table-cell", type: 'number', drag: false },
      { field: 'dealArrangementName', header: 'Revenue Contract', showField: true, display: "table-cell", type: 'text', drag: false },
      { field: 'note', header: 'Note Transaction Type', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'contName', header: 'Cont Apply', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'elementType', header: 'Element Type', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'billToCustomerNumber', header: 'Customer#', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'billToCustomer', header: 'Customer', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'customerPoNum', header: 'PO#', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'orderNumber', header: 'SO#', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'invoiceNum', header: 'Invoice#', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'dealArrangementBasis', header: 'Revenue Contract Basis', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'dealArrangementStatus', header: 'Status', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'legalEntityName', header: 'Legal Entity', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'dealArrangementSource', header: 'Revenue Contract Source', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'dealName', header: 'Deal Name', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'dealNumber', header: 'Deal#', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'dealLineNumber', header: 'Deal Line#', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'sourceHeaderId', header: 'Source Header Id', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'sourceLineId', header: 'Source Line Id', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'sourceLineNumber', header: 'Source Line#', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'productName', header: 'Product Name', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'orderedQuantity', header: 'Ordered Quantity', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'uom', header: 'UOM', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'transactionCurrency', header: 'Currency', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'unitListPrice', header: 'List $/U', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'unitNetPrice', header: 'Sell $/U', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'lineAmount', header: 'Line AMT$', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'discountPercent', header: 'Discount%', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'productPortfolio', header: 'Product Porfolio', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'productFamily', header: 'Product Family', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'productLine', header: 'Product Line', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'division', header: 'Division', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'shipToCustomerNumber', header: 'Ship To Customer#', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'shipToCustomer', header: 'Ship To Customer', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'salesTheater', header: 'Sales Theater', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'salesRegion', header: 'Sales Region', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'salesTeritory', header: 'Sales Territory', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'lineCost', header: 'Line Cost', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'bundleAttributedList', header: 'Bundle Attributed List', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'bundleAttributedNet', header: 'Bundle Attributed Net', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'startDate', header: 'Start Date', showField: true, display: "table-cell", type: 'date', drag: true },
      { field: 'endDate', header: 'End Date', showField: true, display: "table-cell", type: 'date', drag: true },
      { field: 'deliveredDate', header: 'Delivered Date', showField: true, display: "table-cell", type: 'date', drag: true },
      { field: 'sspAmount', header: 'SSP Amount', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'allocationAmount', header: 'Allocation Amount (TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'allocationAmountFc', header: 'Allocation Amount (FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'bookedAmount', header: 'Booked Amount', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'deliveredAmount', header: 'Delivered Amount', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'deliveredAllocationAmount', header: 'Delivered Allocation Amount(TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'deliveredAllocationAmountFc', header: 'Delivered Allocation Amount(FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'postBillingDeferrals', header: 'Post Billing Deferrals (TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'postBillingDeferralsFc', header: 'Post Billing Deferrals (FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'beginingBalance', header: 'Beginning Bal (FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'additionAmount', header: 'Addition Amount (FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'releaseAmount', header: 'Release (FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'endingBalance', header: 'Ending Bal(FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'revenueRecognized', header: 'Revenue Recognized (FC)', showField: true, display: "table-cell", type: 'round', drag: true }
    ];

    this.columns = [];
    this.getTableColumns("rmanDefRollforwardReportV", "Deferred Revenue Roll Forward Report");
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
    this.commonSharedService.saveOrUpdateTableColumns("rmanDefRollforwardReportV", "Deferred Revenue Roll Forward Report", selectedCols, this.userId).then((response) => {
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

  getAllRmanDefRollforwardReportV() {
    this.loading = true;
    this.rmanDefRollforwardReportVService.searchFields(this.periodType, this.asOfPeriod, this.dealArrangementNum, this.soNumber, this.poNumber, this.paginationOptions).then((rmanDefRollforwardReportVList: any) => {
      this.loading = false;
      this.datasource = rmanDefRollforwardReportVList.content;
      this.rmanDefRollforwardReportVList = rmanDefRollforwardReportVList.content;
      this.totalElements = rmanDefRollforwardReportVList.totalElements;
      this.pageSize = rmanDefRollforwardReportVList.size;
      this.displaySearchDialog = false;
      this.disableExport = false;

    }).catch((err: any) => {
      this.loading = false;
    });
  }


  getRmanDefRollforwardReportV(event: any) {
    this.loading = true;
    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.rmanDefRollforwardReportVService.searchFields(this.periodType, this.asOfPeriod, this.dealArrangementNum, this.soNumber, this.poNumber , this.paginationOptions).then((rmanDefRollforwardReportVList: any) => {
      this.loading = false;
      this.datasource = rmanDefRollforwardReportVList.content;
      this.rmanDefRollforwardReportVList = rmanDefRollforwardReportVList.content;
      this.totalElements = rmanDefRollforwardReportVList.totalElements;
      this.pageSize = rmanDefRollforwardReportVList.size;
      this.disableExport = false;
    }).catch((err: any) => {
      this.loading = false;
    });

  }


  showDialogToAdd() {

    this.newRmanDefRollforwardReportV = true;
    this.rmanDefRollforwardReportV = new RmanDefRollforwardReportVImpl();
    this.displayDialog = true;

  }

  prepareRmanLookupsVObject(): any {
    let rmanLookupsVTempObj: any = [];
    rmanLookupsVTempObj.push({ label: '--Select Account Period Type--', value: null });
    this.rmanLookupsVList.forEach((rmanLookupsV) => {
      rmanLookupsVTempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
    });

    this.rmanLookupsV = rmanLookupsVTempObj;

  }

  reset(dt: Table) {
    this.paginationOptions = {};
    this.periodType = '';
    this.asOfPeriod = '';
    this.dealArrangementNum = '';
    this.soNumber = '';
    this.poNumber = '';
    dt.reset();
  }

  exportExcel() {
    this.exportCols = [];
    for (let index = 0; index < this.columns.length; index++) {
      if (this.columns[index].showField) {
        this.exportCols.push(this.columns[index].field);
      }
    }
    this.loading = true;
    let exportReconDealsUrl = this.rmanDefRollforwardReportVService.exportReconDeals(this.periodType, this.asOfPeriod, this.dealArrangementNum, this.soNumber, this.poNumber , this.exportCols);
    window.location.href = exportReconDealsUrl;
    this.loading = false;
  }



  findSelectedRmanDefRollforwardReportVIndex(): number {
    return this.rmanDefRollforwardReportVList.indexOf(this.selectedRmanDefRollforwardReportV);
  }

  onRowSelect(event: any) {

  }

  onBeforeToggle(evt: any) {
    this.collapsed = evt.collapsed;
  }


  cloneRmanDefRollforwardReportV(c: RmanDefRollforwardReportV): RmanDefRollforwardReportV {
    let rmanDefRollforwardReportV: any
      = new RmanDefRollforwardReportVImpl();
    for (let prop in c) {
      rmanDefRollforwardReportV[prop] = c[prop];
    }
    return rmanDefRollforwardReportV;
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
    if (this.isSerached == 0) {
      this.rmanDefRollforwardReportVSearch = new RmanDefRollforwardReportVImpl();
    }
    this.displaySearchDialog = true;
    this.periodType = '';
    this.asOfPeriod = '';
    this.dealArrangementNum = '';
    this.soNumber = '';
    this.poNumber = '';
  }

  search() {
    this.isSerached = 1;
    this.displaySearchDialog = false;
    this.paginationOptions = {};
    this.getAllRmanDefRollforwardReportV();
  }

  searchFields(dt: Table) {
    this.loading = true;
    dt.reset();
    this.rmanDefRollforwardReportVService.searchFields(this.periodType, this.asOfPeriod, this.dealArrangementNum, this.soNumber, this.poNumber , this.paginationOptions).then((rmanDefRollforwardReportVList: any) => {
      this.displaySearchDialog = false;
      this.rmanDefRollforwardReportVList = rmanDefRollforwardReportVList.content;
      this.totalElements = rmanDefRollforwardReportVList.totalElements;
      this.pageSize = rmanDefRollforwardReportVList.size;
      this.loading = false;

    });

  }

  filterPeriodName(event: any) {
    let query = event.query;
    this.rmanDefRollforwardReportVService.getPeriodNameList(query).then(response => {
      this.filteredPeriodNameList = response.content.map(item => item.periodName);
    }).catch(err => {
      this.filteredPeriodNameList = [];
    });
  }


}


class RmanDefRollforwardReportVImpl {
  constructor(public sourceLineId?: any, public deliveredAllocationAmount?: any, public transactionCurrency?: any, public endDate?: any, public sourceHeaderId?: any, public bundleAttributedNet?: any, public salesTeritory?: any, public periodName?: any, public salesRegion?: any, public dealArrangementBasis?: any, public productPortfolio?: any, public unitListPrice?: any, public shipToCustomerNumber?: any, public dealName?: any, public lineAmount?: any, public sspAmount?: any, public bookedAmount?: any, public dealArrangementSource?: any, public sourceLineNumber?: any, public periodYear?: any, public unitNetPrice?: any, public customerPoNum?: any, public productName?: any, public quarterName?: any, public releaseAmount?: any, public productLine?: any, public orderedQuantity?: any, public endingBalance?: any, public revenueRecognized?: any, public dealArrangementStatus?: any, public dealArrangementNumber?: any, public postBillingDeferrals?: any, public salesTheater?: any, public dealArrangementName?: any, public allocationAmount?: any, public billToCustomerNumber?: any, public discountPercent?: any, public dealNumber?: any, public billToCustomer?: any, public bundleAttributedList?: any, public shipToCustomer?: any, public beginingBalance?: any, public dealLineNumber?: any, public startDate?: any, public periodDetail?: any, public dealArrangementId?: any, public uom?: any, public additionAmount?: any, public legalEntityName?: any, public productFamily?: any, public orderNumber?: any, public lineCost?: any, public deliveredAmount?: any) { }
}

interface ILabels {
  [index: string]: string;
}
