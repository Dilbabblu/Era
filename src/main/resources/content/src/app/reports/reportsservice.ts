import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
declare var require: any;
const appSettings = require('../appsettings');

@Injectable()
export class ReportsService {

  constructor(private http: HttpClient) { }

  getAllReports(search:any): Promise<any[]> {
    let serviceUrl = appSettings.apiUrl + '/ayaraReportsSearch?';
    let searchString = search;

    if (searchString == '') {
      serviceUrl = serviceUrl + 'search=%25';
    }
    else {
      serviceUrl = serviceUrl + 'search=' + searchString;
    }

    return this.http.get(serviceUrl).toPromise().then((data: any) => {
      return data;
    });
  }
}