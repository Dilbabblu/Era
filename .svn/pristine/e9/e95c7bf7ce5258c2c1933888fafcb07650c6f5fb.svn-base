import { Component, Input, OnChanges, OnInit, SimpleChange } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ConfirmationService, Message } from 'primeng/api';
import { Table } from 'primeng/table';
import { RmanEntityParametersVService } from '../rmanEntityParametersV/rmanEntityParametersVservice';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanRuleParameterValue } from './rmanRuleParameterValue';
import { RmanRuleParameterValueLabels } from './rmanRuleParameterValueLabels';
import { RmanRuleParameterValueService } from './rmanRuleParameterValueservice';


declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');
@Component({
    templateUrl: './rmanRuleParameterValue.component.html',
    selector: 'rmanRuleParameterValue-data',
    providers: [RmanRuleParameterValueService, RmanEntityParametersVService, ConfirmationService]
})

export class RmanRuleParameterValueComponent implements OnInit, OnChanges {

    displayDialog: boolean;

    displaySearchDialog: boolean;

    displayConfirmation: boolean;

    showMsg: any;

    msgs: Message[] = [];

    

    pParameterValueId: any;

    rmanRuleParameterValue: any = new RmanRuleParameterValueImpl();

    rmanRuleParameterValueSearch: any = new RmanRuleParameterValueImpl();

    isSerached: number = 0;

    selectedRmanRuleParameterValue: RmanRuleParameterValue;

    newRmanRuleParameterValue: boolean;

    @Input() pRuleHeaderId: number;
    @Input() pRuleCategory: number;

    rmanRuleParameterValueList: any[];

    cols: any[];
    columns: any[];

    columnOptions: any[];

    paginationOptions: any;

    pages: {};

    datasource: any[];
    pageSize: number;
    totalElements: number;

    globalCols: any[];
    clonedCols: any[];

    showAddColumns = true;
    isSelectAllChecked = true;

    userId: number;
    showPaginator: boolean = true;
    startIndex: number;


    rmanLookupsVList: any[] = [];
    rmanLookupsV: any[];
    rmanLookupsV1List: any[] = [];
    rmanLookupsV1: any[];
    rmanEntityParametersVList: any[] = [];
    rmanEntityParametersV: any[];

    collapsedRuleParameters: boolean = true;

    ruleParametersForm: FormGroup;
    noData = appSettings.noData;
    loading: boolean;
    masterData: any;
    constructor(private rmanRuleParameterValueService: RmanRuleParameterValueService, private rmanLookupsVService: RmanLookupsVService, private rmanEntityParametersVService: RmanEntityParametersVService, private formBuilder: FormBuilder, private confirmationService: ConfirmationService,
        private notificationService: NotificationService, private commonSharedService: CommonSharedService) {

        // generate list code
        this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };

        this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'RULE_QUALIFIER' }).then((rmanLookupsVList: any) => {
            this.rmanLookupsVList = rmanLookupsVList.content;
            this.prepareRmanLookupsVObject();

            this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'RULE_CONDITION' }).then((rmanLookupsV1List: any) => {
                this.rmanLookupsV1List = rmanLookupsV1List.content;
                this.prepareRmanLookupsV1Object();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while getting "AND/OR" data');
                this.loading = false;
            });

        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting "Qualifier" data');
            this.loading = false;
        });

    }

    ngOnChanges(changes: { [propKey: string]: SimpleChange }) {
    }


    ngOnInit() {
        this.globalCols = [
            { field: 'parameterGroup', header: 'Parameter Group', showField: true, display: "table-cell", type: 'text', drag: false },
            { field: 'parameterId', header: 'Parameter Id', showField: true, display: "table-cell", type: 'text', drag: false },
            { field: 'qualifier', header: 'Qualifier', showField: true, display: "table-cell", type: 'text', drag: true },
            { field: 'parameterValue', header: 'Parameter Value', showField: true, display: "table-cell", type: 'text', drag: true },
            { field: 'andOr', header: 'And/Or', showField: true, display: "table-cell", type: 'text', drag: true },
            ];
        this.columns = [];
        this.getTableColumns("revenueContractRules", "ContractResults");
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
        this.commonSharedService.saveOrUpdateTableColumns("revenueContractRules", "ContractResults", selectedCols, this.userId).then((response) => {
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
        //console.log(this.globalCols);
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

    reset(dt: Table) {
        this.paginationOptions = {};
        this.rmanRuleParameterValue = new RmanRuleParameterValueImpl();
        dt.reset();
    
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
        this.ruleParametersForm = this.formBuilder.group({
            'name': ['', [
                Validators.required
            ]
            ],
            'qualifier': ['', [Validators.required]]
        });

        this.ruleParametersForm.valueChanges
            .subscribe(data => this.onValueChanged(data));

        this.onValueChanged();
    }

    onValueChanged(data?: any) {
        if (!this.ruleParametersForm) { return; }
        const form = this.ruleParametersForm;

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
        'name': '', 'qualifier': ''/* ,'workspacedbName':'','workspacedbPass':'','workspacedbPort':'','workspacedbUser':'' */
    };

    validationMessages = {
        'name': {
            'required': "Parameter ID is required"
        },
        'qualifier': {
            'required': "Qualifier is Required"
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
            return rmanEntityParametersV.parameterName;
    }



    getAllRmanRuleParameterValue(searchobj?: any) {
        this.rmanRuleParameterValue.ruleHeaderId = this.pRuleHeaderId;
        this.loading = true;
        if ((this.pRuleHeaderId != null) && (this.pRuleHeaderId)) {
            this.rmanRuleParameterValueService.getAllRmanRuleParameterValue(this.paginationOptions, this.rmanRuleParameterValue).then((rmanRuleParameterValueList: any) => {
                this.loading = false;
                this.datasource = rmanRuleParameterValueList.content;
                if (this.isSerached == 0) {
                    this.rmanRuleParameterValueList = rmanRuleParameterValueList.content.filter((item: any) => item.ruleHeaderId = this.pRuleHeaderId);
                } else {
                    this.rmanRuleParameterValueList = rmanRuleParameterValueList.content;
                    this.isSerached = 0;
                }
                this.totalElements = rmanRuleParameterValueList.totalElements;
                this.pageSize = rmanRuleParameterValueList.size;
                this.displaySearchDialog = false;
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while getting data');
                this.loading = false;
            });
        }

    }



    getRmanRuleParameterValue(event: any) {

        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.loading = true;
        if ((this.pRuleHeaderId != null) && (this.pRuleHeaderId)) {
            this.rmanRuleParameterValueService.getAllRmanRuleParameterValue(this.paginationOptions, this.rmanRuleParameterValue).then((rmanRuleParameterValueList: any) => {
                this.loading = false;
                this.datasource = rmanRuleParameterValueList.content;
                if (this.pRuleHeaderId != null) {
                    this.rmanRuleParameterValueList = rmanRuleParameterValueList.content.filter((item: any) => item.ruleHeaderId == this.pRuleHeaderId);
                } else {
                    this.rmanRuleParameterValueList = rmanRuleParameterValueList.content;
                }
                this.totalElements = rmanRuleParameterValueList.totalElements;
                this.pageSize = rmanRuleParameterValueList.size;
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while getting data');
                this.loading = false;
            });
        }


    }

    showDialogToAdd() {

        this.newRmanRuleParameterValue = true;
        this.rmanRuleParameterValue = new RmanRuleParameterValueImpl();
        if (this.pRuleHeaderId == null || this.pRuleHeaderId == 0) {
            this.displayDialog = false;
            
            this.notificationService.showInfo('Please select Arrangement Rule');
            this.displayConfirmation = true;
        }
        else {
            this.rmanRuleParameterValue.ruleHeaderId = this.pRuleHeaderId;
            this.displayDialog = true;
            this.prepareRmanLookupsVObject();
            this.prepareRmanLookupsV1Object();
            this.prepareRmanEntityParametersVObject();
        }
    }

    cancelEdit() {
        this.displayDialog = false;
        this.rmanRuleParameterValue = new RmanRuleParameterValueImpl();

    }

    cancelSearch() {
        this.displaySearchDialog = false;
        this.rmanRuleParameterValueSearch = new RmanRuleParameterValueImpl();
    }

    parentCall(data) {
        this.masterData = data;
        if (data != '') {
            this.pRuleHeaderId = data.ruleHeaderId;
            this.pRuleCategory = data.ruleCategory;
            this.rmanEntityParametersVService.getAllRmanEntityParametersV(this.paginationOptions, { 'entityCategory': this.pRuleCategory }, 'Y').then((rmanEntityParametersVList: any) => {
                this.rmanEntityParametersVList = rmanEntityParametersVList.content;
                this.prepareRmanEntityParametersVObject();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while getting "Parameter ID" data');
                this.loading = false;
            });
            this.getAllRmanRuleParameterValue();
        } else {
            this.pRuleHeaderId = null;
            this.rmanRuleParameterValueList = [];

        }
    }

    saveOrUpdate(msg: any){
        this.notificationService.showSuccess(msg);
        this.loading = false;
        this.getAllRmanRuleParameterValue();
    }

    save() {
        if (this.newRmanRuleParameterValue) {
            this.rmanRuleParameterValue.ruleHeaderId = this.pRuleHeaderId;
            this.loading = true;
            this.rmanRuleParameterValueService.saveRmanRuleParameterValue(this.rmanRuleParameterValue).then((response: any) => {
                this.saveOrUpdate('Saved successfully');
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while saving data');
                this.loading = false;
            });

        }
        else {
            this.loading = true;
            this.rmanRuleParameterValueService.updateRmanRuleParameterValue(this.rmanRuleParameterValue).then((response: any) => {
                this.saveOrUpdate('Updated successfully');
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while updating the data');
                this.loading = false;
            });

        }

        this.rmanRuleParameterValue = new RmanRuleParameterValueImpl();

        this.displayDialog = false;

    }

    delete(rmanRuleParameterValue: any) {
        this.rmanRuleParameterValue = rmanRuleParameterValue;
        this.displayDialog = false;
        this.confirmationService.confirm({
            message: 'Are you sure you want to delete this record?',
            header: 'Confirmation',
            icon: '',
            accept: () => {
                this.rmanRuleParameterValueList.splice(this.findSelectedRmanRuleParameterValueIndex(), 1);
                this.loading = true;
                this.rmanRuleParameterValueService.deleteRmanRuleParameterValue(this.rmanRuleParameterValue).then((response: any) => {
                    this.loading = false;
                    this.rmanRuleParameterValue = new RmanRuleParameterValueImpl();
                    this.getAllRmanRuleParameterValue();
                });
                this.notificationService.showSuccess('Deleted successfully');
            },
            reject: () => {
                this.notificationService.showWarning('You have rejected');
            }
        });
    }

    editRow(rmanRuleParameterValue: any) {
        this.newRmanRuleParameterValue = false;
        this.rmanRuleParameterValue = this.cloneRmanRuleParameterValue(rmanRuleParameterValue);
        this.displayDialog = true;
        this.prepareRmanLookupsVObject();
        this.prepareRmanLookupsV1Object();
        this.prepareRmanEntityParametersVObject();
    }


    findSelectedRmanRuleParameterValueIndex(): number {
        return this.rmanRuleParameterValueList.indexOf(this.selectedRmanRuleParameterValue);
    }

    onRowSelect(event: any) {

    }

    cloneRmanRuleParameterValue(c: RmanRuleParameterValue): RmanRuleParameterValue {
        let rmanRuleParameterValue: any
            = new RmanRuleParameterValueImpl();
        for (let prop in c) {
            rmanRuleParameterValue[prop] = c[prop];
        }
        return rmanRuleParameterValue;
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

        this.rmanRuleParameterValueSearch = new RmanRuleParameterValueImpl();

        if (this.isSerached == 0) {
            this.rmanRuleParameterValueSearch = new RmanRuleParameterValueImpl();
        }
        this.displaySearchDialog = true;

    }

    search() {

        this.isSerached = 1;
        this.rmanRuleParameterValue = this.rmanRuleParameterValueSearch;
        this.paginationOptions = {};
        this.getAllRmanRuleParameterValue(this.rmanRuleParameterValue);
    }

    prepareRmanLookupsVObject() {
        let rmanLookupsVTempObj: any = [{ label: '--Select Qualifier(*)--', value: null }];
        this.rmanLookupsVList.forEach((rmanLookupsV) => {
            rmanLookupsVTempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
        });

        this.rmanLookupsV = rmanLookupsVTempObj;

    }

    prepareRmanLookupsV1Object() {
        let rmanLookupsV1TempObj: any = [{ label: '--Select And/Or--', value: null }];
        this.rmanLookupsV1List.forEach((rmanLookupsV1) => {
            rmanLookupsV1TempObj.push({ label: rmanLookupsV1.lookupDescription, value: rmanLookupsV1.lookupCode });
        });

        this.rmanLookupsV1 = rmanLookupsV1TempObj;

    }

    prepareRmanEntityParametersVObject() {
        let rmanEntityParametersVTempObj: any = [{ label: '--Select Parameter ID(*)--', value: null }];
        this.rmanEntityParametersVList.forEach((rmanEntityParametersV) => {
            rmanEntityParametersVTempObj.push({ label: rmanEntityParametersV.parameterName, value: rmanEntityParametersV.entityParameterId });
        });

        this.rmanEntityParametersV = rmanEntityParametersVTempObj;

    }


    onBeforeToggleRuleParameters(evt: any) {
        this.collapsedRuleParameters = evt.collapsed;
    }
}


class RmanRuleParameterValueImpl {
    constructor(public attribute10?: any, public dealFlag?: any, public attribute30?: any, public attribute14?: any, public ruleHeaderId?: any, public attribute13?: any, public attribute12?: any, public attribute11?: any, public lastUpdateDate?: any, public attribute29?: any, public attribute28?: any, public attribute27?: any, public attribute26?: any, public parameterValueId?: any, public parameterId?: any, public attribute3?: any, public attribute21?: any, public createdBy?: any, public attribute2?: any, public attribute20?: any, public lastUpdatedBy?: any, public attribute1?: any, public attribute25?: any, public attribute24?: any, public attribute23?: any, public attribute22?: any, public creationDate?: any, public attribute9?: any, public attribute8?: any, public attribute7?: any, public attribute6?: any, public attribute5?: any, public attribute4?: any, public parameterGroup?: any, public attribute18?: any, public attribute17?: any, public attribute16?: any, public attribute15?: any, public qualifier?: any, public andOr?: any, public parameterValue?: any, public attribute19?: any) { }
}

interface ILabels {
    [index: string]: string;
}
