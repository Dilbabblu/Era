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
export class RmanInvoiceHeadersVService {

    constructor(private http: HttpClient) { }

    getServiceUrl(paginationOptions: any,rmanInvoiceHeadersVSearchObject: any,exportCols: any, exportFlag?: any) {
        let searchString='';

        let serviceUrl = appSettings.apiUrl + '/rmanInvoiceHeadersVExport?';
        if (exportFlag == 0) {
            serviceUrl = appSettings.apiUrl + '/rmanInvoiceHeadersVSearch?';
        }

        if (rmanInvoiceHeadersVSearchObject.sourceInvoiceId != undefined && rmanInvoiceHeadersVSearchObject.sourceInvoiceId != "") {
            searchString = searchString + 'sourceInvoiceId:' + rmanInvoiceHeadersVSearchObject.sourceInvoiceId + ',';
        }

        if (rmanInvoiceHeadersVSearchObject.invoiceNumber != undefined && rmanInvoiceHeadersVSearchObject.invoiceNumber != "") {
            searchString = searchString + 'invoiceNumber:' + rmanInvoiceHeadersVSearchObject.invoiceNumber + ',';
        }

        if (rmanInvoiceHeadersVSearchObject.invoicedDate != undefined && rmanInvoiceHeadersVSearchObject.invoicedDate != "") {
            searchString = searchString + 'invoicedDate:' + rmanInvoiceHeadersVSearchObject.invoicedDate + ',';
        }

        if (rmanInvoiceHeadersVSearchObject.invoiceType != undefined && rmanInvoiceHeadersVSearchObject.invoiceType != "") {
            searchString = searchString + 'invoiceType:' + rmanInvoiceHeadersVSearchObject.invoiceType + ',';
        }

        if (rmanInvoiceHeadersVSearchObject.invoiceTrxType != undefined && rmanInvoiceHeadersVSearchObject.invoiceTrxType != "") {
            searchString = searchString + 'invoiceTrxType:' + rmanInvoiceHeadersVSearchObject.invoiceTrxType + ',';
        }

        if (rmanInvoiceHeadersVSearchObject.fxRate != undefined && rmanInvoiceHeadersVSearchObject.fxRate != "") {
            searchString = searchString + 'fxRate:' + rmanInvoiceHeadersVSearchObject.fxRate + ',';
        }

        if (rmanInvoiceHeadersVSearchObject.fxDate != undefined && rmanInvoiceHeadersVSearchObject.fxDate != "") {
            searchString = searchString + 'fxDate:' + rmanInvoiceHeadersVSearchObject.fxDate + ',';
        }

        if (rmanInvoiceHeadersVSearchObject.invoiceCurrency != undefined && rmanInvoiceHeadersVSearchObject.invoiceCurrency != "") {
            searchString = searchString + 'invoiceCurrency:' + rmanInvoiceHeadersVSearchObject.invoiceCurrency + ',';
        }

        if (rmanInvoiceHeadersVSearchObject.salesOrderNumber != undefined && rmanInvoiceHeadersVSearchObject.salesOrderNumber != "") {
            searchString = searchString + 'salesOrderNumber:' + rmanInvoiceHeadersVSearchObject.salesOrderNumber + ',';
        }

        if (rmanInvoiceHeadersVSearchObject.invoiceSource != undefined && rmanInvoiceHeadersVSearchObject.invoiceSource != "") {
            searchString = searchString + 'invoiceSource:' + rmanInvoiceHeadersVSearchObject.invoiceSource + ',';
        }

        if (rmanInvoiceHeadersVSearchObject.arrangementId != undefined && rmanInvoiceHeadersVSearchObject.arrangementId != "") {
            searchString = searchString + 'arrangementId:' + rmanInvoiceHeadersVSearchObject.arrangementId + ',';
        }

        if (rmanInvoiceHeadersVSearchObject.invoiceAmount != undefined && rmanInvoiceHeadersVSearchObject.invoiceAmount != "") {
            searchString = searchString + 'invoiceAmount:' + rmanInvoiceHeadersVSearchObject.invoiceAmount;
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
          
        if(exportCols !=undefined && exportCols!=null){
            serviceUrl = serviceUrl+'&exportCols='+exportCols;
        }
      
            return serviceUrl;
      
    }

    getAllRmanInvoiceHeadersV(paginationOptions: any,rmanInvoiceHeadersVSearchObject: any, exportCols: any) {
        //console.log(paginationOptions);

        let serviceUrl = this.getServiceUrl(paginationOptions, rmanInvoiceHeadersVSearchObject,exportCols, 0);
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
          return data;
        });
    }



    searchRmanInvoiceHeadersV(rmanInvoiceHeadersV) {
        return this.http.get(appSettings.apiUrl + '/RMAN_INVOICE_HEADERS_V/search/findBySourceInvoiceIdAndInvoiceNumberAndInvoicedDateAndInvoiceTypeAndInvoiceTrxTypeAndFxRateAndFxDateAndInvoiceCurrencyAndSalesOrderNumberAndInvoiceSourceAndArrangementIdAndInvoiceAmount?sourceInvoiceId=' + rmanInvoiceHeadersV.sourceInvoiceId + '&invoiceNumber=' + rmanInvoiceHeadersV.invoiceNumber + '&invoicedDate=' + rmanInvoiceHeadersV.invoicedDate + '&invoiceType=' + rmanInvoiceHeadersV.invoiceType + '&invoiceTrxType=' + rmanInvoiceHeadersV.invoiceTrxType + '&fxRate=' + rmanInvoiceHeadersV.fxRate + '&fxDate=' + rmanInvoiceHeadersV.fxDate + '&invoiceCurrency=' + rmanInvoiceHeadersV.invoiceCurrency + '&salesOrderNumber=' + rmanInvoiceHeadersV.salesOrderNumber + '&invoiceSource=' + rmanInvoiceHeadersV.invoiceSource + '&arrangementId=' + rmanInvoiceHeadersV.arrangementId + '&invoiceAmount=' + rmanInvoiceHeadersV.invoiceAmount).toPromise().then(data => {
            ////console.log(data);
            return data;
        });
    }

    saveRmanInvoiceHeadersV(rmanInvoiceHeadersV) {
        let body = JSON.stringify(rmanInvoiceHeadersV);
        return this.http.post(appSettings.apiUrl + '/RMAN_INVOICE_HEADERS_V', body, httpOptions).toPromise().then(data => {
            return data;
        });
    }

    updateRmanInvoiceHeadersV(rmanInvoiceHeadersV) {

        delete rmanInvoiceHeadersV._links;
        delete rmanInvoiceHeadersV.interests;
        let body = JSON.stringify(rmanInvoiceHeadersV);

        return this.http.put(appSettings.apiUrl + '/RMAN_INVOICE_HEADERS_V/' + rmanInvoiceHeadersV.sourceInvoiceId, body, httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanInvoiceHeadersV(rmanInvoiceHeadersV) {
        let deleteUrl = appSettings.apiUrl + '/RMAN_INVOICE_HEADERS_V/' + rmanInvoiceHeadersV.sourceInvoiceId;

        return this.http.delete(deleteUrl, httpOptions).toPromise().then(data => {
            return data;
        });
    }

}
