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
export class RmanDealRfcstVService {

    constructor(private http: HttpClient) { }

    getServiceUrl(paginationOptions: any, rmanDealRfcstVSearchObject: any, exportFlag: any) {

        let serviceUrl = appSettings.apiUrl + '/rmanDealRfcstVExport?';

        if (exportFlag == 0) {
            serviceUrl = appSettings.apiUrl + '/rmanDealRfcstVSearch?';
        }

        let searchString = '';

        if (rmanDealRfcstVSearchObject.arrangementId != undefined && rmanDealRfcstVSearchObject.arrangementId != "") {
            searchString = searchString + 'arrangementId:' + rmanDealRfcstVSearchObject.arrangementId + ',';
        }

        if (rmanDealRfcstVSearchObject.arrangementName != undefined && rmanDealRfcstVSearchObject.arrangementName != "") {
            searchString = searchString + 'arrangementName:' + rmanDealRfcstVSearchObject.arrangementName + ',';
        }

        if (rmanDealRfcstVSearchObject.sku != undefined && rmanDealRfcstVSearchObject.sku != "") {
            searchString = searchString + 'sku:' + rmanDealRfcstVSearchObject.sku + ',';
        }

        if (rmanDealRfcstVSearchObject.qty != undefined && rmanDealRfcstVSearchObject.qty != "") {
            searchString = searchString + 'qty:' + rmanDealRfcstVSearchObject.qty + ',';
        }

        if (rmanDealRfcstVSearchObject.elementType != undefined && rmanDealRfcstVSearchObject.elementType != "") {
            searchString = searchString + 'elementType:' + rmanDealRfcstVSearchObject.elementType + ',';
        }

        if (rmanDealRfcstVSearchObject.netPrice != undefined && rmanDealRfcstVSearchObject.netPrice != "") {
            searchString = searchString + 'netPrice:' + rmanDealRfcstVSearchObject.netPrice + ',';
        }

        if (rmanDealRfcstVSearchObject.expectedBookingAmount != undefined && rmanDealRfcstVSearchObject.expectedBookingAmount != "") {
            searchString = searchString + 'expectedBookingAmount:' + rmanDealRfcstVSearchObject.expectedBookingAmount + ',';
        }

        if (rmanDealRfcstVSearchObject.amount != undefined && rmanDealRfcstVSearchObject.amount != "") {
            searchString = searchString + 'amount:' + rmanDealRfcstVSearchObject.amount + ',';
        }

        if (rmanDealRfcstVSearchObject.glPeriod != undefined && rmanDealRfcstVSearchObject.glPeriod != "") {
            searchString = searchString + 'glPeriod:' + rmanDealRfcstVSearchObject.glPeriod + ',';
        }

        if (rmanDealRfcstVSearchObject.startDate != undefined && rmanDealRfcstVSearchObject.startDate != "") {
            searchString = searchString + 'startDate:' + rmanDealRfcstVSearchObject.startDate;
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

        return serviceUrl;
    }

    getAllRmanDealRfcstV(paginationOptions: any, rmanDealRfcstVSearchObject: any): Promise<any[]> {
        let serviceUrl = this.getServiceUrl(paginationOptions, rmanDealRfcstVSearchObject, 0);
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }



    saveRmanDealRfcstV(rmanDealRfcstV: any) {
        let body = JSON.stringify(rmanDealRfcstV);

        return this.http.post(appSettings.apiUrl + '/RMAN_DEAL_RFCST_V', body, httpOptions).toPromise().then(data => {
            return data;
        });
    }

    updateRmanDealRfcstV(rmanDealRfcstV: any) {

        delete rmanDealRfcstV._links;
        delete rmanDealRfcstV.interests;
        let body = JSON.stringify(rmanDealRfcstV);

        return this.http.put(appSettings.apiUrl + '/RMAN_DEAL_RFCST_V/' + rmanDealRfcstV.arrangementId, body, httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanDealRfcstV(rmanDealRfcstV: any) {
        let deleteUrl = appSettings.apiUrl + '/RMAN_DEAL_RFCST_V/' + rmanDealRfcstV.arrangementId;

        return this.http.delete(deleteUrl, httpOptions).toPromise().then(data => {
            return data;
        });
    }

    getRmanForecastView(pArrgId: any) {

        if (pArrgId == undefined) {
            pArrgId = 0;
        }

        let serviceUrl = appSettings.apiUrl + '/revmantra/rfcstView?arrgId=' + pArrgId;
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });

    }
}
