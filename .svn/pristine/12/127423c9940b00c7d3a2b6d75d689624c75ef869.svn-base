import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ConfirmationService, Message } from 'primeng/api';
import { Table } from 'primeng/table';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { NotificationService } from '../shared/notifications.service';
import { UploadService } from '../shared/upload.service';
import { RmanFiscalPeriods } from './rmanFiscalPeriods';
import { RmanFiscalPeriodsLabels } from './rmanFiscalPeriodsLabels';
import { RmanFiscalPeriodsService } from './rmanFiscalPeriodsservice';
import { CommonSharedService } from '../shared/common.service';


declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
    templateUrl: './rmanFiscalPeriods.component.html',
    selector: 'rmanFiscalPeriods-data',
    providers: [RmanFiscalPeriodsService, ConfirmationService]
})

export class RmanFiscalPeriodsComponent implements OnInit {

    displayDialog: boolean;

    displaySearchDialog: boolean;

    displayPeriodsDialog: boolean = false;

    uploadLoading: boolean = false;

    rmanFiscalPeriods: any = new RmanFiscalPeriodsImpl();
    rmanPeriods: any = new RmanFiscalPeriodsImpl();

    rmanFiscalPeriodsSearch: any = new RmanFiscalPeriodsImpl();

    isSerached: number = 0;

    cref: ChangeDetectorRef;

    showMsg: any;

    msgs: Message[] = [];



    selectedRmanFiscalPeriods: RmanFiscalPeriods;

    newRmanFiscalPeriods: boolean;

    rmanFiscalPeriodsList: any[];

    cols: any[];
    columnOptions: any[];

    paginationOptions: any;

    pages: {};

    datasource: any[];
    pageSize: number;
    totalElements: number;


    rmanLookupsVList: any[] = [];
    rmanLookupsV: any[];

    collapsed: boolean = true;
    loading: boolean;
    noData = appSettings.noData;


    fiscalPeriodsForm: FormGroup;

    isSelectAllChecked = true;
    globalCols: any[];
    clonedCols: any[];
    userId: number;
    showPaginator: boolean = true;
    startIndex: number;
    showAddColumns = true;
    columns: any[];

    constructor(private ref: ChangeDetectorRef, private rmanFiscalPeriodsService: RmanFiscalPeriodsService, private rmanLookupsVService: RmanLookupsVService, private confirmationService: ConfirmationService, private formBuilder: FormBuilder,
        private notificationService: NotificationService, public _uploadService: UploadService, private commonSharedService: CommonSharedService) {

        // generate list code
        this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
        this.loading = true;
        this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'RMAN_PERIOD_STATUS' }).then((rmanLookupsVList: any) => {
            this.loading = false;
            this.rmanLookupsVList = rmanLookupsVList.content;
            this.prepareRmanLookupsVObject();
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting "Period Status" data');
            this.loading = false;
        });

        this.cref = ref;


    }

    ngAfterViewChecked() {
        this.cref.detectChanges();
    }
    ngOnInit() {
        this.globalCols = [
            { field: 'periodStatus', header: 'Period Status', showField: true, drag: true, display: "table-cell", type: 'text' },
            { field: 'periodNum', header: 'Period Number', showField: true, drag: true, display: "table-cell", type: 'number' },
            { field: 'periodYear', header: 'Period Year', showField: true, drag: true, display: "table-cell", type: 'text' },
            { field: 'periodName', header: 'Period Name', showField: true, drag: true, display: "table-cell", type: 'text' },
            { field: 'ledgerName', header: 'Ledger Name', showField: true, drag: true, display: "table-cell", type: 'text' },
            { field: 'startDate', header: 'Start Date', showField: true, drag: true, display: "table-cell", type: 'date' },
            { field: 'endDate', header: 'End Date', showField: true, drag: true, display: "table-cell", type: 'date' }
        ];

        this.columns = [];
        this.getTableColumns("rmanFiscalPeriods", "Accounting Periods");
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
        this.commonSharedService.saveOrUpdateTableColumns("rmanFiscalPeriods", "Accounting Periods", selectedCols, this.userId).then((response) => {
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

    buildForm() {
        this.fiscalPeriodsForm = this.formBuilder.group({
            'periodNum': ['', [Validators.required, Validators.minLength(1), Validators.maxLength(12)]],
            'periodYear': ['', [Validators.required, Validators.pattern('^[0-9]*$'), Validators.minLength(4), Validators.maxLength(4)]],
            'periodName': ['', [Validators.required, Validators.minLength(6), Validators.maxLength(6)]],
            'quarterName': ['', [Validators.required, Validators.minLength(7), Validators.maxLength(7)]],
            'ledgerName': ['', [Validators.required, Validators.minLength(4), Validators.maxLength(30)]],
            'adjustmentPeriodFlag': ['', [Validators.required]],
            'quarterNum': ['', [Validators.required, Validators.minLength(1), Validators.maxLength(4)]],
        });

        this.fiscalPeriodsForm.valueChanges
            .subscribe(data => this.onValueChanged(data));

        this.onValueChanged();
    }

    onValueChanged(data?: any) {
        if (!this.fiscalPeriodsForm) { return; }
        const form = this.fiscalPeriodsForm;
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
        'periodNum': '', 'periodYear': '', 'periodName': '', 'quarterName': '',
        'ledgerName': '', 'adjustmentPeriodFlag': '', 'quarterNum': ''
    };

    validationMessages = {
        'periodNum': {
            'required': "Period number is required (minimum length is 1 and maximum length is 12 characters)",
            'minlength': 'Period number must be 1 character.',
            'maxlength': 'Period number must be 12 characters long.',
        },
        'periodYear': {
            'required': "Period year is Required (Must be 4 characters long)",
            'minlength': 'Period year must be 4 characters long.',
            'maxlength': 'Period year must be 4 characters long.',
            'pattern': 'Only number values are allowed [0-9] and'
        },
        'periodName': {
            'required': "Period name is required (Must be 6 characters long)",
            'minlength': 'Period name must be 6 characters long.',
            'maxlength': 'Period name must be 6 characters long.',
        },
        'quarterName': {
            'required': "Quarter name is required (Must be 7 characters long)",
            'minlength': 'Quarter name must be 7 characters long.',
            'maxlength': 'Quarter name must be 7 characters long.',
        },
        'ledgerName': {
            'required': "Ledger Name is Required (minimum length is 4 and maximum length is 30 characters)",
            'minlength': 'Ledger Name must be at least 4 characters long.',
            'maxlength': 'Ledger Name cannot be more than 30 characters long.',
        },
        'adjustmentPeriodFlag': {
            'required': "Adjustment period flag is required",
        },
        'quarterNum': {
            'required': "Quarter number is required (minimum length is 1 and maximum length is 4 characters)",
            'minlength': 'Quarter number must be 1 character.',
            'maxlength': 'Quarter number must be 4 characters long.',
        }
    }

    transformRmanLookupsV(rmanLookupsV: any) {
        if (rmanLookupsV)
            return rmanLookupsV.lookupDescription;
    }

    reset(dt: Table) {
        this.paginationOptions = {};
        this.rmanFiscalPeriods = new RmanFiscalPeriodsImpl();
        dt.reset();
    }


    getAllRmanFiscalPeriods() {
        this.loading = true;
        this.rmanFiscalPeriodsService.getAllRmanFiscalPeriods(this.paginationOptions, this.rmanFiscalPeriods).then((rmanFiscalPeriodsList: any) => {
            this.loading = false;
            this.datasource = rmanFiscalPeriodsList.content;
            this.rmanFiscalPeriodsList = rmanFiscalPeriodsList.content;
            this.totalElements = rmanFiscalPeriodsList.totalElements;
            this.pageSize = rmanFiscalPeriodsList.size;
            this.displaySearchDialog = false;
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
        });
    }


    getRmanFiscalPeriods(event: any) {

        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.loading = true;
        this.rmanFiscalPeriodsService.getAllRmanFiscalPeriods(this.paginationOptions, this.rmanFiscalPeriods).then((rmanFiscalPeriodsList: any) => {
            this.loading = false;
            this.datasource = rmanFiscalPeriodsList.content;
            this.rmanFiscalPeriodsList = rmanFiscalPeriodsList.content;
            this.totalElements = rmanFiscalPeriodsList.totalElements;
            this.pageSize = rmanFiscalPeriodsList.size;
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
        });

    }


    showDialogToAdd() {

        this.newRmanFiscalPeriods = true;
        this.rmanFiscalPeriods = new RmanFiscalPeriodsImpl();
        this.rmanFiscalPeriods.adjustmentPeriodFlag = 'N';
        this.displayDialog = true;
        this.prepareRmanLookupsVObject();
        this.buildForm();

    }

    cancelAddEdit() {
        this.rmanFiscalPeriods = new RmanFiscalPeriodsImpl();
        this.displayDialog = false;
    }



    save() {

        delete this.rmanFiscalPeriods['rmanLookupsV'];
        this.rmanPeriods = this.rmanFiscalPeriods;
        this.loading = true;
        if (this.newRmanFiscalPeriods) {
            this.rmanFiscalPeriodsService.validatePeriods(this.rmanFiscalPeriods).then((response: any) => {
                if (response != "success") {
                    this.loading = false;
                    this.notificationService.showError(response);
                } else if (response == "success") {
                    this.rmanFiscalPeriodsService.saveRmanFiscalPeriods(this.rmanPeriods).then((response: any) => {
                        this.loading = false;
                        this.notificationService.showSuccess('Saved succesfully');
                        this.getAllRmanFiscalPeriods();
                    })
                }
            }).catch((err: any) => {
                this.loading = false;
                this.notificationService.showError('Error occured while creating new fiscal period');

            });
        }
        //updating existing fiscal period
        else {
            this.loading = true;
            this.rmanFiscalPeriodsService.validatePeriods(this.rmanFiscalPeriods).then((response: any) => {
                if (response != "success") {
                    this.loading = false;
                    this.notificationService.showError(response);
                } else if (response == "success") {
                    this.rmanFiscalPeriodsService.updateRmanFiscalPeriods(this.rmanPeriods).then((response: any) => {
                        this.notificationService.showSuccess('Updated succesfully');
                        if (response.periodStatus == 'CLOSED') {
                            this.rmanFiscalPeriodsService.updateGlAcctsStatus(response.periodName).then((responseglupdate: any) => {
                                this.loading = false;
                            })
                        }
                        this.getAllRmanFiscalPeriods();
                    })
                }
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while updating the fiscal period');
                this.loading = false;
            });
        }
        this.displayDialog = false;
    }


    delete(rmanFiscalPeriods: any) {
        this.rmanFiscalPeriods = rmanFiscalPeriods;
        if (this.rmanFiscalPeriods.startDate) {
            this.rmanFiscalPeriods.startDate = new Date(this.rmanFiscalPeriods.startDate);
        }
        if (this.rmanFiscalPeriods.endDate) {
            this.rmanFiscalPeriods.endDate = new Date(this.rmanFiscalPeriods.endDate);
        }

        this.displayDialog = false;
        this.confirmationService.confirm({
            message: 'Are you sure you want to delete this record?',
            header: 'Confirmation',
            icon: '',
            accept: () => {
                this.rmanFiscalPeriodsList.splice(this.findSelectedRmanFiscalPeriodsIndex(), 1);
                this.loading = true;
                this.rmanFiscalPeriodsService.deleteRmanFiscalPeriods(this.rmanFiscalPeriods).then((response: any) => {
                    this.loading = false;
                    this.rmanFiscalPeriods = new RmanFiscalPeriodsImpl();
                    this.getAllRmanFiscalPeriods();
                });
                this.notificationService.showSuccess('Deleted succesfully');
            },
            reject: () => {
                this.notificationService.showWarning('You have rejected');
            }
        });
    }

    editRow(rmanFiscalPeriods: any) {
        this.newRmanFiscalPeriods = false;
        this.rmanFiscalPeriods = this.cloneRmanFiscalPeriods(rmanFiscalPeriods);
        if (this.rmanFiscalPeriods.startDate) {
            this.rmanFiscalPeriods.startDate = new Date(this.rmanFiscalPeriods.startDate);
        }
        if (this.rmanFiscalPeriods.endDate) {
            this.rmanFiscalPeriods.endDate = new Date(this.rmanFiscalPeriods.endDate);
        }
        if (this.rmanFiscalPeriods.startDate) {
            this.rmanFiscalPeriods.startDate = new Date(this.rmanFiscalPeriods.startDate);
        }
        if (this.rmanFiscalPeriods.quarterStartDate) {
            this.rmanFiscalPeriods.quarterStartDate = new Date(this.rmanFiscalPeriods.quarterStartDate);
        }
        if (this.rmanFiscalPeriods.yearStartDate) {
            this.rmanFiscalPeriods.yearStartDate = new Date(this.rmanFiscalPeriods.yearStartDate);
        }
        this.displayDialog = true;
        this.prepareRmanLookupsVObject();

    }

    onSelectStatus(event: any) {
        if (this.rmanFiscalPeriods.periodStatus == 'OPEN') {
            this.rmanFiscalPeriods.openFlag = 'Y';
        }
        else if (this.rmanFiscalPeriods.periodStatus == 'CLOSED') {
            this.rmanFiscalPeriods.openFlag = 'N';
        }

        else if (this.rmanFiscalPeriods.periodStatus == 'FUTURE') {
            this.rmanFiscalPeriods.openFlag = 'F';
        }

    }


    findSelectedRmanFiscalPeriodsIndex(): number {
        return this.rmanFiscalPeriodsList.indexOf(this.selectedRmanFiscalPeriods);
    }

    onRowSelect(event: any) {

    }

    cloneRmanFiscalPeriods(c: RmanFiscalPeriods): RmanFiscalPeriods {
        let rmanFiscalPeriods: any
            = new RmanFiscalPeriodsImpl();
        for (let prop in c) {
            rmanFiscalPeriods[prop] = c[prop];
        }
        return rmanFiscalPeriods;
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

        this.rmanFiscalPeriodsSearch = new RmanFiscalPeriodsImpl();

        if (this.isSerached == 0) {
            this.rmanFiscalPeriodsSearch = new RmanFiscalPeriodsImpl();
        }
        this.displaySearchDialog = true;

    }

    cancelSearch() {
        this.displaySearchDialog = false;
        this.rmanFiscalPeriodsSearch = new RmanFiscalPeriodsImpl();
    }

    search() {

        this.isSerached = 1;
        this.rmanFiscalPeriods = this.rmanFiscalPeriodsSearch;
        this.getAllRmanFiscalPeriods();
    }

    prepareRmanLookupsVObject() {
        let rmanLookupsVTempObj: any = [{ label: appSettings.dropDownOptions.SelectPeriodStatus, value: null }];
        this.rmanLookupsVList.forEach((rmanLookupsV) => {
            rmanLookupsVTempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
        });

        this.rmanLookupsV = rmanLookupsVTempObj;

    }

    onBeforeToggle(evt: any) {
        this.collapsed = evt.collapsed;
    }

    fileUploadHandler(event: any, url: any) {
        this._uploadService.processUpload(event, url);
    }

    showUploadLoader() {
        this._uploadService.uploadLoading = true;
        this.uploadLoading = true;
    }

    importFile() {
        this._uploadService.uploadDialog = true;
        this.displayPeriodsDialog = true;
    }

    cancelPeriodsUpload() {
        this._uploadService.uploadDialog = false;
        this.displayPeriodsDialog = false;
    }

    onPeriodsUpload(event: any) {
        this.notificationService.showSuccess('File Uploaded successfully');
        this.displayPeriodsDialog = false;
        this.uploadLoading = false;

    }
    onErrorPeriodsFileupload(event: any) {

        this.displayPeriodsDialog = false;
        this.uploadLoading = false;
        let msg: string = "";
        msg += event.files[0].name + " file upload process failed due to ";
        if (event.xhr.response) {
            msg += JSON.parse(event.xhr.response).message
        }
        this.notificationService.showError(msg);
    }

}


class RmanFiscalPeriodsImpl {
    constructor(public quarterStartDate?: any, public createdBy?: any, public lastUpdatedBy?: any, public periodYear?: any, public adjustmentPeriodFlag?: any, public creationDate?: any, public endDate?: any, public startDate?: any, public quarterNum?: any, public sourcePeriodId?: any, public lastUpdateDate?: any, public periodNum?: any, public ledgerName?: any, public quarterName?: any, public periodName?: any, public enteredPeriodName?: any, public periodStatus?: any, public yearStartDate?: any, public rmanPeriodId?: any, public openFlag?: any) { }
}

interface ILabels {
    [index: string]: string;
}
