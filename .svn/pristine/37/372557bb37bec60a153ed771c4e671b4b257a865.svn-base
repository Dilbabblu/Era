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
export class RmanContProdNameLovVService {

    constructor(private http: HttpClient) {}
    
    getAllRmanContProdNameLovV(paginationOptions:any,rmanContProdNameLovVSearchObject:any): Promise<any[]> {
        let serviceUrl=appSettings.apiUrl+'/rmanContProdNameLovVSearch?';
        
        let searchString='';

        if (rmanContProdNameLovVSearchObject.sno!=undefined && rmanContProdNameLovVSearchObject.sno!="") {
            searchString=searchString+'sno:'+rmanContProdNameLovVSearchObject.sno+',';
        }

        if (rmanContProdNameLovVSearchObject.dealArrangementId!=undefined && rmanContProdNameLovVSearchObject.dealArrangementId!="") {
            searchString=searchString+'dealArrangementId:'+rmanContProdNameLovVSearchObject.dealArrangementId+',';
        }

        if (rmanContProdNameLovVSearchObject.elementType!=undefined && rmanContProdNameLovVSearchObject.elementType!="") {
            searchString=searchString+'elementType:'+rmanContProdNameLovVSearchObject.elementType+',';
        }

        if (rmanContProdNameLovVSearchObject.productCategory!=undefined && rmanContProdNameLovVSearchObject.productCategory!="") {
            searchString=searchString+'productCategory:'+rmanContProdNameLovVSearchObject.productCategory+',';
        }

        if (rmanContProdNameLovVSearchObject.productType!=undefined && rmanContProdNameLovVSearchObject.productType!="") {
            searchString=searchString+'productType:'+rmanContProdNameLovVSearchObject.productType+',';
        }

        if (rmanContProdNameLovVSearchObject.productName!=undefined && rmanContProdNameLovVSearchObject.productName!="") {
            searchString=searchString+'productName:'+rmanContProdNameLovVSearchObject.productName;
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
    

    
    saveRmanContProdNameLovV(rmanContProdNameLovV:any): Promise<any[]> {
        let body = JSON.stringify(rmanContProdNameLovV);
        return this.http.post<any[]>(appSettings.apiUrl+'/RMAN_CONT_PROD_NAME_LOV_V',body,httpOptions).toPromise().then(data => {
            return data;
        });
    }
    
    updateRmanContProdNameLovV(rmanContProdNameLovV:any): Promise<any[]> {
        
        delete rmanContProdNameLovV._links;
        delete rmanContProdNameLovV.interests;
        let body = JSON.stringify(rmanContProdNameLovV);
        return this.http.put<any[]>(appSettings.apiUrl+'/RMAN_CONT_PROD_NAME_LOV_V/'+rmanContProdNameLovV.sno,body,httpOptions).toPromise().then(data => {
            return data;
        });
        
    }
    
    deleteRmanContProdNameLovV(rmanContProdNameLovV:any): Promise<any[]> {
        let deleteUrl=appSettings.apiUrl+'/RMAN_CONT_PROD_NAME_LOV_V/'+rmanContProdNameLovV.sno;
        return this.http.delete(deleteUrl,httpOptions).toPromise().then((data:any) => {
            return data;
        });
    }

}
