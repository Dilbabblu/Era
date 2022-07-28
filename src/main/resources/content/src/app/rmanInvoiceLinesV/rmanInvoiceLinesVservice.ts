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
export class RmanInvoiceLinesVService {

    constructor(private http: HttpClient) { }


    getServiceUrl(paginationOptions: any, rmanInvoiceLinesVSearchObject: any, exportCols: any, exportFlag?: any) {

        let searchString = '';

        let serviceUrl = appSettings.apiUrl + '/rmanInvoiceLinesVExport?';

        if (exportFlag == 0) {

            serviceUrl = appSettings.apiUrl + '/rmanInvoiceLinesVSearch?';
        }


        if (rmanInvoiceLinesVSearchObject.rmanInvoiceLineId != undefined && rmanInvoiceLinesVSearchObject.rmanInvoiceLineId != "") {
            searchString = searchString + 'rmanInvoiceLineId:' + rmanInvoiceLinesVSearchObject.rmanInvoiceLineId + ',';
        }

        if (rmanInvoiceLinesVSearchObject.sourceInvoiceLineId != undefined && rmanInvoiceLinesVSearchObject.sourceInvoiceLineId != "") {
            searchString = searchString + 'sourceInvoiceLineId:' + rmanInvoiceLinesVSearchObject.sourceInvoiceLineId + ',';
        }

        if (rmanInvoiceLinesVSearchObject.sourceInvoiceId != undefined && rmanInvoiceLinesVSearchObject.sourceInvoiceId != "") {
            searchString = searchString + 'sourceInvoiceId:' + rmanInvoiceLinesVSearchObject.sourceInvoiceId + ',';
        }

        if (rmanInvoiceLinesVSearchObject.invoiceLineNumber != undefined && rmanInvoiceLinesVSearchObject.invoiceLineNumber != "") {
            searchString = searchString + 'invoiceLineNumber:' + rmanInvoiceLinesVSearchObject.invoiceLineNumber + ',';
        }

        if (rmanInvoiceLinesVSearchObject.lineType != undefined && rmanInvoiceLinesVSearchObject.lineType != "") {
            searchString = searchString + 'lineType:' + rmanInvoiceLinesVSearchObject.lineType + ',';
        }

        if (rmanInvoiceLinesVSearchObject.quantity != undefined && rmanInvoiceLinesVSearchObject.quantity != "") {
            searchString = searchString + 'quantity:' + rmanInvoiceLinesVSearchObject.quantity + ',';
        }

        if (rmanInvoiceLinesVSearchObject.salesOrderNumber != undefined && rmanInvoiceLinesVSearchObject.salesOrderNumber != "") {
            searchString = searchString + 'salesOrderNumber:' + rmanInvoiceLinesVSearchObject.salesOrderNumber + ',';
        }

        if (rmanInvoiceLinesVSearchObject.sourceLineNumber != undefined && rmanInvoiceLinesVSearchObject.sourceLineNumber != "") {
            searchString = searchString + 'sourceLineNumber:' + rmanInvoiceLinesVSearchObject.sourceLineNumber + ',';
        }

        if (rmanInvoiceLinesVSearchObject.salesOrderLineId != undefined && rmanInvoiceLinesVSearchObject.salesOrderLineId != "") {
            searchString = searchString + 'salesOrderLineId:' + rmanInvoiceLinesVSearchObject.salesOrderLineId + ',';
        }

        if (rmanInvoiceLinesVSearchObject.revenueAmount != undefined && rmanInvoiceLinesVSearchObject.revenueAmount != "") {
            searchString = searchString + 'revenueAmount:' + rmanInvoiceLinesVSearchObject.revenueAmount + ',';
        }

        if (rmanInvoiceLinesVSearchObject.usdAmount != undefined && rmanInvoiceLinesVSearchObject.usdAmount != "") {
            searchString = searchString + 'usdAmount:' + rmanInvoiceLinesVSearchObject.usdAmount;
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

        if (exportCols != undefined && exportCols != null) {
            serviceUrl = serviceUrl + '&exportCols=' + exportCols;
        }

        return serviceUrl;

    }

    getAllRmanInvoiceLinesV(paginationOptions: any, rmanInvoiceLinesVSearchObject: any, exportCols: any) {
        let serviceUrl = this.getServiceUrl(paginationOptions, rmanInvoiceLinesVSearchObject, exportCols, 0);
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }

    searchRmanInvoiceLinesV(rmanInvoiceLinesV) {
        return this.http.get(appSettings.apiUrl + '/RMAN_INVOICE_LINES_V/search/findByRmanInvoiceLineIdAndSourceInvoiceLineIdAndSourceInvoiceIdAndInvoiceLineNumberAndLineTypeAndQuantityAndSalesOrderNumberAndSourceLineNumberAndSalesOrderLineIdAndRevenueAmountAndUsdAmount?rmanInvoiceLineId=' + rmanInvoiceLinesV.rmanInvoiceLineId + '&sourceInvoiceLineId=' + rmanInvoiceLinesV.sourceInvoiceLineId + '&sourceInvoiceId=' + rmanInvoiceLinesV.sourceInvoiceId + '&invoiceLineNumber=' + rmanInvoiceLinesV.invoiceLineNumber + '&lineType=' + rmanInvoiceLinesV.lineType + '&quantity=' + rmanInvoiceLinesV.quantity + '&salesOrderNumber=' + rmanInvoiceLinesV.salesOrderNumber + '&sourceLineNumber=' + rmanInvoiceLinesV.sourceLineNumber + '&salesOrderLineId=' + rmanInvoiceLinesV.salesOrderLineId + '&revenueAmount=' + rmanInvoiceLinesV.revenueAmount + '&usdAmount=' + rmanInvoiceLinesV.usdAmount).toPromise().then(data => {
            return data;
        });
    }

    saveRmanInvoiceLinesV(rmanInvoiceLinesV) {
        let body = JSON.stringify(rmanInvoiceLinesV);

        return this.http.post(appSettings.apiUrl + '/RMAN_INVOICE_LINES_V', body, httpOptions).toPromise().then(data => {
            return data;
        });
    }

    updateRmanInvoiceLinesV(rmanInvoiceLinesV) {

        delete rmanInvoiceLinesV._links;
        delete rmanInvoiceLinesV.interests;
        let body = JSON.stringify(rmanInvoiceLinesV);

        return this.http.put(appSettings.apiUrl + '/RMAN_INVOICE_LINES_V/' + rmanInvoiceLinesV.sourceInvoiceLineId, body, httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanInvoiceLinesV(rmanInvoiceLinesV) {
        let deleteUrl = appSettings.apiUrl + '/RMAN_INVOICE_LINES_V/' + rmanInvoiceLinesV.sourceInvoiceLineId;

        return this.http.delete(deleteUrl, httpOptions).toPromise().then(data => {
            return data;
        });
    }

}
