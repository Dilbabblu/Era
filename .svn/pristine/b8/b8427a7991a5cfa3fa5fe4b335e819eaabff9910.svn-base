import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, ValidationErrors, ValidatorFn, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ConfirmationService, Message } from 'primeng/api';
import { Table } from 'primeng/table';
import { Subscription } from 'rxjs';
import { RmanCurrencyService } from '../rmanCurrency/rmanCurrencyservice';
import { RmanFmvRulesDefParaValueComponent } from '../rmanFmvRulesDefParaValue/rmanFmvRulesDefParaValue.component';
import { RmanLegalEntitiesService } from '../rmanLegalEntities/rmanLegalEntitiesservice';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { UploadService } from '../shared/upload.service';
import { RmanFmvRulesDef } from './rmanFmvRulesDef';
import { RmanFmvRulesDefLabels } from './rmanFmvRulesDefLabels';
import { RmanFmvRulesDefService } from './rmanFmvRulesDefservice';

declare var require: any;
const appSettings = require('../appsettings');


declare var $: any;

@Component({
  templateUrl: './rmanFmvRulesDef.component.html',
  selector: 'rmanFmvRulesDef-data',
  providers: [RmanFmvRulesDefService, ConfirmationService, RmanLegalEntitiesService, RmanCurrencyService]
})

export class RmanFmvRulesDefComponent implements OnInit, OnDestroy {

  displayDialog: boolean;

  displaySearchDialog: boolean;

  displaySSPRulesDialog: boolean = false;

  uploadLoading: boolean = false;

  showMsg: any;
  msgs: Message[] = [];
  rmanFmvRulesDef: any = new RmanFmvRulesDefImpl();

  rmanFmvRulesDefSearch: any = new RmanFmvRulesDefImpl();

  isSerached: number = 0;

  pFmvRuleDefId: number;

  status: any;

  selectedRmanFmvRulesDef: any = {} as RmanFmvRulesDef;

  newRmanFmvRulesDef: boolean;

  rmanFmvRulesDefList: any[];

  cols: any[];
  columns: ILabels;

  columnOptions: any[];

  paginationOptions: any;

  pages: {};

  datasource: any[];
  pageSize: number;
  totalElements: number;

  rmanCurrencyList: any[] = [];
  rmanCurrency: any[];

  rmanLookupsVList: any[] = [];
  rmanLookupsV: any[];
  rmanLookupsV1List: any[] = [];
  rmanLookupsV1: any[];
  rmanLookupsV2List: any[] = [];
  rmanLookupsV2: any[];
  collapsed: boolean = true;

  fairValuesForm: FormGroup;
  editFlag: boolean = false;
  role: any;
  
  appoveFlag: boolean;
  loading: boolean;
  noData = appSettings.noData;
  subscription1: Subscription;
  rmanLegalEntitiesList: any[] = [];
  rmanLegalEntities: any[];
  @ViewChild(RmanFmvRulesDefParaValueComponent) private myChild: RmanFmvRulesDefParaValueComponent;

  medErrorValue = '';
  medError:boolean = false;
  priceErrorValue = '';
  priceError:boolean = false;

  sspBookId:any;

  constructor(private rmanFmvRulesDefService: RmanFmvRulesDefService, private rmanLookupsVService: RmanLookupsVService, private formBuilder: FormBuilder,
    private confirmationService: ConfirmationService,
    private commonSharedService: CommonSharedService,
    private rmanLegalEntitiesService: RmanLegalEntitiesService,
    private rmanCurrencyService: RmanCurrencyService,
    private notificationService: NotificationService,
    public _uploadService:UploadService,
    private route: ActivatedRoute) {

    this.route.params.subscribe((params) => {
      this.sspBookId = params.id;
    });

    // generate list code
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    this.loading = true;
    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'FMV_CATEGORY' }).then((rmanLookupsVList: any) => {
      this.rmanLookupsVList = rmanLookupsVList.content;
      this.prepareRmanLookupsVObject();
      this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'FMV_TYPE' }).then((rmanLookupsV1List: any) => {
        this.rmanLookupsV1List = rmanLookupsV1List.content;
        this.prepareRmanLookupsV1Object();
        this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'DEAL_FMV_STATUS' }).then((rmanLookupsV2List: any) => {
          this.rmanLookupsV2List = rmanLookupsV2List.content;
          this.prepareRmanLookupsV2Object();
          this.rmanLegalEntitiesService.getAllRmanLegalEntities(this.paginationOptions, {}).then((rmanLegalEntitiesList: any) => {
            this.rmanLegalEntitiesList = rmanLegalEntitiesList.content;

            this.prepareRmanLegalEntitiesObject();
            this.loading = false;
          })
        }).catch((err: any) => {
          this.notificationService.showError('Error occured while getting "FMV Rule Status" data');
          this.loading = false;
        });
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while getting "FMV Type" data');
        this.loading = false;
      });
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting "FMV Category" data');
      this.loading = false;
    });

    this.loading = true;
    this.rmanCurrencyService.getAllRmanCurrency(this.paginationOptions, {}).then((rmanCurrencyList: any) => {
      this.rmanCurrencyList = rmanCurrencyList.content;
      this.prepareRmanCurrencyObject();
      this.loading = false;
    });

    this.subscription1 = this.commonSharedService.getRole().subscribe(res => {
      this.role = res;

    });

  }

  ngOnInit() {
    let rmanFmvRulesDefLabels = new RmanFmvRulesDefLabels();
    this.columns = rmanFmvRulesDefLabels.fieldLabels;
    this.buildForm();
  }


  prepareRmanCurrencyObject() {
    let rmanCurrencyTempObj: any = [{ label: appSettings.dropDownOptions.selectCurrencyCode, value: null }];
    this.rmanCurrencyList.forEach((rmanCurrency) => {
      rmanCurrencyTempObj.push({ label: rmanCurrency.currencyCode, value: rmanCurrency.currencyCode });
    });

    this.rmanCurrency = rmanCurrencyTempObj;

  }

  reset(dt: Table) {
    this.paginationOptions = {};
    this.rmanFmvRulesDef = new RmanFmvRulesDefImpl();
    this.rmanFmvRulesDefSearch = new RmanFmvRulesDefImpl();
    dt.reset();
  }


  buildForm() {
    this.fairValuesForm = this.formBuilder.group({
      'name': ['', [Validators.required, Validators.minLength(4),Validators.maxLength(80)]],
      'status': ['', [Validators.required]],
      'type': ['', [Validators.required]],
      'category': ['', [Validators.required]],
      'price': ['', [Validators.required,Validators.pattern('^[0-9]*$')]],
      'minimum': ['', [Validators.required,Validators.pattern('^[0-9]*$')]],
      'maximum': ['', [Validators.required,Validators.pattern('^[0-9]*$')]],
      'med': ['', [Validators.required,Validators.pattern('^[0-9]*$')]],
      'quarterStartDate': ['', [Validators.required]],
      'quarterEndDate': ['', [Validators.required]],
      'currencyAttribute': ['', [Validators.required]],
    });
    this.fairValuesForm.valueChanges
      .subscribe(data => this.onValueChanged(data));
    this.onValueChanged();
  }

  onValueChanged(data?: any) {
    if (!this.fairValuesForm) { return; }
    const form = this.fairValuesForm;

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
    'name': '', 'status': '', 'type': '', 'category': '', 'minimum': '', 'maximum': '', 'price': '', 'med': '', 'quarterStartDate': '', 'quarterEndDate': '', 'currencyAttribute': ''
  };

  validationMessages = {
    'name': {
        'required': "FMV Rule Name is required (minimum length is 4 and maximum length is 80 characters)",
        'minlength': 'Rule Name must be at least 4 characters long.',
        'maxlength': 'Rule Name cannot be more than 80 characters long.',
    },
    'status': { 'required': "Rule Status is Required" },
    'type': { 'required': "FMV Type is required" },
    'category': { 'required': "FMV Category is required" },
    'price': { 
        'required': "FMV Price is required (Only number values are allowed [0-9])",
        'pattern': 'Only number values are allowed [0-9]' },
    'minimum': { 
        'required': "Min is required (Only number values are allowed [0-9])",
        'pattern': 'Only number values are allowed [0-9]' },
    'maximum': { 
        'required': "Max is required (Only number values are allowed [0-9])",
        'pattern': 'Only number values are allowed [0-9]' },
    'med': { 
        'required': "Median is required (Only number values are allowed [0-9])",
        'pattern': 'Only number values are allowed [0-9]',
         },
    'quarterStartDate': { 'required': "Start Date is required" },
    'quarterEndDate': { 'required': "End Date is required" },
    'currencyAttribute': { 'required': "Currency Code is required" },
  }

  // #AYAR-310 Anil Mullamuri on 07-JUNE-2021 
  medianValueChange(event: any){
    var min:number = +this.fairValuesForm.controls['minimum'].value;
    var max:number = +this.fairValuesForm.controls['maximum'].value;
    var med:number = +this.fairValuesForm.controls['med'].value;
    if(med >= min && med <= max){
      this.medError = false;
    }else{
      this.medErrorValue = "Median Should fall between Min and Max values"
      this.medError = true;
    }
  }

  priceValueChange(event: any){
    var min:number = +this.fairValuesForm.controls['minimum'].value;
    var max:number = +this.fairValuesForm.controls['maximum'].value;
    var price:number = +this.fairValuesForm.controls['price'].value;
    if(price >= min && price <= max){
      this.priceError = false;
    }else{
      this.priceErrorValue = "SSP Price Should fall between Min and Max values"
      this.priceError = true;
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



  approve() {
    if (this.appoveFlag && Object.keys(this.selectedRmanFmvRulesDef) && this.selectedRmanFmvRulesDef['fmvRuleStatus'] != 'APPROVED') {
      this.confirmationService.confirm({
        message: 'Are you sure you want to approve this record?',
        header: 'Confirmation',
        icon: '',
        accept: () => {
          this.selectedRmanFmvRulesDef.fmvRuleStatus = 'APPROVED';
          this.rmanFmvRulesDef = this.selectedRmanFmvRulesDef;
          this.loading = true;
          this.__updateFmvRules(this.rmanFmvRulesDef);
          this.notificationService.showSuccess('Status changed to APPROVED');
        },
        reject: () => {
          this.notificationService.showWarning('You have rejected');
          this.rmanFmvRulesDef = new RmanFmvRulesDefImpl();
        }
      });
    }
    else if (this.selectedRmanFmvRulesDef && this.selectedRmanFmvRulesDef['fmvRuleStatus'] == 'APPROVED') {
      this.notificationService.showWarning('Selected rule has already approved');
    }
    else if (!this.appoveFlag && this.selectedRmanFmvRulesDef && (this.selectedRmanFmvRulesDef['fmvRuleStatus'] == 'REJECTED' || this.selectedRmanFmvRulesDef['fmvRuleStatus'] == 'NEW')) {
      this.notificationService.showWarning('Please add atleast one parameter to Approve');
    } else {
      this.notificationService.showWarning('Please select atleast one rule to Approve');
    }


  }

  approveAll() {
    
      this.confirmationService.confirm({
        message: 'Are you sure you want to approve all records?',
        header: 'Confirmation',
        icon: '',
        accept: () => {
          this.loading = true;
          this.rmanFmvRulesDefService.approveAllRmanRulesDef(this.sspBookId).then((response: any)=>{
          this.loading = false;
          console.log(response);
          if(response){
            this.notificationService.showSuccess('Approved All Rules Successfully');
          }else{
            this.notificationService.showWarning('Approving All Rules Failed');
          }
          this.rmanFmvRulesDef = new RmanFmvRulesDefImpl();
          this.getAllRmanFmvRulesDef();
          });
        },
        reject: () => {
          this.notificationService.showWarning('You have rejected');
          this.rmanFmvRulesDef = new RmanFmvRulesDefImpl();
        }
      });
  }

  reject() {
    if (this.selectedRmanFmvRulesDef && Object.keys(this.selectedRmanFmvRulesDef).length && this.selectedRmanFmvRulesDef['fmvRuleStatus'] != "REJECTED") {
      this.confirmationService.confirm({
        message: 'Are you sure you want to reject this record?',
        header: 'Confirmation',
        icon: '',
        accept: () => {
          this.editFlag = false;
          this.selectedRmanFmvRulesDef.fmvRuleStatus = 'REJECTED';
          this.rmanFmvRulesDef = this.selectedRmanFmvRulesDef;
          this.loading = true;
          this.__updateFmvRules(this.rmanFmvRulesDef);
          this.notificationService.showSuccess('Status changed to REJECTED');
        },
        reject: () => {
          this.notificationService.showWarning('You have rejected');
          this.rmanFmvRulesDef = new RmanFmvRulesDefImpl();
        }
      });
    }
    else if (this.selectedRmanFmvRulesDef && this.selectedRmanFmvRulesDef['fmvRuleStatus'] == "REJECTED") {
      this.notificationService.showWarning('Selected rule has already Rejected');
    }
    else {
      this.notificationService.showWarning('Please select atleast one rule to Reject');
    }
  }

  __updateFmvRules(fmvRules:any){
    this.rmanFmvRulesDefService.updateRmanFmvRulesDef(fmvRules).then((response: any) => {
      this.loading = false;
      this.rmanFmvRulesDef = new RmanFmvRulesDefImpl();
      this.getAllRmanFmvRulesDef();
    });
  }

  getNotifyParameterExist(event: any) {

    this.appoveFlag = event;
  }

  getAllRmanFmvRulesDef() {
    this.loading = true;
    this.rmanFmvRulesDef = this.rmanFmvRulesDefSearch;
    this.rmanFmvRulesDef.bookId = this.sspBookId;
    this.rmanFmvRulesDefService.getAllRmanFmvRulesDefDetails(this.paginationOptions, this.rmanFmvRulesDef).then((rmanFmvRulesDefList: any) => {
      this.loading = false;
      this.datasource = rmanFmvRulesDefList.content;
      this.rmanFmvRulesDefList = rmanFmvRulesDefList.content;
      if (this.rmanFmvRulesDefList && this.rmanFmvRulesDefList.length > 0) {
        this.selectedRmanFmvRulesDef = this.rmanFmvRulesDefList[0];
        this.pFmvRuleDefId = this.selectedRmanFmvRulesDef.fmvRuleDefId;
        this.status = this.selectedRmanFmvRulesDef.fmvRuleStatus;
        this.myChild.ParentCall(this.selectedRmanFmvRulesDef);
      } else {
        this.selectedRmanFmvRulesDef = {};
        this.myChild.ParentCall('');
      }


      this.totalElements = rmanFmvRulesDefList.totalElements;
      this.pageSize = rmanFmvRulesDefList.size;
      this.displaySearchDialog = false;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }


  getRmanFmvRulesDef(event: any) {

    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loading = true;
    this.rmanFmvRulesDef = this.rmanFmvRulesDefSearch;
    this.rmanFmvRulesDef.bookId = this.sspBookId;
    this.rmanFmvRulesDefService.getAllRmanFmvRulesDefDetails(this.paginationOptions, this.rmanFmvRulesDef).then((rmanFmvRulesDefList: any) => {
      this.loading = false;
      this.datasource = rmanFmvRulesDefList.content;
      this.rmanFmvRulesDefList = rmanFmvRulesDefList.content;
      if (this.rmanFmvRulesDefList.length > 0) {
        /*Begining of Code used for default First Row Selected*/
        this.selectedRmanFmvRulesDef = this.rmanFmvRulesDefList[0];
        this.pFmvRuleDefId = this.selectedRmanFmvRulesDef.fmvRuleDefId;
        this.status = this.selectedRmanFmvRulesDef.fmvRuleStatus;
        this.myChild.ParentCall(this.selectedRmanFmvRulesDef);
        /*End of Code used for default First Row Selected*/
      } else {
        this.selectedRmanFmvRulesDef = {};
        this.myChild.ParentCall('')
      }
      this.totalElements = rmanFmvRulesDefList.totalElements;
      this.pageSize = rmanFmvRulesDefList.size;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      $.unblockUI();
      this.loading = false;
    });

  }



  showDialogToAdd() {
    this.editFlag = false;
    this.newRmanFmvRulesDef = true;
    this.rmanFmvRulesDef = new RmanFmvRulesDefImpl();
    this.displayDialog = true;
    this.rmanFmvRulesDef.dealFlag = 'Y';
    this.rmanFmvRulesDef.fmvRuleStatus = 'NEW';
    this.prepareRmanLookupsVObject();
    this.prepareRmanLookupsV1Object();
    this.buildForm();
  }

saveOrUpdate(msg: any){
  this.notificationService.showSuccess(msg);
  $.unblockUI();
  this.getAllRmanFmvRulesDef();
}

  save() {
    delete this.rmanFmvRulesDef['legalEntityName']
    if (this.newRmanFmvRulesDef) {
      this.rmanFmvRulesDef.bookId = this.sspBookId;
      $.blockUI();
      this.rmanFmvRulesDefService.saveRmanFmvRulesDef(this.rmanFmvRulesDef).then((response: any) => {
        this.saveOrUpdate('Saved successfully');
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while saving data');
        $.unblockUI();
      });
    }
    else {
      $.blockUI();
      this.rmanFmvRulesDefService.updateRmanFmvRulesDef(this.rmanFmvRulesDef).then((response: any) => {
        this.saveOrUpdate('Updated successfully');
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while updating data');
        $.unblockUI();
      });
    }
    this.rmanFmvRulesDef = new RmanFmvRulesDefImpl();
    this.displayDialog = false;
    this.editFlag = false;
  }

  cancel() {
    this.displayDialog = false;
    this.editFlag = false;
    this.rmanFmvRulesDef = new RmanFmvRulesDefImpl();

  }

  cancelSearch() {
    this.displaySearchDialog = false;
    this.rmanFmvRulesDefSearch = new RmanFmvRulesDefImpl();
  }
  exportExcel() {
    let serviceUrl = this.rmanFmvRulesDefService.getAllRmanFmvRulesDef(this.paginationOptions, this.rmanFmvRulesDef, 1);
    window.location.href = serviceUrl;
  }


  delete(rmanFmvRulesDef: any) {
    this.rmanFmvRulesDef = rmanFmvRulesDef;
    this.displayDialog = false;
    this.confirmationService.confirm({
      message: 'Are you sure you want to delete this record?',
      header: 'Confirmation',
      icon: '',
      accept: () => {
        this.rmanFmvRulesDefList.splice(this.findSelectedRmanFmvRulesDefIndex(), 1);
        $.blockUI();
        this.rmanFmvRulesDefService.deleteRmanFmvRulesDef(this.rmanFmvRulesDef).then((response: any) => {
          $.unblockUI();
          this.rmanFmvRulesDef = new RmanFmvRulesDefImpl();
          this.getAllRmanFmvRulesDef();
        });
        this.notificationService.showSuccess('Deleted successfully');
      },
      reject: () => {
        this.notificationService.showWarning('You have rejected');
      }
    })

  }

  editRow(rmanFmvRulesDef: any) {
    this.newRmanFmvRulesDef = false;
    this.rmanFmvRulesDef = this.cloneRmanFmvRulesDef(rmanFmvRulesDef);
    this.displayDialog = true;
    if (this.rmanFmvRulesDef.fmvRuleStatus == 'APPROVED') {
      this.editFlag = true;
    } else {
      this.editFlag = false;
    }

    if (this.rmanFmvRulesDef.quarterStartDate) {
      this.rmanFmvRulesDef.quarterStartDate = new Date(this.rmanFmvRulesDef.quarterStartDate);
    }
    if (this.rmanFmvRulesDef.quarterEndDate) {
      this.rmanFmvRulesDef.quarterEndDate = new Date(this.rmanFmvRulesDef.quarterEndDate);
    }
    this.prepareRmanLookupsVObject();
    this.prepareRmanLookupsV1Object();
  }

  fileUploadHandler(event: any, url:any){
    this._uploadService.processUpload(event,url);
}

  importFile() {
    this._uploadService.uploadDialog = true;
    this.displaySSPRulesDialog = true;
  }

  showUploadLoader() {
    this.uploadLoading = true;
  }

  onSSPRulesUpload(event: any) {
    
    this.notificationService.showSuccess('File Uploaded successfully');
    this.displaySSPRulesDialog = false;
    this.uploadLoading = false;
  }

  onErrorSSPFileupload(event: any) {
    
    this.displaySSPRulesDialog = false;
    this.uploadLoading = false;
    let msg: string = "";
    msg += event.files[0].name + " file upload process failed due to ";
    if (event.xhr.response) {
      msg += JSON.parse(event.xhr.response).message
    }
    this.notificationService.showError(msg);
  }

  Uploadcancel() {
    this._uploadService.uploadDialog = false;
    this.displaySSPRulesDialog = false;
  }

  findSelectedRmanFmvRulesDefIndex(): number {
    return this.rmanFmvRulesDefList.indexOf(this.selectedRmanFmvRulesDef);
  }

  onRowUnSelect() {
    this.myChild.ParentCall('');
  }
  onRowSelect(event: any) {
    this.selectedRmanFmvRulesDef = event.data;
    this.pFmvRuleDefId = this.selectedRmanFmvRulesDef.fmvRuleDefId;
    this.status = this.selectedRmanFmvRulesDef.fmvRuleStatus;
    this.myChild.ParentCall(event.data);
  }


  cloneRmanFmvRulesDef(c: RmanFmvRulesDef): RmanFmvRulesDef {
    let rmanFmvRulesDef: any
      = new RmanFmvRulesDefImpl();
    for (let prop in c) {
      rmanFmvRulesDef[prop] = c[prop];
    }
    return rmanFmvRulesDef;
  }
  showDialogToSearch() {
    this.rmanFmvRulesDefSearch = new RmanFmvRulesDefImpl();
    this.displaySearchDialog = true;
  }

  search() {
    this.isSerached = 1;
    this.rmanFmvRulesDef = this.rmanFmvRulesDefSearch;
    this.displaySearchDialog = false;
    this.paginationOptions = {};
    this.getAllRmanFmvRulesDef();
  }

  prepareRmanLookupsVObject() {
    let rmanLookupsVTempObj: any = [{ label: appSettings.dropDownOptions.selectFMVCategory, value: null }];
    this.rmanLookupsVList.forEach((rmanLookupsV) => {
      rmanLookupsVTempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
    });
    this.rmanLookupsV = rmanLookupsVTempObj;
  }

  prepareRmanLookupsV1Object() {
    let rmanLookupsV1TempObj: any = [{ label: appSettings.dropDownOptions.selectFMVType, value: null }];
    this.rmanLookupsV1List.forEach((rmanLookupsV1) => {
      rmanLookupsV1TempObj.push({ label: rmanLookupsV1.lookupDescription, value: rmanLookupsV1.lookupCode });
    });

    this.rmanLookupsV1 = rmanLookupsV1TempObj;

  }

  prepareRmanLookupsV2Object() {
    let rmanLookupsV2TempObj: any = [{ label: appSettings.dropDownOptions.selectFMVRuleStatus, value: null }];
    this.rmanLookupsV2List.forEach((rmanLookupsV2) => {
      rmanLookupsV2TempObj.push({ label: rmanLookupsV2.lookupDescription, value: rmanLookupsV2.lookupCode });
    });

    this.rmanLookupsV2 = rmanLookupsV2TempObj;

  }

  prepareRmanLegalEntitiesObject() {
    let rmanLegalEntitiesTempObj: any = [{ label: appSettings.dropDownOptions.selectLegalEntity, value: null }];
    this.rmanLegalEntitiesList.forEach((rmanLegalEntities) => {
      rmanLegalEntitiesTempObj.push({ label: rmanLegalEntities.name, value: rmanLegalEntities.legalEntityId });
    });
    this.rmanLegalEntities = rmanLegalEntitiesTempObj;
  }

  onBeforeToggle(evt: any) {
    this.collapsed = evt.collapsed;
  }

  onHide(event: any) {
    this.editFlag = false;
  }

  ngOnDestroy() {
    this.subscription1.unsubscribe();
  }



}


export class RmanFmvRulesDefImpl {
  constructor(public quarterStartDate?: any, public dealFlag?: any, public attribute30?: any, public lastUpdateDate?: any, public approverId?: any, public attribute29?: any, public attribute28?: any, public attribute27?: any, public attribute26?: any, public attribute3?: any, public createdBy?: any, public attribute2?: any, public lastUpdatedBy?: any, public attribute1?: any, public creationDate?: any, public attribute9?: any, public fmvPrice?: any, public attribute8?: any, public attribute7?: any, public attribute6?: any, public quarterName?: any, public attribute5?: any, public attribute4?: any, public fmvPct?: any, public min?: any, public fmvRuleDefId?: any, public attribute10?: any, public attribute14?: any, public max?: any, public attribute13?: any, public attribute12?: any, public attribute11?: any, public fmvCategory?: any, public quarterEndDate?: any, public median?: any, public fmvRuleStatus?: any, public fmvRuleName?: any, public attribute21?: any, public attribute20?: any, public attribute25?: any, public attribute24?: any, public attribute23?: any, public attribute22?: any, public enabledFlag?: any, public attribute18?: any, public attribute17?: any, public attribute16?: any, public attribute15?: any, public vsoe?: any, public fmvType?: any, public attribute19?: any, public legalEntityId?: any, public legalEntityName?: any, public bookId?: any) { }
}

interface ILabels {
  [index: string]: string;
}
