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
export class RmanFmvRulesDefParaValueService {

    constructor(private http: HttpClient) { }

    getAllRmanFmvRulesDefParaValue(paginationOptions: any, rmanFmvRulesDefParaValueSearchObject: any): Promise<any[]> {
        let serviceUrl = appSettings.apiUrl + '/rmanFmvRulesDefParaValueSearch?';

        let searchString = '';

        if (rmanFmvRulesDefParaValueSearchObject.parameterValueId != undefined && rmanFmvRulesDefParaValueSearchObject.parameterValueId != "") {
            searchString = searchString + 'parameterValueId:' + rmanFmvRulesDefParaValueSearchObject.parameterValueId + ',';
        }

        if (rmanFmvRulesDefParaValueSearchObject.fmvRuleDefId != undefined && rmanFmvRulesDefParaValueSearchObject.fmvRuleDefId != "") {
            searchString = searchString + 'fmvRuleDefId:' + rmanFmvRulesDefParaValueSearchObject.fmvRuleDefId + ',';
        }

        if (rmanFmvRulesDefParaValueSearchObject.parameterId != undefined && rmanFmvRulesDefParaValueSearchObject.parameterId != "") {
            searchString = searchString + 'parameterId:' + rmanFmvRulesDefParaValueSearchObject.parameterId + ',';
        }

        if (rmanFmvRulesDefParaValueSearchObject.qualifier != undefined && rmanFmvRulesDefParaValueSearchObject.qualifier != "") {
            searchString = searchString + 'qualifier:' + rmanFmvRulesDefParaValueSearchObject.qualifier + ',';
        }

        if (rmanFmvRulesDefParaValueSearchObject.parameterValue != undefined && rmanFmvRulesDefParaValueSearchObject.parameterValue != "") {
            searchString = searchString + 'parameterValue:' + rmanFmvRulesDefParaValueSearchObject.parameterValue + ',';
        }

        if (rmanFmvRulesDefParaValueSearchObject.attribute1 != undefined && rmanFmvRulesDefParaValueSearchObject.attribute1 != "") {
            searchString = searchString + 'attribute1:' + rmanFmvRulesDefParaValueSearchObject.attribute1 + ',';
        }

        if (rmanFmvRulesDefParaValueSearchObject.attribute2 != undefined && rmanFmvRulesDefParaValueSearchObject.attribute2 != "") {
            searchString = searchString + 'attribute2:' + rmanFmvRulesDefParaValueSearchObject.attribute2 + ',';
        }

        if (rmanFmvRulesDefParaValueSearchObject.attribute3 != undefined && rmanFmvRulesDefParaValueSearchObject.attribute3 != "") {
            searchString = searchString + 'attribute3:' + rmanFmvRulesDefParaValueSearchObject.attribute3 + ',';
        }

        if (rmanFmvRulesDefParaValueSearchObject.attribute4 != undefined && rmanFmvRulesDefParaValueSearchObject.attribute4 != "") {
            searchString = searchString + 'attribute4:' + rmanFmvRulesDefParaValueSearchObject.attribute4 + ',';
        }

        if (rmanFmvRulesDefParaValueSearchObject.attribute5 != undefined && rmanFmvRulesDefParaValueSearchObject.attribute5 != "") {
            searchString = searchString + 'attribute5:' + rmanFmvRulesDefParaValueSearchObject.attribute5 + ',';
        }

        if (rmanFmvRulesDefParaValueSearchObject.attribute6 != undefined && rmanFmvRulesDefParaValueSearchObject.attribute6 != "") {
            searchString = searchString + 'attribute6:' + rmanFmvRulesDefParaValueSearchObject.attribute6 + ',';
        }

        if (rmanFmvRulesDefParaValueSearchObject.attribute7 != undefined && rmanFmvRulesDefParaValueSearchObject.attribute7 != "") {
            searchString = searchString + 'attribute7:' + rmanFmvRulesDefParaValueSearchObject.attribute7 + ',';
        }

        if (rmanFmvRulesDefParaValueSearchObject.attribute8 != undefined && rmanFmvRulesDefParaValueSearchObject.attribute8 != "") {
            searchString = searchString + 'attribute8:' + rmanFmvRulesDefParaValueSearchObject.attribute8 + ',';
        }

        if (rmanFmvRulesDefParaValueSearchObject.attribute9 != undefined && rmanFmvRulesDefParaValueSearchObject.attribute9 != "") {
            searchString = searchString + 'attribute9:' + rmanFmvRulesDefParaValueSearchObject.attribute9 + ',';
        }

        if (rmanFmvRulesDefParaValueSearchObject.attribute10 != undefined && rmanFmvRulesDefParaValueSearchObject.attribute10 != "") {
            searchString = searchString + 'attribute10:' + rmanFmvRulesDefParaValueSearchObject.attribute10 + ',';
        }

        if (rmanFmvRulesDefParaValueSearchObject.attribute11 != undefined && rmanFmvRulesDefParaValueSearchObject.attribute11 != "") {
            searchString = searchString + 'attribute11:' + rmanFmvRulesDefParaValueSearchObject.attribute11 + ',';
        }

        if (rmanFmvRulesDefParaValueSearchObject.attribute12 != undefined && rmanFmvRulesDefParaValueSearchObject.attribute12 != "") {
            searchString = searchString + 'attribute12:' + rmanFmvRulesDefParaValueSearchObject.attribute12 + ',';
        }

        if (rmanFmvRulesDefParaValueSearchObject.attribute13 != undefined && rmanFmvRulesDefParaValueSearchObject.attribute13 != "") {
            searchString = searchString + 'attribute13:' + rmanFmvRulesDefParaValueSearchObject.attribute13 + ',';
        }

        if (rmanFmvRulesDefParaValueSearchObject.attribute14 != undefined && rmanFmvRulesDefParaValueSearchObject.attribute14 != "") {
            searchString = searchString + 'attribute14:' + rmanFmvRulesDefParaValueSearchObject.attribute14 + ',';
        }

        if (rmanFmvRulesDefParaValueSearchObject.attribute15 != undefined && rmanFmvRulesDefParaValueSearchObject.attribute15 != "") {
            searchString = searchString + 'attribute15:' + rmanFmvRulesDefParaValueSearchObject.attribute15 + ',';
        }

        if (rmanFmvRulesDefParaValueSearchObject.creationDate != undefined && rmanFmvRulesDefParaValueSearchObject.creationDate != "") {
            searchString = searchString + 'creationDate:' + rmanFmvRulesDefParaValueSearchObject.creationDate + ',';
        }

        if (rmanFmvRulesDefParaValueSearchObject.createdBy != undefined && rmanFmvRulesDefParaValueSearchObject.createdBy != "") {
            searchString = searchString + 'createdBy:' + rmanFmvRulesDefParaValueSearchObject.createdBy + ',';
        }

        if (rmanFmvRulesDefParaValueSearchObject.lastUpdateDate != undefined && rmanFmvRulesDefParaValueSearchObject.lastUpdateDate != "") {
            searchString = searchString + 'lastUpdateDate:' + rmanFmvRulesDefParaValueSearchObject.lastUpdateDate + ',';
        }

        if (rmanFmvRulesDefParaValueSearchObject.lastUpdatedBy != undefined && rmanFmvRulesDefParaValueSearchObject.lastUpdatedBy != "") {
            searchString = searchString + 'lastUpdatedBy:' + rmanFmvRulesDefParaValueSearchObject.lastUpdatedBy + ',';
        }

        if (rmanFmvRulesDefParaValueSearchObject.parameterGroup != undefined && rmanFmvRulesDefParaValueSearchObject.parameterGroup != "") {
            searchString = searchString + 'parameterGroup:' + rmanFmvRulesDefParaValueSearchObject.parameterGroup + ',';
        }

        if (rmanFmvRulesDefParaValueSearchObject.andOr != undefined && rmanFmvRulesDefParaValueSearchObject.andOr != "") {
            searchString = searchString + 'andOr:' + rmanFmvRulesDefParaValueSearchObject.andOr + ',';
        }

        if (rmanFmvRulesDefParaValueSearchObject.ruleHeaderId != undefined && rmanFmvRulesDefParaValueSearchObject.ruleHeaderId != "") {
            searchString = searchString + 'ruleHeaderId:' + rmanFmvRulesDefParaValueSearchObject.ruleHeaderId + ',';
        }

        if (rmanFmvRulesDefParaValueSearchObject.dealFlag != undefined && rmanFmvRulesDefParaValueSearchObject.dealFlag != "") {
            searchString = searchString + 'dealFlag:' + rmanFmvRulesDefParaValueSearchObject.dealFlag;
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


    saveRmanFmvRulesDefParaValue(rmanFmvRulesDefParaValue: any): Promise<any[]> {
        let body = JSON.stringify(rmanFmvRulesDefParaValue);
        return this.http.post<any[]>(appSettings.apiUrl + '/RMAN_FMV_RULES_DEF_PARA_VALUE', body, httpOptions).toPromise().then(data => {
            return data;
        });
    }

    updateRmanFmvRulesDefParaValue(rmanFmvRulesDefParaValue: any): Promise<any[]> {

        delete rmanFmvRulesDefParaValue._links;
        delete rmanFmvRulesDefParaValue.interests;
        let body = JSON.stringify(rmanFmvRulesDefParaValue);
        return this.http.put<any[]>(appSettings.apiUrl + '/RMAN_FMV_RULES_DEF_PARA_VALUE/' + rmanFmvRulesDefParaValue.parameterValueId, body, httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanFmvRulesDefParaValue(rmanFmvRulesDefParaValue: any): Promise<any[]> {
        let deleteUrl = appSettings.apiUrl + '/RMAN_FMV_RULES_DEF_PARA_VALUE/' + rmanFmvRulesDefParaValue.parameterValueId;
        return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
            return data;
        });
    }

}
