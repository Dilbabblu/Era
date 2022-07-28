import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
declare var require: any;
const appSettings = require('../appsettings');


@Injectable()
export class RmanArrgForecastingDetailReportService {

    constructor(private http: HttpClient) { }


    getRmanForecastDetailsReport(arrgLevel: any, arrgId: any, fromPeriod: any, toPeriod: any) {

        if (fromPeriod == undefined) {
            fromPeriod = '';
        }
        if (toPeriod == undefined) {
            toPeriod = '';
        }
        if (arrgLevel == undefined) {
            arrgLevel = '';
        }
        if (arrgId == undefined) {
            arrgId = '';
        }

        let serviceUrl = appSettings.apiUrl + '/reports/forecastingReport?arrgLevel=' + arrgLevel + '&arrgId=' + arrgId + '&fromPeriod=' + fromPeriod + '&toPeriod=' + toPeriod;
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }

    getRmanForecastingDetailsReportFile(arrgLevel: any, arrgId: any, fromPeriod: any, toPeriod: any, exportCols: any) {

        if (fromPeriod == undefined) {
            fromPeriod = '';
        }
        if (toPeriod == undefined) {
            toPeriod = '';
        }
        if (arrgLevel == undefined) {
            arrgLevel = '';
        }
        if (arrgId == undefined) {
            arrgId = '';
        }
        
        let serviceUrl = appSettings.apiUrl + '/reports/exportForecastingReport?arrgLevel=' + arrgLevel + '&arrgId=' + arrgId + '&fromPeriod=' + fromPeriod + '&toPeriod=' + toPeriod;

        if (exportCols != undefined && exportCols != "") {
            serviceUrl = serviceUrl + '&exportCols=' + exportCols;
        }
        return serviceUrl;
    }
}
