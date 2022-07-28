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
export class RmanLookupCodesService {

    constructor(private http: HttpClient) {}
    
    getAllRmanLookupCodes(paginationOptions:any,rmanLookupCodesSearchObject:any): Promise<any[]> {
        let serviceUrl=appSettings.apiUrl+'/rmanLookupCodesSearch?';
        
        let searchString='';

        if (rmanLookupCodesSearchObject.lookupTypeCode!=undefined && rmanLookupCodesSearchObject.lookupTypeCode!="") {
            searchString=searchString+'lookupTypeCode:'+rmanLookupCodesSearchObject.lookupTypeCode+',';
        }

        if (rmanLookupCodesSearchObject.lookupCode!=undefined && rmanLookupCodesSearchObject.lookupCode!="") {
            searchString=searchString+'lookupCode:'+rmanLookupCodesSearchObject.lookupCode+',';
        }

        if (rmanLookupCodesSearchObject.description!=undefined && rmanLookupCodesSearchObject.description!="") {
            searchString=searchString+'description:'+rmanLookupCodesSearchObject.description+',';
        }

        if (rmanLookupCodesSearchObject.enabledFlag!=undefined && rmanLookupCodesSearchObject.enabledFlag!="") {
            searchString=searchString+'enabledFlag:'+rmanLookupCodesSearchObject.enabledFlag+',';
        }

        if (rmanLookupCodesSearchObject.startDateActive!=undefined && rmanLookupCodesSearchObject.startDateActive!="") {
            searchString=searchString+'startDateActive:'+rmanLookupCodesSearchObject.startDateActive+',';
        }

        if (rmanLookupCodesSearchObject.endDateActive!=undefined && rmanLookupCodesSearchObject.endDateActive!="") {
            searchString=searchString+'endDateActive:'+rmanLookupCodesSearchObject.endDateActive+',';
        }

        if (rmanLookupCodesSearchObject.attribute1!=undefined && rmanLookupCodesSearchObject.attribute1!="") {
            searchString=searchString+'attribute1:'+rmanLookupCodesSearchObject.attribute1+',';
        }

        if (rmanLookupCodesSearchObject.attribute2!=undefined && rmanLookupCodesSearchObject.attribute2!="") {
            searchString=searchString+'attribute2:'+rmanLookupCodesSearchObject.attribute2+',';
        }

        if (rmanLookupCodesSearchObject.attribute3!=undefined && rmanLookupCodesSearchObject.attribute3!="") {
            searchString=searchString+'attribute3:'+rmanLookupCodesSearchObject.attribute3+',';
        }

        if (rmanLookupCodesSearchObject.attribute4!=undefined && rmanLookupCodesSearchObject.attribute4!="") {
            searchString=searchString+'attribute4:'+rmanLookupCodesSearchObject.attribute4+',';
        }

        if (rmanLookupCodesSearchObject.attribute5!=undefined && rmanLookupCodesSearchObject.attribute5!="") {
            searchString=searchString+'attribute5:'+rmanLookupCodesSearchObject.attribute5+',';
        }

        if (rmanLookupCodesSearchObject.creationDate!=undefined && rmanLookupCodesSearchObject.creationDate!="") {
            searchString=searchString+'creationDate:'+rmanLookupCodesSearchObject.creationDate+',';
        }

        if (rmanLookupCodesSearchObject.createdBy!=undefined && rmanLookupCodesSearchObject.createdBy!="") {
            searchString=searchString+'createdBy:'+rmanLookupCodesSearchObject.createdBy+',';
        }

        if (rmanLookupCodesSearchObject.lastUpdateDate!=undefined && rmanLookupCodesSearchObject.lastUpdateDate!="") {
            searchString=searchString+'lastUpdateDate:'+rmanLookupCodesSearchObject.lastUpdateDate+',';
        }

        if (rmanLookupCodesSearchObject.lastUpdatedBy!=undefined && rmanLookupCodesSearchObject.lastUpdatedBy!="") {
            searchString=searchString+'lastUpdatedBy:'+rmanLookupCodesSearchObject.lastUpdatedBy+',';
        }

        if (rmanLookupCodesSearchObject.seededFlag!=undefined && rmanLookupCodesSearchObject.seededFlag!="") {
            searchString=searchString+'seededFlag:'+rmanLookupCodesSearchObject.seededFlag;
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
                
        return this.http.get(serviceUrl).toPromise().then((data:any) => {
            return data;
        });
    }
    
    
    saveRmanLookupCodes(rmanLookupCodes:any): Promise<any[]> {
        let body = JSON.stringify(rmanLookupCodes);
        return this.http.post<any[]>(appSettings.apiUrl+'/RMAN_LOOKUP_CODES',body,httpOptions).toPromise().then(data => {
            return data;
        });
    }
    
    updateRmanLookupCodes(rmanLookupCodes:any): Promise<any[]> {
        
        delete rmanLookupCodes._links;
        delete rmanLookupCodes.interests;
        let body = JSON.stringify(rmanLookupCodes);
        return this.http.put<any[]>(appSettings.apiUrl+'/RMAN_LOOKUP_CODES/'+rmanLookupCodes.lookupId,body,httpOptions).toPromise().then(data => {
            return data;
        });
    }
    
    deleteRmanLookupCodes(rmanLookupCodes:any): Promise<any[]> {
        let deleteUrl=appSettings.apiUrl+'/RMAN_LOOKUP_CODES/'+rmanLookupCodes.lookupId;
        return this.http.delete(deleteUrl,httpOptions).toPromise().then((data:any) => {
            return data;
        });
    }

}
