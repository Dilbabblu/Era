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
export class AllTabColumnsService {

    constructor(private http: HttpClient) { }

    getAllAllTabColumns(paginationOptions: any, allTabColumnsSearchObject: any): Promise<any[]> {
        let serviceUrl = appSettings.apiUrl + '/allTabColumnsSearch?';

        let searchString = '';

        if (allTabColumnsSearchObject.owner != undefined && allTabColumnsSearchObject.owner != "") {
            searchString = searchString + 'owner:' + allTabColumnsSearchObject.owner + ',';
        }

        if (allTabColumnsSearchObject.tableName != undefined && allTabColumnsSearchObject.tableName != "") {
            searchString = searchString + 'tableName:' + allTabColumnsSearchObject.tableName + ',';
        }

        if (allTabColumnsSearchObject.columnName != undefined && allTabColumnsSearchObject.columnName != "") {
            searchString = searchString + 'columnName:' + allTabColumnsSearchObject.columnName + ',';
        }

        if (allTabColumnsSearchObject.dataType != undefined && allTabColumnsSearchObject.dataType != "") {
            searchString = searchString + 'dataType:' + allTabColumnsSearchObject.dataType + ',';
        }

        if (allTabColumnsSearchObject.dataTypeMod != undefined && allTabColumnsSearchObject.dataTypeMod != "") {
            searchString = searchString + 'dataTypeMod:' + allTabColumnsSearchObject.dataTypeMod + ',';
        }

        if (allTabColumnsSearchObject.dataTypeOwner != undefined && allTabColumnsSearchObject.dataTypeOwner != "") {
            searchString = searchString + 'dataTypeOwner:' + allTabColumnsSearchObject.dataTypeOwner + ',';
        }

        if (allTabColumnsSearchObject.dataLength != undefined && allTabColumnsSearchObject.dataLength != "") {
            searchString = searchString + 'dataLength:' + allTabColumnsSearchObject.dataLength + ',';
        }

        if (allTabColumnsSearchObject.dataPrecision != undefined && allTabColumnsSearchObject.dataPrecision != "") {
            searchString = searchString + 'dataPrecision:' + allTabColumnsSearchObject.dataPrecision + ',';
        }

        if (allTabColumnsSearchObject.dataScale != undefined && allTabColumnsSearchObject.dataScale != "") {
            searchString = searchString + 'dataScale:' + allTabColumnsSearchObject.dataScale + ',';
        }

        if (allTabColumnsSearchObject.nullable != undefined && allTabColumnsSearchObject.nullable != "") {
            searchString = searchString + 'nullable:' + allTabColumnsSearchObject.nullable + ',';
        }

        if (allTabColumnsSearchObject.columnId != undefined && allTabColumnsSearchObject.columnId != "") {
            searchString = searchString + 'columnId:' + allTabColumnsSearchObject.columnId + ',';
        }

        if (allTabColumnsSearchObject.defaultLength != undefined && allTabColumnsSearchObject.defaultLength != "") {
            searchString = searchString + 'defaultLength:' + allTabColumnsSearchObject.defaultLength + ',';
        }

        if (allTabColumnsSearchObject.dataDefault != undefined && allTabColumnsSearchObject.dataDefault != "") {
            searchString = searchString + 'dataDefault:' + allTabColumnsSearchObject.dataDefault + ',';
        }

        if (allTabColumnsSearchObject.numDistinct != undefined && allTabColumnsSearchObject.numDistinct != "") {
            searchString = searchString + 'numDistinct:' + allTabColumnsSearchObject.numDistinct + ',';
        }

        if (allTabColumnsSearchObject.lowValue != undefined && allTabColumnsSearchObject.lowValue != "") {
            searchString = searchString + 'lowValue:' + allTabColumnsSearchObject.lowValue + ',';
        }

        if (allTabColumnsSearchObject.highValue != undefined && allTabColumnsSearchObject.highValue != "") {
            searchString = searchString + 'highValue:' + allTabColumnsSearchObject.highValue + ',';
        }

        if (allTabColumnsSearchObject.density != undefined && allTabColumnsSearchObject.density != "") {
            searchString = searchString + 'density:' + allTabColumnsSearchObject.density + ',';
        }

        if (allTabColumnsSearchObject.numNulls != undefined && allTabColumnsSearchObject.numNulls != "") {
            searchString = searchString + 'numNulls:' + allTabColumnsSearchObject.numNulls + ',';
        }

        if (allTabColumnsSearchObject.numBuckets != undefined && allTabColumnsSearchObject.numBuckets != "") {
            searchString = searchString + 'numBuckets:' + allTabColumnsSearchObject.numBuckets + ',';
        }

        if (allTabColumnsSearchObject.lastAnalyzed != undefined && allTabColumnsSearchObject.lastAnalyzed != "") {
            searchString = searchString + 'lastAnalyzed:' + allTabColumnsSearchObject.lastAnalyzed + ',';
        }

        if (allTabColumnsSearchObject.sampleSize != undefined && allTabColumnsSearchObject.sampleSize != "") {
            searchString = searchString + 'sampleSize:' + allTabColumnsSearchObject.sampleSize + ',';
        }

        if (allTabColumnsSearchObject.characterSetName != undefined && allTabColumnsSearchObject.characterSetName != "") {
            searchString = searchString + 'characterSetName:' + allTabColumnsSearchObject.characterSetName + ',';
        }

        if (allTabColumnsSearchObject.charColDeclLength != undefined && allTabColumnsSearchObject.charColDeclLength != "") {
            searchString = searchString + 'charColDeclLength:' + allTabColumnsSearchObject.charColDeclLength + ',';
        }

        if (allTabColumnsSearchObject.globalStats != undefined && allTabColumnsSearchObject.globalStats != "") {
            searchString = searchString + 'globalStats:' + allTabColumnsSearchObject.globalStats + ',';
        }

        if (allTabColumnsSearchObject.userStats != undefined && allTabColumnsSearchObject.userStats != "") {
            searchString = searchString + 'userStats:' + allTabColumnsSearchObject.userStats + ',';
        }

        if (allTabColumnsSearchObject.avgColLen != undefined && allTabColumnsSearchObject.avgColLen != "") {
            searchString = searchString + 'avgColLen:' + allTabColumnsSearchObject.avgColLen + ',';
        }

        if (allTabColumnsSearchObject.charLength != undefined && allTabColumnsSearchObject.charLength != "") {
            searchString = searchString + 'charLength:' + allTabColumnsSearchObject.charLength + ',';
        }

        if (allTabColumnsSearchObject.charUsed != undefined && allTabColumnsSearchObject.charUsed != "") {
            searchString = searchString + 'charUsed:' + allTabColumnsSearchObject.charUsed + ',';
        }

        if (allTabColumnsSearchObject.v80FmtImage != undefined && allTabColumnsSearchObject.v80FmtImage != "") {
            searchString = searchString + 'v80FmtImage:' + allTabColumnsSearchObject.v80FmtImage + ',';
        }

        if (allTabColumnsSearchObject.dataUpgraded != undefined && allTabColumnsSearchObject.dataUpgraded != "") {
            searchString = searchString + 'dataUpgraded:' + allTabColumnsSearchObject.dataUpgraded + ',';
        }

        if (allTabColumnsSearchObject.histogram != undefined && allTabColumnsSearchObject.histogram != "") {
            searchString = searchString + 'histogram:' + allTabColumnsSearchObject.histogram;
        }



        if (searchString == '') {
            serviceUrl = serviceUrl + 'search=%25&size=10000';
        }
        else {
            serviceUrl = serviceUrl + 'search=' + searchString + '&size=10000';
        }

        if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != "" && !isNaN(paginationOptions.pageNumber) && paginationOptions.pageNumber != 0) {
            serviceUrl = serviceUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;
        }

        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }

    saveAllTabColumns(allTabColumns: any): Promise<any[]> {
        let body = JSON.stringify(allTabColumns);
        return this.http.post<any[]>(appSettings.apiUrl + '/ALL_TAB_COLUMNS', body, httpOptions).toPromise().then(data => {
            return data;
        });
    }

    updateAllTabColumns(allTabColumns: any): Promise<any[]> {

        delete allTabColumns._links;
        delete allTabColumns.interests;
        let body = JSON.stringify(allTabColumns);
        return this.http.put<any[]>(appSettings.apiUrl + '/ALL_TAB_COLUMNS/' + allTabColumns.tableName, body, httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteAllTabColumns(allTabColumns: any): Promise<any[]> {
        let deleteUrl = appSettings.apiUrl + '/ALL_TAB_COLUMNS/' + allTabColumns.tableName;
        return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
            return data;
        });
    }

}
