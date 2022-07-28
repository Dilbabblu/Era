import { Location } from '@angular/common';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { MenuItem } from 'primeng/api';
import { Subscription } from 'rxjs';
import { RmanDealArrangementsService } from '../rmanDealArrangements/rmanDealArrangementsservice';
import { RmanDealStatusService } from '../services/rmanDealStatusservice';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';

declare var require: any;
declare var $: any;

const appSettings = require('../appsettings');

@Component({
  templateUrl: './rmanArrangementsOverView.component.html',
  selector: 'rmanArrangementsOverView-data',
  providers: [RmanDealArrangementsService, RmanDealStatusService]
})


export class RmanArrangementsOverViewComponent implements OnInit, OnDestroy {
  tabIndex: any;
  tabIndex2: any;
  displaySearchDialog: boolean;
  displaySubmitDialog: boolean;
  displayApproveRejectDialog: boolean;
  onTabSelected: boolean = false;
  rmanDealStatus: any;
  datasource: any[];
  pageSize: number;
  totalElements: number;
  rmanDealStatusList: any[] = [];
  name: any;
  parrangementId: any;
  parrangementDealFlag: any;
  status: any;
  nextDealState: any = '';
  approveRejectFlag: boolean = false;
  displaySubmitFlag: boolean = false;
  displayReopenDialog: boolean = false;
  submitFlag: boolean = false;
  reOpenFlag: boolean = false;
  paramArrangementNumber: any;
  paramArrangementName: any;
  dealArrangementStatus: any;
  rmanDealArrangements: any;
  rmanDealArrangementsList: any[] = [];
  paginationOptions: any;
  state: any;
  response: any;
  dealState: any;
  overviewDealStatus: any;
  commentsSubmit: any = '';
  commentsReopen: any = '';
  commentsApproveReject: any = '';
  result: any[] = [];
  statusResult: string;
  designationResult: string;
  approvalForm: FormGroup;
  reopenForm: FormGroup;
  approveRejectForm: FormGroup;
  
  noData = appSettings.noData;

  subscription1: Subscription;
  selectedInstance: any;
  selectedComponent: any;
  role: any;
  paramTabFound: boolean;
  tabName: string;
  items2: MenuItem[];

  // VariableConsiderationComponent, BookingsComponent, BillingsComponent, RevenueComponent,ForecastingComponent, ForecastingAnalysisComponent

  constructor(private route: ActivatedRoute, private router: Router, private formBuilder: FormBuilder, private rmanDealArrangementsService: RmanDealArrangementsService, private rmanDealStatusService: RmanDealStatusService,
    private commonSharedService: CommonSharedService, private location: Location, private notificationService: NotificationService) {

    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    this.subscription1 = this.commonSharedService.getRole().subscribe(res => {
      this.role = res;
    });

    this.route.params.subscribe(params => {
      this.parrangementId = params['id'];
      this.parrangementDealFlag = params['dealFlag'];
      if (params['tab']) {
        const tab = params['tab'];
        this.paramTabFound = true;
        this.tabName = tab;
      } else {
        this.paramTabFound = false;
      }
    });

    $(document).bind("contextmenu", function (e) {
      return false;
    });

    var angularComp = this;
    $.contextMenu({
      selector: '.ui-tabview ul li:not(:first-child)',
      callback: function (key, options) {
        let tabName = options.$trigger.context.innerText;
        let index = 0;
        if(tabName == 'Revenue Contract Overview'){
          index = 0;
        } else if (tabName == 'Contracts') {
          index = 1;
        } else if (tabName == 'Allocations') {
          index = 2;
        } else if (tabName == 'Holds & Events') {
          index = 3;
        } else if (tabName == 'Bookings') {
          index = 4;
        } else if (tabName == 'Billings') {
          index = 5;
        } else if (tabName == 'Revenue') {
          index = 6;
        } else if (tabName == 'Gross Margin') {
          index = 7;
        } else if (tabName == 'Exceptions') {
          index = 8;
        }else if (tabName == 'Approvals History') {
          index = 10;
        }
        angularComp.navigateToTab(index);
      },
      items: {
        "open": { name: "Open in New Tab", icon: "open" }
      }
    });
  }

  ngOnInit() {
    this.getRmanDealArrangementsById();
    this.buildForm();
    this.buildForm1();
    this.buildForm2();

  }

  buildForm() {
    this.approvalForm = this.formBuilder.group({
      'submitComments': ['', [Validators.required]],
    });

    this.approvalForm.valueChanges
      .subscribe(data => this.onValueChanged(data));

    this.onValueChanged();
  }

  onValueChanged(data?: any) {
    if (!this.approvalForm) { return; }
    const form = this.approvalForm;

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
    'submitComments': ''
  };

  validationMessages = {
    'submitComments': {
      'required': "Comments is required"
    }
  }

  buildForm1() {
    this.reopenForm = this.formBuilder.group({

      'reopenComments': ['', [Validators.required]],
    });

    this.reopenForm.valueChanges
      .subscribe(data => this.onValueChanged1(data));

    this.onValueChanged1();
  }

  onValueChanged1(data?: any) {
    if (!this.reopenForm) { return; }
    const form = this.reopenForm;

    for (const field in this.formErrors1) {
      // clear previous error message (if any)
      this.formErrors1[field] = '';
      const control = form.get(field);
      if (control && control.dirty && !control.valid) {
        const messages = this.validationMessages1[field];
        for (const key in control.errors) {
          this.formErrors1[field] += messages[key] + ' ';
        }
      }
    }
  }

  formErrors1 = {
    'reopenComments': ''
  };

  validationMessages1 = {
    'reopenComments': {
      'required': "Comments is required"
    }
  }

  buildForm2() {
    this.approveRejectForm = this.formBuilder.group({
      'approveComments': ['', [Validators.required]],
    });

    this.approveRejectForm.valueChanges
      .subscribe(data => this.onValueChanged2(data));

    this.onValueChanged2();
  }

  onValueChanged2(data?: any) {
    if (!this.approveRejectForm) { return; }
    const form = this.approveRejectForm;

    for (const field in this.formErrors2) {
      // clear previous error message (if any)
      this.formErrors2[field] = '';
      const control = form.get(field);
      if (control && control.dirty && !control.valid) {
        const messages = this.validationMessages2[field];
        for (const key in control.errors) {
          this.formErrors2[field] += messages[key] + ' ';
        }
      }
    }
  }

  formErrors2 = {
    'approveComments': ''
  };

  validationMessages2 = {
    'approveComments': {
      'required': "Comments is required"
    }
  }
  /*handleChangeFCST(event: any) {

    var index = event.index;

    this.tabIndex2 = index;
    if (this.tabIndex2 == 0) {
      this.router.navigate(['/rmanArrangementsAllV', 'rmanArrangementsOverView', this.parrangementId, this.parrangementDealFlag, 'forecasting', 'enterForecasting']);
    }
    if (this.tabIndex2 == 1) {
      this.router.navigate(['/rmanArrangementsAllV', 'rmanArrangementsOverView', this.parrangementId, this.parrangementDealFlag, 'forecasting', 'viewForecasting']);
    }
  }*/
  getRmanDealArrangementsById() {
    $.blockUI();
    this.rmanDealArrangementsService.getAllRmanDealArrangements(this.paginationOptions, { 'dealArrangementId': this.parrangementId }).then((rmanDealArrangementsList: any) => {
      this.rmanDealArrangementsList = rmanDealArrangementsList.content;
      this.paramArrangementName = this.rmanDealArrangementsList[0].dealArrangementName;
      this.paramArrangementNumber = this.rmanDealArrangementsList[0].dealArrangementNumber;
      this.status = this.rmanDealArrangementsList[0].dealArrangementStatus;
      $.unblockUI();
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting "Arrangement by ID" data');
      $.unblockUI();
    });
  }




  handleChange(event: any) {
    var index = event.index;
    this.tabIndex = index;

    if(this.tabIndex == 0){
      this.router.navigate(['/rmanArrangementsAllV', 'rmanArrangementsOverView', this.parrangementId, this.parrangementDealFlag]);
    }
    if (this.tabIndex == 1) {
      this.router.navigate(['/rmanArrangementsAllV', 'rmanArrangementsOverView', this.parrangementId, this.parrangementDealFlag, 'contracts']);
    }
    if (this.tabIndex == 2) {
      this.router.navigate(['/rmanArrangementsAllV', 'rmanArrangementsOverView', this.parrangementId, this.parrangementDealFlag, 'allocations'], {state: {arrgId : this.parrangementId}});
    }
    if (this.tabIndex == 3) {
      this.router.navigate(['/rmanArrangementsAllV', 'rmanArrangementsOverView', this.parrangementId, this.parrangementDealFlag, 'vconsideration']);
    }
    if (this.tabIndex == 4) {
      this.router.navigate(['/rmanArrangementsAllV', 'rmanArrangementsOverView', this.parrangementId, this.parrangementDealFlag, 'bookings']);
    }
    if (this.tabIndex == 5) {
      this.router.navigate(['/rmanArrangementsAllV', 'rmanArrangementsOverView', this.parrangementId, this.parrangementDealFlag, 'billings']);
    }
    if (this.tabIndex == 6) {
      this.router.navigate(['/rmanArrangementsAllV', 'rmanArrangementsOverView', this.parrangementId, this.parrangementDealFlag, 'revenue']);
    }
    if (this.tabIndex == 7) {
      this.router.navigate(['/rmanArrangementsAllV', 'rmanArrangementsOverView', this.parrangementId, this.parrangementDealFlag, 'grossmargin']);
    }
    if (this.tabIndex == 8) {
     // this.tabIndex2 = 0;
     // this.router.navigate(['/rmanArrangementsAllV', 'rmanArrangementsOverView', this.parrangementId, this.parrangementDealFlag, 'forecasting', 'enterForecasting']);
      this.router.navigate(['/rmanArrangementsAllV', 'rmanArrangementsOverView', this.parrangementId, this.parrangementDealFlag, 'forecasting', 'viewForecasting']);
    }
    if (this.tabIndex == 9) {
      this.router.navigate(['/rmanArrangementsAllV', 'rmanArrangementsOverView', this.parrangementId, this.parrangementDealFlag, 'forecasting', 'actualAnalysis']);
    }
    if (this.tabIndex == 10) {
      this.router.navigate(['/rmanArrangementsAllV', 'rmanArrangementsOverView', this.parrangementId, this.parrangementDealFlag, 'approvalhistory']);
    }
  }

  navigateToTab(index: number) {
    let url = location.href;
    let tabName = '';
    if (index == 1) {
      tabName = '/contracts';
    } else if (index == 2) {
      tabName = '/allocations';
    } else if (index == 3) {
      tabName = '/variableConsiderations';
    } else if (index == 4) {
      tabName = '/bookings';
    } else if (index == 5) {
      tabName = '/billings';
    } else if (index == 6) {
      tabName = '/revenue';
    } else if (index == 7) {
      tabName = '/grossMargin';
    } else if (index == 8) {
      tabName = '/exceptions';
    }
    window.open(url + tabName, "_blank");
  }

  ngOnDestroy() {
    this.subscription1.unsubscribe();
  }

}
