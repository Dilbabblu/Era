import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ConfirmationService, Message } from 'primeng/api';
import { Table } from 'primeng/table';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { AllTabColumnsService } from '../services/allTabColumnsservice';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanEntityParameters } from './rmanEntityParameters';
import { RmanEntityParametersLabels } from './rmanEntityParametersLabels';
import { RmanEntityParametersService } from './rmanEntityParametersservice';
declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
    templateUrl: './rmanEntityParameters.component.html',
    selector: 'rmanEntityParameters-data',
    providers: [RmanEntityParametersService, RmanLookupsVService, AllTabColumnsService, ConfirmationService]
})

export class RmanEntityParametersComponent implements OnInit {

    displayDialog: boolean;

    displayConfirmation: boolean;

    pParameterValueId: any;

    displaySearchDialog: boolean;

    rmanEntityParameters: any = new RmanEntityParametersImpl();

    rmanEntityParametersSearch: any = new RmanEntityParametersImpl();

    isSerached: number = 0;

    showMsg: any;

    msgs: Message[] = [];

    

    pEntityId: number;

    pTableName: any;
    selectedRmanEntityParameters: RmanEntityParameters;

    newRmanEntityParameters: boolean;

    rmanEntityParametersList: any[];

    cols: any[];
    entityParamColumns: ILabels;

    columnOptions: any[];

    paginationOptions: any;

    pages: {};

    datasource: any[];
    pageSize: number;
    totalElements: number;
    noData = appSettings.noData;

    allTabColumnsList: any[] = [];
    allTabColumns: any[];
    allTabColumns1List: any[] = [];
    allTabColumns1: any[];
    rmanLookupsVList: any[] = [];
    rmanLookupsV: any[];

    childTable: any[];

    collapsed: boolean = true;

    entityParametersForm: FormGroup;
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

    constructor(
        private rmanEntityParametersService: RmanEntityParametersService,
        private allTabColumnsService: AllTabColumnsService,
        private formBuilder: FormBuilder,
        private confirmationService: ConfirmationService,
        private rmanLookupsVService: RmanLookupsVService,
        private notificationService: NotificationService,
        private commonSharedService: CommonSharedService
    ) {

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
    parentCall(data) {
        this.masterData = data;
        if (data != '' && data) {
            this.pEntityId = data.entityId;
            this.pTableName = data.tableName;
            this.allTabColumnsService.getAllAllTabColumns(this.paginationOptions, { 'tableName': this.pTableName }).then((allTabColumns1List: any) => {
                this.allTabColumns1List = allTabColumns1List.content;
                this.prepareAllTabColumnsObject();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while getting data');
                this.loading = false;
            });
            this.getAllRmanEntityParameters();
        } else {
            this.pEntityId = null;
            this.rmanEntityParametersList = [];
        }
    }

    ngOnInit() {
        this.globalCols = [
            { field: 'parameterName', header: 'Parameter Name', showField: true, drag: false, display: "table-cell", type: 'number' },
            { field: 'description', header: 'Description', showField: true, drag: false, display: "table-cell", type: 'text' },
            { field: 'columnName', header: 'Column Name', showField: true, drag: true, display: "table-cell", type: 'text' },
            { field: 'columnType', header: 'Column Type', showField: true, drag: true, display: "table-cell", type: 'text' },
            { field: 'columnSize', header: 'Column Size', showField: true, drag: true, display: "table-cell", type: 'text' },
            { field: 'enabledFlag', header: 'Enabled Flag', showField: true, drag: true, display: "table-cell", type: 'text' }
        ];

        this.columns = [];
        this.getTableColumns("rmanLegalEntities", "Entities Parameters");

        let rmanEntityParametersLabels = new RmanEntityParametersLabels();
        this.entityParamColumns = rmanEntityParametersLabels.fieldLabels;
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
        this.commonSharedService.saveOrUpdateTableColumns("rmanLegalEntities", "Entities Parameters", selectedCols, this.userId).then((response) => {
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
        this.rmanEntityParameters = new RmanEntityParametersImpl();
        dt.reset();
    }

    buildForm() {
        this.entityParametersForm = this.formBuilder.group({
            'name': ['', [
                Validators.required
            ]
            ],
            'flag': ['', [Validators.required]]
        });

        this.entityParametersForm.valueChanges
            .subscribe(data => this.onValueChanged(data));

        this.onValueChanged();
    }

    onValueChanged(data?: any) {
        if (!this.entityParametersForm) { return; }
        const form = this.entityParametersForm;

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
        'name': '', 'flag': ''/* ,'workspacedbName':'','workspacedbPass':'','workspacedbPort':'','workspacedbUser':'' */
    };

    validationMessages = {
        'name': {
            'required': "Parameter Name is required"/* ,
'minlength': 'Name must be at least 4 characters long.',
'maxlength': 'Name cannot be more than 25 characters long.', */
        }, 'flag': {
            'required': "Enabled Flag is Required"
        }/* ,
'workspacedbHost':{
'required': "DB Host is required"
},'workspacedbPort':{
'required': "DB Port is required",
// 'minlength': 'DB Port must be at least 4 characters long.',
// 'maxlength': 'DB Port cannot be more than 6 characters long.',
'pattern':'Please enter the valid "Port" number with minimum 4 and maximum 6 digit.'
},'workspacedbUser':{
'required': "DB User is required"
},'workspacedbPass':{
'required': "DB Password is required"
} */
    }

    transformAllTabColumns(allTabColumns: any) {
        if (allTabColumns)
            return allTabColumns.columnName;
    }
    transformAllTabColumns1(allTabColumns1: any) {
        if (allTabColumns1)
            return allTabColumns1.tableName;
    }

    getAllRmanEntityParameters(searchObj?: any) {
        let data;
        if (searchObj) {
            data = searchObj;
        } else {
            data = { 'entityId': this.pEntityId }
        }

        this.loading = true;
        if ((this.pEntityId != undefined) && (this.pEntityId != null)) {
            this.rmanEntityParametersService.getAllRmanEntityParameters(this.paginationOptions, data).then((rmanEntityParametersList: any) => {
                this.loading = false;
                this.datasource = rmanEntityParametersList.content;
                this.rmanEntityParametersList = rmanEntityParametersList.content;
                this.totalElements = rmanEntityParametersList.totalElements;
                this.pageSize = rmanEntityParametersList.size;
                this.displaySearchDialog = false;
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while getting data');
                this.loading = false;
            });
        }

    }


    getRmanEntityParameters(event: any) {

        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.loading = true;
        if ((this.pEntityId != undefined) && (this.pEntityId != null)) {
            this.rmanEntityParametersService.getAllRmanEntityParameters(this.paginationOptions, { 'entityId': this.pEntityId }).then((rmanEntityParametersList: any) => {
                this.loading = false;
                this.datasource = rmanEntityParametersList.content;
                this.rmanEntityParametersList = rmanEntityParametersList.content;
                this.totalElements = rmanEntityParametersList.totalElements;
                this.pageSize = rmanEntityParametersList.size;
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while getting data');
                this.loading = false;
            });
        }

    }


    showDialogToAdd() {

        this.newRmanEntityParameters = true;
        this.rmanEntityParameters = new RmanEntityParametersImpl();
        if (this.pEntityId == null || this.pEntityId == 0) {
            this.displayDialog = false;
            this.notificationService.showInfo('Please select an entity');
            this.displayConfirmation = true;
        }
        else {
            this.rmanEntityParameters.entityId = this.pEntityId;
            this.rmanEntityParameters.entityParameterId = this.pParameterValueId;
            this.displayDialog = true;
            this.prepareAllTabColumnsObject();
            this.prepareRmanLookupsVObject();
            this.buildForm();

        }
    }


    save() {
        if (this.newRmanEntityParameters) {
            this.loading = true;
            this.rmanEntityParametersService.saveRmanEntityParameters(this.rmanEntityParameters).then((response: any) => {
                this.notificationService.showSuccess('Saved successfully');
                this.getAllRmanEntityParameters();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while saving the data');
                this.loading = false;
            });
        }
        else {
            this.loading = true;
            this.rmanEntityParametersService.updateRmanEntityParameters(this.rmanEntityParameters).then((response: any) => {
                this.notificationService.showSuccess('Updated successfully');
                this.getAllRmanEntityParameters();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while updating the data');
                this.loading = false;
            });
        }
        this.rmanEntityParameters = new RmanEntityParametersImpl();
        this.displayDialog = false;
    }

    delete(rmanEntityParameters: any) {
        this.rmanEntityParameters = rmanEntityParameters;
        this.displayDialog = false;
        this.confirmationService.confirm({
            message: 'Are you sure you want to delete this record?',
            header: 'Confirmation',
            icon: '',
            accept: () => {
                this.rmanEntityParametersList.splice(this.findSelectedRmanEntityParametersIndex(), 1);
                this.loading = true;
                this.rmanEntityParametersService.deleteRmanEntityParameters(this.rmanEntityParameters).then((response: any) => {
                    this.rmanEntityParameters = new RmanEntityParametersImpl();
                    this.getAllRmanEntityParameters();
                });
                this.notificationService.showSuccess('Deleted successfully');
            },
            reject: () => {
                this.notificationService.showWarning('You have rejected');
            }
        });
    }

    editRow(rmanEntityParameters: any) {
        this.newRmanEntityParameters = false;
        this.rmanEntityParameters = this.cloneRmanEntityParameters(rmanEntityParameters);
        this.displayDialog = true;
        this.prepareAllTabColumnsObject();
        this.prepareRmanLookupsVObject();

    }

    findSelectedRmanEntityParametersIndex(): number {
        return this.rmanEntityParametersList.indexOf(this.selectedRmanEntityParameters);
    }

    onRowSelect(event: any) {

    }

    cloneRmanEntityParameters(c: RmanEntityParameters): RmanEntityParameters {
        let rmanEntityParameters: any
            = new RmanEntityParametersImpl();
        for (let prop in c) {
            rmanEntityParameters[prop] = c[prop];
        }
        return rmanEntityParameters;
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
    cancelAddEdit() {
        this.displayDialog = false;
        this.rmanEntityParameters = new RmanEntityParametersImpl();
    }
    showDialogToSearch() {

        this.rmanEntityParametersSearch = new RmanEntityParametersImpl();

        if (this.isSerached == 0) {
            this.rmanEntityParametersSearch = new RmanEntityParametersImpl();
        }
        this.displaySearchDialog = true;

    }

    search() {
        this.isSerached = 1;
        this.rmanEntityParametersSearch.entityId = this.pEntityId
        this.rmanEntityParameters = this.rmanEntityParametersSearch;
        this.paginationOptions = {};
        this.getAllRmanEntityParameters(this.rmanEntityParameters);
    }

    prepareRmanLookupsVObject() {
        let rmanLookupsVTempObj: any = [{ label: appSettings.dropDownOptions.selectEnabledFlag, value: null }];
        this.rmanLookupsVList.forEach((rmanLookupsV) => {
            rmanLookupsVTempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
        });

        this.rmanLookupsV = rmanLookupsVTempObj;
    }

    prepareAllTabColumnsObject() {
        let allTabColumns1TempObj: any = [{ label: appSettings.dropDownOptions.selectParameter, value: null }];
        this.allTabColumns1List.forEach((allTabColumns1) => {
            allTabColumns1TempObj.push({ label: allTabColumns1.columnName, value: allTabColumns1.columnName });
        });
        this.allTabColumns1 = allTabColumns1TempObj;
    }
    onBeforeToggle(evt: any) {
        this.collapsed = evt.collapsed;
    }

}


class RmanEntityParametersImpl {
    constructor(public attribute10?: any, public attribute30?: any, public entityId?: any, public attribute14?: any, public attribute13?: any, public columnName?: any, public attribute12?: any, public attribute11?: any, public lastUpdateDate?: any, public parameterName?: any, public description?: any, public entityParameterId?: any, public columnType?: any, public attribute29?: any, public attribute28?: any, public attribute27?: any, public attribute26?: any, public columnSize?: any, public attribute3?: any, public attribute21?: any, public createdBy?: any, public attribute2?: any, public attribute20?: any, public lastUpdatedBy?: any, public attribute1?: any, public attribute25?: any, public attribute24?: any, public attribute23?: any, public attribute22?: any, public creationDate?: any, public attribute9?: any, public attribute8?: any, public attribute7?: any, public enabledFlag?: any, public attribute6?: any, public attribute5?: any, public columnSequence?: any, public attribute4?: any, public attribute18?: any, public attribute17?: any, public attribute16?: any, public attribute15?: any, public attribute19?: any) { }
}

interface ILabels {
    [index: string]: string;
}
