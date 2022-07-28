import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
declare var require: any;
const appSettings = require('../appsettings');


@Injectable()
export class AyaraActualsVsActiveReportService {

    constructor(private http: HttpClient) { }


    getAyaraActualsActiveARMReport(arrgLevel: any,docType: any,quoteStatus: any, fromDate: any, toDate: any) {

        if (fromDate == undefined) {
            fromDate = '';
        }
        if (toDate == undefined) {
            toDate = '';
        }
        if (quoteStatus == undefined) {
            quoteStatus = '';
        }
        if (arrgLevel == undefined) {
            arrgLevel = '';
        }
        if (docType == undefined) {
            docType = '';
        }

        let serviceUrl = appSettings.apiUrl + '/reports/ayaraActiveAndActuals?arrgLevel=' + arrgLevel+'&docType=' + docType + '&quoteStatus=' + quoteStatus + '&fromDate=' + fromDate + '&toDate=' + toDate;
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }

    getAyaraActualsActiveARMReportFile(arrgLevel: any, docType:any, quoteStatus: any, fromDate: any, toDate: any, exportCols: any) {

        if (fromDate == undefined) {
            fromDate = '';
        }
        if (toDate == undefined) {
            toDate = '';
        }
        if (quoteStatus == undefined) {
            quoteStatus = '';
        }
        if (arrgLevel == undefined) {
            arrgLevel = '';
        }
        if (docType == undefined) {
            docType = '';
        }

        
        let serviceUrl = appSettings.apiUrl + '/reports/exportActualsVsActiveArmReport?arrgLevel=' + arrgLevel +'&docType=' + docType +'&quoteStatus=' + quoteStatus + '&fromDate=' + fromDate + '&toDate=' + toDate;

        if (exportCols != undefined && exportCols != "") {
            serviceUrl = serviceUrl + '&exportCols=' + exportCols;
        }
        return serviceUrl;
    }

    getAyaraActualsActiveARMChart(arrgLevel: any, docType:any,quoteStatus:any, fromDate: any, toDate: any) {

        if (arrgLevel == undefined) {
            arrgLevel = '';
        }

        if (fromDate == undefined) {
            fromDate = '';
        }
        if (toDate == undefined) {
            toDate = '';
        }

        if (docType == undefined) {
            docType = '';
        }

        if (quoteStatus == undefined) {
            quoteStatus = '';
        }

        let serviceUrl = appSettings.apiUrl + '/reports/generateActualVsActiveChart?arrgLevel=' + arrgLevel + '&docType=' + docType +'&quoteStatus=' + quoteStatus +'&fromDate=' + fromDate + '&toDate=' + toDate;
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }

}
