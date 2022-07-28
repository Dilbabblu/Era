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
export class RmanReconSosrcToBkingsRepService {

    constructor(private http: HttpClient, private datePipe: DatePipe) { }

    getServiceUrl(paginationOptions: any, rmanReconSosrcToBkingsRepSearchObject: any, exportFlag?: any) {
        let serviceUrl = appSettings.apiUrl + '/rmanReconSosrcToBkingsRepExport?';
        if (exportFlag == 0) {
            serviceUrl = appSettings.apiUrl + '/rmanReconSosrcToBkingsRepSearch?';
        }

        let searchString = '';
        if (rmanReconSosrcToBkingsRepSearchObject.so != undefined && rmanReconSosrcToBkingsRepSearchObject.so != "") {
            searchString = searchString + 'so:' + rmanReconSosrcToBkingsRepSearchObject.so + ',';
        }

        if (rmanReconSosrcToBkingsRepSearchObject.sourceLineNumber != undefined && rmanReconSosrcToBkingsRepSearchObject.sourceLineNumber != "") {
            searchString = searchString + 'sourceLineNumber:' + rmanReconSosrcToBkingsRepSearchObject.sourceLineNumber + ',';
        }

        if (rmanReconSosrcToBkingsRepSearchObject.bookingEntityName != undefined && rmanReconSosrcToBkingsRepSearchObject.bookingEntityName != "") {
            searchString = searchString + 'bookingEntityName:' + rmanReconSosrcToBkingsRepSearchObject.bookingEntityName + ',';
        }

        if (rmanReconSosrcToBkingsRepSearchObject.bookedDate != undefined && rmanReconSosrcToBkingsRepSearchObject.bookedDate != "") {
            searchString = searchString + 'bookedDate:' + rmanReconSosrcToBkingsRepSearchObject.bookedDate + ',';
        }

        if (rmanReconSosrcToBkingsRepSearchObject.endCustomer != undefined && rmanReconSosrcToBkingsRepSearchObject.endCustomer != "") {
            searchString = searchString + 'endCustomer:' + rmanReconSosrcToBkingsRepSearchObject.endCustomer + ',';
        }

        if (rmanReconSosrcToBkingsRepSearchObject.arrangementNumber != undefined && rmanReconSosrcToBkingsRepSearchObject.arrangementNumber != "") {
            searchString = searchString + 'arrangementNumber:' + rmanReconSosrcToBkingsRepSearchObject.arrangementNumber + ',';
        }

        if (rmanReconSosrcToBkingsRepSearchObject.arrangementLineNum != undefined && rmanReconSosrcToBkingsRepSearchObject.arrangementLineNum != "") {
            searchString = searchString + 'arrangementLineNum:' + rmanReconSosrcToBkingsRepSearchObject.arrangementLineNum + ',';
        }

        if (rmanReconSosrcToBkingsRepSearchObject.sku != undefined && rmanReconSosrcToBkingsRepSearchObject.sku != "") {
            searchString = searchString + 'sku:' + rmanReconSosrcToBkingsRepSearchObject.sku + ',';
        }

        if (rmanReconSosrcToBkingsRepSearchObject.srcQty != undefined && rmanReconSosrcToBkingsRepSearchObject.srcQty != "") {
            searchString = searchString + 'srcQty:' + rmanReconSosrcToBkingsRepSearchObject.srcQty + ',';
        }

        if (rmanReconSosrcToBkingsRepSearchObject.trgQty != undefined && rmanReconSosrcToBkingsRepSearchObject.trgQty != "") {
            searchString = searchString + 'trgQty:' + rmanReconSosrcToBkingsRepSearchObject.trgQty + ',';
        }

        if (rmanReconSosrcToBkingsRepSearchObject.srcUnitPrice != undefined && rmanReconSosrcToBkingsRepSearchObject.srcUnitPrice != "") {
            searchString = searchString + 'srcUnitPrice:' + rmanReconSosrcToBkingsRepSearchObject.srcUnitPrice + ',';
        }

        if (rmanReconSosrcToBkingsRepSearchObject.trgUnitPrice != undefined && rmanReconSosrcToBkingsRepSearchObject.trgUnitPrice != "") {
            searchString = searchString + 'trgUnitPrice:' + rmanReconSosrcToBkingsRepSearchObject.trgUnitPrice + ',';
        }

        if (rmanReconSosrcToBkingsRepSearchObject.srcAmount != undefined && rmanReconSosrcToBkingsRepSearchObject.srcAmount != "") {
            searchString = searchString + 'srcAmount:' + rmanReconSosrcToBkingsRepSearchObject.srcAmount + ',';
        }

        if (rmanReconSosrcToBkingsRepSearchObject.trgAmount != undefined && rmanReconSosrcToBkingsRepSearchObject.trgAmount != "") {
            searchString = searchString + 'trgAmount:' + rmanReconSosrcToBkingsRepSearchObject.trgAmount + ',';
        }

        if (rmanReconSosrcToBkingsRepSearchObject.exception != undefined && rmanReconSosrcToBkingsRepSearchObject.exception != "") {
            searchString = searchString + 'exception:' + rmanReconSosrcToBkingsRepSearchObject.exception;
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

    getAllRmanReconSosrcToBkingsRep(paginationOptions: any, rmanReconSosrcToBkingsRepSearchObject: any) {
        let serviceUrl = this.getServiceUrl(paginationOptions, rmanReconSosrcToBkingsRepSearchObject, 0);
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }

    searchRmanReconSosrcToBkingsRep(rmanReconSosrcToBkingsRep: any) {
        return this.http.get(appSettings.apiUrl + '/RMAN_RECON_SOSRC_TO_BKINGS_REP/search/findBySoAndSourceLineNumberAndBookingEntityNameAndBookedDateAndEndCustomerAndArrangementNumberAndArrangementLineNumAndSkuAndSrcQtyAndTrgQtyAndSrcUnitPriceAndTrgUnitPriceAndSrcAmountAndTrgAmountAndException?so=' + rmanReconSosrcToBkingsRep.so + '&sourceLineNumber=' + rmanReconSosrcToBkingsRep.sourceLineNumber + '&bookingEntityName=' + rmanReconSosrcToBkingsRep.bookingEntityName + '&bookedDate=' + rmanReconSosrcToBkingsRep.bookedDate + '&endCustomer=' + rmanReconSosrcToBkingsRep.endCustomer + '&arrangementNumber=' + rmanReconSosrcToBkingsRep.arrangementNumber + '&arrangementLineNum=' + rmanReconSosrcToBkingsRep.arrangementLineNum + '&sku=' + rmanReconSosrcToBkingsRep.sku + '&srcQty=' + rmanReconSosrcToBkingsRep.srcQty + '&trgQty=' + rmanReconSosrcToBkingsRep.trgQty + '&srcUnitPrice=' + rmanReconSosrcToBkingsRep.srcUnitPrice + '&trgUnitPrice=' + rmanReconSosrcToBkingsRep.trgUnitPrice + '&srcAmount=' + rmanReconSosrcToBkingsRep.srcAmount + '&trgAmount=' + rmanReconSosrcToBkingsRep.trgAmount + '&exception=' + rmanReconSosrcToBkingsRep.exception).toPromise().then(data => {
            return data;
        });
    }

    saveRmanReconSosrcToBkingsRep(rmanReconSosrcToBkingsRep: any) {
        let body = JSON.stringify(rmanReconSosrcToBkingsRep);

        return this.http.post(appSettings.apiUrl + '/RMAN_RECON_SOSRC_TO_BKINGS_REP', body, httpOptions).toPromise().then(data => {
            return data;
        });
    }

    updateRmanReconSosrcToBkingsRep(rmanReconSosrcToBkingsRep: any) {

        delete rmanReconSosrcToBkingsRep._links;
        delete rmanReconSosrcToBkingsRep.interests;
        let body = JSON.stringify(rmanReconSosrcToBkingsRep);

        return this.http.put(appSettings.apiUrl + '/RMAN_RECON_SOSRC_TO_BKINGS_REP/' + rmanReconSosrcToBkingsRep.arrangementNumber, body, httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanReconSosrcToBkingsRep(rmanReconSosrcToBkingsRep: any) {
        let deleteUrl = appSettings.apiUrl + '/RMAN_RECON_SOSRC_TO_BKINGS_REP/' + rmanReconSosrcToBkingsRep.arrangementNumber;

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
        let searchUrl = appSettings.apiUrl + '/revmantra/reconSoSrcToBkingsParams?fromDate=' + this.datePipe.transform(fromDate, 'yyyyMMdd') + '&toDate=' + this.datePipe.transform(toDate, 'yyyyMMdd') + '&legalEntity=' + legalEntity;
        if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != "" && !isNaN(paginationOptions.pageNumber) && paginationOptions.pageNumber != 0) {
            searchUrl = searchUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;
        }
        return this.http.get(searchUrl).toPromise().then((data: any) => {
            return data;
        });
    }

    exportReconsrcBkings(fromDate: any, toDate: any, legalEntity: any, paginationOptions: any, exportCols: any) {
        if (fromDate == undefined) {
            fromDate = '';
        }

        if (toDate == undefined) {
            toDate = '';
        }

        if (legalEntity == undefined) {
            legalEntity = '';
        }
        let serviceUrl = appSettings.apiUrl + '/rmanReconSosrcToBkingsRepExport?fromDate=' + this.datePipe.transform(fromDate, 'yyyyMMdd') + '&toDate=' + this.datePipe.transform(toDate, 'yyyyMMdd') + '&legalEntity=' + legalEntity;

        if (exportCols != undefined && exportCols != "") {
            serviceUrl = serviceUrl + '&exportCols=' + exportCols;
        }
        return serviceUrl;
    }

}
