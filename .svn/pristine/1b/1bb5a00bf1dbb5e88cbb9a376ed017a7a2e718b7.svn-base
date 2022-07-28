import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ConfirmationService, Message } from 'primeng/api';
import { Table } from 'primeng/table';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanContTemplate } from './rmanContTemplate';
import { RmanContTemplateLabels } from './rmanContTemplateLabels';
import { RmanContTemplateService } from './rmanContTemplateservice';


declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
    templateUrl: './rmanContTemplate.component.html',
    selector: 'rmanContTemplate-data',
    providers: [RmanContTemplateService, ConfirmationService]
})

export class RmanContTemplateComponent implements OnInit {

    displayDialog: boolean;

    displaySearchDialog: boolean;

    rmanContTemplate: any = new RmanContTemplateImpl();

    rmanContTemplateSearch: any = new RmanContTemplateImpl();

    isSerached: number = 0;

    showMsg: any;

    msgs: Message[] = [];



    selectedRmanContTemplate: RmanContTemplate;

    newRmanContTemplate: boolean;

    cref: ChangeDetectorRef;

    rmanContTemplateList: any[];

    cols: any[];
    columns: any[];

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
    noData = appSettings.noData;
    collapsed: boolean = true;

    contTemplateForm: FormGroup;
    loading: boolean;

    globalCols: any[];
    clonedCols: any[];
  
    showAddColumns = true;
    isSelectAllChecked = true;
  
    userId: number;
    showPaginator: boolean = true;
    startIndex: number;

    constructor(private ref: ChangeDetectorRef, private rmanContTemplateService: RmanContTemplateService, private rmanLookupsVService: RmanLookupsVService, private formBuilder: FormBuilder, private confirmationService: ConfirmationService, private notificationService: NotificationService,
        private commonSharedService: CommonSharedService) {

        // generate list code
        this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
        this.loading = true;
        this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'ENABLED_FLAG' }).then((rmanLookupsVList: any) => {
            this.rmanLookupsVList = rmanLookupsVList.content;
            this.prepareRmanLookupsVObject();


            this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'CONT_APPLY_TYPE' }).then((rmanLookupsV1List: any) => {
                this.loading = false;
                this.rmanLookupsV1List = rmanLookupsV1List.content;
                this.prepareRmanLookupsV1Object();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while getting "Apply Type" data');
                this.loading = false;
            });
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting "Invoice Hold" data');
            this.loading = false;
        });

        this.cref = ref;


    }

    ngAfterViewChecked() {
        this.cref.detectChanges();
    }

    ngOnInit() {
        this.globalCols = [
            { field: 'templateName', header: 'Template Name', showField: true, display: "table-cell", type: 'text', drag: false },
            { field: 'description', header: 'Description', showField: true, display: "table-cell", type: 'text', drag: false },
            { field: 'applyType', header: 'Apply Type', showField: true, display: "table-cell", type: 'text', drag: true },
            { field: 'revenue', header: 'Revenue', showField: true, display: "table-cell", type: 'number', drag: true },
            { field: 'cogs', header: 'cogs', showField: true, display: "table-cell", type: 'number', drag: true },
            { field: 'invoiceHold', header: 'Invoice Hold', showField: true, display: "table-cell", type: 'text', drag: true },
            { field: 'effectiveStartDate', header: 'Effective Start Date', showField: true, display: "table-cell", type: 'date', drag: true },
            { field: 'effectiveEndDate', header: 'Effective End Date', showField: true, display: "table-cell", type: 'date', drag: true },
          ];

        this.columns = [];
        this.getTableColumns("contingencyTemplates", "Templates");
        // this.getAllRmanContTemplate();

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
        this.commonSharedService.saveOrUpdateTableColumns("contingencyTemplates", "Templates", selectedCols, this.userId).then((response) => {
          this.columns = this.globalCols.filter(item => item.showField);
          this.userId = response["userId"];
          this.showPaginator = this.columns.length !== 0 ;
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
        this.rmanContTemplate = new RmanContTemplateImpl();
        dt.reset();
    }

    buildForm() {
        this.contTemplateForm = this.formBuilder.group({
            'type': ['', [
                Validators.required
            ]
            ],
            'startDate': ['', [Validators.required]],
            'name': ['', [Validators.required, Validators.minLength(4), Validators.maxLength(20)]],
            'cogs': ['', [Validators.pattern('^[0-9]*$')]],
            'revenue': ['', [Validators.pattern('^[0-9]*$')]],
        });

        this.contTemplateForm.valueChanges
            .subscribe(data => this.onValueChanged(data));

        this.onValueChanged();
    }

    onValueChanged(data?: any) {
        if (!this.contTemplateForm) { return; }
        const form = this.contTemplateForm;

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
        'startDate': '', 'type': '', 'name': '', 'cogs': '', 'revenue': '',/*,'workspacedbPass':'','workspacedbPort':'','workspacedbUser':'' */
    };

    validationMessages = {
        'startDate': {
            'required': "Name is required"
        }, 'type': {
            'required': "Apply Type is Required"
        },
        'name': {
            'required': "Template Name is required (minimum length is 4 and maximum length is 20 characters)",
            'minlength': 'Template Name must be at least 4 characters long.',
            'maxlength': 'Template Name cannot be more than 20 characters long.',
        },
        'cogs': {
            'pattern': 'Only number values are allowed [0-9]'
        },
        'revenue': {
            'pattern': 'Only number values are allowed [0-9]'
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



    getAllRmanContTemplate() {
        this.loading = true;
        this.rmanContTemplateService.getAllRmanContTemplate(this.paginationOptions, this.rmanContTemplate).then((rmanContTemplateList: any) => {
            this.loading = false;
            this.datasource = rmanContTemplateList.content;
            this.rmanContTemplateList = rmanContTemplateList.content;
            this.totalElements = rmanContTemplateList.totalElements;
            this.pageSize = rmanContTemplateList.size;
            this.displaySearchDialog = false;
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
        });
    }


    getRmanContTemplate(event: any) {

        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.loading = true;
        this.rmanContTemplateService.getAllRmanContTemplate(this.paginationOptions, this.rmanContTemplate).then((rmanContTemplateList: any) => {
            this.loading = false;
            this.datasource = rmanContTemplateList.content;
            this.rmanContTemplateList = rmanContTemplateList.content;
            this.totalElements = rmanContTemplateList.totalElements;
            this.pageSize = rmanContTemplateList.size;
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
        });

    }


    showDialogToAdd() {

        this.newRmanContTemplate = true;
        this.rmanContTemplate = new RmanContTemplateImpl();
        this.displayDialog = true;
        this.prepareRmanLookupsVObject();
        this.prepareRmanLookupsV1Object();
        this.buildForm();
    }

    cancelEdit() {
        this.displayDialog = false;
        this.rmanContTemplate = new RmanContTemplateImpl();
    }

    saveOrUpdate(msg: any){
        this.notificationService.showSuccess(msg);
        this.loading = false;
        this.getAllRmanContTemplate();
    }

    save() {
        if (this.newRmanContTemplate) {
            this.loading = true;
            this.rmanContTemplateService.saveRmanContTemplate(this.rmanContTemplate).then((response: any) => {
                this.saveOrUpdate('Saved succesfully');
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while saving the data');
                this.loading = false;
            });
        }
        else {
            this.loading = true;
            this.rmanContTemplateService.updateRmanContTemplate(this.rmanContTemplate).then((response: any) => {
                this.saveOrUpdate('Updated succesfully');
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while updating the data');
                this.loading = false;
            });
        }

        this.rmanContTemplate = new RmanContTemplateImpl();
        this.displayDialog = false;
    }

    delete(rmanContTemplate: any) {
        this.rmanContTemplate = rmanContTemplate;
        if (this.rmanContTemplate.effectiveEndDate) {
            this.rmanContTemplate.effectiveEndDate = new Date(this.rmanContTemplate.effectiveEndDate);
        }
        if (this.rmanContTemplate.effectiveStartDate) {
            this.rmanContTemplate.effectiveStartDate = new Date(this.rmanContTemplate.effectiveStartDate);
        }
        this.displayDialog = false;


        this.confirmationService.confirm({
            message: 'Are you sure you want to delete this record?',
            header: 'Confirmation',
            icon: '',
            accept: () => {
                this.rmanContTemplateList.splice(this.findSelectedRmanContTemplateIndex(), 1);
                this.loading = true;
                this.rmanContTemplateService.deleteRmanContTemplate(this.rmanContTemplate).then((response: any) => {
                    this.loading = false;
                    this.rmanContTemplate = new RmanContTemplateImpl();
                    this.getAllRmanContTemplate();
                });
                this.notificationService.showSuccess('Deleted succesfully');
            },
            reject: () => {
                this.notificationService.showWarning('You have rejected');
            }
        });
    }

    editRow(rmanContTemplate: any) {
        this.newRmanContTemplate = false;
        this.rmanContTemplate = this.cloneRmanContTemplate(rmanContTemplate);
        if (this.rmanContTemplate.effectiveEndDate) {
            this.rmanContTemplate.effectiveEndDate = new Date(this.rmanContTemplate.effectiveEndDate);
        }
        if (this.rmanContTemplate.effectiveStartDate) {
            this.rmanContTemplate.effectiveStartDate = new Date(this.rmanContTemplate.effectiveStartDate);
        }
        this.displayDialog = true;
        this.prepareRmanLookupsVObject();
        this.prepareRmanLookupsV1Object();

    }


    findSelectedRmanContTemplateIndex(): number {
        return this.rmanContTemplateList.indexOf(this.selectedRmanContTemplate);
    }

    onRowSelect(event: any) {

    }

    cloneRmanContTemplate(c: RmanContTemplate): RmanContTemplate {
        let rmanContTemplate: any
            = new RmanContTemplateImpl();
        for (let prop in c) {
            rmanContTemplate[prop] = c[prop];
        }
        return rmanContTemplate;
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

        this.rmanContTemplateSearch = new RmanContTemplateImpl();

        if (this.isSerached == 0) {
            this.rmanContTemplateSearch = new RmanContTemplateImpl();
        }
        this.displaySearchDialog = true;

    }

    cancelSearch() {
        this.displaySearchDialog = false;
        this.rmanContTemplateSearch = new RmanContTemplateImpl();
    }

    search() {

        this.isSerached = 1;
        this.rmanContTemplate = this.rmanContTemplateSearch;
        this.paginationOptions = {};
        this.getAllRmanContTemplate();
    }

    prepareRmanLookupsVObject() {
        let rmanLookupsVTempObj: any = [{ label: appSettings.dropDownOptions.SelectInvoiceHold, value: null }];
        this.rmanLookupsVList.forEach((rmanLookupsV) => {
            rmanLookupsVTempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
        });

        this.rmanLookupsV = rmanLookupsVTempObj;

    }

    prepareRmanLookupsV1Object() {
        let rmanLookupsV1TempObj: any = [{ label: appSettings.dropDownOptions.SelectApplyType, value: null }];
        this.rmanLookupsV1List.forEach((rmanLookupsV1) => {
            rmanLookupsV1TempObj.push({ label: rmanLookupsV1.lookupDescription, value: rmanLookupsV1.lookupCode });
        });

        this.rmanLookupsV1 = rmanLookupsV1TempObj;

    }

    onBeforeToggle(evt: any) {
        this.collapsed = evt.collapsed;
    }

}


class RmanContTemplateImpl {
    constructor(public attribute10?: any, public invoiceHold?: any, public attribute14?: any, public attribute13?: any, public attribute12?: any, public cogs?: any, public attribute11?: any, public applyType?: any, public lastUpdateDate?: any, public templateId?: any, public description?: any, public effectiveEndDate?: any, public attribute3?: any, public createdBy?: any, public attribute2?: any, public lastUpdatedBy?: any, public attribute1?: any, public revenue?: any, public creationDate?: any, public attribute9?: any, public attribute8?: any, public attribute7?: any, public attribute6?: any, public defaultDays?: any, public attribute5?: any, public attribute4?: any, public effectiveStartDate?: any, public templateName?: any, public attribute15?: any) { }
}

interface ILabels {
    [index: string]: string;
}
