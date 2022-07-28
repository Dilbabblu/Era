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
export class RmanAccountSetupService {

    constructor(private http: HttpClient) {}

    getAllRmanAccountSetup(paginationOptions:any,rmanAccountSetupSearchObject:any) {
        let serviceUrl=appSettings.apiUrl+'/rmanAccountSetupSearch?';

        let searchString='';

        if (rmanAccountSetupSearchObject.accountingStructure!=undefined && rmanAccountSetupSearchObject.accountingStructure!="") {
            searchString=searchString+'accountingStructure:'+rmanAccountSetupSearchObject.accountingStructure+',';
        }

        if (rmanAccountSetupSearchObject.name!=undefined && rmanAccountSetupSearchObject.name!="") {
            searchString=searchString+'name:'+rmanAccountSetupSearchObject.name+',';
        }

        if (rmanAccountSetupSearchObject.revenue!=undefined && rmanAccountSetupSearchObject.revenue!="") {
            searchString=searchString+'revenue:'+rmanAccountSetupSearchObject.revenue+',';
        }

        if (rmanAccountSetupSearchObject.deferredRevenue!=undefined && rmanAccountSetupSearchObject.deferredRevenue!="") {
            searchString=searchString+'deferredRevenue:'+rmanAccountSetupSearchObject.deferredRevenue+',';
        }

        if (rmanAccountSetupSearchObject.provision!=undefined && rmanAccountSetupSearchObject.provision!="") {
            searchString=searchString+'provision:'+rmanAccountSetupSearchObject.provision+',';
        }

        if (rmanAccountSetupSearchObject.amortizationDeferrals!=undefined && rmanAccountSetupSearchObject.amortizationDeferrals!="") {
            searchString=searchString+'amortizationDeferrals:'+rmanAccountSetupSearchObject.amortizationDeferrals+',';
        }

        if (rmanAccountSetupSearchObject.cogs!=undefined && rmanAccountSetupSearchObject.cogs!="") {
            searchString=searchString+'cogs:'+rmanAccountSetupSearchObject.cogs+',';
        }

        if (rmanAccountSetupSearchObject.deferredCogs!=undefined && rmanAccountSetupSearchObject.deferredCogs!="") {
            searchString=searchString+'deferredCogs:'+rmanAccountSetupSearchObject.deferredCogs;
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

    saveRmanAccountSetup(rmanAccountSetup:any) {
        let body = JSON.stringify(rmanAccountSetup);
        return this.http.post<any[]>(appSettings.apiUrl+'/RMAN_ACCOUNT_SETUP',body,httpOptions).toPromise().then((data:any) => {
            return data;
        });
    }

    updateRmanAccountSetup(rmanAccountSetup:any) {

        delete rmanAccountSetup._links;
        delete rmanAccountSetup.interests;
        let body = JSON.stringify(rmanAccountSetup);
        return this.http.put(appSettings.apiUrl+'/RMAN_ACCOUNT_SETUP/'+rmanAccountSetup.acctSetupId,body,httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanAccountSetup(rmanAccountSetup:any) {
        let deleteUrl=appSettings.apiUrl+'/RMAN_ACCOUNT_SETUP/'+rmanAccountSetup.acctSetupId;
        return this.http.delete(deleteUrl,httpOptions).toPromise().then(data => {
            return data;
        });
    }

}
