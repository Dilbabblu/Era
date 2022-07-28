import { Component } from '@angular/core';
import { ConfirmationService } from 'primeng/api';
import { Table } from 'primeng/table';
import { NotificationService } from '../shared/notifications.service';
import { RmanEvents } from './rmanEvents';
import { RmanEventsLabels } from './rmanEventsLabels';
import { RmanEventsService } from './rmanEventsservice';
import { CommonSharedService } from '../shared/common.service';

declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');


@Component({
  templateUrl: './rmanEvents.component.html',
  selector: 'rmanEvents-data',
  providers: [RmanEventsService, ConfirmationService]
})

export class RmanEventsComponent {

  displayDialog: boolean;

  displaySearchDialog: boolean;

  rmanEvents: RmanEvents = new RmanEventsImpl();

  rmanEventsSearch: RmanEvents = new RmanEventsImpl();

  isSerached: number = 0;

  selectedRmanEvents: RmanEvents;

  newRmanEvents: boolean;

  rmanEventsList: RmanEvents[];

  cols: any[];
  //columns: ILabels;

  //columnOptions: any[];

  paginationOptions = {};

  pages: {};
  noData = appSettings.noData;

  datasource: any[];
  pageSize: number;
  totalElements: number;
  collapsed: boolean = true;
  
  dateFlag: boolean;
  loading: boolean;
  isSelectAllChecked = true;
  globalCols: any[];
  clonedCols: any[];
  userId: number;
  showPaginator: boolean = true;
  startIndex: number;
  showAddColumns = true;
  columns: any[];

  constructor(private rmanEventsService: RmanEventsService, private confirmationService: ConfirmationService,
    private notificationService: NotificationService,  private commonSharedService: CommonSharedService) {
    // generate list code
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
  }

  ngOnInit() {
 
    this.globalCols = [
      { field: 'orderNumber', header: 'SO#', showField: true, drag: false, display: "table-cell",type:'number'},
      { field: 'orderLineNo', header: 'SO Line#', showField: true, drag: true, display: "table-cell",type:'number' },
      { field: 'eventName', header: 'Event Name', showField: true, drag: true, display: "table-cell",type:'text'},
      { field: 'eventDate', header: 'Event Date', showField: true, drag: true, display: "table-cell",type:'date' },
      { field: 'productName', header: 'Product Name', showField: true, drag: true, display: "table-cell",type:'text' },
      { field: 'serviceStartDate', header: 'Service Start Date', showField: true, drag: true, display: "table-cell",type:'date' },
      { field: 'serviceEndDate', header: 'Service End Date' , showField: true, drag: true, display: "table-cell",type:'date'},
      { field: 'cogsAmount', header: 'COGS Amount' , showField: true, drag: true, display: "table-cell",type:'round'},
      { field: 'attribute1', header: 'Additional Discount' , showField: true, drag: true, display: "table-cell",type:'text'}
      ];

      this.columns = [];
      this.getTableColumns("rmanEvents", "Events");
   
   
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
    this.commonSharedService.saveOrUpdateTableColumns("rmanEvents", "Events", selectedCols, this.userId).then((response) => {
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
    //console.log(this.globalCols);
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


  reset(dt: Table) {
    this.paginationOptions = {};
    this.rmanEvents = new RmanEventsImpl();
    this.rmanEventsSearch = new RmanEventsImpl();
    dt.reset();
  }

  getAllRmanEvents() {
    this.loading = true;
    this.rmanEvents = this.rmanEventsSearch;
    this.rmanEventsService.getAllRmanEvents(this.paginationOptions, this.rmanEvents).then((rmanEventsList: any) => {
      this.loading = false;
      this.datasource = rmanEventsList.content;
      this.rmanEventsList = rmanEventsList.content;
      this.totalElements = rmanEventsList.totalElements;
      this.pageSize = rmanEventsList.size;
      this.displaySearchDialog = false;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }


  getRmanEvents(event: any) {

    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.rmanEvents = this.rmanEventsSearch;
    this.loading = true;
    this.rmanEventsService.getAllRmanEvents(this.paginationOptions, this.rmanEvents).then((rmanEventsList: any) => {
      this.loading = false;
      this.datasource = rmanEventsList.content;
      this.rmanEventsList = rmanEventsList.content;
      this.totalElements = rmanEventsList.totalElements;
      this.pageSize = rmanEventsList.size;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });

  }


  showDialogToAdd() {
    this.newRmanEvents = true;
    this.rmanEvents = new RmanEventsImpl();
    this.displayDialog = true;

  }

  dateCheck(event: any) {
    if (this.rmanEvents.serviceStartDate && this.rmanEvents.serviceEndDate) {
      if (this.rmanEvents.serviceStartDate > this.rmanEvents.serviceEndDate) {
        this.dateFlag = true;
      }
      else {
        this.dateFlag = false;
      }
    }
  }


  save() {
    if (this.newRmanEvents) {
      this.loading = true;
      this.rmanEventsService.saveRmanEvents(this.rmanEvents).then((response: any) => {

        this.getAllRmanEvents();
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while saving the data');
        this.loading = false;
      });
    }
    else {
      this.loading = true;
      let rmaneventsInfo = this.rmanEvents;
      this.rmanEventsService.updateRmanEvents(this.rmanEvents).then((response: any) => {
        this.rmanEventsService.revRecogEvent(rmaneventsInfo).then((resp: any) => {
        });
        this.notificationService.showSuccess('Updated successfully');
        this.getAllRmanEvents();
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while updating the data');
        this.loading = false;
      });
    }

    this.rmanEvents = new RmanEventsImpl();
    this.displayDialog = false;

  }


  delete(rmanEvents: any) {
    this.rmanEvents = rmanEvents;
    this.displayDialog = false;
    this.confirmationService.confirm({
      message: 'Are you sure you want to delete this record?',
      header: 'Confirmation',
      icon: '',
      accept: () => {
        this.rmanEventsList.splice(this.findSelectedRmanEventsIndex(), 1);
        this.loading = true;
        this.rmanEventsService.deleteRmanEvents(this.rmanEvents).then(response => {
          this.rmanEvents = new RmanEventsImpl();
          this.getAllRmanEvents();
        });
        this.notificationService.showSuccess('Deleted successfully');
      },
      reject: () => {
        this.notificationService.showError('You have rejected');
      }
    });



  }

  editRow(rmanEvents: any) {
    this.newRmanEvents = false;
    this.dateFlag = false;
    this.rmanEvents = this.cloneRmanEvents(rmanEvents);
    if (this.rmanEvents.eventDate) {
      this.rmanEvents.eventDate = new Date(this.rmanEvents.eventDate);
    }
    if (this.rmanEvents.serviceStartDate) {
      this.rmanEvents.serviceStartDate = new Date(this.rmanEvents.serviceStartDate);
    }
    if (this.rmanEvents.serviceEndDate) {
      this.rmanEvents.serviceEndDate = new Date(this.rmanEvents.serviceEndDate);
    }

    this.displayDialog = true;

  }


  findSelectedRmanEventsIndex(): number {
    return this.rmanEventsList.indexOf(this.selectedRmanEvents);
  }

  onRowSelect(event: any) {

  }

  cloneRmanEvents(c: RmanEvents): RmanEvents {
    let rmanEvents = new RmanEventsImpl();
    for (let prop in c) {
      rmanEvents[prop] = c[prop];
    }
    return rmanEvents;
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
  cancelAddEdit() {
    this.displayDialog = false;
    this.rmanEvents = new RmanEventsImpl();
  }
  showDialogToSearch() {

    this.rmanEventsSearch = new RmanEventsImpl();

    if (this.isSerached == 0) {
      this.rmanEventsSearch = new RmanEventsImpl();
    }
    this.displaySearchDialog = true;

  }

  search() {

    this.isSerached = 1;
    this.rmanEvents = this.rmanEventsSearch;
    this.paginationOptions = {};
    this.getAllRmanEvents();
  }

  onBeforeToggle(evt: any) {
    this.collapsed = evt.collapsed;
  }

}


class RmanEventsImpl implements RmanEvents {
  constructor(public createdBy?: any, public lastUpdatedBy?: any, public eventDate?: any, public transactionSource?: any, public errorMessage?: any, public orderLineId?: any, public eventName?: any, public orderLineNo?: any, public creationDate?: any, public lastUpdateLogin?: any, public lastUpdateDate?: any, public transactionType?: any, public status?: any, public orderNumber?: any, public cogsAmount?: any, public serviceStartDate?: any, public serviceEndDate?: any, public productName?: any) { }
}

interface ILabels {
  [index: string]: string;
}
