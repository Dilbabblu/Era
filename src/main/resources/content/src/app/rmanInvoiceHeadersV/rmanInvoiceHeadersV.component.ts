import { Component, OnInit, ViewChild } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { Table } from 'primeng/table';
import { RmanInvoiceLinesVComponent } from '../rmanInvoiceLinesV/rmanInvoiceLinesV.component';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanInvoiceHeadersV } from './rmanInvoiceHeadersV';
import { RmanInvoiceHeadersVService } from './rmanInvoiceHeadersVservice';
declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
    templateUrl: './rmanInvoiceHeadersV.component.html',
    selector: 'rmanInvoiceHeadersV-data',
    providers: [RmanInvoiceHeadersVService]
})

export class RmanInvoiceHeadersVComponent implements OnInit {
    noData = appSettings.noData;
    displayDialog: boolean;

    displaySearchDialog: boolean;

    rmanInvoiceHeadersV: any = new RmanInvoiceHeadersVImpl();

    rmanInvoiceHeadersVSearch: any = new RmanInvoiceHeadersVImpl();

    isSerached: number = 0;

    arrIdK: any;

    selectedRmanInvoiceHeadersV: any = {} as RmanInvoiceHeadersV;

    newRmanInvoiceHeadersV: boolean;

    rmanInvoiceHeadersVList: RmanInvoiceHeadersV[];

    cols: any[];

    columnOptions: any[];

    paginationOptions = {};

    pages: {};



    datasource: any[];
    pageSize: number;
    totalElements: number;
    collapsed: boolean = true;
    sourceInvoiceId: any;
    loading: boolean;
    
    isSelectAllChecked = true;
    globalCols: any[];
    clonedCols: any[];
    userId: number;
    showPaginator: boolean = true;
    startIndex: number;
    showAddColumns = true;
    columns: any[];
    exportCols: string[] =[];
    disableExport: boolean = true;
    
    @ViewChild(RmanInvoiceLinesVComponent) private childTable: RmanInvoiceLinesVComponent;


    constructor(private rmanInvoiceHeadersVService: RmanInvoiceHeadersVService, private router: Router,  private commonSharedService: CommonSharedService,
      private notificationService:NotificationService) {

        // generate list code
        this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
        this.router.events.subscribe((event) => {
            if (event instanceof NavigationEnd) {
                this.arrIdK = event.url.split('/')[3];
            }
        });
    }

    ngOnInit() {

       this.getAllRmanInvoiceHeadersV();

       this.globalCols = [
        { field: 'invoiceNumber', header: 'Invoice Number', showField: true, drag: false, display: "table-cell",type:'number'},
        { field: 'invoicedDate', header: 'Invoiced Date', showField: true, drag: true, display: "table-cell",type:'date' },
        { field: 'invoiceType', header: 'Invoice Type', showField: true, drag: true, display: "table-cell",type:'text'},
        { field: 'invoiceTrxType', header: 'InvoiceTrx Type', showField: true, drag: true, display: "table-cell",type:'text' },
        { field: 'fxRate', header: 'Fx Rate', showField: true, drag: true, display: "table-cell",type:'text' },
        { field: 'fxDate', header: 'Fx Date', showField: true, drag: true, display: "table-cell",type:'date' },
        { field: 'invoiceCurrency', header: 'Invoice Currency' , showField: true, drag: true, display: "table-cell",type:'text'},
        { field: 'acctdCurrency', header: 'Functional Currency', drag: true, showField: true, display: "table-cell",type:'text' },
        { field: 'salesOrderNumber', header: 'SO #', drag: true, showField: true, display: "table-cell",type:'number' },
        { field: 'invoiceSource', header: 'Invoice Source', drag: true, showField: true, display: "table-cell",type:'text' },
        { field: 'invoiceAmount', header: 'Invoice Amount', drag: true, showField: true, display: "table-cell",type:'round' }
        ];

        this.columns = [];
        this.getTableColumns("rmanInvoiceHeadersV", "Invoice Headers");

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
        this.commonSharedService.saveOrUpdateTableColumns("rmanInvoiceHeadersV", "Invoice Headers", selectedCols, this.userId).then((response) => {
          this.columns = this.globalCols.filter(item => item.showField);
          this.userId = response["userId"];
          this.showPaginator = this.columns.length !== 0;
          this.loading = false;
        }).catch(() => {
          this.notificationService.showError('Error occured while getting data' );
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


    getAllRmanInvoiceHeadersV() {
        this.loading = true;
        this.rmanInvoiceHeadersV.arrangementId=this.arrIdK;
        this.rmanInvoiceHeadersVService.getAllRmanInvoiceHeadersV(this.paginationOptions, this.rmanInvoiceHeadersV, this.exportCols).then((rmanInvoiceHeadersVList: any) => {
            this.datasource = rmanInvoiceHeadersVList.content;
            this.rmanInvoiceHeadersVList = rmanInvoiceHeadersVList.content;
            this.totalElements = rmanInvoiceHeadersVList.totalElements;
            this.pageSize = rmanInvoiceHeadersVList.size;
            this.displaySearchDialog = false;
            this.loading = false;
            this.disableExport = false;
            if (this.rmanInvoiceHeadersVList.length != 0) {
                this.selectedRmanInvoiceHeadersV = this.rmanInvoiceHeadersVList[0];
                this.sourceInvoiceId = this.selectedRmanInvoiceHeadersV.sourceInvoiceId;

            } else {
                this.selectedRmanInvoiceHeadersV = '';
            }
            this.childTable.parentCall(this.selectedRmanInvoiceHeadersV);

        });
    }


    getRmanInvoiceHeadersV(event: any) {

        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.loading = true;
        this.rmanInvoiceHeadersV.arrangementId=this.arrIdK;
        this.rmanInvoiceHeadersVService.getAllRmanInvoiceHeadersV(this.paginationOptions, this.rmanInvoiceHeadersV, this.exportCols).then((rmanInvoiceHeadersVList: any) => {
            this.datasource = rmanInvoiceHeadersVList.content;
            this.rmanInvoiceHeadersVList = rmanInvoiceHeadersVList.content;
            this.totalElements = rmanInvoiceHeadersVList.totalElements;
            this.pageSize = rmanInvoiceHeadersVList.size;
            if (this.rmanInvoiceHeadersVList.length != 0) {
                this.selectedRmanInvoiceHeadersV = this.rmanInvoiceHeadersVList[0];
                this.sourceInvoiceId = this.selectedRmanInvoiceHeadersV.sourceInvoiceId;

            } else {
                this.selectedRmanInvoiceHeadersV = '';
            }
            this.childTable.parentCall(this.selectedRmanInvoiceHeadersV);
            this.loading = false;
            this.disableExport = false;
        });

    }

    exportExcel() {
      this.exportCols =[];
      for (let index = 0; index < this.columns.length; index++) {
              if(this.columns[index].showField){
                  this.exportCols.push(this.columns[index].field);
              }
           }
        let serviceUrl = this.rmanInvoiceHeadersVService.getServiceUrl(this.paginationOptions ,this.rmanInvoiceHeadersV, this.exportCols, 1);
        window.location.href = serviceUrl;
    }


    showDialogToAdd() {

        this.newRmanInvoiceHeadersV = true;
        this.rmanInvoiceHeadersV = new RmanInvoiceHeadersVImpl();
        this.displayDialog = true;

    }


    reset(dt: Table) {
        this.paginationOptions = {};
        this.rmanInvoiceHeadersV = new RmanInvoiceHeadersVImpl();
        dt.reset();
    }


    save() {
        if (this.newRmanInvoiceHeadersV) {
            this.rmanInvoiceHeadersVService.saveRmanInvoiceHeadersV(this.rmanInvoiceHeadersV).then((response: any) => {
                this.getAllRmanInvoiceHeadersV();
            });
        }
        else {
            this.rmanInvoiceHeadersVService.updateRmanInvoiceHeadersV(this.rmanInvoiceHeadersV).then((response: any) => {
                this.getAllRmanInvoiceHeadersV();
            });
        }
        this.rmanInvoiceHeadersV = new RmanInvoiceHeadersVImpl();
        this.displayDialog = false;
    }


    delete(rmanInvoiceHeadersV: any) {
        this.rmanInvoiceHeadersV = rmanInvoiceHeadersV;
        this.displayDialog = false;
        if (window.confirm('Are you sure you want to delete this record?')) {
            this.rmanInvoiceHeadersVList.splice(this.findSelectedRmanInvoiceHeadersVIndex(), 1);
            this.rmanInvoiceHeadersVService.deleteRmanInvoiceHeadersV(this.rmanInvoiceHeadersV).then(response => {
                this.rmanInvoiceHeadersV = new RmanInvoiceHeadersVImpl();
                this.getAllRmanInvoiceHeadersV();
            });
        }

    }

    editRow(rmanInvoiceHeadersV: any) {
        this.newRmanInvoiceHeadersV = false;
        this.rmanInvoiceHeadersV = this.cloneRmanInvoiceHeadersV(rmanInvoiceHeadersV);
        this.displayDialog = true;
    }


    findSelectedRmanInvoiceHeadersVIndex(): number {
        return this.rmanInvoiceHeadersVList.indexOf(this.selectedRmanInvoiceHeadersV);
    }

    onRowSelect(event: any) {
        this.selectedRmanInvoiceHeadersV = event.data;
        this.sourceInvoiceId = this.selectedRmanInvoiceHeadersV.sourceInvoiceId;
        this.childTable.parentCall(this.selectedRmanInvoiceHeadersV);
    }

    onRowUnSelect(event) {
        this.childTable.parentCall('');
    }
    onBeforeToggle(evt: any) {
        this.collapsed = evt.collapsed;
    }

    cloneRmanInvoiceHeadersV(c: RmanInvoiceHeadersV): RmanInvoiceHeadersV {
        let rmanInvoiceHeadersV: any = new RmanInvoiceHeadersVImpl();
        for (let prop in c) {
            rmanInvoiceHeadersV[prop] = c[prop];
        }
        return rmanInvoiceHeadersV;
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

        this.rmanInvoiceHeadersVSearch = new RmanInvoiceHeadersVImpl();

        if (this.isSerached == 0) {
            this.rmanInvoiceHeadersVSearch = new RmanInvoiceHeadersVImpl();
        }
        this.displaySearchDialog = true;

    }

    search() {

        this.isSerached = 1;
        this.rmanInvoiceHeadersV = this.rmanInvoiceHeadersVSearch;
        this.paginationOptions = {};
        this.getAllRmanInvoiceHeadersV();
    }
}

class RmanInvoiceHeadersVImpl implements RmanInvoiceHeadersV {
    constructor(public fxRate?: any, public fxDate?: any, public sourceInvoiceId?: any, public invoiceType?: any, public invoiceTrxType?: any, public invoiceSource?: any, public salesOrderNumber?: any, public invoiceNumber?: any, public invoicedDate?: any, public invoiceAmount?: any, public invoiceCurrency?: any, public arrangementId?: any, public acctdCurrency?: any) { }
}

interface ILabels {
    [index: string]: string;
}
