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
export class RmanApprovalHistoryService {

  constructor(private http: HttpClient) { }

  getServiceUrl(paginationOptions: any, rmanApprovalHistorySearchObject: any, exportFlag: any) {

    let serviceUrl = appSettings.apiUrl + '/rmanApprovalHistoryExport?';

    if (exportFlag == 0) {
      serviceUrl = appSettings.apiUrl + '/ayaraRcApprovalHistoryVSearch?';
    }
    let searchString = '';

    if (rmanApprovalHistorySearchObject.arrangementId != undefined && rmanApprovalHistorySearchObject.arrangementId != "") {
      searchString = searchString + 'arrangementId:' + rmanApprovalHistorySearchObject.arrangementId + ',';
    }

    if (rmanApprovalHistorySearchObject.approvalStatus != undefined && rmanApprovalHistorySearchObject.approvalStatus != "") {
      searchString = searchString + 'approvalStatus:' + rmanApprovalHistorySearchObject.approvalStatus + ',';
    }

    if (rmanApprovalHistorySearchObject.actionBy != undefined && rmanApprovalHistorySearchObject.actionBy != "") {
      searchString = searchString + 'actionBy:' + rmanApprovalHistorySearchObject.actionBy + ',';
    }

    if (rmanApprovalHistorySearchObject.actionDate != undefined && rmanApprovalHistorySearchObject.actionDate != "") {
      searchString = searchString + 'actionDate:' + rmanApprovalHistorySearchObject.actionDate + ',';
    }

    if (rmanApprovalHistorySearchObject.comments != undefined && rmanApprovalHistorySearchObject.comments != "") {
      searchString = searchString + 'comments:' + rmanApprovalHistorySearchObject.comments + ',';
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

  getAllApprovalHistory(paginationOptions: any, rmanApprovalHistorySearchObject: any): Promise<any[]> {
    let serviceUrl = this.getServiceUrl(paginationOptions, rmanApprovalHistorySearchObject, 0);
    return this.http.get(serviceUrl).toPromise().then((data: any) => {
      return data;
    });
  }


}
