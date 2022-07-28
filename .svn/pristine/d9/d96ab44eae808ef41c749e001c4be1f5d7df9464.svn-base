import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, OnDestroy } from '@angular/core';
declare var require: any;
const appSettings = require('../appsettings');


const httpOptions = {
    headers: new HttpHeaders({
        'Content-Type': 'application/json',
    })
};



@Injectable()
export class RmanLookupsVService implements OnDestroy {

    constructor(private http: HttpClient) {
    }

    ngOnDestroy() { 
    }


    getAllRmanLookupsV(paginationOptions: any, rmanLookupsVSearchObject: any): Promise<any[]> {
        let serviceUrl = appSettings.apiUrl + '/rmanLookupsVSearch?';

        let searchString = '';

        if (rmanLookupsVSearchObject.lookupTypeName != undefined && rmanLookupsVSearchObject.lookupTypeName != "") {
            searchString = searchString + 'lookupTypeName:' + rmanLookupsVSearchObject.lookupTypeName + ',';
        }

        if (rmanLookupsVSearchObject.lookupTypeMeaning != undefined && rmanLookupsVSearchObject.lookupTypeMeaning != "") {
            searchString = searchString + 'lookupTypeMeaning:' + rmanLookupsVSearchObject.lookupTypeMeaning + ',';
        }

        if (rmanLookupsVSearchObject.lookupTypeDescription != undefined && rmanLookupsVSearchObject.lookupTypeDescription != "") {
            searchString = searchString + 'lookupTypeDescription:' + rmanLookupsVSearchObject.lookupTypeDescription + ',';
        }

        if (rmanLookupsVSearchObject.lookupTypeStartDate != undefined && rmanLookupsVSearchObject.lookupTypeStartDate != "") {
            searchString = searchString + 'lookupTypeStartDate:' + rmanLookupsVSearchObject.lookupTypeStartDate + ',';
        }

        if (rmanLookupsVSearchObject.lookupTypeEndDate != undefined && rmanLookupsVSearchObject.lookupTypeEndDate != "") {
            searchString = searchString + 'lookupTypeEndDate:' + rmanLookupsVSearchObject.lookupTypeEndDate + ',';
        }

        if (rmanLookupsVSearchObject.lookupTypeEnabledFlag != undefined && rmanLookupsVSearchObject.lookupTypeEnabledFlag != "") {
            searchString = searchString + 'lookupTypeEnabledFlag:' + rmanLookupsVSearchObject.lookupTypeEnabledFlag + ',';
        }

        if (rmanLookupsVSearchObject.lookupCode != undefined && rmanLookupsVSearchObject.lookupCode != "") {
            searchString = searchString + 'lookupCode:' + rmanLookupsVSearchObject.lookupCode + ',';
        }

        if (rmanLookupsVSearchObject.lookupDescription != undefined && rmanLookupsVSearchObject.lookupDescription != "") {
            searchString = searchString + 'lookupDescription:' + rmanLookupsVSearchObject.lookupDescription + ',';
        }

        if (rmanLookupsVSearchObject.lookupCodeStartDate != undefined && rmanLookupsVSearchObject.lookupCodeStartDate != "") {
            searchString = searchString + 'lookupCodeStartDate:' + rmanLookupsVSearchObject.lookupCodeStartDate + ',';
        }

        if (rmanLookupsVSearchObject.lookupCodeEndDate != undefined && rmanLookupsVSearchObject.lookupCodeEndDate != "") {
            searchString = searchString + 'lookupCodeEndDate:' + rmanLookupsVSearchObject.lookupCodeEndDate + ',';
        }

        if (rmanLookupsVSearchObject.lookupCodeEnabledFlag != undefined && rmanLookupsVSearchObject.lookupCodeEnabledFlag != "") {
            searchString = searchString + 'lookupCodeEnabledFlag:' + rmanLookupsVSearchObject.lookupCodeEnabledFlag;
        }



        if (searchString == '') {
            serviceUrl = serviceUrl + 'search=%25&size=10000';

        }
        else {
            serviceUrl = serviceUrl + 'search=' + searchString + '&size=10000';
        }

        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }


    saveRmanLookupsV(rmanLookupsV: any): Promise<any[]> {
        let body = JSON.stringify(rmanLookupsV);
        return this.http.post<any[]>(appSettings.apiUrl + '/RMAN_LOOKUPS_V', body, httpOptions).toPromise().then(data => {
            return data;
        });
    }

    updateRmanLookupsV(rmanLookupsV: any): Promise<any[]> {

        delete rmanLookupsV._links;
        delete rmanLookupsV.interests;
        let body = JSON.stringify(rmanLookupsV);
        return this.http.put<any[]>(appSettings.apiUrl + '/RMAN_LOOKUPS_V/' + rmanLookupsV.lookupCode, body, httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanLookupsV(rmanLookupsV: any): Promise<any[]> {
        let deleteUrl = appSettings.apiUrl + '/RMAN_LOOKUPS_V/' + rmanLookupsV.lookupCode;
        return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
            return data;
        });
    }

}
