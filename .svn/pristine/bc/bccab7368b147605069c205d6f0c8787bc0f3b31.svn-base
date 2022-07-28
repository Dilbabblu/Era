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
export class RmanDealStatusService {

    constructor(private http: HttpClient) {}

    getAllRmanDealStatus(paginationOptions:any,rmanDealStatusSearchObject:any) {
        let serviceUrl=appSettings.apiUrl+'/rmanDealStatusSearch?';

        let searchString='';

        if (rmanDealStatusSearchObject.dealHeaderId!=undefined && rmanDealStatusSearchObject.dealHeaderId!="") {
            searchString=searchString+'dealHeaderId:'+rmanDealStatusSearchObject.dealHeaderId+',';
        }

        if (rmanDealStatusSearchObject.dealStatus!=undefined && rmanDealStatusSearchObject.dealStatus!="") {
            searchString=searchString+'dealStatus:'+rmanDealStatusSearchObject.dealStatus+',';
        }

        if (rmanDealStatusSearchObject.analystId!=undefined && rmanDealStatusSearchObject.analystId!="") {
            searchString=searchString+'analystId:'+rmanDealStatusSearchObject.analystId+',';
        }

        if (rmanDealStatusSearchObject.analystComments!=undefined && rmanDealStatusSearchObject.analystComments!="") {
            searchString=searchString+'analystComments:'+rmanDealStatusSearchObject.analystComments+',';
        }

        if (rmanDealStatusSearchObject.approverId!=undefined && rmanDealStatusSearchObject.approverId!="") {
            searchString=searchString+'approverId:'+rmanDealStatusSearchObject.approverId+',';
        }

        if (rmanDealStatusSearchObject.approverComments!=undefined && rmanDealStatusSearchObject.approverComments!="") {
            searchString=searchString+'approverComments:'+rmanDealStatusSearchObject.approverComments+',';
        }

        if (rmanDealStatusSearchObject.approvedBy!=undefined && rmanDealStatusSearchObject.approvedBy!="") {
            searchString=searchString+'approvedBy:'+rmanDealStatusSearchObject.approvedBy+',';
        }

        if (rmanDealStatusSearchObject.approvalDate!=undefined && rmanDealStatusSearchObject.approvalDate!="") {
            searchString=searchString+'approvalDate:'+rmanDealStatusSearchObject.approvalDate+',';
        }

        if (rmanDealStatusSearchObject.submittedBy!=undefined && rmanDealStatusSearchObject.submittedBy!="") {
            searchString=searchString+'submittedBy:'+rmanDealStatusSearchObject.submittedBy+',';
        }

        if (rmanDealStatusSearchObject.submissionDate!=undefined && rmanDealStatusSearchObject.submissionDate!="") {
            searchString=searchString+'submissionDate:'+rmanDealStatusSearchObject.submissionDate+',';
        }

        if (rmanDealStatusSearchObject.createdDate!=undefined && rmanDealStatusSearchObject.createdDate!="") {
            searchString=searchString+'createdDate:'+rmanDealStatusSearchObject.createdDate+',';
        }

        if (rmanDealStatusSearchObject.createdBy!=undefined && rmanDealStatusSearchObject.createdBy!="") {
            searchString=searchString+'createdBy:'+rmanDealStatusSearchObject.createdBy+',';
        }

        if (rmanDealStatusSearchObject.lastUpdatedDate!=undefined && rmanDealStatusSearchObject.lastUpdatedDate!="") {
            searchString=searchString+'lastUpdatedDate:'+rmanDealStatusSearchObject.lastUpdatedDate+',';
        }

        if (rmanDealStatusSearchObject.lastUpdatedBy!=undefined && rmanDealStatusSearchObject.lastUpdatedBy!="") {
            searchString=searchString+'lastUpdatedBy:'+rmanDealStatusSearchObject.lastUpdatedBy+',';
        }

        if (rmanDealStatusSearchObject.processInstanceId!=undefined && rmanDealStatusSearchObject.processInstanceId!="") {
            searchString=searchString+'processInstanceId:'+rmanDealStatusSearchObject.processInstanceId;
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


    saveRmanDealStatus(rmanDealStatus:any) {
        let body = JSON.stringify(rmanDealStatus);
        return this.http.post(appSettings.apiUrl+'/RMAN_DEAL_STATUS',body,httpOptions).toPromise().then((data:any) => {
            return data;
        });
    }

    updateRmanDealStatus(rmanDealStatus:any) {

        delete rmanDealStatus._links;
        delete rmanDealStatus.interests;
        let body = JSON.stringify(rmanDealStatus);
        return this.http.put<any[]>(appSettings.apiUrl+'/RMAN_DEAL_STATUS/'+rmanDealStatus.dealHeaderId,body,httpOptions).toPromise().then(data => {
            return data;
        });

    }

    deleteRmanDealStatus(rmanDealStatus:any) {
        let deleteUrl=appSettings.apiUrl+'/RMAN_DEAL_STATUS/'+rmanDealStatus.dealHeaderId;
        return this.http.delete(deleteUrl,httpOptions).toPromise().then(data => {
            return data;
        });
    }

}
