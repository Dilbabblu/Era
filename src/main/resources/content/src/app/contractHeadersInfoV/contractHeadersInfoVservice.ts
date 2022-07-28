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
export class ContractHeadersInfoVService {

    constructor(private http: HttpClient) { }

    getServiceUrl(paginationOptions: any, contractHeadersInfoVSearchObject: any, exportCols: any, exportFlag: any) {

        let serviceUrl = appSettings.apiUrl + '/contractHeadersInfoVExport?';

        if (exportFlag == 0) {
            serviceUrl = appSettings.apiUrl + '/contractHeadersInfoVSearch?';
        }

        let searchString = '';

        if (contractHeadersInfoVSearchObject.dealArrangementId != undefined && contractHeadersInfoVSearchObject.dealArrangementId != "") {
            searchString = searchString + 'dealArrangementId:' + contractHeadersInfoVSearchObject.dealArrangementId + ',';
        }

        if (contractHeadersInfoVSearchObject.dealHeaderId != undefined && contractHeadersInfoVSearchObject.dealHeaderId != "") {
            searchString = searchString + 'dealHeaderId:' + contractHeadersInfoVSearchObject.dealHeaderId + ',';
        }

        if (contractHeadersInfoVSearchObject.dealNumber != undefined && contractHeadersInfoVSearchObject.dealNumber != "") {
            searchString = searchString + 'dealNumber:' + contractHeadersInfoVSearchObject.dealNumber + ',';
        }

        if (contractHeadersInfoVSearchObject.dealName != undefined && contractHeadersInfoVSearchObject.dealName != "") {
            searchString = searchString + 'dealName:' + contractHeadersInfoVSearchObject.dealName + ',';
        }

        if (contractHeadersInfoVSearchObject.dealType != undefined && contractHeadersInfoVSearchObject.dealType != "") {
            searchString = searchString + 'dealType:' + contractHeadersInfoVSearchObject.dealType + ',';
        }

        if (contractHeadersInfoVSearchObject.dealStatus != undefined && contractHeadersInfoVSearchObject.dealStatus != "") {
            searchString = searchString + 'dealStatus:' + contractHeadersInfoVSearchObject.dealStatus + ',';
        }

        if (contractHeadersInfoVSearchObject.agreementNumber != undefined && contractHeadersInfoVSearchObject.agreementNumber != "") {
            searchString = searchString + 'agreementNumber:' + contractHeadersInfoVSearchObject.agreementNumber + ',';
        }

        if (contractHeadersInfoVSearchObject.agreementName != undefined && contractHeadersInfoVSearchObject.agreementName != "") {
            searchString = searchString + 'agreementName:' + contractHeadersInfoVSearchObject.agreementName + ',';
        }

        if (contractHeadersInfoVSearchObject.opportunityNum != undefined && contractHeadersInfoVSearchObject.opportunityNum != "") {
            searchString = searchString + 'opportunityNum:' + contractHeadersInfoVSearchObject.opportunityNum + ',';
        }

        if (contractHeadersInfoVSearchObject.opportunityName != undefined && contractHeadersInfoVSearchObject.opportunityName != "") {
            searchString = searchString + 'opportunityName:' + contractHeadersInfoVSearchObject.opportunityName + ',';
        }

        if (contractHeadersInfoVSearchObject.endCustomerName != undefined && contractHeadersInfoVSearchObject.endCustomerName != "") {
            searchString = searchString + 'endCustomerName:' + contractHeadersInfoVSearchObject.endCustomerName + ',';
        }

        if (contractHeadersInfoVSearchObject.endCustomerNum != undefined && contractHeadersInfoVSearchObject.endCustomerNum != "") {
            searchString = searchString + 'endCustomerNum:' + contractHeadersInfoVSearchObject.endCustomerNum + ',';
        }

        if (contractHeadersInfoVSearchObject.salesChannel != undefined && contractHeadersInfoVSearchObject.salesChannel != "") {
            searchString = searchString + 'salesChannel:' + contractHeadersInfoVSearchObject.salesChannel + ',';
        }

        if (contractHeadersInfoVSearchObject.dealCurrencyCode != undefined && contractHeadersInfoVSearchObject.dealCurrencyCode != "") {
            searchString = searchString + 'dealCurrencyCode:' + contractHeadersInfoVSearchObject.dealCurrencyCode + ',';
        }

        if (contractHeadersInfoVSearchObject.createdDate != undefined && contractHeadersInfoVSearchObject.createdDate != "") {
            searchString = searchString + 'createdDate:' + contractHeadersInfoVSearchObject.createdDate + ',';
        }

        if (contractHeadersInfoVSearchObject.additionalInfo1 != undefined && contractHeadersInfoVSearchObject.additionalInfo1 != "") {
            searchString = searchString + 'additionalInfo1:' + contractHeadersInfoVSearchObject.additionalInfo1 + ',';
        }

        if (contractHeadersInfoVSearchObject.additionalInfo2 != undefined && contractHeadersInfoVSearchObject.additionalInfo2 != "") {
            searchString = searchString + 'additionalInfo2:' + contractHeadersInfoVSearchObject.additionalInfo2 + ',';
        }

        if (contractHeadersInfoVSearchObject.priceList != undefined && contractHeadersInfoVSearchObject.priceList != "") {
            searchString = searchString + 'priceList:' + contractHeadersInfoVSearchObject.priceList + ',';
        }

        if (contractHeadersInfoVSearchObject.billToCustomerName != undefined && contractHeadersInfoVSearchObject.billToCustomerName != "") {
            searchString = searchString + 'billToCustomerName:' + contractHeadersInfoVSearchObject.billToCustomerName + ',';
        }

        if (contractHeadersInfoVSearchObject.billToCountry != undefined && contractHeadersInfoVSearchObject.billToCountry != "") {
            searchString = searchString + 'billToCountry:' + contractHeadersInfoVSearchObject.billToCountry + ',';
        }

        if (contractHeadersInfoVSearchObject.shipToCountry != undefined && contractHeadersInfoVSearchObject.shipToCountry != "") {
            searchString = searchString + 'shipToCountry:' + contractHeadersInfoVSearchObject.shipToCountry + ',';
        }

        if (contractHeadersInfoVSearchObject.dealAmount != undefined && contractHeadersInfoVSearchObject.dealAmount != "") {
            searchString = searchString + 'dealAmount:' + contractHeadersInfoVSearchObject.dealAmount;
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

    getAllContractHeadersInfoV(paginationOptions: any, contractHeadersInfoVSearchObject: any, exportCols: any): Promise<any[]> {
        let serviceUrl = this.getServiceUrl(paginationOptions, contractHeadersInfoVSearchObject, exportCols, 0);
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }

    saveContractHeadersInfoV(contractHeadersInfoV: any): Promise<any[]> {
        let body = JSON.stringify(contractHeadersInfoV);
        return this.http.post<any[]>(appSettings.apiUrl + '/CONTRACT_HEADERS_INFO_V', body, httpOptions).toPromise().then(data => {
            return data;
        });
    }

    updateContractHeadersInfoV(contractHeadersInfoV: any): Promise<any[]> {

        delete contractHeadersInfoV._links;
        delete contractHeadersInfoV.interests;
        let body = JSON.stringify(contractHeadersInfoV);
        return this.http.put<any[]>(appSettings.apiUrl + '/CONTRACT_HEADERS_INFO_V/' + contractHeadersInfoV.dealHeaderId, body, httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteContractHeadersInfoV(contractHeadersInfoV: any): Promise<any[]> {
        let deleteUrl = appSettings.apiUrl + '/CONTRACT_HEADERS_INFO_V/' + contractHeadersInfoV.dealHeaderId;
        return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
            return data;
        });
    }

    splitProcess(srcRc: any, sourceContractHeaderIds: any[], flag: any): Promise<any[]> {

        var dlstr = '';
        for (var i = 0; i < sourceContractHeaderIds.length; i++) {
          dlstr = dlstr + "sourceContractHeaderIds=" + sourceContractHeaderIds[i];
          if (i < sourceContractHeaderIds.length - 1) {
            dlstr = dlstr + '&';
          }
        }
        let splitUrl = appSettings.apiUrl + '/revmantra/splitProcess/?srcRc=' + srcRc + '&' + dlstr + '&flag=' + flag;
    
        return this.http.post(splitUrl,null).toPromise().then((data: any) => {
          return data;
        });

      }

      mergeProcess(srcRc: any, sourceContractHeaderIds: any[],trgRc:any, flag: any): Promise<any[]> {

        var dlstr = '';
        for (var i = 0; i < sourceContractHeaderIds.length; i++) {
          dlstr = dlstr + "sourceContractHeaderIds=" + sourceContractHeaderIds[i];
          if (i < sourceContractHeaderIds.length - 1) {
            dlstr = dlstr + '&';
          }
        }
        let mergeUrl = appSettings.apiUrl + '/revmantra/mergeProcess/?srcRc=' + srcRc + '&' + dlstr + '&trgRc=' + trgRc + '&flag=' + flag;
    
        return this.http.post(mergeUrl, null).toPromise().then((data: any) => {
          return data;
        });

      }

}
