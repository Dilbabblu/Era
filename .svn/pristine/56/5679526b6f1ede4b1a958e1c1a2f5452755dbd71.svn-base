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
export class RmanOrdersService {

    constructor(private http: HttpClient) { }

    getServiceUrl(paginationOptions: any, rmanOrdersSearchObject: any, exportFlag: any) {

        let serviceUrl = appSettings.apiUrl + '/rmanOrdersExport?';

        if (exportFlag == 0) {
            serviceUrl = appSettings.apiUrl + '/rmanOrdersSearch?';
        }

        let searchString = '';

        if (rmanOrdersSearchObject.rmanLineId != undefined && rmanOrdersSearchObject.rmanLineId != "") {
            searchString = searchString + 'rmanLineId:' + rmanOrdersSearchObject.rmanLineId + ',';
        }

        if (rmanOrdersSearchObject.exceptionFlag != undefined && rmanOrdersSearchObject.exceptionFlag != "") {
            searchString = searchString + 'exceptionFlag:' + rmanOrdersSearchObject.exceptionFlag + ',';
        }

        if (rmanOrdersSearchObject.sourceHeaderId != undefined && rmanOrdersSearchObject.sourceHeaderId != "") {
            searchString = searchString + 'sourceHeaderId:' + rmanOrdersSearchObject.sourceHeaderId + ',';
        }

        if (rmanOrdersSearchObject.orderNumber != undefined && rmanOrdersSearchObject.orderNumber != "") {
            searchString = searchString + 'orderNumber:' + rmanOrdersSearchObject.orderNumber + ',';
        }

        if (rmanOrdersSearchObject.customerPoNum != undefined && rmanOrdersSearchObject.customerPoNum != "") {
            searchString = searchString + 'customerPoNum:' + rmanOrdersSearchObject.customerPoNum + ',';
        }

        if (rmanOrdersSearchObject.orderType != undefined && rmanOrdersSearchObject.orderType != "") {
            searchString = searchString + 'orderType:' + rmanOrdersSearchObject.orderType + ',';
        }

        if (rmanOrdersSearchObject.bookingEntityId != undefined && rmanOrdersSearchObject.bookingEntityId != "") {
            searchString = searchString + 'bookingEntityId:' + rmanOrdersSearchObject.bookingEntityId + ',';
        }

        if (rmanOrdersSearchObject.shippingEntityId != undefined && rmanOrdersSearchObject.shippingEntityId != "") {
            searchString = searchString + 'shippingEntityId:' + rmanOrdersSearchObject.shippingEntityId + ',';
        }

        if (rmanOrdersSearchObject.soldToCustomer != undefined && rmanOrdersSearchObject.soldToCustomer != "") {
            searchString = searchString + 'soldToCustomer:' + rmanOrdersSearchObject.soldToCustomer + ',';
        }

        if (rmanOrdersSearchObject.billToCustomer != undefined && rmanOrdersSearchObject.billToCustomer != "") {
            searchString = searchString + 'billToCustomer:' + rmanOrdersSearchObject.billToCustomer + ',';
        }

        if (rmanOrdersSearchObject.endCustomer != undefined && rmanOrdersSearchObject.endCustomer != "") {
            searchString = searchString + 'endCustomer:' + rmanOrdersSearchObject.endCustomer + ',';
        }

        if (rmanOrdersSearchObject.shipToCustomer != undefined && rmanOrdersSearchObject.shipToCustomer != "") {
            searchString = searchString + 'shipToCustomer:' + rmanOrdersSearchObject.shipToCustomer + ',';
        }

        if (rmanOrdersSearchObject.billToCountry != undefined && rmanOrdersSearchObject.billToCountry != "") {
            searchString = searchString + 'billToCountry:' + rmanOrdersSearchObject.billToCountry + ',';
        }

        if (rmanOrdersSearchObject.shipToCountry != undefined && rmanOrdersSearchObject.shipToCountry != "") {
            searchString = searchString + 'shipToCountry:' + rmanOrdersSearchObject.shipToCountry + ',';
        }

        if (rmanOrdersSearchObject.shippingOrgCode != undefined && rmanOrdersSearchObject.shippingOrgCode != "") {
            searchString = searchString + 'shippingOrgCode:' + rmanOrdersSearchObject.shippingOrgCode + ',';
        }

        if (rmanOrdersSearchObject.bookedDate != undefined && rmanOrdersSearchObject.bookedDate != "") {
            searchString = searchString + 'bookedDate:' + rmanOrdersSearchObject.bookedDate + ',';
        }

        if (rmanOrdersSearchObject.orderedDate != undefined && rmanOrdersSearchObject.orderedDate != "") {
            searchString = searchString + 'orderedDate:' + rmanOrdersSearchObject.orderedDate + ',';
        }

        if (rmanOrdersSearchObject.scheduleShipDate != undefined && rmanOrdersSearchObject.scheduleShipDate != "") {
            searchString = searchString + 'scheduleShipDate:' + rmanOrdersSearchObject.scheduleShipDate + ',';
        }

        if (rmanOrdersSearchObject.orderStatus != undefined && rmanOrdersSearchObject.orderStatus != "") {
            searchString = searchString + 'orderStatus:' + rmanOrdersSearchObject.orderStatus + ',';
        }

        if (rmanOrdersSearchObject.priceList != undefined && rmanOrdersSearchObject.priceList != "") {
            searchString = searchString + 'priceList:' + rmanOrdersSearchObject.priceList + ',';
        }

        if (rmanOrdersSearchObject.salesrep != undefined && rmanOrdersSearchObject.salesrep != "") {
            searchString = searchString + 'salesrep:' + rmanOrdersSearchObject.salesrep + ',';
        }

        if (rmanOrdersSearchObject.bookingCurrency != undefined && rmanOrdersSearchObject.bookingCurrency != "") {
            searchString = searchString + 'bookingCurrency:' + rmanOrdersSearchObject.bookingCurrency + ',';
        }

        if (rmanOrdersSearchObject.fob != undefined && rmanOrdersSearchObject.fob != "") {
            searchString = searchString + 'fob:' + rmanOrdersSearchObject.fob + ',';
        }

        if (rmanOrdersSearchObject.sourceLineId != undefined && rmanOrdersSearchObject.sourceLineId != "") {
            searchString = searchString + 'sourceLineId:' + rmanOrdersSearchObject.sourceLineId + ',';
        }

        if (rmanOrdersSearchObject.sourceLineNumber != undefined && rmanOrdersSearchObject.sourceLineNumber != "") {
            searchString = searchString + 'sourceLineNumber:' + rmanOrdersSearchObject.sourceLineNumber + ',';
        }

        if (rmanOrdersSearchObject.productName != undefined && rmanOrdersSearchObject.productName != "") {
            searchString = searchString + 'productName:' + rmanOrdersSearchObject.productName + ',';
        }

        if (rmanOrdersSearchObject.productId != undefined && rmanOrdersSearchObject.productId != "") {
            searchString = searchString + 'productId:' + rmanOrdersSearchObject.productId + ',';
        }

        if (rmanOrdersSearchObject.productOrgId != undefined && rmanOrdersSearchObject.productOrgId != "") {
            searchString = searchString + 'productOrgId:' + rmanOrdersSearchObject.productOrgId + ',';
        }

        if (rmanOrdersSearchObject.orderedQuantity != undefined && rmanOrdersSearchObject.orderedQuantity != "") {
            searchString = searchString + 'orderedQuantity:' + rmanOrdersSearchObject.orderedQuantity + ',';
        }

        if (rmanOrdersSearchObject.shippedQuantity != undefined && rmanOrdersSearchObject.shippedQuantity != "") {
            searchString = searchString + 'shippedQuantity:' + rmanOrdersSearchObject.shippedQuantity + ',';
        }

        if (rmanOrdersSearchObject.fulfilledQuantity != undefined && rmanOrdersSearchObject.fulfilledQuantity != "") {
            searchString = searchString + 'fulfilledQuantity:' + rmanOrdersSearchObject.fulfilledQuantity + ',';
        }

        if (rmanOrdersSearchObject.lineType != undefined && rmanOrdersSearchObject.lineType != "") {
            searchString = searchString + 'lineType:' + rmanOrdersSearchObject.lineType + ',';
        }

        if (rmanOrdersSearchObject.lineStatus != undefined && rmanOrdersSearchObject.lineStatus != "") {
            searchString = searchString + 'lineStatus:' + rmanOrdersSearchObject.lineStatus + ',';
        }

        if (rmanOrdersSearchObject.unitSellingPrice != undefined && rmanOrdersSearchObject.unitSellingPrice != "") {
            searchString = searchString + 'unitSellingPrice:' + rmanOrdersSearchObject.unitSellingPrice + ',';
        }

        if (rmanOrdersSearchObject.unitListPrice != undefined && rmanOrdersSearchObject.unitListPrice != "") {
            searchString = searchString + 'unitListPrice:' + rmanOrdersSearchObject.unitListPrice + ',';
        }

        if (rmanOrdersSearchObject.shippableFlag != undefined && rmanOrdersSearchObject.shippableFlag != "") {
            searchString = searchString + 'shippableFlag:' + rmanOrdersSearchObject.shippableFlag + ',';
        }

        if (rmanOrdersSearchObject.invoiceFlag != undefined && rmanOrdersSearchObject.invoiceFlag != "") {
            searchString = searchString + 'invoiceFlag:' + rmanOrdersSearchObject.invoiceFlag + ',';
        }

        if (rmanOrdersSearchObject.orginalLineId != undefined && rmanOrdersSearchObject.orginalLineId != "") {
            searchString = searchString + 'orginalLineId:' + rmanOrdersSearchObject.orginalLineId + ',';
        }

        if (rmanOrdersSearchObject.origRmanLineId != undefined && rmanOrdersSearchObject.origRmanLineId != "") {
            searchString = searchString + 'origRmanLineId:' + rmanOrdersSearchObject.origRmanLineId + ',';
        }

        if (rmanOrdersSearchObject.orginalLineNumber != undefined && rmanOrdersSearchObject.orginalLineNumber != "") {
            searchString = searchString + 'orginalLineNumber:' + rmanOrdersSearchObject.orginalLineNumber + ',';
        }

        if (rmanOrdersSearchObject.orginalOrderNumber != undefined && rmanOrdersSearchObject.orginalOrderNumber != "") {
            searchString = searchString + 'orginalOrderNumber:' + rmanOrdersSearchObject.orginalOrderNumber + ',';
        }

        if (rmanOrdersSearchObject.accountingRuleName != undefined && rmanOrdersSearchObject.accountingRuleName != "") {
            searchString = searchString + 'accountingRuleName:' + rmanOrdersSearchObject.accountingRuleName + ',';
        }

        if (rmanOrdersSearchObject.rmanAcctRuleId != undefined && rmanOrdersSearchObject.rmanAcctRuleId != "") {
            searchString = searchString + 'rmanAcctRuleId:' + rmanOrdersSearchObject.rmanAcctRuleId + ',';
        }

        if (rmanOrdersSearchObject.serviceStartDate != undefined && rmanOrdersSearchObject.serviceStartDate != "") {
            searchString = searchString + 'serviceStartDate:' + rmanOrdersSearchObject.serviceStartDate + ',';
        }

        if (rmanOrdersSearchObject.serviceEndDate != undefined && rmanOrdersSearchObject.serviceEndDate != "") {
            searchString = searchString + 'serviceEndDate:' + rmanOrdersSearchObject.serviceEndDate + ',';
        }

        if (rmanOrdersSearchObject.serviceDuration != undefined && rmanOrdersSearchObject.serviceDuration != "") {
            searchString = searchString + 'serviceDuration:' + rmanOrdersSearchObject.serviceDuration + ',';
        }

        if (rmanOrdersSearchObject.servicePeriod != undefined && rmanOrdersSearchObject.servicePeriod != "") {
            searchString = searchString + 'servicePeriod:' + rmanOrdersSearchObject.servicePeriod + ',';
        }

        if (rmanOrdersSearchObject.lineAttribute1 != undefined && rmanOrdersSearchObject.lineAttribute1 != "") {
            searchString = searchString + 'lineAttribute1:' + rmanOrdersSearchObject.lineAttribute1 + ',';
        }

        if (rmanOrdersSearchObject.lineAttribute2 != undefined && rmanOrdersSearchObject.lineAttribute2 != "") {
            searchString = searchString + 'lineAttribute2:' + rmanOrdersSearchObject.lineAttribute2 + ',';
        }

        if (rmanOrdersSearchObject.lineAttribute3 != undefined && rmanOrdersSearchObject.lineAttribute3 != "") {
            searchString = searchString + 'lineAttribute3:' + rmanOrdersSearchObject.lineAttribute3 + ',';
        }

        if (rmanOrdersSearchObject.lineAttribute4 != undefined && rmanOrdersSearchObject.lineAttribute4 != "") {
            searchString = searchString + 'lineAttribute4:' + rmanOrdersSearchObject.lineAttribute4 + ',';
        }

        if (rmanOrdersSearchObject.lineAttribute5 != undefined && rmanOrdersSearchObject.lineAttribute5 != "") {
            searchString = searchString + 'lineAttribute5:' + rmanOrdersSearchObject.lineAttribute5 + ',';
        }

        if (rmanOrdersSearchObject.lineAttribute6 != undefined && rmanOrdersSearchObject.lineAttribute6 != "") {
            searchString = searchString + 'lineAttribute6:' + rmanOrdersSearchObject.lineAttribute6 + ',';
        }

        if (rmanOrdersSearchObject.lineAttribute7 != undefined && rmanOrdersSearchObject.lineAttribute7 != "") {
            searchString = searchString + 'lineAttribute7:' + rmanOrdersSearchObject.lineAttribute7 + ',';
        }

        if (rmanOrdersSearchObject.lineAttribute8 != undefined && rmanOrdersSearchObject.lineAttribute8 != "") {
            searchString = searchString + 'lineAttribute8:' + rmanOrdersSearchObject.lineAttribute8 + ',';
        }

        if (rmanOrdersSearchObject.lineAttribute9 != undefined && rmanOrdersSearchObject.lineAttribute9 != "") {
            searchString = searchString + 'lineAttribute9:' + rmanOrdersSearchObject.lineAttribute9 + ',';
        }

        if (rmanOrdersSearchObject.lineAttribute10 != undefined && rmanOrdersSearchObject.lineAttribute10 != "") {
            searchString = searchString + 'lineAttribute10:' + rmanOrdersSearchObject.lineAttribute10 + ',';
        }

        if (rmanOrdersSearchObject.lineAttribute11 != undefined && rmanOrdersSearchObject.lineAttribute11 != "") {
            searchString = searchString + 'lineAttribute11:' + rmanOrdersSearchObject.lineAttribute11 + ',';
        }

        if (rmanOrdersSearchObject.lineAttribute12 != undefined && rmanOrdersSearchObject.lineAttribute12 != "") {
            searchString = searchString + 'lineAttribute12:' + rmanOrdersSearchObject.lineAttribute12 + ',';
        }

        if (rmanOrdersSearchObject.lineAttribute13 != undefined && rmanOrdersSearchObject.lineAttribute13 != "") {
            searchString = searchString + 'lineAttribute13:' + rmanOrdersSearchObject.lineAttribute13 + ',';
        }

        if (rmanOrdersSearchObject.lineAttribute14 != undefined && rmanOrdersSearchObject.lineAttribute14 != "") {
            searchString = searchString + 'lineAttribute14:' + rmanOrdersSearchObject.lineAttribute14 + ',';
        }

        if (rmanOrdersSearchObject.lineAttribute15 != undefined && rmanOrdersSearchObject.lineAttribute15 != "") {
            searchString = searchString + 'lineAttribute15:' + rmanOrdersSearchObject.lineAttribute15 + ',';
        }

        if (rmanOrdersSearchObject.headerAttribute1 != undefined && rmanOrdersSearchObject.headerAttribute1 != "") {
            searchString = searchString + 'headerAttribute1:' + rmanOrdersSearchObject.headerAttribute1 + ',';
        }

        if (rmanOrdersSearchObject.headerAttribute2 != undefined && rmanOrdersSearchObject.headerAttribute2 != "") {
            searchString = searchString + 'headerAttribute2:' + rmanOrdersSearchObject.headerAttribute2 + ',';
        }

        if (rmanOrdersSearchObject.headerAttribute3 != undefined && rmanOrdersSearchObject.headerAttribute3 != "") {
            searchString = searchString + 'headerAttribute3:' + rmanOrdersSearchObject.headerAttribute3 + ',';
        }

        if (rmanOrdersSearchObject.headerAttribute4 != undefined && rmanOrdersSearchObject.headerAttribute4 != "") {
            searchString = searchString + 'headerAttribute4:' + rmanOrdersSearchObject.headerAttribute4 + ',';
        }

        if (rmanOrdersSearchObject.headerAttribute5 != undefined && rmanOrdersSearchObject.headerAttribute5 != "") {
            searchString = searchString + 'headerAttribute5:' + rmanOrdersSearchObject.headerAttribute5 + ',';
        }

        if (rmanOrdersSearchObject.headerAttribute6 != undefined && rmanOrdersSearchObject.headerAttribute6 != "") {
            searchString = searchString + 'headerAttribute6:' + rmanOrdersSearchObject.headerAttribute6 + ',';
        }

        if (rmanOrdersSearchObject.headerAttribute7 != undefined && rmanOrdersSearchObject.headerAttribute7 != "") {
            searchString = searchString + 'headerAttribute7:' + rmanOrdersSearchObject.headerAttribute7 + ',';
        }

        if (rmanOrdersSearchObject.headerAttribute8 != undefined && rmanOrdersSearchObject.headerAttribute8 != "") {
            searchString = searchString + 'headerAttribute8:' + rmanOrdersSearchObject.headerAttribute8 + ',';
        }

        if (rmanOrdersSearchObject.headerAttribute9 != undefined && rmanOrdersSearchObject.headerAttribute9 != "") {
            searchString = searchString + 'headerAttribute9:' + rmanOrdersSearchObject.headerAttribute9 + ',';
        }

        if (rmanOrdersSearchObject.headerAttribute10 != undefined && rmanOrdersSearchObject.headerAttribute10 != "") {
            searchString = searchString + 'headerAttribute10:' + rmanOrdersSearchObject.headerAttribute10 + ',';
        }

        if (rmanOrdersSearchObject.headerAttribute11 != undefined && rmanOrdersSearchObject.headerAttribute11 != "") {
            searchString = searchString + 'headerAttribute11:' + rmanOrdersSearchObject.headerAttribute11 + ',';
        }

        if (rmanOrdersSearchObject.headerAttribute12 != undefined && rmanOrdersSearchObject.headerAttribute12 != "") {
            searchString = searchString + 'headerAttribute12:' + rmanOrdersSearchObject.headerAttribute12 + ',';
        }

        if (rmanOrdersSearchObject.headerAttribute13 != undefined && rmanOrdersSearchObject.headerAttribute13 != "") {
            searchString = searchString + 'headerAttribute13:' + rmanOrdersSearchObject.headerAttribute13 + ',';
        }

        if (rmanOrdersSearchObject.headerAttribute14 != undefined && rmanOrdersSearchObject.headerAttribute14 != "") {
            searchString = searchString + 'headerAttribute14:' + rmanOrdersSearchObject.headerAttribute14 + ',';
        }

        if (rmanOrdersSearchObject.headerAttribute15 != undefined && rmanOrdersSearchObject.headerAttribute15 != "") {
            searchString = searchString + 'headerAttribute15:' + rmanOrdersSearchObject.headerAttribute15 + ',';
        }

        if (rmanOrdersSearchObject.creationDate != undefined && rmanOrdersSearchObject.creationDate != "") {
            searchString = searchString + 'creationDate:' + rmanOrdersSearchObject.creationDate + ',';
        }

        if (rmanOrdersSearchObject.createdBy != undefined && rmanOrdersSearchObject.createdBy != "") {
            searchString = searchString + 'createdBy:' + rmanOrdersSearchObject.createdBy + ',';
        }

        if (rmanOrdersSearchObject.lastUpdateDate != undefined && rmanOrdersSearchObject.lastUpdateDate != "") {
            searchString = searchString + 'lastUpdateDate:' + rmanOrdersSearchObject.lastUpdateDate + ',';
        }

        if (rmanOrdersSearchObject.lastUpdatedBy != undefined && rmanOrdersSearchObject.lastUpdatedBy != "") {
            searchString = searchString + 'lastUpdatedBy:' + rmanOrdersSearchObject.lastUpdatedBy + ',';
        }

        if (rmanOrdersSearchObject.arrangementId != undefined && rmanOrdersSearchObject.arrangementId != "") {
            searchString = searchString + 'arrangementId:' + rmanOrdersSearchObject.arrangementId + ',';
        }

        if (rmanOrdersSearchObject.allocationAmount != undefined && rmanOrdersSearchObject.allocationAmount != "") {
            searchString = searchString + 'allocationAmount:' + rmanOrdersSearchObject.allocationAmount + ',';
        }

        if (rmanOrdersSearchObject.carveInOrOut != undefined && rmanOrdersSearchObject.carveInOrOut != "") {
            searchString = searchString + 'carveInOrOut:' + rmanOrdersSearchObject.carveInOrOut + ',';
        }

        if (rmanOrdersSearchObject.fmvHistoryFlag != undefined && rmanOrdersSearchObject.fmvHistoryFlag != "") {
            searchString = searchString + 'fmvHistoryFlag:' + rmanOrdersSearchObject.fmvHistoryFlag + ',';
        }

        if (rmanOrdersSearchObject.eitfSop != undefined && rmanOrdersSearchObject.eitfSop != "") {
            searchString = searchString + 'eitfSop:' + rmanOrdersSearchObject.eitfSop + ',';
        }

        if (rmanOrdersSearchObject.fmvRuleDefId != undefined && rmanOrdersSearchObject.fmvRuleDefId != "") {
            searchString = searchString + 'fmvRuleDefId:' + rmanOrdersSearchObject.fmvRuleDefId + ',';
        }

        if (rmanOrdersSearchObject.repCurrUsp != undefined && rmanOrdersSearchObject.repCurrUsp != "") {
            searchString = searchString + 'repCurrUsp:' + rmanOrdersSearchObject.repCurrUsp + ',';
        }

        if (rmanOrdersSearchObject.repCurrUlp != undefined && rmanOrdersSearchObject.repCurrUlp != "") {
            searchString = searchString + 'repCurrUlp:' + rmanOrdersSearchObject.repCurrUlp + ',';
        }

        if (rmanOrdersSearchObject.repCurrExtendedAmt != undefined && rmanOrdersSearchObject.repCurrExtendedAmt != "") {
            searchString = searchString + 'repCurrExtendedAmt:' + rmanOrdersSearchObject.repCurrExtendedAmt + ',';
        }

        if (rmanOrdersSearchObject.repUnitSellingPrice != undefined && rmanOrdersSearchObject.repUnitSellingPrice != "") {
            searchString = searchString + 'repUnitSellingPrice:' + rmanOrdersSearchObject.repUnitSellingPrice + ',';
        }

        if (rmanOrdersSearchObject.repUnitListPrice != undefined && rmanOrdersSearchObject.repUnitListPrice != "") {
            searchString = searchString + 'repUnitListPrice:' + rmanOrdersSearchObject.repUnitListPrice + ',';
        }

        if (rmanOrdersSearchObject.elementType != undefined && rmanOrdersSearchObject.elementType != "") {
            searchString = searchString + 'elementType:' + rmanOrdersSearchObject.elementType + ',';
        }

        if (rmanOrdersSearchObject.deliveredFlag != undefined && rmanOrdersSearchObject.deliveredFlag != "") {
            searchString = searchString + 'deliveredFlag:' + rmanOrdersSearchObject.deliveredFlag + ',';
        }

        if (rmanOrdersSearchObject.parentLineId != undefined && rmanOrdersSearchObject.parentLineId != "") {
            searchString = searchString + 'parentLineId:' + rmanOrdersSearchObject.parentLineId + ',';
        }

        if (rmanOrdersSearchObject.projectName != undefined && rmanOrdersSearchObject.projectName != "") {
            searchString = searchString + 'projectName:' + rmanOrdersSearchObject.projectName + ',';
        }

        if (rmanOrdersSearchObject.projectNumber != undefined && rmanOrdersSearchObject.projectNumber != "") {
            searchString = searchString + 'projectNumber:' + rmanOrdersSearchObject.projectNumber + ',';
        }

        if (rmanOrdersSearchObject.projectId != undefined && rmanOrdersSearchObject.projectId != "") {
            searchString = searchString + 'projectId:' + rmanOrdersSearchObject.projectId + ',';
        }

        if (rmanOrdersSearchObject.taskName != undefined && rmanOrdersSearchObject.taskName != "") {
            searchString = searchString + 'taskName:' + rmanOrdersSearchObject.taskName + ',';
        }

        if (rmanOrdersSearchObject.taskNumber != undefined && rmanOrdersSearchObject.taskNumber != "") {
            searchString = searchString + 'taskNumber:' + rmanOrdersSearchObject.taskNumber + ',';
        }

        if (rmanOrdersSearchObject.taskId != undefined && rmanOrdersSearchObject.taskId != "") {
            searchString = searchString + 'taskId:' + rmanOrdersSearchObject.taskId + ',';
        }

        if (rmanOrdersSearchObject.dealNumber != undefined && rmanOrdersSearchObject.dealNumber != "") {
            searchString = searchString + 'dealNumber:' + rmanOrdersSearchObject.dealNumber + ',';
        }

        if (rmanOrdersSearchObject.dealLineNumber != undefined && rmanOrdersSearchObject.dealLineNumber != "") {
            searchString = searchString + 'dealLineNumber:' + rmanOrdersSearchObject.dealLineNumber + ',';
        }

        if (rmanOrdersSearchObject.lineCost != undefined && rmanOrdersSearchObject.lineCost != "") {
            searchString = searchString + 'lineCost:' + rmanOrdersSearchObject.lineCost + ',';
        }

        if (rmanOrdersSearchObject.roleName != undefined && rmanOrdersSearchObject.roleName != "") {
            searchString = searchString + 'roleName:' + rmanOrdersSearchObject.roleName + ',';
        }

        if (rmanOrdersSearchObject.revenueCategory != undefined && rmanOrdersSearchObject.revenueCategory != "") {
            searchString = searchString + 'revenueCategory:' + rmanOrdersSearchObject.revenueCategory + ',';
        }

        if (rmanOrdersSearchObject.expenditureType != undefined && rmanOrdersSearchObject.expenditureType != "") {
            searchString = searchString + 'expenditureType:' + rmanOrdersSearchObject.expenditureType + ',';
        }

        if (rmanOrdersSearchObject.repCurrCode != undefined && rmanOrdersSearchObject.repCurrCode != "") {
            searchString = searchString + 'repCurrCode:' + rmanOrdersSearchObject.repCurrCode + ',';
        }

        if (rmanOrdersSearchObject.contingencyCode != undefined && rmanOrdersSearchObject.contingencyCode != "") {
            searchString = searchString + 'contingencyCode:' + rmanOrdersSearchObject.contingencyCode + ',';
        }

        if (rmanOrdersSearchObject.subElementType != undefined && rmanOrdersSearchObject.subElementType != "") {
            searchString = searchString + 'subElementType:' + rmanOrdersSearchObject.subElementType + ',';
        }

        if (rmanOrdersSearchObject.allocationFlag != undefined && rmanOrdersSearchObject.allocationFlag != "") {
            searchString = searchString + 'allocationFlag:' + rmanOrdersSearchObject.allocationFlag + ',';
        }

        if (rmanOrdersSearchObject.customerPoLineNum != undefined && rmanOrdersSearchObject.customerPoLineNum != "") {
            searchString = searchString + 'customerPoLineNum:' + rmanOrdersSearchObject.customerPoLineNum + ',';
        }

        if (rmanOrdersSearchObject.dealArrangementId != undefined && rmanOrdersSearchObject.dealArrangementId != "") {
            searchString = searchString + 'dealArrangementId:' + rmanOrdersSearchObject.dealArrangementId + ',';
        }

        if (rmanOrdersSearchObject.poHeaderId != undefined && rmanOrdersSearchObject.poHeaderId != "") {
            searchString = searchString + 'poHeaderId:' + rmanOrdersSearchObject.poHeaderId + ',';
        }

        if (rmanOrdersSearchObject.poLineId != undefined && rmanOrdersSearchObject.poLineId != "") {
            searchString = searchString + 'poLineId:' + rmanOrdersSearchObject.poLineId + ',';
        }

        if (rmanOrdersSearchObject.actualFulfilledDate != undefined && rmanOrdersSearchObject.actualFulfilledDate != "") {
            searchString = searchString + 'actualFulfilledDate:' + rmanOrdersSearchObject.actualFulfilledDate + ',';
        }

        if (rmanOrdersSearchObject.dealLineId != undefined && rmanOrdersSearchObject.dealLineId != "") {
            searchString = searchString + 'dealLineId:' + rmanOrdersSearchObject.dealLineId + ',';
        }

        if (rmanOrdersSearchObject.billToLocation != undefined && rmanOrdersSearchObject.billToLocation != "") {
            searchString = searchString + 'billToLocation:' + rmanOrdersSearchObject.billToLocation + ',';
        }

        if (rmanOrdersSearchObject.conversionRate != undefined && rmanOrdersSearchObject.conversionRate != "") {
            searchString = searchString + 'conversionRate:' + rmanOrdersSearchObject.conversionRate + ',';
        }

        if (rmanOrdersSearchObject.fxDate != undefined && rmanOrdersSearchObject.fxDate != "") {
            searchString = searchString + 'fxDate:' + rmanOrdersSearchObject.fxDate + ',';
        }

        if (rmanOrdersSearchObject.fxRate != undefined && rmanOrdersSearchObject.fxRate != "") {
            searchString = searchString + 'fxRate:' + rmanOrdersSearchObject.fxRate + ',';
        }

        if (rmanOrdersSearchObject.revrecAccount != undefined && rmanOrdersSearchObject.revrecAccount != "") {
            searchString = searchString + 'revrecAccount:' + rmanOrdersSearchObject.revrecAccount + ',';
        }

        if (rmanOrdersSearchObject.revrecAcctRule != undefined && rmanOrdersSearchObject.revrecAcctRule != "") {
            searchString = searchString + 'revrecAcctRule:' + rmanOrdersSearchObject.revrecAcctRule + ',';
        }

        if (rmanOrdersSearchObject.revrecAcctScope != undefined && rmanOrdersSearchObject.revrecAcctScope != "") {
            searchString = searchString + 'revrecAcctScope:' + rmanOrdersSearchObject.revrecAcctScope + ',';
        }

        if (rmanOrdersSearchObject.revrecDelay != undefined && rmanOrdersSearchObject.revrecDelay != "") {
            searchString = searchString + 'revrecDelay:' + rmanOrdersSearchObject.revrecDelay + ',';
        }

        if (rmanOrdersSearchObject.revrecEndDate != undefined && rmanOrdersSearchObject.revrecEndDate != "") {
            searchString = searchString + 'revrecEndDate:' + rmanOrdersSearchObject.revrecEndDate + ',';
        }

        if (rmanOrdersSearchObject.revrecStDate != undefined && rmanOrdersSearchObject.revrecStDate != "") {
            searchString = searchString + 'revrecStDate:' + rmanOrdersSearchObject.revrecStDate + ',';
        }

        if (rmanOrdersSearchObject.shipToLocation != undefined && rmanOrdersSearchObject.shipToLocation != "") {
            searchString = searchString + 'shipToLocation:' + rmanOrdersSearchObject.shipToLocation + ',';
        }

        if (rmanOrdersSearchObject.parentLine != undefined && rmanOrdersSearchObject.parentLine != "") {
            searchString = searchString + 'parentLine:' + rmanOrdersSearchObject.parentLine + ',';
        }

        if (rmanOrdersSearchObject.bundleFlag != undefined && rmanOrdersSearchObject.bundleFlag != "") {
            searchString = searchString + 'bundleFlag:' + rmanOrdersSearchObject.bundleFlag + ',';
        }

        if (rmanOrdersSearchObject.attributedListPrice != undefined && rmanOrdersSearchObject.attributedListPrice != "") {
            searchString = searchString + 'attributedListPrice:' + rmanOrdersSearchObject.attributedListPrice + ',';
        }

        if (rmanOrdersSearchObject.attributedSellPrice != undefined && rmanOrdersSearchObject.attributedSellPrice != "") {
            searchString = searchString + 'attributedSellPrice:' + rmanOrdersSearchObject.attributedSellPrice + ',';
        }

        if (rmanOrdersSearchObject.glUpdateDate != undefined && rmanOrdersSearchObject.glUpdateDate != "") {
            searchString = searchString + 'glUpdateDate:' + rmanOrdersSearchObject.glUpdateDate + ',';
        }

        if (rmanOrdersSearchObject.glStatus != undefined && rmanOrdersSearchObject.glStatus != "") {
            searchString = searchString + 'glStatus:' + rmanOrdersSearchObject.glStatus;
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

    getAllRmanOrders(paginationOptions: any, rmanOrdersSearchObject: any): Promise<any[]> {
        let serviceUrl = this.getServiceUrl(paginationOptions, rmanOrdersSearchObject, 0);
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        })
    }

    saveRmanOrders(rmanOrders: any) {
        let body = JSON.stringify(rmanOrders);
        return this.http.post(appSettings.apiUrl + '/RMAN_ORDERS', body, httpOptions).toPromise().then(data => {
            return data;
        });
    }

    updateRmanOrders(rmanOrders: any) {

        delete rmanOrders._links;
        delete rmanOrders.interests;
        let body = JSON.stringify(rmanOrders);
        return this.http.put(appSettings.apiUrl + '/RMAN_ORDERS/' + rmanOrders.rmanLineId, body, httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanOrders(rmanOrders: any) {
        let deleteUrl = appSettings.apiUrl + '/RMAN_ORDERS/' + rmanOrders.rmanLineId;
        return this.http.delete(deleteUrl, httpOptions).toPromise().then(data => {
            return data;
        });
    }

}
