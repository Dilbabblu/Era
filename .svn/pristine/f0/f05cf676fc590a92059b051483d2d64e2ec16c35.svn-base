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
export class RmanRuleParameterValueService {

    constructor(private http: HttpClient) { }

    getAllRmanRuleParameterValue(paginationOptions: any, rmanRuleParameterValueSearchObject: any): Promise<any[]> {

        let serviceUrl = appSettings.apiUrl + '/rmanRuleParameterValueSearch?';

        let searchString = '';

        if (rmanRuleParameterValueSearchObject.parameterValueId != undefined && rmanRuleParameterValueSearchObject.parameterValueId != "") {
            searchString = searchString + 'parameterValueId:' + rmanRuleParameterValueSearchObject.parameterValueId + ',';
        }

        if (rmanRuleParameterValueSearchObject.ruleHeaderId != undefined && rmanRuleParameterValueSearchObject.ruleHeaderId != "") {
            searchString = searchString + 'ruleHeaderId:' + rmanRuleParameterValueSearchObject.ruleHeaderId + ',';
        }

        if (rmanRuleParameterValueSearchObject.parameterId != undefined && rmanRuleParameterValueSearchObject.parameterId != "") {
            searchString = searchString + 'parameterId:' + rmanRuleParameterValueSearchObject.parameterId + ',';
        }

        if (rmanRuleParameterValueSearchObject.qualifier != undefined && rmanRuleParameterValueSearchObject.qualifier != "") {
            searchString = searchString + 'qualifier:' + rmanRuleParameterValueSearchObject.qualifier + ',';
        }

        if (rmanRuleParameterValueSearchObject.parameterValue != undefined && rmanRuleParameterValueSearchObject.parameterValue != "") {
            searchString = searchString + 'parameterValue:' + rmanRuleParameterValueSearchObject.parameterValue + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute1 != undefined && rmanRuleParameterValueSearchObject.attribute1 != "") {
            searchString = searchString + 'attribute1:' + rmanRuleParameterValueSearchObject.attribute1 + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute2 != undefined && rmanRuleParameterValueSearchObject.attribute2 != "") {
            searchString = searchString + 'attribute2:' + rmanRuleParameterValueSearchObject.attribute2 + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute3 != undefined && rmanRuleParameterValueSearchObject.attribute3 != "") {
            searchString = searchString + 'attribute3:' + rmanRuleParameterValueSearchObject.attribute3 + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute4 != undefined && rmanRuleParameterValueSearchObject.attribute4 != "") {
            searchString = searchString + 'attribute4:' + rmanRuleParameterValueSearchObject.attribute4 + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute5 != undefined && rmanRuleParameterValueSearchObject.attribute5 != "") {
            searchString = searchString + 'attribute5:' + rmanRuleParameterValueSearchObject.attribute5 + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute6 != undefined && rmanRuleParameterValueSearchObject.attribute6 != "") {
            searchString = searchString + 'attribute6:' + rmanRuleParameterValueSearchObject.attribute6 + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute7 != undefined && rmanRuleParameterValueSearchObject.attribute7 != "") {
            searchString = searchString + 'attribute7:' + rmanRuleParameterValueSearchObject.attribute7 + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute8 != undefined && rmanRuleParameterValueSearchObject.attribute8 != "") {
            searchString = searchString + 'attribute8:' + rmanRuleParameterValueSearchObject.attribute8 + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute9 != undefined && rmanRuleParameterValueSearchObject.attribute9 != "") {
            searchString = searchString + 'attribute9:' + rmanRuleParameterValueSearchObject.attribute9 + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute10 != undefined && rmanRuleParameterValueSearchObject.attribute10 != "") {
            searchString = searchString + 'attribute10:' + rmanRuleParameterValueSearchObject.attribute10 + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute11 != undefined && rmanRuleParameterValueSearchObject.attribute11 != "") {
            searchString = searchString + 'attribute11:' + rmanRuleParameterValueSearchObject.attribute11 + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute12 != undefined && rmanRuleParameterValueSearchObject.attribute12 != "") {
            searchString = searchString + 'attribute12:' + rmanRuleParameterValueSearchObject.attribute12 + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute13 != undefined && rmanRuleParameterValueSearchObject.attribute13 != "") {
            searchString = searchString + 'attribute13:' + rmanRuleParameterValueSearchObject.attribute13 + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute14 != undefined && rmanRuleParameterValueSearchObject.attribute14 != "") {
            searchString = searchString + 'attribute14:' + rmanRuleParameterValueSearchObject.attribute14 + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute15 != undefined && rmanRuleParameterValueSearchObject.attribute15 != "") {
            searchString = searchString + 'attribute15:' + rmanRuleParameterValueSearchObject.attribute15 + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute16 != undefined && rmanRuleParameterValueSearchObject.attribute16 != "") {
            searchString = searchString + 'attribute16:' + rmanRuleParameterValueSearchObject.attribute16 + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute17 != undefined && rmanRuleParameterValueSearchObject.attribute17 != "") {
            searchString = searchString + 'attribute17:' + rmanRuleParameterValueSearchObject.attribute17 + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute18 != undefined && rmanRuleParameterValueSearchObject.attribute18 != "") {
            searchString = searchString + 'attribute18:' + rmanRuleParameterValueSearchObject.attribute18 + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute19 != undefined && rmanRuleParameterValueSearchObject.attribute19 != "") {
            searchString = searchString + 'attribute19:' + rmanRuleParameterValueSearchObject.attribute19 + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute20 != undefined && rmanRuleParameterValueSearchObject.attribute20 != "") {
            searchString = searchString + 'attribute20:' + rmanRuleParameterValueSearchObject.attribute20 + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute21 != undefined && rmanRuleParameterValueSearchObject.attribute21 != "") {
            searchString = searchString + 'attribute21:' + rmanRuleParameterValueSearchObject.attribute21 + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute22 != undefined && rmanRuleParameterValueSearchObject.attribute22 != "") {
            searchString = searchString + 'attribute22:' + rmanRuleParameterValueSearchObject.attribute22 + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute23 != undefined && rmanRuleParameterValueSearchObject.attribute23 != "") {
            searchString = searchString + 'attribute23:' + rmanRuleParameterValueSearchObject.attribute23 + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute24 != undefined && rmanRuleParameterValueSearchObject.attribute24 != "") {
            searchString = searchString + 'attribute24:' + rmanRuleParameterValueSearchObject.attribute24 + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute25 != undefined && rmanRuleParameterValueSearchObject.attribute25 != "") {
            searchString = searchString + 'attribute25:' + rmanRuleParameterValueSearchObject.attribute25 + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute26 != undefined && rmanRuleParameterValueSearchObject.attribute26 != "") {
            searchString = searchString + 'attribute26:' + rmanRuleParameterValueSearchObject.attribute26 + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute27 != undefined && rmanRuleParameterValueSearchObject.attribute27 != "") {
            searchString = searchString + 'attribute27:' + rmanRuleParameterValueSearchObject.attribute27 + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute28 != undefined && rmanRuleParameterValueSearchObject.attribute28 != "") {
            searchString = searchString + 'attribute28:' + rmanRuleParameterValueSearchObject.attribute28 + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute29 != undefined && rmanRuleParameterValueSearchObject.attribute29 != "") {
            searchString = searchString + 'attribute29:' + rmanRuleParameterValueSearchObject.attribute29 + ',';
        }

        if (rmanRuleParameterValueSearchObject.attribute30 != undefined && rmanRuleParameterValueSearchObject.attribute30 != "") {
            searchString = searchString + 'attribute30:' + rmanRuleParameterValueSearchObject.attribute30 + ',';
        }

        if (rmanRuleParameterValueSearchObject.creationDate != undefined && rmanRuleParameterValueSearchObject.creationDate != "") {
            searchString = searchString + 'creationDate:' + rmanRuleParameterValueSearchObject.creationDate + ',';
        }

        if (rmanRuleParameterValueSearchObject.createdBy != undefined && rmanRuleParameterValueSearchObject.createdBy != "") {
            searchString = searchString + 'createdBy:' + rmanRuleParameterValueSearchObject.createdBy + ',';
        }

        if (rmanRuleParameterValueSearchObject.lastUpdateDate != undefined && rmanRuleParameterValueSearchObject.lastUpdateDate != "") {
            searchString = searchString + 'lastUpdateDate:' + rmanRuleParameterValueSearchObject.lastUpdateDate + ',';
        }

        if (rmanRuleParameterValueSearchObject.lastUpdatedBy != undefined && rmanRuleParameterValueSearchObject.lastUpdatedBy != "") {
            searchString = searchString + 'lastUpdatedBy:' + rmanRuleParameterValueSearchObject.lastUpdatedBy + ',';
        }

        if (rmanRuleParameterValueSearchObject.parameterGroup != undefined && rmanRuleParameterValueSearchObject.parameterGroup != "") {
            searchString = searchString + 'parameterGroup:' + rmanRuleParameterValueSearchObject.parameterGroup + ',';
        }

        if (rmanRuleParameterValueSearchObject.andOr != undefined && rmanRuleParameterValueSearchObject.andOr != "") {
            searchString = searchString + 'andOr:' + rmanRuleParameterValueSearchObject.andOr + ',';
        }

        if (rmanRuleParameterValueSearchObject.dealFlag != undefined && rmanRuleParameterValueSearchObject.dealFlag != "") {
            searchString = searchString + 'dealFlag:' + rmanRuleParameterValueSearchObject.dealFlag;
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

    searchRmanRuleParameterValue(rmanRuleParameterValue: any): Promise<any[]> {
        return this.http.get(appSettings.apiUrl + '/RMAN_RULE_PARAMETER_VALUE/search/findByParameterValueIdAndRuleHeaderIdAndParameterIdAndQualifierAndParameterValueAndAttribute1AndAttribute2AndAttribute3AndAttribute4AndAttribute5AndAttribute6AndAttribute7AndAttribute8AndAttribute9AndAttribute10AndAttribute11AndAttribute12AndAttribute13AndAttribute14AndAttribute15AndAttribute16AndAttribute17AndAttribute18AndAttribute19AndAttribute20AndAttribute21AndAttribute22AndAttribute23AndAttribute24AndAttribute25AndAttribute26AndAttribute27AndAttribute28AndAttribute29AndAttribute30AndCreationDateAndCreatedByAndLastUpdateDateAndLastUpdatedByAndParameterGroupAndAndOrAndDealFlag?parameterValueId=' + rmanRuleParameterValue.parameterValueId + '&ruleHeaderId=' + rmanRuleParameterValue.ruleHeaderId + '&parameterId=' + rmanRuleParameterValue.parameterId + '&qualifier=' + rmanRuleParameterValue.qualifier + '&parameterValue=' + rmanRuleParameterValue.parameterValue + '&attribute1=' + rmanRuleParameterValue.attribute1 + '&attribute2=' + rmanRuleParameterValue.attribute2 + '&attribute3=' + rmanRuleParameterValue.attribute3 + '&attribute4=' + rmanRuleParameterValue.attribute4 + '&attribute5=' + rmanRuleParameterValue.attribute5 + '&attribute6=' + rmanRuleParameterValue.attribute6 + '&attribute7=' + rmanRuleParameterValue.attribute7 + '&attribute8=' + rmanRuleParameterValue.attribute8 + '&attribute9=' + rmanRuleParameterValue.attribute9 + '&attribute10=' + rmanRuleParameterValue.attribute10 + '&attribute11=' + rmanRuleParameterValue.attribute11 + '&attribute12=' + rmanRuleParameterValue.attribute12 + '&attribute13=' + rmanRuleParameterValue.attribute13 + '&attribute14=' + rmanRuleParameterValue.attribute14 + '&attribute15=' + rmanRuleParameterValue.attribute15 + '&attribute16=' + rmanRuleParameterValue.attribute16 + '&attribute17=' + rmanRuleParameterValue.attribute17 + '&attribute18=' + rmanRuleParameterValue.attribute18 + '&attribute19=' + rmanRuleParameterValue.attribute19 + '&attribute20=' + rmanRuleParameterValue.attribute20 + '&attribute21=' + rmanRuleParameterValue.attribute21 + '&attribute22=' + rmanRuleParameterValue.attribute22 + '&attribute23=' + rmanRuleParameterValue.attribute23 + '&attribute24=' + rmanRuleParameterValue.attribute24 + '&attribute25=' + rmanRuleParameterValue.attribute25 + '&attribute26=' + rmanRuleParameterValue.attribute26 + '&attribute27=' + rmanRuleParameterValue.attribute27 + '&attribute28=' + rmanRuleParameterValue.attribute28 + '&attribute29=' + rmanRuleParameterValue.attribute29 + '&attribute30=' + rmanRuleParameterValue.attribute30 + '&creationDate=' + rmanRuleParameterValue.creationDate + '&createdBy=' + rmanRuleParameterValue.createdBy + '&lastUpdateDate=' + rmanRuleParameterValue.lastUpdateDate + '&lastUpdatedBy=' + rmanRuleParameterValue.lastUpdatedBy + '&parameterGroup=' + rmanRuleParameterValue.parameterGroup + '&andOr=' + rmanRuleParameterValue.andOr + '&dealFlag=' + rmanRuleParameterValue.dealFlag).toPromise().then((data: any) => {
            return data;
        });
    }

    saveRmanRuleParameterValue(rmanRuleParameterValue: any): Promise<any[]> {
        let body = JSON.stringify(rmanRuleParameterValue);
        return this.http.post(appSettings.apiUrl + '/RMAN_RULE_PARAMETER_VALUE', body, httpOptions).toPromise().then((data: any) => {
            return data;
        });
    }

    updateRmanRuleParameterValue(rmanRuleParameterValue: any): Promise<any[]> {

        delete rmanRuleParameterValue._links;
        delete rmanRuleParameterValue.interests;
        let body = JSON.stringify(rmanRuleParameterValue);
        return this.http.put(appSettings.apiUrl + '/RMAN_RULE_PARAMETER_VALUE/' + rmanRuleParameterValue.parameterValueId, body, httpOptions).toPromise().then((data: any) => {
            return data;
        });

    }

    deleteRmanRuleParameterValue(rmanRuleParameterValue: any): Promise<any[]> {
        let deleteUrl = appSettings.apiUrl + '/RMAN_RULE_PARAMETER_VALUE/' + rmanRuleParameterValue.parameterValueId;
        return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
            return data;
        });
    }

}
