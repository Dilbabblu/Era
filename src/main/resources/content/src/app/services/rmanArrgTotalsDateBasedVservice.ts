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
export class RmanArrgTotalsDateBasedVService {

    constructor(private http: HttpClient) {}
    
    getAllRmanArrgTotalsDateBasedV(paginationOptions:any,rmanArrgTotalsDateBasedVSearchObject:any): Promise<any[]> {
        let serviceUrl=appSettings.apiUrl+'/rmanArrgTotalsDateBasedVSearch?';
        
        let searchString='';

        if (rmanArrgTotalsDateBasedVSearchObject.dealArrangementId!=undefined && rmanArrgTotalsDateBasedVSearchObject.dealArrangementId!="") {
            searchString=searchString+'dealArrangementId:'+rmanArrgTotalsDateBasedVSearchObject.dealArrangementId+',';
        }

        if (rmanArrgTotalsDateBasedVSearchObject.year!=undefined && rmanArrgTotalsDateBasedVSearchObject.year!="") {
            searchString=searchString+'year:'+rmanArrgTotalsDateBasedVSearchObject.year+',';
        }

        if (rmanArrgTotalsDateBasedVSearchObject.month!=undefined && rmanArrgTotalsDateBasedVSearchObject.month!="") {
            searchString=searchString+'month:'+rmanArrgTotalsDateBasedVSearchObject.month+',';
        }

        if (rmanArrgTotalsDateBasedVSearchObject.type!=undefined && rmanArrgTotalsDateBasedVSearchObject.type!="") {
            searchString=searchString+'type:'+rmanArrgTotalsDateBasedVSearchObject.type+',';
        }

        if (rmanArrgTotalsDateBasedVSearchObject.amount!=undefined && rmanArrgTotalsDateBasedVSearchObject.amount!="") {
            searchString=searchString+'amount:'+rmanArrgTotalsDateBasedVSearchObject.amount;
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
    
    
    saveRmanArrgTotalsDateBasedV(rmanArrgTotalsDateBasedV:any): Promise<any[]> {
        let body = JSON.stringify(rmanArrgTotalsDateBasedV);
        return this.http.post<any[]>(appSettings.apiUrl+'/RMAN_ARRG_TOTALS_DATE_BASED_V',body,httpOptions).toPromise().then(data => {
            return data;
        });
    }
    
    updateRmanArrgTotalsDateBasedV(rmanArrgTotalsDateBasedV:any): Promise<any[]> {
        
        delete rmanArrgTotalsDateBasedV._links;
        delete rmanArrgTotalsDateBasedV.interests;
        let body = JSON.stringify(rmanArrgTotalsDateBasedV);
        return this.http.put<any[]>(appSettings.apiUrl+'/RMAN_ARRG_TOTALS_DATE_BASED_V/'+rmanArrgTotalsDateBasedV.dealArrangementId,body,httpOptions).toPromise().then(data => {
            return data;
        });
        
    }
    
    deleteRmanArrgTotalsDateBasedV(rmanArrgTotalsDateBasedV:any): Promise<any[]> {
        let deleteUrl=appSettings.apiUrl+'/RMAN_ARRG_TOTALS_DATE_BASED_V/'+rmanArrgTotalsDateBasedV.dealArrangementId;
        return this.http.delete(deleteUrl,httpOptions).toPromise().then((data:any) => {
            return data;
        });
    }

}
