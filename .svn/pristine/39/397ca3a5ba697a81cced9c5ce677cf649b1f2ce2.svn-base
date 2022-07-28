import { Component, EventEmitter, OnChanges, OnDestroy, OnInit, Output, SimpleChange } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ConfirmationService, Message } from 'primeng/api';
import { Table } from 'primeng/table';
import { RmanEntityParametersVService } from '../rmanEntityParametersV/rmanEntityParametersVservice';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanFmvRulesDefParaValue } from './rmanFmvRulesDefParaValue';
import { RmanFmvRulesDefParaValueLabels } from './rmanFmvRulesDefParaValueLabels';
import { RmanFmvRulesDefParaValueService } from './rmanFmvRulesDefParaValueservice';

declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');
@Component({
  templateUrl: './rmanFmvRulesDefParaValue.component.html',
  selector: 'rmanFmvRulesDefParaValue-data',
  providers: [RmanFmvRulesDefParaValueService, RmanEntityParametersVService, ConfirmationService]
})

export class RmanFmvRulesDefParaValueComponent implements OnInit, OnDestroy, OnChanges {

  displayDialog: boolean;

  displayConfirmation: boolean;

  pParameterValueId: any;

  displaySearchDialog: boolean;

  msgs: Message[] = [];

  

  rmanFmvRulesDefParaValue: any = new RmanFmvRulesDefParaValueImpl();

  rmanFmvRulesDefParaValueSearch: any = new RmanFmvRulesDefParaValueImpl();
  isSerached: number = 0;
  pFmvRuleDefId: number;
  @Output() notifyPameterExist = new EventEmitter();

  selectedRmanFmvRulesDefParaValue: RmanFmvRulesDefParaValue;

  newRmanFmvRulesDefParaValue: boolean;

  rmanFmvRulesDefParaValueList: any[];

  cols: any[];
  columns: ILabels;

  columnOptions: any[];

  paginationOptions: any;

  pages: {};

  datasource: any[];
  pageSize: number;
  totalElements: number;


  rmanLookupsVList: any[] = [];
  rmanLookupsV: any[];
  rmanLookupsV1List: any[] = [];
  rmanLookupsV1: any[];
  rmanEntityParametersVList: any[] = [];
  rmanEntityParametersV: any[];

  collapsedParameterValues: boolean = true;

  parameterValuesForm: FormGroup;
  loading: boolean;
  noData = appSettings.noData;

  masterData: any;
  pFmvRuleDefParentStatus: string;


  constructor(private rmanFmvRulesDefParaValueService: RmanFmvRulesDefParaValueService
    , private rmanLookupsVService: RmanLookupsVService
    , private rmanEntityParametersVService: RmanEntityParametersVService
    , private formBuilder: FormBuilder
    , private confirmationService: ConfirmationService
    , private commonSharedService: CommonSharedService,
    private notificationService: NotificationService) {

    // generate list code
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    this.loading = true;
    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'RULE_CONDITION' }).then((rmanLookupsVList: any) => {
      this.rmanLookupsVList = rmanLookupsVList.content;
      this.prepareRmanLookupsVObject();


      this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'RULE_QUALIFIER' }).then((rmanLookupsV1List: any) => {
        this.rmanLookupsV1List = rmanLookupsV1List.content;
        this.prepareRmanLookupsV1Object();

        this.rmanEntityParametersVService.getAllRmanEntityParametersV(this.paginationOptions, { 'entityName': 'Deal FMV Eligibility' }, 'Y').then((rmanEntityParametersVList: any) => {
          this.loading = false;
          this.rmanEntityParametersVList = rmanEntityParametersVList.content;
          this.prepareRmanEntityParametersVObject();
        }).catch((err: any) => {
          this.notificationService.showError('Error occured while getting "Parameter Name" data');
          this.loading = false;
        });
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while getting "Qualifier" data');
        this.loading = false;
      });
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting "AND/OR" data');
      this.loading = false;
    });

  }
  ParentCall(data) {
    this.masterData = data;
    if (data && data != '') {
      this.pFmvRuleDefId = data.fmvRuleDefId;
      this.pFmvRuleDefParentStatus = data.fmvRuleStatus;
      this.getAllRmanFmvRulesDefParaValue();
    } else {
      this.pFmvRuleDefId = null;
      this.pFmvRuleDefParentStatus = '';
      this.rmanFmvRulesDefParaValueList = [];
      this.notifyPameterExist.emit(false);
    }
  }
  ngOnChanges(changes: { [propKey: string]: SimpleChange }) {
  
  }

  ngOnInit() {
    this.cols = [];
    let cols: any = [];
    cols["attribute10"] = "attribute10";
    cols["dealFlag"] = "dealFlag";
    cols["attribute14"] = "attribute14";
    cols["attribute13"] = "attribute13";
    cols["ruleHeaderId"] = "ruleHeaderId";
    cols["attribute12"] = "attribute12";
    cols["attribute11"] = "attribute11";
    cols["lastUpdateDate"] = "lastUpdateDate";
    cols["parameterValueId"] = "parameterValueId";
    cols["parameterId"] = "parameterId";
    cols["attribute3"] = "attribute3";
    cols["createdBy"] = "createdBy";
    cols["attribute2"] = "attribute2";
    cols["lastUpdatedBy"] = "lastUpdatedBy";
    cols["attribute1"] = "attribute1";
    cols["creationDate"] = "creationDate";
    cols["attribute9"] = "attribute9";
    cols["attribute8"] = "attribute8";
    cols["attribute7"] = "attribute7";
    cols["attribute6"] = "attribute6";
    cols["attribute5"] = "attribute5";
    cols["attribute4"] = "attribute4";
    cols["parameterGroup"] = "parameterGroup";
    cols["fmvRuleDefId"] = "fmvRuleDefId";
    cols["attribute15"] = "attribute15";
    cols["qualifier"] = "qualifier";
    cols["andOr"] = "andOr";
    cols["parameterValue"] = "parameterValue";
    let rmanFmvRulesDefParaValueLabels = new RmanFmvRulesDefParaValueLabels();
    this.columns = rmanFmvRulesDefParaValueLabels.fieldLabels;
    this.columnOptions = [];
    this.cols = [];
    for (let prop in this.columns) {
      this.cols.push({ field: prop, header: this.columns[prop] });
      this.columnOptions.push({ label: this.columns[prop], value: prop });
    }
    this.buildForm();
  }

  reset(dt: Table) {
    this.paginationOptions = {};
    this.rmanFmvRulesDefParaValue = new RmanFmvRulesDefParaValueImpl();
    dt.reset();
  }

  buildForm() {
    this.parameterValuesForm = this.formBuilder.group({
      'group': ['', [
        Validators.required
      ]
      ],
      'value': ['', [Validators.required]],
      'name': ['', [Validators.required]],
      'qualifier': ['', [Validators.required]],
      'andor': ['', [Validators.required]]
    });

    this.parameterValuesForm.valueChanges
      .subscribe(data => this.onValueChanged(data));

    this.onValueChanged();
  }

  onValueChanged(data?: any) {
    if (!this.parameterValuesForm) { return; }
    const form = this.parameterValuesForm;

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
    'group': '', 'value': '', 'name': '', 'qualifier': '', 'andor': ''/*,'workspacedbUser':'' */
  };

  validationMessages = {
    'group': {
      'required': "Parameter Group is required"
    }, 'value': {
      'required': "Parameter Value is Required"
    },
    'name': {
      'required': "Parameter Name is required"
    }, 'qualifier': {
      'required': "Qualifier is required"
    },

    'andor': {
      'required': "AND/OR is required"
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

  transformRmanEntityParametersV(rmanEntityParametersV: any) {
    if (rmanEntityParametersV)
      return rmanEntityParametersV.parameterDescription;
  }



  getAllRmanFmvRulesDefParaValue(searchobj?: any) {
    let data: any;
    if (searchobj) {
      data = searchobj
    } else {
      data = { 'fmvRuleDefId': this.pFmvRuleDefId }
    }

    if (this.pFmvRuleDefId != undefined || this.pFmvRuleDefId != null) {

      this.loading = true;
      this.rmanFmvRulesDefParaValueService.getAllRmanFmvRulesDefParaValue(this.paginationOptions, data).then((rmanFmvRulesDefParaValueList: any) => {

        this.loading = false;

        this.datasource = rmanFmvRulesDefParaValueList.content;
        if (this.datasource.length == 0) {
          this.notifyPameterExist.emit(false)
        } else {
          this.notifyPameterExist.emit(true)
        }
        if (this.pFmvRuleDefId != undefined || this.pFmvRuleDefId != null) {
          this.rmanFmvRulesDefParaValueList = rmanFmvRulesDefParaValueList.content;
        }
        this.totalElements = rmanFmvRulesDefParaValueList.totalElements;
        this.pageSize = rmanFmvRulesDefParaValueList.size;
        this.displaySearchDialog = false;
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while getting data');
        this.loading = false;
      });
    }

  }


  getRmanFmvRulesDefParaValue(event: any) {
    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    if (this.pFmvRuleDefId != undefined || this.pFmvRuleDefId != null) {
      this.loading = true;
      this.rmanFmvRulesDefParaValueService.getAllRmanFmvRulesDefParaValue(this.paginationOptions, { 'fmvRuleDefId': this.pFmvRuleDefId }).then((rmanFmvRulesDefParaValueList: any) => {
        this.loading = false;
        this.datasource = rmanFmvRulesDefParaValueList.content;
        this.rmanFmvRulesDefParaValueList = rmanFmvRulesDefParaValueList.content;
        this.totalElements = rmanFmvRulesDefParaValueList.totalElements;
        this.pageSize = rmanFmvRulesDefParaValueList.size;
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while getting data');
        this.loading = false;
      });
    }
  }


  showDialogToAdd() {

    if (this.pFmvRuleDefParentStatus === 'APPROVED') {
      
      this.notificationService.showError('Reject the fair value rule to add the parameter');
    } else {
      this.newRmanFmvRulesDefParaValue = true;
      this.rmanFmvRulesDefParaValue = new RmanFmvRulesDefParaValueImpl();
      if (this.pFmvRuleDefId == null || this.pFmvRuleDefId == 0) {
        this.displayDialog = false;
        
        this.notificationService.showWarning('Please select FMV Rule');
        this.displayConfirmation = true;
      }
      else {
        this.rmanFmvRulesDefParaValue.fmvRuleDefId = this.pFmvRuleDefId;
        this.displayDialog = true;
        this.prepareRmanLookupsVObject();
        this.prepareRmanLookupsV1Object();
        this.buildForm();
      }
    }

  }

  saveOrUpdate(msg: any){
    this.notificationService.showSuccess(msg);
        $.unblockUI();
        this.getAllRmanFmvRulesDefParaValue();
  }

  save() {

    if (this.newRmanFmvRulesDefParaValue) {
      this.rmanFmvRulesDefParaValue.fmvRuleDefId = this.pFmvRuleDefId;
      $.blockUI();
      this.rmanFmvRulesDefParaValueService.saveRmanFmvRulesDefParaValue(this.rmanFmvRulesDefParaValue).then((response: any) => {
        this.saveOrUpdate('Saved successfully');
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while saving data');
        $.unblockUI();
      });
    }
    else {
      $.blockUI();
      this.rmanFmvRulesDefParaValueService.updateRmanFmvRulesDefParaValue(this.rmanFmvRulesDefParaValue).then((response: any) => {
        this.saveOrUpdate('Updated successfully');
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while updating data');
        $.unblockUI();
      });
    }

    this.rmanFmvRulesDefParaValue = new RmanFmvRulesDefParaValueImpl();

    this.displayDialog = false;

  }



  delete(rmanFmvRulesDefParaValue: any) {
    this.rmanFmvRulesDefParaValue = rmanFmvRulesDefParaValue;
    this.displayDialog = false;
    this.confirmationService.confirm({
      message: 'Are you sure you want to delete this record?',
      header: 'Confirmation',
      icon: '',
      accept: () => {
        this.rmanFmvRulesDefParaValueList.splice(this.findSelectedRmanFmvRulesDefParaValueIndex(), 1);
        $.blockUI();
        this.rmanFmvRulesDefParaValueService.deleteRmanFmvRulesDefParaValue(this.rmanFmvRulesDefParaValue).then((response: any) => {
          $.unblockUI();
          this.rmanFmvRulesDefParaValue = new RmanFmvRulesDefParaValueImpl();
          this.getAllRmanFmvRulesDefParaValue();
        });
        this.notificationService.showSuccess('Deleted successfully');
      },
      reject: () => {
        this.notificationService.showWarning('You have rejected');
      }
    });



  }


  editRow(rmanFmvRulesDefParaValue: any) {
    this.newRmanFmvRulesDefParaValue = false;
    this.rmanFmvRulesDefParaValue = this.cloneRmanFmvRulesDefParaValue(rmanFmvRulesDefParaValue);
    this.displayDialog = true;
    this.prepareRmanLookupsVObject();
    this.prepareRmanLookupsV1Object();

  }


  findSelectedRmanFmvRulesDefParaValueIndex(): number {
    return this.rmanFmvRulesDefParaValueList.indexOf(this.selectedRmanFmvRulesDefParaValue);
  }

  onRowSelect(event: any) {

  }

  cloneRmanFmvRulesDefParaValue(c: RmanFmvRulesDefParaValue): RmanFmvRulesDefParaValue {
    let rmanFmvRulesDefParaValue: any
      = new RmanFmvRulesDefParaValueImpl();
    for (let prop in c) {
      rmanFmvRulesDefParaValue[prop] = c[prop];
    }
    return rmanFmvRulesDefParaValue;
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

    this.rmanFmvRulesDefParaValueSearch = new RmanFmvRulesDefParaValueImpl();

    if (this.isSerached == 0) {
      this.rmanFmvRulesDefParaValueSearch = new RmanFmvRulesDefParaValueImpl();
    }
    if (this.pFmvRuleDefId == null || this.pFmvRuleDefId == 0) {
      this.displaySearchDialog = false;
      
      this.notificationService.showInfo('Please select FMV Rule');
    } else {
      this.displaySearchDialog = true;
    }

  }

  search() {

    this.isSerached = 1;
    this.rmanFmvRulesDefParaValueSearch.fmvRuleDefId = this.pFmvRuleDefId;
    this.rmanFmvRulesDefParaValue = this.rmanFmvRulesDefParaValueSearch;

    this.getAllRmanFmvRulesDefParaValue(this.rmanFmvRulesDefParaValue);
  }


  prepareRmanLookupsVObject() {
    let rmanLookupsVTempObj: any = [{ label: appSettings.dropDownOptions.SelectFMVCreateRuleParameterAndOr, value: null }];
    this.rmanLookupsVList.forEach((rmanLookupsV) => {
      rmanLookupsVTempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
    });
    this.rmanLookupsV = rmanLookupsVTempObj;
  }

  prepareRmanLookupsV1Object() {
    let rmanLookupsV1TempObj: any = [{ label: appSettings.dropDownOptions.SelectFMVCreateRuleParameterQualifier, value: null }];
    this.rmanLookupsV1List.forEach((rmanLookupsV1) => {
      rmanLookupsV1TempObj.push({ label: rmanLookupsV1.lookupDescription, value: rmanLookupsV1.lookupCode });
    });

    this.rmanLookupsV1 = rmanLookupsV1TempObj;

  }
  prepareRmanEntityParametersVObject() {
    let rmanEntityParametersVTempObj: any = [{ label: appSettings.dropDownOptions.SelectFMVCreateRuleParameterName, value: null }];
    this.rmanEntityParametersVList.forEach((rmanEntityParametersV) => {
      rmanEntityParametersVTempObj.push({ label: rmanEntityParametersV.parameterDescription, value: rmanEntityParametersV.entityParameterId });
    });
    this.rmanEntityParametersV = rmanEntityParametersVTempObj;
  }

  ngOnDestroy() {
  }


  onBeforeToggleParameterValues(evt: any) {
    this.collapsedParameterValues = evt.collapsed;
  }

}


class RmanFmvRulesDefParaValueImpl {
  constructor(public attribute10?: any, public dealFlag?: any, public attribute14?: any, public attribute13?: any, public ruleHeaderId?: any, public attribute12?: any, public attribute11?: any, public lastUpdateDate?: any, public parameterValueId?: any, public parameterId?: any, public attribute3?: any, public createdBy?: any, public attribute2?: any, public lastUpdatedBy?: any, public attribute1?: any, public creationDate?: any, public attribute9?: any, public attribute8?: any, public attribute7?: any, public attribute6?: any, public attribute5?: any, public attribute4?: any, public parameterGroup?: any, public fmvRuleDefId?: any, public attribute15?: any, public qualifier?: any, public andOr?: any, public parameterValue?: any) { }
}

interface ILabels {
  [index: string]: string;
}
