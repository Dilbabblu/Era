import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ConfirmationService, Message } from 'primeng/api';
import { Table } from 'primeng/table';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { RmanRuleParameterValueComponent } from '../rmanRuleParameterValue/rmanRuleParameterValue.component';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanRulesHeader } from './rmanRulesHeader';
import { RmanRulesHeaderLabels } from './rmanRulesHeaderLabels';
import { RmanRulesHeaderService } from './rmanRulesHeaderservice';



declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');
@Component({
    templateUrl: './rmanRulesHeader.component.html',
    selector: 'rmanRulesHeader-data',
    providers: [RmanRulesHeaderService, ConfirmationService]
})

export class RmanRulesHeaderComponent implements OnInit {

    displayDialog: boolean;

    showMsg: any;

    displaySearchDialog: boolean;

    rmanRulesHeader: any = new RmanRulesHeaderImpl();

    rmanRulesHeaderSearch: any = new RmanRulesHeaderImpl();

    isSerached: number = 0;

    selectedRmanRulesHeader: RmanRulesHeader;

    newRmanRulesHeader: boolean;

    pRuleHeaderId: number;
    pRuleCategory: string;

    rmanRulesHeaderList: any[];

    cols: any[];
    columns: any[];

    columnOptions: any[];

    msgs: Message[] = [];

    

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
    noData = appSettings.noData;
    collapsed: boolean = true;
    arrangementRulesForm: FormGroup;
    loading: boolean;
    @ViewChild(RmanRuleParameterValueComponent) private childTable: RmanRuleParameterValueComponent;

    constructor(private rmanRulesHeaderService: RmanRulesHeaderService, private rmanLookupsVService: RmanLookupsVService, private formBuilder: FormBuilder, private confirmationService: ConfirmationService,
        private notificationService: NotificationService, private commonSharedService: CommonSharedService) {

        // generate list code
        this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
        this.loading = true;
        this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'RULE_CATEGORY' }).then((rmanLookupsVList: any) => {
            this.loading = false;
            this.rmanLookupsVList = rmanLookupsVList.content;
            this.prepareRmanLookupsVObject();
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting "Rule Category" data');
            this.loading = false;
        })



    }



    ngOnInit() {
        this.globalCols = [
            { field: 'ruleName', header: 'Rule Name', showField: true, display: "table-cell", type: 'text', drag: false },
            { field: 'sequenceNumber', header: 'Sequence Number', showField: true, display: "table-cell", type: 'number', drag: false },
            { field: 'ruleCategory', header: 'Rule Category', showField: true, display: "table-cell", type: 'text', drag: true },
            { field: 'ruleStartDate', header: 'Rule Start Date', showField: true, display: "table-cell", type: 'date', drag: true },
            { field: 'ruleEndDate', header: 'Rule End Date', showField: true, display: "table-cell", type: 'date', drag: true },
            { field: 'description', header: 'Description', showField: true, display: "table-cell", type: 'text', drag: true },
            ];

        this.columns = [];
        this.getTableColumns("revenueContractRules", "ContractRules");

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
        this.commonSharedService.saveOrUpdateTableColumns("revenueContractRules", "ContractRules", selectedCols, this.userId).then((response) => {
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
        this.rmanRulesHeader = new RmanRulesHeaderImpl();
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
        this.arrangementRulesForm = this.formBuilder.group({
            'name': ['', [Validators.required, Validators.minLength(4),Validators.maxLength(65)]],
            'startDate': ['', [Validators.required]],
            'category': ['', [Validators.required]],
            'sequence': ['', [Validators.required,Validators.pattern('^[0-9]*$')]],
            'attribute2': ['', [Validators.pattern('^[0-9]*$')]],
            'attribute1': ['', [Validators.minLength(4),Validators.maxLength(20)]],
        });

        this.arrangementRulesForm.valueChanges
            .subscribe(data => this.onValueChanged(data));

        this.onValueChanged();
    }

    onValueChanged(data?: any) {
        if (!this.arrangementRulesForm) { return; }
        const form = this.arrangementRulesForm;

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
        'name': '', 'startDate': '', 'category': '', 'sequence': '', 'attribute2': '', 'attribute1': '',/* ,'workspacedbPass':'','workspacedbPort':'','workspacedbUser':'' */
    };

    validationMessages = {
        'name': {
            'required': "Rule Name is required (minimum length is 4 and maximum length is 65 characters)",
            'minlength': 'Rule Name must be at least 4 characters long.',
            'maxlength': 'Rule Name cannot be more than 65 characters long.',
        },
        'startDate': {
            'required': "Rule Start Date is Required"
        },
        'category': {
            'required': "Rule Category is required"
        },
        'sequence': {
            'required': "Sequence Number is required (Only number values are allowed [0-9])",
            'pattern': 'Only number values are allowed [0-9]'
        },
        'attribute2': {
            'pattern': 'Only number values are allowed [0-9]'
        },
        'attribute1': {
            'minlength': 'Element Type must be at least 4 characters long.',
            'maxlength': 'Element Type cannot be more than 20 characters long.',
        }

    }
    transformRmanLookupsV(rmanLookupsV: any) {
        if (rmanLookupsV)
            return rmanLookupsV.lookupDescription;
    }



    getAllRmanRulesHeader() {
        this.loading = true;
        this.rmanRulesHeaderService.getAllRmanRulesHeader(this.paginationOptions, this.rmanRulesHeader).then((rmanRulesHeaderList: any) => {
            this.loading = false;
            this.datasource = rmanRulesHeaderList.content;
            this.rmanRulesHeaderList = rmanRulesHeaderList.content;
            if (this.rmanRulesHeaderList.length > 0) {
                /*Begining of Code used for default First Row Selected*/
                this.selectedRmanRulesHeader = this.rmanRulesHeaderList[0];
                this.pRuleHeaderId = this.selectedRmanRulesHeader.ruleHeaderId;
                this.pRuleCategory = this.selectedRmanRulesHeader.ruleCategory;
                this.childTable.parentCall(this.selectedRmanRulesHeader);
                /*End of Code used for default First Row Selected*/
            } else {
                this.childTable.parentCall('');
            }


            this.totalElements = rmanRulesHeaderList.totalElements;
            this.pageSize = rmanRulesHeaderList.size;
            this.displaySearchDialog = false;
        }).catch((err: any) => {
            console.error(err);
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
        });
    }


    getRmanRulesHeader(event: any) {

        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.loading = true;
        this.rmanRulesHeaderService.getAllRmanRulesHeader(this.paginationOptions, this.rmanRulesHeader).then((rmanRulesHeaderList: any) => {
            this.loading = false;
            this.datasource = rmanRulesHeaderList.content;
            this.rmanRulesHeaderList = rmanRulesHeaderList.content;
            if (this.rmanRulesHeaderList.length > 0) {
                /*Begining of Code used for default First Row Selected*/
                this.selectedRmanRulesHeader = this.rmanRulesHeaderList[0];
                this.pRuleHeaderId = this.selectedRmanRulesHeader.ruleHeaderId;
                this.pRuleCategory = this.selectedRmanRulesHeader.ruleCategory;
                this.childTable.parentCall(this.selectedRmanRulesHeader);
                /*End of Code used for default First Row Selected*/
            } else {
                this.childTable.parentCall('');
            }
            this.totalElements = rmanRulesHeaderList.totalElements;
            this.pageSize = rmanRulesHeaderList.size;
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
        });

    }


    showDialogToAdd() {

        this.newRmanRulesHeader = true;
        this.rmanRulesHeader = new RmanRulesHeaderImpl();
        this.displayDialog = true;
        this.prepareRmanLookupsVObject();
        this.buildForm();

    }

saveOrUpdate(msg: any){
    this.notificationService.showSuccess(msg);
    this.loading = false;
    this.getAllRmanRulesHeader();
}

    save() {
        if (this.newRmanRulesHeader) {
            this.loading = true;
            this.rmanRulesHeaderService.saveRmanRulesHeader(this.rmanRulesHeader).then((response: any) => {
                this.saveOrUpdate('Saved successfully');
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while saving data');
                this.loading = false;
            });
        }
        else {
            this.loading = true;
            this.rmanRulesHeaderService.updateRmanRulesHeader(this.rmanRulesHeader).then((response: any) => {
                this.saveOrUpdate('Updated successfully');
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while updating data');
                this.loading = false;
            });
        }
        this.rmanRulesHeader = new RmanRulesHeaderImpl();
        this.displayDialog = false;
    }

    delete(rmanRulesHeader: any) {
        this.rmanRulesHeader = rmanRulesHeader;
        this.rmanRulesHeader.ruleEndDate = new Date(this.rmanRulesHeader.ruleEndDate);
        this.rmanRulesHeader.ruleStartDate = new Date(this.rmanRulesHeader.ruleStartDate);
        this.displayDialog = false;
        this.confirmationService.confirm({
            message: 'Are you sure you want to delete this record?',
            header: 'Confirmation',
            icon: '',
            accept: () => {
                this.rmanRulesHeaderList.splice(this.findSelectedRmanRulesHeaderIndex(), 1);
                this.loading = true;
                this.rmanRulesHeaderService.deleteRmanRulesHeader(this.rmanRulesHeader).then((response: any) => {
                    this.loading = false;
                    this.rmanRulesHeader = new RmanRulesHeaderImpl();
                    this.getAllRmanRulesHeader();
                });
                this.notificationService.showSuccess('Deleted successfully');
            },
            reject: () => {
                this.notificationService.showWarning('You have rejected');
            }
        });
    }


    editRow(rmanRulesHeader: any) {
        this.newRmanRulesHeader = false;
        this.rmanRulesHeader = this.cloneRmanRulesHeader(rmanRulesHeader);
        if (this.rmanRulesHeader.ruleEndDate) {
            this.rmanRulesHeader.ruleEndDate = new Date(this.rmanRulesHeader.ruleEndDate);
        }
        if (this.rmanRulesHeader.ruleStartDate) {
            this.rmanRulesHeader.ruleStartDate = new Date(this.rmanRulesHeader.ruleStartDate);
        }

        this.displayDialog = true;
        this.prepareRmanLookupsVObject();

    }


    findSelectedRmanRulesHeaderIndex(): number {
        return this.rmanRulesHeaderList.indexOf(this.selectedRmanRulesHeader);
    }

    onRowUnSelect() {
        this.childTable.parentCall('');
    }


    onRowSelect(event: any) {
        this.selectedRmanRulesHeader = event.data;
        this.pRuleHeaderId = this.selectedRmanRulesHeader.ruleHeaderId;
        this.childTable.parentCall(event.data);

    }

    cloneRmanRulesHeader(c: RmanRulesHeader): RmanRulesHeader {
        let rmanRulesHeader: any
            = new RmanRulesHeaderImpl();
        for (let prop in c) {
            rmanRulesHeader[prop] = c[prop];
        }
        return rmanRulesHeader;
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

        this.rmanRulesHeaderSearch = new RmanRulesHeaderImpl();

        if (this.isSerached == 0) {
            this.rmanRulesHeaderSearch = new RmanRulesHeaderImpl();
        }
        this.displaySearchDialog = true;

    }

    cancelSearch() {
        this.displaySearchDialog = false;
        this.rmanRulesHeaderSearch = new RmanRulesHeaderImpl();

    }

    cancelEdit() {
        this.displayDialog = false;
        this.rmanRulesHeader = new RmanRulesHeaderImpl();
    }

    search() {
        this.isSerached = 1;
        this.rmanRulesHeader = this.rmanRulesHeaderSearch;
        this.paginationOptions = {};
        this.getAllRmanRulesHeader();
    }

    prepareRmanLookupsVObject() {
        let rmanLookupsVTempObj: any = [{ label: '--Select Rule Category(*)--', value: null }];
        this.rmanLookupsVList.forEach((rmanLookupsV) => {
            rmanLookupsVTempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
        });

        this.rmanLookupsV = rmanLookupsVTempObj;

    }



    onBeforeToggle(evt: any) {
        this.collapsed = evt.collapsed;
    }

}


class RmanRulesHeaderImpl {
    constructor(public attribute10?: any, public dealFlag?: any, public attribute30?: any, public attribute14?: any, public ruleHeaderId?: any, public attribute13?: any, public attribute12?: any, public attribute11?: any, public ruleName?: any, public ruleMasterId?: any, public lastUpdateDate?: any, public ruleEndDate?: any, public sequenceNumber?: any, public approverId?: any, public ruleCategory?: any, public description?: any, public attribute29?: any, public attribute28?: any, public attribute27?: any, public attribute26?: any, public ruleStartDate?: any, public attribute3?: any, public attribute21?: any, public createdBy?: any, public attribute2?: any, public attribute20?: any, public lastUpdatedBy?: any, public attribute1?: any, public attribute25?: any, public attribute24?: any, public attribute23?: any, public attribute22?: any, public creationDate?: any, public attribute9?: any, public attribute8?: any, public attribute7?: any, public attribute6?: any, public attribute5?: any, public attribute4?: any, public attribute18?: any, public attribute17?: any, public attribute16?: any, public attribute15?: any, public attribute19?: any) { }
}

interface ILabels {
    [index: string]: string;
}
