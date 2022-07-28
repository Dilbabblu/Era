import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ConfirmationService, Message } from 'primeng/api';
import { Table } from 'primeng/table';
import { RmanContTemplateService } from '../rmanContTemplate/rmanContTemplateservice';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { RmanContLinkedTemplateSvService } from '../services/rmanContLinkedTemplateSvservice';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanContHeader } from './rmanContHeader';
import { RmanContHeaderLabels } from './rmanContHeaderLabels';
import { RmanContHeaderService } from './rmanContHeaderservice';

declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
  templateUrl: './rmanContHeader.component.html',
  selector: 'rmanContHeader-data',
  providers: [RmanContHeaderService, RmanContTemplateService, RmanContLinkedTemplateSvService, ConfirmationService]
})

export class RmanContHeaderComponent implements OnInit {

  displayDialog: boolean;

  displaySearchDialog: boolean;

  diaplyPickListDialog: boolean;

  initialProcess: number = 0;

  msgs: Message[];



  pContHeaderId: any;

  rmanContHeader: any = new RmanContHeaderImpl();

  rmanContHeaderSearch: any = new RmanContHeaderImpl();


  rmanContTemplate: any = new RmanContTemplateImpl();

  rmanContLinkedTemplate: any = new RmanContLinkedTemplateSvImpl();

  rmanContTemplatesList: any[];
  rmanContLinkedTemplatesList: any[];

  srcRmanContTemplates: any[];
  trgRmanContTemplates: any[];
  rmanContLinkedTemplates: any[];



  isSerached: number = 0;

  showMsg: any;

  selectedRmanContHeader: RmanContHeader;

  newRmanContHeader: boolean;

  cref: ChangeDetectorRef;

  rmanContHeaderList: any[];

  cols: any[];
  columns: any[];

  columnOptions: any[];

  paginationOptions: any;

  pages: {};

  datasource: any[];
  pageSize: number;
  totalElements: number;
  noData = appSettings.noData;

  rmanLookupsVList: any[] = [];
  rmanLookupsV: any[];
  rmanLookupsV1List: any[] = [];
  rmanLookupsV1: any[];

  rmanLookupsV2List: any[] = []; // RevRec Hold List for Cont Codes
  rmanLookupsV2: any[]; //Cont Codes
  rmanLookupsV3List: any[] = []; // RevRec Hold Apply Level List 
  rmanLookupsV3: any[]; // RevRec Hold Apply


  collapsed: boolean = true;

  contHeaderForm: FormGroup;
  loading: boolean;
  revFlag: boolean;
  cogsFlag: boolean;

  globalCols: any[];
  clonedCols: any[];

  showAddColumns = true;
  isSelectAllChecked = true;

  userId: number;
  showPaginator: boolean = true;
  startIndex: number;
  postAllocationLookup:any[] =[];
  fvFlagLookup:any[] =[];


  constructor(private ref: ChangeDetectorRef, private rmanContHeaderService: RmanContHeaderService, private rmanLookupsVService: RmanLookupsVService,
    private formBuilder: FormBuilder, private rmanContTemplateService: RmanContTemplateService,
    private rmanContLinkedTemplateSvService: RmanContLinkedTemplateSvService, private confirmationService: ConfirmationService, private notificationService: NotificationService,
    private commonSharedService: CommonSharedService) {

    // generate list code
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    this.loading = true;
    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'CONT_RULE_APPLY_LEVEL' }).then((rmanLookupsVList: any) => {
      this.rmanLookupsVList = rmanLookupsVList.content;
      this.prepareRmanLookupsV1Object();

      this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'CONT_RULE_CATEGORY' }).then((rmanLookupsV1List: any) => {
        this.loading = false;
        this.rmanLookupsV1List = rmanLookupsV1List.content;

        this.prepareRmanLookupsVObject();

      }).catch((err: any) => {
        this.notificationService.showError('Error occured while getting "Rule Apply Level" data');
        this.loading = false;
      });
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting "Rule Category" data');
      this.loading = false;
    });

    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'REV_REC_HOLD_TYPE' }).then((rmanLookupsV2List: any) => {
      this.loading = false;
      this.rmanLookupsV2List = rmanLookupsV2List.content;

      this.prepareRmanLookupsV2Object();

    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting "REV_REC_HOLD_TYPE Level" data');
      this.loading = false;
    });

    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'REVREC_HOLD_APPLY_LEVEL' }).then((rmanLookupsV3List: any) => {
      this.loading = false;
      this.rmanLookupsV3List = rmanLookupsV3List.content;

      this.prepareRmanLookupsV3Object();

    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting "REVREC_HOLD_APPLY_LEVEL" data');
      this.loading = false;
    });

    
    this.postAllocationLookup.push({ label: 'Select Post Allocation Flag', value: null });
    this.postAllocationLookup.push({label: 'Y', value: 'Y'});
    this.postAllocationLookup.push({label:'N', value:'N'});

    this.fvFlagLookup.push({ label: 'Select FV Flag', value: null });
    this.fvFlagLookup.push({label: 'Y', value: 'Y'});
    this.fvFlagLookup.push({label:'N', value:'N'});

    this.cref = ref;


  }

  ngAfterViewChecked() {
    this.cref.detectChanges();
  }

  ngOnInit() {

    this.globalCols = [
      { field: 'ruleName', header: 'Rule Name', showField: true, display: "table-cell", type: 'text', drag: false },
      { field: 'description', header: 'Description', showField: true, display: "table-cell", type: 'text', drag: false },
      { field: 'ruleApplyLevel', header: 'Rule Apply Level', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'ruleCategory', header: 'Rule Category', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'ruleStartDate', header: 'Rule Start Date', showField: true, display: "table-cell", type: 'date', drag: true },
      { field: 'ruleEndDate', header: 'Rule End Date', showField: true, display: "table-cell", type: 'date', drag: true },
      { field: 'ranking', header: 'Ranking', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'revFlag', header: 'Revenue', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'cogsFlag', header: 'COGS', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'attribute1', header: 'Revrec Hold Apply', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'attribute2', header: 'Post Billing Allocation Flag', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'attribute3', header: 'Include FV Flag', showField: true, display: "table-cell", type: 'text', drag: true },
    ];

    //this.getAllRmanContHeader();

    //this.getAllRmanContHeader();

    this.columns = [];
    this.getTableColumns("contingencyCodes", "Codes");

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
    this.commonSharedService.saveOrUpdateTableColumns("contingencyCodes", "Codes", selectedCols, this.userId).then((response) => {
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
    this.contHeaderForm = this.formBuilder.group({
      'name': ['', [
        Validators.required,
        Validators.maxLength(25)
      ]
      ],
      'category': ['', [Validators.required]],
      'startDate': ['', [Validators.required]],
      'endDate': [''],
      'description': ['', [Validators.minLength(4), Validators.maxLength(30)]],
      'ruleApplyLevel': [''],
      'comments': [''],
      'ranking': ['', [Validators.pattern('^[0-9]*$')]],
      'revFlag': [''],
      'cogsFlag': [''],
      'attribute1': [''],
      'attribute2': [''],
      'attribute3': ['']


    });

    this.contHeaderForm.valueChanges
      .subscribe(data => this.onValueChanged(data));

    this.onValueChanged();
  }

  onValueChanged(data?: any) {
    if (!this.contHeaderForm) { return; }
    const form = this.contHeaderForm;

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
    'name': '', 'category': '', 'startDate': '', 'description': '', 'ranking': '',/*,'workspacedbPass':'','workspacedbPort':'','workspacedbUser':'' */
  };

  validationMessages = {
    'name': {
      'required': "Name is required",
      'maxlength': 'Name cannot be more than 25 characters long.',
    }, 'category': {
      'required': "Rule Category is Required"
    },
    'startDate': {
      'required': "Rule Start Date is required"
    },
    'description': {
      'minlength': 'Description must be at least 4 characters long.',
      'maxlength': 'Description cannot be more than 30 characters long.',
    },
    'ranking': {
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



  getAllRmanContHeader() {
    this.loading = true;
    this.rmanContHeaderService.getAllRmanContHeader(this.paginationOptions, this.rmanContHeader).then((rmanContHeaderList: any) => {
      this.loading = false;
      this.datasource = rmanContHeaderList.content;
      this.rmanContHeaderList = rmanContHeaderList.content;
      this.totalElements = rmanContHeaderList.totalElements;
      this.pageSize = rmanContHeaderList.size;
      this.displaySearchDialog = false;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }

  onSelectingPostAllocationFlag(flag: any) {
    if(flag=='Y'){
      this.rmanContHeader.attribute3 = 'N';
    }else if(flag=='N'){
      this.rmanContHeader.attribute3 = null;
    }
  }


  getRmanContHeader(event: any) {

    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loading = true;
    this.rmanContHeaderService.getAllRmanContHeader(this.paginationOptions, this.rmanContHeader).then((rmanContHeaderList: any) => {
      this.loading = false;
      this.datasource = rmanContHeaderList.content;
      this.rmanContHeaderList = rmanContHeaderList.content;
      this.totalElements = rmanContHeaderList.totalElements;
      this.pageSize = rmanContHeaderList.size;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });

  }


  getContLinktemplates() {
    let srcList: any[] = [];
    this.srcRmanContTemplates = [];
    this.trgRmanContTemplates = [];
    if (this.selectedRmanContHeader && Object.keys(this.selectedRmanContHeader).length) {
      this.loading = true;
      this.paginationOptions = {};
      this.rmanContTemplateService.getAllRmanContTemplate(this.paginationOptions, this.rmanContTemplate, 'Y').then((rmanContTemplates1: any) => {
        this.loading = false;
        this.rmanContTemplatesList = rmanContTemplates1.content;
        this.srcRmanContTemplates = rmanContTemplates1.content;
        this.trgRmanContTemplates = [];
        if (this.srcRmanContTemplates && this.srcRmanContTemplates.length > 0) {
          this.loading = true;
          this.rmanContLinkedTemplateSvService.getAllRmanContLinkedTemplateSv(this.paginationOptions, this.rmanContLinkedTemplate).then((rmanContLinkedTemplates1: any) => {
            this.loading = false;
            let contLinktempsFilteredTemplateIds = [];
            this.rmanContLinkedTemplatesList = rmanContLinkedTemplates1.content;
            contLinktempsFilteredTemplateIds = this.rmanContLinkedTemplatesList.filter((item: any) => item.ruleHeaderId == this.pContHeaderId).map(filteredLinkedTemplate => filteredLinkedTemplate.templateId);
            if (contLinktempsFilteredTemplateIds && contLinktempsFilteredTemplateIds.length > 0) {
              this.srcRmanContTemplates.forEach(contTemplateTemp => {
                if (contLinktempsFilteredTemplateIds.includes(contTemplateTemp.templateId)) {
                  this.trgRmanContTemplates.push(contTemplateTemp);
                } else {
                  srcList.push(contTemplateTemp);
                }
              })
              this.srcRmanContTemplates = srcList;
            }
            this.diaplyPickListDialog = true;
            this.loading = false;
          }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
          });
        }
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while getting data');
        this.loading = false;
      });

    } else {
      this.notificationService.showInfo('Please select one of the contingency to assign templates');
    }

  }


  saveContLinktemplates() {
    this.loading = true;
    this.paginationOptions = {};
    var trgRmanContTemplatesTemplateIds = this.trgRmanContTemplates.map(item => item.templateId);
    var body_data = { contRuleHeaderId: this.pContHeaderId, rmanContTemplateList: trgRmanContTemplatesTemplateIds }
    this.rmanContLinkedTemplateSvService.saveRmanContLinkedTemplateSv(body_data).then(res => {
      this.notificationService.showSuccess('Templates updated successfully');
      this.loading = false;
      this.diaplyPickListDialog = false;
    }).catch((err: any) => {
      this.notificationService.showError(err.error.message);
      this.loading = false;
      this.diaplyPickListDialog = false;
    });

  }

  showDialogToAdd() {

    this.newRmanContHeader = true;
    this.rmanContHeader = new RmanContHeaderImpl();
    this.displayDialog = true;
    this.prepareRmanLookupsVObject();
    this.prepareRmanLookupsV1Object();
    this.prepareRmanLookupsV2Object();
    this.prepareRmanLookupsV3Object();
    this.buildForm();
  }

  cancelEdit() {
    this.displayDialog = false;
    this.rmanContHeader = new RmanContHeaderImpl();
  }

  showDialogToAddTemplates() {
    if (this.selectedRmanContHeader != null) {

      this.getContLinktemplates();

      if (this.initialProcess == 1) {
        this.diaplyPickListDialog = true;
        this.initialProcess = 0;
      }
    } else {
      this.notificationService.showInfo('Please select one of the contingency to apply templates');
    }

  }

  save() {
    if (this.rmanContHeader.cogsFlag) {
      this.rmanContHeader.cogsFlag = 'Y';
    }
    else {
      this.rmanContHeader.cogsFlag = 'N';
    }

    if (this.rmanContHeader.revFlag) {
      this.rmanContHeader.revFlag = 'Y';
    }
    else {
      this.rmanContHeader.revFlag = 'N';
    }

    this.loading = true;
    this.rmanContHeaderService.createOrUpdateContHeader(this.rmanContHeader,this.newRmanContHeader).then((response: any) => {
      this.loading = false;
      this.getAllRmanContHeader();
      this.notificationService.showSuccess(this.newRmanContHeader ? appSettings.commonValueConstants.SUCCESS_SAVED : appSettings.commonValueConstants.SUCCESS_UPDATED);
    }).catch((err: any) => {
      this.notificationService.showError(this.newRmanContHeader ? appSettings.commonValueConstants.ERR_SAVING_DATA : appSettings.commonValueConstants.ERR_UPDATING_DATA);
      this.loading = false;
    });

    this.rmanContHeader = new RmanContHeaderImpl();

    this.displayDialog = false;

  }

  delete(rmanContHeader: any) {
    this.rmanContHeader = rmanContHeader;
    if (this.rmanContHeader.ruleStartDate) {
      this.rmanContHeader.ruleStartDate = new Date(this.rmanContHeader.ruleStartDate);
    }
    if (this.rmanContHeader.ruleEndDate) {
      this.rmanContHeader.ruleEndDate = new Date(this.rmanContHeader.ruleEndDate);
    }
    this.displayDialog = false;
    this.confirmationService.confirm({
      message: 'Are you sure you want to delete this record?',
      header: 'Confirmation',
      icon: '',
      accept: () => {
        this.rmanContHeaderList.splice(this.findSelectedRmanContHeaderIndex(), 1);
        this.loading = true;
        this.rmanContHeaderService.deleteRmanContHeader(this.rmanContHeader).then((response: any) => {
          this.loading = false;
          this.rmanContHeader = new RmanContHeaderImpl();
          this.getAllRmanContHeader();
        });
        this.notificationService.showSuccess('Deleted successfully');
      },
      reject: () => {
        this.notificationService.showWarning('You have rejected');
      }
    });
  }



  editRow(rmanContHeader: any) {
    this.newRmanContHeader = false;
    this.rmanContHeader = this.cloneRmanContHeader(rmanContHeader);
    if (this.rmanContHeader.ruleStartDate) {
      this.rmanContHeader.ruleStartDate = new Date(this.rmanContHeader.ruleStartDate);
    }
    if (this.rmanContHeader.ruleEndDate) {
      this.rmanContHeader.ruleEndDate = new Date(this.rmanContHeader.ruleEndDate);
    }

    this.displayDialog = true;
    if (rmanContHeader.revFlag == 'Y') {
      this.revFlag = true;
      this.rmanContHeader.revFlag = true;
    } else {
      this.revFlag = false;
      this.rmanContHeader.revFlag = false;
    }

    if (rmanContHeader.cogsFlag == 'Y') {
      this.cogsFlag = true;
      this.rmanContHeader.cogsFlag = true;
    } else {
      this.cogsFlag = false;
      this.rmanContHeader.cogsFlag = false;
    }
    this.prepareRmanLookupsVObject();
    this.prepareRmanLookupsV1Object();
    this.prepareRmanLookupsV2Object();
    this.prepareRmanLookupsV3Object();

  }




  findSelectedRmanContHeaderIndex(): number {
    return this.rmanContHeaderList.indexOf(this.selectedRmanContHeader);
  }

  onRowSelect(event: any) {
    this.selectedRmanContHeader = event.data;
    this.pContHeaderId = this.selectedRmanContHeader.ruleHeaderId;
  }

  cloneRmanContHeader(c: RmanContHeader): RmanContHeader {
    let rmanContHeader: any
      = new RmanContHeaderImpl();
    for (let prop in c) {
      rmanContHeader[prop] = c[prop];
    }
    return rmanContHeader;
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

    this.rmanContHeaderSearch = new RmanContHeaderImpl();
    if (this.isSerached == 0) {
      this.rmanContHeaderSearch = new RmanContHeaderImpl();
    }
    this.displaySearchDialog = true;

  }

  cancelSearch() {
    this.displaySearchDialog = false;
    this.rmanContHeaderSearch = new RmanContHeaderImpl();
  }

  search() {

    this.isSerached = 1;
    this.rmanContHeader = this.rmanContHeaderSearch;
    this.paginationOptions = {};
    this.getAllRmanContHeader();
  }

  reset(dt: Table) {
    this.paginationOptions = {};
    this.rmanContHeaderSearch = new RmanContHeaderImpl();
    this.rmanContHeader = new RmanContHeaderImpl();
    dt.reset();
  }




  prepareRmanLookupsVObject() {
    let rmanLookupsVTempObj: any = [{ label: appSettings.dropDownOptions.SelectRuleCategory, value: null }];
    this.rmanLookupsV1List.forEach((rmanLookupsV) => {
      rmanLookupsVTempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
    });

    this.rmanLookupsV = rmanLookupsVTempObj;

  }

  prepareRmanLookupsV1Object() {
    let rmanLookupsV1TempObj: any = [{ label: appSettings.dropDownOptions.SelectRuleApply, value: null }];
    this.rmanLookupsVList.forEach((rmanLookupsV1) => {
      rmanLookupsV1TempObj.push({ label: rmanLookupsV1.lookupDescription, value: rmanLookupsV1.lookupCode });
    });

    this.rmanLookupsV1 = rmanLookupsV1TempObj;

  }

  prepareRmanLookupsV2Object() {
    let rmanLookupsV2TempObj: any = [{ label: appSettings.dropDownOptions.SelectContingencyCode, value: null }];
    this.rmanLookupsV2List.forEach((rmanLookupsV2) => {
      rmanLookupsV2TempObj.push({ label: rmanLookupsV2.lookupCode, value: rmanLookupsV2.lookupCode });
    });

    this.rmanLookupsV2 = rmanLookupsV2TempObj;

  }

  prepareRmanLookupsV3Object() {
    let rmanLookupsV3TempObj: any = [{ label: appSettings.dropDownOptions.SelectRevRecHoldApplyLevel, value: null }];
    this.rmanLookupsV3List.forEach((rmanLookupsV3) => {
      rmanLookupsV3TempObj.push({ label: rmanLookupsV3.lookupDescription, value: rmanLookupsV3.lookupCode });
    });

    this.rmanLookupsV3 = rmanLookupsV3TempObj;

  }
  onBeforeToggle(evt: any) {
    this.collapsed = evt.collapsed;
  }

}


class RmanContHeaderImpl {
  constructor(public dealFlag?: any, public attribute30?: any, public ruleHeaderId?: any, public lastUpdateDate?: any, public ranking?: any, public approverId?: any, public attribute29?: any, public attribute28?: any, public attribute27?: any, public attribute26?: any, public attribute3?: any, public createdBy?: any, public attribute2?: any, public lastUpdatedBy?: any, public attribute1?: any, public creationDate?: any, public attribute9?: any, public attribute8?: any, public attribute7?: any, public attribute6?: any, public attribute5?: any, public ruleApplyLevel?: any, public attribute4?: any, public attribute10?: any, public attribute14?: any, public attribute13?: any, public attribute12?: any, public attribute11?: any, public ruleName?: any, public comments?: any, public ruleMasterId?: any, public cogsFlag?: any, public ruleEndDate?: any, public sequenceNumber?: any, public ruleCategory?: any, public description?: any, public ruleStartDate?: any, public attribute21?: any, public attribute20?: any, public revFlag?: any, public attribute25?: any, public attribute24?: any, public attribute23?: any, public attribute22?: any, public attribute18?: any, public attribute17?: any, public attribute16?: any, public attribute15?: any, public attribute19?: any) { }
}


class RmanContTemplateImpl {
  constructor(public attribute10?: any, public invoiceHold?: any, public attribute14?: any, public attribute13?: any, public attribute12?: any, public cogs?: any, public attribute11?: any, public applyType?: any, public lastUpdateDate?: any, public templateId?: any, public description?: any, public effectiveEndDate?: any, public attribute3?: any, public createdBy?: any, public attribute2?: any, public lastUpdatedBy?: any, public attribute1?: any, public revenue?: any, public creationDate?: any, public attribute9?: any, public attribute8?: any, public attribute7?: any, public attribute6?: any, public defaultDays?: any, public attribute5?: any, public attribute4?: any, public effectiveStartDate?: any, public templateName?: any, public attribute15?: any) { }
}

class RmanContLinkedTemplateSvImpl {
  constructor(public attribute3?: any, public attribute10?: any, public createdBy?: any, public attribute2?: any, public lastUpdatedBy?: any, public attribute1?: any, public attribute14?: any, public ruleHeaderId?: any, public attribute13?: any, public attribute12?: any, public attribute11?: any, public creationDate?: any, public attribute9?: any, public attribute8?: any, public attribute7?: any, public lastUpdateDate?: any, public attribute6?: any, public templateId?: any, public attribute5?: any, public attribute4?: any, public attribute15?: any, public key?: any) { }
}

interface ILabels {
  [index: string]: string;
}
