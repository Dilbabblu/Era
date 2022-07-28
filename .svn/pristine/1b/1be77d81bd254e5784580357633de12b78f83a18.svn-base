import { Component } from '@angular/core';
import { ConfirmationService } from 'primeng/api';
import { Table } from 'primeng/table';
import { RmanLegalEntitiesService } from '../rmanLegalEntities/rmanLegalEntitiesservice';
import { NotificationService } from '../shared/notifications.service';
import { RmanAccountSetup } from './rmanAccountSetup';
import { RmanAccountSetupLabels } from './rmanAccountSetupLabels';
import { RmanAccountSetupService } from './rmanAccountSetupservice';
import { CommonSharedService } from '../shared/common.service';

declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
  templateUrl: './rmanAccountSetup.component.html',
  selector: 'rmanAccountSetup-data',
  providers: [RmanAccountSetupService, ConfirmationService, RmanLegalEntitiesService]
})

export class RmanAccountSetupComponent {

  displayDialog: boolean;

  displaySearchDialog: boolean;



  rmanAccountSetup: any = new RmanAccountSetupImpl();

  rmanAccountSetupSearch: RmanAccountSetup = new RmanAccountSetupImpl();

  isSerached: number = 0;

  selectedRmanAccountSetup: RmanAccountSetup;

  newRmanAccountSetup: boolean;

  rmanAccountSetupList: RmanAccountSetup[];

  cols: any[];

  columnOptions: any[];

  paginationOptions = {};

  pages: {};

  datasource: any[];
  pageSize: number;
  totalElements: number;

  collapsed: boolean = true;
  noData = appSettings.noData;
  loading: boolean;
  rmanLegalEntitiesList: any[] = [];
  rmanLegalEntities: any[];
  isSelectAllChecked = true;
    globalCols: any[];
    clonedCols: any[];
    userId: number;
    showPaginator: boolean = true;
    startIndex: number;
    showAddColumns = true;
    columns: any[];


  constructor(private rmanAccountSetupService: RmanAccountSetupService, private confirmationService: ConfirmationService, private rmanLegalEntitiesService: RmanLegalEntitiesService, private notificationService: NotificationService,  private commonSharedService: CommonSharedService) {
    // generate list code
    this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
  }

  ngOnInit() {

    this.rmanLegalEntitiesService.getAllRmanLegalEntities(this.paginationOptions, {}, 'Y').then((rmanLegalEntitiesList: any) => {
      this.rmanLegalEntitiesList = rmanLegalEntitiesList.content;
      this.prepareRmanLegalEntitiesObject();
    })
    this.globalCols = [
      { field: 'legalEntityName', header: 'Legal Entity', showField: true, drag: true, display: "table-cell",type:'text'},
      { field: 'accountingStructure', header: 'Accounting Structure', showField: true, drag: true, display: "table-cell",type:'text' },
      { field: 'name', header: 'Name', showField: true, drag: true, display: "table-cell",type:'text'},
      { field: 'revenue', header: 'Revenue', showField: true, drag: true, display: "table-cell",type:'text' },
      { field: 'deferredRevenue', header: 'Deferred Revenue', showField: true, drag: true, display: "table-cell",type:'text' },
      { field: 'cearingAccount', header: 'Clearing Account', showField: true, drag: true, display: "table-cell",type:'text' },
      { field: 'defRevenueContingency', header: 'Deferred Revenue Contingency' , showField: true, drag: true, display: "table-cell",type:'text'},
      { field: 'contractLiability', header: 'Contract Liability' , showField: true, drag: true, display: "table-cell",type:'text'},
      { field: 'contractAsset', header: 'Contract Asset' , showField: true, drag: true, display: "table-cell",type:'text'} 
    ];

      this.columns = [];
      this.getTableColumns("rmanAccountSetup", "Account Setup");
    //let rmanAccountSetupLabels = new RmanAccountSetupLabels();
    //this.columns = rmanAccountSetupLabels.fieldLabels;
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
    this.commonSharedService.saveOrUpdateTableColumns("rmanAccountSetup", "Account Setup", selectedCols, this.userId).then((response) => {
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
    this.rmanAccountSetup = new RmanAccountSetupImpl();
    dt.reset();
  }

  getAllRmanAccountSetup() {
    this.loading = true;
    this.rmanAccountSetupService.getAllRmanAccountSetup(this.paginationOptions, this.rmanAccountSetup).then((rmanAccountSetupList: any) => {
      this.loading = false;
      this.datasource = rmanAccountSetupList.content;
      this.rmanAccountSetupList = rmanAccountSetupList.content;
      this.totalElements = rmanAccountSetupList.totalElements;
      this.pageSize = rmanAccountSetupList.size;
      this.displaySearchDialog = false;
      this.rmanAccountSetupSearch = new RmanAccountSetupImpl();
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });
  }


  getRmanAccountSetup(event: any) {
    let first: number = event.first;
    let rows: number = event.rows;
    let pageNumber: number = first / rows;
    this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
    this.loading = true;
    this.rmanAccountSetupService.getAllRmanAccountSetup(this.paginationOptions, this.rmanAccountSetup).then((rmanAccountSetupList: any) => {
      this.loading = false;
      this.datasource = rmanAccountSetupList.content;
      this.rmanAccountSetupList = rmanAccountSetupList.content;
      this.totalElements = rmanAccountSetupList.totalElements;
      this.pageSize = rmanAccountSetupList.size;
    }).catch((err: any) => {
      this.notificationService.showError('Error occured while getting data');
      this.loading = false;
    });

  }

  onBeforeToggle(evt: any) {
    this.collapsed = evt.collapsed;
  }

  showDialogToAdd() {
    this.newRmanAccountSetup = true;
    this.rmanAccountSetup = new RmanAccountSetupImpl();
    this.displayDialog = true;
  }

  save() {
    this.rmanAccountSetup.legalEntityName = this.rmanLegalEntities.filter((item: any) => item.value == this.rmanAccountSetup.legalEntityId)[0].label;
    if (this.newRmanAccountSetup) {
      this.loading = true;
      this.rmanAccountSetupService.saveRmanAccountSetup(this.rmanAccountSetup).then((response: any) => {
        this.notificationService.showSuccess('Saved successfully');
        this.getAllRmanAccountSetup();
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while saving the data');
        this.loading = false;
      });
    }
    else {
      this.loading = true;
      this.rmanAccountSetupService.updateRmanAccountSetup(this.rmanAccountSetup).then((response: any) => {
        this.notificationService.showSuccess('Updated successfully');
        this.getAllRmanAccountSetup();
      }).catch((err: any) => {
        this.notificationService.showError('Error occured while updating the data');
        this.loading = false;
      });
    }

    this.rmanAccountSetup = new RmanAccountSetupImpl();
    this.displayDialog = false;
  }


  delete(rmanAccountSetup: any) {
    this.rmanAccountSetup = rmanAccountSetup;
    this.displayDialog = false;
    this.confirmationService.confirm({
      message: 'Are you sure you want to delete this record?',
      header: 'Confirmation',
      icon: '',
      accept: () => {
        this.rmanAccountSetupList.splice(this.findSelectedRmanAccountSetupIndex(), 1);
        this.loading = true;
        this.rmanAccountSetupService.deleteRmanAccountSetup(this.rmanAccountSetup).then(response => {
          this.loading = false;
          this.rmanAccountSetup = new RmanAccountSetupImpl();
          this.getAllRmanAccountSetup();
        });

        this.notificationService.showSuccess('Deleted successfully');

      },
      reject: () => {
        this.notificationService.showWarning('You have rejected');
      }
    });
  }

  editRow(rmanAccountSetup: any) {
    this.newRmanAccountSetup = false;
    this.rmanAccountSetup = this.cloneRmanAccountSetup(rmanAccountSetup);
    this.displayDialog = true;

  }

  prepareRmanLegalEntitiesObject() {
    let rmanLegalEntitiesTempObj: any = [{ label: appSettings.dropDownOptions.selectLegalEntity, value: null }];
    this.rmanLegalEntitiesList.forEach((rmanLegalEntities) => {
      rmanLegalEntitiesTempObj.push({ label: rmanLegalEntities.name, value: rmanLegalEntities.legalEntityId });
    });
    this.rmanLegalEntities = rmanLegalEntitiesTempObj;
  }


  findSelectedRmanAccountSetupIndex(): number {
    return this.rmanAccountSetupList.indexOf(this.selectedRmanAccountSetup);
  }

  onRowSelect(event: any) {

  }

  cloneRmanAccountSetup(c: RmanAccountSetup): RmanAccountSetup {
    let rmanAccountSetup = new RmanAccountSetupImpl();
    for (let prop in c) {
      rmanAccountSetup[prop] = c[prop];
    }
    return rmanAccountSetup;
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
    this.rmanAccountSetup = new RmanAccountSetupImpl();
  }
  showDialogToSearch() {

    this.rmanAccountSetupSearch = new RmanAccountSetupImpl();

    if (this.isSerached == 0) {
      this.rmanAccountSetupSearch = new RmanAccountSetupImpl();
    }
    this.displaySearchDialog = true;

  }

  search() {
    this.displaySearchDialog = false;
    this.isSerached = 1;
    this.rmanAccountSetup = this.rmanAccountSetupSearch;
    this.paginationOptions = {};
    this.getAllRmanAccountSetup();
  }



}


class RmanAccountSetupImpl implements RmanAccountSetup {
  constructor(public accountingStructure?: any, public revenue?: any, public cogs?: any, public deferredCogs?: any, public provision?: any, public amortizationDeferrals?: any, public name?: any, public deferredRevenue?: any, public cearingAccount?: any, public defRevenueContingency?: any, public contractLiability?: any, public contractAsset?: any, public acctSetupId?: any,
    public legalEntityId?: any,
    public legalEntityName?: any) { }
}

interface ILabels {
  [index: string]: string;
}
