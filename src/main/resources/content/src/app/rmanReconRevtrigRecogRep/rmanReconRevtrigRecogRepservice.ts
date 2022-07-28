import { DatePipe } from '@angular/common';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
declare var require: any;
const appSettings = require('../appsettings');


const httpOptions = {
    headers: new HttpHeaders({
        'Content-Type': 'application/json',
    })
}


@Injectable()
export class RmanReconRevtrigRecogRepService {

    constructor(private http: HttpClient, private datePipe: DatePipe) { }

    getServiceUrl(paginationOptions: any, rmanReconRevtrigRecogRepSearchObject: any, exportFlag?: any) {
        let serviceUrl = appSettings.apiUrl + '/rmanReconRevtrigRecogRepExport?';

        let searchString = '';

        if (exportFlag == 0) {
            serviceUrl = appSettings.apiUrl + '/rmanReconRevtrigRecogRepSearch?';
        }

        if (rmanReconRevtrigRecogRepSearchObject.arrangementName != undefined && rmanReconRevtrigRecogRepSearchObject.arrangementName != "") {
            searchString = searchString + 'arrangementName:' + rmanReconRevtrigRecogRepSearchObject.arrangementName + ',';
        }

        if (rmanReconRevtrigRecogRepSearchObject.arrangementNumber != undefined && rmanReconRevtrigRecogRepSearchObject.arrangementNumber != "") {
            searchString = searchString + 'arrangementNumber:' + rmanReconRevtrigRecogRepSearchObject.arrangementNumber + ',';
        }

        if (rmanReconRevtrigRecogRepSearchObject.arrangementLineNumber != undefined && rmanReconRevtrigRecogRepSearchObject.arrangementLineNumber != "") {
            searchString = searchString + 'arrangementLineNumber:' + rmanReconRevtrigRecogRepSearchObject.arrangementLineNumber + ',';
        }

        if (rmanReconRevtrigRecogRepSearchObject.so != undefined && rmanReconRevtrigRecogRepSearchObject.so != "") {
            searchString = searchString + 'so:' + rmanReconRevtrigRecogRepSearchObject.so + ',';
        }

        if (rmanReconRevtrigRecogRepSearchObject.soLineNum != undefined && rmanReconRevtrigRecogRepSearchObject.soLineNum != "") {
            searchString = searchString + 'soLineNum:' + rmanReconRevtrigRecogRepSearchObject.soLineNum + ',';
        }

        if (rmanReconRevtrigRecogRepSearchObject.skuRevTrigger != undefined && rmanReconRevtrigRecogRepSearchObject.skuRevTrigger != "") {
            searchString = searchString + 'skuRevTrigger:' + rmanReconRevtrigRecogRepSearchObject.skuRevTrigger + ',';
        }

        if (rmanReconRevtrigRecogRepSearchObject.eventReceived != undefined && rmanReconRevtrigRecogRepSearchObject.eventReceived != "") {
            searchString = searchString + 'eventReceived:' + rmanReconRevtrigRecogRepSearchObject.eventReceived + ',';
        }

        if (rmanReconRevtrigRecogRepSearchObject.deliveredAmt != undefined && rmanReconRevtrigRecogRepSearchObject.deliveredAmt != "") {
            searchString = searchString + 'deliveredAmt:' + rmanReconRevtrigRecogRepSearchObject.deliveredAmt + ',';
        }

        if (rmanReconRevtrigRecogRepSearchObject.allocAmt != undefined && rmanReconRevtrigRecogRepSearchObject.allocAmt != "") {
            searchString = searchString + 'allocAmt:' + rmanReconRevtrigRecogRepSearchObject.allocAmt + ',';
        }

        if (rmanReconRevtrigRecogRepSearchObject.deferredAmt != undefined && rmanReconRevtrigRecogRepSearchObject.deferredAmt != "") {
            searchString = searchString + 'deferredAmt:' + rmanReconRevtrigRecogRepSearchObject.deferredAmt + ',';
        }

        if (rmanReconRevtrigRecogRepSearchObject.provisionAmt != undefined && rmanReconRevtrigRecogRepSearchObject.provisionAmt != "") {
            searchString = searchString + 'provisionAmt:' + rmanReconRevtrigRecogRepSearchObject.provisionAmt + ',';
        }

        if (rmanReconRevtrigRecogRepSearchObject.recogAmt != undefined && rmanReconRevtrigRecogRepSearchObject.recogAmt != "") {
            searchString = searchString + 'recogAmt:' + rmanReconRevtrigRecogRepSearchObject.recogAmt + ',';
        }

        if (rmanReconRevtrigRecogRepSearchObject.currency != undefined && rmanReconRevtrigRecogRepSearchObject.currency != "") {
            searchString = searchString + 'currency:' + rmanReconRevtrigRecogRepSearchObject.currency + ',';
        }

        if (rmanReconRevtrigRecogRepSearchObject.exception != undefined && rmanReconRevtrigRecogRepSearchObject.exception != "") {
            searchString = searchString + 'exception:' + rmanReconRevtrigRecogRepSearchObject.exception;
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

    getAllRmanReconRevtrigRecogRep(paginationOptions: any, rmanReconRevtrigRecogRepSearchObject: any) {
        let serviceUrl = this.getServiceUrl(paginationOptions, rmanReconRevtrigRecogRepSearchObject, 0);
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }

    searchRmanReconRevtrigRecogRep(rmanReconRevtrigRecogRep: any) {
        return this.http.get(appSettings.apiUrl + '/RMAN_RECON_REVTRIG_RECOG_REP/search/findByArrangementNameAndArrangementNumberAndArrangementLineNumberAndSoAndSoLineNumAndSkuRevTriggerAndEventReceivedAndDeliveredAmtAndAllocAmtAndDeferredAmtAndProvisionAmtAndRecogAmtAndCurrencyAndException?arrangementName=' + rmanReconRevtrigRecogRep.arrangementName + '&arrangementNumber=' + rmanReconRevtrigRecogRep.arrangementNumber + '&arrangementLineNumber=' + rmanReconRevtrigRecogRep.arrangementLineNumber + '&so=' + rmanReconRevtrigRecogRep.so + '&soLineNum=' + rmanReconRevtrigRecogRep.soLineNum + '&skuRevTrigger=' + rmanReconRevtrigRecogRep.skuRevTrigger + '&eventReceived=' + rmanReconRevtrigRecogRep.eventReceived + '&deliveredAmt=' + rmanReconRevtrigRecogRep.deliveredAmt + '&allocAmt=' + rmanReconRevtrigRecogRep.allocAmt + '&deferredAmt=' + rmanReconRevtrigRecogRep.deferredAmt + '&provisionAmt=' + rmanReconRevtrigRecogRep.provisionAmt + '&recogAmt=' + rmanReconRevtrigRecogRep.recogAmt + '&currency=' + rmanReconRevtrigRecogRep.currency + '&exception=' + rmanReconRevtrigRecogRep.exception).toPromise().then(data => {
            return data;
        });
    }

    saveRmanReconRevtrigRecogRep(rmanReconRevtrigRecogRep: any) {
        let body = JSON.stringify(rmanReconRevtrigRecogRep);

        return this.http.post(appSettings.apiUrl + '/RMAN_RECON_REVTRIG_RECOG_REP', body, httpOptions).toPromise().then(data => {
            return data;
        });
    }

    updateRmanReconRevtrigRecogRep(rmanReconRevtrigRecogRep: any) {

        delete rmanReconRevtrigRecogRep._links;
        delete rmanReconRevtrigRecogRep.interests;
        let body = JSON.stringify(rmanReconRevtrigRecogRep);

        return this.http.put(appSettings.apiUrl + '/RMAN_RECON_REVTRIG_RECOG_REP/' + rmanReconRevtrigRecogRep.arrangementNumber, body, httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanReconRevtrigRecogRep(rmanReconRevtrigRecogRep: any) {
        let deleteUrl = appSettings.apiUrl + '/RMAN_RECON_REVTRIG_RECOG_REP/' + rmanReconRevtrigRecogRep.arrangementNumber;

        return this.http.delete(deleteUrl, httpOptions).toPromise().then(data => {
            return data;
        });
    }

    searchFields(fromDate: any, toDate: any, legalEntity: any, paginationOptions: any) {
        if (fromDate == undefined) {
            fromDate = '';
        }

        if (toDate == undefined) {
            toDate = '';
        }

        if (legalEntity == undefined) {
            legalEntity = '';
        }
        let searchUrl = appSettings.apiUrl + '/revmantra/reconRevTrigRecognizeParams?fromDate=' + this.datePipe.transform(fromDate, 'yyyyMMdd') + '&toDate=' + this.datePipe.transform(toDate, 'yyyyMMdd') + '&legalEntity=' + legalEntity;
        if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != "" && !isNaN(paginationOptions.pageNumber) && paginationOptions.pageNumber != 0) {
            searchUrl = searchUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;
        }
        return this.http.get(searchUrl).toPromise().then((data: any) => {
            return data;
        });
    }

    exportReconRevTrigReport(fromDate: any, toDate: any, legalEntity: any, paginationOptions: any, exportCols: any) {
        if (fromDate == undefined) {
            fromDate = '';
        }

        if (toDate == undefined) {
            toDate = '';
        }

        if (legalEntity == undefined) {
            legalEntity = '';
        }
        let serviceUrl = appSettings.apiUrl + '/rmanReconRevtrigRecogRepExport?fromDate=' + this.datePipe.transform(fromDate, 'yyyyMMdd') + '&toDate=' + this.datePipe.transform(toDate, 'yyyyMMdd') + '&legalEntity=' + legalEntity;
        if (exportCols != undefined && exportCols != "") {
            serviceUrl = serviceUrl + '&exportCols=' + exportCols;
        }

        return serviceUrl;
    }



}
