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
export class BsbReportService {

    constructor(private http: HttpClient) { }
    sDate: any;
    eDate: any;
    getServiceUrl(paginationOptions: any, bsbReportSearchObject: any, exportFlag: any, searchFields: any) {

        let serviceUrl = appSettings.apiUrl + '/bsbReportExport?';

        if (exportFlag == 0) {

            serviceUrl = appSettings.apiUrl + '/bsbReportSearch?';
        }

        let searchString = '';
        if (bsbReportSearchObject.financialMonth != undefined && bsbReportSearchObject.financialMonth != "") {
            searchString = searchString + 'financialMonth:' + bsbReportSearchObject.financialMonth + ',';
        }

        if (bsbReportSearchObject.shipToCustomerName != undefined && bsbReportSearchObject.shipToCustomerName != "") {
            searchString = searchString + 'shipToCustomerName:' + bsbReportSearchObject.shipToCustomerName + ',';
        }

        if (bsbReportSearchObject.shipToCountry != undefined && bsbReportSearchObject.shipToCountry != "") {
            searchString = searchString + 'shipToCountry:' + bsbReportSearchObject.shipToCountry + ',';
        }

        if (bsbReportSearchObject.billToCustomerName != undefined && bsbReportSearchObject.billToCustomerName != "") {
            searchString = searchString + 'billToCustomerName:' + bsbReportSearchObject.billToCustomerName + ',';
        }

        if (bsbReportSearchObject.billToState != undefined && bsbReportSearchObject.billToState != "") {
            searchString = searchString + 'billToState:' + bsbReportSearchObject.billToState + ',';
        }

        if (bsbReportSearchObject.billToCountry != undefined && bsbReportSearchObject.billToCountry != "") {
            searchString = searchString + 'billToCountry:' + bsbReportSearchObject.billToCountry + ',';
        }

        if (bsbReportSearchObject.customerPo != undefined && bsbReportSearchObject.customerPo != "") {
            searchString = searchString + 'customerPo:' + bsbReportSearchObject.customerPo + ',';
        }

        if (bsbReportSearchObject.fob != undefined && bsbReportSearchObject.fob != "") {
            searchString = searchString + 'fob:' + bsbReportSearchObject.fob + ',';
        }

        if (bsbReportSearchObject.freightTerms != undefined && bsbReportSearchObject.freightTerms != "") {
            searchString = searchString + 'freightTerms:' + bsbReportSearchObject.freightTerms + ',';
        }

        if (bsbReportSearchObject.freightCarrier != undefined && bsbReportSearchObject.freightCarrier != "") {
            searchString = searchString + 'freightCarrier:' + bsbReportSearchObject.freightCarrier + ',';
        }

        if (bsbReportSearchObject.orderNumber != undefined && bsbReportSearchObject.orderNumber != "") {
            searchString = searchString + 'orderNumber:' + bsbReportSearchObject.orderNumber + ',';
        }

        if (bsbReportSearchObject.orderLine != undefined && bsbReportSearchObject.orderLine != "") {
            searchString = searchString + 'orderLine:' + bsbReportSearchObject.orderLine + ',';
        }

        if (bsbReportSearchObject.orderType != undefined && bsbReportSearchObject.orderType != "") {
            searchString = searchString + 'orderType:' + bsbReportSearchObject.orderType + ',';
        }

        if (bsbReportSearchObject.subOrderType != undefined && bsbReportSearchObject.subOrderType != "") {
            searchString = searchString + 'subOrderType:' + bsbReportSearchObject.subOrderType + ',';
        }

        if (bsbReportSearchObject.isRevenue != undefined && bsbReportSearchObject.isRevenue != "") {
            searchString = searchString + 'isRevenue:' + bsbReportSearchObject.isRevenue + ',';
        }

        if (bsbReportSearchObject.salesrepName != undefined && bsbReportSearchObject.salesrepName != "") {
            searchString = searchString + 'salesrepName:' + bsbReportSearchObject.salesrepName + ',';
        }

        if (bsbReportSearchObject.region != undefined && bsbReportSearchObject.region != "") {
            searchString = searchString + 'region:' + bsbReportSearchObject.region + ',';
        }

        if (bsbReportSearchObject.productNumber != undefined && bsbReportSearchObject.productNumber != "") {
            searchString = searchString + 'productNumber:' + bsbReportSearchObject.productNumber + ',';
        }

        if (bsbReportSearchObject.productFamily != undefined && bsbReportSearchObject.productFamily != "") {
            searchString = searchString + 'productFamily:' + bsbReportSearchObject.productFamily + ',';
        }

        if (bsbReportSearchObject.productLine != undefined && bsbReportSearchObject.productLine != "") {
            searchString = searchString + 'productLine:' + bsbReportSearchObject.productLine + ',';
        }

        if (bsbReportSearchObject.shipDate != undefined && bsbReportSearchObject.shipDate != "") {
            searchString = searchString + 'shipDate:' + bsbReportSearchObject.shipDate + ',';
        }

        if (bsbReportSearchObject.invoiceNumber != undefined && bsbReportSearchObject.invoiceNumber != "") {
            searchString = searchString + 'invoiceNumber:' + bsbReportSearchObject.invoiceNumber + ',';
        }

        if (bsbReportSearchObject.invoiceLine != undefined && bsbReportSearchObject.invoiceLine != "") {
            searchString = searchString + 'invoiceLine:' + bsbReportSearchObject.invoiceLine + ',';
        }

        if (bsbReportSearchObject.shippedQuantity != undefined && bsbReportSearchObject.shippedQuantity != "") {
            searchString = searchString + 'shippedQuantity:' + bsbReportSearchObject.shippedQuantity + ',';
        }

        if (bsbReportSearchObject.extendedCost != undefined && bsbReportSearchObject.extendedCost != "") {
            searchString = searchString + 'extendedCost:' + bsbReportSearchObject.extendedCost + ',';
        }

        if (bsbReportSearchObject.shippedAmount != undefined && bsbReportSearchObject.shippedAmount != "") {
            searchString = searchString + 'shippedAmount:' + bsbReportSearchObject.shippedAmount + ',';
        }

        if (bsbReportSearchObject.division != undefined && bsbReportSearchObject.division != "") {
            searchString = searchString + 'division:' + bsbReportSearchObject.division + ',';
        }

        if (bsbReportSearchObject.totalMonths != undefined && bsbReportSearchObject.totalMonths != "") {
            searchString = searchString + 'totalMonths:' + bsbReportSearchObject.totalMonths + ',';
        }

        if (bsbReportSearchObject.serviceCode != undefined && bsbReportSearchObject.serviceCode != "") {
            searchString = searchString + 'serviceCode:' + bsbReportSearchObject.serviceCode + ',';
        }

        if (bsbReportSearchObject.endCustomer != undefined && bsbReportSearchObject.endCustomer != "") {
            searchString = searchString + 'endCustomer:' + bsbReportSearchObject.endCustomer + ',';
        }

        if (bsbReportSearchObject.snExists != undefined && bsbReportSearchObject.snExists != "") {
            searchString = searchString + 'snExists:' + bsbReportSearchObject.snExists + ',';
        }

        if (bsbReportSearchObject.username != undefined && bsbReportSearchObject.username != "") {
            searchString = searchString + 'username:' + bsbReportSearchObject.username + ',';
        }

        if (bsbReportSearchObject.itemType != undefined && bsbReportSearchObject.itemType != "") {
            searchString = searchString + 'itemType:' + bsbReportSearchObject.itemType + ',';
        }

        if (bsbReportSearchObject.warrantyTransferred != undefined && bsbReportSearchObject.warrantyTransferred != "") {
            searchString = searchString + 'warrantyTransferred:' + bsbReportSearchObject.warrantyTransferred + ',';
        }

        if (bsbReportSearchObject.serviceStartDate != undefined && bsbReportSearchObject.serviceStartDate != "") {
            searchString = searchString + 'serviceStartDate:' + bsbReportSearchObject.serviceStartDate + ',';
        }

        if (bsbReportSearchObject.serviceEndDate != undefined && bsbReportSearchObject.serviceEndDate != "") {
            searchString = searchString + 'serviceEndDate:' + bsbReportSearchObject.serviceEndDate + ',';
        }

        if (bsbReportSearchObject.productService != undefined && bsbReportSearchObject.productService != "") {
            searchString = searchString + 'productService:' + bsbReportSearchObject.productService + ',';
        }

        if (bsbReportSearchObject.productFamily2 != undefined && bsbReportSearchObject.productFamily2 != "") {
            searchString = searchString + 'productFamily2:' + bsbReportSearchObject.productFamily2 + ',';
        }

        if (bsbReportSearchObject.note != undefined && bsbReportSearchObject.note != "") {
            searchString = searchString + 'note:' + bsbReportSearchObject.note + ',';
        }

        if (bsbReportSearchObject.je != undefined && bsbReportSearchObject.je != "") {
            searchString = searchString + 'je:' + bsbReportSearchObject.je + ',';
        }

        if (bsbReportSearchObject.geography10k != undefined && bsbReportSearchObject.geography10k != "") {
            searchString = searchString + 'geography10k:' + bsbReportSearchObject.geography10k + ',';
        }

        if (bsbReportSearchObject.concatenate != undefined && bsbReportSearchObject.concatenate != "") {
            searchString = searchString + 'concatenate:' + bsbReportSearchObject.concatenate + ',';
        }

        if (bsbReportSearchObject.source != undefined && bsbReportSearchObject.source != "") {
            searchString = searchString + 'source:' + bsbReportSearchObject.source + ',';
        }

        if (bsbReportSearchObject.extendedWarranty != undefined && bsbReportSearchObject.extendedWarranty != "") {
            searchString = searchString + 'extendedWarranty:' + bsbReportSearchObject.extendedWarranty + ',';
        }

        if (bsbReportSearchObject.reasonForExclusion != undefined && bsbReportSearchObject.reasonForExclusion != "") {
            searchString = searchString + 'reasonForExclusion:' + bsbReportSearchObject.reasonForExclusion + ',';
        }

        if (bsbReportSearchObject.serviceMaintLegacy != undefined && bsbReportSearchObject.serviceMaintLegacy != "") {
            searchString = searchString + 'serviceMaintLegacy:' + bsbReportSearchObject.serviceMaintLegacy + ',';
        }

        if (bsbReportSearchObject.reasonForExclusion2 != undefined && bsbReportSearchObject.reasonForExclusion2 != "") {
            searchString = searchString + 'reasonForExclusion2:' + bsbReportSearchObject.reasonForExclusion2 + ',';
        }

        if (bsbReportSearchObject.serviceMaintNewParts != undefined && bsbReportSearchObject.serviceMaintNewParts != "") {
            searchString = searchString + 'serviceMaintNewParts:' + bsbReportSearchObject.serviceMaintNewParts + ',';
        }

        if (bsbReportSearchObject.reasonForExclusion3 != undefined && bsbReportSearchObject.reasonForExclusion3 != "") {
            searchString = searchString + 'reasonForExclusion3:' + bsbReportSearchObject.reasonForExclusion3;
        }
        if (searchFields.financialMonth != undefined && searchFields.financialMonth != "") {
            searchString = searchString + 'financialMonth:' + searchFields.financialMonth + ',';
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

    getAllBsbReport(paginationOptions: any, bsbReportSearchObject: any, searchFields: any) {

        let serviceUrl = this.getServiceUrl(paginationOptions, bsbReportSearchObject, 0, searchFields);

        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });


    }
    searchBsbReport(bsbReport: any): Promise<any[]> {
        return this.http.get(appSettings.apiUrl + '/BSB_REPORT/search/findByFinancialMonthAndShipToCustomerNameAndShipToCountryAndBillToCustomerNameAndBillToStateAndBillToCountryAndCustomerPoAndFobAndFreightTermsAndFreightCarrierAndOrderNumberAndOrderLineAndOrderTypeAndSubOrderTypeAndIsRevenueAndSalesrepNameAndRegionAndProductNumberAndProductFamilyAndProductLineAndShipDateAndInvoiceNumberAndInvoiceLineAndShippedQuantityAndExtendedCostAndShippedAmountAndDivisionAndTotalMonthsAndServiceCodeAndEndCustomerAndSnExistsAndUsernameAndItemTypeAndWarrantyTransferredAndServiceStartDateAndServiceEndDateAndProductServiceAndProductFamily2AndNoteAndJeAndGeography10kAndConcatenateAndSourceAndExtendedWarrantyAndReasonForExclusionAndServiceMaintLegacyAndReasonForExclusion2AndServiceMaintNewPartsAndReasonForExclusion3?financialMonth=' + bsbReport.financialMonth + '&shipToCustomerName=' + bsbReport.shipToCustomerName + '&shipToCountry=' + bsbReport.shipToCountry + '&billToCustomerName=' + bsbReport.billToCustomerName + '&billToState=' + bsbReport.billToState + '&billToCountry=' + bsbReport.billToCountry + '&customerPo=' + bsbReport.customerPo + '&fob=' + bsbReport.fob + '&freightTerms=' + bsbReport.freightTerms + '&freightCarrier=' + bsbReport.freightCarrier + '&orderNumber=' + bsbReport.orderNumber + '&orderLine=' + bsbReport.orderLine + '&orderType=' + bsbReport.orderType + '&subOrderType=' + bsbReport.subOrderType + '&isRevenue=' + bsbReport.isRevenue + '&salesrepName=' + bsbReport.salesrepName + '&region=' + bsbReport.region + '&productNumber=' + bsbReport.productNumber + '&productFamily=' + bsbReport.productFamily + '&productLine=' + bsbReport.productLine + '&shipDate=' + bsbReport.shipDate + '&invoiceNumber=' + bsbReport.invoiceNumber + '&invoiceLine=' + bsbReport.invoiceLine + '&shippedQuantity=' + bsbReport.shippedQuantity + '&extendedCost=' + bsbReport.extendedCost + '&shippedAmount=' + bsbReport.shippedAmount + '&division=' + bsbReport.division + '&totalMonths=' + bsbReport.totalMonths + '&serviceCode=' + bsbReport.serviceCode + '&endCustomer=' + bsbReport.endCustomer + '&snExists=' + bsbReport.snExists + '&username=' + bsbReport.username + '&itemType=' + bsbReport.itemType + '&warrantyTransferred=' + bsbReport.warrantyTransferred + '&serviceStartDate=' + bsbReport.serviceStartDate + '&serviceEndDate=' + bsbReport.serviceEndDate + '&productService=' + bsbReport.productService + '&productFamily2=' + bsbReport.productFamily2 + '&note=' + bsbReport.note + '&je=' + bsbReport.je + '&geography10k=' + bsbReport.geography10k + '&concatenate=' + bsbReport.concatenate + '&source=' + bsbReport.source + '&extendedWarranty=' + bsbReport.extendedWarranty + '&reasonForExclusion=' + bsbReport.reasonForExclusion + '&serviceMaintLegacy=' + bsbReport.serviceMaintLegacy + '&reasonForExclusion2=' + bsbReport.reasonForExclusion2 + '&serviceMaintNewParts=' + bsbReport.serviceMaintNewParts + '&reasonForExclusion3=' + bsbReport.reasonForExclusion3).toPromise().then((data: any) => {
            return data;
        });
    }

    saveBsbReport(bsbReport: any): Promise<any[]> {
        let body = JSON.stringify(bsbReport);
        return this.http.post(appSettings.apiUrl + '/BSB_REPORT', body, httpOptions).toPromise().then((data: any) => {
            return data;
        });
    }

    updateBsbReport(bsbReport: any): Promise<any[]> {

        delete bsbReport._links;
        delete bsbReport.interests;
        let body = JSON.stringify(bsbReport);
        return this.http.put(appSettings.apiUrl + '/BSB_REPORT/' + bsbReport.financialMonth, body, httpOptions).toPromise().then((data: any) => {
            return data;
        });

    }

    deleteBsbReport(bsbReport: any): Promise<any[]> {
        let deleteUrl = appSettings.apiUrl + '/BSB_REPORT/' + bsbReport.financialMonth;
        return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
            return data;
        });
    }

}
