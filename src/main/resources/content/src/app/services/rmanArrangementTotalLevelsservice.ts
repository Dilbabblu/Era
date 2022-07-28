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
export class RmanArrangementTotalLevelsService {

    constructor(private http: HttpClient) {}
    
    getAllRmanArrangementTotalLevels(paginationOptions:any,rmanArrangementTotalLevelsSearchObject:any): Promise<any[]> {
        let serviceUrl=appSettings.apiUrl+'/rmanArrangementTotalLevelsSearch?';
        
        let searchString='';

        if (rmanArrangementTotalLevelsSearchObject.dealArrangementId!=undefined && rmanArrangementTotalLevelsSearchObject.dealArrangementId!="") {
            searchString=searchString+'dealArrangementId:'+rmanArrangementTotalLevelsSearchObject.dealArrangementId+',';
        }

        if (rmanArrangementTotalLevelsSearchObject.arrangementamount!=undefined && rmanArrangementTotalLevelsSearchObject.arrangementamount!="") {
            searchString=searchString+'arrangementamount:'+rmanArrangementTotalLevelsSearchObject.arrangementamount+',';
        }

        if (rmanArrangementTotalLevelsSearchObject.bookingsamount!=undefined && rmanArrangementTotalLevelsSearchObject.bookingsamount!="") {
            searchString=searchString+'bookingsamount:'+rmanArrangementTotalLevelsSearchObject.bookingsamount+',';
        }

        if (rmanArrangementTotalLevelsSearchObject.shippedamount!=undefined && rmanArrangementTotalLevelsSearchObject.shippedamount!="") {
            searchString=searchString+'shippedamount:'+rmanArrangementTotalLevelsSearchObject.shippedamount+',';
        }

        if (rmanArrangementTotalLevelsSearchObject.billedamount!=undefined && rmanArrangementTotalLevelsSearchObject.billedamount!="") {
            searchString=searchString+'billedamount:'+rmanArrangementTotalLevelsSearchObject.billedamount+',';
        }

        if (rmanArrangementTotalLevelsSearchObject.revrecognizeamount!=undefined && rmanArrangementTotalLevelsSearchObject.revrecognizeamount!="") {
            searchString=searchString+'revrecognizeamount:'+rmanArrangementTotalLevelsSearchObject.revrecognizeamount+',';
        }

        if (rmanArrangementTotalLevelsSearchObject.revdeffered!=undefined && rmanArrangementTotalLevelsSearchObject.revdeffered!="") {
            searchString=searchString+'revdeffered:'+rmanArrangementTotalLevelsSearchObject.revdeffered+',';
        }

        if (rmanArrangementTotalLevelsSearchObject.cogsrev!=undefined && rmanArrangementTotalLevelsSearchObject.cogsrev!="") {
            searchString=searchString+'cogsrev:'+rmanArrangementTotalLevelsSearchObject.cogsrev+',';
        }

        if (rmanArrangementTotalLevelsSearchObject.grossmargin!=undefined && rmanArrangementTotalLevelsSearchObject.grossmargin!="") {
            searchString=searchString+'grossmargin:'+rmanArrangementTotalLevelsSearchObject.grossmargin;
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
    
    
    saveRmanArrangementTotalLevels(rmanArrangementTotalLevels:any): Promise<any[]> {
        let body = JSON.stringify(rmanArrangementTotalLevels);
        return this.http.post<any[]>(appSettings.apiUrl+'/RMAN_ARRANGEMENT_TOTAL_LEVELS',body,httpOptions).toPromise().then(data => {
            return data;
        });
    }
    
    updateRmanArrangementTotalLevels(rmanArrangementTotalLevels:any): Promise<any[]> {
        
        delete rmanArrangementTotalLevels._links;
        delete rmanArrangementTotalLevels.interests;
        let body = JSON.stringify(rmanArrangementTotalLevels);
        return this.http.put<any[]>(appSettings.apiUrl+'/RMAN_ARRANGEMENT_TOTAL_LEVELS/'+rmanArrangementTotalLevels.dealArrangementId,body,httpOptions).toPromise().then(data => {
            return data;
        });
        
    }
    
    deleteRmanArrangementTotalLevels(rmanArrangementTotalLevels:any): Promise<any[]> {
        let deleteUrl=appSettings.apiUrl+'/RMAN_ARRANGEMENT_TOTAL_LEVELS/'+rmanArrangementTotalLevels.dealArrangementId;
        return this.http.delete(deleteUrl,httpOptions).toPromise().then((data:any) => {
            return data;
        });
    }

}
