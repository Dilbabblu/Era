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
export class RmanEntitiesService {

    constructor(private http: HttpClient) { }

    getAllRmanEntities(paginationOptions: any, rmanEntitiesSearchObject: any): Promise<any[]> {

        let serviceUrl = appSettings.apiUrl + '/rmanEntitiesSearch?';

        let searchString = '';

        if (rmanEntitiesSearchObject.entityId != undefined && rmanEntitiesSearchObject.entityId != "") {
            searchString = searchString + 'entityId:' + rmanEntitiesSearchObject.entityId + ',';
        }

        if (rmanEntitiesSearchObject.entityName != undefined && rmanEntitiesSearchObject.entityName != "") {
            searchString = searchString + 'entityName:' + rmanEntitiesSearchObject.entityName + ',';
        }

        if (rmanEntitiesSearchObject.entityCategory != undefined && rmanEntitiesSearchObject.entityCategory != "") {
            searchString = searchString + 'entityCategory:' + rmanEntitiesSearchObject.entityCategory + ',';
        }

        if (rmanEntitiesSearchObject.description != undefined && rmanEntitiesSearchObject.description != "") {
            searchString = searchString + 'description:' + rmanEntitiesSearchObject.description + ',';
        }

        if (rmanEntitiesSearchObject.tableName != undefined && rmanEntitiesSearchObject.tableName != "") {
            searchString = searchString + 'tableName:' + rmanEntitiesSearchObject.tableName + ',';
        }

        if (rmanEntitiesSearchObject.startDateActive != undefined && rmanEntitiesSearchObject.startDateActive != "") {
            searchString = searchString + 'startDateActive:' + rmanEntitiesSearchObject.startDateActive + ',';
        }

        if (rmanEntitiesSearchObject.endDateActive != undefined && rmanEntitiesSearchObject.endDateActive != "") {
            searchString = searchString + 'endDateActive:' + rmanEntitiesSearchObject.endDateActive + ',';
        }

        if (rmanEntitiesSearchObject.attribute1 != undefined && rmanEntitiesSearchObject.attribute1 != "") {
            searchString = searchString + 'attribute1:' + rmanEntitiesSearchObject.attribute1 + ',';
        }

        if (rmanEntitiesSearchObject.attribute2 != undefined && rmanEntitiesSearchObject.attribute2 != "") {
            searchString = searchString + 'attribute2:' + rmanEntitiesSearchObject.attribute2 + ',';
        }

        if (rmanEntitiesSearchObject.attribute3 != undefined && rmanEntitiesSearchObject.attribute3 != "") {
            searchString = searchString + 'attribute3:' + rmanEntitiesSearchObject.attribute3 + ',';
        }

        if (rmanEntitiesSearchObject.attribute4 != undefined && rmanEntitiesSearchObject.attribute4 != "") {
            searchString = searchString + 'attribute4:' + rmanEntitiesSearchObject.attribute4 + ',';
        }

        if (rmanEntitiesSearchObject.attribute5 != undefined && rmanEntitiesSearchObject.attribute5 != "") {
            searchString = searchString + 'attribute5:' + rmanEntitiesSearchObject.attribute5 + ',';
        }

        if (rmanEntitiesSearchObject.attribute6 != undefined && rmanEntitiesSearchObject.attribute6 != "") {
            searchString = searchString + 'attribute6:' + rmanEntitiesSearchObject.attribute6 + ',';
        }

        if (rmanEntitiesSearchObject.attribute7 != undefined && rmanEntitiesSearchObject.attribute7 != "") {
            searchString = searchString + 'attribute7:' + rmanEntitiesSearchObject.attribute7 + ',';
        }

        if (rmanEntitiesSearchObject.attribute8 != undefined && rmanEntitiesSearchObject.attribute8 != "") {
            searchString = searchString + 'attribute8:' + rmanEntitiesSearchObject.attribute8 + ',';
        }

        if (rmanEntitiesSearchObject.attribute9 != undefined && rmanEntitiesSearchObject.attribute9 != "") {
            searchString = searchString + 'attribute9:' + rmanEntitiesSearchObject.attribute9 + ',';
        }

        if (rmanEntitiesSearchObject.attribute10 != undefined && rmanEntitiesSearchObject.attribute10 != "") {
            searchString = searchString + 'attribute10:' + rmanEntitiesSearchObject.attribute10 + ',';
        }

        if (rmanEntitiesSearchObject.attribute11 != undefined && rmanEntitiesSearchObject.attribute11 != "") {
            searchString = searchString + 'attribute11:' + rmanEntitiesSearchObject.attribute11 + ',';
        }

        if (rmanEntitiesSearchObject.attribute12 != undefined && rmanEntitiesSearchObject.attribute12 != "") {
            searchString = searchString + 'attribute12:' + rmanEntitiesSearchObject.attribute12 + ',';
        }

        if (rmanEntitiesSearchObject.attribute13 != undefined && rmanEntitiesSearchObject.attribute13 != "") {
            searchString = searchString + 'attribute13:' + rmanEntitiesSearchObject.attribute13 + ',';
        }

        if (rmanEntitiesSearchObject.attribute14 != undefined && rmanEntitiesSearchObject.attribute14 != "") {
            searchString = searchString + 'attribute14:' + rmanEntitiesSearchObject.attribute14 + ',';
        }

        if (rmanEntitiesSearchObject.attribute15 != undefined && rmanEntitiesSearchObject.attribute15 != "") {
            searchString = searchString + 'attribute15:' + rmanEntitiesSearchObject.attribute15 + ',';
        }

        if (rmanEntitiesSearchObject.attribute16 != undefined && rmanEntitiesSearchObject.attribute16 != "") {
            searchString = searchString + 'attribute16:' + rmanEntitiesSearchObject.attribute16 + ',';
        }

        if (rmanEntitiesSearchObject.attribute17 != undefined && rmanEntitiesSearchObject.attribute17 != "") {
            searchString = searchString + 'attribute17:' + rmanEntitiesSearchObject.attribute17 + ',';
        }

        if (rmanEntitiesSearchObject.attribute18 != undefined && rmanEntitiesSearchObject.attribute18 != "") {
            searchString = searchString + 'attribute18:' + rmanEntitiesSearchObject.attribute18 + ',';
        }

        if (rmanEntitiesSearchObject.attribute19 != undefined && rmanEntitiesSearchObject.attribute19 != "") {
            searchString = searchString + 'attribute19:' + rmanEntitiesSearchObject.attribute19 + ',';
        }

        if (rmanEntitiesSearchObject.attribute20 != undefined && rmanEntitiesSearchObject.attribute20 != "") {
            searchString = searchString + 'attribute20:' + rmanEntitiesSearchObject.attribute20 + ',';
        }

        if (rmanEntitiesSearchObject.attribute21 != undefined && rmanEntitiesSearchObject.attribute21 != "") {
            searchString = searchString + 'attribute21:' + rmanEntitiesSearchObject.attribute21 + ',';
        }

        if (rmanEntitiesSearchObject.attribute22 != undefined && rmanEntitiesSearchObject.attribute22 != "") {
            searchString = searchString + 'attribute22:' + rmanEntitiesSearchObject.attribute22 + ',';
        }

        if (rmanEntitiesSearchObject.attribute23 != undefined && rmanEntitiesSearchObject.attribute23 != "") {
            searchString = searchString + 'attribute23:' + rmanEntitiesSearchObject.attribute23 + ',';
        }

        if (rmanEntitiesSearchObject.attribute24 != undefined && rmanEntitiesSearchObject.attribute24 != "") {
            searchString = searchString + 'attribute24:' + rmanEntitiesSearchObject.attribute24 + ',';
        }

        if (rmanEntitiesSearchObject.attribute25 != undefined && rmanEntitiesSearchObject.attribute25 != "") {
            searchString = searchString + 'attribute25:' + rmanEntitiesSearchObject.attribute25 + ',';
        }

        if (rmanEntitiesSearchObject.attribute26 != undefined && rmanEntitiesSearchObject.attribute26 != "") {
            searchString = searchString + 'attribute26:' + rmanEntitiesSearchObject.attribute26 + ',';
        }

        if (rmanEntitiesSearchObject.attribute27 != undefined && rmanEntitiesSearchObject.attribute27 != "") {
            searchString = searchString + 'attribute27:' + rmanEntitiesSearchObject.attribute27 + ',';
        }

        if (rmanEntitiesSearchObject.attribute28 != undefined && rmanEntitiesSearchObject.attribute28 != "") {
            searchString = searchString + 'attribute28:' + rmanEntitiesSearchObject.attribute28 + ',';
        }

        if (rmanEntitiesSearchObject.attribute29 != undefined && rmanEntitiesSearchObject.attribute29 != "") {
            searchString = searchString + 'attribute29:' + rmanEntitiesSearchObject.attribute29 + ',';
        }

        if (rmanEntitiesSearchObject.attribute30 != undefined && rmanEntitiesSearchObject.attribute30 != "") {
            searchString = searchString + 'attribute30:' + rmanEntitiesSearchObject.attribute30 + ',';
        }

        if (rmanEntitiesSearchObject.creationDate != undefined && rmanEntitiesSearchObject.creationDate != "") {
            searchString = searchString + 'creationDate:' + rmanEntitiesSearchObject.creationDate + ',';
        }

        if (rmanEntitiesSearchObject.createdBy != undefined && rmanEntitiesSearchObject.createdBy != "") {
            searchString = searchString + 'createdBy:' + rmanEntitiesSearchObject.createdBy + ',';
        }

        if (rmanEntitiesSearchObject.lastUpdateDate != undefined && rmanEntitiesSearchObject.lastUpdateDate != "") {
            searchString = searchString + 'lastUpdateDate:' + rmanEntitiesSearchObject.lastUpdateDate + ',';
        }

        if (rmanEntitiesSearchObject.lastUpdatedBy != undefined && rmanEntitiesSearchObject.lastUpdatedBy != "") {
            searchString = searchString + 'lastUpdatedBy:' + rmanEntitiesSearchObject.lastUpdatedBy + ',';
        }

        if (rmanEntitiesSearchObject.dealFlag != undefined && rmanEntitiesSearchObject.dealFlag != "") {
            searchString = searchString + 'dealFlag:' + rmanEntitiesSearchObject.dealFlag + ',';
        }

        if (rmanEntitiesSearchObject.postBooking != undefined && rmanEntitiesSearchObject.postBooking != "") {
            searchString = searchString + 'postBooking:' + rmanEntitiesSearchObject.postBooking + ',';
        }

        if (rmanEntitiesSearchObject.auditFlag != undefined && rmanEntitiesSearchObject.auditFlag != "") {
            searchString = searchString + 'auditFlag:' + rmanEntitiesSearchObject.auditFlag + ',';
        }

        if (rmanEntitiesSearchObject.objectType != undefined && rmanEntitiesSearchObject.objectType != "") {
            searchString = searchString + 'objectType:' + rmanEntitiesSearchObject.objectType;
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



    saveRmanEntities(rmanEntities: any): Promise<any[]> {
        let body = JSON.stringify(rmanEntities);
        return this.http.post<any[]>(appSettings.apiUrl + '/RMAN_ENTITIES', body, httpOptions).toPromise().then(data => {
            return data;
        });
    }

    updateRmanEntities(rmanEntities: any): Promise<any[]> {

        delete rmanEntities._links;
        delete rmanEntities.interests;
        let body = JSON.stringify(rmanEntities);
        return this.http.put<any[]>(appSettings.apiUrl + '/RMAN_ENTITIES/' + rmanEntities.entityId, body, httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanEntities(rmanEntities: any): Promise<any[]> {
        let deleteUrl = appSettings.apiUrl + '/RMAN_ENTITIES/' + rmanEntities.entityId;
        return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
            return data;
        });
    }

}
