import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ConfirmationService, Message } from 'primeng/api';
import { Table } from 'primeng/table';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { RmanResponsibilitiesService } from '../rmanResponsibilities/rmanResponsibilitiesservice';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanUserResponsibilities } from './rmanUserResponsibilities';
import { RmanUserResponsibilitiesLabels } from './rmanUserResponsibilitiesLabels';
import { RmanUserResponsibilitiesService } from './rmanUserResponsibilitiesservice';
declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
    templateUrl: './rmanUserResponsibilities.component.html',
    selector: 'rmanUserResponsibilities-data',
    providers: [RmanUserResponsibilitiesService, RmanResponsibilitiesService, ConfirmationService]
})

export class RmanUserResponsibilitiesComponent implements OnInit {

    displayDialog: boolean;

    displayConfirmation: boolean;

    displaySearchDialog: boolean;

    rmanUserResponsibilities: any = new RmanUserResponsibilitiesImpl();

    rmanUserResponsibilitiesSearch: any = new RmanUserResponsibilitiesImpl();

    isSerached: number = 0;

    showMsg: any;

    msgs: Message[] = [];
    noData = appSettings.noData;
    

    selectedRmanUserResponsibilities: RmanUserResponsibilities;

    newRmanUserResponsibilities: boolean;

    pRmanUserId: number;

    rmanUserResponsibilitiesList: any[];

    cols: any[];
    userResponsibilityColumns: ILabels;

    columnOptions: any[];

    paginationOptions: any;

    pages: {};

    datasource: any[];
    pageSize: number;
    totalElements: number;


    rmanResponsibilitiesList: any[];
    rmanResponsibilities: any[];

    rmanLookupsVList: any[] = [];
    rmanLookupsV: any[];

    collapsed: boolean = true;

    userResponsibilitiesForm: FormGroup;
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

    constructor(private rmanUserResponsibilitiesService: RmanUserResponsibilitiesService, private rmanResponsibilitiesService: RmanResponsibilitiesService, private formBuilder: FormBuilder, private confirmationService: ConfirmationService, private rmanLookupsVService: RmanLookupsVService,
        private notificationService: NotificationService, private commonSharedService: CommonSharedService) {

        // generate list code
        this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
        this.loading = true;
        this.rmanResponsibilitiesService.getAllRmanResponsibilities(this.paginationOptions, {}).then((rmanResponsibilitiesList: any) => {
            this.rmanResponsibilitiesList = rmanResponsibilitiesList.content;
            this.prepareRmanResponsibilitiesObject();
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting "Responsibility ID" data');
            this.loading = false;
        });

        this.loading = true;
        this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'ENABLED_FLAG' }).then((rmanLookupsVList: any) => {
            this.rmanLookupsVList = rmanLookupsVList.content;
            this.prepareRmanLookupsVObject();
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting "Enabled Flag" data');
            this.loading = false;
        });
    }

    prepareRmanLookupsVObject() {
        let rmanLookupsVTempObj: any = [{ label: appSettings.dropDownOptions.selectEnabledFlag, value: null }];
        this.rmanLookupsVList.forEach((rmanLookupsV) => {
            rmanLookupsVTempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
        });
        this.rmanLookupsV = rmanLookupsVTempObj;

    }

    parentCall(data) {
        this.masterData = data;
        if (data && data != '') {
            this.pRmanUserId = data.rmanUserId;
            this.getAllRmanUserResponsibilities();

        } else {
            this.pRmanUserId = null;
            this.rmanUserResponsibilitiesList = [];
        }
    }
    cancelSearch() {
        this.displaySearchDialog = false;
        this.rmanUserResponsibilities = new RmanUserResponsibilitiesImpl();
    }
    cancelEdit() {
        this.displayDialog = false;
        this.rmanUserResponsibilitiesSearch = new RmanUserResponsibilitiesImpl();
    }

    ngOnInit() {

        this.globalCols = [
            { field: 'responsibilityId', header: 'Responsibility Name', showField: true, drag: false, display: "table-cell", type: 'text' },
            { field: 'startDateActive', header: 'Start Date', showField: true, drag: true, display: "table-cell", type: 'date' },
            { field: 'endDateActive', header: 'End Date', showField: true, drag: true, display: "table-cell", type: 'date' },
            { field: 'enabledFlag', header: 'Enabled Flag', showField: true, drag: true, display: "table-cell", type: 'text' },
        ];

        this.columns = [];
        this.getTableColumns("rmanUsers", "User Responsibilities");

        let rmanUserResponsibilitiesLabels = new RmanUserResponsibilitiesLabels();
        this.userResponsibilityColumns = rmanUserResponsibilitiesLabels.fieldLabels;
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
        this.commonSharedService.saveOrUpdateTableColumns("rmanUsers", "User Responsibilities", selectedCols, this.userId).then((response) => {
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
        this.rmanUserResponsibilities = new RmanUserResponsibilitiesImpl();
        dt.reset();
    }

    buildForm() {
        this.userResponsibilitiesForm = this.formBuilder.group({
            'rID': ['', [
                Validators.required
            ]
            ],
            'startDate': ['', [Validators.required]],
            'flag': ['', [Validators.required]]
        });

        this.userResponsibilitiesForm.valueChanges
            .subscribe(data => this.onValueChanged(data));

        this.onValueChanged();
    }

    onValueChanged(data?: any) {
        if (!this.userResponsibilitiesForm) { return; }
        const form = this.userResponsibilitiesForm;

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
        'rID': '', 'startDate': '', 'flag': ''/* ,'workspacedbName':'','workspacedbPass':'','workspacedbPort':'','workspacedbUser':'' */
    };

    validationMessages = {
        'rID': {
            'required': "Responsibility ID is required"
        }, 'startDate': {
            'required': "Start Date Active is Required"
        }, 'flag': {
            'required': "Enabled Flag is Required"
        }
    }


    transformRmanResponsibilities(user: any) {
        if (user)
            return user.rmanResponsibilities.responsibilityName;
    }



    getAllRmanUserResponsibilities() {
        this.rmanUserResponsibilities.rmanUserId = this.pRmanUserId;
        this.loading = true;
        this.rmanUserResponsibilities['rmanUserId'] = this.pRmanUserId;
        if ((this.pRmanUserId != undefined) && (this.pRmanUserId != null)) {
            this.rmanUserResponsibilitiesService.getAllRmanUserResponsibilities(this.paginationOptions, this.rmanUserResponsibilities).then((rmanUserResponsibilitiesList: any) => {
                this.loading = false;
                this.datasource = rmanUserResponsibilitiesList.content;
                if (this.pRmanUserId != null) {
                    this.rmanUserResponsibilitiesList = rmanUserResponsibilitiesList.content;
                } else {
                    this.rmanUserResponsibilitiesList = [];
                }
                this.totalElements = rmanUserResponsibilitiesList.totalElements;
                this.pageSize = rmanUserResponsibilitiesList.size;
                this.displaySearchDialog = false;
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while getting data');
                this.loading = false;
            });
        }
    }

    getRmanUserResponsibilities(event: any) {

        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.loading = true;
        if ((this.pRmanUserId != undefined) && (this.pRmanUserId != null)) {
            this.rmanUserResponsibilitiesService.getAllRmanUserResponsibilities(this.paginationOptions, this.rmanUserResponsibilities).then((rmanUserResponsibilitiesList: any) => {
                this.loading = false;
                this.datasource = rmanUserResponsibilitiesList.content;
                if (this.pRmanUserId != null) {
                    this.rmanUserResponsibilitiesList = rmanUserResponsibilitiesList.content.filter((item: any) => item.rmanUserId == this.pRmanUserId);
                } else {
                    this.rmanUserResponsibilitiesList = rmanUserResponsibilitiesList.content;
                }
                this.totalElements = rmanUserResponsibilitiesList.totalElements;
                this.pageSize = rmanUserResponsibilitiesList.size;
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while getting data');
                this.loading = false;
            });
        }

    }


    showDialogToAdd() {

        this.newRmanUserResponsibilities = true;
        this.rmanUserResponsibilities = new RmanUserResponsibilitiesImpl();
        if (this.pRmanUserId == null || this.pRmanUserId == 0) {
            this.displayDialog = false;
            this.notificationService.showInfo('Please select a User');
            this.displayConfirmation = true;
        }
        else {
            this.rmanUserResponsibilities.rmanUserId = this.pRmanUserId;
            this.displayDialog = true;
            this.prepareRmanResponsibilitiesObject();
            this.buildForm();
        }

    }


    save() {
        if (this.newRmanUserResponsibilities) {
            this.rmanUserResponsibilities.rmanUserId = this.pRmanUserId;
            this.loading = true;
            this.rmanUserResponsibilitiesService.saveRmanUserResponsibilities(this.rmanUserResponsibilities).then((response: any) => {
                this.notificationService.showSuccess('Saved successfully');
                this.getAllRmanUserResponsibilities();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while saving data');
                this.loading = false;
            });
        }
        else {
            this.loading = true;
            this.rmanUserResponsibilitiesService.updateRmanUserResponsibilities(this.rmanUserResponsibilities).then((response: any) => {
                this.notificationService.showSuccess('Updated successfully');
                this.getAllRmanUserResponsibilities();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while updating data');
                this.loading = false;
            });
        }

        this.rmanUserResponsibilities = new RmanUserResponsibilitiesImpl();

        this.displayDialog = false;

    }

    delete(rmanUserResponsibilities: any) {
        this.rmanUserResponsibilities = rmanUserResponsibilities;
        if (this.rmanUserResponsibilities.endDateActive) {
            this.rmanUserResponsibilities.endDateActive = new Date(this.rmanUserResponsibilities.endDateActive);
        }
        if (this.rmanUserResponsibilities.startDateActive) {
            this.rmanUserResponsibilities.startDateActive = new Date(this.rmanUserResponsibilities.startDateActive);
        }
        this.displayDialog = false;
        this.confirmationService.confirm({
            message: 'Are you sure you want to delete this record?',
            header: 'Confirmation',
            icon: '',
            accept: () => {
                this.rmanUserResponsibilitiesList.splice(this.findSelectedRmanUserResponsibilitiesIndex(), 1);
                this.rmanUserResponsibilitiesService.deleteRmanUserResponsibilities(this.rmanUserResponsibilities).then((response: any) => {
                    this.rmanUserResponsibilities = new RmanUserResponsibilitiesImpl();
                    this.getAllRmanUserResponsibilities();
                });
                this.notificationService.showSuccess('Deleted successfully');
            },
            reject: () => {
                this.notificationService.showWarning('You have rejected');
            }
        });
    }

    editRow(rmanUserResponsibilities: any) {
        this.newRmanUserResponsibilities = false;
        this.rmanUserResponsibilities = this.cloneRmanUserResponsibilities(rmanUserResponsibilities);
        if (this.rmanUserResponsibilities.endDateActive) {
            this.rmanUserResponsibilities.endDateActive = new Date(this.rmanUserResponsibilities.endDateActive);
        }
        if (this.rmanUserResponsibilities.startDateActive) {
            this.rmanUserResponsibilities.startDateActive = new Date(this.rmanUserResponsibilities.startDateActive);
        } this.displayDialog = true;
        this.prepareRmanResponsibilitiesObject();
    }


    findSelectedRmanUserResponsibilitiesIndex(): number {
        return this.rmanUserResponsibilitiesList.indexOf(this.selectedRmanUserResponsibilities);
    }

    onRowSelect(event: any) {

    }

    cloneRmanUserResponsibilities(c: RmanUserResponsibilities): RmanUserResponsibilities {
        let rmanUserResponsibilities: any
            = new RmanUserResponsibilitiesImpl();
        for (let prop in c) {
            rmanUserResponsibilities[prop] = c[prop];
        }
        return rmanUserResponsibilities;
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

        this.rmanUserResponsibilitiesSearch = new RmanUserResponsibilitiesImpl();

        if (this.isSerached == 0) {
            this.rmanUserResponsibilitiesSearch = new RmanUserResponsibilitiesImpl();
        }
        this.displaySearchDialog = true;

    }

    search() {
        this.isSerached = 1;
        this.rmanUserResponsibilities = this.rmanUserResponsibilitiesSearch;
        this.paginationOptions = {};
        this.getAllRmanUserResponsibilities();
    }

    prepareRmanResponsibilitiesObject() {
        let rmanResponsibilitiesTempObj: any = [{ label: appSettings.dropDownOptions.selectResponsibility, value: null }];
        this.rmanResponsibilitiesList.forEach((rmanResponsibilities) => {
            rmanResponsibilitiesTempObj.push({ label: rmanResponsibilities.responsibilityName, value: rmanResponsibilities.responsibilityId });
        });

        this.rmanResponsibilities = rmanResponsibilitiesTempObj;

    }

    onBeforeToggle(evt: any) {
        this.collapsed = evt.collapsed;
    }
}


class RmanUserResponsibilitiesImpl {
    constructor(public attribute3?: any, public createdBy?: any, public attribute2?: any, public lastUpdatedBy?: any, public startDateActive?: any, public attribute1?: any, public creationDate?: any, public lastUpdateDate?: any, public responsibilityId?: any, public attribute5?: any, public attribute4?: any, public endDateActive?: any, public seededFlag?: any, public rmanUserId?: any, public enabledFlag?: any) { }
}

interface ILabels {
    [index: string]: string;
}
