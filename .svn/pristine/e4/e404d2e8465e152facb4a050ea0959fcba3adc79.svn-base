import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ConfirmationService, Message } from 'primeng/api';
import { Table } from 'primeng/table';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanLookupCodes } from './rmanLookupCodes';
import { RmanLookupCodesLabels } from './rmanLookupCodesLabels';
import { RmanLookupCodesService } from './rmanLookupCodesservice';
declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');
@Component({
    templateUrl: './rmanLookupCodes.component.html',
    selector: 'rmanLookupCodes-data',
    providers: [RmanLookupCodesService, ConfirmationService]
})

export class RmanLookupCodesComponent implements OnInit {

    displayDialog: boolean;

    displaySearchDialog: boolean;

    displayConfirmation: boolean;
    noData = appSettings.noData;
    rmanLookupCodes: any = new RmanLookupCodesImpl();

    rmanLookupCodesSearch: any = new RmanLookupCodesImpl();

    isSerached: number = 0;

    msgs: Message[] = [];

    

    selectedRmanLookupCodes: RmanLookupCodes;

    pLookupTypeName: any;

    newRmanLookupCodes: boolean;

    rmanLookupCodesList: any[] = [];

    cols: any[];
    lookupCodeColumns: ILabels;

    columnOptions: any[];

    paginationOptions: any;

    pages: {};

    datasource: any[];
    pageSize: number;
    totalElements: number;

    rmanLookupsVList: any[] = [];
    rmanLookupsV: any[];

    collapsed: boolean = true;

    lookupCodesForm: FormGroup;
    loading: boolean;
    masterData: any;

    isSelectAllChecked = true;
    globalCols: any[];
    clonedCols: any[];
    userId: number;
    showPaginator: boolean = true;
    startIndex: number;
    showAddColumns = true;
    columns: any[];

    constructor(private rmanLookupCodesService: RmanLookupCodesService, private rmanLookupsVService: RmanLookupsVService, private formBuilder: FormBuilder, private confirmationService: ConfirmationService,
        private notificationService: NotificationService, private commonSharedService: CommonSharedService) {

        // generate list code
        this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
        this.loading = true;
        this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'ENABLED_FLAG' }).then((rmanLookupsVList: any) => {
            this.loading = false;
            this.rmanLookupsVList = rmanLookupsVList.content;
            this.prepareRmanLookupsVObject();
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting "Enabled Flag" data');
            this.loading = false;
        });

    }

    ngOnInit() {

        this.globalCols = [
            { field: 'lookupTypeCode', header: 'Lookup Type Code', showField: true, drag: false, display: "table-cell", type: 'text' },
            { field: 'lookupCode', header: 'Lookup Code', showField: true, drag: false, display: "table-cell", type: 'text' },
            { field: 'description', header: 'Description', showField: true, drag: false, display: "table-cell", type: 'text' },
            { field: 'enabledFlag', header: 'Enabled Flag', showField: true, drag: true, display: "table-cell", type: 'text' },
            { field: 'startDateActive', header: 'Start Date', showField: true, drag: true, display: "table-cell", type: 'date' },
            { field: 'endDateActive', header: 'End Date', showField: true, drag: true, display: "table-cell", type: 'date' },
            { field: 'createdBy', header: 'Created By', showField: true, drag: true, display: "table-cell", type: 'number' },
            { field: 'lastUpdateDate', header: 'Last Updated Date', showField: true, drag: true, display: "table-cell", type: 'date' },
            { field: 'lastUpdatedBy', header: 'Last Updated By', showField: true, drag: true, display: "table-cell", type: 'number' }
        ];

        this.columns = [];
        this.getTableColumns("rmanLookups", "Lookup Codes");

        let rmanLookupCodesLabels = new RmanLookupCodesLabels();
        this.lookupCodeColumns = rmanLookupCodesLabels.fieldLabels;
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
        this.commonSharedService.saveOrUpdateTableColumns("rmanLookups", "Lookup Codes", selectedCols, this.userId).then((response) => {
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
        this.lookupCodesForm = this.formBuilder.group({
            'typeCode': ['', [Validators.required]],
            'code': ['', [Validators.required]],
            'flag': ['', [Validators.required]],
            'startDate': ['', [Validators.required]]
        });

        this.lookupCodesForm.valueChanges
            .subscribe(data => this.onValueChanged(data));

        this.onValueChanged();
    }

    onValueChanged(data?: any) {
        if (!this.lookupCodesForm) { return; }
        const form = this.lookupCodesForm;

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
        'typeCode': '', 'code': '', 'flag': '', 'startDate': ''/* ,'workspacedbPort':'','workspacedbUser':'' */
    };

    validationMessages = {
        'typeCode': {
            'required': "Lookup Type Code is required"
        }, 'code': {
            'required': "Lookup Code is required"
        },
        'flag': {
            'required': "Enabled Flag is required"
        },
        'startDate': {
            'required': "Start Date Active is required"
        }
    }

    transformRmanLookupsV(rmanLookupsV: any) {
        if (rmanLookupsV)
            return rmanLookupsV.lookupDescription;
    }


    getAllRmanLookupCodes(searchObj?: any) {
        let data;
        if (searchObj) {
            data = searchObj;

        } else {
            data = { 'lookupTypeCode': this.pLookupTypeName }
        }
        this.loading = true;
        if ((this.pLookupTypeName) && (this.pLookupTypeName != null)) {
            this.rmanLookupCodesService.getAllRmanLookupCodes(this.paginationOptions, data).then((rmanLookupCodesList: any) => {
                this.loading = false;
                this.datasource = rmanLookupCodesList.content;
                if ((this.pLookupTypeName) && (this.pLookupTypeName != null)) {
                    this.rmanLookupCodesList = rmanLookupCodesList.content;
                } else {
                    this.rmanLookupCodesList = [];
                }
                this.totalElements = rmanLookupCodesList.totalElements;
                this.pageSize = rmanLookupCodesList.size;
                this.displaySearchDialog = false;
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while getting data');
                this.loading = false;
            });
        }

    }
    ParentCall(data) {
        this.masterData = data;
        if (data !== '' && data) {
            this.pLookupTypeName = data.lookupTypeName;
            this.getAllRmanLookupCodes();
        } else {
            this.pLookupTypeName = null;
            this.rmanLookupCodesList = [];
        }
    }


    getRmanLookupCodes(event: any) {

        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.loading = true;
        if ((this.pLookupTypeName) && (this.pLookupTypeName != null)) {
            this.rmanLookupCodesService.getAllRmanLookupCodes(this.paginationOptions, { 'lookupTypeCode': this.pLookupTypeName }).then((rmanLookupCodesList: any) => {
                this.loading = false;
                this.datasource = rmanLookupCodesList.content;
                this.rmanLookupCodesList = rmanLookupCodesList.content;
                this.totalElements = rmanLookupCodesList.totalElements;
                this.pageSize = rmanLookupCodesList.size;
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while getting data');
                this.loading = false;
            });
        }

    }



    showDialogToAdd() {

        this.newRmanLookupCodes = true;
        this.rmanLookupCodes = new RmanLookupCodesImpl();
        this.lookupCodesForm.get('typeCode').enable();
        this.lookupCodesForm.get('code').enable();
        if (this.pLookupTypeName == null || this.pLookupTypeName == 0) {
            this.displayDialog = false;
            this.notificationService.showInfo('Please select a Lookup Type');
            this.displayConfirmation = true;
        }
        else {
            this.rmanLookupCodes.lookupTypeCode = this.pLookupTypeName;
            this.displayDialog = true;
            this.prepareRmanLookupsVObject();

        }
    }


    save() {

        if (this.newRmanLookupCodes) {
            this.loading = true;
            this.rmanLookupCodesService.saveRmanLookupCodes(this.rmanLookupCodes).then((response: any) => {
                this.notificationService.showSuccess('Saved successfully');
                this.getAllRmanLookupCodes();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while saving data');
                this.loading = false;
            });
        }
        else {
            this.loading = true;
            this.rmanLookupCodesService.updateRmanLookupCodes(this.rmanLookupCodes).then((response: any) => {
                this.notificationService.showSuccess('Updated successfully');
                this.getAllRmanLookupCodes();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while updating data');
                this.loading = false;
            });
        }

        this.rmanLookupCodes = new RmanLookupCodesImpl();

        this.displayDialog = false;

    }

    delete(rmanLookupCodes: any) {
        this.rmanLookupCodes = rmanLookupCodes;
        if (this.rmanLookupCodes.endDateActive) {
            this.rmanLookupCodes.endDateActive = new Date(this.rmanLookupCodes.endDateActive);
        }
        if (this.rmanLookupCodes.startDateActive) {
            this.rmanLookupCodes.startDateActive = new Date(this.rmanLookupCodes.startDateActive);
        }
        if (this.rmanLookupCodes.lastUpdateDate) {
            this.rmanLookupCodes.lastUpdateDate = new Date(this.rmanLookupCodes.lastUpdateDate);
        }
        this.displayDialog = false;

        this.confirmationService.confirm({
            message: 'Are you sure you want to delete this record?',
            header: 'Confirmation',
            icon: '',
            accept: () => {
                this.rmanLookupCodesList.splice(this.findSelectedRmanLookupCodesIndex(), 1);
                this.loading = true;
                this.rmanLookupCodesService.deleteRmanLookupCodes(this.rmanLookupCodes).then((response: any) => {
                    this.rmanLookupCodes = new RmanLookupCodesImpl();
                    this.getAllRmanLookupCodes();
                });
                this.notificationService.showSuccess('Deleted successfully');
            },
            reject: () => {
                this.notificationService.showWarning('You have rejected');
            }
        });
    }

    editRow(rmanLookupCodes: any) {
        this.newRmanLookupCodes = false;
        this.rmanLookupCodes = this.cloneRmanLookupCodes(rmanLookupCodes);
        if (this.rmanLookupCodes.endDateActive) {
            this.rmanLookupCodes.endDateActive = new Date(this.rmanLookupCodes.endDateActive);
        }
        if (this.rmanLookupCodes.startDateActive) {
            this.rmanLookupCodes.startDateActive = new Date(this.rmanLookupCodes.startDateActive);
        }
        if (this.rmanLookupCodes.lastUpdateDate) {
            this.rmanLookupCodes.lastUpdateDate = new Date(this.rmanLookupCodes.lastUpdateDate);
        }
        this.displayDialog = true;
        this.lookupCodesForm.get('typeCode').disable();
        this.prepareRmanLookupsVObject();

    }


    findSelectedRmanLookupCodesIndex(): number {
        return this.rmanLookupCodesList.indexOf(this.selectedRmanLookupCodes);
    }

    onRowSelect(event: any) {

    }

    cloneRmanLookupCodes(c: RmanLookupCodes): RmanLookupCodes {
        let rmanLookupCodes: any
            = new RmanLookupCodesImpl();
        for (let prop in c) {
            rmanLookupCodes[prop] = c[prop];
        }
        return rmanLookupCodes;
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
        this.rmanLookupCodesSearch = new RmanLookupCodesImpl();
        this.displaySearchDialog = true;
    }
    reset(dt: Table) {
        this.paginationOptions = {};
        this.rmanLookupCodes = new RmanLookupCodesImpl();
        dt.reset();
    }

    search() {

        this.isSerached = 1;
        this.rmanLookupCodesSearch.lookupTypeCode = this.pLookupTypeName;
        this.rmanLookupCodes = this.rmanLookupCodesSearch;
        this.paginationOptions = {};
        this.getAllRmanLookupCodes(this.rmanLookupCodes);
    }

    cancelAddEdit() {
        this.displayDialog = false;
        this.rmanLookupCodes = new RmanLookupCodesImpl();
    }

    prepareRmanLookupsVObject() {
        let rmanLookupsVTempObj: any = [{ label: appSettings.dropDownOptions.selectEnabledFlag, value: null }];
        this.rmanLookupsVList.forEach((rmanLookupsV) => {
            rmanLookupsVTempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
        });

        this.rmanLookupsV = rmanLookupsVTempObj;

    }

    onBeforeToggle(evt: any) {
        this.collapsed = evt.collapsed;
    }
}


class RmanLookupCodesImpl {
    constructor(public attribute3?: any, public createdBy?: any, public attribute2?: any, public lastUpdatedBy?: any, public startDateActive?: any, public attribute1?: any, public lookupCode?: any, public creationDate?: any, public enabledFlag?: any, public lastUpdateDate?: any, public attribute5?: any, public attribute4?: any, public description?: any, public lookupTypeCode?: any, public endDateActive?: any, public seededFlag?: any, public lookupId?: any) { }
}

interface ILabels {
    [index: string]: string;
}
