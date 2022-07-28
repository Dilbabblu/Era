import { Location } from '@angular/common';
import { Component } from '@angular/core';
import { Table } from 'primeng/table';
import { RmanLegalEntitiesService } from '../rmanLegalEntities/rmanLegalEntitiesservice';
import { CommonSharedService } from '../shared/common.service';
import { NotificationService } from '../shared/notifications.service';
import { RmanReconRevtrigRecogRep } from './rmanReconRevtrigRecogRep';
import { RmanReconRevtrigRecogRepService } from './rmanReconRevtrigRecogRepservice';

declare var require:any;

const appSettings = require('../appsettings');

declare var $:any;

@Component({
    templateUrl: './rmanReconRevtrigRecogRep.component.html',
    selector: 'rmanReconRevtrigRecogRep-data',
    providers: [RmanReconRevtrigRecogRepService,RmanLegalEntitiesService]
})

export class RmanReconRevtrigRecogRepComponent{

    displayDialog: boolean;

    displaySearchDialog: boolean;

    rmanReconRevtrigRecogRep: RmanReconRevtrigRecogRep = new RmanReconRevtrigRecogRepImpl();

    rmanReconRevtrigRecogRepSearch: RmanReconRevtrigRecogRep = new RmanReconRevtrigRecogRepImpl();

	isSerached:number=0;

    selectedRmanReconRevtrigRecogRep: RmanReconRevtrigRecogRep;

    newRmanReconRevtrigRecogRep: boolean;

    rmanReconRevtrigRecogRepList: RmanReconRevtrigRecogRep[];

    cols:any[];
    columns:any[];

    columnOptions: any[];

    paginationOptions={};

    pages:{};

    datasource: any[];
    pageSize:number;
    totalElements:number;
    collapsed: boolean = true;
    
    fromDate:any;
    toDate:any;
    legalEntity:any;
    legalEntitiesList: any[] = [];
    entities: any[] = [];
    loading: boolean;

    noData = appSettings.noData;

    showAddColumns = true;
    isSelectAllChecked = true;
    
    globalCols: any[];
    clonedCols: any[];
    userId: number;
    showPaginator: boolean = true;
    startIndex: number;

    exportCols: string[] =[];
    disableExport: boolean = true;

    constructor(private rmanReconRevtrigRecogRepService: RmanReconRevtrigRecogRepService,private rmanLegalEntitiesService: RmanLegalEntitiesService, private location: Location, private commonSharedService: CommonSharedService ,
      private notificationService:NotificationService) {
        // generate list code
        this.paginationOptions={'pageNumber':0,'pageSize':'10000'};
    }

    ngOnInit() {
    
	    this.rmanLegalEntitiesService.getAllRmanLegalEntities(this.paginationOptions, {}, 'Y').then((data: any) => {
		      this.legalEntitiesList = data.content;		      
		      this.getEntities();
		    })
    
        this.globalCols =[ 
        
          { field: 'arrangementName', header: 'Revenue Contract Name',  showField: true, display: "table-cell",type:'text', drag:false},
          { field: 'arrangementNumber', header: 'Revenue Contract#',  showField: true, display: "table-cell",type:'number', drag:false},
		      { field: 'arrangementLineNumber', header: 'Revenue Contract Line#',  showField: true, display: "table-cell",type:'number', drag:true},
          { field: 'so', header: 'SO #',  showField: true, display: "table-cell",type:'number', drag:true},
          { field: 'sourceLineId', header: 'Source Line Id',  showField: true, display: "table-cell",type:'number', drag:true},
          { field: 'soLineNum', header: 'SO Line#',  showField: true, display: "table-cell",type:'number', drag:true},
          { field: 'skuRevTrigger', header: 'Revenue Triggers (as per SKU)',  showField: true, display: "table-cell",type:'text', drag:true},     
          { field: 'eventReceived', header: 'Event Received',  showField: true, display: "table-cell",type:'text', drag:true},
          { field: 'actualFulfilledDate', header: 'Delivered Date',  showField: true, display: "table-cell",type:'date', drag:true},
          { field: 'deliveredAmt', header: 'Delivered Amount',  showField: true, display: "table-cell",type:'round', drag:true},
          { field: 'allocAmt', header: 'Allocation Amount',  showField: true, display: "table-cell",type:'round', drag:true},
          { field: 'deferredAmt', header: 'Deferred Amount',  showField: true, display: "table-cell", type:'round', drag:true},
          { field: 'provisionAmt', header: 'Provision Amount',  showField: true, display: "table-cell",type:'round', drag:true},
          { field: 'recogAmt', header: 'Recognized Amount',  showField: true, display: "table-cell",type:'round', drag:true},
          { field: 'currency', header: 'Currency',  showField: true, display: "table-cell",type:'text', drag:true},
		      { field: 'exception', header: 'Exception',  showField: true, display: "table-cell",type:'text', drag:true}
		  
		  ];
      this.columns = [];
      this.getTableColumns("rmanReconRevtrigRecogRep", "Reconciliation Revenue Triggers to Recognize Revenue Report");
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
      this.commonSharedService.saveOrUpdateTableColumns("rmanReconRevtrigRecogRep", "Reconciliation Revenue Triggers to Recognize Revenue Report", selectedCols, this.userId).then((response) => {
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
  
    
    reset(dt:Table){  
    	this.paginationOptions = {};  
        this.rmanReconRevtrigRecogRep = new RmanReconRevtrigRecogRepImpl();
        this.rmanReconRevtrigRecogRepSearch = new RmanReconRevtrigRecogRepImpl();
        this.fromDate='';
        this.toDate='';
        this.legalEntity='';
        dt.reset();
    }

    goToReconciliationReports(){
      this.location.back();
    }
  
    getAllRmanReconRevtrigRecogRep() {
  this.loading = true;
        this.rmanReconRevtrigRecogRepService.getAllRmanReconRevtrigRecogRep(this.paginationOptions,this.rmanReconRevtrigRecogRep).then((rmanReconRevtrigRecogRepList:any) => {            
            this.datasource = rmanReconRevtrigRecogRepList.content;
            this.rmanReconRevtrigRecogRepList = rmanReconRevtrigRecogRepList.content;
            this.totalElements=rmanReconRevtrigRecogRepList.totalElements;
            this.pageSize=rmanReconRevtrigRecogRepList.size;
            this.displaySearchDialog = false;
          this.loading = false;
          this.disableExport = false;
        });
    }


    getRmanReconRevtrigRecogRep(event:any) {       

        let first:number=event.first;
        let rows:number=event.rows;
        let pageNumber:number=first/rows;
        this.paginationOptions={'pageNumber':pageNumber,'pageSize':this.pageSize,'sortField':event.sortField,'sortOrder':event.sortOrder};
      this.loading = true;
        this.rmanReconRevtrigRecogRepService.searchFields(this.fromDate,this.toDate,this.legalEntity,this.paginationOptions).then((rmanReconRevtrigRecogRepList:any) => {
            this.datasource = rmanReconRevtrigRecogRepList.content;
            this.rmanReconRevtrigRecogRepList = rmanReconRevtrigRecogRepList.content;
            this.totalElements=rmanReconRevtrigRecogRepList.totalElements;
            this.pageSize=rmanReconRevtrigRecogRepList.size;
          this.loading = false;
          this.disableExport = false;
        });

    }


    showDialogToAdd() {

        this.newRmanReconRevtrigRecogRep = true;
        this.rmanReconRevtrigRecogRep = new RmanReconRevtrigRecogRepImpl();
        this.displayDialog = true;

    }

    exportExcel() {
        this.exportCols =[];
        for (let index = 0; index < this.columns.length; index++) {
          if(this.columns[index].showField){
              this.exportCols.push(this.columns[index].field);
          }
       }

        this.loading = true;
        let exportReconRevRecTriggerReportUrl = this.rmanReconRevtrigRecogRepService.exportReconRevTrigReport(this.fromDate, this.toDate, this.legalEntity, this.paginationOptions, this.exportCols);
        window.location.href = exportReconRevRecTriggerReportUrl;
        this.loading = false;
    }

    save() {

        if (this.newRmanReconRevtrigRecogRep) {
            this.rmanReconRevtrigRecogRepService.saveRmanReconRevtrigRecogRep(this.rmanReconRevtrigRecogRep).then((response:any) => {
                 this.getAllRmanReconRevtrigRecogRep();
            });
        }
        else {
            this.rmanReconRevtrigRecogRepService.updateRmanReconRevtrigRecogRep(this.rmanReconRevtrigRecogRep).then((response:any) => {
                 this.getAllRmanReconRevtrigRecogRep();
            });
        }

        this.rmanReconRevtrigRecogRep = new RmanReconRevtrigRecogRepImpl();
        this.displayDialog = false;

    }


    delete(rmanReconRevtrigRecogRep:any) {
        this.rmanReconRevtrigRecogRep=rmanReconRevtrigRecogRep;
        this.displayDialog = false;

        if (window.confirm('Are you sure you want to delete this record?')) {
           this.rmanReconRevtrigRecogRepList.splice(this.findSelectedRmanReconRevtrigRecogRepIndex(), 1);
           this.rmanReconRevtrigRecogRepService.deleteRmanReconRevtrigRecogRep(this.rmanReconRevtrigRecogRep).then(response => {
               this.rmanReconRevtrigRecogRep = new RmanReconRevtrigRecogRepImpl();
               this.getAllRmanReconRevtrigRecogRep();
           });
        }

    }

    editRow(rmanReconRevtrigRecogRep:any) {
        this.newRmanReconRevtrigRecogRep = false;
        this.rmanReconRevtrigRecogRep = this.cloneRmanReconRevtrigRecogRep(rmanReconRevtrigRecogRep);
        this.displayDialog = true;

    }


    findSelectedRmanReconRevtrigRecogRepIndex(): number {
        return this.rmanReconRevtrigRecogRepList.indexOf(this.selectedRmanReconRevtrigRecogRep);
    }

    onRowSelect(event:any) {

    }

    cloneRmanReconRevtrigRecogRep(c: RmanReconRevtrigRecogRep): RmanReconRevtrigRecogRep {
        let rmanReconRevtrigRecogRep = new RmanReconRevtrigRecogRepImpl();
        for(let prop in c) {
            rmanReconRevtrigRecogRep[prop] = c[prop];
        }
        return rmanReconRevtrigRecogRep;
    }

    hideColumnMenu: boolean=true;

    toggleColumnMenu(){
        if(this.hideColumnMenu)
        {
            this.hideColumnMenu= false;
        }else
        {
            this.hideColumnMenu=true;
        }
    }

    showFilter: boolean= false;

    toggleFilterBox(){
        if(this.showFilter)
        {
            this.showFilter= false;
        }else
        {
            this.showFilter=true;
        }
    }

    showDialogToSearch() {

        this.rmanReconRevtrigRecogRepSearch=new RmanReconRevtrigRecogRepImpl();

        if (this.isSerached==0) {
            this.rmanReconRevtrigRecogRepSearch=new RmanReconRevtrigRecogRepImpl();
        }
        this.fromDate='';
        this.toDate='';
        this.legalEntity='';
        this.displaySearchDialog = true;

    }

    search() {

        this.isSerached=1;
		this.rmanReconRevtrigRecogRep=this.rmanReconRevtrigRecogRepSearch;
		this.getAllRmanReconRevtrigRecogRep();
    }

    onBeforeToggle(evt: any) {     
      this.collapsed = evt.collapsed;
    }
    
    searchFields(dt:Table){
	$.blockUI();
		this.rmanReconRevtrigRecogRepService.searchFields(this.fromDate,this.toDate,this.legalEntity,this.paginationOptions).then((rmanReconRevtrigRecogRepList:any)=>{		
			this.displaySearchDialog = false;
			this.rmanReconRevtrigRecogRepList = rmanReconRevtrigRecogRepList.content;
            this.totalElements=rmanReconRevtrigRecogRepList.totalElements;
            this.pageSize=rmanReconRevtrigRecogRepList.size;
			$.unblockUI();
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


class RmanReconRevtrigRecogRepImpl implements RmanReconRevtrigRecogRep {
    constructor(public allocAmt?:any,public currency?:any,public arrangementNumber?:any,public exception?:any,public deferredAmt?:any,public eventReceived?:any,public recogAmt?:any,public provisionAmt?:any,public arrangementLineNumber?:any,public deliveredAmt?:any,public soLineNum?:any,public skuRevTrigger?:any,public arrangementName?:any,public so?:any) {}
}

interface ILabels {
     [index: string]: string;
}
