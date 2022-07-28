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
export class RmanCurrencyService {

    constructor(private http: HttpClient) {}

    getAllRmanCurrency(paginationOptions:any,rmanCurrencySearchObject:any, action?:any): Promise<any[]> {
        let serviceUrl=appSettings.apiUrl+'/rmanCurrencySearch?';

        let searchString='';

        if (rmanCurrencySearchObject.currencyCode!=undefined && rmanCurrencySearchObject.currencyCode!="") {
            searchString=searchString+'currencyCode:'+rmanCurrencySearchObject.currencyCode+',';
        }

        if (rmanCurrencySearchObject.name!=undefined && rmanCurrencySearchObject.name!="") {
            searchString=searchString+'name:'+rmanCurrencySearchObject.name+',';
        }

        if (rmanCurrencySearchObject.format!=undefined && rmanCurrencySearchObject.format!="") {
            searchString=searchString+'format:'+rmanCurrencySearchObject.format;
        }


       if (action) {
        if (searchString == '') {
            serviceUrl=serviceUrl+'search=%25';
        }
        else {
            serviceUrl=serviceUrl+'search='+searchString;
        }
       } else {
        if (searchString == '') {
            serviceUrl=serviceUrl+'search=%25&size=10000';
        }
        else {
            serviceUrl=serviceUrl+'search='+searchString+'&size=10000';
        }
       }
      

        if (paginationOptions.pageNumber!=undefined && paginationOptions.pageNumber!="" && !isNaN(paginationOptions.pageNumber) && paginationOptions.pageNumber!=0) {
           serviceUrl=serviceUrl+'&page='+paginationOptions.pageNumber+'&size='+paginationOptions.pageSize;
        }

        return this.http.get(serviceUrl).toPromise().then((data:any) => {
            return data;
        });
    }


    saveRmanCurrency(rmanCurrency:any): Promise<any[]> {
        let body = JSON.stringify(rmanCurrency);
        return this.http.post<any[]>(appSettings.apiUrl+'/RMAN_CURRENCY',body,httpOptions).toPromise().then(data => {
            return data;
        });
    }

    updateRmanCurrency(rmanCurrency:any): Promise<any[]> {

        delete rmanCurrency._links;
        delete rmanCurrency.interests;
        let body = JSON.stringify(rmanCurrency);
        return this.http.put<any[]>(appSettings.apiUrl+'/RMAN_CURRENCY/'+rmanCurrency.currencyCode,body,httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanCurrency(rmanCurrency:any): Promise<any[]> {
        let deleteUrl=appSettings.apiUrl+'/RMAN_CURRENCY/'+rmanCurrency.currencyCode;
        return this.http.delete(deleteUrl,httpOptions).toPromise().then((data:any) => {
            return data;
        });
    }

}
