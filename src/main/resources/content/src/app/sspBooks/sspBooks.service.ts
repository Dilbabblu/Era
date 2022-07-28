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
export class SspBooksService {

  constructor(private http: HttpClient) { }

  getAllSspBooks(paginationOptions: any, sspBooksSearchObject: any): Promise<any[]> {
    let serviceUrl = appSettings.apiUrl + '/sspBooksSearch?';

    let searchString = '';

    if (sspBooksSearchObject.bookId != undefined && sspBooksSearchObject.bookId != "") {
      searchString = searchString + 'bookId:' + sspBooksSearchObject.bookId + ',';
    }

    if (sspBooksSearchObject.bookName != undefined && sspBooksSearchObject.bookName != "") {
      searchString = searchString + 'bookName:' + sspBooksSearchObject.bookName + ',';
    }

    if (sspBooksSearchObject.startDate != undefined && sspBooksSearchObject.startDate != "") {
      searchString = searchString + 'startDate:' + sspBooksSearchObject.startDate + ',';
    }

    if (sspBooksSearchObject.endDate != undefined && sspBooksSearchObject.endDate != "") {
      searchString = searchString + 'endDate:' + sspBooksSearchObject.endDate + ',';
    }

    if (sspBooksSearchObject.status != undefined && sspBooksSearchObject.status != "") {
      searchString = searchString + 'status:' + sspBooksSearchObject.status + ',';
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

saveSspBook(sspBook: any): Promise<any[]> {
    let body = JSON.stringify(sspBook);
    return this.http.post<any[]>(appSettings.apiUrl + '/AYARA_SSP_BOOKS', body, httpOptions).toPromise().then(data => {
        return data;
    });
}

updateSspBook(sspBook: any): Promise<any[]> {

    delete sspBook._links;
    delete sspBook.interests;
    let body = JSON.stringify(sspBook);
    return this.http.put<any[]>(appSettings.apiUrl + '/AYARA_SSP_BOOKS/' + sspBook.bookId, body, httpOptions).toPromise().then(data => {
        return data;
    });

}

deleteSspBook(sspBook: any): Promise<any[]> {
    let deleteUrl = appSettings.apiUrl + '/AYARA_SSP_BOOKS/' + sspBook.bookId;
    return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
        return data;
    });
}
}
