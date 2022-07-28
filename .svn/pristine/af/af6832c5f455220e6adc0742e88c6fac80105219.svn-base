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
export class RmanLegalEntitiesService {

    constructor(private http: HttpClient) { }

    getAllRmanLegalEntities(paginationOptions: any, rmanLegalEntitiesSearchObject: any, fetchAll?: any): Promise<any[]> {
        let serviceUrl = appSettings.apiUrl + '/rmanLegalEntitiesSearch?';

        let searchString = '';

        if (rmanLegalEntitiesSearchObject.legalEntityId != undefined && rmanLegalEntitiesSearchObject.legalEntityId != "") {
            searchString = searchString + 'legalEntityId:' + rmanLegalEntitiesSearchObject.legalEntityId + ',';
        }

        if (rmanLegalEntitiesSearchObject.name != undefined && rmanLegalEntitiesSearchObject.name != "") {
            searchString = searchString + 'name:' + rmanLegalEntitiesSearchObject.name + ',';
        }

        if (rmanLegalEntitiesSearchObject.functionalCurrency != undefined && rmanLegalEntitiesSearchObject.functionalCurrency != "") {
            searchString = searchString + 'functionalCurrency:' + rmanLegalEntitiesSearchObject.functionalCurrency + ',';
        }

        if (rmanLegalEntitiesSearchObject.reportingCurrency != undefined && rmanLegalEntitiesSearchObject.reportingCurrency != "") {
            searchString = searchString + 'reportingCurrency:' + rmanLegalEntitiesSearchObject.reportingCurrency + ',';
        }

        if (rmanLegalEntitiesSearchObject.calendar != undefined && rmanLegalEntitiesSearchObject.calendar != "") {
            searchString = searchString + 'calendar:' + rmanLegalEntitiesSearchObject.calendar + ',';
        }

        if (rmanLegalEntitiesSearchObject.allocationCurrency != undefined && rmanLegalEntitiesSearchObject.allocationCurrency != "") {
            searchString = searchString + 'allocationCurrency:' + rmanLegalEntitiesSearchObject.allocationCurrency + ',';
        }

        if (rmanLegalEntitiesSearchObject.creationDate != undefined && rmanLegalEntitiesSearchObject.creationDate != "") {
            searchString = searchString + 'creationDate:' + rmanLegalEntitiesSearchObject.creationDate + ',';
        }

        if (rmanLegalEntitiesSearchObject.createdBy != undefined && rmanLegalEntitiesSearchObject.createdBy != "") {
            searchString = searchString + 'createdBy:' + rmanLegalEntitiesSearchObject.createdBy + ',';
        }

        if (rmanLegalEntitiesSearchObject.lastUpdateDate != undefined && rmanLegalEntitiesSearchObject.lastUpdateDate != "") {
            searchString = searchString + 'lastUpdateDate:' + rmanLegalEntitiesSearchObject.lastUpdateDate + ',';
        }

        if (rmanLegalEntitiesSearchObject.lastUpdatedBy != undefined && rmanLegalEntitiesSearchObject.lastUpdatedBy != "") {
            searchString = searchString + 'lastUpdatedBy:' + rmanLegalEntitiesSearchObject.lastUpdatedBy + ',';
        }

        if (rmanLegalEntitiesSearchObject.attribute1 != undefined && rmanLegalEntitiesSearchObject.attribute1 != "") {
            searchString = searchString + 'attribute1:' + rmanLegalEntitiesSearchObject.attribute1 + ',';
        }

        if (rmanLegalEntitiesSearchObject.attribute2 != undefined && rmanLegalEntitiesSearchObject.attribute2 != "") {
            searchString = searchString + 'attribute2:' + rmanLegalEntitiesSearchObject.attribute2 + ',';
        }

        if (rmanLegalEntitiesSearchObject.attribute3 != undefined && rmanLegalEntitiesSearchObject.attribute3 != "") {
            searchString = searchString + 'attribute3:' + rmanLegalEntitiesSearchObject.attribute3 + ',';
        }

        if (rmanLegalEntitiesSearchObject.attribute4 != undefined && rmanLegalEntitiesSearchObject.attribute4 != "") {
            searchString = searchString + 'attribute4:' + rmanLegalEntitiesSearchObject.attribute4 + ',';
        }

        if (rmanLegalEntitiesSearchObject.attribute5 != undefined && rmanLegalEntitiesSearchObject.attribute5 != "") {
            searchString = searchString + 'attribute5:' + rmanLegalEntitiesSearchObject.attribute5 + ',';
        }

        if (rmanLegalEntitiesSearchObject.ledgerName != undefined && rmanLegalEntitiesSearchObject.ledgerName != "") {
            searchString = searchString + 'ledgerName:' + rmanLegalEntitiesSearchObject.ledgerName + ',';
        }

        if (rmanLegalEntitiesSearchObject.enabledFlag != undefined && rmanLegalEntitiesSearchObject.enabledFlag != "") {
            searchString = searchString + 'enabledFlag:' + rmanLegalEntitiesSearchObject.enabledFlag + ',';
        }

        if (rmanLegalEntitiesSearchObject.defferedAccount != undefined && rmanLegalEntitiesSearchObject.defferedAccount != "") {
            searchString = searchString + 'defferedAccount:' + rmanLegalEntitiesSearchObject.defferedAccount + ',';
        }

        if (rmanLegalEntitiesSearchObject.roundingPrecision != undefined && rmanLegalEntitiesSearchObject.roundingPrecision != "") {
            searchString = searchString + 'roundingPrecision:' + rmanLegalEntitiesSearchObject.roundingPrecision + ',';
        }

        if (rmanLegalEntitiesSearchObject.currencyFormat != undefined && rmanLegalEntitiesSearchObject.currencyFormat != "") {
            searchString = searchString + 'currencyFormat:' + rmanLegalEntitiesSearchObject.currencyFormat + ',';
        }

        if (rmanLegalEntitiesSearchObject.locale != undefined && rmanLegalEntitiesSearchObject.locale != "") {
            searchString = searchString + 'locale:' + rmanLegalEntitiesSearchObject.locale + ',';
        }

        if (rmanLegalEntitiesSearchObject.deferredCogs != undefined && rmanLegalEntitiesSearchObject.deferredCogs != "") {
            searchString = searchString + 'deferredCogs:' + rmanLegalEntitiesSearchObject.deferredCogs + ',';
        }

        if (rmanLegalEntitiesSearchObject.currencyCode != undefined && rmanLegalEntitiesSearchObject.currencyCode != "") {
            searchString = searchString + 'currencyCode:' + rmanLegalEntitiesSearchObject.currencyCode + ',';
        }

        if (rmanLegalEntitiesSearchObject.periodType != undefined && rmanLegalEntitiesSearchObject.periodType != "") {
            searchString = searchString + 'periodType:' + rmanLegalEntitiesSearchObject.periodType + ',';
        }

        if (rmanLegalEntitiesSearchObject.defRevAccountId != undefined && rmanLegalEntitiesSearchObject.defRevAccountId != "") {
            searchString = searchString + 'defRevAccountId:' + rmanLegalEntitiesSearchObject.defRevAccountId + ',';
        }

        if (rmanLegalEntitiesSearchObject.defRevCogsId != undefined && rmanLegalEntitiesSearchObject.defRevCogsId != "") {
            searchString = searchString + 'defRevCogsId:' + rmanLegalEntitiesSearchObject.defRevCogsId + ',';
        }

        if (rmanLegalEntitiesSearchObject.revAccountId != undefined && rmanLegalEntitiesSearchObject.revAccountId != "") {
            searchString = searchString + 'revAccountId:' + rmanLegalEntitiesSearchObject.revAccountId + ',';
        }

        if (rmanLegalEntitiesSearchObject.cogsAccountId != undefined && rmanLegalEntitiesSearchObject.cogsAccountId != "") {
            searchString = searchString + 'cogsAccountId:' + rmanLegalEntitiesSearchObject.cogsAccountId + ',';
        }

        if (rmanLegalEntitiesSearchObject.defCogsAccountId != undefined && rmanLegalEntitiesSearchObject.defCogsAccountId != "") {
            searchString = searchString + 'defCogsAccountId:' + rmanLegalEntitiesSearchObject.defCogsAccountId;
        }



        if (searchString == '') {
            serviceUrl = serviceUrl + 'search=%25';
        }
        else {
            serviceUrl = serviceUrl + 'search=' + searchString;
        }

        if (fetchAll == 'Y') {
            serviceUrl = serviceUrl + '&fetchAll=Y';
        }

        if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != "" && !isNaN(paginationOptions.pageNumber) && paginationOptions.pageNumber != 0) {
            serviceUrl = serviceUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;
        }

        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }


    saveRmanLegalEntities(rmanLegalEntities: any): Promise<any[]> {
        let body = JSON.stringify(rmanLegalEntities);
        return this.http.post<any[]>(appSettings.apiUrl + '/RMAN_LEGAL_ENTITIES', body, httpOptions).toPromise().then(data => {
            return data;
        });
    }

    updateRmanLegalEntities(rmanLegalEntities: any): Promise<any[]> {

        delete rmanLegalEntities._links;
        delete rmanLegalEntities.interests;
        let body = JSON.stringify(rmanLegalEntities);
        return this.http.put<any[]>(appSettings.apiUrl + '/RMAN_LEGAL_ENTITIES/' + rmanLegalEntities.legalEntityId, body, httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanLegalEntities(rmanLegalEntities: any): Promise<any[]> {
        let deleteUrl = appSettings.apiUrl + '/RMAN_LEGAL_ENTITIES/' + rmanLegalEntities.legalEntityId;
        return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
            return data;
        });
    }

}
