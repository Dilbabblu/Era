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
export class RmanPendingApprovalsService {

  constructor(private http: HttpClient) { }

  getAllPendingApprovals(paginationOptions: any): Promise<any[]> {
    let serviceUrl = appSettings.apiUrl + '/ayaraRcPendingApprovalsVSearch?';

    let searchString = '';

    if (searchString == '') {
      serviceUrl = serviceUrl + 'search=%25';
    }
    else {
      serviceUrl = serviceUrl + 'search=' + searchString;
    }

    if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != "" && !isNaN(paginationOptions.pageNumber) && paginationOptions.pageNumber != 0) {
      serviceUrl = serviceUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;
    }

    return this.http.get(serviceUrl).toPromise().then((data: any) => {
      return data;
    });


  }

  getAllOutstandingApprovals(paginationOptions: any): Promise<any[]> {
    let serviceUrl = appSettings.apiUrl + '/ayaraPendingSubmissionApprovalsVSearch?';

    let searchString = '';

    if (searchString == '') {
      serviceUrl = serviceUrl + 'search=%25';
    }
    else {
      serviceUrl = serviceUrl + 'search=' + searchString;
    }

    if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != "" && !isNaN(paginationOptions.pageNumber) && paginationOptions.pageNumber != 0) {
      serviceUrl = serviceUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;
    }

    return this.http.get(serviceUrl).toPromise().then((data: any) => {
      return data;
    });


  }

  processContract(rmanPendingApprovals: any): Promise<any[]> {
    let body = JSON.stringify(rmanPendingApprovals);
    return this.http.post<any[]>(appSettings.apiUrl + '/processContract', body, httpOptions).toPromise().then(data => {
      return data;
    });
  }

  processDelegate(rmanPendingApprovals: any, user: any, comments:any): Promise<any> {
    let serviceUrl = appSettings.apiUrl + '/delegateTask?processInstanceId='+rmanPendingApprovals.processInstanceId+'&assignee='+user;
    return this.http.get(serviceUrl).toPromise().then((result: any) => {
      return result;
    });

  }

  fetchDelegateUsers(): Promise<any> {
    let serviceUrl = appSettings.apiUrl + '/fetchDelegateUsers';
    return this.http.get(serviceUrl).toPromise().then((data: any) => {
      return data;
    });

  }


}
