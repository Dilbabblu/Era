import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ConfirmationService } from 'primeng/api';
import { Table } from 'primeng/table';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { NotificationService } from '../shared/notifications.service';
import { UploadService } from '../shared/upload.service';
import { RmanCustomers } from './rmanCustomers';
import { RmanCustomersLabels } from './rmanCustomersLabels';
import { RmanCustomersService } from './rmanCustomersservice';
import { CommonSharedService } from '../shared/common.service';

declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
    templateUrl: './rmanCustomers.component.html',
    selector: 'rmanCustomers-data',
    providers: [RmanCustomersService, ConfirmationService]
})

export class RmanCustomersComponent {

    displayDialog: boolean;

    displaySearchDialog: boolean;
    
    uploadLoading: boolean = false;

    rmanCustomers: RmanCustomers = new RmanCustomersImpl();

    rmanCustomersSearch: RmanCustomers = new RmanCustomersImpl();

    isSerached: number = 0;

    selectedRmanCustomers: RmanCustomers;

    newRmanCustomers: boolean;
	
	displayCustomersDialog: boolean = false;
	
    rmanCustomersList: RmanCustomers[];

    cols: any[];
    //columns: ILabels;

    columnOptions: any[];

    paginationOptions = {};

    pages: {};


    datasource: any[];
    pageSize: number;
    totalElements: number;
    collapsed: boolean = true;
    
    customerForm: FormGroup;
    noData = appSettings.noData;
    loading: boolean;
    rmancustomerStatus: any[];
    isSelectAllChecked = true;
    globalCols: any[];
    clonedCols: any[];
    userId: number;
    showPaginator: boolean = true;
    startIndex: number;
    showAddColumns = true;
    columns: any[];


    constructor(
        private rmanCustomersService: RmanCustomersService,
        private confirmationService: ConfirmationService,
        private rmanLookupsVService: RmanLookupsVService,
        private formBuilder: FormBuilder,
        private notificationService:NotificationService,
        public _uploadService:UploadService,  private commonSharedService: CommonSharedService
    ) {

        // generate list code
        this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };

        this.buildForm();

    }

    ngOnInit() {
        this.globalCols = [
            { field: 'customerNumber', header: 'Customer Number', showField: true, drag: false, display: "table-cell",type:'number'},
            { field: 'customerName', header: 'Customer Name', showField: true, drag: true, display: "table-cell",type:'text' },
            { field: 'status', header: 'Status', showField: true, drag: true, display: "table-cell",type:'text'},
        ];

        this.columns = [];
        this.getTableColumns("rmanCustomers", "Customers");
             //Fetching the status list
            this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'Record_Status' }).then((rmanLookupsV1List: any) => {
                this.rmancustomerStatus = rmanLookupsV1List.content;
                this.prepareRmanStatus();
                this.loading = false;
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while getting "Status" data');
                this.loading = false;
            });
            
    }

    prepareRmanStatus() {
        let rmanLookupsVTempObj: any = [{ label: appSettings.dropDownOptions.selectStat, value: null }];
        this.rmancustomerStatus.forEach((rmanLookupsV) => {
            rmanLookupsVTempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
        });
        this.rmancustomerStatus = rmanLookupsVTempObj;
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
        this.commonSharedService.saveOrUpdateTableColumns("rmanCustomers", "Customers", selectedCols, this.userId).then((response) => {
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



    getAllRmanCustomers() {
        this.loading = true;
        this.rmanCustomersService.getAllRmanCustomers(this.paginationOptions, this.rmanCustomers, false).then((rmanCustomersList: any) => {
            this.loading = false;
            this.datasource = rmanCustomersList.content;
            this.rmanCustomersList = rmanCustomersList.content;
            this.totalElements = rmanCustomersList.totalElements;
            this.pageSize = rmanCustomersList.size;
            this.displaySearchDialog = false;
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
        });
    }

    getRmanCustomers(event: any) {
        this.loading = true;
        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.rmanCustomersService.getAllRmanCustomers(this.paginationOptions, this.rmanCustomers, false).then((rmanCustomersList: any) => {
            this.loading = false;
            this.datasource = rmanCustomersList.content;
            this.rmanCustomersList = rmanCustomersList.content;
            this.totalElements = rmanCustomersList.totalElements;
            this.pageSize = rmanCustomersList.size;
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
        });

    }

    buildForm() {
        this.customerForm = this.formBuilder.group({
            'customerName': ['', [Validators.required, Validators.minLength(4),Validators.maxLength(60)]],
            'customerNumber': ['', [Validators.required, Validators.minLength(4),Validators.maxLength(60)]],
            'status': ['', [Validators.required]]
        });
        this.customerForm.valueChanges
            .subscribe(data => this.onValueChanged(data));

        this.onValueChanged();
    }

    onValueChanged(data?: any) {
        if (!this.customerForm) { return; }
        const form = this.customerForm;

        for (const field in this.formErrors) {

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
        'customerName': '', 'customerNumber': '', 'status': ''
    };

    validationMessages = {
        'customerName': {
            'required': "Customer Name is required (minimum length is 4 and maximum length is 60 characters)",
            'minlength': 'Customer Name must be at least 4 characters long.',
            'maxlength': 'Customer Name cannot be more than 60 characters long.',
        },
        'customerNumber': {
            'required': "Customer Number is Required (minimum length is 4 and maximum length is 60 characters)",
            'minlength': 'Customer Number must be at least 4 characters long.',
            'maxlength': 'Customer Number cannot be more than 60 characters long.',
        },
        'status': {
            'required': "Status is Required"
        }
    }


    showDialogToAdd() {
        this.newRmanCustomers = true;
        this.rmanCustomers = new RmanCustomersImpl();
        this.displayDialog = true;
        this.buildForm()
    }


    save() {

        if (this.newRmanCustomers) {
            this.loading = true;
            this.rmanCustomers.customerId = this.rmanCustomers.customerNumber;
            this.rmanCustomers.origSystemReference = this.rmanCustomers.customerNumber;
            this.rmanCustomersService.saveRmanCustomers(this.rmanCustomers).then((response: any) => {
                this.notificationService.showSuccess('Saved successfully');
                this.getAllRmanCustomers();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while saving data');
                this.loading = false;

            });
        }
        else {
            this.loading = true;
            this.rmanCustomers.customerId = this.rmanCustomers.origSystemReference;
            this.rmanCustomers.origSystemReference = this.rmanCustomers.customerNumber;
            this.rmanCustomersService.updateRmanCustomers(this.rmanCustomers).then((response: any) => {
                this.notificationService.showSuccess('Updated successfully');
                this.getAllRmanCustomers();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while updating data');
                this.loading = false;

            });
        }

        this.rmanCustomers = new RmanCustomersImpl();

        this.displayDialog = false;

    }

    onBeforeToggle(evt: any) {
        this.collapsed = evt.collapsed;
    }

    reset(dt: Table) {
        this.paginationOptions = {};
        this.rmanCustomers = new RmanCustomersImpl();
        this.rmanCustomersSearch = new RmanCustomersImpl();
        dt.reset();
    }


    delete(rmanCustomers: any) {
        this.rmanCustomers = rmanCustomers;
        this.displayDialog = false;

        this.confirmationService.confirm({
            message: 'Are you sure you want to delete this record?',
            header: 'Confirmation',
            icon: '',
            accept: () => {
                this.rmanCustomersList.splice(this.findSelectedRmanCustomersIndex(), 1);
                this.rmanCustomersService.deleteRmanCustomers(this.rmanCustomers).then(response => {
                    this.notificationService.showSuccess('Deleted successfully');
                    this.rmanCustomers = new RmanCustomersImpl();
                    this.getAllRmanCustomers();
                });
            },
            reject: () => {
                this.notificationService.showWarning('You have rejected');
            }
        })

    }

    editRow(rmanCustomers: any) {
        this.newRmanCustomers = false;
        this.rmanCustomers = this.cloneRmanCustomers(rmanCustomers);
        this.displayDialog = true;

    }


    findSelectedRmanCustomersIndex(): number {
        return this.rmanCustomersList.indexOf(this.selectedRmanCustomers);
    }

    onRowSelect(event: any) {

    }

    cloneRmanCustomers(c: RmanCustomers): RmanCustomers {
        let rmanCustomers = new RmanCustomersImpl();
        for (let prop in c) {
            rmanCustomers[prop] = c[prop];
        }
        return rmanCustomers;
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
            this.rmanCustomersSearch = new RmanCustomersImpl();
        }
        this.rmanCustomersSearch = new RmanCustomersImpl();
        this.displaySearchDialog = true;

    }
    cancelAddEdit(){
        this.displayDialog=false;
        this.rmanCustomers = new RmanCustomersImpl();
    }
    search() {

        this.isSerached = 1;
        this.rmanCustomers = this.rmanCustomersSearch;
        this.paginationOptions={};
        this.getAllRmanCustomers();
    }
    
    importFile(){
        this._uploadService.uploadDialog = true;
    	this.displayCustomersDialog=true;
    }
    
    showUploadLoader(){
    	this.uploadLoading = true;
    }

    fileUploadHandler(event: any, url:any){
        this._uploadService.processUpload(event,url);
    }
    
    
    onCustomersUpload(event: any){
    	
        this.notificationService.showSuccess('File Uploaded successfully');
	
	    this.displayCustomersDialog = false;
	    this.uploadLoading = false;    
	}
	
	onErrorCustFileupload(event:any){
		
	    this.displayCustomersDialog = false;
	    this.uploadLoading = false;    
	    let msg: string = "";
	    msg += event.files[0].name +" file upload process failed due to ";
	    if (event.xhr.response){
	      msg += JSON.parse(event.xhr.response).message
	    }
        this.notificationService.showError(msg);
	}
	
	cancel(){
        this._uploadService.uploadDialog = false;
		this.displayCustomersDialog = false;
	}


}


export class RmanCustomersImpl implements RmanCustomers {
    constructor(public groupType?: any, public globalAttribute10?: any, public lastUpdateDate?: any, public globalAttribute5?: any, public globalAttribute4?: any, public personTitle?: any, public status?: any, public globalAttribute7?: any, public globalAttribute6?: any, public globalAttribute1?: any, public country?: any, public emailAddress?: any, public knownAs?: any, public globalAttribute3?: any, public globalAttribute2?: any, public personPreviousLastName?: any, public personNameSuffix?: any, public globalAttribute9?: any, public personFirstName?: any, public globalAttribute8?: any, public county?: any, public createdBy?: any, public attribute3?: any, public lastUpdatedBy?: any, public attribute2?: any, public origSystemReference?: any, public attribute1?: any, public customerNumber?: any, public customerClassCode?: any, public personIdentifier?: any, public revAccountId?: any, public customerId?: any, public creationDate?: any, public attribute9?: any, public attribute8?: any, public attribute7?: any, public attribute6?: any, public attribute5?: any, public attribute4?: any, public attributeCategory?: any, public personMiddleName?: any, public attribute10?: any, public attribute14?: any, public attribute13?: any, public attribute12?: any, public customerType?: any, public attribute11?: any, public state?: any, public dunsNumber?: any, public requestId?: any, public primarySalesrepName?: any, public financeContact?: any, public postalCode?: any, public paymentTerms?: any, public salesChannelCode?: any, public sicCodeType?: any, public address1?: any, public primaryPhoneNumber?: any, public address3?: any, public address2?: any, public attribute21?: any, public cogsAccountId?: any, public attribute20?: any, public address4?: any, public attribute24?: any, public attribute23?: any, public attribute22?: any, public globalAttribute20?: any, public personAcademicTitle?: any, public globalAttributeCategory?: any, public globalAttribute17?: any, public globalAttribute18?: any, public globalAttribute15?: any, public personLastName?: any, public globalAttribute16?: any, public faxNumber?: any, public customerName?: any, public globalAttribute13?: any, public city?: any, public doNotMailFlag?: any, public globalAttribute14?: any, public globalAttribute11?: any, public personIdenType?: any, public globalAttribute12?: any, public attribute18?: any, public attribute17?: any, public attribute16?: any, public province?: any, public attribute15?: any, public globalAttribute19?: any, public attribute19?: any) { }
}

interface ILabels {
    [index: string]: string;
}
