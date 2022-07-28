import { Component, OnInit } from '@angular/core';
import { Table } from 'primeng/table';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanInvoiceLinesV } from './rmanInvoiceLinesV';
import { RmanInvoiceLinesVService } from './rmanInvoiceLinesVservice';

declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
    templateUrl: './rmanInvoiceLinesV.component.html',
    selector: 'rmanInvoiceLinesV-data',
    providers: [RmanInvoiceLinesVService]
})

export class RmanInvoiceLinesVComponent implements OnInit {
    noData = appSettings.noData;
    displayDialog: boolean;

    displaySearchDialog: boolean;

    rmanInvoiceLinesV: any = new RmanInvoiceLinesVImpl();

    rmanInvoiceLinesVSearch: any = new RmanInvoiceLinesVImpl();

    isSerached: number = 0;

    selectedRmanInvoiceLinesV: RmanInvoiceLinesV;

    newRmanInvoiceLinesV: boolean;

    rmanInvoiceLinesVList: RmanInvoiceLinesV[];

    cols: any[];
    columns: any[];

    columnOptions: any[];

    paginationOptions = {};

    pages: {};

    sourceInvoiceId: number;
    datasource: any[];
    pageSize: number;
    totalElements: number;
    collapsed: boolean = true;
    masterData: any;
    loading: boolean;
    isSelectAllChecked = true;
    globalCols: any[];
    clonedCols: any[];
    userId: number;
    showPaginator: boolean = true;
    startIndex: number;
    showAddColumns = true;
    exportCols: string[] =[];
    disableExport: boolean = true;


    constructor(private rmanInvoiceLinesVService: RmanInvoiceLinesVService, private commonSharedService: CommonSharedService,
      private notificationService:NotificationService) {
        // generate list code
        this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    }

    ngOnInit() {
        this.globalCols = 	  [
            { field: 'invoiceLineNumber', header: 'Invoice Line Number', showField: true, drag: false, display: "table-cell",type:'number'},
            { field: 'lineType', header: 'Line Type', showField: true, drag: true, display: "table-cell",type:'text' },
            { field: 'quantity', header: 'Quantity', showField: true, drag: true, display: "table-cell",type:'number'},
            { field: 'unitSellingPrice', header: 'Unit Selling Price', showField: true, drag: true, display: "table-cell",type:'round' },
            { field: 'salesOrderNumber', header: 'SO #', showField: true, drag: true, display: "table-cell",type:'number' },
            { field: 'sourceLineNumber', header: 'SO Line #', showField: true, drag: true, display: "table-cell",type:'number' },
            { field: 'revenueAmount', header: 'Invoice Line Amount' , showField: true, drag: true, display: "table-cell",type:'round'},
            { field: 'usdAmount', header: 'Amount in FC', drag: true, showField: true, display: "table-cell",type:'round' },
            { field: 'attribute1', header: 'Attribute 1', showField: true, drag: true, display: "table-cell",type:'text' },
            { field: 'attribute2', header: 'Attribute 2', showField: true, drag: true, display: "table-cell",type:'text' },
            { field: 'attribute3', header: 'Attribute 3', showField: true, drag: true, display: "table-cell",type:'text' },
            { field: 'attribute4', header: 'Attribute 4', showField: true, drag: true, display: "table-cell",type:'text' },
            { field: 'attribute5', header: 'Attribute 5', showField: true, drag: true, display: "table-cell",type:'text' }
            ];

            this.columns = [];
            this.getTableColumns("rmanInvoiceLinesV", "Invoice Lines");
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
              if(response.tableColumns.indexOf(col.field) !== -1) {
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
        this.commonSharedService.saveOrUpdateTableColumns("rmanInvoiceLinesV", "Invoice Lines", selectedCols, this.userId).then((response) => {
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
    
      selectColumns(col: any){
        let cols = this.globalCols.filter(item => !item.showField);
        if (cols.length > 0) {
          this.isSelectAllChecked = false;
        } else {
          this.isSelectAllChecked = true;
        }
      }
    
      onSelectAll(){
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
      
        onConfiguringColumns(event: any){
          this.clonedCols = JSON.parse(JSON.stringify(this.globalCols));
          this.showAddColumns = false;
    }
    
    closeConfigureColumns(event: any){
      this.showAddColumns = true;
      this.globalCols = this.clonedCols;
      let configCol = this.globalCols.filter(item => !item.showField);
      this.isSelectAllChecked = !(configCol.length > 0);
    }

    parentCall(data) {
        this.masterData = data;
        if (data != '') {
            this.sourceInvoiceId = data.sourceInvoiceId;
            this.getAllRmanInvoiceLinesV();
        } else {
            this.sourceInvoiceId = null;
            this.rmanInvoiceLinesVList = [];
        }
    }


    onBeforeToggle(evt: any) {
        this.collapsed = evt.collapsed;
    }


    exportExcel() {
        this.exportCols =[];
        for (let index = 0; index < this.columns.length; index++) {
                if(this.columns[index].showField){
                    this.exportCols.push(this.columns[index].field);
                }
             }
    
        let serviceUrl = this.rmanInvoiceLinesVService.getServiceUrl(this.paginationOptions, { 'sourceInvoiceId': this.sourceInvoiceId },this.exportCols, 1);
        window.location.href = serviceUrl;

    }
    reset(dt: Table) {
        this.paginationOptions = {};
        this.rmanInvoiceLinesV = {};
		dt.reset();
        this.isSerached = 0;

    }



    getAllRmanInvoiceLinesV() {
        if (this.sourceInvoiceId != undefined || this.sourceInvoiceId != null) {
            this.loading = true;
            this.rmanInvoiceLinesVService.getAllRmanInvoiceLinesV(this.paginationOptions, { 'sourceInvoiceId': this.sourceInvoiceId }, this.exportCols).then((rmanInvoiceLinesVList: any) => {
                this.datasource = rmanInvoiceLinesVList.content;
                this.rmanInvoiceLinesVList = rmanInvoiceLinesVList.content;
                this.totalElements = rmanInvoiceLinesVList.totalElements;
                this.pageSize = rmanInvoiceLinesVList.size;
                this.displaySearchDialog = false;
                this.loading = false;
                this.disableExport = false;
            });
        } else {
            this.totalElements = 1;
            this.pageSize = 1;
            //AYAR-269 - Added by Madhu on 27-05-2021
            this.disableExport = false;
        }
    }


    getRmanInvoiceLinesV(event: any) {
        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        if (this.sourceInvoiceId != undefined || this.sourceInvoiceId != null) {
            this.loading = true;
            this.rmanInvoiceLinesVService.getAllRmanInvoiceLinesV(this.paginationOptions, { 'sourceInvoiceId': this.sourceInvoiceId },this.exportCols).then((rmanInvoiceLinesVList: any) => {
                this.datasource = rmanInvoiceLinesVList.content;
                this.rmanInvoiceLinesVList = rmanInvoiceLinesVList.content;
                this.totalElements = rmanInvoiceLinesVList.totalElements;
                this.pageSize = rmanInvoiceLinesVList.size;
                this.loading = false;
                this.disableExport = false;
            });
        } else {
            this.totalElements = 1;
            this.pageSize = 1;
             //AYAR-269 - Added by Madhu on 27-05-2021
            this.disableExport = false;
        }

    }


    showDialogToAdd() {
        this.newRmanInvoiceLinesV = true;
        this.rmanInvoiceLinesV = new RmanInvoiceLinesVImpl();
        this.displayDialog = true;
    }


    save() {

        if (this.newRmanInvoiceLinesV) {
            this.rmanInvoiceLinesVService.saveRmanInvoiceLinesV(this.rmanInvoiceLinesV).then((response: any) => {
                this.getAllRmanInvoiceLinesV();
            });
        }
        else {
            this.rmanInvoiceLinesVService.updateRmanInvoiceLinesV(this.rmanInvoiceLinesV).then((response: any) => {
                this.getAllRmanInvoiceLinesV();
            });
        }

        this.rmanInvoiceLinesV = new RmanInvoiceLinesVImpl();

        this.displayDialog = false;

    }


    delete(rmanInvoiceLinesV: any) {
        this.rmanInvoiceLinesV = rmanInvoiceLinesV;
        this.displayDialog = false;
        if (window.confirm('Are you sure you want to delete this record?')) {
            this.rmanInvoiceLinesVList.splice(this.findSelectedRmanInvoiceLinesVIndex(), 1);
            this.rmanInvoiceLinesVService.deleteRmanInvoiceLinesV(this.rmanInvoiceLinesV).then(response => {
                this.rmanInvoiceLinesV = new RmanInvoiceLinesVImpl();
                this.getAllRmanInvoiceLinesV();
            });
        }

    }

    editRow(rmanInvoiceLinesV: any) {
        this.newRmanInvoiceLinesV = false;
        this.rmanInvoiceLinesV = this.cloneRmanInvoiceLinesV(rmanInvoiceLinesV);
        this.displayDialog = true;
    }


    findSelectedRmanInvoiceLinesVIndex(): number {
        return this.rmanInvoiceLinesVList.indexOf(this.selectedRmanInvoiceLinesV);
    }

    onRowSelect(event: any) {

    }

    cloneRmanInvoiceLinesV(c: RmanInvoiceLinesV): RmanInvoiceLinesV {
        let rmanInvoiceLinesV: any = new RmanInvoiceLinesVImpl();
        for (let prop in c) {
            rmanInvoiceLinesV[prop] = c[prop];
        }
        return rmanInvoiceLinesV;
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

        this.rmanInvoiceLinesVSearch = new RmanInvoiceLinesVImpl();

        if (this.isSerached == 0) {
            this.rmanInvoiceLinesVSearch = new RmanInvoiceLinesVImpl();
        }
        this.displaySearchDialog = true;

    }

    search() {

        this.isSerached = 1;
        this.rmanInvoiceLinesV = this.rmanInvoiceLinesVSearch;
        this.getAllRmanInvoiceLinesV();
    }



}


class RmanInvoiceLinesVImpl implements RmanInvoiceLinesV {
    constructor(public sourceInvoiceId?: any, public sourceLineNumber?: any, public quantity?: any, public invoiceLineNumber?: any, public salesOrderNumber?: any, public lineType?: any, public salesOrderLineId?: any, public sourceInvoiceLineId?: any, public rmanInvoiceLineId?: any, public usdAmount?: any, public revenueAmount?: any,
        public unitSellingPrice?: any, public glDate?: any, public debitAccount?: any, public creditAccount?: any, public attribute1?: any, public attribute2?: any, public attribute3?: any, public attribute4?: any, public attribute5?: any) { }
}


interface ILabels {
    [index: string]: string;
}
