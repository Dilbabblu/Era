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
export class RmanPermissionsService {

  constructor(private http: HttpClient) { }

  getAllPermissionFunctions(paginationOptions: any, rmanPermissionFunctionSearch: any): Promise<any[]> {

    let serviceUrl = appSettings.apiUrl + '/rmanRoleFunctionsSearch?';

    let searchString = '';

    if (rmanPermissionFunctionSearch.roleid != undefined && rmanPermissionFunctionSearch.roleid != "") {
      searchString = searchString + 'roleid:' + rmanPermissionFunctionSearch.roleid;
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

  getAllRmanFunctions(paginationOptions: any, ): Promise<any[]> {
    let serviceUrl = appSettings.apiUrl + '/rmanFunctionsSearch?';
    let searchString = 'enabledFlag:Y';

    if (searchString == '') {
      serviceUrl = serviceUrl + 'search=%25';
    }
    else {
      serviceUrl = serviceUrl + 'search=' + searchString;
    }

    serviceUrl = serviceUrl + '&allVals=true';

    if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != "" && !isNaN(paginationOptions.pageNumber) && paginationOptions.pageNumber != 0) {
      serviceUrl = serviceUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;
    }
    return this.http.get(serviceUrl).toPromise().then((data: any) => {
      return data;
    });
  }

  saveRmanPermissions(rmanPermissions: any): Promise<any[]> {
    let body = JSON.stringify(rmanPermissions);
    return this.http.post<any[]>(appSettings.apiUrl + '/RMAN_ROLE_FUNCTIONS', body, httpOptions).toPromise().then(data => {
      return data;
    });
  }

  updateRmanPermissions(rmanPermissions: any): Promise<any[]> {
    let body = JSON.stringify(rmanPermissions);
    return this.http.put<any[]>(appSettings.apiUrl + '/RMAN_ROLE_FUNCTIONS/' + rmanPermissions.rfid, body, httpOptions).toPromise().then(data => {
      return data;
    });
  }

  deleteRmanPermissions(rmanPermissions: any): Promise<Object> {
    let deleteUrl = appSettings.apiUrl + '/RMAN_ROLE_FUNCTIONS/' + rmanPermissions.rfid;
    return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
      return data;
    });
  }

}
