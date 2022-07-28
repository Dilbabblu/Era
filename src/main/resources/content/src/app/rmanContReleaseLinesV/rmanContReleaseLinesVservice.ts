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
export class RmanContReleaseLinesVService {

    constructor(private http: HttpClient) {}

    getServiceUrl(paginationOptions: any, rmanContReleaseLinesVSearchObject: any, exportFlag: any, exportCols: any) {

      let serviceUrl = appSettings.apiUrl + '/rmanContReleaseLinesVExport?';

      if (exportFlag == 0) {
        serviceUrl = appSettings.apiUrl + '/rmanContReleaseLinesVSearch?';
      }

      let searchString='';

        if (rmanContReleaseLinesVSearchObject.releaseLineId!=undefined && rmanContReleaseLinesVSearchObject.releaseLineId!="") {
            searchString=searchString+'releaseLineId:'+rmanContReleaseLinesVSearchObject.releaseLineId+',';
        }

        if (rmanContReleaseLinesVSearchObject.transLineId!=undefined && rmanContReleaseLinesVSearchObject.transLineId!="") {
            searchString=searchString+'transLineId:'+rmanContReleaseLinesVSearchObject.transLineId+',';
        }

        if (rmanContReleaseLinesVSearchObject.transHeaderId!=undefined && rmanContReleaseLinesVSearchObject.transHeaderId!="") {
            searchString=searchString+'transHeaderId:'+rmanContReleaseLinesVSearchObject.transHeaderId+',';
        }

        if (rmanContReleaseLinesVSearchObject.dealArrangementId!=undefined && rmanContReleaseLinesVSearchObject.dealArrangementId!="") {
            searchString=searchString+'dealArrangementId:'+rmanContReleaseLinesVSearchObject.dealArrangementId+',';
        }

        if (rmanContReleaseLinesVSearchObject.releaseLevel!=undefined && rmanContReleaseLinesVSearchObject.releaseLevel!="") {
            searchString=searchString+'releaseLevel:'+rmanContReleaseLinesVSearchObject.releaseLevel+',';
        }

        if (rmanContReleaseLinesVSearchObject.ruleName!=undefined && rmanContReleaseLinesVSearchObject.ruleName!="") {
            searchString=searchString+'ruleName:'+rmanContReleaseLinesVSearchObject.ruleName+',';
        }

        if (rmanContReleaseLinesVSearchObject.templateName!=undefined && rmanContReleaseLinesVSearchObject.templateName!="") {
            searchString=searchString+'templateName:'+rmanContReleaseLinesVSearchObject.templateName+',';
        }

        if (rmanContReleaseLinesVSearchObject.sourceHeader!=undefined && rmanContReleaseLinesVSearchObject.sourceHeader!="") {
            searchString=searchString+'sourceHeader:'+rmanContReleaseLinesVSearchObject.sourceHeader+',';
        }

        if (rmanContReleaseLinesVSearchObject.sourceLineNumber!=undefined && rmanContReleaseLinesVSearchObject.sourceLineNumber!="") {
            searchString=searchString+'sourceLineNumber:'+rmanContReleaseLinesVSearchObject.sourceLineNumber+',';
        }

        if (rmanContReleaseLinesVSearchObject.elementType!=undefined && rmanContReleaseLinesVSearchObject.elementType!="") {
            searchString=searchString+'elementType:'+rmanContReleaseLinesVSearchObject.elementType+',';
        }

        if (rmanContReleaseLinesVSearchObject.productGroup!=undefined && rmanContReleaseLinesVSearchObject.productGroup!="") {
            searchString=searchString+'productGroup:'+rmanContReleaseLinesVSearchObject.productGroup+',';
        }

        if (rmanContReleaseLinesVSearchObject.productCategory!=undefined && rmanContReleaseLinesVSearchObject.productCategory!="") {
            searchString=searchString+'productCategory:'+rmanContReleaseLinesVSearchObject.productCategory+',';
        }

        if (rmanContReleaseLinesVSearchObject.productName!=undefined && rmanContReleaseLinesVSearchObject.productName!="") {
            searchString=searchString+'productName:'+rmanContReleaseLinesVSearchObject.productName+',';
        }

        if (rmanContReleaseLinesVSearchObject.applyType!=undefined && rmanContReleaseLinesVSearchObject.applyType!="") {
            searchString=searchString+'applyType:'+rmanContReleaseLinesVSearchObject.applyType+',';
        }

        if (rmanContReleaseLinesVSearchObject.revenue!=undefined && rmanContReleaseLinesVSearchObject.revenue!="") {
            searchString=searchString+'revenue:'+rmanContReleaseLinesVSearchObject.revenue+',';
        }

        if (rmanContReleaseLinesVSearchObject.cogs!=undefined && rmanContReleaseLinesVSearchObject.cogs!="") {
            searchString=searchString+'cogs:'+rmanContReleaseLinesVSearchObject.cogs+',';
        }

        if (rmanContReleaseLinesVSearchObject.releaseRevenue!=undefined && rmanContReleaseLinesVSearchObject.releaseRevenue!="") {
            searchString=searchString+'releaseRevenue:'+rmanContReleaseLinesVSearchObject.releaseRevenue+',';
        }

        if (rmanContReleaseLinesVSearchObject.releaseCogs!=undefined && rmanContReleaseLinesVSearchObject.releaseCogs!="") {
            searchString=searchString+'releaseCogs:'+rmanContReleaseLinesVSearchObject.releaseCogs+',';
        }

        if (rmanContReleaseLinesVSearchObject.event!=undefined && rmanContReleaseLinesVSearchObject.event!="") {
            searchString=searchString+'event:'+rmanContReleaseLinesVSearchObject.event+',';
        }

        if (rmanContReleaseLinesVSearchObject.releaseDate!=undefined && rmanContReleaseLinesVSearchObject.releaseDate!="") {
            searchString=searchString+'releaseDate:'+rmanContReleaseLinesVSearchObject.releaseDate+',';
        }

        if (rmanContReleaseLinesVSearchObject.releaseType!=undefined && rmanContReleaseLinesVSearchObject.releaseType!="") {
            searchString=searchString+'releaseType:'+rmanContReleaseLinesVSearchObject.releaseType;
        }

        if (searchString == '') {
            serviceUrl=serviceUrl+'search=%25';
        }
        else {
            serviceUrl=serviceUrl+'search='+searchString;
        }

        if (paginationOptions.pageNumber!=undefined && paginationOptions.pageNumber!="" && !isNaN(paginationOptions.pageNumber) && paginationOptions.pageNumber!=0) {
           serviceUrl=serviceUrl+'&page='+paginationOptions.pageNumber+'&size='+paginationOptions.pageSize;
        }

        if(exportCols!=undefined && exportCols!=""){
            serviceUrl=serviceUrl+'&exportCols='+exportCols;
        }

          return serviceUrl;
    }

    getAllRmanContReleaseLinesV(paginationOptions: any, rmanContReleaseLinesVSearchObject: any, exportCols: any): Promise<any[]> {

      let serviceUrl = this.getServiceUrl(paginationOptions, rmanContReleaseLinesVSearchObject, 0, exportCols);
      return this.http.get(serviceUrl).toPromise().then((data: any) => {
        return data;
      });
    }


    saveRmanContReleaseLinesV(rmanContReleaseLinesV:any) {
        let body = JSON.stringify(rmanContReleaseLinesV);
       
        return this.http.post(appSettings.apiUrl+'/RMAN_CONT_RELEASE_LINES_V',body,httpOptions).toPromise().then(data => {
            return data
        });
    }

    updateRmanContReleaseLinesV(rmanContReleaseLinesV:any) {

        delete rmanContReleaseLinesV._links;
        delete rmanContReleaseLinesV.interests;
        let body = JSON.stringify(rmanContReleaseLinesV);
       
        return this.http.put(appSettings.apiUrl+'/RMAN_CONT_RELEASE_LINES_V/'+rmanContReleaseLinesV.releaseLineId,body,httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanContReleaseLinesV(rmanContReleaseLinesV:any) {
        let deleteUrl=appSettings.apiUrl+'/RMAN_CONT_RELEASE_LINES_V/'+rmanContReleaseLinesV.releaseLineId;
    
        return this.http.delete(deleteUrl,httpOptions).toPromise().then(data => {
            return data;
        });
    }

}
