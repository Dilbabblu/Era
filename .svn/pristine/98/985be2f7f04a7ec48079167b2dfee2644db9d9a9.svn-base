import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
declare var require: any;
const appSettings = require('../appsettings');

@Injectable()
export class RmanDefRollforwardReportVService {

    constructor(private http: HttpClient) { }

    getAllRmanDefRollforwardReportV(paginationOptions: any, rmanDefRollforwardReportVSearchObject: any): Promise<any[]> {

        let serviceUrl = appSettings.apiUrl + '/rmanDefRollforwardReportVSearch?';

        let searchString = '';

        if (rmanDefRollforwardReportVSearchObject.periodDetail != undefined && rmanDefRollforwardReportVSearchObject.periodDetail != "") {
            searchString = searchString + 'periodDetail:' + rmanDefRollforwardReportVSearchObject.periodDetail + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.dealArrangementId != undefined && rmanDefRollforwardReportVSearchObject.dealArrangementId != "") {
            searchString = searchString + 'dealArrangementId:' + rmanDefRollforwardReportVSearchObject.dealArrangementId + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.dealArrangementNumber != undefined && rmanDefRollforwardReportVSearchObject.dealArrangementNumber != "") {
            searchString = searchString + 'dealArrangementNumber:' + rmanDefRollforwardReportVSearchObject.dealArrangementNumber + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.dealArrangementName != undefined && rmanDefRollforwardReportVSearchObject.dealArrangementName != "") {
            searchString = searchString + 'dealArrangementName:' + rmanDefRollforwardReportVSearchObject.dealArrangementName + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.dealArrangementBasis != undefined && rmanDefRollforwardReportVSearchObject.dealArrangementBasis != "") {
            searchString = searchString + 'dealArrangementBasis:' + rmanDefRollforwardReportVSearchObject.dealArrangementBasis + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.dealArrangementStatus != undefined && rmanDefRollforwardReportVSearchObject.dealArrangementStatus != "") {
            searchString = searchString + 'dealArrangementStatus:' + rmanDefRollforwardReportVSearchObject.dealArrangementStatus + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.legalEntityName != undefined && rmanDefRollforwardReportVSearchObject.legalEntityName != "") {
            searchString = searchString + 'legalEntityName:' + rmanDefRollforwardReportVSearchObject.legalEntityName + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.dealArrangementSource != undefined && rmanDefRollforwardReportVSearchObject.dealArrangementSource != "") {
            searchString = searchString + 'dealArrangementSource:' + rmanDefRollforwardReportVSearchObject.dealArrangementSource + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.customerPoNum != undefined && rmanDefRollforwardReportVSearchObject.customerPoNum != "") {
            searchString = searchString + 'customerPoNum:' + rmanDefRollforwardReportVSearchObject.customerPoNum + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.dealName != undefined && rmanDefRollforwardReportVSearchObject.dealName != "") {
            searchString = searchString + 'dealName:' + rmanDefRollforwardReportVSearchObject.dealName + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.dealNumber != undefined && rmanDefRollforwardReportVSearchObject.dealNumber != "") {
            searchString = searchString + 'dealNumber:' + rmanDefRollforwardReportVSearchObject.dealNumber + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.dealLineNumber != undefined && rmanDefRollforwardReportVSearchObject.dealLineNumber != "") {
            searchString = searchString + 'dealLineNumber:' + rmanDefRollforwardReportVSearchObject.dealLineNumber + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.sourceHeaderId != undefined && rmanDefRollforwardReportVSearchObject.sourceHeaderId != "") {
            searchString = searchString + 'sourceHeaderId:' + rmanDefRollforwardReportVSearchObject.sourceHeaderId + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.orderNumber != undefined && rmanDefRollforwardReportVSearchObject.orderNumber != "") {
            searchString = searchString + 'orderNumber:' + rmanDefRollforwardReportVSearchObject.orderNumber + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.sourceLineId != undefined && rmanDefRollforwardReportVSearchObject.sourceLineId != "") {
            searchString = searchString + 'sourceLineId:' + rmanDefRollforwardReportVSearchObject.sourceLineId + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.sourceLineNumber != undefined && rmanDefRollforwardReportVSearchObject.sourceLineNumber != "") {
            searchString = searchString + 'sourceLineNumber:' + rmanDefRollforwardReportVSearchObject.sourceLineNumber + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.productName != undefined && rmanDefRollforwardReportVSearchObject.productName != "") {
            searchString = searchString + 'productName:' + rmanDefRollforwardReportVSearchObject.productName + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.orderedQuantity != undefined && rmanDefRollforwardReportVSearchObject.orderedQuantity != "") {
            searchString = searchString + 'orderedQuantity:' + rmanDefRollforwardReportVSearchObject.orderedQuantity + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.uom != undefined && rmanDefRollforwardReportVSearchObject.uom != "") {
            searchString = searchString + 'uom:' + rmanDefRollforwardReportVSearchObject.uom + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.transactionCurrency != undefined && rmanDefRollforwardReportVSearchObject.transactionCurrency != "") {
            searchString = searchString + 'transactionCurrency:' + rmanDefRollforwardReportVSearchObject.transactionCurrency + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.unitListPrice != undefined && rmanDefRollforwardReportVSearchObject.unitListPrice != "") {
            searchString = searchString + 'unitListPrice:' + rmanDefRollforwardReportVSearchObject.unitListPrice + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.unitNetPrice != undefined && rmanDefRollforwardReportVSearchObject.unitNetPrice != "") {
            searchString = searchString + 'unitNetPrice:' + rmanDefRollforwardReportVSearchObject.unitNetPrice + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.lineAmount != undefined && rmanDefRollforwardReportVSearchObject.lineAmount != "") {
            searchString = searchString + 'lineAmount:' + rmanDefRollforwardReportVSearchObject.lineAmount + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.discountPercent != undefined && rmanDefRollforwardReportVSearchObject.discountPercent != "") {
            searchString = searchString + 'discountPercent:' + rmanDefRollforwardReportVSearchObject.discountPercent + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.productPortfolio != undefined && rmanDefRollforwardReportVSearchObject.productPortfolio != "") {
            searchString = searchString + 'productPortfolio:' + rmanDefRollforwardReportVSearchObject.productPortfolio + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.productLine != undefined && rmanDefRollforwardReportVSearchObject.productLine != "") {
            searchString = searchString + 'productLine:' + rmanDefRollforwardReportVSearchObject.productLine + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.productFamily != undefined && rmanDefRollforwardReportVSearchObject.productFamily != "") {
            searchString = searchString + 'productFamily:' + rmanDefRollforwardReportVSearchObject.productFamily + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.shipToCustomer != undefined && rmanDefRollforwardReportVSearchObject.shipToCustomer != "") {
            searchString = searchString + 'shipToCustomer:' + rmanDefRollforwardReportVSearchObject.shipToCustomer + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.shipToCustomerNumber != undefined && rmanDefRollforwardReportVSearchObject.shipToCustomerNumber != "") {
            searchString = searchString + 'shipToCustomerNumber:' + rmanDefRollforwardReportVSearchObject.shipToCustomerNumber + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.billToCustomer != undefined && rmanDefRollforwardReportVSearchObject.billToCustomer != "") {
            searchString = searchString + 'billToCustomer:' + rmanDefRollforwardReportVSearchObject.billToCustomer + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.billToCustomerNumber != undefined && rmanDefRollforwardReportVSearchObject.billToCustomerNumber != "") {
            searchString = searchString + 'billToCustomerNumber:' + rmanDefRollforwardReportVSearchObject.billToCustomerNumber + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.salesTheater != undefined && rmanDefRollforwardReportVSearchObject.salesTheater != "") {
            searchString = searchString + 'salesTheater:' + rmanDefRollforwardReportVSearchObject.salesTheater + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.salesRegion != undefined && rmanDefRollforwardReportVSearchObject.salesRegion != "") {
            searchString = searchString + 'salesRegion:' + rmanDefRollforwardReportVSearchObject.salesRegion + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.salesTeritory != undefined && rmanDefRollforwardReportVSearchObject.salesTeritory != "") {
            searchString = searchString + 'salesTeritory:' + rmanDefRollforwardReportVSearchObject.salesTeritory + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.lineCost != undefined && rmanDefRollforwardReportVSearchObject.lineCost != "") {
            searchString = searchString + 'lineCost:' + rmanDefRollforwardReportVSearchObject.lineCost + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.bundleAttributedList != undefined && rmanDefRollforwardReportVSearchObject.bundleAttributedList != "") {
            searchString = searchString + 'bundleAttributedList:' + rmanDefRollforwardReportVSearchObject.bundleAttributedList + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.bundleAttributedNet != undefined && rmanDefRollforwardReportVSearchObject.bundleAttributedNet != "") {
            searchString = searchString + 'bundleAttributedNet:' + rmanDefRollforwardReportVSearchObject.bundleAttributedNet + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.startDate != undefined && rmanDefRollforwardReportVSearchObject.startDate != "") {
            searchString = searchString + 'startDate:' + rmanDefRollforwardReportVSearchObject.startDate + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.endDate != undefined && rmanDefRollforwardReportVSearchObject.endDate != "") {
            searchString = searchString + 'endDate:' + rmanDefRollforwardReportVSearchObject.endDate + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.sspAmount != undefined && rmanDefRollforwardReportVSearchObject.sspAmount != "") {
            searchString = searchString + 'sspAmount:' + rmanDefRollforwardReportVSearchObject.sspAmount + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.allocationAmount != undefined && rmanDefRollforwardReportVSearchObject.allocationAmount != "") {
            searchString = searchString + 'allocationAmount:' + rmanDefRollforwardReportVSearchObject.allocationAmount + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.bookedAmount != undefined && rmanDefRollforwardReportVSearchObject.bookedAmount != "") {
            searchString = searchString + 'bookedAmount:' + rmanDefRollforwardReportVSearchObject.bookedAmount + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.deliveredAmount != undefined && rmanDefRollforwardReportVSearchObject.deliveredAmount != "") {
            searchString = searchString + 'deliveredAmount:' + rmanDefRollforwardReportVSearchObject.deliveredAmount + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.deliveredAllocationAmount != undefined && rmanDefRollforwardReportVSearchObject.deliveredAllocationAmount != "") {
            searchString = searchString + 'deliveredAllocationAmount:' + rmanDefRollforwardReportVSearchObject.deliveredAllocationAmount + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.postBillingDeferrals != undefined && rmanDefRollforwardReportVSearchObject.postBillingDeferrals != "") {
            searchString = searchString + 'postBillingDeferrals:' + rmanDefRollforwardReportVSearchObject.postBillingDeferrals + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.beginingBalance != undefined && rmanDefRollforwardReportVSearchObject.beginingBalance != "") {
            searchString = searchString + 'beginingBalance:' + rmanDefRollforwardReportVSearchObject.beginingBalance + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.additionAmount != undefined && rmanDefRollforwardReportVSearchObject.additionAmount != "") {
            searchString = searchString + 'additionAmount:' + rmanDefRollforwardReportVSearchObject.additionAmount + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.releaseAmount != undefined && rmanDefRollforwardReportVSearchObject.releaseAmount != "") {
            searchString = searchString + 'releaseAmount:' + rmanDefRollforwardReportVSearchObject.releaseAmount + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.endingBalance != undefined && rmanDefRollforwardReportVSearchObject.endingBalance != "") {
            searchString = searchString + 'endingBalance:' + rmanDefRollforwardReportVSearchObject.endingBalance + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.revenueRecognized != undefined && rmanDefRollforwardReportVSearchObject.revenueRecognized != "") {
            searchString = searchString + 'revenueRecognized:' + rmanDefRollforwardReportVSearchObject.revenueRecognized + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.periodName != undefined && rmanDefRollforwardReportVSearchObject.periodName != "") {
            searchString = searchString + 'periodName:' + rmanDefRollforwardReportVSearchObject.periodName + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.periodYear != undefined && rmanDefRollforwardReportVSearchObject.periodYear != "") {
            searchString = searchString + 'periodYear:' + rmanDefRollforwardReportVSearchObject.periodYear + ',';
        }

        if (rmanDefRollforwardReportVSearchObject.quarterName != undefined && rmanDefRollforwardReportVSearchObject.quarterName != "") {
            searchString = searchString + 'quarterName:' + rmanDefRollforwardReportVSearchObject.quarterName;
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

    searchFields(periodType: any, asOfPeriod: any, dealArrangementNum:any, soNumber:any, poNumber:any, paginationOptions: any) {
        
        if (periodType == undefined) periodType = ''; 
        if (asOfPeriod == undefined) asOfPeriod = '';
        if (dealArrangementNum == undefined) dealArrangementNum = '';
        if (soNumber == undefined) soNumber = '';
        if (poNumber == undefined) poNumber = '';

        let searchUrl = appSettings.apiUrl + '/revmantra/deferredRevenueRollForwardRep?periodType=' + periodType + '&asOfPeriod=' + asOfPeriod + '&dealArrgNum='+ dealArrangementNum + '&so=' +soNumber + '&po=' + poNumber;
        if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != "" && !isNaN(paginationOptions.pageNumber) && paginationOptions.pageNumber != 0) {
            searchUrl = searchUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;
        }
        return this.http.get(searchUrl).toPromise().then((data: any) => {
            return data;
        });
    }

    exportReconDeals(periodType: any, asOfPeriod: any, dealArrangementNum:any, soNumber:any, poNumber:any , exportCols: any) {
    
        if (periodType == undefined) periodType = ''; 
        if (asOfPeriod == undefined) asOfPeriod = '';
        if (dealArrangementNum == undefined) dealArrangementNum = '';
        if (soNumber == undefined) soNumber = '';
        if (poNumber == undefined) poNumber = '';

        let serviceUrl = appSettings.apiUrl + '/rmanDeferredRevenueRollForwardRepExport?periodType=' + periodType + '&asOfPeriod=' + asOfPeriod + '&dealArrgNum='+ dealArrangementNum + '&so=' +soNumber + '&po=' + poNumber;

        if (exportCols != undefined && exportCols != "") {
            serviceUrl = serviceUrl + '&exportCols=' + exportCols;
        }
        return serviceUrl;

    }

    getPeriodNameList(periodName: any) {
        let serviceUrl = appSettings.apiUrl + '/rmanFiscalPeriodsSearch?';
        let searchString = '';
        if (periodName) {
            searchString = searchString + `periodName:${periodName}`
        }
        if (searchString == '') {
            serviceUrl = serviceUrl + 'search=%25';
        }
        else {
            serviceUrl = serviceUrl + 'search=' + searchString;
        }
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }

}
