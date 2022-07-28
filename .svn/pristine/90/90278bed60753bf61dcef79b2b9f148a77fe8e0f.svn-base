import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
declare var require: any;
const appSettings = require('../appsettings');


@Injectable()
export class AyaraActualsARMReportService {

    constructor(private http: HttpClient) { }


    getAyaraActualsARMReport(arrgLevel: any, fromDate: any, toDate: any) {

        if (fromDate == undefined) {
            fromDate = '';
        }
        if (toDate == undefined) {
            toDate = '';
        }
        if (arrgLevel == undefined) {
            arrgLevel = '';
        }

        let serviceUrl = appSettings.apiUrl + '/reports/actualsArmReport?arrgLevel=' + arrgLevel + '&fromDate=' + fromDate + '&toDate=' + toDate;
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }

    getAyaraActualsARMReportFile(arrgLevel: any, fromDate: any, toDate: any, exportCols: any) {

        if (fromDate == undefined) {
            fromDate = '';
        }
        if (toDate == undefined) {
            toDate = '';
        }
        if (arrgLevel == undefined) {
            arrgLevel = '';
        }
        
        let serviceUrl = appSettings.apiUrl + '/reports/exportActualsArmReport?arrgLevel=' + arrgLevel + '&fromDate=' + fromDate + '&toDate=' + toDate;

        if (exportCols != undefined && exportCols != "") {
            serviceUrl = serviceUrl + '&exportCols=' + exportCols;
        }
        return serviceUrl;
    }

    getAyaraActualsARMChart(arrgLevel: any, fromDate: any, toDate: any) {

        if (arrgLevel == undefined) {
            arrgLevel = '';
        }
        if (fromDate == undefined) {
            fromDate = '';
        }
        if (toDate == undefined) {
            toDate = '';
        }
    

        let serviceUrl = appSettings.apiUrl + '/reports/generateActualsARMChart?arrgLevel=' + arrgLevel + '&fromDate=' + fromDate + '&toDate=' + toDate;
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }
}
