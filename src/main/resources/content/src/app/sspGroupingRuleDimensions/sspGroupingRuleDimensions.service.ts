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
export class SspGroupingRuleDimensionsService {

  constructor(private http: HttpClient) { }

  getAllSspGroupingRuleDimensions(paginationOptions: any, dimensionSearchObj: any): Promise<any[]> {
    let serviceUrl = appSettings.apiUrl + '/sspGroupingRuleDimensionsSearch?';

    let searchString = '';

    if (dimensionSearchObj.dimensionId != undefined && dimensionSearchObj.dimensionId != "") {
        searchString = searchString + 'dimensionId:' + dimensionSearchObj.dimensionId + ',';
    }

    if (dimensionSearchObj.dimensionName != undefined && dimensionSearchObj.dimensionName != "") {
        searchString = searchString + 'dimensionName:' + dimensionSearchObj.dimensionName + ',';
    }

    if (dimensionSearchObj.andOr != undefined && dimensionSearchObj.andOr != "") {
        searchString = searchString + 'andOr:' + dimensionSearchObj.andOr + ',';
    }

    if (dimensionSearchObj.groupId != undefined && dimensionSearchObj.groupId != "") {
        searchString = searchString + 'groupId:' + dimensionSearchObj.groupId + ',';
    }

    if (dimensionSearchObj.attribute1 != undefined && dimensionSearchObj.attribute1 != "") {
        searchString = searchString + 'attribute1:' + dimensionSearchObj.attribute1 + ',';
    }

    if (dimensionSearchObj.attribute2 != undefined && dimensionSearchObj.attribute2 != "") {
        searchString = searchString + 'attribute2:' + dimensionSearchObj.attribute2 + ',';
    }

    if (dimensionSearchObj.attribute3 != undefined && dimensionSearchObj.attribute3 != "") {
        searchString = searchString + 'attribute3:' + dimensionSearchObj.attribute3 + ',';
    }

    if (dimensionSearchObj.attribute4 != undefined && dimensionSearchObj.attribute4 != "") {
        searchString = searchString + 'attribute4:' + dimensionSearchObj.attribute4 + ',';
    }

    if (dimensionSearchObj.attribute5 != undefined && dimensionSearchObj.attribute5 != "") {
        searchString = searchString + 'attribute5:' + dimensionSearchObj.attribute5 ;
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

saveDimensions(dimensionObj: any): Promise<any[]> {
  let body = JSON.stringify(dimensionObj);
  return this.http.post<any[]>(appSettings.apiUrl + '/AYARA_SSP_GROUPING_RULE_DIMENSIONS', body, httpOptions).toPromise().then(data => {
      return data;
  });
}

updateDimensions(dimensionObj: any): Promise<any[]> {

  delete dimensionObj._links;
  delete dimensionObj.interests;
  let body = JSON.stringify(dimensionObj);
  return this.http.put<any[]>(appSettings.apiUrl + '/AYARA_SSP_GROUPING_RULE_DIMENSIONS/' + dimensionObj.dimensionId, body, httpOptions).toPromise().then(data => {
      return data;
  });

}

deleteDimensions(dimensionObj: any): Promise<any[]> {
  let deleteUrl = appSettings.apiUrl + '/AYARA_SSP_GROUPING_RULE_DIMENSIONS/' + dimensionObj.dimensionId;
  return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
      return data;
  });
}


}
