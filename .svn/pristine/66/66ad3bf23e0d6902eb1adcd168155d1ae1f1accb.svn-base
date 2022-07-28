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
export class RmanUsersService {

  constructor(private http: HttpClient) { }

  getAllRmanUsers(paginationOptions: any, rmanUsersSearchObject: any, fetchAll:any): Promise<any[]> {
    let serviceUrl = appSettings.apiUrl + '/rmanUsersSearch?';

    if(fetchAll === true){
      serviceUrl = serviceUrl + 'fetchAll=true&';
    }
    

    let searchString = '';

    if (rmanUsersSearchObject.rmanUserId != undefined && rmanUsersSearchObject.rmanUserId != "") {
      searchString = searchString + 'rmanUserId:' + rmanUsersSearchObject.rmanUserId + ',';
    }

    if (rmanUsersSearchObject.userPassword != undefined && rmanUsersSearchObject.userPassword != "") {
      searchString = searchString + 'userPassword:' + rmanUsersSearchObject.userPassword + ',';
    }

    if (rmanUsersSearchObject.userName != undefined && rmanUsersSearchObject.userName != "") {
      searchString = searchString + 'userName:' + rmanUsersSearchObject.userName + ',';
    }

    if (rmanUsersSearchObject.firstName != undefined && rmanUsersSearchObject.firstName != "") {
      searchString = searchString + 'firstName:' + rmanUsersSearchObject.firstName + ',';
    }

    if (rmanUsersSearchObject.lastName != undefined && rmanUsersSearchObject.lastName != "") {
      searchString = searchString + 'lastName:' + rmanUsersSearchObject.lastName + ',';
    }

    if (rmanUsersSearchObject.fullName != undefined && rmanUsersSearchObject.fullName != "") {
      searchString = searchString + 'fullName:' + rmanUsersSearchObject.fullName + ',';
    }

    if (rmanUsersSearchObject.homePhone != undefined && rmanUsersSearchObject.homePhone != "") {
      searchString = searchString + 'homePhone:' + rmanUsersSearchObject.homePhone + ',';
    }

    if (rmanUsersSearchObject.workPhone != undefined && rmanUsersSearchObject.workPhone != "") {
      searchString = searchString + 'workPhone:' + rmanUsersSearchObject.workPhone + ',';
    }

    if (rmanUsersSearchObject.cellPhone != undefined && rmanUsersSearchObject.cellPhone != "") {
      searchString = searchString + 'cellPhone:' + rmanUsersSearchObject.cellPhone + ',';
    }

    if (rmanUsersSearchObject.emailAddress != undefined && rmanUsersSearchObject.emailAddress != "") {
      searchString = searchString + 'emailAddress:' + rmanUsersSearchObject.emailAddress + ',';
    }

    if (rmanUsersSearchObject.rmanEmployeeId != undefined && rmanUsersSearchObject.rmanEmployeeId != "") {
      searchString = searchString + 'rmanEmployeeId:' + rmanUsersSearchObject.rmanEmployeeId + ',';
    }

    if (rmanUsersSearchObject.startDateActive != undefined && rmanUsersSearchObject.startDateActive != "") {
      searchString = searchString + 'startDateActive:' + rmanUsersSearchObject.startDateActive + ',';
    }

    if (rmanUsersSearchObject.endDateActive != undefined && rmanUsersSearchObject.endDateActive != "") {
      searchString = searchString + 'endDateActive:' + rmanUsersSearchObject.endDateActive + ',';
    }

    if (rmanUsersSearchObject.attribute1 != undefined && rmanUsersSearchObject.attribute1 != "") {
      searchString = searchString + 'attribute1:' + rmanUsersSearchObject.attribute1 + ',';
    }

    if (rmanUsersSearchObject.attribute2 != undefined && rmanUsersSearchObject.attribute2 != "") {
      searchString = searchString + 'attribute2:' + rmanUsersSearchObject.attribute2 + ',';
    }

    if (rmanUsersSearchObject.attribute3 != undefined && rmanUsersSearchObject.attribute3 != "") {
      searchString = searchString + 'attribute3:' + rmanUsersSearchObject.attribute3 + ',';
    }

    if (rmanUsersSearchObject.attribute4 != undefined && rmanUsersSearchObject.attribute4 != "") {
      searchString = searchString + 'attribute4:' + rmanUsersSearchObject.attribute4 + ',';
    }

    if (rmanUsersSearchObject.attribute5 != undefined && rmanUsersSearchObject.attribute5 != "") {
      searchString = searchString + 'attribute5:' + rmanUsersSearchObject.attribute5 + ',';
    }

    if (rmanUsersSearchObject.creationDate != undefined && rmanUsersSearchObject.creationDate != "") {
      searchString = searchString + 'creationDate:' + rmanUsersSearchObject.creationDate + ',';
    }

    if (rmanUsersSearchObject.createdBy != undefined && rmanUsersSearchObject.createdBy != "") {
      searchString = searchString + 'createdBy:' + rmanUsersSearchObject.createdBy + ',';
    }

    if (rmanUsersSearchObject.lastUpdateDate != undefined && rmanUsersSearchObject.lastUpdateDate != "") {
      searchString = searchString + 'lastUpdateDate:' + rmanUsersSearchObject.lastUpdateDate + ',';
    }

    if (rmanUsersSearchObject.lastUpdatedBy != undefined && rmanUsersSearchObject.lastUpdatedBy != "") {
      searchString = searchString + 'lastUpdatedBy:' + rmanUsersSearchObject.lastUpdatedBy + ',';
    }

    if (rmanUsersSearchObject.mgrId != undefined && rmanUsersSearchObject.mgrId != "") {
      searchString = searchString + 'mgrId:' + rmanUsersSearchObject.mgrId;
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

  getUsersInfo(): Promise<any> {
    return this.http.get(appSettings.apiUrl + '/loggedUserInfo').toPromise().then((result: any) => {
      return result;
    });
  }



  saveRmanUsers(rmanUsers: any): Promise<any[]> {
    let body = JSON.stringify(rmanUsers);
    return this.http.post<any[]>(appSettings.apiUrl + '/saveUserInfo', body, httpOptions).toPromise().then(data => {
      return data;
    });
  }

  updateRmanUsers(rmanUsers: any): Promise<any[]> {

    delete rmanUsers._links;
    delete rmanUsers.interests;
    let body = JSON.stringify(rmanUsers);
    return this.http.post<any[]>(appSettings.apiUrl + '/saveUserInfo', body, httpOptions).toPromise().then(data => {
      return data;
    });

  }

  deleteRmanUsers(rmanUsers: any): Promise<any[]> {
    let deleteUrl = appSettings.apiUrl + '/RMAN_USERS/' + rmanUsers.rmanUserId;
    return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
      return data;
    });
  }

}
