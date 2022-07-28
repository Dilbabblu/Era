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
export class RmanFcstActualDetailsVService {

    constructor(private http: HttpClient) { }

    getAllRmanFcstActualDetailsV(paginationOptions: any, rmanFcstActualDetailsVSearchObject: any): Promise<any[]> {
        let serviceUrl = appSettings.apiUrl + '/rmanFcstActualDetailsVSearch?';

        let searchString = '';

        if (rmanFcstActualDetailsVSearchObject.arrangementId != undefined && rmanFcstActualDetailsVSearchObject.arrangementId != "") {
            searchString = searchString + 'arrangementId:' + rmanFcstActualDetailsVSearchObject.arrangementId + ',';
        }

        if (rmanFcstActualDetailsVSearchObject.arrangementName != undefined && rmanFcstActualDetailsVSearchObject.arrangementName != "") {
            searchString = searchString + 'arrangementName:' + rmanFcstActualDetailsVSearchObject.arrangementName + ',';
        }

        if (rmanFcstActualDetailsVSearchObject.sku != undefined && rmanFcstActualDetailsVSearchObject.sku != "") {
            searchString = searchString + 'sku:' + rmanFcstActualDetailsVSearchObject.sku + ',';
        }

        if (rmanFcstActualDetailsVSearchObject.qty != undefined && rmanFcstActualDetailsVSearchObject.qty != "") {
            searchString = searchString + 'qty:' + rmanFcstActualDetailsVSearchObject.qty + ',';
        }

        if (rmanFcstActualDetailsVSearchObject.elementType != undefined && rmanFcstActualDetailsVSearchObject.elementType != "") {
            searchString = searchString + 'elementType:' + rmanFcstActualDetailsVSearchObject.elementType + ',';
        }

        if (rmanFcstActualDetailsVSearchObject.netPrice != undefined && rmanFcstActualDetailsVSearchObject.netPrice != "") {
            searchString = searchString + 'netPrice:' + rmanFcstActualDetailsVSearchObject.netPrice + ',';
        }

        if (rmanFcstActualDetailsVSearchObject.expectedBookingAmount != undefined && rmanFcstActualDetailsVSearchObject.expectedBookingAmount != "") {
            searchString = searchString + 'expectedBookingAmount:' + rmanFcstActualDetailsVSearchObject.expectedBookingAmount + ',';
        }

        if (rmanFcstActualDetailsVSearchObject.recordType != undefined && rmanFcstActualDetailsVSearchObject.recordType != "") {
            searchString = searchString + 'recordType:' + rmanFcstActualDetailsVSearchObject.recordType + ',';
        }

        if (rmanFcstActualDetailsVSearchObject.amount != undefined && rmanFcstActualDetailsVSearchObject.amount != "") {
            searchString = searchString + 'amount:' + rmanFcstActualDetailsVSearchObject.amount + ',';
        }

        if (rmanFcstActualDetailsVSearchObject.quarterName != undefined && rmanFcstActualDetailsVSearchObject.quarterName != "") {
            searchString = searchString + 'quarterName:' + rmanFcstActualDetailsVSearchObject.quarterName + ',';
        }

        if (rmanFcstActualDetailsVSearchObject.glPeriod != undefined && rmanFcstActualDetailsVSearchObject.glPeriod != "") {
            searchString = searchString + 'glPeriod:' + rmanFcstActualDetailsVSearchObject.glPeriod + ',';
        }

        if (rmanFcstActualDetailsVSearchObject.startDate != undefined && rmanFcstActualDetailsVSearchObject.startDate != "") {
            searchString = searchString + 'startDate:' + rmanFcstActualDetailsVSearchObject.startDate;
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


    saveRmanFcstActualDetailsV(rmanFcstActualDetailsV: any): Promise<any[]> {
        let body = JSON.stringify(rmanFcstActualDetailsV);
        return this.http.post<any[]>(appSettings.apiUrl + '/RMAN_FCST_ACTUAL_DETAILS_V', body, httpOptions).toPromise().then((data: any) => {
            return data;
        });
    }

    updateRmanFcstActualDetailsV(rmanFcstActualDetailsV: any): Promise<any[]> {

        delete rmanFcstActualDetailsV._links;
        delete rmanFcstActualDetailsV.interests;
        let body = JSON.stringify(rmanFcstActualDetailsV);
        return this.http.put<any[]>(appSettings.apiUrl + '/RMAN_FCST_ACTUAL_DETAILS_V/' + rmanFcstActualDetailsV.arrangementId, body, httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanFcstActualDetailsV(rmanFcstActualDetailsV: any): Promise<any[]> {
        let deleteUrl = appSettings.apiUrl + '/RMAN_FCST_ACTUAL_DETAILS_V/' + rmanFcstActualDetailsV.arrangementId;
        return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
            return data;
        });
    }

}
