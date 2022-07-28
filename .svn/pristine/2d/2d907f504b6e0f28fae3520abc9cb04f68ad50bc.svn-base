import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ConfirmationService } from 'primeng/api';
import { Table } from 'primeng/table';
import { RmanLegalEntitiesService } from '../rmanLegalEntities/rmanLegalEntitiesservice';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { RmanProductsImpl } from '../rmanProducts/rmanProducts.component';
import { RmanProductsLabels } from '../rmanProducts/rmanProductsLabels';
import { RmanProductsService } from '../rmanProducts/rmanProductsservice';
import { NotificationService } from '../shared/notifications.service';
import { RmanPobMapping } from './rmanPobMapping';
import { RmanPobMappingLabels } from './rmanPobMappingLabels';
import { RmanPobMappingService } from './rmanPobMappingservice';
import { CommonSharedService } from '../shared/common.service';
declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
  templateUrl: './rmanPobMapping.component.html',
  selector: 'rmanPobMapping-data',
  providers: [RmanPobMappingService, RmanProductsService, RmanLegalEntitiesService, ConfirmationService]
})

export class RmanPobMappingComponent implements OnInit {

  displayDialog: boolean;

  displaySearchDialog: boolean;

  displayItemSearchDialog: boolean;

  rmanProductsSearch: any = new RmanProductsImpl();
  rmanProducts: RmanProductsImpl = new RmanProductsImpl();
  selectedProduct: RmanProductsImpl = new RmanProductsImpl();
  rmanProductsLabels: RmanProductsLabels = new RmanProductsLabels();


  rmanPobMapping: any = new RmanPobMappingImpl();

  rmanPobMappingSearch: any = new RmanPobMappingImpl();

  isSerached: number = 0;

  searched: number = 0;

  selectedRmanPobMapping: RmanPobMapping;

  newRmanPobMapping: boolean;

  rmanPobMappingList: any[];

  cols: any[];
  productColumns: ILabels2;

  popupFlag: any;
  columnOptions: any[];

  paginationOptions: any;

  pages: {};

  datasource: any[];
  pageSize: number;
  totalElements: number;
  itemPageSize: number;
  itemTotalElements: number;
  productdatasource: any[];

  rmanProductsList: any[] = [];


  rmanProductsListSample: any[] = [];
  rmanProductsSample: any[];
  rmanProducts1List: any[] = [];
  rmanProducts1: any[];
  rmanLookupsVList: any[] = [];
  rmanLookupsV: any[];
  rmanLookupsV1List: any[] = [];
  rmanLookupsV1: any[];
  rmanLegalEntitiesList: any[] = [];
  rmanLegalEntities: any[];
  pobMappingForm: FormGroup;

  collapsed: boolean = true;

  splitFlag: boolean;
  noData = appSettings.noData;
  loading: boolean;
  selectedProductName: string = '';
  isSelectAllChecked = true;
  globalCols: any[];
  clonedCols: any[];
  userId: number;
  showPaginator: boolean = true;
  startIndex: number;
  showAddColumns = true;
  columns: any[];
  exportCols: string[] =[];


  constructor(private rmanPobMappingService: RmanPobMappingService, private rmanProductsService: RmanProductsService, private rmanLookupsVService: RmanLookupsVService, private formBuilder: FormBuilder,
    private rmanLegalEntitiesService: RmanLegalEntitiesService, private confirmationService: ConfirmationService,
    private notificationService: NotificationService, private commonSharedService: CommonSharedService) {

    // generate list code
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    this.loading = true;
    this.rmanProductsService.getAllRmanProducts(this.paginationOptions, {}, false).then((rmanProductsList: any) => {
      this.rmanProductsList = rmanProductsList.content;
      this.prepareRmanProductsObject();

      this.rmanLegalEntitiesService.getAllRmanLegalEntities(this.paginationOptions, {}, 'Y').then((rmanLegalEntitiesList: any) => {
        this.rmanLegalEntitiesList = rmanLegalEntitiesList.content;
        this.prepareRmanLegalEntitiesObject();


        this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'POB_MAPPING_TYPE' }).then((rmanLookupsVList: any) => {
          this.rmanLookupsVList = rmanLookupsVList.content;
          this.prepareRmanLookupsVObject();


          this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'POB_SPLIT_BASIS' }).then((rmanLookupsV1List: any) => {
            this.loading = false;
            this.rmanLookupsV1List = rmanLookupsV1List.content;
            this.prepareRmanLookupsV1Object();
          }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting "Split Type" data');
            this.loading = false;
          });
        }).catch((err: any) => {
          this.notificationService.showError('Error occured while getting "Mapping Type" data');
          this.loading = false;
        });
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while getting "Legal Entity" data');
        this.loading = false;
      });
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });

  }

  ngOnInit() {

    this.getAllRmanPobMapping();
    this.globalCols = [
      { field: 'skuType', header: 'Mapping Type', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'standaloneSubSku', header: 'Product Name', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'pobGrouping', header: 'POB Grouping', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'rmanLookupsV', header: 'Split Basis', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'split', header: 'Split', showField: true, drag: true, display: "table-cell", type: 'number' },
      { field: 'parentSku', header: 'Parent Product', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'startDate', header: 'Start Date', showField: true, drag: true, display: "table-cell", type: 'date' },
      { field: 'endDate', header: 'End Date', showField: true, drag: true, display: "table-cell", type: 'date' },
      { field: 'status', header: 'Status', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'legalEntityName', header: 'Legal Entity', showField: true, drag: true, display: "table-cell", type: 'text' }
    ];

    this.columns = [];
    this.getTableColumns("rmanPobMapping", "POB Mappings");

    let rmanProductsLabels = new RmanProductsLabels();
    this.productColumns = rmanProductsLabels.fieldLabels;
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
    this.commonSharedService.saveOrUpdateTableColumns("rmanPobMapping", "POB Mappings", selectedCols, this.userId).then((response) => {
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
    this.rmanPobMapping = new RmanPobMappingImpl();
    dt.reset();
  }

  checkValidators() {

    if (this.pobMappingForm.controls['skuType'].value == 'POB Group') {
      this.pobMappingForm.get('pobGrouping').setValidators([Validators.required, Validators.minLength(4), Validators.maxLength(25)])
      this.pobMappingForm.get('parentSku').clearValidators();

      this.pobMappingForm.get('splitBasis').clearValidators();
      this.pobMappingForm.get('split').clearValidators();
      this.pobMappingForm.get('splitBasis').disable();
      this.pobMappingForm.get('parentSku').disable();
      this.pobMappingForm.get('split').disable();
      this.pobMappingForm.updateValueAndValidity();
    } else {
      this.pobMappingForm.get('pobGrouping').clearValidators();
      this.pobMappingForm.get('pobGrouping').disable();
      this.pobMappingForm.get('splitBasis').enable();
      this.pobMappingForm.get('split').disable();
      this.pobMappingForm.get('splitBasis').setValidators([Validators.required]);
      this.pobMappingForm.get('split').setValidators([Validators.required]);
      this.pobMappingForm.get('parentSku').setValidators([Validators.required]);
      this.pobMappingForm.get('parentSku').enable();
      this.pobMappingForm.updateValueAndValidity();

    }

    this.checkSplit();

  }

  OnSelectSkuType(event: any) {

    if (this.pobMappingForm.controls['skuType'].value == 'POB Group') {
      this.pobMappingForm.get('pobGrouping').setValidators([Validators.required, Validators.minLength(4), Validators.maxLength(25)]);
      this.pobMappingForm.get('pobGrouping').enable();
      this.pobMappingForm.get('standaloneSubSku').setValidators([Validators.required]);
      this.pobMappingForm.get('standaloneSubSku').enable();
      this.pobMappingForm.get('parentSku').clearValidators();
      this.pobMappingForm.patchValue({
        parentSku: '',
        splitBasis: '',
        split: ''
      });

      this.pobMappingForm.get('splitBasis').clearValidators();
      this.pobMappingForm.get('split').clearValidators();
      this.pobMappingForm.get('splitBasis').disable();
      this.pobMappingForm.get('parentSku').disable();
      this.pobMappingForm.get('split').disable();
      this.pobMappingForm.updateValueAndValidity();
    } else if (this.pobMappingForm.controls['skuType'].value == 'Order Line POB Group') {
      this.pobMappingForm.get('pobGrouping').setValidators([Validators.required, Validators.minLength(4), Validators.maxLength(25)]);
      this.pobMappingForm.get('pobGrouping').enable();
      this.pobMappingForm.get('standaloneSubSku').clearValidators();
      this.pobMappingForm.get('parentSku').clearValidators();
      this.pobMappingForm.get('splitBasis').clearValidators();
      this.pobMappingForm.patchValue({
        standaloneSubSku: '',
        parentSku: '',
        splitBasis: '',
        split: ''
      });
      this.pobMappingForm.updateValueAndValidity();
    } else {
      this.pobMappingForm.get('pobGrouping').clearValidators();
      this.pobMappingForm.patchValue({
        pobGrouping: '',
        split: ''
      })
      this.pobMappingForm.get('pobGrouping').disable();
      this.pobMappingForm.get('splitBasis').enable();
      this.pobMappingForm.get('split').disable();
      this.pobMappingForm.get('splitBasis').setValidators([Validators.required]);
      this.pobMappingForm.get('split').setValidators([Validators.required, Validators.maxLength(100), Validators.pattern(/^[0-9]+(.[0-9]{0,2})?$/)]);
      this.pobMappingForm.get('parentSku').setValidators([Validators.required]);
      this.pobMappingForm.get('parentSku').enable();
      this.pobMappingForm.get('standaloneSubSku').setValidators([Validators.required]);
      this.pobMappingForm.updateValueAndValidity();

    }



  }

  checkSplit() {

    if (this.pobMappingForm.controls['splitBasis'].value == 'F') {
      this.pobMappingForm.get('split').disable();
    } else {
      this.pobMappingForm.get('split').enable();
    }
  }

  OnSelectSplitBasis(event: any) {

    if (this.pobMappingForm.controls['splitBasis'].value == 'P') {
      this.pobMappingForm.get('split').setValidators([Validators.required,
      Validators.maxLength(100), Validators.pattern(/^[0-9]+(.[0-9]{0,2})?$/)]);
      this.pobMappingForm.get('split').updateValueAndValidity();
    }

    if (this.pobMappingForm.controls['splitBasis'].value == 'F') {
      this.pobMappingForm.patchValue({
        split: ''
      })
      this.pobMappingForm.get('split').disable();
    } else {
      this.pobMappingForm.get('split').enable();
    }

    this.checkSplit();
  }

  buildForm() {


    let mappingfields: any = {
      'skuType': [this.rmanPobMapping.skuType, [Validators.required]],
      'status': [this.rmanPobMapping.status, [Validators.required]],
      'startDate': [this.rmanPobMapping.startDate, [Validators.required]],
      'splitBasis': [this.rmanPobMapping.splitBasis, [Validators.required]],
      'legalEntityId': [this.rmanPobMapping.legalEntityId, [Validators.required]],
      'standaloneSubSku': [this.rmanPobMapping.standaloneSubSku, [Validators.required]],
      'parentSku': ['', []],
      'pobGrouping': ['', [Validators.minLength(4), Validators.maxLength(25)]],
      'split': [{ value: null, disabled: false }],
    };

    this.pobMappingForm = this.formBuilder.group(mappingfields);
    this.pobMappingForm.valueChanges
      .subscribe(data => this.onValueChanged(data));

    this.onValueChanged();
  }

  onValueChanged(data?: any) {
    if (!this.pobMappingForm) { return; }
    const form = this.pobMappingForm;

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
    'skuType': '', 'status': '', 'startDate': '', 'splitBasis': '', 'legalEntityId': '', 'standaloneSubSku': '', 'parentSku': '', 'pobGrouping': '', 'split': ''
  };

  validationMessages = {
    'skuType': {
      'required': "Product Type is required"
    }, 'status': {
      'required': "Status is required"
    },
    'startDate': {
      'required': "Start Date is required"
    },
    'splitBasis': {
      'required': "Split Type is required",
    },
    'legalEntityId': {
      'required': "Legal Entity is required"
    },
    'standaloneSubSku': {
      'required': "Product Name is required"
    },
    'parentSku': {
      'required': "Parent Product is required"
    },
    'pobGrouping': {
      'required': "POB Grouping is required (minimum length is 4 and maximum length is 25 characters)",
      'minlength': 'POB Grouping must be at least 4 characters long.',
      'maxlength': 'POB Grouping cannot be more than 25 characters long.',
    },
    'split': {
      'required': 'Split is required (maximum length should not be more than 100 and only Number values are allowed [0-9] )',
      'maxlength': 'Maximum length should not be more than 100',
      'pattern': 'Only number values are allowed [0-9]'
    }
  }

  transformRmanProducts(rmanProducts: any) {
    if (rmanProducts)
      return rmanProducts.productDescription;
  }
  transformRmanProducts1(rmanProducts1: any) {
    if (rmanProducts1)
      return rmanProducts1.productDescription;
  }
  transformRmanLegalEntities(rmanLegalEntities: any) {
    if (rmanLegalEntities)
      return rmanLegalEntities.name;
  }
  transformRmanLookupsV(rmanLookupsV: any) {
    if (rmanLookupsV)
      return rmanLookupsV.lookupDescription;
  }

  transformRmanLookupsV1(rmanLookupsV1: any) {
    if (rmanLookupsV1)
      return rmanLookupsV1.lookupDescription;
  }

  cancelProductSearch() {
    this.displayItemSearchDialog = false;
    this.selectedProduct = {};
  }
  cancelAddEdit() {
    this.displayDialog = false;
    this.rmanPobMapping = new RmanPobMappingImpl();
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
      $('.ui-datatable-scrollable-body').scrollTop(0);

    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }

  onRowItemSelect(event: any) {
    this.rmanProducts.productName = this.selectedProduct.productName
    this.rmanProducts.productDescription = this.selectedProduct.productDescription;
  }




  getAllRmanPobMapping() {
    this.loading = true;
    this.rmanPobMappingService.getAllRmanPobMapping(this.paginationOptions, this.rmanPobMapping, this.exportCols).then((rmanPobMappingList: any) => {
      this.loading = false;
      this.datasource = rmanPobMappingList.content;
      this.rmanPobMappingList = rmanPobMappingList.content;
      this.totalElements = rmanPobMappingList.totalElements;
      this.pageSize = rmanPobMappingList.size;
      this.displaySearchDialog = false;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }


  getRmanPobMapping(event: any) {
    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loading = true;
    this.rmanPobMappingService.getAllRmanPobMapping(this.paginationOptions, this.rmanPobMapping, this.exportCols).then((rmanPobMappingList: any) => {
      this.loading = false;
      this.datasource = rmanPobMappingList.content;
      this.rmanPobMappingList = rmanPobMappingList.content;
      this.totalElements = rmanPobMappingList.totalElements;
      this.pageSize = rmanPobMappingList.size;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });

  }


  showDialogToAdd() {

    this.newRmanPobMapping = true;
    this.rmanPobMapping = new RmanPobMappingImpl();
    this.displayDialog = true;
    this.rmanPobMapping.status = 'Active';

    this.prepareRmanProductsObject();
    this.prepareRmanProducts1Object();
    this.prepareRmanLookupsVObject();
    this.prepareRmanLookupsV1Object();
    this.prepareRmanLegalEntitiesObject();
    this.buildForm();

  }

  productSearchDialog(flag: any, productsdt: Table) {
    this.displayItemSearchDialog = true;
    this.popupFlag = flag;
    this.rmanProducts = new RmanProductsImpl();
    this.rmanProductsSearch = new RmanProductsImpl();
    if (this.popupFlag === 1 && this.selectedProductName) {
      this.rmanProducts.productOrgName = this.selectedProductName;
    }
    this.selectedProduct = {};
    productsdt.reset();
  }

  onSplitChange(event: any) {
    if (event != 'PS') {
      this.splitFlag = true;
      this.rmanPobMapping.split = '';
    } else {
      this.splitFlag = false;
    }
  }

  saveOrUpdate(msg: any){
    this.notificationService.showSuccess(msg);
    this.paginationOptions = {};
    this.getAllRmanPobMapping();
  }

  save() {

    delete this.rmanPobMapping.legalEntityName;

    if (this.newRmanPobMapping) {
      this.loading = true;
      this.rmanPobMappingService.saveRmanPobMapping(this.rmanPobMapping).then((response: any) => {
        this.saveOrUpdate('Saved successfully');
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while saving data');
        this.loading = false;
      });
    }
    else {
      this.loading = true;
      this.rmanPobMappingService.updateRmanPobMapping(this.rmanPobMapping).then((response: any) => {
        this.saveOrUpdate('Updated successfully');
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while updating data');
        this.loading = false;
      });
    }


    this.rmanPobMapping = new RmanPobMappingImpl();

    this.displayDialog = false;

  }

  exportExcel() {
    $.blockUI();
    this.exportCols = [];
    for (let index = 0; index < this.columns.length; index++) {
      if (this.columns[index].showField) {
        this.exportCols.push(this.columns[index].field);
      }
    }
    let serviceUrl = this.rmanPobMappingService.getServiceUrl(this.paginationOptions, this.rmanPobMapping,this.exportCols, 1);
    $.unblockUI();
    window.location.href = serviceUrl;
  }



  delete(rmanPobMapping: any) {
    this.rmanPobMapping = rmanPobMapping;
    this.rmanPobMapping.startDate = new Date(this.rmanPobMapping.startDate);
    this.rmanPobMapping.endDate = new Date(this.rmanPobMapping.endDate);
    this.displayDialog = false;

    this.confirmationService.confirm({
      message: 'Are you sure you want to delete this record?',
      header: 'Confirmation',
      icon: '',
      accept: () => {
        this.rmanPobMappingList.splice(this.findSelectedRmanPobMappingIndex(), 1);
        this.loading = true;
        this.rmanPobMappingService.deleteRmanPobMapping(this.rmanPobMapping).then((response: any) => {

          this.rmanPobMapping = new RmanPobMappingImpl();
          this.getAllRmanPobMapping();
        });
        this.notificationService.showSuccess('Deleted successfully');
      },
      reject: () => {
        this.rmanPobMapping = new RmanPobMappingImpl();
        this.notificationService.showWarning('You have rejected');
      }
    });

  }

  editRow(rmanPobMapping: any) {
    this.newRmanPobMapping = false;

    this.rmanPobMapping = this.cloneRmanPobMapping(rmanPobMapping);

    this.rmanPobMapping.startDate = new Date(this.rmanPobMapping.startDate);
    if (this.rmanPobMapping.endDate) {
      this.rmanPobMapping.endDate = new Date(this.rmanPobMapping.endDate);
    }
    this.displayDialog = true;
    this.prepareRmanProductsObject();
    this.prepareRmanProducts1Object();
    this.prepareRmanLookupsVObject();
    this.prepareRmanLookupsV1Object();
    this.prepareRmanLegalEntitiesObject();
    this.pobMappingForm.patchValue({
      legalEntityId: this.rmanPobMapping.rmanLegalEntities.legalEntityId,
      parentSku: this.rmanPobMapping.parentSku,
      pobGrouping: this.rmanPobMapping.pobGrouping,
      skuType: this.rmanPobMapping.skuType,
      split: this.rmanPobMapping.split,
      splitBasis: this.rmanPobMapping.splitBasis,
      standaloneSubSku: this.rmanPobMapping.standaloneSubSku,
      startDate: this.rmanPobMapping.startDate,
      status: this.rmanPobMapping.status
    })
    this.checkValidators();

  }


  findSelectedRmanPobMappingIndex(): number {
    return this.rmanPobMappingList.indexOf(this.selectedRmanPobMapping);
  }

  onRowSelect(event: any) {

  }

  onRowProductSelect(event: any) {

  }

  cloneRmanPobMapping(c: RmanPobMapping): RmanPobMapping {
    let rmanPobMapping: any = new RmanPobMappingImpl();
    for (let prop in c) {
      rmanPobMapping[prop] = c[prop];
    }

    return rmanPobMapping;
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

    this.rmanPobMappingSearch = new RmanPobMappingImpl();

    if (this.isSerached == 0) {
      this.rmanPobMappingSearch = new RmanPobMappingImpl();
    }
    this.displaySearchDialog = true;

  }

  search() {
    this.displaySearchDialog = false;
    this.isSerached = 1;
    this.paginationOptions = {};
    this.rmanPobMapping = this.rmanPobMappingSearch;
    this.getAllRmanPobMapping();
  }

  searchProduct() {
    this.rmanProducts = this.rmanProductsSearch;
    if (this.popupFlag === 1) {
      this.rmanProducts.productOrgName = this.selectedProductName;
    }
    this.paginationOptions = {};
    this.getAllRmanProducts();
  }



  populate() {
    if (this.popupFlag == 1) {
      this.rmanPobMapping.parentSku = this.selectedProduct.productName;
    } else {
      this.rmanPobMapping.standaloneSubSku = this.selectedProduct.productName;
      this.selectedProductName = this.selectedProduct.productOrgName;
      this.rmanPobMapping.parentSku = '';
    }
    this.displayItemSearchDialog = false;
  }

  resetProducts(productsdt: Table) {
    this.paginationOptions = {};
    this.rmanProducts = new RmanProductsImpl();
    this.rmanProductsSearch = new RmanProductsImpl();
    if (this.popupFlag === 1) {
      this.rmanProducts.productOrgName = this.selectedProductName;
    }
    productsdt.reset();
  }


  prepareRmanProductsObject() {
    let rmanProductsTempObj: any = [];
    this.rmanProductsList.forEach((rmanProductsSample) => {
      rmanProductsTempObj.push({ label: rmanProductsSample.productDescription, value: rmanProductsSample.productName });
    });

    this.rmanProductsSample = rmanProductsTempObj;

  }
  prepareRmanLegalEntitiesObject() {
    let rmanLegalEntitiesTempObj: any = [{ label: appSettings.dropDownOptions.selectLegalEntity, value: null }];
    this.rmanLegalEntitiesList.forEach((rmanLegalEntities) => {
      rmanLegalEntitiesTempObj.push({ label: rmanLegalEntities.name, value: rmanLegalEntities.legalEntityId });
    });
    this.rmanLegalEntities = rmanLegalEntitiesTempObj;
  }
  prepareRmanProducts1Object() {
    let rmanProducts1TempObj: any = [{ label: appSettings.dropDownOptions.SelectStandalone, value: null }];
    this.rmanProducts1List.forEach((rmanProducts1) => {
      rmanProducts1TempObj.push({ label: rmanProducts1.productDescription, value: rmanProducts1.productName });
    });

    this.rmanProducts1 = rmanProducts1TempObj;

  }


  prepareRmanLookupsVObject() {
    let rmanLookupsVTempObj: any = [{ label: appSettings.dropDownOptions.SelectMapping, value: null }];
    this.rmanLookupsVList.forEach((rmanLookupsV) => {
      rmanLookupsVTempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
    });

    this.rmanLookupsV = rmanLookupsVTempObj;

  }

  prepareRmanLookupsV1Object() {
    let rmanLookupsV1TempObj: any = [{ label: appSettings.dropDownOptions.SelectSplit, value: null }];
    this.rmanLookupsV1List.forEach((rmanLookupsV1) => {
      rmanLookupsV1TempObj.push({ label: rmanLookupsV1.lookupDescription, value: rmanLookupsV1.lookupCode });
    });


    this.rmanLookupsV1 = rmanLookupsV1TempObj;

  }


  onBeforeToggle(evt: any) {
    this.collapsed = evt.collapsed;
  }
}


class RmanPobMappingImpl {
  constructor(public productId?: any, public legalEntityName?: any, public pobGrouping?: any, public parentSku?: any, public attribute3?: any, public attribute2?: any, public attribute1?: any, public standaloneSubSku?: any, public endDate?: any, public startDate?: any, public split?: any, public attribute5?: any, public attribute4?: any, public splitBasis?: any, public status?: any, public pobMapId?: any, public skuType?: any) { }
}

interface ILabels {
  [index: string]: string;
}

interface ILabels2 {
  [index: string]: string;
}
