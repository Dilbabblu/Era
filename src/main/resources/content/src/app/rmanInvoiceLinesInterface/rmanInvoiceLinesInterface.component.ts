import { Component } from '@angular/core';
import { Table } from 'primeng/table';
import { NotificationService } from '../shared/notifications.service';
import { RmanInvoiceLinesInterface } from './rmanInvoiceLinesInterface';
import { RmanInvoiceLinesInterfaceLabels } from './rmanInvoiceLinesInterfaceLabels';
import { RmanInvoiceLinesInterfaceService } from './rmanInvoiceLinesInterfaceservice';

declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
    templateUrl: './rmanInvoiceLinesInterface.component.html',
    selector: 'rmanInvoiceLinesInterface-data',    
    providers: [RmanInvoiceLinesInterfaceService,]
})

export class RmanInvoiceLinesInterfaceComponent{  

    displayDialog: boolean;
    
    displaySearchDialog: boolean;

    rmanInvoiceLinesInterface: RmanInvoiceLinesInterface = new RmanInvoiceLinesInterfaceImpl();
    
    rmanInvoiceLinesInterfaceSearch: RmanInvoiceLinesInterface = new RmanInvoiceLinesInterfaceImpl();	
	
    isSearched:number=0;
    newRmanInvoiceLinesInterface: boolean;

    selectedRmanInvLinesDetails: any[] = [];
    selectedLines: any[] = [];

    rmanInvoiceLinesInterfaceList: RmanInvoiceLinesInterface[];
    columns:ILabels;
    paginationOptions={};
    pages:{};
    datasource: any[];
    pageSize:number;
    totalElements:number;
	hideColumnMenu: boolean=true;
    showFilter: boolean= false;
    
    cellEditedBillingsDetails:any[]=[];
    loading: boolean;
    collapsed: boolean = true;
    noData = appSettings.noData;
    constructor(private rmanInvoiceLinesInterfaceService: RmanInvoiceLinesInterfaceService,
        private notificationService:NotificationService ) {     
        // generate list code
        this.paginationOptions={'pageNumber':0,'pageSize':'10000'};
    }

    ngOnInit() {
        let rmanInvoiceLinesInterfaceLabels = new RmanInvoiceLinesInterfaceLabels();        
        this.columns=rmanInvoiceLinesInterfaceLabels.fieldLabels;      
        this.selectedLines = [];        
    } 

    exportExcel(){
        let serviceUrl = this.rmanInvoiceLinesInterfaceService.getServiceUrl(this.paginationOptions, this.rmanInvoiceLinesInterface, 'N',1);
        window.location.href = serviceUrl;
    }  
    
    getAllRmanInvoiceLinesInterface() {
        this.rmanInvoiceLinesInterfaceService.getAllRmanInvoiceLinesInterface(this.paginationOptions,this.rmanInvoiceLinesInterface).then((rmanInvoiceLinesInterfaceList:any) => {            
            this.datasource = rmanInvoiceLinesInterfaceList.content;
            this.rmanInvoiceLinesInterfaceList = rmanInvoiceLinesInterfaceList.content;
            this.totalElements=rmanInvoiceLinesInterfaceList.totalElements;
            this.pageSize=rmanInvoiceLinesInterfaceList.size;
            this.displaySearchDialog = false;
        });
    }

    deleteSelected(dt:Table){
        
        this.selectedRmanInvLinesDetails = [];

        for (let i = 0; i < this.selectedLines.length; i++) {
          this.selectedRmanInvLinesDetails.push(this.selectedLines[i].sourceInvoiceLineId);
        }
		if (this.selectedRmanInvLinesDetails.length > 0) {
            this.loading = true;
        	this.rmanInvoiceLinesInterfaceService.deleteRmanInvLinesDetails(this.selectedRmanInvLinesDetails).then((response: any) => {
                this.notificationService.showSuccess('Succesfully selected records are deleted');
           }).then(()=>{
               this.reset(dt);
            }).catch((err:any)=>{
                this.notificationService.showError('Getting error While delete records');
            });
			
		}else{
            this.notificationService.showInfo('Select at least one record to delete');
		}
      }
        
    
    getRmanInvoiceLinesInterface(event:any) {
    
        let first:number=event.first;
        let rows:number=event.rows;
        let pageNumber:number=first/rows;
        this.paginationOptions={'pageNumber':pageNumber,'pageSize':this.pageSize,'sortField':event.sortField,'sortOrder':event.sortOrder};
        this.rmanInvoiceLinesInterfaceService.getAllRmanInvoiceLinesInterface(this.paginationOptions,this.rmanInvoiceLinesInterface).then((rmanInvoiceLinesInterfaceList:any) => {
            this.datasource = rmanInvoiceLinesInterfaceList.content;
            this.rmanInvoiceLinesInterfaceList = rmanInvoiceLinesInterfaceList.content;
            this.totalElements=rmanInvoiceLinesInterfaceList.totalElements;
            this.pageSize=rmanInvoiceLinesInterfaceList.size;
        });

    }


    showDialogToAdd() {
        this.newRmanInvoiceLinesInterface = true;
        this.rmanInvoiceLinesInterface = new RmanInvoiceLinesInterfaceImpl();
        this.displayDialog = true;
    }

    onCellEditComplete(rmanInvoiceLinesInterface){
        let indexOfcurrentEditedIncellEditedIntfDealDetails=this.cellEditedBillingsDetails.findIndex(exception=> exception.sourceInvoiceLineId===rmanInvoiceLinesInterface.sourceInvoiceLineId);

        if(indexOfcurrentEditedIncellEditedIntfDealDetails!=-1){
            this.cellEditedBillingsDetails.splice(indexOfcurrentEditedIncellEditedIntfDealDetails,1);
        }
        rmanInvoiceLinesInterface.interfaceStatus=null;
        rmanInvoiceLinesInterface.errorMessage=null;         
        this.cellEditedBillingsDetails.push(rmanInvoiceLinesInterface);
    }
    saveExceptions(){
        if(this.cellEditedBillingsDetails && this.cellEditedBillingsDetails.length===0){
            this.notificationService.showError('Please edit atleast one exception.');
            return;
        }
        this.rmanInvoiceLinesInterfaceService.saveRmanInvoiceLinesInterface(this.cellEditedBillingsDetails).then((response: any) => {
            this.notificationService.showSuccess('Saved succesfully');
            this.paginationOptions={};
            this.cellEditedBillingsDetails=[];
            this.getAllRmanInvoiceLinesInterface();
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while saving the data');
            this.loading = false;
        });
    }
    saveAndProcessExceptions(){
        if(this.cellEditedBillingsDetails && this.cellEditedBillingsDetails.length===0){
            this.__processBillings();
        }else{
            this.rmanInvoiceLinesInterfaceService.saveRmanInvoiceLinesInterface(this.cellEditedBillingsDetails).then((response: any) => {
                this.paginationOptions={};
                this.cellEditedBillingsDetails=[];
                this.__processBillings();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while saving exceptions');
                this.loading = false;
            });
        }
    }

    __processBillings(){
        this.rmanInvoiceLinesInterfaceService.processBillings().then((response: any) => {
            this.notificationService.showSuccess('Saved/Processed succesfully');
            this.loading = false;
            this.getAllRmanInvoiceLinesInterface();
        }).catch((err: any) => {                
            this.notificationService.showError('Error occured while saving/processing exceptions');
            this.loading = false;
        });    
    }

    reset(dt: Table) {
        this.paginationOptions = {};
        this.rmanInvoiceLinesInterface = new RmanInvoiceLinesInterfaceImpl();
        dt.reset();
    }
    save() {
    
        if (this.newRmanInvoiceLinesInterface) {
            this.rmanInvoiceLinesInterfaceService.saveRmanInvoiceLinesInterface(this.rmanInvoiceLinesInterface).then((response:any) => {
                 this.getAllRmanInvoiceLinesInterface();
            });
        }
        else {
            this.rmanInvoiceLinesInterfaceService.updateRmanInvoiceLinesInterface(this.rmanInvoiceLinesInterface).then((response:any) => {
                 this.getAllRmanInvoiceLinesInterface();
            });
        }
 
        this.rmanInvoiceLinesInterface = new RmanInvoiceLinesInterfaceImpl();

        this.displayDialog = false;
        
    }
    
    editRow(rmanInvoiceLinesInterface:any) {
        this.newRmanInvoiceLinesInterface = false;
        this.rmanInvoiceLinesInterface = this.cloneRmanInvoiceLinesInterface(rmanInvoiceLinesInterface);
        this.displayDialog = true;
        
    }
    
    onBeforeToggle(evt: any) {
        this.collapsed = evt.collapsed;
    }

    onRowSelect(event:any) {

    }

    cloneRmanInvoiceLinesInterface(c: RmanInvoiceLinesInterface): RmanInvoiceLinesInterface {
        let rmanInvoiceLinesInterface = new RmanInvoiceLinesInterfaceImpl();
        for(let prop in c) {
            rmanInvoiceLinesInterface[prop] = c[prop];
        }
        return rmanInvoiceLinesInterface;
    }    

    toggleColumnMenu(){
        if(this.hideColumnMenu)
        {
            this.hideColumnMenu= false;
        }else
        {
            this.hideColumnMenu=true;
        }
    }

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

        this.rmanInvoiceLinesInterfaceSearch=new RmanInvoiceLinesInterfaceImpl();
  
		if (this.isSearched==0) {
            this.rmanInvoiceLinesInterfaceSearch=new RmanInvoiceLinesInterfaceImpl();
        }
        this.displaySearchDialog = true;
    
    }

    search() {

		this.isSearched=1;
		this.rmanInvoiceLinesInterface=this.rmanInvoiceLinesInterfaceSearch;
		this.getAllRmanInvoiceLinesInterface();
    }
	cancelSearch() {
        this.displaySearchDialog = false;
		this.rmanInvoiceLinesInterfaceSearch=new RmanInvoiceLinesInterfaceImpl();		
    }
}


class RmanInvoiceLinesInterfaceImpl implements RmanInvoiceLinesInterface {
    constructor(public fxDate?,public acctdCurrency?,public invoiceSource?,public quantity?,public salesOrderNumber?,public origLastUpdatedBy?,public invoiceCurrency?,public lastUpdateDate?,public actualShippedDate?,public invoiceType?,public unitSellingPrice?,public createdBy?,public lastUpdatedBy?,public cogsAmount?,public origCreatedBy?,public debitAccount?,public sourceLineNumber?,public sourceOrderLineId?,public creationDate?,public glDate?,public origLastUpdateDate?,public interfaceProcessId?,public rmanAcctRuleId?,public rmanLineId?,public rmanInvoiceLineId?,public errorMessage?,public origCreationDate?,public invoicedDate?,public sourceInvoiceLineId?,public servicePeriod?,public usdAmount?,public revenueAmount?,public errorFlag?,public interfaceStatus?,public fxRate?,public sourceInvoiceId?,public serviceStartDate?,public serviceDuration?,public lineType?,public cogsAccount?,public invoiceNumber?,public acctdRevAmount?,public pid?,public accountingRuleName?,public serviceEndDate?,public invoiceTrxType?,public invoiceLineNumber?,public processedDate?,public creditAccount?) {}
}

interface ILabels {
     [index: string]: string;
}
