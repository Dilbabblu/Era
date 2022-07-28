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
export class RmanReconInvoiceReportVService {

    constructor(private http: HttpClient, private datePipe: DatePipe) { }

    getServiceUrl(paginationOptions: any, rmanReconInvoiceReportVSearchObject: any, exportCols: any, exportFlag?: any) {
        let serviceUrl = appSettings.apiUrl + '/rmanReconInvoiceReportVExport?';

        if (exportFlag == 0) {
            serviceUrl = appSettings.apiUrl + '/rmanReconInvoiceReportVSearch?';
        }
        let searchString = '';

        if (rmanReconInvoiceReportVSearchObject.sno != undefined && rmanReconInvoiceReportVSearchObject.sno != "") {
            searchString = searchString + 'sno:' + rmanReconInvoiceReportVSearchObject.sno + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.dealArrangementId != undefined && rmanReconInvoiceReportVSearchObject.dealArrangementId != "") {
            searchString = searchString + 'dealArrangementId:' + rmanReconInvoiceReportVSearchObject.dealArrangementId + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.legalEntityId != undefined && rmanReconInvoiceReportVSearchObject.legalEntityId != "") {
            searchString = searchString + 'legalEntityId:' + rmanReconInvoiceReportVSearchObject.legalEntityId + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.legalEntityName != undefined && rmanReconInvoiceReportVSearchObject.legalEntityName != "") {
            searchString = searchString + 'legalEntityName:' + rmanReconInvoiceReportVSearchObject.legalEntityName + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.dealArrangementNumber != undefined && rmanReconInvoiceReportVSearchObject.dealArrangementNumber != "") {
            searchString = searchString + 'dealArrangementNumber:' + rmanReconInvoiceReportVSearchObject.dealArrangementNumber + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.dealArrangementName != undefined && rmanReconInvoiceReportVSearchObject.dealArrangementName != "") {
            searchString = searchString + 'dealArrangementName:' + rmanReconInvoiceReportVSearchObject.dealArrangementName + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.dealArrangementBasis != undefined && rmanReconInvoiceReportVSearchObject.dealArrangementBasis != "") {
            searchString = searchString + 'dealArrangementBasis:' + rmanReconInvoiceReportVSearchObject.dealArrangementBasis + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.endCustomerName != undefined && rmanReconInvoiceReportVSearchObject.endCustomerName != "") {
            searchString = searchString + 'endCustomerName:' + rmanReconInvoiceReportVSearchObject.endCustomerName + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.salesNodeLevel1 != undefined && rmanReconInvoiceReportVSearchObject.salesNodeLevel1 != "") {
            searchString = searchString + 'salesNodeLevel1:' + rmanReconInvoiceReportVSearchObject.salesNodeLevel1 + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.salesNodeLevel2 != undefined && rmanReconInvoiceReportVSearchObject.salesNodeLevel2 != "") {
            searchString = searchString + 'salesNodeLevel2:' + rmanReconInvoiceReportVSearchObject.salesNodeLevel2 + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.salesNodeLevel3 != undefined && rmanReconInvoiceReportVSearchObject.salesNodeLevel3 != "") {
            searchString = searchString + 'salesNodeLevel3:' + rmanReconInvoiceReportVSearchObject.salesNodeLevel3 + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.dealHeaderId != undefined && rmanReconInvoiceReportVSearchObject.dealHeaderId != "") {
            searchString = searchString + 'dealHeaderId:' + rmanReconInvoiceReportVSearchObject.dealHeaderId + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.dealNumber != undefined && rmanReconInvoiceReportVSearchObject.dealNumber != "") {
            searchString = searchString + 'dealNumber:' + rmanReconInvoiceReportVSearchObject.dealNumber + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.dealLineNumber != undefined && rmanReconInvoiceReportVSearchObject.dealLineNumber != "") {
            searchString = searchString + 'dealLineNumber:' + rmanReconInvoiceReportVSearchObject.dealLineNumber + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.productName != undefined && rmanReconInvoiceReportVSearchObject.productName != "") {
            searchString = searchString + 'productName:' + rmanReconInvoiceReportVSearchObject.productName + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.productDescription != undefined && rmanReconInvoiceReportVSearchObject.productDescription != "") {
            searchString = searchString + 'productDescription:' + rmanReconInvoiceReportVSearchObject.productDescription + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.itemType != undefined && rmanReconInvoiceReportVSearchObject.itemType != "") {
            searchString = searchString + 'itemType:' + rmanReconInvoiceReportVSearchObject.itemType + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.customerPoNum != undefined && rmanReconInvoiceReportVSearchObject.customerPoNum != "") {
            searchString = searchString + 'customerPoNum:' + rmanReconInvoiceReportVSearchObject.customerPoNum + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.orderNumber != undefined && rmanReconInvoiceReportVSearchObject.orderNumber != "") {
            searchString = searchString + 'orderNumber:' + rmanReconInvoiceReportVSearchObject.orderNumber + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.sourceLineNumber != undefined && rmanReconInvoiceReportVSearchObject.sourceLineNumber != "") {
            searchString = searchString + 'sourceLineNumber:' + rmanReconInvoiceReportVSearchObject.sourceLineNumber + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.orderedDate != undefined && rmanReconInvoiceReportVSearchObject.orderedDate != "") {
            searchString = searchString + 'orderedDate:' + rmanReconInvoiceReportVSearchObject.orderedDate + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.bookedDate != undefined && rmanReconInvoiceReportVSearchObject.bookedDate != "") {
            searchString = searchString + 'bookedDate:' + rmanReconInvoiceReportVSearchObject.bookedDate + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.orderedQuantity != undefined && rmanReconInvoiceReportVSearchObject.orderedQuantity != "") {
            searchString = searchString + 'orderedQuantity:' + rmanReconInvoiceReportVSearchObject.orderedQuantity + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.actualFulfilledDate != undefined && rmanReconInvoiceReportVSearchObject.actualFulfilledDate != "") {
            searchString = searchString + 'actualFulfilledDate:' + rmanReconInvoiceReportVSearchObject.actualFulfilledDate + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.shippedQuantity != undefined && rmanReconInvoiceReportVSearchObject.shippedQuantity != "") {
            searchString = searchString + 'shippedQuantity:' + rmanReconInvoiceReportVSearchObject.shippedQuantity + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.repUnitListPrice != undefined && rmanReconInvoiceReportVSearchObject.repUnitListPrice != "") {
            searchString = searchString + 'repUnitListPrice:' + rmanReconInvoiceReportVSearchObject.repUnitListPrice + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.repUnitSellingPrice != undefined && rmanReconInvoiceReportVSearchObject.repUnitSellingPrice != "") {
            searchString = searchString + 'repUnitSellingPrice:' + rmanReconInvoiceReportVSearchObject.repUnitSellingPrice + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.transactionPrice != undefined && rmanReconInvoiceReportVSearchObject.transactionPrice != "") {
            searchString = searchString + 'transactionPrice:' + rmanReconInvoiceReportVSearchObject.transactionPrice + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.invoiceNumber != undefined && rmanReconInvoiceReportVSearchObject.invoiceNumber != "") {
            searchString = searchString + 'invoiceNumber:' + rmanReconInvoiceReportVSearchObject.invoiceNumber + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.invoiceLineNumber != undefined && rmanReconInvoiceReportVSearchObject.invoiceLineNumber != "") {
            searchString = searchString + 'invoiceLineNumber:' + rmanReconInvoiceReportVSearchObject.invoiceLineNumber + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.invoicedDate != undefined && rmanReconInvoiceReportVSearchObject.invoicedDate != "") {
            searchString = searchString + 'invoicedDate:' + rmanReconInvoiceReportVSearchObject.invoicedDate + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.invoicedQuantity != undefined && rmanReconInvoiceReportVSearchObject.invoicedQuantity != "") {
            searchString = searchString + 'invoicedQuantity:' + rmanReconInvoiceReportVSearchObject.invoicedQuantity + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.invoiceCurrency != undefined && rmanReconInvoiceReportVSearchObject.invoiceCurrency != "") {
            searchString = searchString + 'invoiceCurrency:' + rmanReconInvoiceReportVSearchObject.invoiceCurrency + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.acctdCurrency != undefined && rmanReconInvoiceReportVSearchObject.acctdCurrency != "") {
            searchString = searchString + 'acctdCurrency:' + rmanReconInvoiceReportVSearchObject.acctdCurrency + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.fxRate != undefined && rmanReconInvoiceReportVSearchObject.fxRate != "") {
            searchString = searchString + 'fxRate:' + rmanReconInvoiceReportVSearchObject.fxRate + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.fxDate != undefined && rmanReconInvoiceReportVSearchObject.fxDate != "") {
            searchString = searchString + 'fxDate:' + rmanReconInvoiceReportVSearchObject.fxDate + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.revenueAmount != undefined && rmanReconInvoiceReportVSearchObject.revenueAmount != "") {
            searchString = searchString + 'revenueAmount:' + rmanReconInvoiceReportVSearchObject.revenueAmount + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.acctdRevAmount != undefined && rmanReconInvoiceReportVSearchObject.acctdRevAmount != "") {
            searchString = searchString + 'acctdRevAmount:' + rmanReconInvoiceReportVSearchObject.acctdRevAmount;
        }

        if (rmanReconInvoiceReportVSearchObject.fromArrgId != undefined && rmanReconInvoiceReportVSearchObject.fromArrgId != null) {
            searchString = searchString + 'dealArrangementId>' + rmanReconInvoiceReportVSearchObject.fromArrgId + ',';
        }
        if (rmanReconInvoiceReportVSearchObject.toArrgId != undefined && rmanReconInvoiceReportVSearchObject.toArrgId != null) {
            searchString = searchString + 'dealArrangementId<' + rmanReconInvoiceReportVSearchObject.toArrgId + ',';
        }

        if (rmanReconInvoiceReportVSearchObject.fromPeriod != undefined && rmanReconInvoiceReportVSearchObject.fromPeriod != null) {
            searchString = searchString + 'actualFulfilledDate>' + this.datePipe.transform(rmanReconInvoiceReportVSearchObject.fromPeriod, 'yyyyMMdd') + ',';
        }
        if (rmanReconInvoiceReportVSearchObject.toPeriod != undefined && rmanReconInvoiceReportVSearchObject.toPeriod != null) {
            searchString = searchString + 'actualFulfilledDate<' + this.datePipe.transform(rmanReconInvoiceReportVSearchObject.toPeriod, 'yyyyMMdd') + ',';
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

        if (exportCols != undefined && exportCols != "") {
            serviceUrl = serviceUrl + '&exportCols=' + exportCols;
        }

        return serviceUrl;
    }

    getAllRmanReconInvoiceReportV(paginationOptions: any, rmanReconInvoiceReportVSearchObject: any) {
        let serviceUrl = this.getServiceUrl(paginationOptions, rmanReconInvoiceReportVSearchObject, '', 0);
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }

    searchRmanReconInvoiceReportV(rmanReconInvoiceReportV: any) {
        return this.http.get(appSettings.apiUrl + '/RMAN_RECON_INVOICE_REPORT_V/search/findBySnoAndDealArrangementIdAndLegalEntityIdAndLegalEntityNameAndDealArrangementNumberAndDealArrangementNameAndDealArrangementBasisAndEndCustomerNameAndSalesNodeLevel1AndSalesNodeLevel2AndSalesNodeLevel3AndDealHeaderIdAndDealNumberAndDealLineNumberAndProductNameAndProductDescriptionAndItemTypeAndCustomerPoNumAndOrderNumberAndSourceLineNumberAndOrderedDateAndBookedDateAndOrderedQuantityAndActualFulfilledDateAndShippedQuantityAndRepUnitListPriceAndRepUnitSellingPriceAndTransactionPriceAndInvoiceNumberAndInvoiceLineNumberAndInvoicedDateAndInvoicedQuantityAndInvoiceCurrencyAndAcctdCurrencyAndFxRateAndFxDateAndRevenueAmountAndAcctdRevAmount?sno=' + rmanReconInvoiceReportV.sno + '&dealArrangementId=' + rmanReconInvoiceReportV.dealArrangementId + '&legalEntityId=' + rmanReconInvoiceReportV.legalEntityId + '&legalEntityName=' + rmanReconInvoiceReportV.legalEntityName + '&dealArrangementNumber=' + rmanReconInvoiceReportV.dealArrangementNumber + '&dealArrangementName=' + rmanReconInvoiceReportV.dealArrangementName + '&dealArrangementBasis=' + rmanReconInvoiceReportV.dealArrangementBasis + '&endCustomerName=' + rmanReconInvoiceReportV.endCustomerName + '&salesNodeLevel1=' + rmanReconInvoiceReportV.salesNodeLevel1 + '&salesNodeLevel2=' + rmanReconInvoiceReportV.salesNodeLevel2 + '&salesNodeLevel3=' + rmanReconInvoiceReportV.salesNodeLevel3 + '&dealHeaderId=' + rmanReconInvoiceReportV.dealHeaderId + '&dealNumber=' + rmanReconInvoiceReportV.dealNumber + '&dealLineNumber=' + rmanReconInvoiceReportV.dealLineNumber + '&productName=' + rmanReconInvoiceReportV.productName + '&productDescription=' + rmanReconInvoiceReportV.productDescription + '&itemType=' + rmanReconInvoiceReportV.itemType + '&customerPoNum=' + rmanReconInvoiceReportV.customerPoNum + '&orderNumber=' + rmanReconInvoiceReportV.orderNumber + '&sourceLineNumber=' + rmanReconInvoiceReportV.sourceLineNumber + '&orderedDate=' + rmanReconInvoiceReportV.orderedDate + '&bookedDate=' + rmanReconInvoiceReportV.bookedDate + '&orderedQuantity=' + rmanReconInvoiceReportV.orderedQuantity + '&actualFulfilledDate=' + rmanReconInvoiceReportV.actualFulfilledDate + '&shippedQuantity=' + rmanReconInvoiceReportV.shippedQuantity + '&repUnitListPrice=' + rmanReconInvoiceReportV.repUnitListPrice + '&repUnitSellingPrice=' + rmanReconInvoiceReportV.repUnitSellingPrice + '&transactionPrice=' + rmanReconInvoiceReportV.transactionPrice + '&invoiceNumber=' + rmanReconInvoiceReportV.invoiceNumber + '&invoiceLineNumber=' + rmanReconInvoiceReportV.invoiceLineNumber + '&invoicedDate=' + rmanReconInvoiceReportV.invoicedDate + '&invoicedQuantity=' + rmanReconInvoiceReportV.invoicedQuantity + '&invoiceCurrency=' + rmanReconInvoiceReportV.invoiceCurrency + '&acctdCurrency=' + rmanReconInvoiceReportV.acctdCurrency + '&fxRate=' + rmanReconInvoiceReportV.fxRate + '&fxDate=' + rmanReconInvoiceReportV.fxDate + '&revenueAmount=' + rmanReconInvoiceReportV.revenueAmount + '&acctdRevAmount=' + rmanReconInvoiceReportV.acctdRevAmount).toPromise().then(data => {
            return data;
        });
    }

    saveRmanReconInvoiceReportV(rmanReconInvoiceReportV: any) {
        let body = JSON.stringify(rmanReconInvoiceReportV);

        return this.http.post(appSettings.apiUrl + '/RMAN_RECON_INVOICE_REPORT_V', body, httpOptions).toPromise().then(data => {
            return data;
        });
    }

    updateRmanReconInvoiceReportV(rmanReconInvoiceReportV: any) {

        delete rmanReconInvoiceReportV._links;
        delete rmanReconInvoiceReportV.interests;
        let body = JSON.stringify(rmanReconInvoiceReportV);

        return this.http.put(appSettings.apiUrl + '/RMAN_RECON_INVOICE_REPORT_V/' + rmanReconInvoiceReportV.sno, body, httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanReconInvoiceReportV(rmanReconInvoiceReportV: any) {
        let deleteUrl = appSettings.apiUrl + '/RMAN_RECON_INVOICE_REPORT_V/' + rmanReconInvoiceReportV.sno;

        return this.http.delete(deleteUrl, httpOptions).toPromise().then(data => {
            return data;
        });
    }

}
