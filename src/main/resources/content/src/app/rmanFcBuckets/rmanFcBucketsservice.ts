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
export class RmanFcBucketsService {

    constructor(private http: HttpClient) { }

    getAllRmanFcBuckets(paginationOptions: any, rmanFcBucketsSearchObject: any): Promise<any[]> {
        let serviceUrl = appSettings.apiUrl + '/rmanFcBucketsSearch?';

        let searchString = '';

        if (rmanFcBucketsSearchObject.bucketId != undefined && rmanFcBucketsSearchObject.bucketId != "") {
            searchString = searchString + 'bucketId:' + rmanFcBucketsSearchObject.bucketId + ',';
        }

        if (rmanFcBucketsSearchObject.name != undefined && rmanFcBucketsSearchObject.name != "") {
            searchString = searchString + 'name:' + rmanFcBucketsSearchObject.name + ',';
        }

        if (rmanFcBucketsSearchObject.version != undefined && rmanFcBucketsSearchObject.version != "") {
            searchString = searchString + 'version:' + rmanFcBucketsSearchObject.version + ',';
        }

        if (rmanFcBucketsSearchObject.numberOfBuckets != undefined && rmanFcBucketsSearchObject.numberOfBuckets != "") {
            searchString = searchString + 'numberOfBuckets:' + rmanFcBucketsSearchObject.numberOfBuckets + ',';
        }

        if (rmanFcBucketsSearchObject.numberOfPeriods != undefined && rmanFcBucketsSearchObject.numberOfPeriods != "") {
            searchString = searchString + 'numberOfPeriods:' + rmanFcBucketsSearchObject.numberOfPeriods + ',';
        }

        if (rmanFcBucketsSearchObject.numberOfQtrs != undefined && rmanFcBucketsSearchObject.numberOfQtrs != "") {
            searchString = searchString + 'numberOfQtrs:' + rmanFcBucketsSearchObject.numberOfQtrs + ',';
        }

        if (rmanFcBucketsSearchObject.numberOfYears != undefined && rmanFcBucketsSearchObject.numberOfYears != "") {
            searchString = searchString + 'numberOfYears:' + rmanFcBucketsSearchObject.numberOfYears + ',';
        }

        if (rmanFcBucketsSearchObject.startDate != undefined && rmanFcBucketsSearchObject.startDate != "") {
            searchString = searchString + 'startDate:' + rmanFcBucketsSearchObject.startDate + ',';
        }

        if (rmanFcBucketsSearchObject.endDate != undefined && rmanFcBucketsSearchObject.endDate != "") {
            searchString = searchString + 'endDate:' + rmanFcBucketsSearchObject.endDate + ',';
        }

        if (rmanFcBucketsSearchObject.attribute1 != undefined && rmanFcBucketsSearchObject.attribute1 != "") {
            searchString = searchString + 'attribute1:' + rmanFcBucketsSearchObject.attribute1 + ',';
        }

        if (rmanFcBucketsSearchObject.attribute2 != undefined && rmanFcBucketsSearchObject.attribute2 != "") {
            searchString = searchString + 'attribute2:' + rmanFcBucketsSearchObject.attribute2 + ',';
        }

        if (rmanFcBucketsSearchObject.attribute3 != undefined && rmanFcBucketsSearchObject.attribute3 != "") {
            searchString = searchString + 'attribute3:' + rmanFcBucketsSearchObject.attribute3 + ',';
        }

        if (rmanFcBucketsSearchObject.attribute4 != undefined && rmanFcBucketsSearchObject.attribute4 != "") {
            searchString = searchString + 'attribute4:' + rmanFcBucketsSearchObject.attribute4 + ',';
        }

        if (rmanFcBucketsSearchObject.attribute5 != undefined && rmanFcBucketsSearchObject.attribute5 != "") {
            searchString = searchString + 'attribute5:' + rmanFcBucketsSearchObject.attribute5 + ',';
        }

        if (rmanFcBucketsSearchObject.attribute6 != undefined && rmanFcBucketsSearchObject.attribute6 != "") {
            searchString = searchString + 'attribute6:' + rmanFcBucketsSearchObject.attribute6 + ',';
        }

        if (rmanFcBucketsSearchObject.attribute7 != undefined && rmanFcBucketsSearchObject.attribute7 != "") {
            searchString = searchString + 'attribute7:' + rmanFcBucketsSearchObject.attribute7 + ',';
        }

        if (rmanFcBucketsSearchObject.attribute8 != undefined && rmanFcBucketsSearchObject.attribute8 != "") {
            searchString = searchString + 'attribute8:' + rmanFcBucketsSearchObject.attribute8 + ',';
        }

        if (rmanFcBucketsSearchObject.attribute9 != undefined && rmanFcBucketsSearchObject.attribute9 != "") {
            searchString = searchString + 'attribute9:' + rmanFcBucketsSearchObject.attribute9 + ',';
        }

        if (rmanFcBucketsSearchObject.attribute10 != undefined && rmanFcBucketsSearchObject.attribute10 != "") {
            searchString = searchString + 'attribute10:' + rmanFcBucketsSearchObject.attribute10 + ',';
        }

        if (rmanFcBucketsSearchObject.attribute11 != undefined && rmanFcBucketsSearchObject.attribute11 != "") {
            searchString = searchString + 'attribute11:' + rmanFcBucketsSearchObject.attribute11 + ',';
        }

        if (rmanFcBucketsSearchObject.attribute12 != undefined && rmanFcBucketsSearchObject.attribute12 != "") {
            searchString = searchString + 'attribute12:' + rmanFcBucketsSearchObject.attribute12 + ',';
        }

        if (rmanFcBucketsSearchObject.attribute13 != undefined && rmanFcBucketsSearchObject.attribute13 != "") {
            searchString = searchString + 'attribute13:' + rmanFcBucketsSearchObject.attribute13 + ',';
        }

        if (rmanFcBucketsSearchObject.attribute14 != undefined && rmanFcBucketsSearchObject.attribute14 != "") {
            searchString = searchString + 'attribute14:' + rmanFcBucketsSearchObject.attribute14 + ',';
        }

        if (rmanFcBucketsSearchObject.attribute15 != undefined && rmanFcBucketsSearchObject.attribute15 != "") {
            searchString = searchString + 'attribute15:' + rmanFcBucketsSearchObject.attribute15 + ',';
        }

        if (rmanFcBucketsSearchObject.createdDate != undefined && rmanFcBucketsSearchObject.createdDate != "") {
            searchString = searchString + 'createdDate:' + rmanFcBucketsSearchObject.createdDate + ',';
        }

        if (rmanFcBucketsSearchObject.createdBy != undefined && rmanFcBucketsSearchObject.createdBy != "") {
            searchString = searchString + 'createdBy:' + rmanFcBucketsSearchObject.createdBy + ',';
        }

        if (rmanFcBucketsSearchObject.lastUpdatedDate != undefined && rmanFcBucketsSearchObject.lastUpdatedDate != "") {
            searchString = searchString + 'lastUpdatedDate:' + rmanFcBucketsSearchObject.lastUpdatedDate + ',';
        }

        if (rmanFcBucketsSearchObject.lastUpdatedBy != undefined && rmanFcBucketsSearchObject.lastUpdatedBy != "") {
            searchString = searchString + 'lastUpdatedBy:' + rmanFcBucketsSearchObject.lastUpdatedBy + ',';
        }

        if (rmanFcBucketsSearchObject.latestFlag != undefined && rmanFcBucketsSearchObject.latestFlag != "") {
            searchString = searchString + 'latestFlag:' + rmanFcBucketsSearchObject.latestFlag;
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



    saveRmanFcBuckets(rmanFcBuckets: any): Promise<any[]> {
        let body = JSON.stringify(rmanFcBuckets);
        return this.http.post<any[]>(appSettings.apiUrl + '/RMAN_FC_BUCKETS', body, httpOptions).toPromise().then(data => {
            return data;
        });
    }

    updateRmanFcBuckets(rmanFcBuckets: any): Promise<any[]> {

        delete rmanFcBuckets._links;
        delete rmanFcBuckets.interests;
        let body = JSON.stringify(rmanFcBuckets);
        return this.http.put<any[]>(appSettings.apiUrl + '/RMAN_FC_BUCKETS/' + rmanFcBuckets.bucketId, body, httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanFcBuckets(rmanFcBuckets: any): Promise<any[]> {
        let deleteUrl = appSettings.apiUrl + '/RMAN_FC_BUCKETS/' + rmanFcBuckets.bucketId;
        return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
            return data;
        });
    }

    getFcBucketsList() {
        let fcListurl = appSettings.apiUrl + '/FcBucketsSearch';
        return this.http.get(fcListurl).toPromise().then(data => {
            return data;
        });
    }

}
