import { ChangeDetectorRef, Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NavigationEnd, Router } from "@angular/router";
import { Message } from 'primeng/api';
import { ConfirmationService } from 'primeng/api';
import { Table } from 'primeng/table';
import { RmanDealArrangementsImpl } from '../rmanDealArrangements/rmanDealArrangements.component';
import { RmanDealArrangementsService } from '../rmanDealArrangements/rmanDealArrangementsservice';
import { RmanDealDetailsComponent } from '../rmanDealDetails/rmanDealDetails.component';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { ContractHeadersInfoV } from './contractHeadersInfoV';
import { ContractHeadersInfoVService } from './contractHeadersInfoVservice';


declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
  templateUrl: './contractHeadersInfoV.component.html',
  selector: 'contractHeadersInfoV-data',
  providers: [ContractHeadersInfoVService, ConfirmationService]
})

export class ContractHeadersInfoVComponent implements OnInit {

  displayDialog: boolean;

  displaySearchDialog: boolean;

  pDealHeaderId: any;

  arrIdK: any;

  msgs: Message[];

  contractHeadersInfoV: any = new ContractHeadersInfoVImpl();

  contractHeadersInfoVSearch: any = new ContractHeadersInfoVImpl();

  newRmanDealHeaders: boolean;

  isSerached: number = 0;

  contractsForm: FormGroup;

  selectedContractHeadersInfoV: ContractHeadersInfoV;

  newContractHeadersInfoV: boolean;

  contractHeadersInfoVList: any[] = [];

  selectedContracts: any[] = [];

  rmanDealHeadersList: any[] = [];

  rmanDealArrangementsList: any[] = [];

  rmanDealArrangements: any = new RmanDealArrangementsImpl();

  rmanDealArrangementsObj: any;
  noData = appSettings.noData;

  cols: any[];
  columns: any[];
  dealColumns: ILabels;

  columnOptions: any[];

  paginationOptions: any;

  pages: {};

  cref: ChangeDetectorRef;

  datasource: any[];
  pageSize: number;
  totalElements: number;

  collapsed: boolean = true;
  loading: boolean;

  showAddColumns = true;
  isSelectAllChecked = true;


  globalCols: any[];
  clonedCols: any[];

  userId: number;
  showPaginator: boolean = true;
  startIndex: number;

  exportCols: string[] = [];
  disableExport: boolean = true;
  displaySplitDialog: boolean = false;
  flag: any;
  mergeFlag: any;

  selectedContract: ContractHeadersInfoV;
  rmanDealArrangementsSearch: any = new RmanDealArrangementsImpl();
  totalArrgElements: number;
  selectedArrangement: RmanDealArrangementsImpl = new RmanDealArrangementsImpl();
  targetDealArrangementId: any;
  displayMergeDialog: boolean = false;
  mergeSelection: boolean = false;



  @ViewChild(RmanDealDetailsComponent) private childTable: RmanDealDetailsComponent;


  constructor(private ref: ChangeDetectorRef, private formBuilder: FormBuilder,
    private rmanDealArrangementsService: RmanDealArrangementsService, private contractHeadersInfoVService: ContractHeadersInfoVService,
    private router: Router, private commonSharedService: CommonSharedService, private notificationService: NotificationService, private confirmationService: ConfirmationService) {
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.arrIdK = event.url.split('/')[3];
      }
    });

    this.cref = ref;
    this.loading = true;
    this.rmanDealArrangementsService.getAllRmanDealArrangements(this.paginationOptions, { 'dealArrangementId': this.arrIdK }).then((rmanDealArrangementsList: any) => {
      this.loading = false;
      this.disableExport = false;
      this.rmanDealArrangementsList = rmanDealArrangementsList.content;
    });
  }

  ngAfterViewChecked() {
  }

  ngOnInit() {

    this.globalCols = [
      { field: 'dealNumber', header: 'Contract/Deal#', showField: true, display: "table-cell", type: 'number', drag: false },
      { field: 'dealName', header: 'Contract/Deal Name', showField: true, display: "table-cell", type: 'text', drag: false },
      { field: 'agreementNumber', header: 'Agreement#', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'agreementName', header: 'Agreement Name', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'opportunityNum', header: 'Opportunity #', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'opportunityName', header: 'Opportunity Name', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'endCustomerName', header: 'Customer Name', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'salesChannel', header: 'Sales Channel', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'dealCurrencyCode', header: 'Currency', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'dealAmount', header: 'Amount', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'createdDate', header: 'Created Date', showField: true, display: "table-cell", type: 'date', drag: true },
      { field: 'additionalInfo1', header: 'Project Number', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'priceList', header: 'Price List', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'po', header: 'PO', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'groupingRuleName', header: 'Grouping Rule Name', showField: true, display: "table-cell", type: 'text', drag: true }
    ];
    this.columns = [];
    this.getTableColumns("contractsHeadersInfoV", "Contracts");
    this.buildForm();
  }

  getTableColumns(pageName: string, tableName: string) {
    this.isSelectAllChecked = true;
    this.commonSharedService.getConfiguredColDetails(pageName, tableName).then((response) => {
      if (response && response != null && response.userId) {
        this.columns = [];
        let colsList = response.tableColumns.split(",");
        if (colsList.length > 0) {
          colsList.forEach((item, index) => {
            if (item) {
              this.startIndex = this.globalCols.findIndex(col => col.field == item);
              this.onDrop(index);
            }
          });
        }
        this.globalCols.forEach(col => {
          if (response.tableColumns.indexOf(col.field) !== -1) {
            this.columns.push(col);
          } else {
            col.showField = false;
          }
        });
        if (this.columns.length != this.globalCols.length) this.isSelectAllChecked = false;
        this.showPaginator = this.columns.length !== 0;
        this.userId = response.userId;
      } else {
        this.columns = this.globalCols;
      }
    }).catch(() => {
      this.notificationService.showError('Error occured while getting table columns data');
      this.loading = false;
    });
  }

  saveColumns() {
    let selectedCols = "";
    this.showAddColumns = !this.showAddColumns;
    const colLength = this.globalCols.length - 1;
    this.globalCols.forEach((col, index) => {
      if (col.showField) {
        selectedCols += col.field;
        if (index < colLength) {
          selectedCols += ",";
        }
      }
    });
    this.loading = true;
    this.commonSharedService.saveOrUpdateTableColumns("contractsHeadersInfoV", "Contracts", selectedCols, this.userId).then((response) => {
      this.columns = this.globalCols.filter(item => item.showField);
      this.userId = response["userId"];
      this.showPaginator = this.columns.length !== 0;
      this.loading = false;
    }).catch(() => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }

  onDragStart(index: number) {
    this.startIndex = index;
  }

  onDrop(dropIndex: number) {
    const general = this.globalCols[this.startIndex]; // get element
    this.globalCols.splice(this.startIndex, 1);       // delete from old position
    this.globalCols.splice(dropIndex, 0, general);    // add to new position
  }

  selectColumns(col: any) {
    let cols = this.globalCols.filter(item => !item.showField);
    if (cols.length > 0) {
      this.isSelectAllChecked = false;
    } else {
      this.isSelectAllChecked = true;
    }
  }

  onSelectAll() {
    this.isSelectAllChecked = !this.isSelectAllChecked;
    this.globalCols.forEach(col => {
      if (this.isSelectAllChecked) {
        col.showField = true;
      } else {
        if (col.drag) {
          col.showField = false;
        }
      }
    });
  }

  showSplitOptions() {
    if (this.dealHeaderIds.length == 0) {
      this.notificationService.showError("Please select a contract to process split functionality")
    } else {
      this.displaySplitDialog = true;
    }
  }

  showMergeOptions() {
    if (this.dealHeaderIds.length == 0) {
      this.notificationService.showError("Please select a contract to process merge functionality")
    } else {
      this.mergeSelection = true;
    }
  }

  splitCancel() {
    this.displaySplitDialog = false;
    this.flag = null;
  }

  mergeCancel() {
    this.mergeSelection = false;
    this.mergeFlag = null;
  }

  splitProcess() {
    this.confirmationService.confirm({
      message: 'Are you sure want to Split?',
      header: 'Confirmation',
      icon: '',
      accept: () => {
        this.displaySplitDialog = false;
        this.loading = true;
        this.contractHeadersInfoVService.splitProcess(this.arrIdK, this.dealHeaderIds, this.flag).then((response: any) => {
          this.loading = false;
          if (response == null || response == undefined) {
            this.notificationService.showError("Split Processed Failed");
          } else {
            if (response.status == 'N') {
              this.notificationService.showSuccess("Split Processed Succesfully and target Revenue contract number is " + response.targetArrangementId)
              this.getAllContractHeadersInfoV();
            } else if (response.status == 'Y') {
              this.notificationService.showError("Split Process Failed due to: " + response.message);
            }
          }
          this.flag = null;
        }).catch((err: any) => {
          this.loading = false;
          this.notificationService.showError('Split Process Failed due to ' + err);
        })
      },
      reject: () => {
        this.notificationService.showWarning('You have rejected');
      }
    });
  }


  mergeProcess(targetDealArrangementId: any) {
    //console.log(targetDealArrangementId);
    if (targetDealArrangementId) {
      this.confirmationService.confirm({
        message: 'Are you sure want to Merge?',
        header: 'Confirmation',
        icon: '',
        accept: () => {
          this.displayMergeDialog = false;
          this.loading = true;
          this.contractHeadersInfoVService.mergeProcess(this.arrIdK, this.dealHeaderIds, targetDealArrangementId, this.mergeFlag).then((response: any) => {
            this.loading = false;
            if (response == null || response == undefined) {
              this.notificationService.showError("Merge Processed Failed");
            } else {
              if (response.status == 'N') {
                this.notificationService.showSuccess("Merge Processed Succesfully")
                this.getAllContractHeadersInfoV();
              } else if (response.status == 'Y') {
                this.notificationService.showError("Merge Process Failed due to: " + response.message);
              }
            }
            this.mergeFlag = null;
           
          }).catch((err: any) => {
            this.loading = false;
            this.notificationService.showError('Merge Process Failed due to ' + err);
          })
        },
        reject: () => {
          this.notificationService.showWarning('You have rejected');
        }
      });
    } else {
      this.notificationService.showError('Select Target Revenue Contract');
    }
   
  }

  cancelMergeProcess() {
    this.displayMergeDialog = false;
    this.mergeFlag = null;
  }

  exportExcel() {

    this.exportCols = [];
    for (let index = 0; index < this.columns.length; index++) {
      if (this.columns[index].showField) {
        this.exportCols.push(this.columns[index].field);
      }
    }
    let serviceUrl = this.contractHeadersInfoVService.getServiceUrl(this.paginationOptions, this.contractHeadersInfoV, this.exportCols, 1);
    window.location.href = serviceUrl;
  }

  reset(dt: Table) {
    this.paginationOptions = {};
    this.contractHeadersInfoV = new ContractHeadersInfoVImpl();
    dt.reset();
  }

  onConfiguringColumns(event: any) {
    this.clonedCols = JSON.parse(JSON.stringify(this.globalCols));
    this.showAddColumns = false;
  }

  closeConfigureColumns(event: any) {
    this.showAddColumns = true;
    this.globalCols = this.clonedCols;
    let configCol = this.globalCols.filter(item => !item.showField);
    this.isSelectAllChecked = !(configCol.length > 0);
  }

  buildForm() {
    this.contractsForm = this.formBuilder.group({
      'dealNumber': ['', [Validators.required]],
      'dealType': ['', [Validators.required]],
      'dealName': ['', [Validators.required]],
      'dealCurrencyCode': ['', [Validators.required]],
      'priceList': ['', [Validators.required]],
    });

    this.contractsForm.valueChanges
      .subscribe(data => this.onValueChanged(data));

    this.onValueChanged();
  }

  onValueChanged(data?: any) {
    if (!this.contractsForm) { return; }
    const form = this.contractsForm;

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
    'dealNumber': '', 'dealType': '', 'dealName': '', 'dealCurrencyCode': '', 'priceList': ''
  };

  validationMessages = {
    'dealNumber': {
      'required': "Deal Number is required"
    },
    'dealType': {
      'required': "Deal Type is required"
    },
    'dealName': {
      'required': "Deal Name is Required"
    },
    'dealCurrencyCode': {
      'required': "Deal Currency Code is required"
    },
    'priceList': {
      'required': "Price List is required",
    }
  }

  getAllContractHeadersInfoV() {
    this.loading = true;
    this.contractHeadersInfoV.dealArrangementId = this.arrIdK;
    this.contractHeadersInfoVService.getAllContractHeadersInfoV(this.paginationOptions, this.contractHeadersInfoV, this.exportCols).then((contractHeadersInfoVList: any) => {
      this.loading = false;
      this.datasource = contractHeadersInfoVList.content;
      this.contractHeadersInfoVList = contractHeadersInfoVList.content;
      if (this.contractHeadersInfoVList.length > 0) {
        /*Begining of Code used for default First Row Selected*/
         this.selectedContractHeadersInfoV = this.contractHeadersInfoVList[0];
         this.pDealHeaderId = this.selectedContractHeadersInfoV.dealHeaderId;

         this.dealHeaderIds = [];
         if (this.dealHeaderIds.indexOf(this.pDealHeaderId) == -1) {
          this.dealHeaderIds.push(this.pDealHeaderId);
        }
       // console.log( this.dealHeaderIds);
         this.childTable.parentCall(this.selectedContractHeadersInfoV);
        /*End of Code used for default First Row Selected*/
      } else {
        this.childTable.parentCall('');
      }
      this.totalElements = contractHeadersInfoVList.totalElements;
      this.pageSize = contractHeadersInfoVList.size;
      this.displaySearchDialog = false;
    }).catch((err: any) => {
      this.loading = false;
      this.notificationService.showError('Network failed or service is down');
    });
  }


  getContractHeadersInfoV(event: any) {

    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loading = true;
    this.contractHeadersInfoV.dealArrangementId = this.arrIdK;
    this.contractHeadersInfoVService.getAllContractHeadersInfoV(this.paginationOptions, this.contractHeadersInfoV, this.exportCols).then((contractHeadersInfoVList: any) => {
      this.loading = false;
      this.datasource = contractHeadersInfoVList.content;
      this.contractHeadersInfoVList = contractHeadersInfoVList.content;
      if (this.contractHeadersInfoVList.length > 0) {
        /*Begining of Code used for default First Row Selected*/
         this.selectedContractHeadersInfoV = this.contractHeadersInfoVList[0];
         this.pDealHeaderId = this.selectedContractHeadersInfoV.dealHeaderId;
        this.dealHeaderIds = [];
         if (this.dealHeaderIds.indexOf(this.pDealHeaderId) == -1) {
          this.dealHeaderIds.push(this.pDealHeaderId);
          }

        this.childTable.parentCall(this.selectedContractHeadersInfoV);
        /*End of Code used for default First Row Selected*/
      }
      this.totalElements = contractHeadersInfoVList.totalElements;
      this.pageSize = contractHeadersInfoVList.size;
    }).catch((err: any) => {
      this.loading = false;
      this.notificationService.showError('Network failed or service is down');
    });
  }

  delete(contractHeadersInfoV: any) {
    this.contractHeadersInfoV = contractHeadersInfoV;
    this.displayDialog = false;
    if (window.confirm('Are you sure you want to delete this record?')) {
      this.contractHeadersInfoVList.splice(this.findSelectedContractHeadersInfoVIndex(), 1);
      this.loading = true;
      this.contractHeadersInfoVService.deleteContractHeadersInfoV(this.contractHeadersInfoV).then((response: any) => {
        this.contractHeadersInfoV = new ContractHeadersInfoVImpl();
        this.getAllContractHeadersInfoV();
      });
    }

  }

  editRow(contractHeadersInfoV: any) {
    this.newContractHeadersInfoV = false;
    this.contractHeadersInfoV = this.cloneContractHeadersInfoV(contractHeadersInfoV);
    this.displayDialog = true;

  }

  findSelectedContractHeadersInfoVIndex(): number {
    return this.contractHeadersInfoVList.indexOf(this.selectedContractHeadersInfoV);
  }

  dealHeaderIds: any[] = [];

  onRowSelect(event: any) {
    this.dealHeaderIds = [];
    this.selectedContractHeadersInfoV = event.data;
    this.pDealHeaderId = this.selectedContractHeadersInfoV.dealHeaderId;
    this.dealHeaderIds.push(this.pDealHeaderId);
    this.childTable.parentCall(event.data);
    //console.log( this.dealHeaderIds);

    //below code is for multiple selection of contracts
    /*this.selectedContract = event.data;
    console.log("selection: " + event.data);
    if (this.dealHeaderIds.indexOf(this.selectedContract.dealHeaderId) == -1) {
      this.dealHeaderIds.push(this.selectedContract.dealHeaderId);
    }
    console.log(this.dealHeaderIds);
    this.childTable.parentCall(event.data);
    //console.log(this.selectedContracts);*/
  }

  onRowUnSelect(event: any) {
    //below code is for multiple selection of contracts
    /*console.log("unselected: " + event.data);
    this.selectedContract = event.data;
    var index = this.dealHeaderIds.indexOf(this.selectedContract.dealHeaderId);
    if (index != -1) {
      this.dealHeaderIds.splice(index, 1);
    }
    console.log(this.dealHeaderIds);
     this.childTable.parentCall('');*/
     this.dealHeaderIds=[];
    this.childTable.parentCall('');
  }



  selectAll(checkValue, data) {
    this.dealHeaderIds = [];
    if (checkValue) {
      this.dealHeaderIds = [];
      for (var i = 0; i < data.length; i++) {
        this.dealHeaderIds.push(data[i].dealHeaderId);
      }
    }
  }

  selectSingle(checkValue, data) {
    var index = this.dealHeaderIds.indexOf(data.dealHeaderId);
    if (checkValue) {
      if (index == -1) {
        this.dealHeaderIds.push(data.dealHeaderId);
      }
    } else {
      if (index != -1) {
        this.dealHeaderIds.splice(index, 1);
      }
    }
  }

  cloneContractHeadersInfoV(c: ContractHeadersInfoV): ContractHeadersInfoV {
    let contractHeadersInfoV: any = new ContractHeadersInfoVImpl();
    for (let prop in c) {
      contractHeadersInfoV[prop] = c[prop];
    }
    return contractHeadersInfoV;
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

    this.contractHeadersInfoVSearch = new ContractHeadersInfoVImpl();
    if (this.isSerached == 0) {
      this.contractHeadersInfoVSearch = new ContractHeadersInfoVImpl();
    }
    this.displaySearchDialog = true;

  }

  search() {

    this.isSerached = 1;
    this.contractHeadersInfoV = this.contractHeadersInfoVSearch;
    this.paginationOptions = {};
    this.getAllContractHeadersInfoV();
  }

  onBeforeToggle(evt: any) {
    this.collapsed = evt.collapsed;
  }

  searchArrangements() {
    this.rmanDealArrangements = this.rmanDealArrangementsSearch;
    this.getAllRmanDealArrangements();
  }

  resetArrangements() {
    this.paginationOptions = {};
    this.rmanDealArrangements = new RmanDealArrangementsImpl();
    this.rmanDealArrangementsSearch.dealArrangementName = '';
    this.rmanDealArrangementsSearch.dealArrangementNumber = '';
    this.getAllRmanDealArrangements();
  }

  getAllRmanDealArrangements() {
    this.loading = true;
    this.rmanDealArrangementsService.getAllRmanDealArrangements(this.paginationOptions, this.rmanDealArrangements).then((rmanDealArrangementsList: any) => {
      this.datasource = rmanDealArrangementsList.content;
      this.rmanDealArrangementsList = this.datasource.filter((item: any) => {
        return (item.dealArrangementId != this.arrIdK);
      })
      this.totalArrgElements = rmanDealArrangementsList.totalElements;
      this.pageSize = rmanDealArrangementsList.size;
      this.displaySearchDialog = false;
      this.loading = false;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }

  getRmanDealArrangements(event: any) {
    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loading = true;
    this.rmanDealArrangementsService.getAllRmanDealArrangements(this.paginationOptions, this.rmanDealArrangements).then((rmanDealArrangementsList: any) => {

      this.datasource = rmanDealArrangementsList.content;
      this.rmanDealArrangementsList = rmanDealArrangementsList.content.filter((item: any) => {
        return item.dealArrangementId != this.arrIdK;
      })
      this.totalArrgElements = rmanDealArrangementsList.totalElements;
      this.pageSize = rmanDealArrangementsList.size;
      this.loading = false;

    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }

  onRowArrgSelect(event: any) {
    this.selectedArrangement = event.data;
    this.targetDealArrangementId = this.selectedArrangement.dealArrangementId;
  }

  showMergeDialog() {
    this.mergeSelection = false;
    this.displayMergeDialog = true;
  }

}


class ContractHeadersInfoVImpl {
  constructor(public agreementName?: any, public endCustomerName?: any, public additionalInfo1?: any, public additionalInfo2?: any, public createdDate?: any, public priceList?: any, public dealHeaderId?: any, public dealAmount?: any, public dealType?: any, public salesChannel?: any, public dealArrangementId?: any, public dealStatus?: any, public agreementNumber?: any, public billToCountry?: any, public opportunityNum?: any, public dealCurrencyCode?: any, public opportunityName?: any, public endCustomerNum?: any, public shipToCountry?: any, public dealNumber?: any, public billToCustomerName?: any, public dealName?: any, public groupingRuleName?: any, public po?: any) { }
}

interface ILabels {
  [index: string]: string;
}
