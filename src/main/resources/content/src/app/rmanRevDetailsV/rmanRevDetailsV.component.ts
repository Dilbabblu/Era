import { ChangeDetectorRef, Component, OnInit, ViewChild } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { Table } from 'primeng/table';
import { ArrgContractAllocationsVService } from '../arrgContractAllocationsV/arrgContractAllocationsVservice';
import { RmanContReleaseEventsVComponent, RmanContReleaseEventsVImpl } from '../rmanContReleaseEventsV/rmanContReleaseEventsV.component';
import { RmanContReleaseEventsVLabels } from '../rmanContReleaseEventsV/rmanContReleaseEventsVLabels';
import { RmanContReleaseEventsVService } from '../rmanContReleaseEventsV/rmanContReleaseEventsVservice';
import { RmanDealArrangementsService } from '../rmanDealArrangements/rmanDealArrangementsservice';
import { RmanGlAccountingVImpl } from '../rmanGlAccountingV/rmanGlAccountingV.component';
import { RmanGlAccountingVLabels } from '../rmanGlAccountingV/rmanGlAccountingVLabels';
import { RmanGlAccountingVService } from '../rmanGlAccountingV/rmanGlAccountingVservice';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanRevDetailsV } from './rmanRevDetailsV';
import { RmanRevDetailsVService } from './rmanRevDetailsVservice';


declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');
@Component({
  templateUrl: './rmanRevDetailsV.component.html',
  selector: 'rmanRevDetailsV-data',
  providers: [RmanRevDetailsVService, RmanGlAccountingVService, RmanContReleaseEventsVService, ArrgContractAllocationsVService]
})

export class RmanRevDetailsVComponent implements OnInit {
  noData = appSettings.noData;
  displayDialog: boolean;

  displaySearchDialog: boolean;

  arrId: any;

  @ViewChild(RmanContReleaseEventsVComponent) private rmanContReleaseEventsVComponent: RmanContReleaseEventsVComponent;

  rmanRevDetailsV: any = new RmanRevDetailsVImpl();

  rmanGlAccountingV: any = new RmanGlAccountingVImpl();

  rmanGlAccountingVSearch: any = new RmanGlAccountingVImpl();

  rmanContReleaseEventsV: any = new RmanContReleaseEventsVImpl();

  rmanContReleaseEventsVSearch: any = new RmanContReleaseEventsVImpl();

  rmanRevDetailsVSearch: any = new RmanRevDetailsVImpl();

  showRevSchedulesDialog: boolean = false;
  rmanDealUsageSummaryList: any[] = [];
  
  displayPageSize:any = 20;
  
  isSerached: number = 0;

  cref: ChangeDetectorRef;

  selectedRmanRevDetailsV: RmanRevDetailsV;

  newRmanRevDetailsV: boolean;

  rmanRevDetailsVList: any[] = [];

  //cols: any[];
  columns: any[];
  accColumns: ILabels;
  contColumns: ILabels;

  columnOptions: any[];

  paginationOptions: any;

  pages: {};

  datasource: any[];
  pageSize: number;
  totalRevElements: number;
  totalAccElements: number;
  totalContElements: number;
  totalUsagesElements: number;
  so: any;
  soLine: any;
  collapsed: boolean = true;

  showContingenciesDialog: boolean = false;
  showAccountingDialog: boolean = false;
  showUsageDialog: boolean = false;

  rmanGlAccountingVList: any[] = [];
  rmanContReleaseEventsVList: any[] = [];
  rmanDealArrangementsList: any[] = [];
  arrgContractAllocationsVList: any[] = [];

  rmanUsagesVList: any[] = [];
  paramArrangementName: any;
  paramArrangementNumber: any;
  parrangementId: any;
  sku: any;
  lineNumber: any;
  pDealLineId: any;
  sourceLineId: any;
  
  totalAllocAmountTotal: any;
  deliveredAllocRspTotal: any;
  postBillingProvisionTotal: any;
  postBillingDeferralsTotal: any;
  postBillingAllocationAmountTotal: any;
  begBalanceTotal: any;
  currentPeriodTotal: any;
  endingBalanceTotal: any;
  totalAllocAmountFcTotal: any;
  deliveredAllocRspFcTotal: any;
  pbDeferralsFcTotal: any;
  totalBookedAmount: any;
  totalShippedAmount: any;
  totalBilledAmount: any;
  totalUnamortizedAmount: any;
  totalBilledAmountFc: any;
  totalPbAllocAmountTc: any;
  totalRevBegBalTc: any;
  totalRevCurrBalTc: any;
  totalRevEndBalTc: any;
  totalUnamortizedAmountTc: any;
  totalRevenueAdjustment: any;
  loading: boolean = true;
  pageContSize: number;

  uDealLineId: any;

  showAddColumns = true;
  isSelectAllChecked = true;
  globalCols: any[];
  clonedCols: any[];
  userId: number;
  showPaginator: boolean = true;
  startIndex: number;
 
  exportCols: string[] =[];
  disableExport: boolean = true;

  isRevType:boolean;
  revType:any = "D";

  revenueContractBasis:any;
  showDeliveryDetailsDialog: boolean
  rmanDeliveryDetailsList: any[] = [];
  totalDeliveryDetailsElements: number;
  rmanActualRevenueSchedulesList: any[] = [];
  totalRevScheduleElements: number;
  revSchedulesRowSize: number;
  showActualRevSchedulesDialog: boolean;
  revcolumns: any[];

 
  constructor(private router: Router, private rmanDealArrangementsService: RmanDealArrangementsService, private rmanContReleaseEventsVService: RmanContReleaseEventsVService, private rmanGlAccountingVService: RmanGlAccountingVService, private rmanRevDetailsVService: RmanRevDetailsVService, private commonSharedService: CommonSharedService,
    private notificationService: NotificationService) {

    // generate list code
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '100' };

    let url = router.url;
    this.arrId = url.split('/')[3];

    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.arrId = event.url.split('/')[3];
      }
    });
    //console.log(this.arrId);

  }


  ngOnInit() {
    this.getRmanDealArrangementsById();
    let rmanGlAccountingVLabels = new RmanGlAccountingVLabels();
    let rmanContReleaseEventsVLabels = new RmanContReleaseEventsVLabels();
    this.accColumns = rmanGlAccountingVLabels.fieldLabels;
    this.contColumns = rmanContReleaseEventsVLabels.fieldLabels;
    this.globalCols = [
      { field: 'pobGroup', header: 'POB ID', showField: true, drag: false, display: "table-cell", type: 'text', footer: 'empty' },
      { field: 'arrgLineNumber', header: 'Revenue Contract Line#', showField: true, drag: false, display: "table-cell", type: 'number', footer: 'empty' },
      { field: 'dealNumber', header: 'Deal#', showField: true, drag: true, display: "table-cell", type: 'number', footer: 'empty' },
      { field: 'dealLineNumber', header: 'Deal Line#', showField: true, drag: true, display: "table-cell", type: 'number', footer: 'empty' },
      { field: 'bundleFlag', header: 'Bundle Flag', showField: true, drag: true, display: "table-cell", type: 'text', footer: 'empty' },
      { field: 'parentLineId', header: 'Parent Line Id', showField: true, drag: true, display: "table-cell", type: 'number', footer: 'empty' },
      { field: 'customerPoNum', header: 'PO#', showField: true, drag: true, display: "table-cell", type: 'number', footer: 'empty' },
      { field: 'orderNumber', header: 'SO#', drag: true, showField: true, display: "table-cell", type: 'number', footer: 'empty' },
      { field: 'sourceLineNumber', header: 'SO Line#', drag: true, showField: true, display: "table-cell", type: 'number', footer: 'empty' },
      { field: 'productName', header: 'Product Name', drag: true, showField: true, display: "table-cell", type: 'text', footer: 'empty' },
      { field: 'productDescription', header: 'Product Description', drag: true, showField: true, display: "table-cell", type: 'text', footer: 'empty' },
      { field: 'element', header: 'Element Type', drag: true, showField: true, display: "table-cell", type: 'text', footer: 'empty' },
      { field: 'productGroup', header: 'Product Family', drag: true, showField: true, display: "table-cell", type: 'text', footer: 'empty' },
      { field: 'productType', header: 'Product Line', drag: true, showField: true, display: "table-cell", type: 'text', footer: 'empty' },
      { field: 'arrgLineAmount', header: 'Revenue Contract Line Amount', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'empty' },
      { field: 'arrgLineCost', header: 'Revenue Contract Line Cost (FC)', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'empty' },
      { field: 'attributedNetPrice', header: 'Attributed Net Price', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'totals' },
      { field: 'totalAllocation', header: 'Total Allocation Amount (TC)', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'totalAllocAmountTotal' },
      { field: 'totalAllocationFc', header: 'Total Allocation Amount (FC)', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'totalAllocAmountFcTotal' },
      { field: 'bookedAmount', header: 'Booked Amount', showField: true, drag: true, display: "table-cell", type: 'link', footer: 'totalBookedAmount' },
      { field: 'shippedAmount', header: 'Delivered Amount', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'totalShippedAmount' },
      { field: 'deliveredAttributedNetPrice', header: 'Delivered Attributed Net Price', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'empty' },
      { field: 'deliveredAllocRsp', header: 'Delivered Allocation RSP (TC)', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'deliveredAllocRspTotal' },
      { field: 'deliveredAllocFcRsp', header: 'Delivered Allocation RSP(FC)', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'deliveredAllocRspFcTotal' },
      { field: 'billedAmount', header: 'Billed Amount', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'totalBilledAmount' },
      { field: 'billedAmountFc', header: 'Billed Amount (FC)', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'totalBilledAmountFc' },
      { field: 'postBillingContAmount', header: 'Post Billing Provisions', drag: true, showField: true, display: "table-cell", type: 'round', footer: 'postBillingProvisionTotal' },
      { field: 'postBillingDeferrals', header: 'Post Billing Deferrals (TC)', drag: true, showField: true, display: "table-cell", type: 'round', footer: 'postBillingDeferralsTotal' },
      { field: 'pbDeferralFc', header: 'Post Billing Deferrals (FC)', drag: true, showField: true, display: "table-cell", type: 'round', footer: 'pbDeferralsFcTotal' },
      { field: 'pbAllocAmountTc', header: 'Post Billing Alloc Amt (TC)', drag: true, showField: true, display: "table-cell", type: 'round', footer: 'totalPbAllocAmountTc' },
      { field: 'postBillingAllocationAmount', header: 'Post Billing Allocation Amount (FC)', drag: true, showField: true, display: "table-cell", type: 'round', footer: 'postBillingAllocationAmountTotal' },
      { field: 'revenueStartDate', header: 'Service Start Date', drag: true, showField: true, display: "table-cell", type: 'date', footer: 'empty' },
      { field: 'revenueEndDate', header: 'Service End Date', drag: true, showField: true, display: "table-cell", type: 'date', footer: 'empty' },
      { field: 'revBegBalTc', header: 'Revenue - Beginning Balance (TC)', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'totalRevBegBalTc' },
      { field: 'revCurrMonthBalTc', header: 'Revenue-Current Period (TC)', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'totalRevCurrBalTc' },
      { field: 'revEndBalTc', header: 'Revenue-Ending Balance (TC)', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'totalRevEndBalTc' },
      { field: 'cumGaapBegBalance', header: 'Revenue - Beginning Balance (FC)', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'begBalanceTotal' },
      { field: 'netGappCurrMonth', header: 'Revenue-Current Period (FC)', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'currentPeriodTotal' },
      { field: 'cumGaapEndingBalance', header: 'Revenue-Ending Balance (FC)', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'endingBalanceTotal' },
      { field: 'accountingRuleName', header: 'Accounting Rule', showField: true, drag: true, display: "table-cell", type: 'text', footer: 'empty' },
      { field: 'amortRuleRevenue', header: 'Amortization Rule', showField: true, drag: true, display: "table-cell", type: 'text', footer: 'empty' },
      { field: 'amortMethodRevenue', header: 'Amortization Method', showField: true, drag: true, display: "table-cell", type: 'text', footer: 'empty' },
      { field: 'gaapUnamortizedTc', header: 'Unamortized Amount (TC)', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'totalUnamortizedAmountTc' },
      { field: 'gaapUnamortized', header: 'Unamortized Amount (FC)', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'totalUnamortizedAmount' },
      { field: 'cogsBegiBalCogs', header: 'COGS-Beg Balance', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'empty' },
      { field: 'currentMonthCogs', header: 'COGS-Current Period', drag: true, showField: true, display: "table-cell", type: 'round', footer: 'empty' },
      { field: 'endingBalance', header: 'COGS-End Balance', drag: true, showField: true, display: "table-cell", type: 'round', footer: 'empty' },
      { field: 'revAdjustment', header: 'Revenue Adjustment', drag: true, showField: true, display: "table-cell", type: 'round', footer: 'totalRevenueAdjustment' }
    ];
    this.columns = [];
    this.getTableColumns("rmanRevDetailsV", "Deal Revenue Snapshot");

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
          if (colsList.indexOf(col.field) !== -1) {
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
    this.commonSharedService.saveOrUpdateTableColumns("rmanRevDetailsV", "Deal Revenue Snapshot", selectedCols, this.userId).then((response) => {
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

  swicthClickRecognizer:boolean = false;
  onQuoteOrderSwitch(){
    this.swicthClickRecognizer = true;
    if(this.revType == "D"){
      this.revType = "SO"
    }else{
      this.revType = "D"
    }
    this.getAllRmanRevDetailsV();
  }

  exportExcel() {
    this.exportCols = [];
    for (let index = 0; index < this.columns.length; index++) {
      if (this.columns[index].showField) {
        this.exportCols.push(this.columns[index].field);
      }
    }

    let serviceUrl = this.rmanRevDetailsVService.getServiceUrl(this.paginationOptions, this.arrId, this.so, this.soLine, this.revType, 1, this.exportCols);
    window.location.href = serviceUrl;

  }

  reset(dt: Table) {
    this.paginationOptions = {};
    this.rmanRevDetailsV = new RmanRevDetailsVImpl();
    this.rmanRevDetailsVSearch = new RmanRevDetailsVImpl();
    this.so = '';
    this.soLine = '';
    this.pDealLineId = null;
    dt.reset();
  }

  resetAccounts(dt1: Table) {

    this.paginationOptions = {};
    this.rmanGlAccountingV = new RmanGlAccountingVImpl();
    this.rmanGlAccountingVSearch = new RmanGlAccountingVImpl();
    this.rmanGlAccountingV.dealArrangementId = this.arrId;
    this.rmanGlAccountingV.dealLineId = this.pDealLineId;
    dt1.reset();
  }

  resetContingencies(dt3: Table) {

    this.paginationOptions = {};
    this.rmanContReleaseEventsV = new RmanContReleaseEventsVImpl();
    this.rmanContReleaseEventsVSearch = new RmanContReleaseEventsVImpl();
    this.rmanContReleaseEventsV.dealArrangementId = this.arrId;
    this.rmanContReleaseEventsV.dealLineId = this.pDealLineId;
    dt3.reset();

  }

  getRmanDealArrangementsById() {

    this.rmanDealArrangementsService.getAllRmanDealArrangements(this.paginationOptions, { 'dealArrangementId': this.arrId }).then((rmanDealArrangementsList: any) => {
      this.rmanDealArrangementsList = rmanDealArrangementsList.content;
      this.paramArrangementName = this.rmanDealArrangementsList[0].dealArrangementName;
      this.paramArrangementNumber = this.rmanDealArrangementsList[0].dealArrangementNumber;

    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }

  getAllRmanContReleaseEventsVTest() {

    this.rmanContReleaseEventsVComponent.getAllRmanContReleaseEventsV();

  }




  getAllRmanContReleaseEventsV() {
    this.rmanContReleaseEventsVService.getAllRmanContReleaseEventsV(this.paginationOptions, this.rmanContReleaseEventsV).then((rmanContReleaseEventsVList: any) => {
      this.datasource = rmanContReleaseEventsVList.content;
      if (this.pDealLineId != null) {
        this.rmanContReleaseEventsVList = rmanContReleaseEventsVList.content.filter((item: any) => item.dealLineId == this.pDealLineId);
      } else {
        this.rmanContReleaseEventsVList = rmanContReleaseEventsVList.content;
      }
      this.totalContElements = rmanContReleaseEventsVList.totalElements;
      this.pageSize = rmanContReleaseEventsVList.size;
	      this.disableExport = false;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });

  }

  getRmanContReleaseEventsV(event: any) {

    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageContSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.rmanContReleaseEventsVService.getAllRmanContReleaseEventsV(this.paginationOptions, { 'dealArrangementId': this.arrId, 'dealLineId': this.pDealLineId }).then((rmanContReleaseEventsVList: any) => {
      this.rmanContReleaseEventsVList = rmanContReleaseEventsVList.content;
      this.totalContElements = rmanContReleaseEventsVList.totalElements;
      this.pageSize = rmanContReleaseEventsVList.size;
		      this.disableExport = false;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });

  }

  getRmanDealUsageSummary(event: any) {
    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageContSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.rmanRevDetailsVService.getUsageSummaryDetails(this.paginationOptions, this.pDealLineId).then((rmanDealUsageSummaryList: any) => {
      this.datasource = rmanDealUsageSummaryList.content;
      this.rmanDealUsageSummaryList = rmanDealUsageSummaryList.content;
      this.loading = false;
      this.totalContElements = rmanDealUsageSummaryList.totalElements;
      this.pageSize = rmanDealUsageSummaryList.size;

    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });

  }


  exportContingencies() {
    let searchParam = {};
    if (this.pDealLineId != null) {
      searchParam = { 'dealArrangementId': this.arrId, 'so': this.rmanContReleaseEventsVSearch.so, 'sourceLineNumber': this.rmanContReleaseEventsVSearch.sourceLineNumber, 'dealLineId': this.rmanContReleaseEventsVSearch.dealLineId };
    } else {
      searchParam = { 'dealArrangementId': this.arrId, 'so': this.rmanContReleaseEventsVSearch.so, 'sourceLineNumber': this.rmanContReleaseEventsVSearch.sourceLineNumber };
    }

    let serviceUrl = this.rmanContReleaseEventsVService.getServiceUrl(this.paginationOptions, searchParam, 1);
    window.location.href = serviceUrl;

  }


  searchAccounts() {
    this.rmanGlAccountingV = this.rmanGlAccountingVSearch;
    this.rmanGlAccountingV.dealArrangementId = this.arrId;
    this.rmanGlAccountingV.dealLineId = this.pDealLineId;
    this.paginationOptions = {};
    this.getAllRmanGlAccountingVFilter();
  }

  searchContigencies() {
    this.rmanContReleaseEventsV = this.rmanContReleaseEventsVSearch
    this.rmanContReleaseEventsV.dealArrangementId = this.arrId;
    this.rmanContReleaseEventsV.dealLineId = this.pDealLineId;
    this.paginationOptions = {};
    this.getAllRmanContReleaseEventsV();

  }

  contingencies(dt3: Table) {
    this.rmanContReleaseEventsV = {};
    this.rmanContReleaseEventsV = new RmanContReleaseEventsVImpl();
    this.rmanContReleaseEventsVSearch = new RmanContReleaseEventsVImpl();
    let searchParams = {};
    if (this.pDealLineId != null) {
      searchParams = { 'dealArrangementId': this.arrId, 'dealLineId': this.pDealLineId };
    } else {
      searchParams = { 'dealArrangementId': this.arrId };
    }

    this.loading = true;
    this.rmanContReleaseEventsVService.getAllRmanContReleaseEventsV(this.paginationOptions, searchParams).then((rmanContReleaseEventsVList: any) => {
      this.datasource = rmanContReleaseEventsVList.content;
      this.rmanContReleaseEventsVList = rmanContReleaseEventsVList.content;
      this.loading = false;
      this.totalContElements = rmanContReleaseEventsVList.totalElements;
      this.pageSize = rmanContReleaseEventsVList.size;
      if (this.rmanContReleaseEventsVList.length > 0) {
        this.getAllRmanContReleaseEventsVTest();
        this.showContingenciesDialog = true;
      } else {
        this.notificationService.showWarning('Holds & Events are not applied for this deal line.');
      }

    });
  }

  deliveryDetails(dd: Table){
    this.loading = true;
    if(this.sourceLineId != null && this.sourceLineId != undefined && this.pDealLineId !=null && this.pDealLineId !=undefined){
      this.rmanRevDetailsVService.getDeliveryDetails(this.paginationOptions, this.pDealLineId, this.sourceLineId).then((rmanDeliveryDetailsList: any) =>{
        this.rmanDeliveryDetailsList = rmanDeliveryDetailsList.content;
        this.loading = false;
        this.totalDeliveryDetailsElements = rmanDeliveryDetailsList.totalElements;
        this.pageSize = rmanDeliveryDetailsList.size;
        if (this.rmanDeliveryDetailsList.length > 0) {
          this.showDeliveryDetailsDialog = true;
        } else {
          this.notificationService.showWarning('No Delivery Details associated with corresponding Deal Line Id and Source Line Id');
        }
  
      });
    }else if(this.sourceLineId == null && this.pDealLineId == null){
      //warning
      this.notificationService.showWarning('Please select a record to View Delivery Details');
      this.loading = false;
    }else if(this.sourceLineId == null || this.pDealLineId == null){
      this.notificationService.showWarning('Either Deal Line Id or Source Line Id is empty, Please check and try again');
      this.loading = false;
    }
  }

  revenueSchedules(ars: Table){
    this.loading = true;
    if(this.arrId !=null && this.arrId !=undefined){
      this.rmanRevDetailsVService.getActualRevSchedules(this.paginationOptions, this.arrId).then((rmanActualRevenueSchedulesList: any)=>{
        this.rmanActualRevenueSchedulesList = rmanActualRevenueSchedulesList.Content;
        this.totalRevScheduleElements = rmanActualRevenueSchedulesList.Content.length;
        this.revSchedulesRowSize = 10;
        if(this.totalRevScheduleElements > 0){
          let dTemp: any = this.rmanActualRevenueSchedulesList[0];
          this.revcolumns = [];
          for (let prop in dTemp) {
            this.revcolumns.push({
              field: prop,
              header: prop,
              display: 'table-cell',
              text: 'right'
              //style: { 'width': '100px', 'text-align': 'right' },
              //display: 'table-cell',
              
            });

          }

          let leftAlignItems = ["Product Name"];

          for (let index = 0; index < this.revcolumns.length; index++) {
            if (leftAlignItems.indexOf(this.revcolumns[index].header) == -1) {
              this.revcolumns[index].text = "right";
            } else {
              this.revcolumns[index].text = "left";
            }
          }



          this.rmanActualRevenueSchedulesList = rmanActualRevenueSchedulesList.Content.slice(0, 10);
          this.showActualRevSchedulesDialog = true;
          this.loading = false;
        }else{
          this.loading = false;
          this.notificationService.showWarning('No Actual Revenue Schedules associated with corresponding Revenue Contract Number');
        }

        
      });
    }
  }

  cancel(){
    this.revcolumns = [];
  }

  paginate(data) {
    this.loading = true;
    this.rmanActualRevenueSchedulesList = this.rmanActualRevenueSchedulesList.slice(data.first, data.first + 10);
    this.loading = false;
  }


  getDeliveryDetails(event: any) {
    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageContSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.rmanRevDetailsVService.getDeliveryDetails(this.paginationOptions, this.pDealLineId, this.sourceLineId).then((rmanDeliveryDetailsList: any) => {
      this.datasource = rmanDeliveryDetailsList.content;
      this.rmanDeliveryDetailsList = rmanDeliveryDetailsList.content;
      this.loading = false;
      this.totalContElements = rmanDeliveryDetailsList.totalElements;
      this.pageSize = rmanDeliveryDetailsList.size;

    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });

  }



  revSchedules() {
    if (this.pDealLineId != null) {
      this.loading = true;
      this.rmanRevDetailsVService.getUsageSummaryDetails(this.paginationOptions, this.pDealLineId).then((rmanDealUsageSummaryList: any) => {
        this.datasource = rmanDealUsageSummaryList.content;
        this.rmanDealUsageSummaryList = rmanDealUsageSummaryList.content;
        this.loading = false;
        this.disableExport = false;
        this.totalContElements = rmanDealUsageSummaryList.totalElements;
        this.pageSize = rmanDealUsageSummaryList.size;
        if (this.rmanDealUsageSummaryList.length > 0) {
          this.showRevSchedulesDialog = true;
        } else {
          this.notificationService.showWarning('No Revenue Schedules for selected deal line.');
        }

      });

    } else {
      this.notificationService.showWarning('Select deal to view Revenue Schedules.');
    }
  }


  accounting(dt1: Table) {
    this.rmanGlAccountingV = new RmanGlAccountingVImpl();
    this.rmanGlAccountingVSearch = new RmanGlAccountingVImpl();
    this.showAccountingDialog = true;
    dt1.reset();
  }

  getAllRmanGlAccountingV() {
    this.loading = true;
    this.rmanGlAccountingVService.getAllRmanGlAccountingV(this.paginationOptions, this.rmanGlAccountingVSearch, this.exportCols).then((rmanGlAccountingVList: any) => {
      this.datasource = rmanGlAccountingVList.content;
      this.rmanGlAccountingVList = rmanGlAccountingVList.content;
      this.totalAccElements = rmanGlAccountingVList.totalElements;
      this.pageSize = rmanGlAccountingVList.size;
      this.loading = false;
      this.disableExport = false;
      this.displaySearchDialog = false;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }

  getAllRmanGlAccountingVFilter() {
    this.loading = true;
    this.rmanGlAccountingVService.getAllRmanGlAccountingV(this.paginationOptions, this.rmanGlAccountingV, this.exportCols).then((rmanGlAccountingVList: any) => {
      this.loading = false;
      this.datasource = rmanGlAccountingVList.content;
      this.rmanGlAccountingVList = rmanGlAccountingVList.content;
      this.rmanGlAccountingVList = this.rmanGlAccountingVList.slice();
      this.totalAccElements = rmanGlAccountingVList.totalElements;
      this.pageSize = rmanGlAccountingVList.size;
      this.displaySearchDialog = false;
      this.disableExport = false;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }

  getRmanGlAccountingV(event: any) {

    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };

    this.rmanGlAccountingV = this.rmanGlAccountingVSearch;
    this.rmanGlAccountingV.dealArrangementId = this.arrId;
    if (this.pDealLineId != null) {
      this.rmanGlAccountingV.dealLineId = this.pDealLineId;
    }
    this.loading = true;
    this.rmanGlAccountingVService.getAllRmanGlAccountingV(this.paginationOptions, this.rmanGlAccountingV, this.exportCols).then((rmanGlAccountingVList: any) => {

      this.datasource = rmanGlAccountingVList.content;
      this.rmanGlAccountingVList = rmanGlAccountingVList.content;
      this.totalAccElements = rmanGlAccountingVList.totalElements;
      this.pageSize = rmanGlAccountingVList.size;
      this.loading = false;
      this.disableExport = false;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });

  }

  exportAccountsExcel() {
    let searchParam = {};
    if (this.pDealLineId != null) {
      searchParam = { 'dealArrangementId': this.arrId, 'orderNumber': this.rmanGlAccountingVSearch.orderNumber, 'sourceLineNumber': this.rmanGlAccountingVSearch.sourceLineNumber, 'dealLineId': this.rmanGlAccountingVSearch.dealLineId };
    } else {
      searchParam = { 'dealArrangementId': this.arrId, 'orderNumber': this.rmanGlAccountingVSearch.orderNumber, 'sourceLineNumber': this.rmanGlAccountingVSearch.sourceLineNumber };
    }
    let serviceUrl = this.rmanGlAccountingVService.getServiceUrl(this.paginationOptions, searchParam, this.exportCols, 1);
    window.location.href = serviceUrl;

  }


  getAllRmanRevDetailsV() {
    if(!this.swicthClickRecognizer){
      this.loading = true;
      this.rmanDealArrangementsService.getDealArrangementBasis(this.arrId).then((data) => {
        console.log(data);
        this.revenueContractBasis = data;
        if(this.revenueContractBasis === 'SO' || this.revenueContractBasis === 'PO'){
          this.isRevType = true;
          this.revType = 'SO';
        }
      });
    }
    this.totalAllocAmountTotal = 0;
    this.deliveredAllocRspTotal = 0;
    this.postBillingProvisionTotal = 0;
    this.postBillingDeferralsTotal = 0;
    this.postBillingAllocationAmountTotal = 0;
    this.begBalanceTotal = 0;
    this.currentPeriodTotal = 0;
    this.endingBalanceTotal = 0;
    this.totalAllocAmountFcTotal = 0;
    this.deliveredAllocRspFcTotal = 0;
    this.pbDeferralsFcTotal = 0;
    this.totalBookedAmount = 0;
    this.totalShippedAmount = 0;
    this.totalBilledAmount = 0;
    this.totalUnamortizedAmount = 0;
    this.totalBilledAmountFc = 0;
    this.totalPbAllocAmountTc = 0;
    this.totalRevBegBalTc = 0;
    this.totalRevCurrBalTc = 0;
    this.totalRevEndBalTc = 0;
    this.totalUnamortizedAmountTc = 0;
    this.totalRevenueAdjustment = 0;
    this.loading = true;
    this.rmanRevDetailsV['dealArrangementId'] = this.arrId;
    this.rmanRevDetailsVService.getAllRmanRevDetailsV(this.paginationOptions, this.arrId, this.so, this.soLine, this.revType, this.exportCols).then((rmanRevDetailsVList: any) => {
      this.datasource = rmanRevDetailsVList.content;
      this.rmanRevDetailsVList = rmanRevDetailsVList.content;
      if (this.rmanRevDetailsVList.length > 0) {
        this.selectedRmanRevDetailsV = this.rmanRevDetailsVList[0];
        this.sku = this.selectedRmanRevDetailsV.productName;
        this.lineNumber = this.selectedRmanRevDetailsV.arrgLineNumber;

      }

      this.totalRevElements = rmanRevDetailsVList.totalElements;
      this.pageSize = rmanRevDetailsVList.size;
      this.getAllRevenuesTotal();
      this.displaySearchDialog = false;
      this.loading = false;
      this.disableExport = false;

    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });

  }


  getRmanRevDetailsV(event: any) {

    if(!this.swicthClickRecognizer){
      this.loading = true;
      this.rmanDealArrangementsService.getDealArrangementBasis(this.arrId).then((data) => {
        console.log(data);
        this.revenueContractBasis = data;
        if(this.revenueContractBasis === 'SO' || this.revenueContractBasis === 'PO'){
          this.isRevType = true;
          this.revType = 'SO';
        }
        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.loading = true;
        this.rmanRevDetailsV['dealArrangementId'] = this.arrId;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.rmanRevDetailsVService.getAllRmanRevDetailsV(this.paginationOptions, this.arrId, this.so, this.soLine, this.revType, this.exportCols).then((rmanRevDetailsVList: any) => {
          this.datasource = rmanRevDetailsVList.content;
          this.rmanRevDetailsVList = rmanRevDetailsVList.content;
          if (this.rmanRevDetailsVList.length > 0) {
            this.selectedRmanRevDetailsV = this.rmanRevDetailsVList[0];
            this.sku = this.selectedRmanRevDetailsV.productName;
            this.getAllRevenuesTotal();
          }
          this.totalRevElements = rmanRevDetailsVList.totalElements;
          this.pageSize = rmanRevDetailsVList.size;
          this.loading = false;
    
        }).catch((err: any) => {
          this.notificationService.showError('Error occured while getting data');
          this.loading = false;
        });
      });
    }


  }


  getAllRevenuesTotal() {
    this.rmanRevDetailsVService.getAllRevenueTotals(this.arrId, this.so, this.soLine, this.revType).then((revenueTotalResponse: any) => {
      this.totalAllocAmountTotal = revenueTotalResponse['totalAllocation'];
      this.deliveredAllocRspTotal = revenueTotalResponse['deliveredAllocationRsp'];
      this.postBillingProvisionTotal = revenueTotalResponse['postBillingContingency'];
      this.postBillingDeferralsTotal = revenueTotalResponse['postBillingDeffered'];
      this.postBillingAllocationAmountTotal = revenueTotalResponse['postBillingAllocation'];
      this.begBalanceTotal = revenueTotalResponse['revenueBeginBalance'];
      this.currentPeriodTotal = revenueTotalResponse['revenueCurrentMonthBalance'];
      this.endingBalanceTotal = revenueTotalResponse['revenueEndBalance'];
      this.totalAllocAmountFcTotal = revenueTotalResponse['totalAllocationFc'];
      this.deliveredAllocRspFcTotal = revenueTotalResponse['deliveredAllocFcRsp'];
      this.pbDeferralsFcTotal = revenueTotalResponse['pbDeferralFc'];
      this.totalBookedAmount = revenueTotalResponse['totalBookedAmount'];
      this.totalShippedAmount = revenueTotalResponse['totalShippedAmount'];
      this.totalBilledAmount = revenueTotalResponse['totalBilledAmount'];
      this.totalUnamortizedAmount = revenueTotalResponse['totalUnamortizedAmount'];
      this.totalBilledAmountFc = revenueTotalResponse['totalBilledAmountFc'];
      this.totalPbAllocAmountTc = revenueTotalResponse['totalPostBollingAllocAmtTc'];
      this.totalRevBegBalTc = revenueTotalResponse['totalRevBegBalTc'];
      this.totalRevCurrBalTc = revenueTotalResponse['totalRevCurrBalTc'];
      this.totalRevEndBalTc = revenueTotalResponse['totalRevEndBalTc'];
      this.totalUnamortizedAmountTc = revenueTotalResponse['totalUnamortizedAmountTc'];
      this.totalRevenueAdjustment = revenueTotalResponse['totalRevenueAdjustment'];
    }).catch((err: any) => {
    });
  }

  showDialogToAdd() {

    this.newRmanRevDetailsV = true;
    this.rmanRevDetailsV = new RmanRevDetailsVImpl();
    this.displayDialog = true;

  }


  save() {

    if (this.newRmanRevDetailsV) {
      this.loading = true;
      this.rmanRevDetailsVService.saveRmanRevDetailsV(this.rmanRevDetailsV).then((response: any) => {
        this.notificationService.showSuccess('Saved successfully');
        this.getAllRmanRevDetailsV();
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while saving data');
        this.loading = false;
      });
    }
    else {
      this.loading = true;
      this.rmanRevDetailsVService.updateRmanRevDetailsV(this.rmanRevDetailsV).then((response: any) => {
        this.notificationService.showSuccess('Updated successfully');
        this.getAllRmanRevDetailsV();
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while updating data');
        this.loading = false;
      });
    }

    this.rmanRevDetailsV = new RmanRevDetailsVImpl();

    this.displayDialog = false;

  }


  delete(rmanRevDetailsV: any) {
    this.rmanRevDetailsV = rmanRevDetailsV;
    this.displayDialog = false;
    if (window.confirm('Are you sure you want to delete this record?')) {
      this.rmanRevDetailsVList.splice(this.findSelectedRmanRevDetailsVIndex(), 1);
      this.loading = true;
      this.rmanRevDetailsVService.deleteRmanRevDetailsV(this.rmanRevDetailsV).then((response: any) => {
        this.loading = false;
        this.rmanRevDetailsV = new RmanRevDetailsVImpl();
        this.getAllRmanRevDetailsV();
      });
    }

  }

  editRow(rmanRevDetailsV: any) {
    this.newRmanRevDetailsV = false;
    this.rmanRevDetailsV = this.cloneRmanRevDetailsV(rmanRevDetailsV);
    this.displayDialog = true;
  }


  findSelectedRmanRevDetailsVIndex(): number {
    return this.rmanRevDetailsVList.indexOf(this.selectedRmanRevDetailsV);
  }

  onRowSelect(event: any) {
    this.selectedRmanRevDetailsV = event.data;
    this.pDealLineId = this.selectedRmanRevDetailsV.dealLineId;
    this.sku = this.selectedRmanRevDetailsV.productName;
    this.lineNumber = this.selectedRmanRevDetailsV.dealLineNumber;
    this.sourceLineId = this.selectedRmanRevDetailsV.sourceLineId;
  }
  onRowUnSelect(event: any) {
    this.pDealLineId = null;
    this.sourceLineId = null;
  }

  cloneRmanRevDetailsV(c: RmanRevDetailsV): RmanRevDetailsV {
    let rmanRevDetailsV: any
      = new RmanRevDetailsVImpl();
    for (let prop in c) {
      rmanRevDetailsV[prop] = c[prop];
    }
    return rmanRevDetailsV;
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

    this.rmanRevDetailsVSearch = new RmanRevDetailsVImpl();

    if (this.isSerached == 0) {
      this.rmanRevDetailsVSearch = new RmanRevDetailsVImpl();
    }
    this.displaySearchDialog = true;

  }

  search() {

    this.isSerached = 1;
    this.rmanRevDetailsV = this.rmanRevDetailsVSearch;
    this.displaySearchDialog = false;
    this.getAllRmanRevDetailsV();
  }

  onBeforeToggle(evt: any) {
    this.collapsed = evt.collapsed;
  }

  getRmanUsage(event: any) {
    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loading = true;
    this.rmanRevDetailsVService.getAllUsages(this.paginationOptions, this.uDealLineId).then((rmanUsagesVList: any) => {
      this.rmanUsagesVList = rmanUsagesVList.content;
      this.totalUsagesElements = rmanUsagesVList.totalElements;
      this.pageSize = rmanUsagesVList.size;

      if (this.rmanUsagesVList.length > 0) {
        this.showUsageDialog = true;
      } else {
        this.notificationService.showWarning('Usages are not created for this deal line.');
      }
      this.loading = false;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data for Usages');
      this.loading = false;
    });


  }
  showUsages(dealLineId) {
    this.uDealLineId = dealLineId;
    this.rmanUsagesVList = [];
    this.showUsageDialog = true;
  }

  fieldType(fieldValue: any) {
    return typeof fieldValue;
  }

}


class RmanRevDetailsVImpl {
  constructor(public dealLineId?: any, public deliveredAllocRsp?: any, public totalGaapRevenueCurrentMon?: any, public dealArrangementName?: any, public postBillingContAmount?: any, public cumGaapEndingBalance?: any, public arrgLineAmount?: any, public totalGaapRevenueEndingBal?: any, public cumGaapBegBalance?: any, public bookedAmount?: any, public preBillingContAmount?: any, public dealLineNumber?: any, public productGroup?: any, public cogsBegiBalCogs?: any, public productName?: any, public dealArrangementId?: any, public accountingRuleName?: any, public shippedAmount?: any, public billedAmount?: any, public productType?: any, public netGappCurrMonth?: any, public element?: any, public postBillingAllocationAmount?: any, public currentMonthCogs?: any, public gaapUnamortized?: any, public totalGaapRevneueBegBal?: any, public arrgLineCost?: any, public endingBalance?: any, public totalAllocation?: any, public duration?: any, public postBillingDeferrals?: any, public attributedNetPrice?: any,
    public deliveredAttributedNetPrice?: any, public pobGroup?: any, public arrgLineNumber?: any, public amortMethodRevenue?: any, sourceLineId?: any) { }
}

interface ILabels {
  [index: string]: string;
}
