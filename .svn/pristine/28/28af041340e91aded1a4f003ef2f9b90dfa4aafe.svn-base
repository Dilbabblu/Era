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
export class RmanContHeaderVService {

    constructor(private http: HttpClient) {}
    
    getAllRmanContHeaderV(paginationOptions:any,rmanContHeaderVSearchObject:any): Promise<any[]> {
        let serviceUrl=appSettings.apiUrl+'/rmanContHeaderVSearch?';
        
        let searchString='';

        if (rmanContHeaderVSearchObject.ruleHeaderId!=undefined && rmanContHeaderVSearchObject.ruleHeaderId!="") {
            searchString=searchString+'ruleHeaderId:'+rmanContHeaderVSearchObject.ruleHeaderId+',';
        }

        if (rmanContHeaderVSearchObject.ruleName!=undefined && rmanContHeaderVSearchObject.ruleName!="") {
            searchString=searchString+'ruleName:'+rmanContHeaderVSearchObject.ruleName+',';
        }

        if (rmanContHeaderVSearchObject.description!=undefined && rmanContHeaderVSearchObject.description!="") {
            searchString=searchString+'description:'+rmanContHeaderVSearchObject.description+',';
        }

        if (rmanContHeaderVSearchObject.ruleCategory!=undefined && rmanContHeaderVSearchObject.ruleCategory!="") {
            searchString=searchString+'ruleCategory:'+rmanContHeaderVSearchObject.ruleCategory+',';
        }

        if (rmanContHeaderVSearchObject.ruleApplyLevel!=undefined && rmanContHeaderVSearchObject.ruleApplyLevel!="") {
            searchString=searchString+'ruleApplyLevel:'+rmanContHeaderVSearchObject.ruleApplyLevel+',';
        }

        if (rmanContHeaderVSearchObject.comments!=undefined && rmanContHeaderVSearchObject.comments!="") {
            searchString=searchString+'comments:'+rmanContHeaderVSearchObject.comments+',';
        }

        if (rmanContHeaderVSearchObject.ruleStartDate!=undefined && rmanContHeaderVSearchObject.ruleStartDate!="") {
            searchString=searchString+'ruleStartDate:'+rmanContHeaderVSearchObject.ruleStartDate+',';
        }

        if (rmanContHeaderVSearchObject.ruleEndDate!=undefined && rmanContHeaderVSearchObject.ruleEndDate!="") {
            searchString=searchString+'ruleEndDate:'+rmanContHeaderVSearchObject.ruleEndDate+',';
        }

        if (rmanContHeaderVSearchObject.ranking!=undefined && rmanContHeaderVSearchObject.ranking!="") {
            searchString=searchString+'ranking:'+rmanContHeaderVSearchObject.ranking+',';
        }

        if (rmanContHeaderVSearchObject.revFlag!=undefined && rmanContHeaderVSearchObject.revFlag!="") {
            searchString=searchString+'revFlag:'+rmanContHeaderVSearchObject.revFlag+',';
        }

        if (rmanContHeaderVSearchObject.cogsFlag!=undefined && rmanContHeaderVSearchObject.cogsFlag!="") {
            searchString=searchString+'cogsFlag:'+rmanContHeaderVSearchObject.cogsFlag+',';
        }

        if (rmanContHeaderVSearchObject.creationDate!=undefined && rmanContHeaderVSearchObject.creationDate!="") {
            searchString=searchString+'creationDate:'+rmanContHeaderVSearchObject.creationDate+',';
        }

        if (rmanContHeaderVSearchObject.createdBy!=undefined && rmanContHeaderVSearchObject.createdBy!="") {
            searchString=searchString+'createdBy:'+rmanContHeaderVSearchObject.createdBy+',';
        }

        if (rmanContHeaderVSearchObject.lastUpdateDate!=undefined && rmanContHeaderVSearchObject.lastUpdateDate!="") {
            searchString=searchString+'lastUpdateDate:'+rmanContHeaderVSearchObject.lastUpdateDate+',';
        }

        if (rmanContHeaderVSearchObject.lastUpdatedBy!=undefined && rmanContHeaderVSearchObject.lastUpdatedBy!="") {
            searchString=searchString+'lastUpdatedBy:'+rmanContHeaderVSearchObject.lastUpdatedBy;
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
    
    
    saveRmanContHeaderV(rmanContHeaderV:any): Promise<any[]> {
        let body = JSON.stringify(rmanContHeaderV);
        return this.http.post<any[]>(appSettings.apiUrl+'/RMAN_CONT_HEADER_V',body,httpOptions).toPromise().then(data => {
            return data;
        });
    }
    
    updateRmanContHeaderV(rmanContHeaderV:any): Promise<any[]> {
        
        delete rmanContHeaderV._links;
        delete rmanContHeaderV.interests;
        let body = JSON.stringify(rmanContHeaderV);
        return this.http.put<any[]>(appSettings.apiUrl+'/RMAN_CONT_HEADER_V/'+rmanContHeaderV.ruleHeaderId,body,httpOptions).toPromise().then(data => {
            return data;
        });
        
    }
    
    deleteRmanContHeaderV(rmanContHeaderV:any): Promise<any[]> {
        let deleteUrl=appSettings.apiUrl+'/RMAN_CONT_HEADER_V/'+rmanContHeaderV.ruleHeaderId;
        return this.http.delete(deleteUrl,httpOptions).toPromise().then((data:any) => {
            return data;
        });
    }

}
