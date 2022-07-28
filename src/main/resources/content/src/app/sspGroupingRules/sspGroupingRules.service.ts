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
export class SspGroupingRulesService {

  constructor(private http: HttpClient) { }

  getAllSspGroupingRules(paginationOptions: any, sspGroupingRulesSearchObject: any, fetchAll:any): Promise<any[]> {
    let serviceUrl = appSettings.apiUrl + '/sspGroupingRulesSearch?';

    let searchString = '';

    if(fetchAll === true){
      serviceUrl = serviceUrl + 'fetchAll=true&';
    }

    if (sspGroupingRulesSearchObject.groupId != undefined && sspGroupingRulesSearchObject.groupId != "") {
      searchString = searchString + 'groupId:' + sspGroupingRulesSearchObject.groupId + ',';
    }

    if (sspGroupingRulesSearchObject.ruleName != undefined && sspGroupingRulesSearchObject.ruleName != "") {
      searchString = searchString + 'ruleName:' + sspGroupingRulesSearchObject.ruleName + ',';
    }

    if (sspGroupingRulesSearchObject.startDate != undefined && sspGroupingRulesSearchObject.startDate != "") {
      searchString = searchString + 'startDate:' + sspGroupingRulesSearchObject.startDate + ',';
    }

    if (sspGroupingRulesSearchObject.endDate != undefined && sspGroupingRulesSearchObject.endDate != "") {
      searchString = searchString + 'endDate:' + sspGroupingRulesSearchObject.endDate + ',';
    }

    if (sspGroupingRulesSearchObject.enabledFlag != undefined && sspGroupingRulesSearchObject.enabledFlag != "") {
      searchString = searchString + 'enabledFlag:' + sspGroupingRulesSearchObject.enabledFlag + ',';
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

  saveSspGroupingRule(sspGroupingRule: any): Promise<any[]> {
    let body = JSON.stringify(sspGroupingRule);
    return this.http.post<any[]>(appSettings.apiUrl + '/AYARA_SSP_GROUPING_RULES', body, httpOptions).toPromise().then(data => {
      return data;
    });
  }

  updateSspGroupingRule(sspGroupingRule: any): Promise<any[]> {

    delete sspGroupingRule._links;
    delete sspGroupingRule.interests;
    let body = JSON.stringify(sspGroupingRule);
    return this.http.put<any[]>(appSettings.apiUrl + '/AYARA_SSP_GROUPING_RULES/' + sspGroupingRule.groupId, body, httpOptions).toPromise().then(data => {
      return data;
    });

  }

  deleteSspGroupingRule(sspGroupingRule: any): Promise<any[]> {
    let deleteUrl = appSettings.apiUrl + '/AYARA_SSP_GROUPING_RULES/' + sspGroupingRule.groupId;
    return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
        return data;
    });
}
}
