import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Table } from 'primeng/table';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanFunctions } from './rmanFunctions';
import { RmanFunctionsLabels } from './rmanFunctionsLabels';
import { RmanFunctionsService } from './rmanFunctionsservice';
declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
    templateUrl: './rmanFunctions.component.html',
    selector: 'rmanFunctions-data',
    providers: [RmanFunctionsService]
})

export class RmanFunctionsComponent implements OnInit {

    displayDialog: boolean;

    displaySearchDialog: boolean;

    loading: boolean;

    rmanFunctions: any = new RmanFunctionsImpl();

    rmanFunctionsSearch: any = new RmanFunctionsImpl();

    isSerached: number = 0;

    selectedRmanFunctions: any = {} as RmanFunctions;

    newRmanFunctions: boolean;

    rmanFunctionsList: any[];

    collapsed: boolean = true;

    cols: any[];
    functionColumns: ILabels;

    columnOptions: any[];

    paginationOptions: any;

    pages: {};

    datasource: any[];
    pageSize: number;
    totalElements: number;
    rmanLookupsVList: any[] = [];
    rmanLookupsV: any[];

    permissionsForm: FormGroup;

    isSelectAllChecked = true;
    globalCols: any[];
    clonedCols: any[];
    userId: number;
    showPaginator: boolean = true;
    startIndex: number;
    showAddColumns = true;
    columns: any[];

    constructor(private rmanFunctionsService: RmanFunctionsService, private rmanLookupsVService: RmanLookupsVService, private formBuilder: FormBuilder,
        private notificationService: NotificationService,private commonSharedService: CommonSharedService) {

        // generate list code
        this.loading = true;
        this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
        this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'ENABLED_FLAG' }).then((rmanLookupsVList: any) => {
            this.loading = false;
            this.rmanLookupsVList = rmanLookupsVList.content;
            this.prepareRmanLookupsVObject();
        }).catch((err: any) => {
            this.loading = false;
        })


    }

    ngOnInit() {
        this.globalCols = [
            { field: 'fid', header: 'Function Id', showField: true, drag: false, display: "table-cell", type: 'number' },
            { field: 'module', header: 'Module', showField: true, drag: false, display: "table-cell", type: 'text' },
            { field: 'name', header: 'Function Name', showField: true, drag: false, display: "table-cell", type: 'text' },
            { field: 'fcode', header: 'Function Code', showField: true, drag: true, display: "table-cell", type: 'text' },
            { field: 'enabledFlag', header: 'Enabled Flag', showField: true, drag: true, display: "table-cell", type: 'text' }
        ];

        this.columns = [];
        this.getTableColumns("rmanPermissionModules", "Permission Modules");

        let rmanFunctionsLabels = new RmanFunctionsLabels();
        this.functionColumns = rmanFunctionsLabels.fieldLabels;
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
        this.commonSharedService.saveOrUpdateTableColumns("rmanPermissionModules", "Permission Modules", selectedCols, this.userId).then((response) => {
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
        this.permissionsForm = this.formBuilder.group({
            'module': ['', [Validators.required, Validators.minLength(5),Validators.maxLength(30)]],
            'fcode': ['', [Validators.required, , Validators.minLength(2),Validators.maxLength(15)]],
            'name': ['', [Validators.required, Validators.minLength(4),Validators.maxLength(70)]],
            'enabledFlag': ['', [Validators.required]],
        });

        this.permissionsForm.valueChanges
            .subscribe(data => this.onValueChanged(data));

        this.onValueChanged();
    }

    onValueChanged(data?: any) {
        if (!this.permissionsForm) { return; }
        const form = this.permissionsForm;

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
        'module': '', 'fcode': '', 'name': '', 'enabledFlag': ''
    };

    validationMessages = {
        'module': {
            'required': "Module name is required (minimum length is 5 and maximum length is 30 characters)",
            'minlength': 'Module Name must be at least 5 characters long.',
            'maxlength': 'Module Name cannot be more than 30 characters long.',
        },
        'fcode': {
            'required': "Function code is Required (minimum length is 2 and maximum length is 15 characters)",
            'minlength': 'Function code must be at least 2 characters long.',
            'maxlength': 'Function code cannot be more than 15 characters long.',
        },
        'name': {
            'required': "Function Name is required (minimum length is 4 and maximum length is 70 characters)",
            'minlength': 'Function Name must be at least 4 characters long.',
            'maxlength': 'Function Name cannot be more than 70 characters long.',
        },
        'enabledFlag': {
            'required': "Enabled flag is required"
        }
    }

    getAllRmanFunctions() {
        this.loading = true;
        this.rmanFunctionsService.getAllRmanFunctions(this.paginationOptions, this.rmanFunctions).then((rmanFunctionsList: any) => {
            this.loading = false;
            this.datasource = rmanFunctionsList.content;
            this.rmanFunctionsList = rmanFunctionsList.content;
            this.totalElements = rmanFunctionsList.totalElements;
            this.pageSize = rmanFunctionsList.size;
            this.displaySearchDialog = false;
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
        });
    }


    getRmanFunctions(event: any) {

        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.loading = true;
        this.rmanFunctionsService.getAllRmanFunctions(this.paginationOptions, this.rmanFunctions).then((rmanFunctionsList: any) => {
            this.loading = false;
            this.datasource = rmanFunctionsList.content;
            this.rmanFunctionsList = rmanFunctionsList.content;
            this.totalElements = rmanFunctionsList.totalElements;
            this.pageSize = rmanFunctionsList.size;
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
        });

    }


    showDialogToAdd() {

        this.newRmanFunctions = true;
        this.rmanFunctions = new RmanFunctionsImpl();
        this.displayDialog = true;
        this.prepareRmanLookupsVObject();
        this.buildForm();

    }

    saveOrUpdate(msg: any){
        this.notificationService.showSuccess(msg);
        this.loading = false;
        this.getAllRmanFunctions();
    }

    save() {
        if (this.newRmanFunctions) {
            this.loading = true;
            this.rmanFunctionsService.saveRmanFunctions(this.rmanFunctions).then((response: any) => {
                this.saveOrUpdate('Saved Successfully');
            });
        }
        else {
            this.loading = true;
            this.rmanFunctionsService.updateRmanFunctions(this.rmanFunctions).then((response: any) => {
                this.saveOrUpdate('Updated Successfully');
            });
        }
        this.rmanFunctions = new RmanFunctionsImpl();
        this.displayDialog = false;
    }

    delete(rmanFunctions: any) {
        this.rmanFunctions = rmanFunctions;
        this.displayDialog = false;
        if (window.confirm('Are you sure you want to delete this record?')) {
            this.rmanFunctionsList.splice(this.findSelectedRmanFunctionsIndex(), 1);
            this.loading = true;
            this.rmanFunctionsService.deleteRmanFunctions(this.rmanFunctions).then((response: any) => {
                this.loading = false;
                this.rmanFunctions = new RmanFunctionsImpl();
                this.getAllRmanFunctions();
            });
        }

    }

    reset(dt: Table) {
        this.paginationOptions = {};
        this.rmanFunctions = new RmanFunctionsImpl();
        dt.reset();
    }


    editRow(rmanFunctions: any) {
        this.newRmanFunctions = false;
        this.rmanFunctions = this.cloneRmanFunctions(rmanFunctions);
        this.displayDialog = true;

        this.prepareRmanLookupsVObject();

    }

    prepareRmanLookupsVObject() {
        let rmanLookupsVTempObj: any = [{ label: appSettings.dropDownOptions.selectEnabledFlag, value: null }];
        this.rmanLookupsVList.forEach((rmanLookupsV) => {
            rmanLookupsVTempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
        });

        this.rmanLookupsV = rmanLookupsVTempObj;

    }

    findSelectedRmanFunctionsIndex(): number {
        return this.rmanFunctionsList.indexOf(this.selectedRmanFunctions);
    }

    onRowSelect(event: any) {

    }

    cancelAddEdit() {
        this.displayDialog = false;
        this.rmanFunctions = new RmanFunctionsImpl();
    }

    onBeforeToggle(evt: any) {
        this.collapsed = evt.collapsed;
    }


    cloneRmanFunctions(c: RmanFunctions): RmanFunctions {
        let rmanFunctions: any
            = new RmanFunctionsImpl();
        for (let prop in c) {
            rmanFunctions[prop] = c[prop];
        }
        return rmanFunctions;
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
            this.rmanFunctionsSearch = new RmanFunctionsImpl();
        }
        this.displaySearchDialog = true;

    }

    search() {
        this.displaySearchDialog = false;
        this.isSerached = 1;
        this.rmanFunctions = this.rmanFunctionsSearch;
        this.getAllRmanFunctions();
    }



}


class RmanFunctionsImpl {
    constructor(public fid?: any, public module?: any, public fcode?: any, public enabledFlag?: any, public url?: any, public name?: any) { }
}

interface ILabels {
    [index: string]: string;
}
