import { Location } from '@angular/common';
import { Component } from '@angular/core';
import { Table } from 'primeng/table';
import { RmanLegalEntitiesService } from '../rmanLegalEntities/rmanLegalEntitiesservice';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanReconShippedSoTrgRep } from './rmanReconShippedSoTrgRep';
import { RmanReconShippedSoTrgRepService } from './rmanReconShippedSoTrgRepservice';

declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');
@Component({
    templateUrl: './rmanReconShippedSoTrgRep.component.html',
    selector: 'rmanReconShippedSoTrgRep-data',
    providers: [RmanReconShippedSoTrgRepService, RmanLegalEntitiesService]
})

export class RmanReconShippedSoTrgRepComponent {

    displayDialog: boolean;

    displaySearchDialog: boolean;

    rmanReconShippedSoTrgRep: RmanReconShippedSoTrgRep = new RmanReconShippedSoTrgRepImpl();

    rmanReconShippedSoTrgRepSearch: RmanReconShippedSoTrgRep = new RmanReconShippedSoTrgRepImpl();

    isSerached: number = 0;

    selectedRmanReconShippedSoTrgRep: RmanReconShippedSoTrgRep;

    newRmanReconShippedSoTrgRep: boolean;

    rmanReconShippedSoTrgRepList: RmanReconShippedSoTrgRep[];

    cols: any[];
    columns: any[];

    columnOptions: any[];

    paginationOptions = {};

    pages: {};

    datasource: any[];
    pageSize: number;
    totalElements: number;
    collapsed: boolean = true;
    fromDate: any;
    toDate: any;
    legalEntity: any;
    legalEntitiesList: any[] = [];
    entities: any[] = [];
    noData = appSettings.noData;
    loading: boolean;

    showAddColumns = true;
    isSelectAllChecked = true;
    globalCols: any[];
    clonedCols: any[];
    userId: number;
    showPaginator: boolean = true;
    startIndex: number;
    


    exportCols: string[] =[];
    disableExport: boolean = true;

    constructor(private rmanReconShippedSoTrgRepService: RmanReconShippedSoTrgRepService, private rmanLegalEntitiesService: RmanLegalEntitiesService, private location: Location,  private commonSharedService: CommonSharedService,
      private notificationService:NotificationService) {

        // generate list code
        this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };



    }

    ngOnInit() {
        this.rmanLegalEntitiesService.getAllRmanLegalEntities(this.paginationOptions, {}, 'Y').then((data: any) => {
            this.legalEntitiesList = data.content;
            this.getEntities();
        })
        
        this.globalCols =[ 
        
            { field: 'arrangementName', header: 'Revenue Contract Name',  showField: true, display: "table-cell",type:'text', drag:false},
            { field: 'arrangementNumber', header: 'Revenue Contract#',  showField: true, display: "table-cell",type:'number', drag:false},
            { field: 'so', header: 'SO #',  showField: true, display: "table-cell",type:'number', drag:true},
            { field: 'sourceLineId', header: 'Source Line Id',  showField: true, display: "table-cell",type:'number', drag:true},
            { field: 'soLineNum', header: 'SO Line#',  showField: true, display: "table-cell",type:'number', drag:true},
            { field: 'entity', header: 'Entity',  showField: true, display: "table-cell",type:'text', drag:true},     
            { field: 'deliveredDate', header: 'Delivered Date',  showField: true, display: "table-cell",type:'date', drag:true},
            { field: 'arrgLineNum', header: 'Linked Revenue Contract Line #',  showField: true, display: "table-cell",type:'number', drag:true},
            { field: 'sku', header: 'Product Name',  showField: true, display: "table-cell",type:'text', drag:true},
            { field: 'srcDeliveredQty', header: 'Delivered Quantity (Source)',  showField: true, display: "table-cell",type:'number', drag:true},
            { field: 'trgDeliveredQty', header: 'Delivered Quantity (Destination)',  showField: true, display: "table-cell", type:'number', drag:true},
            { field: 'eventReceived', header: 'Event Received',  showField: true, display: "table-cell",type:'text', drag:true},
            { field: 'revTriggerForSku', header: 'Revenue Trigger as per SKU',  showField: true, display: "table-cell",type:'text', drag:true},
            { field: 'exception', header: 'Exception',  showField: true, display: "table-cell",type:'text', drag:true}
            
            ];
            this.columns = [];
            this.getTableColumns("rmanReconShippedSoTrgRep", "Reconciliation Shipments/Fulfillments to Revenue Triggers Report");
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
        this.commonSharedService.saveOrUpdateTableColumns("rmanReconShippedSoTrgRep", "Reconciliation Shipments/Fulfillments to Revenue Triggers Report", selectedCols, this.userId).then((response) => {
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

   
     exportExcel() {

        this.exportCols =[];

	    for (let index = 0; index < this.columns.length; index++) {
            if(this.columns[index].showField){
                this.exportCols.push(this.columns[index].field);
            }
         }

        this.loading = true;
        let exportReconShippedSOTriggerReportUrl = this.rmanReconShippedSoTrgRepService.exportShippedSOTrigReport(this.fromDate, this.toDate, this.legalEntity, this.paginationOptions, this.exportCols);
        window.location.href = exportReconShippedSOTriggerReportUrl;
        this.loading = false;
    }

    getAllRmanReconShippedSoTrgRep() {
        this.loading = true;
        this.rmanReconShippedSoTrgRepService.getAllRmanReconShippedSoTrgRep(this.paginationOptions, this.rmanReconShippedSoTrgRep).then((rmanReconShippedSoTrgRepList: any) => {
            this.datasource = rmanReconShippedSoTrgRepList.content;
            this.rmanReconShippedSoTrgRepList = rmanReconShippedSoTrgRepList.content;
            this.totalElements = rmanReconShippedSoTrgRepList.totalElements;
            this.pageSize = rmanReconShippedSoTrgRepList.size;
            this.loading = false;
            this.displaySearchDialog = false;
            this.disableExport = false;
        });
    }


    getRmanReconShippedSoTrgRep(event: any) {

        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.loading = true;
        this.rmanReconShippedSoTrgRepService.searchFields(this.fromDate, this.toDate, this.legalEntity, this.paginationOptions).then((rmanReconShippedSoTrgRepList: any) => {
            this.datasource = rmanReconShippedSoTrgRepList.content;
            this.rmanReconShippedSoTrgRepList = rmanReconShippedSoTrgRepList.content;
            this.totalElements = rmanReconShippedSoTrgRepList.totalElements;
            this.pageSize = rmanReconShippedSoTrgRepList.size;
            this.loading = false;
            this.disableExport = false;
        });

    }


    showDialogToAdd() {

        this.newRmanReconShippedSoTrgRep = true;
        this.rmanReconShippedSoTrgRep = new RmanReconShippedSoTrgRepImpl();
        this.displayDialog = true;

    }


    save() {

        if (this.newRmanReconShippedSoTrgRep) {
            this.rmanReconShippedSoTrgRepService.saveRmanReconShippedSoTrgRep(this.rmanReconShippedSoTrgRep).then((response: any) => {
                this.getAllRmanReconShippedSoTrgRep();
            });
        }
        else {
            this.rmanReconShippedSoTrgRepService.updateRmanReconShippedSoTrgRep(this.rmanReconShippedSoTrgRep).then((response: any) => {
                this.getAllRmanReconShippedSoTrgRep();
            });
        }

        this.rmanReconShippedSoTrgRep = new RmanReconShippedSoTrgRepImpl();

        this.displayDialog = false;

    }


    delete(rmanReconShippedSoTrgRep: any) {
        this.rmanReconShippedSoTrgRep = rmanReconShippedSoTrgRep;

        this.displayDialog = false;

        if (window.confirm('Are you sure you want to delete this record?')) {
            this.rmanReconShippedSoTrgRepList.splice(this.findSelectedRmanReconShippedSoTrgRepIndex(), 1);
            this.rmanReconShippedSoTrgRepService.deleteRmanReconShippedSoTrgRep(this.rmanReconShippedSoTrgRep).then(response => {
                this.rmanReconShippedSoTrgRep = new RmanReconShippedSoTrgRepImpl();
                this.getAllRmanReconShippedSoTrgRep();
            });
        }

    }

    editRow(rmanReconShippedSoTrgRep: any) {
        this.newRmanReconShippedSoTrgRep = false;
        this.rmanReconShippedSoTrgRep = this.cloneRmanReconShippedSoTrgRep(rmanReconShippedSoTrgRep);
        this.displayDialog = true;

    }


    findSelectedRmanReconShippedSoTrgRepIndex(): number {
        return this.rmanReconShippedSoTrgRepList.indexOf(this.selectedRmanReconShippedSoTrgRep);
    }

    onRowSelect(event: any) {

    }

    cloneRmanReconShippedSoTrgRep(c: RmanReconShippedSoTrgRep): RmanReconShippedSoTrgRep {
        let rmanReconShippedSoTrgRep = new RmanReconShippedSoTrgRepImpl();
        for (let prop in c) {
            rmanReconShippedSoTrgRep[prop] = c[prop];
        }
        return rmanReconShippedSoTrgRep;
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

        this.rmanReconShippedSoTrgRepSearch = new RmanReconShippedSoTrgRepImpl();

        if (this.isSerached == 0) {
            this.rmanReconShippedSoTrgRepSearch = new RmanReconShippedSoTrgRepImpl();
        }
        this.fromDate = '';
        this.toDate = '';
        this.legalEntity = '';
        this.displaySearchDialog = true;

    }

    reset(dt: Table) {
       this.paginationOptions = {};
        this.rmanReconShippedSoTrgRep = new RmanReconShippedSoTrgRepImpl();
        this.rmanReconShippedSoTrgRepSearch = new RmanReconShippedSoTrgRepImpl();
        this.fromDate = '';
        this.toDate = '';
        this.legalEntity = '';
        dt.reset();
    }

    search() {
        this.isSerached = 1;
        this.rmanReconShippedSoTrgRep = this.rmanReconShippedSoTrgRepSearch;
        this.getAllRmanReconShippedSoTrgRep();
    }

    onBeforeToggle(evt: any) {
        this.collapsed = evt.collapsed;
    }

    searchFields(dt: Table) {
       this.loading = true;
        this.rmanReconShippedSoTrgRepService.searchFields(this.fromDate, this.toDate, this.legalEntity, this.paginationOptions).then((rmanReconShippedSoTrgRepList: any) => {
            this.displaySearchDialog = false;
            this.rmanReconShippedSoTrgRepList = rmanReconShippedSoTrgRepList.content;
            this.totalElements = rmanReconShippedSoTrgRepList.totalElements;
            this.pageSize = rmanReconShippedSoTrgRepList.size;
            this.loading = false;
        })
    }

    getEntities() {
        let entitiesTemp: any[] = [{ label: '--Select Entity Name--', value: null }];
        this.legalEntitiesList.forEach((obj: any) => {
            entitiesTemp.push({ label: obj.name, value: obj.legalEntityId })
        })
        this.entities = entitiesTemp;
    }
}


class RmanReconShippedSoTrgRepImpl implements RmanReconShippedSoTrgRep {
    constructor(public srcDeliveredQty?: any, public arrangementNumber?: any, public exception?: any, public eventReceived?: any, public revTriggerForSku?: any, public entity?: any, public deliveredDate?: any, public arrgLineNum?: any, public soLineNum?: any, public arrangementName?: any, public so?: any, public sku?: any, public trgDeliveredQty?: any) { }
}

interface ILabels {
    [index: string]: string;
}
