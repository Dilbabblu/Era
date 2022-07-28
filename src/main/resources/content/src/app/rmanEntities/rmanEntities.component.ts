import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ConfirmationService, Message } from 'primeng/api';
import { Table } from 'primeng/table';
import { RmanEntityParametersComponent } from '../rmanEntityParameters/rmanEntityParameters.component';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanEntities } from './rmanEntities';
import { RmanEntitiesLabels } from './rmanEntitiesLabels';
import { RmanEntitiesService } from './rmanEntitiesservice';
declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
    templateUrl: './rmanEntities.component.html',
    selector: 'rmanEntities-data',
    providers: [RmanEntitiesService, ConfirmationService]
})

export class RmanEntitiesComponent implements OnInit {

    displayDialog: boolean;

    displaySearchDialog: boolean;

    rmanEntities: any = new RmanEntitiesImpl();

    rmanEntitiesSearch: any = new RmanEntitiesImpl();

    isSerached: number = 0;

    showMsg: any;

    msgs: Message[] = [];

    

    selectedRmanEntities: RmanEntities;

    pEntityId: number;

    pTableName: any;

    newRmanEntities: boolean;

    rmanEntitiesList: any[];

    cols: any[];
    entitiesColumns: ILabels;


    paginationOptions: any;

    pages: {};

    datasource: any[];
    pageSize: number;
    totalElements: number;


    rmanLookupsVList: any[] = [];
    rmanLookupsV: any[];
    rmanLookupsV1List: any[] = [];
    rmanLookupsV1: any[];
    rmanLookupsV2List: any[] = [];
    rmanLookupsV2: any[];
    rmanLookupsV3List: any[] = [];
    rmanLookupsV3: any[];
    rmanLookupsV4List: any[] = [];
    rmanLookupsV4: any[];

    tableList: any[] = [];
    collapsed: boolean = true;

    entitiesForm: FormGroup;
    loading: boolean;

    noData = appSettings.noData;
    @ViewChild(RmanEntityParametersComponent) private childTable: RmanEntityParametersComponent;

    isSelectAllChecked = true;
    globalCols: any[];
    clonedCols: any[];
    userId: number;
    showPaginator: boolean = true;
    startIndex: number;
    showAddColumns = true;
    columns: any[];

    constructor(private rmanEntitiesService: RmanEntitiesService, private rmanLookupsVService: RmanLookupsVService, private formBuilder: FormBuilder, private confirmationService: ConfirmationService,
        private notificationService: NotificationService, private commonSharedService: CommonSharedService) {

        // generate list code
        this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
        this.loading = true;
        this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'ENABLED_FLAG' }).then((rmanLookupsVList: any) => {
            this.rmanLookupsVList = rmanLookupsVList.content;
            this.prepareRmanLookupsVObject();


            this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'ENABLED_FLAG' }).then((rmanLookupsV1List: any) => {
                this.rmanLookupsV1List = rmanLookupsV1List.content;
                this.prepareRmanLookupsV1Object();


                this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, {}).then((rmanLookupsV2List: any) => {
                    this.rmanLookupsV2List = rmanLookupsV2List.content;
                    this.prepareRmanLookupsV2Object();


                    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'OBJECT_TYPE' }).then((rmanLookupsV3List: any) => {
                        this.rmanLookupsV3List = rmanLookupsV3List.content;
                        this.prepareRmanLookupsV3Object();

                        this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'ENABLED_FLAG' }).then((rmanLookupsV4List: any) => {
                            this.loading = false;
                            this.rmanLookupsV4List = rmanLookupsV4List.content;
                            this.prepareRmanLookupsV4Object();
                        }).catch((err: any) => {
                            this.notificationService.showError('Error occured while getting "Deal Flag" data');
                            this.loading = false;
                        });
                    }).catch((err: any) => {
                        this.notificationService.showError('Error occured while getting "Object Type" data');
                        this.loading = false;
                    });
                }).catch((err: any) => {
                    this.notificationService.showError('Error occured while getting "Entity Category" data');
                    this.loading = false;
                });
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while getting "Audit Flag" data');
                this.loading = false;
            });
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting "Post Booking" data');
            this.loading = false;
        });


    }
    cancelSearch() {
        this.displaySearchDialog = false;
        this.rmanEntitiesSearch = new RmanEntitiesImpl();

    }
    cancelEdit() {
        this.displayDialog = false;
        this.rmanEntities = new RmanEntitiesImpl();
    }
    table() {
        let tableListTemp: any = [];
        this.rmanEntitiesList.forEach((obj) => {
            tableListTemp.push({ label: obj.tableName, value: obj.tableName });
        });

        this.tableList = tableListTemp;
        return this.tableList;
    }
    ngOnInit() {
        this.globalCols = [
            { field: 'entityName', header: 'Entity Name', showField: true, drag: false, display: "table-cell", type: 'text' },
            { field: 'entityCategory', header: 'Entity Category', showField: true, drag: false, display: "table-cell", type: 'text' },
            { field: 'description', header: 'Description', showField: true, drag: false, display: "table-cell", type: 'text' },
            { field: 'tableName', header: 'Table Name', showField: true, drag: true, display: "table-cell", type: 'text' },
            { field: 'dealFlag', header: 'Deal Flag', showField: true, drag: true, display: "table-cell", type: 'text' },
            { field: 'postBooking', header: 'Post Booking Flag', showField: true, drag: true, display: "table-cell", type: 'text' },
            { field: 'auditFlag', header: 'Audit Flag', showField: true, drag: true, display: "table-cell", type: 'text' },
            { field: 'objectType', header: 'Object Type', showField: true, drag: true, display: "table-cell", type: 'text' },
            { field: 'startDateActive', header: 'Active Start Date', showField: true, drag: true, display: "table-cell", type: 'date' },
            { field: 'endDateActive', header: 'Active End Date', showField: true, drag: true, display: "table-cell", type: 'date' }
        
        ];

        this.columns = [];
        this.getTableColumns("rmanEntities", "Entities");

        let rmanEntitiesLabels = new RmanEntitiesLabels();
        this.entitiesColumns = rmanEntitiesLabels.fieldLabels;
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
        this.commonSharedService.saveOrUpdateTableColumns("rmanEntities", "Entities", selectedCols, this.userId).then((response) => {
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
        this.rmanEntities = new RmanEntitiesImpl();
        dt.reset();
    }

    buildForm() {
        this.entitiesForm = this.formBuilder.group({
            'name': ['', [
                Validators.required,Validators.minLength(4),Validators.maxLength(35)
            ]
            ],
            'dFlag': ['', [Validators.required]],
            'category': ['', [Validators.required, Validators.minLength(4),Validators.maxLength(40)]],
            'pBooking': ['', [Validators.required
            ]],
            'oType': ['', [Validators.required]],
            'activeDate': ['', [Validators.required]],
            'tName': ['', [Validators.required, Validators.minLength(4),Validators.maxLength(30)]],
            'aFlag': ['', [Validators.required]]
        });

        this.entitiesForm.valueChanges
            .subscribe(data => this.onValueChanged(data));

        this.onValueChanged();
    }

    onValueChanged(data?: any) {
        if (!this.entitiesForm) { return; }
        const form = this.entitiesForm;

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
        'name': '', 'dFlag': '', 'category': '', 'pBooking': '', 'oType': '', 'activeDate': '', 'tName': '', 'aFlag': ''
    };

    validationMessages = {
        'name': {
            'required': " Entity Name is required (minimum length is 4 and maximum length is 35 characters)",
            'minlength': 'Entity Name must be at least 4 characters long.',
            'maxlength': 'Entity Name cannot be more than 35 characters long.',
        }, 'dFlag': {
            'required': "Deal Flag is Required"
        },
        'category': {
            'required': " Entity Category is required (minimum length is 4 and maximum length is 40 characters)",
            'minlength': 'Entity Name must be at least 4 characters long.',
            'maxlength': 'Entity Name cannot be more than 40 characters long.',
        }, 'pBooking': {
            'required': "Post Booking is required"
        }, 'oType': {
            'required': "Object Type is required"
        }, 'activeDate': {
            'required': "Start Date Active is required"
        }, 'tName': {
            'required': "Table Name is required (minimum length is 4 and maximum length is 30 characters)",
            'minlength': 'Table Name must be at least 4 characters long.',
            'maxlength': 'Table Name cannot be more than 30 characters long.',
        },
        'aFlag': {
            'required': "Audit Flag is required"
        }
    }

    transformRmanLookupsV(rmanLookupsV: any) {
        if (rmanLookupsV)
            return rmanLookupsV.lookupDescription;
    }
    transformRmanLookupsV1(rmanLookupsV1: any) {
        if (rmanLookupsV1)
            return rmanLookupsV1.lookupDescription;
    }
    transformRmanLookupsV2(rmanLookupsV2: any) {
        if (rmanLookupsV2)
            return rmanLookupsV2.lookupDescription;
    }
    transformRmanLookupsV3(rmanLookupsV3: any) {
        if (rmanLookupsV3)
            return rmanLookupsV3.lookupDescription;
    }
    transformRmanLookupsV4(rmanLookupsV4: any) {
        if (rmanLookupsV4)
            return rmanLookupsV4.lookupDescription;
    }



    getAllRmanEntities() {
        this.loading = true;
        this.rmanEntitiesService.getAllRmanEntities(this.paginationOptions, this.rmanEntities).then((rmanEntitiesList: any) => {
            this.loading = false;
            this.datasource = rmanEntitiesList.content;
            this.rmanEntitiesList = rmanEntitiesList.content;
            this.totalElements = rmanEntitiesList.totalElements;
            this.selectedRmanEntities = this.rmanEntitiesList[0];
            if (rmanEntitiesList && rmanEntitiesList.content && rmanEntitiesList.content[0]) {
                this.pEntityId = rmanEntitiesList.content[0].entityId;
                this.pTableName = rmanEntitiesList.content[0].tableName;
            } else {
                this.pEntityId = 0;
                this.pTableName = '';
            }
            this.childTable.parentCall(this.selectedRmanEntities);
            this.pageSize = rmanEntitiesList.size;
            this.displaySearchDialog = false;
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
        });
    }


    getRmanEntities(event: any) {

        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.loading = true;
        this.rmanEntitiesService.getAllRmanEntities(this.paginationOptions, this.rmanEntities).then((rmanEntitiesList: any) => {
            this.loading = false;
            this.datasource = rmanEntitiesList.content;
            this.rmanEntitiesList = rmanEntitiesList.content;
            this.pEntityId = rmanEntitiesList.content[0].entityId;
            this.pTableName = rmanEntitiesList.content[0].tableName;
            this.selectedRmanEntities = this.rmanEntitiesList[0];
            this.childTable.parentCall(this.selectedRmanEntities);
            this.totalElements = rmanEntitiesList.totalElements;
            this.pageSize = rmanEntitiesList.size;
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
        });

    }


    showDialogToAdd() {
        this.newRmanEntities = true;
        this.rmanEntities = new RmanEntitiesImpl();
        this.displayDialog = true;
        this.prepareRmanLookupsVObject();
        this.prepareRmanLookupsV1Object();
        this.prepareRmanLookupsV2Object();
        this.prepareRmanLookupsV3Object();
        this.prepareRmanLookupsV4Object();
        this.buildForm();
    }

    save() {
        if (this.newRmanEntities) {
            this.loading = true;
            this.rmanEntitiesService.saveRmanEntities(this.rmanEntities).then((response: any) => {
                this.notificationService.showSuccess('Saved successfully');
                this.getAllRmanEntities();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while saving the data');
                this.loading = false;
            });
        }
        else {
            this.loading = true;
            this.rmanEntitiesService.updateRmanEntities(this.rmanEntities).then((response: any) => {
                this.notificationService.showSuccess('Updated successfully');
                this.getAllRmanEntities();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while updating the data');
                this.loading = false;
            });
        }
        this.rmanEntities = new RmanEntitiesImpl();
        this.displayDialog = false;
    }

    delete(rmanEntities: any) {
        this.rmanEntities = rmanEntities;
        if (this.rmanEntities.endDateActive) {
            this.rmanEntities.endDateActive = new Date(this.rmanEntities.endDateActive);
        }
        if (this.rmanEntities.startDateActive) {
            this.rmanEntities.startDateActive = new Date(this.rmanEntities.startDateActive);
        }
        this.displayDialog = false;
        this.confirmationService.confirm({
            message: 'Are you sure you want to delete this record?',
            header: 'Confirmation',
            icon: '',
            accept: () => {
                this.rmanEntitiesList.splice(this.findSelectedRmanEntitiesIndex(), 1);
                this.loading = true;
                this.rmanEntitiesService.deleteRmanEntities(this.rmanEntities).then((response: any) => {
                    this.rmanEntities = new RmanEntitiesImpl();
                    this.getAllRmanEntities();
                });
                this.notificationService.showSuccess('Deleted successfully');
            },
            reject: () => {
                this.notificationService.showWarning('You have rejected');
            }
        });
    }

    editRow(rmanEntities: any) {
        this.newRmanEntities = false;
        this.rmanEntities = this.cloneRmanEntities(rmanEntities);
        if (this.rmanEntities.endDateActive) {
            this.rmanEntities.endDateActive = new Date(this.rmanEntities.endDateActive);
        }
        if (this.rmanEntities.startDateActive) {
            this.rmanEntities.startDateActive = new Date(this.rmanEntities.startDateActive);
        } this.displayDialog = true;
        this.prepareRmanLookupsVObject();
        this.prepareRmanLookupsV1Object();
        this.prepareRmanLookupsV2Object();
        this.prepareRmanLookupsV3Object();
        this.prepareRmanLookupsV4Object();

    }


    findSelectedRmanEntitiesIndex(): number {
        return this.rmanEntitiesList.indexOf(this.selectedRmanEntities);
    }
    onRowUnSelect(event: any) {
        this.childTable.parentCall('');
    }
    onRowSelect(event: any) {
        this.selectedRmanEntities = event.data;
        this.childTable.parentCall(event.data);
    }

    cloneRmanEntities(c: RmanEntities): RmanEntities {
        let rmanEntities: any
            = new RmanEntitiesImpl();
        for (let prop in c) {
            rmanEntities[prop] = c[prop];
        }
        return rmanEntities;
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

        this.rmanEntitiesSearch = new RmanEntitiesImpl();

        if (this.isSerached == 0) {
            this.rmanEntitiesSearch = new RmanEntitiesImpl();
        }
        this.displaySearchDialog = true;

    }

    search() {
        this.isSerached = 1;
        this.rmanEntities = this.rmanEntitiesSearch;
        this.paginationOptions = {};
        this.getAllRmanEntities();
    }

    prepareRmanLookupsVObject() {
        let rmanLookupsVTempObj: any = [{ label: appSettings.dropDownOptions.selectPost, value: null }];
        this.rmanLookupsVList.forEach((rmanLookupsV) => {
            rmanLookupsVTempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
        });

        this.rmanLookupsV = rmanLookupsVTempObj;

    }

    prepareRmanLookupsV1Object() {
        let rmanLookupsV1TempObj: any = [{ label: appSettings.dropDownOptions.selectAudit, value: null }];
        this.rmanLookupsV1List.forEach((rmanLookupsV1) => {
            rmanLookupsV1TempObj.push({ label: rmanLookupsV1.lookupDescription, value: rmanLookupsV1.lookupCode });
        });

        this.rmanLookupsV1 = rmanLookupsV1TempObj;

    }

    prepareRmanLookupsV2Object() {
        let rmanLookupsV2TempObj: any = [{ label: appSettings.dropDownOptions.selectentity, value: null }];
        this.rmanLookupsV2List.forEach((rmanLookupsV2) => {
            rmanLookupsV2TempObj.push({ label: rmanLookupsV2.lookupDescription, value: rmanLookupsV2.lookupCode });
        });

        this.rmanLookupsV2 = rmanLookupsV2TempObj;

    }

    prepareRmanLookupsV3Object() {
        let rmanLookupsV3TempObj: any = [{ label: appSettings.dropDownOptions.selectobjectType, value: null }];
        this.rmanLookupsV3List.forEach((rmanLookupsV3) => {
            rmanLookupsV3TempObj.push({ label: rmanLookupsV3.lookupDescription, value: rmanLookupsV3.lookupCode });
        });

        this.rmanLookupsV3 = rmanLookupsV3TempObj;

    }

    prepareRmanLookupsV4Object() {
        let rmanLookupsV4TempObj: any = [{ label: appSettings.dropDownOptions.selectDeal, value: null }];
        this.rmanLookupsV4List.forEach((rmanLookupsV4) => {
            rmanLookupsV4TempObj.push({ label: rmanLookupsV4.lookupDescription, value: rmanLookupsV4.lookupCode });
        });

        this.rmanLookupsV4 = rmanLookupsV4TempObj;

    }

    onBeforeToggle(evt: any) {
        this.collapsed = evt.collapsed;
    }

}


class RmanEntitiesImpl {
    constructor(public attribute10?: any, public dealFlag?: any, public tableName?: any, public attribute30?: any, public entityId?: any, public attribute14?: any, public attribute13?: any, public attribute12?: any, public attribute11?: any, public postBooking?: any, public lastUpdateDate?: any, public objectType?: any, public description?: any, public attribute29?: any, public attribute28?: any, public attribute27?: any, public attribute26?: any, public endDateActive?: any, public entityName?: any, public attribute3?: any, public attribute21?: any, public createdBy?: any, public attribute2?: any, public attribute20?: any, public lastUpdatedBy?: any, public startDateActive?: any, public attribute1?: any, public entityCategory?: any, public attribute25?: any, public attribute24?: any, public attribute23?: any, public attribute22?: any, public creationDate?: any, public attribute9?: any, public attribute8?: any, public attribute7?: any, public attribute6?: any, public attribute5?: any, public attribute4?: any, public attribute18?: any, public auditFlag?: any, public attribute17?: any, public attribute16?: any, public attribute15?: any, public attribute19?: any) { }
}

interface ILabels {
    [index: string]: string;
}
