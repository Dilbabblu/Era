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
export class RmanConversionRatesService {

    constructor(private http: HttpClient,private datePipe: DatePipe) {}
    
    getServiceUrl(paginationOptions: any,rmanConversionRatesSearchObject: any, exportCols: any, exportFlag?: any) {
        let serviceUrl = appSettings.apiUrl + '/rmanConversionRatesExport?';

        if (exportFlag == 0) {
            serviceUrl = appSettings.apiUrl + '/rmanConversionRatesSearch?';
        }
        
        let searchString='';

        if (rmanConversionRatesSearchObject.fromCurrency!=undefined && rmanConversionRatesSearchObject.fromCurrency!="") {
            searchString=searchString+'fromCurrency:'+rmanConversionRatesSearchObject.fromCurrency+',';
        }

        if (rmanConversionRatesSearchObject.toCurrency!=undefined && rmanConversionRatesSearchObject.toCurrency!="") {
            searchString=searchString+'toCurrency:'+rmanConversionRatesSearchObject.toCurrency+',';
        }

        if (rmanConversionRatesSearchObject.conversionType!=undefined && rmanConversionRatesSearchObject.conversionType!="") {
            searchString=searchString+'conversionType:'+rmanConversionRatesSearchObject.conversionType+',';
        }

        if (rmanConversionRatesSearchObject.conversionRate!=undefined && rmanConversionRatesSearchObject.conversionRate!="") {
            searchString=searchString+'conversionRate:'+rmanConversionRatesSearchObject.conversionRate+',';
        }

        if (rmanConversionRatesSearchObject.conversionStartDate!=undefined && rmanConversionRatesSearchObject.conversionStartDate!="") {
            searchString=searchString+'conversionStartDate:'+rmanConversionRatesSearchObject.conversionStartDate+',';
        }

        if (rmanConversionRatesSearchObject.conversionEndDate!=undefined && rmanConversionRatesSearchObject.conversionEndDate!="") {
            searchString=searchString+'conversionEndDate:'+rmanConversionRatesSearchObject.conversionEndDate+',';
        }

        if (rmanConversionRatesSearchObject.attribute1!=undefined && rmanConversionRatesSearchObject.attribute1!="") {
            searchString=searchString+'attribute1:'+rmanConversionRatesSearchObject.attribute1+',';
        }

        if (rmanConversionRatesSearchObject.attribute2!=undefined && rmanConversionRatesSearchObject.attribute2!="") {
            searchString=searchString+'attribute2:'+rmanConversionRatesSearchObject.attribute2+',';
        }

        if (rmanConversionRatesSearchObject.attribute3!=undefined && rmanConversionRatesSearchObject.attribute3!="") {
            searchString=searchString+'attribute3:'+rmanConversionRatesSearchObject.attribute3+',';
        }

        if (rmanConversionRatesSearchObject.attribute4!=undefined && rmanConversionRatesSearchObject.attribute4!="") {
            searchString=searchString+'attribute4:'+rmanConversionRatesSearchObject.attribute4+',';
        }

        if (rmanConversionRatesSearchObject.attribute5!=undefined && rmanConversionRatesSearchObject.attribute5!="") {
            searchString=searchString+'attribute5:'+rmanConversionRatesSearchObject.attribute5+',';
        }

        if (rmanConversionRatesSearchObject.attribute6!=undefined && rmanConversionRatesSearchObject.attribute6!="") {
            searchString=searchString+'attribute6:'+rmanConversionRatesSearchObject.attribute6+',';
        }

        if (rmanConversionRatesSearchObject.attribute7!=undefined && rmanConversionRatesSearchObject.attribute7!="") {
            searchString=searchString+'attribute7:'+rmanConversionRatesSearchObject.attribute7+',';
        }

        if (rmanConversionRatesSearchObject.attribute8!=undefined && rmanConversionRatesSearchObject.attribute8!="") {
            searchString=searchString+'attribute8:'+rmanConversionRatesSearchObject.attribute8+',';
        }

        if (rmanConversionRatesSearchObject.attribute9!=undefined && rmanConversionRatesSearchObject.attribute9!="") {
            searchString=searchString+'attribute9:'+rmanConversionRatesSearchObject.attribute9+',';
        }

        if (rmanConversionRatesSearchObject.attribute10!=undefined && rmanConversionRatesSearchObject.attribute10!="") {
            searchString=searchString+'attribute10:'+rmanConversionRatesSearchObject.attribute10+',';
        }

        if (rmanConversionRatesSearchObject.attribute11!=undefined && rmanConversionRatesSearchObject.attribute11!="") {
            searchString=searchString+'attribute11:'+rmanConversionRatesSearchObject.attribute11+',';
        }

        if (rmanConversionRatesSearchObject.attribute12!=undefined && rmanConversionRatesSearchObject.attribute12!="") {
            searchString=searchString+'attribute12:'+rmanConversionRatesSearchObject.attribute12+',';
        }

        if (rmanConversionRatesSearchObject.attribute13!=undefined && rmanConversionRatesSearchObject.attribute13!="") {
            searchString=searchString+'attribute13:'+rmanConversionRatesSearchObject.attribute13+',';
        }

        if (rmanConversionRatesSearchObject.attribute14!=undefined && rmanConversionRatesSearchObject.attribute14!="") {
            searchString=searchString+'attribute14:'+rmanConversionRatesSearchObject.attribute14+',';
        }

        if (rmanConversionRatesSearchObject.attribute15!=undefined && rmanConversionRatesSearchObject.attribute15!="") {
            searchString=searchString+'attribute15:'+rmanConversionRatesSearchObject.attribute15+',';
        }

        if (rmanConversionRatesSearchObject.createdDate!=undefined && rmanConversionRatesSearchObject.createdDate!="") {
            searchString=searchString+'createdDate:'+rmanConversionRatesSearchObject.createdDate+',';
        }

        if (rmanConversionRatesSearchObject.createdBy!=undefined && rmanConversionRatesSearchObject.createdBy!="") {
            searchString=searchString+'createdBy:'+rmanConversionRatesSearchObject.createdBy+',';
        }

        if (rmanConversionRatesSearchObject.lastUpdatedDate!=undefined && rmanConversionRatesSearchObject.lastUpdatedDate!="") {
            searchString=searchString+'lastUpdatedDate:'+rmanConversionRatesSearchObject.lastUpdatedDate+',';
        }

        if (rmanConversionRatesSearchObject.lastUpdatedBy!=undefined && rmanConversionRatesSearchObject.lastUpdatedBy!="") {
            searchString=searchString+'lastUpdatedBy:'+rmanConversionRatesSearchObject.lastUpdatedBy;
        }

        if (rmanConversionRatesSearchObject.statusCode!=undefined && rmanConversionRatesSearchObject.statusCode!="") {
            searchString=searchString+'statusCode:'+rmanConversionRatesSearchObject.statusCode;
        }

        if (rmanConversionRatesSearchObject.conversionDate!=undefined && rmanConversionRatesSearchObject.conversionDate!="") {
             searchString=searchString+'conversionDate:'+ this.datePipe.transform(rmanConversionRatesSearchObject.conversionDate,'yyyyMMdd')+',';
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

        if(exportCols !=undefined && exportCols!=null){
            serviceUrl = serviceUrl+'&exportCols='+exportCols;
        }

        return serviceUrl;
    }

    getAllRmanConversionRates(paginationOptions: any,rmanConversionRatesSearchObject: any, exportCols: any) {
        let serviceUrl = this.getServiceUrl(paginationOptions, rmanConversionRatesSearchObject, exportCols, 0);
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }
    
	searchRmanConversionRates(rmanConversionRates) {
        return this.http.get(appSettings.apiUrl+'/RMAN_CONVERSION_RATES/search/findByFromCurrencyAndToCurrencyAndConversionTypeAndConversionRateAndConversionStartDateAndConversionEndDateAndAttribute1AndAttribute2AndAttribute3AndAttribute4AndAttribute5AndAttribute6AndAttribute7AndAttribute8AndAttribute9AndAttribute10AndAttribute11AndAttribute12AndAttribute13AndAttribute14AndAttribute15AndCreatedDateAndCreatedByAndLastUpdatedDateAndLastUpdatedBy?fromCurrency='+rmanConversionRates.fromCurrency+'&toCurrency='+rmanConversionRates.toCurrency+'&conversionType='+rmanConversionRates.conversionType+'&conversionRate='+rmanConversionRates.conversionRate+'&conversionStartDate='+rmanConversionRates.conversionStartDate+'&conversionEndDate='+rmanConversionRates.conversionEndDate+'&attribute1='+rmanConversionRates.attribute1+'&attribute2='+rmanConversionRates.attribute2+'&attribute3='+rmanConversionRates.attribute3+'&attribute4='+rmanConversionRates.attribute4+'&attribute5='+rmanConversionRates.attribute5+'&attribute6='+rmanConversionRates.attribute6+'&attribute7='+rmanConversionRates.attribute7+'&attribute8='+rmanConversionRates.attribute8+'&attribute9='+rmanConversionRates.attribute9+'&attribute10='+rmanConversionRates.attribute10+'&attribute11='+rmanConversionRates.attribute11+'&attribute12='+rmanConversionRates.attribute12+'&attribute13='+rmanConversionRates.attribute13+'&attribute14='+rmanConversionRates.attribute14+'&attribute15='+rmanConversionRates.attribute15+'&createdDate='+rmanConversionRates.createdDate+'&createdBy='+rmanConversionRates.createdBy+'&lastUpdatedDate='+rmanConversionRates.lastUpdatedDate+'&lastUpdatedBy='+rmanConversionRates.lastUpdatedBy).toPromise().then(data => {
			return data; 
			});
    }
    
    saveRmanConversionRates(rmanConversionRates) {
        let body = JSON.stringify(rmanConversionRates);
   
        return this.http.post(appSettings.apiUrl+'/RMAN_CONVERSION_RATES',body,httpOptions).toPromise().then(data => {
            return data;
        });
    }
    
    updateRmanConversionRates(rmanConversionRates) {
        
        delete rmanConversionRates._links;
        delete rmanConversionRates.interests;
        let body = JSON.stringify(rmanConversionRates);
        return this.http.put(appSettings.apiUrl+'/RMAN_CONVERSION_RATES/'+rmanConversionRates.fromCurrency,body,httpOptions).toPromise().then(data => {
            return data;
        });
        
    }
    
    deleteRmanConversionRates(rmanConversionRates) {
        let deleteUrl=appSettings.apiUrl+'/RMAN_CONVERSION_RATES/'+rmanConversionRates.fromCurrency;
        return this.http.delete(deleteUrl,httpOptions).toPromise().then(data => {
            return data;
        });
    }

}
