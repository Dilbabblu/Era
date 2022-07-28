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
export class RmanContLinkedTemplateSvService {

    constructor(private http: HttpClient) {}

    getAllRmanContLinkedTemplateSv(paginationOptions:any,rmanContLinkedTemplateSvSearchObject:any): Promise<any[]> {
        let serviceUrl=appSettings.apiUrl+'/rmanContLinkedTemplateSvSearch?';

        let searchString='';

        if (rmanContLinkedTemplateSvSearchObject.key!=undefined && rmanContLinkedTemplateSvSearchObject.key!="") {
            searchString=searchString+'key:'+rmanContLinkedTemplateSvSearchObject.key+',';
        }

        if (rmanContLinkedTemplateSvSearchObject.ruleHeaderId!=undefined && rmanContLinkedTemplateSvSearchObject.ruleHeaderId!="") {
            searchString=searchString+'ruleHeaderId:'+rmanContLinkedTemplateSvSearchObject.ruleHeaderId+',';
        }

        if (rmanContLinkedTemplateSvSearchObject.templateId!=undefined && rmanContLinkedTemplateSvSearchObject.templateId!="") {
            searchString=searchString+'templateId:'+rmanContLinkedTemplateSvSearchObject.templateId+',';
        }

        if (rmanContLinkedTemplateSvSearchObject.attribute1!=undefined && rmanContLinkedTemplateSvSearchObject.attribute1!="") {
            searchString=searchString+'attribute1:'+rmanContLinkedTemplateSvSearchObject.attribute1+',';
        }

        if (rmanContLinkedTemplateSvSearchObject.attribute2!=undefined && rmanContLinkedTemplateSvSearchObject.attribute2!="") {
            searchString=searchString+'attribute2:'+rmanContLinkedTemplateSvSearchObject.attribute2+',';
        }

        if (rmanContLinkedTemplateSvSearchObject.attribute3!=undefined && rmanContLinkedTemplateSvSearchObject.attribute3!="") {
            searchString=searchString+'attribute3:'+rmanContLinkedTemplateSvSearchObject.attribute3+',';
        }

        if (rmanContLinkedTemplateSvSearchObject.attribute4!=undefined && rmanContLinkedTemplateSvSearchObject.attribute4!="") {
            searchString=searchString+'attribute4:'+rmanContLinkedTemplateSvSearchObject.attribute4+',';
        }

        if (rmanContLinkedTemplateSvSearchObject.attribute5!=undefined && rmanContLinkedTemplateSvSearchObject.attribute5!="") {
            searchString=searchString+'attribute5:'+rmanContLinkedTemplateSvSearchObject.attribute5+',';
        }

        if (rmanContLinkedTemplateSvSearchObject.attribute6!=undefined && rmanContLinkedTemplateSvSearchObject.attribute6!="") {
            searchString=searchString+'attribute6:'+rmanContLinkedTemplateSvSearchObject.attribute6+',';
        }

        if (rmanContLinkedTemplateSvSearchObject.attribute7!=undefined && rmanContLinkedTemplateSvSearchObject.attribute7!="") {
            searchString=searchString+'attribute7:'+rmanContLinkedTemplateSvSearchObject.attribute7+',';
        }

        if (rmanContLinkedTemplateSvSearchObject.attribute8!=undefined && rmanContLinkedTemplateSvSearchObject.attribute8!="") {
            searchString=searchString+'attribute8:'+rmanContLinkedTemplateSvSearchObject.attribute8+',';
        }

        if (rmanContLinkedTemplateSvSearchObject.attribute9!=undefined && rmanContLinkedTemplateSvSearchObject.attribute9!="") {
            searchString=searchString+'attribute9:'+rmanContLinkedTemplateSvSearchObject.attribute9+',';
        }

        if (rmanContLinkedTemplateSvSearchObject.attribute10!=undefined && rmanContLinkedTemplateSvSearchObject.attribute10!="") {
            searchString=searchString+'attribute10:'+rmanContLinkedTemplateSvSearchObject.attribute10+',';
        }

        if (rmanContLinkedTemplateSvSearchObject.attribute11!=undefined && rmanContLinkedTemplateSvSearchObject.attribute11!="") {
            searchString=searchString+'attribute11:'+rmanContLinkedTemplateSvSearchObject.attribute11+',';
        }

        if (rmanContLinkedTemplateSvSearchObject.attribute12!=undefined && rmanContLinkedTemplateSvSearchObject.attribute12!="") {
            searchString=searchString+'attribute12:'+rmanContLinkedTemplateSvSearchObject.attribute12+',';
        }

        if (rmanContLinkedTemplateSvSearchObject.attribute13!=undefined && rmanContLinkedTemplateSvSearchObject.attribute13!="") {
            searchString=searchString+'attribute13:'+rmanContLinkedTemplateSvSearchObject.attribute13+',';
        }

        if (rmanContLinkedTemplateSvSearchObject.attribute14!=undefined && rmanContLinkedTemplateSvSearchObject.attribute14!="") {
            searchString=searchString+'attribute14:'+rmanContLinkedTemplateSvSearchObject.attribute14+',';
        }

        if (rmanContLinkedTemplateSvSearchObject.attribute15!=undefined && rmanContLinkedTemplateSvSearchObject.attribute15!="") {
            searchString=searchString+'attribute15:'+rmanContLinkedTemplateSvSearchObject.attribute15+',';
        }

        if (rmanContLinkedTemplateSvSearchObject.creationDate!=undefined && rmanContLinkedTemplateSvSearchObject.creationDate!="") {
            searchString=searchString+'creationDate:'+rmanContLinkedTemplateSvSearchObject.creationDate+',';
        }

        if (rmanContLinkedTemplateSvSearchObject.createdBy!=undefined && rmanContLinkedTemplateSvSearchObject.createdBy!="") {
            searchString=searchString+'createdBy:'+rmanContLinkedTemplateSvSearchObject.createdBy+',';
        }

        if (rmanContLinkedTemplateSvSearchObject.lastUpdateDate!=undefined && rmanContLinkedTemplateSvSearchObject.lastUpdateDate!="") {
            searchString=searchString+'lastUpdateDate:'+rmanContLinkedTemplateSvSearchObject.lastUpdateDate+',';
        }

        if (rmanContLinkedTemplateSvSearchObject.lastUpdatedBy!=undefined && rmanContLinkedTemplateSvSearchObject.lastUpdatedBy!="") {
            searchString=searchString+'lastUpdatedBy:'+rmanContLinkedTemplateSvSearchObject.lastUpdatedBy;
        }

        if (searchString == '') {
            serviceUrl=serviceUrl+'search=%25';
        }
        else {
            serviceUrl=serviceUrl+'search='+searchString;
        }
        if (paginationOptions.pageNumber!=undefined && paginationOptions.pageNumber!="" && !isNaN(paginationOptions.pageNumber) && paginationOptions.pageNumber!=0) {
           serviceUrl=serviceUrl+'&page='+paginationOptions.pageNumber+'&size='+paginationOptions.pageSize;
        }else{
          serviceUrl=serviceUrl+'&size='+paginationOptions.pageSize;
        }

        return this.http.get(serviceUrl).toPromise().then((data:any) => {
            return data;
        });
    }


    saveRmanContLinkedTemplateSv(body_data:any): Promise<any[]> {
        let body = JSON.stringify(body_data);
        return this.http.post<any[]>(appSettings.apiUrl+'/saveRmanContLinkedTemplates',body,httpOptions).toPromise().then(data => {
           return data;
        })
    }

    updateRmanContLinkedTemplateSv(rmanContLinkedTemplateSv:any): Promise<any[]> {

        delete rmanContLinkedTemplateSv._links;
        delete rmanContLinkedTemplateSv.interests;
        let body = JSON.stringify(rmanContLinkedTemplateSv);
        return this.http.put<any[]>(appSettings.apiUrl+'/RMAN_CONT_LINKED_TEMPLATE_SV/'+rmanContLinkedTemplateSv.key,body,httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanContLinkedTemplateSv(rmanContLinkedTemplateSv:any): Promise<any[]> {
        let deleteUrl=appSettings.apiUrl+'/RMAN_CONT_LINKED_TEMPLATE_SV/'+rmanContLinkedTemplateSv.ruleHeaderId+'/'+rmanContLinkedTemplateSv.templateId;
        return this.http.delete(deleteUrl,httpOptions).toPromise().then((data:any) => {
            return data;
        });
    }

}
