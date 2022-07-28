import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { DatePipe } from '@angular/common';


declare var require: any;
const appSettings = require('../../appsettings');

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  })
};

@Injectable()
export class GenerateSSPService {

  constructor(private http: HttpClient, private datePipe: DatePipe) {

  }
  // sspBookId, sspType,calculateSsp, min, max, amountType, bsiDate, sourceFrom, sourceTo, targetFrom,targetTo, sspGrule, rmanUserId
  generateSSP(sspBookId: any, sspType: any, calculateSsp: any, min: any, max: any, amountType: any, bsiDate: any, sourceFrom: any, sourceTo: any, targetFrom: any, targetTo: any, sspGrule: any, rmanUserId: any) {
    sourceFrom = this.datePipe.transform(sourceFrom, 'yyyy-MM-dd hh:mm:ss');
    sourceTo = this.datePipe.transform(sourceTo, 'yyyy-MM-dd hh:mm:ss');
    targetFrom = this.datePipe.transform(targetFrom, 'yyyy-MM-dd hh:mm:ss');
    targetTo = this.datePipe.transform(targetTo, 'yyyy-MM-dd hh:mm:ss');

    let generateSSPUrl = appSettings.apiUrl + '/revmantra/generateSSP?bookId=' + sspBookId + '&sspType=' + sspType + '&sspCalc=' + calculateSsp + '&amount=' + amountType + '&date=' + bsiDate + '&srcFrom=' + sourceFrom + '&srcTo=' + sourceTo + '&targetFrom=' + targetFrom + '&targetTo=' + targetTo + '&ruleName=' + sspGrule + '&rmanUserId=' + rmanUserId;
    if (min != undefined && min != "") {
      generateSSPUrl = generateSSPUrl + '&fromRange=' + min;
    }
    if (max != undefined && max != "") {
      generateSSPUrl = generateSSPUrl + '&toRange=' + max;
    }
    return this.http.get(generateSSPUrl).toPromise().then(data => {
      return data;
    });
  }

}
