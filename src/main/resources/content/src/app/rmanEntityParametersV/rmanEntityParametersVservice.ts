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
export class RmanEntityParametersVService {

    constructor(private http: HttpClient) { }

    getAllRmanEntityParametersV(paginationOptions: any, rmanEntityParametersVSearchObject: any, fetchAll?: any): Promise<any[]> {
        let serviceUrl = appSettings.apiUrl + '/rmanEntityParametersVSearch?';

        let searchString = '';

        if (rmanEntityParametersVSearchObject.entityId != undefined && rmanEntityParametersVSearchObject.entityId != "") {
            searchString = searchString + 'entityId:' + rmanEntityParametersVSearchObject.entityId + ',';
        }

        if (rmanEntityParametersVSearchObject.entityName != undefined && rmanEntityParametersVSearchObject.entityName != "") {
            searchString = searchString + 'entityName:' + rmanEntityParametersVSearchObject.entityName + ',';
        }

        if (rmanEntityParametersVSearchObject.entityCategory != undefined && rmanEntityParametersVSearchObject.entityCategory != "") {
            searchString = searchString + 'entityCategory:' + rmanEntityParametersVSearchObject.entityCategory + ',';
        }

        if (rmanEntityParametersVSearchObject.entityDescription != undefined && rmanEntityParametersVSearchObject.entityDescription != "") {
            searchString = searchString + 'entityDescription:' + rmanEntityParametersVSearchObject.entityDescription + ',';
        }

        if (rmanEntityParametersVSearchObject.tableName != undefined && rmanEntityParametersVSearchObject.tableName != "") {
            searchString = searchString + 'tableName:' + rmanEntityParametersVSearchObject.tableName + ',';
        }

        if (rmanEntityParametersVSearchObject.startDateActive != undefined && rmanEntityParametersVSearchObject.startDateActive != "") {
            searchString = searchString + 'startDateActive:' + rmanEntityParametersVSearchObject.startDateActive + ',';
        }

        if (rmanEntityParametersVSearchObject.endDateActive != undefined && rmanEntityParametersVSearchObject.endDateActive != "") {
            searchString = searchString + 'endDateActive:' + rmanEntityParametersVSearchObject.endDateActive + ',';
        }

        if (rmanEntityParametersVSearchObject.entityParameterId != undefined && rmanEntityParametersVSearchObject.entityParameterId != "") {
            searchString = searchString + 'entityParameterId:' + rmanEntityParametersVSearchObject.entityParameterId + ',';
        }

        if (rmanEntityParametersVSearchObject.parameterName != undefined && rmanEntityParametersVSearchObject.parameterName != "") {
            searchString = searchString + 'parameterName:' + rmanEntityParametersVSearchObject.parameterName + ',';
        }

        if (rmanEntityParametersVSearchObject.parameterDescription != undefined && rmanEntityParametersVSearchObject.parameterDescription != "") {
            searchString = searchString + 'parameterDescription:' + rmanEntityParametersVSearchObject.parameterDescription + ',';
        }

        if (rmanEntityParametersVSearchObject.columnName != undefined && rmanEntityParametersVSearchObject.columnName != "") {
            searchString = searchString + 'columnName:' + rmanEntityParametersVSearchObject.columnName + ',';
        }

        if (rmanEntityParametersVSearchObject.columnType != undefined && rmanEntityParametersVSearchObject.columnType != "") {
            searchString = searchString + 'columnType:' + rmanEntityParametersVSearchObject.columnType + ',';
        }

        if (rmanEntityParametersVSearchObject.columnSize != undefined && rmanEntityParametersVSearchObject.columnSize != "") {
            searchString = searchString + 'columnSize:' + rmanEntityParametersVSearchObject.columnSize + ',';
        }

        if (rmanEntityParametersVSearchObject.columnSequence != undefined && rmanEntityParametersVSearchObject.columnSequence != "") {
            searchString = searchString + 'columnSequence:' + rmanEntityParametersVSearchObject.columnSequence + ',';
        }

        if (rmanEntityParametersVSearchObject.enabledFlag != undefined && rmanEntityParametersVSearchObject.enabledFlag != "") {
            searchString = searchString + 'enabledFlag:' + rmanEntityParametersVSearchObject.enabledFlag;
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


    saveRmanEntityParametersV(rmanEntityParametersV: any): Promise<any[]> {
        let body = JSON.stringify(rmanEntityParametersV);
        return this.http.post(appSettings.apiUrl + '/RMAN_ENTITY_PARAMETERS_V', body, httpOptions).toPromise().then((data: any) => {
            return data;
        });
    }

    updateRmanEntityParametersV(rmanEntityParametersV: any): Promise<any[]> {

        delete rmanEntityParametersV._links;
        delete rmanEntityParametersV.interests;
        let body = JSON.stringify(rmanEntityParametersV);
        return this.http.put<any[]>(appSettings.apiUrl + '/RMAN_ENTITY_PARAMETERS_V/' + rmanEntityParametersV.entityParameterId, body, httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanEntityParametersV(rmanEntityParametersV: any): Promise<any[]> {
        let deleteUrl = appSettings.apiUrl + '/RMAN_ENTITY_PARAMETERS_V/' + rmanEntityParametersV.entityParameterId;
        return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
            return data;
        });
    }

}
