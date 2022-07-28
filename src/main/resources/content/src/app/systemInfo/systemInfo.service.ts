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
export class SystemInfoService {

  constructor(private http: HttpClient) { }

  getAllReleaseLogs(paginationOptions: any, releaseLogsSearchObject: any): Promise<any[]> {

    let serviceUrl = appSettings.apiUrl + '/ayaraReleaseLogTblSearch?';

    let searchString = '';

    if (releaseLogsSearchObject.firmwareVersion != undefined && releaseLogsSearchObject.firmwareVersion != "") {
      searchString = searchString + 'firmwareVersion:' + releaseLogsSearchObject.firmwareVersion + ',';
    }

    if (releaseLogsSearchObject.creationDate != undefined && releaseLogsSearchObject.creationDate != "") {
      searchString = searchString + 'creationDate:' + releaseLogsSearchObject.creationDate + ',';
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

  saveReleaseLog(releaseLog: any): Promise<any[]> {
    let body = JSON.stringify(releaseLog);
    return this.http.post<any[]>(appSettings.apiUrl + '/AYARA_RELEASE_LOG_TBL', body, httpOptions).toPromise().then(data => {
        return data;
    });
  }

  updateReleaseLog(releaseLog: any): Promise<any[]> {
    delete releaseLog._links;
    delete releaseLog.interests;
    let body = JSON.stringify(releaseLog);
    return this.http.put<any[]>(appSettings.apiUrl + '/AYARA_RELEASE_LOG_TBL/' + releaseLog.firmwareVersion, body, httpOptions).toPromise().then(data => {
        return data;
    });
  }

  deleteReleaseLog(releaseLog: any): Promise<any[]> {
    let deleteUrl = appSettings.apiUrl + '/AYARA_RELEASE_LOG_TBL/' + releaseLog.firmwareVersion;
    return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
        return data;
    });
  }
}
