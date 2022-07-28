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
export class RmanUserResponsibilitiesService {

  constructor(private http: HttpClient) { }

  getAllRmanUserResponsibilities(paginationOptions: any, rmanUserResponsibilitiesSearchObject: any): Promise<any[]> {
    let serviceUrl = appSettings.apiUrl + '/rmanUserResponsibilitiesSearch?';

    let searchString = '';

    if (rmanUserResponsibilitiesSearchObject.rmanUserId != undefined && rmanUserResponsibilitiesSearchObject.rmanUserId != "") {
      searchString = searchString + 'rmanUserId:' + rmanUserResponsibilitiesSearchObject.rmanUserId + ',';
    }

    if (rmanUserResponsibilitiesSearchObject.responsibilityId != undefined && rmanUserResponsibilitiesSearchObject.responsibilityId != "") {
      searchString = searchString + 'responsibilityId:' + rmanUserResponsibilitiesSearchObject.responsibilityId + ',';
    }

    if (rmanUserResponsibilitiesSearchObject.startDateActive != undefined && rmanUserResponsibilitiesSearchObject.startDateActive != "") {
      searchString = searchString + 'startDateActive:' + rmanUserResponsibilitiesSearchObject.startDateActive + ',';
    }

    if (rmanUserResponsibilitiesSearchObject.endDateActive != undefined && rmanUserResponsibilitiesSearchObject.endDateActive != "") {
      searchString = searchString + 'endDateActive:' + rmanUserResponsibilitiesSearchObject.endDateActive + ',';
    }

    if (rmanUserResponsibilitiesSearchObject.attribute1 != undefined && rmanUserResponsibilitiesSearchObject.attribute1 != "") {
      searchString = searchString + 'attribute1:' + rmanUserResponsibilitiesSearchObject.attribute1 + ',';
    }

    if (rmanUserResponsibilitiesSearchObject.attribute2 != undefined && rmanUserResponsibilitiesSearchObject.attribute2 != "") {
      searchString = searchString + 'attribute2:' + rmanUserResponsibilitiesSearchObject.attribute2 + ',';
    }

    if (rmanUserResponsibilitiesSearchObject.attribute3 != undefined && rmanUserResponsibilitiesSearchObject.attribute3 != "") {
      searchString = searchString + 'attribute3:' + rmanUserResponsibilitiesSearchObject.attribute3 + ',';
    }

    if (rmanUserResponsibilitiesSearchObject.attribute4 != undefined && rmanUserResponsibilitiesSearchObject.attribute4 != "") {
      searchString = searchString + 'attribute4:' + rmanUserResponsibilitiesSearchObject.attribute4 + ',';
    }

    if (rmanUserResponsibilitiesSearchObject.attribute5 != undefined && rmanUserResponsibilitiesSearchObject.attribute5 != "") {
      searchString = searchString + 'attribute5:' + rmanUserResponsibilitiesSearchObject.attribute5 + ',';
    }

    if (rmanUserResponsibilitiesSearchObject.creationDate != undefined && rmanUserResponsibilitiesSearchObject.creationDate != "") {
      searchString = searchString + 'creationDate:' + rmanUserResponsibilitiesSearchObject.creationDate + ',';
    }

    if (rmanUserResponsibilitiesSearchObject.createdBy != undefined && rmanUserResponsibilitiesSearchObject.createdBy != "") {
      searchString = searchString + 'createdBy:' + rmanUserResponsibilitiesSearchObject.createdBy + ',';
    }

    if (rmanUserResponsibilitiesSearchObject.lastUpdateDate != undefined && rmanUserResponsibilitiesSearchObject.lastUpdateDate != "") {
      searchString = searchString + 'lastUpdateDate:' + rmanUserResponsibilitiesSearchObject.lastUpdateDate + ',';
    }

    if (rmanUserResponsibilitiesSearchObject.lastUpdatedBy != undefined && rmanUserResponsibilitiesSearchObject.lastUpdatedBy != "") {
      searchString = searchString + 'lastUpdatedBy:' + rmanUserResponsibilitiesSearchObject.lastUpdatedBy + ',';
    }

    if (rmanUserResponsibilitiesSearchObject.seededFlag != undefined && rmanUserResponsibilitiesSearchObject.seededFlag != "") {
      searchString = searchString + 'seededFlag:' + rmanUserResponsibilitiesSearchObject.seededFlag;
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


  saveRmanUserResponsibilities(rmanUserResponsibilities: any): Promise<any[]> {
    let body = JSON.stringify(rmanUserResponsibilities);
    return this.http.post<any[]>(appSettings.apiUrl + '/RMAN_USER_RESPONSIBILITIES', body, httpOptions).toPromise().then(data => {
      return data;
    });
  }

  updateRmanUserResponsibilities(rmanUserResponsibilities: any): Promise<any[]> {

    delete rmanUserResponsibilities._links;
    delete rmanUserResponsibilities.interests;
    let body = JSON.stringify(rmanUserResponsibilities);
    return this.http.put<any[]>(appSettings.apiUrl + '/rmanUserResponsibilities/' + rmanUserResponsibilities.responsibilityId, body, httpOptions).toPromise().then(data => {
      return data;
    });

  }

  deleteRmanUserResponsibilities(rmanUserResponsibilities: any): Promise<any[]> {
    let deleteUrl = appSettings.apiUrl + '/rmanUserResponsibility';
    let Body = JSON.stringify(rmanUserResponsibilities);
    const options = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }),
      body: Body
    }

    return this.http.delete(deleteUrl, options).toPromise().then((data: any) => {
      return data;
    });
  }

}
