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
export class RmanRevenueTemplatesService {

    constructor(private http: HttpClient) {}

    getAllRmanRevenueTemplates(paginationOptions:any,rmanRevenueTemplatesSearchObject:any, fetchAll:any) {
        let serviceUrl=appSettings.apiUrl+'/rmanRevenueTemplatesSearch?';

        let searchString='';

        if (rmanRevenueTemplatesSearchObject.revenueTemplateId!=undefined && rmanRevenueTemplatesSearchObject.revenueTemplateId!="") {
            searchString=searchString+'revenueTemplateId:'+rmanRevenueTemplatesSearchObject.revenueTemplateId+',';
        }

        if (rmanRevenueTemplatesSearchObject.templateName!=undefined && rmanRevenueTemplatesSearchObject.templateName!="") {
            searchString=searchString+'templateName:'+rmanRevenueTemplatesSearchObject.templateName+',';
        }

        if (rmanRevenueTemplatesSearchObject.description!=undefined && rmanRevenueTemplatesSearchObject.description!="") {
            searchString=searchString+'description:'+rmanRevenueTemplatesSearchObject.description+',';
        }

        if (rmanRevenueTemplatesSearchObject.startDate!=undefined && rmanRevenueTemplatesSearchObject.startDate!="") {
            searchString=searchString+'startDate:'+rmanRevenueTemplatesSearchObject.startDate+',';
        }

        if (rmanRevenueTemplatesSearchObject.endDate!=undefined && rmanRevenueTemplatesSearchObject.endDate!="") {
            searchString=searchString+'endDate:'+rmanRevenueTemplatesSearchObject.endDate+',';
        }

        if (rmanRevenueTemplatesSearchObject.activeFlag!=undefined && rmanRevenueTemplatesSearchObject.activeFlag!="") {
            searchString=searchString+'activeFlag:'+rmanRevenueTemplatesSearchObject.activeFlag+',';
        }

        if (rmanRevenueTemplatesSearchObject.accTriggerRevenue!=undefined && rmanRevenueTemplatesSearchObject.accTriggerRevenue!="") {
            searchString=searchString+'accTriggerRevenue:'+rmanRevenueTemplatesSearchObject.accTriggerRevenue+',';
        }

        if (rmanRevenueTemplatesSearchObject.accTriggerCogs!=undefined && rmanRevenueTemplatesSearchObject.accTriggerCogs!="") {
            searchString=searchString+'accTriggerCogs:'+rmanRevenueTemplatesSearchObject.accTriggerCogs+',';
        }

        if (rmanRevenueTemplatesSearchObject.accRuleRevenue!=undefined && rmanRevenueTemplatesSearchObject.accRuleRevenue!="") {
            searchString=searchString+'accRuleRevenue:'+rmanRevenueTemplatesSearchObject.accRuleRevenue+',';
        }

        if (rmanRevenueTemplatesSearchObject.accRuleCogs!=undefined && rmanRevenueTemplatesSearchObject.accRuleCogs!="") {
            searchString=searchString+'accRuleCogs:'+rmanRevenueTemplatesSearchObject.accRuleCogs+',';
        }

        if (rmanRevenueTemplatesSearchObject.amortRuleRevenue!=undefined && rmanRevenueTemplatesSearchObject.amortRuleRevenue!="") {
            searchString=searchString+'amortRuleRevenue:'+rmanRevenueTemplatesSearchObject.amortRuleRevenue+',';
        }

        if (rmanRevenueTemplatesSearchObject.amortRuleCogs!=undefined && rmanRevenueTemplatesSearchObject.amortRuleCogs!="") {
            searchString=searchString+'amortRuleCogs:'+rmanRevenueTemplatesSearchObject.amortRuleCogs+',';
        }

        if (rmanRevenueTemplatesSearchObject.amortMethodRevenue!=undefined && rmanRevenueTemplatesSearchObject.amortMethodRevenue!="") {
            searchString=searchString+'amortMethodRevenue:'+rmanRevenueTemplatesSearchObject.amortMethodRevenue+',';
        }

        if (rmanRevenueTemplatesSearchObject.amortMethodCogs!=undefined && rmanRevenueTemplatesSearchObject.amortMethodCogs!="") {
            searchString=searchString+'amortMethodCogs:'+rmanRevenueTemplatesSearchObject.amortMethodCogs+',';
        }

        if (rmanRevenueTemplatesSearchObject.revAccount!=undefined && rmanRevenueTemplatesSearchObject.revAccount!="") {
            searchString=searchString+'revAccount:'+rmanRevenueTemplatesSearchObject.revAccount+',';
        }

        if (rmanRevenueTemplatesSearchObject.revSubaccount!=undefined && rmanRevenueTemplatesSearchObject.revSubaccount!="") {
            searchString=searchString+'revSubaccount:'+rmanRevenueTemplatesSearchObject.revSubaccount+',';
        }

        if (rmanRevenueTemplatesSearchObject.defRevAccount!=undefined && rmanRevenueTemplatesSearchObject.defRevAccount!="") {
            searchString=searchString+'defRevAccount:'+rmanRevenueTemplatesSearchObject.defRevAccount+',';
        }

        if (rmanRevenueTemplatesSearchObject.defRevSubaccount!=undefined && rmanRevenueTemplatesSearchObject.defRevSubaccount!="") {
            searchString=searchString+'defRevSubaccount:'+rmanRevenueTemplatesSearchObject.defRevSubaccount+',';
        }

        if (rmanRevenueTemplatesSearchObject.cogsAccount!=undefined && rmanRevenueTemplatesSearchObject.cogsAccount!="") {
            searchString=searchString+'cogsAccount:'+rmanRevenueTemplatesSearchObject.cogsAccount+',';
        }

        if (rmanRevenueTemplatesSearchObject.cogsSubaccount!=undefined && rmanRevenueTemplatesSearchObject.cogsSubaccount!="") {
            searchString=searchString+'cogsSubaccount:'+rmanRevenueTemplatesSearchObject.cogsSubaccount+',';
        }

        if (rmanRevenueTemplatesSearchObject.defCogsAccount!=undefined && rmanRevenueTemplatesSearchObject.defCogsAccount!="") {
            searchString=searchString+'defCogsAccount:'+rmanRevenueTemplatesSearchObject.defCogsAccount+',';
        }

        if (rmanRevenueTemplatesSearchObject.defCogsSubaccount!=undefined && rmanRevenueTemplatesSearchObject.defCogsSubaccount!="") {
            searchString=searchString+'defCogsSubaccount:'+rmanRevenueTemplatesSearchObject.defCogsSubaccount+',';
        }

        if (rmanRevenueTemplatesSearchObject.revReserveAccount!=undefined && rmanRevenueTemplatesSearchObject.revReserveAccount!="") {
            searchString=searchString+'revReserveAccount:'+rmanRevenueTemplatesSearchObject.revReserveAccount+',';
        }

        if (rmanRevenueTemplatesSearchObject.revenueReserveSubaccount!=undefined && rmanRevenueTemplatesSearchObject.revenueReserveSubaccount!="") {
            searchString=searchString+'revenueReserveSubaccount:'+rmanRevenueTemplatesSearchObject.revenueReserveSubaccount+',';
        }

        if (rmanRevenueTemplatesSearchObject.revAmortAccount!=undefined && rmanRevenueTemplatesSearchObject.revAmortAccount!="") {
            searchString=searchString+'revAmortAccount:'+rmanRevenueTemplatesSearchObject.revAmortAccount+',';
        }

        if (rmanRevenueTemplatesSearchObject.revAmortSubaccount!=undefined && rmanRevenueTemplatesSearchObject.revAmortSubaccount!="") {
            searchString=searchString+'revAmortSubaccount:'+rmanRevenueTemplatesSearchObject.revAmortSubaccount+',';
        }

        if (rmanRevenueTemplatesSearchObject.createdBy!=undefined && rmanRevenueTemplatesSearchObject.createdBy!="") {
            searchString=searchString+'createdBy:'+rmanRevenueTemplatesSearchObject.createdBy+',';
        }

        if (rmanRevenueTemplatesSearchObject.createdDate!=undefined && rmanRevenueTemplatesSearchObject.createdDate!="") {
            searchString=searchString+'createdDate:'+rmanRevenueTemplatesSearchObject.createdDate+',';
        }

        if (rmanRevenueTemplatesSearchObject.lastUpdatedBy!=undefined && rmanRevenueTemplatesSearchObject.lastUpdatedBy!="") {
            searchString=searchString+'lastUpdatedBy:'+rmanRevenueTemplatesSearchObject.lastUpdatedBy+',';
        }

        if (rmanRevenueTemplatesSearchObject.lastUpdatedDate!=undefined && rmanRevenueTemplatesSearchObject.lastUpdatedDate!="") {
            searchString=searchString+'lastUpdatedDate:'+rmanRevenueTemplatesSearchObject.lastUpdatedDate;
        }



        if (searchString == '') {
            serviceUrl=serviceUrl+'search=%25';
        }
        else {
            serviceUrl=serviceUrl+'search='+searchString;
        }

        if(fetchAll){
            serviceUrl = serviceUrl + "&fetchAll=true";
        }

        if (paginationOptions.pageNumber!=undefined && paginationOptions.pageNumber!="" && !isNaN(paginationOptions.pageNumber) && paginationOptions.pageNumber!=0) {
           serviceUrl=serviceUrl+'&page='+paginationOptions.pageNumber+'&size='+paginationOptions.pageSize;
        }

        return this.http.get(serviceUrl).toPromise().then(data => {
            return data;
        });
    }



    saveRmanRevenueTemplates(rmanRevenueTemplates :any) {
        let body = JSON.stringify(rmanRevenueTemplates);
        return this.http.post(appSettings.apiUrl+'/RMAN_REVENUE_TEMPLATES',body,httpOptions).toPromise().then(data => {
            return data;
        });
    }

    updateRmanRevenueTemplates(rmanRevenueTemplates :any) {

        delete rmanRevenueTemplates._links;
        delete rmanRevenueTemplates.interests;
        let body = JSON.stringify(rmanRevenueTemplates);
        return this.http.put(appSettings.apiUrl+'/RMAN_REVENUE_TEMPLATES/'+rmanRevenueTemplates.revenueTemplateId,body,httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanRevenueTemplates(rmanRevenueTemplates :any) {
        let deleteUrl=appSettings.apiUrl+'/RMAN_REVENUE_TEMPLATES/'+rmanRevenueTemplates.revenueTemplateId;
        return this.http.delete(deleteUrl,httpOptions).toPromise().then(data => {
            return data;
        });
    }


}
