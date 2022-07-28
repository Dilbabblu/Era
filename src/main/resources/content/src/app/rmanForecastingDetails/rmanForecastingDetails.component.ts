import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NavigationEnd, Router } from "@angular/router";
import { Table } from 'primeng/table';
import { RmanCurrencyService } from '../rmanCurrency/rmanCurrencyservice';
import { RmanDealArrangementsService } from '../rmanDealArrangements/rmanDealArrangementsservice';
import { RmanFcBucketsService } from '../rmanFcBuckets/rmanFcBucketsservice';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { RmanFcConversionTypesService } from '../services/rmanFcConversionTypesservice';
import { RmanFcLevelService } from '../services/rmanFcLevelservice';
import { RmanFcMethodsService } from '../services/rmanFcMethodsservice';
import { NotificationService } from '../shared/notifications.service';
import { RmanForecastingDetails } from './rmanForecastingDetails';
import { RmanForecastingDetailsLabels } from './rmanForecastingDetailsLabels';
import { RmanForecastingDetailsService } from './rmanForecastingDetailsservice';
declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
  templateUrl: './rmanForecastingDetails.component.html',
  selector: 'rmanForecastingDetails-data',
  providers: [RmanForecastingDetailsService, RmanFcConversionTypesService, RmanCurrencyService, RmanFcBucketsService, RmanFcLevelService, RmanFcMethodsService]
})

export class RmanForecastingDetailsComponent implements OnInit {
  noData = appSettings.noData;
  displayDialog: boolean;

  displayTable: boolean = false;

  displayAddDialog: boolean = false;
  displaySearchDialog: boolean;
  arrIdK: any;
  rmanForecastingDetails: any = new RmanForecastingDetailsImpl();

  rmanForecastingDetailsSearch: any = new RmanForecastingDetailsImpl();

  isSerached: number = 0;

  selectedRmanForecastingDetails: RmanForecastingDetails;

  newRmanForecastingDetails: boolean;

  rmanForecastingDetailsList: any[];
  rmanForecastingDetailsList1: any[];
  rmanFcMethodsList1: any[];
  cols: any[];
  columns: ILabels;

  columnOptions: any[];

  paginationOptions: any;

  pages: {};

  datasource: any[];
  pageSize: number;
  totalElements: number;


  rmanLookupsVList: any[] = [];
  rmanLookupsV: any[];
  rmanLookupsV2List: any[] = [];
  rmanLookupsV2: any[];
  rmanFcConversionTypesList: any[] = [];
  rmanFcConversionTypes: any[];
  rmanCurrencyList: any[] = [];
  rmanCurrency: any[];
  rmanFcBucketsList: any[] = [];
  rmanFcBuckets: any[];
  rmanFcLevelList: any[] = [];
  rmanFcLevel: any[];
  rmanLookupsV1List: any[] = [];
  rmanLookupsV1: any[];
  rmanFcMethodsList: any[] = [];
  rmanFcMethods: any[];
  rmanDealArrangementsList: any[] = [];
  rmanDealArrangements: any[];
  rmanDealArrangements1: any[] = [];
  rmanForecastingDetailsList2: any[] = [];
  rmanDealArrangementsList1: any[] = [];
  b1period: any = '';
  b2period: any;
  b3period: any;
  b4period: any;
  b5period: any;
  b6period: any;
  b7period: any;
  b8period: any;
  b9period: any;
  b10period: any;
  b11period: any;
  b12period: any;
  b13period: any;
  b14period: any;
  b15period: any;
  b16period: any;
  b17period: any;
  b18period: any;
  b19period: any;
  b20period: any;
  b21period: any;
  b22period: any;
  b23period: any;
  b24period: any;

  collapsed: boolean = true;

  forecastingDetailsForm: FormGroup;
  loading: boolean;


  constructor(private rmanForecastingDetailsService: RmanForecastingDetailsService, private rmanLookupsVService: RmanLookupsVService, private rmanFcConversionTypesService: RmanFcConversionTypesService, private rmanCurrencyService: RmanCurrencyService, private rmanFcBucketsService: RmanFcBucketsService, private rmanFcLevelService: RmanFcLevelService, private rmanFcMethodsService: RmanFcMethodsService, private rmanDealArrangementsService: RmanDealArrangementsService, private router: Router, private formBuilder: FormBuilder,
    private notificationService: NotificationService) {

    // generate list code
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.arrIdK = event.url.split('/')[3];
      }
    });
    this.loading = true;
    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { lookupTypeName: 'ENABLED_FLAG' }).then((rmanLookupsVList: any) => {
      this.rmanLookupsVList = rmanLookupsVList.content;
      this.prepareRmanLookupsVObject();


      this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { lookupTypeName: 'ENABLED_FLAG' }).then((rmanLookupsV2List: any) => {
        this.rmanLookupsV2List = rmanLookupsV2List.content;
        this.prepareRmanLookupsV2Object();


        this.rmanFcConversionTypesService.getAllRmanFcConversionTypes(this.paginationOptions, {}).then((rmanFcConversionTypesList: any) => {
          this.rmanFcConversionTypesList = rmanFcConversionTypesList.content;
          this.prepareRmanFcConversionTypesObject();


          this.rmanCurrencyService.getAllRmanCurrency(this.paginationOptions, {}).then((rmanCurrencyList: any) => {
            this.rmanCurrencyList = rmanCurrencyList.content;
            this.prepareRmanCurrencyObject();

            this.rmanFcBucketsService.getFcBucketsList().then((rmanFcBucketsList: any) => {
              this.rmanFcBucketsList = rmanFcBucketsList;
              this.prepareRmanFcBucketsObject();

              this.rmanFcLevelService.getAllRmanFcLevel(this.paginationOptions, {}).then((rmanFcLevelList: any) => {
                this.rmanFcLevelList = rmanFcLevelList.content;
                this.prepareRmanFcLevelObject();

                this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, {}).then((rmanLookupsV1List: any) => {
                  this.rmanLookupsV1List = rmanLookupsV1List.content;
                  this.prepareRmanLookupsV1Object();


                  this.rmanFcMethodsService.getAllRmanFcMethods(this.paginationOptions, {}).then((rmanFcMethodsList: any) => {
                    this.rmanFcMethodsList = rmanFcMethodsList.content;
                    this.prepareRmanFcMethodsObject();

                    this.rmanDealArrangementsService.getAllRmanDealArrangements(this.paginationOptions, {}).then((rmanDealArrangementsList: any) => {
                      this.rmanDealArrangementsList = rmanDealArrangementsList.content;
                      this.prepareRmanDealArrangementsObject();
                      this.prepareRmanDealArrangementsObject1();

                      this.rmanForecastingDetailsService.getAllRmanForecastingDetails(this.paginationOptions, { 'arrangementId': this.arrIdK }).then((rmanForecastingDetailsList1: any) => {
                        this.loading = false;
                        this.rmanForecastingDetailsList1 = rmanForecastingDetailsList1.content.filter((item: any) => item.arrangementId == this.arrIdK, true);
                        var n: any;
                        for (n = 1; n <= 24; n++) {
                          this.onbuckeutPeriodHeader(n, this.rmanForecastingDetailsList1);
                        }
                      }).catch((err: any) => {
                        this.notificationService.showError('Error occured while getting data');
                        this.loading = false;
                      });
                    }).catch((err: any) => {
                      this.notificationService.showError('Error occured while getting "Deal Arrangement" data');
                      this.loading = false;
                    });
                  }).catch((err: any) => {
                    this.notificationService.showError('Error occured while getting "FC Method ID" data');
                    this.loading = false;
                  });
                }).catch((err: any) => {
                  this.notificationService.showError('Error occured while getting data');
                  this.loading = false;
                });
              }).catch((err: any) => {
                this.notificationService.showError('Error occured while "FC Level Name" getting data');
                this.loading = false;
              });
            }).catch((err: any) => {
              this.notificationService.showError('Error occured while "FC Bucket ID" getting data');
              this.loading = false;
            });
          }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
          });
        }).catch((err: any) => {
          this.notificationService.showError('Error occured while "FC Conversion Type" getting data');
          this.loading = false;
        });
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while "Apply Contingencies" getting data');
        this.loading = false;
      });
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while "Apply Allocations" getting data');
      this.loading = false;
    });



    this.getAllRmanForecastingDetails();
    this.rmanDealArrangementsService.getAllRmanDealArrangements(this.paginationOptions, { 'dealArrangementId': this.arrIdK }).then((rmanDealArrangementsList: any) => {
      this.loading = false;
      this.rmanDealArrangementsList1 = rmanDealArrangementsList.content.filter((item: any) => item.dealArrangementId == this.arrIdK, true);
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');

    });
    this.loading = true;
  }

  ngAfterViewChecked() {
  }

  ngOnInit() {

    let rmanForecastingDetailsLabels = new RmanForecastingDetailsLabels();
    this.columns = rmanForecastingDetailsLabels.fieldLabels;
    this.buildForm();
  }

  exportExcel() {
    let serviceUrl = this.rmanForecastingDetailsService.getServiceUrl(this.paginationOptions, { 'arrangementId': this.arrIdK }, 1);
    window.location.href = serviceUrl;
  }

  reset(dt: Table) {
    dt.reset();
    this.paginationOptions = {};
    this.rmanForecastingDetails = new RmanForecastingDetailsImpl();
    this.getAllRmanForecastingDetails();
  }

  buildForm() {
    this.forecastingDetailsForm = this.formBuilder.group({
      'arrId': ['', [Validators.required]],
      'arrName': ['', [Validators.required]],
      'levelName': ['', [Validators.required]],
      'startDate': ['', [Validators.required]],
      'bucketId': ['', [Validators.required]],
      'allocation': ['', [Validators.required]],
      'applyCont': ['']
    });

    this.forecastingDetailsForm.valueChanges
      .subscribe(data => this.onValueChanged(data));

    this.onValueChanged();
  }

  onValueChanged(data?: any) {
    if (!this.forecastingDetailsForm) { return; }
    const form = this.forecastingDetailsForm;

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
    'arrId': '', 'arrName': '', 'levelName': '', 'startDate': '', 'bucketId': '', 'allocation': '', 'applyCont': ''
  };

  validationMessages = {
    'arrId': {
      'required': "Arrangement ID is required"
    }, 'arrName': {
      'required': "Arrangement Name is Required"
    },
    'levelName': {
      'required': "FC Level Name is required"
    }, 'startDate': {
      'required': "Start Date is required",
    }, 'bucketId': {
      'required': "FC Bucket ID is required"
    }, 'allocation': {
      'required': "Apply Allocations is required"
    }, 'applyCont': {
      'required': "Apply Contingencies is required"
    }
  }


  transformRmanLookupsV(rmanLookupsV: any) {
    if (rmanLookupsV)
      return rmanLookupsV.lookupDescription;
  }
  transformRmanFcConversionTypes(rmanFcConversionTypes: any) {
    if (rmanFcConversionTypes)
      return rmanFcConversionTypes.description;
  }
  transformRmanCurrency(rmanCurrency: any) {
    if (rmanCurrency)
      return rmanCurrency.name;
  }
  transformRmanFcBuckets(rmanFcBuckets: any) {
    if (rmanFcBuckets)
      return rmanFcBuckets.name;
  }
  transformRmanFcLevel(rmanFcLevel: any) {
    if (rmanFcLevel)
      return rmanFcLevel.name;
  }
  transformRmanLookupsV1(rmanLookupsV1: any) {
    if (rmanLookupsV1)
      return rmanLookupsV1.lookupDescription;
  }

  transformRmanFcMethods(rmanFcMethods: any) {
    if (rmanFcMethods)
      return rmanFcMethods.name;
  }



  getAllRmanForecastingDetails() {
    this.loading = true;
    this.rmanForecastingDetailsService.getAllRmanForecastingDetails(this.paginationOptions, { 'arrangementId': this.arrIdK }).then((rmanForecastingDetailsList: any) => {
      this.loading = false;
      this.datasource = rmanForecastingDetailsList.content;
      this.rmanForecastingDetailsList = rmanForecastingDetailsList.content;
      this.totalElements = rmanForecastingDetailsList.totalElements;
      this.pageSize = rmanForecastingDetailsList.size;
      this.displaySearchDialog = false;
    });
  }


  getRmanForecastingDetails(event: any) {

    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loading = true;
    this.rmanForecastingDetailsService.getAllRmanForecastingDetails(this.paginationOptions, { 'arrangementId': this.arrIdK }).then((rmanForecastingDetailsList: any) => {
      this.loading = false;
      this.datasource = rmanForecastingDetailsList.content;
      this.rmanForecastingDetailsList = rmanForecastingDetailsList.content;
      this.totalElements = rmanForecastingDetailsList.totalElements;
      this.pageSize = rmanForecastingDetailsList.size;
    });

  }

  onHide(data) {
    this.displayAddDialog = false;
  }


  showDialogToAdd() {
    this.newRmanForecastingDetails = true;
    this.rmanForecastingDetails = new RmanForecastingDetailsImpl();


    this.rmanDealArrangementsList1 = this.removeDuplicate(this.rmanDealArrangementsList1, 'dealArrangementId');

    if (this.rmanDealArrangementsList1.length > 0) {

      this.rmanForecastingDetails.arrangementId = this.rmanDealArrangementsList1[0].dealArrangementId;
      this.rmanForecastingDetails.arrangementName = this.rmanDealArrangementsList1[0].dealArrangementName;
      this.rmanForecastingDetails.customerName = this.rmanDealArrangementsList1[0].endCustomerName;
      this.rmanForecastingDetails.fcCurrency = this.rmanDealArrangementsList1[0].arrangementCurrency;
      this.rmanForecastingDetails.masterArrangementId = this.rmanDealArrangementsList1[0].masterArrgId;
    }

    this.prepareRmanLookupsVObject();
    this.prepareRmanFcConversionTypesObject();
    this.prepareRmanCurrencyObject();
    this.prepareRmanFcBucketsObject();
    this.prepareRmanFcLevelObject();
    this.prepareRmanLookupsV1Object();
    this.prepareRmanFcMethodsObject();

    this.displayAddDialog = true;


  }


  save(rmanForecastingDetails?: any) {
    this.newRmanForecastingDetails = false;
    this.rmanForecastingDetails = this.cloneRmanForecastingDetails(rmanForecastingDetails);

    this.rmanForecastingDetails.fcStartDate = new Date(this.rmanForecastingDetails.fcStartDate);

    if (this.newRmanForecastingDetails) {
      this.loading = true;
      this.rmanForecastingDetailsService.saveRmanForecastingDetails(this.rmanForecastingDetails).then((response: any) => {

        this.getAllRmanForecastingDetails();
      });
    }
    else {
      let enteredAmount: any;
      enteredAmount = Number.parseFloat(this.rmanForecastingDetails.bucket1 != null ? this.rmanForecastingDetails.bucket1 : 0)
        + Number.parseFloat(this.rmanForecastingDetails.bucket2 != null ? this.rmanForecastingDetails.bucket2 : 0)
        + Number.parseFloat(this.rmanForecastingDetails.bucket3 != null ? this.rmanForecastingDetails.bucket3 : 0)
        + Number.parseFloat(this.rmanForecastingDetails.bucket4 != null ? this.rmanForecastingDetails.bucket4 : 0)
        + Number.parseFloat(this.rmanForecastingDetails.bucket5 != null ? this.rmanForecastingDetails.bucket5 : 0)
        + Number.parseFloat(this.rmanForecastingDetails.bucket6 != null ? this.rmanForecastingDetails.bucket6 : 0)
        + Number.parseFloat(this.rmanForecastingDetails.bucket7 != null ? this.rmanForecastingDetails.bucket7 : 0)
        + Number.parseFloat(this.rmanForecastingDetails.bucket8 != null ? this.rmanForecastingDetails.bucket8 : 0)
        + Number.parseFloat(this.rmanForecastingDetails.bucket9 != null ? this.rmanForecastingDetails.bucket9 : 0)
        + Number.parseFloat(this.rmanForecastingDetails.bucket10 != null ? this.rmanForecastingDetails.bucket10 : 0)
        + Number.parseFloat(this.rmanForecastingDetails.bucket11 != null ? this.rmanForecastingDetails.bucket11 : 0)
        + Number.parseFloat(this.rmanForecastingDetails.bucket12 != null ? this.rmanForecastingDetails.bucket12 : 0)
        + Number.parseFloat(this.rmanForecastingDetails.bucket13 != null ? this.rmanForecastingDetails.bucket13 : 0)
        + Number.parseFloat(this.rmanForecastingDetails.bucket14 != null ? this.rmanForecastingDetails.bucket14 : 0)
        + Number.parseFloat(this.rmanForecastingDetails.bucket15 != null ? this.rmanForecastingDetails.bucket15 : 0)
        + Number.parseFloat(this.rmanForecastingDetails.bucket16 != null ? this.rmanForecastingDetails.bucket16 : 0)
        + Number.parseFloat(this.rmanForecastingDetails.bucket17 != null ? this.rmanForecastingDetails.bucket17 : 0)
        + Number.parseFloat(this.rmanForecastingDetails.bucket18 != null ? this.rmanForecastingDetails.bucket18 : 0)
        + Number.parseFloat(this.rmanForecastingDetails.bucket19 != null ? this.rmanForecastingDetails.bucket19 : 0)
        + Number.parseFloat(this.rmanForecastingDetails.bucket20 != null ? this.rmanForecastingDetails.bucket20 : 0)
        + Number.parseFloat(this.rmanForecastingDetails.bucket21 != null ? this.rmanForecastingDetails.bucket21 : 0)
        + Number.parseFloat(this.rmanForecastingDetails.bucket22 != null ? this.rmanForecastingDetails.bucket22 : 0)
        + Number.parseFloat(this.rmanForecastingDetails.bucket23 != null ? this.rmanForecastingDetails.bucket23 : 0)
        + Number.parseFloat(this.rmanForecastingDetails.bucket24 != null ? this.rmanForecastingDetails.bucket24 : 0);

      if (this.rmanForecastingDetails.fcMethodId == 1) {
        if (Number.parseFloat(this.rmanForecastingDetails.amount) != enteredAmount) {
          this.notificationService.showInfo('Entered Amount should be equal to actual amount of ' + this.rmanForecastingDetails.amount);

        } else {
          this.loading = true;
          this.rmanForecastingDetailsService.updateRmanForecastingDetails(this.rmanForecastingDetails).then((response: any) => {

            this.getAllRmanForecastingDetails();
            this.notificationService.showSuccess('Forecasting of data sucessfully updated..!');

          });
        }
      } else if (this.rmanForecastingDetails.fcMethodId == 2) {
        if (enteredAmount != 100) {
          this.notificationService.showInfo('Entered Amount should be equal to 100');

        } else {
          this.loading = true;
          this.rmanForecastingDetailsService.updateRmanForecastingDetails(this.rmanForecastingDetails).then((response: any) => {
            this.getAllRmanForecastingDetails();
            this.notificationService.showSuccess('Forecasting of data sucessfully updated..!');
          });
        }
      } else {
        this.loading = true;
        this.rmanForecastingDetailsService.updateRmanForecastingDetails(this.rmanForecastingDetails).then((response: any) => {

          this.getAllRmanForecastingDetails();
          this.notificationService.showSuccess('Forecasting of data sucessfully updated..!');
        });
      }


    }

    //this.rmanForecastingDetails = new RmanForecastingDetailsImpl();


    this.displayDialog = false;

  }


  delete(rmanForecastingDetails: any) {
    this.rmanForecastingDetails = rmanForecastingDetails;

    //this.rmanForecastingDetails = null;
    this.displayDialog = false;

    if (window.confirm('Are you sure you want to delete this record?')) {
      this.rmanForecastingDetailsList.splice(this.findSelectedRmanForecastingDetailsIndex(), 1);
      this.loading = true;
      this.rmanForecastingDetailsService.deleteRmanForecastingDetails(this.rmanForecastingDetails).then((response: any) => {

        this.rmanForecastingDetails = new RmanForecastingDetailsImpl();
        this.getAllRmanForecastingDetails();
        //this.rmanForecastingDetailsList.splice(this.findSelectedRmanForecastingDetailsIndex(), 1);
        //this.rmanForecastingDetails = null;
        // this.displayDialog = false;
      });
    }

  }

  editRow(rmanForecastingDetails: any) {
    this.newRmanForecastingDetails = false;
    this.rmanForecastingDetails = this.cloneRmanForecastingDetails(rmanForecastingDetails);
    this.displayDialog = true;
    this.prepareRmanLookupsVObject();
    this.prepareRmanFcConversionTypesObject();
    this.prepareRmanCurrencyObject();
    this.prepareRmanFcBucketsObject();
    this.prepareRmanFcLevelObject();
    this.prepareRmanLookupsV1Object();
    this.prepareRmanFcMethodsObject();

  }


  findSelectedRmanForecastingDetailsIndex(): number {
    return this.rmanForecastingDetailsList.indexOf(this.selectedRmanForecastingDetails);
  }

  onRowSelect(event: any) {

  }

  cloneRmanForecastingDetails(c: RmanForecastingDetails): RmanForecastingDetails {
    let rmanForecastingDetails: any
      = new RmanForecastingDetailsImpl();
    for (let prop in c) {
      rmanForecastingDetails[prop] = c[prop];
    }
    return rmanForecastingDetails;
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

    this.rmanForecastingDetailsSearch = new RmanForecastingDetailsImpl();

    if (this.isSerached == 0) {
      this.rmanForecastingDetailsSearch = new RmanForecastingDetailsImpl();
    }
    this.displaySearchDialog = true;

  }

  search() {

    this.isSerached = 1;
    this.rmanForecastingDetails = this.rmanForecastingDetailsSearch;
    this.getAllRmanForecastingDetails();
  }

  prepareRmanLookupsVObject() {
    let rmanLookupsVTempObj: any = [];
    rmanLookupsVTempObj.push({ label: '--Select Apply Allocations--', value: null });
    this.rmanLookupsVList.forEach((rmanLookupsV) => {
      rmanLookupsVTempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
    });

    this.rmanLookupsV = rmanLookupsVTempObj;

  }

  prepareRmanLookupsV2Object() {
    let rmanLookupsV2TempObj: any = [];
    rmanLookupsV2TempObj.push({ label: '--Select Apply Contingencies--', value: null });
    this.rmanLookupsV2List.forEach((rmanLookupsV2) => {
      rmanLookupsV2TempObj.push({ label: rmanLookupsV2.lookupDescription, value: rmanLookupsV2.lookupCode });
    });

    this.rmanLookupsV2 = rmanLookupsV2TempObj;

  }

  prepareRmanFcConversionTypesObject() {
    let rmanFcConversionTypesTempObj: any = [];
    rmanFcConversionTypesTempObj.push({ label: '--Select FC Conversion Type--', value: null });
    this.rmanFcConversionTypesList.forEach((rmanFcConversionTypes) => {
      rmanFcConversionTypesTempObj.push({ label: rmanFcConversionTypes.description, value: rmanFcConversionTypes.conversionType });
    });

    this.rmanFcConversionTypes = rmanFcConversionTypesTempObj;

  }

  prepareRmanCurrencyObject() {
    let rmanCurrencyTempObj: any = [];
    rmanCurrencyTempObj.push({ label: 'Select One', value: null });
    this.rmanCurrencyList.forEach((rmanCurrency) => {
      rmanCurrencyTempObj.push({ label: rmanCurrency.name, value: rmanCurrency.currencyCode });
    });

    this.rmanCurrency = rmanCurrencyTempObj;

  }

  prepareRmanFcBucketsObject() {
    let rmanFcBucketsTempObj: any = [];
    rmanFcBucketsTempObj.push({ label: '--Select FC Bucket ID--', value: null });
    this.rmanFcBucketsList.forEach((rmanFcBuckets) => {
      rmanFcBucketsTempObj.push({ label: rmanFcBuckets.name, value: rmanFcBuckets.bucketId });
    });

    this.rmanFcBuckets = rmanFcBucketsTempObj;

  }

  prepareRmanFcLevelObject() {
    let rmanFcLevelTempObj: any = [];
    rmanFcLevelTempObj.push({ label: '--Select FC Level Name--', value: null });
    this.rmanFcLevelList.forEach((rmanFcLevel) => {
      rmanFcLevelTempObj.push({ label: rmanFcLevel.name, value: rmanFcLevel.levelId });
    });

    this.rmanFcLevel = rmanFcLevelTempObj;

  }

  prepareRmanLookupsV1Object() {
    let rmanLookupsV1TempObj: any = [];
    rmanLookupsV1TempObj.push({ label: 'Select One', value: null });
    this.rmanLookupsV1List.forEach((rmanLookupsV1) => {
      rmanLookupsV1TempObj.push({ label: rmanLookupsV1.lookupDescription, value: rmanLookupsV1.lookupCode });
    });

    this.rmanLookupsV1 = rmanLookupsV1TempObj;

  }

  prepareRmanFcMethodsObject() {
    let rmanFcMethodsTempObj: any = [];
    rmanFcMethodsTempObj.push({ label: '--Select FC Method ID--', value: null });
    this.rmanFcMethodsList.forEach((rmanFcMethods) => {
      rmanFcMethodsTempObj.push({ label: rmanFcMethods.name, value: rmanFcMethods.fcMethodId });
    });

    this.rmanFcMethods = rmanFcMethodsTempObj;

  }

  prepareRmanDealArrangementsObject() {
    let rmanDealArrangementsTempObj: any = [];
    rmanDealArrangementsTempObj.push({ label: '--Select Arrangement ID-- ', value: null });
    this.rmanDealArrangementsList.forEach((rmanDealArrangements) => {
      rmanDealArrangementsTempObj.push({ label: rmanDealArrangements.dealArrangementId, value: rmanDealArrangements.dealArrangementId });
    });
    this.rmanDealArrangements = rmanDealArrangementsTempObj;
  }

  prepareRmanDealArrangementsObject1() {
    let rmanDealArrangementsTempObj: any = [];
    rmanDealArrangementsTempObj.push({ label: '--Select Arrangement Name--', value: null });
    this.rmanDealArrangementsList.forEach((rmanDealArrangements) => {
      rmanDealArrangementsTempObj.push({ label: rmanDealArrangements.dealArrangementName, value: rmanDealArrangements.dealArrangementName });
    });
    this.rmanDealArrangements1 = rmanDealArrangementsTempObj;
  }

  onBeforeToggle(evt: any) {
    this.collapsed = evt.collapsed;
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

  onbuckeutPeriodHeader(i: any, rmanlist: any[]) {
    let rmanForecastingDetailsList2: any[];
    rmanForecastingDetailsList2 = rmanlist;
    rmanForecastingDetailsList2 = this.removeDuplicate(rmanForecastingDetailsList2, 'bucket' + i + 'Period');

    if (rmanForecastingDetailsList2.length > 0) {
      switch (i) {
        case 1: {
          this.b1period = rmanForecastingDetailsList2[0].bucket1Period;
          break;
        }
        case 2: {
          this.b2period = rmanForecastingDetailsList2[0].bucket2Period;
          break;
        }
        case 3: {
          this.b3period = rmanForecastingDetailsList2[0].bucket3Period;
          break;
        }
        case 4: {
          this.b4period = rmanForecastingDetailsList2[0].bucket4Period;
          break;
        }
        case 5: {
          this.b5period = rmanForecastingDetailsList2[0].bucket5Period;
          break;
        }
        case 6: {
          this.b6period = rmanForecastingDetailsList2[0].bucket6Period;
          break;
        }
        case 7: {
          this.b7period = rmanForecastingDetailsList2[0].bucket7Period;
          break;
        }
        case 8: {
          this.b8period = rmanForecastingDetailsList2[0].bucket8Period;
          break;
        }
        case 9: {
          this.b9period = rmanForecastingDetailsList2[0].bucket9Period;
          break;
        }
        case 10: {
          this.b10period = rmanForecastingDetailsList2[0].bucket10Period;
          break;
        }
        case 11: {
          this.b11period = rmanForecastingDetailsList2[0].bucket11Period;
          break;
        }
        case 12: {
          this.b12period = rmanForecastingDetailsList2[0].bucket12Period;
          break;
        }
        case 13: {
          this.b13period = rmanForecastingDetailsList2[0].bucket13Period;
          break;
        }
        case 14: {
          this.b14period = rmanForecastingDetailsList2[0].bucket14Period;
          break;
        }
        case 15: {
          this.b15period = rmanForecastingDetailsList2[0].bucket15Period;
          break;
        }
        case 16: {
          this.b16period = rmanForecastingDetailsList2[0].bucket16Period;
          break;
        }
        case 17: {
          this.b17period = rmanForecastingDetailsList2[0].bucket17Period;
          break;
        }
        case 18: {
          this.b18period = rmanForecastingDetailsList2[0].bucket18Period;
          break;
        }
        case 19: {
          this.b19period = rmanForecastingDetailsList2[0].bucket19Period;
          break;
        }
        case 20: {
          this.b20period = rmanForecastingDetailsList2[0].bucket20Period;
          break;
        }
        case 21: {
          this.b21period = rmanForecastingDetailsList2[0].bucket21Period;
          break;
        }
        case 22: {
          this.b22period = rmanForecastingDetailsList2[0].bucket22Period;
          break;
        }
        case 23: {
          this.b23period = rmanForecastingDetailsList2[0].bucket23Period;
          break;
        }
        case 24: {
          this.b24period = rmanForecastingDetailsList2[0].bucket24Period;
          break;
        }
      }
    }

  }

  onChangeArrgId(arrId: any) {
    this.loading = true;
    this.rmanDealArrangementsService.getAllRmanDealArrangements(this.paginationOptions, { 'dealArrangementId': arrId }).then((rmanDealArrangementsList: any) => {
      this.loading = false;
      this.rmanDealArrangementsList = rmanDealArrangementsList.content.filter((item: any) => item.dealArrangementId == arrId, true);

      this.rmanDealArrangementsList = this.removeDuplicate(this.rmanDealArrangementsList, 'dealArrangementId');

      this.rmanForecastingDetails.arrangementName = this.rmanDealArrangementsList[0].dealArrangementName;
      this.rmanForecastingDetails.customerName = this.rmanDealArrangementsList[0].endCustomerName;
      this.rmanForecastingDetails.fcCurrency = this.rmanDealArrangementsList[0].arrangementCurrency;
      this.rmanForecastingDetails.masterArrangementId = this.rmanDealArrangementsList[0].masterArrgId;
    });
  }
  onChangeArrgName(arrName: any) {
    this.loading = true;
    this.rmanDealArrangementsService.getAllRmanDealArrangements(this.paginationOptions, { 'dealArrangementName': arrName }).then((rmanDealArrangementsList: any) => {
      this.loading = false;
      this.rmanDealArrangementsList = rmanDealArrangementsList.content.filter((item: any) => item.dealArrangementName == arrName, true);

      this.rmanDealArrangementsList = this.removeDuplicate(this.rmanDealArrangementsList, 'dealArrangementId');

      this.rmanForecastingDetails.arrangementId = this.rmanDealArrangementsList[0].dealArrangementId;
      this.rmanForecastingDetails.customerName = this.rmanDealArrangementsList[0].endCustomerName;
      this.rmanForecastingDetails.fcCurrency = this.rmanDealArrangementsList[0].arrangementCurrency;
      this.rmanForecastingDetails.masterArrangementId = this.rmanDealArrangementsList[0].masterArrgId;

    });
  }

  updateFCSTD(rmanForecastingDetails: any[]) {
    this.loading = true;
    this.rmanForecastingDetailsService.updateRFCSTDetails(rmanForecastingDetails).then(response => {
      this.loading = false;
    }).catch(err => {
    });
  }

  showFCD(rmanForecastingDetails: any) {
    this.displayTable = false;
    this.loading = true;
    this.rmanForecastingDetailsService.showFCDetails(rmanForecastingDetails).then(response => {
      this.loading = false;
    });
    this.loading = true;
    this.rmanForecastingDetailsService.getAllRmanForecastingDetails(this.paginationOptions, { 'arrangementId': rmanForecastingDetails.arrangementId }).then((rmanForecastingDetailsList2: any) => {
      this.loading = false;

      this.rmanForecastingDetailsList2 = rmanForecastingDetailsList2.content;
      var n: any;
      for (n = 1; n <= 24; n++) {
        this.onbuckeutPeriodHeader(n, this.rmanForecastingDetailsList2);
      }
    });
    this.notificationService.showSuccess('Saved successfully');
    this.getAllRmanForecastingDetails();
    this.displayAddDialog = false;
    this.displayTable = true;
  }

}


class RmanForecastingDetailsImpl {
  constructor(public bucket18?: any, public applyContingencies?: any, public bucket17?: any, public createdDate?: any, public bucket9Period?: any, public bucket3Period?: any, public bucket4Period?: any, public bucket5Period?: any, public bucket6Period?: any, public bucket7Period?: any, public bucket8Period?: any, public bucket19?: any, public level1Name?: any, public future?: any, public productOrgId?: any, public bucket1Period?: any, public amount?: any, public bucket2Period?: any, public bucket14?: any, public bucket13?: any, public expectedStartDate?: any, public level5Value?: any, public bucket16?: any, public bucket15?: any, public bucket10?: any, public type?: any, public bucket12?: any, public bucket11?: any, public createdBy?: any, public lastUpdatedBy?: any, public bucket18Period?: any, public arrangementId?: any, public bucket4?: any, public level4Value?: any, public level5Name?: any, public bucket5?: any, public bucket21Period?: any, public bucket2?: any, public bucket3?: any, public bucket8?: any, public bucket9?: any, public applyAllocations?: any, public level2Name?: any, public bucket6?: any, public bucket12Period?: any, public bucket14Period?: any, public bucket16Period?: any, public bucket7?: any, public bucket10Period?: any, public bucket24?: any, public bucket21?: any, public bucket1?: any, public bucket20?: any, public bucket23Period?: any, public bucket23?: any, public level1Value?: any, public bucket22?: any, public fcBucketId?: any, public remainingAmount?: any, public level4Name?: any, public fcCurrency?: any, public fcConversionType?: any, public level3Value?: any, public remainingFutureFlag?: any, public arrangementName?: any, public fcStartDate?: any, public fcMethodId?: any, public expectedSplit?: any, public level3Name?: any, public bucket19Period?: any, public level2Value?: any, public expectedDuration?: any, public masterArrangementId?: any, public bucketType?: any, public bucket13Period?: any, public lastUpdatedDate?: any, public bucket22Period?: any, public shipmentDelay?: any, public customerName?: any, public bucket11Period?: any, public bucket15Period?: any, public inoviceDelay?: any, public expectedEndDate?: any, public bookingDelay?: any, public bucket17Period?: any, public fcLevelName?: any, public bucket20Period?: any, public bucket24Period?: any) { }
}

interface ILabels {
  [index: string]: string;
}
