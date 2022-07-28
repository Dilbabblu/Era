import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { NavigationEnd, Router } from "@angular/router";
import { ConfirmationService } from 'primeng/api';
import { Table } from 'primeng/table';
import { RmanDealArrangementsImpl } from '../rmanDealArrangements/rmanDealArrangements.component';
import { RmanDealArrangementsLabels } from '../rmanDealArrangements/rmanDealArrangementsLabels';
import { RmanDealArrangementsService } from '../rmanDealArrangements/rmanDealArrangementsservice';
import { RmanDealDetailsImpl } from '../rmanDealDetails/rmanDealDetails.component';
import { RmanDealDetailsLabels } from '../rmanDealDetails/rmanDealDetailsLabels';
import { RmanDealDetailsService } from '../rmanDealDetails/rmanDealDetailsservice';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanOrderLinesBookingsV } from './rmanOrderLinesBookingsV';
import { RmanOrderLinesBookingsVService } from './rmanOrderLinesBookingsVservice';

declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');
@Component({
  templateUrl: './rmanOrderLinesBookingsV.component.html',
  selector: 'rmanOrderLinesBookingsV-data',
  providers: [RmanOrderLinesBookingsVService, ConfirmationService, RmanDealDetailsService, RmanDealArrangementsService]
})

export class RmanOrderLinesBookingsVComponent implements OnInit {
  noData = appSettings.noData;
  displayDialog: boolean;

  displaySearchDialog: boolean;

  displayContractsDialog: boolean;

  rmanOrderLinesBookingsV: any = new RmanOrderLinesBookingsVImpl();

  rmanOrderLinesBookingsVSearch: any = new RmanOrderLinesBookingsVImpl();

  isSerached: number = 0;
  pSno: any;

  @Output() getBookings = new EventEmitter();

  arrIdK: any;

  selectedRmanOrderLinesBookingsV: RmanOrderLinesBookingsV;

  newRmanOrderLinesBookingsV: boolean;

  rmanOrderLinesBookingsVList: any[] = [];

  rmanDealDetails: any = new RmanDealDetailsImpl();
  rmanDealDetailsSearch: any = new RmanDealDetailsImpl();

  selectedDeal: any = new RmanDealDetailsImpl();

  rmanDealDetailsList: any[] = [];

  targetDealArrangementId: any;
  targetDealLineNumber: any;
  targetDealNumber: any = 1;
  targetDealLineId: any = 1;
  cols: any[];
  columns: any[];
  contractColumns: ILabels;

  columnOptions: any[];

  paginationOptions: any;

  pages: {};

  datasource: any[];
  pageSize: number;
  totalElements: number;
  totalOrderElements: number;
  historyDialog: boolean = false;
  collapsed: boolean = true;
  
  rmanDealArrangementsList: any[] = [];
  rmanDealArrangementsSearch: any = new RmanDealArrangementsImpl();
  rmanDealArrangements: RmanDealArrangementsImpl = new RmanDealArrangementsImpl();
  selectedArrangement: RmanDealArrangementsImpl = new RmanDealArrangementsImpl();
  arrangementColumns: ILabels;
  rmanDealArrangementsLabels: RmanDealArrangementsLabels = new RmanDealArrangementsLabels();
  loadingOrderLines: boolean = true;
  sourceLineId: any;
  masterData: any;

  showAddColumns = true;
  isSelectAllChecked = true;
  globalCols: any[];
  clonedCols: any[];
  userId: number;
  showPaginator: boolean = true;
  startIndex: number;
  disableExport: boolean = true;

  exportCols: string[] = [];

  constructor(private rmanDealArrangementsService: RmanDealArrangementsService, private rmanOrderLinesBookingsVService: RmanOrderLinesBookingsVService, private router: Router, private confirmService: ConfirmationService, private commonSharedService: CommonSharedService,
    private notificationService: NotificationService) {

    // generate list code
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.arrIdK = event.url.split('/')[3];
      }
    });

  }
  ngOnInit() {

    let rmanDealDetailsLabels = new RmanDealDetailsLabels();
    this.globalCols = [

      { field: 'pobGrouping', header: 'POB Id', showField: true, display: "table-cell", type: 'text', drag: false },
      { field: 'soLineNum', header: 'SO Line#', showField: true, display: "table-cell", type: 'number', drag: false },
      { field: 'productName', header: 'Product Name', showField: true, display: "table-cell", type: 'text', drag: false },
      { field: 'uom', header: 'UOM', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'orderedQuantity', header: 'Ordered Quantity', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'listPrice', header: 'Unit List Price', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'netPrice', header: 'Unit Selling Price', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'extendedListAmount', header: 'Extended List Amount', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'lineAmount', header: 'Line Amount', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'lineCost', header: 'Line Cost', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'manufacturingCost', header: 'Manufacturing Cost', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'bundleFlag', header: 'Bundle Flag', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'parentLineId', header: 'Parent Line Id', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'bookedDate', header: 'Booked Date', showField: true, display: "table-cell", type: 'date', drag: true },
      { field: 'shipeedDate', header: 'Delivered Date', showField: true, display: "table-cell", type: 'date', drag: true },
      { field: 'billedDate', header: 'Billed Date', showField: true, display: "table-cell", type: 'date', drag: true },
      { field: 'lineStatus', header: 'Line Status', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'accountingRuleName', header: 'Accounting Rule', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'amortRuleRevenue', header: 'Amortization Rule', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'contractStartDate', header: 'Contract Start Date', showField: true, display: "table-cell", type: 'date', drag: true },
      { field: 'contractEndDate', header: 'Contract End Date', showField: true, display: "table-cell", type: 'date', drag: true },
      { field: 'productFamily', header: 'Product Family', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'productCategory', header: 'Product Line', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'dealNumber', header: 'Quote Number', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'dealLineNumber', header: 'Quote Line Number', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'contractModifed', header: 'Contract Modified', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'contractModifiedDate', header: 'Contract Modified Date', showField: true, display: "table-cell", type: 'date', drag: true },
      { field: 'lineAttribute1', header: 'Attribute 1', showField: true, drag: true, display: "table-cell",type:'text' },
      { field: 'lineAttribute2', header: 'Attribute 2', showField: true, drag: true, display: "table-cell",type:'text' },
      { field: 'lineAttribute3', header: 'Attribute 3', showField: true, drag: true, display: "table-cell",type:'text' },
      { field: 'lineAttribute4', header: 'Attribute 4', showField: true, drag: true, display: "table-cell",type:'text' },
      { field: 'lineAttribute5', header: 'Attribute 5', showField: true, drag: true, display: "table-cell",type:'text' },
      { field: 'lineAttribute6', header: 'Attribute 6', showField: true, drag: true, display: "table-cell",type:'text' },
      { field: 'lineAttribute7', header: 'Attribute 7', showField: true, drag: true, display: "table-cell",type:'text' },
      { field: 'lineAttribute8', header: 'Attribute 8', showField: true, drag: true, display: "table-cell",type:'text' },
      { field: 'lineAttribute9', header: 'Attribute 9', showField: true, drag: true, display: "table-cell",type:'text' },
      { field: 'lineAttribute10', header: 'Attribute 10', showField: true, drag: true, display: "table-cell",type:'text' },
      { field: 'lineAttribute11', header: 'Attribute 11', showField: true, drag: true, display: "table-cell",type:'text' },
      { field: 'lineAttribute12', header: 'Attribute 12', showField: true, drag: true, display: "table-cell",type:'text' },
      { field: 'lineAttribute13', header: 'Attribute 13', showField: true, drag: true, display: "table-cell",type:'text' },
      { field: 'lineAttribute14', header: 'Attribute 14', showField: true, drag: true, display: "table-cell",type:'text' },
      { field: 'lineAttribute15', header: 'Attribute 15', showField: true, drag: true, display: "table-cell",type:'text' }
    ];
    this.arrangementColumns = this.rmanDealArrangementsLabels.fieldLabels;
    this.contractColumns = rmanDealDetailsLabels.fieldLabels;
    this.columns = [];
    this.getTableColumns("rmanOrderLinesBookingsV", "Booking Lines");
  }

  parentCall(data) {
    this.masterData = data;
    if (data != '') {
      this.pSno = data.sno;
      this.getAllRmanOrderLinesBookingsV();
    } else {
      this.pSno = null;
      this.rmanOrderLinesBookingsVList = [];
    }
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
      this.loadingOrderLines = false;
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
    this.loadingOrderLines = true;
    this.commonSharedService.saveOrUpdateTableColumns("rmanOrderLinesBookingsV", "Booking Lines", selectedCols, this.userId).then((response) => {
      this.columns = this.globalCols.filter(item => item.showField);
      this.userId = response["userId"];
      this.showPaginator = this.columns.length !== 0;
      this.loadingOrderLines = false;
    }).catch(() => {
      this.notificationService.showError('Error occured while getting data');
      this.loadingOrderLines = false;
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
  onRowArrgSelect(event: any) {
    this.selectedArrangement = event.data;
    this.targetDealArrangementId = this.selectedArrangement.dealArrangementId;
  }

  searchArrangements() {
    this.rmanDealArrangements = this.rmanDealArrangementsSearch;
    this.getAllRmanDealArrangements();
  }

  getAllRmanDealArrangements() {
    this.loadingOrderLines = true;
    this.rmanDealArrangementsService.getAllRmanDealArrangements(this.paginationOptions, this.rmanDealArrangements).then((rmanDealArrangementsList: any) => {
      this.loadingOrderLines = false;
      this.datasource = rmanDealArrangementsList.content;
      this.rmanDealArrangementsList = rmanDealArrangementsList.content;
      this.rmanDealArrangementsList = this.rmanDealArrangementsList.filter((item: any) => item.dealArrangementId != this.arrIdK);
      this.totalElements = rmanDealArrangementsList.totalElements;
      this.pageSize = rmanDealArrangementsList.size;
      this.displaySearchDialog = false;
      this.disableExport = false;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loadingOrderLines = false;
    });
  }

  resetArrangements() {
    this.paginationOptions = {};
    this.rmanDealArrangements = new RmanDealArrangementsImpl();
    this.rmanDealArrangementsSearch.dealArrangementName = '';
    this.rmanDealArrangementsSearch.dealArrangementNumber = '';
    this.getAllRmanDealArrangements();
  }


  getRmanDealArrangements(event: any) {
    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loadingOrderLines = true;
    this.rmanDealArrangementsService.getAllRmanDealArrangements(this.paginationOptions, this.rmanDealArrangements).then((rmanDealArrangementsList: any) => {
      this.loadingOrderLines = false;
      this.datasource = rmanDealArrangementsList.content;
      this.rmanDealArrangementsList = rmanDealArrangementsList.content;
      this.totalElements = rmanDealArrangementsList.totalElements;
      this.pageSize = rmanDealArrangementsList.size;
      this.disableExport = false;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loadingOrderLines = false;
    });
  }

  exportExcel() {
    this.exportCols = [];
    for (let index = 0; index < this.columns.length; index++) {
      if (this.columns[index].showField) {
        this.exportCols.push(this.columns[index].field);
      }
    }
    let serviceUrl = this.rmanOrderLinesBookingsVService.getServiceUrl(this.paginationOptions, { 'sourceHeaderId': this.pSno, 'arrangementId': this.arrIdK }, 1, this.exportCols);
    window.location.href = serviceUrl;
  }

  reset(dt: Table) {

    this.paginationOptions = {};
    this.rmanOrderLinesBookingsV = new RmanOrderLinesBookingsVImpl();
    dt.reset();
  }

  getAllRmanOrderLinesBookingsV() {
    this.loadingOrderLines = true;
    this.rmanOrderLinesBookingsV.sourceHeaderId = this.pSno;
    this.rmanOrderLinesBookingsVService.getAllRmanOrderLinesBookingsV(this.paginationOptions, { 'arrangementId': this.arrIdK, 'sourceHeaderId': this.pSno }, this.exportCols).then((rmanOrderLinesBookingsVList: any) => {


      this.datasource = rmanOrderLinesBookingsVList.content;
      this.rmanOrderLinesBookingsVList = rmanOrderLinesBookingsVList.content;
      this.totalOrderElements = rmanOrderLinesBookingsVList.totalElements;
      this.pageSize = rmanOrderLinesBookingsVList.size;
      this.loadingOrderLines = false;
      this.displaySearchDialog = false;
      this.disableExport = false;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loadingOrderLines = false;
    });
  }


  getRmanOrderLinesBookingsV(event: any) {
    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loadingOrderLines = true;
    if (this.pSno) {
      this.rmanOrderLinesBookingsVService.getAllRmanOrderLinesBookingsV(this.paginationOptions, { 'arrangementId': this.arrIdK, 'sourceHeaderId': this.pSno }, this.exportCols).then((rmanOrderLinesBookingsVList: any) => {

        this.datasource = rmanOrderLinesBookingsVList.content;
        this.rmanOrderLinesBookingsVList = rmanOrderLinesBookingsVList.content;
        this.totalOrderElements = rmanOrderLinesBookingsVList.totalElements;
        this.pageSize = rmanOrderLinesBookingsVList.size;
        this.loadingOrderLines = false;
        this.disableExport = false;
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while getting data');
        this.loadingOrderLines = false;
      });
    }

  }


  showDialogToAdd() {

    this.newRmanOrderLinesBookingsV = true;
    this.rmanOrderLinesBookingsV = new RmanOrderLinesBookingsVImpl();
    this.displayDialog = true;

  }


  save() {

    if (this.newRmanOrderLinesBookingsV) {


      this.loadingOrderLines = true;
      this.rmanOrderLinesBookingsVService.saveRmanOrderLinesBookingsV(this.rmanOrderLinesBookingsV).then((response: any) => {

        this.getAllRmanOrderLinesBookingsV();
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while saving data');
        this.loadingOrderLines = false;
      });
    }
    else {
      this.loadingOrderLines = true;
      this.rmanOrderLinesBookingsVService.updateRmanOrderLinesBookingsV(this.rmanOrderLinesBookingsV).then((response: any) => {

        this.getAllRmanOrderLinesBookingsV();
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while updating data');
        this.loadingOrderLines = false;
      });
    }

    this.rmanOrderLinesBookingsV = new RmanOrderLinesBookingsVImpl();

    this.displayDialog = false;

  }

  getHistory() {

    if (this.selectedRmanOrderLinesBookingsV != undefined) {

      this.historyDialog = true;

    } else {
      this.notificationService.showError('Select one line to view  the history');
    }
  }


  delete(rmanOrderLinesBookingsV: any) {
    this.rmanOrderLinesBookingsV = rmanOrderLinesBookingsV;
    this.displayDialog = false;
    if (window.confirm('Are you sure you want to delete this record?')) {
      this.rmanOrderLinesBookingsVList.splice(this.findSelectedRmanOrderLinesBookingsVIndex(), 1);
      this.loadingOrderLines = true;
      this.rmanOrderLinesBookingsVService.deleteRmanOrderLinesBookingsV(this.rmanOrderLinesBookingsV).then((response: any) => {

        this.rmanOrderLinesBookingsV = new RmanOrderLinesBookingsVImpl();
        this.getAllRmanOrderLinesBookingsV();
      });
    }

  }

  editRow(rmanOrderLinesBookingsV: any) {
    this.newRmanOrderLinesBookingsV = false;
    this.rmanOrderLinesBookingsV = this.cloneRmanOrderLinesBookingsV(rmanOrderLinesBookingsV);
    this.displayDialog = true;

  }


  findSelectedRmanOrderLinesBookingsVIndex(): number {
    return this.rmanOrderLinesBookingsVList.indexOf(this.selectedRmanOrderLinesBookingsV);
  }

  onRowSelect(event: any) {
    this.sourceLineId = event.data.sourceLineId;
  }

  cloneRmanOrderLinesBookingsV(c: RmanOrderLinesBookingsV): RmanOrderLinesBookingsV {
    let rmanOrderLinesBookingsV: any = new RmanOrderLinesBookingsVImpl();
    for (let prop in c) {
      rmanOrderLinesBookingsV[prop] = c[prop];
    }
    return rmanOrderLinesBookingsV;
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

  linkOrUnlinkSalesOrderLine(msg: any){
    this.getAllRmanOrderLinesBookingsV();
    this.getBookings.emit();
    this.notificationService.showSuccess(msg);
  }

  unLinkSoLineItem() {
    if (!this.selectedRmanOrderLinesBookingsV) {
      this.notificationService.showInfo('Please select one of the Order Line to UnLink');
    } else {
      this.confirmService.confirm({
        message: 'Are you sure you want to Unlink this record?',
        header: 'Confirmation',
        icon: '',
        accept: () => {
          this.rmanOrderLinesBookingsVService.unLinkSalesOrderline(this.selectedRmanOrderLinesBookingsV).then(response => {
            this.linkOrUnlinkSalesOrderLine('Selected Sales Order Line is Unlinked from this Sales Order');
          });

        },
        reject: () => {
          this.notificationService.showWarning('You are cancelled the request for UnLink SO Operation');
        }
      });
    }
  }

  linkSoLineItem() {
    if (!this.selectedRmanOrderLinesBookingsV) {
      this.notificationService.showInfo('Please select one of the Order Line to link');
    } else {
      this.confirmService.confirm({
        message: 'Are you sure you want to link this record?',
        header: 'Confirmation',
        icon: '',
        accept: () => {
          this.selectedArrangement = {};
          this.displayContractsDialog = true;
        },
        reject: () => {
          this.notificationService.showWarning('You have Cancel the Request of Link SO Line');
        }
      });
    }
  }

  okSoLink() {
    this.loadingOrderLines = true;
    this.rmanOrderLinesBookingsVService.linkSalesOrderline(this.selectedRmanOrderLinesBookingsV.sourceLineId, this.targetDealArrangementId, this.targetDealNumber, this.targetDealLineId).then((response: any) => {
     this.linkOrUnlinkSalesOrderLine('Selected Sales Order Line is linked to this Sales Order');

    })
      .catch((err: any) => {
        this.notificationService.showError('Error occured while linking the data');
        this.loadingOrderLines = false;
      });


    this.displayContractsDialog = false;
  }

  showDialogToSearch() {

    this.rmanOrderLinesBookingsVSearch = new RmanOrderLinesBookingsVImpl();

    if (this.isSerached == 0) {
      this.rmanOrderLinesBookingsVSearch = new RmanOrderLinesBookingsVImpl();
    }
    this.displaySearchDialog = true;

  }

  search() {

    this.isSerached = 1;
    this.rmanOrderLinesBookingsV = this.rmanOrderLinesBookingsVSearch;
    this.getAllRmanOrderLinesBookingsV();
  }

  onBeforeToggle(evt: any) {
    this.collapsed = evt.collapsed;
  }
}


class RmanOrderLinesBookingsVImpl {
  constructor(public listPrice?: any, public revrecAcctScope?: any, public so?: any, public priceList?: any, public shipeedDate?: any, public elementType?: any, public milestone?: any, public revrecEndDate?: any, public shipDate?: any, public shippedQuantity?: any, public endCustomer?: any, public lineAmount?: any, public pobTemplate?: any, public pobGrouping?: any, public revrecDelay?: any, public billedDate?: any, public bookingCurrency?: any, public netPrice?: any, public revrecAcctRule?: any, public parentLineId?: any, public customerPoNum?: any, public productName?: any, public lineStatus?: any, public arrangementId?: any, public funcCurrencyCode?: any, public bookedDate?: any, public accountingRuleName?: any, public accountingScope?: any, public uom?: any, public ouName?: any, public orderBookedDate?: any, public productFamily?: any, public revrecAccount?: any, public productCategory?: any, public rmanLineId?: any, public orderedQuantity?: any, public da?: any, public contractStartDate?: any, public contractEndDate?: any, public revrecStDate?: any, public bundleFlag?: any, public soLineNum?: any, public sourceLineId?: any, public amortRuleRevenue?: any, public sourceHeaderId?: any, public refOrderNumber?: any,
    public serviceRefOrder?: any, public serviceRefOrdLineNum?: any, public contractModifed?: any,
    public contractModifiedDate?: any, public lineCost?: any, public manufacturingCost?: any, public lineAttribute1?: any,
    public lineAttribute2?: any, public lineAttribute3?: any, public lineAttribute4?: any, public lineAttribute5?: any, public lineAttribute6?: any,
    public lineAttribute7?: any, public lineAttribute8?: any, public lineAttribute9?: any, public lineAttribute10?: any, public lineAttribute11?: any,
    public lineAttribute12?: any, public lineAttribute13?: any, public lineAttribute14?: any, public lineAttribute15?: any,) { }
}

interface ILabels {
  [index: string]: string;
}
