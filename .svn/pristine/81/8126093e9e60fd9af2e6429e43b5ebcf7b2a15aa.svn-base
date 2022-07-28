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
export class RmanFmvRulesDefService {

    constructor(private http: HttpClient, private datePipe: DatePipe) { }

    getAllRmanFmvRulesDef(paginationOptions: any, rmanFmvRulesDefSearchObject: any, exportFlag: any) {

        let serviceUrl = appSettings.apiUrl + '/rmanFMVRulesExport?';

        if (exportFlag == 0) {
            serviceUrl = appSettings.apiUrl + '/rmanFmvRulesDefSearch?';
        }

        let searchString = '';

        if (rmanFmvRulesDefSearchObject.fmvRuleDefId != undefined && rmanFmvRulesDefSearchObject.fmvRuleDefId != "") {
            searchString = searchString + 'fmvRuleDefId:' + rmanFmvRulesDefSearchObject.fmvRuleDefId + ',';
        }

        if (rmanFmvRulesDefSearchObject.fmvRuleName != undefined && rmanFmvRulesDefSearchObject.fmvRuleName != "") {
            searchString = searchString + 'fmvRuleName:' + rmanFmvRulesDefSearchObject.fmvRuleName + ',';
        }

        if (rmanFmvRulesDefSearchObject.fmvType != undefined && rmanFmvRulesDefSearchObject.fmvType != "") {
            searchString = searchString + 'fmvType:' + rmanFmvRulesDefSearchObject.fmvType + ',';
        }

        if (rmanFmvRulesDefSearchObject.quarterStartDate != undefined && rmanFmvRulesDefSearchObject.quarterStartDate != "") {
            searchString = searchString + 'quarterStartDate>' + this.datePipe.transform(rmanFmvRulesDefSearchObject.quarterStartDate, 'yyyyMMdd') + ',';
        }

        if (rmanFmvRulesDefSearchObject.quarterEndDate != undefined && rmanFmvRulesDefSearchObject.quarterEndDate != "") {
            searchString = searchString + 'quarterEndDate<' + this.datePipe.transform(rmanFmvRulesDefSearchObject.quarterEndDate, 'yyyyMMdd') + ',';
        }


        if (rmanFmvRulesDefSearchObject.min != undefined && rmanFmvRulesDefSearchObject.min != "") {
            searchString = searchString + 'min:' + rmanFmvRulesDefSearchObject.min + ',';
        }

        if (rmanFmvRulesDefSearchObject.median != undefined && rmanFmvRulesDefSearchObject.median != "") {
            searchString = searchString + 'median:' + rmanFmvRulesDefSearchObject.median + ',';
        }

        if (rmanFmvRulesDefSearchObject.max != undefined && rmanFmvRulesDefSearchObject.max != "") {
            searchString = searchString + 'max:' + rmanFmvRulesDefSearchObject.max + ',';
        }

        if (rmanFmvRulesDefSearchObject.fmvRuleStatus != undefined && rmanFmvRulesDefSearchObject.fmvRuleStatus != "") {
            searchString = searchString + 'fmvRuleStatus:' + rmanFmvRulesDefSearchObject.fmvRuleStatus + ',';
        }

        if (rmanFmvRulesDefSearchObject.fmvPrice != undefined && rmanFmvRulesDefSearchObject.fmvPrice != "") {
            searchString = searchString + 'fmvPrice:' + rmanFmvRulesDefSearchObject.fmvPrice + ',';
        }

        if (rmanFmvRulesDefSearchObject.fmvPct != undefined && rmanFmvRulesDefSearchObject.fmvPct != "") {
            searchString = searchString + 'fmvPct:' + rmanFmvRulesDefSearchObject.fmvPct + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute1 != undefined && rmanFmvRulesDefSearchObject.attribute1 != "") {
            searchString = searchString + 'attribute1:' + rmanFmvRulesDefSearchObject.attribute1 + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute2 != undefined && rmanFmvRulesDefSearchObject.attribute2 != "") {
            searchString = searchString + 'attribute2:' + rmanFmvRulesDefSearchObject.attribute2 + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute3 != undefined && rmanFmvRulesDefSearchObject.attribute3 != "") {
            searchString = searchString + 'attribute3:' + rmanFmvRulesDefSearchObject.attribute3 + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute4 != undefined && rmanFmvRulesDefSearchObject.attribute4 != "") {
            searchString = searchString + 'attribute4:' + rmanFmvRulesDefSearchObject.attribute4 + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute5 != undefined && rmanFmvRulesDefSearchObject.attribute5 != "") {
            searchString = searchString + 'attribute5:' + rmanFmvRulesDefSearchObject.attribute5 + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute6 != undefined && rmanFmvRulesDefSearchObject.attribute6 != "") {
            searchString = searchString + 'attribute6:' + rmanFmvRulesDefSearchObject.attribute6 + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute7 != undefined && rmanFmvRulesDefSearchObject.attribute7 != "") {
            searchString = searchString + 'attribute7:' + rmanFmvRulesDefSearchObject.attribute7 + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute8 != undefined && rmanFmvRulesDefSearchObject.attribute8 != "") {
            searchString = searchString + 'attribute8:' + rmanFmvRulesDefSearchObject.attribute8 + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute9 != undefined && rmanFmvRulesDefSearchObject.attribute9 != "") {
            searchString = searchString + 'attribute9:' + rmanFmvRulesDefSearchObject.attribute9 + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute10 != undefined && rmanFmvRulesDefSearchObject.attribute10 != "") {
            searchString = searchString + 'attribute10:' + rmanFmvRulesDefSearchObject.attribute10 + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute11 != undefined && rmanFmvRulesDefSearchObject.attribute11 != "") {
            searchString = searchString + 'attribute11:' + rmanFmvRulesDefSearchObject.attribute11 + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute12 != undefined && rmanFmvRulesDefSearchObject.attribute12 != "") {
            searchString = searchString + 'attribute12:' + rmanFmvRulesDefSearchObject.attribute12 + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute13 != undefined && rmanFmvRulesDefSearchObject.attribute13 != "") {
            searchString = searchString + 'attribute13:' + rmanFmvRulesDefSearchObject.attribute13 + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute14 != undefined && rmanFmvRulesDefSearchObject.attribute14 != "") {
            searchString = searchString + 'attribute14:' + rmanFmvRulesDefSearchObject.attribute14 + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute15 != undefined && rmanFmvRulesDefSearchObject.attribute15 != "") {
            searchString = searchString + 'attribute15:' + rmanFmvRulesDefSearchObject.attribute15 + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute16 != undefined && rmanFmvRulesDefSearchObject.attribute16 != "") {
            searchString = searchString + 'attribute16:' + rmanFmvRulesDefSearchObject.attribute16 + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute17 != undefined && rmanFmvRulesDefSearchObject.attribute17 != "") {
            searchString = searchString + 'attribute17:' + rmanFmvRulesDefSearchObject.attribute17 + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute18 != undefined && rmanFmvRulesDefSearchObject.attribute18 != "") {
            searchString = searchString + 'attribute18:' + rmanFmvRulesDefSearchObject.attribute18 + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute19 != undefined && rmanFmvRulesDefSearchObject.attribute19 != "") {
            searchString = searchString + 'attribute19:' + rmanFmvRulesDefSearchObject.attribute19 + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute20 != undefined && rmanFmvRulesDefSearchObject.attribute20 != "") {
            searchString = searchString + 'attribute20:' + rmanFmvRulesDefSearchObject.attribute20 + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute21 != undefined && rmanFmvRulesDefSearchObject.attribute21 != "") {
            searchString = searchString + 'attribute21:' + rmanFmvRulesDefSearchObject.attribute21 + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute22 != undefined && rmanFmvRulesDefSearchObject.attribute22 != "") {
            searchString = searchString + 'attribute22:' + rmanFmvRulesDefSearchObject.attribute22 + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute23 != undefined && rmanFmvRulesDefSearchObject.attribute23 != "") {
            searchString = searchString + 'attribute23:' + rmanFmvRulesDefSearchObject.attribute23 + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute24 != undefined && rmanFmvRulesDefSearchObject.attribute24 != "") {
            searchString = searchString + 'attribute24:' + rmanFmvRulesDefSearchObject.attribute24 + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute25 != undefined && rmanFmvRulesDefSearchObject.attribute25 != "") {
            searchString = searchString + 'attribute25:' + rmanFmvRulesDefSearchObject.attribute25 + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute26 != undefined && rmanFmvRulesDefSearchObject.attribute26 != "") {
            searchString = searchString + 'attribute26:' + rmanFmvRulesDefSearchObject.attribute26 + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute27 != undefined && rmanFmvRulesDefSearchObject.attribute27 != "") {
            searchString = searchString + 'attribute27:' + rmanFmvRulesDefSearchObject.attribute27 + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute28 != undefined && rmanFmvRulesDefSearchObject.attribute28 != "") {
            searchString = searchString + 'attribute28:' + rmanFmvRulesDefSearchObject.attribute28 + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute29 != undefined && rmanFmvRulesDefSearchObject.attribute29 != "") {
            searchString = searchString + 'attribute29:' + rmanFmvRulesDefSearchObject.attribute29 + ',';
        }

        if (rmanFmvRulesDefSearchObject.attribute30 != undefined && rmanFmvRulesDefSearchObject.attribute30 != "") {
            searchString = searchString + 'attribute30:' + rmanFmvRulesDefSearchObject.attribute30 + ',';
        }

        if (rmanFmvRulesDefSearchObject.creationDate != undefined && rmanFmvRulesDefSearchObject.creationDate != "") {
            searchString = searchString + 'creationDate:' + rmanFmvRulesDefSearchObject.creationDate + ',';
        }

        if (rmanFmvRulesDefSearchObject.createdBy != undefined && rmanFmvRulesDefSearchObject.createdBy != "") {
            searchString = searchString + 'createdBy:' + rmanFmvRulesDefSearchObject.createdBy + ',';
        }

        if (rmanFmvRulesDefSearchObject.lastUpdateDate != undefined && rmanFmvRulesDefSearchObject.lastUpdateDate != "") {
            searchString = searchString + 'lastUpdateDate:' + rmanFmvRulesDefSearchObject.lastUpdateDate + ',';
        }

        if (rmanFmvRulesDefSearchObject.lastUpdatedBy != undefined && rmanFmvRulesDefSearchObject.lastUpdatedBy != "") {
            searchString = searchString + 'lastUpdatedBy:' + rmanFmvRulesDefSearchObject.lastUpdatedBy + ',';
        }

        if (rmanFmvRulesDefSearchObject.enabledFlag != undefined && rmanFmvRulesDefSearchObject.enabledFlag != "") {
            searchString = searchString + 'enabledFlag:' + rmanFmvRulesDefSearchObject.enabledFlag + ',';
        }

        if (rmanFmvRulesDefSearchObject.quarterName != undefined && rmanFmvRulesDefSearchObject.quarterName != "") {
            searchString = searchString + 'quarterName:' + rmanFmvRulesDefSearchObject.quarterName + ',';
        }

        if (rmanFmvRulesDefSearchObject.approverId != undefined && rmanFmvRulesDefSearchObject.approverId != "") {
            searchString = searchString + 'approverId:' + rmanFmvRulesDefSearchObject.approverId + ',';
        }

        if (rmanFmvRulesDefSearchObject.fmvCategory != undefined && rmanFmvRulesDefSearchObject.fmvCategory != "") {
            searchString = searchString + 'fmvCategory:' + rmanFmvRulesDefSearchObject.fmvCategory + ',';
        }

        if (rmanFmvRulesDefSearchObject.dealFlag != undefined && rmanFmvRulesDefSearchObject.dealFlag != "") {
            searchString = searchString + 'dealFlag:' + rmanFmvRulesDefSearchObject.dealFlag + ',';
        }

        if (rmanFmvRulesDefSearchObject.bookId != undefined && rmanFmvRulesDefSearchObject.bookId != "") {
            searchString = searchString + 'bookId:' + rmanFmvRulesDefSearchObject.bookId + ',';
        }


        if (rmanFmvRulesDefSearchObject.vsoe != undefined && rmanFmvRulesDefSearchObject.vsoe != "") {
            searchString = searchString + 'vsoe:' + rmanFmvRulesDefSearchObject.vsoe;
        }


        if (searchString == '') {
            serviceUrl = serviceUrl + 'search=%25' + '&sort=fmvRuleDefId,desc';
        }
        else {
            serviceUrl = serviceUrl + 'search=' + searchString + '&sort=fmvRuleDefId,desc';
        }



        if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != "" && !isNaN(paginationOptions.pageNumber)) {
            serviceUrl = serviceUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;
        }

        return serviceUrl;

    }

    getAllRmanFmvRulesDefDetails(paginationOptions: any, rmanFmvRulesDefSearchObject: any): Promise<any[]> {

        let serviceUrl = this.getAllRmanFmvRulesDef(paginationOptions, rmanFmvRulesDefSearchObject, 0);
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }




    saveRmanFmvRulesDef(rmanFmvRulesDef: any): Promise<any[]> {
        let body = JSON.stringify(rmanFmvRulesDef);
        return this.http.post<any[]>(appSettings.apiUrl + '/RMAN_FMV_RULES_DEF', body, httpOptions).toPromise().then(data => {
            return data;
        });
    }

    updateRmanFmvRulesDef(rmanFmvRulesDef: any): Promise<any[]> {

        delete rmanFmvRulesDef._links;
        delete rmanFmvRulesDef.interests;
        let body = JSON.stringify(rmanFmvRulesDef);
        return this.http.put<any[]>(appSettings.apiUrl + '/RMAN_FMV_RULES_DEF/' + rmanFmvRulesDef.fmvRuleDefId, body, httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanFmvRulesDef(rmanFmvRulesDef: any): Promise<any[]> {
        let deleteUrl = appSettings.apiUrl + '/RMAN_FMV_RULES_DEF/' + rmanFmvRulesDef.fmvRuleDefId;
        return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
            return data;
        });
    }
    checkFVExists(ruleName: any): Promise<any[]> {
        let checkFVUrl = appSettings.apiUrl + '/checkFVExists/?fmvRuleName=' + ruleName;
        return this.http.get(checkFVUrl, httpOptions).toPromise().then((data: any) => {
            return data;
        });
    }

    approveAllRmanRulesDef(bookId: any): Promise<any[]> {
        let serviceUrl = appSettings.apiUrl + '/sspbook/ssprules/approve?sspBookId=' +bookId;
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
       
    }


}
