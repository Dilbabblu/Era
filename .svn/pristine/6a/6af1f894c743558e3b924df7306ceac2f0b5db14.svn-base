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
export class RmanContTemplateService {

    constructor(private http: HttpClient) {}
    
    getAllRmanContTemplate(paginationOptions:any,rmanContTemplateSearchObject:any,fetchAll?:any): Promise<any[]> {
        let serviceUrl=appSettings.apiUrl+'/rmanContTemplateSearch?';
        
        let searchString='';

        if (rmanContTemplateSearchObject.templateId!=undefined && rmanContTemplateSearchObject.templateId!="") {
            searchString=searchString+'templateId:'+rmanContTemplateSearchObject.templateId+',';
        }

        if (rmanContTemplateSearchObject.templateName!=undefined && rmanContTemplateSearchObject.templateName!="") {
            searchString=searchString+'templateName:'+rmanContTemplateSearchObject.templateName+',';
        }

        if (rmanContTemplateSearchObject.description!=undefined && rmanContTemplateSearchObject.description!="") {
            searchString=searchString+'description:'+rmanContTemplateSearchObject.description+',';
        }

        if (rmanContTemplateSearchObject.applyType!=undefined && rmanContTemplateSearchObject.applyType!="") {
            searchString=searchString+'applyType:'+rmanContTemplateSearchObject.applyType+',';
        }

        if (rmanContTemplateSearchObject.revenue!=undefined && rmanContTemplateSearchObject.revenue!="") {
            searchString=searchString+'revenue:'+rmanContTemplateSearchObject.revenue+',';
        }

        if (rmanContTemplateSearchObject.cogs!=undefined && rmanContTemplateSearchObject.cogs!="") {
            searchString=searchString+'cogs:'+rmanContTemplateSearchObject.cogs+',';
        }

        if (rmanContTemplateSearchObject.effectiveStartDate!=undefined && rmanContTemplateSearchObject.effectiveStartDate!="") {
            searchString=searchString+'effectiveStartDate:'+rmanContTemplateSearchObject.effectiveStartDate+',';
        }

        if (rmanContTemplateSearchObject.effectiveEndDate!=undefined && rmanContTemplateSearchObject.effectiveEndDate!="") {
            searchString=searchString+'effectiveEndDate:'+rmanContTemplateSearchObject.effectiveEndDate+',';
        }

        if (rmanContTemplateSearchObject.attribute1!=undefined && rmanContTemplateSearchObject.attribute1!="") {
            searchString=searchString+'attribute1:'+rmanContTemplateSearchObject.attribute1+',';
        }

        if (rmanContTemplateSearchObject.attribute2!=undefined && rmanContTemplateSearchObject.attribute2!="") {
            searchString=searchString+'attribute2:'+rmanContTemplateSearchObject.attribute2+',';
        }

        if (rmanContTemplateSearchObject.attribute3!=undefined && rmanContTemplateSearchObject.attribute3!="") {
            searchString=searchString+'attribute3:'+rmanContTemplateSearchObject.attribute3+',';
        }

        if (rmanContTemplateSearchObject.attribute4!=undefined && rmanContTemplateSearchObject.attribute4!="") {
            searchString=searchString+'attribute4:'+rmanContTemplateSearchObject.attribute4+',';
        }

        if (rmanContTemplateSearchObject.attribute5!=undefined && rmanContTemplateSearchObject.attribute5!="") {
            searchString=searchString+'attribute5:'+rmanContTemplateSearchObject.attribute5+',';
        }

        if (rmanContTemplateSearchObject.attribute6!=undefined && rmanContTemplateSearchObject.attribute6!="") {
            searchString=searchString+'attribute6:'+rmanContTemplateSearchObject.attribute6+',';
        }

        if (rmanContTemplateSearchObject.attribute7!=undefined && rmanContTemplateSearchObject.attribute7!="") {
            searchString=searchString+'attribute7:'+rmanContTemplateSearchObject.attribute7+',';
        }

        if (rmanContTemplateSearchObject.attribute8!=undefined && rmanContTemplateSearchObject.attribute8!="") {
            searchString=searchString+'attribute8:'+rmanContTemplateSearchObject.attribute8+',';
        }

        if (rmanContTemplateSearchObject.attribute9!=undefined && rmanContTemplateSearchObject.attribute9!="") {
            searchString=searchString+'attribute9:'+rmanContTemplateSearchObject.attribute9+',';
        }

        if (rmanContTemplateSearchObject.attribute10!=undefined && rmanContTemplateSearchObject.attribute10!="") {
            searchString=searchString+'attribute10:'+rmanContTemplateSearchObject.attribute10+',';
        }

        if (rmanContTemplateSearchObject.attribute11!=undefined && rmanContTemplateSearchObject.attribute11!="") {
            searchString=searchString+'attribute11:'+rmanContTemplateSearchObject.attribute11+',';
        }

        if (rmanContTemplateSearchObject.attribute12!=undefined && rmanContTemplateSearchObject.attribute12!="") {
            searchString=searchString+'attribute12:'+rmanContTemplateSearchObject.attribute12+',';
        }

        if (rmanContTemplateSearchObject.attribute13!=undefined && rmanContTemplateSearchObject.attribute13!="") {
            searchString=searchString+'attribute13:'+rmanContTemplateSearchObject.attribute13+',';
        }

        if (rmanContTemplateSearchObject.attribute14!=undefined && rmanContTemplateSearchObject.attribute14!="") {
            searchString=searchString+'attribute14:'+rmanContTemplateSearchObject.attribute14+',';
        }

        if (rmanContTemplateSearchObject.attribute15!=undefined && rmanContTemplateSearchObject.attribute15!="") {
            searchString=searchString+'attribute15:'+rmanContTemplateSearchObject.attribute15+',';
        }

        if (rmanContTemplateSearchObject.creationDate!=undefined && rmanContTemplateSearchObject.creationDate!="") {
            searchString=searchString+'creationDate:'+rmanContTemplateSearchObject.creationDate+',';
        }

        if (rmanContTemplateSearchObject.createdBy!=undefined && rmanContTemplateSearchObject.createdBy!="") {
            searchString=searchString+'createdBy:'+rmanContTemplateSearchObject.createdBy+',';
        }

        if (rmanContTemplateSearchObject.lastUpdateDate!=undefined && rmanContTemplateSearchObject.lastUpdateDate!="") {
            searchString=searchString+'lastUpdateDate:'+rmanContTemplateSearchObject.lastUpdateDate+',';
        }

        if (rmanContTemplateSearchObject.lastUpdatedBy!=undefined && rmanContTemplateSearchObject.lastUpdatedBy!="") {
            searchString=searchString+'lastUpdatedBy:'+rmanContTemplateSearchObject.lastUpdatedBy+',';
        }

        if (rmanContTemplateSearchObject.defaultDays!=undefined && rmanContTemplateSearchObject.defaultDays!="") {
            searchString=searchString+'defaultDays:'+rmanContTemplateSearchObject.defaultDays+',';
        }

        if (rmanContTemplateSearchObject.invoiceHold!=undefined && rmanContTemplateSearchObject.invoiceHold!="") {
            searchString=searchString+'invoiceHold:'+rmanContTemplateSearchObject.invoiceHold;
        }


        
        if (searchString == '') {
            serviceUrl=serviceUrl+'search=%25';
        }
        else {
            serviceUrl=serviceUrl+'search='+searchString;
        }

        if(fetchAll=='Y') {
        	serviceUrl=serviceUrl+'&fetchAll=Y';
        }
        
        if (paginationOptions.pageNumber!=undefined && paginationOptions.pageNumber!="" && !isNaN(paginationOptions.pageNumber) && paginationOptions.pageNumber!=0) {
           serviceUrl=serviceUrl+'&page='+paginationOptions.pageNumber+'&size='+paginationOptions.pageSize;
        }
                
        return this.http.get(serviceUrl).toPromise().then((data:any) => {
            return data;
        });
    }
    
	
    
    saveRmanContTemplate(rmanContTemplate:any): Promise<any[]> {
        let body = JSON.stringify(rmanContTemplate);
        return this.http.post<any[]>(appSettings.apiUrl+'/RMAN_CONT_TEMPLATE',body,httpOptions).toPromise().then(data => {
            return data;
        });
    }
    
    updateRmanContTemplate(rmanContTemplate:any): Promise<any[]> {
        
        delete rmanContTemplate._links;
        delete rmanContTemplate.interests;
        let body = JSON.stringify(rmanContTemplate);
        return this.http.put<any[]>(appSettings.apiUrl+'/RMAN_CONT_TEMPLATE/'+rmanContTemplate.templateId,body,httpOptions).toPromise().then(data => {
            return data;
        });
        
    }
    
    deleteRmanContTemplate(rmanContTemplate:any): Promise<any[]> {
        let deleteUrl=appSettings.apiUrl+'/RMAN_CONT_TEMPLATE/'+rmanContTemplate.templateId;
        return this.http.delete(deleteUrl,httpOptions).toPromise().then((data:any) => {
            return data;
        });
    }

}
