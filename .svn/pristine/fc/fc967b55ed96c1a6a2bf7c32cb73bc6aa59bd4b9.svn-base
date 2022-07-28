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
export class RmanEventsService {

  constructor(private http: HttpClient) { }

  getAllRmanEvents(paginationOptions: any, rmanEventsSearchObject: any) {
    let serviceUrl = appSettings.apiUrl + '/rmanEventsSearch?';

    let searchString = '';

    if (rmanEventsSearchObject.orderNumber != undefined && rmanEventsSearchObject.orderNumber != "") {
      searchString = searchString + 'orderNumber:' + rmanEventsSearchObject.orderNumber + ',';
    }

    if (rmanEventsSearchObject.orderLineId != undefined && rmanEventsSearchObject.orderLineId != "") {
      searchString = searchString + 'orderLineId:' + rmanEventsSearchObject.orderLineId + ',';
    }

    if (rmanEventsSearchObject.orderLineNo != undefined && rmanEventsSearchObject.orderLineNo != "") {
      searchString = searchString + 'orderLineNo:' + rmanEventsSearchObject.orderLineNo + ',';
    }

    if (rmanEventsSearchObject.transactionType != undefined && rmanEventsSearchObject.transactionType != "") {
      searchString = searchString + 'transactionType:' + rmanEventsSearchObject.transactionType + ',';
    }

    if (rmanEventsSearchObject.transactionSource != undefined && rmanEventsSearchObject.transactionSource != "") {
      searchString = searchString + 'transactionSource:' + rmanEventsSearchObject.transactionSource + ',';
    }

    if (rmanEventsSearchObject.eventName != undefined && rmanEventsSearchObject.eventName != "") {
      searchString = searchString + 'eventName:' + rmanEventsSearchObject.eventName + ',';
    }

    if (rmanEventsSearchObject.eventDate != undefined && rmanEventsSearchObject.eventDate != "") {
      searchString = searchString + 'eventDate:' + rmanEventsSearchObject.eventDate + ',';
    }

    if (rmanEventsSearchObject.createdBy != undefined && rmanEventsSearchObject.createdBy != "") {
      searchString = searchString + 'createdBy:' + rmanEventsSearchObject.createdBy + ',';
    }

    if (rmanEventsSearchObject.creationDate != undefined && rmanEventsSearchObject.creationDate != "") {
      searchString = searchString + 'creationDate:' + rmanEventsSearchObject.creationDate + ',';
    }

    if (rmanEventsSearchObject.lastUpdatedBy != undefined && rmanEventsSearchObject.lastUpdatedBy != "") {
      searchString = searchString + 'lastUpdatedBy:' + rmanEventsSearchObject.lastUpdatedBy + ',';
    }

    if (rmanEventsSearchObject.lastUpdateDate != undefined && rmanEventsSearchObject.lastUpdateDate != "") {
      searchString = searchString + 'lastUpdateDate:' + rmanEventsSearchObject.lastUpdateDate + ',';
    }

    if (rmanEventsSearchObject.lastUpdateLogin != undefined && rmanEventsSearchObject.lastUpdateLogin != "") {
      searchString = searchString + 'lastUpdateLogin:' + rmanEventsSearchObject.lastUpdateLogin + ',';
    }

    if (rmanEventsSearchObject.status != undefined && rmanEventsSearchObject.status != "") {
      searchString = searchString + 'status:' + rmanEventsSearchObject.status + ',';
    }

    if (rmanEventsSearchObject.errorMessage != undefined && rmanEventsSearchObject.errorMessage != "") {
      searchString = searchString + 'errorMessage:' + rmanEventsSearchObject.errorMessage;
    }



    if (searchString == '') {
      serviceUrl = serviceUrl + 'search=%25' + '&sort=eventDate,desc';
    }
    else {
      serviceUrl = serviceUrl + 'search=' + searchString + '&sort=eventDate,desc';
    }

    if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != "" && !isNaN(paginationOptions.pageNumber)) {
      serviceUrl = serviceUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;
    }

    return this.http.get(serviceUrl).toPromise().then((data: any) => {
      return data;
    });
  }



  saveRmanEvents(rmanEvents: any) {
    let body = JSON.stringify(rmanEvents);
    return this.http.post<any[]>(appSettings.apiUrl + '/RMAN_EVENTS', body, httpOptions).toPromise().then(data => {
      return data;
    });
  }

  updateRmanEvents(rmanEvents: any) {

    delete rmanEvents._links;
    delete rmanEvents.interests;
    let body = JSON.stringify(rmanEvents);
    return this.http.put<any[]>(appSettings.apiUrl + '/RMAN_EVENTS/' + rmanEvents.orderLineId, body, httpOptions).toPromise().then(data => {
      return data;
    });

  }

  deleteRmanEvents(rmanEvents: any) {
    let deleteUrl = appSettings.apiUrl + '/RMAN_EVENTS/' + rmanEvents.orderLineId;

    return this.http.delete(deleteUrl, httpOptions).toPromise().then(data => {
      return data;
    });
  }

  revRecogEvent(rmanEvents: any) {
    let revrecUrl = appSettings.apiUrl + '/revmantra/revrecognition/?orderLineId=' + rmanEvents.orderLineId;
    return this.http.get(revrecUrl, httpOptions).toPromise().then(data => {
      return data;
    });
  }


}
