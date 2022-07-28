import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
declare var require:any;
const appSettings = require('../appsettings');


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
  })
};

@Injectable()
export class RmanArrangementsAllVService {

  constructor(private http: HttpClient) { }
  
  getServiceUrl(paginationOptions: any, rmanArrangementsAllVSearchObject: any, exportFlag: any) {

    let serviceUrl = appSettings.apiUrl + '/rmanArrangementsAllVExport?';

    if (exportFlag == 0) {
    serviceUrl = appSettings.apiUrl + '/rmanArrangementsAllVCommonSearch?'

      //serviceUrl = appSettings.apiUrl + '/rmanArrangementsAllVSearch?';
    }


    let searchString = '';

    if (rmanArrangementsAllVSearchObject.arrangementName != undefined && rmanArrangementsAllVSearchObject.arrangementName != "") {
      searchString = searchString + 'arrangementName:' + rmanArrangementsAllVSearchObject.arrangementName + ',';
    }

    if (rmanArrangementsAllVSearchObject.creationDate != undefined && rmanArrangementsAllVSearchObject.creationDate != "") {
      searchString = searchString + 'creationDate:' + rmanArrangementsAllVSearchObject.creationDate + ',';
    }

    if (rmanArrangementsAllVSearchObject.arrangementTotal != undefined && rmanArrangementsAllVSearchObject.arrangementTotal != "") {
      searchString = searchString + 'arrangementTotal:' + rmanArrangementsAllVSearchObject.arrangementTotal + ',';
    }

    if (rmanArrangementsAllVSearchObject.arrangementType != undefined && rmanArrangementsAllVSearchObject.arrangementType != "") {
      searchString = searchString + 'arrangementType:' + rmanArrangementsAllVSearchObject.arrangementType + ',';
    }

    if (rmanArrangementsAllVSearchObject.arrangementQtr != undefined && rmanArrangementsAllVSearchObject.arrangementQtr != "") {
      searchString = searchString + 'arrangementQtr:' + rmanArrangementsAllVSearchObject.arrangementQtr + ',';
    }

    if (rmanArrangementsAllVSearchObject.arrangementKey != undefined && rmanArrangementsAllVSearchObject.arrangementKey != "") {
      searchString = searchString + 'arrangementKey:' + rmanArrangementsAllVSearchObject.arrangementKey + ',';
    }

    if (rmanArrangementsAllVSearchObject.arrangementStatus != undefined && rmanArrangementsAllVSearchObject.arrangementStatus != "") {
      searchString = searchString + 'arrangementStatus:' + rmanArrangementsAllVSearchObject.arrangementStatus + ',';
    }

    if (rmanArrangementsAllVSearchObject.arrangementId != undefined && rmanArrangementsAllVSearchObject.arrangementId != "") {
      searchString = searchString + 'arrangementId:' + rmanArrangementsAllVSearchObject.arrangementId + ',';
    }

    if (rmanArrangementsAllVSearchObject.createdBy != undefined && rmanArrangementsAllVSearchObject.createdBy != "") {
      searchString = searchString + 'createdBy:' + rmanArrangementsAllVSearchObject.createdBy + ',';
    }

    if (rmanArrangementsAllVSearchObject.lastUpdateDate != undefined && rmanArrangementsAllVSearchObject.lastUpdateDate != "") {
      searchString = searchString + 'lastUpdateDate:' + rmanArrangementsAllVSearchObject.lastUpdateDate + ',';
    }

    if (rmanArrangementsAllVSearchObject.lastUpdatedBy != undefined && rmanArrangementsAllVSearchObject.lastUpdatedBy != "") {
      searchString = searchString + 'lastUpdatedBy:' + rmanArrangementsAllVSearchObject.lastUpdatedBy + ',';
    }

    if (rmanArrangementsAllVSearchObject.legalEntityId != undefined && rmanArrangementsAllVSearchObject.legalEntityId != "") {
      searchString = searchString + 'legalEntityId:' + rmanArrangementsAllVSearchObject.legalEntityId + ',';
    }

    if (rmanArrangementsAllVSearchObject.guidanceName != undefined && rmanArrangementsAllVSearchObject.guidanceName != "") {
      searchString = searchString + 'guidanceName:' + rmanArrangementsAllVSearchObject.guidanceName + ',';
    }

    if (rmanArrangementsAllVSearchObject.guidanceType != undefined && rmanArrangementsAllVSearchObject.guidanceType != "") {
      searchString = searchString + 'guidanceType:' + rmanArrangementsAllVSearchObject.guidanceType + ',';
    }

    if (rmanArrangementsAllVSearchObject.calcuationMethod != undefined && rmanArrangementsAllVSearchObject.calcuationMethod != "") {
      searchString = searchString + 'calcuationMethod:' + rmanArrangementsAllVSearchObject.calcuationMethod + ',';
    }

    if (rmanArrangementsAllVSearchObject.contractFlag != undefined && rmanArrangementsAllVSearchObject.contractFlag != "") {
      searchString = searchString + 'contractFlag:' + rmanArrangementsAllVSearchObject.contractFlag + ',';
    }

    if (rmanArrangementsAllVSearchObject.repCurrCode != undefined && rmanArrangementsAllVSearchObject.repCurrCode != "") {
      searchString = searchString + 'repCurrCode:' + rmanArrangementsAllVSearchObject.repCurrCode + ',';
    }

    if (rmanArrangementsAllVSearchObject.arrangementCurrency != undefined && rmanArrangementsAllVSearchObject.arrangementCurrency != "") {
      searchString = searchString + 'arrangementCurrency:' + rmanArrangementsAllVSearchObject.arrangementCurrency + ',';
    }

    if (rmanArrangementsAllVSearchObject.endCustomerName != undefined && rmanArrangementsAllVSearchObject.endCustomerName != "") {
      searchString = searchString + 'endCustomerName:' + rmanArrangementsAllVSearchObject.endCustomerName + ',';
    }

    if (rmanArrangementsAllVSearchObject.endCustomerNumber != undefined && rmanArrangementsAllVSearchObject.endCustomerNumber != "") {
      searchString = searchString + 'endCustomerNumber:' + rmanArrangementsAllVSearchObject.endCustomerNumber + ',';
    }

    if (rmanArrangementsAllVSearchObject.arrangementBasis != undefined && rmanArrangementsAllVSearchObject.arrangementBasis != "") {
      searchString = searchString + 'arrangementBasis:' + rmanArrangementsAllVSearchObject.arrangementBasis + ',';
    }

    if (rmanArrangementsAllVSearchObject.arrangementSource != undefined && rmanArrangementsAllVSearchObject.arrangementSource != "") {
      searchString = searchString + 'arrangementSource:' + rmanArrangementsAllVSearchObject.arrangementSource + ',';
    }

    if (rmanArrangementsAllVSearchObject.msaNumber != undefined && rmanArrangementsAllVSearchObject.msaNumber != "") {
      searchString = searchString + 'msaNumber:' + rmanArrangementsAllVSearchObject.msaNumber + ',';
    }

    if (rmanArrangementsAllVSearchObject.salesNodeLevel1 != undefined && rmanArrangementsAllVSearchObject.salesNodeLevel1 != "") {
      searchString = searchString + 'salesNodeLevel1:' + rmanArrangementsAllVSearchObject.salesNodeLevel1 + ',';
    }

    if (rmanArrangementsAllVSearchObject.salesNodeLevel2 != undefined && rmanArrangementsAllVSearchObject.salesNodeLevel2 != "") {
      searchString = searchString + 'salesNodeLevel2:' + rmanArrangementsAllVSearchObject.salesNodeLevel2 + ',';
    }

    if (rmanArrangementsAllVSearchObject.salesNodeLevel3 != undefined && rmanArrangementsAllVSearchObject.salesNodeLevel3 != "") {
      searchString = searchString + 'salesNodeLevel3:' + rmanArrangementsAllVSearchObject.salesNodeLevel3 + ',';
    }

    if (rmanArrangementsAllVSearchObject.salesNodeLevel4 != undefined && rmanArrangementsAllVSearchObject.salesNodeLevel4 != "") {
      searchString = searchString + 'salesNodeLevel4:' + rmanArrangementsAllVSearchObject.salesNodeLevel4 + ',';
    }

    if (rmanArrangementsAllVSearchObject.revAccountantId != undefined && rmanArrangementsAllVSearchObject.revAccountantId != "") {
      searchString = searchString + 'revAccountantId:' + rmanArrangementsAllVSearchObject.revAccountantId + ',';
    }

    if (rmanArrangementsAllVSearchObject.revManagerId != undefined && rmanArrangementsAllVSearchObject.revManagerId != "") {
      searchString = searchString + 'revManagerId:' + rmanArrangementsAllVSearchObject.revManagerId + ',';
    }

    if (rmanArrangementsAllVSearchObject.salesContact != undefined && rmanArrangementsAllVSearchObject.salesContact != "") {
      searchString = searchString + 'salesContact:' + rmanArrangementsAllVSearchObject.salesContact + ',';
    }

    if (rmanArrangementsAllVSearchObject.customerContact != undefined && rmanArrangementsAllVSearchObject.customerContact != "") {
      searchString = searchString + 'customerContact:' + rmanArrangementsAllVSearchObject.customerContact + ',';
    }

    if (rmanArrangementsAllVSearchObject.reasonCode != undefined && rmanArrangementsAllVSearchObject.reasonCode != "") {
      searchString = searchString + 'reasonCode:' + rmanArrangementsAllVSearchObject.reasonCode + ',';
    }

    if (rmanArrangementsAllVSearchObject.allocationEligible != undefined && rmanArrangementsAllVSearchObject.allocationEligible != "") {
      searchString = searchString + 'allocationEligible:' + rmanArrangementsAllVSearchObject.allocationEligible + ',';
    }

    if (rmanArrangementsAllVSearchObject.msaName != undefined && rmanArrangementsAllVSearchObject.msaName != "") {
      searchString = searchString + 'msaName:' + rmanArrangementsAllVSearchObject.msaName + ',';
    }

    if (rmanArrangementsAllVSearchObject.arrangementNumber != undefined && rmanArrangementsAllVSearchObject.arrangementNumber != "") {
      searchString = searchString + 'arrangementNumber:' + rmanArrangementsAllVSearchObject.arrangementNumber + ',';
    }

    if (rmanArrangementsAllVSearchObject.changeReason != undefined && rmanArrangementsAllVSearchObject.changeReason != "") {
      searchString = searchString + 'changeReason:' + rmanArrangementsAllVSearchObject.changeReason + ',';
    }

    if (rmanArrangementsAllVSearchObject.masterArrgFlag != undefined && rmanArrangementsAllVSearchObject.masterArrgFlag != "") {
      searchString = searchString + 'masterArrgFlag:' + rmanArrangementsAllVSearchObject.masterArrgFlag + ',';
    }

    if (rmanArrangementsAllVSearchObject.masterArrgId != undefined && rmanArrangementsAllVSearchObject.masterArrgId != "") {
      searchString = searchString + 'masterArrgId:' + rmanArrangementsAllVSearchObject.masterArrgId + ',';
    }

    if (rmanArrangementsAllVSearchObject.masterArrgName != undefined && rmanArrangementsAllVSearchObject.masterArrgName != "") {
      searchString = searchString + 'masterArrgName:' + rmanArrangementsAllVSearchObject.masterArrgName + ',';
    }

    if (rmanArrangementsAllVSearchObject.legalEntityName != undefined && rmanArrangementsAllVSearchObject.legalEntityName != "") {
      searchString = searchString + 'legalEntityName:' + rmanArrangementsAllVSearchObject.legalEntityName + ',';
    }

    if (rmanArrangementsAllVSearchObject.orderNumber != undefined && rmanArrangementsAllVSearchObject.orderNumber != "") {
      searchString = searchString + 'orderNumber:' + rmanArrangementsAllVSearchObject.orderNumber + ',';
    }

    if (rmanArrangementsAllVSearchObject.customerPoNum != undefined && rmanArrangementsAllVSearchObject.customerPoNum != "") {
      searchString = searchString + 'customerPoNum:' + rmanArrangementsAllVSearchObject.customerPoNum + ',';
    }

    if (rmanArrangementsAllVSearchObject.dealNumber != undefined && rmanArrangementsAllVSearchObject.dealNumber != "") {
      searchString = searchString + 'dealNumber:' + rmanArrangementsAllVSearchObject.dealNumber + ',';
    }

    if (rmanArrangementsAllVSearchObject.dealName != undefined && rmanArrangementsAllVSearchObject.dealName != "") {
      searchString = searchString + 'dealName:' + rmanArrangementsAllVSearchObject.dealName + ',';
    }

    if (rmanArrangementsAllVSearchObject.dealFlag != undefined && rmanArrangementsAllVSearchObject.dealFlag != "") {
      searchString = searchString + 'dealFlag:' + rmanArrangementsAllVSearchObject.dealFlag;
    }

    if (rmanArrangementsAllVSearchObject.customerPoNum != undefined && rmanArrangementsAllVSearchObject.customerPoNum != "") {
      searchString = searchString + 'customerPoNum:' + rmanArrangementsAllVSearchObject.customerPoNum + ',';
    }

    if (rmanArrangementsAllVSearchObject.contApplied != undefined && rmanArrangementsAllVSearchObject.contApplied != "") {
      searchString = searchString + 'contApplied:' + rmanArrangementsAllVSearchObject.contApplied + ',';
    }

    if (searchString == '') {
      serviceUrl = serviceUrl + 'search=%25';
    }
    else {
      serviceUrl = serviceUrl + 'search=' + searchString;
    }

    if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != null && !isNaN(paginationOptions.pageNumber) ) {
      serviceUrl = serviceUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;
    }
    
    if(paginationOptions.sortField != undefined && paginationOptions.sortField !=null && paginationOptions.sortOrder !=undefined && paginationOptions.sortOrder!=null){
      serviceUrl  = serviceUrl + '&sort=' +paginationOptions.sortField +','+paginationOptions.sortOrder;
    }

    return serviceUrl;
  }

  getAllRmanArrangementsAllV(paginationOptions: any, rmanArrangementsAllVSearchObject: any): Promise<any[]> {
    let serviceUrl = this.getServiceUrl(paginationOptions, rmanArrangementsAllVSearchObject, 0);
    return this.http.get(serviceUrl).toPromise().then((data: any) => {
      return data;
    });
  }

  getLocalSearchedRmanArrangementsAllV(paginationOptions: any, searchString: any, field: any): Promise<any[]> {
    let serviceUrl = this.getLocalSearchServiceUrl(paginationOptions, searchString, field, 0);
    return this.http.get(serviceUrl).toPromise().then((data: any) => {
      return data;
    });
  }

  getLocalSearchServiceUrl(paginationOptions: any, searchString: any, field: any, exportFlag: number) {
   

    let serviceUrl = appSettings.apiUrl + '/rmanArrangementsAllVExport?';

    if (exportFlag == 0) {
      serviceUrl = appSettings.apiUrl + '/rmanArrangementsAllVLocalSearch?';
    }
    
    if (searchString == '') {
      serviceUrl = serviceUrl + 'search=%25';
    }
    else {
      if(field == "arrangementKey"){
      serviceUrl = serviceUrl + 'search=' + searchString +'&field='+field;
      }
    }

    if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != null && !isNaN(paginationOptions.pageNumber) ) {
      serviceUrl = serviceUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;
     
    }

    return serviceUrl;
  }

  getSearchedRmanArrangements(paginationOptions: any, startDate: any, endDate: any, modStartDate: any, modEndDate:any, globalSearch: any, arrangementKey: any, arrangementNumber: any, arrangementName: any, dealNumber: any, dealName: any, customerPoNum: any, orderNumber: any, endCustomerName: any, legalEntityName: any, arrangementCurrency: any, arrangementTotal: any, arrangementType: any, arrangementStatus: any, creationDate: any, lastUpdateDate: any, arrangementBasis: any, arrangementSource: any, contApplied: any, lastArrgModifiedDate: any, projectNumber: any,groupingRule: any, dealNum:any, exportCols: any) : Promise<any[]> {
    let serviceUrl = this.getUrl(paginationOptions, startDate, endDate, modStartDate, modEndDate, globalSearch, arrangementKey, arrangementNumber, arrangementName, dealNumber, dealName, customerPoNum, orderNumber, endCustomerName, legalEntityName, arrangementCurrency, arrangementTotal, arrangementType, arrangementStatus, creationDate, lastUpdateDate, arrangementBasis, arrangementSource, contApplied,lastArrgModifiedDate, projectNumber, groupingRule, dealNum, 0, exportCols);
    return this.http.get(serviceUrl).toPromise().then((data: any) => {
      return data;
    });
  }

  getUrl(paginationOptions: any, startDate: any, endDate: any, modStartDate:any, modEndDate:any, globalSearch: any, arrangementKey: any, arrangementNumber: any, arrangementName: any, dealNumber: any, dealName: any, customerPoNum: any, orderNumber: any, endCustomerName: any, legalEntityName: any, arrangementCurrency: any, arrangementTotal: any, arrangementType: any, arrangementStatus: any, creationDate: any, lastUpdateDate: any, arrangementBasis: any, arrangementSource: any, contApplied: any, lastArrgModifiedDate: any,projectNumber:any,groupingRule:any, dealNum: any, exportFlag: any, exportCols: any) {
    let serviceUrl = appSettings.apiUrl + '/rmanArrangementsAllVExport?';
    let searchString='';
    if(exportFlag ==0){
      serviceUrl = appSettings.apiUrl + '/rmanArrangementsAllVCommonSearch?'
    }

    //global search, date ranges and combination of local search
    if (startDate != undefined && startDate != "") {
      searchString = searchString + 'startDate>' + startDate +',';
    }

    if (endDate != undefined && endDate != "") {
      searchString = searchString + 'endDate<' + endDate +',';
    }
    
    if (modStartDate != undefined && modStartDate != "") {
      searchString = searchString + 'modStartDate>' + modStartDate +',';
    }

    if (modEndDate != undefined && modEndDate != "") {
      searchString = searchString + 'modEndDate<' + modEndDate +',';
    }

    if (globalSearch != undefined && globalSearch != "") {
      searchString = searchString + 'globalSearch=' + globalSearch+",";
    }

    if (arrangementKey != undefined && arrangementKey != "") {
      searchString = searchString + 'arrangementKey:' + arrangementKey +',';
    }

    if (arrangementNumber != undefined && arrangementNumber != "") {
      searchString = searchString + 'arrangementNumber:' + arrangementNumber +',';
    }

    if (arrangementName != undefined && arrangementName != "") {
      searchString = searchString + 'arrangementName:' + arrangementName+',';
    }

    if (dealNumber != undefined && dealNumber != "") {
      searchString = searchString + 'dealNumber:' + dealNumber+',';
    }

    if (dealName != undefined && dealName != "") {
      searchString = searchString + 'dealName:' + dealName+',';
    }

    if (customerPoNum != undefined && customerPoNum != "") {
      searchString = searchString + 'customerPoNum:' + customerPoNum+',';
    }

    if (orderNumber != undefined && orderNumber != "") {
      searchString = searchString + 'orderNumber:' + orderNumber+',';
    }

    if (endCustomerName != undefined && endCustomerName != "") {
      searchString = searchString + 'endCustomerName:' + endCustomerName+',';
    }

    if (legalEntityName != undefined && legalEntityName != "") {
      searchString = searchString + 'legalEntityName:' + legalEntityName+',';
    }

    if (arrangementCurrency != undefined && arrangementCurrency != "") {
      searchString = searchString + 'arrangementCurrency:' + arrangementCurrency+',';
    }

    if (arrangementTotal != undefined && arrangementTotal != "") {
      searchString = searchString + 'arrangementTotal:' + arrangementTotal+',';
    }

    if (arrangementType != undefined && arrangementType != "") {
      searchString = searchString + 'arrangementType:' + arrangementType+',';
    }

    if (arrangementStatus != undefined && arrangementStatus != "") {
      searchString = searchString + 'arrangementStatus:' + arrangementStatus+',';
    }

    if (creationDate != undefined && creationDate != "") {
      searchString = searchString + 'creationDate:' + creationDate+',';
    }

    if (lastUpdateDate != undefined && lastUpdateDate != "") {
      searchString = searchString + 'lastUpdateDate:' + lastUpdateDate+',';
    }

    if (arrangementBasis != undefined && arrangementBasis != "") {
      searchString = searchString + 'arrangementBasis:' + arrangementBasis+',';
    }

    if (arrangementSource != undefined && arrangementSource != "") {
      searchString = searchString + 'arrangementSource:' + arrangementSource+',';
    }

    if (contApplied != undefined && contApplied != "") {
      searchString = searchString + 'contApplied:' + contApplied+',';
    }

    if (lastArrgModifiedDate != undefined && lastArrgModifiedDate != "") {
      searchString = searchString + 'lastArrgModifiedDate:' + lastArrgModifiedDate+',';
    }

    if (projectNumber != undefined && projectNumber != "") {
      searchString = searchString + 'projectNumber:' + projectNumber+',';
    }

    if (groupingRule != undefined && groupingRule != "") {
      searchString = searchString + 'groupingRule:' + groupingRule+',';
    }

    if (dealNum != undefined && dealNum != "") {
      searchString = searchString + 'dealNum:' + dealNum+',';
    }

    if(searchString ==''){
      serviceUrl = serviceUrl + 'search=%25';
    }else{
      serviceUrl = serviceUrl+ 'search='+ searchString;
    }
   
    if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != null && !isNaN(paginationOptions.pageNumber) ) {
      serviceUrl = serviceUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;     
    }

    if(paginationOptions.sortField != undefined && paginationOptions.sortField !=null && paginationOptions.sortOrder !=undefined && paginationOptions.sortOrder!=null){
      serviceUrl  = serviceUrl + '&sort=' +paginationOptions.sortField +','+paginationOptions.sortOrder;
    }

    if(exportCols!=undefined && exportCols!=""){
      serviceUrl=serviceUrl+'&exportCols='+exportCols;
     }

    return serviceUrl;
  }

  saveRmanArrangementsAllV(rmanArrangementsAllV: any): Promise<any[]> {
    let body = JSON.stringify(rmanArrangementsAllV);
    return this.http.post<any[]>(appSettings.apiUrl + '/RMAN_ARRANGEMENTS_ALL_V', body, httpOptions).toPromise().then(data => {
      return data;
    });
  }

  updateRmanArrangementsAllV(rmanArrangementsAllV: any): Promise<any[]> {

    delete rmanArrangementsAllV._links;
    delete rmanArrangementsAllV.interests;
    let body = JSON.stringify(rmanArrangementsAllV);
    return this.http.put<any[]>(appSettings.apiUrl + '/RMAN_ARRANGEMENTS_ALL_V/' + rmanArrangementsAllV.arrangementId, body, httpOptions).toPromise().then(data => {
      return data;
    });

  }

  deleteRmanArrangementsAllV(rmanArrangementsAllV: any): Promise<any[]> {
    let deleteUrl = appSettings.apiUrl + '/RMAN_ARRANGEMENTS_ALL_V/' + rmanArrangementsAllV.arrangementId;
    return this.http.delete(deleteUrl, httpOptions).toPromise().then((data:any) => {
      return data;
    });
  }

  runImportRecordsJob(importRecords: any) {
    let formData = new FormData();
    formData.append("file", importRecords.file, importRecords.file.name);
    this.http.post(appSettings.apiUrl + + "/upload", formData, httpOptions).subscribe();
  }

}
