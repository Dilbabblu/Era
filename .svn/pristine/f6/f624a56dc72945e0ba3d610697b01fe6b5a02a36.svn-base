import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ConfirmationService } from 'primeng/api';
import { Table } from 'primeng/table';
import { RmanLegalEntitiesService } from '../rmanLegalEntities/rmanLegalEntitiesservice';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { RmanRevenueTemplatesImpl } from '../rmanRevenueTemplates/rmanRevenueTemplates.component';
import { RmanRevenueTemplatesLabels } from '../rmanRevenueTemplates/rmanRevenueTemplatesLabels';
import { RmanRevenueTemplatesService } from '../rmanRevenueTemplates/rmanRevenueTemplatesservice';
import { NotificationService } from '../shared/notifications.service';
import { UploadService } from '../shared/upload.service';
import { RmanProducts } from './rmanProducts';
import { RmanProductsLabels } from './rmanProductsLabels';
import { RmanProductsService } from './rmanProductsservice';
import { CommonSharedService } from '../shared/common.service';
declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
    templateUrl: './rmanProducts.component.html',
    selector: 'rmanProducts-data',
    providers: [RmanProductsService, RmanLegalEntitiesService, RmanRevenueTemplatesService, ConfirmationService]
})

export class RmanProductsComponent implements OnInit {

    displayDialog: boolean;

    collapsed: boolean = true;

    displaySearchDialog: boolean;

    displayProductsDialog: boolean = false;

    uploadLoading: boolean = false;

    rmanProducts: any = new RmanProductsImpl();

    rmanProductsSearch: any = new RmanProductsImpl();


    rmanRevenueTemplatesSearch: any = new RmanRevenueTemplatesImpl();

    rmanRevenueTemplates: RmanRevenueTemplatesImpl = new RmanRevenueTemplatesImpl();

    selectedRevenueTemplates: RmanRevenueTemplatesImpl = new RmanRevenueTemplatesImpl();

    rmanRevenueTemplatesLabels: RmanRevenueTemplatesLabels = new RmanRevenueTemplatesLabels();


    isSerached: number = 0;

    selectedRmanProducts: RmanProducts;

    newRmanProducts: boolean;

    rmanProductsList: RmanProducts[];

    cols: any[];
    //columns: ILabels;
    revenueColumns: ILabels;


    columnOptions: any[];

    paginationOptions = {};

    pages: {};

    datasource: any[];
    pageSize: number;
    totalElements: number;

    rmanLookupsVList: any[] = [];
    rmanLookupsV: any[];
    rmanLookupsV1List: any[] = [];
    rmanLookupsV1: any[];
    rmanLegalEntitiesList: any[] = [];
    rmanLegalEntities: any[];
    rmanLookupsV2List: any[] = [];
    rmanLookupsV2: any[];
    rmanLookupsV3List: any[] = [];
    rmanLookupsV3: any[];
    rmanLookupsV4List: any[] = [];
    rmanLookupsV4: any[];
    rmanLookupsV5List: any[] = [];
    rmanLookupsV5: any[];
    rmanLookupsV6List: any[] = [];
    rmanLookupsV6: any[];
    rmanLookupsV7List: any[] = [];
    rmanLookupsV7: any[];
    rmanLookupsV8List: any[] = [];
    rmanLookupsV8: any[];

    rmanRevenueTemplatesList: any[] = [];
    rmanRevenueTemplatesProducts: any[] = [];


    productsForm: FormGroup;
    msgs: any;
    
    noData = appSettings.noData;
    loading: boolean;
    isSelectAllChecked = true;
    globalCols: any[];
    clonedCols: any[];
    userId: number;
    showPaginator: boolean = true;
    startIndex: number;
    showAddColumns = true;
    columns: any[];

    constructor(private rmanRevenueTemplatesService: RmanRevenueTemplatesService, private rmanProductsService: RmanProductsService, private formBuilder: FormBuilder, private rmanLookupsVService: RmanLookupsVService, private rmanLegalEntitiesService: RmanLegalEntitiesService, private confirmationService: ConfirmationService,
        private notificationService: NotificationService, public _uploadService:UploadService,  private commonSharedService: CommonSharedService) {

        // generate list code
        this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
        this.loading = true;
        this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'ENABLED_FLAG' }).then((rmanLookupsVList: any) => {
            this.rmanLookupsVList = rmanLookupsVList.content;
            this.prepareRmanLookupsVObject();

            this.rmanRevenueTemplatesService.getAllRmanRevenueTemplates(this.paginationOptions, {}, true).then((rmanRevenueTemplatesList: any) => {
                this.rmanRevenueTemplatesList = rmanRevenueTemplatesList.content;
                this.prepareRmanRevenueTemplatesObject();

                this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'ENABLED_FLAG' }).then((rmanLookupsV1List: any) => {
                    this.rmanLookupsV1List = rmanLookupsV1List.content;
                    this.prepareRmanLookupsV1Object();


                    this.rmanLegalEntitiesService.getAllRmanLegalEntities(this.paginationOptions, {}).then((rmanLegalEntitiesList: any) => {
                        this.rmanLegalEntitiesList = rmanLegalEntitiesList.content;
                        this.prepareRmanLegalEntitiesObject();


                        this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'ENABLED_FLAG' }).then((rmanLookupsV2List: any) => {
                            this.rmanLookupsV2List = rmanLookupsV2List.content;
                            this.prepareRmanLookupsV2Object();
                            this.prepareRmanLookupsV3Object();
                            this.prepareRmanLookupsV4Object();
                        }).catch((err: any) => {
                            this.notificationService.showError('Error occured while getting "Bundled Item" data');
                            this.loading = false;
                        });
                    }).catch((err: any) => {
                        this.notificationService.showError('Error occured while getting "Product Organization" data');
                        this.loading = false;
                    });
                }).catch((err: any) => {
                    this.notificationService.showError('Error occured while getting "Invoice Enabled Flag" data');
                    this.loading = false;
                });
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while getting "Revenue Template Name" data');
                this.loading = false;
            });
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting "Allocation Flag" data');
            this.loading = false;
        });

        this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'UNIT_OF_MEASUREMENT' }).then((rmanLookupsV5List: any) => {
            this.rmanLookupsV5List = rmanLookupsV5List.content;
            this.prepareRmanLookupsV5Object();
        });
        this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'PRODUCT_STATUS' }).then((rmanLookupsV6List: any) => {
            this.rmanLookupsV6List = rmanLookupsV6List.content;
            this.prepareRmanLookupsV6Object();
        });
        this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'INVOICING_RULE' }).then((rmanLookupsV7List: any) => {
            this.rmanLookupsV7List = rmanLookupsV7List.content;
            this.prepareRmanLookupsV7Object();
        });
        this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'PRODUCT_ELEMENT' }).then((rmanLookupsV8List: any) => {
            this.rmanLookupsV8List = rmanLookupsV8List.content;
            this.prepareRmanLookupsV8Object();
        });


    }

    ngOnInit() {
        this.globalCols = [
            { field: 'productId', header: 'Product ID', showField: true, drag: false, display: "table-cell",type:'number', innerfields: '0'},
            { field: 'sourceProductId', header: 'Source ID', showField: true, drag: true, display: "table-cell",type:'number' , innerfields: '0'},
            { field: 'productName', header: 'Product Name', showField: true, drag: true, display: "table-cell",type:'text', innerfields: '0'},
            { field: 'productDescription', header: 'Product Description', showField: true, drag: true, display: "table-cell",type:'text', innerfields: '0' },
            { field: 'productOrgId', header: 'Product Org ID', showField: true, drag: true, display: "table-cell",type:'number', innerfields: '0' },
            { field: 'productOrgName', header: 'Product Organization', showField: true, drag: true, display: "table-cell",type:'text', innerfields: '0' },
            { field: 'attribute26', header: 'Product Master class', showField: true, drag: true, display: "table-cell",type:'text', innerfields: '0' },
            { field: 'attribute27', header: 'Rev Rec%', showField: true, drag: true, display: "table-cell",type:'number', innerfields: '0' },
            { field: 'productOrgCode', header: 'Business Unit' , showField: true, drag: true, display: "table-cell",type:'text', innerfields: '0'},
            { field: 'productStatus', header: 'Item Status' , showField: true, drag: true, display: "table-cell",type:'text', innerfields: '0'},
            { field: 'productType', header: 'Item Type' , showField: true, drag: true, display: "table-cell",type:'text', innerfields: '0'},
            { field: 'productCost', header: 'Product Cost' , showField: true, drag: true, display: "table-cell",type:'round', innerfields: '0'},
            { field: 'productRevAccount', header: 'Product Rev Account' , showField: true, drag: true, display: "table-cell",type:'text', innerfields: '0'},
            { field: 'shippableFlag', header: 'Shippable Flag', showField: true, drag: true, display: "table-cell",type:'text', innerfields: '0'},
            { field: 'attribute1', header: 'Product Portfolio', showField: true, drag: true, display: "table-cell",type:'text', innerfields: '0' },
            { field: 'attribute2', header: 'Product Family', showField: true, drag: true, display: "table-cell",type:'text', innerfields: '0'},
            { field: 'attribute3', header: 'Product Line', showField: true, drag: true, display: "table-cell",type:'text', innerfields: '0' },
            { field: 'acctRuleName', header: 'Invoicing Rule', showField: true, drag: true, display: "table-cell",type:'text', innerfields: '0' },
            { field: 'elementType', header: 'Product Element', showField: true, drag: true, display: "table-cell",type:'text', innerfields: '0' },
            { field: 'bundleFlag', header: 'Bundled Item' , showField: true, drag: true, display: "table-cell",type:'text', innerfields: '0'},
            { field: 'uom', header: 'Unit of Measurement' , showField: true, drag: true, display: "table-cell",type:'text', innerfields: '0'},
            { field: 'startDate', header: 'Start Date' , showField: true, drag: true, display: "table-cell",type:'date', innerfields: '0'},
            { field: 'endDate', header: 'End Date' , showField: true, drag: true, display: "table-cell",type:'date', innerfields: '0'},
            { field: 'invoiceEnabledFlag', header: 'Invoice Enabled Flag' , showField: true, drag: true, display: "table-cell",type:'text', innerfields: '0'},
            { field: 'rmanRevenueTemplates', header: 'Revenue Template', showField: true, drag: true, display: "table-cell",type:'text', innerfields: '1', subfield:'templateName' }	
            ];
    
            this.columns = [];
            this.getTableColumns("rmanProducts", "Products");
        
        let rmanRevenueTemplatesLabels = new RmanRevenueTemplatesLabels();
        this.revenueColumns = rmanRevenueTemplatesLabels.fieldLabels;
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
        this.commonSharedService.saveOrUpdateTableColumns("rmanProducts", "Products", selectedCols, this.userId).then((response) => {
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
        //console.log(this.globalCols);
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
        this.rmanProductsSearch = new RmanProductsImpl();
        this.rmanProducts = new RmanProductsImpl();
        dt.reset();
    }

    buildForm() {
        this.productsForm = this.formBuilder.group({
            'productName': ['', [Validators.required, Validators.minLength(4), Validators.maxLength(60)]],
            'productDescription': ['', [Validators.required]],
            'uom': ['', [Validators.required]],
            'startDate': ['', []],
            'endDate': ['', []],
            'itemStatus': ['', [Validators.required]],
            'itemType': ['', []],
            'bundledItem': ['', [Validators.required]],
            'invoicingRule': ['', [Validators.required]],
            'productOrganization': ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
            'productOrgCode': ['', [Validators.required]],
            'productOrgName': ['', [Validators.required]],
            'elementType': ['', []],
            'productMasterClass':['', []],
            'revRecPerc': ['', [Validators.pattern('^[0-9]*$'), Validators.min(0), Validators.max(100)]],
        });

        this.productsForm.valueChanges
            .subscribe(data => this.onValueChanged(data));

        this.onValueChanged();
    }
    onValueChanged(data?: any) {
        if (!this.productsForm) { return; }
        const form = this.productsForm;

        for (const field in this.formErrors) {
            // clear previous error message (if any)
            this.formErrors[field] = '';
            const control = form.get(field);
            if (field === 'endDate') {
                let startDate = this.productsForm.get('startDate').value;
                let endDate = this.productsForm.get('endDate').value;
                if (endDate) {
                    this.formErrors['startDate'] = '';
                    if (!startDate) {
                        this.formErrors['startDate'] += 'Start date is required' + ' ';
                    } else if (startDate > endDate) {
                        this.formErrors['endDate'] += 'End date can not be less than start date' + ' ';
                    }
                }
            } else {
                if (control && control.dirty && !control.valid) {
                    const messages = this.validationMessages[field];
                    for (const key in control.errors) {
                        this.formErrors[field] += messages[key] + ' ';
                    }
                }
            }
        }
    }

    formErrors = {
        'productName': '', 'productDescription': '', 'uom': '', 'startDate': '', 'endDate': '', 'itemStatus': '', 'itemType': '', 'bundledItem': '', 'invoicingRule': '', 'productOrganization': '', 'productOrgCode': '', 'productOrgName': '','elementType':'','productMasterClass':'','revRecPerc':''
    };

    validationMessages = {
        'productName': {
            'required': "Product Name is required (minimum length is 4 and maximum length is 60 characters)",
            'minlength': 'Product Name must be at least 4 characters long.',
            'maxlength': 'Product Name cannot be more than 60 characters long.',
        }, 'productDescription': {
            'required': "Product Description is Required"
        },
        'uom': {
            'required': "Unit of Measurement is required"
        }, 'startDate': {
            'required': "Start Date is required"
        }, 'itemStatus': {
            'required': "Item Status is required"
        }, 'itemType': {
            'required': "Item Type is required"
        }, 'bundledItem': {
            'required': "Bundled Item is required"
        }, 'invoicingRule': {
            'required': "Invoicing Rule is required"
        }, 'productOrganization': {
            'required': "Product Organization is required (Only number values are allowed [0-9])",
            'pattern': 'Only number values are allowed [0-9]'
        }, 'productOrgName': {
            'required': "Product Organization Name is required"
        }, 'productOrgCode': {
            'required': "Product Organization Code is required"
        }, 'elementType':{
            'required': "Product Element is required"
        }, 'revRecPerc':{
            'required': "Rev Rec(%) is required",
            'min':"Minimum Values is 0",
            'max':"Maximum Value is 100"
        }, 'productMasterClass':{
            'required': "Product Master class is required"
        }


    }


    transformRmanLookupsV(rmanLookupsV: any) {
        if (rmanLookupsV)
            return rmanLookupsV.lookupDescription;
    }
    transformRmanLookupsV1(rmanLookupsV1: any) {
        if (rmanLookupsV1)
            return rmanLookupsV1.lookupDescription;
    }
    transformRmanLegalEntities(rmanLegalEntities: any) {
        if (rmanLegalEntities)
            return rmanLegalEntities.name;
    }
    transformRmanLookupsV2(rmanLookupsV2: any) {
        if (rmanLookupsV2)
            return rmanLookupsV2.lookupDescription;
    }

    getRmanRevenueTemplatesInProducts() {
        this.rmanRevenueTemplates = {};
        if (this.rmanProducts.revenueTemplateId) {
            this.loading = true;
            this.rmanRevenueTemplatesService.getAllRmanRevenueTemplates(this.paginationOptions, { 'revenueTemplateId': this.rmanProducts.revenueTemplateId }, false).then((rmanRevenueTemplates: any) => {
                this.loading = false;
                this.rmanRevenueTemplates = rmanRevenueTemplates.content[0];
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while getting data');
                this.loading = false;
            });
        }
    }

    getAllRmanProducts() {
        this.loading = true;
        this.rmanProducts = this.rmanProductsSearch;
        this.rmanProductsService.getAllRmanProducts(this.paginationOptions, this.rmanProducts, false)
            .then((rmanProductsList: any) => {
                this.loading = false;
                this.datasource = rmanProductsList.content;
                this.rmanProductsList = rmanProductsList.content;
                this.totalElements = rmanProductsList.totalElements;
                this.pageSize = rmanProductsList.size;
                this.displaySearchDialog = false;
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while getting data');
                this.loading = false;
            });
    }


    getRmanProducts(event: any) {

        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.loading = true;
        this.rmanProducts = this.rmanProductsSearch;
        this.rmanProductsService.getAllRmanProducts(this.paginationOptions, this.rmanProducts, false)
            .then((rmanProductsList: any) => {
                this.loading = false;
                this.datasource = rmanProductsList.content;
                this.rmanProductsList = rmanProductsList.content;
                this.totalElements = rmanProductsList.totalElements;
                this.pageSize = rmanProductsList.size;
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while getting data');
                this.loading = false;
            });

    }


    showDialogToAdd() {

        this.newRmanProducts = true;
        this.rmanProducts = new RmanProductsImpl();
        this.displayDialog = true;
        this.prepareRmanLookupsVObject();
        this.prepareRmanLookupsV1Object();
        this.prepareRmanLegalEntitiesObject();
        this.prepareRmanLookupsV2Object();
        this.prepareRmanLookupsV3Object();
        this.prepareRmanRevenueTemplatesObject();
        this.buildForm();
    }


    save() {


        if (this.newRmanProducts) {
            this.loading = true;
            this.rmanProductsService.saveRmanProducts(this.rmanProducts).then(response => {
                this.notificationService.showSuccess( 'Saved successfully');
                this.getAllRmanProducts();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while saving the data');
                this.loading = false;
            });
        }
        else {
            this.loading = true;
            if (this.rmanProducts.rmanRevenueTemplates) {
                this.rmanProducts.rmanRevenueTemplates.revenueTemplateId = this.rmanProducts.revenueTemplateId;
            }
            this.rmanProductsService.updateRmanProducts(this.rmanProducts).then(response => {
                this.notificationService.showSuccess('Updated successfully');
                this.getAllRmanProducts();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while updating data');
                this.loading = false;
            });
        }

        this.rmanProducts = new RmanProductsImpl();

        this.displayDialog = false;

    }


    delete(rmanProducts: any) {
        this.rmanProducts = rmanProducts;
        this.displayDialog = false;
        this.confirmationService.confirm({
            message: 'Are you sure you want to delete this record?',
            header: 'Confirmation',
            icon: '',
            accept: () => {
                this.rmanProductsList.splice(this.findSelectedRmanProductsIndex(), 1);
                this.loading = true;
                this.rmanProductsService.deleteRmanProducts(this.rmanProducts).then(response => {
                    this.loading = false;
                    this.rmanProducts = new RmanProductsImpl();
                    this.getAllRmanProducts();
                });
                this.notificationService.showSuccess('Deleted successfully');
            },
            reject: () => {
                this.notificationService.showWarning('You have rejected');
            }
        });


    }

    editRow(rmanProducts: any) {
        this.newRmanProducts = false;
        this.rmanProducts = this.cloneRmanProducts(rmanProducts);
        if (this.rmanProducts.startDate) {
            this.rmanProducts.startDate = new Date(this.rmanProducts.startDate);
        }
        if (this.rmanProducts.endDate) {
            this.rmanProducts.endDate = new Date(this.rmanProducts.endDate);
        }

        if (this.rmanProducts.revenueTemplateId && rmanProducts.rmanRevenueTemplates) {
            this.rmanRevenueTemplates = rmanProducts.rmanRevenueTemplates;
        }

        this.displayDialog = true;

        this.prepareRmanLookupsVObject();
        this.prepareRmanLookupsV1Object();
        this.prepareRmanLegalEntitiesObject();
        this.prepareRmanLookupsV2Object();
        this.prepareRmanLookupsV3Object();
        this.prepareRmanRevenueTemplatesObject();

    }


    findSelectedRmanProductsIndex(): number {
        return this.rmanProductsList.indexOf(this.selectedRmanProducts);
    }

    onRowSelect(event: any) {

    }

    cloneRmanProducts(c: RmanProducts): RmanProducts {
        let rmanProducts: any = new RmanProductsImpl();
        for (let prop in c) {
            rmanProducts[prop] = c[prop];
        }
        return rmanProducts;
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

        this.rmanProductsSearch = new RmanProductsImpl();

        if (this.isSerached == 0) {
            this.rmanProductsSearch = new RmanProductsImpl();
        }
        this.displaySearchDialog = true;

    }

    fileUploadHandler(event: any, url:any){
        this._uploadService.processUpload(event,url);
    }
    
    importFile() {
        this._uploadService.uploadDialog = true;
        this.displayProductsDialog = true;
    }
    showUploadLoader() {
        this.uploadLoading = true;
    }


    onProductsUpload(event: any) {
        this.displayProductsDialog = false;
        
        this.notificationService.showSuccess('File Uploaded successfully');

        this.uploadLoading = false;
    }

    onErrorProdFileupload(event: any) {
        
        this.displayProductsDialog = false;
        this.uploadLoading = false;
        let msg: string = "";
        msg += event.files[0].name + " file upload process failed due to ";
        if (event.xhr.response) {
            msg += JSON.parse(event.xhr.response).message
        }
        this.notificationService.showError(msg);

    }

    cancelProductsUpload() {
        this._uploadService.uploadDialog = false;
        this.displayProductsDialog = false;
    }
    search() {

        this.isSerached = 1;
        this.rmanProducts = this.rmanProductsSearch;
        this.paginationOptions = {};
        this.getAllRmanProducts();
    }
    cancelAddEdit() {
        this.displayDialog = false;
        this.rmanProducts = new RmanProductsImpl();
        this.formErrors['startDate'] = '';
    }

    prepareRmanLookupsVObject() {
        let rmanLookupsVTempObj: any = [{ label: appSettings.dropDownOptions.selectAllocation, value: null }];
        this.rmanLookupsVList.forEach((rmanLookupsV) => {
            rmanLookupsVTempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
        });

        this.rmanLookupsV = rmanLookupsVTempObj;

    }

    prepareRmanLookupsV1Object() {
        let rmanLookupsV1TempObj: any = [{ label: appSettings.dropDownOptions.selectInvoice, value: null }];
        this.rmanLookupsV1List.forEach((rmanLookupsV1) => {
            rmanLookupsV1TempObj.push({ label: rmanLookupsV1.lookupDescription, value: rmanLookupsV1.lookupCode });
        });

        this.rmanLookupsV1 = rmanLookupsV1TempObj;

    }

    prepareRmanRevenueTemplatesObject() {
        let rmanRevenueTemplatesTempObj: any = [{ label: appSettings.dropDownOptions.selectRevTemp, value: null }];
        this.rmanRevenueTemplatesList.forEach((rmanRevenueTemplatesProducts) => {
            rmanRevenueTemplatesTempObj.push({ label: rmanRevenueTemplatesProducts.templateName, value: rmanRevenueTemplatesProducts.revenueTemplateId });
        });

        this.rmanRevenueTemplatesProducts = rmanRevenueTemplatesTempObj;

    }

    prepareRmanLegalEntitiesObject() {
        let rmanLegalEntitiesTempObj: any = [{ label: appSettings.dropDownOptions.selectProdOrg, value: null }];
        this.rmanLegalEntitiesList.forEach((rmanLegalEntities) => {
            rmanLegalEntitiesTempObj.push({ label: rmanLegalEntities.name, value: rmanLegalEntities.legalEntityId });
        });

        this.rmanLegalEntities = rmanLegalEntitiesTempObj;

    }

    prepareRmanLookupsV2Object() {
        let rmanLookupsV2TempObj: any = [{ label: appSettings.dropDownOptions.selectBundled, value: null }];
        this.rmanLookupsV2List.forEach((rmanLookupsV2) => {
            rmanLookupsV2TempObj.push({ label: rmanLookupsV2.lookupDescription, value: rmanLookupsV2.lookupCode });
        });

        this.rmanLookupsV2 = rmanLookupsV2TempObj;

    }


    prepareRmanLookupsV3Object() {
        let rmanLookupsV3TempObj: any = [{ label: appSettings.dropDownOptions.selectInvoicable, value: null }];
        this.rmanLookupsV3List.forEach((rmanLookupsV3) => {
            rmanLookupsV3TempObj.push({ label: rmanLookupsV3.lookupDescription, value: rmanLookupsV3.lookupCode });
        });

        this.rmanLookupsV3 = rmanLookupsV3TempObj;

    }
    
        prepareRmanLookupsV4Object() {
        let rmanLookupsV4TempObj: any = [{ label:appSettings.dropDownOptions.selectLtStFlag, value: null }];
        this.rmanLookupsV2List.forEach((rmanLookupsV4) => {
            rmanLookupsV4TempObj.push({ label: rmanLookupsV4.lookupDescription, value: rmanLookupsV4.lookupCode });
        });

        this.rmanLookupsV4 = rmanLookupsV4TempObj;

    }

    prepareRmanLookupsV5Object() {
        let rmanLookupsV5TempObj: any = [{ label:appSettings.dropDownOptions.selectUom, value: null }];
        this.rmanLookupsV5List.forEach((rmanLookupsV5) => {
            rmanLookupsV5TempObj.push({ label: rmanLookupsV5.lookupDescription, value: rmanLookupsV5.lookupCode });
        });
        this.rmanLookupsV5 = rmanLookupsV5TempObj;
    }

    prepareRmanLookupsV6Object() {
        let rmanLookupsV6TempObj: any = [{ label:appSettings.dropDownOptions.selectItemStatus, value: null }];
        this.rmanLookupsV6List.forEach((rmanLookupsV6) => {
            rmanLookupsV6TempObj.push({ label: rmanLookupsV6.lookupDescription, value: rmanLookupsV6.lookupCode });
        });
        this.rmanLookupsV6 = rmanLookupsV6TempObj;
    }
    prepareRmanLookupsV7Object() {
        let rmanLookupsV7TempObj: any = [{ label:appSettings.dropDownOptions.selectInvoiceRule, value: null }];
        this.rmanLookupsV7List.forEach((rmanLookupsV7) => {
            rmanLookupsV7TempObj.push({ label: rmanLookupsV7.lookupDescription, value: rmanLookupsV7.lookupCode });
        });
        this.rmanLookupsV7 = rmanLookupsV7TempObj;
    }
    prepareRmanLookupsV8Object() {
        let rmanLookupsV8TempObj: any = [{ label:appSettings.dropDownOptions.selectProductElement, value: null }];
        this.rmanLookupsV8List.forEach((rmanLookupsV8) => {
            rmanLookupsV8TempObj.push({ label: rmanLookupsV8.lookupDescription, value: rmanLookupsV8.lookupCode });
        });
        this.rmanLookupsV8 = rmanLookupsV8TempObj;
    }

    onBeforeToggle(evt: any) {
        this.collapsed = evt.collapsed;
    }
}


export class RmanProductsImpl {
    constructor(public attribute30?: any, public endDate?: any, public elementType?: any, public lastUpdateDate?: any, public productOrgId?: any, public productDescription?: any, public attribute29?: any, public attribute28?: any, public allocationFlag?: any, public attribute27?: any, public attribute26?: any, public allowRevrecWoInvoice?: any, public attribute3?: any, public createdBy?: any, public attribute2?: any, public lastUpdatedBy?: any, public productOrgName?: any, public attribute1?: any, public revAccountId?: any, public creationDate?: any, public attribute9?: any, public shippableFlag?: any, public attribute8?: any, public productName?: any, public attribute7?: any, public invoiceEnabledFlag?: any, public attribute6?: any, public attribute5?: any, public attribute4?: any, public directCv?: any, public productStatus?: any, public residualValue?: any, public source?: any, public attribute10?: any, public cvPercent?: any, public sourceProductId?: any, public revrecType?: any, public attribute14?: any, public attribute13?: any, public attribute12?: any, public attribute11?: any, public acctRuleName?: any, public productRevAccount?: any, public productCogsAccount?: any, public productOrgCode?: any, public attribute21?: any, public cogsAccountId?: any, public attribute20?: any, public attribute25?: any, public attribute24?: any, public fvOptional?: any, public attribute23?: any, public attribute22?: any, public startDate?: any, public productId?: any, public revenueTemplateId?: any, public productCost?: any, public productType?: any, public uom?: any, public attribute18?: any, public attribute17?: any, public revenueCategory?: any, public attribute16?: any, public attribute15?: any, public attribute19?: any, public bundleFlag?: any) { }
}

interface ILabels {
    [index: string]: string;
}
