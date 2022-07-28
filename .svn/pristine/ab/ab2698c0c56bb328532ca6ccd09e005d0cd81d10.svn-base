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
export class RmanDealDetailsService {

  constructor(private http: HttpClient) { }

  getServiceUrl(paginationOptions: any, rmanDealDetailsSearchObject: any, exportFlag: any, exportCols: any) {

    let serviceUrl = appSettings.apiUrl + '/rmanDealDetailsExport?';

    if (exportFlag == 0) {
      serviceUrl = appSettings.apiUrl + '/rmanDealDetailsSearch?';
    }

    let searchString = '';

    if (rmanDealDetailsSearchObject.dealHeaderId != undefined && rmanDealDetailsSearchObject.dealHeaderId != "") {
      searchString = searchString + 'dealHeaderId:' + rmanDealDetailsSearchObject.dealHeaderId + ',';
    }

    if (rmanDealDetailsSearchObject.dealNumber != undefined && rmanDealDetailsSearchObject.dealNumber != "") {
      searchString = searchString + 'dealNumber:' + rmanDealDetailsSearchObject.dealNumber + ',';
    }

    if (rmanDealDetailsSearchObject.dealType != undefined && rmanDealDetailsSearchObject.dealType != "") {
      searchString = searchString + 'dealType:' + rmanDealDetailsSearchObject.dealType + ',';
    }

    if (rmanDealDetailsSearchObject.legalEntityId != undefined && rmanDealDetailsSearchObject.legalEntityId != "") {
      searchString = searchString + 'legalEntityId:' + rmanDealDetailsSearchObject.legalEntityId + ',';
    }

    if (rmanDealDetailsSearchObject.dealStatus != undefined && rmanDealDetailsSearchObject.dealStatus != "") {
      searchString = searchString + 'dealStatus:' + rmanDealDetailsSearchObject.dealStatus + ',';
    }

    if (rmanDealDetailsSearchObject.endCustomerName != undefined && rmanDealDetailsSearchObject.endCustomerName != "") {
      searchString = searchString + 'endCustomerName:' + rmanDealDetailsSearchObject.endCustomerName + ',';
    }

    if (rmanDealDetailsSearchObject.customerType != undefined && rmanDealDetailsSearchObject.customerType != "") {
      searchString = searchString + 'customerType:' + rmanDealDetailsSearchObject.customerType + ',';
    }

    if (rmanDealDetailsSearchObject.endCustomerNum != undefined && rmanDealDetailsSearchObject.endCustomerNum != "") {
      searchString = searchString + 'endCustomerNum:' + rmanDealDetailsSearchObject.endCustomerNum + ',';
    }

    if (rmanDealDetailsSearchObject.billToCustomerName != undefined && rmanDealDetailsSearchObject.billToCustomerName != "") {
      searchString = searchString + 'billToCustomerName:' + rmanDealDetailsSearchObject.billToCustomerName + ',';
    }

    if (rmanDealDetailsSearchObject.billToCountry != undefined && rmanDealDetailsSearchObject.billToCountry != "") {
      searchString = searchString + 'billToCountry:' + rmanDealDetailsSearchObject.billToCountry + ',';
    }

    if (rmanDealDetailsSearchObject.shipToCountry != undefined && rmanDealDetailsSearchObject.shipToCountry != "") {
      searchString = searchString + 'shipToCountry:' + rmanDealDetailsSearchObject.shipToCountry + ',';
    }

    if (rmanDealDetailsSearchObject.opportunityName != undefined && rmanDealDetailsSearchObject.opportunityName != "") {
      searchString = searchString + 'opportunityName:' + rmanDealDetailsSearchObject.opportunityName + ',';
    }

    if (rmanDealDetailsSearchObject.opportunityNum != undefined && rmanDealDetailsSearchObject.opportunityNum != "") {
      searchString = searchString + 'opportunityNum:' + rmanDealDetailsSearchObject.opportunityNum + ',';
    }

    if (rmanDealDetailsSearchObject.priceList != undefined && rmanDealDetailsSearchObject.priceList != "") {
      searchString = searchString + 'priceList:' + rmanDealDetailsSearchObject.priceList + ',';
    }

    if (rmanDealDetailsSearchObject.forecastCode != undefined && rmanDealDetailsSearchObject.forecastCode != "") {
      searchString = searchString + 'forecastCode:' + rmanDealDetailsSearchObject.forecastCode + ',';
    }

    if (rmanDealDetailsSearchObject.agreementCode != undefined && rmanDealDetailsSearchObject.agreementCode != "") {
      searchString = searchString + 'agreementCode:' + rmanDealDetailsSearchObject.agreementCode + ',';
    }

    if (rmanDealDetailsSearchObject.dealCurrencyCode != undefined && rmanDealDetailsSearchObject.dealCurrencyCode != "") {
      searchString = searchString + 'dealCurrencyCode:' + rmanDealDetailsSearchObject.dealCurrencyCode + ',';
    }

    if (rmanDealDetailsSearchObject.conversionRate != undefined && rmanDealDetailsSearchObject.conversionRate != "") {
      searchString = searchString + 'conversionRate:' + rmanDealDetailsSearchObject.conversionRate + ',';
    }

    if (rmanDealDetailsSearchObject.paymentTerms != undefined && rmanDealDetailsSearchObject.paymentTerms != "") {
      searchString = searchString + 'paymentTerms:' + rmanDealDetailsSearchObject.paymentTerms + ',';
    }

    if (rmanDealDetailsSearchObject.conversionType != undefined && rmanDealDetailsSearchObject.conversionType != "") {
      searchString = searchString + 'conversionType:' + rmanDealDetailsSearchObject.conversionType + ',';
    }

    if (rmanDealDetailsSearchObject.conversionDate != undefined && rmanDealDetailsSearchObject.conversionDate != "") {
      searchString = searchString + 'conversionDate:' + rmanDealDetailsSearchObject.conversionDate + ',';
    }

    if (rmanDealDetailsSearchObject.partnerName != undefined && rmanDealDetailsSearchObject.partnerName != "") {
      searchString = searchString + 'partnerName:' + rmanDealDetailsSearchObject.partnerName + ',';
    }

    if (rmanDealDetailsSearchObject.salesrepName != undefined && rmanDealDetailsSearchObject.salesrepName != "") {
      searchString = searchString + 'salesrepName:' + rmanDealDetailsSearchObject.salesrepName + ',';
    }

    if (rmanDealDetailsSearchObject.salesTerritory != undefined && rmanDealDetailsSearchObject.salesTerritory != "") {
      searchString = searchString + 'salesTerritory:' + rmanDealDetailsSearchObject.salesTerritory + ',';
    }

    if (rmanDealDetailsSearchObject.salesChannel != undefined && rmanDealDetailsSearchObject.salesChannel != "") {
      searchString = searchString + 'salesChannel:' + rmanDealDetailsSearchObject.salesChannel + ',';
    }

    if (rmanDealDetailsSearchObject.financeContact != undefined && rmanDealDetailsSearchObject.financeContact != "") {
      searchString = searchString + 'financeContact:' + rmanDealDetailsSearchObject.financeContact + ',';
    }

    if (rmanDealDetailsSearchObject.financeContactId != undefined && rmanDealDetailsSearchObject.financeContactId != "") {
      searchString = searchString + 'financeContactId:' + rmanDealDetailsSearchObject.financeContactId + ',';
    }

    if (rmanDealDetailsSearchObject.salesOpsName != undefined && rmanDealDetailsSearchObject.salesOpsName != "") {
      searchString = searchString + 'salesOpsName:' + rmanDealDetailsSearchObject.salesOpsName + ',';
    }

    if (rmanDealDetailsSearchObject.salesOpsId != undefined && rmanDealDetailsSearchObject.salesOpsId != "") {
      searchString = searchString + 'salesOpsId:' + rmanDealDetailsSearchObject.salesOpsId + ',';
    }

    if (rmanDealDetailsSearchObject.dealArrangementId != undefined && rmanDealDetailsSearchObject.dealArrangementId != "") {
      searchString = searchString + 'dealArrangementId:' + rmanDealDetailsSearchObject.dealArrangementId + ',';
    }

    if (rmanDealDetailsSearchObject.dealLineId != undefined && rmanDealDetailsSearchObject.dealLineId != "") {
      searchString = searchString + 'dealLineId:' + rmanDealDetailsSearchObject.dealLineId + ',';
    }

    if (rmanDealDetailsSearchObject.dealLineNumber != undefined && rmanDealDetailsSearchObject.dealLineNumber != "") {
      searchString = searchString + 'dealLineNumber:' + rmanDealDetailsSearchObject.dealLineNumber + ',';
    }

    if (rmanDealDetailsSearchObject.productName != undefined && rmanDealDetailsSearchObject.productName != "") {
      searchString = searchString + 'productName:' + rmanDealDetailsSearchObject.productName + ',';
    }

    if (rmanDealDetailsSearchObject.fmvRuleDefId != undefined && rmanDealDetailsSearchObject.fmvRuleDefId != "") {
      searchString = searchString + 'fmvRuleDefId:' + rmanDealDetailsSearchObject.fmvRuleDefId + ',';
    }

    if (rmanDealDetailsSearchObject.quantity != undefined && rmanDealDetailsSearchObject.quantity != "") {
      searchString = searchString + 'quantity:' + rmanDealDetailsSearchObject.quantity + ',';
    }

    if (rmanDealDetailsSearchObject.unitListPrice != undefined && rmanDealDetailsSearchObject.unitListPrice != "") {
      searchString = searchString + 'unitListPrice:' + rmanDealDetailsSearchObject.unitListPrice + ',';
    }

    if (rmanDealDetailsSearchObject.repUnitListPrice != undefined && rmanDealDetailsSearchObject.repUnitListPrice != "") {
      searchString = searchString + 'repUnitListPrice:' + rmanDealDetailsSearchObject.repUnitListPrice + ',';
    }

    if (rmanDealDetailsSearchObject.repUnitSellingPrice != undefined && rmanDealDetailsSearchObject.repUnitSellingPrice != "") {
      searchString = searchString + 'repUnitSellingPrice:' + rmanDealDetailsSearchObject.repUnitSellingPrice + ',';
    }

    if (rmanDealDetailsSearchObject.unitSellingPrice != undefined && rmanDealDetailsSearchObject.unitSellingPrice != "") {
      searchString = searchString + 'unitSellingPrice:' + rmanDealDetailsSearchObject.unitSellingPrice + ',';
    }

    if (rmanDealDetailsSearchObject.elementType != undefined && rmanDealDetailsSearchObject.elementType != "") {
      searchString = searchString + 'elementType:' + rmanDealDetailsSearchObject.elementType + ',';
    }

    if (rmanDealDetailsSearchObject.accountingScope != undefined && rmanDealDetailsSearchObject.accountingScope != "") {
      searchString = searchString + 'accountingScope:' + rmanDealDetailsSearchObject.accountingScope + ',';
    }

    if (rmanDealDetailsSearchObject.serviceStartDate != undefined && rmanDealDetailsSearchObject.serviceStartDate != "") {
      searchString = searchString + 'serviceStartDate:' + rmanDealDetailsSearchObject.serviceStartDate + ',';
    }

    if (rmanDealDetailsSearchObject.serviceEndDate != undefined && rmanDealDetailsSearchObject.serviceEndDate != "") {
      searchString = searchString + 'serviceEndDate:' + rmanDealDetailsSearchObject.serviceEndDate + ',';
    }

    if (rmanDealDetailsSearchObject.serviceDuration != undefined && rmanDealDetailsSearchObject.serviceDuration != "") {
      searchString = searchString + 'serviceDuration:' + rmanDealDetailsSearchObject.serviceDuration + ',';
    }

    if (rmanDealDetailsSearchObject.serviceDurationUom != undefined && rmanDealDetailsSearchObject.serviceDurationUom != "") {
      searchString = searchString + 'serviceDurationUom:' + rmanDealDetailsSearchObject.serviceDurationUom + ',';
    }

    if (rmanDealDetailsSearchObject.dealLineCost != undefined && rmanDealDetailsSearchObject.dealLineCost != "") {
      searchString = searchString + 'dealLineCost:' + rmanDealDetailsSearchObject.dealLineCost + ',';
    }

    if (rmanDealDetailsSearchObject.allocationAmount != undefined && rmanDealDetailsSearchObject.allocationAmount != "") {
      searchString = searchString + 'allocationAmount:' + rmanDealDetailsSearchObject.allocationAmount + ',';
    }

    if (rmanDealDetailsSearchObject.cvInOutAmount != undefined && rmanDealDetailsSearchObject.cvInOutAmount != "") {
      searchString = searchString + 'cvInOutAmount:' + rmanDealDetailsSearchObject.cvInOutAmount + ',';
    }

    if (rmanDealDetailsSearchObject.accounintRuleName != undefined && rmanDealDetailsSearchObject.accounintRuleName != "") {
      searchString = searchString + 'accounintRuleName:' + rmanDealDetailsSearchObject.accounintRuleName + ',';
    }

    if (rmanDealDetailsSearchObject.createdDate != undefined && rmanDealDetailsSearchObject.createdDate != "") {
      searchString = searchString + 'createdDate:' + rmanDealDetailsSearchObject.createdDate + ',';
    }

    if (rmanDealDetailsSearchObject.createdBy != undefined && rmanDealDetailsSearchObject.createdBy != "") {
      searchString = searchString + 'createdBy:' + rmanDealDetailsSearchObject.createdBy + ',';
    }

    if (rmanDealDetailsSearchObject.lastUpdatedDate != undefined && rmanDealDetailsSearchObject.lastUpdatedDate != "") {
      searchString = searchString + 'lastUpdatedDate:' + rmanDealDetailsSearchObject.lastUpdatedDate + ',';
    }

    if (rmanDealDetailsSearchObject.lastUpdatedBy != undefined && rmanDealDetailsSearchObject.lastUpdatedBy != "") {
      searchString = searchString + 'lastUpdatedBy:' + rmanDealDetailsSearchObject.lastUpdatedBy + ',';
    }

    if (rmanDealDetailsSearchObject.attribute1 != undefined && rmanDealDetailsSearchObject.attribute1 != "") {
      searchString = searchString + 'attribute1:' + rmanDealDetailsSearchObject.attribute1 + ',';
    }

    if (rmanDealDetailsSearchObject.attribute2 != undefined && rmanDealDetailsSearchObject.attribute2 != "") {
      searchString = searchString + 'attribute2:' + rmanDealDetailsSearchObject.attribute2 + ',';
    }

    if (rmanDealDetailsSearchObject.attribute3 != undefined && rmanDealDetailsSearchObject.attribute3 != "") {
      searchString = searchString + 'attribute3:' + rmanDealDetailsSearchObject.attribute3 + ',';
    }

    if (rmanDealDetailsSearchObject.attribute4 != undefined && rmanDealDetailsSearchObject.attribute4 != "") {
      searchString = searchString + 'attribute4:' + rmanDealDetailsSearchObject.attribute4 + ',';
    }

    if (rmanDealDetailsSearchObject.attribute5 != undefined && rmanDealDetailsSearchObject.attribute5 != "") {
      searchString = searchString + 'attribute5:' + rmanDealDetailsSearchObject.attribute5 + ',';
    }

    if (rmanDealDetailsSearchObject.attribute6 != undefined && rmanDealDetailsSearchObject.attribute6 != "") {
      searchString = searchString + 'attribute6:' + rmanDealDetailsSearchObject.attribute6 + ',';
    }

    if (rmanDealDetailsSearchObject.attribute7 != undefined && rmanDealDetailsSearchObject.attribute7 != "") {
      searchString = searchString + 'attribute7:' + rmanDealDetailsSearchObject.attribute7 + ',';
    }

    if (rmanDealDetailsSearchObject.attribute8 != undefined && rmanDealDetailsSearchObject.attribute8 != "") {
      searchString = searchString + 'attribute8:' + rmanDealDetailsSearchObject.attribute8 + ',';
    }

    if (rmanDealDetailsSearchObject.attribute9 != undefined && rmanDealDetailsSearchObject.attribute9 != "") {
      searchString = searchString + 'attribute9:' + rmanDealDetailsSearchObject.attribute9 + ',';
    }

    if (rmanDealDetailsSearchObject.attribute10 != undefined && rmanDealDetailsSearchObject.attribute10 != "") {
      searchString = searchString + 'attribute10:' + rmanDealDetailsSearchObject.attribute10 + ',';
    }

    if (rmanDealDetailsSearchObject.attribute11 != undefined && rmanDealDetailsSearchObject.attribute11 != "") {
      searchString = searchString + 'attribute11:' + rmanDealDetailsSearchObject.attribute11 + ',';
    }

    if (rmanDealDetailsSearchObject.attribute12 != undefined && rmanDealDetailsSearchObject.attribute12 != "") {
      searchString = searchString + 'attribute12:' + rmanDealDetailsSearchObject.attribute12 + ',';
    }

    if (rmanDealDetailsSearchObject.attribute13 != undefined && rmanDealDetailsSearchObject.attribute13 != "") {
      searchString = searchString + 'attribute13:' + rmanDealDetailsSearchObject.attribute13 + ',';
    }

    if (rmanDealDetailsSearchObject.attribute14 != undefined && rmanDealDetailsSearchObject.attribute14 != "") {
      searchString = searchString + 'attribute14:' + rmanDealDetailsSearchObject.attribute14 + ',';
    }

    if (rmanDealDetailsSearchObject.attribute15 != undefined && rmanDealDetailsSearchObject.attribute15 != "") {
      searchString = searchString + 'attribute15:' + rmanDealDetailsSearchObject.attribute15 + ',';
    }

    if (rmanDealDetailsSearchObject.eitfSop != undefined && rmanDealDetailsSearchObject.eitfSop != "") {
      searchString = searchString + 'eitfSop:' + rmanDealDetailsSearchObject.eitfSop + ',';
    }

    if (rmanDealDetailsSearchObject.fmvAmount != undefined && rmanDealDetailsSearchObject.fmvAmount != "") {
      searchString = searchString + 'fmvAmount:' + rmanDealDetailsSearchObject.fmvAmount + ',';
    }

    if (rmanDealDetailsSearchObject.dealDate != undefined && rmanDealDetailsSearchObject.dealDate != "") {
      searchString = searchString + 'dealDate:' + rmanDealDetailsSearchObject.dealDate + ',';
    }

    if (rmanDealDetailsSearchObject.repCurrCode != undefined && rmanDealDetailsSearchObject.repCurrCode != "") {
      searchString = searchString + 'repCurrCode:' + rmanDealDetailsSearchObject.repCurrCode + ',';
    }

    if (rmanDealDetailsSearchObject.lineId != undefined && rmanDealDetailsSearchObject.lineId != "") {
      searchString = searchString + 'lineId:' + rmanDealDetailsSearchObject.lineId + ',';
    }

    if (rmanDealDetailsSearchObject.parentLineId != undefined && rmanDealDetailsSearchObject.parentLineId != "") {
      searchString = searchString + 'parentLineId:' + rmanDealDetailsSearchObject.parentLineId + ',';
    }

    if (rmanDealDetailsSearchObject.expectedStartDate != undefined && rmanDealDetailsSearchObject.expectedStartDate != "") {
      searchString = searchString + 'expectedStartDate:' + rmanDealDetailsSearchObject.expectedStartDate + ',';
    }

    if (rmanDealDetailsSearchObject.expectedEndDate != undefined && rmanDealDetailsSearchObject.expectedEndDate != "") {
      searchString = searchString + 'expectedEndDate:' + rmanDealDetailsSearchObject.expectedEndDate + ',';
    }

    if (rmanDealDetailsSearchObject.durationUom != undefined && rmanDealDetailsSearchObject.durationUom != "") {
      searchString = searchString + 'durationUom:' + rmanDealDetailsSearchObject.durationUom + ',';
    }

    if (rmanDealDetailsSearchObject.expectedSplit != undefined && rmanDealDetailsSearchObject.expectedSplit != "") {
      searchString = searchString + 'expectedSplit:' + rmanDealDetailsSearchObject.expectedSplit + ',';
    }

    if (rmanDealDetailsSearchObject.contingencyCode != undefined && rmanDealDetailsSearchObject.contingencyCode != "") {
      searchString = searchString + 'contingencyCode:' + rmanDealDetailsSearchObject.contingencyCode + ',';
    }

    if (rmanDealDetailsSearchObject.agreementName != undefined && rmanDealDetailsSearchObject.agreementName != "") {
      searchString = searchString + 'agreementName:' + rmanDealDetailsSearchObject.agreementName + ',';
    }

    if (rmanDealDetailsSearchObject.subElementType != undefined && rmanDealDetailsSearchObject.subElementType != "") {
      searchString = searchString + 'subElementType:' + rmanDealDetailsSearchObject.subElementType + ',';
    }

    if (rmanDealDetailsSearchObject.expectedDuration != undefined && rmanDealDetailsSearchObject.expectedDuration != "") {
      searchString = searchString + 'expectedDuration:' + rmanDealDetailsSearchObject.expectedDuration + ',';
    }

    if (rmanDealDetailsSearchObject.contTransHeaderId != undefined && rmanDealDetailsSearchObject.contTransHeaderId != "") {
      searchString = searchString + 'contTransHeaderId:' + rmanDealDetailsSearchObject.contTransHeaderId + ',';
    }

    if (rmanDealDetailsSearchObject.analystId != undefined && rmanDealDetailsSearchObject.analystId != "") {
      searchString = searchString + 'analystId:' + rmanDealDetailsSearchObject.analystId + ',';
    }

    if (rmanDealDetailsSearchObject.approverId != undefined && rmanDealDetailsSearchObject.approverId != "") {
      searchString = searchString + 'approverId:' + rmanDealDetailsSearchObject.approverId + ',';
    }

    if (rmanDealDetailsSearchObject.productOrgId != undefined && rmanDealDetailsSearchObject.productOrgId != "") {
      searchString = searchString + 'productOrgId:' + rmanDealDetailsSearchObject.productOrgId + ',';
    }

    if (rmanDealDetailsSearchObject.argBasisLineNumber != undefined && rmanDealDetailsSearchObject.argBasisLineNumber != "") {
      searchString = searchString + 'argBasisLineNumber:' + rmanDealDetailsSearchObject.argBasisLineNumber + ',';
    }

    if (rmanDealDetailsSearchObject.billToCustomerNum != undefined && rmanDealDetailsSearchObject.billToCustomerNum != "") {
      searchString = searchString + 'billToCustomerNum:' + rmanDealDetailsSearchObject.billToCustomerNum + ',';
    }

    if (rmanDealDetailsSearchObject.billToSiteNum != undefined && rmanDealDetailsSearchObject.billToSiteNum != "") {
      searchString = searchString + 'billToSiteNum:' + rmanDealDetailsSearchObject.billToSiteNum + ',';
    }

    if (rmanDealDetailsSearchObject.shipToSiteNum != undefined && rmanDealDetailsSearchObject.shipToSiteNum != "") {
      searchString = searchString + 'shipToSiteNum:' + rmanDealDetailsSearchObject.shipToSiteNum + ',';
    }

    if (rmanDealDetailsSearchObject.contractStartDate != undefined && rmanDealDetailsSearchObject.contractStartDate != "") {
      searchString = searchString + 'contractStartDate:' + rmanDealDetailsSearchObject.contractStartDate + ',';
    }

    if (rmanDealDetailsSearchObject.contractEndDate != undefined && rmanDealDetailsSearchObject.contractEndDate != "") {
      searchString = searchString + 'contractEndDate:' + rmanDealDetailsSearchObject.contractEndDate + ',';
    }

    if (rmanDealDetailsSearchObject.allocationFlag != undefined && rmanDealDetailsSearchObject.allocationFlag != "") {
      searchString = searchString + 'allocationFlag:' + rmanDealDetailsSearchObject.allocationFlag + ',';
    }

    if (rmanDealDetailsSearchObject.directCv != undefined && rmanDealDetailsSearchObject.directCv != "") {
      searchString = searchString + 'directCv:' + rmanDealDetailsSearchObject.directCv + ',';
    }

    if (rmanDealDetailsSearchObject.cvPercent != undefined && rmanDealDetailsSearchObject.cvPercent != "") {
      searchString = searchString + 'cvPercent:' + rmanDealDetailsSearchObject.cvPercent + ',';
    }

    if (rmanDealDetailsSearchObject.directCvAmount != undefined && rmanDealDetailsSearchObject.directCvAmount != "") {
      searchString = searchString + 'directCvAmount:' + rmanDealDetailsSearchObject.directCvAmount + ',';
    }

    if (rmanDealDetailsSearchObject.fvPercent != undefined && rmanDealDetailsSearchObject.fvPercent != "") {
      searchString = searchString + 'fvPercent:' + rmanDealDetailsSearchObject.fvPercent + ',';
    }

    if (rmanDealDetailsSearchObject.parentLineNumber != undefined && rmanDealDetailsSearchObject.parentLineNumber != "") {
      searchString = searchString + 'parentLineNumber:' + rmanDealDetailsSearchObject.parentLineNumber + ',';
    }

    if (rmanDealDetailsSearchObject.agreementNumber != undefined && rmanDealDetailsSearchObject.agreementNumber != "") {
      searchString = searchString + 'agreementNumber:' + rmanDealDetailsSearchObject.agreementNumber + ',';
    }

    if (rmanDealDetailsSearchObject.dealName != undefined && rmanDealDetailsSearchObject.dealName != "") {
      searchString = searchString + 'dealName:' + rmanDealDetailsSearchObject.dealName + ',';
    }

    if (rmanDealDetailsSearchObject.uomCode != undefined && rmanDealDetailsSearchObject.uomCode != "") {
      searchString = searchString + 'uomCode:' + rmanDealDetailsSearchObject.uomCode + ',';
    }

    if (rmanDealDetailsSearchObject.bespPerUnit != undefined && rmanDealDetailsSearchObject.bespPerUnit != "") {
      searchString = searchString + 'bespPerUnit:' + rmanDealDetailsSearchObject.bespPerUnit + ',';
    }

    if (rmanDealDetailsSearchObject.trxAllocUnitAmt != undefined && rmanDealDetailsSearchObject.trxAllocUnitAmt != "") {
      searchString = searchString + 'trxAllocUnitAmt:' + rmanDealDetailsSearchObject.trxAllocUnitAmt + ',';
    }

    if (rmanDealDetailsSearchObject.trxCurrencyCode != undefined && rmanDealDetailsSearchObject.trxCurrencyCode != "") {
      searchString = searchString + 'trxCurrencyCode:' + rmanDealDetailsSearchObject.trxCurrencyCode + ',';
    }

    if (rmanDealDetailsSearchObject.changeReason != undefined && rmanDealDetailsSearchObject.changeReason != "") {
      searchString = searchString + 'changeReason:' + rmanDealDetailsSearchObject.changeReason + ',';
    }

    if (rmanDealDetailsSearchObject.contAppQty != undefined && rmanDealDetailsSearchObject.contAppQty != "") {
      searchString = searchString + 'contAppQty:' + rmanDealDetailsSearchObject.contAppQty + ',';
    }

    if (rmanDealDetailsSearchObject.bundleFlag != undefined && rmanDealDetailsSearchObject.bundleFlag != "") {
      searchString = searchString + 'bundleFlag:' + rmanDealDetailsSearchObject.bundleFlag + ',';
    }

    if (rmanDealDetailsSearchObject.bundlePercent != undefined && rmanDealDetailsSearchObject.bundlePercent != "") {
      searchString = searchString + 'bundlePercent:' + rmanDealDetailsSearchObject.bundlePercent + ',';
    }

    if (rmanDealDetailsSearchObject.childListPrice != undefined && rmanDealDetailsSearchObject.childListPrice != "") {
      searchString = searchString + 'childListPrice:' + rmanDealDetailsSearchObject.childListPrice + ',';
    }

    if (rmanDealDetailsSearchObject.childSellPrice != undefined && rmanDealDetailsSearchObject.childSellPrice != "") {
      searchString = searchString + 'childSellPrice:' + rmanDealDetailsSearchObject.childSellPrice;
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

  getAllRmanDealDetails(paginationOptions: any, rmanDealDetailsSearchObject: any, exportCols: any): Promise<any[]> {
    let serviceUrl = this.getServiceUrl(paginationOptions, rmanDealDetailsSearchObject, 0, exportCols);
    return this.http.get(serviceUrl).toPromise().then((data: any) => {
      return data;
    });
  }


  saveRmanDealDetails(rmanDealDetails: any): Promise<any[]> {
    let body = JSON.stringify(rmanDealDetails);
    return this.http.post(appSettings.apiUrl + '/saveRmanDealDetails', body, httpOptions).toPromise().then((data: any) => {
      return data;
    });
  }

  updateRmanDealDetails(rmanDealDetails: any): Promise<any[]> {

    delete rmanDealDetails._links;
    delete rmanDealDetails.interests;
    let body = JSON.stringify(rmanDealDetails);
    return this.http.put<any[]>(appSettings.apiUrl + '/RMAN_DEAL_DETAILS/' + rmanDealDetails.dealLineId, body, httpOptions).toPromise().then(data => {
      return data;
    });

  }

  deleteRmanDealDetails(rmanDealDetails: any): Promise<any[]> {
    let deleteUrl = appSettings.apiUrl + '/RMAN_DEAL_DETAILS/' + rmanDealDetails.dealLineId;
    return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
      return data;
    });
  }

  mergeDeals(arrgId: any, dealLines: any[], trgArrgId: any): Promise<any[]> {
    var dlstr = '';
    for (var i = 0; i < dealLines.length; i++) {
      dlstr = dlstr + "dealLinesList=" + dealLines[i];
      if (i < dealLines.length - 1) {
        dlstr = dlstr + '&';
      }
    }
    let mergeUrl = appSettings.apiUrl + '/revmantra/mergedeals/?arrangementId=' + arrgId + '&' + dlstr + '&trgArrgId=' + trgArrgId;
    return this.http.get(mergeUrl).toPromise().then((data: any) => {
      data = JSON.parse(JSON.stringify(data || null));
      return data;
    });
  }

  splitDeals(arrgId: any, dealLines: any[], arrgNumber: any, arrgName: any): Promise<any[]> {

    var dlstr = '';
    for (var i = 0; i < dealLines.length; i++) {
      dlstr = dlstr + "dealLinesList=" + dealLines[i];
      if (i < dealLines.length - 1) {
        dlstr = dlstr + '&';
      }
    }
    let splitUrl = appSettings.apiUrl + '/revmantra/splitdeals/?arrangementId=' + arrgId + '&' + dlstr + '&arrgNumber=' + arrgNumber + '&arrgName=' + arrgName;

    return this.http.get(splitUrl).toPromise().then((data: any) => {
      return data;
    });
  }

  getValidArrangement(arrgNumber: any, arrgName: any): Promise<any[]> {
    return this.http.get(appSettings.apiUrl + '/revmantra/validateArrangementExists/?arrgNumber=' + arrgNumber + "&" + 'arrgName=' + arrgName, { responseType: 'text' }).toPromise().then((data: any) => {
      data = JSON.parse(JSON.stringify(data || null));
      return data;
    });
  }

}
