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
export class RmanReconDealsArggRepService {

    constructor(private http: HttpClient, private datePipe: DatePipe) { }

    getServiceUrl(paginationOptions: any, rmanReconDealsArggRepSearchObject: any, exportFlag?: any) {
        let serviceUrl = appSettings.apiUrl + '/rmanReconDealsArggRepExport?';
        if (exportFlag == 0) {
            serviceUrl = appSettings.apiUrl + '/rmanReconDealsArggRepSearch?';
        }

        let searchString = '';

        if (rmanReconDealsArggRepSearchObject.dealNumber != undefined && rmanReconDealsArggRepSearchObject.dealNumber != "") {
            searchString = searchString + 'dealNumber:' + rmanReconDealsArggRepSearchObject.dealNumber + ',';
        }

        if (rmanReconDealsArggRepSearchObject.dealLineNumber != undefined && rmanReconDealsArggRepSearchObject.dealLineNumber != "") {
            searchString = searchString + 'dealLineNumber:' + rmanReconDealsArggRepSearchObject.dealLineNumber + ',';
        }

        if (rmanReconDealsArggRepSearchObject.so != undefined && rmanReconDealsArggRepSearchObject.so != "") {
            searchString = searchString + 'so:' + rmanReconDealsArggRepSearchObject.so + ',';
        }

        if (rmanReconDealsArggRepSearchObject.sourceLineNumber != undefined && rmanReconDealsArggRepSearchObject.sourceLineNumber != "") {
            searchString = searchString + 'sourceLineNumber:' + rmanReconDealsArggRepSearchObject.sourceLineNumber + ',';
        }

        if (rmanReconDealsArggRepSearchObject.customerName != undefined && rmanReconDealsArggRepSearchObject.customerName != "") {
            searchString = searchString + 'customerName:' + rmanReconDealsArggRepSearchObject.customerName + ',';
        }

        if (rmanReconDealsArggRepSearchObject.creationDate != undefined && rmanReconDealsArggRepSearchObject.creationDate != "") {
            searchString = searchString + 'creationDate:' + rmanReconDealsArggRepSearchObject.creationDate + ',';
        }

        if (rmanReconDealsArggRepSearchObject.arrangementNumber != undefined && rmanReconDealsArggRepSearchObject.arrangementNumber != "") {
            searchString = searchString + 'arrangementNumber:' + rmanReconDealsArggRepSearchObject.arrangementNumber + ',';
        }

        if (rmanReconDealsArggRepSearchObject.arrangementLineNum != undefined && rmanReconDealsArggRepSearchObject.arrangementLineNum != "") {
            searchString = searchString + 'arrangementLineNum:' + rmanReconDealsArggRepSearchObject.arrangementLineNum + ',';
        }

        if (rmanReconDealsArggRepSearchObject.arrangementStatus != undefined && rmanReconDealsArggRepSearchObject.arrangementStatus != "") {
            searchString = searchString + 'arrangementStatus:' + rmanReconDealsArggRepSearchObject.arrangementStatus + ',';
        }

        if (rmanReconDealsArggRepSearchObject.sku != undefined && rmanReconDealsArggRepSearchObject.sku != "") {
            searchString = searchString + 'sku:' + rmanReconDealsArggRepSearchObject.sku + ',';
        }

        if (rmanReconDealsArggRepSearchObject.srcQty != undefined && rmanReconDealsArggRepSearchObject.srcQty != "") {
            searchString = searchString + 'srcQty:' + rmanReconDealsArggRepSearchObject.srcQty + ',';
        }

        if (rmanReconDealsArggRepSearchObject.trgQty != undefined && rmanReconDealsArggRepSearchObject.trgQty != "") {
            searchString = searchString + 'trgQty:' + rmanReconDealsArggRepSearchObject.trgQty + ',';
        }

        if (rmanReconDealsArggRepSearchObject.srcUnitPrice != undefined && rmanReconDealsArggRepSearchObject.srcUnitPrice != "") {
            searchString = searchString + 'srcUnitPrice:' + rmanReconDealsArggRepSearchObject.srcUnitPrice + ',';
        }

        if (rmanReconDealsArggRepSearchObject.trgUnitPrice != undefined && rmanReconDealsArggRepSearchObject.trgUnitPrice != "") {
            searchString = searchString + 'trgUnitPrice:' + rmanReconDealsArggRepSearchObject.trgUnitPrice + ',';
        }

        if (rmanReconDealsArggRepSearchObject.srcAmount != undefined && rmanReconDealsArggRepSearchObject.srcAmount != "") {
            searchString = searchString + 'srcAmount:' + rmanReconDealsArggRepSearchObject.srcAmount + ',';
        }

        if (rmanReconDealsArggRepSearchObject.trgAmount != undefined && rmanReconDealsArggRepSearchObject.trgAmount != "") {
            searchString = searchString + 'trgAmount:' + rmanReconDealsArggRepSearchObject.trgAmount + ',';
        }

        if (rmanReconDealsArggRepSearchObject.currency != undefined && rmanReconDealsArggRepSearchObject.currency != "") {
            searchString = searchString + 'currency:' + rmanReconDealsArggRepSearchObject.currency + ',';
        }

        if (rmanReconDealsArggRepSearchObject.exception != undefined && rmanReconDealsArggRepSearchObject.exception != "") {
            searchString = searchString + 'exception:' + rmanReconDealsArggRepSearchObject.exception;
        }



        if (searchString == '') {
            serviceUrl = serviceUrl + 'search=%25';
        }
        else {
            serviceUrl = serviceUrl + 'search=' + searchString;
        }

        if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != null && !isNaN(paginationOptions.pageNumber) && paginationOptions.pageNumber != 0) {
            serviceUrl = serviceUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;
        }
        return serviceUrl;
    }

    getAllRmanReconDealsArggRep(paginationOptions: any, rmanReconDealsArggRepSearchObject: any) {

        let serviceUrl = this.getServiceUrl(paginationOptions, rmanReconDealsArggRepSearchObject, 0);
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }

    searchRmanReconDealsArggRep(rmanReconDealsArggRep: any) {
        return this.http.get(appSettings.apiUrl + '/RMAN_RECON_DEALS_ARGG_REP/search/findByDealNumberAndDealLineNumberAndSoAndSourceLineNumberAndCustomerNameAndCreationDateAndArrangementNumberAndArrangementLineNumAndArrangementStatusAndSkuAndSrcQtyAndTrgQtyAndSrcUnitPriceAndTrgUnitPriceAndSrcAmountAndTrgAmountAndCurrencyAndException?dealNumber=' + rmanReconDealsArggRep.dealNumber + '&dealLineNumber=' + rmanReconDealsArggRep.dealLineNumber + '&so=' + rmanReconDealsArggRep.so + '&sourceLineNumber=' + rmanReconDealsArggRep.sourceLineNumber + '&customerName=' + rmanReconDealsArggRep.customerName + '&creationDate=' + rmanReconDealsArggRep.creationDate + '&arrangementNumber=' + rmanReconDealsArggRep.arrangementNumber + '&arrangementLineNum=' + rmanReconDealsArggRep.arrangementLineNum + '&arrangementStatus=' + rmanReconDealsArggRep.arrangementStatus + '&sku=' + rmanReconDealsArggRep.sku + '&srcQty=' + rmanReconDealsArggRep.srcQty + '&trgQty=' + rmanReconDealsArggRep.trgQty + '&srcUnitPrice=' + rmanReconDealsArggRep.srcUnitPrice + '&trgUnitPrice=' + rmanReconDealsArggRep.trgUnitPrice + '&srcAmount=' + rmanReconDealsArggRep.srcAmount + '&trgAmount=' + rmanReconDealsArggRep.trgAmount + '&currency=' + rmanReconDealsArggRep.currency + '&exception=' + rmanReconDealsArggRep.exception).toPromise().then(data => {
            return data;
        });
    }

    saveRmanReconDealsArggRep(rmanReconDealsArggRep: any) {
        let body = JSON.stringify(rmanReconDealsArggRep);

        return this.http.post(appSettings.apiUrl + '/RMAN_RECON_DEALS_ARGG_REP', body, httpOptions).toPromise().then(data => {
            return data;
        });
    }

    updateRmanReconDealsArggRep(rmanReconDealsArggRep: any) {

        delete rmanReconDealsArggRep._links;
        delete rmanReconDealsArggRep.interests;
        let body = JSON.stringify(rmanReconDealsArggRep);

        return this.http.put(appSettings.apiUrl + '/RMAN_RECON_DEALS_ARGG_REP/' + rmanReconDealsArggRep.sku, body, httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanReconDealsArggRep(rmanReconDealsArggRep: any) {
        let deleteUrl = appSettings.apiUrl + '/RMAN_RECON_DEALS_ARGG_REP/' + rmanReconDealsArggRep.sku;

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
        let searchUrl = appSettings.apiUrl + '/revmantra/reconReportParams?fromDate=' + this.datePipe.transform(fromDate, 'yyyyMMdd') + '&toDate=' + this.datePipe.transform(toDate, 'yyyyMMdd') + '&legalEntity=' + legalEntity;
        if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != "" && !isNaN(paginationOptions.pageNumber) && paginationOptions.pageNumber != 0) {
            searchUrl = searchUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;
        }
        return this.http.get(searchUrl).toPromise().then((data: any) => {
            return data;
        });
    }

    exportReconDeals(fromDate: any, toDate: any, legalEntity: any, paginationOptions: any, exportCols: any) {
        if (fromDate == undefined) {
            fromDate = '';
        }

        if (toDate == undefined) {
            toDate = '';
        }

        if (legalEntity == undefined) {
            legalEntity = '';
        }

        let serviceUrl = appSettings.apiUrl + '/rmanReconDealsArggRepExport?fromDate=' + this.datePipe.transform(fromDate, 'yyyyMMdd') + '&toDate=' + this.datePipe.transform(toDate, 'yyyyMMdd') + '&legalEntity=' + legalEntity;

        if (exportCols != undefined && exportCols != "") {
            serviceUrl = serviceUrl + '&exportCols=' + exportCols;
        }

        return serviceUrl;

    }


}
