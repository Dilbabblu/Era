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
export class RmanOrderBookingsVService {

  constructor(private http: HttpClient) { }

  getServiceUrl(paginationOptions: any, rmanOrderBookingsVSearchObject: any, exportFlag: any, exportCols: any) {

    let serviceUrl = appSettings.apiUrl + '/rmanOrderBookingsVExport?';

    if (exportFlag == 0) {
      serviceUrl = appSettings.apiUrl + '/rmanOrderBookingsVSearch?';
    }

    let searchString = '';

    if (rmanOrderBookingsVSearchObject.arrangementId != undefined && rmanOrderBookingsVSearchObject.arrangementId != "") {
      searchString = searchString + 'arrangementId:' + rmanOrderBookingsVSearchObject.arrangementId + ',';
    }

    if (rmanOrderBookingsVSearchObject.so != undefined && rmanOrderBookingsVSearchObject.so != "") {
      searchString = searchString + 'so:' + rmanOrderBookingsVSearchObject.so + ',';
    }

    if (rmanOrderBookingsVSearchObject.ouName != undefined && rmanOrderBookingsVSearchObject.ouName != "") {
      searchString = searchString + 'ouName:' + rmanOrderBookingsVSearchObject.ouName + ',';
    }

    if (rmanOrderBookingsVSearchObject.endCustomer != undefined && rmanOrderBookingsVSearchObject.endCustomer != "") {
      searchString = searchString + 'endCustomer:' + rmanOrderBookingsVSearchObject.endCustomer + ',';
    }

    if (rmanOrderBookingsVSearchObject.customerNumber != undefined && rmanOrderBookingsVSearchObject.customerNumber != "") {
      searchString = searchString + 'customerNumber:' + rmanOrderBookingsVSearchObject.customerNumber + ',';
    }

    if (rmanOrderBookingsVSearchObject.billToLocation != undefined && rmanOrderBookingsVSearchObject.billToLocation != "") {
      searchString = searchString + 'billToLocation:' + rmanOrderBookingsVSearchObject.billToLocation + ',';
    }

    if (rmanOrderBookingsVSearchObject.shipToLocation != undefined && rmanOrderBookingsVSearchObject.shipToLocation != "") {
      searchString = searchString + 'shipToLocation:' + rmanOrderBookingsVSearchObject.shipToLocation + ',';
    }

    if (rmanOrderBookingsVSearchObject.orderBookedDate != undefined && rmanOrderBookingsVSearchObject.orderBookedDate != "") {
      searchString = searchString + 'orderBookedDate:' + rmanOrderBookingsVSearchObject.orderBookedDate + ',';
    }

    if (rmanOrderBookingsVSearchObject.priceList != undefined && rmanOrderBookingsVSearchObject.priceList != "") {
      searchString = searchString + 'priceList:' + rmanOrderBookingsVSearchObject.priceList + ',';
    }

    if (rmanOrderBookingsVSearchObject.customerPoNum != undefined && rmanOrderBookingsVSearchObject.customerPoNum != "") {
      searchString = searchString + 'customerPoNum:' + rmanOrderBookingsVSearchObject.customerPoNum + ',';
    }

    if (rmanOrderBookingsVSearchObject.bookingCurrency != undefined && rmanOrderBookingsVSearchObject.bookingCurrency != "") {
      searchString = searchString + 'bookingCurrency:' + rmanOrderBookingsVSearchObject.bookingCurrency + ',';
    }

    if (rmanOrderBookingsVSearchObject.funcCurrencyCode != undefined && rmanOrderBookingsVSearchObject.funcCurrencyCode != "") {
      searchString = searchString + 'funcCurrencyCode:' + rmanOrderBookingsVSearchObject.funcCurrencyCode + ',';
    }

    if (rmanOrderBookingsVSearchObject.orderAcctdAmount != undefined && rmanOrderBookingsVSearchObject.orderAcctdAmount != "") {
      searchString = searchString + 'orderAcctdAmount:' + rmanOrderBookingsVSearchObject.orderAcctdAmount + ',';
    }

    if (rmanOrderBookingsVSearchObject.orderTrxAmount != undefined && rmanOrderBookingsVSearchObject.orderTrxAmount != "") {
      searchString = searchString + 'orderTrxAmount:' + rmanOrderBookingsVSearchObject.orderTrxAmount + ',';
    }

    if (rmanOrderBookingsVSearchObject.linkedDate != undefined && rmanOrderBookingsVSearchObject.linkedDate != "") {
      searchString = searchString + 'linkedDate:' + rmanOrderBookingsVSearchObject.linkedDate;
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

    if (exportCols != undefined && exportCols != "") {
      serviceUrl = serviceUrl + '&exportCols=' + exportCols;
    }
    return serviceUrl;
  }

  getAllRmanOrderBookingsV(paginationOptions: any, rmanOrderBookingsVSearchObject: any, exportCols: any): Promise<any[]> {
    let serviceUrl = this.getServiceUrl(paginationOptions, rmanOrderBookingsVSearchObject, 0, exportCols);
    return this.http.get(serviceUrl).toPromise().then((data: any) => {
      return data;
    });
  }




  getSoLink(ordNumber: any, srcArrgId: any, trgDealId: any): Promise<any[]> {
    let body = "ordNumber=" + ordNumber + "&srcArrgId=" + srcArrgId + "&trgDealId=" + trgDealId;
    let soLinkUrl = appSettings.apiUrl + '/revmantra/soLink?' + body;
    return this.http.get(soLinkUrl).toPromise().then((data: any) => {
      return data;
    });
  }

  getPoLink(srcPoNum: any, srcArrgId: any, trgPoNum: any, trgArrgId: any) {
    let body = "srcPoNum=" + srcPoNum + "&srcArrgId=" + srcArrgId + "&trgPoNum=" + trgPoNum + "&trgArrgId=" + trgArrgId;
    let poLinkUrl = appSettings.apiUrl + '/revmantra/reLinkPO?' + body;
    return this.http.get(poLinkUrl, { responseType: 'text' }).toPromise().then((data: any) => {
      return data;
    });
  }

  saveRmanOrderBookingsV(rmanOrderBookingsV: any): Promise<any[]> {
    let body = JSON.stringify(rmanOrderBookingsV);
    return this.http.post<any[]>(appSettings.apiUrl + '/RMAN_ORDER_BOOKINGS_V', body, httpOptions).toPromise().then(data => {
      return data;
    });
  }

  updateRmanOrderBookingsV(rmanOrderBookingsV: any): Promise<any[]> {

    delete rmanOrderBookingsV._links;
    delete rmanOrderBookingsV.interests;
    let body = JSON.stringify(rmanOrderBookingsV);
    return this.http.put<any[]>(appSettings.apiUrl + '/RMAN_ORDER_BOOKINGS_V/' + rmanOrderBookingsV.so, body, httpOptions).toPromise().then(data => {
      return data;
    });

  }

  deleteRmanOrderBookingsV(rmanOrderBookingsV: any): Promise<any[]> {
    let deleteUrl = appSettings.apiUrl + '/RMAN_ORDER_BOOKINGS_V/' + rmanOrderBookingsV.so;
    return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
      return data;
    });
  }

  delinkPO(srcPoNum: any, srcArrgId: any) {
    let delinkURL = appSettings.apiUrl + '/revmantra/unLinkPO?poNum=' + srcPoNum + '&srcArrgId=' + srcArrgId;
    return this.http.get(delinkURL, { responseType: 'text' }).toPromise().then((data: any) => {
      return data;
    });
  }

}
