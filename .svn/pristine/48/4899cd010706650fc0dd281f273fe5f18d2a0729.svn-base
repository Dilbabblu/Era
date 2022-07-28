import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

declare var require: any;
const appSettings = require('../appsettings');



const httpOptions = {
    headers: new HttpHeaders({
        'Content-Type': 'application/json',
    })
};


@Injectable()
export class RmanFunctionsService {

    constructor(private http: HttpClient) { }

    getAllRmanFunctions(paginationOptions: any, rmanFunctionsSearchObject: any): Promise<any[]> {

        let serviceUrl = appSettings.apiUrl + '/rmanFunctionsSearch?';

        let searchString = '';

        if (rmanFunctionsSearchObject.fid != undefined && rmanFunctionsSearchObject.fid != "") {
            searchString = searchString + 'fid:' + rmanFunctionsSearchObject.fid + ',';
        }

        if (rmanFunctionsSearchObject.module != undefined && rmanFunctionsSearchObject.module != "") {
            searchString = searchString + 'module:' + rmanFunctionsSearchObject.module + ',';
        }

        if (rmanFunctionsSearchObject.fcode != undefined && rmanFunctionsSearchObject.fcode != "") {
            searchString = searchString + 'fcode:' + rmanFunctionsSearchObject.fcode + ',';
        }

        if (rmanFunctionsSearchObject.name != undefined && rmanFunctionsSearchObject.name != "") {
            searchString = searchString + 'name:' + rmanFunctionsSearchObject.name + ',';
        }

        if (rmanFunctionsSearchObject.url != undefined && rmanFunctionsSearchObject.url != "") {
            searchString = searchString + 'url:' + rmanFunctionsSearchObject.url + ',';
        }

        if (rmanFunctionsSearchObject.enabledFlag != undefined && rmanFunctionsSearchObject.enabledFlag != "") {
            searchString = searchString + 'enabledFlag:' + rmanFunctionsSearchObject.enabledFlag;
        }



        if (searchString == '') {
            serviceUrl = serviceUrl + 'search=%25';
        }
        else {
            serviceUrl = serviceUrl + 'search=' + searchString;
        }

        if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != "" && !isNaN(paginationOptions.pageNumber) && paginationOptions.pageNumber != 0) {
            serviceUrl = serviceUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;
        }

        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }

    saveRmanFunctions(rmanFunctions: any): Promise<any[]> {
        let body = JSON.stringify(rmanFunctions);
        return this.http.post(appSettings.apiUrl + '/RMAN_FUNCTIONS', body, httpOptions).toPromise().then((data: any) => {
            return data;
        });
    }

    updateRmanFunctions(rmanFunctions: any): Promise<any[]> {

        delete rmanFunctions._links;
        delete rmanFunctions.interests;
        let body = JSON.stringify(rmanFunctions);
        return this.http.put(appSettings.apiUrl + '/RMAN_FUNCTIONS/' + rmanFunctions.fid, body, httpOptions).toPromise().then((data: any) => {
            return data;
        });

    }

    deleteRmanFunctions(rmanFunctions: any): Promise<any[]> {
        let deleteUrl = appSettings.apiUrl + '/RMAN_FUNCTIONS/' + rmanFunctions.fid;
        return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
            return data;
        });
    }

}
