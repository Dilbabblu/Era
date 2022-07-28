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
export class SspActionLogsService {

  constructor(private http: HttpClient) { }


  getActionLogs(paginationOptions: any){
    let serviceUrl = appSettings.apiUrl + "/rmanUserActivityLogSearch?";

    serviceUrl = serviceUrl + 'search=%20';

    if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != "" && !isNaN(paginationOptions.pageNumber) && paginationOptions.pageNumber != 0) {
      serviceUrl = serviceUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;
    }

    return this.http.get(serviceUrl).toPromise().then((data: any) => {
      return data;
    });
  }
  
}
