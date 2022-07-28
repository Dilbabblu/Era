import { DatePipe } from '@angular/common';
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
export class RmanFiscalPeriodsService {

    constructor(private http: HttpClient, public datepipe: DatePipe) { }

    getAllRmanFiscalPeriods(paginationOptions: any, rmanFiscalPeriodsSearchObject: any): Promise<any[]> {
        let serviceUrl = appSettings.apiUrl + '/rmanFiscalPeriodsSearch?';

        let searchString = '';

        if (rmanFiscalPeriodsSearchObject.periodName != undefined && rmanFiscalPeriodsSearchObject.periodName != "") {
            searchString = searchString + 'periodName:' + rmanFiscalPeriodsSearchObject.periodName + ',';
        }

        if (rmanFiscalPeriodsSearchObject.startDate != undefined && rmanFiscalPeriodsSearchObject.startDate != "") {
            searchString = searchString + 'startDate:' + rmanFiscalPeriodsSearchObject.startDate + ',';
        }

        if (rmanFiscalPeriodsSearchObject.endDate != undefined && rmanFiscalPeriodsSearchObject.endDate != "") {
            searchString = searchString + 'endDate:' + rmanFiscalPeriodsSearchObject.endDate + ',';
        }

        if (rmanFiscalPeriodsSearchObject.periodYear != undefined && rmanFiscalPeriodsSearchObject.periodYear != "") {
            searchString = searchString + 'periodYear:' + rmanFiscalPeriodsSearchObject.periodYear + ',';
        }

        if (rmanFiscalPeriodsSearchObject.periodNum != undefined && rmanFiscalPeriodsSearchObject.periodNum != "") {
            searchString = searchString + 'periodNum:' + rmanFiscalPeriodsSearchObject.periodNum + ',';
        }

        if (rmanFiscalPeriodsSearchObject.quarterNum != undefined && rmanFiscalPeriodsSearchObject.quarterNum != "") {
            searchString = searchString + 'quarterNum:' + rmanFiscalPeriodsSearchObject.quarterNum + ',';
        }

        if (rmanFiscalPeriodsSearchObject.enteredPeriodName != undefined && rmanFiscalPeriodsSearchObject.enteredPeriodName != "") {
            searchString = searchString + 'enteredPeriodName:' + rmanFiscalPeriodsSearchObject.enteredPeriodName + ',';
        }

        if (rmanFiscalPeriodsSearchObject.adjustmentPeriodFlag != undefined && rmanFiscalPeriodsSearchObject.adjustmentPeriodFlag != "") {
            searchString = searchString + 'adjustmentPeriodFlag:' + rmanFiscalPeriodsSearchObject.adjustmentPeriodFlag + ',';
        }

        if (rmanFiscalPeriodsSearchObject.yearStartDate != undefined && rmanFiscalPeriodsSearchObject.yearStartDate != "") {
            searchString = searchString + 'yearStartDate:' + rmanFiscalPeriodsSearchObject.yearStartDate + ',';
        }

        if (rmanFiscalPeriodsSearchObject.quarterStartDate != undefined && rmanFiscalPeriodsSearchObject.quarterStartDate != "") {
            searchString = searchString + 'quarterStartDate:' + rmanFiscalPeriodsSearchObject.quarterStartDate + ',';
        }

        if (rmanFiscalPeriodsSearchObject.creationDate != undefined && rmanFiscalPeriodsSearchObject.creationDate != "") {
            searchString = searchString + 'creationDate:' + rmanFiscalPeriodsSearchObject.creationDate + ',';
        }

        if (rmanFiscalPeriodsSearchObject.createdBy != undefined && rmanFiscalPeriodsSearchObject.createdBy != "") {
            searchString = searchString + 'createdBy:' + rmanFiscalPeriodsSearchObject.createdBy + ',';
        }

        if (rmanFiscalPeriodsSearchObject.lastUpdateDate != undefined && rmanFiscalPeriodsSearchObject.lastUpdateDate != "") {
            searchString = searchString + 'lastUpdateDate:' + rmanFiscalPeriodsSearchObject.lastUpdateDate + ',';
        }

        if (rmanFiscalPeriodsSearchObject.lastUpdatedBy != undefined && rmanFiscalPeriodsSearchObject.lastUpdatedBy != "") {
            searchString = searchString + 'lastUpdatedBy:' + rmanFiscalPeriodsSearchObject.lastUpdatedBy + ',';
        }

        if (rmanFiscalPeriodsSearchObject.sourcePeriodId != undefined && rmanFiscalPeriodsSearchObject.sourcePeriodId != "") {
            searchString = searchString + 'sourcePeriodId:' + rmanFiscalPeriodsSearchObject.sourcePeriodId + ',';
        }

        if (rmanFiscalPeriodsSearchObject.rmanPeriodId != undefined && rmanFiscalPeriodsSearchObject.rmanPeriodId != "") {
            searchString = searchString + 'rmanPeriodId:' + rmanFiscalPeriodsSearchObject.rmanPeriodId + ',';
        }

        if (rmanFiscalPeriodsSearchObject.ledgerName != undefined && rmanFiscalPeriodsSearchObject.ledgerName != "") {
            searchString = searchString + 'ledgerName:' + rmanFiscalPeriodsSearchObject.ledgerName + ',';
        }

        if (rmanFiscalPeriodsSearchObject.quarterName != undefined && rmanFiscalPeriodsSearchObject.quarterName != "") {
            searchString = searchString + 'quarterName:' + rmanFiscalPeriodsSearchObject.quarterName + ',';
        }

        if (rmanFiscalPeriodsSearchObject.periodStatus != undefined && rmanFiscalPeriodsSearchObject.periodStatus != "") {
            searchString = searchString + 'periodStatus:' + rmanFiscalPeriodsSearchObject.periodStatus + ',';
        }

        if (rmanFiscalPeriodsSearchObject.openFlag != undefined && rmanFiscalPeriodsSearchObject.openFlag != "") {
            searchString = searchString + 'openFlag:' + rmanFiscalPeriodsSearchObject.openFlag;
        }



        if (searchString == '') {
            serviceUrl = serviceUrl + 'search=%25' + '&sort=startDate,desc';
        }
        else {
            serviceUrl = serviceUrl + 'search=' + searchString + '&sort=startDate,desc';
        }

        if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != "" && !isNaN(paginationOptions.pageNumber)) {
            serviceUrl = serviceUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;
        }

        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }



    saveRmanFiscalPeriods(rmanFiscalPeriods: any): Promise<any[]> {
        let body = JSON.stringify(rmanFiscalPeriods);
        return this.http.post<any[]>(appSettings.apiUrl + '/RMAN_FISCAL_PERIODS', body, httpOptions).toPromise().then(data => {
            return data;
        });
    }

    updateRmanFiscalPeriods(rmanFiscalPeriods: any): Promise<any[]> {

        delete rmanFiscalPeriods._links;
        delete rmanFiscalPeriods.interests;
        let body = JSON.stringify(rmanFiscalPeriods);
        return this.http.put<any[]>(appSettings.apiUrl + '/RMAN_FISCAL_PERIODS/' + rmanFiscalPeriods.rmanPeriodId, body, httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanFiscalPeriods(rmanFiscalPeriods: any): Promise<any[]> {
        let deleteUrl = appSettings.apiUrl + '/RMAN_FISCAL_PERIODS/' + rmanFiscalPeriods.rmanPeriodId;
        return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
            return data;
        });
    }

    updateGlAcctsStatus(period: any): Promise<any[]> {
        let glServiceURL = appSettings.apiUrl + '/updateGlStatus?period=' + period;
        return this.http.get(glServiceURL, { responseType: 'text' }).toPromise().then((data: any) => {
            return data;
        });
    }

    getFinancialYears() {
        let fyServiceUrl = appSettings.apiUrl + '/financialYears';
        return this.http.get(fyServiceUrl).toPromise().then((data: any) => {
            return data;
        });
    }

    getPeriodDimensions() {
        let pdServiceUrl = appSettings.apiUrl + '/periodDimensions';
        return this.http.get(pdServiceUrl).toPromise().then((data: any) => {
            return data;
        });
    }

    validatePeriods(rmanFiscalPeriods: any): Promise<any> {
        let startDate = this.datepipe.transform(rmanFiscalPeriods['startDate'], 'yyyy-MM-dd');
        let endDate = this.datepipe.transform(rmanFiscalPeriods['endDate'], 'yyyy-MM-dd');
        let periodName = rmanFiscalPeriods['periodName'];
        let periodStatus = rmanFiscalPeriods['periodStatus'];

        let body = "periodName=" + periodName + "&" + "periodStatus=" + periodStatus + "&" + "startDate=" + startDate + "&" + "endDate=" + endDate;
        let releaseUrl = appSettings.apiUrl + '/checkPeriodStatus?' + body;
        return this.http.get(releaseUrl, { responseType: 'text' }).toPromise().then((data: any) => {
            return data;
        });
    }

}
