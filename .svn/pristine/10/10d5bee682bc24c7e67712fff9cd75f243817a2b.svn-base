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
export class RmanRevDetailsVService {

  constructor(private http: HttpClient) { }


  getServiceUrl(paginationOptions: any, arrgId: any, so: any, soLine: any, revType: any, exportFlag: any, exportCols: any) {

    let serviceUrl = appSettings.apiUrl + '/rmanRevDetailsVExport?arrgId=' + arrgId + "&revType=" + revType;

    if (exportFlag == 0) {
      serviceUrl = appSettings.apiUrl + '/rmanRevDetailsVSearch?arrgId=' + arrgId + "&revType=" + revType;
    }

    if (so != undefined && so != "" && isNaN(so)) {
      serviceUrl = serviceUrl + '&so=' + so;
    } else {
      serviceUrl = serviceUrl + '&so=';
    }
    if (soLine != undefined && soLine != "" && isNaN(soLine)) {
      serviceUrl = serviceUrl + '&soLine=' + soLine;
    } else {
      serviceUrl = serviceUrl + '&soLine=';
    }



    if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != "" && !isNaN(paginationOptions.pageNumber)) {
      serviceUrl = serviceUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;
    }

    if (exportCols != undefined && exportCols != "") {
      serviceUrl = serviceUrl + '&exportCols=' + exportCols;
    }

    return serviceUrl;
  }

  getAllRmanRevDetailsV(paginationOptions: any, arrgId: any, so: any, soLine: any, revType: any, exportCols: any): Promise<any[]> {
    let serviceUrl = this.getServiceUrl(paginationOptions, arrgId, so, soLine, revType, 0, exportCols);
    return this.http.get(serviceUrl).toPromise().then((data: any) => {
      return data;
    });
  }

  saveRmanRevDetailsV(rmanRevDetailsV: any): Promise<any[]> {
    let body = JSON.stringify(rmanRevDetailsV);
    return this.http.post<any[]>(appSettings.apiUrl + '/RMAN_REV_DETAILS_V', body, httpOptions).toPromise().then(data => {
      return data;
    });
  }

  updateRmanRevDetailsV(rmanRevDetailsV: any): Promise<any[]> {

    delete rmanRevDetailsV._links;
    delete rmanRevDetailsV.interests;
    let body = JSON.stringify(rmanRevDetailsV);
    return this.http.put<any[]>(appSettings.apiUrl + '/RMAN_REV_DETAILS_V/' + rmanRevDetailsV.dealLineId, body, httpOptions).toPromise().then(data => {
      return data;
    });

  }

  deleteRmanRevDetailsV(rmanRevDetailsV: any): Promise<any[]> {
    let deleteUrl = appSettings.apiUrl + '/RMAN_REV_DETAILS_V/' + rmanRevDetailsV.dealLineId;
    return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
      return data;
    });
  }

  getAllRevenueTotals(pDealArrangementId: any, so: any, soLine: any, revType: any) {

    let getTotalUrl = appSettings.apiUrl + '/rmanGetRevTotals?arrgId=' + pDealArrangementId + "&revType=" + revType;
    if (so != undefined && so != "" && isNaN(so)) {
      getTotalUrl = getTotalUrl + '&so=' + so;
    } else {
      getTotalUrl = getTotalUrl + '&so=';
    }
    if (soLine != undefined && soLine != "" && isNaN(soLine)) {
      getTotalUrl = getTotalUrl + '&soLine=' + soLine;
    } else {
      getTotalUrl = getTotalUrl + '&soLine=';
    }
    return this.http.get(getTotalUrl, httpOptions).toPromise().then((data: any) => {
      return data;
    });
  }

  getUsageSummaryDetails(paginationOptions: any, pDealLineId: any) {
    let serviceUrl = appSettings.apiUrl + '/rmanDealUsagesSummarySearch?';

    if (pDealLineId != undefined && pDealLineId != "" && isNaN(pDealLineId)) {
      serviceUrl = serviceUrl + 'search=dealLineId:' + pDealLineId;
    } else {
      serviceUrl = serviceUrl + 'search=%25';
    }

    if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != "" && !isNaN(paginationOptions.pageNumber)) {
      serviceUrl = serviceUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;
    }
    return this.http.get(serviceUrl).toPromise().then((data: any) => {
      return data;
    });
  }

  getAllUsages(paginationOptions: any, pDealLineId: any): Promise<any[]> {
    let serviceUrl = appSettings.apiUrl + '/rmanUsageSummaryDetailsSearch?search=dealLineId:' + pDealLineId;
    if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != "" && !isNaN(paginationOptions.pageNumber)) {
      serviceUrl = serviceUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;
    }
    return this.http.get(serviceUrl).toPromise().then((data: any) => {
      return data;
    });

  }

  getDeliveryDetails(paginationOptions: any, pDealLineId: any, pSourceLineId: any): Promise<any[]> {
    let serviceUrl = appSettings.apiUrl + '/ayaraOrderDeliveryDetailsInfoVSearch?';
    
    if(pDealLineId !=null && pDealLineId !=undefined && pDealLineId !="" && pSourceLineId !=null && pSourceLineId !=undefined && pSourceLineId !=""){
      serviceUrl = serviceUrl +'search=dealLineId:'+ pDealLineId +'&sourceLineId:'+pSourceLineId;
    }else{
        serviceUrl = serviceUrl + 'search=%25';
    }
    
    if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != "" && !isNaN(paginationOptions.pageNumber)) {
      serviceUrl = serviceUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;
    }
    return this.http.get(serviceUrl).toPromise().then((data: any) => {
      return data;
    });

  }

  getActualRevSchedules(paginationOptions: any, arrgId: any): Promise<any[]> {
    let serviceUrl = appSettings.apiUrl + '/actualRevenueScheduleReport?arrgId=' + arrgId;
    if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != "" && !isNaN(paginationOptions.pageNumber)) {
      serviceUrl = serviceUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;
    }
    return this.http.get(serviceUrl).toPromise().then((data: any) => {
      return data;
    });

  }

}
