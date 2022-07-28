import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ConfirmationService } from 'primeng/api';
import { Table } from 'primeng/table';
import { RmanLegalEntitiesService } from '../rmanLegalEntities/rmanLegalEntitiesservice';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { RmanProductsImpl } from '../rmanProducts/rmanProducts.component';
import { RmanProductsLabels } from '../rmanProducts/rmanProductsLabels';
import { RmanProductsService } from '../rmanProducts/rmanProductsservice';
import { NotificationService } from '../shared/notifications.service';
import { RmanApprovalRules } from './rmanApprovalRules';
import { RmanApprovalRulesService } from './rmanApprovalRulesservice';
import { CommonSharedService } from '../shared/common.service';
declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
  templateUrl: './rmanApprovalRules.component.html',
  selector: 'rmanApprovalRules-data',
  providers: [RmanApprovalRulesService, RmanProductsService, RmanLegalEntitiesService, ConfirmationService]
})

export class RmanApprovalRulesComponent implements OnInit {


  displayDialog: boolean;

  displaySearchDialog: boolean;

  displayItemSearchDialog: boolean;

  isSerached: number = 0;

  searched: number = 0;
  rmanApprovalRulesList: any[];

  cols: any[];


  popupFlag: any;
  columnOptions: any[];

  paginationOptions: any;

  pages: {};

  datasource: any[];
  pageSize: number;
  totalElements: number;
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
  exportCols: string[] = [];
  isCreate: boolean;
  rmanApprovalRuleForm: FormGroup;

  rmanApprovalRule: any = new RmanApprovalRulesImpl();
  rmanApprovalRuleSearch: any = new RmanApprovalRulesImpl();

  rmanLegalEntitiesLookup: any[] = [];
  rolesLookup: any[] = [];
  approvalCriteriaLookup: any[] = [];
  approvalUserRolesLookup: any[] = [];
  assigneeTypesLookup: any[] = [];
  geoLookup: any[] = [];
  activeFlagLookup: any[] = [];
  rmanLegalEntitiesList: any[];
  rmanUserRolesList: any[];
  rmanGeoList: any[];
  rmanAssigneeTypeList: any[];
  rmanApprovalCriteriaList: any[];
  rmanApprovalUserRolesList: any[];
  entityName: any[];
  disableRanking: boolean;


  constructor(private rmanApprovalRulesService: RmanApprovalRulesService, private rmanLookupsVService: RmanLookupsVService, private formBuilder: FormBuilder,
    private rmanLegalEntitiesService: RmanLegalEntitiesService, private confirmationService: ConfirmationService,
    private notificationService: NotificationService, private commonSharedService: CommonSharedService) {

    // generate list code
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    this.loading = true;
  }

  ngOnInit() {

    this.getAllRmanLegalEntities();

    //role lookup
    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'USER_ROLES' }).then((data: any) => {
      this.rmanUserRolesList = data.content;
      this.prepareUserRolesLookupObject();
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting "Identifier" data');
      this.loading = false;
    });

    //geo lookup
    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'GEO_TYPE' }).then((data: any) => {
      this.rmanGeoList = data.content;
      this.prepareGeoLookupObject();
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting "Identifier" data');
      this.loading = false;
    });

    //assignee type
    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'ASSIGNEE_TYPE' }).then((data: any) => {
      this.rmanAssigneeTypeList = data.content;
      this.prepareAssigneeTypeLookupObject();
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting "Identifier" data');
      this.loading = false;
    });

    //approval Criteria
    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'APPROVAL_CRITERIA' }).then((data: any) => {
      this.rmanApprovalCriteriaList = data.content;
      this.prepareApprovalCriteriaLookupObject();
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting "Identifier" data');
      this.loading = false;
    });

    //ranking 
    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'APPROVAL_USER_ROLES' }).then((data: any) => {
      this.rmanApprovalUserRolesList = data.content;
      this.prepareApprovalUserRolesLookupObject();
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting "Approval User Roles" lookup data');
      this.loading = false;
    });


    this.activeFlagLookup.push({ label: 'Select Active Flag', value: null });
    this.activeFlagLookup.push({ label: 'Y', value: 'Y' });
    this.activeFlagLookup.push({ label: 'N', value: 'N' });

    // this.getAllRmanApprovalRules();
    this.globalCols = [
      { field: 'ranking', header: 'Ranking', showField: true, drag: true, display: "table-cell", type: 'number' },
      { field: 'entityId', header: 'Legal Entity', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'userRole', header: 'Role', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'approvalcriteria', header: 'Approval Criteria', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'minValue', header: 'Min', showField: true, drag: true, display: "table-cell", type: 'number' },
      { field: 'maxValue', header: 'Max', showField: true, drag: true, display: "table-cell", type: 'number' },
      { field: 'assigneeType', header: 'Assignee Type', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'geo', header: 'Geo', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'activeFlag', header: 'Active', showField: true, drag: true, display: "table-cell", type: 'text' }
    ];

    this.buildForm();

    this.columns = [];
    this.getTableColumns("rmanApprovalRules", "Manage Approval Rules");

  }

  getAllRmanLegalEntities() {
    this.loading = true;
    this.rmanLegalEntitiesService.getAllRmanLegalEntities(this.paginationOptions, {}, "Y").then((rmanLegalEntitiesList: any) => {
      this.rmanLegalEntitiesList = rmanLegalEntitiesList.content;
      this.prepareRmanLegalEntitiesObject();
      this.loading = false;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting "Legal Entity" data');
      this.loading = false;
    });
  }

  prepareApprovalCriteriaLookupObject() {
    let rmanLookupsV1TempObj: any = [{ label: 'Select Approval Criteria', value: null }];
    this.rmanApprovalCriteriaList.forEach((rmanLookupsV1) => {
      rmanLookupsV1TempObj.push({ label: rmanLookupsV1.lookupDescription, value: rmanLookupsV1.lookupCode });
    });

    this.approvalCriteriaLookup = rmanLookupsV1TempObj;

  }

  prepareApprovalUserRolesLookupObject(){
    let rmanLookupsV1TempObj: any = [{ label: 'Select Approval Rule User Role', value: null }];
    this.rmanApprovalUserRolesList.forEach((rmanLookupsV1) => {
      rmanLookupsV1TempObj.push({ label: rmanLookupsV1.lookupDescription, value: rmanLookupsV1.lookupCode });
    });

    this.approvalUserRolesLookup = rmanLookupsV1TempObj;
  }


  prepareAssigneeTypeLookupObject() {
    let rmanLookupsV1TempObj: any = [{ label: 'Select Assignee Type', value: null }];
    this.rmanAssigneeTypeList.forEach((rmanLookupsV1) => {
      rmanLookupsV1TempObj.push({ label: rmanLookupsV1.lookupDescription, value: rmanLookupsV1.lookupCode });
    });

    this.assigneeTypesLookup = rmanLookupsV1TempObj;

  }

  prepareGeoLookupObject() {
    let rmanLookupsV1TempObj: any = [{ label: 'Select Geo', value: null }];
    this.rmanGeoList.forEach((rmanLookupsV1) => {
      rmanLookupsV1TempObj.push({ label: rmanLookupsV1.lookupDescription, value: rmanLookupsV1.lookupCode });
    });

    this.geoLookup = rmanLookupsV1TempObj;

  }

  prepareUserRolesLookupObject() {
    let rmanLookupsV1TempObj: any = [{ label: 'Select Role', value: null }];
    this.rmanUserRolesList.forEach((rmanLookupsV1) => {
      rmanLookupsV1TempObj.push({ label: rmanLookupsV1.lookupDescription, value: rmanLookupsV1.lookupCode });
    });

    this.rolesLookup = rmanLookupsV1TempObj;

  }

  prepareRmanLegalEntitiesObject() {
    let rmanLegalEntitiesTempObj: any = [{ label: appSettings.dropDownOptions.selectLegalEntity, value: null }];
    this.rmanLegalEntitiesList.forEach((rmanLegalEntities) => {
      rmanLegalEntitiesTempObj.push({ label: rmanLegalEntities.name, value: rmanLegalEntities.legalEntityId });
    });
    this.rmanLegalEntitiesLookup = rmanLegalEntitiesTempObj;
  }

  buildForm() {
    this.rmanApprovalRuleForm = this.formBuilder.group({
      'ranking': ['', [Validators.required]],
      'legalEntity': ['', [Validators.required]],
      'role': ['', [Validators.required]],
      'approvalCriteria': ['', [Validators.required]],
      'min': ['', [Validators.required]],
      'max': ['', []],
      'assigneeType': ['', [Validators.required]],
      'active': ['', [Validators.required]],
      'geo': ['', []]
    });
    this.rmanApprovalRuleForm.valueChanges
      .subscribe(data => this.onValueChanged(data));
    this.onValueChanged();
  }

  onValueChanged(data?: any) {
    if (!this.rmanApprovalRuleForm) { return; }
    const form = this.rmanApprovalRuleForm;

    for (const field in this.formErrors) {
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
    'ranking': '', 'legalEntity': '', 'role': '', 'approvalCriteria': '', 'min': '', 'max': '', 'assigneeType': '', 'active': '', 'geo': ''
  };

  validationMessages = {
    'ranking': { 'required': "Ranking is required" },
    'legalEntity': { 'required': "Legal Entity is required" },
    'role': { 'required': "Role is required" },
    'approvalCriteria': { 'required': "Approval Criteria is required" },
    'min': { 'required': "Min Value is required" },
    'max': { 'required': "Max Value is required" },
    'assigneeType': { 'required': "Assignee Type is required" },
    'active': { 'required': "Active Flag is required" },
    'geo': { 'required': "Geo is required" },
  }

  showDialogToSearch() {
    this.rmanApprovalRuleSearch = new RmanApprovalRulesImpl();
    this.displaySearchDialog = true;
  }

  search() {
    this.displaySearchDialog = false;
    this.paginationOptions = {};
    this.rmanApprovalRule = this.rmanApprovalRuleSearch;
    this.getAllRmanApprovalRules();
  }


  showDialogToAdd() {
    this.displayDialog = true;
    this.isCreate = true;
    this.rmanApprovalRule = new RmanApprovalRulesImpl();
    this.buildForm();
  }

  reset(dt: any) {
    this.loading = true;
    this.paginationOptions = {};
    this.rmanApprovalRule = new RmanApprovalRulesImpl();
    dt.reset();
  }

  onSelectUserRole(role: any){
    let selectedRoleObj = this.rmanApprovalUserRolesList.filter((item: any)=> item.lookupDescription == role)
    this.rmanApprovalRule.ranking = selectedRoleObj[0].lookupCode;
    this.disableRanking = true;
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
    this.commonSharedService.saveOrUpdateTableColumns("rmanApprovalRules", "Manage Approval Rules", selectedCols, this.userId).then((response) => {
      this.columns = this.globalCols.filter(item => item.showField);
      this.userId = response["userId"];
      this.showPaginator = this.columns.length !== 0;
      this.loading = false;
    }).catch(() => {
      this.notificationService.showError('Error occured while fetching Columns data');
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

  transformRmanLegalEntity(entityId: any) {
    if (this.rmanLegalEntitiesList != undefined && this.rmanLegalEntitiesList != null) {
      for (var i = 0; i < this.rmanLegalEntitiesList.length; i++) {
        if (this.rmanLegalEntitiesList[i].legalEntityId == entityId) {
          return this.rmanLegalEntitiesList[i].name;
        }
      }
    } else {
      return null;
    }

  }

  transformToEntityId(entityName: any) {
    for (var i = 0; i < this.rmanLegalEntitiesList.length; i++) {
      if (this.rmanLegalEntitiesList[i].name == entityName) {
        return this.rmanLegalEntitiesList[i].legalEntityId;
      }
    }

  }

  onHide(event: any) {

  }

  getAllRmanApprovalRules() {
    this.loading = true;
    this.rmanApprovalRulesService.getAllRmanApprovalRules(this.paginationOptions, this.rmanApprovalRule, this.exportCols).then((rmanApprovalRulesList: any) => {
      this.loading = false;
      this.datasource = rmanApprovalRulesList.content;
      this.rmanApprovalRulesList = rmanApprovalRulesList.content;
      this.totalElements = rmanApprovalRulesList.totalElements;
      this.pageSize = rmanApprovalRulesList.size;
      this.displaySearchDialog = false;
      this.rmanApprovalRulesList.forEach(obj => {
        obj.entityId = this.transformRmanLegalEntity(obj.entityId);

      });
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }


  getRmanApprovalRules(event: any) {
    this.loading=true;
    this.rmanLegalEntitiesService.getAllRmanLegalEntities({}, {}, "Y").then((rmanLegalEntitiesList: any) => {
      this.rmanLegalEntitiesList = rmanLegalEntitiesList.content;
      this.prepareRmanLegalEntitiesObject();
      let first: number = event.first;
      let rows: number = event.rows;
      let pageNumber: number = first / rows;
      this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
      this.loading = true;
      this.rmanApprovalRulesService.getAllRmanApprovalRules(this.paginationOptions, this.rmanApprovalRule, this.exportCols).then((rmanApprovalRulesList: any) => {
        this.loading = false;
        this.datasource = rmanApprovalRulesList.content;
        this.rmanApprovalRulesList = rmanApprovalRulesList.content;
        this.totalElements = rmanApprovalRulesList.totalElements;
        this.pageSize = rmanApprovalRulesList.size;
        this.rmanApprovalRulesList.forEach(obj => {
          obj.entityId = this.transformRmanLegalEntity(obj.entityId);

        });
      })
    }).catch((err: any) => {
      console.error('Error Occured', err);
      this.notificationService.showError('Error occured while fetching data');
      this.loading = false;
    });

  }


  editRow(rmanApprovalRule: any) {
    this.disableRanking = true;
    this.isCreate = false;
    this.rmanApprovalRule = this.cloneApprovalRules(rmanApprovalRule);
    this.entityName = rmanApprovalRule.entityId;
    this.rmanApprovalRule.entityId = this.transformToEntityId(this.entityName);
    this.displayDialog = true;
  }

  cloneApprovalRules(c: RmanApprovalRules): RmanApprovalRules {
    let rmanApprovalRule: any = new RmanApprovalRulesImpl();
    for (let prop in c) {
      rmanApprovalRule[prop] = c[prop];
    }
    return rmanApprovalRule;
  }

  cancel() {
    this.displayDialog = false;
    this.rmanApprovalRule = new RmanApprovalRulesImpl();
  }

  onRowSelect(event: any) {

  }

  saveOrUpdate(msg: any){
    this.notificationService.showSuccess(msg);
    this.displayDialog = false;
    this.rmanApprovalRule = new RmanApprovalRulesImpl();
    this.getAllRmanApprovalRules();
  }

  save() {
    this.loading = true;
    this.displayDialog = false;

    if (this.isCreate) {
      this.rmanApprovalRulesService.saveApprovalRule(this.rmanApprovalRule).then((response: any) => {
        this.saveOrUpdate('Saved successfully');
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while saving data');
        this.loading = false;
      });
    } else {
      this.rmanApprovalRulesService.updateApprovalRule(this.rmanApprovalRule).then((response: any) => {
        this.saveOrUpdate('Updated successfully');
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while updating data');
        this.loading = false;
      });
    }
  }

  delete(rmanApprovalRule: any) {
    this.displayDialog = false;
    this.confirmationService.confirm({
      message: 'Are you sure you want to delete this record?',
      header: 'Confirmation',
      icon: '',
      accept: () => {
        this.loading = true;
        this.rmanApprovalRulesService.deleteApprovalRule(rmanApprovalRule).then((response: any) => {
          this.rmanApprovalRule = new RmanApprovalRulesImpl();
          this.getAllRmanApprovalRules();
        });
        this.notificationService.showSuccess('Deleted successfully');
      },
      reject: () => {
        this.notificationService.showWarning('You have rejected');
      }
    });

  }


}


class RmanApprovalRulesImpl {
  constructor(
    ruleId?: any,
    ranking?: any,
    entityId?: any,
    userRole?: any,
    approvalcriteria?: any,
    minValue?: any,
    maxValue?: any,
    assigneeType?: any,
    geo?: any,
    activeFlag?: any
  ) { }
}

interface ILabels {
  [index: string]: string;
}

