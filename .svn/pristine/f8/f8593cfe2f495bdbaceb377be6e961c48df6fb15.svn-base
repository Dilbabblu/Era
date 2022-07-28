import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Table } from 'primeng/table';
import { RmanCurrencyService } from '../rmanCurrency/rmanCurrencyservice';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { NotificationService } from '../shared/notifications.service';
import { UploadService } from '../shared/upload.service';
import { RmanConversionRates } from './rmanConversionRates';
import { RmanConversionRatesLabels } from './rmanConversionRatesLabels';
import { RmanConversionRatesService } from './rmanConversionRatesservice';
import { CommonSharedService } from '../shared/common.service';

declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');


@Component({
    templateUrl: './rmanConversionRates.component.html',
    selector: 'rmanConversionRates-data',
    providers: [RmanConversionRatesService, RmanCurrencyService]
})

export class RmanConversionRatesComponent {

    displayConvRatesImportDialog: boolean = false;

    displayDialog: boolean;

    displaySearchDialog: boolean;

    uploadLoading: boolean = false;

    rmanConversionRates: any = new RmanConversionRatesImpl();

    rmanConversionRatesSearch: any = new RmanConversionRatesImpl();

    isSerached: number = 0;

    selectedRmanConversionRates: RmanConversionRates;

    newRmanConversionRates: boolean;

    rmanConversionRatesList: RmanConversionRates[];

    cols: any[];
    columnOptions: any[];

    paginationOptions = {};

    pages: {};

    collapsed: boolean = true;

    datasource: any[];
    pageSize: number;
    totalElements: number;
    rmanCurrencyList: any[] = [];
    rmanFromCurrencyList: any[] = [];
    rmanToCurrencyList: any[] = [];
    rmanCurrency: any[];
    conversionRatesForm: FormGroup;

    isSelectAllChecked = true;
    globalCols: any[];
    clonedCols: any[];
    userId: number;
    showPaginator: boolean = true;
    startIndex: number;
    showAddColumns = true;
    columns: any[];
    exportCols: string[] = [];

    statusList: any = [
        { label: appSettings.dropDownOptions.SelectStatus, value: null },
        { label: 'Active', value: 'Active' },
        { label: 'Inactive', value: 'Inactive' }
    ];
    loading: boolean;
    noData = appSettings.noData;

    rmanLookupsVList: any[] = [];
    rmanLookupsV: any[];
    rmanLookupsV2List: any[] = [];
    rmanLookupsV2: any[];

    constructor(private formBuilder: FormBuilder, private rmanCurrencyService: RmanCurrencyService, private rmanConversionRatesService: RmanConversionRatesService, private notificationService: NotificationService,
        public _uploadService: UploadService, private rmanLookupsVService: RmanLookupsVService, private commonSharedService: CommonSharedService) {

        // generate list code
        this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
        this.loading = true;
        this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'Record_Status' }).then((rmanLookupsVList: any) => {
            this.rmanLookupsVList = rmanLookupsVList.content;
            this.preparermanLookupsVObject();
        });
        this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'CONVERSION_TYPE' }).then((rmanLookupsV2List: any) => {
            this.rmanLookupsV2List = rmanLookupsV2List.content;
            this.preparermanLookupsV2Object();
        });
        this.rmanCurrencyService.getAllRmanCurrency(this.paginationOptions, {}).then((rmanCurrencyList: any) => {
            this.rmanCurrencyList = rmanCurrencyList.content;
            this.prepareCurrencyListObject();
            this.loading = false;
        });
    }



    ngOnInit() {
        this.globalCols = [
            { field: 'fromCurrency', header: 'From Currency', showField: true, drag: true, display: "table-cell", type: 'text' },
            { field: 'toCurrency', header: 'To Currency', showField: true, drag: true, display: "table-cell", type: 'text' },
            { field: 'conversionType', header: 'Conversion Type', showField: true, drag: true, display: "table-cell", type: 'text' },
            { field: 'conversionRate', header: 'Conversion Rate', showField: true, drag: true, display: "table-cell", type: 'number' },
            { field: 'conversionDate', header: 'Effective Date', showField: true, drag: true, display: "table-cell", type: 'date' },
            { field: 'conversionStartDate', header: 'Start Date', showField: true, drag: true, display: "table-cell", type: 'date' },
            { field: 'conversionEndDate', header: 'End Date', showField: true, drag: true, display: "table-cell", type: 'date' },
            { field: 'statusCode', header: 'Status Code', showField: true, drag: true, display: "table-cell", type: 'text' }

        ];

        this.columns = [];
        this.getTableColumns("rmanConversionRates", "Conversion Rates");
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
        this.commonSharedService.saveOrUpdateTableColumns("rmanConversionRates", "Conversion Rates", selectedCols, this.userId).then((response) => {
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


    preparermanLookupsVObject() {
        let rmanLookupsVTempObj: any = [{ label: appSettings.dropDownOptions.selectItemStatus, value: null }];
        this.rmanLookupsVList.forEach((rmanLookupsV) => {
            rmanLookupsVTempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
        });
        this.rmanLookupsV = rmanLookupsVTempObj;
    }

    preparermanLookupsV2Object() {
        let rmanLookupsV2TempObj: any = [{ label: appSettings.dropDownOptions.selectConversionType, value: null }];
        this.rmanLookupsV2List.forEach((rmanLookupsV) => {
            rmanLookupsV2TempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
        });
        this.rmanLookupsV2 = rmanLookupsV2TempObj;
    }

    onConversionTypeChange(event:any){
        console.log(this.conversionRatesForm.controls['conversionType'].value);
        if (this.conversionRatesForm.controls['conversionType'].value == 'SPOT') {
            this.conversionRatesForm.get('conversionDate').setValidators([Validators.required]);
            this.conversionRatesForm.get('statusCode').setValidators([Validators.required]);
            this.conversionRatesForm.get('conversionDate').enable();
            this.conversionRatesForm.get('statusCode').enable();
            this.conversionRatesForm.get('conversionStartDate').clearValidators();
            this.conversionRatesForm.get('conversionEndDate').clearValidators();
            this.conversionRatesForm.get('conversionStartDate').disable();
            this.conversionRatesForm.get('conversionEndDate').disable();
            this.conversionRatesForm.patchValue({
                conversionEndDate: '',
                conversionStartDate: ''
              });
            this.conversionRatesForm.updateValueAndValidity();
        }else if (this.conversionRatesForm.controls['conversionType'].value == 'CORPORATE'){
            this.conversionRatesForm.get('conversionStartDate').setValidators([Validators.required]);
            this.conversionRatesForm.get('conversionEndDate').setValidators([Validators.required]);
            this.conversionRatesForm.get('statusCode').setValidators([Validators.required]);
            this.conversionRatesForm.get('conversionStartDate').enable();
            this.conversionRatesForm.get('conversionEndDate').enable();
            this.conversionRatesForm.get('statusCode').enable();
            this.conversionRatesForm.get('conversionDate').clearValidators();
            this.conversionRatesForm.get('conversionDate').disable();
            this.conversionRatesForm.patchValue({
                conversionDate: ''
              });
            this.conversionRatesForm.updateValueAndValidity();
        }
    }

    getAllRmanConversionRates() {
        this.loading = true;
        this.rmanConversionRatesService.getAllRmanConversionRates(this.paginationOptions, this.rmanConversionRates, this.exportCols).then((rmanConversionRatesList: any) => {
            this.datasource = rmanConversionRatesList.content;
            this.rmanConversionRatesList = rmanConversionRatesList.content;
            this.totalElements = rmanConversionRatesList.totalElements;
            this.pageSize = rmanConversionRatesList.size;
            this.displaySearchDialog = false;
            this.loading = false;
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting  data');
            this.loading = false;
        });
    }

    reset(dt: Table) {
        this.paginationOptions = {};
        this.rmanConversionRates = new RmanConversionRatesImpl();
        dt.reset();
    }


    getRmanConversionRates(event: any) {
        this.loading = true;
        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.rmanConversionRatesService.getAllRmanConversionRates(this.paginationOptions, this.rmanConversionRates, this.exportCols).then((rmanConversionRatesList: any) => {
            this.datasource = rmanConversionRatesList.content;
            this.rmanConversionRatesList = rmanConversionRatesList.content;
            this.totalElements = rmanConversionRatesList.totalElements;
            this.pageSize = rmanConversionRatesList.size;
            this.loading = false;
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting  data');
            this.loading = false;
        });

    }

    buildForm() {
        this.conversionRatesForm = this.formBuilder.group({
            'fromCurrency': ['', [Validators.required]],
            'toCurrency': ['', [Validators.required]],
            'conversionType': ['', [Validators.required, Validators.minLength(4), Validators.maxLength(10)]],
            'conversionRate': ['', [Validators.required, Validators.pattern(/^[0-9]+(.[0-9]{0,2})?$/)]],
            'conversionDate': ['', [Validators.required]],
            'statusCode': ['', [Validators.required]],
            'conversionStartDate': [''],
            'conversionEndDate': ['']
        });

        this.conversionRatesForm.valueChanges
            .subscribe(data => this.onValueChanged(data));

        this.onValueChanged();
    }

    onValueChanged(data?: any) {
        if (!this.conversionRatesForm) { return; }
        const form = this.conversionRatesForm;

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
        'fromCurrency': '', 'toCurrency': '', 'conversionType': '', 'conversionRate': '', 'conversionDate': '', 'statusCode': ''
    };

    validationMessages = {
        'fromCurrency': {
            'required': "From Currency is required"
        },
        'toCurrency': {
            'required': "To Currency is Required"
        },
        'conversionType': {
            'required': "Conversion Type is Required (minimum length is 4 and maximum length is 10 characters)",
            'minlength': 'Conversion Type must be at least 4 characters long.',
            'maxlength': 'Conversion Type cannot be more than 10 characters long.',
        },
        'conversionRate': {
            'required': "Conversion Rate is Required (Only number values are allowed [0-9] )",
            'pattern': 'Only number values are allowed [0-9]'
        },
        'conversionDate': {
            'required': "Effective date is Required"
        },
        'statusCode': {
            'required': "Status Code is Required"
        }
    }

    importFile() {
        this._uploadService.uploadDialog = true;
        this.displayConvRatesImportDialog = true;
    }

    showUploadLoader() {
        this.uploadLoading = true;
    }

    fileUploadHandler(event: any, url: any) {
        this._uploadService.processUpload(event, url);
    }

    onConvRatesUpload(event: any) {
        this.notificationService.showSuccess('File Uploaded successfully');

        this.displayConvRatesImportDialog = false;
        this.uploadLoading = false;
    }

    onErrorConvRatesFileupload(event: any) {

        this.displayConvRatesImportDialog = false;
        this.uploadLoading = false;
        let msg: string = "";
        msg += event.files[0].name + " file upload process failed due to ";
        if (event.xhr.response) {
            msg += JSON.parse(event.xhr.response).message
        }
        this.notificationService.showError(msg);
    }

    cancelConversionRatesUpload() {
        this._uploadService.uploadDialog = false;
        this.displayConvRatesImportDialog = false;
    }

    showDialogToAdd() {

        this.newRmanConversionRates = true;
        this.rmanConversionRates = new RmanConversionRatesImpl();
        this.displayDialog = true;
        this.buildForm();
    }

    cancelAddEdit() {
        this.rmanConversionRates = new RmanConversionRatesImpl();
        this.displayDialog = false;
    }


    save() {

        if (this.newRmanConversionRates) {
            this.loading = true;
            this.rmanConversionRatesService.saveRmanConversionRates(this.rmanConversionRates).then((response: any) => {
                this.getAllRmanConversionRates();
                this.notificationService.showSuccess('Saved successfully');
                this.loading = false;
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while saving  data');
                this.loading = false;
            });

        }
        else {
            this.loading = true;
            this.rmanConversionRatesService.updateRmanConversionRates(this.rmanConversionRates).then((response: any) => {
                this.getAllRmanConversionRates();
                this.notificationService.showError('Error occured while saving data');
                this.loading = false;
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while saving data');
                this.loading = false;
            });
        }

        this.rmanConversionRates = new RmanConversionRatesImpl();

        this.displayDialog = false;

    }

    exportExcel() {
        this.loading = true;
        this.exportCols = [];
        for (let index = 0; index < this.columns.length; index++) {
            if (this.columns[index].showField) {
                this.exportCols.push(this.columns[index].field);
            }
        }
        let serviceUrl = this.rmanConversionRatesService.getServiceUrl(this.paginationOptions, this.rmanConversionRates, this.exportCols, 1);
        this.loading = false;
        window.location.href = serviceUrl;
    }


    delete(rmanConversionRates: any) {
        this.rmanConversionRates = rmanConversionRates;
        this.displayDialog = false;
        if (window.confirm('Are you sure you want to delete this record?')) {
            this.rmanConversionRatesList.splice(this.findSelectedRmanConversionRatesIndex(), 1);
            this.rmanConversionRatesService.deleteRmanConversionRates(this.rmanConversionRates).then(response => {
                this.rmanConversionRates = new RmanConversionRatesImpl();
                this.getAllRmanConversionRates();
            });
        }

    }

    editRow(rmanConversionRates: any) {
        this.newRmanConversionRates = false;
        this.rmanConversionRates = this.cloneRmanConversionRates(rmanConversionRates);
        this.displayDialog = true;
    }


    findSelectedRmanConversionRatesIndex(): number {
        return this.rmanConversionRatesList.indexOf(this.selectedRmanConversionRates);
    }

    onRowSelect(event: any) {

    }

    cloneRmanConversionRates(c: RmanConversionRates): RmanConversionRates {
        let rmanConversionRates: any = new RmanConversionRatesImpl();
        for (let prop in c) {
            rmanConversionRates[prop] = c[prop];
        }
        return rmanConversionRates;
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

        this.rmanConversionRatesSearch = new RmanConversionRatesImpl();

        if (this.isSerached == 0) {
            this.rmanConversionRatesSearch = new RmanConversionRatesImpl();
        }
        this.displaySearchDialog = true;

    }

    cancelSearch() {
        this.displaySearchDialog = false;
        this.rmanConversionRatesSearch = new RmanConversionRatesImpl();
    }

    onBeforeToggle(evt: any) {
        this.collapsed = evt.collapsed;
    }

    search() {
        this.paginationOptions = {};
        this.isSerached = 1;
        this.rmanConversionRates = this.rmanConversionRatesSearch;
        this.getAllRmanConversionRates();
    }

    prepareCurrencyListObject() {
        let rmanCurrencyTempObj: any[] = []
        this.rmanCurrencyList.forEach((rmanCurrency) => {
            rmanCurrencyTempObj.push({ label: rmanCurrency.currencyCode, value: rmanCurrency.currencyCode })
        });
        this.rmanFromCurrencyList = [...rmanCurrencyTempObj];
        this.rmanToCurrencyList = [...rmanCurrencyTempObj];
        this.rmanFromCurrencyList.unshift({ label: appSettings.dropDownOptions.selectFromCurrency, value: null });
        this.rmanToCurrencyList.unshift({ label: appSettings.dropDownOptions.selectToCurrency, value: null });
    }

}


class RmanConversionRatesImpl {
    constructor(public attribute10?: any, public conversionStartDate?: any, public attribute14?: any, public attribute13?: any, public createdDate?: any, public attribute12?: any, public attribute11?: any, public conversionType?: any, public toCurrency?: any, public attribute3?: any, public createdBy?: any, public attribute2?: any, public lastUpdatedBy?: any, public attribute1?: any, public conversionRate?: any, public attribute9?: any, public attribute8?: any, public attribute7?: any, public attribute6?: any, public attribute5?: any, public attribute4?: any, public lastUpdatedDate?: any, public fromCurrency?: any, public attribute15?: any, public conversionEndDate?: any, public conversionDate?: any, public statusCode?: any) { }
}

interface ILabels {
    [index: string]: string;
}