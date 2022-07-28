import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ConfirmationService, Message } from 'primeng/api';
import { Table } from 'primeng/table';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { RmanResponsibilitiesService } from '../rmanResponsibilities/rmanResponsibilitiesservice';
import { NotificationService } from '../shared/notifications.service';
import { RmanFunctions } from './rmanFunctions';
import { RmanPermissions } from './rmanPermissions';
import { RmanPermissionsLabels } from './rmanResponsibilitiesPermissionsLabels';
import { RmanPermissionsService } from './rmanResponsibilitiesPermissionsService';
declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
    templateUrl: './rmanResponsibilitiesPermissions.component.html',
    selector: 'rmanResponsibilitiesPermissions-data',
    providers: [RmanPermissionsService, RmanResponsibilitiesService, ConfirmationService]
})

export class RmanPermissionsComponent implements OnInit {

    displayDialog: boolean;

    displayConfirmation: boolean;

    displaySearchDialog: boolean;

    rmanPermissions: any = new RmanPermissionsImpl();

    rmanPermissionsSearch: any = new RmanPermissionsImpl();

    isSerached: number = 0;

    showMsg: any;

    msgs: Message[] = [];
    noData = appSettings.noData;
    

    selectedPermissions: any = {} as RmanPermissions;

    newRmanPermissions: boolean;

    pResponsibilityId: number;
    responsibilityName: string;

    rmanPermissionsList: any[];

    cols: any[];
    columns: ILabels;

    columnOptions: any[];

    paginationOptions: any;

    pages: {};

    datasource: any[];
    pageSize: number;
    totalElements: number;
    rmanFunctions: any[];


    rmanResponsibilitiesList: any[];
    rmanResponsibilities: any[];

    rmanFunctionsList: any[];
    selectedRmanFunction: any;
    selectedRmanModule: any;

    permissionsList: any[];
    selectedPermissionsList: any[] = [];

    editableRfId: any = null;
    defaultseleted: boolean = false;

    collapsed: boolean = true;

    rmanLookupsVList: any[] = [];
    rmanLookupsV: any[];

    rolePermissionsForm: FormGroup;
    loading: boolean;
    masterData: any;


    constructor(private rmanPermissionsService: RmanPermissionsService, private rmanResponsibilitiesService: RmanResponsibilitiesService, private formBuilder: FormBuilder, private confirmationService: ConfirmationService, private rmanLookupsVService: RmanLookupsVService,
        private notificationService: NotificationService) {

        // generate list code
        this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
        this.loading = true;
        this.rmanResponsibilitiesService.getAllRmanResponsibilities(this.paginationOptions, {}).then((rmanResponsibilitiesList: any) => {
            this.loading = false;
            this.rmanResponsibilitiesList = rmanResponsibilitiesList.content;
            this.prepareRmanResponsibilitiesObject();
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting "Responsibility ID" data');
            this.loading = false;
        });

        this.loading = true;
        this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'ENABLED_FLAG' }).then((rmanLookupsVList: any) => {
            this.loading = false;
            this.rmanLookupsVList = rmanLookupsVList.content;
            this.prepareRmanLookupsVObject();
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting "Enabled Flag" data');
            this.loading = false;
        });
        this.getAllRmanFunctions();


    }

    parentCall(data) {
        this.masterData = data;
        if (data && data != '') {
            this.pResponsibilityId = data.responsibilityId;
            this.responsibilityName = data.responsibilityName;
            this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
            this.getAllPermissionFunctions();

        } else {
            this.pResponsibilityId = null;
            this.rmanPermissionsList = [];
        }
    }
    cancelSearch() {
        this.displaySearchDialog = false;
        this.rmanPermissions = new RmanPermissionsImpl();
    }
    cancelEdit() {
        this.displayDialog = false;
        this.rmanPermissionsSearch = new RmanPermissionsImpl();
    }

    prepareRmanLookupsVObject() {
        let rmanLookupsVTempObj: any = [{ label: appSettings.dropDownOptions.selectEnabledFlag, value: null }];
        this.rmanLookupsVList.forEach((rmanLookupsV) => {
            rmanLookupsVTempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
        });
        this.rmanLookupsV = rmanLookupsVTempObj;

    }

    ngOnInit() {
        let rmanPermissionsLabels = new RmanPermissionsLabels();
        this.columns = rmanPermissionsLabels.fieldLabels;
        this.buildForm();
    }

    reset(dt: Table) {
        this.paginationOptions = {};
        this.rmanPermissions = new RmanPermissionsImpl();
        this.getAllPermissionFunctions();
    }

    buildForm() {
        this.rolePermissionsForm = this.formBuilder.group({
            'fName': ['', [
                Validators.required
            ]
            ],
            'perm': ['', [Validators.required]],
            'flag': ['', [Validators.required]],
            'mName': ['', [Validators.required]]
        });

        this.rolePermissionsForm.valueChanges
            .subscribe(data => this.onValueChanged(data));

        this.onValueChanged();
    }

    onValueChanged(data?: any) {
        if (!this.rolePermissionsForm) { return; }
        const form = this.rolePermissionsForm;

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
        'fName': '', 'perm': '', 'flag': '', 'mName': ''/* ,'workspacedbName':'','workspacedbPass':'','workspacedbPort':'','workspacedbUser':'' */
    };

    validationMessages = {
        'fName': {
            'required': "Function Name is required"
        }, 'perm': {
            'required': "Atleast one permission is Required"
        },
        'flag': {
            'required': "Enabled Flag is Required"
        },
        'mName': {
            'required': "Module Nameis Required"
        }
    }


    transformPermissionsValues(permission: any) {
        return permission == 1 ? 'Yes' : 'No';
    }

    getAllRmanFunctions() {
        this.loading = true;
        this.rmanPermissionsService.getAllRmanFunctions(this.paginationOptions).then((rmanFunctionsList: any) => {
            this.loading = false;
            this.rmanFunctions = rmanFunctionsList.content;
            this.prepareRmanModuleObject();
            this.preparePermissionsObjects();
        });

    }
    moduleList = [];
    prepareRmanModuleObject() {
        let newModuleList = [];
        let moduleListTemp = [];
        this.rmanFunctions.forEach((item, index) => {
            if (moduleListTemp.findIndex(i => i.module == item.module) === -1) {
                moduleListTemp.push(item)
            }
        });
        newModuleList = moduleListTemp
        let moduleTemp: any = [{ label: appSettings.dropDownOptions.selectModuleName, value: null }];
        newModuleList.forEach((modules) => {
            moduleTemp.push({ label: modules.module, value: modules.module });
        });
        this.moduleList = moduleTemp;
    }

    prepareFunctions() {
        if (this.rmanFunctions && this.selectedRmanModule) {
            let filteredRmanFunctions = this.rmanFunctions.filter(func => func.module == this.selectedRmanModule);
            this.prepareRmanFunctionsObject(filteredRmanFunctions);
        }
    }

    prepareRmanFunctionsObject(filteredFunctions) {
        let rmanFunctionsTempObj: any = [{ label: appSettings.dropDownOptions.selectFunctionName, value: null }];
        filteredFunctions.forEach((rmanFunction) => {
            rmanFunctionsTempObj.push({ label: rmanFunction.name, value: rmanFunction.fid });
        });
        this.rmanFunctionsList = rmanFunctionsTempObj;
    }

    preparePermissionsObjects() {
        let permissionsTempObj: any[] = [];
        permissionsTempObj.push({ name: "Read", code: "read" });
        permissionsTempObj.push({ name: "Write", code: "write" });
        permissionsTempObj.push({ name: "Upload", code: "upload" });

        this.permissionsList = permissionsTempObj;
    }

    verifyModuleSelection() {
        if (this.defaultseleted || this.selectedRmanModule == undefined) {
            return true;
        }
        return false;
    }

    getAllPermissionFunctions() {
        this.rmanPermissions.roleid = this.pResponsibilityId;
        this.loading = true;
        this.rmanPermissions['rmanUserId'] = this.pResponsibilityId;
        if ((this.pResponsibilityId != undefined) && (this.pResponsibilityId != null)) {
            this.rmanPermissionsService.getAllPermissionFunctions(this.paginationOptions, this.rmanPermissions).then((rmanPermissionsList: any) => {
                this.loading = false;
                this.datasource = rmanPermissionsList.content;
                if (this.pResponsibilityId != null) {
                    this.rmanPermissionsList = rmanPermissionsList.content;
                } else {
                    this.rmanPermissionsList = [];
                }
                this.totalElements = rmanPermissionsList.totalElements;
                this.pageSize = rmanPermissionsList.size;
                this.displaySearchDialog = false;
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while getting data');
                this.loading = false;
            });
        }
    }

    getAllPermissionsFunctions(event: any) {

        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.loading = true;
        if ((this.pResponsibilityId != undefined) && (this.pResponsibilityId != null)) {
            this.rmanPermissionsService.getAllPermissionFunctions(this.paginationOptions, this.rmanPermissions).then((rmanPermissionsList: any) => {
                this.loading = false;
                this.datasource = rmanPermissionsList.content;
                this.rmanPermissionsList = rmanPermissionsList.content;
                this.totalElements = rmanPermissionsList.totalElements;
                this.pageSize = rmanPermissionsList.size;
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while getting data');
                this.loading = false;
            });
        }

    }


    showDialogToAdd() {
        this.rmanFunctionsList = [];
        this.defaultseleted = false;
        this.newRmanPermissions = true;
        this.editableRfId = null;
        this.rmanPermissions = new RmanPermissionsImpl();
        if (this.pResponsibilityId == null || this.pResponsibilityId == 0) {
            this.displayDialog = false;
            this.notificationService.showInfo('Please select a Responsibility');
            this.displayConfirmation = true;
        }
        else {
            this.rmanPermissions.roleid = this.pResponsibilityId;
            this.displayDialog = true;
            this.prepareRmanResponsibilitiesObject();
            this.buildForm();
        }

    }


    save() {
        if (this.newRmanPermissions) {
            this.rmanPermissions.roleid = this.pResponsibilityId;
            this.loading = true;
            let permissionsData = this.prepareSaveEditObject();
            this.rmanPermissionsService.saveRmanPermissions(permissionsData).then((response: any) => {
                this.notificationService.showSuccess('Saved succesfully');
                this.getAllPermissionFunctions();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while saving the data');
                this.loading = false;
            });
        }
        else {
            this.loading = true;
            let permissionsData = this.prepareSaveEditObject();
            this.rmanPermissionsService.updateRmanPermissions(permissionsData).then((response: any) => {
                this.notificationService.showSuccess('Updated succesfully');
                this.notificationService.showSuccess( 'Updated successfully' );

                this.getAllPermissionFunctions();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while updating the data');
                this.loading = false;
            });
        }
        this.rmanPermissions = new RmanPermissionsImpl();
        this.defaultseleted = false;
        this.displayDialog = false;
    }

    delete(rmanPermissions: any) {
        this.rmanPermissions = rmanPermissions;
        this.displayDialog = false;

        this.confirmationService.confirm({
            message: 'Are you sure you want to delete this record?',
            header: 'Confirmation',
            icon: '',
            accept: () => {
                this.rmanPermissionsList.splice(this.findSelectedPermisionsIndex(rmanPermissions), 1);
                this.rmanPermissionsService.deleteRmanPermissions(this.rmanPermissions).then((response: any) => {
                    this.rmanPermissions = new RmanPermissionsImpl();
                    this.getAllPermissionFunctions();
                });
                this.notificationService.showSuccess('Deleted succesfully');
            },
            reject: () => {
                this.notificationService.showWarning('You have rejected');
            }
        });
    }

    prepareSaveEditObject(): RmanPermissionsImpl {
        let permissionsData = new RmanPermissionsImpl();
        permissionsData.roleid = this.pResponsibilityId;
        permissionsData.functionId = this.selectedRmanFunction;
        permissionsData.enabledFlag = this.rmanPermissions.enabledFlag;
        permissionsData.startDateActive = this.rmanPermissions.startDateActive;
        permissionsData.endDateActive = this.rmanPermissions.endDateActive;
        this.editableRfId != null ? permissionsData.rfid = this.editableRfId : permissionsData.rfid = null;
        this.selectedPermissionsList.forEach((permission) => {

            if(permission.code == 'read') permissionsData.read = 1;
                
            if(permission.code == 'write') permissionsData.write = 1;
                
            if(permission.code == 'upload') permissionsData.upload = 1;

            if (permissionsData.read == undefined) permissionsData.read = 0 ;

            if (permissionsData.write == undefined) permissionsData.write = 0 ;

            if (permissionsData.upload == undefined) permissionsData.upload = 0 ;

        });
        return permissionsData;
    }


    editRow(rmanPermissions: any) {
        this.newRmanPermissions = false;
        this.rmanPermissions = this.cloneRmanPermissions(rmanPermissions);
        this.preparePreseletedPermissions(this.rmanPermissions);
        this.selectedRmanModule = this.rmanPermissions.rmanFunctions.module;
        this.selectedRmanFunction = this.rmanPermissions.functionId;
        if (this.rmanPermissions.startDateActive) {
            this.rmanPermissions.startDateActive = new Date(this.rmanPermissions.startDateActive);
        }
        if (this.rmanPermissions.startDateActive) {
            this.rmanPermissions.startDateActive = new Date(this.rmanPermissions.startDateActive);
        }
        this.defaultseleted = true;
        this.editableRfId = this.rmanPermissions.rfid;
        this.displayDialog = true;
        this.prepareRmanResponsibilitiesObject();
    }

    preparePreseletedPermissions(rmanPermissions: RmanPermissionsImpl) {
        this.selectedPermissionsList = [];
        
        if(rmanPermissions.read == 1)  this.selectedPermissionsList.push({ name: 'Read', code: 'read' });
        if(rmanPermissions.write == 1) this.selectedPermissionsList.push({ name: 'Write', code: 'write' });
        if(rmanPermissions.upload == 1) this.selectedPermissionsList.push({ name: 'Upload', code: 'upload' });
    }


    findSelectedPermisionsIndex(selectedPermissions): number {
        return this.rmanPermissionsList.indexOf(selectedPermissions);
    }

    onRowSelect(event: any) {

    }

    cloneRmanPermissions(c: RmanPermissions): RmanPermissions {
        let rmanPermissions: any
            = new RmanPermissionsImpl();
        for (let prop in c) {
            rmanPermissions[prop] = c[prop];
        }
        return rmanPermissions;
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

        this.rmanPermissionsSearch = new RmanPermissionsImpl();

        if (this.isSerached == 0) {
            this.rmanPermissionsSearch = new RmanPermissionsImpl();
        }
        this.displaySearchDialog = true;

    }

    search() {

        this.isSerached = 1;
        this.rmanPermissions = this.rmanPermissionsSearch;
        this.paginationOptions = {};
        this.getAllPermissionFunctions();
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


class RmanPermissionsImpl {
    constructor(
        public read?: any,
        public upload?: any,
        public write?: any,
        public rfid?: any,
        public roleid?: any,
        public functionId?: any,
        public rmanFunctions?: RmanFunctions,
        public enabledFlag?: any,
        public startDateActive?: any,
        public endDateActive?: any) { }
}

interface ILabels {
    [index: string]: string;
}
