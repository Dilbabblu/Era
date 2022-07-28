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
export class RmanGlAccountsService {


    constructor(private http: HttpClient) {}
    
    getAllRmanGlAccounts(paginationOptions:any,rmanGlAccountsSearchObject:any) {
        let serviceUrl=appSettings.apiUrl+'/rmanGlAccountsSearch?';
        
        let searchString='';

        if (rmanGlAccountsSearchObject.accountId!=undefined && rmanGlAccountsSearchObject.accountId!="") {
            searchString=searchString+'accountId:'+rmanGlAccountsSearchObject.accountId+',';
        }

        if (rmanGlAccountsSearchObject.sourceAccountId!=undefined && rmanGlAccountsSearchObject.sourceAccountId!="") {
            searchString=searchString+'sourceAccountId:'+rmanGlAccountsSearchObject.sourceAccountId+',';
        }

        if (rmanGlAccountsSearchObject.sourceLedgerId!=undefined && rmanGlAccountsSearchObject.sourceLedgerId!="") {
            searchString=searchString+'sourceLedgerId:'+rmanGlAccountsSearchObject.sourceLedgerId+',';
        }

        if (rmanGlAccountsSearchObject.ledgerId!=undefined && rmanGlAccountsSearchObject.ledgerId!="") {
            searchString=searchString+'ledgerId:'+rmanGlAccountsSearchObject.ledgerId+',';
        }

        if (rmanGlAccountsSearchObject.accountingString!=undefined && rmanGlAccountsSearchObject.accountingString!="") {
            searchString=searchString+'accountingString:'+rmanGlAccountsSearchObject.accountingString+',';
        }

        if (rmanGlAccountsSearchObject.segment1!=undefined && rmanGlAccountsSearchObject.segment1!="") {
            searchString=searchString+'segment1:'+rmanGlAccountsSearchObject.segment1+',';
        }

        if (rmanGlAccountsSearchObject.segment2!=undefined && rmanGlAccountsSearchObject.segment2!="") {
            searchString=searchString+'segment2:'+rmanGlAccountsSearchObject.segment2+',';
        }

        if (rmanGlAccountsSearchObject.segment3!=undefined && rmanGlAccountsSearchObject.segment3!="") {
            searchString=searchString+'segment3:'+rmanGlAccountsSearchObject.segment3+',';
        }

        if (rmanGlAccountsSearchObject.segment4!=undefined && rmanGlAccountsSearchObject.segment4!="") {
            searchString=searchString+'segment4:'+rmanGlAccountsSearchObject.segment4+',';
        }

        if (rmanGlAccountsSearchObject.segment5!=undefined && rmanGlAccountsSearchObject.segment5!="") {
            searchString=searchString+'segment5:'+rmanGlAccountsSearchObject.segment5+',';
        }

        if (rmanGlAccountsSearchObject.segment6!=undefined && rmanGlAccountsSearchObject.segment6!="") {
            searchString=searchString+'segment6:'+rmanGlAccountsSearchObject.segment6+',';
        }

        if (rmanGlAccountsSearchObject.segment7!=undefined && rmanGlAccountsSearchObject.segment7!="") {
            searchString=searchString+'segment7:'+rmanGlAccountsSearchObject.segment7+',';
        }

        if (rmanGlAccountsSearchObject.segment8!=undefined && rmanGlAccountsSearchObject.segment8!="") {
            searchString=searchString+'segment8:'+rmanGlAccountsSearchObject.segment8+',';
        }

        if (rmanGlAccountsSearchObject.segment9!=undefined && rmanGlAccountsSearchObject.segment9!="") {
            searchString=searchString+'segment9:'+rmanGlAccountsSearchObject.segment9+',';
        }

        if (rmanGlAccountsSearchObject.segment10!=undefined && rmanGlAccountsSearchObject.segment10!="") {
            searchString=searchString+'segment10:'+rmanGlAccountsSearchObject.segment10+',';
        }

        if (rmanGlAccountsSearchObject.accountType!=undefined && rmanGlAccountsSearchObject.accountType!="") {
            searchString=searchString+'accountType:'+rmanGlAccountsSearchObject.accountType+',';
        }

        if (rmanGlAccountsSearchObject.enabledFlag!=undefined && rmanGlAccountsSearchObject.enabledFlag!="") {
            searchString=searchString+'enabledFlag:'+rmanGlAccountsSearchObject.enabledFlag+',';
        }

        if (rmanGlAccountsSearchObject.creationDate!=undefined && rmanGlAccountsSearchObject.creationDate!="") {
            searchString=searchString+'creationDate:'+rmanGlAccountsSearchObject.creationDate+',';
        }

        if (rmanGlAccountsSearchObject.createdBy!=undefined && rmanGlAccountsSearchObject.createdBy!="") {
            searchString=searchString+'createdBy:'+rmanGlAccountsSearchObject.createdBy+',';
        }

        if (rmanGlAccountsSearchObject.lastUpdateDate!=undefined && rmanGlAccountsSearchObject.lastUpdateDate!="") {
            searchString=searchString+'lastUpdateDate:'+rmanGlAccountsSearchObject.lastUpdateDate+',';
        }

        if (rmanGlAccountsSearchObject.lastUpdatedBy!=undefined && rmanGlAccountsSearchObject.lastUpdatedBy!="") {
            searchString=searchString+'lastUpdatedBy:'+rmanGlAccountsSearchObject.lastUpdatedBy;
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
    
	
    
    saveRmanGlAccounts(rmanGlAccounts:any) {
        let body = JSON.stringify(rmanGlAccounts);
        return this.http.post(appSettings.apiUrl+'/RMAN_GL_ACCOUNTS',body,httpOptions).toPromise().then(data => {
            return data;
        });
    }
    
    updateRmanGlAccounts(rmanGlAccounts:any) {
        
        delete rmanGlAccounts._links;
        delete rmanGlAccounts.interests;
        let body = JSON.stringify(rmanGlAccounts);
        return this.http.put(appSettings.apiUrl+'/RMAN_GL_ACCOUNTS/'+rmanGlAccounts.accountId,body,httpOptions).toPromise().then(data => {
            return data;
        });
        
    }
    
    deleteRmanGlAccounts(rmanGlAccounts:any) {
        let deleteUrl=appSettings.apiUrl+'/RMAN_GL_ACCOUNTS/'+rmanGlAccounts.accountId;
        return this.http.delete(deleteUrl,httpOptions).toPromise().then((data:any) => {
            return data;
        });
    }

}
