import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NavigationEnd, Router } from "@angular/router";
import { ConfirmationService, Message } from 'primeng/api';
import { Table } from 'primeng/table';
import { RmanContHeaderService } from '../rmanContHeader/rmanContHeaderservice';
import { RmanContTransToReleaseService } from '../rmanContTransToRelease/rmanContTransToReleaseservice';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { RmanContHeaderVService } from '../services/rmanContHeaderVservice';
import { RmanContLinkTemplateVService } from '../services/rmanContLinkTemplateVservice';
import { RmanContProdNameLovVService } from '../services/rmanContProdNameLovVservice';
import { RmanContSourceLovService } from '../services/rmanContSourceLovservice';
import { NotificationService } from '../shared/notifications.service';
import { RmanContTransLines } from './rmanContTransLines';
import { RmanContTransLinesLabels } from './rmanContTransLinesLabels';
import { RmanContTransLinesService } from './rmanContTransLinesservice';


declare var $: any;

@Component({
  templateUrl: './rmanContTransLines.component.html',
  selector: 'rmanContTransLines-data',
  providers: [RmanContTransLinesService, RmanContTransToReleaseService, RmanLookupsVService, RmanContLinkTemplateVService, RmanContProdNameLovVService, RmanContHeaderVService, RmanContSourceLovService, ConfirmationService,RmanContHeaderService]
})

export class RmanContTransLinesComponent implements OnInit {

  displayDialog: boolean;

  displayDialogConfirm: boolean;

  displaySearchDialog: boolean;

  @Input() arrId: string;

  arrIdK: any;

  msgs: Message[] = [];

  @Output() getAllRelease = new EventEmitter();

  rmanContTransLines: any = new RmanContTransLinesImpl();

  rmanContTransLinesSearch: any = new RmanContTransLinesImpl();

  isSerached: number = 0;


  selectedRmanContTransLines: RmanContTransLines;

  newRmanContTransLines: boolean;

  rmanContTransLinesList: any[] = [];

  cols: any[];
  columns: ILabels;

  columnOptions: any[];

  paginationOptions: any;

  pages: {};

  datasource: any[];
  pageSize: number;
  totalElements: number;
  b1period: any;

  rmanLookupsVList: any[] = [];
  rmanLookupsV: any[];
  rmanLookupsV1List: any[] = [];
  rmanLookupsV8: any[];
  rmanLookupsV8List: any[] = [];
  rmanLookupsV9: any[];
  rmanLookupsV9List: any[] = [];
  rmanLookupsV1: any[];
  rmanLookupsV2List: any[] = [];
  rmanLookupsV2: any[];
  rmanLookupsV4List: any[] = [];
  rmanLookupsV4: any[];
  rmanContLinkTemplateVList: any[] = [];
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
  releaseResponse: any;
  applyContingenciesForm: FormGroup;
  rmanContTransToReleaseList: any[] = [];
  tableref: Table;
  customFlag: boolean = true;
  enableFlag: boolean = false;

  revFlag: boolean = false;
  cogsFlag: boolean = false;
  eventFlag: boolean = false;
  loadingContTransLines: boolean;

  sourceHeaderIds: any = [];
  sourceLineIds: any = [];


  constructor(private rmanContHeaderService: RmanContHeaderService, private rmanContTransLinesService: RmanContTransLinesService, private rmanLookupsVService: RmanLookupsVService, private rmanContLinkTemplateVService: RmanContLinkTemplateVService, private rmanContProdNameLovVService: RmanContProdNameLovVService, private rmanContHeaderVService: RmanContHeaderVService, private rmanContSourceLovService: RmanContSourceLovService, private router: Router, private rmanContTransToReleaseService: RmanContTransToReleaseService, private confirmationService: ConfirmationService, private formBuilder: FormBuilder, private notificationService: NotificationService) {

    // generate list code
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.arrIdK = event.url.split('/')[3];
      }
    });


    this.loadingContTransLines = true;
    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'ENABLED_FLAG' }).then((rmanLookupsVList: any) => {
      this.rmanLookupsVList = rmanLookupsVList.content;
      this.rmanLookupsV8List = rmanLookupsVList.content;
      this.rmanLookupsV9List = rmanLookupsVList.content;
      this.prepareRmanLookupsV9Object();
      this.prepareRmanLookupsV8Object();
      this.prepareRmanLookupsVObject();
      this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'RELEASE_EVENT' }).then((rmanLookupsV1List: any) => {
        this.rmanLookupsV1List = rmanLookupsV1List.content;
        this.prepareRmanLookupsV1Object();

        this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'APPLICATION_LEVEL' }).then((rmanLookupsV2List: any) => {
          this.rmanLookupsV2List = rmanLookupsV2List.content;
          this.prepareRmanLookupsV2Object();

          this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'CONT_APPLY_TYPE' }).then((rmanLookupsV4List: any) => {
            this.rmanLookupsV4List = rmanLookupsV4List.content;
            this.prepareRmanLookupsV4Object();

            this.rmanContLinkTemplateVService.getAllRmanContLinkTemplateV(this.paginationOptions, {}).then((rmanContLinkTemplateVList: any) => {
              this.rmanContLinkTemplateVList = rmanContLinkTemplateVList.content;
              this.prepareRmanContLinkTemplateVObject();


              this.rmanContProdNameLovVService.getAllRmanContProdNameLovV(this.paginationOptions, { 'dealArrangementId': this.arrIdK }).then((rmanContProdNameLovVList: any) => {
                this.rmanContProdNameLovVList = rmanContProdNameLovVList.content;
                this.rmanContProdGroupList = rmanContProdNameLovVList.content;
                this.rmanContProdCategoryList = rmanContProdNameLovVList.content;
                this.rmanContProdNameList = rmanContProdNameLovVList.content;
                this.prepareRmanContProdNameLovVObject();



                this.rmanContHeaderService.getAllRmanContHeader(this.paginationOptions, { 'lookupTypeName': 'APPLICATION_LEVEL' }).then((rmanContHeaderVList: any) => {
                  this.rmanContHeaderVList = rmanContHeaderVList.content;
                  this.prepareRmanContHeaderVObject();

                  this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'CONT_EVENT_TYPE' }).then((rmanLookupsV3List: any) => {
                    this.rmanLookupsV3List = rmanLookupsV3List.content;
                    this.prepareRmanLookupsV3Object();

                    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'RMAN_ACCOUNT_STANDARDS' }).then((rmanLookupsV6List: any) => {
                      this.rmanLookupsV6List = rmanLookupsV6List.content;
                      this.prepareRmanLookupsV6Object();

                      this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'ENABLED_FLAG' }).then((rmanLookupsV7List: any) => {
                        this.rmanLookupsV7List = rmanLookupsV7List.content;
                        this.prepareRmanLookupsV7Object();


                        this.rmanContSourceLovService.getAllRmanContSourceLov(this.paginationOptions, { 'dealArrangementId': this.arrIdK }).then((rmanContSourceLovList: any) => {
                          this.rmanContSourceLovList = rmanContSourceLovList.content;
                          this.rmanContSourceLovService.getAllRmanContSourceLov(this.paginationOptions, { 'dealArrangementId': this.arrIdK }).then((rmanContSourceLov1List: any) => {
                            this.rmanContSourceLov1List = rmanContSourceLov1List.content;
                            this.rmanContProdNameLovVService.getAllRmanContProdNameLovV(this.paginationOptions, {}).then((rmanContProdNameLovV1List: any) => {
                              this.rmanContProdNameLovV1List = rmanContProdNameLovV1List.content;
                              this.prepareRmanContProdNameLovV1Object();

                              this.rmanContProdNameLovVService.getAllRmanContProdNameLovV(this.paginationOptions, {}).then((rmanContProdNameLovV2List: any) => {
                                this.rmanContProdNameLovV2List = rmanContProdNameLovV2List.content;
                                this.prepareRmanContProdNameLovV2Object();
                              }).catch((err: any) => {
                                this.notificationService.showError('Error occured while getting data');
                                this.loadingContTransLines = false;
                              });
                            }).catch((err: any) => {
                              this.notificationService.showError('Error occured while getting data');
                              this.loadingContTransLines = false;
                            });
                          }).catch((err: any) => {
                            this.notificationService.showError('Error occured while getting data');
                            this.loadingContTransLines = false;
                          });
                        }).catch((err: any) => {
                          this.notificationService.showError('Error occured while getting data');
                          this.loadingContTransLines = false;
                        });
                      }).catch((err: any) => {
                        this.notificationService.showError('Error occured while getting data');
                        this.loadingContTransLines = false;
                      });
                    }).catch((err: any) => {
                      this.notificationService.showError('Error occured while getting data');
                      this.loadingContTransLines = false;
                    });
                  }).catch((err: any) => {
                    this.notificationService.showError('Error occured while getting "Cont Event Type" data');
                    this.loadingContTransLines = false;
                  });
                }).catch((err: any) => {
                  this.notificationService.showError('Error occured while getting "Contingency Name" data');
                  this.loadingContTransLines = false;
                });
              }).catch((err: any) => {
                this.notificationService.showError('Error occured while getting "element (or) product type (or) product category (or) product name" data');
                this.loadingContTransLines = false;
              });
            }).catch((err: any) => {
              this.notificationService.showError('Error occured while getting "Template" data');
              this.loadingContTransLines = false;
            });
          }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting "Apply Type" data');
            this.loadingContTransLines = false;
          });
        }).catch((err: any) => {
          this.notificationService.showError('Error occured while getting "Application Type" data');
          this.loadingContTransLines = false;
        });
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while getting "Release Event Type" data');
        this.loadingContTransLines = false;
      });
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting "Include in FV Allocation" data');
      this.loadingContTransLines = false;
    });

    this.sourceHeaderIds.push({ label: 'Select Source Header #(*)', value: null });
    this.rmanContSourceLov = this.sourceHeaderIds;
    this.sourceLineIds.push({ label: 'Select Source Line #(*)', value: null });
    this.rmanContSourceLov1 = this.sourceLineIds;

  }

  ngOnInit() {

    this.getAllRmanContTransLines();

    this.cols = [];
    let cols: any = [];
    cols["attribute30"] = "attribute30";
    cols["invoiceHold"] = "invoiceHold";
    cols["sourceLineId"] = "sourceLineId";
    cols["ruleHeaderId"] = "ruleHeaderId";
    cols["releaseCogs"] = "releaseCogs";
    cols["applyType"] = "applyType";
    cols["sourceHeaderId"] = "sourceHeaderId";
    cols["lastUpdateDate"] = "lastUpdateDate";
    cols["event"] = "event";
    cols["ranking"] = "ranking";
    cols["status"] = "status";
    cols["attribute29"] = "attribute29";
    cols["attribute28"] = "attribute28";
    cols["attribute27"] = "attribute27";
    cols["avgContAcceptDur"] = "avgContAcceptDur";
    cols["attribute26"] = "attribute26";
    cols["attribute3"] = "attribute3";
    cols["createdBy"] = "createdBy";
    cols["transHeaderId"] = "transHeaderId";
    cols["maxDuration"] = "maxDuration";
    cols["attribute2"] = "attribute2";
    cols["lastUpdatedBy"] = "lastUpdatedBy";
    cols["attribute1"] = "attribute1";
    cols["applicationLevel"] = "applicationLevel";
    cols["soHeaderId"] = "soHeaderId";
    cols["revenue"] = "revenue";
    cols["creationDate"] = "creationDate";
    cols["attribute9"] = "attribute9";
    cols["attribute8"] = "attribute8";
    cols["attribute7"] = "attribute7";
    cols["productName"] = "productName";
    cols["attribute6"] = "attribute6";
    cols["attribute5"] = "attribute5";
    cols["releaseType"] = "releaseType";
    cols["attribute4"] = "attribute4";
    cols["dealNum"] = "dealNum";
    cols["soLineId"] = "soLineId";
    cols["releaseRevenue"] = "releaseRevenue";
    cols["attribute10"] = "attribute10";
    cols["attribute14"] = "attribute14";
    cols["attribute13"] = "attribute13";
    cols["attribute12"] = "attribute12";
    cols["contEventType"] = "contEventType";
    cols["application"] = "application";
    cols["attribute11"] = "attribute11";
    cols["cogs"] = "cogs";
    cols["comments"] = "comments";
    cols["templateId"] = "templateId";
    cols["ruleCategory"] = "ruleCategory";
    cols["description"] = "description";
    cols["deferredMethod"] = "deferredMethod";
    cols["attribute21"] = "attribute21";
    cols["attribute20"] = "attribute20";
    cols["transLineId"] = "transLineId";
    cols["attribute25"] = "attribute25";
    cols["attribute24"] = "attribute24";
    cols["attribute23"] = "attribute23";
    cols["attribute22"] = "attribute22";
    cols["autoReleaseDays"] = "autoReleaseDays";
    cols["percentage"] = "percentage";
    cols["dealArrangementId"] = "dealArrangementId";
    cols["element"] = "element";
    cols["attribute18"] = "attribute18";
    cols["attribute17"] = "attribute17";
    cols["attribute16"] = "attribute16";
    cols["attribute15"] = "attribute15";
    cols["attribute19"] = "attribute19";

    let rmanContTransLinesLabels = new RmanContTransLinesLabels();
    this.columns = rmanContTransLinesLabels.fieldLabels;
    this.columnOptions = [];
    this.cols = [];
    for (let prop in this.columns) {
      this.cols.push({ field: prop, header: this.columns[prop] });
      this.columnOptions.push({ label: this.columns[prop], value: prop });
    }
    this.buildForm();
  }

  buildForm() {
    this.applyContingenciesForm = this.formBuilder.group({

      'name': [this.rmanContTransLines.ruleHeaderId, [Validators.required]],
      'postAllocationContingency': [this.rmanContTransLines.attribute29, [Validators.required]],
      'event': [this.rmanContTransLines.event, [Validators.required]],
      'appLevel': [this.rmanContTransLines.applicationLevel, [Validators.required]],
      'template': [this.rmanContTransLines.templateId, [Validators.required]],
      'releaseDays': [this.rmanContTransLines.autoReleaseDays],
      'sourceHeaderId': [this.rmanContTransLines.sourceHeaderId],
      'sourceLineId': [this.rmanContTransLines.sourceLineId],
      'revenue': [this.rmanContTransLines.revenue, [Validators.required, Validators.pattern(/^0*[1-9]\d*$/)]],
      'cogs': [this.rmanContTransLines.cogs, [Validators.required, Validators.pattern(/^0*[1-9]\d*$/)]],
    });

    setTimeout(() => {
      if (this.rmanContTransLines.applicationLevel == 'POB') {
        const arrSourceLineId = this.applyContingenciesForm.get('sourceLineId');
        arrSourceLineId.setValidators([Validators.required]);
      }
    }, 2000);

    if (this.rmanContTransLines.event == 'Auto') {
      const autoReleaseDays = this.applyContingenciesForm.get('releaseDays');
      autoReleaseDays.setValidators([Validators.required, Validators.pattern(/^[0-9]+$/)]);
    }
    this.applyContingenciesForm.valueChanges
      .subscribe((data: any) => this.onValueChanged(data));

    this.onValueChanged();
  }

  onValueChanged(data?: any) {
    if (!this.applyContingenciesForm) { return; }
    const form = this.applyContingenciesForm;

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
    'name': '', 'postAllocationContingency': '', 'event': '', 'appLevel': '', 'template': '', 'releaseDays': '', 'sourceHeaderId': '', 'sourceLineId': '', 'revenue': '', 'cogs': ''
  };

  validationMessages = {

    'name': {
      'required': "Name is required"
    },

    'postAllocationContingency': {
      'required': "Post Allocation Contingency is required"
    },
    'event': {
      'required': "Release Event is required"
    },
    'appLevel': {
      'required': "Application Level is required"
    },
    'template': {
      'required': "Template is required"
    },
    'releaseDays': {
      'required': "Release Days is required",
      'pattern': "Enter value greater than '0'"
    },
    'sourceHeaderId': {
      'required': "Source Header # is required"
    },
    'sourceLineId': {
      'required': "Source Line # is required"
    },
    'revenue': {
      'required': "Revenue is required",
      'pattern': "Enter value greater than '0'"
    },
    'cogs': {
      'required': "COGS is required",
      'pattern': "Enter value greater than '0'"
    }

  }


  transformRmanLookupsV(rmanLookupsV: any) {
    if (rmanLookupsV)
      return rmanLookupsV.lookupDescription;
  }
  transformRmanLookupsV8(rmanLookupsV8: any) {
    if (rmanLookupsV8)
      return rmanLookupsV8.lookupDescription;
  }

  transformRmanLookupsV1(rmanLookupsV1: any) {
    if (rmanLookupsV1)
      return rmanLookupsV1.lookupDescription;
  }
  transformRmanLookupsV2(rmanLookupsV2: any) {
    if (rmanLookupsV2)
      return rmanLookupsV2.lookupDescription;
  }
  transformRmanContLinkTemplateV(rmanContLinkTemplateV: any) {
    if (rmanContLinkTemplateV)
      return rmanContLinkTemplateV.templateName;
  }
  transformRmanContProdNameLovV(rmanContProdNameLovV: any) {
    if (rmanContProdNameLovV)
      return rmanContProdNameLovV.elementType;
  }
  transformRmanContHeaderV(rmanContHeaderV: any) {
    if (rmanContHeaderV)
      return rmanContHeaderV.ruleName;
  }
  transformRmanLookupsV3(rmanLookupsV3: any) {
    if (rmanLookupsV3)
      return rmanLookupsV3.lookupDescription;
  }
  transformContAdditionalInfo3LovV(contAdditionalInfo3LovV: any) {
    if (contAdditionalInfo3LovV)
      return contAdditionalInfo3LovV.attribute3;
  }
  transformRmanContSourceLov(rmanContSourceLov: any) {
    if (rmanContSourceLov)
      return rmanContSourceLov.sourceName;
  }
  transformRmanContSourceLov1(rmanContSourceLov1: any) {
    if (rmanContSourceLov1)
      return rmanContSourceLov1.sourceLine;
  }
  transformRmanContProdNameLovV1(rmanContProdNameLovV1: any) {
    if (rmanContProdNameLovV1)
      return rmanContProdNameLovV1.productType;
  }
  transformRmanContProdNameLovV2(rmanContProdNameLovV2: any) {
    if (rmanContProdNameLovV2)
      return rmanContProdNameLovV2.productCategory;
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

  setValidators(controlName) {
    this.applyContingenciesForm.patchValue({
      'sourceHeaderId': ''
    })
  }




  onSelectContingency(contHeaderId: any) {

    let rmanContHeaderFilterList: any = [];
    rmanContHeaderFilterList = this.rmanContHeaderVList.filter((item: any) => item.ruleHeaderId == contHeaderId);
    if (rmanContHeaderFilterList.length > 0) {
      this.rmanContTransLines.ranking = rmanContHeaderFilterList[0].ranking;
      this.rmanContTransLines.ruleCategory = rmanContHeaderFilterList[0].ruleCategory;
      this.rmanContTransLines.attribute28 = rmanContHeaderFilterList[0].attribute3;
      this.rmanContTransLines.attribute29 = rmanContHeaderFilterList[0].attribute2;
    }

    this.loadingContTransLines = true;
    this.rmanContLinkTemplateVService.getAllRmanContLinkTemplateV(this.paginationOptions, { 'ruleHeaderId': contHeaderId }).then((rmanContLinkTemplateVList: any) => {
      this.loadingContTransLines = false;
      this.rmanContLinkTemplateVList = rmanContLinkTemplateVList.content.filter((item: any) => item.ruleHeaderId == contHeaderId, true);
      this.prepareRmanContLinkTemplateVObject();
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loadingContTransLines = false;
    });

  }

  onSelectContTemplate(contTemplateId: any) {
    this.customFlag = true;
    let rmanContTemplateFilterList: any = [];
    rmanContTemplateFilterList = this.rmanContLinkTemplateVList.filter((item: any) => item.templateId == contTemplateId);

    if (rmanContTemplateFilterList.length > 0) {
      this.rmanContTransLines.revenue = rmanContTemplateFilterList[0].revenue;
      this.rmanContTransLines.cogs = rmanContTemplateFilterList[0].cogs;
      this.rmanContTransLines.invoiceHold = rmanContTemplateFilterList[0].invoiceHold;
      this.rmanContTransLines.applyType = rmanContTemplateFilterList[0].applyType;
      if (rmanContTemplateFilterList[0].customFlag == 'Y') {
        this.customFlag = false;
      }
    }
    if (this.rmanContTransLines.applyType == 'PERCENT') {
      this.rmanContTransLines.deferredMethod = 'PRORATE';
    } else {
      this.rmanContTransLines.deferredMethod = 'FIFO';
    }

  }

  onSelecttAutoReleaseEvent(autoEvent: any) {
    if (autoEvent == 'Manual') {
      this.eventFlag = true;
      this.rmanContTransLines.autoReleaseDays = null;
    }
    else {
      this.eventFlag = false;
    }
    this.buildForm();
  }


  getAllRmanContTransLines() {
    this.loadingContTransLines = true;
    this.rmanContTransLinesService.getAllRmanContTransLines(this.paginationOptions, { 'dealArrangementId': this.arrIdK }).then((rmanContTransLinesList: any) => {
      this.loadingContTransLines = false;
      this.datasource = rmanContTransLinesList.content;
      this.rmanContTransLinesList = rmanContTransLinesList.content.filter((item: any) => item.status != "C");
      this.totalElements = rmanContTransLinesList.totalElements;
      this.pageSize = rmanContTransLinesList.size;
      this.displaySearchDialog = false;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loadingContTransLines = false;
    });
  }


  getRmanContTransLines(event: any) {

    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loadingContTransLines = true;
    this.rmanContTransLinesService.getAllRmanContTransLines(this.paginationOptions, { 'dealArrangementId': this.arrIdK }).then((rmanContTransLinesList: any) => {
      this.loadingContTransLines = false;
      this.datasource = rmanContTransLinesList.content;
      this.rmanContTransLinesList = rmanContTransLinesList.content.filter((item: any) => item.status != "C");
      this.totalElements = rmanContTransLinesList.totalElements;
      this.pageSize = rmanContTransLinesList.size;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loadingContTransLines = false;
    });

  }

  onSelectAllocation(event: any) {
    if (event == 'Y') {
      this.rmanContTransLines.attribute29 = 'N';
      this.enableFlag = true;
    }
    else {
      this.enableFlag = false;
      this.rmanContTransLines.attribute29 = '';
    }
  }


  showDialogToAdd() {
    this.newRmanContTransLines = true;
    this.rmanContTransLines = new RmanContTransLinesImpl();
    this.rmanContTransLines.attribute28 = 'N';
    this.rmanContTransLines.contEventType = 'BOTH';
    this.enableFlag = false;
    this.displayDialog = true;
    this.prepareRmanLookupsVObject();
    this.prepareRmanLookupsV8Object();
    this.prepareRmanLookupsV9Object();
    this.prepareRmanLookupsV1Object();
    this.prepareRmanLookupsV2Object();
    this.prepareRmanLookupsV4Object();
    this.prepareRmanContLinkTemplateVObject();
    this.prepareRmanContProdNameLovVObject();
    this.prepareRmanContHeaderVObject();
    this.prepareRmanLookupsV3Object();
    this.prepareRmanContSourceLovObject('add');
    this.prepareRmanContSourceLov1Object('add');
    this.prepareRmanContProdNameLovV1Object();
    this.prepareRmanContProdNameLovV2Object();
    this.buildForm();

  }

  getAllRmanContTransToRelease() {
    this.rmanContTransToReleaseService.getAllRmanContTransToRelease(this.paginationOptions, { 'dealArrangementId': this.arrIdK }).then((rmanContTransToReleaseList: any) => {
      this.datasource = rmanContTransToReleaseList.content;
      this.rmanContTransToReleaseList = rmanContTransToReleaseList.content;
      this.totalElements = rmanContTransToReleaseList.totalElements;
      this.pageSize = rmanContTransToReleaseList.size;
      this.displaySearchDialog = false;

    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loadingContTransLines = false;
    });
  }


  save() {

    if (this.newRmanContTransLines) {
      this.rmanContTransLines.dealArrangementId = this.arrIdK;
      this.rmanContTransLinesService.saveRmanContTransLines(this.rmanContTransLines).then((response: any) => {
        this.getAllRmanContTransLines();
        this.releaseResponse = response.transLineId;
        if (this.releaseResponse != null) {
          this.rmanContTransLinesService.releaseRmanContengencies(this.releaseResponse, this.releaseResponse).then((response: any) => {
            this.notificationService.showSuccess('Saved successfully');
            this.getAllRelease.emit();
          }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loadingContTransLines = false;
          });
        }
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while getting data');
        this.loadingContTransLines = false;
      });

    }
    else {
      this.rmanContTransLinesService.updateRmanContTransLines(this.rmanContTransLines).then((response: any) => {
        this.getAllRmanContTransLines();
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while getting data');
        this.loadingContTransLines = false;
      });
    }
    this.rmanContTransLines = new RmanContTransLinesImpl();
    this.displayDialog = false;
  }


  delete(rmanContTransLines: any) {
    this.rmanContTransLines = rmanContTransLines;
    this.displayDialog = false;
    if (window.confirm('Are you sure you want to delete this record?')) {
      this.rmanContTransLinesList.splice(this.findSelectedRmanContTransLinesIndex(), 1);
      this.loadingContTransLines = true;
      this.rmanContTransLinesService.deleteRmanContTransLines(this.rmanContTransLines).then((response: any) => {
        this.loadingContTransLines = false;
        this.rmanContTransLines = new RmanContTransLinesImpl();
        this.getAllRmanContTransLines();
      });
    }

  }

  editRow(rmanContTransLines: any) {
    this.newRmanContTransLines = false;
    this.rmanContTransLines = this.cloneRmanContTransLines(rmanContTransLines);
    this.displayDialog = true;
    this.prepareRmanLookupsVObject();
    this.prepareRmanLookupsV8Object();
    this.prepareRmanLookupsV9Object();
    this.prepareRmanLookupsV1Object();
    this.prepareRmanLookupsV2Object();
    this.prepareRmanLookupsV4Object();
    this.prepareRmanContLinkTemplateVObject();
    this.prepareRmanContProdNameLovVObject();
    this.prepareRmanContHeaderVObject();
    this.prepareRmanLookupsV3Object();
    this.prepareRmanContSourceLovObject('edit');
    this.prepareRmanContSourceLov1Object('edit');
    this.prepareRmanContProdNameLovV1Object();
    this.prepareRmanContProdNameLovV2Object();

  }


  ConfirmContApply(rmanContTransLines: any) {
    rmanContTransLines = this.selectedRmanContTransLines;
    if (!this.selectedRmanContTransLines) {
      this.notificationService.showInfo('Select a row to confirm..!');

    } else {
      this.confirmationService.confirm({
        message: 'Are you sure that you want to Confirm this contingency?',
        header: 'Confirmation',
        icon: '',
        accept: () => {
          this.newRmanContTransLines = false;
          this.rmanContTransLines = this.cloneRmanContTransLines(rmanContTransLines);
          this.displayDialogConfirm = true;
          this.rmanContTransLines.status = 'C';
          let rmanContLine = this.rmanContTransLines;
          this.rmanContTransLinesService.releaseRmanContengencies(rmanContTransLines.transLineId, rmanContTransLines.transHeaderId).then((response: any) => {
            this.rmanContTransLinesService.updateRmanContTransLines(rmanContLine).then((response: any) => {
              if (response.transHeaderId != null) {
                this.getAllRmanContTransLines();
              }
            });
          });

          this.rmanContTransLines = new RmanContTransLinesImpl();
          this.notificationService.showInfo('You have accepted');
        },
        reject: () => {
          this.notificationService.showInfo('You have rejected');
        }
      });

    }


  }


  findSelectedRmanContTransLinesIndex(): number {
    return this.rmanContTransLinesList.indexOf(this.selectedRmanContTransLines);
  }

  onRowSelect(event: any) {
    this.selectedRmanContTransLines = event.data;
  }

  cloneRmanContTransLines(c: RmanContTransLines): RmanContTransLines {
    let rmanContTransLines: any
      = new RmanContTransLinesImpl();
    for (let prop in c) {
      rmanContTransLines[prop] = c[prop];
    }
    return rmanContTransLines;
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
      this.rmanContTransLinesSearch = new RmanContTransLinesImpl();
    }
    this.displaySearchDialog = true;

  }

  search() {
    this.isSerached = 1;
    this.rmanContTransLines = this.rmanContTransLinesSearch;
    this.getAllRmanContTransLines();
  }

  prepareRmanLookupsVObject() {
    let rmanLookupsVTempObj: any = [];
    rmanLookupsVTempObj.push({ label: 'Select Post Allocation Contingency(*)', value: null });
    this.rmanLookupsVList.forEach((rmanLookupsV) => {
      rmanLookupsVTempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
    });

    this.rmanLookupsV = rmanLookupsVTempObj;

  }

  prepareRmanLookupsV8Object() {
    let rmanLookupsV8TempObj: any = [];
    rmanLookupsV8TempObj.push({ label: 'Select Invoice Hold', value: null });
    this.rmanLookupsV8List.forEach((rmanLookupsV8) => {
      rmanLookupsV8TempObj.push({ label: rmanLookupsV8.lookupDescription, value: rmanLookupsV8.lookupCode });
    });

    this.rmanLookupsV8 = rmanLookupsV8TempObj;

  }

  prepareRmanLookupsV9Object() {
    let rmanLookupsV9TempObj: any = [];
    rmanLookupsV9TempObj.push({ label: 'Select Include in FV Allocation', value: null });
    this.rmanLookupsV9List.forEach((rmanLookupsV9) => {
      rmanLookupsV9TempObj.push({ label: rmanLookupsV9.lookupDescription, value: rmanLookupsV9.lookupCode });
    });

    this.rmanLookupsV9 = rmanLookupsV9TempObj;

  }

  prepareRmanLookupsV1Object() {
    let rmanLookupsV1TempObj: any = [];
    rmanLookupsV1TempObj.push({ label: 'Select Release Event Type(*)', value: null });
    this.rmanLookupsV1List.forEach((rmanLookupsV1) => {
      rmanLookupsV1TempObj.push({ label: rmanLookupsV1.lookupDescription, value: rmanLookupsV1.lookupCode });
    });

    this.rmanLookupsV1 = rmanLookupsV1TempObj;

  }

  prepareRmanLookupsV2Object() {
    let rmanLookupsV2TempObj: any = [];
    rmanLookupsV2TempObj.push({ label: 'Select Application Type(*)', value: null });
    this.rmanLookupsV2List.forEach((rmanLookupsV2) => {
      rmanLookupsV2TempObj.push({ label: rmanLookupsV2.lookupDescription, value: rmanLookupsV2.lookupCode });
    });

    this.rmanLookupsV2 = rmanLookupsV2TempObj;

  }

  prepareRmanLookupsV4Object() {
    let rmanLookupsV4TempObj: any = [];
    rmanLookupsV4TempObj.push({ label: 'Select Apply Type', value: null });
    this.rmanLookupsV4List.forEach((rmanLookupsV4) => {
      rmanLookupsV4TempObj.push({ label: rmanLookupsV4.lookupDescription, value: rmanLookupsV4.lookupCode });
    });

    this.rmanLookupsV4 = rmanLookupsV4TempObj;
  }

  prepareRmanContLinkTemplateVObject() {
    let rmanContLinkTemplateVTempObj: any = [];
    rmanContLinkTemplateVTempObj.push({ label: 'Select Template(*)', value: null });
    this.rmanContLinkTemplateVList.forEach((rmanContLinkTemplateV) => {
      rmanContLinkTemplateVTempObj.push({ label: rmanContLinkTemplateV.templateName, value: rmanContLinkTemplateV.templateId });
    });

    this.rmanContLinkTemplateV = rmanContLinkTemplateVTempObj;

  }

  prepareRmanContProdNameLovVObject() {
    this.rmanContProdNameLovVList = this.removeDuplicate(this.rmanContProdNameLovVList, 'elementType');
    this.rmanContProdGroupList = this.removeDuplicate(this.rmanContProdGroupList, 'productType');
    this.rmanContProdCategoryList = this.removeDuplicate(this.rmanContProdCategoryList, 'productCategory');
    this.rmanContProdNameList = this.removeDuplicate(this.rmanContProdNameList, 'productName');

    let rmanContProdNameLovVTempObj: any = [];
    rmanContProdNameLovVTempObj.push({ label: 'Select Element', value: null });
    this.rmanContProdNameLovVList.forEach((rmanContProdNameLovV) => {
      rmanContProdNameLovVTempObj.push({ label: rmanContProdNameLovV.elementType, value: rmanContProdNameLovV.elementType });
    });

    this.rmanContProdNameLovV = rmanContProdNameLovVTempObj;

    rmanContProdNameLovVTempObj = [];
    rmanContProdNameLovVTempObj.push({ label: 'Select Product Group', value: null });
    this.rmanContProdGroupList.forEach((rmanContProdNameLovV) => {
      rmanContProdNameLovVTempObj.push({ label: rmanContProdNameLovV.productType, value: rmanContProdNameLovV.productType });
    });

    this.rmanContProdGroupV1 = rmanContProdNameLovVTempObj;
    rmanContProdNameLovVTempObj = [];
    rmanContProdNameLovVTempObj.push({ label: 'Select Product Category', value: null });
    this.rmanContProdCategoryList.forEach((rmanContProdNameLovV) => {
      rmanContProdNameLovVTempObj.push({ label: rmanContProdNameLovV.productCategory, value: rmanContProdNameLovV.productCategory });
    });

    this.rmanContProdCategoryV1 = rmanContProdNameLovVTempObj;

    rmanContProdNameLovVTempObj = [];
    rmanContProdNameLovVTempObj.push({ label: 'Select Product Name', value: null });
    this.rmanContProdNameList.forEach((rmanContProdNameLovV) => {
      rmanContProdNameLovVTempObj.push({ label: rmanContProdNameLovV.productName, value: rmanContProdNameLovV.productName });
    });

    this.rmanContProdNameV1 = rmanContProdNameLovVTempObj;

  }

  prepareRmanContHeaderVObject() {
    let rmanContHeaderVTempObj: any = [];
    rmanContHeaderVTempObj.push({ label: 'Select Contingency Name(*)', value: '' });
    this.rmanContHeaderVList.forEach((rmanContHeaderV) => {
      rmanContHeaderVTempObj.push({ label: rmanContHeaderV.ruleName, value: rmanContHeaderV.ruleHeaderId });
    });

    this.rmanContHeaderV = rmanContHeaderVTempObj;

  }

  prepareRmanLookupsV3Object() {
    let rmanLookupsV3TempObj: any = [];
    rmanLookupsV3TempObj.push({ label: 'Select Cont Event Type', value: null });
    this.rmanLookupsV3List.forEach((rmanLookupsV3) => {
      rmanLookupsV3TempObj.push({ label: rmanLookupsV3.lookupDescription, value: rmanLookupsV3.lookupCode });
    });

    this.rmanLookupsV3 = rmanLookupsV3TempObj;

  }

  prepareRmanLookupsV6Object() {
    let rmanLookupsV6TempObj: any = [];
    rmanLookupsV6TempObj.push({ label: 'Select Standard(*)', value: null });
    this.rmanLookupsV6List.forEach((rmanLookupsV6) => {
      rmanLookupsV6TempObj.push({ label: rmanLookupsV6.lookupDescription, value: rmanLookupsV6.lookupCode });
    });

    this.rmanLookupsV6 = rmanLookupsV6TempObj;

  }

  prepareRmanLookupsV7Object() {
    let rmanLookupsV7TempObj: any = [];
    rmanLookupsV7TempObj.push({ label: 'Select One', value: null });
    this.rmanLookupsV7List.forEach((rmanLookupsV7) => {
      rmanLookupsV7TempObj.push({ label: rmanLookupsV7.lookupDescription, value: rmanLookupsV7.lookupCode });
    });

    this.rmanLookupsV7 = rmanLookupsV7TempObj;

  }

  onSelectingApplicationLevel(appLevel: any) {
    this.rmanContSourceLovService.getAllRmanContSourceLov(this.paginationOptions, { 'dealArrangementId': this.arrIdK, 'applicationLevel': appLevel }).then((rmanContSourceLovList: any) => {
      this.rmanContSourceLovList = rmanContSourceLovList.content.filter(item => item.applicationLevel === appLevel);
      if (this.rmanContSourceLovList.length > 0) {
        if (appLevel == 'ARRANGEMENT') {
          this.sourceHeaderIds = [];
          this.sourceLineIds = [];
          //revenue contract# in source header id and source line id disable (both disable)
          this.rmanContTransLines.sourceHeaderId = this.rmanContSourceLovList[0].sourceHeaderId;
          this.rmanContTransLines.attribute21 = this.rmanContSourceLovList[0].sourceHeaderId;
          this.rmanContTransLines.attribute22 = null;
          this.sourceHeaderIds.push({ label: this.rmanContSourceLovList[0].sourceHeaderId, value: this.rmanContSourceLovList[0].sourceHeaderId });
          this.rmanContSourceLov = this.sourceHeaderIds;
        } else if (appLevel == 'POB' || appLevel == 'ORDER') {
          this.sourceHeaderIds = [];
          let uniqueSourceHeaderIds: any[];
          uniqueSourceHeaderIds = this.removeDuplicate(this.rmanContSourceLovList, 'sourceHeaderId');
          //SO# in Source header Id and line number in source line id (both enable)
          this.rmanContTransLines.sourceHeaderId = null;
          this.sourceHeaderIds.push({ label: 'Select Source Header #(*)', value: null });
          if(uniqueSourceHeaderIds.length > 0) {
            uniqueSourceHeaderIds.forEach((obj) => {
              this.sourceHeaderIds.push({ label: obj.sourceName, value: obj.sourceHeaderId });
            });
          }
          this.rmanContSourceLov = this.sourceHeaderIds;
        } else if (appLevel == 'PURCHASE ORDER') {
          this.sourceHeaderIds = [];
          this.sourceLineIds = [];
          //PO# in source header id and source line id disable (both disable)
          this.rmanContTransLines.attribute21 = this.rmanContSourceLovList[0].sourceName;
          this.rmanContTransLines.attribute22 = null;
          this.rmanContTransLines.sourceHeaderId = this.rmanContSourceLovList[0].sourceName;
          this.sourceHeaderIds.push({ label: this.rmanContSourceLovList[0].sourceName, value: this.rmanContSourceLovList[0].sourceHeaderId });
          this.rmanContSourceLov = this.sourceHeaderIds;
        }
      } else {
        this.sourceHeaderIds = [];
        this.sourceLineIds = [];
        this.sourceHeaderIds.push({ label: 'Select Source Header #(*)', value: null });
        this.rmanContSourceLov = this.sourceHeaderIds;
        this.sourceLineIds.push({ label: 'Select Source Line #(*)', value: null });
        this.rmanContSourceLov1 = this.sourceLineIds;
        this.rmanContTransLines.attribute21 = null;
        this.rmanContTransLines.attribute22 = null;
      }
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while fetching data for Source Header# / Source Line#');
    });

  }

  onSelectingSourceHeader(sourceHeaderId: any) {
    //retrieving sourcename for pob and order
    let sourceName: any[] = this.rmanContSourceLov.filter(obj => obj.value == sourceHeaderId);
    this.rmanContTransLines.attribute21 = sourceName[0].label;
    let sourceLineIdsList: any[];
    let uniqueSourceLineIdsList: any[];
    this.sourceLineIds = [];
    sourceLineIdsList = this.rmanContSourceLovList.filter(item => item.sourceHeaderId == sourceHeaderId, true);
    uniqueSourceLineIdsList = this.removeDuplicate(sourceLineIdsList, 'sourceLineId');
    // related source_line number in source line id field
    this.sourceLineIds.push({ label: 'Select Source Line #(*)', value: null });
    if (uniqueSourceLineIdsList.length > 0){
      uniqueSourceLineIdsList.forEach((sourceLineIdObj) => {
        this.sourceLineIds.push({ label: sourceLineIdObj.sourceLine, value: sourceLineIdObj.sourceLineId });
      });
    }
    this.rmanContSourceLov1 = this.sourceLineIds;

  }

  onSelectingSourceLineId(sourceLineId: any){
    let sourceLine: any[] = this.rmanContSourceLov1.filter(obj => obj.value == sourceLineId);
    this.rmanContTransLines.attribute22 = sourceLine[0].label;
    console.log(this.rmanContTransLines.attribute22);
    console.log(sourceLineId);
  }

  //source header
  prepareRmanContSourceLovObject(action?: any) {
    let rmanContSourceLovTempObj: any = [];
    rmanContSourceLovTempObj.push({ label: 'Select Source Header #(*)', value: null });
    this.rmanContSourceLov = rmanContSourceLovTempObj;
  }

  //preparing source line
  prepareRmanContSourceLov1Object(action?: any) {
    let rmanContSourceLov1TempObj: any = [];
    rmanContSourceLov1TempObj.push({ label: 'Select Source Line #(*)', value: null });
    this.rmanContSourceLov1 = rmanContSourceLov1TempObj;
  }

  prepareRmanContProdNameLovV1Object() {
    let rmanContProdNameLovV1TempObj: any = [];
    this.rmanContProdNameLovV1List.forEach((rmanContProdNameLovV1) => {
      rmanContProdNameLovV1TempObj.push({ label: rmanContProdNameLovV1.productType, value: rmanContProdNameLovV1.productType });
    });
    this.rmanContProdNameLovV1 = rmanContProdNameLovV1TempObj;
  }

  prepareRmanContProdNameLovV2Object() {
    let rmanContProdNameLovV2TempObj: any = [];
    this.rmanContProdNameLovV2List.forEach((rmanContProdNameLovV2) => {
      rmanContProdNameLovV2TempObj.push({ label: rmanContProdNameLovV2.productCategory, value: rmanContProdNameLovV2.productCategory });
    });
    this.rmanContProdNameLovV2 = rmanContProdNameLovV2TempObj;
  }

  onBeforeToggle(evt: any) {
    this.collapsed = evt.collapsed;
  }
}


class RmanContTransLinesImpl {
  constructor(public attribute30?: any, public invoiceHold?: any, public sourceLineId?: any, public ruleHeaderId?: any, public releaseCogs?: any, public applyType?: any, public sourceHeaderId?: any, public lastUpdateDate?: any, public event?: any, public ranking?: any, public status?: any, public attribute29?: any, public attribute28?: any, public attribute27?: any, public avgContAcceptDur?: any, public attribute26?: any, public attribute3?: any, public createdBy?: any, public transHeaderId?: any, public maxDuration?: any, public attribute2?: any, public lastUpdatedBy?: any, public attribute1?: any, public applicationLevel?: any, public soHeaderId?: any, public revenue?: any, public creationDate?: any, public attribute9?: any, public attribute8?: any, public attribute7?: any, public productName?: any, public attribute6?: any, public attribute5?: any, public releaseType?: any, public attribute4?: any, public dealNum?: any, public soLineId?: any, public releaseRevenue?: any, public attribute10?: any, public attribute14?: any, public attribute13?: any, public attribute12?: any, public contEventType?: any, public application?: any, public attribute11?: any, public cogs?: any, public comments?: any, public templateId?: any, public ruleCategory?: any, public description?: any, public deferredMethod?: any, public attribute21?: any, public attribute20?: any, public transLineId?: any, public attribute25?: any, public attribute24?: any, public attribute23?: any, public attribute22?: any, public autoReleaseDays?: any, public percentage?: any, public dealArrangementId?: any, public element?: any, public attribute18?: any, public attribute17?: any, public attribute16?: any, public attribute15?: any, public attribute19?: any) { }
}

interface ILabels {
  [index: string]: string;
}
