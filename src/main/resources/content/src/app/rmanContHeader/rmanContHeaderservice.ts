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
export class RmanContHeaderService {

    constructor(private http: HttpClient) {}
    
    getAllRmanContHeader(paginationOptions:any,rmanContHeaderSearchObject:any): Promise<any[]> {
        let serviceUrl=appSettings.apiUrl+'/rmanContHeaderSearch?';
        
        let searchString='';

        if (rmanContHeaderSearchObject.ruleHeaderId!=undefined && rmanContHeaderSearchObject.ruleHeaderId!="") {
            searchString=searchString+'ruleHeaderId:'+rmanContHeaderSearchObject.ruleHeaderId+',';
        }

        if (rmanContHeaderSearchObject.ruleName!=undefined && rmanContHeaderSearchObject.ruleName!="") {
            searchString=searchString+'ruleName:'+rmanContHeaderSearchObject.ruleName+',';
        }

        if (rmanContHeaderSearchObject.ruleApplyLevel!=undefined && rmanContHeaderSearchObject.ruleApplyLevel!="") {
            searchString=searchString+'ruleApplyLevel:'+rmanContHeaderSearchObject.ruleApplyLevel+',';
        }

        if (rmanContHeaderSearchObject.ruleCategory!=undefined && rmanContHeaderSearchObject.ruleCategory!="") {
            searchString=searchString+'ruleCategory:'+rmanContHeaderSearchObject.ruleCategory+',';
        }

        if (rmanContHeaderSearchObject.ruleStartDate!=undefined && rmanContHeaderSearchObject.ruleStartDate!="") {
            searchString=searchString+'ruleStartDate:'+rmanContHeaderSearchObject.ruleStartDate+',';
        }

        if (rmanContHeaderSearchObject.ruleEndDate!=undefined && rmanContHeaderSearchObject.ruleEndDate!="") {
            searchString=searchString+'ruleEndDate:'+rmanContHeaderSearchObject.ruleEndDate+',';
        }

        if (rmanContHeaderSearchObject.attribute1!=undefined && rmanContHeaderSearchObject.attribute1!="") {
            searchString=searchString+'attribute1:'+rmanContHeaderSearchObject.attribute1+',';
        }

        if (rmanContHeaderSearchObject.attribute2!=undefined && rmanContHeaderSearchObject.attribute2!="") {
            searchString=searchString+'attribute2:'+rmanContHeaderSearchObject.attribute2+',';
        }

        if (rmanContHeaderSearchObject.attribute3!=undefined && rmanContHeaderSearchObject.attribute3!="") {
            searchString=searchString+'attribute3:'+rmanContHeaderSearchObject.attribute3+',';
        }

        if (rmanContHeaderSearchObject.attribute4!=undefined && rmanContHeaderSearchObject.attribute4!="") {
            searchString=searchString+'attribute4:'+rmanContHeaderSearchObject.attribute4+',';
        }

        if (rmanContHeaderSearchObject.attribute5!=undefined && rmanContHeaderSearchObject.attribute5!="") {
            searchString=searchString+'attribute5:'+rmanContHeaderSearchObject.attribute5+',';
        }

        if (rmanContHeaderSearchObject.attribute6!=undefined && rmanContHeaderSearchObject.attribute6!="") {
            searchString=searchString+'attribute6:'+rmanContHeaderSearchObject.attribute6+',';
        }

        if (rmanContHeaderSearchObject.attribute7!=undefined && rmanContHeaderSearchObject.attribute7!="") {
            searchString=searchString+'attribute7:'+rmanContHeaderSearchObject.attribute7+',';
        }

        if (rmanContHeaderSearchObject.attribute8!=undefined && rmanContHeaderSearchObject.attribute8!="") {
            searchString=searchString+'attribute8:'+rmanContHeaderSearchObject.attribute8+',';
        }

        if (rmanContHeaderSearchObject.attribute9!=undefined && rmanContHeaderSearchObject.attribute9!="") {
            searchString=searchString+'attribute9:'+rmanContHeaderSearchObject.attribute9+',';
        }

        if (rmanContHeaderSearchObject.attribute10!=undefined && rmanContHeaderSearchObject.attribute10!="") {
            searchString=searchString+'attribute10:'+rmanContHeaderSearchObject.attribute10+',';
        }

        if (rmanContHeaderSearchObject.attribute11!=undefined && rmanContHeaderSearchObject.attribute11!="") {
            searchString=searchString+'attribute11:'+rmanContHeaderSearchObject.attribute11+',';
        }

        if (rmanContHeaderSearchObject.attribute12!=undefined && rmanContHeaderSearchObject.attribute12!="") {
            searchString=searchString+'attribute12:'+rmanContHeaderSearchObject.attribute12+',';
        }

        if (rmanContHeaderSearchObject.attribute13!=undefined && rmanContHeaderSearchObject.attribute13!="") {
            searchString=searchString+'attribute13:'+rmanContHeaderSearchObject.attribute13+',';
        }

        if (rmanContHeaderSearchObject.attribute14!=undefined && rmanContHeaderSearchObject.attribute14!="") {
            searchString=searchString+'attribute14:'+rmanContHeaderSearchObject.attribute14+',';
        }

        if (rmanContHeaderSearchObject.attribute15!=undefined && rmanContHeaderSearchObject.attribute15!="") {
            searchString=searchString+'attribute15:'+rmanContHeaderSearchObject.attribute15+',';
        }

        if (rmanContHeaderSearchObject.attribute16!=undefined && rmanContHeaderSearchObject.attribute16!="") {
            searchString=searchString+'attribute16:'+rmanContHeaderSearchObject.attribute16+',';
        }

        if (rmanContHeaderSearchObject.attribute17!=undefined && rmanContHeaderSearchObject.attribute17!="") {
            searchString=searchString+'attribute17:'+rmanContHeaderSearchObject.attribute17+',';
        }

        if (rmanContHeaderSearchObject.attribute18!=undefined && rmanContHeaderSearchObject.attribute18!="") {
            searchString=searchString+'attribute18:'+rmanContHeaderSearchObject.attribute18+',';
        }

        if (rmanContHeaderSearchObject.attribute19!=undefined && rmanContHeaderSearchObject.attribute19!="") {
            searchString=searchString+'attribute19:'+rmanContHeaderSearchObject.attribute19+',';
        }

        if (rmanContHeaderSearchObject.attribute20!=undefined && rmanContHeaderSearchObject.attribute20!="") {
            searchString=searchString+'attribute20:'+rmanContHeaderSearchObject.attribute20+',';
        }

        if (rmanContHeaderSearchObject.attribute21!=undefined && rmanContHeaderSearchObject.attribute21!="") {
            searchString=searchString+'attribute21:'+rmanContHeaderSearchObject.attribute21+',';
        }

        if (rmanContHeaderSearchObject.attribute22!=undefined && rmanContHeaderSearchObject.attribute22!="") {
            searchString=searchString+'attribute22:'+rmanContHeaderSearchObject.attribute22+',';
        }

        if (rmanContHeaderSearchObject.attribute23!=undefined && rmanContHeaderSearchObject.attribute23!="") {
            searchString=searchString+'attribute23:'+rmanContHeaderSearchObject.attribute23+',';
        }

        if (rmanContHeaderSearchObject.attribute24!=undefined && rmanContHeaderSearchObject.attribute24!="") {
            searchString=searchString+'attribute24:'+rmanContHeaderSearchObject.attribute24+',';
        }

        if (rmanContHeaderSearchObject.attribute25!=undefined && rmanContHeaderSearchObject.attribute25!="") {
            searchString=searchString+'attribute25:'+rmanContHeaderSearchObject.attribute25+',';
        }

        if (rmanContHeaderSearchObject.attribute26!=undefined && rmanContHeaderSearchObject.attribute26!="") {
            searchString=searchString+'attribute26:'+rmanContHeaderSearchObject.attribute26+',';
        }

        if (rmanContHeaderSearchObject.attribute27!=undefined && rmanContHeaderSearchObject.attribute27!="") {
            searchString=searchString+'attribute27:'+rmanContHeaderSearchObject.attribute27+',';
        }

        if (rmanContHeaderSearchObject.attribute28!=undefined && rmanContHeaderSearchObject.attribute28!="") {
            searchString=searchString+'attribute28:'+rmanContHeaderSearchObject.attribute28+',';
        }

        if (rmanContHeaderSearchObject.attribute29!=undefined && rmanContHeaderSearchObject.attribute29!="") {
            searchString=searchString+'attribute29:'+rmanContHeaderSearchObject.attribute29+',';
        }

        if (rmanContHeaderSearchObject.attribute30!=undefined && rmanContHeaderSearchObject.attribute30!="") {
            searchString=searchString+'attribute30:'+rmanContHeaderSearchObject.attribute30+',';
        }

        if (rmanContHeaderSearchObject.creationDate!=undefined && rmanContHeaderSearchObject.creationDate!="") {
            searchString=searchString+'creationDate:'+rmanContHeaderSearchObject.creationDate+',';
        }

        if (rmanContHeaderSearchObject.createdBy!=undefined && rmanContHeaderSearchObject.createdBy!="") {
            searchString=searchString+'createdBy:'+rmanContHeaderSearchObject.createdBy+',';
        }

        if (rmanContHeaderSearchObject.lastUpdateDate!=undefined && rmanContHeaderSearchObject.lastUpdateDate!="") {
            searchString=searchString+'lastUpdateDate:'+rmanContHeaderSearchObject.lastUpdateDate+',';
        }

        if (rmanContHeaderSearchObject.lastUpdatedBy!=undefined && rmanContHeaderSearchObject.lastUpdatedBy!="") {
            searchString=searchString+'lastUpdatedBy:'+rmanContHeaderSearchObject.lastUpdatedBy+',';
        }

        if (rmanContHeaderSearchObject.description!=undefined && rmanContHeaderSearchObject.description!="") {
            searchString=searchString+'description:'+rmanContHeaderSearchObject.description+',';
        }

        if (rmanContHeaderSearchObject.ruleMasterId!=undefined && rmanContHeaderSearchObject.ruleMasterId!="") {
            searchString=searchString+'ruleMasterId:'+rmanContHeaderSearchObject.ruleMasterId+',';
        }

        if (rmanContHeaderSearchObject.approverId!=undefined && rmanContHeaderSearchObject.approverId!="") {
            searchString=searchString+'approverId:'+rmanContHeaderSearchObject.approverId+',';
        }

        if (rmanContHeaderSearchObject.sequenceNumber!=undefined && rmanContHeaderSearchObject.sequenceNumber!="") {
            searchString=searchString+'sequenceNumber:'+rmanContHeaderSearchObject.sequenceNumber+',';
        }

        if (rmanContHeaderSearchObject.dealFlag!=undefined && rmanContHeaderSearchObject.dealFlag!="") {
            searchString=searchString+'dealFlag:'+rmanContHeaderSearchObject.dealFlag+',';
        }

        if (rmanContHeaderSearchObject.ranking!=undefined && rmanContHeaderSearchObject.ranking!="") {
            searchString=searchString+'ranking:'+rmanContHeaderSearchObject.ranking+',';
        }

        if (rmanContHeaderSearchObject.revFlag!=undefined && rmanContHeaderSearchObject.revFlag!="") {
            searchString=searchString+'revFlag:'+rmanContHeaderSearchObject.revFlag+',';
        }

        if (rmanContHeaderSearchObject.cogsFlag!=undefined && rmanContHeaderSearchObject.cogsFlag!="") {
            searchString=searchString+'cogsFlag:'+rmanContHeaderSearchObject.cogsFlag+',';
        }

        if (rmanContHeaderSearchObject.comments!=undefined && rmanContHeaderSearchObject.comments!="") {
            searchString=searchString+'comments:'+rmanContHeaderSearchObject.comments;
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
    
    deleteRmanContHeader(rmanContHeader:any): Promise<any[]> {
        let deleteUrl=appSettings.apiUrl+'/RMAN_CONT_HEADER/'+rmanContHeader.ruleHeaderId;
        return this.http.delete(deleteUrl,httpOptions).toPromise().then((data:any) => {
            return data;
        });
    }
    
    contRulesList():Promise<any[]> {
        let contRulesURL= appSettings.apiUrl+'/rmanContRulesLov';
        
        return this.http.get(contRulesURL).toPromise().then((data:any) => {
            return data;
        });
    }
    
    createOrUpdateContHeader(rmanContHeader:any, isCreate:any): Promise<any[]> {
        if(isCreate){
            let body = JSON.stringify(rmanContHeader);
            return this.http.post<any[]>(appSettings.apiUrl+'/createContHeader',body,httpOptions).toPromise().then(data => {
                return data;
            });
        }else{
            delete rmanContHeader._links;
            delete rmanContHeader.interests;
            let body = JSON.stringify(rmanContHeader);
            return this.http.put<any[]>(appSettings.apiUrl+'/RMAN_CONT_HEADER/'+rmanContHeader.ruleHeaderId,body,httpOptions).toPromise().then(data => {
                data=JSON.parse(JSON.stringify(data));
                return data;
            });
        }
    }    
}
