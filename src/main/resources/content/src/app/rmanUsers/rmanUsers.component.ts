import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ConfirmationService, Message } from 'primeng/api';
import { Table } from 'primeng/table';
import { RmanLegalEntitiesService } from '../rmanLegalEntities/rmanLegalEntitiesservice';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { RmanUserResponsibilitiesComponent } from '../rmanUserResponsibilities/rmanUserResponsibilities.component';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanUsers } from './rmanUsers';
import { RmanUsersLabels } from './rmanUsersLabels';
import { RmanUsersService } from './rmanUsersservice';
declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
  templateUrl: './rmanUsers.component.html',
  selector: 'rmanUsers-data',
  providers: [RmanUsersService, ConfirmationService, RmanLegalEntitiesService]
})

export class RmanUsersComponent implements OnInit {

  displayDialog: boolean;

  displaySearchDialog: boolean;

  rmanUsers: any = new RmanUsersImpl();

  rmanUsersSearch: any = new RmanUsersImpl();

  isSerached: number = 0;

  showMsg: any;

  msgs: Message[] = [];



  selectedRmanUsers: RmanUsers;

  pRmanUserId: number;

  newRmanUsers: boolean;

  rmanUsersList: any[];
  totalRmanUsersList: any[];
  rmanLegalEntities: any[];
  rmanLegalEntitiesList: any[];
  rmanUsersOpt: any[];
  cols: any[];
  userColumns: ILabels;

  columnOptions: any[];

  paginationOptions: any;

  pages: {};

  datasource: any[];
  pageSize: number;
  totalElements: number;

  collapsed: boolean = true;

  rmanLookupsVList: any[] = [];
  rmanLookupsV: any[];

  usersForm: FormGroup;
  noData = appSettings.noData;
  loading: boolean;
  @ViewChild(RmanUserResponsibilitiesComponent) private childTable: RmanUserResponsibilitiesComponent;

  isSelectAllChecked = true;
  globalCols: any[];
  clonedCols: any[];
  userId: number;
  showPaginator: boolean = true;
  startIndex: number;
  showAddColumns = true;
  columns: any[];

  constructor(private rmanUsersService: RmanUsersService, private rmanLegalEntitiesService: RmanLegalEntitiesService, private formBuilder: FormBuilder, private confirmationService: ConfirmationService, private rmanLookupsVService: RmanLookupsVService,
    private notificationService: NotificationService, private commonSharedService: CommonSharedService) {

    // generate list code
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
   
   /* this.loading = true;
    this.rmanLegalEntitiesService.getAllRmanLegalEntities(this.paginationOptions, {}, "Y").then((rmanLegalEntitiesList: any) => {
      this.rmanLegalEntitiesList = rmanLegalEntitiesList.content;
      this.prepareRmanLegalEntitiesObject();
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting "Legal Entity" data');
      this.loading = false;
    });*/


    this.loading = true;
    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'ENABLED_FLAG' }).then((rmanLookupsVList: any) => {
      this.rmanLookupsVList = rmanLookupsVList.content;
      this.prepareRmanLookupsVObject();
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting "Enabled Flag" data');
      this.loading = false;
    });

   this.getAllUsers();

  }

  getAllUsers(){
    this.loading = true;
    this.rmanUsersService.getAllRmanUsers(this.paginationOptions, {}, true).then((totalRmanUsersList: any) => {
      this.totalRmanUsersList = totalRmanUsersList.content;
      this.prepareRmanUsersObject();
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while fetching all User names');
      this.loading = false;
    });
  }

  prepareRmanUsersObject() {
    let rmanUsersTempObj: any = [{ label: appSettings.dropDownOptions.selectManager, value: null }];
    this.totalRmanUsersList.forEach((rmanUsers) => {
      rmanUsersTempObj.push({ label: rmanUsers.fullName, value: rmanUsers.rmanUserId });
    });
    this.rmanUsersOpt = rmanUsersTempObj;
  }

  prepareRmanLookupsVObject() {
    let rmanLookupsVTempObj: any = [{ label: appSettings.dropDownOptions.selectEnabledFlag, value: null }];
    this.rmanLookupsVList.forEach((rmanLookupsV) => {
      rmanLookupsVTempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
    });
    this.rmanLookupsV = rmanLookupsVTempObj;
  }

  ngOnInit() {

    this.rmanLegalEntitiesService.getAllRmanLegalEntities(this.paginationOptions, {}, "Y").then((rmanLegalEntitiesList: any) => {
      this.rmanLegalEntitiesList = rmanLegalEntitiesList.content;
      this.prepareRmanLegalEntitiesObject();
    })

    this.globalCols = [
      { field: 'userName', header: 'User Name', showField: true, drag: false, display: "table-cell", type: 'text' },
      { field: 'firstName', header: 'First Name', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'lastName', header: 'Last Name', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'fullName', header: 'Full Name', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'homePhone', header: 'Home Phone', showField: true, drag: true, display: "table-cell", type: 'number' },
      { field: 'workPhone', header: 'Work Phone', showField: true, drag: true, display: "table-cell", type: 'number' },
      { field: 'cellPhone', header: 'Cell Phone', showField: true, drag: true, display: "table-cell", type: 'number' },
      { field: 'emailAddress', header: 'Email Address', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'rmanEmployeeId', header: 'Employee Id', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'startDateActive', header: 'Start Date', showField: true, drag: true, display: "table-cell", type: 'date' },
      { field: 'endDateActive', header: 'End Date', showField: true, drag: true, display: "table-cell", type: 'date' },
      { field: 'enabledFlag', header: 'Enabled Flag', showField: true, drag: true, display: "table-cell", type: 'text' }

    ];

    this.columns = [];
    this.getTableColumns("rmanUsers", "Users");

    let rmanUsersLabels = new RmanUsersLabels();
    this.userColumns = rmanUsersLabels.fieldLabels;
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
    this.commonSharedService.saveOrUpdateTableColumns("rmanUsers", "Users", selectedCols, this.userId).then((response) => {
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
    this.rmanUsers = new RmanUsersImpl();
    dt.reset();
  }

  cancelSearch() {
    this.displaySearchDialog = false;
    this.rmanUsersSearch = new RmanUsersImpl();
  }
  cancelEdit() {
    this.displayDialog = false;
    this.rmanUsers = new RmanUsersImpl();

  }
  buildForm() {
    this.usersForm = this.formBuilder.group({
      'name': ['', [
        Validators.required, Validators.minLength(4), Validators.maxLength(40)
      ]
      ],
      'activeDate': ['', [Validators.required]],
      'password': ['', [Validators.required, Validators.minLength(8), Validators.maxLength(20), Validators.pattern(/^(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]){8,}/)]],
      'firstName': ['', [Validators.required]],
      'legalEntityId': [this.rmanUsers.legalEntityId, []],
      'emailAddress': ['', [Validators.required, Validators.pattern(/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/)]],
      'workPhone': ['', [Validators.required]],
      'flag': ['', [Validators.required]]
    });

    this.usersForm.valueChanges
      .subscribe(data => this.onValueChanged(data));

    this.onValueChanged();
  }


  onValueChanged(data?: any) {
    if (!this.usersForm) { return; }
    const form = this.usersForm;

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
    'name': '', 'activeDate': '', 'password': '', 'firstName': '', 'legalEntityId': '', 'emailAddress': '', 'workPhone': '', 'flag': ''
  };


  validationMessages = {
    'name': {
      'required': "Name is required (minimum length is 4 and maximum length is 40 characters)",
      'minlength': 'Name must be at least 4 characters long.',
      'maxlength': 'Name cannot be more than 40 characters long.',
    },
    'activeDate': {
      'required': "Start Date Active is Required"
    },
    'password': {
      'required': "Password is required",
      'pattern': "Enter a valid password.(Atleast one lower case letter,one upper case letter, one digit and one special character(!@#$%^&* ))",
      'minlength': 'Password must be at least 8 characters long.',
      'maxlength': 'Password cannot be more than 20 characters long.',
    },
    'firstName': {
      'required': "First name is required"
    },
    'legalEntityId': {
      'required': "Legal Entity is required"
    },
    'emailAddress': {
      'required': "Email Address is required",
      'pattern': "Enter a valid email address."
    },
    'workPhone': {
      'required': "Work Phone is required"
    },
    'flag': {
      'required': "Enabled Flag is required"
    }
  }




  getAllRmanUsers() {
    this.loading = true;
    this.rmanUsersService.getAllRmanUsers(this.paginationOptions, this.rmanUsers, false).then((rmanUsersList: any) => {
      this.loading = false;
      this.datasource = rmanUsersList.content;
      this.rmanUsersList = rmanUsersList.content;
      if (this.rmanUsersList && this.rmanUsersList.length > 0) {

        /*Begining of Code used for default First Row Selected*/
        this.selectedRmanUsers = this.rmanUsersList[0];
        this.pRmanUserId = this.selectedRmanUsers.rmanUserId;
        /*End of Code used for default First Row Selected*/
        this.childTable.parentCall(this.selectedRmanUsers);
      }
      else {
        this.childTable.parentCall('');
      }

      this.totalElements = rmanUsersList.totalElements;
      // this.prepareRmanUsersObject();
      this.pageSize = rmanUsersList.size;
      this.displaySearchDialog = false;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }


  getRmanUsers(event: any) {

    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loading = true;
    this.rmanUsersService.getAllRmanUsers(this.paginationOptions, this.rmanUsers, false).then((rmanUsersList: any) => {
      this.loading = false;
      this.datasource = rmanUsersList.content;
      this.rmanUsersList = rmanUsersList.content;
      if (this.rmanUsersList.length > 0) {
        /*Begining of Code used for default First Row Selected*/
        this.selectedRmanUsers = this.rmanUsersList[0];
        this.childTable.parentCall(this.selectedRmanUsers);
        this.pRmanUserId = this.selectedRmanUsers.rmanUserId;
        /*End of Code used for default First Row Selected*/
      }
      //this.prepareRmanUsersObject();
      this.totalElements = rmanUsersList.totalElements;
      this.pageSize = rmanUsersList.size;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });

  }


  showDialogToAdd() {

    this.newRmanUsers = true;
    this.rmanUsers = new RmanUsersImpl();
    this.displayDialog = true;
    this.buildForm();
  }

  saveOrUpdate(msg: any){
    this.notificationService.showSuccess(msg);
    this.displayDialog = false;
    this.rmanUsers = new RmanUsersImpl();
    this.getAllRmanUsers();
    this.getAllUsers();
  }

  save() {
    if (this.rmanUsers) delete this.rmanUsers['rmanUserResponsibilitiesSet'];
    if (this.newRmanUsers) {
      this.loading = true;
      this.rmanUsersService.saveRmanUsers(this.rmanUsers).then((response: any) => {
       this.saveOrUpdate('Saved successfully');
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while saving data');
        this.loading = false;
      });
    }
    else {
      this.loading = true;
      this.rmanUsersService.updateRmanUsers(this.rmanUsers).then((response: any) => {
        this.saveOrUpdate('Updated successfully');
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while updating data');
        this.loading = false;
      });
    }
  }


  delete(rmanUsers: any) {
    this.rmanUsers = rmanUsers;
    if (this.rmanUsers.lastUpdateDate) {
      this.rmanUsers.lastUpdateDate = new Date(this.rmanUsers.lastUpdateDate);
    }
    if (this.rmanUsers.endDateActive) {
      this.rmanUsers.endDateActive = new Date(this.rmanUsers.endDateActive);
    }
    if (this.rmanUsers.startDateActive) {
      this.rmanUsers.startDateActive = new Date(this.rmanUsers.startDateActive);
    }
    this.displayDialog = false;
    this.confirmationService.confirm({
      message: 'Are you sure you want to delete this record?',
      header: 'Confirmation',
      icon: '',
      accept: () => {
        this.rmanUsersList.splice(this.findSelectedRmanUsersIndex(), 1);
        this.loading = true;
        this.rmanUsersService.deleteRmanUsers(this.rmanUsers).then((response: any) => {

          this.rmanUsers = new RmanUsersImpl();
          this.getAllRmanUsers();
          this.getAllUsers(); 
        });
        this.notificationService.showSuccess('Deleted successfully');
      },
      reject: () => {
        this.notificationService.showWarning('You have rejected');
      }
    });
  }


  editRow(rmanUsers: any) {
    this.newRmanUsers = false;
    this.rmanUsers = this.cloneRmanUsers(rmanUsers);
    if (this.rmanUsers.lastUpdateDate) {
      this.rmanUsers.lastUpdateDate = new Date(this.rmanUsers.lastUpdateDate);
    }
    if (this.rmanUsers.endDateActive) {
      this.rmanUsers.endDateActive = new Date(this.rmanUsers.endDateActive);
    }
    if (this.rmanUsers.startDateActive) {
      this.rmanUsers.startDateActive = new Date(this.rmanUsers.startDateActive);
    }

    this.displayDialog = true;
    this.prepareRmanLegalEntitiesObject();
    this.usersForm.patchValue({
      legalEntityId: this.rmanUsers.rmanLegalEntities.legalEntityId,
    })
    this.usersForm.updateValueAndValidity();

  }

  findSelectedRmanUsersIndex(): number {
    return this.rmanUsersList.indexOf(this.selectedRmanUsers);
  }

  onRowSelect(event: any) {
    this.selectedRmanUsers = event.data;
    this.pRmanUserId = this.selectedRmanUsers.rmanUserId;
    this.childTable.parentCall(event.data);

  }
  onRowUnSelect() {
    this.childTable.parentCall('');
  }

  cloneRmanUsers(c: RmanUsers): RmanUsers {
    let rmanUsers: any = new RmanUsersImpl();
    for (let prop in c) {
      rmanUsers[prop] = c[prop];
    }
    return rmanUsers;
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

    this.rmanUsersSearch = new RmanUsersImpl();

    if (this.isSerached == 0) {
      this.rmanUsersSearch = new RmanUsersImpl();
    }
    this.displaySearchDialog = true;

  }

  search() {

    this.isSerached = 1;
    this.rmanUsers = this.rmanUsersSearch;
    this.paginationOptions = {};
    this.getAllRmanUsers();
  }

  prepareRmanLegalEntitiesObject() {
    let rmanLegalEntitiesTempObj: any = [{ label: appSettings.dropDownOptions.selectLegalEntity, value: null }];
    this.rmanLegalEntitiesList.forEach((rmanLegalEntities) => {
      rmanLegalEntitiesTempObj.push({ label: rmanLegalEntities.name, value: rmanLegalEntities.legalEntityId });
    });
    this.rmanLegalEntities = rmanLegalEntitiesTempObj;
  }

  onBeforeToggle(evt: any) {
    this.collapsed = evt.collapsed;
  }


}


export class RmanUsersImpl {
  constructor(public attribute3?: any, public createdBy?: any, public attribute2?: any, public lastUpdatedBy?: any, public startDateActive?: any, public attribute1?: any, public rmanEmployeeId?: any, public creationDate?: any, public userName?: any, public lastName?: any, public lastUpdateDate?: any, public workPhone?: any, public firstName?: any, public attribute5?: any, public attribute4?: any, public cellPhone?: any, public emailAddress?: any, public userPassword?: any, public mgrId?: any, public fullName?: any, public homePhone?: any, public endDateActive?: any, public rmanUserId?: any, public enabledFlag?: any) { }
}

interface ILabels {
  [index: string]: string;
}
