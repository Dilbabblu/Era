import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ConfirmationService, Message } from 'primeng/api';
import { Table } from 'primeng/table';
import { RmanCurrencyService } from '../rmanCurrency/rmanCurrencyservice';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanLegalEntities } from './rmanLegalEntities';
import { RmanLegalEntitiesLabels } from './rmanLegalEntitiesLabels';
import { RmanLegalEntitiesService } from './rmanLegalEntitiesservice';

declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
    templateUrl: './rmanLegalEntities.component.html',
    selector: 'rmanLegalEntities-data',
    providers: [RmanLegalEntitiesService, RmanCurrencyService, ConfirmationService]
})

export class RmanLegalEntitiesComponent implements OnInit {

    displayDialog: boolean;

    displaySearchDialog: boolean;

    rmanLegalEntities: any = new RmanLegalEntitiesImpl();

    rmanLegalEntitiesSearch: any = new RmanLegalEntitiesImpl();

    isSerached: number = 0;

    
    showMsg: any;

    msgs: Message[] = [];

    

    selectedRmanLegalEntities: RmanLegalEntities;

    newRmanLegalEntities: boolean;

    rmanLegalEntitiesList: any[];

    cols: any[];
    leaglEntityColumns: ILabels;

    columnOptions: any[];

    paginationOptions: any;

    pages: {};

   

    datasource: any[];
    pageSize: number;
    totalElements: number;


    rmanCurrencyList: any[] = [];
    rmanCurrency: any[];
    rmanCurrency1List: any[] = [];
    rmanCurrency1: any[];
    rmanCurrency2List: any[] = [];
    rmanCurrency2: any[];
    rmanCurrency3List: any[] = [];
    rmanCurrency3: any[];
    rmanLookupsVList: any[] = [];
    rmanLookupsV: any[];
    noData = appSettings.noData;
    loading: boolean;
    collapsed: boolean = true;

    legalEntitiesForm: FormGroup;

    isSelectAllChecked = true;
    globalCols: any[];
    clonedCols: any[];
    userId: number;
    showPaginator: boolean = true;
    startIndex: number;
    showAddColumns = true;
    columns: any[];

    

    constructor(private rmanLegalEntitiesService: RmanLegalEntitiesService, private rmanCurrencyService: RmanCurrencyService, private rmanLookupsVService: RmanLookupsVService, private formBuilder: FormBuilder, private confirmationService: ConfirmationService,
        private notificationService:NotificationService, private commonSharedService:CommonSharedService) {}
   
    ngOnInit() {

        this.globalCols = [
            { field: 'legalEntityId', header: 'Legal Entity Id', showField: true, drag: false, display: "table-cell", type: 'number' },
            { field: 'name', header: 'Name', showField: true, drag: false, display: "table-cell", type: 'text' },
            { field: 'description', header: 'Description', showField: true, drag: false, display: "table-cell", type: 'text' },
            { field: 'functionalCurrency', header: 'Functional Currency', showField: true, drag: true, display: "table-cell", type: 'text' },
            { field: 'reportingCurrency', header: 'Reporting Currency', showField: true, drag: true, display: "table-cell", type: 'text' },
            { field: 'calendar', header: 'Calendar', showField: true, drag: true, display: "table-cell", type: 'text' },
            { field: 'allocationCurrency', header: 'Allocation Currency', showField: true, drag: true, display: "table-cell", type: 'text' },
            { field: 'ledgerName', header: 'Ledger Name', showField: true, drag: true, display: "table-cell", type: 'text' },
            { field: 'enabledFlag', header: 'Enabled Flag', showField: true, drag: true, display: "table-cell", type: 'text' },
            { field: 'currencyCode', header: 'Currency Code', showField: true, drag: true, display: "table-cell", type: 'text' }
        
        ];
        
        this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
        this.loading = true;
        this.rmanCurrencyService.getAllRmanCurrency(this.paginationOptions, {}).then((rmanCurrencyList: any) => {
            this.rmanCurrencyList = rmanCurrencyList.content;
            this.prepareRmanCurrencyObject();
            this.rmanCurrency1List = rmanCurrencyList.content;
            this.prepareRmanCurrency1Object();
            this.rmanCurrency2List = rmanCurrencyList.content;
            this.prepareRmanCurrency2Object();
            this.rmanCurrency3List = rmanCurrencyList.content;
            this.prepareRmanCurrency3Object();
            this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'ENABLED_FLAG' }).then((rmanLookupsVList: any) => {
                            this.loading = false;
                            this.rmanLookupsVList = rmanLookupsVList.content;
                            this.prepareRmanLookupsVObject();
                        });
                    });

                    
        this.columns = [];
        this.getTableColumns("rmanLegalEntities", "Legal Entities");

        let rmanLegalEntitiesLabels = new RmanLegalEntitiesLabels();
        this.leaglEntityColumns = rmanLegalEntitiesLabels.fieldLabels;
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
        this.commonSharedService.saveOrUpdateTableColumns("rmanLegalEntities", "Legal Entities", selectedCols, this.userId).then((response) => {
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


    cancelSearch(){
        this.displaySearchDialog = false;
        this.rmanLegalEntitiesSearch = new RmanLegalEntitiesImpl();
    }
    cancelAddEdit() {        
        this.displayDialog = false;
        this.rmanLegalEntities = new RmanLegalEntitiesImpl();
    }
    ngAfterViewChecked() {
    }

    reset(dt: Table) {
        this.paginationOptions = {};
        this.rmanLegalEntities = new RmanLegalEntitiesImpl();
        dt.reset();

    }

    buildForm() {
        this.legalEntitiesForm = this.formBuilder.group({
            'name': ['', [Validators.required, Validators.minLength(4),Validators.maxLength(40)]],
            'flag': ['', [Validators.required]],
            'ledgerName': ['', [Validators.minLength(4),Validators.maxLength(30)]],
            'description': ['', [Validators.maxLength(50)]],
            'calendar': ['', [Validators.maxLength(20)]],
        });

        this.legalEntitiesForm.valueChanges
            .subscribe(data => this.onValueChanged(data));

        this.onValueChanged();
    }

    onValueChanged(data?: any) {
        if (!this.legalEntitiesForm) { return; }
        const form = this.legalEntitiesForm;

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
        'name': '', 'flag': '', 'ledgerName':'', 'description':'', 'calendar':''
    };

    validationMessages = {
        'name': {
            'required': "Name is required (minimum length is 4 and maximum length is 40 characters)",
            'minlength': 'Name must be at least 4 characters long.',
            'maxlength': 'Name cannot be more than 40 characters long.',
        }, 'flag': {
            'required': "Enabled Flag is Required"
        },
        'ledgerName': {
            'minlength': 'Ledger Name must be at least 4 characters long.',
            'maxlength': 'Ledger Name cannot be more than 30 characters long.',
        },
        'description': {
            'maxlength': 'Description cannot be more than 50 characters long.'
        },
        'calendar': {
            'maxlength': 'Calender length cannot be more than 20 characters long.'
        }
    }

    transformRmanCurrency(rmanCurrency: any) {
        if (rmanCurrency)
            return rmanCurrency.name;
    }
    transformRmanCurrency1(rmanCurrency1: any) {
        if (rmanCurrency1)
            return rmanCurrency1.name;
    }
    transformRmanCurrency2(rmanCurrency2: any) {
        if (rmanCurrency2)
            return rmanCurrency2.name;
    }
    transformRmanCurrency3(rmanCurrency3: any) {
        if (rmanCurrency3)
            return rmanCurrency3.name;
    }
    transformRmanLookupsV(rmanLookupsV: any) {
        if (rmanLookupsV)
            return rmanLookupsV.lookupDescription;
    }



    getAllRmanLegalEntities() {
        this.loading = true;
        this.rmanLegalEntitiesService.getAllRmanLegalEntities(this.paginationOptions, this.rmanLegalEntities).then((rmanLegalEntitiesList: any) => {
            this.loading = false;
            this.datasource = rmanLegalEntitiesList.content;
            this.rmanLegalEntitiesList = rmanLegalEntitiesList.content;
            this.totalElements = rmanLegalEntitiesList.totalElements;
            this.pageSize = rmanLegalEntitiesList.size;
            this.displaySearchDialog = false;
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
        });
    }


    getRmanLegalEntities(event: any) {

        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.loading = true;
        this.rmanLegalEntitiesService.getAllRmanLegalEntities(this.paginationOptions, this.rmanLegalEntities).then((rmanLegalEntitiesList: any) => {
            this.loading = false;
            this.datasource = rmanLegalEntitiesList.content;
            this.rmanLegalEntitiesList = rmanLegalEntitiesList.content;
            this.totalElements = rmanLegalEntitiesList.totalElements;
            this.pageSize = rmanLegalEntitiesList.size;
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
        });

    }


    showDialogToAdd() {

        this.newRmanLegalEntities = true;
        this.rmanLegalEntities = new RmanLegalEntitiesImpl();
        this.displayDialog = true;
        this.prepareRmanCurrencyObject();
        this.prepareRmanCurrency1Object();
        this.prepareRmanCurrency2Object();
        this.prepareRmanCurrency3Object();
        this.prepareRmanLookupsVObject();
        this.buildForm();

    }


    save() {


        if (this.newRmanLegalEntities) {
            this.loading = true;
            this.rmanLegalEntitiesService.saveRmanLegalEntities(this.rmanLegalEntities).then((response: any) => {
                this.notificationService.showSuccess('Saved successfully');
                this.getAllRmanLegalEntities();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while saving data');
                this.loading = false;
            });
        }
        else {
            this.loading = true;
            this.rmanLegalEntitiesService.updateRmanLegalEntities(this.rmanLegalEntities).then((response: any) => {
                this.notificationService.showSuccess('Updated successfully');
                this.getAllRmanLegalEntities();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while updating data');
                this.loading = false;
            });
        }

        this.rmanLegalEntities = new RmanLegalEntitiesImpl();

        this.displayDialog = false;

    }


    delete(rmanLegalEntities: any) {
        this.rmanLegalEntities = rmanLegalEntities;
        if (this.rmanLegalEntities.lastUpdateDate) {
            this.rmanLegalEntities.lastUpdateDate = new Date(this.rmanLegalEntities.lastUpdateDate);
        }
        this.displayDialog = false;
        this.confirmationService.confirm({
            message: 'Are you sure you want to delete this record?',
            header: 'Confirmation',
            icon: '',
            accept: () => {
                this.rmanLegalEntitiesList.splice(this.findSelectedRmanLegalEntitiesIndex(), 1);
                this.loading = true;
                this.rmanLegalEntitiesService.deleteRmanLegalEntities(this.rmanLegalEntities).then((response: any) => {
                    this.rmanLegalEntities = new RmanLegalEntitiesImpl();
                    this.getAllRmanLegalEntities();
                });
                this.notificationService.showSuccess('Deleted successfully');
            },
            reject: () => {
                this.notificationService.showWarning('You have rejected' );
            }
        });
    }

    editRow(rmanLegalEntities: any) {
        this.newRmanLegalEntities = false;
        this.rmanLegalEntities = this.cloneRmanLegalEntities(rmanLegalEntities);
        if (this.rmanLegalEntities.lastUpdateDate) {
            this.rmanLegalEntities.lastUpdateDate = new Date(this.rmanLegalEntities.lastUpdateDate);
        } this.displayDialog = true;
        this.prepareRmanCurrencyObject();
        this.prepareRmanCurrency1Object();
        this.prepareRmanCurrency2Object();
        this.prepareRmanCurrency3Object();
        this.prepareRmanLookupsVObject();

    }


    findSelectedRmanLegalEntitiesIndex(): number {
        return this.rmanLegalEntitiesList.indexOf(this.selectedRmanLegalEntities);
    }

    onRowSelect(event: any) {

    }

    cloneRmanLegalEntities(c: RmanLegalEntities): RmanLegalEntities {
        let rmanLegalEntities: any
            = new RmanLegalEntitiesImpl();
        for (let prop in c) {
            rmanLegalEntities[prop] = c[prop];
        }
        return rmanLegalEntities;
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

        this.rmanLegalEntitiesSearch = new RmanLegalEntitiesImpl();

        if (this.isSerached == 0) {
            this.rmanLegalEntitiesSearch = new RmanLegalEntitiesImpl();
        }
        this.displaySearchDialog = true;

    }

    search() {

        this.isSerached = 1;
        this.rmanLegalEntities = this.rmanLegalEntitiesSearch;
        this.paginationOptions={};
        this.getAllRmanLegalEntities();
    }

    prepareRmanCurrencyObject() {
        let rmanCurrencyTempObj: any = [{ label: appSettings.dropDownOptions.selectAllocationCurrency, value: null }];
        this.rmanCurrencyList.forEach((rmanCurrency) => {
        rmanCurrencyTempObj.push({ label: rmanCurrency.currencyCode, value: rmanCurrency.currencyCode });
        });

        this.rmanCurrency = rmanCurrencyTempObj;

    }

    prepareRmanCurrency1Object() {
        let rmanCurrency1TempObj: any = [{ label: appSettings.dropDownOptions.selectCurrencyCode, value: null }];
        this.rmanCurrency1List.forEach((rmanCurrency1) => {
            rmanCurrency1TempObj.push({ label: rmanCurrency1.currencyCode, value: rmanCurrency1.currencyCode });
        });

        this.rmanCurrency1 = rmanCurrency1TempObj;

    }

    prepareRmanCurrency2Object() {
        let rmanCurrency2TempObj: any = [{ label: appSettings.dropDownOptions.selectReporting, value: null }];
        this.rmanCurrency2List.forEach((rmanCurrency2) => {
            rmanCurrency2TempObj.push({ label: rmanCurrency2.currencyCode, value: rmanCurrency2.currencyCode });
        });

        this.rmanCurrency2 = rmanCurrency2TempObj;

    }

    prepareRmanCurrency3Object() {
        let rmanCurrency3TempObj: any = [{ label: appSettings.dropDownOptions.selectFunctional, value: null }];
        this.rmanCurrency3List.forEach((rmanCurrency3) => {
            rmanCurrency3TempObj.push({ label: rmanCurrency3.currencyCode, value: rmanCurrency3.currencyCode });
        });

        this.rmanCurrency3 = rmanCurrency3TempObj;

    }

    prepareRmanLookupsVObject() {
        let rmanLookupsVTempObj: any = [{ label: appSettings.dropDownOptions.selectFlagEnabled, value: null }];
        this.rmanLookupsVList.forEach((rmanLookupsV) => {
            rmanLookupsVTempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
        });

        this.rmanLookupsV = rmanLookupsVTempObj;

    }

    onBeforeToggle(evt: any) {
        this.collapsed = evt.collapsed;
    }

}


class RmanLegalEntitiesImpl {
    constructor(public reportingCurrency?: any, public defRevCogsId?: any, public lastUpdateDate?: any, public ledgerName?: any, public currencyCode?: any, public createdBy?: any, public attribute3?: any, public cogsAccountId?: any, public allocationCurrency?: any, public lastUpdatedBy?: any, public attribute2?: any, public attribute1?: any, public periodType?: any, public defRevAccountId?: any, public legalEntityId?: any, public roundingPrecision?: any, public revAccountId?: any, public defCogsAccountId?: any, public creationDate?: any, public enabledFlag?: any, public currencyFormat?: any, public attribute5?: any, public name?: any, public attribute4?: any, public locale?: any, public functionalCurrency?: any, public deferredCogs?: any, public calendar?: any, public defferedAccount?: any,
        public companyCode?: any, public description?: any) { }
}

interface ILabels {
    [index: string]: string;
}
