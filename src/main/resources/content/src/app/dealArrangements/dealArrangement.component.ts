import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Table } from 'primeng/table';
import { ArrangementManagerSharedService } from '../arrangementManager/arrangementManager-shared.service';
import { RmanCurrencyService } from '../rmanCurrency/rmanCurrencyservice';
import { RmanCustomersImpl } from '../rmanCustomers/rmanCustomers.component';
import { RmanCustomersLabels } from '../rmanCustomers/rmanCustomersLabels';
import { RmanCustomersService } from '../rmanCustomers/rmanCustomersservice';
import { RmanDealArrangementsService } from '../rmanDealArrangements/rmanDealArrangementsservice';
import { RmanLegalEntitiesService } from '../rmanLegalEntities/rmanLegalEntitiesservice';
import { RmanUsersService } from '../rmanUsers/rmanUsersservice';
import { RmanMasterArrangementsVService } from '../services/rmanMasterArrangementsVservice';
import { NotificationService } from '../shared/notifications.service';
import { DealarrangementService } from './dealarrangement.service';
import { DealArrangementLabels } from './dealArrangementLabel';
declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
  selector: 'app-deal',
  templateUrl: './dealArrangement.component.html',
  providers: [RmanLegalEntitiesService, RmanUsersService, RmanCurrencyService, RmanCustomersService, RmanMasterArrangementsVService, RmanDealArrangementsService]
})
export class DealArrangementComponent implements OnInit {

  @Input() actionDetails: any;
  edialog: boolean = false;
  pStatus: any = 'OPEN';
  displayDialog: boolean;
  displaySearchDialog: boolean;
  rmanDealArrangements: any = new RmanDealArrangementsImpl();
  rmanDealArrangementsSearch: any = new RmanDealArrangementsImpl();
  rmanCustomersLabels: RmanCustomersLabels = new RmanCustomersLabels();
  isSerached: number = 0;
  selectedRmanDealArrangements: any;
  newRmanDealArrangements: boolean;
  rmanDealArrangementsList: any[];
  cols: any[];
  columns: ILabels;
  customerColumns: ILabels2;
  columnOptions: any[];
  paginationOptions: any;
  pages: {};
  displayMasterArragement: boolean = false;
  datasource: any[];
  pageSize: number;
  totalElements: number;
  rmanCurrencyList: any[];
  rmanCurrency: any[];
  rmanLookupsVList: any[];
  rmanLookupsV: any[];
  rmanUsersList: any[];
  rmanUsers: any[];
  rmanUsers1List: any[];
  rmanUsers1: any[];
  rmanLookupsV1List: any[];
  rmanLookupsV1: any[];
  rmanCustomersList: any[];
  rmanLookupsV2List: any[];
  rmanLookupsV2: any[];
  rmanLookupsV3List: any[];
  rmanLookupsV3: any[];
  rmanLookupsV4List: any[];
  rmanLookupsV4: any[];
  rmanLookupsV5List: any[];
  rmanLookupsV5: any[]
  rmanLookupsV6List: any[];
  rmanLookupsV6: any[];
  rmanMasterArrangementsVList: any[];
  rmanMasterArrangementsV: any[];
  rmanLegalEntities: any[];
  rmanLegalEntitiesList: any[];
  arrgAddForm: FormGroup;
  arrgForm: FormGroup;
  loading: boolean = false;
  isLoad: boolean = false;
  got_form_data: boolean = false;
  arrIdK: any;
  displayItemSearchDialog: boolean;
  selectedCustomer: RmanCustomersImpl = new RmanCustomersImpl();
  rmanCustomersSearch: any = new RmanCustomersImpl();
  rmanCustomers: RmanCustomersImpl = new RmanCustomersImpl();
  noData = appSettings.noData;
  itemPageSize: number;
  itemTotalElements: number;

  constructor(private sharedService: ArrangementManagerSharedService, private rmanDealArrangementsService: RmanDealArrangementsService, private rmanCustomersService: RmanCustomersService, private formBuilder: FormBuilder,
    private dealarrangementService: DealarrangementService, private route: ActivatedRoute, private notificationService: NotificationService) {
    this.paginationOptions = { 'pageNumber': 0 };
  }

  ngOnInit() {
    this.rmanDealArrangements = new RmanDealArrangementsImpl();
    if (this.actionDetails == 'EDIT') {
      this.route.params.subscribe((params: any) => {
        this.arrIdK = params['id'];
      });
      this.newRmanDealArrangements = false;
      this.getRmanDealArrangementsById();
    } else if (this.actionDetails == 'ADD') {
      this.newRmanDealArrangements = true;
    }
    this.loading = true;
    this.dealarrangementService.getAllDealServices().subscribe(res => {
      if (res && !res.includes(null)) {
        this.rmanCurrencyList = res[0].content;
        this.prepareRmanCurrencyObject();
        this.rmanLookupsVList = res[1].content;
        this.prepareRmanLookupsVObject();

        this.rmanLookupsV1List = res[2].content;
        this.prepareRmanLookupsV1Object();

        this.rmanLookupsV2List = res[3].content;
        this.prepareRmanLookupsV2Object();

        this.rmanLookupsV3List = res[4].content;
        this.prepareRmanLookupsV3Object();

        this.rmanLookupsV4List = res[5].content;
        this.prepareRmanLookupsV4Object();

        this.rmanLookupsV5List = res[6].content;
        this.prepareRmanLookupsV5Object();

        this.rmanLookupsV6List = res[7].content;
        this.prepareRmanLookupsV6Object();

        this.rmanUsersList = res[8].content;
        this.prepareRmanUsersObject();
        this.rmanUsers1List = res[8].content;
        this.prepareRmanUsers1Object();

        this.rmanCustomersList = res[9].content;
        this.prepareRmanCustomersObject();

        this.rmanMasterArrangementsVList = res[10].content;
        this.prepareRmanMasterArrangementsVObject();


        this.rmanLegalEntitiesList = res[11].content;
        this.prepareRmanLegalEntitiesObject();
        this.loading = false;
        this.isLoad = true;
        this.got_form_data = true;
      } else {
        this.notificationService.showError('Error occured while getting data');
        this.loading = false;
        this.isLoad = true;
        this.got_form_data = false;
      }
    }, error => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
      this.isLoad = true;
      this.got_form_data = false;
    })
    let rmanDealArrangementsLabels = new DealArrangementLabels;
    this.columns = rmanDealArrangementsLabels.fieldLabels;
    let rmanCustomersLabels = new RmanCustomersLabels();
    this.customerColumns = rmanCustomersLabels.fieldLabels;
    this.buildForm();

  }
  getAllRmanCustomers() {
    this.rmanCustomersService.getAllRmanCustomers(this.paginationOptions, this.rmanCustomers, false).then((rmanCustomersList: any) => {
      this.loading = false;
      this.rmanCustomersList = rmanCustomersList.content;
      this.itemTotalElements = rmanCustomersList.totalElements;
      this.itemPageSize = rmanCustomersList.size;
      $('.ui-datatable-scrollable-body').scrollTop(0);
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }
  getRmanCustomers(event: any) {

    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.itemPageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loading = true;
    this.rmanCustomersService.getAllRmanCustomers(this.paginationOptions, this.rmanCustomers, false).then((rmanCustomersList: any) => {
      this.loading = false;
      this.rmanCustomersList = rmanCustomersList.content;
      this.itemTotalElements = rmanCustomersList.totalElements;
      this.itemPageSize = rmanCustomersList.size;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });

  }

  resetCustomers(customersdt: Table) {
    this.paginationOptions = {};
    this.rmanCustomers = new RmanCustomersImpl();
    this.rmanCustomersSearch = new RmanCustomersImpl();
    customersdt.reset();
  }
  buildForm() {
    this.arrgForm = this.formBuilder.group({
      'msaName': ['', [Validators.required,]],
      'msaNumber': ['', [Validators.required]],
      'dealArrangementNumber': ['', [Validators.required]],
      'dealArrangementName': ['', [Validators.required]],
      'endCustomerNumber': ['', [Validators.required]],
      'endCustomerName': ['', [Validators.required]],
      'dealArrangementSource': ['', [Validators.required,]],
      'dealArrangementBasis': ['', [Validators.required]],
      'legalEntityId': ['', [Validators.required]],
      'arrangementCurrency': ['', [Validators.required]],
      'salesNodeLevel1': ['', [Validators.required]],
      'salesNodeLevel2': ['', [Validators.required]],
      'salesNodeLevel3': ['', [Validators.required]],
      'salesNodeLevel4': ['', [Validators.required]],
      'salesContact': ['', [Validators.required]],
      'revAccountantId': ['', [Validators.required]],
      'revManagerId': ['', [Validators.required]],
      'masterArrgFlag': ['', [Validators.required]]
    });
    this.arrgForm.get('endCustomerNumber').disable();
    this.arrgForm.valueChanges
      .subscribe(data => this.onValueChanged(data));

    this.onValueChanged();

  }
  onValueChanged(data?: any) {
    if (!this.arrgForm) { return; }
    const form = this.arrgForm;

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
    'msaName': '', 'msaNumber': '', 'dealArrangementNumber': '', 'dealArrangementName': '', 'endCustomerNumber': '', 'endCustomerName': '', 'dealArrangementSource': '', 'dealArrangementBasis': '', 'legalEntityId': '', 'arrangementCurrency': '', 'salesNodeLevel1': '', 'salesNodeLevel2': '', 'salesNodeLevel3': '', 'salesNodeLevel4': '', 'salesContact': '', 'revAccountantId': '', 'revManagerId': '', 'masterArrgFlag': ''
  };
  customerSearchDialog(flag, customersdt: Table) {
    this.displayItemSearchDialog = true;
    this.rmanCustomers = new RmanCustomersImpl();
    this.rmanCustomersSearch = new RmanCustomersImpl();
    this.selectedCustomer = {};
    customersdt.reset();
  }
  cancelCustomerSearch() {
    this.displayItemSearchDialog = false;
  }
  populate() {

    this.rmanDealArrangements.endCustomerName = this.selectedCustomer.customerName;
    this.rmanDealArrangements.endCustomerNumber = this.selectedCustomer.customerNumber;
    this.displayItemSearchDialog = false;
  }
  onRowCustomerSelect(event) {

  }
  searchCustomer() {
    this.rmanCustomers = this.rmanCustomersSearch;
    this.paginationOptions = {};
    this.getAllRmanCustomers();

  }

  validationMessages = {
    'msaName': {
      'required': "MSA Name is required"
    }, 'msaNumber': {
      'required': "MSA Number is required"
    },
    'dealArrangementNumber': {
      'required': "Deal Arrangement Number is required"
    }, 'dealArrangementName': {
      'required': "Deal Arrangement Name is required"
    }, 'endCustomerNumber': {
      'required': "End Customer Number is required"
    }, 'endCustomerName': {
      'required': "End Customer Name is required"
    },
    'dealArrangementSource': {
      'required': "Deal Arrangement Source is required"
    }, 'dealArrangementBasis': {
      'required': "Deal Arrangement Basis is required"
    },
    'legalEntityId': {
      'required': "Legal Entity is required"
    }, 'arrangementCurrency': {
      'required': "Arrangement Currency is required"
    }, 'salesNodeLevel1': {
      'required': "Sales Theater is required"
    }, 'salesNodeLevel2': {
      'required': "Sales Region is required"
    }, 'salesNodeLevel3': {
      'required': "Sales Territory is required"
    }, 'salesNodeLevel4': {
      'required': "Deal Closed Flag is required"
    }, 'salesContact': {
      'required': "Sales Contact is required"
    }, 'revAccountantId': {
      'required': "Rev Accountant ID is required"
    }, 'revManagerId': {
      'required': "Rev Manager ID is required"
    }, 'masterArrgFlag': {
      'required': "Master Arrangement Flag is required"
    }
  }


  getRmanDealArrangementsById() {
    let pdealArrangementId = this.arrIdK;
    this.loading = true;
    this.rmanDealArrangementsService.getAllRmanDealArrangements(this.paginationOptions, { 'dealArrangementId': pdealArrangementId }).then((rmanArrangementsDemoList: any) => {
      this.loading = false;
      this.rmanDealArrangements = rmanArrangementsDemoList.content[0];
    });
  }


  save() {
    this.rmanDealArrangements.allocationEligible = 'Y';
    if (this.newRmanDealArrangements) {
      this.rmanDealArrangements.allocationEligible = 'Y';
      this.rmanDealArrangements.dealArrangementKey = this.rmanDealArrangements.dealArrangementName;
      this.rmanDealArrangements.dealArrangementStatus = this.pStatus;
      this.loading = true;

      this.dealarrangementService.saveRmanDealArrangements(this.rmanDealArrangements).then((response: any) => {
        this.sharedService.setNotifyFlag(true);
        this.rmanDealArrangements = new RmanDealArrangementsImpl();
      }).catch((err: any) => {
        this.sharedService.setNotifyErrorFlag(true);
        this.notificationService.showError('Error occured while saving the data');
        this.loading = false;
      });
      this.sharedService.setNotifyParent(this.edialog);
    }
    else {
      this.loading = true;
      this.isLoad = false;
      this.dealarrangementService.updateRmanDealArrangements(this.rmanDealArrangements).then((response: any) => {
        this.rmanDealArrangements = new RmanDealArrangementsImpl();
        this.isLoad = true;
        this.sharedService.setNotifyParent(this.edialog);
      }).catch((err: any) => {
        this.isLoad = true;
        this.notificationService.showError('Error occured while updating the data');
        this.loading = false;
      });
    }
  }
  onCancel() {
    this.rmanDealArrangements = new RmanDealArrangementsImpl();
    this.sharedService.setNotifyParent(this.edialog);
  }


  onSelectEntity(event: any) {
    if (event.value) {
      this.rmanDealArrangements.legalEntityName = this.rmanLegalEntities.filter((item: any) => item.value == event.value)[0].label;
    } else {
      this.rmanDealArrangements.legalEntityName = null;
    }

  }
  onSelectCustomer(event: any) {
    if (event.value) {
      /* no-code */
    } else {
      this.rmanDealArrangements.endCustomerName = null;
      this.rmanDealArrangements.endCustomerNumber = null;
    }
  }



  prepareRmanCurrencyObject() {
    let rmanCurrencyTempObj: any = [];
    rmanCurrencyTempObj.push({ label: appSettings.dropDownOptions.selectArrangementCurrency, value: null });
    this.rmanCurrencyList.forEach((rmanCurrency) => {
      rmanCurrencyTempObj.push({ label: rmanCurrency.currencyCode, value: rmanCurrency.currencyCode });
    });

    this.rmanCurrency = rmanCurrencyTempObj;
  }

  prepareRmanLookupsVObject() {
    let rmanLookupsVTempObj: any = [];
    rmanLookupsVTempObj.push({ label: appSettings.dropDownOptions.selectMasterArrgFlag, value: null });
    this.rmanLookupsVList.forEach((rmanLookupsV) => {
      rmanLookupsVTempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
    });

    this.rmanLookupsV = rmanLookupsVTempObj;

  }

  prepareRmanLookupsV1Object() {
    let rmanLookupsV1TempObj: any = [];
    rmanLookupsV1TempObj.push({ label: appSettings.dropDownOptions.selectSalesTheater, value: null });
    this.rmanLookupsV1List.forEach((rmanLookupsV1) => {
      rmanLookupsV1TempObj.push({ label: rmanLookupsV1.lookupDescription, value: rmanLookupsV1.lookupCode });
    });

    this.rmanLookupsV1 = rmanLookupsV1TempObj;

  }
  prepareRmanLookupsV2Object() {
    let rmanLookupsV2TempObj: any = [];
    rmanLookupsV2TempObj.push({ label: appSettings.dropDownOptions.selectSalesRegion, value: null });
    this.rmanLookupsV2List.forEach((rmanLookupsV2) => {
      rmanLookupsV2TempObj.push({ label: rmanLookupsV2.lookupDescription, value: rmanLookupsV2.lookupCode });
    });

    this.rmanLookupsV2 = rmanLookupsV2TempObj;

  }

  prepareRmanLookupsV3Object() {
    let rmanLookupsV3TempObj: any = [];
    rmanLookupsV3TempObj.push({ label: appSettings.dropDownOptions.selectSalesTeritory, value: null });
    this.rmanLookupsV3List.forEach((rmanLookupsV3) => {
      rmanLookupsV3TempObj.push({ label: rmanLookupsV3.lookupDescription, value: rmanLookupsV3.lookupCode });
    });

    this.rmanLookupsV3 = rmanLookupsV3TempObj;

  }

  prepareRmanLegalEntitiesObject() {
    let rmanLegalEntitiesTempObj: any = [{ label: appSettings.dropDownOptions.selectLegalEntityName, value: null }];
    this.rmanLegalEntitiesList.forEach((rmanLegalEntities) => {
      rmanLegalEntitiesTempObj.push({ label: rmanLegalEntities.name, value: rmanLegalEntities.legalEntityId });
    });
    this.rmanLegalEntities = rmanLegalEntitiesTempObj;
  }

  prepareRmanLookupsV4Object() {
    let rmanLookupsV4TempObj: any = [];
    rmanLookupsV4TempObj.push({ label: appSettings.dropDownOptions.selectDealClosedFlag, value: null });
    this.rmanLookupsV4List.forEach((rmanLookupsV4) => {
      rmanLookupsV4TempObj.push({ label: rmanLookupsV4.lookupDescription, value: rmanLookupsV4.lookupCode });
    });

    this.rmanLookupsV4 = rmanLookupsV4TempObj;

  }
  prepareRmanLookupsV5Object() {
    let rmanLookupsV5TempObj: any = [];
    rmanLookupsV5TempObj.push({ label: appSettings.dropDownOptions.selectDealArrangementSource, value: null });
    this.rmanLookupsV5List.forEach((rmanLookupsV5) => {
      rmanLookupsV5TempObj.push({ label: rmanLookupsV5.lookupDescription, value: rmanLookupsV5.lookupCode });
    });

    this.rmanLookupsV5 = rmanLookupsV5TempObj;

  }
  prepareRmanLookupsV6Object() {
    let rmanLookupsV6TempObj: any = [];
    rmanLookupsV6TempObj.push({ label: appSettings.dropDownOptions.selectDealArrangementBasis, value: null });
    this.rmanLookupsV6List.forEach((rmanLookupsV6) => {
      rmanLookupsV6TempObj.push({ label: rmanLookupsV6.lookupDescription, value: rmanLookupsV6.lookupCode });
    });

    this.rmanLookupsV6 = rmanLookupsV6TempObj;

  }

  prepareRmanUsersObject() {
    let rmanUsersTempObj: any = [];
    rmanUsersTempObj.push({ label: appSettings.dropDownOptions.selectRevManagerID, value: null });
    this.rmanUsersList.forEach((rmanUsers) => {
      rmanUsersTempObj.push({ label: rmanUsers.fullName, value: rmanUsers.rmanUserId });
    });

    this.rmanUsers = rmanUsersTempObj;

  }

  prepareRmanUsers1Object() {
    let rmanUsers1TempObj: any = [];
    rmanUsers1TempObj.push({ label: appSettings.dropDownOptions.selectRevAccountantID, value: null });
    this.rmanUsers1List.forEach((rmanUsers1) => {
      rmanUsers1TempObj.push({ label: rmanUsers1.fullName, value: rmanUsers1.rmanUserId });
    });

    this.rmanUsers1 = rmanUsers1TempObj;

  }

  prepareRmanCustomersObject() {
    let rmanCustomersTempObj: any = [];
    rmanCustomersTempObj.push({ label: appSettings.dropDownOptions.selectCustomer, value: null });
    this.rmanCustomersList.forEach((rmanCustomers) => {
      rmanCustomersTempObj.push({ label: rmanCustomers.customerName, value: rmanCustomers.customerNumber });
    });

    this.rmanCustomers = rmanCustomersTempObj;
  }

  prepareRmanMasterArrangementsVObject() {
    let rmanMasterArrangementsVTempObj: any = [];
    rmanMasterArrangementsVTempObj.push({ label: appSettings.dropDownOptions.selectMasterArrangement, value: null });
    this.rmanMasterArrangementsVList.forEach((rmanMasterArrangementsV) => {
      rmanMasterArrangementsVTempObj.push({ label: rmanMasterArrangementsV.masterarrgname, value: rmanMasterArrangementsV.masterarrgid });
    });

    this.rmanMasterArrangementsV = rmanMasterArrangementsVTempObj;
  }
  onSelectMasterFlag(masterArrgFlag: any) {
    if (masterArrgFlag == 'C') {
      this.displayMasterArragement = true;
      this.rmanDealArrangements.masterArrgId = null;
    } else {

      this.rmanDealArrangements.masterArrgId = null;
      this.displayMasterArragement = false;
      this.rmanDealArrangements.masterArrgName = null;
    }
  }
  onMasterArrgName(arrgId: any) {
    let rmanMasterList: any[];
    rmanMasterList = this.rmanMasterArrangementsVList.filter((item: any) => item.masterarrgid == arrgId, true);
    if (rmanMasterList) {
      this.rmanDealArrangements.masterArrgName = rmanMasterList[0].masterarrgname;
    }
  }
}

class RmanDealArrangementsImpl {
  constructor(public dealCosedDate?: any, public attribute30?: any, public lastUpdateDate?: any, public dealArrangementBasis?: any, public dealArrangementKey?: any, public dealArrangementTotal?: any, public changeReason?: any, public attribute29?: any, public attribute28?: any, public dealArrangementType?: any, public attribute27?: any, public dealApprovalDate?: any, public attribute26?: any, public masterArrgId?: any, public dealName?: any, public attribute3?: any, public createdBy?: any, public attribute2?: any, public lastUpdatedBy?: any, public attribute1?: any, public dealArrangementSource?: any, public salesContact?: any, public legalEntityId?: any, public creationDate?: any, public attribute9?: any, public attribute8?: any, public attribute7?: any, public attribute6?: any, public attribute5?: any, public attribute4?: any, public allocationEligible?: any, public dealAgreementId?: any, public dealArrangementStatus?: any, public attribute10?: any, public endCustomerName?: any, public dealArrangementNumber?: any, public masterArrgName?: any, public revManagerId?: any, public attribute14?: any, public attribute13?: any, public arrangementCurrency?: any, public attribute12?: any, public msaName?: any, public attribute11?: any, public dealApprovedBy?: any, public dealArrangementName?: any, public endCustomerNumber?: any, public customerContact?: any, public dealId?: any, public dealArrangementSaMe?: any, public dealNumber?: any, public attribute21?: any, public salesNodeLevel4?: any, public attribute20?: any, public msaNumber?: any, public salesNodeLevel2?: any, public salesNodeLevel3?: any, public dealArrangementQtr?: any, public attribute25?: any, public attribute24?: any, public attribute23?: any, public revAccountantId?: any, public attribute22?: any, public reasonCode?: any, public masterArrgFlag?: any, public salesNodeLevel1?: any, public dealArrangementId?: any, public legalEntityName?: any, public attribute18?: any, public attribute17?: any, public attribute16?: any, public attribute15?: any, public dealAgreementName?: any, public attribute19?: any) { }
}

interface ILabels {
  [index: string]: string;
}
interface ILabels2 {
  [index: string]: string;
}