import { Component } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { Table } from 'primeng/table';
import { BsbReport } from './bsbReport';
import { BsbReportLabels } from './bsbReportLabels';
import { BsbReportService } from './bsbReportservice';
declare var require: any;

declare var $: any;

const appSettings = require('../appsettings');

@Component({
    templateUrl: './bsbReport.component.html',
    selector: 'bspReport-data',
    providers: [BsbReportService ]  
})

export class BsbReportComponent{

     displayDialog: boolean;
    
    displaySearchDialog: boolean;

    bsbReport: any = new BsbReportImpl();
    
    bsbReportSearch: any = new BsbReportImpl();
	
	isSerached:number=0;
    
    selectedBsbReport: BsbReport;

    newBsbReport: boolean;

    bsbReportList: any[];

    searchFields: any = {};
    
    noData = appSettings.noData;

    loading: boolean;
    
    cols:any[];
    columns:ILabels;

    collapsed:boolean = true;
    
    columnOptions: any[];
    
    paginationOptions:any;
    
    pages:{};

    private items: MenuItem[];
    
    datasource: any[];
    pageSize:number;
    totalElements:number;
    
    
    
    
    constructor(private bsbReportService: BsbReportService ) {
        this.paginationOptions={'pageNumber':0,'pageSize':'10000'};
    }


    ngOnInit() {
        
        this.cols = [];
		let bsbReportLabels = new BsbReportLabels();
        
        this.columns=bsbReportLabels.fieldLabels;
        
        this.columnOptions = [];
        
        this.cols=[];
        
	    for (let prop in this.columns) {
			 this.cols.push({field: prop, header: this.columns[prop]});
			 this.columnOptions.push({label: this.columns[prop], value: prop});
		}

        this.items = 
        [
                {
                    label: 'Add', icon: 'fa-plus',command:(event:any)=>{
                    }
                },
                {
                    label: 'Columns', icon: 'fa-columns',command: (event:any) => {
                    }
                },
                {
                    label: 'Search', icon: 'fa-search',command:(event:any)=>{
                        this.showDialogToSearch();
                    }
                },
                {
                    label: 'Reset', icon: 'fa-refresh',command:(event:any)=>{
                        this.paginationOptions={};
                        this.bsbReport=new BsbReportImpl();
                        this.getAllBsbReport();
                    }
                }
        ];
    }

    reset(dt:Table){
        this.paginationOptions = {};
        this.bsbReport = new BsbReportImpl();
        this.bsbReportSearch=new BsbReportImpl();
        dt.reset();
      }

    
      getAllBsbReport() {
        this.loading = true;
        this.bsbReportService.getAllBsbReport(this.paginationOptions,this.bsbReport,this.searchFields).then((bsbReportList:any) => {
            this.datasource = bsbReportList.content;
            this.bsbReportList = bsbReportList.content;
            this.totalElements=bsbReportList.totalElements;
            this.pageSize=bsbReportList.size;
            this.loading = false;
            this.displaySearchDialog = false;
        });
    }
        
    
    getBsbReport(event:any) {
    
        let first:number=event.first;
        let rows:number=event.rows;
        let pageNumber:number=first/rows;
        this.paginationOptions={'pageNumber':pageNumber,'pageSize':this.pageSize,'sortField':event.sortField,'sortOrder':event.sortOrder};
        this.loading = true;
        this.bsbReportService.getAllBsbReport(this.paginationOptions,this.bsbReport,this.searchFields).then((bsbReportList:any) => {
            this.datasource = bsbReportList.content;
            this.bsbReportList = bsbReportList.content;
            this.totalElements=bsbReportList.totalElements;
            this.pageSize=bsbReportList.size;
            this.loading = false;
        });

    }

    exportExcel() {
        this.loading = true;
          let serviceUrl = this.bsbReportService.getServiceUrl(this.paginationOptions, this.bsbReport, 1,this.searchFields);
      this.loading = false;
          window.location.href = serviceUrl;
        }
    
        findSelectedBsbReportIndex(): number {
        return this.bsbReportList.indexOf(this.selectedBsbReport);
    }

    onRowSelect(event:any) {

    }

    showDialogToSearch() {

       if (this.isSerached==0) {
            this.bsbReportSearch=new BsbReportImpl();
        }
        this.displaySearchDialog = true;
    
    }

    search() {

        this.isSerached=1;
		this.bsbReport=this.bsbReportSearch;
        this.getAllBsbReport();
        this.displaySearchDialog = false;
    }
    onBeforeToggle(evt: any) {
        this.collapsed = evt.collapsed;
    } 
    

}
 
class BsbReportImpl {
    constructor(public productFamily2?:any,public serviceCode?:any,public geography10k?:any,public reasonForExclusion?:any,public billToCountry?:any,public fob?:any,public username?:any,public concatenate?:any,public extendedWarranty?:any,public billToState?:any,public region?:any,public shippedAmount?:any,public productLine?:any,public customerPo?:any,public snExists?:any,public source?:any,public financialMonth?:any,public je?:any,public serviceMaintNewParts?:any,public shipToCustomerName?:any,public extendedCost?:any,public warrantyTransferred?:any,public freightTerms?:any,public freightCarrier?:any,public division?:any,public invoiceLine?:any,public productService?:any,public note?:any,public shipDate?:any,public shippedQuantity?:any,public orderLine?:any,public productNumber?:any,public serviceStartDate?:any,public billToCustomerName?:any,public endCustomer?:any,public reasonForExclusion2?:any,public itemType?:any,public reasonForExclusion3?:any,public serviceMaintLegacy?:any,public orderType?:any,public invoiceNumber?:any,public isRevenue?:any,public totalMonths?:any,public serviceEndDate?:any,public productFamily?:any,public shipToCountry?:any,public orderNumber?:any,public subOrderType?:any,public salesrepName?:any) {}
}

interface ILabels {
     [index: string]: string;
} 
