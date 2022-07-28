import { ChangeDetectorRef, Component, Input, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NavigationEnd, Router } from "@angular/router";
import { ConfirmationService } from 'primeng/api';
import { Table } from 'primeng/table';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { ArrgContractAllocationsV } from './arrgContractAllocationsV';
import { ArrgContractAllocationsVService } from './arrgContractAllocationsVservice';
import { DatePipe, Location } from '@angular/common';
import { Subscription } from 'rxjs';
import { DealarrangementService } from '../dealArrangements/dealarrangement.service';
import { RmanDealArrangementsService } from '../rmanDealArrangements/rmanDealArrangementsservice';
import { delay } from 'rxjs/operators';

declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
  templateUrl: './arrgContractAllocationsV.component.html',
  selector: 'arrgContractAllocationsV-data',
  providers: [ArrgContractAllocationsVService, ConfirmationService,DatePipe, CommonSharedService, RmanDealArrangementsService]
})

export class ArrgContractAllocationsVComponent implements OnInit {

  displayDialog: boolean;

  displaySearchDialog: boolean;

  tempDisplayDialog: boolean = false;

  test: boolean;

  displayPageSize: any = 20;

  displayProspectiveDialog: boolean = false;
  noData = appSettings.noData;
  @Input() arrId: any;
  arrIdK: any;
  arrgNumber: any;
  arrgName: any;
  selectedDeals: any[] = [];
  dealLinesList: any[];

  displayProspDeals: boolean = false;
  arrgContractAllocationsV: any = new ArrgContractAllocationsVImpl();

  arrgContractAllocationsVSearch: any = new ArrgContractAllocationsVImpl();

  prospectiveDeals: any = new ProspectiveDealsImpl();
  prospectiveDealsList: any[] = [];
  prospectiveDealListConst: any[] = [];
  isSerached: number = 0;

  selectedArrgContractAllocationsV: ArrgContractAllocationsV;

  newArrgContractAllocationsV: boolean;

  arrgContractAllocationsVList: any[] = [];

  newProspectiveDealsList: any[] = [];

  cols: any[];
  columns: any[];
  columnOptions: any[];

  paginationOptions: any;

  pages: {};

  cref: ChangeDetectorRef;

  datasource: any[];
  pageSize: number;
  totalElements: number;
  totalRecords: number;
  rowCount: any = 10;

  collapsed: boolean = true;

  allocationsForm: FormGroup;

  arrgResult: {};
  lineAmountTotal: any;
  vcTotal: any;
  allocableNetTotal: any;
  fvTotal: any;
  allocationTotal: any;
  allocationFcTotal: any;
  cvInOutAmountTotal: any;
  totalListAmount: any;
  espTotal: any;
  espInstTotal: any;
  statusTotal: any;
  commentsTotal: any;
  table: any = {};
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

  quoteOrderSwitch: boolean = false;

  revenueContractBasis:any;
  data:any;
/**
  * Added Import DatePipe Component and added in Providers
				  * A	dded DatePipe Service in the constructor used for the 
  * Date convert to the ISO Date format(YYYY-MM-DD)
  * To fix the bug #AYAR-403 by chandra kota on 2021-JUN-01 
  */
  constructor(private ref: ChangeDetectorRef, private arrgContractAllocationsVService: ArrgContractAllocationsVService, private router: Router,
    private confirmationService: ConfirmationService, private formBuilder: FormBuilder, private commonSharedService: CommonSharedService,
    private notificationService:NotificationService,private datePipe: DatePipe, private dealArrgService:RmanDealArrangementsService, private location: Location) {
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
      this.data = this.location.getState();
      this.arrIdK = this.data.arrgId;
      this.router.events.subscribe((event) => {
        if (event instanceof NavigationEnd) {
          this.arrIdK = event.url.split('/')[3];
        }
      });

  }


  ngOnInit() {
    this.selectedDeals = [];
    this.globalCols = [
      { field: 'pobGrouping', header: 'POB ID', showField: true, drag: false, display: "table-cell", type: 'text', footer: 'empty' },
      { field: 'arrgLineNumber', header: 'Revenue Contract Line#', showField: true, drag: false, display: "table-cell", type: 'number', footer: 'empty' },
      { field: 'customerPoNum', header: 'PO', showField: true, drag: true, display: "table-cell", type: 'number', footer: 'empty' },
      { field: 'orderNumber', header: 'SO#', showField: true, drag: true, display: "table-cell", type: 'number', footer: 'empty' },
      { field: 'sourceLineNumber', header: 'SO Line#', showField: true, drag: true, display: "table-cell", type: 'number', footer: 'empty' },
      { field: 'dealNumber', header: 'Contract/Deal#', showField: true, drag: true, display: "table-cell", type: 'number', footer: 'empty' },
      { field: 'dealLineNumber', header: 'Line#', showField: true, drag: true, display: "table-cell", type: 'number', footer: 'empty' },
      { field: 'productName', header: 'Product Name', drag: true, showField: true, display: "table-cell", type: 'text', footer: 'empty' },
      { field: 'productDescription', header: 'Product Description', drag: true, showField: true, display: "table-cell", type: 'text', footer: 'empty' },
      { field: 'uomCode', header: 'UOM', drag: true, showField: true, display: "table-cell", type: 'text', footer: 'empty' },
      { field: 'quantity', header: 'Quantity', drag: true, showField: true, display: "table-cell", type: 'number', footer: 'empty' },
      { field: 'dealCurrencyCode', header: 'Currency', drag: true, showField: true, display: "table-cell", type: 'text', footer: 'empty' },
      { field: 'unitListPrice', header: 'Unit List Price', drag: true, showField: true, display: "table-cell", type: 'round', footer: 'empty' },
      { field: 'unitSellingPrice', header: 'Unit Selling Price', drag: true, showField: true, display: "table-cell", type: 'round', footer: 'empty' },
      { field: 'netPriceDiscount', header: 'Net Price Discount%', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'totals' },
      { field: 'extendedListAmount', header: 'Extended List Amount', drag: true, showField: true, display: "table-cell", type: 'round', footer: 'totalListAmount' },
      { field: 'lineAmount', header: 'Line Amount', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'lineAmountTotal' },
      { field: 'vc', header: 'Variable Consideration', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'vcTotal' },
      { field: 'allocableAmount', header: 'Allocable Net Price', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'allocableNetTotal' },
      { field: 'elementType', header: 'Element Type', showField: true, drag: true, display: "table-cell", type: 'text', footer: 'empty' },
      { field: 'bundleFlag', header: 'Bundle Flag', showField: true, drag: true, display: "table-cell", type: 'text', footer: 'empty' },
      { field: 'parentLineId', header: 'Parent Product', showField: true, drag: true, display: "table-cell", type: 'number', footer: 'empty' },
      { field: 'productGroup', header: 'Product Family', showField: true, drag: true, display: "table-cell", type: 'text', footer: 'empty' },
      { field: 'productType', header: 'Product Line', showField: true, drag: true, display: "table-cell", type: 'text', footer: 'empty' },
      { field: 'fmvRuleName', header: 'SSP Rule Name', showField: true, drag: true, display: "table-cell", type: 'text', footer: 'empty' },
      { field: 'fmvCategory', header: 'SSP Category', drag: true, showField: true, display: "table-cell", type: 'text', footer: 'empty' },
      { field: 'fmvType', header: 'SSP Type', drag: true, showField: true, display: "table-cell", type: 'text', footer: 'empty' },
      { field: 'fmvMin', header: 'SSP Min', drag: true, showField: true, display: "table-cell", type: 'round', footer: 'empty' },
      { field: 'fmvMean', header: 'SSP Trx', drag: true, showField: true, display: "table-cell", type: 'round', footer: 'empty' },
      { field: 'fmvMax', header: 'SSP Max', drag: true, showField: true, display: "table-cell", type: 'round', footer: 'empty' },
      { field: 'bundleAttributionList', header: 'Bundle Attribution List', drag: true, showField: true, display: "table-cell", type: 'round', footer: 'empty' },
      { field: 'bundleAttributionNet', header: 'Bundle Attribution Net', drag: true, showField: true, display: "table-cell", type: 'round', footer: 'empty' },
      { field: 'sspLow', header: 'SSP Low', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'empty' },
      { field: 'sspHigh', header: 'SSP High', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'empty' },
      { field: 'ssp', header: 'SSP', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'empty' },
      { field: 'fmvAmount', header: 'Extended SSP', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'fvTotal' },
      { field: 'allocationAmount', header: 'Allocation Amount', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'allocationTotal' },
      { field: 'cvInOutAmount', header: 'Carve In/Carve Out ', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'cvInOutAmountTotal' },
      { field: 'allocationFlag', header: 'Allocation Flag', showField: true, drag: true, display: "table-cell", type: 'text', footer: 'empty' },
      { field: 'allocationInclusive', header: 'Allocation Inclusive', showField: true, drag: true, display: "table-cell", type: 'text', footer: 'empty' },
      { field: 'totalCost', header: 'Total Cost', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'empty' },
      { field: 'fxRate', header: 'Fx Rate', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'empty' },
      { field: 'fxCurrency', header: 'Fx Currency', showField: true, drag: true, display: "table-cell", type: 'number', footer: 'empty' },
      { field: 'fxDate', header: 'Fx Date', showField: true, drag: true, display: "table-cell", type: 'date', footer: 'empty' },
      { field: 'allocationAmountFc', header: 'Allocation Amount(FC)', drag: true, showField: true, display: "table-cell", type: 'round', footer: 'allocationFcTotal' },
      { field: 'bedp', header: 'BEDP', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'empty' },
      { field: 'esp', header: 'ESP', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'espTotal' },
      { field: 'espinst', header: 'ESP+INT', drag: true, showField: true, display: "table-cell", type: 'round', footer: 'espInstTotal' },
      { field: 'allocationMarginPercentage', header: 'Allocation Margin %', showField: true, drag: true, display: "table-cell", type: 'round', footer: 'empty' },
      { field: 'grossMarginPercentage', header: 'Gross Margin %', drag: true, showField: true, display: "table-cell", type: 'round', footer: 'empty' },
      { field: 'revenueGuidance', header: 'Revenue Guidance Analysis', drag: true, showField: true, display: "table-cell", type: 'symbol', footer: 'statusTotal' },
      { field: 'comments', header: 'Revenue Guidance Description', drag: true, showField: true, display: "table-cell", type: 'text', footer: 'commentsTotal' }
      
    ];
    this.columns = [];
    this.getTableColumns("arrgContractAllocationsV", "Allocations Table");
    this.buildForm();
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
    this.commonSharedService.saveOrUpdateTableColumns("arrgContractAllocationsV", "Allocations Table", selectedCols, this.userId).then((response) => {
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
    let serviceUrl = this.arrgContractAllocationsVService.getServiceUrl(this.paginationOptions, { 'dealArrangementId': this.arrIdK }, 1, this.exportCols, this.quoteOrderSwitch);
    window.location.href = serviceUrl;

  }



  OnReceiveChange(event: any) {
  }


  reset(dt: Table) {
    this.paginationOptions = {};
    this.selectedDeals = [];
    this.arrgContractAllocationsV = new ArrgContractAllocationsVImpl();
    dt.reset();
  }

  buildForm() {
    this.allocationsForm = this.formBuilder.group({
      'arrangementNumber': ['', [Validators.required]],
      'arrangementName': ['', [Validators.required]],
      'unitSellingPrice': [''],
      'undeliveredQty': ['']

    });

    this.allocationsForm.valueChanges
      .subscribe(data => this.onValueChanged(data));

    this.onValueChanged();
  }

  onValueChanged(data?: any) {
    if (!this.allocationsForm) { return; }
    const form = this.allocationsForm;

    for (const field in this.formErrors) {
      // clear previous error message (if any)
      this.formErrors[field] = '';
      const control = form.get(field);
      if (control && control.dirty && !control.valid) {
        const messages = this.validationMessages[field];
        for (const key in control.errors) {
          this.formErrors[field] += messages[key] + ' ';
        }
      }
    }
  }

  formErrors = {
    'arrangementNumber': '', 'arrangementName': ''
  };

  validationMessages = {
    'arrangementNumber': {
      'required': "Arrangement Number is required"
    },
    'arrangementName': {
      'required': "Arrangement Name is required"
    }
  }

  swicthClickRecognizer:boolean = false;
  onQuoteOrderSwitch(){
    this.swicthClickRecognizer = true;
    this.arrgContractAllocationsV = new ArrgContractAllocationsVImpl();
    this.getAllArrgContractAllocationsV();
  }

  getAllArrgContractAllocationsV() {
    if(!this.swicthClickRecognizer){
      this.loading = true;
      this.dealArrgService.getDealArrangementBasis(this.arrIdK).then((data) => {
        this.revenueContractBasis = data;
        if(this.revenueContractBasis === 'SO' || this.revenueContractBasis === 'PO'){
          this.quoteOrderSwitch = true;
        }
      });
    }

    this.lineAmountTotal = 0;
    this.vcTotal = 0;
    this.allocableNetTotal = 0;
    this.fvTotal = 0;
    this.allocationTotal = 0;
    this.allocationFcTotal = 0;
    this.cvInOutAmountTotal = 0;
    this.totalListAmount = 0;
    this.espTotal = 0;
    this.espInstTotal = 0;
    this.statusTotal = null;
    this.commentsTotal = null;

    this.loading = true;
    this.arrgContractAllocationsV['dealArrangementId'] = this.arrIdK;
    this.arrgContractAllocationsVService.getAllArrgContractAllocationsV(this.paginationOptions, this.arrgContractAllocationsV, this.exportCols,this.quoteOrderSwitch).then((arrgContractAllocationsVList: any) => {
      this.datasource = arrgContractAllocationsVList.content;
      this.arrgContractAllocationsVList = arrgContractAllocationsVList.content;
      this.totalElements = arrgContractAllocationsVList.totalElements;
      this.pageSize = arrgContractAllocationsVList.size;
      this.getAllAllocationsTotal();
      this.displaySearchDialog = false;
      this.disableExport = false;
    }).catch((err: any) => {
      this.loading = false;
      this.notificationService.showError('Network failed / service is down');
    });
  }


  getArrgContractAllocationsV(event: any) {
    if(!this.swicthClickRecognizer){
      this.loading = true;
      this.dealArrgService.getDealArrangementBasis(this.arrIdK).then((data) => {
        this.revenueContractBasis = data;
        if(this.revenueContractBasis === 'SO' || this.revenueContractBasis === 'PO'){
          this.quoteOrderSwitch = true;
        }
        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.loading = true;
        this.arrgContractAllocationsV['dealArrangementId'] = this.arrIdK;
        this.arrgContractAllocationsVService.getAllArrgContractAllocationsV(this.paginationOptions, this.arrgContractAllocationsV, this.exportCols,this.quoteOrderSwitch).then((arrgContractAllocationsVList: any) => {
          this.datasource = arrgContractAllocationsVList.content;
          this.arrgContractAllocationsVList = arrgContractAllocationsVList.content;
          this.totalElements = arrgContractAllocationsVList.totalElements;
          this.pageSize = arrgContractAllocationsVList.size;
          this.getAllAllocationsTotal();
        }).catch((err: any) => {
          this.loading = false;
          this.notificationService.showError('Network failed / service is down' );
        });
      });
    }

  }


  getAllAllocationsTotal() {
    this.arrgContractAllocationsVService.getAllAllocationsTotal(this.arrIdK, this.quoteOrderSwitch).then((allAllocationResponse: any) => {
      this.lineAmountTotal = allAllocationResponse['totalLineAmount'];
      this.vcTotal = allAllocationResponse['totalVCAmount'];
      this.allocableNetTotal = allAllocationResponse['totalAllocableNetPrice'];
      this.fvTotal = allAllocationResponse['totalSSPAmount'];
      this.allocationTotal = allAllocationResponse['totalAllocationAmount'];
      this.allocationFcTotal = allAllocationResponse['totalAllocationFcAmount'];
      this.cvInOutAmountTotal = allAllocationResponse['totalCvInOutAmount'];
      this.totalListAmount = allAllocationResponse['totalListAmount'];
      this.espTotal=allAllocationResponse['totalEsp'];
      this.espInstTotal = allAllocationResponse['totalEspinst'];
      this.statusTotal = allAllocationResponse['totalRevenueGuidanceAnalysis'];
      this.commentsTotal = allAllocationResponse['totalRevenueGuidanceDescription'];
      this.loading = false;   
      this.disableExport = false;   
    }).catch((err: any) => {
      this.loading = false;
    });
  }

/**
  * Added cnt variable and Date values in prospectiveDealsList  data
  * need to format like ISO standrd Date like 'YYYY-MM-DD'
  * AYAR-403 Chandra Kota on 2021-JUN-01
  */
  getProspDealsOnLoad() {
    this.loading = true;
    this.arrgContractAllocationsVService.getAllProspectiveDealsTest(this.arrIdK, this.dealLinesList)
      .subscribe(prospectiveDealsList => {
        this.totalRecords = prospectiveDealsList.length;
        this.prospectiveDealListConst = prospectiveDealsList;
		
		this.prospectiveDealsList = prospectiveDealsList.slice(0, 10);
		let cnt:any=0;
		this.prospectiveDealsList.forEach(x=>{
			if(x.contractStartDate){
				this.prospectiveDealsList[cnt].contractStartDate=new Date(x.contractStartDate);
			}
			if(x.contractEndDate){
				this.prospectiveDealsList[cnt].contractEndDate=new Date(x.contractEndDate);
			}
			if(x.serviceStartDate){
				this.prospectiveDealsList[cnt].serviceStartDate=new Date(x.serviceStartDate);
			}
			if(x.serviceEndDate){
				this.prospectiveDealsList[cnt].serviceEndDate=new Date(x.serviceEndDate);
			}
			cnt++;
		});
		        
		this.loading = false;
      }, error => {
        this.loading = false;
        this.notificationService.showError('Network failed / service is down');
      })

    this.displayProspectiveDialog = true;
  }

  getProspectiveDeals() {
    if (this.selectedDeals != undefined) {
      if (this.selectedDeals.length > 0) {
        this.dealLinesList = [];
        for (let i = 0; i < this.selectedDeals.length; i++) {
          this.dealLinesList.push(this.selectedDeals[i].dealLineId);
        }
      } else {
        this.notificationService.showError('Select at least one deal Line to prospective');
      }
    }
    else {
      this.notificationService.showError('Select at least one deal Line to prospective');
    }
  }

  processTheProspectiveDeals() {
    this.arrgContractAllocationsVService.getValidArrangement(this.arrgNumber, this.arrgName).then((arrgResult: any) => {
      if (arrgResult == 'Y') {
        this.notificationService.showError('Arrangement already exist');
      }
      else if (arrgResult == 'N') {
        this.loading = true;
        this.arrgContractAllocationsVService.processProspectiveDeals(this.arrIdK, this.arrgNumber, this.arrgName, this.prospectiveDealsList).then((resp: any) => {
          if (resp) {
            this.getAllArrgContractAllocationsV();
            this.displayProspectiveDialog = false;
            this.notificationService.showSuccess('Sucessfully Processed.Created the arrangement' + this.arrgNumber);
          } else {
            this.getAllArrgContractAllocationsV();
            this.displayProspectiveDialog = false;
            this.notificationService.showError('Failed to Process Prospective Deals are failed..!' );
          }
        }).catch((err: any) => {
          this.loading = false;
          this.displayProspectiveDialog = false;
          this.notificationService.showError('Network failed / service is down' );
        });
      }
    });
    this.buildForm();
  }

  processRetrospectiveDeals() {
    this.loading = true;
    this.arrgContractAllocationsVService.processRetrospectiveDeals(this.arrIdK).then((response: any) => {
      if (response) {
        this.getAllArrgContractAllocationsV();
        this.notificationService.showSuccess( 'Sucessfully Retropective Process executed for  ' + this.arrIdK + ' Arrangement' );
      } else {
        this.getAllArrgContractAllocationsV();
        this.notificationService.showError('Retropective Process is failed..!' );
      }
    }).catch((err: any) => {
      this.loading = false;
      this.notificationService.showError('Network failed / service is down' );
    });
  }

  reallocation() {
    this.confirmationService.confirm({
      message: 'Are you sure,Do you want to reallocate?',
      header: 'Confirmation',
      icon: '',
      accept: () => {
        this.arrgContractAllocationsVService.reallocation(this.arrIdK).then((response: any) => {
          this.getAllArrgContractAllocationsV();
        })
        this.notificationService.showSuccess('Allocation Successfully done.' );
      },
      reject: () => {
        this.notificationService.showSuccess('You have rejected.' );
      }
    });
  }

  showDialogToAdd() {
    this.newArrgContractAllocationsV = true;
    this.arrgContractAllocationsV = new ArrgContractAllocationsVImpl();
    this.displayDialog = true;
    this.buildForm();
  }


  save() {
    if (this.newArrgContractAllocationsV) {
      this.loading = true;
      this.arrgContractAllocationsVService.saveArrgContractAllocationsV(this.arrgContractAllocationsV).then((response: any) => {
        this.getAllArrgContractAllocationsV();
      }).catch((err: any) => {
        this.loading = false;
        this.notificationService.showError('Error occured while saving the data' );
      });
    }
    else {
      this.loading = true;
      this.arrgContractAllocationsVService.updateArrgContractAllocationsV(this.arrgContractAllocationsV).then((response: any) => {
        this.getAllArrgContractAllocationsV();
      }).catch((err: any) => {
        this.loading = false;
        this.notificationService.showError('Error occured while saving the data' );
      });
    }
    this.arrgContractAllocationsV = new ArrgContractAllocationsVImpl();
    this.displayDialog = false;
  }

  delete(arrgContractAllocationsV: any) {
    this.arrgContractAllocationsV = arrgContractAllocationsV;
    this.displayDialog = false;

    if (window.confirm('Are you sure you want to delete this record?')) {
      this.arrgContractAllocationsVList.splice(this.findSelectedArrgContractAllocationsVIndex(), 1);
      this.loading = true;
      this.arrgContractAllocationsVService.deleteArrgContractAllocationsV(this.arrgContractAllocationsV).then((response: any) => {
        this.arrgContractAllocationsV = new ArrgContractAllocationsVImpl();
        this.getAllArrgContractAllocationsV();
      });
    }
  }

  editRow(arrgContractAllocationsV: any) {
    this.newArrgContractAllocationsV = false;
    this.arrgContractAllocationsV = this.cloneArrgContractAllocationsV(arrgContractAllocationsV);
    this.displayDialog = true;
  }


  findSelectedArrgContractAllocationsVIndex(): number {
    return this.arrgContractAllocationsVList.indexOf(this.selectedArrgContractAllocationsV);
  }

  onRowSelect(event: any) {
    this.arrgContractAllocationsVList.forEach((item: any) => {
      if (Math.trunc(item.dealLineNumber) == Math.trunc(event.data.dealLineNumber) && (item.dealLineNumber != event.data.dealLineNumber) || (item.parentLineId == event.data.dealLineNumber) || (item.dealLineNumber == event.data.parentLineId) || (item.parentLineId != null && item.parentLineId == event.data.parentLineId)) {
        if (this.selectedDeals != undefined) {
          if (this.selectedDeals.length > 0) {
            let x = this.selectedDeals.length;
            this.selectedDeals[x] = item;
          } else {
            this.selectedDeals[0] = item;
          }
        } else {
          this.selectedDeals = [];
          this.selectedDeals[0] = item;
        }
      }
    });
  }

  onRowUnselect(event: any) {
    this.arrgContractAllocationsVList.forEach((item: any) => {
      if (Math.trunc(item.dealLineNumber) == Math.trunc(event.data.dealLineNumber) || (item.parentLineId == event.data.dealLineNumber) || (item.dealLineNumber == event.data.parentLineId) || (item.parentLineId != null && item.parentLineId == event.data.parentLineId)) {
        this.selectedDeals.splice(this.selectedDeals.indexOf(item), 1);

      }
    });
  }

  cloneArrgContractAllocationsV(c: ArrgContractAllocationsV): ArrgContractAllocationsV {
    let arrgContractAllocationsV: any = new ArrgContractAllocationsVImpl();
    for (let prop in c) {
      arrgContractAllocationsV[prop] = c[prop];
    }
    return arrgContractAllocationsV;
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

    this.arrgContractAllocationsVSearch = new ArrgContractAllocationsVImpl();

    if (this.isSerached == 0) {
      this.arrgContractAllocationsVSearch = new ArrgContractAllocationsVImpl();
    }
    this.displaySearchDialog = true;

  }

  search() {
    this.isSerached = 1;
    this.arrgContractAllocationsV = this.arrgContractAllocationsVSearch;
    this.getAllArrgContractAllocationsV();
  }

  onBeforeToggle(evt: any) {
    this.collapsed = evt.collapsed;
  }

  ProspectiveAnalysis() {
    this.prospectiveDealsList = [];
    this.arrgName = '';
    this.arrgNumber = '';
    if (this.selectedDeals != undefined) {
      if (this.selectedDeals.length > 0) {
        this.dealLinesList = [];
        for (let i = 0; i < this.selectedDeals.length; i++) {
          this.dealLinesList.push(this.selectedDeals[i].dealLineId);
        }
        this.prospectiveDealsList = [];
        this.getProspDealsOnLoad();
      } else {
        this.notificationService.showWarning('No deals Lines Selected to Prospective..!' );
      }
    } else {
      this.notificationService.showError('Select atleast one deal Line to Prospective..!' );
    }

  }

  paginate(data) {
    this.loading = true;
    this.prospectiveDealsList = this.prospectiveDealListConst.slice(data.first, data.first + 10);
    this.loading = false;
  }

  executeRetrospectiveProcess() {
    this.confirmationService.confirm({
      message: 'Are you sure you want to retrospective process for this arrangement?',
      header: 'Confirmation',
      icon: '',
      accept: () => {
        this.processRetrospectiveDeals();
        this.notificationService.showInfo( 'You have accepted' );
      },
      reject: () => {
        this.notificationService.showInfo(  'You have rejected' );
      }
    });

  }
}

class ArrgContractAllocationsVImpl {
  constructor(public dealLineId?: any, public quantity?: any, public elementType?: any, public allocationAmount?: any, public parentLineNumber?: any, public totalCost?: any, public dealCurrencyCode?: any, public unitSellingPrice?: any, public unitListPrice?: any, public fmvCategory?: any, public cvInOutAmount?: any, public bundleAttribitionList?: any, public dealNumber?: any, public lineAmount?: any, public repCurrCode?: any, public fmvRuleName?: any, public pobGrouping?: any,
    public dealLineNumber?: any, public productGroup?: any, public fmvMin?: any, public fmvMean?: any, public fmvAmount?: any, public dealHeaderId?: any, public solution?: any, public parentLineId?: any, public productName?: any, public dealArrangementId?: any, public trxCurrencyCode?: any, public accountingScope?: any, public productType?: any, public fmvMax?: any, public accountingStandard?: any, public uomCode?: any, public allocationInclusive?: any, public bundleAttribitionNet?: any,
    public bundleFlag?: any, public fmvType?: any, public vc?: any, public arrgLineNumber?: any, public allocableAmount?: any, public sspLow?: any, public sspHigh?: any, public netPriceDiscount?: any) { }
}

class ProspectiveDealsImpl {
  constructor(public dealArrangmentId?: any, public quantity?: any, public unitListPrice?: any, public unitSellingPrice?: any, public dealNumber?: any, public dealLineNumber?: any, public productName?: any, public uomCode?: any, public dealCurrencyCode?: any, public conversionRate?: any, public contractStartDate?: any, public contractEndDate?: any, public serviceStartDate?: any, public serviceEndDate?: any, public dealLineId?: any, public undeliveredQty?: any, public undQty?: any, public ssp?: any) { }
}

interface ILabels {
  [index: string]: string;
}
