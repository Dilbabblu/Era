import { AbsoluteSourceSpan } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ConfirmationService } from 'primeng/api';
import { Table } from 'primeng/table';
import { NotificationService } from '../shared/notifications.service';
import { ReleaseLogs } from './systemInfo';
import { SystemInfoService } from './systemInfo.service';
declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
  selector: 'system-info',
  templateUrl: './systemInfo.component.html',
  providers:[SystemInfoService,ConfirmationService]
})
export class SystemInfoComponent implements OnInit {

  displayAddDialog:boolean;

  releaseLogsForm:FormGroup;
  noData = appSettings.noData;
  datasource: any[];
  paginationOptions: any;
  pageSize: number;
  totalElements: number;
  loading: boolean;

  releaseLogs = new ReleaseLogsImpl();
  releaseLogsSearch = new ReleaseLogsImpl();
  releaseLogs2:any[];

  releaseLogList:any[];
  releaseLogList2:any[];
  releaseLogList3:any[];

  displaySearchDialog:boolean;

  isCreate:boolean = true;

  showSingleReleaseLog:boolean;
  showAllReleaseLogs:boolean;


  constructor(private systemInfoService:SystemInfoService, private notificationService:NotificationService,
    private formBuilder: FormBuilder, private confirmationService: ConfirmationService) { 
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
  }

  ngOnInit() {
    this.buildForm();
  }

  buildForm() {
    this.releaseLogsForm = this.formBuilder.group({
      'firmwareVersion': ['', [Validators.required, Validators.pattern(/^[0-9]+(.[0-9]{0,2})?$/)]],
      'releaseDate': ['', [Validators.required]],
      'releaseNotes': ['', [Validators.required]],
    });
    this.releaseLogsForm.valueChanges
      .subscribe(data => this.onValueChanged(data));
    this.onValueChanged();
  }
  
  onValueChanged(data?: any) {
    if (!this.releaseLogsForm) { return; }
    const form = this.releaseLogsForm;
  
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
    'firmwareVersion': '','releaseDate':'','releaseNotes': ''
  };
  
  validationMessages = {
    'firmwareVersion':{ 
      'required': "Firmware Version is required" ,
      'pattern':"Only Number Values are allowed [0-9]"
    },
    'releaseDate': { 'required': "Release date is required" },
    'releaseNotes':{ 'required': "Release Notes required" },
  }

  getReleaseLogs() {
    this.loading = true;
    this.systemInfoService.getAllReleaseLogs(this.paginationOptions, this.releaseLogs).then((releaseLogList: any) => {
      this.loading = false;
      this.datasource = releaseLogList.content;
      this.releaseLogs2 = JSON.parse(JSON.stringify(releaseLogList.content));
      this.releaseLogList = Array.of(releaseLogList.content[0]);
      this.releaseLogList2 = releaseLogList.content;
      this.releaseLogList2.splice(0,1);
      this.totalElements = releaseLogList.totalElements;
      this.pageSize = releaseLogList.size;
      this.displaySearchDialog = false;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }

  getAllReleaseLogs(event:any){
    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize };
    this.loading = true;
    this.systemInfoService.getAllReleaseLogs(this.paginationOptions, this.releaseLogs).then((releaseLogList: any) => {
      this.loading = false;
      this.datasource = releaseLogList.content;
      this.releaseLogs2 = JSON.parse(JSON.stringify(releaseLogList.content));
      if(releaseLogList.content.length === 0){
        this.releaseLogList = releaseLogList.content;
      }else{
        this.releaseLogList = Array.of(releaseLogList.content[0]);
      }
      this.releaseLogList2 = releaseLogList.content;
      this.releaseLogList2.splice(0,1);
      this.totalElements = releaseLogList.totalElements;
      this.pageSize = releaseLogList.size;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }

  showLogs(){
    this.showAllReleaseLogs = true;
    this.showSingleReleaseLog = false;
  }

  hideLogs(){
    this.showAllReleaseLogs = false;
    this.showSingleReleaseLog = false;
  }

  goToAllLogs(){
    this.showAllReleaseLogs = true;
    this.showSingleReleaseLog = false;
  }

  goToRelease(firmwareVersion){
    console.log(firmwareVersion);
    console.log(this.releaseLogs2);
    this.releaseLogList3 = this.releaseLogs2.filter(item => item.firmwareVersion === firmwareVersion);
    console.log(this.releaseLogList3);
    this.showSingleReleaseLog = true;
  }

  showDialogToAdd(){
    this.releaseLogs = new ReleaseLogsImpl();
    this.displayAddDialog = true;
    this.isCreate = true;
  }

  reset(dt:Table){
    this.loading = true;
    this.paginationOptions = {};
    this.releaseLogs = new ReleaseLogsImpl();
    dt.reset();
  }

  editRow(releaseLog:any){
    this.isCreate = false;
    this.releaseLogs = this.cloneReleaseLogs(releaseLog);
    if (this.releaseLogs.releaseDate) {
      this.releaseLogs.releaseDate = new Date(this.releaseLogs.releaseDate);
    }
    this.displayAddDialog = true;

  }

  cloneReleaseLogs(c: ReleaseLogs): ReleaseLogs {
    let releaseLog: any
      = new ReleaseLogsImpl();
    for (let prop in c) {
      releaseLog[prop] = c[prop];
    }
    return releaseLog;
  }

  cloneReleaseLogs2(c: any[]) {
    c.forEach(item => {
      this.releaseLogs2.push(item);
    });
  }

  delete(releaseLog:any){
    this.confirmationService.confirm({
      message: 'Are you sure you want to delete this record?',
      header: 'Confirmation',
      icon: '',
      accept: () => {
        this.loading = true;
        this.systemInfoService.deleteReleaseLog(releaseLog).then((response: any) => {
          this.releaseLogs = new ReleaseLogsImpl();
          this.getReleaseLogs();
        });
        this.notificationService.showSuccess('Deleted successfully');
      },
      reject: () => {
        this.notificationService.showWarning('You have rejected');
      }
    });
  }

  cancel(){
    this.displayAddDialog = false;
    this.isCreate = true;
  }

  onHide(ev:any){
    
  }

  saveOrUpdate(msg: any){
    this.notificationService.showSuccess(msg);
        this.displayAddDialog = false;
        this.releaseLogs = new ReleaseLogsImpl();
        this.getReleaseLogs();
  }

  save(){
    this.displayAddDialog = false;
    if(this.isCreate){
      this.loading = true;
      this.systemInfoService.saveReleaseLog(this.releaseLogs).then((response: any) => {
        this.saveOrUpdate('Saved successfully');
      }).catch((err: any) => {
        this.notificationService.showError(err.error.message);
        this.loading = false;
      });
    }else{
      this.loading = true;
      this.systemInfoService.updateReleaseLog(this.releaseLogs).then((response: any) => {
        this.saveOrUpdate('Updated successfully');
      }).catch((err: any) => {
        this.notificationService.showError(err.error.message);
        this.loading = false;
      });
    }
  }

}

export class ReleaseLogsImpl{
  constructor(public createdBy?:any,
    public lastUpdatedBy?:any,
    public releaseDate?:any,
    public firmwareVersion?:any,
    public creationDate?:any,
    public lastUpdateDate?:any,
    public releaseNotes?:any,
    public releaseNotesList?:any[]){}
}
