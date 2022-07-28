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
export class RmanContLinkTemplateVService {

    constructor(private http: HttpClient) {}
    
    getAllRmanContLinkTemplateV(paginationOptions:any,rmanContLinkTemplateVSearchObject:any): Promise<any[]> {
        let serviceUrl=appSettings.apiUrl+'/rmanContLinkTemplateVSearch?';
        
        let searchString='';

        if (rmanContLinkTemplateVSearchObject.ruleHeaderId!=undefined && rmanContLinkTemplateVSearchObject.ruleHeaderId!="") {
            searchString=searchString+'ruleHeaderId:'+rmanContLinkTemplateVSearchObject.ruleHeaderId+',';
        }

        if (rmanContLinkTemplateVSearchObject.templateId!=undefined && rmanContLinkTemplateVSearchObject.templateId!="") {
            searchString=searchString+'templateId:'+rmanContLinkTemplateVSearchObject.templateId+',';
        }

        if (rmanContLinkTemplateVSearchObject.ranking!=undefined && rmanContLinkTemplateVSearchObject.ranking!="") {
            searchString=searchString+'ranking:'+rmanContLinkTemplateVSearchObject.ranking+',';
        }

        if (rmanContLinkTemplateVSearchObject.ruleName!=undefined && rmanContLinkTemplateVSearchObject.ruleName!="") {
            searchString=searchString+'ruleName:'+rmanContLinkTemplateVSearchObject.ruleName+',';
        }

        if (rmanContLinkTemplateVSearchObject.ruleCategory!=undefined && rmanContLinkTemplateVSearchObject.ruleCategory!="") {
            searchString=searchString+'ruleCategory:'+rmanContLinkTemplateVSearchObject.ruleCategory+',';
        }

        if (rmanContLinkTemplateVSearchObject.templateName!=undefined && rmanContLinkTemplateVSearchObject.templateName!="") {
            searchString=searchString+'templateName:'+rmanContLinkTemplateVSearchObject.templateName+',';
        }

        if (rmanContLinkTemplateVSearchObject.applyType!=undefined && rmanContLinkTemplateVSearchObject.applyType!="") {
            searchString=searchString+'applyType:'+rmanContLinkTemplateVSearchObject.applyType+',';
        }

        if (rmanContLinkTemplateVSearchObject.revenue!=undefined && rmanContLinkTemplateVSearchObject.revenue!="") {
            searchString=searchString+'revenue:'+rmanContLinkTemplateVSearchObject.revenue+',';
        }

        if (rmanContLinkTemplateVSearchObject.cogs!=undefined && rmanContLinkTemplateVSearchObject.cogs!="") {
            searchString=searchString+'cogs:'+rmanContLinkTemplateVSearchObject.cogs+',';
        }

        if (rmanContLinkTemplateVSearchObject.defaultDays!=undefined && rmanContLinkTemplateVSearchObject.defaultDays!="") {
            searchString=searchString+'defaultDays:'+rmanContLinkTemplateVSearchObject.defaultDays+',';
        }

        if (rmanContLinkTemplateVSearchObject.invoiceHold!=undefined && rmanContLinkTemplateVSearchObject.invoiceHold!="") {
            searchString=searchString+'invoiceHold:'+rmanContLinkTemplateVSearchObject.invoiceHold;
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
    
    
    saveRmanContLinkTemplateV(rmanContLinkTemplateV:any): Promise<any[]> {
        let body = JSON.stringify(rmanContLinkTemplateV);
        return this.http.post<any[]>(appSettings.apiUrl+'/RMAN_CONT_LINK_TEMPLATE_V',body,httpOptions).toPromise().then(data => {
            return data;
        });
    }
    
    updateRmanContLinkTemplateV(rmanContLinkTemplateV:any): Promise<any[]> {
        
        delete rmanContLinkTemplateV._links;
        delete rmanContLinkTemplateV.interests;
        let body = JSON.stringify(rmanContLinkTemplateV);
        return this.http.put<any[]>(appSettings.apiUrl+'/RMAN_CONT_LINK_TEMPLATE_V/'+rmanContLinkTemplateV.templateId,body,httpOptions).toPromise().then(data => {
            return data;
        });
        
    }
    
    deleteRmanContLinkTemplateV(rmanContLinkTemplateV:any): Promise<any[]> {
        let deleteUrl=appSettings.apiUrl+'/RMAN_CONT_LINK_TEMPLATE_V/'+rmanContLinkTemplateV.templateId;
        return this.http.delete(deleteUrl,httpOptions).toPromise().then((data:any) => {
            return data;
        });
    }

}
