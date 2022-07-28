import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { RmanLookupsV } from './rmanLookupsV';
import { RmanLookupsVLabels } from './rmanLookupsVLabels';
import { RmanLookupsVService } from './rmanLookupsVservice';


declare var $:any;

@Component({
    templateUrl: './rmanLookupsV.component.html',
    selector: 'rmanLookupsV-data',
    providers: [RmanLookupsVService ]  
})

export class RmanLookupsVComponent implements OnInit{

    displayDialog: boolean;
    
    displaySearchDialog: boolean;

    rmanLookupsV: any = new RmanLookupsVImpl();
    
    rmanLookupsVSearch: any = new RmanLookupsVImpl();
	
	isSerached:number=0;
    
    selectedRmanLookupsV: RmanLookupsV;

    newRmanLookupsV: boolean;

    rmanLookupsVList: any[];
    
    cols:any[];
    columns:ILabels;
    
    columnOptions: any[];
    
    paginationOptions:any;
    
    pages:{};

    public items: MenuItem[];
    
    datasource: any[];
    pageSize:number;
    totalElements:number;
    
    
    
    
    constructor(private rmanLookupsVService: RmanLookupsVService ) {
        // generate list code
        this.paginationOptions={'pageNumber':0,'pageSize':'10000'};
    }

    ngOnInit() {
        
        this.getAllRmanLookupsV();
        
        this.cols = [];
        let cols:any = [];
        cols["lookupCodeEndDate"] = "lookupCodeEndDate";
        cols["lookupTypeName"] = "lookupTypeName";
        cols["lookupTypeEnabledFlag"] = "lookupTypeEnabledFlag";
        cols["lookupCodeEnabledFlag"] = "lookupCodeEnabledFlag";
        cols["lookupTypeDescription"] = "lookupTypeDescription";
        cols["lookupDescription"] = "lookupDescription";
        cols["lookupCode"] = "lookupCode";
        cols["lookupTypeEndDate"] = "lookupTypeEndDate";
        cols["lookupTypeStartDate"] = "lookupTypeStartDate";
        cols["lookupCodeStartDate"] = "lookupCodeStartDate";
        cols["lookupTypeMeaning"] = "lookupTypeMeaning";
         let rmanLookupsVLabels = new RmanLookupsVLabels();
        
        this.columns=rmanLookupsVLabels.fieldLabels;
        
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
                        this.rmanLookupsV=new RmanLookupsVImpl();
                        this.getAllRmanLookupsV();
                    }
                }
        ];
    }

    

    
    getAllRmanLookupsV() {
        this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions,this.rmanLookupsV).then((rmanLookupsVList:any) => {
            this.datasource = rmanLookupsVList.content;
            this.rmanLookupsVList = rmanLookupsVList.content;
            this.totalElements=rmanLookupsVList.totalElements;
            this.pageSize=rmanLookupsVList.size;
            this.displaySearchDialog = false;
        });
    }
        
    
    getRmanLookupsV(event:any) {
    
        let first:number=event.first;
        let rows:number=event.rows;
        let pageNumber:number=first/rows;
        this.paginationOptions={'pageNumber':pageNumber,'pageSize':this.pageSize,'sortField':event.sortField,'sortOrder':event.sortOrder};
        this.rmanLookupsVService.getAllRmanLookupsV(this.paginationOptions,this.rmanLookupsV).then((rmanLookupsVList:any) => {
            this.datasource = rmanLookupsVList.content;
            this.rmanLookupsVList = rmanLookupsVList.content;
            this.totalElements=rmanLookupsVList.totalElements;
            this.pageSize=rmanLookupsVList.size;
        });

    }


    showDialogToAdd() {
    
        this.newRmanLookupsV = true;
        this.rmanLookupsV = new RmanLookupsVImpl();
        this.displayDialog = true;
        
    }


    save() {
    
        if (this.newRmanLookupsV) {
            this.rmanLookupsVService.saveRmanLookupsV(this.rmanLookupsV).then((response:any) => {
                 this.getAllRmanLookupsV();
            });
        }
        else {
            this.rmanLookupsVService.updateRmanLookupsV(this.rmanLookupsV).then((response:any) => {
                 this.getAllRmanLookupsV();
            });
        }
 
        this.rmanLookupsV = new RmanLookupsVImpl();

        this.displayDialog = false;
        
    }


    delete(rmanLookupsV:any) {
        this.rmanLookupsV=rmanLookupsV;
        this.displayDialog = false;
        
        if (window.confirm('Are you sure you want to delete this record?')) {
           this.rmanLookupsVList.splice(this.findSelectedRmanLookupsVIndex(), 1);
           this.rmanLookupsVService.deleteRmanLookupsV(this.rmanLookupsV).then((response:any) => {  
               this.rmanLookupsV = new RmanLookupsVImpl();
               this.getAllRmanLookupsV();
           });    
        }

    }    
    
    editRow(rmanLookupsV:any) {
        this.newRmanLookupsV = false;
        this.rmanLookupsV = this.cloneRmanLookupsV(rmanLookupsV);
        this.displayDialog = true;
        
    }
    

    findSelectedRmanLookupsVIndex(): number {
        return this.rmanLookupsVList.indexOf(this.selectedRmanLookupsV);
    }

    onRowSelect(event:any) {

    }

    cloneRmanLookupsV(c: RmanLookupsV): RmanLookupsV {
        let rmanLookupsV:any
         = new RmanLookupsVImpl();
        for(let prop in c) {
            rmanLookupsV[prop] = c[prop];
        }
        return rmanLookupsV;
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
            this.rmanLookupsVSearch=new RmanLookupsVImpl();
        }
        this.displaySearchDialog = true;
    
    }

    search() {

        this.isSerached=1;
		this.rmanLookupsV=this.rmanLookupsVSearch;
		this.getAllRmanLookupsV();
    }
    
    

}


class RmanLookupsVImpl {
    constructor(public lookupCodeEndDate?:any,public lookupTypeName?:any,public lookupTypeEnabledFlag?:any,public lookupCodeEnabledFlag?:any,public lookupTypeDescription?:any,public lookupDescription?:any,public lookupCode?:any,public lookupTypeEndDate?:any,public lookupTypeStartDate?:any,public lookupCodeStartDate?:any,public lookupTypeMeaning?:any) {}
}

interface ILabels {
     [index: string]: string;
}
