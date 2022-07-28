import { Component, OnInit, ViewChild } from '@angular/core';
import { NavigationEnd, Router } from "@angular/router";
import { ConfirmationService } from 'primeng/api';
import { Table } from 'primeng/table';
import { RmanOpenDealArrangementsImpl } from '../rmanOpenDealArrangements/rmanOpenDealArrangements.component';
import { RmanOpenDealArrangementsLabels } from '../rmanOpenDealArrangements/rmanOpenDealArrangementsLabels';
import { RmanOpenDealArrangementsservice } from '../rmanOpenDealArrangements/rmanOpenDealArrangementsservice';
import { RmanOrderLinesBookingsVComponent } from '../rmanOrderLinesBookingsV/rmanOrderLinesBookingsV.component';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanOrderBookingsV } from './rmanOrderBookingsV';
import { RmanOrderBookingsVService } from './rmanOrderBookingsVservice';

declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
  templateUrl: './rmanOrderBookingsV.component.html',
  selector: 'rmanOrderBookingsV-data',
  providers: [RmanOrderBookingsVService, ConfirmationService, RmanOpenDealArrangementsservice]
})

export class RmanOrderBookingsVComponent implements OnInit {
  noData = appSettings.noData;
  displayDialog: boolean;

  displaySearchDialog: boolean;

  displayDealsDialog: boolean;

  displayMergeDialog: boolean;

  totalArrgElements: number;

  arrIdK: any;

  pSno: any;

  rmanOrderBookingsV: any = new RmanOrderBookingsVImpl();

  rmanOrderBookingsVSearch: any = new RmanOrderBookingsVImpl();

  rmanDealArrangements: RmanOpenDealArrangementsImpl = new RmanOpenDealArrangementsImpl();

  rmanDealArrangementsSearch: any = new RmanOpenDealArrangementsImpl();

  selectedArrangement: RmanOpenDealArrangementsImpl = new RmanOpenDealArrangementsImpl();

  targetDealArrangementId: any;

  isSerached: number = 0;

  selectedRmanOrderBookingsV: RmanOrderBookingsV;

  selectedDeal: any;

  newRmanOrderBookingsV: boolean;

  rmanOrderBookingsVList: any[] = [];

  rmanDealDetailsList: any[] = [];

  rmanDealArrangementsList: any[] = [];

  cols: any[];
  columns: any[];
  dealColumns: ILabels;
  arrangementColumns: ILabels;
  rmanDealArrangementsLabels: RmanOpenDealArrangementsLabels = new RmanOpenDealArrangementsLabels();

  columnOptions: any[];

  paginationOptions: any;

  pages: {};

  datasource: any[];
  pageSize: number;
  arrgPageSize: number;
  totalElements: number;
  totalDealElements: number;

  collapsed: boolean = true;
  loading: boolean = true;
  

  showAddColumns = true;
  isSelectAllChecked = true;
  globalCols: any[];
  clonedCols: any[];
  userId: number;
  showPaginator: boolean = true;
  startIndex: number;

  exportCols: string[] = [];
  disableExport: boolean = true;

  @ViewChild(RmanOrderLinesBookingsVComponent) private childTable: RmanOrderLinesBookingsVComponent;

  constructor(
    private rmanOrderBookingsVService: RmanOrderBookingsVService
    , private router: Router
    , private confirmService: ConfirmationService
    , private rmanDealArrangementsService: RmanOpenDealArrangementsservice
    , private commonSharedService: CommonSharedService,
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



    this.globalCols = [

      { field: 'so', header: 'SO#', showField: true, display: "table-cell", type: 'number', drag: false },
      { field: 'orderNumModifier', header: 'Contract Modifier', showField: true, display: "table-cell", type: 'text', drag: false },
      { field: 'ouName', header: 'Operating Unit', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'endCustomer', header: 'Bill To Customer Name', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'customerNumber', header: 'Bill To Customer#', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'billToLocation', header: 'Bill To Location', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'shipToLocation', header: 'Ship To Location', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'salesrep', header: 'Sales Rep', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'priceList', header: 'Price List', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'customerPoNum', header: 'PO #', showField: true, display: "table-cell", type: 'number', drag: true },
      { field: 'bookingCurrency', header: 'Booking Currency', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'funcCurrencyCode', header: 'Functional Currency', showField: true, display: "table-cell", type: 'text', drag: true },
      { field: 'orderAcctdAmount', header: 'Ordered Amount', showField: true, display: "table-cell", type: 'round', drag: true },
      { field: 'orderBookedDate', header: 'Ordered Date', showField: true, display: "table-cell", type: 'date', drag: true }

    ];

    this.arrangementColumns = this.rmanDealArrangementsLabels.fieldLabels;

    this.columns = [];
    this.getTableColumns("rmanOrderBookingsV", "Bookings");
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
    this.commonSharedService.saveOrUpdateTableColumns("rmanOrderBookingsV", "Bookings", selectedCols, this.userId).then((response) => {
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

  exportExcel() {

    this.exportCols = [];

    for (let index = 0; index < this.columns.length; index++) {
      if (this.columns[index].showField) {
        this.exportCols.push(this.columns[index].field);
      }
    }
    let serviceUrl = this.rmanOrderBookingsVService.getServiceUrl(this.paginationOptions, this.rmanOrderBookingsV, 1, this.exportCols);
    window.location.href = serviceUrl;
  }

  reset(dt: Table) {

    this.paginationOptions = {};
    this.rmanOrderBookingsV = new RmanOrderBookingsVImpl();
    dt.reset();
  }

  getAllRmanOrderBookingsV() {
    this.loading = true;
    this.rmanOrderBookingsV.arrangementId = this.arrIdK;
    this.rmanOrderBookingsVService.getAllRmanOrderBookingsV(this.paginationOptions, this.rmanOrderBookingsV, this.exportCols).then((rmanOrderBookingsVList: any) => {
      this.loading = false;
      this.datasource = rmanOrderBookingsVList.content;
      this.rmanOrderBookingsVList = rmanOrderBookingsVList.content;
      if (this.rmanOrderBookingsVList.length > 0) {
        /*Begining of Code used for default First Row Selected*/
        this.selectedRmanOrderBookingsV = this.rmanOrderBookingsVList[0];
        this.pSno = this.selectedRmanOrderBookingsV.sno;
        this.childTable.parentCall(this.selectedRmanOrderBookingsV);
        /*End of Code used for default First Row Selected*/
      }
      this.totalElements = rmanOrderBookingsVList.totalElements;
      this.pageSize = rmanOrderBookingsVList.size;
      this.displaySearchDialog = false;
      this.disableExport = false;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }


  getRmanOrderBookingsV(event: any) {

    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loading = true;
    this.rmanOrderBookingsV.arrangementId = this.arrIdK;
    this.rmanOrderBookingsVService.getAllRmanOrderBookingsV(this.paginationOptions, this.rmanOrderBookingsV, this.exportCols).then((rmanOrderBookingsVList: any) => {
      this.loading = false;
      this.disableExport = false;
      this.datasource = rmanOrderBookingsVList.content;
      this.rmanOrderBookingsVList = rmanOrderBookingsVList.content;
      if (this.rmanOrderBookingsVList.length > 0) {
        /*Begining of Code used for default First Row Selected*/
        this.selectedRmanOrderBookingsV = this.rmanOrderBookingsVList[0];
        this.pSno = this.selectedRmanOrderBookingsV.sno;
        this.childTable.parentCall(this.selectedRmanOrderBookingsV);
        /*End of Code used for default First Row Selected*/
      }
      this.totalElements = rmanOrderBookingsVList.totalElements;
      this.pageSize = rmanOrderBookingsVList.size;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }

  delinkPo() {
    this.loading = true;
    if (!this.selectedRmanOrderBookingsV) {
      this.notificationService.showInfo('Please select one of the PO to deLink');
    } else {
      this.confirmService.confirm({
        message: 'Are you sure you want to delink the selected PO ' + this.selectedRmanOrderBookingsV.customerPoNum + '?',
        header: 'Confirmation',
        icon: '',
        accept: () => {
          this.rmanOrderBookingsVService.delinkPO(this.selectedRmanOrderBookingsV.customerPoNum, this.selectedRmanOrderBookingsV.arrangementId).then((data: any) => {
            this.loading = false;
            this.notificationService.showSuccess('PO ' + this.selectedRmanOrderBookingsV.customerPoNum + ' deLink successfully completed');
            this.getAllRmanOrderBookingsV();
          }).catch((err: any) => {
            this.loading = false;
            this.notificationService.showError(err.error.message);
          });
        },
        reject: () => {
          this.loading = false;
          this.notificationService.showWarning('You cancelled the Request of deLink PO' + this.selectedRmanOrderBookingsV.customerPoNum);
        }
      });
    }
  }

  okSolink() {
    this.loading = true;
    this.rmanOrderBookingsVService.getSoLink(this.selectedRmanOrderBookingsV.so, this.selectedRmanOrderBookingsV.arrangementId, this.selectedDeal.dealLineId).then((data: any) => {
      if (data[0].errorFlag == "N")
        this.notificationService.showSuccess(data[0].errorMessage);
      if (data[0].errorFlag == "Y")
        this.notificationService.showError(data[0].errorMessage);
      if (data[0].errorFlag == "W")
        this.notificationService.showError(data[0].errorMessage);
      this.displayDealsDialog = false;
      this.getAllRmanOrderBookingsV();

    });
  }
  getPolink() {
    this.loading = true;
    if (this.selectedArrangement.endCustomerNumber == this.selectedRmanOrderBookingsV.customerNumber) {
      this.rmanOrderBookingsVService.getPoLink(this.selectedRmanOrderBookingsV.customerPoNum, this.selectedRmanOrderBookingsV.arrangementId, this.selectedArrangement.poNumber, this.targetDealArrangementId).then((data: any) => {
        this.displayMergeDialog = false;
        this.getAllRmanOrderBookingsV();
        this.loading = false;
        this.notificationService.showSuccess('Successfully PO ' + this.selectedRmanOrderBookingsV.customerPoNum + ' Relink with the target PO ' + this.selectedArrangement.poNumber);

      }).catch((err: any) => {
        this.notificationService.showError(err.error.message);
        this.loading = false;
      });
    } else {
      this.loading = false;
      this.notificationService.showError('Relink denied due to both Selected and target PO belongs to different customers. or Select At least on of the arrangement line');

    }
  }


  showDialogToAdd() {

    this.newRmanOrderBookingsV = true;
    this.rmanOrderBookingsV = new RmanOrderBookingsVImpl();
    this.displayDialog = true;

  }


  save() {

    if (this.newRmanOrderBookingsV) {
      this.loading = true;
      this.rmanOrderBookingsVService.saveRmanOrderBookingsV(this.rmanOrderBookingsV).then((response: any) => {
        this.notificationService.showSuccess('Saved successfully');
        this.getAllRmanOrderBookingsV();
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while saving data');
        this.loading = false;
      });
    }
    else {
      this.loading = true;
      this.rmanOrderBookingsVService.updateRmanOrderBookingsV(this.rmanOrderBookingsV).then((response: any) => {
        this.notificationService.showSuccess('Updated successfully');
        this.getAllRmanOrderBookingsV();
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while updating data');
        this.loading = false;
      });
    }

    this.rmanOrderBookingsV = new RmanOrderBookingsVImpl();

    this.displayDialog = false;

  }


  delete(rmanOrderBookingsV: any) {
    this.rmanOrderBookingsV = rmanOrderBookingsV;
    this.displayDialog = false;
    if (window.confirm('Are you sure you want to delete this record?')) {
      this.rmanOrderBookingsVList.splice(this.findSelectedRmanOrderBookingsVIndex(), 1);
      this.loading = true;
      this.rmanOrderBookingsVService.deleteRmanOrderBookingsV(this.rmanOrderBookingsV).then((response: any) => {
        this.rmanOrderBookingsV = new RmanOrderBookingsVImpl();
        this.getAllRmanOrderBookingsV();
      });
    }

  }


  editRow(rmanOrderBookingsV: any) {
    this.newRmanOrderBookingsV = false;
    this.rmanOrderBookingsV = this.cloneRmanOrderBookingsV(rmanOrderBookingsV);
    this.displayDialog = true;

  }


  findSelectedRmanOrderBookingsVIndex(): number {
    return this.rmanOrderBookingsVList.indexOf(this.selectedRmanOrderBookingsV);
  }

  onRowSelect(event: any) {
    this.selectedRmanOrderBookingsV = event.data;
    this.pSno = this.selectedRmanOrderBookingsV.sno;
    this.childTable.parentCall(this.selectedRmanOrderBookingsV);

  }
  onRowUnselect(event) {
    this.childTable.parentCall('')
  }
  processMergeDeals() {
    if (this.selectedRmanOrderBookingsV) {

      this.displayMergeDialog = true;
    } else {
      this.notificationService.showError('No PO Line selected to Relink with target PO.');
    }

    this.selectedArrangement = {};
    this.rmanDealArrangementsSearch.poNumber = '';
    this.rmanDealArrangementsSearch.dealArrangementNumber = '';
    this.getAllRmanDealArrangements();

  }
  searchArrangements() {
    this.rmanDealArrangements = this.rmanDealArrangementsSearch;
    this.getAllRmanDealArrangements();
  }
  onRowArrgSelect(event: any) {
    this.selectedArrangement = event.data;
    this.targetDealArrangementId = this.selectedArrangement.dealArrangementId;
  }

  getAllRmanDealArrangements() {
    if (this.selectedRmanOrderBookingsV) {
      this.rmanDealArrangements.endCustomerNumber = this.selectedRmanOrderBookingsV.customerNumber;
    }
    this.loading = true;
    this.paginationOptions = {};
    this.rmanDealArrangementsService.getAllRmanDealArrangements(this.paginationOptions, this.rmanDealArrangements).then((rmanDealArrangementsList: any) => {
      this.datasource = rmanDealArrangementsList.content;
      this.rmanDealArrangementsList = rmanDealArrangementsList.content;
      this.rmanDealArrangementsList = this.rmanDealArrangementsList.filter((item: any) => {
        return (item.dealArrangementId != this.arrIdK);
      })
      this.totalArrgElements = rmanDealArrangementsList.totalElements - 1;
      this.arrgPageSize = rmanDealArrangementsList.size;
      this.displaySearchDialog = false;
      this.loading = false;
      this.disableExport = false;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }

  resetArrangements() {
    this.paginationOptions = {};
    this.rmanDealArrangements = new RmanOpenDealArrangementsImpl();
    this.rmanDealArrangementsSearch.poNumber = '';
    this.rmanDealArrangementsSearch.dealArrangementNumber = '';
    this.getAllRmanDealArrangements();
  }
  getRmanDealArrangements(event: any) {
    if (this.selectedRmanOrderBookingsV) {
      this.rmanDealArrangements.endCustomerNumber = this.selectedRmanOrderBookingsV.customerNumber;
    }

    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.arrgPageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loading = true;
    this.rmanDealArrangementsService.getAllRmanDealArrangements(this.paginationOptions, this.rmanDealArrangements).then((rmanDealArrangementsList: any) => {
      this.datasource = rmanDealArrangementsList.content;
      this.rmanDealArrangementsList = rmanDealArrangementsList.content;
      this.rmanDealArrangementsList = rmanDealArrangementsList.content.filter((item: any) => {
        return (item != null && item.dealArrangementId != this.arrIdK);
      })
      this.totalArrgElements = rmanDealArrangementsList.totalElements - 1;
      this.arrgPageSize = rmanDealArrangementsList.size;
      this.loading = false;
      this.disableExport = false;

    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }

  cloneRmanOrderBookingsV(c: RmanOrderBookingsV): RmanOrderBookingsV {
    let rmanOrderBookingsV: any = new RmanOrderBookingsVImpl();
    for (let prop in c) {
      rmanOrderBookingsV[prop] = c[prop];
    }
    return rmanOrderBookingsV;
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

    this.rmanOrderBookingsVSearch = new RmanOrderBookingsVImpl();

    if (this.isSerached == 0) {
      this.rmanOrderBookingsVSearch = new RmanOrderBookingsVImpl();
    }
    this.displaySearchDialog = true;

  }

  search() {

    this.isSerached = 1;
    this.rmanOrderBookingsV = this.rmanOrderBookingsVSearch;
    this.getAllRmanOrderBookingsV();
  }

  onBeforeToggle(evt: any) {
    this.collapsed = evt.collapsed;
  }

}


class RmanOrderBookingsVImpl {
  constructor(public customerNumber?: any, public billToLocation?: any, public so?: any, public priceList?: any, public bookingCurrency?: any, public customerPoNum?: any, public arrangementId?: any, public funcCurrencyCode?: any, public linkedDate?: any, public ouName?: any, public orderBookedDate?: any, public orderTrxAmount?: any, public shipToLocation?: any, public endCustomer?: any, public orderAcctdAmount?: any) { }
}

interface ILabels {
  [index: string]: string;
}
