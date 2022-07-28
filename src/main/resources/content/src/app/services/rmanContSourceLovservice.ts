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
export class RmanContSourceLovService {

    constructor(private http: HttpClient) {}
    
    getAllRmanContSourceLov(paginationOptions:any,rmanContSourceLovSearchObject:any): Promise<any[]> {
        let serviceUrl=appSettings.apiUrl+'/rmanContSourceLovSearch?';
        
        let searchString='';

        if (rmanContSourceLovSearchObject.sno!=undefined && rmanContSourceLovSearchObject.sno!="") {
            searchString=searchString+'sno:'+rmanContSourceLovSearchObject.sno+',';
        }

        if (rmanContSourceLovSearchObject.dealArrangementId!=undefined && rmanContSourceLovSearchObject.dealArrangementId!="") {
            searchString=searchString+'dealArrangementId:'+rmanContSourceLovSearchObject.dealArrangementId+',';
        }

        if (rmanContSourceLovSearchObject.sourceHeaderId!=undefined && rmanContSourceLovSearchObject.sourceHeaderId!="") {
            searchString=searchString+'sourceHeaderId:'+rmanContSourceLovSearchObject.sourceHeaderId+',';
        }

        if (rmanContSourceLovSearchObject.sourceName!=undefined && rmanContSourceLovSearchObject.sourceName!="") {
            searchString=searchString+'sourceName:'+rmanContSourceLovSearchObject.sourceName+',';
        }

        if (rmanContSourceLovSearchObject.sourceLineId!=undefined && rmanContSourceLovSearchObject.sourceLineId!="") {
            searchString=searchString+'sourceLineId:'+rmanContSourceLovSearchObject.sourceLineId+',';
        }

        if (rmanContSourceLovSearchObject.sourceLine!=undefined && rmanContSourceLovSearchObject.sourceLine!="") {
            searchString=searchString+'sourceLine:'+rmanContSourceLovSearchObject.sourceLine+',';
        }

        if (rmanContSourceLovSearchObject.applicationLevel!=undefined && rmanContSourceLovSearchObject.applicationLevel!="") {
            searchString=searchString+'applicationLevel:'+rmanContSourceLovSearchObject.applicationLevel+',';
        }

        if (rmanContSourceLovSearchObject.prePostBooking!=undefined && rmanContSourceLovSearchObject.prePostBooking!="") {
            searchString=searchString+'prePostBooking:'+rmanContSourceLovSearchObject.prePostBooking;
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
    
    saveRmanContSourceLov(rmanContSourceLov:any): Promise<any[]> {
        let body = JSON.stringify(rmanContSourceLov);
        return this.http.post<any[]>(appSettings.apiUrl+'/RMAN_CONT_SOURCE_LOV',body,httpOptions).toPromise().then(data => {
            return data;
        });
    }
    
    updateRmanContSourceLov(rmanContSourceLov:any): Promise<any[]> {
        
        delete rmanContSourceLov._links;
        delete rmanContSourceLov.interests;
        let body = JSON.stringify(rmanContSourceLov);
        return this.http.put<any[]>(appSettings.apiUrl+'/RMAN_CONT_SOURCE_LOV/'+rmanContSourceLov.sourceHeaderId,body,httpOptions).toPromise().then(data => {
            return data;
        });
        
    }
    
    deleteRmanContSourceLov(rmanContSourceLov:any): Promise<any[]> {
        let deleteUrl=appSettings.apiUrl+'/RMAN_CONT_SOURCE_LOV/'+rmanContSourceLov.sourceHeaderId;
        return this.http.delete(deleteUrl,httpOptions).toPromise().then((data:any) => {
            return data;
        });
    }

}
