import { Component } from '@angular/core';
import { Table } from 'primeng/table';
import { RmanLegalEntitiesService } from '../rmanLegalEntities/rmanLegalEntitiesservice';
import { NotificationService } from '../shared/notifications.service';
import { RmanIntfDealDetails } from './rmanIntfDealDetails';
import { RmanIntfDealDetailsLabels } from './rmanIntfDealDetailsLabels';
import { RmanIntfDealDetailsService } from './rmanIntfDealDetailsservice';

declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
    templateUrl: './rmanIntfDealDetails.component.html',
    selector: 'rmanIntfDealDetails-data',    
    providers: [RmanIntfDealDetailsService,RmanLegalEntitiesService]
})

export class RmanIntfDealDetailsComponent{

    displayDialog: boolean;
    
    displaySearchDialog: boolean;

    rmanIntfDealDetails: RmanIntfDealDetails = new RmanIntfDealDetailsImpl();
    
    rmanIntfDealDetailsSearch: RmanIntfDealDetails = new RmanIntfDealDetailsImpl();	
	
    isSearched:number=0;
    selectedRmanIntfDealDetails: any[] = [];
    selectedLines: any[] = [];


    newRmanIntfDealDetails: boolean;

    rmanIntfDealDetailsList: RmanIntfDealDetails[];
    columns:ILabels;
    paginationOptions={};
    pages:{};
    datasource: any[];
    pageSize:number;
    totalElements:number;
	hideColumnMenu: boolean=true;
    showFilter: boolean= false;
    noData = appSettings.noData;
    loading: boolean;
    collapsed: boolean = true;
    cellEditedIntfDealDetails:any[]=[];
    rmanLegalEntitiesList: any[] = [];
    rmanLegalEntities: any[];
    
    constructor(private rmanIntfDealDetailsService: RmanIntfDealDetailsService,private rmanLegalEntitiesService: RmanLegalEntitiesService,
        private notificationService:NotificationService ) {     
        // generate list code
        this.paginationOptions={'pageNumber':0,'pageSize':'10000'};   
    }

    ngOnInit() {  
        this.rmanLegalEntitiesService.getAllRmanLegalEntities(this.paginationOptions, {}).then((rmanLegalEntitiesList: any) => {
            this.rmanLegalEntitiesList = rmanLegalEntitiesList.content;
            this.prepareRmanLegalEntitiesObject();
        });       
        let rmanIntfDealDetailsLabels = new RmanIntfDealDetailsLabels();        
        this.columns=rmanIntfDealDetailsLabels.fieldLabels;    
        this.selectedLines = [];      
    }

    exportExcel(){
        let serviceUrl = this.rmanIntfDealDetailsService.getServiceUrl(this.paginationOptions, this.rmanIntfDealDetails, 'N',1);
        window.location.href = serviceUrl;
    }    
    getAllRmanIntfDealDetails() {
        this.rmanIntfDealDetailsService.getAllRmanIntfDealDetails(this.paginationOptions,this.rmanIntfDealDetails).then((rmanIntfDealDetailsList:any) => {            
            this.datasource = rmanIntfDealDetailsList.content;
            this.rmanIntfDealDetailsList = rmanIntfDealDetailsList.content;
            this.totalElements=rmanIntfDealDetailsList.totalElements;
            this.pageSize=rmanIntfDealDetailsList.size;
            this.displaySearchDialog = false;
        });
    }
    
    onCellEditComplete(rmanIntfDealDetails:any){
        let indexOfcurrentEditedIncellEditedIntfDealDetails=this.cellEditedIntfDealDetails.findIndex(exception=> exception.arrangementNumber+'_'+exception.dealNumber+'_'+exception.dealLineNumber === rmanIntfDealDetails.arrangementNumber+'_'+rmanIntfDealDetails.dealNumber+'_'+rmanIntfDealDetails.dealLineNumber);
        if(indexOfcurrentEditedIncellEditedIntfDealDetails!=-1){
            this.cellEditedIntfDealDetails.splice(indexOfcurrentEditedIncellEditedIntfDealDetails, 1);
        }
        rmanIntfDealDetails.interfaceStatus=null;
        rmanIntfDealDetails.interfaceError=null;         
        this.cellEditedIntfDealDetails.push(rmanIntfDealDetails);
    }
    saveExceptions(){
        if(this.cellEditedIntfDealDetails && this.cellEditedIntfDealDetails.length===0){
            this.notificationService.showError('Please edit atleast one exception.');
            return;
        }
        this.rmanIntfDealDetailsService.saveRmanIntfDealDetails(this.cellEditedIntfDealDetails).then((response: any) => {
            this.notificationService.showSuccess('Saved successfully');
            this.paginationOptions={};
            this.cellEditedIntfDealDetails=[];
            this.getAllRmanIntfDealDetails();    
        }).catch((err: any) => {          
            this.notificationService.showError('Error occured while saving the data');  
            this.loading = false;
        });
    }
    saveAndProcessExceptions(){        
        if(this.cellEditedIntfDealDetails && this.cellEditedIntfDealDetails.length===0){
            this.__processDealDetails();
        }else{
            this.rmanIntfDealDetailsService.saveRmanIntfDealDetails(this.cellEditedIntfDealDetails).then((response: any) => {
                this.paginationOptions={};
                this.cellEditedIntfDealDetails=[];
                this.__processDealDetails();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while saving exceptions');
                this.loading = false;
            });
        }       
    }

    __processDealDetails(){
        this.rmanIntfDealDetailsService.processRmanIntfDealDetails().then((response: any) => {
            this.notificationService.showSuccess('Saved/Processed succesfully');
            this.loading = false;
            this.getAllRmanIntfDealDetails();
        }).catch((err: any) => {                
            this.notificationService.showError('Error occured while saving/processing exceptions');
            this.loading = false;
        });   
    }

    prepareRmanLegalEntitiesObject() {
        let rmanLegalEntitiesTempObj: any = [{ label: appSettings.dropDownOptions.selectLegalEntity, value: null }];
        this.rmanLegalEntitiesList.forEach((rmanLegalEntities) => {
          rmanLegalEntitiesTempObj.push({ label: rmanLegalEntities.name, value: rmanLegalEntities.legalEntityId });
        });
        this.rmanLegalEntities = rmanLegalEntitiesTempObj;
      }
    getRmanIntfDealDetails(event:any) {
    
        let first:number=event.first;
        let rows:number=event.rows;
        let pageNumber:number=first/rows;
        this.paginationOptions={'pageNumber':pageNumber,'pageSize':this.pageSize,'sortField':event.sortField,'sortOrder':event.sortOrder};
        this.rmanIntfDealDetailsService.getAllRmanIntfDealDetails(this.paginationOptions,this.rmanIntfDealDetails).then((rmanIntfDealDetailsList:any) => {
            this.datasource = rmanIntfDealDetailsList.content;
            this.rmanIntfDealDetailsList = rmanIntfDealDetailsList.content;
            this.totalElements=rmanIntfDealDetailsList.totalElements;
            this.pageSize=rmanIntfDealDetailsList.size;
        });

    }
    onBeforeToggle(evt: any) {
        this.collapsed = evt.collapsed;
    }

    showDialogToAdd() {
        this.newRmanIntfDealDetails = true;
        this.rmanIntfDealDetails = new RmanIntfDealDetailsImpl();
        this.displayDialog = true;
    }


    save() {
        if (this.newRmanIntfDealDetails) {
            this.rmanIntfDealDetailsService.saveRmanIntfDealDetails(this.rmanIntfDealDetails).then((response:any) => {
                 this.getAllRmanIntfDealDetails();
            });
        }
        else {
            this.rmanIntfDealDetailsService.updateRmanIntfDealDetails(this.rmanIntfDealDetails).then((response:any) => {
                 this.getAllRmanIntfDealDetails();
            });
        }
 
        this.rmanIntfDealDetails = new RmanIntfDealDetailsImpl();

        this.displayDialog = false;
        
    }


    deleteSelected(dt:Table){
        
        this.selectedRmanIntfDealDetails = [];

        for (let i = 0; i < this.selectedLines.length; i++) {
          this.selectedRmanIntfDealDetails.push(this.selectedLines[i].arrangementNumber);
        }
		if (this.selectedRmanIntfDealDetails.length > 0) {
            this.loading = true;
        	this.rmanIntfDealDetailsService.deleteRmanIntfDealDetails(this.selectedRmanIntfDealDetails).then((response: any) => {
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
    
    editRow(rmanIntfDealDetails:any) {
        this.newRmanIntfDealDetails = false;
        this.rmanIntfDealDetails = this.cloneRmanIntfDealDetails(rmanIntfDealDetails);
        this.displayDialog = true;
        
    }

    onRowSelect(event:any) {

    }

    cloneRmanIntfDealDetails(c: RmanIntfDealDetails): RmanIntfDealDetails {
        let rmanIntfDealDetails = new RmanIntfDealDetailsImpl();
        for(let prop in c) {
            rmanIntfDealDetails[prop] = c[prop];
        }
        return rmanIntfDealDetails;
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

        this.rmanIntfDealDetailsSearch=new RmanIntfDealDetailsImpl();
  
		if (this.isSearched==0) {
            this.rmanIntfDealDetailsSearch=new RmanIntfDealDetailsImpl();
        }
        this.displaySearchDialog = true;
    
    }

    search() {

		this.isSearched=1;
		this.rmanIntfDealDetails=this.rmanIntfDealDetailsSearch;
		this.getAllRmanIntfDealDetails();
    }
    reset(dt: Table) {
        this.paginationOptions = {};
        this.rmanIntfDealDetails = new RmanIntfDealDetailsImpl();
        dt.reset();

    }
	cancelSearch() {
        this.displaySearchDialog = false;
		this.rmanIntfDealDetailsSearch=new RmanIntfDealDetailsImpl();		
    }
}


class RmanIntfDealDetailsImpl implements RmanIntfDealDetails {
    constructor(public fxDate?,public arrangementSource?,public unitCost?,public interfaceError?,public quantity?,public priceList?,public endDate?,public additionalAttribute1?,public additionalAttribute2?,public additionalAttribute3?,public sourceLineRefId?,public unitSellingPrice?,public unitListPrice?,public dealName?,public durationUom?,public entityName?,public createdBy?,public productName?,public arrgBasis?,public adjustmentAmount?,public agreementId?,public operationCode?,public masterArrgName?,public allocationExcludeFlag?,public fvPercent?,public msaName?,public currencyCode?,public interfaceStatus?,public fxRate?,public dealNumber?,public billToCustomerName?,public arrangementName?,public arrangementBasis?,public arrgSource?,public agreementName?,public salesNodeLevel4?,public additionalLineAttribute3?,public salesNodeLevel2?,public additionalLineAttribute1?,public msaNumber?,public salesNodeLevel3?,public additionalLineAttribute2?,public dealLineNumber?,public arrangementNumber?,public bespPerUnit?,public startDate?,public parentLineId?,public masterArrgFlag?,public salesNodeLevel1?,public accountingRuleName?,public contractUnitType?,public customerName?,public duration?,public eitfSop?,public bundleFlag?) {}
}

interface ILabels {
     [index: string]: string;
}
