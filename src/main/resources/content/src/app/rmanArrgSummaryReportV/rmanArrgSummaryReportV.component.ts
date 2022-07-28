import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Table } from 'primeng/table';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanArrgSummaryReportV } from './rmanArrgSummaryReportV';
import { RmanArrgSummaryReportVService } from './rmanArrgSummaryReportVservice';


declare var $: any;

@Component({
  templateUrl: './rmanArrgSummaryReportV.component.html',
  selector: 'rmanArrgSummaryReportV-data',
  providers: [RmanArrgSummaryReportVService]
})

export class RmanArrgSummaryReportVComponent implements OnInit {

  displayDialog: boolean;

  displaySearchDialog: boolean;

  rmanArrgSummaryReportV: any = new RmanArrgSummaryReportVImpl();
  rmanArrgSummaryReportVSearch: any = new RmanArrgSummaryReportVImpl();

  isSerached: number = 0;

  selectedRmanArrgSummaryReportV: RmanArrgSummaryReportV;

  newRmanArrgSummaryReportV: boolean;

  rmanArrgSummaryReportVList: any[];

  searchFields: any = {};

  loading: boolean;

  columns: any[];

  collapsed: boolean = true;

  paginationOptions: any;

  pages: {};

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

  constructor(private rmanArrgSummaryReportVService: RmanArrgSummaryReportVService, private location: Location, private commonSharedService: CommonSharedService, private notificationService: NotificationService) {
    // generate list code
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
  }

  ngOnInit() {

    this.globalCols = [
      { field: 'dealArrangementNumber', header: 'Revenue Contract Number', showField: true, display: "table-cell", type: 'number', drag: false },
      { field: 'dealArrangementBasis', header: 'Revenue Contract Basis', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'dealArrangementStatus', header: 'Status', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'lastArrgModifiedDate', header: 'Revenue Contract Modified Date', showField: true, display: "table-cell", type: 'date', drag: true },
      { field: 'legalEntityName', header: 'Legal Entity', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'dealArrangementSource', header: 'Revenue Contract Source', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'salesContact', header: 'Sales Rep', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'customerPoNum', header: 'PO Number', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'bookingCurrency', header: 'Transaction Currency', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'billToCustomer', header: 'Bill To Customer Name', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'billToCustomerNumber', header: 'Bill To Customer Number', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'salesTheater', header: 'Sales Theater', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'salesRegion', header: 'Sales Region', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'salesTerritory', header: 'Sales Territory', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'bookedAmount', header: 'Booked Amount (TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'sspAmount', header: 'Extended SSP Amount (TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'allocationAmount', header: 'Allocation Amount (TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'carveInOutAmount', header: 'Carve In/Carve Out Amount (TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'deliveredAmount', header: 'Delivered Amount (TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'billedAmount', header: 'Billed Amount (TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'deliveredAllocationAmount', header: 'Delivered Allocation Amount (TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'postBillingDeferrals', header: 'Post Billing Deferrals (TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'postBillingAllocationAmount', header: 'Post Billing Allocation Amount (TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'revBegBal', header: 'Revenue Beginning Balance (TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'revCurrBal', header: 'Revenue Current Balance (TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'revEndBal', header: 'Revenue Ending Balance (TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'unamortizedAmount', header: 'Unamortized Amount (TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'allocationAmountFc', header: 'Allocation Amount (FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'deliveredAllocationAmountFc', header: 'Delivered Allocation Amount (FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'postBillingDeferralsFc', header: 'Post Billing Deferrals (FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'pbAllocationAmountFc', header: 'Post Billing Allocation Amount (FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'revBegBalFc', header: 'Revenue Beginning Balance (FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'revCurrBalFc', header: 'Revenue Current Balance (FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'revEndBalFc', header: 'Revenue Ending Balance (FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'unamortizedAmountFc', header: 'Unamortized Amount (FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'totalCostFc', header: 'Total Cost (FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'grossMarginFc', header: 'Gross Margin (FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'contractAsset', header: 'Contract Asset (TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'contractLiability', header: 'Contract Liability (TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'deferredRevenue', header: 'Deferred Revenue (TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'clearing', header: 'Clearing (TC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'contractAssetFc', header: 'Contract Asset (FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'contractLiabilityFc', header: 'Contract Liability (FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'deferredRevenueFc', header: 'Deferred Revenue (FC)', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'clearingFc', header: 'Clearing (FC)', showField: true, display: "table-cell", type: 'round', drag: true }
    ];

    this.columns = [];
    this.getTableColumns("rmanArrgSummaryReportV", "Revenue Contract Summary Report");
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
    this.commonSharedService.saveOrUpdateTableColumns("rmanArrgSummaryReportV", "Revenue Contract Summary Report", selectedCols, this.userId).then((response) => {
      this.columns = this.globalCols.filter(item => item.showField);
      this.userId = response["userId"];
      this.showPaginator = this.columns.length !== 0;
      this.loading = false;
    }).catch(() => {
      this.notificationService.showError('Error occured while getting data')
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
  reset(dt: Table) {
    this.paginationOptions = {};
    this.searchFields = {};
    dt.reset();
  }

  getAllRmanArrgSummaryReportV() {
    this.loading = true;
    this.rmanArrgSummaryReportVService.getAllRmanArrgSummaryReportV(this.paginationOptions, this.rmanArrgSummaryReportV, this.searchFields, this.exportCols).then((rmanArrgSummaryReportVList: any) => {
      this.datasource = rmanArrgSummaryReportVList.content;
      this.rmanArrgSummaryReportVList = rmanArrgSummaryReportVList.content;
      this.totalElements = rmanArrgSummaryReportVList.totalElements;
      this.pageSize = rmanArrgSummaryReportVList.size;
      this.loading = false;
      this.disableExport = false;
      this.displaySearchDialog = false;
    });
  }


  getRmanArrgSummaryReportV(event: any) {

    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loading = true;
    this.rmanArrgSummaryReportVService.getAllRmanArrgSummaryReportV(this.paginationOptions, this.rmanArrgSummaryReportV, this.searchFields, this.exportCols).then((rmanArrgSummaryReportVList: any) => {
      this.datasource = rmanArrgSummaryReportVList.content;
      this.rmanArrgSummaryReportVList = rmanArrgSummaryReportVList.content;
      this.totalElements = rmanArrgSummaryReportVList.totalElements;
      this.pageSize = rmanArrgSummaryReportVList.size;
      this.loading = false;
      this.disableExport = false;
    });

  }

  exportExcel() {
    this.exportCols = [];

    this.loading = true;

    for (let index = 0; index < this.columns.length; index++) {
      if (this.columns[index].showField) {
        this.exportCols.push(this.columns[index].field);
      }
    }
    let serviceUrl = this.rmanArrgSummaryReportVService.getServiceUrl(this.paginationOptions, this.rmanArrgSummaryReportV, 1, this.searchFields, this.exportCols);
    this.loading = false;
    window.location.href = serviceUrl;
  }

  findSelectedRmanArrgSummaryReportVIndex(): number {
    return this.rmanArrgSummaryReportVList.indexOf(this.selectedRmanArrgSummaryReportV);
  }

  onRowSelect(event: any) {

  }

  showDialogToSearch() {
    if (this.isSerached == 0) {
      this.rmanArrgSummaryReportVSearch = new RmanArrgSummaryReportVImpl();
    }
    this.displaySearchDialog = true;
  }

  search() {
    this.isSerached = 1;
    this.paginationOptions = {};
    this.rmanArrgSummaryReportV = this.rmanArrgSummaryReportVSearch;
    this.getAllRmanArrgSummaryReportV();
    this.displaySearchDialog = false;
  }

  onBeforeToggle(evt: any) {
    this.collapsed = evt.collapsed;
  }

}


class RmanArrgSummaryReportVImpl {
  constructor(public dealArrangementNumber?: any, public revEndBal?: any, public postBillingDeferrals?: any, public revenueUnbilled?: any, public pbAllocationAmountFc?: any, public deliveredAllocationAmount?: any, public revCurrBal?: any, public revBegBalFc?: any, public salesTheater?: any, public salesTerritory?: any, public dealArrangementName?: any, public allocationAmount?: any, public billToCustomerNumber?: any, public unamortizedAmount?: any, public revCurrBalFc?: any, public salesRegion?: any, public shipToCustomerNumber?: any, public carveInOutAmount?: any, public billToCustomer?: any, public sspAmount?: any, public revBegBal?: any, public bookedAmount?: any, public postBillingDeferralsFc?: any, public shipToCustomer?: any, public dealArrangementSource?: any, public bookingCurrency?: any, public revEndBalFc?: any, public customerPoNum?: any, public dealArrangementId?: any, public billedAmount?: any, public allocationAmountFc?: any, public deliveredAllocationAmountFc?: any, public legalEntityName?: any, public grossMarginFc?: any, public postBillingAllocationAmount?: any, public unamortizedAmountFc?: any, public deliveredAmount?: any, public totalCostFc?: any, public dealArrangementStatus?: any
    , public contractAsset?: any, public contractLiability?: any, public deferredRevenue?: any, public clearing?: any
    , public contractAssetFc?: any, public contractLiabilityFc?: any, public deferredRevenueFc?: any, public clearingFc?: any) { }
}

interface ILabels {
  [index: string]: string;
}
