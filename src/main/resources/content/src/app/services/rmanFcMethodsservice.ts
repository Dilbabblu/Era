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
export class RmanFcMethodsService {

    constructor(private http: HttpClient) {}
    
    getAllRmanFcMethods(paginationOptions:any,rmanFcMethodsSearchObject:any): Promise<any[]> {
        let serviceUrl=appSettings.apiUrl+'/rmanFcMethodsSearch?';
        
        let searchString='';

        if (rmanFcMethodsSearchObject.fcMethodId!=undefined && rmanFcMethodsSearchObject.fcMethodId!="") {
            searchString=searchString+'fcMethodId:'+rmanFcMethodsSearchObject.fcMethodId+',';
        }

        if (rmanFcMethodsSearchObject.name!=undefined && rmanFcMethodsSearchObject.name!="") {
            searchString=searchString+'name:'+rmanFcMethodsSearchObject.name+',';
        }

        if (rmanFcMethodsSearchObject.version!=undefined && rmanFcMethodsSearchObject.version!="") {
            searchString=searchString+'version:'+rmanFcMethodsSearchObject.version+',';
        }

        if (rmanFcMethodsSearchObject.description!=undefined && rmanFcMethodsSearchObject.description!="") {
            searchString=searchString+'description:'+rmanFcMethodsSearchObject.description+',';
        }

        if (rmanFcMethodsSearchObject.startDate!=undefined && rmanFcMethodsSearchObject.startDate!="") {
            searchString=searchString+'startDate:'+rmanFcMethodsSearchObject.startDate+',';
        }

        if (rmanFcMethodsSearchObject.endDate!=undefined && rmanFcMethodsSearchObject.endDate!="") {
            searchString=searchString+'endDate:'+rmanFcMethodsSearchObject.endDate+',';
        }

        if (rmanFcMethodsSearchObject.createdDate!=undefined && rmanFcMethodsSearchObject.createdDate!="") {
            searchString=searchString+'createdDate:'+rmanFcMethodsSearchObject.createdDate+',';
        }

        if (rmanFcMethodsSearchObject.createdBy!=undefined && rmanFcMethodsSearchObject.createdBy!="") {
            searchString=searchString+'createdBy:'+rmanFcMethodsSearchObject.createdBy+',';
        }

        if (rmanFcMethodsSearchObject.lastUpdatedDate!=undefined && rmanFcMethodsSearchObject.lastUpdatedDate!="") {
            searchString=searchString+'lastUpdatedDate:'+rmanFcMethodsSearchObject.lastUpdatedDate+',';
        }

        if (rmanFcMethodsSearchObject.lastUpdatedBy!=undefined && rmanFcMethodsSearchObject.lastUpdatedBy!="") {
            searchString=searchString+'lastUpdatedBy:'+rmanFcMethodsSearchObject.lastUpdatedBy;
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
    
    
    saveRmanFcMethods(rmanFcMethods:any): Promise<any[]> {
        let body = JSON.stringify(rmanFcMethods);
        return this.http.post<any[]>(appSettings.apiUrl+'/RMAN_FC_METHODS',body,httpOptions).toPromise().then(data => {
            return data;
        });
    }
    
    updateRmanFcMethods(rmanFcMethods:any): Promise<any[]> {
        
        delete rmanFcMethods._links;
        delete rmanFcMethods.interests;
        let body = JSON.stringify(rmanFcMethods);
        return this.http.put<any[]>(appSettings.apiUrl+'/RMAN_FC_METHODS/'+rmanFcMethods.fcMethodId,body,httpOptions).toPromise().then(data => {
            return data;
        });
        
    }
    
    deleteRmanFcMethods(rmanFcMethods:any): Promise<any[]> {
        let deleteUrl=appSettings.apiUrl+'/RMAN_FC_METHODS/'+rmanFcMethods.fcMethodId;
        return this.http.delete(deleteUrl,httpOptions).toPromise().then((data:any) => {
            return data;
        });
    }

}
