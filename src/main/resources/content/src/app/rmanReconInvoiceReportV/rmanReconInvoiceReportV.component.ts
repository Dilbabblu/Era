import { Location } from '@angular/common';
import { Component } from '@angular/core';
import { Table } from 'primeng/table';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanReconInvoiceReportV } from './rmanReconInvoiceReportV';
import { RmanReconInvoiceReportVService } from './rmanReconInvoiceReportVservice';


declare var $: any;
declare var require:any;

const appSettings = require('../appsettings');

@Component({
    templateUrl: './rmanReconInvoiceReportV.component.html',
    selector: 'rmanReconInvoiceReportV-data',
    providers: [RmanReconInvoiceReportVService]
})

export class RmanReconInvoiceReportVComponent {

    displayDialog: boolean;

    displaySearchDialog: boolean;

    rmanReconInvoiceReportV: any = new RmanReconInvoiceReportVImpl();

    rmanReconInvoiceReportVSearch: any = new RmanReconInvoiceReportVImpl();

    isSerached: number = 0;

    selectedRmanReconInvoiceReportV: RmanReconInvoiceReportV;

    newRmanReconInvoiceReportV: boolean;

    rmanReconInvoiceReportVList: RmanReconInvoiceReportV[];

    cols: any[];
    columns: any[];

    columnOptions: any[];

    paginationOptions = {};

    pages: {};
    


    datasource: any[];
    pageSize: number;
    totalElements: number;
    loading: boolean;
    collapsed: boolean = true;
    noData = appSettings.noData;
    searchFields: any = {};

    showAddColumns = true;
    isSelectAllChecked = true;
    globalCols: any[];
    clonedCols: any[];
    userId: number;
    showPaginator: boolean = true;
    startIndex: number;
    

    exportCols: string[] =[];
    disableExport: boolean = true;

    constructor(private rmanReconInvoiceReportVService: RmanReconInvoiceReportVService,  private location: Location, private commonSharedService: CommonSharedService,
      private notificationService:NotificationService) {
        // generate list code
        this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    }

    ngOnInit() {

      this.globalCols =[ 
        
        { field: 'dealArrangementNumber', header: 'Revenue Contract#',  showField: true, display: "table-cell",type:'number', drag:false},
        { field: 'dealArrangementName', header: 'Revenue Contract Name',  showField: true, display: "table-cell",type:'number', drag:false},
        { field: 'dealArrangementBasis', header: 'Revenue Contract Type',  showField: true, display: "table-cell",type:'text', drag:true},
        { field: 'endCustomerName', header: 'Customer Name',  showField: true, display: "table-cell",type:'text', drag:true},
        { field: 'salesNodeLevel1', header: 'Sales Theater',  showField: true, display: "table-cell",type:'text', drag:true},
        { field: 'salesNodeLevel2', header: 'Region',  showField: true, display: "table-cell",type:'text', drag:true},     
        { field: 'salesNodeLevel3', header: 'Territory',  showField: true, display: "table-cell",type:'text', drag:true},
        { field: 'dealNumber', header: 'Deal#',  showField: true, display: "table-cell",type:'number', drag:true},
        { field: 'dealLineNumber', header: 'Deal Line#',  showField: true, display: "table-cell",type:'number', drag:true},
        { field: 'productName', header: 'Product Name',  showField: true, display: "table-cell",type:'text', drag:true},
        { field: 'productDescription', header: 'Product Description',  showField: true, display: "table-cell", type:'text', drag:true},
        { field: 'itemType', header: 'Item Type',  showField: true, display: "table-cell",type:'text', drag:true},
        { field: 'customerPoNum', header: 'PO#',  showField: true, display: "table-cell",type:'number', drag:true},
        { field: 'orderNumber', header: 'SO#',  showField: true, display: "table-cell",type:'number', drag:true},
        { field: 'sourceLineId', header: 'Source Line Id',  showField: true, display: "table-cell",type:'number', drag:true},
        { field: 'sourceLineNumber', header: 'SO Line #',  showField: true, display: "table-cell",type:'number', drag:true},
        { field: 'orderedDate', header: 'Ordered Date',  showField: true, display: "table-cell",type:'date', drag:true},
        { field: 'orderedQuantity', header: 'Ordered Quantity',  showField: true, display: "table-cell",type:'number', drag:true},
        { field: 'actualFulfilledDate', header: 'Shipped Date',  showField: true, display: "table-cell",type:'date', drag:true},
        { field: 'shippedQuantity', header: 'Shipped Quantity',  showField: true, display: "table-cell",type:'number', drag:true},
        { field: 'repUnitListPrice', header: 'UnitList Price',  showField: true, display: "table-cell",type:'round', drag:true},
        { field: 'repUnitSellingPrice', header: 'Rep Unit Selling Price',  showField: true, display: "table-cell",type:'round', drag:true},
        { field: 'transactionPrice', header: 'Transaction Price',  showField: true, display: "table-cell", type:'round', drag:true},
        { field: 'invoiceNumber', header: 'Invoice #',  showField: true, display: "table-cell",type:'number', drag:true},
        { field: 'invoiceLineNumber', header: 'Invoice Line #',  showField: true, display: "table-cell",type:'number', drag:true},
        { field: 'invoicedDate', header: 'Invoiced Date',  showField: true, display: "table-cell",type:'date', drag:true},
        { field: 'invoicedQuantity', header: 'Invoiced Quantity',  showField: true, display: "table-cell",type:'number', drag:true},
        { field: 'invoiceCurrency', header: 'Invoice Currency',  showField: true, display: "table-cell",type:'text', drag:true},
        { field: 'acctdCurrency', header: 'Accounted Currency',  showField: true, display: "table-cell",type:'text', drag:true},
        { field: 'fxRate', header: 'Fx Rate',  showField: true, display: "table-cell",type:'text', drag:true},
        { field: 'fxDate', header: 'Fx Date',  showField: true, display: "table-cell",type:'date', drag:true},
        { field: 'revenueAmount', header: 'Revenue Amount',  showField: true, display: "table-cell",type:'round', drag:true},
        { field: 'acctdRevAmount', header: 'Accounted Amount',  showField: true, display: "table-cell",type:'round', drag:true}
    ];
    
    this.columns = [];
    this.getTableColumns("rmanReconInvoiceRep", "Reconciliation of Shipments/Fulfillments to Billings Report");
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
        this.commonSharedService.saveOrUpdateTableColumns("rmanReconInvoiceRep", "Reconciliation of Shipments/Fulfillments to Billings Report", selectedCols, this.userId).then((response) => {
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
    

goToReconciliationReports(){
    this.location.back();
  }

    getAllRmanReconInvoiceReportV() {
        this.loading = true;
        this.rmanReconInvoiceReportVService.getAllRmanReconInvoiceReportV(this.paginationOptions, this.searchFields).then((rmanReconInvoiceReportVList: any) => {
            this.datasource = rmanReconInvoiceReportVList.content;
            this.rmanReconInvoiceReportVList = rmanReconInvoiceReportVList.content;
            this.totalElements = rmanReconInvoiceReportVList.totalElements;
            this.pageSize = rmanReconInvoiceReportVList.size;
            this.displaySearchDialog = false;
            this.loading = false;
            this.disableExport = false;
        }).catch((err: any) => {
          this.notificationService.showError('Error occured while getting data');
            this.loading = false;
        });
    }

    reset(dt: Table) {        
        this.paginationOptions = {};
        this.searchFields = {};
        dt.reset();
    }


    getRmanReconInvoiceReportV(event: any) {
        this.loading = true;
        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.rmanReconInvoiceReportVService.getAllRmanReconInvoiceReportV(this.paginationOptions, this.searchFields).then((rmanReconInvoiceReportVList: any) => {
            this.datasource = rmanReconInvoiceReportVList.content;
            this.rmanReconInvoiceReportVList = rmanReconInvoiceReportVList.content;
            this.totalElements = rmanReconInvoiceReportVList.totalElements;
            this.pageSize = rmanReconInvoiceReportVList.size;
            this.loading = false;
            this.disableExport = false;
        }).catch((err: any) => {
          this.notificationService.showError('Error occured while getting data');
            this.loading = false;
        });

    }


    showDialogToAdd() {

        this.newRmanReconInvoiceReportV = true;
        this.rmanReconInvoiceReportV = new RmanReconInvoiceReportVImpl();
        this.displayDialog = true;

    }


    save() {
        this.loading = true;
        if (this.newRmanReconInvoiceReportV) {
            this.rmanReconInvoiceReportVService.saveRmanReconInvoiceReportV(this.rmanReconInvoiceReportV).then((response: any) => {
                this.getAllRmanReconInvoiceReportV();
                this.loading = false;
            }).catch((err: any) => {
              this.notificationService.showError('Error occured while saving data');
                this.loading = false;
            });
        }
        else {
            this.loading = true;
            this.rmanReconInvoiceReportVService.updateRmanReconInvoiceReportV(this.rmanReconInvoiceReportV).then((response: any) => {
                this.getAllRmanReconInvoiceReportV();
                this.loading = false;
            }).catch((err: any) => {
              this.notificationService.showError('Error occured while updating data');
                this.loading = false;
            });
        }

        this.rmanReconInvoiceReportV = new RmanReconInvoiceReportVImpl();

        this.displayDialog = false;

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
        this.loading = true;
        let serviceUrl = this.rmanReconInvoiceReportVService.getServiceUrl(this.paginationOptions, this.searchFields, this.exportCols, 1);
        this.loading = false;
        window.location.href = serviceUrl;
    }


    delete(rmanReconInvoiceReportV: any) {
        this.rmanReconInvoiceReportV = rmanReconInvoiceReportV;
        this.displayDialog = false;

        if (window.confirm('Are you sure you want to delete this record?')) {
            this.rmanReconInvoiceReportVList.splice(this.findSelectedRmanReconInvoiceReportVIndex(), 1);
            this.rmanReconInvoiceReportVService.deleteRmanReconInvoiceReportV(this.rmanReconInvoiceReportV).then(response => {
                this.rmanReconInvoiceReportV = new RmanReconInvoiceReportVImpl();
                this.getAllRmanReconInvoiceReportV();
            });
        }

    }

    editRow(rmanReconInvoiceReportV: any) {
        this.newRmanReconInvoiceReportV = false;
        this.rmanReconInvoiceReportV = this.cloneRmanReconInvoiceReportV(rmanReconInvoiceReportV);
        this.displayDialog = true;

    }


    findSelectedRmanReconInvoiceReportVIndex(): number {
        return this.rmanReconInvoiceReportVList.indexOf(this.selectedRmanReconInvoiceReportV);
    }

    onRowSelect(event: any) {

    }

    cloneRmanReconInvoiceReportV(c: RmanReconInvoiceReportV): RmanReconInvoiceReportV {
        let rmanReconInvoiceReportV: any = new RmanReconInvoiceReportVImpl();
        for (let prop in c) {
            rmanReconInvoiceReportV[prop] = c[prop];
        }
        return rmanReconInvoiceReportV;
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

        this.rmanReconInvoiceReportVSearch = new RmanReconInvoiceReportVImpl();

        if (this.isSerached == 0) {
            this.searchFields={};
        }
        this.displaySearchDialog = true;

    }

    search() {
        this.isSerached = 1;
        this.getAllRmanReconInvoiceReportV();
    }
}


class RmanReconInvoiceReportVImpl {
    constructor(public dealArrangementNumber?: any, public endCustomerName?: any, public fxDate?: any, public acctdCurrency?: any, public repUnitSellingPrice?: any, public invoicedDate?: any, public dealArrangementName?: any, public invoiceCurrency?: any, public invoicedQuantity?: any, public revenueAmount?: any, public productDescription?: any, public dealArrangementBasis?: any, public fxRate?: any, public sno?: any, public shippedQuantity?: any, public dealNumber?: any, public itemType?: any, public actualFulfilledDate?: any, public salesNodeLevel2?: any, public salesNodeLevel3?: any, public dealLineNumber?: any, public sourceLineNumber?: any, public legalEntityId?: any, public dealHeaderId?: any, public invoiceNumber?: any, public acctdRevAmount?: any, public productName?: any, public customerPoNum?: any, public salesNodeLevel1?: any, public bookedDate?: any, public dealArrangementId?: any, public transactionPrice?: any, public legalEntityName?: any, public repUnitListPrice?: any, public invoiceLineNumber?: any, public orderNumber?: any, public orderedDate?: any, public orderedQuantity?: any) { }
}

interface ILabels {
    [index: string]: string;
}
