import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ConfirmationService, Message } from 'primeng/api';
import { Table } from 'primeng/table';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { NotificationService } from '../shared/notifications.service';
import { RmanRevenueTemplates } from './rmanRevenueTemplates';
import { RmanRevenueTemplatesLabels } from './rmanRevenueTemplatesLabels';
import { RmanRevenueTemplatesService } from './rmanRevenueTemplatesservice';
import { CommonSharedService } from '../shared/common.service';
declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');


@Component({
  templateUrl: './rmanRevenueTemplates.component.html',
  selector: 'rmanRevenueTemplates-data',
  providers: [RmanRevenueTemplatesService, ConfirmationService]
})

export class RmanRevenueTemplatesComponent {

  displayDialog: boolean;

  displaySearchDialog: boolean;

  rmanRevenueTemplates: any = new RmanRevenueTemplatesImpl();

  rmanRevenueTemplatesSearch: any = new RmanRevenueTemplatesImpl();

  isSerached: number = 0;

  selectedRmanRevenueTemplates: RmanRevenueTemplates;

  newRmanRevenueTemplates: boolean;

  rmanRevenueTemplatesList: RmanRevenueTemplates[];

  cols: any[];
  //columns: ILabels;

  columnOptions: any[];

  paginationOptions = {};

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
  rmanLookupsV5List: any[] = [];
  rmanLookupsV5: any[];
  rmanLookupsV6List: any[] = [];
  rmanLookupsV6: any[];
  rmanLookupsV7List: any[] = [];
  rmanLookupsV7: any[];
  rmanLookupsV8List: any[] = [];
  rmanLookupsV8: any[];
  rmanLookupsV9List: any[] = [];
  rmanLookupsV9: any[];
  rmanTriggerEventList: any[] =[];
  triggerEventsLookup: any[];

  revenueTemplatesForm: FormGroup;
  collapsed: boolean = true;

  msgs: Message[] = [];

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

  constructor(private rmanRevenueTemplatesService: RmanRevenueTemplatesService, private confirmationService: ConfirmationService, private formBuilder: FormBuilder, private rmanLookupsVService: RmanLookupsVService,
    private notificationService: NotificationService, private commonSharedService: CommonSharedService) {

    // generate list code
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    this.loading = true;
    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'ACCOUNTING_TRIGGER' }).then((rmanLookupsVList: any) => {
      this.rmanLookupsVList = rmanLookupsVList.content;
      this.prepareRmanLookupsVObject();


      this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'REVENUE_TEMPLATE_RULE' }).then((rmanLookupsV1List: any) => {
        this.rmanLookupsV1List = rmanLookupsV1List.content;
        this.prepareRmanLookupsV1Object();

        this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'ACCOUNTING_TRIGGER' }).then((rmanLookupsV2List: any) => {
          this.rmanLookupsV2List = rmanLookupsV2List.content;
          this.prepareRmanLookupsV2Object();


          this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'AMORTIZATION_METHOD' }).then((rmanLookupsV3List: any) => {
            this.rmanLookupsV3List = rmanLookupsV3List.content;
            this.prepareRmanLookupsV3Object();


            this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'AMORTIZATION_METHOD' }).then((rmanLookupsV4List: any) => {
              this.rmanLookupsV4List = rmanLookupsV4List.content;
              this.prepareRmanLookupsV4Object();


              this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'REVENUE_TEMPLATE_RULE' }).then((rmanLookupsV5List: any) => {
                this.rmanLookupsV5List = rmanLookupsV5List.content;
                this.prepareRmanLookupsV5Object();


                this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'AMORTIZATION_RULE' }).then((rmanLookupsV6List: any) => {
                  this.rmanLookupsV6List = rmanLookupsV6List.content;
                  this.prepareRmanLookupsV6Object();


                  this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'AMORTIZATION_RULE' }).then((rmanLookupsV7List: any) => {
                    this.rmanLookupsV7List = rmanLookupsV7List.content;
                    this.prepareRmanLookupsV7Object();


                    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'ENABLED_FLAG' }).then((rmanLookupsV8List: any) => {
                      this.loading = false;
                      this.rmanLookupsV8List = rmanLookupsV8List.content;
                      this.prepareRmanLookupsV8Object();
                      this.prepareRmanLookupsV9Object();
                    }).catch((err: any) => {
                      this.notificationService.showError('Error occured while getting "Active Flag" data');
                      this.loading = false;
                    });
                  }).catch((err: any) => {
                    this.notificationService.showError('Error occured while getting "Amortization Rule COGS" data');
                    this.loading = false;
                  });
                }).catch((err: any) => {
                  this.notificationService.showError('Error occured while getting "Amortization Rule Revenue" data');
                  this.loading = false;
                });
              }).catch((err: any) => {
                this.notificationService.showError('Error occured while getting "Accounting Rule COGS" data');
                this.loading = false;
              });
            }).catch((err: any) => {
              this.notificationService.showError('Error occured while getting "Amortization Method Revenue" data');
              this.loading = false;
            });
          }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting "Amortization Method COGS" data');
            this.loading = false;
          });
        }).catch((err: any) => {
          this.notificationService.showError('Error occured while getting "Accounting Trigger Revenue" data');
          this.loading = false;
        });
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while getting "Accounting Rule Revenue" data');
        this.loading = false;
      });
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting "Accounting Trigger COGS" data');
      this.loading = false;
    });

    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'TRIGGERING_EVENT' }).then((response: any) => {
      this.rmanTriggerEventList = response.content;
      this.prepareTriggeringEventObject();
    }).catch(()=>{

    });

    this.buildForm();

  }

  ngOnInit() {
    this.globalCols = [
      { field: 'revenueTemplateId', header: 'Revenue Template ID', showField: true, drag: false, display: "table-cell", type: 'number' },
      { field: 'templateName', header: 'Name', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'description', header: 'Description', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'startDate', header: 'Start Date', showField: true, drag: true, display: "table-cell", type: 'date' },
      { field: 'endDate', header: 'End Date', showField: true, drag: true, display: "table-cell", type: 'date' },
      { field: 'activeFlag', header: 'Active Flag', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'accTriggerRevenue', header: 'Accounting Trigger Revenue', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'accTriggerCogs', header: 'Accounting Trigger COGS', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'accRuleRevenue', header: 'Accounting Rule Revenue', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'accRuleCogs', header: 'Accounting Rule COGS', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'additionalAttribute5', header: 'Triggering Event', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'amortRuleRevenue', header: 'Amortization Rule Revenue', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'amortRuleCogs', header: 'Amortization Rule COGS', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'amortMethodRevenue', header: 'Amortization Method Revenue', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'amortMethodCogs', header: 'Amortization Method COGS', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'revAccount', header: 'Revenue Account', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'revSubaccount', header: 'Revenue Sub Account', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'defRevAccount', header: 'Deferred Revenue Account', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'defRevSubaccount', header: 'Deferred Revenue Sub Account', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'cogsAccount', header: 'COGS Account', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'cogsSubaccount', header: 'COGS Sub Account', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'defCogsAccount', header: 'Deferred COGS Account', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'defCogsSubaccount', header: 'Deferred COGS Sub Account', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'revReserveAccount', header: 'Revenue Reserve Account', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'revenueReserveSubaccount', header: 'Revenue Reserve Sub Account', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'revAmortAccount', header: 'Revenue Amortization Account', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'revAmortSubaccount', header: 'Revenue Amortization Sub Account', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'defRevenueContAccount', header: 'Deferred Revenue Contingency Account', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'defRevenueContSubaccount', header: 'Deferred Revenue Contingency Sub Account', showField: true, drag: true, display: "table-cell", type: 'text' },


    ];

    this.columns = [];


    this.columnOptions = [];

    this.cols = [];

    for (let prop in this.columns) {
      this.cols.push({ field: prop, header: this.columns[prop] });
      this.columnOptions.push({ label: this.columns[prop], value: prop });
    }
    this.buildForm();
    this.getTableColumns("rmanRevenueTemplates", "Revenue Templates");
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
    this.commonSharedService.saveOrUpdateTableColumns("rmanRevenueTemplates", "Revenue Templates", selectedCols, this.userId).then((response) => {
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

  reset(dt: Table) {
    this.paginationOptions = {};
    this.rmanRevenueTemplates = new RmanRevenueTemplatesImpl();
    dt.reset();
  }

  buildForm() {

    let revenuefields: any = {
      'templateName': ['', [Validators.required, Validators.minLength(4), Validators.maxLength(40)]],
      'startDate': ['', [Validators.required]],
      'activeFlag': ['', [Validators.required]],
      'accRuleRevenue': ['', [Validators.required]],
      'accTriggerCogs': ['', [Validators.required]],
      'accTriggerRevenue': ['', [Validators.required]],
      'accRuleCogs': ['', [Validators.required]],
      'additionalAttribute5': ['', [Validators.required]],
      'amortRuleRevenue': [],
      'amortRuleCogs': [],
      'amortMethodRevenue': [],
      'amortMethodCogs': [],
      'revAccount': ['', [Validators.required, Validators.pattern(/^[0-9]+$/)]],
      'revSubaccount': ['', [Validators.required, Validators.pattern(/^[0-9]+$/)]],
      'defRevAccount': ['', [Validators.required, Validators.pattern(/^[0-9]+$/)]],
      'defRevSubaccount': ['', [Validators.required, Validators.pattern(/^[0-9]+$/)]],
      'cogsAccount': ['', [Validators.required, Validators.pattern(/^[0-9]+$/)]],
      'cogsSubaccount': ['', [Validators.required, Validators.pattern(/^[0-9]+$/)]],
      'defCogsAccount': ['', [Validators.required, Validators.pattern(/^[0-9]+$/)]],
      'defCogsSubaccount': ['', [Validators.required, Validators.pattern(/^[0-9]+$/)]],
      'revReserveAccount': ['', [Validators.required, Validators.pattern(/^[0-9]+$/)]],
      'revenueReserveSubaccount': ['', [Validators.required, Validators.pattern(/^[0-9]+$/)]],
      'revAmortAccount': ['', [Validators.required, Validators.pattern(/^[0-9]+$/)]],
      'revAmortSubaccount': ['', [Validators.required, Validators.pattern(/^[0-9]+$/)]],
      'defRevenueContAccount': ['', [Validators.required, Validators.pattern(/^[0-9]+$/)]],
      'defRevenueContSubaccount': ['', [Validators.required, Validators.pattern(/^[0-9]+$/)]]

    };




    if (this.rmanRevenueTemplates.accRuleCogs == 'RATABLE') {
      revenuefields['amortMethodCogs'] = ['', [Validators.required]];
      revenuefields['amortRuleCogs'] = ['', [Validators.required]];
    }

    if (this.rmanRevenueTemplates.accRuleRevenue == 'RATABLE') {

      revenuefields['amortRuleRevenue'] = ['', [Validators.required]];
      revenuefields['amortMethodRevenue'] = ['', [Validators.required]];
    }

    this.revenueTemplatesForm = this.formBuilder.group(revenuefields);



    this.revenueTemplatesForm.valueChanges
      .subscribe(data => this.onValueChanged(data));

    this.onValueChanged();
  }

  onValueChanged(data?: any) {
    if (!this.revenueTemplatesForm) { return; }
    const form = this.revenueTemplatesForm;

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
    'templateName': '', 'startDate': '', 'activeFlag': '', 'accRuleRevenue': '', 'accTriggerRevenue': '', 'amortRuleRevenue': '', 'amortMethodRevenue': '', 'revAccount': '', 'revSubaccount': '', 'defRevAccount': '', 'defRevSubaccount': '', 'cogsAccount': '', 'cogsSubaccount': '', 'defCogsAccount': '', 'defCogsSubaccount': '', 'revReserveAccount': '', 'revenueReserveSubaccount': '', 'revAmortAccount': '', 'revAmortSubaccount': '', 'accTriggerCogs': '', 'accRuleCogs': '', 'amortRuleCogs': '', 'amortMethodCogs': '', 'defRevenueContAccount': '', 'defRevenueContSubaccount': '', 'additionalAttribute5':''
  };

  validationMessages = {
    'templateName': {
      'required': "Name is required (minimum length is 4 and maximum length is 40 characters)",
      'minlength': 'Name must be at least 4 characters long.',
      'maxlength': 'Name cannot be more than 40 characters long.',
    }, 'startDate': {
      'required': "Start Date is Required"
    },
    'activeFlag': {
      'required': "Active Flag is required"
    },  
    'additionalAttribute5': {
      'required': "Triggering Event is required"
    },'accRuleRevenue': {
      'required': "Accounting Rule Revenue is required"
    }, 'accTriggerRevenue': {
      'required': "Accounting Trigger Revenue is required"
    }, 'accTriggerCogs': {
      'required': "Accounting Trigger Cogs is required"
    }, 'accRuleCogs': {
      'required': "Accounting Rule Cogs is required"
    }, 'amortRuleCogs': {
      'required': "Amortization Rule Cogs is required"
    }, 'amortMethodCogs': {
      'required': "Amortization Method Cogs is required"
    },
    'amortRuleRevenue': {
      'required': "Amortization Rule Revenue is required"
    }, 'amortMethodRevenue': {
      'required': "Amortization Method Revenue is required"
    }, 'revAccount': {
      'required': "Revenue Account is required",
      'pattern': "Only number values are allowed [0-9]"
    }, 'revSubaccount': {
      'required': "Revenue Sub Account is required",
      'pattern': "Only number values are allowed [0-9]"
    }, 'defRevAccount': {
      'required': "Deferred Revenue Account is required",
      'pattern': "Only number values are allowed [0-9]"
    }, 'defRevSubaccount': {
      'required': "Deferred Revenue Sub Account is required",
      'pattern': "Only number values are allowed [0-9]"
    }, 'cogsAccount': {
      'required': "COGS Account is required",
      'pattern': "Only number values are allowed [0-9]"
    }, 'cogsSubaccount': {
      'required': "COGS Sub Account is required",
      'pattern': "Only number values are allowed [0-9]"
    }, 'defCogsAccount': {
      'required': " Deferred COGS Account is required",
      'pattern': "Only number values are allowed [0-9]"
    }, 'defCogsSubaccount': {
      'required': "Deferred COGS Sub Account is required",
      'pattern': "Only number values are allowed [0-9]"
    }, 'revReserveAccount': {
      'required': "Revenue Reserve Account is required",
      'pattern': "Only number values are allowed [0-9]"
    }, 'revenueReserveSubaccount': {
      'required': "Revenue Reserve Sub Account is required",
      'pattern': "Only number values are allowed [0-9]"
    }, 'revAmortAccount': {
      'required': "Revenue Amortization Account is required",
      'pattern': "Only number values are allowed [0-9]"
    }, 'revAmortSubaccount': {
      'required': "Revenue Amortization Sub Account is required",
      'pattern': "Only number values are allowed [0-9]"
    }, 'defRevenueContAccount': {
      'required': "Deferred Revenue Contingency Account is required",
      'pattern': "Only number values are allowed [0-9]"
    }, 'defRevenueContSubaccount': {
      'required': "Deferred Revenue Contingency Sub Account is required",
      'pattern': "Only number values are allowed [0-9]"
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
  transformRmanLookupsV5(rmanLookupsV5: any) {
    if (rmanLookupsV5)
      return rmanLookupsV5.lookupDescription;
  }
  transformRmanLookupsV6(rmanLookupsV6: any) {
    if (rmanLookupsV6)
      return rmanLookupsV6.lookupDescription;
  }
  transformRmanLookupsV7(rmanLookupsV7: any) {
    if (rmanLookupsV7)
      return rmanLookupsV7.lookupDescription;
  }

  onSelectRuleRevenue(event: any) {
    if (event === 'IMMEDIATE') {
      this.rmanRevenueTemplates.amortRuleRevenue = '';
      this.rmanRevenueTemplates.amortMethodRevenue = '';
    }
  }

  onSelectRuleCogs(event: any) {
    if (event === 'IMMEDIATE') {
      this.rmanRevenueTemplates.amortRuleCogs = '';
      this.rmanRevenueTemplates.amortMethodCogs = '';
    }
  }


  getAllRmanRevenueTemplates() {
    this.loading = true;
    this.rmanRevenueTemplatesService.getAllRmanRevenueTemplates(this.paginationOptions, this.rmanRevenueTemplates, false)
      .then((rmanRevenueTemplatesList: any) => {
        this.datasource = rmanRevenueTemplatesList.content;
        this.rmanRevenueTemplatesList = rmanRevenueTemplatesList.content;
        this.totalElements = rmanRevenueTemplatesList.totalElements;
        this.pageSize = rmanRevenueTemplatesList.size;
        this.displaySearchDialog = false;
        this.loading = false;
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while getting data');
        this.loading = false;
      });
  }


  getRmanRevenueTemplates(event: any) {

    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loading = true;
    this.rmanRevenueTemplatesService.getAllRmanRevenueTemplates(this.paginationOptions, this.rmanRevenueTemplates, false).then((rmanRevenueTemplatesList: any) => {
      this.datasource = rmanRevenueTemplatesList.content;
      this.rmanRevenueTemplatesList = rmanRevenueTemplatesList.content;
      this.totalElements = rmanRevenueTemplatesList.totalElements;
      this.pageSize = rmanRevenueTemplatesList.size;
      this.loading = false;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });

  }


  showDialogToAdd() {

    this.newRmanRevenueTemplates = true;
    this.rmanRevenueTemplates = new RmanRevenueTemplatesImpl();
    this.displayDialog = true;
    this.prepareRmanLookupsVObject();
    this.prepareRmanLookupsV1Object();
    this.prepareRmanLookupsV2Object();
    this.prepareRmanLookupsV3Object();
    this.prepareRmanLookupsV4Object();
    this.prepareRmanLookupsV5Object();
    this.prepareRmanLookupsV6Object();
    this.prepareRmanLookupsV7Object();
    this.prepareRmanLookupsV8Object();
    this.prepareRmanLookupsV9Object();
    this.buildForm();

  }


  save() {

    if (this.newRmanRevenueTemplates) {
      this.loading = true;
      this.rmanRevenueTemplatesService.saveRmanRevenueTemplates(this.rmanRevenueTemplates).then(response => {
        this.notificationService.showSuccess('Saved successfully');
        this.getAllRmanRevenueTemplates();

      }).catch((err: any) => {
        this.notificationService.showError('Error occured while saving data');
        this.loading = false;
      });
    }
    else {
      this.loading = true;
      this.rmanRevenueTemplatesService.updateRmanRevenueTemplates(this.rmanRevenueTemplates).then(response => {
        this.notificationService.showSuccess('Updated successfully');
        this.getAllRmanRevenueTemplates();

      }).catch((err: any) => {
        this.notificationService.showError('Error occured while updating data');
        this.loading = false;
      });
    }

    this.rmanRevenueTemplates = new RmanRevenueTemplatesImpl();

    this.displayDialog = false;

  }


  delete(rmanRevenueTemplates: any) {
    this.rmanRevenueTemplates = rmanRevenueTemplates;
    if (this.rmanRevenueTemplates.lastUpdateDate) {
      this.rmanRevenueTemplates.lastUpdateDate = new Date(this.rmanRevenueTemplates.lastUpdateDate);
    }
    if (this.rmanRevenueTemplates.createdDate) {
      this.rmanRevenueTemplates.createdDate = new Date(this.rmanRevenueTemplates.createdDate);
    }
    if (this.rmanRevenueTemplates.endDate) {
      this.rmanRevenueTemplates.endDate = new Date(this.rmanRevenueTemplates.endDate);
    }
    if (this.rmanRevenueTemplates.startDate) {
      this.rmanRevenueTemplates.startDate = new Date(this.rmanRevenueTemplates.startDate);
    }


    this.displayDialog = false;

    this.confirmationService.confirm({
      message: 'Are you sure you want to delete this record?',
      header: 'Confirmation',
      icon: '',
      accept: () => {
        this.rmanRevenueTemplatesList.splice(this.findSelectedRmanRevenueTemplatesIndex(), 1);
        this.rmanRevenueTemplatesService.deleteRmanRevenueTemplates(this.rmanRevenueTemplates).then(response => {
          this.rmanRevenueTemplates = new RmanRevenueTemplatesImpl();
          this.getAllRmanRevenueTemplates();
        });
        this.notificationService.showSuccess('Deleted successfully');
      },
      reject: () => {
        this.notificationService.showWarning('You have rejected');
      }
    });

  }

  editRow(rmanRevenueTemplates: any) {
    this.newRmanRevenueTemplates = false;
    this.rmanRevenueTemplates = this.cloneRmanRevenueTemplates(rmanRevenueTemplates);
    if (this.rmanRevenueTemplates.lastUpdateDate) {
      this.rmanRevenueTemplates.lastUpdateDate = new Date(this.rmanRevenueTemplates.lastUpdateDate);
    }
    if (this.rmanRevenueTemplates.createdDate) {
      this.rmanRevenueTemplates.createdDate = new Date(this.rmanRevenueTemplates.createdDate);
    }
    if (this.rmanRevenueTemplates.endDate) {
      this.rmanRevenueTemplates.endDate = new Date(this.rmanRevenueTemplates.endDate);
    }
    if (this.rmanRevenueTemplates.startDate) {
      this.rmanRevenueTemplates.startDate = new Date(this.rmanRevenueTemplates.startDate);
    }
    this.displayDialog = true;
    this.prepareRmanLookupsVObject();
    this.prepareRmanLookupsV1Object();
    this.prepareRmanLookupsV2Object();
    this.prepareRmanLookupsV3Object();
    this.prepareRmanLookupsV4Object();
    this.prepareRmanLookupsV5Object();
    this.prepareRmanLookupsV6Object();
    this.prepareRmanLookupsV7Object();
    this.prepareRmanLookupsV8Object();
    this.prepareRmanLookupsV9Object();

  }


  findSelectedRmanRevenueTemplatesIndex(): number {
    return this.rmanRevenueTemplatesList.indexOf(this.selectedRmanRevenueTemplates);
  }

  onRowSelect(event: any) {

  }

  cloneRmanRevenueTemplates(c: RmanRevenueTemplates): RmanRevenueTemplates {
    let rmanRevenueTemplates: any = new RmanRevenueTemplatesImpl();
    for (let prop in c) {
      rmanRevenueTemplates[prop] = c[prop];
    }
    return rmanRevenueTemplates;
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

    this.rmanRevenueTemplatesSearch = new RmanRevenueTemplatesImpl();

    if (this.isSerached == 0) {
      this.rmanRevenueTemplatesSearch = new RmanRevenueTemplatesImpl();
    }
    this.displaySearchDialog = true;

  }
  cancelAddEdit() {
    this.displayDialog = false;
    this.rmanRevenueTemplates = new RmanRevenueTemplatesImpl();
  }
  search() {

    this.isSerached = 1;
    this.rmanRevenueTemplates = this.rmanRevenueTemplatesSearch;
    this.paginationOptions = {};
    this.getAllRmanRevenueTemplates();
  }

  prepareRmanLookupsVObject() {
    let rmanLookupsVTempObj: any = [{ label: appSettings.dropDownOptions.selectAccounting, value: null }];
    this.rmanLookupsVList.forEach((rmanLookupsV) => {
      rmanLookupsVTempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
    });

    this.rmanLookupsV = rmanLookupsVTempObj;

  }

  prepareRmanLookupsV1Object() {
    let rmanLookupsV1TempObj: any = [{ label: appSettings.dropDownOptions.selectRuleRevenue, value: null }];
    this.rmanLookupsV1List.forEach((rmanLookupsV1) => {
      rmanLookupsV1TempObj.push({ label: rmanLookupsV1.lookupDescription, value: rmanLookupsV1.lookupCode });
    });

    this.rmanLookupsV1 = rmanLookupsV1TempObj;

  }

  prepareRmanLookupsV2Object() {
    let rmanLookupsV2TempObj: any = [{ label: appSettings.dropDownOptions.selectTriggerRevenue, value: null }];
    this.rmanLookupsV2List.forEach((rmanLookupsV2) => {
      rmanLookupsV2TempObj.push({ label: rmanLookupsV2.lookupDescription, value: rmanLookupsV2.lookupCode });
    });

    this.rmanLookupsV2 = rmanLookupsV2TempObj;

  }

  prepareRmanLookupsV3Object() {
    let rmanLookupsV3TempObj: any = [{ label: appSettings.dropDownOptions.selectAmortization, value: null }];
    this.rmanLookupsV3List.forEach((rmanLookupsV3) => {
      rmanLookupsV3TempObj.push({ label: rmanLookupsV3.lookupDescription, value: rmanLookupsV3.lookupCode });
    });

    this.rmanLookupsV3 = rmanLookupsV3TempObj;

  }

  prepareRmanLookupsV4Object() {
    let rmanLookupsV4TempObj: any = [{ label: appSettings.dropDownOptions.selectAmortizationMethod, value: null }];
    this.rmanLookupsV4List.forEach((rmanLookupsV4) => {
      rmanLookupsV4TempObj.push({ label: rmanLookupsV4.lookupDescription, value: rmanLookupsV4.lookupCode });
    });

    this.rmanLookupsV4 = rmanLookupsV4TempObj;

  }

  prepareRmanLookupsV5Object() {
    let rmanLookupsV5TempObj: any = [{ label: appSettings.dropDownOptions.selectRuleCOGS, value: null }];
    this.rmanLookupsV5List.forEach((rmanLookupsV5) => {
      rmanLookupsV5TempObj.push({ label: rmanLookupsV5.lookupDescription, value: rmanLookupsV5.lookupCode });
    });

    this.rmanLookupsV5 = rmanLookupsV5TempObj;

  }

  prepareRmanLookupsV6Object() {
    let rmanLookupsV6TempObj: any = [{ label: appSettings.dropDownOptions.selectAmortizationRule, value: null }];
    this.rmanLookupsV6List.forEach((rmanLookupsV6) => {
      rmanLookupsV6TempObj.push({ label: rmanLookupsV6.lookupDescription, value: rmanLookupsV6.lookupCode });
    });

    this.rmanLookupsV6 = rmanLookupsV6TempObj;

  }

  prepareRmanLookupsV7Object() {
    let rmanLookupsV7TempObj: any = [{ label: appSettings.dropDownOptions.selectAmortizationRuleCOGS, value: null }];
    this.rmanLookupsV7List.forEach((rmanLookupsV7) => {
      rmanLookupsV7TempObj.push({ label: rmanLookupsV7.lookupDescription, value: rmanLookupsV7.lookupCode });
    });

    this.rmanLookupsV7 = rmanLookupsV7TempObj;

  }

  prepareTriggeringEventObject() {
    let rmanTriggeringEvengtLookup: any = [{ label: appSettings.dropDownOptions.selectTriggeringEvent, value: null }];
    this.rmanTriggerEventList.forEach((obj) => {
      rmanTriggeringEvengtLookup.push({ label: obj.lookupDescription, value: obj.lookupCode });
    });

    this.triggerEventsLookup = rmanTriggeringEvengtLookup;

  }

  prepareRmanLookupsV8Object() {
    let rmanLookupsV8TempObj: any = [{ label: appSettings.dropDownOptions.selectActiveFlag, value: null }];
    this.rmanLookupsV8List.forEach((rmanLookupsV8) => {
      rmanLookupsV8TempObj.push({ label: rmanLookupsV8.lookupDescription, value: rmanLookupsV8.lookupCode });
    });

    this.rmanLookupsV8 = rmanLookupsV8TempObj;

  }

  prepareRmanLookupsV9Object() {
    let rmanLookupsV9TempObj: any = [{ label: appSettings.dropDownOptions.selectLtStFlag, value: null }];
    this.rmanLookupsV8List.forEach((rmanLookupsV9) => {
      rmanLookupsV9TempObj.push({ label: rmanLookupsV9.lookupDescription, value: rmanLookupsV9.lookupCode });
    });

    this.rmanLookupsV9 = rmanLookupsV9TempObj;

  }

  onBeforeToggle(evt: any) {
    this.collapsed = evt.collapsed;
  }
}


export class RmanRevenueTemplatesImpl {
  constructor(public amortRuleRevenue?: any, public createdDate?: any, public endDate?: any, public amortMethodRevenue?: any, public amortRuleCogs?: any, public revenueReserveSubaccount?: any, public defCogsSubaccount?: any, public cogsSubaccount?: any, public description?: any, public revAmortAccount?: any, public accRuleCogs?: any, public revAmortSubaccount?: any, public accTriggerCogs?: any, public createdBy?: any, public lastUpdatedBy?: any, public activeFlag?: any, public amortMethodCogs?: any, public cogsAccount?: any, public revAccount?: any, public startDate?: any, public revenueTemplateId?: any, public lastUpdatedDate?: any, public templateName?: any, public revSubaccount?: any, public defCogsAccount?: any, public accTriggerRevenue?: any, public accRuleRevenue?: any, public defRevSubaccount?: any, public defRevAccount?: any, public revReserveAccount?: any, public defRevenueContAccount?: any, public defRevenueContSubaccount?: any, public ltstFlag?: any, public additionalAttribute5?: any) { }
}

interface ILabels {
  [index: string]: string;
}
