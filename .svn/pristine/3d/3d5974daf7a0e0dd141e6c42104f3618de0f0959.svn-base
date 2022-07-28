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
export class RmanArrgLineOfBusinessVService {

    constructor(private http: HttpClient) {}
    
    getAllRmanArrgLineOfBusinessV(paginationOptions:any,rmanArrgLineOfBusinessVSearchObject:any): Promise<any[]> {
        let serviceUrl=appSettings.apiUrl+'/rmanArrgLineOfBusinessVSearch?';
        
        let searchString='';

        if (rmanArrgLineOfBusinessVSearchObject.sno!=undefined && rmanArrgLineOfBusinessVSearchObject.sno!="") {
            searchString=searchString+'sno:'+rmanArrgLineOfBusinessVSearchObject.sno+',';
        }

        if (rmanArrgLineOfBusinessVSearchObject.dealArrangementId!=undefined && rmanArrgLineOfBusinessVSearchObject.dealArrangementId!="") {
            searchString=searchString+'dealArrangementId:'+rmanArrgLineOfBusinessVSearchObject.dealArrangementId+',';
        }

        if (rmanArrgLineOfBusinessVSearchObject.lineOfBusinessName!=undefined && rmanArrgLineOfBusinessVSearchObject.lineOfBusinessName!="") {
            searchString=searchString+'lineOfBusinessName:'+rmanArrgLineOfBusinessVSearchObject.lineOfBusinessName+',';
        }

        if (rmanArrgLineOfBusinessVSearchObject.lineOfBusiness!=undefined && rmanArrgLineOfBusinessVSearchObject.lineOfBusiness!="") {
            searchString=searchString+'lineOfBusiness:'+rmanArrgLineOfBusinessVSearchObject.lineOfBusiness+',';
        }

        if (rmanArrgLineOfBusinessVSearchObject.amount!=undefined && rmanArrgLineOfBusinessVSearchObject.amount!="") {
            searchString=searchString+'amount:'+rmanArrgLineOfBusinessVSearchObject.amount;
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
    

    
    saveRmanArrgLineOfBusinessV(rmanArrgLineOfBusinessV:any): Promise<any[]> {
        let body = JSON.stringify(rmanArrgLineOfBusinessV);
        return this.http.post<any[]>(appSettings.apiUrl+'/RMAN_ARRG_LINE_OF_BUSINESS_V',body,httpOptions).toPromise().then(data => {
            return data;
        });
    }
    
    updateRmanArrgLineOfBusinessV(rmanArrgLineOfBusinessV:any): Promise<any[]> {
        
        delete rmanArrgLineOfBusinessV._links;
        delete rmanArrgLineOfBusinessV.interests;
        let body = JSON.stringify(rmanArrgLineOfBusinessV);
        return this.http.put<any[]>(appSettings.apiUrl+'/RMAN_ARRG_LINE_OF_BUSINESS_V/'+rmanArrgLineOfBusinessV.dealArrangementId,body,httpOptions).toPromise().then(data => {
            return data;
        });
        
    }
    
    deleteRmanArrgLineOfBusinessV(rmanArrgLineOfBusinessV:any): Promise<any[]> {
        let deleteUrl=appSettings.apiUrl+'/RMAN_ARRG_LINE_OF_BUSINESS_V/'+rmanArrgLineOfBusinessV.dealArrangementId;
        return this.http.delete(deleteUrl,httpOptions).toPromise().then((data:any) => {
            return data;
        });
    }

}
