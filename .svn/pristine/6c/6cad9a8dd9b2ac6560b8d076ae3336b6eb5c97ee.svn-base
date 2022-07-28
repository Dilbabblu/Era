import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ConfirmationService } from 'primeng/api';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { NotificationService } from '../shared/notifications.service';
import { RmanPendingApprovals } from './rmanPendingApprovals';
import { RmanPendingApprovalsService } from './rmanPendingApprovals.service';

import { RmanUsersService } from '../rmanUsers/rmanUsersservice';
declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
  selector: 'rman-pendingapprovals',
  templateUrl: './rmanPendingApprovals.component.html',
  providers: [ConfirmationService, RmanPendingApprovalsService, RmanLookupsVService, RmanUsersService]
})
export class RmanPendingApprovalsComponent implements OnInit {


  noData = appSettings.noData;

  arrIdK: any;
  loading: boolean;
  pendingLoading: boolean;

  rmanPendingApprovalsList: any[] = [];
  rmanOutstandingApprovalsList: any[]=[];
  paginationOptions: any;

  pages: {};

  datasource: any[];
  pendingPageSize: number;
  pageSize: number;
  totalElements: number;
  pendingTotalElements: number;
  displayApproveDialog: boolean;
  displayDelegateDialog: boolean;
  displayDialog: boolean;
  displaySubmitDialog: boolean;
  rmanPendingApprovals: any = new RmanPendingApprovalsImpl();
  rmanOutstandingApprovals: any = new RmanPendingApprovalsImpl();
  rmanUsersList: any[];
  userLookup: any[];
  comments: any;
  delegatedUser: any;
  delegateForm: FormGroup;
  pendingRequestsTable: boolean = true;
  displayOutstandingTbl: boolean = false;
  submitComments: any[];
  moreInfoComments: any;


  constructor( private rmanPendingApprovalsService: RmanPendingApprovalsService, private notificationService: NotificationService,  private rmanUsersService: RmanUsersService,
    private formBuilder: FormBuilder) {

    // generate list code
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
     
    /*this.rmanUsersService.getAllRmanUsers(this.paginationOptions, {'enabledFlag':'Y'}, true).then((rmanUsersList: any) => {
      this.rmanUsersList = rmanUsersList.content;
      this.prepareRmanUsersObject();
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting "Legal Entity" data');
      this.pendingLoading = false;
    });*/

    this.rmanPendingApprovalsService.fetchDelegateUsers().then((rmanUsersList: any) => {
      if(rmanUsersList.length>0){
      this.rmanUsersList = rmanUsersList;
      this.prepareRmanUsersObject();
    }else{
      this.notificationService.showInfo('No Users found with Same Role in Same Legal Entity for Delegation');
      this.pendingLoading = false;
    }
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while fetching "Delegate Users" data');
      this.pendingLoading = false;
    });

   
  }

  prepareRmanUsersObject() {
    let rmanUsersTempObj: any = [{ label: "Select User", value: null }];
    this.rmanUsersList.forEach((rmanUser) => {
      rmanUsersTempObj.push({ label: rmanUser.userName, value: rmanUser.emailAddress});
    });
    this.userLookup = rmanUsersTempObj;
  }


  ngOnInit() {
    this.pendingRequestsTable = true;
    this.displayOutstandingTbl = false;
    this.buildForm();
  }

  showPendingApprovals(){
    this.pendingRequestsTable = true;
    this.displayOutstandingTbl = false;
  }

  showOutstandingApprovals(){
    this.pendingRequestsTable = false;
    this.displayOutstandingTbl = true;
  }

  buildForm() {
    this.delegateForm = this.formBuilder.group({
      'user': ['', [Validators.required]],
      'comments': ['', []],
    });
    this.delegateForm.valueChanges
      .subscribe(data => this.onValueChanged(data));
    this.onValueChanged();
  }
  
  onValueChanged(data?: any) {
    if (!this.delegateForm) { return; }
    const form = this.delegateForm;
  
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
    'user': '', 'comments':''
  };
  
  validationMessages = {
    'user':{ 'required': "User is required" }
  }

  getAllRmanPendingApprovals() {
    this.pendingLoading = true;
    this.rmanPendingApprovalsService.getAllPendingApprovals(this.paginationOptions).then((rmanPendingApprovalsList: any) => {
      this.pendingLoading = false;
      this.datasource = rmanPendingApprovalsList.content;
      this.rmanPendingApprovalsList = rmanPendingApprovalsList.content;
      this.pendingTotalElements = rmanPendingApprovalsList.totalElements;
      this.pendingPageSize = rmanPendingApprovalsList.size;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.pendingLoading = false;
    });
  }

  integrateData(rmanOutstandingApprovalsList: any){
    this.loading = false;
    this.datasource = rmanOutstandingApprovalsList.content;
    this.rmanOutstandingApprovalsList = rmanOutstandingApprovalsList.content;
    this.totalElements = rmanOutstandingApprovalsList.totalElements;
    this.pageSize = rmanOutstandingApprovalsList.size;
  }

  getAllRmanOutstandingApprovals() {
    this.loading = true;
    this.rmanPendingApprovalsService.getAllOutstandingApprovals(this.paginationOptions).then((rmanOutstandingApprovalsList: any) => {
     this.integrateData(rmanOutstandingApprovalsList);
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }

  getRmanOutstandingApprovals(event: any) {
    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loading = true;
    this.rmanPendingApprovalsService.getAllOutstandingApprovals(this.paginationOptions).then((rmanOutstandingApprovalsList: any) => {
      this.integrateData(rmanOutstandingApprovalsList);
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }


  getRmanPendingApprovals(event: any) {
    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pendingPageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.getAllRmanPendingApprovals();
  }

  approve(rmanPendingApprovals){
    this.rmanPendingApprovals = rmanPendingApprovals;
    this.displayApproveDialog = true;
  }

  cancelApprove(){
    this.displayApproveDialog = false;
    this.comments=null;
  }

  moreInfo(rmanPendingApprovals){
    this.rmanPendingApprovals = rmanPendingApprovals;
    this.displayDialog = true;
  }

  cancelInfo(){
    this.displayDialog = false;
    this.moreInfoComments=null;
  }

  onHide(event:any){
    
  }

  delegate(rmanPendingApprovals){
    this.rmanPendingApprovals = rmanPendingApprovals;
    this.displayDelegateDialog = true;
  }
  cancelDelegate(){
    this.displayDelegateDialog = false;
    this.comments=null;
  }

  submitForApproval(rmanOutstandingApprovals){
    this.rmanOutstandingApprovals = rmanOutstandingApprovals;
    this.displaySubmitDialog = true;
  }

  submit(){
    this.loading = true;
    this.displaySubmitDialog = false;
    //this.rmanOutstandingApprovals.decision="SUBMITTED_FOR_APPROVAL";
    //this.rmanOutstandingApprovals.comments = this.submitComments;
    this.rmanPendingApprovalsService.processContract({'arrangementId':this.rmanOutstandingApprovals.revenueContractNumber, 'comments':this.submitComments,'taskName':'','decision':'SUBMITTED_FOR_APPROVAL','arrangementTotal':this.rmanOutstandingApprovals.revenueContractAmount}).then((response: any) => {
     console.log(response);
   // console.log(response==true);
      if(response){
        this.loading = false;
        this.notificationService.showSuccess('Submitted for Approval successfully');
        this.submitComments=null;
        this.rmanOutstandingApprovals = new RmanPendingApprovalsImpl();
        this.getAllRmanOutstandingApprovals();
      }else{
        this.loading = false;
        this.notificationService.showError('Error Occured while submitting for approval');
        this.submitComments=null;
        this.rmanOutstandingApprovals = new RmanPendingApprovalsImpl();
      }
    }).catch((err: any) => {
      this.notificationService.showError('Error Occured while submitting for approval');
      this.loading = false;
      this.displaySubmitDialog = false;
      this.submitComments=null;
    });
  }

  cancelSubmit(){
    this.rmanOutstandingApprovals = new RmanPendingApprovalsImpl();
    this.displaySubmitDialog = false;
    this.submitComments=null;
  }

  saveApprove(){
    this.pendingLoading = true;
    this.displayApproveDialog = false;
    //this.rmanPendingApprovals.decision="APPROVED";
    //this.rmanPendingApprovals.comments = this.comments;
    this.rmanPendingApprovalsService.processContract({'arrangementId':this.rmanPendingApprovals.revenueContractNumber, 'comments':this.comments,'taskName':'','decision':'APPROVED','arrangementTotal':this.rmanPendingApprovals.revenueContractAmount}).then((response: any) => {
      console.log(response);
   // console.log(response==true);
      if(response){
        this.pendingLoading = false;
        this.notificationService.showSuccess('Approved successfully');
        this.comments=null;
        this.rmanPendingApprovals = new RmanPendingApprovalsImpl();
        this.getAllRmanPendingApprovals();
      }else{
        this.pendingLoading = false;
        this.notificationService.showError('Error Occured while approving');
        this.comments=null;
        this.rmanPendingApprovals = new RmanPendingApprovalsImpl();
      }
    }).catch((err: any) => {
      this.notificationService.showError('Error Occured while approving');
      this.pendingLoading = false;
      this.displayApproveDialog = false;
      this.comments=null;
    });
  }

  requestForMoreInfo(){
    this.pendingLoading = true;
    this.displayDialog = false;
    //this.rmanPendingApprovals.decision="REJECTED";
    //this.rmanPendingApprovals.comments = this.comments;
    this.rmanPendingApprovalsService.processContract({'arrangementId':this.rmanPendingApprovals.revenueContractNumber, 'comments':this.moreInfoComments,'taskName':'','decision':'REJECTED','arrangementTotal':this.rmanPendingApprovals.revenueContractAmount}).then((response: any) => {
      console.log(response);
     // console.log(response==true);
      if(response){
        this.pendingLoading = false;
        this.notificationService.showSuccess('Requested for More Info successfully');
        this.moreInfoComments=null;
        this.rmanPendingApprovals = new RmanPendingApprovalsImpl();
        this.getAllRmanPendingApprovals();
      }else{
        this.pendingLoading = false;
        this.notificationService.showError('Error Occured while requesting for more info');
        this.moreInfoComments=null;
        this.rmanPendingApprovals = new RmanPendingApprovalsImpl();
      }
    }).catch((err: any) => {
      this.notificationService.showError('Error Occured while requesting for more info');
      this.pendingLoading = false;
      this.displayDialog = false;
      this.moreInfoComments=null;
    });
  }

  processDelegate(){

    this.pendingLoading = true;
    this.displayDelegateDialog = false;
    this.rmanPendingApprovalsService.processDelegate(this.rmanPendingApprovals, this.delegatedUser, this.comments).then((response: any) => {
      console.log(response);
      //console.log(response==true);
      if(response){
        this.pendingLoading = false;
        this.notificationService.showSuccess('Delegated successfully');
        //this.comments=null;
        this.rmanPendingApprovals = new RmanPendingApprovalsImpl();
        this.getAllRmanPendingApprovals();
      }else{
        this.pendingLoading = false;
        this.notificationService.showError('Error Occured while delegating');
       // this.comments=null;
        this.rmanPendingApprovals = new RmanPendingApprovalsImpl();
      }
    }).catch((err: any) => {
      this.notificationService.showError('Error Occured while delegating');
      this.pendingLoading = false;
      this.displayDelegateDialog = false;
      //this.comments=null;
    });
  }


}

export class RmanPendingApprovalsImpl{
  constructor(
    processInstanceId?: any,
    revenueContractNumber?: any,
    revenueContractStatus?: any,
    revenueContractAmount?: any,
    creationDate?: any,
    createdBy?: any,
    comments? : any,
    decision? : any,
    taskName?: any,
    userName?: any,
    fullName?: any
  ){}

}
