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
export class RmanEntityParametersService {

    constructor(private http: HttpClient) { }

    getAllRmanEntityParameters(paginationOptions: any, rmanEntityParametersSearchObject: any): Promise<any[]> {
        let serviceUrl = appSettings.apiUrl + '/rmanEntityParametersSearch?';

        let searchString = '';

        if (rmanEntityParametersSearchObject.entityParameterId != undefined && rmanEntityParametersSearchObject.entityParameterId != "") {
            searchString = searchString + 'entityParameterId:' + rmanEntityParametersSearchObject.entityParameterId + ',';
        }

        if (rmanEntityParametersSearchObject.entityId != undefined && rmanEntityParametersSearchObject.entityId != "") {
            searchString = searchString + 'entityId:' + rmanEntityParametersSearchObject.entityId + ',';
        }

        if (rmanEntityParametersSearchObject.parameterName != undefined && rmanEntityParametersSearchObject.parameterName != "") {
            searchString = searchString + 'parameterName:' + rmanEntityParametersSearchObject.parameterName + ',';
        }

        if (rmanEntityParametersSearchObject.description != undefined && rmanEntityParametersSearchObject.description != "") {
            searchString = searchString + 'description:' + rmanEntityParametersSearchObject.description + ',';
        }

        if (rmanEntityParametersSearchObject.columnName != undefined && rmanEntityParametersSearchObject.columnName != "") {
            searchString = searchString + 'columnName:' + rmanEntityParametersSearchObject.columnName + ',';
        }

        if (rmanEntityParametersSearchObject.columnType != undefined && rmanEntityParametersSearchObject.columnType != "") {
            searchString = searchString + 'columnType:' + rmanEntityParametersSearchObject.columnType + ',';
        }

        if (rmanEntityParametersSearchObject.columnSize != undefined && rmanEntityParametersSearchObject.columnSize != "") {
            searchString = searchString + 'columnSize:' + rmanEntityParametersSearchObject.columnSize + ',';
        }

        if (rmanEntityParametersSearchObject.columnSequence != undefined && rmanEntityParametersSearchObject.columnSequence != "") {
            searchString = searchString + 'columnSequence:' + rmanEntityParametersSearchObject.columnSequence + ',';
        }

        if (rmanEntityParametersSearchObject.attribute1 != undefined && rmanEntityParametersSearchObject.attribute1 != "") {
            searchString = searchString + 'attribute1:' + rmanEntityParametersSearchObject.attribute1 + ',';
        }

        if (rmanEntityParametersSearchObject.attribute2 != undefined && rmanEntityParametersSearchObject.attribute2 != "") {
            searchString = searchString + 'attribute2:' + rmanEntityParametersSearchObject.attribute2 + ',';
        }

        if (rmanEntityParametersSearchObject.attribute3 != undefined && rmanEntityParametersSearchObject.attribute3 != "") {
            searchString = searchString + 'attribute3:' + rmanEntityParametersSearchObject.attribute3 + ',';
        }

        if (rmanEntityParametersSearchObject.attribute4 != undefined && rmanEntityParametersSearchObject.attribute4 != "") {
            searchString = searchString + 'attribute4:' + rmanEntityParametersSearchObject.attribute4 + ',';
        }

        if (rmanEntityParametersSearchObject.attribute5 != undefined && rmanEntityParametersSearchObject.attribute5 != "") {
            searchString = searchString + 'attribute5:' + rmanEntityParametersSearchObject.attribute5 + ',';
        }

        if (rmanEntityParametersSearchObject.attribute6 != undefined && rmanEntityParametersSearchObject.attribute6 != "") {
            searchString = searchString + 'attribute6:' + rmanEntityParametersSearchObject.attribute6 + ',';
        }

        if (rmanEntityParametersSearchObject.attribute7 != undefined && rmanEntityParametersSearchObject.attribute7 != "") {
            searchString = searchString + 'attribute7:' + rmanEntityParametersSearchObject.attribute7 + ',';
        }

        if (rmanEntityParametersSearchObject.attribute8 != undefined && rmanEntityParametersSearchObject.attribute8 != "") {
            searchString = searchString + 'attribute8:' + rmanEntityParametersSearchObject.attribute8 + ',';
        }

        if (rmanEntityParametersSearchObject.attribute9 != undefined && rmanEntityParametersSearchObject.attribute9 != "") {
            searchString = searchString + 'attribute9:' + rmanEntityParametersSearchObject.attribute9 + ',';
        }

        if (rmanEntityParametersSearchObject.attribute10 != undefined && rmanEntityParametersSearchObject.attribute10 != "") {
            searchString = searchString + 'attribute10:' + rmanEntityParametersSearchObject.attribute10 + ',';
        }

        if (rmanEntityParametersSearchObject.attribute11 != undefined && rmanEntityParametersSearchObject.attribute11 != "") {
            searchString = searchString + 'attribute11:' + rmanEntityParametersSearchObject.attribute11 + ',';
        }

        if (rmanEntityParametersSearchObject.attribute12 != undefined && rmanEntityParametersSearchObject.attribute12 != "") {
            searchString = searchString + 'attribute12:' + rmanEntityParametersSearchObject.attribute12 + ',';
        }

        if (rmanEntityParametersSearchObject.attribute13 != undefined && rmanEntityParametersSearchObject.attribute13 != "") {
            searchString = searchString + 'attribute13:' + rmanEntityParametersSearchObject.attribute13 + ',';
        }

        if (rmanEntityParametersSearchObject.attribute14 != undefined && rmanEntityParametersSearchObject.attribute14 != "") {
            searchString = searchString + 'attribute14:' + rmanEntityParametersSearchObject.attribute14 + ',';
        }

        if (rmanEntityParametersSearchObject.attribute15 != undefined && rmanEntityParametersSearchObject.attribute15 != "") {
            searchString = searchString + 'attribute15:' + rmanEntityParametersSearchObject.attribute15 + ',';
        }

        if (rmanEntityParametersSearchObject.attribute16 != undefined && rmanEntityParametersSearchObject.attribute16 != "") {
            searchString = searchString + 'attribute16:' + rmanEntityParametersSearchObject.attribute16 + ',';
        }

        if (rmanEntityParametersSearchObject.attribute17 != undefined && rmanEntityParametersSearchObject.attribute17 != "") {
            searchString = searchString + 'attribute17:' + rmanEntityParametersSearchObject.attribute17 + ',';
        }

        if (rmanEntityParametersSearchObject.attribute18 != undefined && rmanEntityParametersSearchObject.attribute18 != "") {
            searchString = searchString + 'attribute18:' + rmanEntityParametersSearchObject.attribute18 + ',';
        }

        if (rmanEntityParametersSearchObject.attribute19 != undefined && rmanEntityParametersSearchObject.attribute19 != "") {
            searchString = searchString + 'attribute19:' + rmanEntityParametersSearchObject.attribute19 + ',';
        }

        if (rmanEntityParametersSearchObject.attribute20 != undefined && rmanEntityParametersSearchObject.attribute20 != "") {
            searchString = searchString + 'attribute20:' + rmanEntityParametersSearchObject.attribute20 + ',';
        }

        if (rmanEntityParametersSearchObject.attribute21 != undefined && rmanEntityParametersSearchObject.attribute21 != "") {
            searchString = searchString + 'attribute21:' + rmanEntityParametersSearchObject.attribute21 + ',';
        }

        if (rmanEntityParametersSearchObject.attribute22 != undefined && rmanEntityParametersSearchObject.attribute22 != "") {
            searchString = searchString + 'attribute22:' + rmanEntityParametersSearchObject.attribute22 + ',';
        }

        if (rmanEntityParametersSearchObject.attribute23 != undefined && rmanEntityParametersSearchObject.attribute23 != "") {
            searchString = searchString + 'attribute23:' + rmanEntityParametersSearchObject.attribute23 + ',';
        }

        if (rmanEntityParametersSearchObject.attribute24 != undefined && rmanEntityParametersSearchObject.attribute24 != "") {
            searchString = searchString + 'attribute24:' + rmanEntityParametersSearchObject.attribute24 + ',';
        }

        if (rmanEntityParametersSearchObject.attribute25 != undefined && rmanEntityParametersSearchObject.attribute25 != "") {
            searchString = searchString + 'attribute25:' + rmanEntityParametersSearchObject.attribute25 + ',';
        }

        if (rmanEntityParametersSearchObject.attribute26 != undefined && rmanEntityParametersSearchObject.attribute26 != "") {
            searchString = searchString + 'attribute26:' + rmanEntityParametersSearchObject.attribute26 + ',';
        }

        if (rmanEntityParametersSearchObject.attribute27 != undefined && rmanEntityParametersSearchObject.attribute27 != "") {
            searchString = searchString + 'attribute27:' + rmanEntityParametersSearchObject.attribute27 + ',';
        }

        if (rmanEntityParametersSearchObject.attribute28 != undefined && rmanEntityParametersSearchObject.attribute28 != "") {
            searchString = searchString + 'attribute28:' + rmanEntityParametersSearchObject.attribute28 + ',';
        }

        if (rmanEntityParametersSearchObject.attribute29 != undefined && rmanEntityParametersSearchObject.attribute29 != "") {
            searchString = searchString + 'attribute29:' + rmanEntityParametersSearchObject.attribute29 + ',';
        }

        if (rmanEntityParametersSearchObject.attribute30 != undefined && rmanEntityParametersSearchObject.attribute30 != "") {
            searchString = searchString + 'attribute30:' + rmanEntityParametersSearchObject.attribute30 + ',';
        }

        if (rmanEntityParametersSearchObject.creationDate != undefined && rmanEntityParametersSearchObject.creationDate != "") {
            searchString = searchString + 'creationDate:' + rmanEntityParametersSearchObject.creationDate + ',';
        }

        if (rmanEntityParametersSearchObject.createdBy != undefined && rmanEntityParametersSearchObject.createdBy != "") {
            searchString = searchString + 'createdBy:' + rmanEntityParametersSearchObject.createdBy + ',';
        }

        if (rmanEntityParametersSearchObject.lastUpdateDate != undefined && rmanEntityParametersSearchObject.lastUpdateDate != "") {
            searchString = searchString + 'lastUpdateDate:' + rmanEntityParametersSearchObject.lastUpdateDate + ',';
        }

        if (rmanEntityParametersSearchObject.lastUpdatedBy != undefined && rmanEntityParametersSearchObject.lastUpdatedBy != "") {
            searchString = searchString + 'lastUpdatedBy:' + rmanEntityParametersSearchObject.lastUpdatedBy + ',';
        }

        if (rmanEntityParametersSearchObject.enabledFlag != undefined && rmanEntityParametersSearchObject.enabledFlag != "") {
            searchString = searchString + 'enabledFlag:' + rmanEntityParametersSearchObject.enabledFlag;
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

    saveRmanEntityParameters(rmanEntityParameters: any): Promise<any[]> {
        let body = JSON.stringify(rmanEntityParameters);
        return this.http.post<any[]>(appSettings.apiUrl + '/RMAN_ENTITY_PARAMETERS', body, httpOptions).toPromise().then(data => {
            return data;
        });
    }

    updateRmanEntityParameters(rmanEntityParameters: any): Promise<any[]> {

        delete rmanEntityParameters._links;
        delete rmanEntityParameters.interests;
        let body = JSON.stringify(rmanEntityParameters);
        return this.http.put<any[]>(appSettings.apiUrl + '/RMAN_ENTITY_PARAMETERS/' + rmanEntityParameters.entityParameterId, body, httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanEntityParameters(rmanEntityParameters: any): Promise<any[]> {
        let deleteUrl = appSettings.apiUrl + '/RMAN_ENTITY_PARAMETERS/' + rmanEntityParameters.entityParameterId;
        return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
            return data;
        });
    }

}
