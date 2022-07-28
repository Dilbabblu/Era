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
export class RmanDealGmAsvService {

  constructor(private http: HttpClient) { }

  getServiceUrl(paginationOptions: any, rmanDealGmAsvSearchObject: any, exportFlag: any) {

    let serviceUrl = appSettings.apiUrl + '/rmanDealGmAsvExport?';

    if (exportFlag == 0) {
      serviceUrl = appSettings.apiUrl + '/rmanDealGmAsvSearch?';
    }
    let searchString = '';

    if (rmanDealGmAsvSearchObject.sno != undefined && rmanDealGmAsvSearchObject.sno != "") {
      searchString = searchString + 'sno:' + rmanDealGmAsvSearchObject.sno + ',';
    }

    if (rmanDealGmAsvSearchObject.arrangementId != undefined && rmanDealGmAsvSearchObject.arrangementId != "") {
      searchString = searchString + 'arrangementId:' + rmanDealGmAsvSearchObject.arrangementId + ',';
    }

    if (rmanDealGmAsvSearchObject.arrangementName != undefined && rmanDealGmAsvSearchObject.arrangementName != "") {
      searchString = searchString + 'arrangementName:' + rmanDealGmAsvSearchObject.arrangementName + ',';
    }

    if (rmanDealGmAsvSearchObject.sku != undefined && rmanDealGmAsvSearchObject.sku != "") {
      searchString = searchString + 'sku:' + rmanDealGmAsvSearchObject.sku + ',';
    }

    if (rmanDealGmAsvSearchObject.elementType != undefined && rmanDealGmAsvSearchObject.elementType != "") {
      searchString = searchString + 'elementType:' + rmanDealGmAsvSearchObject.elementType + ',';
    }

    if (rmanDealGmAsvSearchObject.qty != undefined && rmanDealGmAsvSearchObject.qty != "") {
      searchString = searchString + 'qty:' + rmanDealGmAsvSearchObject.qty + ',';
    }

    if (rmanDealGmAsvSearchObject.netPrice != undefined && rmanDealGmAsvSearchObject.netPrice != "") {
      searchString = searchString + 'netPrice:' + rmanDealGmAsvSearchObject.netPrice + ',';
    }

    if (rmanDealGmAsvSearchObject.totalExpectedBookings != undefined && rmanDealGmAsvSearchObject.totalExpectedBookings != "") {
      searchString = searchString + 'totalExpectedBookings:' + rmanDealGmAsvSearchObject.totalExpectedBookings + ',';
    }

    if (rmanDealGmAsvSearchObject.lineCost != undefined && rmanDealGmAsvSearchObject.lineCost != "") {
      searchString = searchString + 'lineCost:' + rmanDealGmAsvSearchObject.lineCost + ',';
    }

    if (rmanDealGmAsvSearchObject.grossMargin != undefined && rmanDealGmAsvSearchObject.grossMargin != "") {
      searchString = searchString + 'grossMargin:' + rmanDealGmAsvSearchObject.grossMargin;
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

  getAllRmanDealGmAsv(paginationOptions: any, rmanDealGmAsvSearchObject: any): Promise<any[]> {
    let serviceUrl = this.getServiceUrl(paginationOptions, rmanDealGmAsvSearchObject, 0);
    return this.http.get(serviceUrl).toPromise().then((data: any) => {
      return data;
    });
  }

  saveRmanDealGmAsv(rmanDealGmAsv: any): Promise<any[]> {
    let body = JSON.stringify(rmanDealGmAsv);
    return this.http.post<any[]>(appSettings.apiUrl + '/RMAN_DEAL_GM_ASV', body, httpOptions).toPromise().then(data => {
      return data;
    });
  }

  updateRmanDealGmAsv(rmanDealGmAsv: any): Promise<any[]> {

    delete rmanDealGmAsv._links;
    delete rmanDealGmAsv.interests;
    let body = JSON.stringify(rmanDealGmAsv);
    return this.http.put<any[]>(appSettings.apiUrl + '/RMAN_DEAL_GM_ASV/' + rmanDealGmAsv.sno, body, httpOptions).toPromise().then((data: any) => {
      return data;
    });

  }

  deleteRmanDealGmAsv(rmanDealGmAsv: any): Promise<any[]> {
    let deleteUrl = appSettings.apiUrl + '/RMAN_DEAL_GM_ASV/' + rmanDealGmAsv.sno;
    return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
      return data;
    });
  }

}
