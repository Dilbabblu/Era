import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
declare var require: any;
const appSettings = require('../appsettings');


@Injectable()
export class RmanForecastActualsAnalysisService {

    constructor(private http: HttpClient) { }

    getAllRmanForecastActualsAnalysis(paginationOptions: any, rmanForecastToActuals: any): Promise<any[]> {

        let serviceUrl = appSettings.apiUrl + '/rmanFcstActualDetailsVSearch?';

        let searchString = '';


        if (rmanForecastToActuals.arrangementId != undefined && rmanForecastToActuals.arrangementId != "") {
            searchString = searchString + 'arrangementId:' + rmanForecastToActuals.arrangementId + ',';
        }

        if (searchString == '') {
            serviceUrl = serviceUrl + 'search=%25';
        }
        else {
            serviceUrl = serviceUrl + 'search=' + searchString;
        }

        if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != "" && !isNaN(paginationOptions.pageNumber) && paginationOptions.pageNumber != 0) {
            serviceUrl = serviceUrl + '&size=' + paginationOptions.pageSize;
        }

        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }

}
