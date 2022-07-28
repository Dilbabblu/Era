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
export class LandingDashboardService {

  constructor(private http: HttpClient) { }

  saveDashboardReportsLayout(checkedReport: any) {
    let serviceUrl = appSettings.apiUrl + "/updateclobs";
    let body = JSON.stringify(checkedReport);
    return this.http.put<any[]>(serviceUrl, body, httpOptions).toPromise().then(data => {
      return data;
    });
  }

  getOverviewFigures(fYear: any, pDimension: any, period: any, quarter: any) {
    if (fYear == undefined) {
      fYear = '';
    }
    if (pDimension == undefined) {
      pDimension = '';
    }
    if (period == undefined) {
      period = '';
    }
    if (quarter == undefined) {
      quarter = '';
    }

    let serviceUrl = appSettings.apiUrl + '/dashboardOverviewFigures?fYear=' + fYear + "&pDimension=" + pDimension + '&quarter=' + quarter + '&period=' + period;
    return this.http.get(serviceUrl).toPromise().then((data: any) => {
      return data;
    });
  }
}
