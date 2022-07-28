import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
declare var require: any;
const appSettings = require('../appsettings');


@Injectable()
export class AyaraActiveQuotesARMReportService {

    constructor(private http: HttpClient) { }


    getAyaraActiveQuotesARMReport(arrgLevel: any, quoteStatus: any, fromDate: any, toDate: any) {

        if (fromDate == undefined) {
            fromDate = '';
        }
        if (toDate == undefined) {
            toDate = '';
        }
        if (arrgLevel == undefined) {
            arrgLevel = '';
        }
        if (quoteStatus == undefined) {
            quoteStatus = '';
        }

        let serviceUrl = appSettings.apiUrl + '/reports/activeQuotesArmReport?arrgLevel=' + arrgLevel + '&quoteStatus=' + quoteStatus + '&fromDate=' + fromDate + '&toDate=' + toDate;
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }

    getAyaraActiveQuotesARMReportFile(arrgLevel: any, quoteStatus: any, fromDate: any, toDate: any, exportCols: any) {

        if (fromDate == undefined) {
            fromDate = '';
        }
        if (toDate == undefined) {
            toDate = '';
        }
        if (arrgLevel == undefined) {
            arrgLevel = '';
        }
		if (quoteStatus == undefined) {
            quoteStatus = '';
        }
        
        let serviceUrl = appSettings.apiUrl + '/reports/exportActiveQuotesArmReport?arrgLevel=' + arrgLevel + '&quoteStatus=' + quoteStatus + '&fromDate=' + fromDate + '&toDate=' + toDate;

        if (exportCols != undefined && exportCols != "") {
            serviceUrl = serviceUrl + '&exportCols=' + exportCols;
        }
        return serviceUrl;
    }

    getAyaraActiveQuotesARMChart(quoteStatus: any,arrgLevel: any, fromDate: any, toDate: any) {
        
        if (arrgLevel == undefined) {
            arrgLevel = '';
        }
        if (fromDate == undefined) {
            fromDate = '';
        }
        if (toDate == undefined) {
            toDate = '';
        }
       
        if (quoteStatus == undefined) {
            quoteStatus = '';
        }

        let serviceUrl = appSettings.apiUrl + '/reports/generateActiveQuotesARMChart?quoteStatus=' + quoteStatus +  '&arrgLevel=' + arrgLevel + '&fromDate=' + fromDate + '&toDate=' + toDate;
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }
}
