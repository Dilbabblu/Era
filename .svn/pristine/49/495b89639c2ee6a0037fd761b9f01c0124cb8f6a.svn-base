import { DatePipe } from '@angular/common';
import { Component, ComponentFactoryResolver, ComponentRef, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { Message } from 'primeng/api';
import { Table } from 'primeng/table';
import { Subscription } from 'rxjs';
import { ArrangementManagerSharedService } from '../arrangementManager/arrangementManager-shared.service';
import { DealArrangementComponent } from '../dealArrangements/dealArrangement.component';
import { RmanContHeaderService } from '../rmanContHeader/rmanContHeaderservice';
import { RmanCurrencyService } from '../rmanCurrency/rmanCurrencyservice';
import { RmanCustomersService } from '../rmanCustomers/rmanCustomersservice';
import { RmanDealArrangementsService } from '../rmanDealArrangements/rmanDealArrangementsservice';
import { RmanLegalEntitiesService } from '../rmanLegalEntities/rmanLegalEntitiesservice';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { RmanUsersService } from '../rmanUsers/rmanUsersservice';
import { AdCmDirective } from '../shared/ad-cm.directive';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { UploadService } from '../shared/upload.service';
import { RmanArrangementsAllV } from './rmanArrangementsAllV';
import { RmanArrangementsAllVService } from './rmanArrangementsAllVservice';


declare var require: any;

declare var $: any;

const appSettings = require('../appsettings');

@Component({
  templateUrl: './rmanArrangementsAllV.component.html',
  selector: 'rmanArrangementsAllV-data',
  providers: [RmanArrangementsAllVService, RmanLegalEntitiesService, RmanLookupsVService, RmanUsersService, RmanCustomersService, RmanCurrencyService, RmanDealArrangementsService, RmanContHeaderService],
  entryComponents: [DealArrangementComponent]
})

export class RmanArrangementsAllVComponent implements OnInit, OnDestroy {

  checked: boolean = false;
  appSettingsUrl: string = appSettings.uploadUrl;
  displayDealDialog: boolean = false;
  displayDealDataDialog: boolean = false;
  displayPBDialog: boolean = false;
  displaySelectMode: boolean = false;
  displayshipmentsDialog: boolean = false;
  smode: string;
  displayDialog: boolean;
  arrgTotal: any;
  _dataTable: any;

  pDealType: any = 'New';

  displaySearchDialog: boolean;
  displayInvDialog: boolean;
  displayQuotesDialog: boolean;

  msgs: Message[];

  rmanArrangementsAllV: any = new RmanArrangementsAllVImpl();

  rmanArrangementsAllVSearch: any = new RmanArrangementsAllVImpl();

  isSerached: number = 0;

  selectedRmanArrangementsAllV: RmanArrangementsAllV;

  newRmanArrangementsAllV: boolean;

  rmanArrangementsAllVList: any[];

  columns: any[];
  globalCols: any[];
  clonedCols: any[];
  rmanSearchObj: any = new RmanArrangementsAllVImpl();
  columnOptions: any[];
  paginationOptions: any;
  pages: {};
  datasource: any[];
  pageSize: number;
  totalElements: number;
  uploadedFiles: any[] = [];
  rmanLegalEntitiesList: any[] = [];
  rmanLegalEntities: any[];
  rmanLookupsVList: any[] = [];
  rmanLookupsV: any[];
  rmanLookupsV1List: any[] = [];
  rmanLookupsV1: any[];
  rmanUsersList: any[] = [];
  rmanUsers: any[];
  rmanLookupsV2List: any[] = [];
  rmanLookupsV2: any[];
  rmanUsers1List: any[] = [];
  rmanUsers1: any[];
  rmanUsers2List: any[] = [];
  rmanUsers2: any[];
  rmanLookupsV3List: any[] = [];
  rmanLookupsV3: any[];
  rmanCustomersList: any[] = [];
  rmanCustomers: any[];
  rmanLookupsV4List: any[] = [];
  rmanLookupsV4: any[];
  rmanLookupsV5List: any[] = [];
  rmanLookupsV5: any[];
  rmanLookupsV6List: any[] = [];
  rmanLookupsV6: any[];
  rmanLookupsV7List: any[] = [];
  rmanLookupsV7: any[];
  rmanLookupsV8List: any[] = [];
  rmanLookupsV8: any[];
  rmanLookupsV9List: any[] = [];
  rmanLookupsV9: any[];
  rmanLookupsV10List: any[] = [];
  rmanLookupsV10: any[];
  rmanLookupsV11List: any[] = [];
  rmanLookupsV11: any[];
  rmanLookupsV12List: any[] = [];
  rmanLookupsV12: any[];
  rmanCurrencyList: any[] = [];
  rmanCurrency: any[];
  rmanContHeaderList: any[] = [];
  rmanContHeader: any[];
  rmanDealArrangementsList: any[] = [];
  rmanDealArrangements: any[];
  collapsed: boolean = true;
  noData = appSettings.noData;
  loading: boolean;
  uploadLoading: boolean;
  isReadOnly: boolean;
  cmode: boolean = false;
  ref: ComponentRef<any>;
  @ViewChild(AdCmDirective) adCm: AdCmDirective;
  @ViewChild('dt') table: Table;
  subscription1: Subscription;
  subscription2: Subscription;
  subscription3: Subscription;
  subscription4: Subscription;
  subscription5: Subscription;

  startDate: any;
  endDate: any;

  modStartDate: any;
  modEndDate: any;

  isSearch: boolean = true;
  globalSearch: any;
  isToggled = false;
  searchString: any

  sortField: string;
  sortOrder: string;
  displayAdvancedSearch = false;
  isSelectAllChecked = true;
  showAddColumns = true;
  exportCols: string[] = [];
  searched = false;
  userId: number;
  showPaginator: boolean = true;
  startIndex: number;
  disableExport: boolean = true;
  displayContRelDialog: boolean;

  constructor(private sharedService: ArrangementManagerSharedService, private componentFactoryResolver: ComponentFactoryResolver, private rmanArrangementsAllVService: RmanArrangementsAllVService, private rmanLookupsVService: RmanLookupsVService, private rmanUsersService: RmanUsersService,
    private rmanContHeaderService: RmanContHeaderService,
    private commonSharedService: CommonSharedService, public datepipe: DatePipe, private notificationService: NotificationService,
    public _uploadService: UploadService) {

    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000', 'sortField': 'arrangementNumber', 'sortOrder': 'desc' };

    this.subscription1 = this.sharedService.getNotifyFlag().subscribe((data: any) => {
      this.getFlag(data);
    });
    this.subscription2 = this.sharedService.getNotifyErrorFlag().subscribe((data: any) => {
      this.getErrorFlag(data);
    });
    this.subscription3 = this.sharedService.getNotifyParent().subscribe((data: any) => {
      this.getNotification(data);
    });

    this.subscription5 = this.commonSharedService.getRole().subscribe(res => {
    });

  }



  ngOnInit() {

    this.globalCols = [
      //{ field: 'arrangementKey', header: 'Revenue Contract Key', showField: true, drag: false, display: "table-cell", type: 'text' },
      { field: 'arrangementNumber', header: 'Revenue Contract Number', showField: true, drag: false, display: "table-cell", type: 'link' },
      { field: 'groupingRule', header: 'Grouping Rule', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'dealNum', header: 'Deal Number', showField: true, drag: true, display: "table-cell", type: 'number' },
      { field: 'projectNumber', header: 'Project Number', showField: true, drag: true, display: "table-cell", type: 'number' },
     // { field: 'arrangementName', header: 'Revenue Contract Name', showField: true, drag: false, display: "table-cell", type: 'link' },
      { field: 'dealNumber', header: 'Quote Number', showField: true, drag: true, display: "table-cell", type: 'number' },
    //{ field: 'dealName', header: 'Deal Name', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'customerPoNum', header: 'PO Number', showField: true, drag: true, display: "table-cell", type: 'number' },
      { field: 'orderNumber', header: 'SO Number', showField: true, drag: true, display: "table-cell", type: 'number' },
      { field: 'endCustomerName', header: 'Customer Name', drag: true, showField: true, display: "table-cell", type: 'text' },
      { field: 'endCustomerNumber', header: 'Customer Number', drag: true, showField: true, display: "table-cell", type: 'number' },
      { field: 'legalEntityName', header: 'Legal Entity', drag: true, showField: true, display: "table-cell", type: 'text' },
      { field: 'arrangementCurrency', header: 'Currency', drag: true, showField: true, display: "table-cell", type: 'text' },
      { field: 'arrangementTotal', header: 'Amount', drag: true, showField: true, display: "table-cell", type: 'round' },
      { field: 'arrangementStatus', header: 'Contract Status', drag: true, showField: true, display: "table-cell", type: 'text' },
     // { field: 'arrangementBasis', header: 'Revenue Contract Basis', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'arrangementSource', header: 'Source', showField: true, drag: true, display: "table-cell", type: 'text' },
      { field: 'contApplied', header: 'Contingency Applied', showField: true, drag: true, display: "table-cell", type: 'text' },
      //{ field: 'arrangementType', header: 'Revenue Contract Type', drag: true, showField: true, display: "table-cell", type: 'text' },
      { field: 'creationDate', header: 'Creation Date', drag: true, showField: true, display: "table-cell", type: 'date' },
      { field: 'lastUpdateDate', header: 'Last Update Date', showField: true, drag: true, display: "table-cell", type: 'date' },
      { field: 'lastArrgModifiedDate', header: 'Modified Date', showField: true, drag: true, display: "table-cell", type: 'date' }
      
    ];

    this.columns = [];

    this.loading = true;
    this.getTableColumns();
    this.rmanContHeaderService.contRulesList().then((rmanContHeadersList: any) => {
      this.rmanContHeaderList = rmanContHeadersList;
      this.prepareRmanContHeaderObject();
    });
    this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'ARRANGEMENT_STATUS' }).then((rmanLookupsVList: any) => {

      this.rmanLookupsVList = rmanLookupsVList.content;
      this.prepareRmanLookupsVObject();
      this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'ARRG_BASIS' }).then((rmanLookupsV1List: any) => {
        this.rmanLookupsV1List = rmanLookupsV1List.content;
        this.prepareRmanLookupsV1Object();
        this.rmanUsersService.getAllRmanUsers(this.paginationOptions, {}, true).then((rmanUsersList: any) => {
          this.rmanUsersList = rmanUsersList.content;
          this.prepareRmanUsersObject();
        });
      });
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
      this.disableExport = false;
    });
  }


  getTableColumns() {
    this.isSelectAllChecked = true;
    this.commonSharedService.getConfiguredColDetails("RmanArrangementsAllV", "Revenue Contract Results").then((response) => {
      if (response && response != null && response.userId) {
        this.columns = [];
        let colsList = response.tableColumns.split(",");
        if (colsList.length > 0) {
          colsList.forEach((item: any, index: number) => {
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
      this.notificationService.showError('Error occured while getting data');
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
    this.commonSharedService.saveOrUpdateTableColumns("RmanArrangementsAllV", "Revenue Contract Results", selectedCols, this.userId).then((response) => {
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


  loadDealcomponent() {
    let componentFactory = this.componentFactoryResolver.resolveComponentFactory(DealArrangementComponent);

    let viewContainerRef = this.adCm.viewContainerRef;
    viewContainerRef.clear();

    let componentRef = viewContainerRef.createComponent(componentFactory);
    this.ref = componentRef;
    this.ref.instance.actionDetails = 'ADD';
  }
  removeComponent() {

    if (this.ref) {
      this.ref.destroy();
    } else {
      /*  no-code */
    }
  }

  onHide(eve) {
    this.removeComponent();
  }

  cancelUpload() {
    this.smode = '';
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


  onColReorder(event: any) {
  }


  exportExcel() {
    this.exportCols = [];
    for (let index = 0; index < this.columns.length; index++) {
      if (this.columns[index].showField) {
        this.exportCols.push(this.columns[index].field);
      }
    }

    let serviceUrl = this.rmanArrangementsAllVService.getUrl(this.paginationOptions, this.startDate, this.endDate, this.modStartDate, this.modEndDate, this.globalSearch, this.rmanSearchObj.arrangementKey,
      this.rmanSearchObj.arrangementNumber, this.rmanSearchObj.arrangementName, this.rmanSearchObj.dealNumber, this.rmanSearchObj.dealName, this.rmanSearchObj.customerPoNum, this.rmanSearchObj.orderNumber, this.rmanSearchObj.endCustomerName,
      this.rmanSearchObj.legalEntityName, this.rmanSearchObj.arrangementCurrency, this.rmanSearchObj.arrangementTotal, this.rmanSearchObj.arrangementType, this.rmanSearchObj.arrangementStatus, this.rmanSearchObj.creationDate, this.rmanSearchObj.lastUpdateDate,
      this.rmanSearchObj.arrangementBasis, this.rmanSearchObj.arrangementSource, this.rmanSearchObj.contApplied, this.rmanSearchObj.lastArrgModifiedDate, this.rmanSearchObj.projectNumber,this.rmanSearchObj.groupingRule, this.rmanSearchObj.dealNum , 1, this.exportCols);
    window.location.href = serviceUrl;
  }

  reset(dt: Table) {
    this.isSerached = 1;
    this.paginationOptions = {};
    this.rmanArrangementsAllV = new RmanArrangementsAllVImpl();
    this.rmanSearchObj = new RmanArrangementsAllVImpl();
    dt.reset();
  }

  transformRmanLegalEntities(rmanLegalEntities: any) {
    if (rmanLegalEntities)
      return rmanLegalEntities.name;
  }
  transformRmanLookupsV(rmanLookupsV: any) {
    if (rmanLookupsV)
      return rmanLookupsV.lookupDescription;
  }
  transformRmanLookupsV1(rmanLookupsV1: any) {
    if (rmanLookupsV1)
      return rmanLookupsV1.lookupDescription;
  }
  transformRmanUsers(rmanUsers: any) {
    if (rmanUsers)
      return rmanUsers.fullName;
  }
  transformRmanLookupsV2(rmanLookupsV2: any) {
    if (rmanLookupsV2)
      return rmanLookupsV2.lookupDescription;
  }
  transformRmanUsers1(rmanUsers1: any) {
    if (rmanUsers1)
      return rmanUsers1.fullName;
  }
  transformRmanUsers2(rmanUsers2: any) {
    if (rmanUsers2)
      return rmanUsers2.fullName;
  }
  transformRmanLookupsV3(rmanLookupsV3: any) {
    if (rmanLookupsV3)
      return rmanLookupsV3.lookupDescription;
  }
  transformRmanCustomers(rmanCustomers: any) {
    if (rmanCustomers)
      return rmanCustomers.customerName;
  }
  transformRmanLookupsV4(rmanLookupsV4: any) {
    if (rmanLookupsV4)
      return rmanLookupsV4.lookupDescription;
  }
  transformRmanLookupsV5(rmanLookupsV5: any) {
    if (rmanLookupsV5)
      return rmanLookupsV5.lookupDescription;
  }
  transformRmanLookupsV6(rmanLookupsV6: any) {
    if (rmanLookupsV6)
      return rmanLookupsV6.lookupDescription;
  }
  transformRmanLookupsV7(rmanLookupsV7: any) {
    if (rmanLookupsV7)
      return rmanLookupsV7.lookupDescription;
  }
  transformRmanLookupsV8(rmanLookupsV8: any) {
    if (rmanLookupsV8)
      return rmanLookupsV8.lookupDescription;
  }
  transformRmanLookupsV9(rmanLookupsV9: any) {
    if (rmanLookupsV9)
      return rmanLookupsV9.lookupDescription;
  }
  transformRmanLookupsV10(rmanLookupsV10: any) {
    if (rmanLookupsV10)
      return rmanLookupsV10.lookupDescription;
  }
  transformRmanLookupsV11(rmanLookupsV11: any) {
    if (rmanLookupsV11)
      return rmanLookupsV11.lookupDescription;
  }
  transformRmanLookupsV12(rmanLookupsV12: any) {
    if (rmanLookupsV12)
      return rmanLookupsV12.lookupDescription;
  }
  transformRmanCurrency(rmanCurrency: any) {
    if (rmanCurrency)
      return rmanCurrency.name;
  }
  transformRmanDealArrangements(rmanDealArrangements: any) {
    if (rmanDealArrangements)
      return rmanDealArrangements.arrangementName;
  }

  onResetGlobalSearch() {
    this.globalSearch = '';
    this.commonSearch();
    this.searched = false;

  }

  onResettingDateRanges() {
    this.startDate = '';
    this.endDate = '';
    this.modStartDate = '';
    this.modEndDate = '';
    this.commonSearch();
  }

  onClickAdvanceSearch(event: any) {
    this.displayAdvancedSearch = !this.displayAdvancedSearch;
    if (this.displayAdvancedSearch) {
      /* no-code */
    } else {
      if ((this.startDate != '' && this.startDate != undefined) || (this.endDate != '' && this.endDate != undefined) || (this.modStartDate != '' && this.modStartDate != undefined) || (this.modEndDate != '' && this.modEndDate != undefined)) {
        this.startDate = '';
        this.endDate = '';
        this.modStartDate = '';
        this.modEndDate = '';
        this.commonSearch();
      }
    }
  }

  onAddingColumns(event: any) {
    this.clonedCols = JSON.parse(JSON.stringify(this.globalCols));
    this.showAddColumns = false;
  }

  closeAddColumns(event: any) {
    this.showAddColumns = true;
    this.globalCols = this.clonedCols;
    let configCol = this.globalCols.filter(item => !item.showField);
    this.isSelectAllChecked = !(configCol.length > 0);
  }

  getAllRmanArrangementsAllV() {
    this.loading = true;
    this.rmanArrangementsAllVService.getAllRmanArrangementsAllV(this.paginationOptions, this.rmanArrangementsAllV).then((rmanArrangementsAllVList: any) => {
      this.loading = false;

      this.datasource = rmanArrangementsAllVList.content;
      this.rmanArrangementsAllVList = rmanArrangementsAllVList.content;
      this.totalElements = rmanArrangementsAllVList.totalElements;
      this.pageSize = rmanArrangementsAllVList.size;
      this.displaySearchDialog = false;
    }).catch((err: any) => {
      this.loading = false;
      this.notificationService.showError('Network failed or Service is down');
    });

  }

  commonSearch() {
    this.startDate = this.datepipe.transform(this.startDate, 'yyyy-MM-dd');
    this.endDate = this.datepipe.transform(this.endDate, 'yyyy-MM-dd');
    this.modStartDate = this.datepipe.transform(this.modStartDate, 'yyyy-MM-dd');
    this.modEndDate = this.datepipe.transform(this.modEndDate, 'yyyy-MM-dd');
    this.isSerached = 1;
    this.paginationOptions = {};
    this.getArrangements();
    this.searched = true;

  }

  getArrangements() {
    this.loading = true;
    this.rmanArrangementsAllVService.getSearchedRmanArrangements(this.paginationOptions, this.startDate, this.endDate, this.modStartDate, this.modEndDate, this.globalSearch, this.rmanSearchObj.arrangementKey, this.rmanSearchObj.arrangementNumber,
      this.rmanSearchObj.arrangementName, this.rmanSearchObj.dealNumber, this.rmanSearchObj.dealName, this.rmanSearchObj.customerPoNum, this.rmanSearchObj.orderNumber, this.rmanSearchObj.endCustomerName, this.rmanSearchObj.legalEntityName, this.rmanSearchObj.arrangementCurrency,
      this.rmanSearchObj.arrangementTotal, this.rmanSearchObj.arrangementType, this.rmanSearchObj.arrangementStatus, this.rmanSearchObj.creationDate, this.rmanSearchObj.lastUpdateDate, this.rmanSearchObj.arrangementBasis, this.rmanSearchObj.arrangementSource, this.rmanSearchObj.contApplied,
      this.rmanSearchObj.lastArrgModifiedDate, this.rmanSearchObj.projectNumber, this.rmanSearchObj.groupingRule,this.rmanSearchObj.dealNum, this.exportCols).then((rmanArrangementsAllVList: any) => {
        this.loading = false;
        this.disableExport = false;
        this.datasource = rmanArrangementsAllVList.content;
        this.rmanArrangementsAllVList = rmanArrangementsAllVList.content;
        this.totalElements = rmanArrangementsAllVList.totalElements;
        this.pageSize = rmanArrangementsAllVList.size;
        this.displaySearchDialog = false;
      }).catch((err: any) => {
        this.loading = false;
        this.notificationService.showError('Network failed or Service is down');
      });
  }

  onsorting(key: any, sortType) {
    this.paginationOptions.sortField = key;
    this.paginationOptions.sortOrder = sortType;
    this.sortField = key;
    this.sortOrder = sortType;
    this.getArrangements();
  }

  getRmanArrangementsAllV(event: any) {

    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': this.sortField, 'sortOrder': this.sortOrder };
    this.loading = true;

    this.rmanArrangementsAllVService.getSearchedRmanArrangements(this.paginationOptions, this.startDate, this.endDate, this.modStartDate, this.modEndDate, this.globalSearch, this.rmanSearchObj.arrangementKey, this.rmanSearchObj.arrangementNumber,
      this.rmanSearchObj.arrangementName, this.rmanSearchObj.dealNumber, this.rmanSearchObj.dealName, this.rmanSearchObj.customerPoNum, this.rmanSearchObj.orderNumber, this.rmanSearchObj.endCustomerName, this.rmanSearchObj.legalEntityName, this.rmanSearchObj.arrangementCurrency,
      this.rmanSearchObj.arrangementTotal, this.rmanSearchObj.arrangementType, this.rmanSearchObj.arrangementStatus, this.rmanSearchObj.creationDate, this.rmanSearchObj.lastUpdateDate, this.rmanSearchObj.arrangementBasis, this.rmanSearchObj.arrangementSource, this.rmanSearchObj.contApplied,
      this.rmanSearchObj.lastArrgModifiedDate, this.rmanSearchObj.projectNumber, this.rmanSearchObj.groupingRule, this.rmanSearchObj.dealNum, this.exportCols).then((rmanArrangementsAllVList: any) => {
        this.loading = false;
        this.datasource = rmanArrangementsAllVList.content;
        this.rmanArrangementsAllVList = rmanArrangementsAllVList.content;
        this.totalElements = rmanArrangementsAllVList.totalElements;
        this.pageSize = rmanArrangementsAllVList.size;
        this.displaySearchDialog = false;
        this.disableExport = false;
      }).catch((err: any) => {
        this.loading = false;
        this.disableExport = false;
        this.notificationService.showError('Network failed or Service is down');
      });

  }

  exportTable(dt: any) {
    this._dataTable = dt;

    this.getAllArrangements();
  }

  getAllArrangements() {
    let x: any[];
    let paginationOptions: any;
    let totalElements: any;
    let pageSize: any;
    paginationOptions = { 'pageNumber': 0, 'pageSize': 100, 'sortField': null, 'sortOrder': null };
    this.rmanArrangementsAllVService.getAllRmanArrangementsAllV(paginationOptions, this.rmanArrangementsAllV).then((rmanArrangementsAllVList: any) => {
      totalElements = rmanArrangementsAllVList.totalElements;
      pageSize = rmanArrangementsAllVList.totalPages;
      x = rmanArrangementsAllVList.content;
      if (pageSize == 1) {
        this._dataTable.value = x;
        this._dataTable.exportCSV();
      }
      for (let i = 1; i < pageSize; i++) {

        paginationOptions = { 'pageNumber': i, 'pageSize': 100, 'sortField': null, 'sortOrder': null };
        this.rmanArrangementsAllVService.getAllRmanArrangementsAllV(paginationOptions, this.rmanArrangementsAllV).then((rmanArrangementsAllVList: any) => {
          x = x.concat(rmanArrangementsAllVList.content);
          if (totalElements == x.length) {
            this._dataTable.value = x;
            this._dataTable.exportCSV();
          }
        });
      }
    }).catch((err: any) => {
    });
  }

  getAllArrangementsTotal() {
    let x: any[];
    let paginationOptions: any;
    let totalElements: any;
    let total: any;
    let pageSize: any;
    paginationOptions = { 'pageNumber': 0, 'pageSize': 100, 'sortField': null, 'sortOrder': null };
    total = 0;
    this.rmanArrangementsAllVService.getAllRmanArrangementsAllV(paginationOptions, this.rmanArrangementsAllV).then((rmanArrangementsAllVList: any) => {
      totalElements = rmanArrangementsAllVList.totalElements;
      pageSize = rmanArrangementsAllVList.totalPages;
      x = rmanArrangementsAllVList.content;
      if (pageSize == 1) {
        for (let t = 0; t < x.length; t++) {
          total = total + x[t].arrangementTotal;
        }
        this.arrgTotal = total;
      }
      for (let i = 1; i < pageSize; i++) {
        paginationOptions = { 'pageNumber': i, 'pageSize': 100, 'sortField': null, 'sortOrder': null };
        this.rmanArrangementsAllVService.getAllRmanArrangementsAllV(paginationOptions, this.rmanArrangementsAllV).then((rmanArrangementsAllVList: any) => {
          x = x.concat(rmanArrangementsAllVList.content);
          if (totalElements == x.length) {
            for (let t = 0; t < x.length; t++) {
              total = total + x[t].arrangementTotal;
            }
            this.arrgTotal = total;
          }
        });
      }
    }).catch((err: any) => {
    });
  }

  showDialogToAdd() {
    this.displayDealDialog = true;
    this.loadDealcomponent();
  }

  save() {
    if (this.newRmanArrangementsAllV) {
      this.loading = true;
      this.rmanArrangementsAllVService.saveRmanArrangementsAllV(this.rmanArrangementsAllV).then((response: any) => {
        this.notificationService.showSuccess('Saved successfully');
        this.getAllRmanArrangementsAllV();
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while getting data');
        this.loading = false;
      });
    }
    else {
      this.loading = true;
      this.rmanArrangementsAllVService.updateRmanArrangementsAllV(this.rmanArrangementsAllV).then((response: any) => {
        this.notificationService.showSuccess('Updated successfully');
        this.getAllRmanArrangementsAllV();
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while getting data');
        this.loading = false;
      });
    }
    this.rmanArrangementsAllV = new RmanArrangementsAllVImpl();
    this.displayDialog = false;
  }

  delete(rmanArrangementsAllV: any) {
    this.rmanArrangementsAllV = rmanArrangementsAllV;
    this.displayDialog = false;

    if (window.confirm('Are you sure you want to delete this record?')) {
      this.rmanArrangementsAllVList.splice(this.findSelectedRmanArrangementsAllVIndex(), 1);
      this.loading = true;
      this.rmanArrangementsAllVService.deleteRmanArrangementsAllV(this.rmanArrangementsAllV).then((response: any) => {

        this.rmanArrangementsAllV = new RmanArrangementsAllVImpl();
        this.getAllRmanArrangementsAllV();
      }).catch((err: any) => {
        this.loading = false;
      });
    }

  }

  editRow(rmanArrangementsAllV: any) {
    this.newRmanArrangementsAllV = false;
    this.rmanArrangementsAllV = this.cloneRmanArrangementsAllV(rmanArrangementsAllV);
    this.displayDialog = true;
    this.prepareRmanLegalEntitiesObject();
    this.prepareRmanLookupsVObject();
    this.prepareRmanLookupsV1Object();
    this.prepareRmanUsersObject();
    this.prepareRmanLookupsV2Object();
    this.prepareRmanUsers1Object();
    this.prepareRmanUsers2Object();
    this.prepareRmanLookupsV3Object();
    this.prepareRmanCustomersObject();
    this.prepareRmanLookupsV4Object();
    this.prepareRmanLookupsV5Object();
    this.prepareRmanLookupsV6Object();
    this.prepareRmanLookupsV7Object();
    this.prepareRmanLookupsV8Object();
    this.prepareRmanLookupsV9Object();
    this.prepareRmanLookupsV10Object();
    this.prepareRmanLookupsV11Object();
    this.prepareRmanLookupsV12Object();
    this.prepareRmanCurrencyObject();
    this.prepareRmanDealArrangementsObject();

  }

  findSelectedRmanArrangementsAllVIndex(): number {
    return this.rmanArrangementsAllVList.indexOf(this.selectedRmanArrangementsAllV);
  }

  onRowSelect(event: any) {

  }

  cloneRmanArrangementsAllV(c: RmanArrangementsAllV): RmanArrangementsAllV {
    let rmanArrangementsAllV: any
      = new RmanArrangementsAllVImpl();
    for (let prop in c) {
      rmanArrangementsAllV[prop] = c[prop];
    }
    return rmanArrangementsAllV;
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

    this.rmanArrangementsAllVSearch = new RmanArrangementsAllVImpl();

    if (this.isSerached == 0) {
      this.rmanArrangementsAllVSearch = new RmanArrangementsAllVImpl();
    }
    this.displaySearchDialog = true;

  }

  getArrangementsByCreationDate() {
    this.isSerached = 1;
    this.rmanArrangementsAllV = this.rmanArrangementsAllVSearch;
    this.paginationOptions = {};
  }

  prepareRmanLegalEntitiesObject() {
    let rmanLegalEntitiesTempObj: any = [];
    this.rmanLegalEntitiesList.forEach((rmanLegalEntities) => {
      rmanLegalEntitiesTempObj.push({ label: rmanLegalEntities.name, value: rmanLegalEntities.legalEntityId });
    });

    this.rmanLegalEntities = rmanLegalEntitiesTempObj;

  }

  /** used */
  prepareRmanLookupsVObject() {
    let rmanLookupsVTempObj: any = [];
    rmanLookupsVTempObj.push({ label: '--Select Arrangement Status--', value: null });
    this.rmanLookupsVList.forEach((rmanLookupsV) => {
      rmanLookupsVTempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
    });

    this.rmanLookupsV = rmanLookupsVTempObj;

  }
  prepareRmanContHeaderObject() {
    let rmanContHeaderTempObj: any = [];
    rmanContHeaderTempObj.push({ label: '--Select Contingency Applied--', value: null });
    this.rmanContHeaderList.forEach((rmanContHeader) => {
      rmanContHeaderTempObj.push({ label: rmanContHeader.description, value: rmanContHeader.description });
    });

    this.rmanContHeader = rmanContHeaderTempObj;
  }

  /** used */
  prepareRmanLookupsV1Object() {
    let rmanLookupsV1TempObj: any = [];
    rmanLookupsV1TempObj.push({ label: '--Select Arrangement Basis--', value: null });
    this.rmanLookupsV1List.forEach((rmanLookupsV1) => {
      rmanLookupsV1TempObj.push({ label: rmanLookupsV1.lookupDescription, value: rmanLookupsV1.lookupCode });
    });

    this.rmanLookupsV1 = rmanLookupsV1TempObj;

  }


  /** used */
  prepareRmanUsersObject() {
    let rmanUsersTempObj: any = [];
    rmanUsersTempObj.push({ label: '--Select Rev Accountant ID--', value: null });
    this.rmanUsersList.forEach((rmanUsers) => {
      rmanUsersTempObj.push({ label: rmanUsers.fullName, value: rmanUsers.rmanUserId });
    });

    this.rmanUsers = rmanUsersTempObj;

  }

  prepareRmanLookupsV2Object() {
    let rmanLookupsV2TempObj: any = [];
    this.rmanLookupsV2List.forEach((rmanLookupsV2) => {
      rmanLookupsV2TempObj.push({ label: rmanLookupsV2.lookupDescription, value: rmanLookupsV2.lookupCode });
    });

    this.rmanLookupsV2 = rmanLookupsV2TempObj;

  }

  prepareRmanUsers1Object() {
    let rmanUsers1TempObj: any = [];
    this.rmanUsers1List.forEach((rmanUsers1) => {
      rmanUsers1TempObj.push({ label: rmanUsers1.fullName, value: rmanUsers1.rmanUserId });
    });

    this.rmanUsers1 = rmanUsers1TempObj;

  }

  prepareRmanUsers2Object() {
    let rmanUsers2TempObj: any = [];
    this.rmanUsers2List.forEach((rmanUsers2) => {
      rmanUsers2TempObj.push({ label: rmanUsers2.fullName, value: rmanUsers2.rmanUserId });
    });

    this.rmanUsers2 = rmanUsers2TempObj;

  }

  prepareRmanLookupsV3Object() {
    let rmanLookupsV3TempObj: any = [];
    this.rmanLookupsV3List.forEach((rmanLookupsV3) => {
      rmanLookupsV3TempObj.push({ label: rmanLookupsV3.lookupDescription, value: rmanLookupsV3.lookupCode });
    });

    this.rmanLookupsV3 = rmanLookupsV3TempObj;

  }

  prepareRmanCustomersObject() {
    let rmanCustomersTempObj: any = [];
    this.rmanCustomersList.forEach((rmanCustomers) => {
      rmanCustomersTempObj.push({ label: rmanCustomers.customerName, value: rmanCustomers.customerNumber });
    });

    this.rmanCustomers = rmanCustomersTempObj;

  }

  prepareRmanLookupsV4Object() {
    let rmanLookupsV4TempObj: any = [];
    this.rmanLookupsV4List.forEach((rmanLookupsV4) => {
      rmanLookupsV4TempObj.push({ label: rmanLookupsV4.lookupDescription, value: rmanLookupsV4.lookupCode });
    });

    this.rmanLookupsV4 = rmanLookupsV4TempObj;

  }

  prepareRmanLookupsV5Object() {
    let rmanLookupsV5TempObj: any = [];
    this.rmanLookupsV5List.forEach((rmanLookupsV5) => {
      rmanLookupsV5TempObj.push({ label: rmanLookupsV5.lookupDescription, value: rmanLookupsV5.lookupCode });
    });

    this.rmanLookupsV5 = rmanLookupsV5TempObj;

  }

  prepareRmanLookupsV6Object() {
    let rmanLookupsV6TempObj: any = [];
    this.rmanLookupsV6List.forEach((rmanLookupsV6) => {
      rmanLookupsV6TempObj.push({ label: rmanLookupsV6.lookupDescription, value: rmanLookupsV6.lookupCode });
    });

    this.rmanLookupsV6 = rmanLookupsV6TempObj;

  }

  prepareRmanLookupsV7Object() {
    let rmanLookupsV7TempObj: any = [];
    this.rmanLookupsV7List.forEach((rmanLookupsV7) => {
      rmanLookupsV7TempObj.push({ label: rmanLookupsV7.lookupDescription, value: rmanLookupsV7.lookupCode });
    });

    this.rmanLookupsV7 = rmanLookupsV7TempObj;

  }

  prepareRmanLookupsV8Object() {
    let rmanLookupsV8TempObj: any = [];
    this.rmanLookupsV8List.forEach((rmanLookupsV8) => {
      rmanLookupsV8TempObj.push({ label: rmanLookupsV8.lookupDescription, value: rmanLookupsV8.lookupCode });
    });

    this.rmanLookupsV8 = rmanLookupsV8TempObj;

  }

  prepareRmanLookupsV9Object() {
    let rmanLookupsV9TempObj: any = [];
    this.rmanLookupsV9List.forEach((rmanLookupsV9) => {
      rmanLookupsV9TempObj.push({ label: rmanLookupsV9.lookupDescription, value: rmanLookupsV9.lookupCode });
    });

    this.rmanLookupsV9 = rmanLookupsV9TempObj;

  }

  prepareRmanLookupsV10Object() {
    let rmanLookupsV10TempObj: any = [];
    this.rmanLookupsV10List.forEach((rmanLookupsV10) => {
      rmanLookupsV10TempObj.push({ label: rmanLookupsV10.lookupDescription, value: rmanLookupsV10.lookupCode });
    });

    this.rmanLookupsV10 = rmanLookupsV10TempObj;

  }

  prepareRmanLookupsV11Object() {
    let rmanLookupsV11TempObj: any = [];
    this.rmanLookupsV11List.forEach((rmanLookupsV11) => {
      rmanLookupsV11TempObj.push({ label: rmanLookupsV11.lookupDescription, value: rmanLookupsV11.lookupCode });
    });

    this.rmanLookupsV11 = rmanLookupsV11TempObj;

  }

  prepareRmanLookupsV12Object() {
    let rmanLookupsV12TempObj: any = [];
    this.rmanLookupsV12List.forEach((rmanLookupsV12) => {
      rmanLookupsV12TempObj.push({ label: rmanLookupsV12.lookupDescription, value: rmanLookupsV12.lookupCode });
    });

    this.rmanLookupsV12 = rmanLookupsV12TempObj;

  }

  prepareRmanCurrencyObject() {
    let rmanCurrencyTempObj: any = [];
    this.rmanCurrencyList.forEach((rmanCurrency) => {
      rmanCurrencyTempObj.push({ label: rmanCurrency.name, value: rmanCurrency.currencyCode });
    });

    this.rmanCurrency = rmanCurrencyTempObj;

  }

  prepareRmanDealArrangementsObject() {
    let rmanDealArrangementsTempObj: any = [];
    this.rmanDealArrangementsList.forEach((rmanDealArrangements) => {
      rmanDealArrangementsTempObj.push({ label: rmanDealArrangements.arrangementName, value: rmanDealArrangements.arrangementId });
    });

    this.rmanDealArrangements = rmanDealArrangementsTempObj;

  }

  onBeforeToggle(evt: any) {

    this.collapsed = evt.collapsed;
  }

  getNotification(event: any) {
    this.displayDealDialog = event;

  }

  getFlag(event: any) {
    this.notificationService.showSuccess('Saved successfully');
    this.paginationOptions = {};
    this.rmanArrangementsAllV = new RmanArrangementsAllVImpl();
    this.getAllRmanArrangementsAllV();
  }

  getErrorFlag(event: any) {
    this.notificationService.showSuccess('Error occured while saving the data');
  }

  onUpload(event: any) {
    this.notificationService.showSuccess('File Uploaded successfully');
    this.displayDealDataDialog = false;
    this.displaySelectMode = false;
    this.smode = '';
  }

  /*fileUploadHandler(event: any, url: any) {
    this._uploadService.processUpload(event, url);
  }*/

  onPBUpload(event: any) {
    this.notificationService.showSuccess('File Uploaded successfully');
    this.displayPBDialog = false;
    this.displaySelectMode = false;
    this.uploadLoading = false;
    this.smode = '';
  }

  showUploadLoader() {
    this.uploadLoading = true;
  }

  onShipmentsUpload(event: any) {
    this.notificationService.showSuccess('File Uploaded successfully');
    this.displayshipmentsDialog = false;
    this.displaySelectMode = false;
    this.uploadLoading = false;
    this.smode = '';
  }

  onErrorShipmentsFileupload(event: any) {
    this.displayshipmentsDialog = false;
    this.uploadLoading = false;
    let msg: string = "";
    msg += event.files[0].name + " file upload process failed due to ";
    if (event.xhr.response) {
      msg += JSON.parse(event.xhr.response).message
    }
    this.notificationService.showError(msg);
    this.smode = '';
  }

  onErrorFileupload(event: any) {
    this.displaySelectMode = false;
    let msg: string = "";
    msg += event.files[0].name + " file upload process failed due to ";
    if (event.xhr.response) {
      msg += JSON.parse(event.xhr.response).message
    }
    this.notificationService.showError(msg);
    this.smode = '';
  }

  onInvUpload(event: any) {
    this.notificationService.showSuccess('File Uploaded successfully');
    this.displayInvDialog = false;
    this.displaySelectMode = false;
    this.uploadLoading = false;
    this.smode = '';
  }

  onErrorInvFileupload(event: any) {
    this.displaySelectMode = false;
    this.uploadLoading = false;
    let msg: string = "";
    msg += event.files[0].name + " file upload process failed due to";
    if (event.xhr.response) {
      msg += JSON.parse(event.xhr.response).message
    }
    this.notificationService.showError(msg);
    this.smode = '';
  }

  onErrorPBFileupload(event: any) {
    this.displaySelectMode = false;
    this.uploadLoading = false;
    let msg: string = "";
    msg += event.files[0].name + " file upload process failed due to ";
    if (event.error) {
      msg += event.error.message;
    }
    this.notificationService.showError(msg);
    this.smode = '';
  }


  importFile() {
    this.displaySelectMode = true;
    this.smode = '';
  }

  onPreBooking(event: any) {
    this.displaySelectMode = false;
    this.displayDealDataDialog = true;
    this.cmode = false;
  }
  onPostBooking(event: any) {
    this.displaySelectMode = false;
    this._uploadService.displayPBDialog = true;
    this.displayPBDialog = true;
    this.cmode = false;
  }
  onInvoices(event: any) {
    this.displaySelectMode = false;
    this._uploadService.displayInvDialog = true;
    this.displayInvDialog = true;
    this.cmode = false;
  }

  onShipments(event: any) {
    this.displaySelectMode = false;
    this._uploadService.displayshipmentsDialog = true;
    this.displayshipmentsDialog = true;
    this.cmode = false;
  }

  onQuotes(event: any) {
    this.displaySelectMode = false;
    this._uploadService.displayQuotesDialog = true;
    this.displayQuotesDialog = true;
    this.cmode = false;
  }

  onContingencyRelease(event: any){
    this.displaySelectMode = false;
    this._uploadService.displayContRelDialog = true;
    this.displayContRelDialog = true;
    this.cmode = false;
  }

  onUsages(event: any){
    this.displaySelectMode = false;
    this._uploadService.displayUsageDialog = true;
    this.cmode = false;
  }

  //if file name starts with book, ship, inv or quote -> process file
  fileUploadHandler(event: any, url: any, type: any) {
    var file: any;
     let tempFiles: any = [];
     var processFlag: boolean;
     for (let file of event.files) {
      tempFiles.push(file.name);
    }
  
    if(tempFiles.length>0){
      console.log(tempFiles[0])
      var fileName = tempFiles[0].toString().toLowerCase();
      file = fileName.replace(/[^a-z\s]+/gi, "");
    }
  
    if(type == 'book' && file.startsWith(type)){
      processFlag  = true;
    }else if(type =='ship' && file.startsWith(type)){
      processFlag  = true;
    }else if(type == 'inv' && file.startsWith(type)){
      processFlag  = true;
    }else if(type =='quote' && file.startsWith(type)){
      processFlag  = true;
    }else if(type =='vcr' && file.startsWith(type)){
      processFlag  = true;
    }else if(type =='usage' && file.startsWith(type)){
      processFlag  = true;
    }else{
      processFlag  = false;
    }
  
    if(processFlag){
      this._uploadService.processUpload(event, url);
    }else{
      this.notificationService.showError('Upload Failed, File Name should start with '+type.toString().toUpperCase()+' Key');
    }
  
    }
  

  onEnablingFilters(event: any) {
    this.isToggled = !this.isToggled;
    if (this.isToggled) {
      /* no-code */
    } else {
      this.rmanSearchObj = new RmanArrangementsAllVImpl();
      this.commonSearch();
    }
  }
  cancel() {
    this.displaySelectMode = true;
  }

  ngOnDestroy() {
    this.subscription1.unsubscribe();
    this.subscription2.unsubscribe();
    this.subscription3.unsubscribe();
    this.subscription5.unsubscribe();

    if (this.ref) {
      this.ref.destroy();
    }

  }
}


class RmanArrangementsAllVImpl {
  constructor(public dealFlag?: any, public endCustomerName?: any, public masterArrgName?: any, public arrangementSource?: any, public revManagerId?: any, public arrangementCurrency?: any, public msaName?: any, public contractFlag?: any, public endCustomerNumber?: any, public lastUpdateDate?: any, public customerContact?: any, public changeReason?: any, public arrangementTotal?: any, public arrangementName?: any, public masterArrgId?: any, public dealNumber?: any, public arrangementBasis?: any, public dealName?: any, public repCurrCode?: any, public createdBy?: any, public salesNodeLevel4?: any, public lastUpdatedBy?: any, public msaNumber?: any, public salesNodeLevel2?: any, public calcuationMethod?: any, public salesNodeLevel3?: any, public salesContact?: any, public arrangementNumber?: any, public legalEntityId?: any, public revAccountantId?: any, public reasonCode?: any, public creationDate?: any, public guidanceType?: any, public arrangementKey?: any, public masterArrgFlag?: any, public customerPoNum?: any, public arrangementId?: any, public salesNodeLevel1?: any, public arrangementType?: any, public allocationEligible?: any, public guidanceName?: any, public legalEntityName?: any, public arrangementStatus?: any, public orderNumber?: any, public arrangementQtr?: any, public contApplied?: any, public groupingRule?: any, public dealNum?: any) { }
}

interface ILabels {
  [index: string]: string;
}
