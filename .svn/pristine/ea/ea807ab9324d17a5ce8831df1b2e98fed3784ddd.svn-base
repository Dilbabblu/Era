import { Component } from '@angular/core';
import { ConfirmationService } from 'primeng/api';
import { Table } from 'primeng/table';
import { RmanLookupsVService } from '../rmanLookupsV/rmanLookupsVservice';
import { NotificationService } from '../shared/notifications.service';
import { UploadService } from '../shared/upload.service';
import { RmanGlAccounts } from './rmanGlAccounts';
import { RmanGlAccountsLabels } from './rmanGlAccountsLabels';
import { RmanGlAccountsService } from './rmanGlAccountsservice';
import { CommonSharedService } from '../shared/common.service';

declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');
@Component({
    templateUrl: './rmanGlAccounts.component.html',
    selector: 'rmanGlAccounts-data',
    providers: [RmanGlAccountsService, ConfirmationService]
})

export class RmanGlAccountsComponent {

    displayDialog: boolean;

    collapsed: boolean = true;

    displaySearchDialog: boolean;

    displayGLAccountsDialog: boolean = false;

    uploadLoading: boolean = false;

    rmanGlAccounts: RmanGlAccounts = new RmanGlAccountsImpl();

    rmanGlAccountsSearch: RmanGlAccounts = new RmanGlAccountsImpl();

    isSerached: number = 0;

    selectedRmanGlAccounts: RmanGlAccounts;

    newRmanGlAccounts: boolean;

    rmanGlAccountsList: RmanGlAccounts[];

    cols: any[];
   // columns: ILabels;
    noData = appSettings.noData;
    columnOptions: any[];

    paginationOptions = {};

    pages: {};

    datasource: any[];
    pageSize: number;
    totalElements: number;

    rmanLookupsVList: any[] = [];
    rmanLookupsV: any[];
    isSelectAllChecked = true;
    globalCols: any[];
    clonedCols: any[];
    userId: number;
    showPaginator: boolean = true;
    startIndex: number;
    showAddColumns = true;
    columns: any[];
    loading: boolean;
    constructor(private rmanGlAccountsService: RmanGlAccountsService, private rmanLookupsVService: RmanLookupsVService, private confirmationService: ConfirmationService,
        private notificationService: NotificationService,public _uploadService:UploadService,  private commonSharedService: CommonSharedService) {

        // generate list code
        this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
        this.loading = true;
        this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions, { 'lookupTypeName': 'GL_Account_Type' }).then((rmanLookupsVList: any) => {
            this.loading = false;
            this.rmanLookupsVList = rmanLookupsVList.content;
            this.prepareRmanLookupsVObject();
        });



    }

    ngOnInit() {
        this.globalCols = [
            { field: 'accountId', header: 'Account ID', showField: true, drag: false, display: "table-cell",type:'number'},
            { field: 'sourceAccountId', header: 'Source Account ID', showField: true, drag: true, display: "table-cell",type:'number' },
            { field: 'accountType', header: 'Account Type', showField: true, drag: true, display: "table-cell",type:'text'},
            { field: 'accountingString', header: 'Accounting String', showField: true, drag: true, display: "table-cell",type:'text' },
            { field: 'segment1', header: 'Company', showField: true, drag: true, display: "table-cell",type:'text' },
            { field: 'segment2', header: 'Division', showField: true, drag: true, display: "table-cell",type:'text' },
            { field: 'segment3', header: 'Department' , showField: true, drag: true, display: "table-cell",type:'text'},
            { field: 'segment4', header: 'Account' , showField: true, drag: true, display: "table-cell",type:'text'},
            { field: 'segment5', header: 'TCID' , showField: true, drag: true, display: "table-cell",type:'text'},
            { field: 'segment6', header: 'Unspecified' , showField: true, drag: true, display: "table-cell",type:'text'},
            { field: 'enabledFlag', header: 'Enabled Flag' , showField: true, drag: true, display: "table-cell",type:'text'}
            
            ];
    
            this.columns = [];
            this.getTableColumns("rmanGlAccounts", "GL Accounts");
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
        this.commonSharedService.saveOrUpdateTableColumns("rmanGlAccounts", "GL Accounts", selectedCols, this.userId).then((response) => {
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
        this.rmanGlAccounts = new RmanGlAccountsImpl();
        dt.reset();

    }

    transformRmanLookupsV(rmanLookupsV: any) {
        if (rmanLookupsV)
            return rmanLookupsV.lookupDescription;
    }

    getAllRmanGlAccounts() {
        this.loading = true;
        this.rmanGlAccountsService.getAllRmanGlAccounts(this.paginationOptions, this.rmanGlAccounts).then((rmanGlAccountsList: any) => {
            this.loading = false;
            this.datasource = rmanGlAccountsList.content;
            this.rmanGlAccountsList = rmanGlAccountsList.content;
            this.totalElements = rmanGlAccountsList.totalElements;
            this.pageSize = rmanGlAccountsList.size;
            this.displaySearchDialog = false;
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
        });
    }


    getRmanGlAccounts(event: any) {

        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.loading = true;
        this.rmanGlAccountsService.getAllRmanGlAccounts(this.paginationOptions, this.rmanGlAccounts).then((rmanGlAccountsList: any) => {
            this.loading = false;
            this.datasource = rmanGlAccountsList.content;
            this.rmanGlAccountsList = rmanGlAccountsList.content;
            this.totalElements = rmanGlAccountsList.totalElements;
            this.pageSize = rmanGlAccountsList.size;
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
        });

    }


    showDialogToAdd() {

        this.newRmanGlAccounts = true;
        this.rmanGlAccounts = new RmanGlAccountsImpl();
        this.displayDialog = true;
        this.prepareRmanLookupsVObject();

    }


    save() {

        if (this.newRmanGlAccounts) {
            this.loading = true;
            this.rmanGlAccountsService.saveRmanGlAccounts(this.rmanGlAccounts).then((response: any) => {
                this.notificationService.showSuccess('Saved successfully');
                this.getAllRmanGlAccounts();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while saving data');
                this.loading = false;
            });
        }
        else {
            this.loading = true;
            this.rmanGlAccountsService.updateRmanGlAccounts(this.rmanGlAccounts).then((response: any) => {
                this.notificationService.showSuccess('Updated successfully');
                this.getAllRmanGlAccounts();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while updating data');
                this.loading = false;
            });
        }

        this.rmanGlAccounts = new RmanGlAccountsImpl();

        this.displayDialog = false;

    }


    delete(rmanGlAccounts: any) {
        this.rmanGlAccounts = rmanGlAccounts;
        this.displayDialog = false;

        this.confirmationService.confirm({
            message: 'Are you sure you want to delete this record?',
            header: 'Confirmation',
            icon: '',
            accept: () => {
                this.rmanGlAccountsList.splice(this.findSelectedRmanGlAccountsIndex(), 1);
                this.loading = true;
                this.rmanGlAccountsService.deleteRmanGlAccounts(this.rmanGlAccounts).then(response => {
                    this.loading = false;
                    this.rmanGlAccounts = new RmanGlAccountsImpl();
                    this.getAllRmanGlAccounts();
                });
                this.notificationService.showSuccess('Deleted successfully');
            },
            reject: () => {
                this.notificationService.showWarning('You have rejected');
            }
        });


    }

    editRow(rmanGlAccounts: any) {
        this.newRmanGlAccounts = false;
        this.rmanGlAccounts = this.cloneRmanGlAccounts(rmanGlAccounts);
        this.displayDialog = true;
        this.prepareRmanLookupsVObject();

    }


    findSelectedRmanGlAccountsIndex(): number {
        return this.rmanGlAccountsList.indexOf(this.selectedRmanGlAccounts);
    }

    onRowSelect(event: any) {

    }

    cloneRmanGlAccounts(c: RmanGlAccounts): RmanGlAccounts {
        let rmanGlAccounts = new RmanGlAccountsImpl();
        for (let prop in c) {
            rmanGlAccounts[prop] = c[prop];
        }
        return rmanGlAccounts;
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
        this.rmanGlAccounts = new RmanGlAccountsImpl();
    }

    showDialogToSearch() {

        this.rmanGlAccountsSearch = new RmanGlAccountsImpl();

        if (this.isSerached == 0) {
            this.rmanGlAccountsSearch = new RmanGlAccountsImpl();
        }
        this.displaySearchDialog = true;

    }
    importFile() {
        this._uploadService.uploadDialog = true;
        this.displayGLAccountsDialog = true;
    }

    showUploadLoader() {
        this.uploadLoading = true;
    }

    onGLAccountsUpload(event: any) {
        this.displayGLAccountsDialog = false;
        
        this.notificationService.showSuccess('File Uploaded successfully');
        this.uploadLoading = false;
    }

    onErrorGLAccountsFileupload(event: any) {
        
        this.displayGLAccountsDialog = false;
        this.uploadLoading = false;
        let msg: string = "";
        msg += event.files[0].name + " file upload process failed due to ";
        if (event.xhr.response) {
            msg += JSON.parse(event.xhr.response).message
        }
        this.notificationService.showError(msg);

    }

    fileUploadHandler(event: any, url:any){
        this._uploadService.processUpload(event,url);
    }

    cancelGLAccountsUpload() {
        this._uploadService.uploadDialog = false;
        this.displayGLAccountsDialog = false;
    }
    search() {

        this.isSerached = 1;
        this.rmanGlAccounts = this.rmanGlAccountsSearch;
        this.paginationOptions = {};
        this.getAllRmanGlAccounts();
    }

    onBeforeToggle(evt: any) {
        this.collapsed = evt.collapsed;
    }

    prepareRmanLookupsVObject() {
        let rmanLookupsVTempObj: any = [{ label: '--Select Account Type--', value: null }];
        this.rmanLookupsVList.forEach((rmanLookupsV) => {
            rmanLookupsVTempObj.push({ label: rmanLookupsV.lookupDescription, value: rmanLookupsV.lookupCode });
        });

        this.rmanLookupsV = rmanLookupsVTempObj;

    }
}


class RmanGlAccountsImpl implements RmanGlAccounts {
    constructor(public createdBy?: any, public lastUpdatedBy?: any, public segment10?: any, public accountType?: any, public accountId?: any, public sourceLedgerId?: any, public creationDate?: any, public segment2?: any, public segment1?: any, public enabledFlag?: any, public lastUpdateDate?: any, public segment8?: any, public segment7?: any, public segment9?: any, public accountingString?: any, public segment4?: any, public ledgerId?: any, public segment3?: any, public segment6?: any, public segment5?: any, public sourceAccountId?: any) { }
}

interface ILabels {
    [index: string]: string;
}
