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
export class RmanContReleaseEventsVService {

    constructor(private http: HttpClient) { }

    getServiceUrl(paginationOptions: any, rmanContReleaseEventsVSearchObject: any, exportFlag: any) {

        let serviceUrl = appSettings.apiUrl + '/rmanContReleaseEventsVExport?';

        if (exportFlag == 0) {
            serviceUrl = appSettings.apiUrl + '/rmanContReleaseEventsVSearch?';
        }


        let searchString = '';

        if (rmanContReleaseEventsVSearchObject.sno != undefined && rmanContReleaseEventsVSearchObject.sno != "") {
            searchString = searchString + 'sno:' + rmanContReleaseEventsVSearchObject.sno + ',';
        }

        if (rmanContReleaseEventsVSearchObject.dealLineId != undefined && rmanContReleaseEventsVSearchObject.dealLineId != "") {
            searchString = searchString + 'dealLineId:' + rmanContReleaseEventsVSearchObject.dealLineId + ',';
        }

        if (rmanContReleaseEventsVSearchObject.dealArrangementId != undefined && rmanContReleaseEventsVSearchObject.dealArrangementId != "") {
            searchString = searchString + 'dealArrangementId:' + rmanContReleaseEventsVSearchObject.dealArrangementId + ',';
        }

        if (rmanContReleaseEventsVSearchObject.dealArrangementNumber != undefined && rmanContReleaseEventsVSearchObject.dealArrangementNumber != "") {
            searchString = searchString + 'dealArrangementNumber:' + rmanContReleaseEventsVSearchObject.dealArrangementNumber + ',';
        }

        if (rmanContReleaseEventsVSearchObject.dealArrangementName != undefined && rmanContReleaseEventsVSearchObject.dealArrangementName != "") {
            searchString = searchString + 'dealArrangementName:' + rmanContReleaseEventsVSearchObject.dealArrangementName + ',';
        }

        if (rmanContReleaseEventsVSearchObject.lineNum != undefined && rmanContReleaseEventsVSearchObject.lineNum != "") {
            searchString = searchString + 'lineNum:' + rmanContReleaseEventsVSearchObject.lineNum + ',';
        }

        if (rmanContReleaseEventsVSearchObject.dealNumber != undefined && rmanContReleaseEventsVSearchObject.dealNumber != "") {
            searchString = searchString + 'dealNumber:' + rmanContReleaseEventsVSearchObject.dealNumber + ',';
        }

        if (rmanContReleaseEventsVSearchObject.dealLineNumber != undefined && rmanContReleaseEventsVSearchObject.dealLineNumber != "") {
            searchString = searchString + 'dealLineNumber:' + rmanContReleaseEventsVSearchObject.dealLineNumber + ',';
        }

        if (rmanContReleaseEventsVSearchObject.so != undefined && rmanContReleaseEventsVSearchObject.so != "") {
            searchString = searchString + 'so:' + rmanContReleaseEventsVSearchObject.so + ',';
        }

        if (rmanContReleaseEventsVSearchObject.sourceLineId != undefined && rmanContReleaseEventsVSearchObject.sourceLineId != "") {
            searchString = searchString + 'sourceLineId:' + rmanContReleaseEventsVSearchObject.sourceLineId + ',';
        }

        if (rmanContReleaseEventsVSearchObject.sourceLineNumber != undefined && rmanContReleaseEventsVSearchObject.sourceLineNumber != "") {
            searchString = searchString + 'sourceLineNumber:' + rmanContReleaseEventsVSearchObject.sourceLineNumber + ',';
        }

        if (rmanContReleaseEventsVSearchObject.bookedAmount != undefined && rmanContReleaseEventsVSearchObject.bookedAmount != "") {
            searchString = searchString + 'bookedAmount:' + rmanContReleaseEventsVSearchObject.bookedAmount + ',';
        }

        if (rmanContReleaseEventsVSearchObject.deliveredAmount != undefined && rmanContReleaseEventsVSearchObject.deliveredAmount != "") {
            searchString = searchString + 'deliveredAmount:' + rmanContReleaseEventsVSearchObject.deliveredAmount + ',';
        }

        if (rmanContReleaseEventsVSearchObject.contingencyName != undefined && rmanContReleaseEventsVSearchObject.contingencyName != "") {
            searchString = searchString + 'contingencyName:' + rmanContReleaseEventsVSearchObject.contingencyName + ',';
        }

        if (rmanContReleaseEventsVSearchObject.templateName != undefined && rmanContReleaseEventsVSearchObject.templateName != "") {
            searchString = searchString + 'templateName:' + rmanContReleaseEventsVSearchObject.templateName + ',';
        }

        if (rmanContReleaseEventsVSearchObject.ranking != undefined && rmanContReleaseEventsVSearchObject.ranking != "") {
            searchString = searchString + 'ranking:' + rmanContReleaseEventsVSearchObject.ranking + ',';
        }

        if (rmanContReleaseEventsVSearchObject.applyType != undefined && rmanContReleaseEventsVSearchObject.applyType != "") {
            searchString = searchString + 'applyType:' + rmanContReleaseEventsVSearchObject.applyType + ',';
        }

        if (rmanContReleaseEventsVSearchObject.revenue != undefined && rmanContReleaseEventsVSearchObject.revenue != "") {
            searchString = searchString + 'revenue:' + rmanContReleaseEventsVSearchObject.revenue + ',';
        }

        if (rmanContReleaseEventsVSearchObject.deferredAmount != undefined && rmanContReleaseEventsVSearchObject.deferredAmount != "") {
            searchString = searchString + 'deferredAmount:' + rmanContReleaseEventsVSearchObject.deferredAmount + ',';
        }

        if (rmanContReleaseEventsVSearchObject.deferredReleaseAmount != undefined && rmanContReleaseEventsVSearchObject.deferredReleaseAmount != "") {
            searchString = searchString + 'deferredReleaseAmount:' + rmanContReleaseEventsVSearchObject.deferredReleaseAmount + ',';
        }

        if (rmanContReleaseEventsVSearchObject.undeferredAmount != undefined && rmanContReleaseEventsVSearchObject.undeferredAmount != "") {
            searchString = searchString + 'undeferredAmount:' + rmanContReleaseEventsVSearchObject.undeferredAmount;
        }



        if (searchString == '') {
            serviceUrl = serviceUrl + 'search=%25';
        }
        else {
            serviceUrl = serviceUrl + 'search=' + searchString;
        }

        if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != "" && !isNaN(paginationOptions.pageNumber)) {
            serviceUrl = serviceUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;
        }

        return serviceUrl;
    }

    getAllRmanContReleaseEventsV(paginationOptions: any, rmanContReleaseEventsVSearchObject: any): Promise<any[]> {
        let serviceUrl = this.getServiceUrl(paginationOptions, rmanContReleaseEventsVSearchObject, 0);
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }

    saveRmanContReleaseEventsV(rmanContReleaseEventsV: any) {
        let body = JSON.stringify(rmanContReleaseEventsV);

        return this.http.post(appSettings.apiUrl + '/RMAN_CONT_RELEASE_EVENTS_V', body, httpOptions).toPromise().then(data => {
            return data;
        });
    }

    updateRmanContReleaseEventsV(rmanContReleaseEventsV: any) {

        delete rmanContReleaseEventsV._links;
        delete rmanContReleaseEventsV.interests;
        let body = JSON.stringify(rmanContReleaseEventsV);

        return this.http.put(appSettings.apiUrl + '/RMAN_CONT_RELEASE_EVENTS_V/' + rmanContReleaseEventsV.sno, body, httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanContReleaseEventsV(rmanContReleaseEventsV: any) {
        let deleteUrl = appSettings.apiUrl + '/RMAN_CONT_RELEASE_EVENTS_V/' + rmanContReleaseEventsV.sno;

        return this.http.delete(deleteUrl, httpOptions).toPromise().then(data => {
            return data;
        });
    }

}
