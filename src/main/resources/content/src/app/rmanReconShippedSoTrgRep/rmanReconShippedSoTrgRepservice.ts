import { DatePipe } from '@angular/common';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
declare var require:any;
const appSettings = require('../appsettings');


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
  })
}




@Injectable()
export class RmanReconShippedSoTrgRepService {

    constructor(private http: HttpClient,private datePipe:DatePipe) {}

    getServiceUrl(paginationOptions:any,rmanReconShippedSoTrgRepSearchObject:any,  exportFlag?: any) {
        let serviceUrl=appSettings.apiUrl+'/rmanReconShippedSoTrgRepExport?';
      

        if (exportFlag == 0) {
            serviceUrl = appSettings.apiUrl + '/rmanReconShippedSoTrgRepSearch?';
        }
            
        let searchString='';

        if (rmanReconShippedSoTrgRepSearchObject.arrangementName!=undefined && rmanReconShippedSoTrgRepSearchObject.arrangementName!="") {
            searchString=searchString+'arrangementName:'+rmanReconShippedSoTrgRepSearchObject.arrangementName+',';
        }

        if (rmanReconShippedSoTrgRepSearchObject.arrangementNumber!=undefined && rmanReconShippedSoTrgRepSearchObject.arrangementNumber!="") {
            searchString=searchString+'arrangementNumber:'+rmanReconShippedSoTrgRepSearchObject.arrangementNumber+',';
        }

        if (rmanReconShippedSoTrgRepSearchObject.so!=undefined && rmanReconShippedSoTrgRepSearchObject.so!="") {
            searchString=searchString+'so:'+rmanReconShippedSoTrgRepSearchObject.so+',';
        }

        if (rmanReconShippedSoTrgRepSearchObject.soLineNum!=undefined && rmanReconShippedSoTrgRepSearchObject.soLineNum!="") {
            searchString=searchString+'soLineNum:'+rmanReconShippedSoTrgRepSearchObject.soLineNum+',';
        }

        if (rmanReconShippedSoTrgRepSearchObject.entity!=undefined && rmanReconShippedSoTrgRepSearchObject.entity!="") {
            searchString=searchString+'entity:'+rmanReconShippedSoTrgRepSearchObject.entity+',';
        }

        if (rmanReconShippedSoTrgRepSearchObject.deliveredDate!=undefined && rmanReconShippedSoTrgRepSearchObject.deliveredDate!="") {
            searchString=searchString+'deliveredDate:'+rmanReconShippedSoTrgRepSearchObject.deliveredDate+',';
        }

        if (rmanReconShippedSoTrgRepSearchObject.arrgLineNum!=undefined && rmanReconShippedSoTrgRepSearchObject.arrgLineNum!="") {
            searchString=searchString+'arrgLineNum:'+rmanReconShippedSoTrgRepSearchObject.arrgLineNum+',';
        }

        if (rmanReconShippedSoTrgRepSearchObject.sku!=undefined && rmanReconShippedSoTrgRepSearchObject.sku!="") {
            searchString=searchString+'sku:'+rmanReconShippedSoTrgRepSearchObject.sku+',';
        }

        if (rmanReconShippedSoTrgRepSearchObject.srcDeliveredQty!=undefined && rmanReconShippedSoTrgRepSearchObject.srcDeliveredQty!="") {
            searchString=searchString+'srcDeliveredQty:'+rmanReconShippedSoTrgRepSearchObject.srcDeliveredQty+',';
        }

        if (rmanReconShippedSoTrgRepSearchObject.trgDeliveredQty!=undefined && rmanReconShippedSoTrgRepSearchObject.trgDeliveredQty!="") {
            searchString=searchString+'trgDeliveredQty:'+rmanReconShippedSoTrgRepSearchObject.trgDeliveredQty+',';
        }

        if (rmanReconShippedSoTrgRepSearchObject.eventReceived!=undefined && rmanReconShippedSoTrgRepSearchObject.eventReceived!="") {
            searchString=searchString+'eventReceived:'+rmanReconShippedSoTrgRepSearchObject.eventReceived+',';
        }

        if (rmanReconShippedSoTrgRepSearchObject.revTriggerForSku!=undefined && rmanReconShippedSoTrgRepSearchObject.revTriggerForSku!="") {
            searchString=searchString+'revTriggerForSku:'+rmanReconShippedSoTrgRepSearchObject.revTriggerForSku+',';
        }

        if (rmanReconShippedSoTrgRepSearchObject.exception!=undefined && rmanReconShippedSoTrgRepSearchObject.exception!="") {
            searchString=searchString+'exception:'+rmanReconShippedSoTrgRepSearchObject.exception;
        }


        
        if (searchString == '') {
            serviceUrl=serviceUrl+'search=%25';
        }
        else {
            serviceUrl=serviceUrl+'search='+searchString;
        }
        
        if (paginationOptions.pageNumber!=undefined && paginationOptions.pageNumber!="" && !isNaN(paginationOptions.pageNumber) && paginationOptions.pageNumber!=0) {
           serviceUrl=serviceUrl+'&page='+paginationOptions.pageNumber+'&size='+paginationOptions.pageSize;
        }
        return serviceUrl;
                
       
    }
    
    getAllRmanReconShippedSoTrgRep(paginationOptions:any,rmanReconShippedSoTrgRepSearchObject:any) {
        let serviceUrl = this.getServiceUrl(paginationOptions, rmanReconShippedSoTrgRepSearchObject, 0);
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }

    
    
	searchRmanReconShippedSoTrgRep(rmanReconShippedSoTrgRep:any) {
        return this.http.get(appSettings.apiUrl+'/RMAN_RECON_SHIPPED_SO_TRG_REP/search/findByArrangementNameAndArrangementNumberAndSoAndSoLineNumAndEntityAndDeliveredDateAndArrgLineNumAndSkuAndSrcDeliveredQtyAndTrgDeliveredQtyAndEventReceivedAndRevTriggerForSkuAndException?arrangementName='+rmanReconShippedSoTrgRep.arrangementName+'&arrangementNumber='+rmanReconShippedSoTrgRep.arrangementNumber+'&so='+rmanReconShippedSoTrgRep.so+'&soLineNum='+rmanReconShippedSoTrgRep.soLineNum+'&entity='+rmanReconShippedSoTrgRep.entity+'&deliveredDate='+rmanReconShippedSoTrgRep.deliveredDate+'&arrgLineNum='+rmanReconShippedSoTrgRep.arrgLineNum+'&sku='+rmanReconShippedSoTrgRep.sku+'&srcDeliveredQty='+rmanReconShippedSoTrgRep.srcDeliveredQty+'&trgDeliveredQty='+rmanReconShippedSoTrgRep.trgDeliveredQty+'&eventReceived='+rmanReconShippedSoTrgRep.eventReceived+'&revTriggerForSku='+rmanReconShippedSoTrgRep.revTriggerForSku+'&exception='+rmanReconShippedSoTrgRep.exception).toPromise().then(data => {
			return data; 
			});
    }
    
    saveRmanReconShippedSoTrgRep(rmanReconShippedSoTrgRep:any) {
        let body = JSON.stringify(rmanReconShippedSoTrgRep);
       
        return this.http.post(appSettings.apiUrl+'/RMAN_RECON_SHIPPED_SO_TRG_REP',body,httpOptions).toPromise().then(data => {
            return data;
        });
    }
    
    updateRmanReconShippedSoTrgRep(rmanReconShippedSoTrgRep:any) {
        
        delete rmanReconShippedSoTrgRep._links;
        delete rmanReconShippedSoTrgRep.interests;
        let body = JSON.stringify(rmanReconShippedSoTrgRep);
   
        return this.http.put(appSettings.apiUrl+'/RMAN_RECON_SHIPPED_SO_TRG_REP/'+rmanReconShippedSoTrgRep.arrangementNumber,body,httpOptions).toPromise().then(data => {
            return data;
        });
        
    }
    
    deleteRmanReconShippedSoTrgRep(rmanReconShippedSoTrgRep:any) {
        let deleteUrl=appSettings.apiUrl+'/RMAN_RECON_SHIPPED_SO_TRG_REP/'+rmanReconShippedSoTrgRep.arrangementNumber;
      
        return this.http.delete(deleteUrl,httpOptions).toPromise().then(data => {
            return data;
        });
    }
    
    searchFields(fromDate:any,toDate:any,legalEntity:any,paginationOptions:any){
    	if(fromDate==undefined){
    		fromDate='';
    	}
		
		if(toDate==undefined){
    		toDate = '';
    	}
    	
    	if(legalEntity==undefined){
    		legalEntity = '';
    	}
		let searchUrl = appSettings.apiUrl+'/revmantra/reconShippedSOTrigParams?fromDate='+this.datePipe.transform(fromDate,'yyyyMMdd')+'&toDate='+this.datePipe.transform(toDate,'yyyyMMdd')+'&legalEntity='+legalEntity;
		if (paginationOptions.pageNumber!=undefined && paginationOptions.pageNumber!="" && !isNaN(paginationOptions.pageNumber) && paginationOptions.pageNumber!=0) {
           searchUrl=searchUrl+'&page='+paginationOptions.pageNumber+'&size='+paginationOptions.pageSize;
        }
    	 return this.http.get(searchUrl).toPromise().then((data:any) => {
            return data;
        });
    }
    
    exportShippedSOTrigReport(fromDate:any,toDate:any,legalEntity:any,paginationOptions:any, exportCols: any){
    	if(fromDate==undefined){
    		fromDate='';
    	}
		
		if(toDate==undefined){
    		toDate = '';
    	}
    	
    	if(legalEntity==undefined){
    		legalEntity = '';
    	}
		let serviceUrl=  appSettings.apiUrl+'/rmanReconShippedSoTrgRepExport?fromDate='+this.datePipe.transform(fromDate,'yyyyMMdd')+'&toDate='+this.datePipe.transform(toDate,'yyyyMMdd')+'&legalEntity='+legalEntity;
        if(exportCols!=undefined && exportCols!=""){
            serviceUrl=serviceUrl+'&exportCols='+exportCols;
        }
           return serviceUrl;
    }
    

}
