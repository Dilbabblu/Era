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
export class RmanResponsibilitiesService {

    constructor(private http: HttpClient) { }

    getAllRmanResponsibilities(paginationOptions: any, rmanResponsibilitiesSearchObject: any): Promise<any[]> {
        let serviceUrl = appSettings.apiUrl + '/rmanResponsibilitiesSearch?';

        let searchString = '';

        if (rmanResponsibilitiesSearchObject.responsibilityId != undefined && rmanResponsibilitiesSearchObject.responsibilityId != "") {
            searchString = searchString + 'responsibilityId:' + rmanResponsibilitiesSearchObject.responsibilityId + ',';
        }

        if (rmanResponsibilitiesSearchObject.responsibilityName != undefined && rmanResponsibilitiesSearchObject.responsibilityName != "") {
            searchString = searchString + 'responsibilityName:' + rmanResponsibilitiesSearchObject.responsibilityName + ',';
        }

        if (rmanResponsibilitiesSearchObject.description != undefined && rmanResponsibilitiesSearchObject.description != "") {
            searchString = searchString + 'description:' + rmanResponsibilitiesSearchObject.description + ',';
        }

        if (rmanResponsibilitiesSearchObject.startDateActive != undefined && rmanResponsibilitiesSearchObject.startDateActive != "") {
            searchString = searchString + 'startDateActive:' + rmanResponsibilitiesSearchObject.startDateActive + ',';
        }

        if (rmanResponsibilitiesSearchObject.endDateActive != undefined && rmanResponsibilitiesSearchObject.endDateActive != "") {
            searchString = searchString + 'endDateActive:' + rmanResponsibilitiesSearchObject.endDateActive + ',';
        }

        if (rmanResponsibilitiesSearchObject.attribute1 != undefined && rmanResponsibilitiesSearchObject.attribute1 != "") {
            searchString = searchString + 'attribute1:' + rmanResponsibilitiesSearchObject.attribute1 + ',';
        }

        if (rmanResponsibilitiesSearchObject.attribute2 != undefined && rmanResponsibilitiesSearchObject.attribute2 != "") {
            searchString = searchString + 'attribute2:' + rmanResponsibilitiesSearchObject.attribute2 + ',';
        }

        if (rmanResponsibilitiesSearchObject.attribute3 != undefined && rmanResponsibilitiesSearchObject.attribute3 != "") {
            searchString = searchString + 'attribute3:' + rmanResponsibilitiesSearchObject.attribute3 + ',';
        }

        if (rmanResponsibilitiesSearchObject.attribute4 != undefined && rmanResponsibilitiesSearchObject.attribute4 != "") {
            searchString = searchString + 'attribute4:' + rmanResponsibilitiesSearchObject.attribute4 + ',';
        }

        if (rmanResponsibilitiesSearchObject.attribute5 != undefined && rmanResponsibilitiesSearchObject.attribute5 != "") {
            searchString = searchString + 'attribute5:' + rmanResponsibilitiesSearchObject.attribute5 + ',';
        }

        if (rmanResponsibilitiesSearchObject.creationDate != undefined && rmanResponsibilitiesSearchObject.creationDate != "") {
            searchString = searchString + 'creationDate:' + rmanResponsibilitiesSearchObject.creationDate + ',';
        }

        if (rmanResponsibilitiesSearchObject.createdBy != undefined && rmanResponsibilitiesSearchObject.createdBy != "") {
            searchString = searchString + 'createdBy:' + rmanResponsibilitiesSearchObject.createdBy + ',';
        }

        if (rmanResponsibilitiesSearchObject.lastUpdateDate != undefined && rmanResponsibilitiesSearchObject.lastUpdateDate != "") {
            searchString = searchString + 'lastUpdateDate:' + rmanResponsibilitiesSearchObject.lastUpdateDate + ',';
        }

        if (rmanResponsibilitiesSearchObject.lastUpdatedBy != undefined && rmanResponsibilitiesSearchObject.lastUpdatedBy != "") {
            searchString = searchString + 'lastUpdatedBy:' + rmanResponsibilitiesSearchObject.lastUpdatedBy;
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


    saveRmanResponsibilities(rmanResponsibilities: any): Promise<any[]> {
        let body = JSON.stringify(rmanResponsibilities);
        return this.http.post<any[]>(appSettings.apiUrl + '/RMAN_RESPONSIBILITIES', body, httpOptions).toPromise().then(data => {
            return data;
        });
    }

    updateRmanResponsibilities(rmanResponsibilities: any): Promise<any[]> {

        delete rmanResponsibilities._links;
        delete rmanResponsibilities.interests;
        rmanResponsibilities.rmanRoleFunctions = [];
        let body = JSON.stringify(rmanResponsibilities);
        return this.http.put<any[]>(appSettings.apiUrl + '/RMAN_RESPONSIBILITIES/' + rmanResponsibilities.responsibilityId, body, httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanResponsibilities(rmanResponsibilities: any): Promise<any[]> {
        let deleteUrl = appSettings.apiUrl + '/RMAN_RESPONSIBILITIES/' + rmanResponsibilities.responsibilityId;
        return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
            return data;
        });
    }

    processRmanRoleFunctions(responsibilityId: any): Promise<any> {
        let serviceUrl = appSettings.apiUrl + '/revmantra/processRmanRoleFunctions?responsibilityId=' + responsibilityId;
        return this.http.get(serviceUrl).toPromise().then(data => {
            return data;
        });
    }

}
