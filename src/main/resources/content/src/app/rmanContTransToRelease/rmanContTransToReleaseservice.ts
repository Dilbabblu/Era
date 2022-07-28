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
export class RmanContTransToReleaseService {

  constructor(private http: HttpClient) { }

  getAllRmanContTransToRelease(paginationOptions: any, rmanContTransToReleaseSearchObject: any): Promise<any[]> {
    let serviceUrl = appSettings.apiUrl + '/rmanContTransToReleaseSearch?';

    let searchString = '';

    if (rmanContTransToReleaseSearchObject.transHeaderId != undefined && rmanContTransToReleaseSearchObject.transHeaderId != "") {
      searchString = searchString + 'transHeaderId:' + rmanContTransToReleaseSearchObject.transHeaderId + ',';
    }

    if (rmanContTransToReleaseSearchObject.transLineId != undefined && rmanContTransToReleaseSearchObject.transLineId != "") {
      searchString = searchString + 'transLineId:' + rmanContTransToReleaseSearchObject.transLineId + ',';
    }

    if (rmanContTransToReleaseSearchObject.ruleHeaderId != undefined && rmanContTransToReleaseSearchObject.ruleHeaderId != "") {
      searchString = searchString + 'ruleHeaderId:' + rmanContTransToReleaseSearchObject.ruleHeaderId + ',';
    }

    if (rmanContTransToReleaseSearchObject.description != undefined && rmanContTransToReleaseSearchObject.description != "") {
      searchString = searchString + 'description:' + rmanContTransToReleaseSearchObject.description + ',';
    }

    if (rmanContTransToReleaseSearchObject.comments != undefined && rmanContTransToReleaseSearchObject.comments != "") {
      searchString = searchString + 'comments:' + rmanContTransToReleaseSearchObject.comments + ',';
    }

    if (rmanContTransToReleaseSearchObject.contEventType != undefined && rmanContTransToReleaseSearchObject.contEventType != "") {
      searchString = searchString + 'contEventType:' + rmanContTransToReleaseSearchObject.contEventType + ',';
    }

    if (rmanContTransToReleaseSearchObject.maxDuration != undefined && rmanContTransToReleaseSearchObject.maxDuration != "") {
      searchString = searchString + 'maxDuration:' + rmanContTransToReleaseSearchObject.maxDuration + ',';
    }

    if (rmanContTransToReleaseSearchObject.event != undefined && rmanContTransToReleaseSearchObject.event != "") {
      searchString = searchString + 'event:' + rmanContTransToReleaseSearchObject.event + ',';
    }

    if (rmanContTransToReleaseSearchObject.percentage != undefined && rmanContTransToReleaseSearchObject.percentage != "") {
      searchString = searchString + 'percentage:' + rmanContTransToReleaseSearchObject.percentage + ',';
    }

    if (rmanContTransToReleaseSearchObject.application != undefined && rmanContTransToReleaseSearchObject.application != "") {
      searchString = searchString + 'application:' + rmanContTransToReleaseSearchObject.application + ',';
    }

    if (rmanContTransToReleaseSearchObject.ranking != undefined && rmanContTransToReleaseSearchObject.ranking != "") {
      searchString = searchString + 'ranking:' + rmanContTransToReleaseSearchObject.ranking + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute1 != undefined && rmanContTransToReleaseSearchObject.attribute1 != "") {
      searchString = searchString + 'attribute1:' + rmanContTransToReleaseSearchObject.attribute1 + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute2 != undefined && rmanContTransToReleaseSearchObject.attribute2 != "") {
      searchString = searchString + 'attribute2:' + rmanContTransToReleaseSearchObject.attribute2 + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute3 != undefined && rmanContTransToReleaseSearchObject.attribute3 != "") {
      searchString = searchString + 'attribute3:' + rmanContTransToReleaseSearchObject.attribute3 + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute4 != undefined && rmanContTransToReleaseSearchObject.attribute4 != "") {
      searchString = searchString + 'attribute4:' + rmanContTransToReleaseSearchObject.attribute4 + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute5 != undefined && rmanContTransToReleaseSearchObject.attribute5 != "") {
      searchString = searchString + 'attribute5:' + rmanContTransToReleaseSearchObject.attribute5 + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute6 != undefined && rmanContTransToReleaseSearchObject.attribute6 != "") {
      searchString = searchString + 'attribute6:' + rmanContTransToReleaseSearchObject.attribute6 + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute7 != undefined && rmanContTransToReleaseSearchObject.attribute7 != "") {
      searchString = searchString + 'attribute7:' + rmanContTransToReleaseSearchObject.attribute7 + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute8 != undefined && rmanContTransToReleaseSearchObject.attribute8 != "") {
      searchString = searchString + 'attribute8:' + rmanContTransToReleaseSearchObject.attribute8 + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute9 != undefined && rmanContTransToReleaseSearchObject.attribute9 != "") {
      searchString = searchString + 'attribute9:' + rmanContTransToReleaseSearchObject.attribute9 + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute10 != undefined && rmanContTransToReleaseSearchObject.attribute10 != "") {
      searchString = searchString + 'attribute10:' + rmanContTransToReleaseSearchObject.attribute10 + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute11 != undefined && rmanContTransToReleaseSearchObject.attribute11 != "") {
      searchString = searchString + 'attribute11:' + rmanContTransToReleaseSearchObject.attribute11 + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute12 != undefined && rmanContTransToReleaseSearchObject.attribute12 != "") {
      searchString = searchString + 'attribute12:' + rmanContTransToReleaseSearchObject.attribute12 + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute13 != undefined && rmanContTransToReleaseSearchObject.attribute13 != "") {
      searchString = searchString + 'attribute13:' + rmanContTransToReleaseSearchObject.attribute13 + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute14 != undefined && rmanContTransToReleaseSearchObject.attribute14 != "") {
      searchString = searchString + 'attribute14:' + rmanContTransToReleaseSearchObject.attribute14 + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute15 != undefined && rmanContTransToReleaseSearchObject.attribute15 != "") {
      searchString = searchString + 'attribute15:' + rmanContTransToReleaseSearchObject.attribute15 + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute16 != undefined && rmanContTransToReleaseSearchObject.attribute16 != "") {
      searchString = searchString + 'attribute16:' + rmanContTransToReleaseSearchObject.attribute16 + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute17 != undefined && rmanContTransToReleaseSearchObject.attribute17 != "") {
      searchString = searchString + 'attribute17:' + rmanContTransToReleaseSearchObject.attribute17 + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute18 != undefined && rmanContTransToReleaseSearchObject.attribute18 != "") {
      searchString = searchString + 'attribute18:' + rmanContTransToReleaseSearchObject.attribute18 + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute19 != undefined && rmanContTransToReleaseSearchObject.attribute19 != "") {
      searchString = searchString + 'attribute19:' + rmanContTransToReleaseSearchObject.attribute19 + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute20 != undefined && rmanContTransToReleaseSearchObject.attribute20 != "") {
      searchString = searchString + 'attribute20:' + rmanContTransToReleaseSearchObject.attribute20 + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute21 != undefined && rmanContTransToReleaseSearchObject.attribute21 != "") {
      searchString = searchString + 'attribute21:' + rmanContTransToReleaseSearchObject.attribute21 + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute22 != undefined && rmanContTransToReleaseSearchObject.attribute22 != "") {
      searchString = searchString + 'attribute22:' + rmanContTransToReleaseSearchObject.attribute22 + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute23 != undefined && rmanContTransToReleaseSearchObject.attribute23 != "") {
      searchString = searchString + 'attribute23:' + rmanContTransToReleaseSearchObject.attribute23 + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute24 != undefined && rmanContTransToReleaseSearchObject.attribute24 != "") {
      searchString = searchString + 'attribute24:' + rmanContTransToReleaseSearchObject.attribute24 + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute25 != undefined && rmanContTransToReleaseSearchObject.attribute25 != "") {
      searchString = searchString + 'attribute25:' + rmanContTransToReleaseSearchObject.attribute25 + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute26 != undefined && rmanContTransToReleaseSearchObject.attribute26 != "") {
      searchString = searchString + 'attribute26:' + rmanContTransToReleaseSearchObject.attribute26 + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute27 != undefined && rmanContTransToReleaseSearchObject.attribute27 != "") {
      searchString = searchString + 'attribute27:' + rmanContTransToReleaseSearchObject.attribute27 + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute28 != undefined && rmanContTransToReleaseSearchObject.attribute28 != "") {
      searchString = searchString + 'attribute28:' + rmanContTransToReleaseSearchObject.attribute28 + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute29 != undefined && rmanContTransToReleaseSearchObject.attribute29 != "") {
      searchString = searchString + 'attribute29:' + rmanContTransToReleaseSearchObject.attribute29 + ',';
    }

    if (rmanContTransToReleaseSearchObject.attribute30 != undefined && rmanContTransToReleaseSearchObject.attribute30 != "") {
      searchString = searchString + 'attribute30:' + rmanContTransToReleaseSearchObject.attribute30 + ',';
    }

    if (rmanContTransToReleaseSearchObject.creationDate != undefined && rmanContTransToReleaseSearchObject.creationDate != "") {
      searchString = searchString + 'creationDate:' + rmanContTransToReleaseSearchObject.creationDate + ',';
    }

    if (rmanContTransToReleaseSearchObject.createdBy != undefined && rmanContTransToReleaseSearchObject.createdBy != "") {
      searchString = searchString + 'createdBy:' + rmanContTransToReleaseSearchObject.createdBy + ',';
    }

    if (rmanContTransToReleaseSearchObject.lastUpdateDate != undefined && rmanContTransToReleaseSearchObject.lastUpdateDate != "") {
      searchString = searchString + 'lastUpdateDate:' + rmanContTransToReleaseSearchObject.lastUpdateDate + ',';
    }

    if (rmanContTransToReleaseSearchObject.lastUpdatedBy != undefined && rmanContTransToReleaseSearchObject.lastUpdatedBy != "") {
      searchString = searchString + 'lastUpdatedBy:' + rmanContTransToReleaseSearchObject.lastUpdatedBy + ',';
    }

    if (rmanContTransToReleaseSearchObject.templateId != undefined && rmanContTransToReleaseSearchObject.templateId != "") {
      searchString = searchString + 'templateId:' + rmanContTransToReleaseSearchObject.templateId + ',';
    }

    if (rmanContTransToReleaseSearchObject.applicationLevel != undefined && rmanContTransToReleaseSearchObject.applicationLevel != "") {
      searchString = searchString + 'applicationLevel:' + rmanContTransToReleaseSearchObject.applicationLevel + ',';
    }

    if (rmanContTransToReleaseSearchObject.dealNum != undefined && rmanContTransToReleaseSearchObject.dealNum != "") {
      searchString = searchString + 'dealNum:' + rmanContTransToReleaseSearchObject.dealNum + ',';
    }

    if (rmanContTransToReleaseSearchObject.soHeaderId != undefined && rmanContTransToReleaseSearchObject.soHeaderId != "") {
      searchString = searchString + 'soHeaderId:' + rmanContTransToReleaseSearchObject.soHeaderId + ',';
    }

    if (rmanContTransToReleaseSearchObject.soLineId != undefined && rmanContTransToReleaseSearchObject.soLineId != "") {
      searchString = searchString + 'soLineId:' + rmanContTransToReleaseSearchObject.soLineId + ',';
    }

    if (rmanContTransToReleaseSearchObject.element != undefined && rmanContTransToReleaseSearchObject.element != "") {
      searchString = searchString + 'element:' + rmanContTransToReleaseSearchObject.element + ',';
    }

    if (rmanContTransToReleaseSearchObject.ruleCategory != undefined && rmanContTransToReleaseSearchObject.ruleCategory != "") {
      searchString = searchString + 'ruleCategory:' + rmanContTransToReleaseSearchObject.ruleCategory + ',';
    }

    if (rmanContTransToReleaseSearchObject.revenue != undefined && rmanContTransToReleaseSearchObject.revenue != "") {
      searchString = searchString + 'revenue:' + rmanContTransToReleaseSearchObject.revenue + ',';
    }

    if (rmanContTransToReleaseSearchObject.cogs != undefined && rmanContTransToReleaseSearchObject.cogs != "") {
      searchString = searchString + 'cogs:' + rmanContTransToReleaseSearchObject.cogs + ',';
    }

    if (rmanContTransToReleaseSearchObject.deferredMethod != undefined && rmanContTransToReleaseSearchObject.deferredMethod != "") {
      searchString = searchString + 'deferredMethod:' + rmanContTransToReleaseSearchObject.deferredMethod + ',';
    }

    if (rmanContTransToReleaseSearchObject.releaseType != undefined && rmanContTransToReleaseSearchObject.releaseType != "") {
      searchString = searchString + 'releaseType:' + rmanContTransToReleaseSearchObject.releaseType + ',';
    }

    if (rmanContTransToReleaseSearchObject.releaseCogs != undefined && rmanContTransToReleaseSearchObject.releaseCogs != "") {
      searchString = searchString + 'releaseCogs:' + rmanContTransToReleaseSearchObject.releaseCogs + ',';
    }

    if (rmanContTransToReleaseSearchObject.releaseRevenue != undefined && rmanContTransToReleaseSearchObject.releaseRevenue != "") {
      searchString = searchString + 'releaseRevenue:' + rmanContTransToReleaseSearchObject.releaseRevenue + ',';
    }

    if (rmanContTransToReleaseSearchObject.applyType != undefined && rmanContTransToReleaseSearchObject.applyType != "") {
      searchString = searchString + 'applyType:' + rmanContTransToReleaseSearchObject.applyType + ',';
    }

    if (rmanContTransToReleaseSearchObject.invoiceHold != undefined && rmanContTransToReleaseSearchObject.invoiceHold != "") {
      searchString = searchString + 'invoiceHold:' + rmanContTransToReleaseSearchObject.invoiceHold + ',';
    }

    if (rmanContTransToReleaseSearchObject.avgContAcceptDur != undefined && rmanContTransToReleaseSearchObject.avgContAcceptDur != "") {
      searchString = searchString + 'avgContAcceptDur:' + rmanContTransToReleaseSearchObject.avgContAcceptDur + ',';
    }

    if (rmanContTransToReleaseSearchObject.status != undefined && rmanContTransToReleaseSearchObject.status != "") {
      searchString = searchString + 'status:' + rmanContTransToReleaseSearchObject.status + ',';
    }

    if (rmanContTransToReleaseSearchObject.productName != undefined && rmanContTransToReleaseSearchObject.productName != "") {
      searchString = searchString + 'productName:' + rmanContTransToReleaseSearchObject.productName + ',';
    }

    if (rmanContTransToReleaseSearchObject.autoReleaseDays != undefined && rmanContTransToReleaseSearchObject.autoReleaseDays != "") {
      searchString = searchString + 'autoReleaseDays:' + rmanContTransToReleaseSearchObject.autoReleaseDays + ',';
    }

    if (rmanContTransToReleaseSearchObject.dealArrangementId != undefined && rmanContTransToReleaseSearchObject.dealArrangementId != "") {
      searchString = searchString + 'dealArrangementId:' + rmanContTransToReleaseSearchObject.dealArrangementId + ',';
    }

    if (rmanContTransToReleaseSearchObject.sourceHeaderId != undefined && rmanContTransToReleaseSearchObject.sourceHeaderId != "") {
      searchString = searchString + 'sourceHeaderId:' + rmanContTransToReleaseSearchObject.sourceHeaderId + ',';
    }

    if (rmanContTransToReleaseSearchObject.sourceLineId != undefined && rmanContTransToReleaseSearchObject.sourceLineId != "") {
      searchString = searchString + 'sourceLineId:' + rmanContTransToReleaseSearchObject.sourceLineId;
    }



    if (searchString == '') {
      serviceUrl = serviceUrl + 'search=%25' + '&sort=ranking';
    }
    else {
      serviceUrl = serviceUrl + 'search=' + searchString + '&sort=ranking';
    }

    if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != "" && !isNaN(paginationOptions.pageNumber) && paginationOptions.pageNumber != 0) {
      serviceUrl = serviceUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;
    }

    return this.http.get(serviceUrl).toPromise().then((data: any) => {
      return data;
    });
  }

  saveRmanContTransToRelease(rmanContTransToRelease: any): Promise<any[]> {
    let body = JSON.stringify(rmanContTransToRelease);
    return this.http.post<any[]>(appSettings.apiUrl + '/RMAN_CONT_TRANS_TO_RELEASE', body, httpOptions).toPromise().then(data => {
      return data;
    });
  }

  updateRmanContTransToRelease(rmanContTransToRelease: any): Promise<any[]> {
    delete rmanContTransToRelease.rmanContLinktemplateV2;
    delete rmanContTransToRelease._links;
    delete rmanContTransToRelease.interests;
    let body = JSON.stringify(rmanContTransToRelease);
    return this.http.put<any[]>(appSettings.apiUrl + '/RMAN_CONT_TRANS_TO_RELEASE/' + rmanContTransToRelease.transLineId, body, httpOptions).toPromise().then(data => {
      return data;
    });

  }

  deleteRmanContTransToRelease(rmanContTransToRelease: any): Promise<any[]> {
    let deleteUrl = appSettings.apiUrl + '/RMAN_CONT_TRANS_TO_RELEASE/' + rmanContTransToRelease.transLineId;
    return this.http.delete(deleteUrl, httpOptions).toPromise().then((data: any) => {
      return data;
    });
  }

  insertReleaseLinesRmanContengencies(transHeaderId: any, transLineId: any) {
    let body = "transHeaderId=" + transHeaderId + "&" + "transLineId=" + transLineId;
    let releaseUrl = appSettings.apiUrl + '/releaseContInsertReleaseLine?' + body;
    return this.http.get(releaseUrl, { responseType: 'text' }).toPromise().then((data: any) => {
      return data.status;
    });
  }

}
