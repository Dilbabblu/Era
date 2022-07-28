import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ConfirmationService, Message } from 'primeng/api';
import { Table } from 'primeng/table';
import { RmanLookupCodesComponent } from '../rmanLookupCodes/rmanLookupCodes.component';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanLookupTypes } from './rmanLookupTypes';
import { RmanLookupTypesLabels } from './rmanLookupTypesLabels';
import { RmanLookupTypesService } from './rmanLookupTypesservice';
declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');


@Component({
    templateUrl: './rmanLookupTypes.component.html',
    selector: 'rmanLookupTypes-data',
    providers: [RmanLookupTypesService, ConfirmationService]
})

export class RmanLookupTypesComponent implements OnInit {
    @ViewChild(RmanLookupCodesComponent) private childTable: RmanLookupCodesComponent;

    displayDialog: boolean;

    displaySearchDialog: boolean;

    rmanLookupTypes: any = new RmanLookupTypesImpl();

    rmanLookupTypesSearch: any = new RmanLookupTypesImpl();

    isSerached: number = 0;

    pLookupTypeName: any;

    msgs: Message[] = [];

    

    selectedRmanLookupTypes: any;

    newRmanLookupTypes: boolean;

    rmanLookupTypesList: any[] = [];

    cols: any[];
    lookupTypeColumns: ILabels;

    columnOptions: any[];

    paginationOptions: any;

    pages: {};

    datasource: any[];
    pageSize: number;
    totalElements: number;

    rmanLookupsVList: any[] = [];
    rmanLookupsV: any[];

    collapsed: boolean = true;

    lookupTypeForm: FormGroup;
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


    constructor(private rmanLookupTypesService: RmanLookupTypesService, private rmanLookupsVService: RmanLookupsVService, private formBuilder: FormBuilder, private confirmationService: ConfirmationService, private notificationService: NotificationService, private commonSharedService: CommonSharedService) {

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
            { field: 'lookupTypeName', header: 'Lookup Type', showField: true, drag: false, display: "table-cell", type: 'text' },
            { field: 'meaning', header: 'Lookup Name', showField: true, drag: false, display: "table-cell", type: 'text' },
            { field: 'description', header: 'Description', showField: true, drag: false, display: "table-cell", type: 'text' },
            { field: 'enabledFlag', header: 'Enabled Flag', showField: true, drag: true, display: "table-cell", type: 'text' },
            { field: 'startDateActive', header: 'Start Date', showField: true, drag: true, display: "table-cell", type: 'date' },
            { field: 'endDateActive', header: 'End Date', showField: true, drag: true, display: "table-cell", type: 'date' },
            { field: 'creationDate', header: 'Creation Date', showField: true, drag: true, display: "table-cell", type: 'date' },
            { field: 'createdBy', header: 'Created By', showField: true, drag: true, display: "table-cell", type: 'number' },
            { field: 'lastUpdateDate', header: 'Last Updated Date', showField: true, drag: true, display: "table-cell", type: 'date' },
            { field: 'lastUpdatedBy', header: 'Last Updated By', showField: true, drag: true, display: "table-cell", type: 'number' }
        ];

        this.columns = [];
        this.getTableColumns("rmanLookups", "Lookup Types");


        let rmanLookupTypesLabels = new RmanLookupTypesLabels();
        this.lookupTypeColumns = rmanLookupTypesLabels.fieldLabels;
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
        this.commonSharedService.saveOrUpdateTableColumns("rmanLookups", "Lookup Types", selectedCols, this.userId).then((response) => {
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
        this.rmanLookupTypes = new RmanLookupTypesImpl();
        dt.reset();
    }

    buildForm() {
        this.lookupTypeForm = this.formBuilder.group({
            'name': ['', [
                Validators.required,
                Validators.minLength(4),
                Validators.maxLength(40)
            ]
            ],
            'meaning': ['', [Validators.required, Validators.minLength(4),
                Validators.maxLength(40)]],
            'flag': ['', [Validators.required]],
            'startDate': ['', [Validators.required]]
        });

        this.lookupTypeForm.valueChanges
            .subscribe(data => this.onValueChanged(data));

        this.onValueChanged();
    }

    onValueChanged(data?: any) {
        if (!this.lookupTypeForm) { return; }
        const form = this.lookupTypeForm;

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
        'name': '', 'meaning': '', 'flag': '', 'startDate': ''/* ,'workspacedbPort':'','workspacedbUser':'' */
    };

    validationMessages = {
        'name': {
            'required': "Lookup Type Name is required (minimum length is 4 and maximum length is 40 characters)",
            'minlength': 'Lookup Type Name must be at least 4 characters long.',
            'maxlength': 'Lookup Type Name cannot be more than 40 characters long.',
        }, 'meaning': {
            'required': "Meaning is Required (minimum length is 4 and maximum length is 40 characters)",
            'minlength': 'Meaning must be at least 4 characters long.',
            'maxlength': 'Meaning cannot be more than 40 characters long.',
        },
        'flag': {
            'required': "Enabled Flag is required"
        }, 'startDate': {
            'required': "Start Date Active is required"
        }
    }
    cancelSearch() {
        this.displaySearchDialog = false;
        this.rmanLookupTypesSearch = new RmanLookupTypesImpl();
    }

    cancelEdit() {
        this.displayDialog = false;
        this.rmanLookupTypes = new RmanLookupTypesImpl();
    }
    cancelAddEdit() {
        this.displayDialog = false;
        this.newRmanLookupTypes = false;
        this.rmanLookupTypes = new RmanLookupTypesImpl();
    }

    transformRmanLookupsV(rmanLookupsV: any) {
        if (rmanLookupsV)
            return rmanLookupsV.lookupDescription;
    }

    getAllRmanLookupTypes() {
        this.loading = true;
        this.rmanLookupTypesService.getAllRmanLookupTypes(this.paginationOptions, this.rmanLookupTypes).then((rmanLookupTypesList: any) => {
            this.loading = false;
            this.datasource = rmanLookupTypesList.content;
            this.rmanLookupTypesList = rmanLookupTypesList.content;
            if (rmanLookupTypesList.content[0]) {
                this.pLookupTypeName = rmanLookupTypesList.content[0].lookupTypeName;
                this.selectedRmanLookupTypes = rmanLookupTypesList.content[0];
            } else {
                this.selectedRmanLookupTypes = '';
            }
            this.childTable.ParentCall(this.selectedRmanLookupTypes);
            this.totalElements = rmanLookupTypesList.totalElements;
            this.pageSize = rmanLookupTypesList.size;
            this.displaySearchDialog = false;
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
        });
    }


    getRmanLookupTypes(event: any) {

        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.loading = true;
        this.rmanLookupTypesService.getAllRmanLookupTypes(this.paginationOptions, this.rmanLookupTypes).then((rmanLookupTypesList: any) => {
            this.loading = false;
            this.datasource = rmanLookupTypesList.content;
            this.rmanLookupTypesList = rmanLookupTypesList.content;

            if (rmanLookupTypesList.content[0]) {
                this.pLookupTypeName = rmanLookupTypesList.content[0].lookupTypeName;
                this.selectedRmanLookupTypes = rmanLookupTypesList.content[0];
            } else {
                this.selectedRmanLookupTypes = '';
            }
            this.childTable.ParentCall(this.selectedRmanLookupTypes);
            this.totalElements = rmanLookupTypesList.totalElements;
            this.pageSize = rmanLookupTypesList.size;
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
        });

    }


    showDialogToAdd() {

        this.newRmanLookupTypes = true;
        this.rmanLookupTypes = new RmanLookupTypesImpl();
        this.displayDialog = true;
        this.lookupTypeForm.get('name').enable();
        this.prepareRmanLookupsVObject();
        this.buildForm();

    }


    save() {

        if (this.newRmanLookupTypes) {
            this.loading = true;
            this.rmanLookupTypesService.saveRmanLookupTypes(this.rmanLookupTypes).then((response: any) => {
                this.notificationService.showSuccess('Saved successfully');
                this.getAllRmanLookupTypes();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while saving the data');
                this.loading = false;
            });
        }
        else {
            this.loading = true;
            this.rmanLookupTypesService.updateRmanLookupTypes(this.rmanLookupTypes).then((response: any) => {
                this.notificationService.showSuccess('Updated successfully');
                this.getAllRmanLookupTypes();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while updating the data');
                this.loading = false;
            });
        }

        this.rmanLookupTypes = new RmanLookupTypesImpl();

        this.displayDialog = false;



    }

    delete(rmanLookupTypes: any) {
        this.rmanLookupTypes = rmanLookupTypes;
        if (this.rmanLookupTypes.endDateActive) {
            this.rmanLookupTypes.endDateActive = new Date(this.rmanLookupTypes.endDateActive);
        }
        if (this.rmanLookupTypes.startDateActive) {
            this.rmanLookupTypes.startDateActive = new Date(this.rmanLookupTypes.startDateActive);
        }
        this.displayDialog = false;

        this.confirmationService.confirm({
            message: 'Are you sure you want to delete this record?',
            header: 'Confirmation',
            icon: '',
            accept: () => {
                this.rmanLookupTypesList.splice(this.findSelectedRmanLookupTypesIndex(), 1);
                this.loading = true;
                this.rmanLookupTypesService.deleteRmanLookupTypes(this.rmanLookupTypes).then((response: any) => {

                    this.rmanLookupTypes = new RmanLookupTypesImpl();
                    this.getAllRmanLookupTypes();

                });
                this.notificationService.showSuccess('Deleted successfully');
            },
            reject: () => {
                this.notificationService.showWarning('You have rejected');
            }
        });
    }

    editRow(rmanLookupTypes: any) {
        this.newRmanLookupTypes = false;
        this.rmanLookupTypes = this.cloneRmanLookupTypes(rmanLookupTypes);
        if (this.rmanLookupTypes.endDateActive) {
            this.rmanLookupTypes.endDateActive = new Date(this.rmanLookupTypes.endDateActive);
        }
        if (this.rmanLookupTypes.startDateActive) {
            this.rmanLookupTypes.startDateActive = new Date(this.rmanLookupTypes.startDateActive);
        }
        this.displayDialog = true;
        this.lookupTypeForm.get('name').disable();
        this.prepareRmanLookupsVObject();

    }


    findSelectedRmanLookupTypesIndex(): number {
        return this.rmanLookupTypesList.indexOf(this.selectedRmanLookupTypes);
    }
    onRowUnSelect() {
        this.childTable.ParentCall('');
    }
    onRowSelect(event: any) {
        this.selectedRmanLookupTypes = event.data;
        this.pLookupTypeName = this.selectedRmanLookupTypes.lookupTypeName;
        this.childTable.ParentCall(this.selectedRmanLookupTypes);

    }

    cloneRmanLookupTypes(c: RmanLookupTypes): RmanLookupTypes {
        let rmanLookupTypes: any
            = new RmanLookupTypesImpl();
        for (let prop in c) {
            rmanLookupTypes[prop] = c[prop];
        }
        return rmanLookupTypes;
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

        this.rmanLookupTypesSearch = new RmanLookupTypesImpl();

        if (this.isSerached == 0) {
            this.rmanLookupTypesSearch = new RmanLookupTypesImpl();
        }
        this.displaySearchDialog = true;

    }

    search() {

        this.isSerached = 1;
        this.rmanLookupTypes = this.rmanLookupTypesSearch;
        this.paginationOptions = {};
        this.getAllRmanLookupTypes();
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


class RmanLookupTypesImpl {
    constructor(public attribute3?: any, public createdBy?: any, public attribute2?: any, public lastUpdatedBy?: any, public startDateActive?: any, public attribute1?: any, public creationDate?: any, public meaning?: any, public enabledFlag?: any, public lastUpdateDate?: any, public attribute5?: any, public attribute4?: any, public lookupTypeName?: any, public description?: any, public endDateActive?: any, public seededFlag?: any) { }
}

interface ILabels {
    [index: string]: string;
}
