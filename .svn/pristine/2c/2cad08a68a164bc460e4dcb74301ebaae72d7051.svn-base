import { DatePipe } from '@angular/common';
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
export class RmanForecastingDetailsService {

  constructor(private http: HttpClient, private datePipe: DatePipe) { }

  getServiceUrl(paginationOptions: any, rmanForecastingDetailsSearchObject: any, exportFlag: any) {

    let serviceUrl = appSettings.apiUrl + '/rmanForecastingDetailsExport?';

    if (exportFlag == 0) {
      serviceUrl = appSettings.apiUrl + '/rmanForecastingDetailsSearch?';
    }
    let searchString = '';


    if (rmanForecastingDetailsSearchObject.key != undefined && rmanForecastingDetailsSearchObject.key != "") {
      searchString = searchString + 'key:' + rmanForecastingDetailsSearchObject.key + ',';
    }

    if (rmanForecastingDetailsSearchObject.arrangementId != undefined && rmanForecastingDetailsSearchObject.arrangementId != "") {
      searchString = searchString + 'arrangementId:' + rmanForecastingDetailsSearchObject.arrangementId + ',';
    }

    if (rmanForecastingDetailsSearchObject.arrangementName != undefined && rmanForecastingDetailsSearchObject.arrangementName != "") {
      searchString = searchString + 'arrangementName:' + rmanForecastingDetailsSearchObject.arrangementName + ',';
    }

    if (rmanForecastingDetailsSearchObject.customerName != undefined && rmanForecastingDetailsSearchObject.customerName != "") {
      searchString = searchString + 'customerName:' + rmanForecastingDetailsSearchObject.customerName + ',';
    }

    if (rmanForecastingDetailsSearchObject.masterArrangementId != undefined && rmanForecastingDetailsSearchObject.masterArrangementId != "") {
      searchString = searchString + 'masterArrangementId:' + rmanForecastingDetailsSearchObject.masterArrangementId + ',';
    }

    if (rmanForecastingDetailsSearchObject.fcCurrency != undefined && rmanForecastingDetailsSearchObject.fcCurrency != "") {
      searchString = searchString + 'fcCurrency:' + rmanForecastingDetailsSearchObject.fcCurrency + ',';
    }

    if (rmanForecastingDetailsSearchObject.fcConversionType != undefined && rmanForecastingDetailsSearchObject.fcConversionType != "") {
      searchString = searchString + 'fcConversionType:' + rmanForecastingDetailsSearchObject.fcConversionType + ',';
    }

    if (rmanForecastingDetailsSearchObject.fcBucketId != undefined && rmanForecastingDetailsSearchObject.fcBucketId != "") {
      searchString = searchString + 'fcBucketId:' + rmanForecastingDetailsSearchObject.fcBucketId + ',';
    }

    if (rmanForecastingDetailsSearchObject.fcLevelName != undefined && rmanForecastingDetailsSearchObject.fcLevelName != "") {
      searchString = searchString + 'fcLevelName:' + rmanForecastingDetailsSearchObject.fcLevelName + ',';
    }

    if (rmanForecastingDetailsSearchObject.applyAllocations != undefined && rmanForecastingDetailsSearchObject.applyAllocations != "") {
      searchString = searchString + 'applyAllocations:' + rmanForecastingDetailsSearchObject.applyAllocations + ',';
    }

    if (rmanForecastingDetailsSearchObject.applyContingencies != undefined && rmanForecastingDetailsSearchObject.applyContingencies != "") {
      searchString = searchString + 'applyContingencies:' + rmanForecastingDetailsSearchObject.applyContingencies + ',';
    }

    if (rmanForecastingDetailsSearchObject.fcMethodId != undefined && rmanForecastingDetailsSearchObject.fcMethodId != "") {
      searchString = searchString + 'fcMethodId:' + rmanForecastingDetailsSearchObject.fcMethodId + ',';
    }

    if (rmanForecastingDetailsSearchObject.level1Name != undefined && rmanForecastingDetailsSearchObject.level1Name != "") {
      searchString = searchString + 'level1Name:' + rmanForecastingDetailsSearchObject.level1Name + ',';
    }

    if (rmanForecastingDetailsSearchObject.level1Value != undefined && rmanForecastingDetailsSearchObject.level1Value != "") {
      searchString = searchString + 'level1Value:' + rmanForecastingDetailsSearchObject.level1Value + ',';
    }

    if (rmanForecastingDetailsSearchObject.level2Name != undefined && rmanForecastingDetailsSearchObject.level2Name != "") {
      searchString = searchString + 'level2Name:' + rmanForecastingDetailsSearchObject.level2Name + ',';
    }

    if (rmanForecastingDetailsSearchObject.level2Value != undefined && rmanForecastingDetailsSearchObject.level2Value != "") {
      searchString = searchString + 'level2Value:' + rmanForecastingDetailsSearchObject.level2Value + ',';
    }

    if (rmanForecastingDetailsSearchObject.level3Name != undefined && rmanForecastingDetailsSearchObject.level3Name != "") {
      searchString = searchString + 'level3Name:' + rmanForecastingDetailsSearchObject.level3Name + ',';
    }

    if (rmanForecastingDetailsSearchObject.level3Value != undefined && rmanForecastingDetailsSearchObject.level3Value != "") {
      searchString = searchString + 'level3Value:' + rmanForecastingDetailsSearchObject.level3Value + ',';
    }

    if (rmanForecastingDetailsSearchObject.level4Name != undefined && rmanForecastingDetailsSearchObject.level4Name != "") {
      searchString = searchString + 'level4Name:' + rmanForecastingDetailsSearchObject.level4Name + ',';
    }

    if (rmanForecastingDetailsSearchObject.level4Value != undefined && rmanForecastingDetailsSearchObject.level4Value != "") {
      searchString = searchString + 'level4Value:' + rmanForecastingDetailsSearchObject.level4Value + ',';
    }

    if (rmanForecastingDetailsSearchObject.level5Name != undefined && rmanForecastingDetailsSearchObject.level5Name != "") {
      searchString = searchString + 'level5Name:' + rmanForecastingDetailsSearchObject.level5Name + ',';
    }

    if (rmanForecastingDetailsSearchObject.level5Value != undefined && rmanForecastingDetailsSearchObject.level5Value != "") {
      searchString = searchString + 'level5Value:' + rmanForecastingDetailsSearchObject.level5Value + ',';
    }

    if (rmanForecastingDetailsSearchObject.type != undefined && rmanForecastingDetailsSearchObject.type != "") {
      searchString = searchString + 'type:' + rmanForecastingDetailsSearchObject.type + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket1 != undefined && rmanForecastingDetailsSearchObject.bucket1 != "") {
      searchString = searchString + 'bucket1:' + rmanForecastingDetailsSearchObject.bucket1 + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket1Period != undefined && rmanForecastingDetailsSearchObject.bucket1Period != "") {
      searchString = searchString + 'bucket1Period:' + rmanForecastingDetailsSearchObject.bucket1Period + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket2 != undefined && rmanForecastingDetailsSearchObject.bucket2 != "") {
      searchString = searchString + 'bucket2:' + rmanForecastingDetailsSearchObject.bucket2 + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket2Period != undefined && rmanForecastingDetailsSearchObject.bucket2Period != "") {
      searchString = searchString + 'bucket2Period:' + rmanForecastingDetailsSearchObject.bucket2Period + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket3 != undefined && rmanForecastingDetailsSearchObject.bucket3 != "") {
      searchString = searchString + 'bucket3:' + rmanForecastingDetailsSearchObject.bucket3 + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket3Period != undefined && rmanForecastingDetailsSearchObject.bucket3Period != "") {
      searchString = searchString + 'bucket3Period:' + rmanForecastingDetailsSearchObject.bucket3Period + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket4 != undefined && rmanForecastingDetailsSearchObject.bucket4 != "") {
      searchString = searchString + 'bucket4:' + rmanForecastingDetailsSearchObject.bucket4 + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket4Period != undefined && rmanForecastingDetailsSearchObject.bucket4Period != "") {
      searchString = searchString + 'bucket4Period:' + rmanForecastingDetailsSearchObject.bucket4Period + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket5 != undefined && rmanForecastingDetailsSearchObject.bucket5 != "") {
      searchString = searchString + 'bucket5:' + rmanForecastingDetailsSearchObject.bucket5 + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket5Period != undefined && rmanForecastingDetailsSearchObject.bucket5Period != "") {
      searchString = searchString + 'bucket5Period:' + rmanForecastingDetailsSearchObject.bucket5Period + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket6 != undefined && rmanForecastingDetailsSearchObject.bucket6 != "") {
      searchString = searchString + 'bucket6:' + rmanForecastingDetailsSearchObject.bucket6 + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket6Period != undefined && rmanForecastingDetailsSearchObject.bucket6Period != "") {
      searchString = searchString + 'bucket6Period:' + rmanForecastingDetailsSearchObject.bucket6Period + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket7 != undefined && rmanForecastingDetailsSearchObject.bucket7 != "") {
      searchString = searchString + 'bucket7:' + rmanForecastingDetailsSearchObject.bucket7 + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket7Period != undefined && rmanForecastingDetailsSearchObject.bucket7Period != "") {
      searchString = searchString + 'bucket7Period:' + rmanForecastingDetailsSearchObject.bucket7Period + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket8 != undefined && rmanForecastingDetailsSearchObject.bucket8 != "") {
      searchString = searchString + 'bucket8:' + rmanForecastingDetailsSearchObject.bucket8 + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket8Period != undefined && rmanForecastingDetailsSearchObject.bucket8Period != "") {
      searchString = searchString + 'bucket8Period:' + rmanForecastingDetailsSearchObject.bucket8Period + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket9 != undefined && rmanForecastingDetailsSearchObject.bucket9 != "") {
      searchString = searchString + 'bucket9:' + rmanForecastingDetailsSearchObject.bucket9 + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket9Period != undefined && rmanForecastingDetailsSearchObject.bucket9Period != "") {
      searchString = searchString + 'bucket9Period:' + rmanForecastingDetailsSearchObject.bucket9Period + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket10 != undefined && rmanForecastingDetailsSearchObject.bucket10 != "") {
      searchString = searchString + 'bucket10:' + rmanForecastingDetailsSearchObject.bucket10 + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket10Period != undefined && rmanForecastingDetailsSearchObject.bucket10Period != "") {
      searchString = searchString + 'bucket10Period:' + rmanForecastingDetailsSearchObject.bucket10Period + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket11 != undefined && rmanForecastingDetailsSearchObject.bucket11 != "") {
      searchString = searchString + 'bucket11:' + rmanForecastingDetailsSearchObject.bucket11 + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket11Period != undefined && rmanForecastingDetailsSearchObject.bucket11Period != "") {
      searchString = searchString + 'bucket11Period:' + rmanForecastingDetailsSearchObject.bucket11Period + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket12 != undefined && rmanForecastingDetailsSearchObject.bucket12 != "") {
      searchString = searchString + 'bucket12:' + rmanForecastingDetailsSearchObject.bucket12 + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket12Period != undefined && rmanForecastingDetailsSearchObject.bucket12Period != "") {
      searchString = searchString + 'bucket12Period:' + rmanForecastingDetailsSearchObject.bucket12Period + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket13 != undefined && rmanForecastingDetailsSearchObject.bucket13 != "") {
      searchString = searchString + 'bucket13:' + rmanForecastingDetailsSearchObject.bucket13 + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket13Period != undefined && rmanForecastingDetailsSearchObject.bucket13Period != "") {
      searchString = searchString + 'bucket13Period:' + rmanForecastingDetailsSearchObject.bucket13Period + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket14 != undefined && rmanForecastingDetailsSearchObject.bucket14 != "") {
      searchString = searchString + 'bucket14:' + rmanForecastingDetailsSearchObject.bucket14 + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket14Period != undefined && rmanForecastingDetailsSearchObject.bucket14Period != "") {
      searchString = searchString + 'bucket14Period:' + rmanForecastingDetailsSearchObject.bucket14Period + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket15 != undefined && rmanForecastingDetailsSearchObject.bucket15 != "") {
      searchString = searchString + 'bucket15:' + rmanForecastingDetailsSearchObject.bucket15 + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket15Period != undefined && rmanForecastingDetailsSearchObject.bucket15Period != "") {
      searchString = searchString + 'bucket15Period:' + rmanForecastingDetailsSearchObject.bucket15Period + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket16 != undefined && rmanForecastingDetailsSearchObject.bucket16 != "") {
      searchString = searchString + 'bucket16:' + rmanForecastingDetailsSearchObject.bucket16 + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket16Period != undefined && rmanForecastingDetailsSearchObject.bucket16Period != "") {
      searchString = searchString + 'bucket16Period:' + rmanForecastingDetailsSearchObject.bucket16Period + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket17 != undefined && rmanForecastingDetailsSearchObject.bucket17 != "") {
      searchString = searchString + 'bucket17:' + rmanForecastingDetailsSearchObject.bucket17 + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket17Period != undefined && rmanForecastingDetailsSearchObject.bucket17Period != "") {
      searchString = searchString + 'bucket17Period:' + rmanForecastingDetailsSearchObject.bucket17Period + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket18 != undefined && rmanForecastingDetailsSearchObject.bucket18 != "") {
      searchString = searchString + 'bucket18:' + rmanForecastingDetailsSearchObject.bucket18 + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket18Period != undefined && rmanForecastingDetailsSearchObject.bucket18Period != "") {
      searchString = searchString + 'bucket18Period:' + rmanForecastingDetailsSearchObject.bucket18Period + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket19 != undefined && rmanForecastingDetailsSearchObject.bucket19 != "") {
      searchString = searchString + 'bucket19:' + rmanForecastingDetailsSearchObject.bucket19 + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket19Period != undefined && rmanForecastingDetailsSearchObject.bucket19Period != "") {
      searchString = searchString + 'bucket19Period:' + rmanForecastingDetailsSearchObject.bucket19Period + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket20 != undefined && rmanForecastingDetailsSearchObject.bucket20 != "") {
      searchString = searchString + 'bucket20:' + rmanForecastingDetailsSearchObject.bucket20 + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket20Period != undefined && rmanForecastingDetailsSearchObject.bucket20Period != "") {
      searchString = searchString + 'bucket20Period:' + rmanForecastingDetailsSearchObject.bucket20Period + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket21 != undefined && rmanForecastingDetailsSearchObject.bucket21 != "") {
      searchString = searchString + 'bucket21:' + rmanForecastingDetailsSearchObject.bucket21 + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket21Period != undefined && rmanForecastingDetailsSearchObject.bucket21Period != "") {
      searchString = searchString + 'bucket21Period:' + rmanForecastingDetailsSearchObject.bucket21Period + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket22 != undefined && rmanForecastingDetailsSearchObject.bucket22 != "") {
      searchString = searchString + 'bucket22:' + rmanForecastingDetailsSearchObject.bucket22 + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket22Period != undefined && rmanForecastingDetailsSearchObject.bucket22Period != "") {
      searchString = searchString + 'bucket22Period:' + rmanForecastingDetailsSearchObject.bucket22Period + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket23 != undefined && rmanForecastingDetailsSearchObject.bucket23 != "") {
      searchString = searchString + 'bucket23:' + rmanForecastingDetailsSearchObject.bucket23 + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket23Period != undefined && rmanForecastingDetailsSearchObject.bucket23Period != "") {
      searchString = searchString + 'bucket23Period:' + rmanForecastingDetailsSearchObject.bucket23Period + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket24 != undefined && rmanForecastingDetailsSearchObject.bucket24 != "") {
      searchString = searchString + 'bucket24:' + rmanForecastingDetailsSearchObject.bucket24 + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucket24Period != undefined && rmanForecastingDetailsSearchObject.bucket24Period != "") {
      searchString = searchString + 'bucket24Period:' + rmanForecastingDetailsSearchObject.bucket24Period + ',';
    }

    if (rmanForecastingDetailsSearchObject.future != undefined && rmanForecastingDetailsSearchObject.future != "") {
      searchString = searchString + 'future:' + rmanForecastingDetailsSearchObject.future + ',';
    }

    if (rmanForecastingDetailsSearchObject.expectedStartDate != undefined && rmanForecastingDetailsSearchObject.expectedStartDate != "") {
      searchString = searchString + 'expectedStartDate:' + rmanForecastingDetailsSearchObject.expectedStartDate + ',';
    }

    if (rmanForecastingDetailsSearchObject.expectedEndDate != undefined && rmanForecastingDetailsSearchObject.expectedEndDate != "") {
      searchString = searchString + 'expectedEndDate:' + rmanForecastingDetailsSearchObject.expectedEndDate + ',';
    }

    if (rmanForecastingDetailsSearchObject.expectedSplit != undefined && rmanForecastingDetailsSearchObject.expectedSplit != "") {
      searchString = searchString + 'expectedSplit:' + rmanForecastingDetailsSearchObject.expectedSplit + ',';
    }

    if (rmanForecastingDetailsSearchObject.expectedDuration != undefined && rmanForecastingDetailsSearchObject.expectedDuration != "") {
      searchString = searchString + 'expectedDuration:' + rmanForecastingDetailsSearchObject.expectedDuration + ',';
    }

    if (rmanForecastingDetailsSearchObject.bucketType != undefined && rmanForecastingDetailsSearchObject.bucketType != "") {
      searchString = searchString + 'bucketType:' + rmanForecastingDetailsSearchObject.bucketType + ',';
    }

    if (rmanForecastingDetailsSearchObject.remainingAmount != undefined && rmanForecastingDetailsSearchObject.remainingAmount != "") {
      searchString = searchString + 'remainingAmount:' + rmanForecastingDetailsSearchObject.remainingAmount + ',';
    }

    if (rmanForecastingDetailsSearchObject.remainingFutureFlag != undefined && rmanForecastingDetailsSearchObject.remainingFutureFlag != "") {
      searchString = searchString + 'remainingFutureFlag:' + rmanForecastingDetailsSearchObject.remainingFutureFlag + ',';
    }

    if (rmanForecastingDetailsSearchObject.productOrgId != undefined && rmanForecastingDetailsSearchObject.productOrgId != "") {
      searchString = searchString + 'productOrgId:' + rmanForecastingDetailsSearchObject.productOrgId + ',';
    }

    if (rmanForecastingDetailsSearchObject.createdDate != undefined && rmanForecastingDetailsSearchObject.createdDate != "") {
      searchString = searchString + 'createdDate:' + rmanForecastingDetailsSearchObject.createdDate + ',';
    }

    if (rmanForecastingDetailsSearchObject.createdBy != undefined && rmanForecastingDetailsSearchObject.createdBy != "") {
      searchString = searchString + 'createdBy:' + rmanForecastingDetailsSearchObject.createdBy + ',';
    }

    if (rmanForecastingDetailsSearchObject.lastUpdatedDate != undefined && rmanForecastingDetailsSearchObject.lastUpdatedDate != "") {
      searchString = searchString + 'lastUpdatedDate:' + rmanForecastingDetailsSearchObject.lastUpdatedDate + ',';
    }

    if (rmanForecastingDetailsSearchObject.lastUpdatedBy != undefined && rmanForecastingDetailsSearchObject.lastUpdatedBy != "") {
      searchString = searchString + 'lastUpdatedBy:' + rmanForecastingDetailsSearchObject.lastUpdatedBy + ',';
    }

    if (rmanForecastingDetailsSearchObject.amount != undefined && rmanForecastingDetailsSearchObject.amount != "") {
      searchString = searchString + 'amount:' + rmanForecastingDetailsSearchObject.amount + ',';
    }

    if (rmanForecastingDetailsSearchObject.bookingDelay != undefined && rmanForecastingDetailsSearchObject.bookingDelay != "") {
      searchString = searchString + 'bookingDelay:' + rmanForecastingDetailsSearchObject.bookingDelay + ',';
    }

    if (rmanForecastingDetailsSearchObject.shipmentDelay != undefined && rmanForecastingDetailsSearchObject.shipmentDelay != "") {
      searchString = searchString + 'shipmentDelay:' + rmanForecastingDetailsSearchObject.shipmentDelay + ',';
    }

    if (rmanForecastingDetailsSearchObject.inoviceDelay != undefined && rmanForecastingDetailsSearchObject.inoviceDelay != "") {
      searchString = searchString + 'inoviceDelay:' + rmanForecastingDetailsSearchObject.inoviceDelay + ',';
    }

    if (rmanForecastingDetailsSearchObject.fcStartDate != undefined && rmanForecastingDetailsSearchObject.fcStartDate != "") {
      searchString = searchString + 'fcStartDate:' + rmanForecastingDetailsSearchObject.fcStartDate;
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

    return serviceUrl;
  }

  getAllRmanForecastingDetails(paginationOptions: any, rmanForecastingDetailsSearchObject: any): Promise<any[]> {
    let serviceUrl = this.getServiceUrl(paginationOptions, rmanForecastingDetailsSearchObject, 0);
    return this.http.get(serviceUrl).toPromise().then((data: any) => {
      return data;
    });
  }

  saveRmanForecastingDetails(rmanForecastingDetails: any): Promise<any[]> {
    let body = JSON.stringify(rmanForecastingDetails);
    return this.http.post<any[]>(appSettings.apiUrl + '/RMAN_FORECASTING_DETAILS', body, httpOptions).toPromise().then(data => {
      return data;
    });
  }

  updateRmanForecastingDetails(rmanForecastingDetails: any): Promise<any[]> {

    delete rmanForecastingDetails._links;
    delete rmanForecastingDetails.interests;
    let body = JSON.stringify(rmanForecastingDetails);
    return this.http.put<any[]>(appSettings.apiUrl + '/RMAN_FORECASTING_DETAILS/' + rmanForecastingDetails.key, body, httpOptions).toPromise().then(data => {
      return data;
    });

  }

  deleteRmanForecastingDetails(rmanForecastingDetails: any): Promise<any[]> {
    let deleteUrl = appSettings.apiUrl + '/RMAN_FORECASTING_DETAILS/' + rmanForecastingDetails.arrangementId;
    return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
      return data;
    });
  }

  showFCDetails(rmanForecastingDetails: any): Promise<any> {
    let body = "arrId=" + rmanForecastingDetails.arrangementId + "&" + "fcLevel=" + rmanForecastingDetails.fcLevelName +
      "&" + "fcBucket=" + rmanForecastingDetails.fcBucketId + "&" + "fcMethod=" + rmanForecastingDetails.fcMethodId + "&" + "fcStartDate=" + this.datePipe.transform(rmanForecastingDetails.fcStartDate, 'yyyy-MM-dd H:mm:ss')
      + "&" + "fcAllocFlag=" + rmanForecastingDetails.applyAllocations;
    let releaseUrl = appSettings.apiUrl + '/enterForecastingDetails?' + body;
    return this.http.get(releaseUrl, { responseType: 'text' }).toPromise().then(data => {
      return data;
    });
  }

  saveFcDistributions(rmanForecastingDetails: any) {
    let body = "arrId=" + rmanForecastingDetails.arrangementId + "&" + "fcLevel=" + rmanForecastingDetails.fcLevelName +
      "&" + "fcBucket=" + rmanForecastingDetails.fcBucketId + "&" + "fcMethod=" + rmanForecastingDetails.fcMethodId + "&" + "fcStartDate=" + this.datePipe.transform(rmanForecastingDetails.fcStartDate, 'yyyy-MM-dd H:mm:ss')
      + "&" + "fcAllocFlag=" + rmanForecastingDetails.applyAllocations;
    let saveFCDistributionsUrl = appSettings.apiUrl + '/saveFcDistributions?' + body;
    return this.http.get(saveFCDistributionsUrl).toPromise().then(data => {
      return data;
    });
  }

  updateRFCSTDetails(rmanForecastingDetails: any[]): Promise<any[]> {
    let body = JSON.stringify(rmanForecastingDetails);
    let rmanFCSTDetail = rmanForecastingDetails[0];
    return this.http.post(appSettings.apiUrl + '/updateForecastingDetails', body, httpOptions).toPromise().then((data: any) => {
      data = JSON.parse(JSON.stringify(data));
      this.saveFcDistributions(rmanFCSTDetail);
      return data;
    });
  }


}
