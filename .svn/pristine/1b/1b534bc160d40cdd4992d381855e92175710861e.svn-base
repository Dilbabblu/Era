import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ConfirmationService, Message } from 'primeng/api';
import { Table } from 'primeng/table';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { RmanPermissionsComponent } from '../rmanResponsibilitiesPermissions/rmanResponsibilitiesPermissions.component';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanResponsibilities } from './rmanResponsibilities';
import { RmanResponsibilitiesLabels } from './rmanResponsibilitiesLabels';
import { RmanResponsibilitiesService } from './rmanResponsibilitiesservice';

declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
    templateUrl: './rmanResponsibilities.component.html',
    selector: 'rmanResponsibilities-data',
})

export class RmanResponsibilitiesComponent implements OnInit {

    displayDialog: boolean;

    displaySearchDialog: boolean;

    rmanResponsibilities: any = new RmanResponsibilitiesImpl();

    rmanResponsibilitiesSearch: any = new RmanResponsibilitiesImpl();

    isSerached: number = 0;

    showMsg: any;

    msgs: Message[] = [];

    

    selectedRmanResponsibilities: RmanResponsibilities;

    pResponsibilityId: number;

    newRmanResponsibilities: boolean;

    rmanResponsibilitiesList: any[];

    cols: any[];
    responsibilityColumns: ILabels;

    columnOptions: any[];

    paginationOptions: any;

    pages: {};

    datasource: any[];
    pageSize: number;
    totalElements: number;

    collapsed: boolean = true;

    rmanLookupsVList: any[] = [];
    rmanLookupsV: any[];

    responsibilitesForm: FormGroup;
    noData = appSettings.noData;
    loading: boolean;

    @ViewChild(RmanPermissionsComponent)
    private childTable: RmanPermissionsComponent;

    isSelectAllChecked = true;
    globalCols: any[];
    clonedCols: any[];
    userId: number;
    showPaginator: boolean = true;
    startIndex: number;
    showAddColumns = true;
    columns: any[];

    constructor(private rmanResponsibilitiesService: RmanResponsibilitiesService, private formBuilder: FormBuilder, private confirmationService: ConfirmationService, private rmanLookupsVService: RmanLookupsVService,
        private notificationService: NotificationService,private commonSharedService: CommonSharedService) {

        // generate list code
        this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
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

    ngOnInit() {

        this.globalCols = [
            { field: 'responsibilityName', header: 'Responsibility Name', showField: true, drag: false, display: "table-cell", type: 'number' },
            { field: 'description', header: 'Description', showField: true, drag: true, display: "table-cell", type: 'text' },
            { field: 'startDateActive', header: 'Start Date', showField: true, drag: true, display: "table-cell", type: 'date' },
            { field: 'endDateActive', header: 'End Date', showField: true, drag: true, display: "table-cell", type: 'date' },
            { field: 'enabledFlag', header: 'Enabled Flag', showField: true, drag: true, display: "table-cell", type: 'text' },
            { field: 'permissions', header: 'Permissions', showField: true, drag: true, display: "table-cell", type: 'link' }
        ];

        this.columns = [];
        this.getTableColumns("rmanResponsibilities", "Responsibilities");

        let rmanResponsibilitiesLabels = new RmanResponsibilitiesLabels();
        this.responsibilityColumns = rmanResponsibilitiesLabels.fieldLabels;
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
        this.commonSharedService.saveOrUpdateTableColumns("rmanResponsibilities", "Responsibilities", selectedCols, this.userId).then((response) => {
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
        this.rmanResponsibilities = new RmanResponsibilitiesImpl();
        dt.reset();
    }
    buildForm() {
        this.responsibilitesForm = this.formBuilder.group({
            'name': ['', [
                Validators.required, Validators.minLength(4), Validators.maxLength(20)
            ]
            ],
            'activeDate': ['', [Validators.required]],
            'flag': ['', [Validators.required]]
        });

        this.responsibilitesForm.valueChanges
            .subscribe(data => this.onValueChanged(data));

        this.onValueChanged();
    }

    onValueChanged(data?: any) {
        if (!this.responsibilitesForm) { return; }
        const form = this.responsibilitesForm;

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
        'name': '', 'activeDate': '', 'flag': ''/* ,'workspacedbName':'','workspacedbPass':'','workspacedbPort':'','workspacedbUser':'' */
    };

    validationMessages = {
        'name': {
            'required': "Responsibility Name is required (minimum length is 4 and maximum length is 20 characters)",
            'minlength': 'Responsibility Name must be at least 4 characters long.',
            'maxlength': 'Responsibility Name cannot be more than 20 characters long.',
        }, 'activeDate': {
            'required': "Start Date Active is Required"
        }, 'flag': {
            'required': "Enabled Flag is required"
        }

    }




    getAllRmanResponsibilities() {
        this.loading = true;
        this.rmanResponsibilitiesService.getAllRmanResponsibilities(this.paginationOptions, this.rmanResponsibilities).then((rmanResponsibilitiesList: any) => {
            this.loading = false;
            this.datasource = rmanResponsibilitiesList.content;
            this.rmanResponsibilitiesList = rmanResponsibilitiesList.content;
            this.totalElements = rmanResponsibilitiesList.totalElements;
            this.pageSize = rmanResponsibilitiesList.size;
            this.displaySearchDialog = false;
            this.rmanResponsibilitiesSearch = new RmanResponsibilitiesImpl();
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
        });
    }


    getRmanResponsibilities(event: any) {
        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.loading = true;
        this.rmanResponsibilitiesService.getAllRmanResponsibilities(this.paginationOptions, this.rmanResponsibilities).then((rmanResponsibilitiesList: any) => {
            this.loading = false;
            this.datasource = rmanResponsibilitiesList.content;
            this.rmanResponsibilitiesList = rmanResponsibilitiesList.content;
            this.totalElements = rmanResponsibilitiesList.totalElements;
            this.pageSize = rmanResponsibilitiesList.size;
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
        });

    }


    showDialogToAdd() {

        this.newRmanResponsibilities = true;
        this.rmanResponsibilities = new RmanResponsibilitiesImpl();
        this.displayDialog = true;
        this.buildForm();
    }


    save() {


        if (this.newRmanResponsibilities) {
            this.loading = true;
            this.rmanResponsibilitiesService.saveRmanResponsibilities(this.rmanResponsibilities).then((response: any) => {
                this.notificationService.showSuccess('Saved succesfully');
                this.notificationService.showWarning('Processing Permissions on New Role');
                this.rmanResponsibilitiesService.processRmanRoleFunctions(response.responsibilityId).then((data: any) => {
                    if (data.status == "Fail") {
                        this.notificationService.showError('Failed to Processing Permissions');
                    } else {
                        this.notificationService.showSuccess('Processed Permissions on New Role succesfully');
                    }
                }).catch((err: any) => {
                    this.notificationService.showError('Error occured while saving the data');
                    this.loading = false;
                });
                this.getAllRmanResponsibilities();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while saving the data');
                this.loading = false;
            });
        }
        else {
            this.loading = true;
            this.rmanResponsibilitiesService.updateRmanResponsibilities(this.rmanResponsibilities).then((response: any) => {
                this.notificationService.showSuccess('Updated succesfully');
                this.getAllRmanResponsibilities();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while updating the data');
                this.loading = false;
            });
        }

        this.rmanResponsibilities = new RmanResponsibilitiesImpl();

        this.displayDialog = false;

    }


    delete(rmanResponsibilities: any) {
        this.rmanResponsibilities = rmanResponsibilities;
        if (this.rmanResponsibilities.startDateActive) {
            this.rmanResponsibilities.startDateActive = new Date(this.rmanResponsibilities.startDateActive);
        }
        if (this.rmanResponsibilities.endDateActive) {
            this.rmanResponsibilities.endDateActive = new Date(this.rmanResponsibilities.endDateActive);
        }
        this.displayDialog = false;


        this.confirmationService.confirm({
            message: 'Are you sure you want to delete this record?',
            header: 'Confirmation',
            icon: '',
            accept: () => {
                this.rmanResponsibilitiesList.splice(this.findSelectedRmanResponsibilitiesIndex(), 1);
                this.loading = true;
                this.rmanResponsibilitiesService.deleteRmanResponsibilities(this.rmanResponsibilities).then((response: any) => {

                    this.rmanResponsibilities = new RmanResponsibilitiesImpl();
                    this.getAllRmanResponsibilities();
                });
                this.notificationService.showSuccess('Sucessfully deleted');
            },
            reject: () => {
                this.notificationService.showWarning('You have rejected');
            }
        });
    }


    editRow(rmanResponsibilities: any) {
        this.newRmanResponsibilities = false;
        this.rmanResponsibilities = this.cloneRmanResponsibilities(rmanResponsibilities);
        if (this.rmanResponsibilities.startDateActive) {
            this.rmanResponsibilities.startDateActive = new Date(this.rmanResponsibilities.startDateActive);
        }
        if (this.rmanResponsibilities.endDateActive) {
            this.rmanResponsibilities.endDateActive = new Date(this.rmanResponsibilities.endDateActive);
        } this.displayDialog = true;

    }


    findSelectedRmanResponsibilitiesIndex(): number {
        return this.rmanResponsibilitiesList.indexOf(this.selectedRmanResponsibilities);
    }

    onRowSelect(event: any) {
    }

    onRowUnSelect() {
        this.childTable.parentCall('');
    }

    cloneRmanResponsibilities(c: RmanResponsibilities): RmanResponsibilities {
        let rmanResponsibilities: any
            = new RmanResponsibilitiesImpl();
        for (let prop in c) {
            rmanResponsibilities[prop] = c[prop];
        }
        return rmanResponsibilities;
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

        this.rmanResponsibilitiesSearch = new RmanResponsibilitiesImpl();

        if (this.isSerached == 0) {
            this.rmanResponsibilitiesSearch = new RmanResponsibilitiesImpl();
        }
        this.displaySearchDialog = true;

    }
    cancelAddEdit() {
        this.displayDialog = false;
        this.rmanResponsibilities = new RmanResponsibilitiesImpl();
    }
    search() {

        this.isSerached = 1;
        this.rmanResponsibilities = this.rmanResponsibilitiesSearch;
        this.paginationOptions = {};
        this.getAllRmanResponsibilities();
    }

    onBeforeToggle(evt: any) {
        this.collapsed = evt.collapsed;
    }

}


class RmanResponsibilitiesImpl {
    constructor(public attribute3?: any, public createdBy?: any, public attribute2?: any, public lastUpdatedBy?: any, public startDateActive?: any, public attribute1?: any, public creationDate?: any, public lastUpdateDate?: any, public responsibilityId?: any, public responsibilityName?: any, public attribute5?: any, public attribute4?: any, public description?: any, public endDateActive?: any, public enabledFlag?: any) { }
}

interface ILabels {
    [index: string]: string;
}
