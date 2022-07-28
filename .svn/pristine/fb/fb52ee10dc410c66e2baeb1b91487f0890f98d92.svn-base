import { DatePipe } from '@angular/common';
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
export class RmanGlAccountingVService {

    constructor(private http: HttpClient,private datePipe:DatePipe) {}


    getServiceUrl(paginationOptions: any, rmanGlAccountingVSearchObject: any,exportCols: any, exportFlag: any) {

      let serviceUrl = appSettings.apiUrl + '/rmanGlAccountingVExport?';

      if (exportFlag == 0) {
        serviceUrl = appSettings.apiUrl + '/rmanGlAccountingVSearch?';
      }

        let searchString='';

        if (rmanGlAccountingVSearchObject.dealArrangementId!=undefined && rmanGlAccountingVSearchObject.dealArrangementId!="") {
            searchString=searchString+'dealArrangementId:'+rmanGlAccountingVSearchObject.dealArrangementId+',';
        }


        if (rmanGlAccountingVSearchObject.rmanInterfaceId!=undefined && rmanGlAccountingVSearchObject.rmanInterfaceId!="") {
            searchString=searchString+'rmanInterfaceId:'+rmanGlAccountingVSearchObject.rmanInterfaceId+',';
        }

        if (rmanGlAccountingVSearchObject.orderNumber!=undefined && rmanGlAccountingVSearchObject.orderNumber!="") {
            searchString=searchString+'orderNumber:'+rmanGlAccountingVSearchObject.orderNumber+',';
        }

        if (rmanGlAccountingVSearchObject.sourceLineNumber!=undefined && rmanGlAccountingVSearchObject.sourceLineNumber!="") {
            searchString=searchString+'sourceLineNumber:'+rmanGlAccountingVSearchObject.sourceLineNumber+',';
        }

        if (rmanGlAccountingVSearchObject.dealLineNumber!=undefined && rmanGlAccountingVSearchObject.dealLineNumber!="") {
            searchString=searchString+'dealLineNumber:'+rmanGlAccountingVSearchObject.dealLineNumber+',';
        }

        if (rmanGlAccountingVSearchObject.dealLineId!=undefined && rmanGlAccountingVSearchObject.dealLineId!="") {
            searchString=searchString+'dealLineId:'+rmanGlAccountingVSearchObject.dealLineId+',';
        }

        if (rmanGlAccountingVSearchObject.lineStatus!=undefined && rmanGlAccountingVSearchObject.lineStatus!="") {
            searchString=searchString+'lineStatus:'+rmanGlAccountingVSearchObject.lineStatus+',';
        }

        if (rmanGlAccountingVSearchObject.glDate!=undefined && rmanGlAccountingVSearchObject.glDate!="") {
            searchString=searchString+'glDate:'+rmanGlAccountingVSearchObject.glDate+',';
        }

        if (rmanGlAccountingVSearchObject.periodName!=undefined && rmanGlAccountingVSearchObject.periodName!="") {
            searchString=searchString+'periodName:'+rmanGlAccountingVSearchObject.periodName+',';
        }

        if (rmanGlAccountingVSearchObject.drCr!=undefined && rmanGlAccountingVSearchObject.drCr!="") {
            searchString=searchString+'drCr:'+rmanGlAccountingVSearchObject.drCr+',';
        }

        if (rmanGlAccountingVSearchObject.account!=undefined && rmanGlAccountingVSearchObject.account!="") {
            searchString=searchString+'account:'+rmanGlAccountingVSearchObject.account+',';
        }

        if (rmanGlAccountingVSearchObject.accountDescription!=undefined && rmanGlAccountingVSearchObject.accountDescription!="") {
            searchString=searchString+'accountDescription:'+rmanGlAccountingVSearchObject.accountDescription+',';
        }

        if (rmanGlAccountingVSearchObject.currencyCode!=undefined && rmanGlAccountingVSearchObject.currencyCode!="") {
            searchString=searchString+'currencyCode:'+rmanGlAccountingVSearchObject.currencyCode+',';
        }

        if (rmanGlAccountingVSearchObject.amountTc!=undefined && rmanGlAccountingVSearchObject.amountTc!="") {
            searchString=searchString+'amountTc:'+rmanGlAccountingVSearchObject.amountTc+',';
        }

        if (rmanGlAccountingVSearchObject.amountFc!=undefined && rmanGlAccountingVSearchObject.amountFc!="") {
            searchString=searchString+'amountFc:'+rmanGlAccountingVSearchObject.amountFc+',';
        }

        if (rmanGlAccountingVSearchObject.postedFlag!=undefined && rmanGlAccountingVSearchObject.postedFlag!="") {
            searchString=searchString+'postedFlag:'+rmanGlAccountingVSearchObject.postedFlag;
        }

        if (rmanGlAccountingVSearchObject.fromArrgId!=undefined && rmanGlAccountingVSearchObject.fromArrgId!="") {
            searchString=searchString+'dealArrangementId>'+rmanGlAccountingVSearchObject.fromArrgId+',';
        }

        if (rmanGlAccountingVSearchObject.toArrgId!=undefined && rmanGlAccountingVSearchObject.toArrgId!="") {
            searchString=searchString+'dealArrangementId<'+rmanGlAccountingVSearchObject.toArrgId+',';
        }

        
        if(rmanGlAccountingVSearchObject.fromPeriod != undefined && rmanGlAccountingVSearchObject.fromPeriod != null){
            searchString=searchString+'glDate>'+ this.datePipe.transform(rmanGlAccountingVSearchObject.fromPeriod,'yyyyMMdd')+',';
        }
        
        if(rmanGlAccountingVSearchObject.toPeriod != undefined && rmanGlAccountingVSearchObject.toPeriod != null){
            searchString=searchString+'glDate<'+ this.datePipe.transform(rmanGlAccountingVSearchObject.toPeriod,'yyyyMMdd')+',';
        }

        if (searchString == '') {
            serviceUrl=serviceUrl+'search=%25';
        }
        else {
            serviceUrl=serviceUrl+'search='+searchString;
        }

        if (paginationOptions.pageNumber!=undefined && paginationOptions.pageNumber!="" && !isNaN(paginationOptions.pageNumber)) {
           serviceUrl=serviceUrl+'&page='+paginationOptions.pageNumber+'&size='+paginationOptions.pageSize;
        }

        if(exportCols!=undefined && exportCols!=""){
            serviceUrl=serviceUrl+'&exportCols='+exportCols;
        }
          return serviceUrl;
      }

      getAllRmanGlAccountingV(paginationOptions: any, rmanContReleaseEventsVSearchObject: any, exportCols: any): Promise<any[]> {
        let serviceUrl = this.getServiceUrl(paginationOptions, rmanContReleaseEventsVSearchObject,exportCols, 0);
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
          return data;
        });
      }


    saveRmanGlAccountingV(rmanGlAccountingV:any) {
        let body = JSON.stringify(rmanGlAccountingV);
      
        return this.http.post(appSettings.apiUrl+'/RMAN_GL_ACCOUNTING_V',body,httpOptions).toPromise().then(data => {
            return data;
        });
    }

    updateRmanGlAccountingV(rmanGlAccountingV:any) {

        delete rmanGlAccountingV._links;
        delete rmanGlAccountingV.interests;
        let body = JSON.stringify(rmanGlAccountingV);
     
        return this.http.put(appSettings.apiUrl+'/RMAN_GL_ACCOUNTING_V/'+rmanGlAccountingV.rmanInterfaceId,body,httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanGlAccountingV(rmanGlAccountingV:any) {
        let deleteUrl=appSettings.apiUrl+'/RMAN_GL_ACCOUNTING_V/'+rmanGlAccountingV.rmanInterfaceId;
     
        return this.http.delete(deleteUrl,httpOptions).toPromise().then(data => {
            return data;
        });
    }

}
