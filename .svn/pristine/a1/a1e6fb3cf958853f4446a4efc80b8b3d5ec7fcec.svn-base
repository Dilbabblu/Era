import { DatePipe } from '@angular/common';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
declare var require:any;
const appSettings = require('../appsettings');

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
  })
};


@Injectable()
export class ArrgContractAllocationsVService {
/**
  * Added Import DatePipe Component
				  * A	dded DatePipe Service in the constructor used for the 
  * Date convert to the ISO Date format(YYYY-MM-DD)
  * To fix the bug #AYAR-403 by chandra kota on 2021-JUN-01 
  */
  constructor(private http: HttpClient,private datePipe: DatePipe) { }

  getServiceUrl(paginationOptions: any, arrgContractAllocationsVSearchObject: any, exportFlag: any, exportCols: any,quoteOrderSwitch: any) {
    let serviceUrl = '';
    if(!quoteOrderSwitch){
      serviceUrl = appSettings.apiUrl + '/arrgContractAllocationsVExport?quoteOrderSwitch=false&';
    }else{
      serviceUrl = appSettings.apiUrl + '/arrgContractAllocationsVExport?quoteOrderSwitch=true&';
    }

    if (exportFlag == 0 && !quoteOrderSwitch) {
      serviceUrl = appSettings.apiUrl + '/arrgContractAllocationsVSearch?';
    }else if (exportFlag == 0 && quoteOrderSwitch){
      serviceUrl = appSettings.apiUrl + '/arrgOrderAllocationsVSearch?';
    }

    let searchString = '';

    if (arrgContractAllocationsVSearchObject.dealArrangementId != undefined && arrgContractAllocationsVSearchObject.dealArrangementId != "") {
      searchString = searchString + 'dealArrangementId:' + arrgContractAllocationsVSearchObject.dealArrangementId + ',';
    }

    if (arrgContractAllocationsVSearchObject.dealHeaderId != undefined && arrgContractAllocationsVSearchObject.dealHeaderId != "") {
      searchString = searchString + 'dealHeaderId:' + arrgContractAllocationsVSearchObject.dealHeaderId + ',';
    }

    if (arrgContractAllocationsVSearchObject.dealNumber != undefined && arrgContractAllocationsVSearchObject.dealNumber != "") {
      searchString = searchString + 'dealNumber:' + arrgContractAllocationsVSearchObject.dealNumber + ',';
    }

    if (arrgContractAllocationsVSearchObject.dealLineNumber != undefined && arrgContractAllocationsVSearchObject.dealLineNumber != "") {
      searchString = searchString + 'dealLineNumber:' + arrgContractAllocationsVSearchObject.dealLineNumber + ',';
    }

    if (arrgContractAllocationsVSearchObject.dealLineId != undefined && arrgContractAllocationsVSearchObject.dealLineId != "") {
      searchString = searchString + 'dealLineId:' + arrgContractAllocationsVSearchObject.dealLineId + ',';
    }

    if (arrgContractAllocationsVSearchObject.productName != undefined && arrgContractAllocationsVSearchObject.productName != "") {
      searchString = searchString + 'productName:' + arrgContractAllocationsVSearchObject.productName + ',';
    }

    if (arrgContractAllocationsVSearchObject.uomCode != undefined && arrgContractAllocationsVSearchObject.uomCode != "") {
      searchString = searchString + 'uomCode:' + arrgContractAllocationsVSearchObject.uomCode + ',';
    }

    if (arrgContractAllocationsVSearchObject.quantity != undefined && arrgContractAllocationsVSearchObject.quantity != "") {
      searchString = searchString + 'quantity:' + arrgContractAllocationsVSearchObject.quantity + ',';
    }

    if (arrgContractAllocationsVSearchObject.dealCurrencyCode != undefined && arrgContractAllocationsVSearchObject.dealCurrencyCode != "") {
      searchString = searchString + 'dealCurrencyCode:' + arrgContractAllocationsVSearchObject.dealCurrencyCode + ',';
    }

    if (arrgContractAllocationsVSearchObject.trxCurrencyCode != undefined && arrgContractAllocationsVSearchObject.trxCurrencyCode != "") {
      searchString = searchString + 'trxCurrencyCode:' + arrgContractAllocationsVSearchObject.trxCurrencyCode + ',';
    }

    if (arrgContractAllocationsVSearchObject.repCurrCode != undefined && arrgContractAllocationsVSearchObject.repCurrCode != "") {
      searchString = searchString + 'repCurrCode:' + arrgContractAllocationsVSearchObject.repCurrCode + ',';
    }

    if (arrgContractAllocationsVSearchObject.unitListPrice != undefined && arrgContractAllocationsVSearchObject.unitListPrice != "") {
      searchString = searchString + 'unitListPrice:' + arrgContractAllocationsVSearchObject.unitListPrice + ',';
    }

    if (arrgContractAllocationsVSearchObject.unitSellingPrice != undefined && arrgContractAllocationsVSearchObject.unitSellingPrice != "") {
      searchString = searchString + 'unitSellingPrice:' + arrgContractAllocationsVSearchObject.unitSellingPrice + ',';
    }

    if (arrgContractAllocationsVSearchObject.lineAmount != undefined && arrgContractAllocationsVSearchObject.lineAmount != "") {
      searchString = searchString + 'lineAmount:' + arrgContractAllocationsVSearchObject.lineAmount + ',';
    }

    if (arrgContractAllocationsVSearchObject.elementType != undefined && arrgContractAllocationsVSearchObject.elementType != "") {
      searchString = searchString + 'elementType:' + arrgContractAllocationsVSearchObject.elementType + ',';
    }

    if (arrgContractAllocationsVSearchObject.accountingScope != undefined && arrgContractAllocationsVSearchObject.accountingScope != "") {
      searchString = searchString + 'accountingScope:' + arrgContractAllocationsVSearchObject.accountingScope + ',';
    }

    if (arrgContractAllocationsVSearchObject.bundleFlag != undefined && arrgContractAllocationsVSearchObject.bundleFlag != "") {
      searchString = searchString + 'bundleFlag:' + arrgContractAllocationsVSearchObject.bundleFlag + ',';
    }

    if (arrgContractAllocationsVSearchObject.parentLineId != undefined && arrgContractAllocationsVSearchObject.parentLineId != "") {
      searchString = searchString + 'parentLineId:' + arrgContractAllocationsVSearchObject.parentLineId + ',';
    }

    if (arrgContractAllocationsVSearchObject.parentLineNumber != undefined && arrgContractAllocationsVSearchObject.parentLineNumber != "") {
      searchString = searchString + 'parentLineNumber:' + arrgContractAllocationsVSearchObject.parentLineNumber + ',';
    }

    if (arrgContractAllocationsVSearchObject.solution != undefined && arrgContractAllocationsVSearchObject.solution != "") {
      searchString = searchString + 'solution:' + arrgContractAllocationsVSearchObject.solution + ',';
    }

    if (arrgContractAllocationsVSearchObject.productGroup != undefined && arrgContractAllocationsVSearchObject.productGroup != "") {
      searchString = searchString + 'productGroup:' + arrgContractAllocationsVSearchObject.productGroup + ',';
    }

    if (arrgContractAllocationsVSearchObject.productType != undefined && arrgContractAllocationsVSearchObject.productType != "") {
      searchString = searchString + 'productType:' + arrgContractAllocationsVSearchObject.productType + ',';
    }

    if (arrgContractAllocationsVSearchObject.fmvRuleName != undefined && arrgContractAllocationsVSearchObject.fmvRuleName != "") {
      searchString = searchString + 'fmvRuleName:' + arrgContractAllocationsVSearchObject.fmvRuleName + ',';
    }

    if (arrgContractAllocationsVSearchObject.fmvCategory != undefined && arrgContractAllocationsVSearchObject.fmvCategory != "") {
      searchString = searchString + 'fmvCategory:' + arrgContractAllocationsVSearchObject.fmvCategory + ',';
    }

    if (arrgContractAllocationsVSearchObject.fmvType != undefined && arrgContractAllocationsVSearchObject.fmvType != "") {
      searchString = searchString + 'fmvType:' + arrgContractAllocationsVSearchObject.fmvType + ',';
    }

    if (arrgContractAllocationsVSearchObject.fmvMin != undefined && arrgContractAllocationsVSearchObject.fmvMin != "") {
      searchString = searchString + 'fmvMin:' + arrgContractAllocationsVSearchObject.fmvMin + ',';
    }

    if (arrgContractAllocationsVSearchObject.fmvMean != undefined && arrgContractAllocationsVSearchObject.fmvMean != "") {
      searchString = searchString + 'fmvMean:' + arrgContractAllocationsVSearchObject.fmvMean + ',';
    }

    if (arrgContractAllocationsVSearchObject.fmvMax != undefined && arrgContractAllocationsVSearchObject.fmvMax != "") {
      searchString = searchString + 'fmvMax:' + arrgContractAllocationsVSearchObject.fmvMax + ',';
    }

    if (arrgContractAllocationsVSearchObject.bundleAttribitionList != undefined && arrgContractAllocationsVSearchObject.bundleAttribitionList != "") {
      searchString = searchString + 'bundleAttribitionList:' + arrgContractAllocationsVSearchObject.bundleAttribitionList + ',';
    }

    if (arrgContractAllocationsVSearchObject.bundleAttribitionNet != undefined && arrgContractAllocationsVSearchObject.bundleAttribitionNet != "") {
      searchString = searchString + 'bundleAttribitionNet:' + arrgContractAllocationsVSearchObject.bundleAttribitionNet + ',';
    }

    if (arrgContractAllocationsVSearchObject.fmvAmount != undefined && arrgContractAllocationsVSearchObject.fmvAmount != "") {
      searchString = searchString + 'fmvAmount:' + arrgContractAllocationsVSearchObject.fmvAmount + ',';
    }

    if (arrgContractAllocationsVSearchObject.allocationAmount != undefined && arrgContractAllocationsVSearchObject.allocationAmount != "") {
      searchString = searchString + 'allocationAmount:' + arrgContractAllocationsVSearchObject.allocationAmount + ',';
    }

    if (arrgContractAllocationsVSearchObject.cvInOutAmount != undefined && arrgContractAllocationsVSearchObject.cvInOutAmount != "") {
      searchString = searchString + 'cvInOutAmount:' + arrgContractAllocationsVSearchObject.cvInOutAmount + ',';
    }

    if (arrgContractAllocationsVSearchObject.pobGrouping != undefined && arrgContractAllocationsVSearchObject.pobGrouping != "") {
      searchString = searchString + 'pobGrouping:' + arrgContractAllocationsVSearchObject.pobGrouping + ',';
    }

    if (arrgContractAllocationsVSearchObject.allocationInclusive != undefined && arrgContractAllocationsVSearchObject.allocationInclusive != "") {
      searchString = searchString + 'allocationInclusive:' + arrgContractAllocationsVSearchObject.allocationInclusive + ',';
    }

    if (arrgContractAllocationsVSearchObject.accountingStandard != undefined && arrgContractAllocationsVSearchObject.accountingStandard != "") {
      searchString = searchString + 'accountingStandard:' + arrgContractAllocationsVSearchObject.accountingStandard + ',';
    }

    if (arrgContractAllocationsVSearchObject.totalCost != undefined && arrgContractAllocationsVSearchObject.totalCost != "") {
      searchString = searchString + 'totalCost:' + arrgContractAllocationsVSearchObject.totalCost;
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

    if(exportFlag != 0 && exportCols!=undefined && exportCols!=""){
      serviceUrl=serviceUrl+'&exportCols='+exportCols;
     }
    return serviceUrl;

  }

  getAllArrgContractAllocationsV(paginationOptions: any, arrgContractAllocationsVSearchObject: any, exportCols: any,quoteOrderSwitch: any): Promise<any[]> {
    let serviceUrl = this.getServiceUrl(paginationOptions, arrgContractAllocationsVSearchObject, 0, exportCols,quoteOrderSwitch);
    return this.http.get(serviceUrl).toPromise().then((data:any) => {
      return data;
    });
  }

  saveArrgContractAllocationsV(arrgContractAllocationsV: any): Promise<any[]> {
    let body = JSON.stringify(arrgContractAllocationsV);
    return this.http.post<any[]>(appSettings.apiUrl + '/ARRG_CONTRACT_ALLOCATIONS_V', body, httpOptions).toPromise().then(data => {
      return data;
    });
  }

  updateArrgContractAllocationsV(arrgContractAllocationsV: any): Promise<any[]> {

    delete arrgContractAllocationsV._links;
    delete arrgContractAllocationsV.interests;
    let body = JSON.stringify(arrgContractAllocationsV);
    return this.http.put<any[]>(appSettings.apiUrl + '/ARRG_CONTRACT_ALLOCATIONS_V/' + arrgContractAllocationsV.dealArrangementId, body, httpOptions).toPromise().then(data => {
      return data;
    });

  }

  deleteArrgContractAllocationsV(arrgContractAllocationsV: any): Promise<any[]> {
    let deleteUrl = appSettings.apiUrl + '/ARRG_CONTRACT_ALLOCATIONS_V/' + arrgContractAllocationsV.dealArrangementId;
    return this.http.delete(deleteUrl, httpOptions).toPromise().then((data:any) => {
      return data;
    });
  }

  //Backup for Get Prospective dealLines
  getAllProspectiveDeals(dealArrangementId: any, dealLines: any[]): Promise<any[]> {


    var dlstr = '';
    for (var i = 0; i < dealLines.length; i++) {
      dlstr = dlstr + "dealLinesList=" + dealLines[i];
      if (i < dealLines.length - 1) {
        dlstr = dlstr + '&';
      }
    }

    return this.http.get(appSettings.apiUrl + '/revmantra/getProspDealsData/?arrangementId=' + dealArrangementId + "&" + dlstr).toPromise().then((data:any) => {
      return data;
    });

  }
/**
  * Added cnt variable and Date values in prospDeals list data
  * need to format like ISO standrd Date like 'YYYY-MM-DD'
  * AYAR-403 Chandra Kota on 2021-JUN-01
  */
  processProspectiveDeals(arrgId: any, arrgNumber: any, arrgName: any, prospDeals: any[]) {
    let x: any[] = [];
    x[0] = arrgId;
    x[1] = arrgNumber;
    x[2] = arrgName;
    x[3] = prospDeals;
		let cnt:any = 0;
		prospDeals.forEach(x=>{
			
			if(x.contractStartDate){
				prospDeals[cnt].contractStartDate= this.datePipe.transform(x.contractStartDate,'yyyy-MM-dd');
			}
			if(x.contractEndDate){
				prospDeals[cnt].contractEndDate=this.datePipe.transform(x.contractEndDate,'yyyy-MM-dd');
			}
			if(x.serviceStartDate){
				prospDeals[cnt].serviceStartDate=this.datePipe.transform(x.serviceStartDate,'yyyy-MM-dd');
			}
			if(x.serviceEndDate){
				prospDeals[cnt].serviceEndDate=this.datePipe.transform(x.serviceEndDate,'yyyy-MM-dd');
			}
				cnt++;
		});
	x[3] = prospDeals;
	
    let body = JSON.stringify(x);
    let prosessPropsDealsUrl = appSettings.apiUrl + '/revmantra/processProspDealsData/';
    return this.http.post<any[]>(prosessPropsDealsUrl, body, httpOptions).toPromise().then(data => {
      return data;
    });
  }

  processRetrospectiveDeals(arrgId: any) {
    let prosessRetrospectiveDealsUrl = appSettings.apiUrl + '/revmantra/retrospectiveDeals/?arrangementId=' + arrgId;
    return this.http.post(prosessRetrospectiveDealsUrl,null).toPromise().then(data => {
      return data;
    });
  }

 
  getAllProspectiveDealsTest(dealArrangementId: any, dealLines: any[]): Observable<any[]> {
    var dlstr = '';
    for (var i = 0; i < dealLines.length; i++) {
      dlstr = dlstr + "dealLinesList=" + dealLines[i];
      if (i < dealLines.length - 1) {
        dlstr = dlstr + '&';
      }
    }
    return this.http.get(appSettings.apiUrl + '/revmantra/getProspDealsData/?arrangementId=' + dealArrangementId + "&" + dlstr)
      .pipe(map((res: Response[]) => res));

  }

  getValidArrangement(arrgNumber:any,arrgName:any) {
    return this.http.get(appSettings.apiUrl + '/revmantra/validateArrangementExists/?arrgNumber=' + arrgNumber + "&" + 'arrgName=' + arrgName, { responseType: 'text'})
    .toPromise().then((data:any) => {
      return data;
    });
  }

  reallocation(arrgId: any) {
    let allocationsUrl = appSettings.apiUrl + '/revmantra/reallocation/?arrangementId=' + arrgId;
    return this.http.post(allocationsUrl,null).toPromise().then(data => {
      return data;
    });
  }

  getAllAllocationsTotal(pDealArrangementId,quoteOrderSwitch) { 
    let getAllAllocationUrl = '';   
    if(quoteOrderSwitch){
      getAllAllocationUrl = appSettings.apiUrl + '/rmanGetOrderAllocationTotals?arrgId='+pDealArrangementId ;
    }else{
      getAllAllocationUrl = appSettings.apiUrl + '/rmanGetAllocationTotals?arrgId='+pDealArrangementId ;
    }
    return this.http.get(getAllAllocationUrl, httpOptions).toPromise().then((data:any) => {
      return data;
    });
  }

}
