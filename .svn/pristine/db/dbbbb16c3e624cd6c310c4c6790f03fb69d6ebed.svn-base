import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
declare var require: any;
const appSettings = require('../appsettings');


@Injectable()
export class AyaraForecastActualRepService {

    constructor(private http: HttpClient) { }

    getAyaraForecastActualRep(periodType: any) {

        if (periodType == undefined) {
            periodType = '';
        }
        let serviceUrl = appSettings.apiUrl + '/revmantra/ayaraForecastActuals/?periodType=' + periodType;
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }

    exportAyaraForecastActualRepFile(periodType: any, exportCols: any) {

        if (periodType == undefined) {
            periodType = '';
        }
        let serviceUrl = appSettings.apiUrl + '/exportAyaraForecastActuals?periodType=' + periodType;

        if (exportCols != undefined && exportCols != "") {
            serviceUrl = serviceUrl + '&exportCols=' + exportCols;
        }
        return serviceUrl;
    }
}
