import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { RmanLookupsVService } from 'src/app/rmanLookupsV/rmanLookupsVservice';
import { SspGroupingRulesImpl } from 'src/app/sspGroupingRules/sspGroupingRules.component';
import { SspGroupingRulesService } from 'src/app/sspGroupingRules/sspGroupingRules.service';
import { GenerateSSPService } from './generateSsp.service';
import { NotificationService } from '../../shared/notifications.service';
import { RmanUsersService } from '../.././rmanUsers/rmanUsersservice';
import { Location } from '@angular/common';

declare var require: any;
const appSettings = require('../../appsettings');

declare var $: any;

@Component({
  selector: 'generate-ssp',
  templateUrl: './generateSsp.component.html',
  providers:[SspGroupingRulesService, GenerateSSPService, RmanUsersService]
})
export class GenerateSSPComponent implements OnInit {

  generateSspForm: FormGroup;
  paginationOptions: any;
  loading: boolean;

  rmanSspTypeList: any[] = [];
  rmanSspTypes: any[];
  rmanCalculateSspValsList: any[] = [];
  rmanCalculateSspVals: any[];
  rmanbsiDatesList: any[] = [];
  rmanbsiDates: any[];
  rmanAmountList: any[] = [];
  rmanAmounts: any[];
  sspGRulesList: any[] = [];
  sspGRules: any[];

  sspType:any;
  calculateSsp:any;
  min:any;
  max:any;
  bsiDate:any;
  amountType:any;
  sourceFrom:any;
  sourceTo:any;
  targetFrom:any;
  targetTo:any;
  sspGrule:any;

  sspBookId:any;

  sspGroupingRules:any = new SspGroupingRulesImpl();
  rmanUserId: any;

  sspData:any;
  itemCategoriesList: any[] = [];
  itemCategories: any[];
  itemCategory: any;


  constructor(private formBuilder: FormBuilder, private rmanLookupsVService: RmanLookupsVService,private route: ActivatedRoute,
    private sspGroupingRulesService: SspGroupingRulesService, private generateSSPService: GenerateSSPService, private notificationService: NotificationService,
    private rmanUsersService: RmanUsersService, private location: Location,private router: Router) {

    this.sspData = this.location.getState();
    if(this.sspData.bookStartDate === undefined){
      this.router.navigate(['/fairValues','sspBooks']);
    }
    this.targetFrom = new Date(this.sspData.bookStartDate);
    this.targetTo = new Date(this.sspData.bookEndDate);

    this.route.params.subscribe((params) => {
      this.sspBookId = params.id;
    });

    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    $.blockUI();
    this.sspGroupingRules.enabledFlag = 'Y';

    this.sspGroupingRulesService.getAllSspGroupingRules(this.paginationOptions, this.sspGroupingRules, true).then((ruleList: any) => {
      this.sspGRulesList = ruleList.content;
      this.prepareSspGRulesObject();
    });
    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'FMV_TYPE' }).then((rmanSspTypeList: any) => {
      this.rmanSspTypeList = rmanSspTypeList.content;
      this.prepareRmanSspTypesObject();
    });
    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'SSP_CALCULATION_TYPE' }).then((rmanCalculateSspValsList: any) => {
      this.rmanCalculateSspValsList = rmanCalculateSspValsList.content;
      this.prepareRmanCalculateSspObject()
    });
    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'BSI_DATES' }).then((rmanbsiDatesList: any) => {
      this.rmanbsiDatesList = rmanbsiDatesList.content;
      this.prepareRmanBSIDatesObject()
    });
    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'SSP_AMOUNT_TYPES' }).then((rmanAmountList: any) => {
      this.rmanAmountList = rmanAmountList.content;
      this.prepareRmanAmountsObject()
    });
    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'ITEM_CATEGORIES_LIST' }).then((itemCategoriesList: any) => {
      this.itemCategoriesList = itemCategoriesList.content;
      this.prepareItemCategoriesObject()
    });



   }

  ngOnInit() {
    this.getRmanUsersInfo();
    this.buildForm();
  }

  getRmanUsersInfo() {
   
    this.rmanUsersService.getUsersInfo().then((rmanUsersInfo: any) => {
      if (rmanUsersInfo != null) {
        this.rmanUserId  = rmanUsersInfo.rmanUserId;
      }
      console.log(this.rmanUserId);
      
    }).catch((err: any) => {
      this.notificationService.showError('Error Occurred while fetching logged in User Id' );
    })
  }

  prepareSspGRulesObject() {
    let rmanSspGRulesTempObj: any = [{ label: appSettings.dropDownOptions.selectRuleName, value: null }];
    this.sspGRulesList.forEach((ssprule) => {
      rmanSspGRulesTempObj.push({ label: ssprule.ruleName, value: ssprule.ruleName });
    });
    this.sspGRules = rmanSspGRulesTempObj;
    $.unblockUI();
  }

  prepareRmanSspTypesObject() {
    let rmanSspTypeTempObj: any = [{ label: appSettings.dropDownOptions.selectFMVType, value: null }];
    this.rmanSspTypeList.forEach((rmanSspType) => {
      rmanSspTypeTempObj.push({ label: rmanSspType.lookupDescription, value: rmanSspType.lookupCode });
    });
    this.rmanSspTypes = rmanSspTypeTempObj;
    $.unblockUI();
  }

  prepareRmanCalculateSspObject() {
    let rmancalSspTempObj: any = [{ label: appSettings.dropDownOptions.selectCalculateSsp, value: null }];
    this.rmanCalculateSspValsList.forEach((rmanSspCal) => {
      rmancalSspTempObj.push({ label: rmanSspCal.lookupDescription, value: rmanSspCal.lookupCode});
    });
    this.rmanCalculateSspVals = rmancalSspTempObj;
    $.unblockUI();
  }

  prepareRmanBSIDatesObject() {
    let rmanBsiDatesTempObj: any = [{ label: appSettings.dropDownOptions.selectBSIDate, value: null }];
    this.rmanbsiDatesList.forEach((rmanbsiDate) => {
      rmanBsiDatesTempObj.push({ label: rmanbsiDate.lookupDescription, value: rmanbsiDate.lookupCode});
    });
    this.rmanbsiDates = rmanBsiDatesTempObj;
    $.unblockUI();
  }

  prepareRmanAmountsObject(){
    let rmanAmountsTempObj: any = [{ label: appSettings.dropDownOptions.selectSSPAmount, value: null }];
    this.rmanAmountList.forEach((rmanAmounts) => {
      rmanAmountsTempObj.push({ label: rmanAmounts.lookupDescription, value: rmanAmounts.lookupCode});
    });
    this.rmanAmounts = rmanAmountsTempObj;
    $.unblockUI();
  }

  prepareItemCategoriesObject(){
    let itemCategoriesTempObj: any = [{ label: appSettings.dropDownOptions.selectItemCategory, value: null }];
    this.itemCategoriesList.forEach((itemCategory) => {
      itemCategoriesTempObj.push({ label: itemCategory.lookupDescription, value: itemCategory.lookupCode});
    });
    this.itemCategories = itemCategoriesTempObj;
    $.unblockUI();
  }

  buildForm() {
    this.generateSspForm = this.formBuilder.group({
      'type': ['', [Validators.required]],
      'calculateSsp': ['', [Validators.required]],
      'minimum': ['', [Validators.required,Validators.pattern(/^-?[0-9]+(.[0-9]{0,2})?$/)]],
      'maximum': ['', [Validators.required,Validators.pattern(/^-?[0-9]+(.[0-9]{0,2})?$/)]],
      'bsiDate': ['', [Validators.required]],
      'amount': ['', [Validators.required]],
      'sourceFrom': ['', [Validators.required]],
      'sourceTo': ['', [Validators.required]],
      'targetFrom': ['', [Validators.required]],
      'targetTo': ['', [Validators.required]],
      'sspGrule': ['', [Validators.required]],
      'itemCategory':['',[]],
    });
    this.generateSspForm.valueChanges
      .subscribe(data => this.onValueChanged(data));
    this.onValueChanged();
  }

  onValueChanged(data?: any) {
    if (!this.generateSspForm) { return; }
    const form = this.generateSspForm;

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
    'type': '','calculateSsp':'','minimum': '', 'maximum': '','bsiDate':'','amount':'','sourceFrom':'','sourceTo':'','targetFrom':'','targetTo':'','sspGrule':''
  };

  validationMessages = {
    'type': { 'required': "SSP Type is required" },
    'calculateSsp':{ 'required': "Calculate SSP is required" },
    'minimum': { 
      'required': "SSP Min is required (Only number values are allowed [0-9])",
      'pattern': 'Only number values are allowed [0-9]' },
    'maximum': { 
      'required': "SSP Max is required (Only number values are allowed [0-9])",
      'pattern': 'Only number values are allowed [0-9]' },
    'bsiDate': { 'required': "Date is required" },
    'amount':{ 'required': "Amount is required" },
    'sourceFrom': { 'required': "Source From is required" },
    'sourceTo':{ 'required': "Source To is required" },
    'targetFrom': { 'required': "Target From is required" },
    'targetTo':{ 'required': "Target To is required" },
    'sspGrule':{ 'required': "Rule Name is required" },
  }

  onSSPCalculationChange(){
    if (this.generateSspForm.controls['calculateSsp'].value == 'auto') {
      this.min = "";
      this.max = "";
      this.generateSspForm.get('minimum').clearValidators();
      this.generateSspForm.get('maximum').clearValidators();
      this.generateSspForm.get('minimum').disable();
      this.generateSspForm.get('maximum').disable();
      this.generateSspForm.updateValueAndValidity();
    }else {
      this.generateSspForm.get('minimum').setValidators([Validators.required,Validators.pattern(/^-?[0-9]+(.[0-9]{0,2})?$/)]);
      this.generateSspForm.get('maximum').setValidators([Validators.required,Validators.pattern(/^-?[0-9]+(.[0-9]{0,2})?$/)]);
      this.generateSspForm.get('minimum').enable();
      this.generateSspForm.get('maximum').enable();
      this.generateSspForm.updateValueAndValidity();
    }
  }

  onSelectingSSPType(value: any){
    //console.log(value);
    if(value =='DISCOUNT'){
      this.amountType = 'DISCOUNT_VALUE';
      this.generateSspForm.get('amount').disable();
    }else if(value=='NETPRICE'){
      this.amountType = 'NET_SELLING_PRICE';
      this.generateSspForm.get('amount').disable();
    }else{
      this.amountType = null;
      this.generateSspForm.get('amount').enable();
    }
    this.generateSspForm.updateValueAndValidity();
  }

  save(){
    $.blockUI();
    this.generateSSPService.generateSSP(this.sspBookId, this.sspType,this.calculateSsp, this.min, this.max, this.amountType, this.bsiDate, this.sourceFrom, this.sourceTo, this.targetFrom, this.targetTo, this.sspGrule, this.rmanUserId).then((response: any) => {
      $.unblockUI();
      if (response) {       
        this.notificationService.showSuccess('Successfully Generated SSP For Selected SSP Book');
        this.generateSspForm.reset();
        this.router.navigate(['/fairValues','sspBooks']);
      } else {   
        this.notificationService.showError('Generate SSP Process Failed' );
      }
    }).catch((err: any) => {
      $.unblockUI();
      this.notificationService.showError('Network failed / service is down');
    });
  }

  cancel(){
     this.generateSspForm.reset();
     this.targetFrom = new Date(this.sspData.bookStartDate);
     this.targetTo = new Date(this.sspData.bookEndDate);
  }

}
