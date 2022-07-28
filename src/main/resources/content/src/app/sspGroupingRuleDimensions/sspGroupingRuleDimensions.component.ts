import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { SspGroupingRuleDimensionsService } from './sspGroupingRuleDimensions.service';
import { ConfirmationService, Message } from 'primeng/api';
import { NotificationService } from '../shared/notifications.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { RmanEntityParametersVService } from '../rmanEntityParametersV/rmanEntityParametersVservice';
import { SspGroupingRuleDimensions } from './sspGroupingRuleDimensions';

declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');
@Component({
  selector: 'sspGroupingRuleDimensions-data',
  templateUrl: './sspGroupingRuleDimensions.component.html',
  providers:[SspGroupingRuleDimensionsService, ConfirmationService, RmanEntityParametersVService]
})
export class SspGroupingRuleDimensionsComponent implements OnInit {

  masterData: any;
  @Output() notifyPameterExist = new EventEmitter();

  sspGroupingRuleDimensions:any[] = [];
  
  datasource: any[];
  paginationOptions: any;
  pageSize: number;
  totalElements: number;

  loading: boolean;
  groupId: number;
  AndOrLookup:any[] =[];
  DimensionForm:FormGroup;
  displayDialog: boolean;
  isCreate: boolean;

  rmanLookupsV1List: any[] = [];
  rmanEntityParametersVList: any[] = [];
  identifiersLookup: any[];
  dimensionNamesLookup: any[];
  value: any;
  displayTo: boolean = false;
  dimensionNames: any[] =[];
  noData = appSettings.noData;

  sspGroupingRuleDimensionsList:any[] =[];
  sspDimensions:any = new SspGroupingRuleDimensionsImpl();
  selectedSspGroupingRuleDimensions: SspGroupingRuleDimensions;

  constructor(private sspGroupingRuleDimensionsService: SspGroupingRuleDimensionsService, private confirmationService: ConfirmationService,
    private notificationService: NotificationService, private formBuilder: FormBuilder,
    private rmanLookupsVService: RmanLookupsVService, private rmanEntityParametersVService: RmanEntityParametersVService) { 
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
  }

  ngOnInit() {
    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'RULE_QUALIFIER' }).then((data: any) => {
      this.rmanLookupsV1List = data.content;
      this.prepareRmanLookupsV1Object();

      this.rmanEntityParametersVService.getAllRmanEntityParametersV(this.paginationOptions, { 'entityName': 'Deal FMV Eligibility' }, 'Y').then((data: any) => {
        this.loading = false;
        this.rmanEntityParametersVList = data.content;
        this.prepareRmanEntityParametersVObject();
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while getting "Dimension Name" data');
        this.loading = false;
      });
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting "Identifier" data');
      this.loading = false;
    });

    this.value='Value'
    

    this.buildForm();
    this.AndOrLookup.push({ label: 'Select And/Or', value: null });
    this.AndOrLookup.push({label: 'And', value: 'And'});
    this.AndOrLookup.push({label:'Or', value:'Or'});
  }

  prepareRmanLookupsV1Object() {
    let rmanLookupsV1TempObj: any = [{ label: 'Select Identifier', value: null }];
    this.rmanLookupsV1List.forEach((rmanLookupsV1) => {
      rmanLookupsV1TempObj.push({ label: rmanLookupsV1.lookupDescription, value: rmanLookupsV1.lookupCode });
    });

    this.identifiersLookup = rmanLookupsV1TempObj;

  }
  prepareRmanEntityParametersVObject() {
    let rmanEntityParametersVTempObj: any = [{ label: 'Select Dimension', value: null }];
    this.rmanEntityParametersVList.forEach((rmanEntityParametersV) => {
      rmanEntityParametersVTempObj.push({ label: rmanEntityParametersV.parameterDescription, value: rmanEntityParametersV.parameterName });
    });
    this.dimensionNamesLookup = rmanEntityParametersVTempObj;
  }

  transformRmanLookupsV(rmanLookupsV: any) {
    if (rmanLookupsV)
      return rmanLookupsV.lookupDescription;
  }

  transformRmanEntityParametersV(dimensionName: any) {
    for (var i=0; i<this.rmanEntityParametersVList.length; i++) {
      if(this.rmanEntityParametersVList[i].parameterName==dimensionName){
        console.log(this.rmanEntityParametersVList[i].parameterDescription);
        return this.rmanEntityParametersVList[i].parameterDescription;
      }
    }

  }

  buildForm() {
    this.DimensionForm = this.formBuilder.group({
      'dimensionNumber': ['', [Validators.required]],
      'dimension': ['', [Validators.required]],
      'identifier': ['', [Validators.required]],
      'andOr': ['', [Validators.required]],
      'from': ['', [Validators.required]],
      'to': ['', [Validators.required,Validators.pattern(/^-?[0-9]+(.[0-9]{0,2})?$/)]],
    });
    this.DimensionForm.valueChanges
      .subscribe(data => this.onValueChanged(data));
    this.onValueChanged();
  }

  onValueChanged(data?: any) {
    if (!this.DimensionForm) { return; }
    const form = this.DimensionForm;
  
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
    'dimensionNumber': '','dimension':'','identifier': '', 'andOr': '', 'from': '', 'to': ''
  };
  
  validationMessages = {
    'dimensionNumber':{ 'required': "Dimension Number is required" },
    'dimension': { 'required': "Dimension Name is required" },
    'identifier':{ 'required': "Identifier is required" },
    'andOr':{'required': "And/Or is required" },
    'from':{'required': "From Value is required" },
    'to': { 
      'required': "To Value is required (Only number values are allowed [0-9])",
      'pattern': 'Only number values are allowed [0-9]' }

  }

  onSelectingIdentifier(value: any){
    if(value=='BETWEEN'){
      this.value = 'From';
      this.displayTo = true;
      this.DimensionForm.get('to').setValidators([Validators.required,Validators.pattern(/^-?[0-9]+(.[0-9]{0,2})?$/)]);
      this.DimensionForm.get('to').enable();
      this.DimensionForm.updateValueAndValidity();     
    }else{
      this.value = 'Value';
      this.displayTo = false;
      this.sspDimensions.attribute4 = null;
      this.DimensionForm.get('to').clearValidators();
      this.DimensionForm.get('to').disable();
      this.DimensionForm.updateValueAndValidity(); 
    }
  }

  onSelectingDimension(value: any){
    //console.log(value);
    if(value=='PRODUCT_NAME'|| value=='REGION'){
      this.DimensionForm.get('from').clearValidators();
      //this.DimensionForm.get('from').disable();
      this.sspDimensions.attribute2 = null;
    }else{
      this.DimensionForm.get('from').setValidators([Validators.required]);
     //this.DimensionForm.get('from').enable();
    }
    this.DimensionForm.updateValueAndValidity();
  }

  reset(dt:any){
    this.loading = true;
    this.paginationOptions = {};
    this.sspDimensions = new SspGroupingRuleDimensionsImpl();
    dt.reset();
  }

  showDialogToAdd(){
    this.displayDialog = true;
    this.isCreate = true;
    this.sspDimensions = new SspGroupingRuleDimensionsImpl();
  }


  ParentCall(data) {
    this.masterData = data;
    if (data && data != '') {
      this.groupId = data.groupId;
      console.log(this.groupId);
      this.getAllSspGroupingRuleDimensions();
    } else {
      this.groupId = null;
      this.sspGroupingRuleDimensions = [];
      this.notifyPameterExist.emit(false);
    }
  }

  editRow(sspGroupingRuleDimension: any) {
    this.isCreate = false;
    this.sspDimensions = this.cloneDimensions(sspGroupingRuleDimension);
    this.displayDialog = true;
    this.prepareRmanLookupsV1Object();
    this.sspDimensions.dimensionName = sspGroupingRuleDimension.dimensionName;
    if(sspGroupingRuleDimension.attribute3=='BETWEEN'){
      this.value = 'From';
      this.displayTo = true;
      this.DimensionForm.get('to').setValidators([Validators.required,Validators.pattern(/^-?[0-9]+(.[0-9]{0,2})?$/)]);
      this.DimensionForm.get('to').enable();
      this.DimensionForm.updateValueAndValidity(); 
    }else{
      this.value = 'Value';
      this.displayTo = false;
      this.sspDimensions.attribute4 = null;
      this.DimensionForm.get('to').clearValidators();
      this.DimensionForm.get('to').disable();
      this.DimensionForm.updateValueAndValidity(); 
    }
    //this.prepareRmanEntityParametersVObject();

  }

  deleteRow(sspGroupingRuleDimension: any) {
    this.sspDimensions = sspGroupingRuleDimension;
    this.displayDialog = false;
    this.confirmationService.confirm({
      message: 'Are you sure you want to delete this record?',
      header: 'Confirmation',
      icon: '',
      accept: () => {
        this.sspGroupingRuleDimensions.splice(this.findSelectedSspGroupingRuleDimensionsIndex(), 1);
        $.blockUI();
        this.sspGroupingRuleDimensionsService.deleteDimensions(this.sspDimensions).then((response: any) => {
          $.unblockUI();
          this.sspDimensions = new SspGroupingRuleDimensionsImpl();
          this.getAllSspGroupingRuleDimensions();
        });
        this.notificationService.showSuccess('Deleted successfully');
      },
      reject: () => {
        this.notificationService.showWarning('You have rejected');
      }
    });



  }

  findSelectedSspGroupingRuleDimensionsIndex(): number {
    return this.sspGroupingRuleDimensions.indexOf(this.selectedSspGroupingRuleDimensions);
  }


  cloneDimensions(c: SspGroupingRuleDimensions): SspGroupingRuleDimensions {
    let sspDimensions: any
      = new SspGroupingRuleDimensionsImpl();
    for (let prop in c) {
      sspDimensions[prop] = c[prop];
    }
    return sspDimensions;
  }

  getAllSspGroupingRuleDimensions(searchobj?: any) {
    let data: any;
    if (searchobj) {
      data = searchobj
    } else {
      data = { 'groupId': this.groupId }
    }

    if (this.groupId != undefined && this.groupId != null) {
      this.loading = true;
      this.sspGroupingRuleDimensionsService.getAllSspGroupingRuleDimensions(this.paginationOptions, data).then((data: any) => {
        this.loading = false;
        this.datasource = data.content;
        if (this.datasource.length == 0) {
          this.notifyPameterExist.emit(false)
        } else {
          this.notifyPameterExist.emit(true)
        }
        if (this.groupId != undefined && this.groupId != null) {
          this.sspGroupingRuleDimensions = data.content;
        }
        this.sspGroupingRuleDimensions.forEach(obj=>{
          obj.dimensionName = this.transformRmanEntityParametersV(obj.dimensionName);
        
        });
        this.totalElements = data.totalElements;
        this.pageSize = data.size;
        //this.displaySearchDialog = false;
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while getting data');
        this.loading = false;
      });
    }

  }

  /*getAllSspGroupingRuleDimensions(event:any){
    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loading = true;
    this.sspGroupingRuleDimensionsList.push({first: true,last: true,number: 0,numberOfElements: 1,size: 10,sort: null,totalElements: 1,totalPages: 1, content: 
      [{number: 'Dimension 1', name: 'Product Name', from: '', identifier: 'Unique', to:''},
      {number: 'Dimension 2', name: 'Qty', from: '500', identifier: 'Greater than or equal to', to:'1000'},
      {number: 'Dimension 3', name: 'Region', from: '', identifier: 'Unique', to:''}]});
    this.loading = false;
    this.datasource = this.sspGroupingRuleDimensionsList[0].content;
    this.sspGroupingRuleDimensions = this.sspGroupingRuleDimensionsList[0].content;
    this.totalElements = this.sspGroupingRuleDimensionsList[0].totalElements;
    this.pageSize = this.sspGroupingRuleDimensionsList[0].size;
  }*/

  getSspGroupingRuleDimensions(event: any) {
    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    if (this.groupId != undefined && this.groupId != null) {
      this.loading = true;
      this.sspGroupingRuleDimensionsService.getAllSspGroupingRuleDimensions(this.paginationOptions, { 'groupId': this.groupId }).then((data: any) => {
        this.loading = false;
        this.datasource = data.content;
        this.sspGroupingRuleDimensions = data.content;
        this.totalElements = data.totalElements;
        this.pageSize = data.size;
        this.sspGroupingRuleDimensions.forEach(obj=>{
          obj.dimensionName = this.transformRmanEntityParametersV(obj.dimensionName);
        
        });
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while getting data');
        this.loading = false;
      });
    }
  }

  saveOrUpdate(msg: any){
    this.notificationService.showSuccess(msg);
    $.unblockUI();
    this.getAllSspGroupingRuleDimensions();
  }

  save() {
    this.loading = true;
    this.displayDialog = false;
    //new
    if (this.isCreate) {
      console.log(this.groupId);
      this.sspDimensions.groupId = this.groupId;
      $.blockUI();
      this.sspGroupingRuleDimensionsService.saveDimensions(this.sspDimensions).then((response: any) => {
        this.saveOrUpdate('Saved successfully');
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while saving data');
        console.log(err);
        $.unblockUI();
      });
    }
    else {
      $.blockUI();
      this.sspGroupingRuleDimensionsService.updateDimensions(this.sspDimensions).then((response: any) => {
        this.saveOrUpdate('Updated successfully');
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while updating data');
        $.unblockUI();
      });
    }
    this.sspDimensions = new SspGroupingRuleDimensionsImpl();
  }

  cancel(){
    this.displayDialog = false;
    this.value = 'Value';
    this.displayTo = false;
  }

  onHide(ev:any){
    
  }

}

class SspGroupingRuleDimensionsImpl{
  constructor(public dimensionId?: any, 
    public dimensionName?: any, 
    public andOr?: any, 
    public groupId?: any, 
    public attribute1?: any, 
    public attribute2?: any, 
    public attribute3?: any, 
    public attribute4?: any, 
    public attribute5?: any
    ) { }
}
