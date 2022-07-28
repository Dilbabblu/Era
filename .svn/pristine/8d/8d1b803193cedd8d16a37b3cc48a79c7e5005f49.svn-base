
import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NavigationEnd, Router } from "@angular/router";
import { ConfirmationService } from 'primeng/api';
import { Table } from 'primeng/table';
import { RmanContReleaseLinesVComponent } from '../rmanContReleaseLinesV/rmanContReleaseLinesV.component';
import { RmanContTransLinesComponent } from '../rmanContTransLines/rmanContTransLines.component';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { RmanUsersService } from '../rmanUsers/rmanUsersservice';
import { RmanContHeaderVService } from '../services/rmanContHeaderVservice';
import { RmanContLinkTemplateVService } from '../services/rmanContLinkTemplateVservice';
import { RmanContProdNameLovVService } from '../services/rmanContProdNameLovVservice';
import { RmanContSourceLovService } from '../services/rmanContSourceLovservice';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanContTransToRelease } from './rmanContTransToRelease';
import { RmanContTransToReleaseLabels } from './rmanContTransToReleaseLabels';
import { RmanContTransToReleaseService } from './rmanContTransToReleaseservice';
declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
  templateUrl: './rmanContTransToRelease.component.html',
  selector: 'rmanContTransToRelease-data',
  providers: [RmanContTransToReleaseService, ConfirmationService, RmanUsersService, RmanContLinkTemplateVService, RmanContProdNameLovVService, RmanContSourceLovService, RmanContHeaderVService]
})

export class RmanContTransToReleaseComponent implements OnInit {
  noData = appSettings.noData;
  displayDialog: boolean;
  displaySearchDialog: boolean;
  displayConditionDialog: boolean;
  conditionFlag: boolean;
  pTransHeaderId: number;
  arrIdK: any;
  rmanContTransToRelease: any = new RmanContTransToReleaseImpl();
  rmanContTransToReleaseSearch: any = new RmanContTransToReleaseImpl();
  isSerached: number = 0;
  selectedRmanContTransToRelease: RmanContTransToRelease;
  newRmanContTransToRelease: boolean;
  rmanContTransToReleaseList: any[] = [];

  columns: any[];
  columnOptions: any[];
  releaseRevenueError: any;
  paginationOptions: any;
  pages: {};
  datasource: any[];
  pageSize: number;
  totalElements: number;
  addFlag = false;
  rmanUsersList: any[] = [];
  rmanUsers: any[];
  rmanUsers1List: any[] = [];
  rmanUsers1: any[];
  rmanLookupsVList: any[] = [];
  rmanLookupsV: any[];
  rmanLookupsV1List: any[] = [];
  rmanLookupsV1: any[];
  rmanLookupsV2List: any[] = [];
  rmanLookupsV2: any[];
  rmanLookupsV4List: any[] = [];
  rmanLookupsV4: any[];
  rmanContLinkTemplateVList: any[] = [];
  rmanContLinkTemplateVListHeaderId: any[];
  rmanContSourceLovApp: any[];
  rmanContSourceLovApplication: any[];
  rmanContLinkTemplateV: any[];
  rmanContProdNameLovVList: any[] = [];
  rmanContProdNameLovV: any[];
  rmanContHeaderVList: any[] = [];
  rmanContHeaderV: any[];
  rmanLookupsV3List: any[] = [];
  rmanLookupsV3: any[];
  rmanLookupsV6List: any[] = [];
  rmanLookupsV6: any[];
  rmanLookupsV7List: any[] = [];
  rmanLookupsV7: any[];
  contAdditionalInfo3LovVList: any[] = [];
  contAdditionalInfo3LovV: any[];
  rmanContSourceLovList: any[] = [];
  rmanContSourceLov: any[];
  rmanContSourceLov1List: any[] = [];
  rmanContSourceLov1: any[];
  rmanContProdNameLovV1List: any[] = [];
  rmanContProdNameLovV1: any[];
  rmanContProdNameLovV2List: any[] = [];
  rmanContProdNameLovV2: any[];
  rmanContProdGroupV1: any[];
  rmanContProdCategoryV1: any[];
  rmanContProdNameV1: any[];
  rmanContProdGroupList: any[] = [];
  rmanContProdCategoryList: any[] = [];
  rmanContProdNameList: any[] = [];
  collapsed: boolean = true;
  loading: boolean;
  transToReleaseForm: FormGroup;
  dt: Table;

  status: any;
  releaseCont: any[] = [];
  columnLabels: ILabels;
  showAddColumns = true;
  isSelectAllChecked = true;
  globalCols: any[];
  clonedCols: any[];
  userId: number;
  showPaginator: boolean = true;
  startIndex: number;
  minimumDate = new Date();

  @ViewChild(RmanContTransLinesComponent)
  private rmanContTransLinesComponent: RmanContTransLinesComponent;

  @ViewChild(RmanContReleaseLinesVComponent)
  private rmanContReleaseLinesVComponent: RmanContReleaseLinesVComponent;


  constructor(private confirmationService: ConfirmationService, private rmanContTransToReleaseService: RmanContTransToReleaseService, private rmanUsersService: RmanUsersService, private rmanLookupsVService: RmanLookupsVService, private rmanContLinkTemplateVService: RmanContLinkTemplateVService, private rmanContProdNameLovVService: RmanContProdNameLovVService, private rmanContHeaderVService: RmanContHeaderVService, private rmanContSourceLovService: RmanContSourceLovService, private router: Router, private formBuilder: FormBuilder, private commonSharedService: CommonSharedService, private notificationService: NotificationService) {
    // generate list code
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.arrIdK = event.url.split('/')[3];
      }
    });

    this.loading = true;
    this.rmanUsersService.getAllRmanUsers(this.paginationOptions, {}, true).then((rmanUsersList: any) => {
      this.rmanUsersList = rmanUsersList.content;
      this.prepareRmanUsersObject();


      this.rmanUsersService.getAllRmanUsers(this.paginationOptions, {}, true).then((rmanUsers1List: any) => {
        this.rmanUsers1List = rmanUsers1List.content;
        this.prepareRmanUsers1Object();


        this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'ENABLED_FLAG' }).then((rmanLookupsVList: any) => {
          this.rmanLookupsVList = rmanLookupsVList.content;
          this.prepareRmanLookupsVObject();


          this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'RELEASE_EVENT' }).then((rmanLookupsV1List: any) => {
            this.rmanLookupsV1List = rmanLookupsV1List.content;
            this.prepareRmanLookupsV1Object();


            this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'APPLICATION_LEVEL' }).then((rmanLookupsV2List: any) => {
              this.rmanLookupsV2List = rmanLookupsV2List.content;
              this.prepareRmanLookupsV2Object();



              this.rmanContLinkTemplateVService.getAllRmanContLinkTemplateV(this.paginationOptions, {}).then((rmanContLinkTemplateVList: any) => {

                this.rmanContLinkTemplateVList = rmanContLinkTemplateVList.content;
                this.prepareRmanContLinkTemplateVObject();


                this.rmanContProdNameLovVService.getAllRmanContProdNameLovV(this.paginationOptions, { 'dealArrangementId': this.arrIdK }).then((rmanContProdNameLovVList: any) => {

                  this.rmanContProdNameLovVList = rmanContProdNameLovVList.content;
                  this.rmanContProdGroupList = rmanContProdNameLovVList.content;
                  this.rmanContProdCategoryList = rmanContProdNameLovVList.content;
                  this.rmanContProdNameList = rmanContProdNameLovVList.content;
                  this.prepareRmanContProdNameLovVObject();


                  this.rmanContHeaderVService.getAllRmanContHeaderV(this.paginationOptions, { 'lookupTypeName': 'APPLICATION_LEVEL' }).then((rmanContHeaderVList: any) => {
                    this.rmanContHeaderVList = rmanContHeaderVList.content;
                    this.prepareRmanContHeaderVObject();


                    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'CONT_EVENT_TYPE' }).then((rmanLookupsV3List: any) => {
                      this.rmanLookupsV3List = rmanLookupsV3List.content;
                      this.prepareRmanLookupsV3Object();


                      this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'RMAN_ACCOUNT_STANDARDS' }).then((rmanLookupsV6List: any) => {
                        this.rmanLookupsV6List = rmanLookupsV6List.content;
                        this.prepareRmanLookupsV6Object();


                        this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'CONT_RELEASE_TYPE' }).then((rmanLookupsV7List: any) => {
                          this.rmanLookupsV7List = rmanLookupsV7List.content;
                          this.prepareRmanLookupsV7Object();



                          this.rmanContSourceLovService.getAllRmanContSourceLov(this.paginationOptions, {}).then((rmanContSourceLovList: any) => {
                            this.rmanContSourceLovList = rmanContSourceLovList.content;

                            this.rmanContSourceLovService.getAllRmanContSourceLov(this.paginationOptions, {}).then((rmanContSourceLov1List: any) => {
                              this.rmanContSourceLov1List = rmanContSourceLov1List.content;

                              this.rmanContProdNameLovVService.getAllRmanContProdNameLovV(this.paginationOptions, {}).then((rmanContProdNameLovV1List: any) => {
                                this.rmanContProdNameLovV1List = rmanContProdNameLovV1List.content;
                                this.prepareRmanContProdNameLovV1Object();


                                this.rmanContProdNameLovVService.getAllRmanContProdNameLovV(this.paginationOptions, {}).then((rmanContProdNameLovV2List: any) => {
                                  this.loading = false;
                                  this.rmanContProdNameLovV2List = rmanContProdNameLovV2List.content;
                                  this.prepareRmanContProdNameLovV2Object();
                                }).catch((err: any) => {
                                  this.notificationService.showError('Error occured while getting data');
                                  this.loading = false;
                                });
                              }).catch((err: any) => {
                                this.notificationService.showError('Error occured while getting data');
                                this.loading = false;
                              });
                            }).catch((err: any) => {
                              this.notificationService.showError('Error occured while getting "Source Line ID" data');
                              this.loading = false;
                            });
                          }).catch((err: any) => {
                            this.notificationService.showError('Error occured while getting "Standard" data');
                            this.loading = false;
                          });
                        }).catch((err: any) => {
                          this.notificationService.showError('Error occured while getting "Release Type" data');
                          this.loading = false;
                        });
                      }).catch((err: any) => {
                        this.notificationService.showError('Error occured while getting "Cont Event Type" data');
                        this.loading = false;
                      });
                    }).catch((err: any) => {
                      this.notificationService.showError('Error occured while getting "Rule Header ID" data');
                      this.loading = false;
                    });
                  }).catch((err: any) => {
                    this.notificationService.showError('Error occured while getting "Element Type" data');
                    this.loading = false;
                  });
                }).catch((err: any) => {
                  this.notificationService.showError('Error occured while getting data');
                  this.loading = false;
                });
              }).catch((err: any) => {
                this.notificationService.showError('Error occured while getting "Template ID" data');
                this.loading = false;
              });
            }).catch((err: any) => {
              this.notificationService.showError('Error occured while getting "Application Level" data');
              this.loading = false;
            });
          }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting "Release Event" data');
            this.loading = false;
          });
        }).catch((err: any) => {
          this.notificationService.showError('Error occured while getting "Invoice Hold" data');
          this.loading = false;
        });
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while getting data');
        this.loading = false;
      });
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });

    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'CONT_APPLY_TYPE' }).then((rmanLookupsV4List: any) => {
      this.rmanLookupsV4List = rmanLookupsV4List.content;
      this.prepareRmanLookupsV4Object();
    });

  }

  ngOnInit() {
    let rmanContTransToReleaseLabels = new RmanContTransToReleaseLabels();
    this.columnLabels = rmanContTransToReleaseLabels.fieldLabels;
    this.getAllRmanContTransToRelease();
    this.globalCols = [
      { field: 'applicationLevel', header: 'Release Level', showField: true, display: "table-cell", type: 'text', drag: false },
      { field: 'attribute21', header: 'Doc Number', showField: true, display: "table-cell", type: 'number', drag: false },
      { field: 'attribute22', header: 'Doc Line Number', showField: true, display: "table-cell", type: 'number', drag: false },
      { field: 'attribute3', header: 'Product Group', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'attribute2', header: 'Product Category', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'productName', header: 'Product Name', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'attribute29', header: 'Post Allocation Contingency', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'contEventType', header: 'Current/Future', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'ruleName', header: 'Name', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'ranking', header: 'Ranking', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'ruleCategory', header: 'Rule Category', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'attribute28', header: 'Include FV Allocation', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'templateId', header: 'Template Id', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'revenue', header: 'Revenue', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'cogs', header: 'Cogs', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'invoiceHold', header: 'Invoice Hold', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'applyType', header: 'Type', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'deferredMethod', header: 'Method', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'releaseType', header: 'Release Type', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'releaseRevenue', header: 'Release Revenue', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'releaseCogs', header: 'Release Cogs', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'comments', header: 'Comments', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'attribute14', header: 'Additional Info', showField: true, display: "table-cell", type: 'text', drag: true }
    ];
    this.columns = [];
    this.getTableColumns("rmanContTransToRelease", "Release Contingencies");
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
        this.showPaginator = this.columns.length !== 0 ;
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
    this.commonSharedService.saveOrUpdateTableColumns("rmanContTransToRelease", "Release Contingencies", selectedCols, this.userId).then((response) => {
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

  buildForm() {
    this.transToReleaseForm = this.formBuilder.group({
      'releaseType': ['', [Validators.required]],
      'releaseRevenue': ['', [Validators.required]],
      'releaseDate': ['', [Validators.required]],

    });
    this.transToReleaseForm.valueChanges
      .subscribe(data => this.onValueChanged(data));
    this.onValueChanged();
  }

  onValueChanged(data?: any) {
    if (!this.transToReleaseForm) { return; }
    const form = this.transToReleaseForm;

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
    'releaseType': '', 'releaseRevenue': '', 'releaseDate':''
  };

  validationMessages = {

    'releaseType': {
      'required': "Release Type  is required"
    },
    'releaseRevenue': {
      'required': "Release Revenue is required"
    },
    'releaseDate': {
      'required': "Release Date is required"
    }
  }




  transformRmanUsers(rmanUsers: any) {
    if (rmanUsers)
      return rmanUsers.fullName;
  }
  transformRmanUsers1(rmanUsers1: any) {
    if (rmanUsers1)
      return rmanUsers1.fullName;
  }
  transformRmanLookupsV(rmanLookupsV: any) {
    if (rmanLookupsV)
      return rmanLookupsV.lookupDescription;
  }
  transformRmanLookupsV1(rmanLookupsV1: any) {
    if (rmanLookupsV1)
      return rmanLookupsV1.lookupDescription;
  }
  

  /* To Remove Duplicate Rows in Array*/
  removeDuplicate(arr: any, prop: any) {
    var new_arr: any = [];
    var lookup = {};
    for (var i in arr) {
      lookup[arr[i][prop]] = arr[i];
    }
    for (i in lookup) {
      new_arr.push(lookup[i]);
    }
    return new_arr;
  }

  reset(dt: Table) {

    this.paginationOptions = {};
    this.rmanContTransToRelease = new RmanContTransToReleaseImpl();
    dt.reset();
  }



  getReleaseLines() {
    this.rmanContReleaseLinesVComponent.getAllRmanContReleaseLinesV();
  }


  onSelectApplicationLevel(applicationLevel: any) {

    this.rmanContSourceLovService.getAllRmanContSourceLov(this.paginationOptions, { 'dealArrangementId': this.arrIdK, 'applicationLevel': applicationLevel }).then((rmanContSourceLovList: any) => {
      this.rmanContSourceLovList = rmanContSourceLovList.content.filter((item: any) => item.applicationLevel == applicationLevel, true);
      this.rmanContSourceLovList = this.removeDuplicate(this.rmanContSourceLovList, 'sourceHeaderId');
      if (applicationLevel == 'ARRANGEMENT' && this.rmanContSourceLovList.length > 0) {
        this.rmanContTransToRelease.sourceHeaderId = this.rmanContSourceLovList[0].sourceHeaderId;
      } else if (!this.rmanContTransToRelease.sourceHeaderId) {
        this.rmanContTransToRelease.sourceHeaderId = null;
      }
      else {
        this.onSelectSourceHeader(this.rmanContTransToRelease.sourceHeaderId);
      }
      this.prepareRmanContSourceLovObject();
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });

  }

  onSelectSourceHeader(sourceHeaderId: any) {
    this.rmanContSourceLov1List = [];
    this.loading = true;
    this.rmanContSourceLovService.getAllRmanContSourceLov(this.paginationOptions, {
      'dealArrangementId': this.arrIdK
      , 'applicationLevel': this.rmanContTransToRelease.applicationLevel
    }).then((rmanContSourceLov1List: any) => {
      this.rmanContSourceLov1List = rmanContSourceLov1List.content.filter((item: any) => item.sourceHeaderId == sourceHeaderId, true);
      this.rmanContSourceLov1List = this.removeDuplicate(this.rmanContSourceLov1List, 'sourceLineId');
      this.prepareRmanContSourceLov1Object();
      this.loading = false;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }

  onSelectContingency(contHeaderId: any) {
    let rmanContHeaderFilterList: any = [];
    rmanContHeaderFilterList = this.rmanContHeaderVList.filter((item: any) => item.ruleHeaderId == contHeaderId);
    this.rmanContTransToRelease.ranking = rmanContHeaderFilterList[0].ranking;
    this.rmanContTransToRelease.ruleCategory = rmanContHeaderFilterList[0].ruleCategory;
    this.rmanContLinkTemplateVService.getAllRmanContLinkTemplateV(this.paginationOptions, { 'ruleHeaderId': contHeaderId }).then((rmanContLinkTemplateVList: any) => {
      this.rmanContLinkTemplateVList = rmanContLinkTemplateVList.content.filter((item: any) => item.ruleHeaderId == contHeaderId, true);
      this.prepareRmanContLinkTemplateVObject();
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });

  }

  onSelectContTemplate(contTemplateId: any) {
    let rmanContTemplateFilterList: any = [];
    rmanContTemplateFilterList = this.rmanContLinkTemplateVList.filter((item: any) => item.templateId == contTemplateId);
    this.rmanContTransToRelease.revenue = rmanContTemplateFilterList[0].revenue;
    this.rmanContTransToRelease.cogs = rmanContTemplateFilterList[0].cogs;
    this.rmanContTransToRelease.invoiceHold = rmanContTemplateFilterList[0].invoiceHold;
    this.rmanContTransToRelease.applyType = rmanContTemplateFilterList[0].applyType;

    if (this.rmanContTransToRelease.applyType == 'PERCENT') {
      this.rmanContTransToRelease.deferredMethod = 'PRORATE';
    } else {
      this.rmanContTransToRelease.deferredMethod = 'FIFO';
    }

  }

  onSelecttAutoReleaseEvent(autoEvent: any) {
    if (autoEvent != 'Auto') {
      this.rmanContTransToRelease.autoReleaseDays = null;
    }

  }

  onContRelease(releaseType: any, applyType: any) {
    if (releaseType == 'FULL' && applyType == 'PERCENT') {
      this.rmanContTransToRelease.releaseCogs = this.rmanContTransToRelease.cogs;
      this.rmanContTransToRelease.releaseRevenue = this.rmanContTransToRelease.revenue;
    } else {
      this.rmanContTransToRelease.releaseCogs = null;
      this.rmanContTransToRelease.releaseRevenue = null;
    }
  }

  getAllRmanContTransToRelease() {
    this.loading = true;
    this.rmanContTransToReleaseService.getAllRmanContTransToRelease(this.paginationOptions, {
      'dealArrangementId': this.arrIdK
    }).then((rmanContTransToReleaseList: any) => {
      this.loading = false;
      this.datasource = rmanContTransToReleaseList.content;
      this.rmanContTransToReleaseList = rmanContTransToReleaseList.content;
      if (this.rmanContTransToReleaseList.length > 0) {
        /*Begining of Code used for default First Row Selected*/
        this.selectedRmanContTransToRelease = this.rmanContTransToReleaseList[0];
        this.pTransHeaderId = this.selectedRmanContTransToRelease.transHeaderId;
        this.rmanContReleaseLinesVComponent.parentCall(this.selectedRmanContTransToRelease)
        /*End of Code used for default First Row Selected*/
      }
      this.rmanContTransToReleaseList.forEach((releaseCont) => {
        this.status = releaseCont.status;
      });
      this.totalElements = rmanContTransToReleaseList.totalElements;
      this.pageSize = rmanContTransToReleaseList.size;
      this.displaySearchDialog = false;

    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }


  getRmanContTransToRelease(event: any) {
    this.loading = true;
    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.rmanContTransToReleaseService.getAllRmanContTransToRelease(this.paginationOptions, { 'dealArrangementId': this.arrIdK }).then((rmanContTransToReleaseList: any) => {
      this.loading = false;
      this.datasource = rmanContTransToReleaseList.content;
      this.rmanContTransToReleaseList = rmanContTransToReleaseList.content;
      if (this.rmanContTransToReleaseList.length > 0) {
        /*Begining of Code used for default First Row Selected*/
        this.selectedRmanContTransToRelease = this.rmanContTransToReleaseList[0];
        this.pTransHeaderId = this.selectedRmanContTransToRelease.transHeaderId;
        this.rmanContReleaseLinesVComponent.parentCall(this.selectedRmanContTransToRelease)
        /*End of Code used for default First Row Selected*/
      }
      this.rmanContTransToReleaseList.forEach((releaseCont) => {
        this.status = releaseCont.status;
      });
      /* this.status = this.status; */
      this.totalElements = rmanContTransToReleaseList.totalElements;
      this.pageSize = rmanContTransToReleaseList.size;

    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });

  }



  showDialogToAdd() {
    this.rmanContTransLinesComponent.showDialogToAdd();
  }

  releaseRevenueChange(contRelease: any) {
    if ("PERCENT" == contRelease.applyType) {
      if ((contRelease.releaseRevenue + contRelease.attribute25) > contRelease.revenue) {
        this.releaseRevenueError = "Earlier " + this.rmanContTransToRelease.attribute25 + " Percent Released. So you cann't release more than " + (this.rmanContTransToRelease.revenue - this.rmanContTransToRelease.attribute25);
      }
    }

    if ("AMOUNT" == contRelease.applyType) {
      if ((contRelease.releaseRevenue + contRelease.attribute24) > contRelease.attribute23) {
        this.releaseRevenueError = "Earlier " + this.rmanContTransToRelease.attribute24 + " Amount Released. So you cann't release more than " + (this.rmanContTransToRelease.attribute23 - this.rmanContTransToRelease.attribute24);
      }
    }

    if (!this.rmanContTransToRelease.releaseRevenue) {
      this.conditionFlag = false;
    }

  }



  release() {
    this.conditionFlag = false;

    if ("PERCENT" == this.rmanContTransToRelease.applyType) {
      if ((Number(this.rmanContTransToRelease.releaseRevenue) + Number(this.rmanContTransToRelease.attribute25)) > Number(this.rmanContTransToRelease.revenue)) {
        this.releaseRevenueError = "Earlier " + this.rmanContTransToRelease.attribute25 + " Percent Released. So you cann't release more than " + (this.rmanContTransToRelease.revenue - this.rmanContTransToRelease.attribute25);
        this.conditionFlag = true;
      }
    }

    if ("AMOUNT" == this.rmanContTransToRelease.applyType) {
      if ((Number(this.rmanContTransToRelease.releaseRevenue) + Number(this.rmanContTransToRelease.attribute24)) > Number(this.rmanContTransToRelease.attribute23)) {
        this.releaseRevenueError = "Total " + this.rmanContTransToRelease.attribute24 + " Amount Released. So you cann't release more than " + (this.rmanContTransToRelease.attribute23 - this.rmanContTransToRelease.attribute24);
        this.conditionFlag = true;
      }
    }

    if (this.conditionFlag) {
      this.notificationService.showError('' + this.releaseRevenueError);
    } else {
      if (this.newRmanContTransToRelease) {
        this.rmanContTransToReleaseService.saveRmanContTransToRelease(this.rmanContTransToRelease).then((response: any) => {
          this.notificationService.showSuccess('Released successfully');
          this.getAllRmanContTransToRelease();
        }).catch((err: any) => {
          this.notificationService.showError('Error occured while getting data');
          this.loading = false;
        });
      }
      else {
        let headerId = this.rmanContTransToRelease.transHeaderId;
        let lineId = this.rmanContTransToRelease.transLineId;

        if (this.rmanContTransToRelease.ruleCategory == 'PROVISION') {
          this.confirmationService.confirm({
            message: 'Are you sure release for customer payment?',
            header: 'Confirmation',
            icon: 'fa fa-question-circle',
            accept: () => {
              this.rmanContTransToRelease.customerPayment = 'Y';

              this.rmanContTransToReleaseService.updateRmanContTransToRelease(this.rmanContTransToRelease).then((response: any) => {
                this.updateRmanContReleaseData(response, 'Contingency is successfully released.',headerId, lineId, 'Order not yet shipped');
                /*if (response.transHeaderId != null) {
                  this.rmanContTransToReleaseService.insertReleaseLinesRmanContengencies(headerId, lineId).then(response => {
                    this.notificationService.showSuccess('Contingency is successfully released.');
                    this.getAllRmanContTransToRelease();
                    this.getReleaseLines();
                  }).catch((err: any) => {
                    this.notificationService.showError('Order not yet shipped');
                    this.loading = false;
                  });

                }*/

              }).catch((err: any) => {
                this.notificationService.showError('Error occured while getting data');
                this.loading = false;
              });
              this.rmanContTransToRelease = new RmanContTransToReleaseImpl();
              this.displayDialog = false;
            },
            reject: () => {
              this.rmanContTransToRelease.customerPayment = 'N';
              this.rmanContTransToReleaseService.updateRmanContTransToRelease(this.rmanContTransToRelease).then((response: any) => {
                if (response.transHeaderId != null) {
                  this.rmanContTransToReleaseService.insertReleaseLinesRmanContengencies(headerId, lineId).then(response => {
                    this.notificationService.showWarning('You have rejected');
                    this.getAllRmanContTransToRelease();
                    this.getReleaseLines();
                  }).catch((err: any) => {
                    this.notificationService.showError('Error occured while inserting the data');
                    this.loading = false;
                  });

                } else {
                  /* no-code */
                }


              }).catch((err: any) => {
                this.notificationService.showError('Error occured while updating the data');
                this.loading = false;
              });
              this.rmanContTransToRelease = new RmanContTransToReleaseImpl();
              this.displayDialog = false;
            }
          });
        } else {
          this.rmanContTransToRelease.customerPayment = 'N';
          this.rmanContTransToReleaseService.updateRmanContTransToRelease(this.rmanContTransToRelease).then((response: any) => {
            
            this.updateRmanContReleaseData(response,'Contingency is successfully released.', headerId, lineId, 'Error occured while inserting the data');
            
           /* if (response.transHeaderId != null) {
              this.rmanContTransToReleaseService.insertReleaseLinesRmanContengencies(headerId, lineId).then(response => {
                this.notificationService.showSuccess('Contingency is successfully released.');
                this.getAllRmanContTransToRelease();
                this.getReleaseLines();
              }).catch((err: any) => {
                this.notificationService.showError('Error occured while inserting the data');
                this.loading = false;
              });

            }*/
          }).catch((err: any) => {
            this.notificationService.showError('Error occured while updating the data');
            this.loading = false;
          });
          this.rmanContTransToRelease = new RmanContTransToReleaseImpl();
          this.displayDialog = false;
        }

      }
    }
    this.buildForm();
  }

  updateRmanContReleaseData(response: any, msg: any, headerId: any, lineId: any, errorMsg: any){
    if (response.transHeaderId != null) {
      this.rmanContTransToReleaseService.insertReleaseLinesRmanContengencies(headerId, lineId).then(response => {
        this.notificationService.showSuccess(msg);
        this.getAllRmanContTransToRelease();
        this.getReleaseLines();
      }).catch((err: any) => {
        this.notificationService.showError(errorMsg);
        this.loading = false;
      });

    }
  }

  save() {
    this.rmanContTransLinesComponent.save();
  }

  delete(rmanContTransToRelease: any) {
    this.rmanContTransToRelease = rmanContTransToRelease;
    this.displayDialog = false;
    this.confirmationService.confirm({
      message: 'Are you sure you want to delete this record?',
      header: 'Confirmation',
      icon: '',
      accept: () => {
        this.rmanContTransToReleaseList.splice(this.findSelectedRmanContTransToReleaseIndex(), 1);
        this.rmanContTransToReleaseService.deleteRmanContTransToRelease(this.rmanContTransToRelease).then((response: any) => {
          this.rmanContTransToRelease = new RmanContTransToReleaseImpl();
          this.getAllRmanContTransToRelease();
        });
        this.notificationService.showSuccess('Deleted successfully');
      },
      reject: () => {
        this.notificationService.showWarning('You have rejected');
      }
    })
  }

  editRow(rmanContTransToRelease: any) {
    this.newRmanContTransToRelease = false;
    this.rmanContTransToRelease = this.cloneRmanContTransToRelease(rmanContTransToRelease);
    setTimeout(() => {
      this.onSelectApplicationLevel(this.rmanContTransToRelease.applicationLevel);
    }, 2000);

    this.prepareRmanUsersObject();
    this.prepareRmanUsers1Object();
    this.prepareRmanLookupsVObject();
    this.prepareRmanLookupsV1Object();
    this.displayDialog = true;
    this.buildForm();

  }

  releaseLine(rmanContTransToRelease: any) {
    this.newRmanContTransToRelease = false;
    if (rmanContTransToRelease.releaseType != "FULL") {
      this.rmanContTransToRelease = this.cloneRmanContTransToRelease(rmanContTransToRelease);
      this.displayDialog = true;
    } else {
      this.notificationService.showInfo('This selected Contingency is Fully released..!');

    }

  }

  findSelectedRmanContTransToReleaseIndex(): number {
    return this.rmanContTransToReleaseList.indexOf(this.selectedRmanContTransToRelease);
  }

  onRowSelect(event: any) {
    this.selectedRmanContTransToRelease = event.data;
    this.pTransHeaderId = this.selectedRmanContTransToRelease.transHeaderId;
    this.rmanContReleaseLinesVComponent.parentCall(this.selectedRmanContTransToRelease)

  }

  onRowUnSelect(event) {
    this.rmanContReleaseLinesVComponent.parentCall('')
  }

  cloneRmanContTransToRelease(c: RmanContTransToRelease): RmanContTransToRelease {
    let rmanContTransToRelease: any
      = new RmanContTransToReleaseImpl();
    for (let prop in c) {
      rmanContTransToRelease[prop] = c[prop];
    }
    return rmanContTransToRelease;
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
    if (this.isSerached == 0) {
      this.rmanContTransToReleaseSearch = new RmanContTransToReleaseImpl();
    }
    this.displaySearchDialog = true;
  }

  search() {
    this.isSerached = 1;
    this.rmanContTransToRelease = this.rmanContTransToReleaseSearch;
    this.getAllRmanContTransToRelease();
  }

  prepareRmanUsersObject() {
    let rmanUsersTempObj: any = [];
    this.rmanUsersList.forEach((rmanUsers) => {
      rmanUsersTempObj.push({ label: rmanUsers.fullName, value: rmanUsers.rmanUserId });
    });

    this.rmanUsers = rmanUsersTempObj;
  }

  prepareRmanUsers1Object() {
    let rmanUsers1TempObj: any = [];
    this.rmanUsers1List.forEach((rmanUsers1: any) => {
      rmanUsers1TempObj.push({ label: rmanUsers1.fullName, value: rmanUsers1.rmanUserId });
    });

    this.rmanUsers1 = rmanUsers1TempObj;

  }

  prepareRmanLookupsVObject() {
    let rmanLookupsVTempObj: any = [];
    rmanLookupsVTempObj.push({ label: 'Select Invoice Hold', value: null });
    this.rmanLookupsVList.forEach((rmanLookupsV: any) => {
      rmanLookupsVTempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
    });

    this.rmanLookupsV = rmanLookupsVTempObj;

  }

  prepareRmanLookupsV1Object() {
    let rmanLookupsV1TempObj: any = [];
    rmanLookupsV1TempObj.push({ label: 'Select Event', value: null });
    this.rmanLookupsV1List.forEach((rmanLookupsV1: any) => {
      rmanLookupsV1TempObj.push({ label: rmanLookupsV1.lookupDescription, value: rmanLookupsV1.lookupCode });
    });

    this.rmanLookupsV1 = rmanLookupsV1TempObj;

  }

  prepareRmanLookupsV2Object() {
    let rmanLookupsV2TempObj: any = [];
    rmanLookupsV2TempObj.push({ label: 'Select Application Level', value: null });
    this.rmanLookupsV2List.forEach((rmanLookupsV2: any) => {
      rmanLookupsV2TempObj.push({ label: rmanLookupsV2.lookupDescription, value: rmanLookupsV2.lookupCode });
    });

    this.rmanLookupsV2 = rmanLookupsV2TempObj;

  }

  prepareRmanContLinkTemplateVObject() {
    let rmanContLinkTemplateVTempObj: any = [];
    rmanContLinkTemplateVTempObj.push({ label: 'Select Template ID', value: null });
    this.rmanContLinkTemplateVList.forEach((rmanContLinkTemplateV: any) => {
      rmanContLinkTemplateVTempObj.push({ label: rmanContLinkTemplateV.templateName, value: rmanContLinkTemplateV.templateId });
    });

    this.rmanContLinkTemplateV = rmanContLinkTemplateVTempObj;

  }
  prepareRmanLookupsV4Object() {
    let rmanLookupsV4TempObj: any = [];
    rmanLookupsV4TempObj.push({ label: 'Select Apply Type', value: null });
    this.rmanLookupsV4List.forEach((rmanLookupsV4) => {
      rmanLookupsV4TempObj.push({ label: rmanLookupsV4.lookupDescription, value: rmanLookupsV4.lookupCode });
    });

    this.rmanLookupsV4 = rmanLookupsV4TempObj;
  }

  prepareRmanContProdNameLovVObject() {

    this.rmanContProdNameLovVList = this.removeDuplicate(this.rmanContProdNameLovVList, 'elementType');
    this.rmanContProdGroupList = this.removeDuplicate(this.rmanContProdGroupList, 'productType');
    this.rmanContProdCategoryList = this.removeDuplicate(this.rmanContProdCategoryList, 'productCategory');
    this.rmanContProdNameList = this.removeDuplicate(this.rmanContProdNameList, 'productName');

    let rmanContProdNameLovVTempObj: any = [];
    this.rmanContProdNameLovVList.forEach((rmanContProdNameLovV) => {
      rmanContProdNameLovVTempObj.push({ label: rmanContProdNameLovV.elementType, value: rmanContProdNameLovV.elementType });
    });
    this.rmanContProdNameLovV = rmanContProdNameLovVTempObj;
    this.rmanContProdNameLovV.unshift({ label: 'Select Element', value: null })
    rmanContProdNameLovVTempObj = [];
    this.rmanContProdGroupList.forEach((rmanContProdNameLovV: any) => {
      rmanContProdNameLovVTempObj.push({ label: rmanContProdNameLovV.productType, value: rmanContProdNameLovV.productType });
    });

    this.rmanContProdGroupV1 = rmanContProdNameLovVTempObj;
    this.rmanContProdGroupV1.unshift({ label: 'Select Product Group', value: null })

    rmanContProdNameLovVTempObj = [];
    this.rmanContProdCategoryList.forEach((rmanContProdNameLovV: any) => {
      rmanContProdNameLovVTempObj.push({ label: rmanContProdNameLovV.productCategory, value: rmanContProdNameLovV.productCategory });
    });

    this.rmanContProdCategoryV1 = rmanContProdNameLovVTempObj;
    this.rmanContProdCategoryV1.push({ label: 'Select Product Category', value: null })

    rmanContProdNameLovVTempObj = [];
    this.rmanContProdNameList.forEach((rmanContProdNameLovV: any) => {
      rmanContProdNameLovVTempObj.push({ label: rmanContProdNameLovV.productName, value: rmanContProdNameLovV.productName });
    });

    this.rmanContProdNameV1 = rmanContProdNameLovVTempObj;
    this.rmanContProdNameV1.unshift({ label: 'Select Product Name', value: null })


  }

  prepareRmanContHeaderVObject() {
    let rmanContHeaderVTempObj: any = [];
    rmanContHeaderVTempObj.push({ label: 'Select Rule Header ID', value: '' });
    this.rmanContHeaderVList.forEach((rmanContHeaderV: any) => {
      rmanContHeaderVTempObj.push({ label: rmanContHeaderV.ruleName, value: rmanContHeaderV.ruleHeaderId });
    });

    this.rmanContHeaderV = rmanContHeaderVTempObj;

  }

  prepareRmanLookupsV3Object() {
    let rmanLookupsV3TempObj: any = [];
    rmanLookupsV3TempObj.push({ label: 'Select Cont Event Type', value: null });
    this.rmanLookupsV3List.forEach((rmanLookupsV3: any) => {
      rmanLookupsV3TempObj.push({ label: rmanLookupsV3.lookupDescription, value: rmanLookupsV3.lookupCode });
    });

    this.rmanLookupsV3 = rmanLookupsV3TempObj;

  }

  prepareRmanLookupsV6Object() {
    let rmanLookupsV6TempObj: any = [];
    rmanLookupsV6TempObj.push({ label: 'Select Standard', value: null });
    this.rmanLookupsV6List.forEach((rmanLookupsV6: any) => {
      rmanLookupsV6TempObj.push({ label: rmanLookupsV6.lookupDescription, value: rmanLookupsV6.lookupCode });
    });

    this.rmanLookupsV6 = rmanLookupsV6TempObj;

  }

  prepareRmanLookupsV7Object() {
    let rmanLookupsV7TempObj: any = [];
    rmanLookupsV7TempObj.push({ label: 'Select Release Type(*)', value: null });
    this.rmanLookupsV7List.forEach((rmanLookupsV7: any) => {
      rmanLookupsV7TempObj.push({ label: rmanLookupsV7.lookupDescription, value: rmanLookupsV7.lookupCode });
    });

    this.rmanLookupsV7 = rmanLookupsV7TempObj;

  }

  prepareContAdditionalInfo3LovVObject() {
    let contAdditionalInfo3LovVTempObj: any = [];
    this.contAdditionalInfo3LovVList.forEach((contAdditionalInfo3LovV: any) => {
      contAdditionalInfo3LovVTempObj.push({ label: contAdditionalInfo3LovV.attribute3, value: contAdditionalInfo3LovV.attribute3 });
    });

    this.contAdditionalInfo3LovV = contAdditionalInfo3LovVTempObj;

  }

  prepareRmanContSourceLovObject() {
    let rmanContSourceLovTempObj: any = [];
    rmanContSourceLovTempObj.push({ label: 'Select Source Header ID', value: null });
    this.rmanContSourceLovList.forEach((rmanContSourceLov: any) => {
      rmanContSourceLovTempObj.push({ label: rmanContSourceLov.sourceName, value: rmanContSourceLov.sourceHeaderId });
    });

    this.rmanContSourceLov = rmanContSourceLovTempObj;
  }


  prepareRmanContSourceLov1Object() {
    let rmanContSourceLov1TempObj: any = [];
    rmanContSourceLov1TempObj.push({ label: 'Select Source Line ID', value: null });
    this.rmanContSourceLov1List.forEach((rmanContSourceLov1: any) => {
      rmanContSourceLov1TempObj.push({ label: rmanContSourceLov1.sourceLine, value: rmanContSourceLov1.sourceLineId });
    });

    this.rmanContSourceLov1 = rmanContSourceLov1TempObj;
  }

  onBeforeToggle(evt: any) {
    this.collapsed = evt.collapsed;
  }
  prepareRmanContProdNameLovV1Object() {

    let rmanContProdNameLovV1TempObj: any = [];
    this.rmanContProdNameLovV1List.forEach((rmanContProdNameLovV1: any) => {
      rmanContProdNameLovV1TempObj.push({ label: rmanContProdNameLovV1.productType, value: rmanContProdNameLovV1.productType });
    });

    this.rmanContProdNameLovV1 = rmanContProdNameLovV1TempObj;

  }

  prepareRmanContProdNameLovV2Object() {
    let rmanContProdNameLovV2TempObj: any = [];
    this.rmanContProdNameLovV2List.forEach((rmanContProdNameLovV2: any) => {
      rmanContProdNameLovV2TempObj.push({ label: rmanContProdNameLovV2.productCategory, value: rmanContProdNameLovV2.productCategory });
    });

    this.rmanContProdNameLovV2 = rmanContProdNameLovV2TempObj;

  }



}


class RmanContTransToReleaseImpl {
  constructor(public attribute30?: any, public invoiceHold?: any, public sourceLineId?: any, public ruleHeaderId?: any, public releaseCogs?: any, public applyType?: any, public sourceHeaderId?: any, public lastUpdateDate?: any, public event?: any, public ranking?: any, public status?: any, public attribute29?: any, public attribute28?: any, public attribute27?: any, public avgContAcceptDur?: any, public attribute26?: any, public attribute3?: any, public createdBy?: any, public transHeaderId?: any, public maxDuration?: any, public attribute2?: any, public lastUpdatedBy?: any, public attribute1?: any, public applicationLevel?: any, public soHeaderId?: any, public revenue?: any, public creationDate?: any, public attribute9?: any, public attribute8?: any, public attribute7?: any, public productName?: any, public attribute6?: any, public attribute5?: any, public releaseType?: any, public attribute4?: any, public dealNum?: any, public soLineId?: any, public releaseRevenue?: any, public attribute10?: any, public attribute14?: any, public attribute13?: any, public attribute12?: any, public contEventType?: any, public application?: any, public attribute11?: any, public cogs?: any, public comments?: any, public templateId?: any, public ruleCategory?: any, public description?: any, public deferredMethod?: any, public attribute21?: any, public attribute20?: any, public transLineId?: any, public attribute25?: any, public attribute24?: any, public attribute23?: any, public attribute22?: any, public autoReleaseDays?: any, public percentage?: any, public dealArrangementId?: any, public element?: any, public attribute18?: any, public attribute17?: any, public attribute16?: any, public attribute15?: any, public attribute19?: any, public customerPayment?: any, public ruleName?:any, public releaseDate?:any) { }
}

interface ILabels {
  [index: string]: string;
}
