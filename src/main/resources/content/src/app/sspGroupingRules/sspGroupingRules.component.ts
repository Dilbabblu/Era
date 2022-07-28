import { Component, OnInit, ViewChild } from '@angular/core';
import { SspGroupingRuleDimensionsComponent } from '../sspGroupingRuleDimensions/sspGroupingRuleDimensions.component';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ConfirmationService } from 'primeng/api';
import { NotificationService } from '../shared/notifications.service';
import { SspGroupingRules } from './sspGroupingRules';
import { SspGroupingRulesService } from './sspGroupingRules.service';
declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');


@Component({
  selector: 'ssp-grouping-rules',
  templateUrl: './sspGroupingRules.component.html',
  providers: [ConfirmationService, SspGroupingRulesService]
})
export class SspGroupingRulesComponent implements OnInit {

  //sspGroupingRules:any[] = [];
  
  datasource: any[];
  paginationOptions: any;
  pageSize: number;
  totalElements: number;
  loading: boolean;
  displaySearchDialog: boolean;
  //sspGroupingRulesList:any[] =[];
  enabledFlagValues:any[] =[];
  displayDialog: boolean;
  isCreate: boolean;

  sspGroupingRules:any = new SspGroupingRulesImpl();
  sspGroupingRulesSearch:any = new SspGroupingRulesImpl();
  sspGroupingRulesList: any[];
  sspGroupId:any;
  sspGroupingRuleForm:FormGroup;
  noData = appSettings.noData;

  selectedGroupingRule: any = {} as SspGroupingRules;
  groupId: number;

  @ViewChild(SspGroupingRuleDimensionsComponent) private myChild: SspGroupingRuleDimensionsComponent;


  constructor(private confirmationService: ConfirmationService, private notificationService: NotificationService,
    private sspGroupingRulesService:SspGroupingRulesService,private formBuilder: FormBuilder) {
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
   }

  ngOnInit() {

    this.buildForm();
    this.enabledFlagValues.push({ label: 'Select Enabled Flag', value: null });
    this.enabledFlagValues.push({label: 'Y', value: 'Y'});
    this.enabledFlagValues.push({label:'N', value:'N'});

  }

  onHide(ev:any){
    
  }

  buildForm() {
    this.sspGroupingRuleForm = this.formBuilder.group({
      'sspRuleName': ['', [Validators.required]],
      'sspFlag': ['', [Validators.required]],
      'sspStartDate': ['', [Validators.required]],
      'sspEndDate': ['', [Validators.required]],
    });
    this.sspGroupingRuleForm.valueChanges
      .subscribe(data => this.onValueChanged(data));
    this.onValueChanged();
  }

  onValueChanged(data?: any) {
    if (!this.sspGroupingRuleForm) { return; }
    const form = this.sspGroupingRuleForm;
  
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
    'sspRuleName': '','sspFlag':'','sspStartDate': '', 'sspEndDate': ''
  };
  
  validationMessages = {
    'sspRuleName':{ 'required': "SSP Rule name is required" },
    'sspFlag': { 'required': "Enabled Flag is required" },
    'sspStartDate':{ 'required': "Start Date is required" },
    'sspEndDate':{'required': "End Date is required" }
  }

  onStatusChange(sspGroupingRule:any){
    console.log(sspGroupingRule.status);
  }


  getAllSspGroupingRules(event:any){
    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loading = true;
    this.sspGroupingRulesService.getAllSspGroupingRules(this.paginationOptions, this.sspGroupingRules, false).then((data: any) => {
    this.loading = false;
    this.datasource = data.content;
    this.sspGroupingRulesList = data.content;
    this.totalElements = data.totalElements;
    this.pageSize = data.size;

    if (this.sspGroupingRulesList && this.sspGroupingRulesList.length > 0) {
      this.selectedGroupingRule = this.sspGroupingRulesList[0];
      this.groupId = this.selectedGroupingRule.groupId;
      this.myChild.ParentCall(this.selectedGroupingRule);
    } else {
      this.selectedGroupingRule = {};
      this.myChild.ParentCall('');
    }
    
  }).catch((err: any) => {
    this.notificationService.showError('Error occured while getting data');
    this.loading = false;
  });
}

  onRowSelect(ev:any){
    this.selectedGroupingRule = ev.data;
    this.groupId = this.selectedGroupingRule.groupId;
    this.myChild.ParentCall(ev.data);
  }

  onRowUnSelect(){
    this.myChild.ParentCall('');
  }

  showDialogToSearch() {
    this.displaySearchDialog = true;
  }

  showDialogToAdd(){
    this.displayDialog = true;
    this.isCreate = true;
    this.sspGroupingRules = new SspGroupingRulesImpl();
  }

  reset(dt:any){
    this.loading = true;
    this.paginationOptions = {};
    this.sspGroupingRules = new SspGroupingRulesImpl();
    dt.reset();
  }

  cancelSearch(){
    this.displaySearchDialog = false;
  }

  search(){
    this.displaySearchDialog = false;
    this.loading = true;
    this.sspGroupingRules = this.sspGroupingRulesSearch;
    this.getSspGroupingRules();
  }

  cancel(){
    this.displayDialog = false;
  }

  getSspGroupingRules() {
    this.loading = true;
    this.sspGroupingRulesService.getAllSspGroupingRules(this.paginationOptions, this.sspGroupingRules, false).then((data: any) => {
      this.loading = false;
      this.datasource = data.content;
      this.sspGroupingRulesList = data.content;
      this.totalElements = data.totalElements;
      this.pageSize = data.size;
      this.displaySearchDialog = false;
      
      if (this.sspGroupingRulesList && this.sspGroupingRulesList.length > 0) {
        this.selectedGroupingRule = this.sspGroupingRulesList[0];
        this.groupId = this.selectedGroupingRule.groupId;
        this.myChild.ParentCall(this.selectedGroupingRule);
      } else {
        this.selectedGroupingRule = {};
        this.myChild.ParentCall('');
      }
      
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }

  editRow(sspGroupingRule: any) {
    this.isCreate = false;
    this.sspGroupingRules = this.cloneGroupingRules(sspGroupingRule);
    if (this.sspGroupingRules.startDate) {
      this.sspGroupingRules.startDate = new Date(this.sspGroupingRules.startDate);
    }
    if (this.sspGroupingRules.endDate) {
      this.sspGroupingRules.endDate = new Date(this.sspGroupingRules.endDate);
    }
    this.displayDialog = true;
  }

  cloneGroupingRules(c: SspGroupingRules): SspGroupingRules {
    let sspGroupingRule: any = new SspGroupingRulesImpl();
    for (let prop in c) {
      sspGroupingRule[prop] = c[prop];
    }
    return sspGroupingRule;
  }

  saveOrUpdate(msg: any){
    this.notificationService.showSuccess(msg);
    this.displayDialog = false;
    this.sspGroupingRules = new SspGroupingRulesImpl();
    this.getSspGroupingRules();
  }
  
  save(){
    this.loading = true;
    this.displayDialog = false;
    if(this.isCreate){
      this.sspGroupingRulesService.saveSspGroupingRule(this.sspGroupingRules).then((response: any) => {
        this.saveOrUpdate('Saved successfully');
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while saving data');
        this.loading = false;
      });
    }else{
      this.sspGroupingRulesService.updateSspGroupingRule(this.sspGroupingRules).then((response: any) => {
        this.saveOrUpdate('Updated successfully');
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while updating data');
        this.loading = false;
      });
    }
  }

  delete(sspGroupingRule: any) {
    this.displayDialog = false;
    this.confirmationService.confirm({
      message: 'Are you sure you want to delete this record?',
      header: 'Confirmation',
      icon: '',
      accept: () => {
        this.loading = true;
        this.sspGroupingRulesService.deleteSspGroupingRule(sspGroupingRule).then((response: any) => {
          this.sspGroupingRules = new SspGroupingRulesImpl();
          this.getSspGroupingRules();
        });
        this.notificationService.showSuccess('Deleted successfully');
      },
      reject: () => {
        this.notificationService.showWarning('You have rejected');
      }
    });

  }

}

export class SspGroupingRulesImpl{
  constructor(public bookId?:any,
    public groupId?:any,
    public ruleName?:any,
    public startDate?:any,
    public endDate?:any,
    public enabledFlag?:any,
    public attribute1?:any,
    public attribute2?:any,
    public attribute3?:any,
    public attribute4?:any,
    public attribute5?:any,
    public attribute6?:any,
    public attribute7?:any,
    public attribute8?:any,
    public attribute9?:any,
    public attribute10?:any){

  }
}
