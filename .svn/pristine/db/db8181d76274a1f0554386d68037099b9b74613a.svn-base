import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
declare var require:any;
const appSettings = require('../appsettings');


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
  })
};



@Injectable()
export class RmanContTransLinesService {

  constructor(private http: HttpClient) { }

  getAllRmanContTransLines(paginationOptions: any, rmanContTransLinesSearchObject: any): Promise<any[]> {
    let serviceUrl = appSettings.apiUrl + '/rmanContTransLinesSearch?';

    let searchString = '';

    if (rmanContTransLinesSearchObject.transHeaderId != undefined && rmanContTransLinesSearchObject.transHeaderId != "") {
      searchString = searchString + 'transHeaderId:' + rmanContTransLinesSearchObject.transHeaderId + ',';
    }

    if (rmanContTransLinesSearchObject.transLineId != undefined && rmanContTransLinesSearchObject.transLineId != "") {
      searchString = searchString + 'transLineId:' + rmanContTransLinesSearchObject.transLineId + ',';
    }

    if (rmanContTransLinesSearchObject.ruleHeaderId != undefined && rmanContTransLinesSearchObject.ruleHeaderId != "") {
      searchString = searchString + 'ruleHeaderId:' + rmanContTransLinesSearchObject.ruleHeaderId + ',';
    }

    if (rmanContTransLinesSearchObject.description != undefined && rmanContTransLinesSearchObject.description != "") {
      searchString = searchString + 'description:' + rmanContTransLinesSearchObject.description + ',';
    }

    if (rmanContTransLinesSearchObject.comments != undefined && rmanContTransLinesSearchObject.comments != "") {
      searchString = searchString + 'comments:' + rmanContTransLinesSearchObject.comments + ',';
    }

    if (rmanContTransLinesSearchObject.contEventType != undefined && rmanContTransLinesSearchObject.contEventType != "") {
      searchString = searchString + 'contEventType:' + rmanContTransLinesSearchObject.contEventType + ',';
    }

    if (rmanContTransLinesSearchObject.maxDuration != undefined && rmanContTransLinesSearchObject.maxDuration != "") {
      searchString = searchString + 'maxDuration:' + rmanContTransLinesSearchObject.maxDuration + ',';
    }

    if (rmanContTransLinesSearchObject.event != undefined && rmanContTransLinesSearchObject.event != "") {
      searchString = searchString + 'event:' + rmanContTransLinesSearchObject.event + ',';
    }

    if (rmanContTransLinesSearchObject.percentage != undefined && rmanContTransLinesSearchObject.percentage != "") {
      searchString = searchString + 'percentage:' + rmanContTransLinesSearchObject.percentage + ',';
    }

    if (rmanContTransLinesSearchObject.application != undefined && rmanContTransLinesSearchObject.application != "") {
      searchString = searchString + 'application:' + rmanContTransLinesSearchObject.application + ',';
    }

    if (rmanContTransLinesSearchObject.ranking != undefined && rmanContTransLinesSearchObject.ranking != "") {
      searchString = searchString + 'ranking:' + rmanContTransLinesSearchObject.ranking + ',';
    }

    if (rmanContTransLinesSearchObject.attribute1 != undefined && rmanContTransLinesSearchObject.attribute1 != "") {
      searchString = searchString + 'attribute1:' + rmanContTransLinesSearchObject.attribute1 + ',';
    }

    if (rmanContTransLinesSearchObject.attribute2 != undefined && rmanContTransLinesSearchObject.attribute2 != "") {
      searchString = searchString + 'attribute2:' + rmanContTransLinesSearchObject.attribute2 + ',';
    }

    if (rmanContTransLinesSearchObject.attribute3 != undefined && rmanContTransLinesSearchObject.attribute3 != "") {
      searchString = searchString + 'attribute3:' + rmanContTransLinesSearchObject.attribute3 + ',';
    }

    if (rmanContTransLinesSearchObject.attribute4 != undefined && rmanContTransLinesSearchObject.attribute4 != "") {
      searchString = searchString + 'attribute4:' + rmanContTransLinesSearchObject.attribute4 + ',';
    }

    if (rmanContTransLinesSearchObject.attribute5 != undefined && rmanContTransLinesSearchObject.attribute5 != "") {
      searchString = searchString + 'attribute5:' + rmanContTransLinesSearchObject.attribute5 + ',';
    }

    if (rmanContTransLinesSearchObject.attribute6 != undefined && rmanContTransLinesSearchObject.attribute6 != "") {
      searchString = searchString + 'attribute6:' + rmanContTransLinesSearchObject.attribute6 + ',';
    }

    if (rmanContTransLinesSearchObject.attribute7 != undefined && rmanContTransLinesSearchObject.attribute7 != "") {
      searchString = searchString + 'attribute7:' + rmanContTransLinesSearchObject.attribute7 + ',';
    }

    if (rmanContTransLinesSearchObject.attribute8 != undefined && rmanContTransLinesSearchObject.attribute8 != "") {
      searchString = searchString + 'attribute8:' + rmanContTransLinesSearchObject.attribute8 + ',';
    }

    if (rmanContTransLinesSearchObject.attribute9 != undefined && rmanContTransLinesSearchObject.attribute9 != "") {
      searchString = searchString + 'attribute9:' + rmanContTransLinesSearchObject.attribute9 + ',';
    }

    if (rmanContTransLinesSearchObject.attribute10 != undefined && rmanContTransLinesSearchObject.attribute10 != "") {
      searchString = searchString + 'attribute10:' + rmanContTransLinesSearchObject.attribute10 + ',';
    }

    if (rmanContTransLinesSearchObject.attribute11 != undefined && rmanContTransLinesSearchObject.attribute11 != "") {
      searchString = searchString + 'attribute11:' + rmanContTransLinesSearchObject.attribute11 + ',';
    }

    if (rmanContTransLinesSearchObject.attribute12 != undefined && rmanContTransLinesSearchObject.attribute12 != "") {
      searchString = searchString + 'attribute12:' + rmanContTransLinesSearchObject.attribute12 + ',';
    }

    if (rmanContTransLinesSearchObject.attribute13 != undefined && rmanContTransLinesSearchObject.attribute13 != "") {
      searchString = searchString + 'attribute13:' + rmanContTransLinesSearchObject.attribute13 + ',';
    }

    if (rmanContTransLinesSearchObject.attribute14 != undefined && rmanContTransLinesSearchObject.attribute14 != "") {
      searchString = searchString + 'attribute14:' + rmanContTransLinesSearchObject.attribute14 + ',';
    }

    if (rmanContTransLinesSearchObject.attribute15 != undefined && rmanContTransLinesSearchObject.attribute15 != "") {
      searchString = searchString + 'attribute15:' + rmanContTransLinesSearchObject.attribute15 + ',';
    }

    if (rmanContTransLinesSearchObject.attribute16 != undefined && rmanContTransLinesSearchObject.attribute16 != "") {
      searchString = searchString + 'attribute16:' + rmanContTransLinesSearchObject.attribute16 + ',';
    }

    if (rmanContTransLinesSearchObject.attribute17 != undefined && rmanContTransLinesSearchObject.attribute17 != "") {
      searchString = searchString + 'attribute17:' + rmanContTransLinesSearchObject.attribute17 + ',';
    }

    if (rmanContTransLinesSearchObject.attribute18 != undefined && rmanContTransLinesSearchObject.attribute18 != "") {
      searchString = searchString + 'attribute18:' + rmanContTransLinesSearchObject.attribute18 + ',';
    }

    if (rmanContTransLinesSearchObject.attribute19 != undefined && rmanContTransLinesSearchObject.attribute19 != "") {
      searchString = searchString + 'attribute19:' + rmanContTransLinesSearchObject.attribute19 + ',';
    }

    if (rmanContTransLinesSearchObject.attribute20 != undefined && rmanContTransLinesSearchObject.attribute20 != "") {
      searchString = searchString + 'attribute20:' + rmanContTransLinesSearchObject.attribute20 + ',';
    }

    if (rmanContTransLinesSearchObject.attribute21 != undefined && rmanContTransLinesSearchObject.attribute21 != "") {
      searchString = searchString + 'attribute21:' + rmanContTransLinesSearchObject.attribute21 + ',';
    }

    if (rmanContTransLinesSearchObject.attribute22 != undefined && rmanContTransLinesSearchObject.attribute22 != "") {
      searchString = searchString + 'attribute22:' + rmanContTransLinesSearchObject.attribute22 + ',';
    }

    if (rmanContTransLinesSearchObject.attribute23 != undefined && rmanContTransLinesSearchObject.attribute23 != "") {
      searchString = searchString + 'attribute23:' + rmanContTransLinesSearchObject.attribute23 + ',';
    }

    if (rmanContTransLinesSearchObject.attribute24 != undefined && rmanContTransLinesSearchObject.attribute24 != "") {
      searchString = searchString + 'attribute24:' + rmanContTransLinesSearchObject.attribute24 + ',';
    }

    if (rmanContTransLinesSearchObject.attribute25 != undefined && rmanContTransLinesSearchObject.attribute25 != "") {
      searchString = searchString + 'attribute25:' + rmanContTransLinesSearchObject.attribute25 + ',';
    }

    if (rmanContTransLinesSearchObject.attribute26 != undefined && rmanContTransLinesSearchObject.attribute26 != "") {
      searchString = searchString + 'attribute26:' + rmanContTransLinesSearchObject.attribute26 + ',';
    }

    if (rmanContTransLinesSearchObject.attribute27 != undefined && rmanContTransLinesSearchObject.attribute27 != "") {
      searchString = searchString + 'attribute27:' + rmanContTransLinesSearchObject.attribute27 + ',';
    }

    if (rmanContTransLinesSearchObject.attribute28 != undefined && rmanContTransLinesSearchObject.attribute28 != "") {
      searchString = searchString + 'attribute28:' + rmanContTransLinesSearchObject.attribute28 + ',';
    }

    if (rmanContTransLinesSearchObject.attribute29 != undefined && rmanContTransLinesSearchObject.attribute29 != "") {
      searchString = searchString + 'attribute29:' + rmanContTransLinesSearchObject.attribute29 + ',';
    }

    if (rmanContTransLinesSearchObject.attribute30 != undefined && rmanContTransLinesSearchObject.attribute30 != "") {
      searchString = searchString + 'attribute30:' + rmanContTransLinesSearchObject.attribute30 + ',';
    }

    if (rmanContTransLinesSearchObject.creationDate != undefined && rmanContTransLinesSearchObject.creationDate != "") {
      searchString = searchString + 'creationDate:' + rmanContTransLinesSearchObject.creationDate + ',';
    }

    if (rmanContTransLinesSearchObject.createdBy != undefined && rmanContTransLinesSearchObject.createdBy != "") {
      searchString = searchString + 'createdBy:' + rmanContTransLinesSearchObject.createdBy + ',';
    }

    if (rmanContTransLinesSearchObject.lastUpdateDate != undefined && rmanContTransLinesSearchObject.lastUpdateDate != "") {
      searchString = searchString + 'lastUpdateDate:' + rmanContTransLinesSearchObject.lastUpdateDate + ',';
    }

    if (rmanContTransLinesSearchObject.lastUpdatedBy != undefined && rmanContTransLinesSearchObject.lastUpdatedBy != "") {
      searchString = searchString + 'lastUpdatedBy:' + rmanContTransLinesSearchObject.lastUpdatedBy + ',';
    }

    if (rmanContTransLinesSearchObject.templateId != undefined && rmanContTransLinesSearchObject.templateId != "") {
      searchString = searchString + 'templateId:' + rmanContTransLinesSearchObject.templateId + ',';
    }

    if (rmanContTransLinesSearchObject.applicationLevel != undefined && rmanContTransLinesSearchObject.applicationLevel != "") {
      searchString = searchString + 'applicationLevel:' + rmanContTransLinesSearchObject.applicationLevel + ',';
    }

    if (rmanContTransLinesSearchObject.dealNum != undefined && rmanContTransLinesSearchObject.dealNum != "") {
      searchString = searchString + 'dealNum:' + rmanContTransLinesSearchObject.dealNum + ',';
    }

    if (rmanContTransLinesSearchObject.soHeaderId != undefined && rmanContTransLinesSearchObject.soHeaderId != "") {
      searchString = searchString + 'soHeaderId:' + rmanContTransLinesSearchObject.soHeaderId + ',';
    }

    if (rmanContTransLinesSearchObject.soLineId != undefined && rmanContTransLinesSearchObject.soLineId != "") {
      searchString = searchString + 'soLineId:' + rmanContTransLinesSearchObject.soLineId + ',';
    }

    if (rmanContTransLinesSearchObject.element != undefined && rmanContTransLinesSearchObject.element != "") {
      searchString = searchString + 'element:' + rmanContTransLinesSearchObject.element + ',';
    }

    if (rmanContTransLinesSearchObject.ruleCategory != undefined && rmanContTransLinesSearchObject.ruleCategory != "") {
      searchString = searchString + 'ruleCategory:' + rmanContTransLinesSearchObject.ruleCategory + ',';
    }

    if (rmanContTransLinesSearchObject.revenue != undefined && rmanContTransLinesSearchObject.revenue != "") {
      searchString = searchString + 'revenue:' + rmanContTransLinesSearchObject.revenue + ',';
    }

    if (rmanContTransLinesSearchObject.cogs != undefined && rmanContTransLinesSearchObject.cogs != "") {
      searchString = searchString + 'cogs:' + rmanContTransLinesSearchObject.cogs + ',';
    }

    if (rmanContTransLinesSearchObject.deferredMethod != undefined && rmanContTransLinesSearchObject.deferredMethod != "") {
      searchString = searchString + 'deferredMethod:' + rmanContTransLinesSearchObject.deferredMethod + ',';
    }

    if (rmanContTransLinesSearchObject.releaseType != undefined && rmanContTransLinesSearchObject.releaseType != "") {
      searchString = searchString + 'releaseType:' + rmanContTransLinesSearchObject.releaseType + ',';
    }

    if (rmanContTransLinesSearchObject.releaseCogs != undefined && rmanContTransLinesSearchObject.releaseCogs != "") {
      searchString = searchString + 'releaseCogs:' + rmanContTransLinesSearchObject.releaseCogs + ',';
    }

    if (rmanContTransLinesSearchObject.releaseRevenue != undefined && rmanContTransLinesSearchObject.releaseRevenue != "") {
      searchString = searchString + 'releaseRevenue:' + rmanContTransLinesSearchObject.releaseRevenue + ',';
    }

    if (rmanContTransLinesSearchObject.applyType != undefined && rmanContTransLinesSearchObject.applyType != "") {
      searchString = searchString + 'applyType:' + rmanContTransLinesSearchObject.applyType + ',';
    }

    if (rmanContTransLinesSearchObject.invoiceHold != undefined && rmanContTransLinesSearchObject.invoiceHold != "") {
      searchString = searchString + 'invoiceHold:' + rmanContTransLinesSearchObject.invoiceHold + ',';
    }

    if (rmanContTransLinesSearchObject.avgContAcceptDur != undefined && rmanContTransLinesSearchObject.avgContAcceptDur != "") {
      searchString = searchString + 'avgContAcceptDur:' + rmanContTransLinesSearchObject.avgContAcceptDur + ',';
    }

    if (rmanContTransLinesSearchObject.status != undefined && rmanContTransLinesSearchObject.status != "") {
      searchString = searchString + 'status:' + rmanContTransLinesSearchObject.status + ',';
    }

    if (rmanContTransLinesSearchObject.productName != undefined && rmanContTransLinesSearchObject.productName != "") {
      searchString = searchString + 'productName:' + rmanContTransLinesSearchObject.productName + ',';
    }

    if (rmanContTransLinesSearchObject.autoReleaseDays != undefined && rmanContTransLinesSearchObject.autoReleaseDays != "") {
      searchString = searchString + 'autoReleaseDays:' + rmanContTransLinesSearchObject.autoReleaseDays + ',';
    }

    if (rmanContTransLinesSearchObject.dealArrangementId != undefined && rmanContTransLinesSearchObject.dealArrangementId != "") {
      searchString = searchString + 'dealArrangementId:' + rmanContTransLinesSearchObject.dealArrangementId + ',';
    }

    if (rmanContTransLinesSearchObject.sourceHeaderId != undefined && rmanContTransLinesSearchObject.sourceHeaderId != "") {
      searchString = searchString + 'sourceHeaderId:' + rmanContTransLinesSearchObject.sourceHeaderId + ',';
    }

    if (rmanContTransLinesSearchObject.sourceLineId != undefined && rmanContTransLinesSearchObject.sourceLineId != "") {
      searchString = searchString + 'sourceLineId:' + rmanContTransLinesSearchObject.sourceLineId;
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

    return this.http.get(serviceUrl).toPromise().then((data:any) => {
      return data;
    });
  }


  saveRmanContTransLines(rmanContTransLines: any): Promise<any[]> {
    let body = JSON.stringify(rmanContTransLines);
    return this.http.post<any[]>(appSettings.apiUrl + '/RMAN_CONT_TRANS_LINES', body, httpOptions).toPromise().then(data => {
      return data;
    });
  }

  updateRmanContTransLines(rmanContTransLines: any): Promise<any[]> {
    delete rmanContTransLines.rmanContLinktemplateV2;
    delete rmanContTransLines._links;
    delete rmanContTransLines.interests;
    let body = JSON.stringify(rmanContTransLines);

    return this.http.put<any[]>(appSettings.apiUrl + '/RMAN_CONT_TRANS_LINES/' + rmanContTransLines.transLineId, body, httpOptions).toPromise().then(data => {
      return data;
    });

  }

  deleteRmanContTransLines(rmanContTransLines: any): Promise<any[]> {
    let deleteUrl = appSettings.apiUrl + '/RMAN_CONT_TRANS_LINES/' + rmanContTransLines.transLineId;
    return this.http.delete(deleteUrl, httpOptions).toPromise().then((data:any) => {
      return data;
    });
  }

  releaseRmanContengencies(transLineId: any, transHeaderId: any): Promise<any> {
    let body = "transHeaderId=" + transHeaderId + "&" + "transLineId=" + transLineId;
    let releaseUrl = appSettings.apiUrl + '/releaseContingency?' + body;
    return this.http.get(releaseUrl).toPromise().then((data: any) => {
      return data;
    }).catch(e=> {
    });
  }

}
