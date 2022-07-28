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
export class ConsolidatedArrgSummaryRepService {

    constructor(private http: HttpClient, private datePipe: DatePipe) {

    }

    sDate: any;
    eDate: any;

    getServiceUrl(paginationOptions: any, consolidatedArrgSummaryRepSearchObject: any, exportFlag: any, searchFields: any) {

        let serviceUrl = appSettings.apiUrl + '/consolidatedArrgSummaryRepExport?';

        if (exportFlag == 0) {
            serviceUrl = appSettings.apiUrl + '/consolidatedArrgSummaryRepSearch?';
        }


        let searchString = '';

        if (consolidatedArrgSummaryRepSearchObject.msaName != undefined && consolidatedArrgSummaryRepSearchObject.msaName != "") {
            searchString = searchString + 'msaName:' + consolidatedArrgSummaryRepSearchObject.msaName + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.msaNumber != undefined && consolidatedArrgSummaryRepSearchObject.msaNumber != "") {
            searchString = searchString + 'msaNumber:' + consolidatedArrgSummaryRepSearchObject.msaNumber + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.customerNumber != undefined && consolidatedArrgSummaryRepSearchObject.customerNumber != "") {
            searchString = searchString + 'customerNumber:' + consolidatedArrgSummaryRepSearchObject.customerNumber + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.customerName != undefined && consolidatedArrgSummaryRepSearchObject.customerName != "") {
            searchString = searchString + 'customerName:' + consolidatedArrgSummaryRepSearchObject.customerName + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.dealStatus != undefined && consolidatedArrgSummaryRepSearchObject.dealStatus != "") {
            searchString = searchString + 'dealStatus:' + consolidatedArrgSummaryRepSearchObject.dealStatus + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.legalEntity != undefined && consolidatedArrgSummaryRepSearchObject.legalEntity != "") {
            searchString = searchString + 'legalEntity:' + consolidatedArrgSummaryRepSearchObject.legalEntity + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.currency != undefined && consolidatedArrgSummaryRepSearchObject.currency != "") {
            searchString = searchString + 'currency:' + consolidatedArrgSummaryRepSearchObject.currency + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.arrangementName != undefined && consolidatedArrgSummaryRepSearchObject.arrangementName != "") {
            searchString = searchString + 'arrangementName:' + consolidatedArrgSummaryRepSearchObject.arrangementName + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.arrangementType != undefined && consolidatedArrgSummaryRepSearchObject.arrangementType != "") {
            searchString = searchString + 'arrangementType:' + consolidatedArrgSummaryRepSearchObject.arrangementType + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.status != undefined && consolidatedArrgSummaryRepSearchObject.status != "") {
            searchString = searchString + 'status:' + consolidatedArrgSummaryRepSearchObject.status + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.arrangementBasis != undefined && consolidatedArrgSummaryRepSearchObject.arrangementBasis != "") {
            searchString = searchString + 'arrangementBasis:' + consolidatedArrgSummaryRepSearchObject.arrangementBasis + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.arrangementSource != undefined && consolidatedArrgSummaryRepSearchObject.arrangementSource != "") {
            searchString = searchString + 'arrangementSource:' + consolidatedArrgSummaryRepSearchObject.arrangementSource + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.salesNodeLevel1 != undefined && consolidatedArrgSummaryRepSearchObject.salesNodeLevel1 != "") {
            searchString = searchString + 'salesNodeLevel1:' + consolidatedArrgSummaryRepSearchObject.salesNodeLevel1 + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.salesNodeLevel2 != undefined && consolidatedArrgSummaryRepSearchObject.salesNodeLevel2 != "") {
            searchString = searchString + 'salesNodeLevel2:' + consolidatedArrgSummaryRepSearchObject.salesNodeLevel2 + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.salesNodeLevel3 != undefined && consolidatedArrgSummaryRepSearchObject.salesNodeLevel3 != "") {
            searchString = searchString + 'salesNodeLevel3:' + consolidatedArrgSummaryRepSearchObject.salesNodeLevel3 + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.salesNodeLevel4 != undefined && consolidatedArrgSummaryRepSearchObject.salesNodeLevel4 != "") {
            searchString = searchString + 'salesNodeLevel4:' + consolidatedArrgSummaryRepSearchObject.salesNodeLevel4 + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.arrangementNumber != undefined && consolidatedArrgSummaryRepSearchObject.arrangementNumber != "") {
            searchString = searchString + 'arrangementNumber:' + consolidatedArrgSummaryRepSearchObject.arrangementNumber + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.approvalStatus != undefined && consolidatedArrgSummaryRepSearchObject.approvalStatus != "") {
            searchString = searchString + 'approvalStatus:' + consolidatedArrgSummaryRepSearchObject.approvalStatus + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.approvalDate != undefined && consolidatedArrgSummaryRepSearchObject.approvalDate != "") {
            searchString = searchString + 'approvalDate:' + consolidatedArrgSummaryRepSearchObject.approvalDate + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.approvedBy != undefined && consolidatedArrgSummaryRepSearchObject.approvedBy != "") {
            searchString = searchString + 'approvedBy:' + consolidatedArrgSummaryRepSearchObject.approvedBy + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.arrangementCreationDate != undefined && consolidatedArrgSummaryRepSearchObject.arrangementCreationDate != "") {
            searchString = searchString + 'arrangementCreationDate:' + consolidatedArrgSummaryRepSearchObject.arrangementCreationDate + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.arrgLegalEntityId != undefined && consolidatedArrgSummaryRepSearchObject.arrgLegalEntityId != "") {
            searchString = searchString + 'arrgLegalEntityId:' + consolidatedArrgSummaryRepSearchObject.arrgLegalEntityId + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.arrangementCreatedBy != undefined && consolidatedArrgSummaryRepSearchObject.arrangementCreatedBy != "") {
            searchString = searchString + 'arrangementCreatedBy:' + consolidatedArrgSummaryRepSearchObject.arrangementCreatedBy + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.analystId != undefined && consolidatedArrgSummaryRepSearchObject.analystId != "") {
            searchString = searchString + 'analystId:' + consolidatedArrgSummaryRepSearchObject.analystId + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.managerId != undefined && consolidatedArrgSummaryRepSearchObject.managerId != "") {
            searchString = searchString + 'managerId:' + consolidatedArrgSummaryRepSearchObject.managerId + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.dealArrangementId != undefined && consolidatedArrgSummaryRepSearchObject.dealArrangementId != "") {
            searchString = searchString + 'dealArrangementId:' + consolidatedArrgSummaryRepSearchObject.dealArrangementId + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.dealLineId != undefined && consolidatedArrgSummaryRepSearchObject.dealLineId != "") {
            searchString = searchString + 'dealLineId:' + consolidatedArrgSummaryRepSearchObject.dealLineId + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.dealNumber != undefined && consolidatedArrgSummaryRepSearchObject.dealNumber != "") {
            searchString = searchString + 'dealNumber:' + consolidatedArrgSummaryRepSearchObject.dealNumber + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.dealName != undefined && consolidatedArrgSummaryRepSearchObject.dealName != "") {
            searchString = searchString + 'dealName:' + consolidatedArrgSummaryRepSearchObject.dealName + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.agreementNumber != undefined && consolidatedArrgSummaryRepSearchObject.agreementNumber != "") {
            searchString = searchString + 'agreementNumber:' + consolidatedArrgSummaryRepSearchObject.agreementNumber + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.agreementCode != undefined && consolidatedArrgSummaryRepSearchObject.agreementCode != "") {
            searchString = searchString + 'agreementCode:' + consolidatedArrgSummaryRepSearchObject.agreementCode + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.transactionCurrencyCode != undefined && consolidatedArrgSummaryRepSearchObject.transactionCurrencyCode != "") {
            searchString = searchString + 'transactionCurrencyCode:' + consolidatedArrgSummaryRepSearchObject.transactionCurrencyCode + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.dealLineNumber != undefined && consolidatedArrgSummaryRepSearchObject.dealLineNumber != "") {
            searchString = searchString + 'dealLineNumber:' + consolidatedArrgSummaryRepSearchObject.dealLineNumber + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.parentLineId != undefined && consolidatedArrgSummaryRepSearchObject.parentLineId != "") {
            searchString = searchString + 'parentLineId:' + consolidatedArrgSummaryRepSearchObject.parentLineId + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.priceList != undefined && consolidatedArrgSummaryRepSearchObject.priceList != "") {
            searchString = searchString + 'priceList:' + consolidatedArrgSummaryRepSearchObject.priceList + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.billToCustomerName != undefined && consolidatedArrgSummaryRepSearchObject.billToCustomerName != "") {
            searchString = searchString + 'billToCustomerName:' + consolidatedArrgSummaryRepSearchObject.billToCustomerName + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.billToCustomerNumber != undefined && consolidatedArrgSummaryRepSearchObject.billToCustomerNumber != "") {
            searchString = searchString + 'billToCustomerNumber:' + consolidatedArrgSummaryRepSearchObject.billToCustomerNumber + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.lineNumber != undefined && consolidatedArrgSummaryRepSearchObject.lineNumber != "") {
            searchString = searchString + 'lineNumber:' + consolidatedArrgSummaryRepSearchObject.lineNumber + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.productName != undefined && consolidatedArrgSummaryRepSearchObject.productName != "") {
            searchString = searchString + 'productName:' + consolidatedArrgSummaryRepSearchObject.productName + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.quantity != undefined && consolidatedArrgSummaryRepSearchObject.quantity != "") {
            searchString = searchString + 'quantity:' + consolidatedArrgSummaryRepSearchObject.quantity + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.elementType != undefined && consolidatedArrgSummaryRepSearchObject.elementType != "") {
            searchString = searchString + 'elementType:' + consolidatedArrgSummaryRepSearchObject.elementType + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.accountingScope != undefined && consolidatedArrgSummaryRepSearchObject.accountingScope != "") {
            searchString = searchString + 'accountingScope:' + consolidatedArrgSummaryRepSearchObject.accountingScope + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.startDate != undefined && consolidatedArrgSummaryRepSearchObject.startDate != "") {
            searchString = searchString + 'startDate:' + consolidatedArrgSummaryRepSearchObject.startDate + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.endDate != undefined && consolidatedArrgSummaryRepSearchObject.endDate != "") {
            searchString = searchString + 'endDate:' + consolidatedArrgSummaryRepSearchObject.endDate + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.uomCode != undefined && consolidatedArrgSummaryRepSearchObject.uomCode != "") {
            searchString = searchString + 'uomCode:' + consolidatedArrgSummaryRepSearchObject.uomCode + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.transactionListPrice != undefined && consolidatedArrgSummaryRepSearchObject.transactionListPrice != "") {
            searchString = searchString + 'transactionListPrice:' + consolidatedArrgSummaryRepSearchObject.transactionListPrice + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.transactionSellingPrice != undefined && consolidatedArrgSummaryRepSearchObject.transactionSellingPrice != "") {
            searchString = searchString + 'transactionSellingPrice:' + consolidatedArrgSummaryRepSearchObject.transactionSellingPrice + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.listPrice != undefined && consolidatedArrgSummaryRepSearchObject.listPrice != "") {
            searchString = searchString + 'listPrice:' + consolidatedArrgSummaryRepSearchObject.listPrice + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.netPrice != undefined && consolidatedArrgSummaryRepSearchObject.netPrice != "") {
            searchString = searchString + 'netPrice:' + consolidatedArrgSummaryRepSearchObject.netPrice + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.dealLineCost != undefined && consolidatedArrgSummaryRepSearchObject.dealLineCost != "") {
            searchString = searchString + 'dealLineCost:' + consolidatedArrgSummaryRepSearchObject.dealLineCost + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.allocationAmount != undefined && consolidatedArrgSummaryRepSearchObject.allocationAmount != "") {
            searchString = searchString + 'allocationAmount:' + consolidatedArrgSummaryRepSearchObject.allocationAmount + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.cvInOutAmount != undefined && consolidatedArrgSummaryRepSearchObject.cvInOutAmount != "") {
            searchString = searchString + 'cvInOutAmount:' + consolidatedArrgSummaryRepSearchObject.cvInOutAmount + ',';
        }

        if (consolidatedArrgSummaryRepSearchObject.trxAllocUnitAmt != undefined && consolidatedArrgSummaryRepSearchObject.trxAllocUnitAmt != "") {
            searchString = searchString + 'trxAllocUnitAmt:' + consolidatedArrgSummaryRepSearchObject.trxAllocUnitAmt;
        }


        if (searchFields.fromPeriod != undefined && searchFields.fromPeriod != null) {
            searchString = searchString + 'arrangementCreationDate>' + this.datePipe.transform(searchFields.fromPeriod, 'yyyyMMdd') + ',';
        }
        if (searchFields.toPeriod != undefined && searchFields.toPeriod != null) {
            searchString = searchString + 'arrangementCreationDate<' + this.datePipe.transform(searchFields.toPeriod, 'yyyyMMdd') + ',';
        }

        if (searchFields.fromPeriodName != undefined && searchFields.fromPeriodName != null) {
            searchString = searchString + 'arrangementCreationDate>' + this.sDate + ',';

        }
        if (searchFields.toPeriodName != undefined && searchFields.toPeriodName != null) {
            searchString = searchString + 'arrangementCreationDate>' + this.eDate + ',';

        }

        if (searchFields.fromArrgId != undefined && searchFields.fromArrgId != null) {
            searchString = searchString + 'dealArrangementId>' + searchFields.fromArrgId + ',';
        }
        if (searchFields.toArrgId != undefined && searchFields.toArrgId != null) {
            searchString = searchString + 'dealArrangementId<' + searchFields.toArrgId + ',';
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

    getAllConsolidatedArrgSummaryRep(paginationOptions: any, consolidatedArrgSummaryRepSearchObject: any, searchFields: any) {
        let serviceUrl = this.getServiceUrl(paginationOptions, consolidatedArrgSummaryRepSearchObject, 0, searchFields);
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });


    }

    getPeriodStartDate(pName: any) {
        return this.http.get(appSettings.apiUrl + '/getPeriodStartDate?periodName=' + pName).toPromise().then((data: any) => {
            this.sDate = data["_body"];
            return data['_body'];
        });
    }

    getPeriodEndDate(pName: any) {
        return this.http.get(appSettings.apiUrl + '/getPeriodEndDate?periodName=' + pName).toPromise().then((data: any) => {
            this.eDate = data["_body"];
            return data['_body'];
        });
    }

    saveConsolidatedArrgSummaryRep(consolidatedArrgSummaryRep: any) {
        let body = JSON.stringify(consolidatedArrgSummaryRep);
        return this.http.post(appSettings.apiUrl + '/CONSOLIDATED_ARRG_SUMMARY_REP', body, httpOptions).toPromise().then(data => {
            return data;
        });
    }

    updateConsolidatedArrgSummaryRep(consolidatedArrgSummaryRep: any) {
        delete consolidatedArrgSummaryRep._links;
        delete consolidatedArrgSummaryRep.interests;
        let body = JSON.stringify(consolidatedArrgSummaryRep);
        return this.http.put(appSettings.apiUrl + '/CONSOLIDATED_ARRG_SUMMARY_REP/' + consolidatedArrgSummaryRep.dealLineId, body, httpOptions).toPromise().then(data => {
            return data;
        });
    }

    deleteConsolidatedArrgSummaryRep(consolidatedArrgSummaryRep: any) {
        let deleteUrl = appSettings.apiUrl + '/CONSOLIDATED_ARRG_SUMMARY_REP/' + consolidatedArrgSummaryRep.dealLineId;
        return this.http.delete(deleteUrl, httpOptions).toPromise().then(data => {
            return data;
        });
    }
}
