import { DatePipe } from '@angular/common';
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
export class RmanDzsGlAccountingVService {

    constructor(private http: HttpClient, private datePipe: DatePipe) { }


    getServiceUrl(paginationOptions: any, rmanDzsGlAccountingVSearchObject: any, exportFlag: any) {

        let serviceUrl = appSettings.apiUrl + '/rmanDzsGlAccountingVExport?';

        if (exportFlag == 0) {
            serviceUrl = appSettings.apiUrl + '/rmanDzsGlAccountingVSearch?';
        }

        let searchString = '';

        if (rmanDzsGlAccountingVSearchObject.dealArrangementId != undefined && rmanDzsGlAccountingVSearchObject.dealArrangementId != "") {
            searchString = searchString + 'dealArrangementId:' + rmanDzsGlAccountingVSearchObject.dealArrangementId + ',';
        }


        if (rmanDzsGlAccountingVSearchObject.rmanInterfaceId != undefined && rmanDzsGlAccountingVSearchObject.rmanInterfaceId != "") {
            searchString = searchString + 'rmanInterfaceId:' + rmanDzsGlAccountingVSearchObject.rmanInterfaceId + ',';
        }

        if (rmanDzsGlAccountingVSearchObject.orderNumber != undefined && rmanDzsGlAccountingVSearchObject.orderNumber != "") {
            searchString = searchString + 'orderNumber:' + rmanDzsGlAccountingVSearchObject.orderNumber + ',';
        }

        if (rmanDzsGlAccountingVSearchObject.sourceLineNumber != undefined && rmanDzsGlAccountingVSearchObject.sourceLineNumber != "") {
            searchString = searchString + 'sourceLineNumber:' + rmanDzsGlAccountingVSearchObject.sourceLineNumber + ',';
        }

        if (rmanDzsGlAccountingVSearchObject.lineStatus != undefined && rmanDzsGlAccountingVSearchObject.lineStatus != "") {
            searchString = searchString + 'lineStatus:' + rmanDzsGlAccountingVSearchObject.lineStatus + ',';
        }

        if (rmanDzsGlAccountingVSearchObject.glDate != undefined && rmanDzsGlAccountingVSearchObject.glDate != "") {
            searchString = searchString + 'glDate:' + rmanDzsGlAccountingVSearchObject.glDate + ',';
        }

        if (rmanDzsGlAccountingVSearchObject.periodName != undefined && rmanDzsGlAccountingVSearchObject.periodName != "") {
            searchString = searchString + 'periodName:' + rmanDzsGlAccountingVSearchObject.periodName + ',';
        }

        if (rmanDzsGlAccountingVSearchObject.drCr != undefined && rmanDzsGlAccountingVSearchObject.drCr != "") {
            searchString = searchString + 'drCr:' + rmanDzsGlAccountingVSearchObject.drCr + ',';
        }

        if (rmanDzsGlAccountingVSearchObject.account != undefined && rmanDzsGlAccountingVSearchObject.account != "") {
            searchString = searchString + 'account:' + rmanDzsGlAccountingVSearchObject.account + ',';
        }

        if (rmanDzsGlAccountingVSearchObject.accountDescription != undefined && rmanDzsGlAccountingVSearchObject.accountDescription != "") {
            searchString = searchString + 'accountDescription:' + rmanDzsGlAccountingVSearchObject.accountDescription + ',';
        }

        if (rmanDzsGlAccountingVSearchObject.currencyCode != undefined && rmanDzsGlAccountingVSearchObject.currencyCode != "") {
            searchString = searchString + 'currencyCode:' + rmanDzsGlAccountingVSearchObject.currencyCode + ',';
        }

        if (rmanDzsGlAccountingVSearchObject.amountTc != undefined && rmanDzsGlAccountingVSearchObject.amountTc != "") {
            searchString = searchString + 'amountTc:' + rmanDzsGlAccountingVSearchObject.amountTc + ',';
        }

        if (rmanDzsGlAccountingVSearchObject.amountFc != undefined && rmanDzsGlAccountingVSearchObject.amountFc != "") {
            searchString = searchString + 'amountFc:' + rmanDzsGlAccountingVSearchObject.amountFc + ',';
        }

        if (rmanDzsGlAccountingVSearchObject.postedFlag != undefined && rmanDzsGlAccountingVSearchObject.postedFlag != "") {
            searchString = searchString + 'postedFlag:' + rmanDzsGlAccountingVSearchObject.postedFlag;
        }

        if (rmanDzsGlAccountingVSearchObject.fromArrgId != undefined && rmanDzsGlAccountingVSearchObject.fromArrgId != "") {
            searchString = searchString + 'dealArrangementId>' + rmanDzsGlAccountingVSearchObject.fromArrgId + ',';
        }

        if (rmanDzsGlAccountingVSearchObject.toArrgId != undefined && rmanDzsGlAccountingVSearchObject.toArrgId != "") {
            searchString = searchString + 'dealArrangementId<' + rmanDzsGlAccountingVSearchObject.toArrgId + ',';
        }


        if (rmanDzsGlAccountingVSearchObject.fromPeriod != undefined && rmanDzsGlAccountingVSearchObject.fromPeriod != null) {
            searchString = searchString + 'glDate>' + this.datePipe.transform(rmanDzsGlAccountingVSearchObject.fromPeriod, 'yyyyMMdd') + ',';
        }

        if (rmanDzsGlAccountingVSearchObject.toPeriod != undefined && rmanDzsGlAccountingVSearchObject.toPeriod != null) {
            searchString = searchString + 'glDate<' + this.datePipe.transform(rmanDzsGlAccountingVSearchObject.toPeriod, 'yyyyMMdd') + ',';
        }

        if (searchString == '') {
            serviceUrl = serviceUrl + 'search=%25';
        }
        else {
            serviceUrl = serviceUrl + 'search=' + searchString;
        }

        if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != "" && !isNaN(paginationOptions.pageNumber)) {
            serviceUrl = serviceUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;
        }

        return serviceUrl;
    }

    getAllRmanDzsGlAccountingV(paginationOptions: any, rmanContReleaseEventsVSearchObject: any): Promise<any[]> {
        let serviceUrl = this.getServiceUrl(paginationOptions, rmanContReleaseEventsVSearchObject, 0);
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }


    saveRmanDzsGlAccountingV(rmanDzsGlAccountingV: any) {
        let body = JSON.stringify(rmanDzsGlAccountingV);

        return this.http.post(appSettings.apiUrl + '/RMAN_GL_ACCOUNTING_V', body, httpOptions).toPromise().then(data => {
            return data;
        });
    }

    updateRmanDzsGlAccountingV(rmanDzsGlAccountingV: any) {

        delete rmanDzsGlAccountingV._links;
        delete rmanDzsGlAccountingV.interests;
        let body = JSON.stringify(rmanDzsGlAccountingV);

        return this.http.put(appSettings.apiUrl + '/RMAN_GL_ACCOUNTING_V/' + rmanDzsGlAccountingV.rmanInterfaceId, body, httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanDzsGlAccountingV(rmanDzsGlAccountingV: any) {
        let deleteUrl = appSettings.apiUrl + '/RMAN_GL_ACCOUNTING_V/' + rmanDzsGlAccountingV.rmanInterfaceId;

        return this.http.delete(deleteUrl, httpOptions).toPromise().then(data => {
            return data;
        });
    }

}
