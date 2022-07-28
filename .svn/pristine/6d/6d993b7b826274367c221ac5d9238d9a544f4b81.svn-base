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
export class RmanFcLevelService {

    constructor(private http: HttpClient) {}
    
    getAllRmanFcLevel(paginationOptions:any,rmanFcLevelSearchObject:any): Promise<any[]> {
        let serviceUrl=appSettings.apiUrl+'/rmanFcLevelSearch?';
        
        let searchString='';

        if (rmanFcLevelSearchObject.levelId!=undefined && rmanFcLevelSearchObject.levelId!="") {
            searchString=searchString+'levelId:'+rmanFcLevelSearchObject.levelId+',';
        }

        if (rmanFcLevelSearchObject.name!=undefined && rmanFcLevelSearchObject.name!="") {
            searchString=searchString+'name:'+rmanFcLevelSearchObject.name+',';
        }

        if (rmanFcLevelSearchObject.startDate!=undefined && rmanFcLevelSearchObject.startDate!="") {
            searchString=searchString+'startDate:'+rmanFcLevelSearchObject.startDate+',';
        }

        if (rmanFcLevelSearchObject.endDate!=undefined && rmanFcLevelSearchObject.endDate!="") {
            searchString=searchString+'endDate:'+rmanFcLevelSearchObject.endDate+',';
        }

        if (rmanFcLevelSearchObject.createdDate!=undefined && rmanFcLevelSearchObject.createdDate!="") {
            searchString=searchString+'createdDate:'+rmanFcLevelSearchObject.createdDate+',';
        }

        if (rmanFcLevelSearchObject.createdBy!=undefined && rmanFcLevelSearchObject.createdBy!="") {
            searchString=searchString+'createdBy:'+rmanFcLevelSearchObject.createdBy+',';
        }

        if (rmanFcLevelSearchObject.lastUpdatedDate!=undefined && rmanFcLevelSearchObject.lastUpdatedDate!="") {
            searchString=searchString+'lastUpdatedDate:'+rmanFcLevelSearchObject.lastUpdatedDate+',';
        }

        if (rmanFcLevelSearchObject.lastUpdatedBy!=undefined && rmanFcLevelSearchObject.lastUpdatedBy!="") {
            searchString=searchString+'lastUpdatedBy:'+rmanFcLevelSearchObject.lastUpdatedBy;
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
    
    
    saveRmanFcLevel(rmanFcLevel:any): Promise<any[]> {
        let body = JSON.stringify(rmanFcLevel);
        return this.http.post<any[]>(appSettings.apiUrl+'/RMAN_FC_LEVEL',body,httpOptions).toPromise().then(data => {
            return data;
        });
    }
    
    updateRmanFcLevel(rmanFcLevel:any): Promise<any[]> {
        
        delete rmanFcLevel._links;
        delete rmanFcLevel.interests;
        let body = JSON.stringify(rmanFcLevel);
        return this.http.put(appSettings.apiUrl+'/RMAN_FC_LEVEL/'+rmanFcLevel.levelId,body,httpOptions).toPromise().then((data:any) => {
            return data;
        });
        
    }
    
    deleteRmanFcLevel(rmanFcLevel:any): Promise<any[]> {
        let deleteUrl=appSettings.apiUrl+'/RMAN_FC_LEVEL/'+rmanFcLevel.levelId;
        return this.http.delete(deleteUrl,httpOptions).toPromise().then((data:any) => {
            return data;
        });
    }

}
