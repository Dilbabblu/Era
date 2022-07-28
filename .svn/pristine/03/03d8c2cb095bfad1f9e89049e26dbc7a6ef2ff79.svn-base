import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
declare var require:any;
const appSettings = require('../../appsettings');

const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
    })
  };

@Injectable()
export class AllExceptionsService {

  constructor(private http: HttpClient) {}
    getServiceUrl(paginationOptions: any, allExceptionsSearchObject: any, exportFlag:any, exportCols:any, exceptionType:any){
        allExceptionsSearchObject.processFlag = 'E';
        
        let serviceUrl= appSettings.apiUrl+'/ayaraDocTransactionsIntSearch?';

        if(exportFlag == 1){
          serviceUrl= appSettings.apiUrl+'/ayaraDocTransactionsIntExport?exceptionType=' + exceptionType +"&";
        }

        let searchString='';

        if (allExceptionsSearchObject.documentCategory!=undefined && allExceptionsSearchObject.documentCategory!="") {
            searchString=searchString+'documentCategory:'+allExceptionsSearchObject.documentCategory+','
        }

        if (allExceptionsSearchObject.processFlag!=undefined && allExceptionsSearchObject.processFlag!="") {
          searchString=searchString+'processFlag:'+allExceptionsSearchObject.processFlag+','
        }

        if (allExceptionsSearchObject.eventType!=undefined && allExceptionsSearchObject.eventType!="") {
          searchString=searchString+'eventType:'+allExceptionsSearchObject.eventType+','
        }

        if (allExceptionsSearchObject.documentSource!=undefined && allExceptionsSearchObject.documentSource!="") {
          searchString=searchString+'documentSource:'+allExceptionsSearchObject.documentSource+','
        }

        if (allExceptionsSearchObject.documentLineId!=undefined && allExceptionsSearchObject.documentLineId!="") {
          searchString=searchString+'documentLineId:'+allExceptionsSearchObject.documentLineId+','
        }

        if (allExceptionsSearchObject.processId!=undefined && allExceptionsSearchObject.processId!="") {
          searchString=searchString+'processId:'+allExceptionsSearchObject.processId+','
        }
        
        if (searchString == '') {
          serviceUrl = serviceUrl + 'search=%25';
        }
        else {
          serviceUrl = serviceUrl + 'search=' + searchString;
        }
       
        if (paginationOptions.pageNumber != undefined && paginationOptions.pageNumber != null && !isNaN(paginationOptions.pageNumber) ) {
          serviceUrl = serviceUrl + '&page=' + paginationOptions.pageNumber + '&size=' + paginationOptions.pageSize;
        }

        if(exportCols != undefined && exportCols != ""){
          serviceUrl=serviceUrl+'&exportCols='+exportCols;
        }

        return serviceUrl;
    }
    getAllExceptions(paginationOptions: any, allExceptionsSearchObject: any): Promise<any[]> {
        let serviceUrl = this.getServiceUrl(paginationOptions, allExceptionsSearchObject, 0, '', '');
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
          return data;
        });
    }
    
    deleteRmanOrdersInterface(rmanOrdersInterface) {
        let deleteUrl=appSettings.apiUrl+'/AYARA_DOC_TRANSACTIONS_INT/'+rmanOrdersInterface.trxId;               
        return this.http.delete(deleteUrl,httpOptions).toPromise().then(data => {
            return data;
        });
    }

    deleteSelectedLines(exceptionLines: any[]){

        let delUrl = appSettings.apiUrl + '/bulkDelExceptions?trxIds='+exceptionLines;
        return this.http.delete(delUrl,{responseType : "text"}).toPromise().then((data:any) => {
          return data;
        });
        
    }

}
