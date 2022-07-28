import { DatePipe } from '@angular/common';
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
export class RmanApprovalRulesService {
    
    constructor(private http: HttpClient,private datePipe: DatePipe) {}
    
    getServiceUrl(paginationOptions: any,rmanApprovalRulesSearchObj: any, exportCols: any, exportFlag?: any) {
        let serviceUrl = appSettings.apiUrl + '/ayaraApprovalRulesExport?';

        if (exportFlag == 0) {
            serviceUrl = appSettings.apiUrl + '/ayaraApprovalRulesSearch?';
        }
        
        let searchString='';

        if (rmanApprovalRulesSearchObj.ranking!=undefined && rmanApprovalRulesSearchObj.ranking!="") {
            searchString=searchString+'ranking:'+rmanApprovalRulesSearchObj.ranking+',';
        }

        if (rmanApprovalRulesSearchObj.entityId!=undefined && rmanApprovalRulesSearchObj.entityId!="") {
            searchString=searchString+'entityId:'+rmanApprovalRulesSearchObj.entityId+',';
        }

        if (rmanApprovalRulesSearchObj.userRole!=undefined && rmanApprovalRulesSearchObj.userRole!="") {
            searchString=searchString+'userRole:'+rmanApprovalRulesSearchObj.userRole+',';
        }

        if (rmanApprovalRulesSearchObj.approvalcriteria!=undefined && rmanApprovalRulesSearchObj.approvalcriteria!="") {
            searchString=searchString+'approvalcriteria:'+rmanApprovalRulesSearchObj.approvalcriteria+',';
        }

        if (rmanApprovalRulesSearchObj.minValue!=undefined && rmanApprovalRulesSearchObj.minValue!="") {
            searchString=searchString+'minValue:'+rmanApprovalRulesSearchObj.minValue+',';
        }

        if (rmanApprovalRulesSearchObj.maxValue!=undefined && rmanApprovalRulesSearchObj.maxValue!="") {
            searchString=searchString+'maxValue:'+rmanApprovalRulesSearchObj.maxValue+',';
        }

        if (rmanApprovalRulesSearchObj.assigneeType!=undefined && rmanApprovalRulesSearchObj.assigneeType!="") {
            searchString=searchString+'assigneeType:'+rmanApprovalRulesSearchObj.assigneeType+',';
        }

        if (rmanApprovalRulesSearchObj.geo!=undefined && rmanApprovalRulesSearchObj.geo!="") {
            searchString=searchString+'geo:'+rmanApprovalRulesSearchObj.geo+',';
        }

        if (rmanApprovalRulesSearchObj.activeFlag!=undefined && rmanApprovalRulesSearchObj.activeFlag!="") {
            searchString=searchString+'activeFlag:'+rmanApprovalRulesSearchObj.activeFlag+',';
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

    getAllRmanApprovalRules(paginationOptions: any,rmanApprovalRulesSearchObj: any, exportCols: any) {
        let serviceUrl = this.getServiceUrl(paginationOptions, rmanApprovalRulesSearchObj, exportCols, 0);
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }
    
    saveApprovalRule(rmanApprovalRule: any): Promise<any[]> {
        let body = JSON.stringify(rmanApprovalRule);
        return this.http.post<any[]>(appSettings.apiUrl + '/AYARA_APPROVAL_RULES', body, httpOptions).toPromise().then(data => {
          return data;
        });
      }
    
      updateApprovalRule(rmanApprovalRule: any): Promise<any[]> {
    
        delete rmanApprovalRule._links;
        delete rmanApprovalRule.interests;
        let body = JSON.stringify(rmanApprovalRule);
        return this.http.put<any[]>(appSettings.apiUrl + '/AYARA_APPROVAL_RULES/' + rmanApprovalRule.ruleId, body, httpOptions).toPromise().then(data => {
          return data;
        });
    
      }
    
      deleteApprovalRule(rmanApprovalRule: any): Promise<any[]> {
        let deleteUrl = appSettings.apiUrl + '/AYARA_APPROVAL_RULES/' + rmanApprovalRule.ruleId;
        return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
            return data;
        });
    }

}
