import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";
import { MenuItem } from 'primeng/api';
import { RmanFcstActualDetailsV } from './rmanFcstActualDetailsV';
import { RmanFcstActualDetailsVLabels } from './rmanFcstActualDetailsVLabels';
import { RmanFcstActualDetailsVService } from './rmanFcstActualDetailsVservice';

declare var $:any;

@Component({
    templateUrl: './rmanFcstActualDetailsV.component.html',
    selector: 'rmanFcstActualDetailsV-data',
    providers: [RmanFcstActualDetailsVService ]  
})

export class RmanFcstActualDetailsVComponent implements OnInit{

    displayDialog: boolean;
    
    displaySearchDialog: boolean;
	
	@Input() arrId:string;
	
	arrIdK:any;
	
    rmanFcstActualDetailsV: any = new RmanFcstActualDetailsVImpl();
    
    rmanFcstActualDetailsVSearch: any = new RmanFcstActualDetailsVImpl();
	
	isSerached:number=0;
    
    selectedRmanFcstActualDetailsV: RmanFcstActualDetailsV;

    newRmanFcstActualDetailsV: boolean;

    rmanFcstActualDetailsVList: any[];
    
    cols:any[];
    columns:ILabels;
    
    columnOptions: any[];
    
    paginationOptions:any;
    
    pages:{};

    private items: MenuItem[];
    
    datasource: any[];
    pageSize:number;
    totalElements:number;
    
    
    
    
    constructor(private rmanFcstActualDetailsVService: RmanFcstActualDetailsVService,private router:Router,private route:ActivatedRoute ) {
      
        // generate list code
        this.paginationOptions={'pageNumber':0,'pageSize':'10000'};
        this.route.params.subscribe((params:any) => {
		this.arrIdK = params['id'];
		
	   });
       this.getAllRmanFcstActualDetailsV();
   
    }

    ngOnInit() {
        this.cols = [];
        let cols:any = [];
        cols["glPeriod"] = "glPeriod";
        cols["expectedBookingAmount"] = "expectedBookingAmount";
        cols["recordType"] = "recordType";
        cols["amount"] = "amount";
        cols["qty"] = "qty";
        cols["netPrice"] = "netPrice";
        cols["elementType"] = "elementType";
        cols["startDate"] = "startDate";
        cols["arrangementName"] = "arrangementName";
        cols["sku"] = "sku";
        cols["arrangementId"] = "arrangementId";
        cols["quarterName"] = "quarterName";
         let rmanFcstActualDetailsVLabels = new RmanFcstActualDetailsVLabels();
        
        this.columns=rmanFcstActualDetailsVLabels.fieldLabels;
        
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
                        this.showDialogToAdd();
                    }
                },
                {
                    label: 'Columns', icon: 'fa-columns',command: (event:any) => {
                     this.toggleColumnMenu();
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
                        this.rmanFcstActualDetailsV=new RmanFcstActualDetailsVImpl();
                        this.getAllRmanFcstActualDetailsV();
                    }
                }
        ];
    }

    

    
    getAllRmanFcstActualDetailsV() {
		$.blockUI();
        this.rmanFcstActualDetailsVService.getAllRmanFcstActualDetailsV(this.paginationOptions,{'arrangementId':this.arrIdK}).then((rmanFcstActualDetailsVList:any) => {
        $.unblockUI();  
            this.datasource = rmanFcstActualDetailsVList.content;
            this.rmanFcstActualDetailsVList = rmanFcstActualDetailsVList.content;
            this.totalElements=rmanFcstActualDetailsVList.totalElements;
            this.pageSize=rmanFcstActualDetailsVList.size;
            this.displaySearchDialog = false;
        });
    }
        
    
    getRmanFcstActualDetailsV(event:any) {
    
        let first:number=event.first;
        let rows:number=event.rows;
        let pageNumber:number=first/rows;
        this.paginationOptions={'pageNumber':pageNumber,'pageSize':this.pageSize,'sortField':event.sortField,'sortOrder':event.sortOrder};
		$.blockUI();
        this.rmanFcstActualDetailsVService.getAllRmanFcstActualDetailsV(this.paginationOptions,this.rmanFcstActualDetailsV).then((rmanFcstActualDetailsVList:any) => {
        $.unblockUI();    
			this.datasource = rmanFcstActualDetailsVList.content;
            this.rmanFcstActualDetailsVList = rmanFcstActualDetailsVList.content;
            this.totalElements=rmanFcstActualDetailsVList.totalElements;
            this.pageSize=rmanFcstActualDetailsVList.size;
        });

    }


    showDialogToAdd() {
    
        this.newRmanFcstActualDetailsV = true;
        this.rmanFcstActualDetailsV = new RmanFcstActualDetailsVImpl();
        this.displayDialog = true;
        
    }


    save() {
    
        if (this.newRmanFcstActualDetailsV) {
			$.blockUI();
            this.rmanFcstActualDetailsVService.saveRmanFcstActualDetailsV(this.rmanFcstActualDetailsV).then((response:any) => {
			$.unblockUI();
                 this.getAllRmanFcstActualDetailsV();
            });
        }
        else {
			$.blockUI();
            this.rmanFcstActualDetailsVService.updateRmanFcstActualDetailsV(this.rmanFcstActualDetailsV).then((response:any) => {
			$.unblockUI();
                 this.getAllRmanFcstActualDetailsV();
            });
        }
 
        this.rmanFcstActualDetailsV = new RmanFcstActualDetailsVImpl();

        this.displayDialog = false;
        
    }


    delete(rmanFcstActualDetailsV:any) {
        this.rmanFcstActualDetailsV=rmanFcstActualDetailsV;
        this.displayDialog = false;
        
        if (window.confirm('Are you sure you want to delete this record?')) {
           this.rmanFcstActualDetailsVList.splice(this.findSelectedRmanFcstActualDetailsVIndex(), 1);
		   $.blockUI();
           this.rmanFcstActualDetailsVService.deleteRmanFcstActualDetailsV(this.rmanFcstActualDetailsV).then((response:any) => {  
		   $.unblockUI();
               this.rmanFcstActualDetailsV = new RmanFcstActualDetailsVImpl();
               this.getAllRmanFcstActualDetailsV();
           });    
        }

    }    
    
    editRow(rmanFcstActualDetailsV:any) {
        this.newRmanFcstActualDetailsV = false;
        this.rmanFcstActualDetailsV = this.cloneRmanFcstActualDetailsV(rmanFcstActualDetailsV);
        this.displayDialog = true;
        
    }
    

    findSelectedRmanFcstActualDetailsVIndex(): number {
        return this.rmanFcstActualDetailsVList.indexOf(this.selectedRmanFcstActualDetailsV);
    }

    onRowSelect(event:any) {

    }

    cloneRmanFcstActualDetailsV(c: RmanFcstActualDetailsV): RmanFcstActualDetailsV {
        let rmanFcstActualDetailsV:any
         = new RmanFcstActualDetailsVImpl();
        for(let prop in c) {
            rmanFcstActualDetailsV[prop] = c[prop];
        }
        return rmanFcstActualDetailsV;
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
        if (this.isSerached==0) {
            this.rmanFcstActualDetailsVSearch=new RmanFcstActualDetailsVImpl();
        }
        this.displaySearchDialog = true;
    
    }

    search() {

        this.isSerached=1;
		this.rmanFcstActualDetailsV=this.rmanFcstActualDetailsVSearch;
		this.getAllRmanFcstActualDetailsV();
    }
    
    

}


class RmanFcstActualDetailsVImpl {
    constructor(public glPeriod?:any,public expectedBookingAmount?:any,public recordType?:any,public amount?:any,public qty?:any,public netPrice?:any,public elementType?:any,public startDate?:any,public arrangementName?:any,public sku?:any,public arrangementId?:any,public quarterName?:any) {}
}

interface ILabels {
     [index: string]: string;
}
