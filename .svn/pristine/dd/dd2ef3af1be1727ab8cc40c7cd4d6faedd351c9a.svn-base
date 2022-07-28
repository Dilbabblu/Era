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
export class RmanOrderLinesBookingsVService {

  constructor(private http: HttpClient) { }

  getServiceUrl(paginationOptions: any, rmanOrderLinesBookingsVSearchObject: any, exportFlag: any, exportCols: any) {

    let serviceUrl = appSettings.apiUrl + '/rmanOrderLinesBookingsVExport?';

    if (exportFlag == 0) {
      serviceUrl = appSettings.apiUrl + '/rmanOrderLinesBookingsVSearch?';
    }
    let searchString = '';

    if (rmanOrderLinesBookingsVSearchObject.arrangementId != undefined && rmanOrderLinesBookingsVSearchObject.arrangementId != "") {
      searchString = searchString + 'arrangementId:' + rmanOrderLinesBookingsVSearchObject.arrangementId + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.rmanLineId != undefined && rmanOrderLinesBookingsVSearchObject.rmanLineId != "") {
      searchString = searchString + 'rmanLineId:' + rmanOrderLinesBookingsVSearchObject.rmanLineId + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.so != undefined && rmanOrderLinesBookingsVSearchObject.so != "") {
      searchString = searchString + 'so:' + rmanOrderLinesBookingsVSearchObject.so + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.ouName != undefined && rmanOrderLinesBookingsVSearchObject.ouName != "") {
      searchString = searchString + 'ouName:' + rmanOrderLinesBookingsVSearchObject.ouName + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.endCustomer != undefined && rmanOrderLinesBookingsVSearchObject.endCustomer != "") {
      searchString = searchString + 'endCustomer:' + rmanOrderLinesBookingsVSearchObject.endCustomer + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.orderBookedDate != undefined && rmanOrderLinesBookingsVSearchObject.orderBookedDate != "") {
      searchString = searchString + 'orderBookedDate:' + rmanOrderLinesBookingsVSearchObject.orderBookedDate + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.priceList != undefined && rmanOrderLinesBookingsVSearchObject.priceList != "") {
      searchString = searchString + 'priceList:' + rmanOrderLinesBookingsVSearchObject.priceList + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.customerPoNum != undefined && rmanOrderLinesBookingsVSearchObject.customerPoNum != "") {
      searchString = searchString + 'customerPoNum:' + rmanOrderLinesBookingsVSearchObject.customerPoNum + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.bookingCurrency != undefined && rmanOrderLinesBookingsVSearchObject.bookingCurrency != "") {
      searchString = searchString + 'bookingCurrency:' + rmanOrderLinesBookingsVSearchObject.bookingCurrency + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.funcCurrencyCode != undefined && rmanOrderLinesBookingsVSearchObject.funcCurrencyCode != "") {
      searchString = searchString + 'funcCurrencyCode:' + rmanOrderLinesBookingsVSearchObject.funcCurrencyCode + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.productName != undefined && rmanOrderLinesBookingsVSearchObject.productName != "") {
      searchString = searchString + 'productName:' + rmanOrderLinesBookingsVSearchObject.productName + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.listPrice != undefined && rmanOrderLinesBookingsVSearchObject.listPrice != "") {
      searchString = searchString + 'listPrice:' + rmanOrderLinesBookingsVSearchObject.listPrice + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.netPrice != undefined && rmanOrderLinesBookingsVSearchObject.netPrice != "") {
      searchString = searchString + 'netPrice:' + rmanOrderLinesBookingsVSearchObject.netPrice + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.lineStatus != undefined && rmanOrderLinesBookingsVSearchObject.lineStatus != "") {
      searchString = searchString + 'lineStatus:' + rmanOrderLinesBookingsVSearchObject.lineStatus + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.shipeedDate != undefined && rmanOrderLinesBookingsVSearchObject.shipeedDate != "") {
      searchString = searchString + 'shipeedDate:' + rmanOrderLinesBookingsVSearchObject.shipeedDate + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.accountingRuleName != undefined && rmanOrderLinesBookingsVSearchObject.accountingRuleName != "") {
      searchString = searchString + 'accountingRuleName:' + rmanOrderLinesBookingsVSearchObject.accountingRuleName + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.contractStartDate != undefined && rmanOrderLinesBookingsVSearchObject.contractStartDate != "") {
      searchString = searchString + 'contractStartDate:' + rmanOrderLinesBookingsVSearchObject.contractStartDate + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.contractEndDate != undefined && rmanOrderLinesBookingsVSearchObject.contractEndDate != "") {
      searchString = searchString + 'contractEndDate:' + rmanOrderLinesBookingsVSearchObject.contractEndDate + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.elementType != undefined && rmanOrderLinesBookingsVSearchObject.elementType != "") {
      searchString = searchString + 'elementType:' + rmanOrderLinesBookingsVSearchObject.elementType + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.productCategory != undefined && rmanOrderLinesBookingsVSearchObject.productCategory != "") {
      searchString = searchString + 'productCategory:' + rmanOrderLinesBookingsVSearchObject.productCategory + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.productFamily != undefined && rmanOrderLinesBookingsVSearchObject.productFamily != "") {
      searchString = searchString + 'productFamily:' + rmanOrderLinesBookingsVSearchObject.productFamily + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.accountingScope != undefined && rmanOrderLinesBookingsVSearchObject.accountingScope != "") {
      searchString = searchString + 'accountingScope:' + rmanOrderLinesBookingsVSearchObject.accountingScope + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.revrecAcctRule != undefined && rmanOrderLinesBookingsVSearchObject.revrecAcctRule != "") {
      searchString = searchString + 'revrecAcctRule:' + rmanOrderLinesBookingsVSearchObject.revrecAcctRule + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.revrecStDate != undefined && rmanOrderLinesBookingsVSearchObject.revrecStDate != "") {
      searchString = searchString + 'revrecStDate:' + rmanOrderLinesBookingsVSearchObject.revrecStDate + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.revrecEndDate != undefined && rmanOrderLinesBookingsVSearchObject.revrecEndDate != "") {
      searchString = searchString + 'revrecEndDate:' + rmanOrderLinesBookingsVSearchObject.revrecEndDate + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.revrecAcctScope != undefined && rmanOrderLinesBookingsVSearchObject.revrecAcctScope != "") {
      searchString = searchString + 'revrecAcctScope:' + rmanOrderLinesBookingsVSearchObject.revrecAcctScope + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.revrecDelay != undefined && rmanOrderLinesBookingsVSearchObject.revrecDelay != "") {
      searchString = searchString + 'revrecDelay:' + rmanOrderLinesBookingsVSearchObject.revrecDelay + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.revrecAccount != undefined && rmanOrderLinesBookingsVSearchObject.revrecAccount != "") {
      searchString = searchString + 'revrecAccount:' + rmanOrderLinesBookingsVSearchObject.revrecAccount + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.orderedQuantity != undefined && rmanOrderLinesBookingsVSearchObject.orderedQuantity != "") {
      searchString = searchString + 'orderedQuantity:' + rmanOrderLinesBookingsVSearchObject.orderedQuantity + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.shippedQuantity != undefined && rmanOrderLinesBookingsVSearchObject.shippedQuantity != "") {
      searchString = searchString + 'shippedQuantity:' + rmanOrderLinesBookingsVSearchObject.shippedQuantity + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.da != undefined && rmanOrderLinesBookingsVSearchObject.da != "") {
      searchString = searchString + 'da:' + rmanOrderLinesBookingsVSearchObject.da + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.bundleFlag != undefined && rmanOrderLinesBookingsVSearchObject.bundleFlag != "") {
      searchString = searchString + 'bundleFlag:' + rmanOrderLinesBookingsVSearchObject.bundleFlag + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.parentLineId != undefined && rmanOrderLinesBookingsVSearchObject.parentLineId != "") {
      searchString = searchString + 'parentLineId:' + rmanOrderLinesBookingsVSearchObject.parentLineId + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.uom != undefined && rmanOrderLinesBookingsVSearchObject.uom != "") {
      searchString = searchString + 'uom:' + rmanOrderLinesBookingsVSearchObject.uom + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.lineAmount != undefined && rmanOrderLinesBookingsVSearchObject.lineAmount != "") {
      searchString = searchString + 'lineAmount:' + rmanOrderLinesBookingsVSearchObject.lineAmount + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.bookedDate != undefined && rmanOrderLinesBookingsVSearchObject.bookedDate != "") {
      searchString = searchString + 'bookedDate:' + rmanOrderLinesBookingsVSearchObject.bookedDate + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.shipDate != undefined && rmanOrderLinesBookingsVSearchObject.shipDate != "") {
      searchString = searchString + 'shipDate:' + rmanOrderLinesBookingsVSearchObject.shipDate + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.billedDate != undefined && rmanOrderLinesBookingsVSearchObject.billedDate != "") {
      searchString = searchString + 'billedDate:' + rmanOrderLinesBookingsVSearchObject.billedDate + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.milestone != undefined && rmanOrderLinesBookingsVSearchObject.milestone != "") {
      searchString = searchString + 'milestone:' + rmanOrderLinesBookingsVSearchObject.milestone + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.pobGrouping != undefined && rmanOrderLinesBookingsVSearchObject.pobGrouping != "") {
      searchString = searchString + 'pobGrouping:' + rmanOrderLinesBookingsVSearchObject.pobGrouping + ',';
    }

    if (rmanOrderLinesBookingsVSearchObject.pobTemplate != undefined && rmanOrderLinesBookingsVSearchObject.pobTemplate != "") {
      searchString = searchString + 'pobTemplate:' + rmanOrderLinesBookingsVSearchObject.pobTemplate;
    }
    
    if (rmanOrderLinesBookingsVSearchObject.sourceHeaderId != undefined && rmanOrderLinesBookingsVSearchObject.sourceHeaderId != "") {
      searchString = searchString + 'sourceHeaderId:' + rmanOrderLinesBookingsVSearchObject.sourceHeaderId;
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

    
	 if(exportCols!=undefined && exportCols!=""){
    serviceUrl=serviceUrl+'&exportCols='+exportCols;
   }

    return serviceUrl;
  }

  getAllRmanOrderLinesBookingsV(paginationOptions: any, rmanOrderLinesBookingsVSearchObject: any, exportCols: any): Promise<any[]> {
    let serviceUrl = this.getServiceUrl(paginationOptions, rmanOrderLinesBookingsVSearchObject, 0, exportCols);
    return this.http.get(serviceUrl).toPromise().then((data: any) => {
      return data;
    });
  }
  saveRmanOrderLinesBookingsV(rmanOrderLinesBookingsV: any): Promise<any[]> {
    let body = JSON.stringify(rmanOrderLinesBookingsV);
    return this.http.post(appSettings.apiUrl + '/RMAN_ORDER_LINES_BOOKINGS_V', body, httpOptions).toPromise().then((data: any) => {
      return data;
    });
  }

  updateRmanOrderLinesBookingsV(rmanOrderLinesBookingsV: any): Promise<any[]> {

    delete rmanOrderLinesBookingsV._links;
    delete rmanOrderLinesBookingsV.interests;
    let body = JSON.stringify(rmanOrderLinesBookingsV);
    return this.http.put(appSettings.apiUrl + '/RMAN_ORDER_LINES_BOOKINGS_V/' + rmanOrderLinesBookingsV.so, body, httpOptions).toPromise().then((data: any) => {
      return data;
    });

  }

  deleteRmanOrderLinesBookingsV(rmanOrderLinesBookingsV: any): Promise<any[]> {
    let deleteUrl = appSettings.apiUrl + '/RMAN_ORDER_LINES_BOOKINGS_V/' + rmanOrderLinesBookingsV.so;
    return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
      return data;
    });
  }

  unLinkSalesOrderline(rmanOrderLinesBookingsV: any) {
    let body = "arrangementId=" + rmanOrderLinesBookingsV.arrangementId + "&soLineId=" + rmanOrderLinesBookingsV.sourceLineId;
    let unlinkSOLineUrl = appSettings.apiUrl + '/unlinkSoLine?' + body;
    return this.http.get(unlinkSOLineUrl).toPromise().then(data => {
      data=JSON.parse(JSON.stringify(data || null));
      return data;
    });
  }

linkSalesOrderline(sourceLineId: any, targetDealArrangementId: any, targetDealNumber: any, targetDealLineNumber: any) {

    let body = "arrangementId=" + targetDealArrangementId + "&soLineId=" + sourceLineId + "&dealNumber=" + targetDealNumber + "&dealLineNumber=" + targetDealLineNumber;
    let linkSOLineUrl = appSettings.apiUrl + '/linkSoLine?' + body;
    return this.http.get(linkSOLineUrl).toPromise().then(data => {
      data = JSON.parse(JSON.stringify(data || null ));
      return data;
    });
  }

}
