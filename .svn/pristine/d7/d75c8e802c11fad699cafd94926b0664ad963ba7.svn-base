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
export class RmanRulesHeaderService {

    constructor(private http: HttpClient) { }

    getAllRmanRulesHeader(paginationOptions: any, rmanRulesHeaderSearchObject: any): Promise<any[]> {

        let serviceUrl = appSettings.apiUrl + '/rmanRulesHeaderSearch?';

        let searchString = '';
        const searchFeilds = ['ruleHeaderId', "ruleName", "ruleCategory", "ruleStartDate", "ruleEndDate", "attribute1", "attribute2", "attribute3", "attribute4", "attribute5", "attribute6", "attribute7", "attribute8", "attribute9", "attribute10", "attribute11", "attribute12", "attribute13", "attribute14", "attribute15", "attribute16", "attribute17", "attribute18", "attribute19", "attribute20", "attribute21", "attribute22", "attribute23", "attribute24", "attribute25", "attribute26", "attribute27", "attribute28", "attribute29", "attribute30", "creationDate", "createdBy", "lastUpdateDate", "description", "ruleMasterId", "approverId", "sequenceNumber", "dealFlag"];
        searchFeilds.forEach((obj) => {
            if (rmanRulesHeaderSearchObject[obj] != undefined && rmanRulesHeaderSearchObject[obj] != "") {
                searchString = searchString + obj + ':' + rmanRulesHeaderSearchObject[obj] + ',';
            }
        });

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

    saveRmanRulesHeader(rmanRulesHeader: any): Promise<any[]> {
        let body = JSON.stringify(rmanRulesHeader);
        return this.http.post<any[]>(appSettings.apiUrl + '/RMAN_RULES_HEADER', body, httpOptions).toPromise().then(data => {
            return data;
        });
    }

    updateRmanRulesHeader(rmanRulesHeader: any): Promise<any[]> {

        delete rmanRulesHeader._links;
        delete rmanRulesHeader.interests;
        let body = JSON.stringify(rmanRulesHeader);
        return this.http.put<any[]>(appSettings.apiUrl + '/RMAN_RULES_HEADER/' + rmanRulesHeader.ruleHeaderId, body, httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanRulesHeader(rmanRulesHeader: any): Promise<any[]> {
        let deleteUrl = appSettings.apiUrl + '/RMAN_RULES_HEADER/' + rmanRulesHeader.ruleHeaderId;
        return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
            return data;
        });
    }

}
