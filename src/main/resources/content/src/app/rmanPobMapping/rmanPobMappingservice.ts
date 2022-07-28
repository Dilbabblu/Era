import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
declare var require:any;
const appSettings = require('../appsettings');


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
  })
};



@Injectable()
export class RmanPobMappingService {

    constructor(private http: HttpClient) {}
    
    getServiceUrl(paginationOptions:any,rmanPobMappingSearchObject:any, exportCols: any, exportFlag?: any) {
        let serviceUrl = appSettings.apiUrl + '/rmanPobMappingExport?';

        if (exportFlag == 0) {
            serviceUrl = appSettings.apiUrl + '/rmanPobMappingSearch?';
        }
        
        let searchString='';

        if (rmanPobMappingSearchObject.pobMapId!=undefined && rmanPobMappingSearchObject.pobMapId!="") {
            searchString=searchString+'pobMapId:'+rmanPobMappingSearchObject.pobMapId+',';
        }

        if (rmanPobMappingSearchObject.skuType!=undefined && rmanPobMappingSearchObject.skuType!="") {
            searchString=searchString+'skuType:'+rmanPobMappingSearchObject.skuType+',';
        }

        if (rmanPobMappingSearchObject.standaloneSubSku!=undefined && rmanPobMappingSearchObject.standaloneSubSku!="") {
            searchString=searchString+'standaloneSubSku:'+rmanPobMappingSearchObject.standaloneSubSku+',';
        }

        if (rmanPobMappingSearchObject.pobGrouping!=undefined && rmanPobMappingSearchObject.pobGrouping!="") {
            searchString=searchString+'pobGrouping:'+rmanPobMappingSearchObject.pobGrouping+',';
        }

        if (rmanPobMappingSearchObject.splitBasis!=undefined && rmanPobMappingSearchObject.splitBasis!="") {
            searchString=searchString+'splitBasis:'+rmanPobMappingSearchObject.splitBasis+',';
        }

        if (rmanPobMappingSearchObject.split!=undefined && rmanPobMappingSearchObject.split!="") {
            searchString=searchString+'split:'+rmanPobMappingSearchObject.split+',';
        }

        if (rmanPobMappingSearchObject.parentSku!=undefined && rmanPobMappingSearchObject.parentSku!="") {
            searchString=searchString+'parentSku:'+rmanPobMappingSearchObject.parentSku+',';
        }

        if (rmanPobMappingSearchObject.startDate!=undefined && rmanPobMappingSearchObject.startDate!="") {
            searchString=searchString+'startDate:'+rmanPobMappingSearchObject.startDate+',';
        }

        if (rmanPobMappingSearchObject.endDate!=undefined && rmanPobMappingSearchObject.endDate!="") {
            searchString=searchString+'endDate:'+rmanPobMappingSearchObject.endDate+',';
        }

        if (rmanPobMappingSearchObject.status!=undefined && rmanPobMappingSearchObject.status!="") {
            searchString=searchString+'status:'+rmanPobMappingSearchObject.status+',';
        }

        if (rmanPobMappingSearchObject.attribute1!=undefined && rmanPobMappingSearchObject.attribute1!="") {
            searchString=searchString+'attribute1:'+rmanPobMappingSearchObject.attribute1+',';
        }

        if (rmanPobMappingSearchObject.attribute2!=undefined && rmanPobMappingSearchObject.attribute2!="") {
            searchString=searchString+'attribute2:'+rmanPobMappingSearchObject.attribute2+',';
        }

        if (rmanPobMappingSearchObject.attribute3!=undefined && rmanPobMappingSearchObject.attribute3!="") {
            searchString=searchString+'attribute3:'+rmanPobMappingSearchObject.attribute3+',';
        }

        if (rmanPobMappingSearchObject.attribute4!=undefined && rmanPobMappingSearchObject.attribute4!="") {
            searchString=searchString+'attribute4:'+rmanPobMappingSearchObject.attribute4+',';
        }

        if (rmanPobMappingSearchObject.attribute5!=undefined && rmanPobMappingSearchObject.attribute5!="") {
            searchString=searchString+'attribute5:'+rmanPobMappingSearchObject.attribute5;
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

        if(exportCols !=undefined && exportCols!=null){
            serviceUrl = serviceUrl+'&exportCols='+exportCols;
        }
                
       return serviceUrl;
    }

    getAllRmanPobMapping(paginationOptions:any,rmanPobMappingSearchObject:any, exportCols: any): Promise<any[]> {
        let serviceUrl = this.getServiceUrl(paginationOptions, rmanPobMappingSearchObject,exportCols, 0);
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }
	
    
    saveRmanPobMapping(rmanPobMapping:any): Promise<any[]> {
        let body = JSON.stringify(rmanPobMapping);
        return this.http.post<any[]>(appSettings.apiUrl+'/RMAN_POB_MAPPING',body,httpOptions).toPromise().then(data => {
            return data;
        });
    }
    
    updateRmanPobMapping(rmanPobMapping:any): Promise<any[]> {
        
        delete rmanPobMapping._links;
        delete rmanPobMapping.interests;
        let body = JSON.stringify(rmanPobMapping);
        return this.http.put<any[]>(appSettings.apiUrl+'/RMAN_POB_MAPPING/'+rmanPobMapping.pobMapId,body,httpOptions).toPromise().then(data => {
            return data;
        });
        
    }
    
    deleteRmanPobMapping(rmanPobMapping:any): Promise<any[]> {
        let deleteUrl=appSettings.apiUrl+'/RMAN_POB_MAPPING/'+rmanPobMapping.pobMapId;
        return this.http.delete(deleteUrl,httpOptions).toPromise().then((data:any) => {
            return data;
        });
    }

}
