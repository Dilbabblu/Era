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
export class RmanLookupTypesService {

    constructor(private http: HttpClient) { }

    getAllRmanLookupTypes(paginationOptions: any, rmanLookupTypesSearchObject: any): Promise<any[]> {

        let serviceUrl = appSettings.apiUrl + '/rmanLookupTypesSearch?';

        let searchString = '';

        if (rmanLookupTypesSearchObject.lookupTypeName != undefined && rmanLookupTypesSearchObject.lookupTypeName != "") {
            searchString = searchString + 'lookupTypeName:' + rmanLookupTypesSearchObject.lookupTypeName + ',';
        }

        if (rmanLookupTypesSearchObject.meaning != undefined && rmanLookupTypesSearchObject.meaning != "") {
            searchString = searchString + 'meaning:' + rmanLookupTypesSearchObject.meaning + ',';
        }

        if (rmanLookupTypesSearchObject.description != undefined && rmanLookupTypesSearchObject.description != "") {
            searchString = searchString + 'description:' + rmanLookupTypesSearchObject.description + ',';
        }

        if (rmanLookupTypesSearchObject.enabledFlag != undefined && rmanLookupTypesSearchObject.enabledFlag != "") {
            searchString = searchString + 'enabledFlag:' + rmanLookupTypesSearchObject.enabledFlag + ',';
        }

        if (rmanLookupTypesSearchObject.startDateActive != undefined && rmanLookupTypesSearchObject.startDateActive != "") {
            searchString = searchString + 'startDateActive:' + rmanLookupTypesSearchObject.startDateActive + ',';
        }

        if (rmanLookupTypesSearchObject.endDateActive != undefined && rmanLookupTypesSearchObject.endDateActive != "") {
            searchString = searchString + 'endDateActive:' + rmanLookupTypesSearchObject.endDateActive + ',';
        }

        if (rmanLookupTypesSearchObject.attribute1 != undefined && rmanLookupTypesSearchObject.attribute1 != "") {
            searchString = searchString + 'attribute1:' + rmanLookupTypesSearchObject.attribute1 + ',';
        }

        if (rmanLookupTypesSearchObject.attribute2 != undefined && rmanLookupTypesSearchObject.attribute2 != "") {
            searchString = searchString + 'attribute2:' + rmanLookupTypesSearchObject.attribute2 + ',';
        }

        if (rmanLookupTypesSearchObject.attribute3 != undefined && rmanLookupTypesSearchObject.attribute3 != "") {
            searchString = searchString + 'attribute3:' + rmanLookupTypesSearchObject.attribute3 + ',';
        }

        if (rmanLookupTypesSearchObject.attribute4 != undefined && rmanLookupTypesSearchObject.attribute4 != "") {
            searchString = searchString + 'attribute4:' + rmanLookupTypesSearchObject.attribute4 + ',';
        }

        if (rmanLookupTypesSearchObject.attribute5 != undefined && rmanLookupTypesSearchObject.attribute5 != "") {
            searchString = searchString + 'attribute5:' + rmanLookupTypesSearchObject.attribute5 + ',';
        }

        if (rmanLookupTypesSearchObject.creationDate != undefined && rmanLookupTypesSearchObject.creationDate != "") {
            searchString = searchString + 'creationDate:' + rmanLookupTypesSearchObject.creationDate + ',';
        }

        if (rmanLookupTypesSearchObject.createdBy != undefined && rmanLookupTypesSearchObject.createdBy != "") {
            searchString = searchString + 'createdBy:' + rmanLookupTypesSearchObject.createdBy + ',';
        }

        if (rmanLookupTypesSearchObject.lastUpdateDate != undefined && rmanLookupTypesSearchObject.lastUpdateDate != "") {
            searchString = searchString + 'lastUpdateDate:' + rmanLookupTypesSearchObject.lastUpdateDate + ',';
        }

        if (rmanLookupTypesSearchObject.lastUpdatedBy != undefined && rmanLookupTypesSearchObject.lastUpdatedBy != "") {
            searchString = searchString + 'lastUpdatedBy:' + rmanLookupTypesSearchObject.lastUpdatedBy + ',';
        }

        if (rmanLookupTypesSearchObject.seededFlag != undefined && rmanLookupTypesSearchObject.seededFlag != "") {
            searchString = searchString + 'seededFlag:' + rmanLookupTypesSearchObject.seededFlag;
        }



        if (searchString == '') {
            serviceUrl = serviceUrl + 'search=%25';
        }
        else {
            serviceUrl = serviceUrl + 'search=' + searchString;
        }

        if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != "" && !isNaN(paginationOptions.pageNumber) && paginationOptions.pageNumber != 0) {
            serviceUrl = serviceUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;
        }

        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }


    saveRmanLookupTypes(rmanLookupTypes: any): Promise<any[]> {
        let body = JSON.stringify(rmanLookupTypes);
        return this.http.post<any[]>(appSettings.apiUrl + '/RMAN_LOOKUP_TYPES', body, httpOptions).toPromise().then(data => {
            return data;
        });
    }

    updateRmanLookupTypes(rmanLookupTypes: any): Promise<any[]> {

        delete rmanLookupTypes._links;
        delete rmanLookupTypes.interests;
        let body = JSON.stringify(rmanLookupTypes);
        return this.http.put<any[]>(appSettings.apiUrl + '/RMAN_LOOKUP_TYPES/' + rmanLookupTypes.lookupTypeName, body, httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanLookupTypes(rmanLookupTypes: any): Promise<any[]> {
        let deleteUrl = appSettings.apiUrl + '/RMAN_LOOKUP_TYPES/' + rmanLookupTypes.lookupTypeName;
        return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
            return data;
        });
    }

}
