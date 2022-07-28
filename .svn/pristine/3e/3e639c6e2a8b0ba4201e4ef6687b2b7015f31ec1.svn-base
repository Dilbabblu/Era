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
export class RmanFcConversionTypesService {

    constructor(private http: HttpClient) {}
    
    getAllRmanFcConversionTypes(paginationOptions:any,rmanFcConversionTypesSearchObject:any): Promise<any[]> {
        let serviceUrl=appSettings.apiUrl+'/rmanFcConversionTypesSearch?';
        
        let searchString='';

        if (rmanFcConversionTypesSearchObject.conversionType!=undefined && rmanFcConversionTypesSearchObject.conversionType!="") {
            searchString=searchString+'conversionType:'+rmanFcConversionTypesSearchObject.conversionType+',';
        }

        if (rmanFcConversionTypesSearchObject.description!=undefined && rmanFcConversionTypesSearchObject.description!="") {
            searchString=searchString+'description:'+rmanFcConversionTypesSearchObject.description+',';
        }

        if (rmanFcConversionTypesSearchObject.startDate!=undefined && rmanFcConversionTypesSearchObject.startDate!="") {
            searchString=searchString+'startDate:'+rmanFcConversionTypesSearchObject.startDate+',';
        }

        if (rmanFcConversionTypesSearchObject.endDate!=undefined && rmanFcConversionTypesSearchObject.endDate!="") {
            searchString=searchString+'endDate:'+rmanFcConversionTypesSearchObject.endDate+',';
        }

        if (rmanFcConversionTypesSearchObject.attribute1!=undefined && rmanFcConversionTypesSearchObject.attribute1!="") {
            searchString=searchString+'attribute1:'+rmanFcConversionTypesSearchObject.attribute1+',';
        }

        if (rmanFcConversionTypesSearchObject.attribute2!=undefined && rmanFcConversionTypesSearchObject.attribute2!="") {
            searchString=searchString+'attribute2:'+rmanFcConversionTypesSearchObject.attribute2+',';
        }

        if (rmanFcConversionTypesSearchObject.attribute3!=undefined && rmanFcConversionTypesSearchObject.attribute3!="") {
            searchString=searchString+'attribute3:'+rmanFcConversionTypesSearchObject.attribute3+',';
        }

        if (rmanFcConversionTypesSearchObject.attribute4!=undefined && rmanFcConversionTypesSearchObject.attribute4!="") {
            searchString=searchString+'attribute4:'+rmanFcConversionTypesSearchObject.attribute4+',';
        }

        if (rmanFcConversionTypesSearchObject.attribute5!=undefined && rmanFcConversionTypesSearchObject.attribute5!="") {
            searchString=searchString+'attribute5:'+rmanFcConversionTypesSearchObject.attribute5+',';
        }

        if (rmanFcConversionTypesSearchObject.attribute6!=undefined && rmanFcConversionTypesSearchObject.attribute6!="") {
            searchString=searchString+'attribute6:'+rmanFcConversionTypesSearchObject.attribute6+',';
        }

        if (rmanFcConversionTypesSearchObject.attribute7!=undefined && rmanFcConversionTypesSearchObject.attribute7!="") {
            searchString=searchString+'attribute7:'+rmanFcConversionTypesSearchObject.attribute7+',';
        }

        if (rmanFcConversionTypesSearchObject.attribute8!=undefined && rmanFcConversionTypesSearchObject.attribute8!="") {
            searchString=searchString+'attribute8:'+rmanFcConversionTypesSearchObject.attribute8+',';
        }

        if (rmanFcConversionTypesSearchObject.attribute9!=undefined && rmanFcConversionTypesSearchObject.attribute9!="") {
            searchString=searchString+'attribute9:'+rmanFcConversionTypesSearchObject.attribute9+',';
        }

        if (rmanFcConversionTypesSearchObject.attribute10!=undefined && rmanFcConversionTypesSearchObject.attribute10!="") {
            searchString=searchString+'attribute10:'+rmanFcConversionTypesSearchObject.attribute10+',';
        }

        if (rmanFcConversionTypesSearchObject.attribute11!=undefined && rmanFcConversionTypesSearchObject.attribute11!="") {
            searchString=searchString+'attribute11:'+rmanFcConversionTypesSearchObject.attribute11+',';
        }

        if (rmanFcConversionTypesSearchObject.attribute12!=undefined && rmanFcConversionTypesSearchObject.attribute12!="") {
            searchString=searchString+'attribute12:'+rmanFcConversionTypesSearchObject.attribute12+',';
        }

        if (rmanFcConversionTypesSearchObject.attribute13!=undefined && rmanFcConversionTypesSearchObject.attribute13!="") {
            searchString=searchString+'attribute13:'+rmanFcConversionTypesSearchObject.attribute13+',';
        }

        if (rmanFcConversionTypesSearchObject.attribute14!=undefined && rmanFcConversionTypesSearchObject.attribute14!="") {
            searchString=searchString+'attribute14:'+rmanFcConversionTypesSearchObject.attribute14+',';
        }

        if (rmanFcConversionTypesSearchObject.attribute15!=undefined && rmanFcConversionTypesSearchObject.attribute15!="") {
            searchString=searchString+'attribute15:'+rmanFcConversionTypesSearchObject.attribute15+',';
        }

        if (rmanFcConversionTypesSearchObject.createdDate!=undefined && rmanFcConversionTypesSearchObject.createdDate!="") {
            searchString=searchString+'createdDate:'+rmanFcConversionTypesSearchObject.createdDate+',';
        }

        if (rmanFcConversionTypesSearchObject.createdBy!=undefined && rmanFcConversionTypesSearchObject.createdBy!="") {
            searchString=searchString+'createdBy:'+rmanFcConversionTypesSearchObject.createdBy+',';
        }

        if (rmanFcConversionTypesSearchObject.lastUpdatedDate!=undefined && rmanFcConversionTypesSearchObject.lastUpdatedDate!="") {
            searchString=searchString+'lastUpdatedDate:'+rmanFcConversionTypesSearchObject.lastUpdatedDate+',';
        }

        if (rmanFcConversionTypesSearchObject.lastUpdatedBy!=undefined && rmanFcConversionTypesSearchObject.lastUpdatedBy!="") {
            searchString=searchString+'lastUpdatedBy:'+rmanFcConversionTypesSearchObject.lastUpdatedBy;
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
                
        return this.http.get(serviceUrl).toPromise().then((data:any) => {
            return data;
        });
    }
    
    
    saveRmanFcConversionTypes(rmanFcConversionTypes:any): Promise<any[]> {
        let body = JSON.stringify(rmanFcConversionTypes);
        return this.http.post<any[]>(appSettings.apiUrl+'/RMAN_FC_CONVERSION_TYPES',body,httpOptions).toPromise().then(data => {
            return data;
        });
    }
    
    updateRmanFcConversionTypes(rmanFcConversionTypes:any): Promise<any[]> {
        
        delete rmanFcConversionTypes._links;
        delete rmanFcConversionTypes.interests;
        let body = JSON.stringify(rmanFcConversionTypes);
        return this.http.put<any[]>(appSettings.apiUrl+'/RMAN_FC_CONVERSION_TYPES/'+rmanFcConversionTypes.conversionType,body,httpOptions).toPromise().then(data => {
            return data;
        });
        
    }
    
    deleteRmanFcConversionTypes(rmanFcConversionTypes:any): Promise<any[]> {
        let deleteUrl=appSettings.apiUrl+'/RMAN_FC_CONVERSION_TYPES/'+rmanFcConversionTypes.conversionType;
        return this.http.delete(deleteUrl,httpOptions).toPromise().then((data:any) => {
            return data;
        });
    }

}
