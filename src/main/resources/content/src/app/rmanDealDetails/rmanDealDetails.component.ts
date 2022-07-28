import { Component, Input, OnChanges, OnInit, SimpleChange } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NavigationEnd, Router } from "@angular/router";
import { Table } from 'primeng/table';
import { RmanCustomersService } from '../rmanCustomers/rmanCustomersservice';
import { RmanDealArrangementsImpl } from '../rmanDealArrangements/rmanDealArrangements.component';
import { RmanDealArrangementsLabels } from '../rmanDealArrangements/rmanDealArrangementsLabels';
import { RmanDealArrangementsService } from '../rmanDealArrangements/rmanDealArrangementsservice';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { RmanProductsImpl } from '../rmanProducts/rmanProducts.component';
import { RmanProductsLabels } from '../rmanProducts/rmanProductsLabels';
import { RmanProductsService } from '../rmanProducts/rmanProductsservice';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanDealDetails } from './rmanDealDetails';
import { RmanDealDetailsService } from './rmanDealDetailsservice';

declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');
@Component({
  templateUrl: './rmanDealDetails.component.html',
  selector: 'rmanDealDetails-data',
  providers: [RmanDealDetailsService, RmanCustomersService, RmanProductsService]
})

export class RmanDealDetailsComponent implements OnInit, OnChanges {


  @Input() pDealHeaderId: any;

  displayDialog: boolean;

  displaySearchDialog: boolean;
  displayItemSearchDialog: boolean;
  rmanProductsSearch: RmanProductsImpl = new RmanProductsImpl();
  rmanProducts: RmanProductsImpl = new RmanProductsImpl();
  selectedProduct: RmanProductsImpl = new RmanProductsImpl();
  rmanProductsLabels: RmanProductsLabels = new RmanProductsLabels();
  rmanDealArrangementsLabels: RmanDealArrangementsLabels = new RmanDealArrangementsLabels();

  selectedDeals: any[] = [];


  mergeStatus: boolean;



  //msgs: Message[];

  arrIdK: any;
  noData = appSettings.noData;
  rmanDealDetails: any = new RmanDealDetailsImpl();

  rmanDealDetailsSearch: any = new RmanDealDetailsImpl();

  rmanDealArrangementsSearch: any = new RmanDealArrangementsImpl();

  rmanDealArrangements: RmanDealArrangementsImpl = new RmanDealArrangementsImpl();

  selectedArrangement: RmanDealArrangementsImpl = new RmanDealArrangementsImpl();

  isSerached: number = 0;

  selectedRmanDealDetails: RmanDealDetails;

  newRmanDealDetails: boolean;

  rmanDealDetailsList: any[];

  dealLinesList: any[];

  cols: any[];
  columns: any[];
  productColumns: ILabels;
  arrangementColumns: ILabels;

  columnOptions: any[];

  paginationOptions: any;

  pages: {};
  displaySplitDialog: boolean;
  displayMergeDialog: boolean;

  datasource: any[];
  productdatasource: any[];
  pageSize: number;
  totalElements: number;
  itemPageSize: number;
  itemTotalElements: number;
  totalArrgElements: number;

  arrgList: any[] = [];
  rmanDealArrangements1: any[] = [];

  rmanCustomersList: any[] = [];
  rmanCustomers: any[];
  rmanCustomers1List: any[] = [];
  rmanCustomers1: any[];

  rmanProductsList: any[] = [];
  rmanDealArrangementsList: any[] = [];
  rmanLookupsV1List: any[] = [];
  rmanLookupsV1: any[];
  rmanDealHeaders: any;
  rmanDealHeadersList: any[] = [];


  collapsed: boolean = true;

  contractLinesForm: FormGroup;

  targetDealArrangementId: any;

  contractLinesSplitForm: FormGroup;

  parrangementId: any;
  parrangementDealFlag: any;
  paramArrangementNumber: any;
  paramArrangementName: any;

  dealDetailsForm: FormGroup;

  arrgName: any;
  arrgNumber: any;
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

  constructor(private rmanDealDetailsService: RmanDealDetailsService, private rmanLookupsVService: RmanLookupsVService, private formBuilder: FormBuilder, private rmanCustomersService: RmanCustomersService,
    private rmanProductsService: RmanProductsService,
    private router: Router,
    private rmanDealArrangementsService: RmanDealArrangementsService, private commonSharedService: CommonSharedService,
    private notificationService: NotificationService) {


    // generate list code
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.arrIdK = event.url.split('/')[3];
      }
    });
    this.loading = true;

    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'ENABLED_FLAG' }).then((rmanLookupsV1List: any) => {
      this.rmanLookupsV1List = rmanLookupsV1List.content;
      this.prepareRmanLookupsV1Object();
      this.rmanDealArrangementsService.getAllRmanDealArrangements(this.paginationOptions, {}).then((arrgList: any) => {
        this.arrgList = arrgList.content;
        this.prepareRmanDealArrangementsObject();
        this.rmanCustomersService.getAllRmanCustomers(this.paginationOptions, {}, false).then((rmanCustomersList: any) => {
          this.rmanCustomersList = rmanCustomersList.content;
          this.prepareRmanCustomersObject();
          this.rmanCustomers1List = rmanCustomersList.content;
          this.prepareRmanCustomers1Object();
          this.rmanProductsService.getAllRmanProducts(this.paginationOptions, {}, false).then((rmanProductsList: any) => {
            this.loading = false;
            this.disableExport = false;
            this.rmanProductsList = rmanProductsList.content;
            this.prepareRmanProductsObject();
          }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
          });

        }).catch((err: any) => {
          this.notificationService.showError('Error occured while getting data');
          this.loading = false;
        });
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while getting data');
        this.loading = false;
      });
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting "Target Deal Arrangement" data');
      this.loading = false;
    });
  }

  ngOnChanges(changes: { [propKey: string]: SimpleChange }) {
    this.pDealHeaderId = changes['pDealHeaderId'].currentValue;
  }

  ngOnInit() {
    let rmanProductsLabels: any = new RmanProductsLabels();
    this.globalCols = [
      { field: 'pobId', header: 'POB ID', innerfields: '0', showField: true, display: "table-cell", type: 'text', drag: false },
      { field: 'dealLineNumber', header: 'Line#', innerfields: '0', showField: true, display: "table-cell", type: 'number', drag: false },
      { field: 'productName', header: 'Product Name', innerfields: '0', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'productDescription', header: 'Product Description', innerfields: '0', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'uomCode', header: 'UOM', innerfields: '0', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'quantity', header: 'Quantity', innerfields: '0', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'dealCurrencyCode', header: 'Currency', innerfields: '0', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'conversionRate', header: 'Exchange Rate', innerfields: '0', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'unitListPrice', header: 'Unit List Price', innerfields: '0', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'unitSellingPrice', header: 'Unit Selling Price', innerfields: '0', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'lineAmount', header: 'Line Amount', innerfields: '0', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'attribute13', header: 'Variable Consideration', innerfields: '0', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'elementType', header: 'Element Type', innerfields: '0', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'bundleFlag', header: 'Bundle Flag', innerfields: '0', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'parentLineId', header: 'Parent Product', innerfields: '0', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'rmanproducts', subfield: 'attribute1', innerfields: '1', header: 'Product Portfolio', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'rmanproducts', subfield: 'attribute2', innerfields: '1', header: 'Product Family', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'rmanproducts', subfield: 'attribute3', innerfields: '1', header: 'Product Line', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'serviceStartDate', header: 'Service Start Date', innerfields: '0', showField: true, display: "table-cell", type: 'date', drag: true },
      { field: 'serviceEndDate', header: 'Service End Date', innerfields: '0', showField: true, display: "table-cell", type: 'date', drag: true },
      { field: 'attribute9', header: 'Unit Cost', innerfields: '0', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'dealLineCost', header: 'Total Cost', innerfields: '0', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'rmanproducts', innerfields: '2', subfield: 'rmanRevenueTemplates', subfield1: 'accRuleRevenue', header: 'Accounting Rule', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'rmanproducts', innerfields: '3', subfield: 'rmanRevenueTemplates', subfield1: 'rmanLookupsV6', subfield2: 'lookupDescription', header: 'Amortization Rule Name', showField: true, display: "table-cell", type: 'text', drag: true }

    ];
    this.columns = [];
    this.getTableColumns("rmanDealDetails", "Contracts Lines");
    this.productColumns = rmanProductsLabels.fieldLabels;
    this.arrangementColumns = this.rmanDealArrangementsLabels.fieldLabels;
    this.buildForm();
    this.buildForm1();
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
              this.startIndex = this.globalCols.findIndex(col => (col.innerfields == '0' && col.field == item) || (col.innerfields == '1' && col.subfield == item) || (col.innerfields == '2' && col.subfield1 == item) || (col.innerfields == '3' && col.subfield2 == item));
              this.onDrop(index);
            }
          });
        }
        this.globalCols.forEach(col => {
          if ((col.innerfields == '0' && colsList.indexOf(col.field) !== -1) || (col.innerfields == '1' && colsList.indexOf(col.subfield) !== -1) || (col.innerfields == '2' && colsList.indexOf(col.subfield1) !== -1) || (col.innerfields == '3' && colsList.indexOf(col.subfield2) !== -1)) {
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
      if (col.showField && col.innerfields == 0) {
        selectedCols += col.field;
        if (index < colLength) {
          selectedCols += ",";
        }
      } else if (col.showField && col.innerfields == 1) {
        selectedCols += col.subfield;
        if (index < colLength) {
          selectedCols += ",";
        }
      } else if (col.showField && col.innerfields == 2) {
        selectedCols += col.subfield1;
        if (index < colLength) {
          selectedCols += ",";
        }
      } else if (col.showField && col.innerfields == 3) {
        selectedCols += col.subfield2;
        if (index < colLength) {
          selectedCols += ",";
        }
      }
    });
    this.loading = true;
    this.commonSharedService.saveOrUpdateTableColumns("rmanDealDetails", "Contracts Lines", selectedCols, this.userId).then((response) => {
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

  parentCall(data) {
    this.masterData = data;
    if (data != '') {
      this.pDealHeaderId = data.dealHeaderId;
      this.getAllRmanDealDetails();
    } else {
      this.pDealHeaderId = null;
      this.rmanDealDetailsList = [];

    }
  }

  exportExcel() {
    this.exportCols = [];

    for (let index = 0; index < this.columns.length; index++) {
      if (this.columns[index].showField) {
        if (this.columns[index].innerfields == 0) {
          this.exportCols.push(this.columns[index].field);
        } else if (this.columns[index].innerfields == 1) {
          this.exportCols.push(this.columns[index].subfield);
        } else if (this.columns[index].innerfields == 2) {
          this.exportCols.push(this.columns[index].subfield1);
        } else if (this.columns[index].innerfields == 3) {
          this.exportCols.push(this.columns[index].subfield2);
        }
      }
    }
    let serviceUrl = this.rmanDealDetailsService.getServiceUrl(this.paginationOptions, { 'dealHeaderId': this.pDealHeaderId, 'dealArrangementId': this.arrIdK }, 1, this.exportCols);
    window.location.href = serviceUrl;
  }

  buildForm() {
    this.dealDetailsForm = this.formBuilder.group({
      'dealLineNumber': ['', [Validators.required]],
      'productName': ['', [Validators.required]],
      'quantity': ['', [Validators.required, Validators.pattern(/^[1-9][0-9]*$/)]],
      'unitListPrice': ['', [Validators.required, Validators.pattern(/^-?\d*\.?\d*$/)]],
      'unitSellingPrice': ['', [Validators.required, Validators.pattern(/^-?\d*\.?\d*$/)]],
      'attribute9': ['', [Validators.required, Validators.pattern(/^-?\d*\.?\d*$/)]],
      'uomCode': ['', [Validators.required]],
      'bundleFlag': ['', [Validators.required]],
    });


    this.dealDetailsForm.valueChanges
      .subscribe(data => this.onValueChanged(data));

    this.onValueChanged();
  }

  onValueChanged(data?: any) {
    if (!this.dealDetailsForm) { return; }
    const form = this.dealDetailsForm;

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



  buildForm1() {
    this.contractLinesSplitForm = this.formBuilder.group({
      'splitArrgName': ['', [Validators.required]],
      'splitArrgNumber': ['', [Validators.required]]

    });

    this.contractLinesSplitForm.valueChanges
      .subscribe(data => this.onValueChangedSplit(data));

    this.onValueChangedSplit();
  }

  onValueChangedSplit(data?: any) {
    if (!this.contractLinesSplitForm) { return; }
    const form = this.contractLinesSplitForm;

    for (const field in this.formErrorsSplit) {
      // clear previous error message (if any)
      this.formErrorsSplit[field] = '';
      const control = form.get(field);
      if (control && control.dirty && !control.valid) {
        const messages = this.validationSplitMessages[field];
        for (const key in control.errors) {
          this.formErrorsSplit[field] += messages[key] + ' ';
        }
      }
    }


  }

  formErrors = {
    'dealLineNumber': '', 'productName': '', 'quantity': '', 'unitListPrice': '', 'unitSellingPrice': '', 'attribute9': '', 'uomCode': '', 'bundleFlag': ''
  };

  formErrorsSplit = {
    'splitArrgName': '', 'splitArrgNumber': ''
  };

  validationMessages = {
    'dealLineNumber': {
      'required': "Deal Line Number is required"
    },

    'productName': {
      'required': "Product Name is required"
    },
    'quantity': {
      'required': "Quantity is required",
      'pattern': 'Quantity should be greater than 1.'
    },
    'unitListPrice': {
      'required': "Unit List Price is required",
      'pattern': 'Only numbers allowed'
    },
    'unitSellingPrice': {
      'required': "Unit Selling Price is required",
      'pattern': 'Only numbers allowed'
    },
    'attribute9': {
      'required': "Unit cost is required",
      'pattern': 'Only numbers allowed'
    },
    'uomCode': {
      'required': "UOM Code is required"
    },

    'bundleFlag': {
      'required': "Bundled Flag is required"
    },
  }

  validationSplitMessages = {
    'splitArrgName': {
      'required': "Arrangement Name is required"
    },
    'splitArrgNumber': {
      'required': "Arrangement Number is required"
    }
  }


  transformRmanCustomers(rmanCustomers: any) {
    if (rmanCustomers)
      return rmanCustomers.customerName;
  }
  transformRmanCustomers1(rmanCustomers1: any) {
    if (rmanCustomers1)
      return rmanCustomers1.customerName;
  }

  transformRmanProducts(rmanProducts: any) {
    if (rmanProducts)
      return rmanProducts.productName;
  }

  productSearchDialog(productstable: Table) {

    this.displayItemSearchDialog = true;
    this.selectedProduct = {};
    this.rmanProducts.productName = '';
    this.rmanProducts.productDescription = '';
    //this.getAllRmanProducts();
    productstable.reset();
  }


  populate() {
    if (this.selectedProduct && Object.keys(this.selectedProduct).length) {
      this.rmanDealDetails.productName = this.selectedProduct.productName;
      this.rmanDealDetails.productOrgId = this.selectedProduct.productOrgId;
    }
    this.displayItemSearchDialog = false;
    //  this.getAllRmanProducts();
  }

  resetProducts() {
    this.paginationOptions = {};
    this.rmanProducts = new RmanProductsImpl();
    this.rmanProductsSearch = new RmanProductsImpl();
    this.getAllRmanProducts();

  }

  searchProduct() {
    this.paginationOptions = {};
    this.rmanProducts = this.rmanProductsSearch;
    this.getAllRmanProducts();
  }




  onRowItemSelect(event: any) {
  }


  searchArrangements() {
    this.rmanDealArrangements = this.rmanDealArrangementsSearch;
    this.getAllRmanDealArrangements();
  }

  resetArrangements() {
    this.paginationOptions = {};
    this.rmanDealArrangements = new RmanDealArrangementsImpl();
    this.rmanDealArrangementsSearch.dealArrangementName = '';
    this.rmanDealArrangementsSearch.dealArrangementNumber = '';
    this.getAllRmanDealArrangements();
  }

  resetDealDetails(dt: Table) {

    this.paginationOptions = {};
    this.rmanDealDetails = new RmanDealDetailsImpl();
    this.selectedDeals = [];
    dt.reset();
  }


  getAllRmanDealDetails() {
    this.loading = true;

    if (this.pDealHeaderId) {

      this.rmanDealDetailsService.getAllRmanDealDetails(this.paginationOptions, { 'dealArrangementId': this.arrIdK, 'dealHeaderId': this.pDealHeaderId }, this.exportCols).then((rmanDealDetailsList: any) => {
        this.loading = false;

        this.datasource = rmanDealDetailsList.content;
        this.rmanDealDetailsList = rmanDealDetailsList.content;
        this.loading = false;
        this.totalElements = rmanDealDetailsList.totalElements;
        this.pageSize = rmanDealDetailsList.size;
        this.displaySearchDialog = false;
        this.disableExport = false;
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while getting data');
        this.loading = false;
      });
    }

  }


  getRmanDealDetails(event: any) {

    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };

    if (this.pDealHeaderId) {
      this.loading = true;
      this.rmanDealDetailsService.getAllRmanDealDetails(this.paginationOptions, { 'dealHeaderId': this.pDealHeaderId, 'dealArrangementId': this.arrIdK }, this.exportCols).then((rmanDealDetailsList: any) => {
        this.datasource = rmanDealDetailsList.content;
        this.rmanDealDetailsList = rmanDealDetailsList.content;
        this.loading = false;
        this.disableExport = false;
        this.totalElements = rmanDealDetailsList.totalElements;
        this.pageSize = rmanDealDetailsList.size;
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while getting data');
        this.loading = false;
      });

    }


  }

  cancel() {
    this.displayDialog = false;
    this.rmanDealDetails = new RmanDealDetailsImpl();
  }

  save() {
    this.rmanDealDetails.repUnitListPrice = this.rmanDealDetails.unitListPrice;
    this.rmanDealDetails.repUnitSellingPrice = this.rmanDealDetails.unitSellingPrice;
    if (this.newRmanDealDetails) {
      this.loading = true;
      this.rmanDealDetailsService.saveRmanDealDetails(this.rmanDealDetails).then((response: any) => {
        this.getAllRmanDealDetails();
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while saving the data');
        this.loading = false;
      });
    }
    else {
      this.loading = true;
      delete this.rmanDealDetails.rmanproducts
      this.rmanDealDetailsService.updateRmanDealDetails(this.rmanDealDetails).then((response: any) => {

        this.getAllRmanDealDetails();
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while updating the data');
        this.loading = false;
      });
    }
    this.rmanDealDetails = new RmanDealDetailsImpl();
    this.displayDialog = false;
  }


  delete(rmanDealDetails: any) {
    this.rmanDealDetails = rmanDealDetails;
    this.displayDialog = false;

    if (window.confirm('Are you sure you want to delete this record?')) {
      this.rmanDealDetailsList.splice(this.findSelectedRmanDealDetailsIndex(), 1);
      this.loading = true;
      this.rmanDealDetailsService.deleteRmanDealDetails(this.rmanDealDetails).then((response: any) => {

        this.rmanDealDetails = new RmanDealDetailsImpl();
        this.getAllRmanDealDetails();
      });
    }

  }

  editRow(rmanDealDetails: any) {
    this.newRmanDealDetails = false;
    this.rmanDealDetails = this.cloneRmanDealDetails(rmanDealDetails);
    this.displayDialog = true;
    this.prepareRmanCustomersObject();
    this.prepareRmanCustomers1Object();
    this.prepareRmanProductsObject();

  }


  findSelectedRmanDealDetailsIndex(): number {
    return this.rmanDealDetailsList.indexOf(this.selectedRmanDealDetails);
  }

  onRowSelect(event: any) {
    this.rmanDealDetailsList.forEach((item: any) => {
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
    this.rmanDealDetailsList.forEach((item: any) => {
      if (Math.trunc(item.dealLineNumber) == Math.trunc(event.data.dealLineNumber) || (item.parentLineId == event.data.dealLineNumber) || (item.dealLineNumber == event.data.parentLineId) || (item.parentLineId != null && item.parentLineId == event.data.parentLineId)) {
        this.selectedDeals.splice(this.selectedDeals.indexOf(item), 1);
      }
    });
  }


  cloneRmanDealDetails(c: RmanDealDetails): RmanDealDetails {
    let rmanDealDetails: any = new RmanDealDetailsImpl();
    for (let prop in c) {
      rmanDealDetails[prop] = c[prop];
    }
    return rmanDealDetails;
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
      this.rmanDealDetailsSearch = new RmanDealDetailsImpl();
    }
    this.displaySearchDialog = true;

  }

  search() {

    this.isSerached = 1;
    this.rmanDealDetails = this.rmanDealDetailsSearch;
    this.paginationOptions = {};
    this.getAllRmanDealDetails();
  }

  cancelProductSearchDialog() {
    this.displayItemSearchDialog = false;
    this.rmanProductsList = [];
    this.rmanDealDetailsSearch = new RmanDealDetailsImpl();
  }


  prepareRmanCustomersObject() {
    let rmanCustomersTempObj: any = [];
    this.rmanCustomersList.forEach((rmanCustomers) => {
      rmanCustomersTempObj.push({ label: rmanCustomers.customerName, value: rmanCustomers.customerName });
    });

    this.rmanCustomers = rmanCustomersTempObj;

  }

  prepareRmanCustomers1Object() {
    let rmanCustomers1TempObj: any = [];
    this.rmanCustomers1List.forEach((rmanCustomers1) => {
      rmanCustomers1TempObj.push({ label: rmanCustomers1.customerName, value: rmanCustomers1.customerName });
    });

    this.rmanCustomers1 = rmanCustomers1TempObj;

  }



  prepareRmanDealArrangementsObject() {
    let rmanDealArrangementsTemppObj: any = [];
    rmanDealArrangementsTemppObj.push({ label: 'Select Target Deal Arrangement', value: '' });
    this.arrgList.forEach((dealArrangement) => {
      rmanDealArrangementsTemppObj.push({ label: dealArrangement.dealArrangementName, value: dealArrangement.dealArrangementId });
    });
    this.rmanDealArrangements1 = rmanDealArrangementsTemppObj;
  }

  prepareRmanProductsObject() {
    let rmanProductsTempObj: any = [];
    this.rmanProductsList.forEach((rmanProducts) => {
      rmanProductsTempObj.push({ label: rmanProducts.productName, value: rmanProducts.productName });
    });

    this.rmanProducts = rmanProductsTempObj;

  }

  prepareRmanLookupsV1Object() {
    let rmanLookupsV1TempObj: any = [{ label: appSettings.dropDownOptions.selectBundleFlag, value: null }];
    this.rmanLookupsV1List.forEach((rmanLookupsV1) => {
      rmanLookupsV1TempObj.push({ label: rmanLookupsV1.lookupDescription, value: rmanLookupsV1.lookupCode });
    });

    this.rmanLookupsV1 = rmanLookupsV1TempObj;

  }


  onBeforeToggle(evt: any) {

    this.collapsed = evt.collapsed;
  }

  itemSearch() {
    this.isSerached = 1;
    this.rmanProducts = this.rmanProductsSearch;
    this.getAllRmanProducts();
  }

  getAllRmanDealArrangements() {
    this.loading = true;
    this.rmanDealArrangementsService.getAllRmanDealArrangements(this.paginationOptions, this.rmanDealArrangements).then((rmanDealArrangementsList: any) => {
      this.datasource = rmanDealArrangementsList.content;
      this.rmanDealArrangementsList = this.datasource.filter((item: any) => {
        return (item.dealArrangementId != this.arrIdK);
      })
      this.totalArrgElements = rmanDealArrangementsList.totalElements;
      this.pageSize = rmanDealArrangementsList.size;
      this.displaySearchDialog = false;
      this.loading = false;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }

  getRmanDealArrangements(event: any) {
    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loading = true;
    this.rmanDealArrangementsService.getAllRmanDealArrangements(this.paginationOptions, this.rmanDealArrangements).then((rmanDealArrangementsList: any) => {

      this.datasource = rmanDealArrangementsList.content;
      this.rmanDealArrangementsList = rmanDealArrangementsList.content.filter((item: any) => {
        return item.dealArrangementId != this.arrIdK;
      })
      this.totalArrgElements = rmanDealArrangementsList.totalElements;
      this.pageSize = rmanDealArrangementsList.size;
      this.loading = false;

    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }

  getRmanProducts(event: any) {

    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.itemPageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loading = true;
    this.rmanProductsService.getAllRmanProducts(this.paginationOptions, this.rmanProducts, false).then((rmanProductsList: any) => {
      this.loading = false;
      this.datasource = rmanProductsList.content;
      this.rmanProductsList = rmanProductsList.content;
      this.itemTotalElements = rmanProductsList.totalElements;
      this.itemPageSize = rmanProductsList.size;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });

  }

  getAllRmanProducts() {
    this.loading = true;
    this.rmanProductsService.getAllRmanProducts(this.paginationOptions, this.rmanProducts, false).then((rmanProductsList: any) => {
      this.loading = false;
      this.productdatasource = rmanProductsList.content;
      this.rmanProductsList = rmanProductsList.content;
      this.itemTotalElements = rmanProductsList.totalElements;
      this.itemPageSize = rmanProductsList.size;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }
  processSplitDeals() {

    if (this.selectedDeals != undefined) {
      if (this.selectedDeals.length > 0) {
        this.arrgName = '';
        this.arrgNumber = '';
        this.displaySplitDialog = true;
      } else {
        this.notificationService.showError('Select at least one deal line to Split as new arrangement..!');
      }

    } else {
      this.notificationService.showError('Select at least one deal line to Split as new arrangement..!');
    }
    this.buildForm1();
  }
  processMergeDeals() {

    if (this.selectedDeals != undefined) {
      if (this.selectedDeals.length > 0) {
        this.displayMergeDialog = true;
      } else {
        this.notificationService.showError('Select at least one deal line to merge with other arrangement..!');
      }

    } else {
      this.notificationService.showError('Select at least one deal line to merge with other arrangement..!');
    }
    this.selectedArrangement = {};
    this.rmanDealArrangementsSearch.dealArrangementName = '';
    this.rmanDealArrangementsSearch.dealArrangementNumber = '';
    this.getAllRmanDealArrangements();

  }

  onRowArrgSelect(event: any) {
    this.selectedArrangement = event.data;
    this.targetDealArrangementId = this.selectedArrangement.dealArrangementId;
  }

  getAllRmanSplitDeals(arrgNumber: any, arrgName: any) {

    if (arrgNumber && arrgName) {

      this.rmanDealDetailsService.getValidArrangement(this.arrgNumber, this.arrgName).then((arrgResult: any) => {


        if (arrgResult == 'Y') {
          this.notificationService.showError('Arrangement already exist');
        }
        else if (arrgResult == 'N') {

          this.dealLinesList = [];

          for (let i = 0; i < this.selectedDeals.length; i++) {
            this.dealLinesList.push(this.selectedDeals[i].dealLineId);
          }

          this.loading = true;
          this.rmanDealDetailsService.splitDeals(this.arrIdK, this.dealLinesList, arrgNumber, arrgName).then((response: any) => {
            this.loading = false;

            if (response) {
              this.selectedDeals = [];
              this.getAllRmanDealDetails();
              this.notificationService.showSuccess('Selected Deal Lines  are created as a separate Arrangement');
            } else {
              this.getAllRmanDealDetails();
              this.notificationService.showError('Selected Deal Lines  are failed to create as a separate Arrangement');
            }


          }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
          });
          this.displaySplitDialog = false;
        }


      });
    }
    else {
      this.notificationService.showError('Arrangement Number and Deal Arrangemnt Name Must be enter..!');
    }
  }

  getAllRmanMergeDeals(targetDealArrangementId: any) {
    if (targetDealArrangementId) {
      this.dealLinesList = [];

      for (let i = 0; i < this.selectedDeals.length; i++) {
        this.dealLinesList.push(this.selectedDeals[i].dealLineId);
      }

      this.loading = true;
      this.rmanDealDetailsService.mergeDeals(this.arrIdK, this.dealLinesList, targetDealArrangementId).then((response: any) => {
        this.loading = false;

        if (response) {
          this.getAllRmanDealDetails();
          this.notificationService.showSuccess('Selected Lines are Merge Successfully with Selected ArrangementId');
        } else {
          this.getAllRmanDealDetails();
          this.notificationService.showError('Selected Deal Lines  are failed to Merge')
        }

      }).catch((err: any) => {
        this.notificationService.showError('Error occured while getting data');
        this.loading = false;
      });
    } else {
      this.notificationService.showError('Select Target Deal Arrangement..!');
    }
    this.displayMergeDialog = false;
  }


}


export class RmanDealDetailsImpl {
  constructor(public shipToSiteNum?: any, public financeContactId?: any, public elementType?: any, public productOrgId?: any, public directCvAmount?: any, public parentLineNumber?: any, public billToCountry?: any, public lineId?: any, public changeReason?: any, public unitSellingPrice?: any, public opportunityName?: any, public endCustomerNum?: any, public durationUom?: any, public dealName?: any, public attribute3?: any, public attribute2?: any, public attribute1?: any, public salesOpsId?: any, public fmvAmount?: any, public dealHeaderId?: any, public attribute9?: any, public attribute8?: any, public childSellPrice?: any, public attribute7?: any, public attribute6?: any, public attribute5?: any, public attribute4?: any, public directCv?: any, public uomCode?: any, public salesOpsName?: any, public agreementCode?: any, public fmvRuleDefId?: any, public attribute10?: any, public cvPercent?: any, public endCustomerName?: any, public serviceDurationUom?: any, public fvPercent?: any, public attribute14?: any, public attribute13?: any, public repUnitSellingPrice?: any, public attribute12?: any, public customerType?: any, public partnerName?: any, public attribute11?: any, public contAppQty?: any, public dealType?: any, public allocationAmount?: any, public salesChannel?: any, public contingencyCode?: any, public opportunityNum?: any, public dealCurrencyCode?: any, public conversionType?: any, public dealNumber?: any, public dealLineNumber?: any, public dealLineCost?: any, public parentLineId?: any, public expectedDuration?: any, public serviceEndDate?: any, public lastUpdatedDate?: any, public accountingScope?: any, public shipToCountry?: any, public attribute15?: any, public salesrepName?: any, public eitfSop?: any, public contTransHeaderId?: any, public bundleFlag?: any, public quantity?: any, public createdDate?: any, public priceList?: any, public analystId?: any, public billToCustomerNum?: any, public approverId?: any, public billToSiteNum?: any, public unitListPrice?: any, public cvInOutAmount?: any, public expectedStartDate?: any, public allocationFlag?: any, public createdBy?: any, public lastUpdatedBy?: any, public legalEntityId?: any, public productName?: any, public forecastCode?: any, public dealStatus?: any, public trxCurrencyCode?: any, public repUnitListPrice?: any, public conversionDate?: any, public dealLineId?: any, public salesTerritory?: any, public financeContact?: any, public paymentTerms?: any, public subElementType?: any, public bundlePercent?: any, public serviceStartDate?: any, public billToCustomerName?: any, public repCurrCode?: any, public trxAllocUnitAmt?: any, public agreementName?: any, public expectedSplit?: any, public serviceDuration?: any, public conversionRate?: any, public argBasisLineNumber?: any, public bespPerUnit?: any, public dealArrangementId?: any, public agreementNumber?: any, public accounintRuleName?: any, public childListPrice?: any, public expectedEndDate?: any, public dealDate?: any, public contractStartDate?: any, public contractEndDate?: any) { }
}

interface ILabels {
  [index: string]: string;
}
