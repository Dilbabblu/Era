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
export class RmanMasterArrangementsVService {

    constructor(private http: HttpClient) {}
    
    getAllRmanMasterArrangementsV(paginationOptions:any,rmanMasterArrangementsVSearchObject:any): Promise<any[]> {
        let serviceUrl=appSettings.apiUrl+'/rmanMasterArrangementsVSearch?';
        
        let searchString='';

        if (rmanMasterArrangementsVSearchObject.masterarrgname!=undefined && rmanMasterArrangementsVSearchObject.masterarrgname!="") {
            searchString=searchString+'masterarrgname:'+rmanMasterArrangementsVSearchObject.masterarrgname+',';
        }

        if (rmanMasterArrangementsVSearchObject.masterarrgid!=undefined && rmanMasterArrangementsVSearchObject.masterarrgid!="") {
            searchString=searchString+'masterarrgid:'+rmanMasterArrangementsVSearchObject.masterarrgid;
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
    
    
    saveRmanMasterArrangementsV(rmanMasterArrangementsV:any): Promise<any[]> {
        let body = JSON.stringify(rmanMasterArrangementsV);
        return this.http.post<any[]>(appSettings.apiUrl+'/RMAN_MASTER_ARRANGEMENTS_V',body,httpOptions).toPromise().then(data => {
            return data;
        });
    }
    
    updateRmanMasterArrangementsV(rmanMasterArrangementsV:any): Promise<any[]> {
        
        delete rmanMasterArrangementsV._links;
        delete rmanMasterArrangementsV.interests;
        let body = JSON.stringify(rmanMasterArrangementsV);
        return this.http.put<any[]>(appSettings.apiUrl+'/RMAN_MASTER_ARRANGEMENTS_V/'+rmanMasterArrangementsV.masterarrgid,body,httpOptions).toPromise().then(data => {
            return data;
        });
        
    }
    
    deleteRmanMasterArrangementsV(rmanMasterArrangementsV:any): Promise<any[]> {
        let deleteUrl=appSettings.apiUrl+'/RMAN_MASTER_ARRANGEMENTS_V/'+rmanMasterArrangementsV.masterarrgid;
        return this.http.delete(deleteUrl,httpOptions).toPromise().then((data:any) => {
            return data;
        });
    }

}
