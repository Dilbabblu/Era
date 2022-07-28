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
export class RmanTrxDetailReportService {

    constructor(private http: HttpClient, private datePipe: DatePipe) {}
    getServiceUrl(paginationOptions,rmanTrxDetailReportSearchObject, exportCols: any, exportFlag?: any) {
        let serviceUrl = appSettings.apiUrl + '/rmanTrxDetailReportExport?';

        if (exportFlag == 0) {
          
             serviceUrl=appSettings.apiUrl+'/rmanTrxDetailReportSearch?';
          }
        
        let searchString='';

        if (rmanTrxDetailReportSearchObject.sno!=undefined && rmanTrxDetailReportSearchObject.sno!="") {
            searchString=searchString+'sno:'+rmanTrxDetailReportSearchObject.sno+',';
        }

        if (rmanTrxDetailReportSearchObject.dealArrangementId!=undefined && rmanTrxDetailReportSearchObject.dealArrangementId!="") {
            searchString=searchString+'dealArrangementId:'+rmanTrxDetailReportSearchObject.dealArrangementId+',';
        }

        if (rmanTrxDetailReportSearchObject.dealArrangementNumber!=undefined && rmanTrxDetailReportSearchObject.dealArrangementNumber!="") {
            searchString=searchString+'dealArrangementNumber:'+rmanTrxDetailReportSearchObject.dealArrangementNumber+',';
        }

        if (rmanTrxDetailReportSearchObject.dealArrangementName!=undefined && rmanTrxDetailReportSearchObject.dealArrangementName!="") {
            searchString=searchString+'dealArrangementName:'+rmanTrxDetailReportSearchObject.dealArrangementName+',';
        }

        if (rmanTrxDetailReportSearchObject.arrangementType!=undefined && rmanTrxDetailReportSearchObject.arrangementType!="") {
            searchString=searchString+'arrangementType:'+rmanTrxDetailReportSearchObject.arrangementType+',';
        }

        if (rmanTrxDetailReportSearchObject.customerName!=undefined && rmanTrxDetailReportSearchObject.customerName!="") {
            searchString=searchString+'customerName:'+rmanTrxDetailReportSearchObject.customerName+',';
        }

        if (rmanTrxDetailReportSearchObject.customerNumber!=undefined && rmanTrxDetailReportSearchObject.customerNumber!="") {
            searchString=searchString+'customerNumber:'+rmanTrxDetailReportSearchObject.customerNumber+',';
        }

        if (rmanTrxDetailReportSearchObject.salesTheater!=undefined && rmanTrxDetailReportSearchObject.salesTheater!="") {
            searchString=searchString+'salesTheater:'+rmanTrxDetailReportSearchObject.salesTheater+',';
        }

        if (rmanTrxDetailReportSearchObject.region!=undefined && rmanTrxDetailReportSearchObject.region!="") {
            searchString=searchString+'region:'+rmanTrxDetailReportSearchObject.region+',';
        }

        if (rmanTrxDetailReportSearchObject.territory!=undefined && rmanTrxDetailReportSearchObject.territory!="") {
            searchString=searchString+'territory:'+rmanTrxDetailReportSearchObject.territory+',';
        }

        if (rmanTrxDetailReportSearchObject.dealNumber!=undefined && rmanTrxDetailReportSearchObject.dealNumber!="") {
            searchString=searchString+'dealNumber:'+rmanTrxDetailReportSearchObject.dealNumber+',';
        }

        if (rmanTrxDetailReportSearchObject.dealLineNumber!=undefined && rmanTrxDetailReportSearchObject.dealLineNumber!="") {
            searchString=searchString+'dealLineNumber:'+rmanTrxDetailReportSearchObject.dealLineNumber+',';
        }

        if (rmanTrxDetailReportSearchObject.productName!=undefined && rmanTrxDetailReportSearchObject.productName!="") {
            searchString=searchString+'productName:'+rmanTrxDetailReportSearchObject.productName+',';
        }

        if (rmanTrxDetailReportSearchObject.productDescription!=undefined && rmanTrxDetailReportSearchObject.productDescription!="") {
            searchString=searchString+'productDescription:'+rmanTrxDetailReportSearchObject.productDescription+',';
        }

        if (rmanTrxDetailReportSearchObject.itemType!=undefined && rmanTrxDetailReportSearchObject.itemType!="") {
            searchString=searchString+'itemType:'+rmanTrxDetailReportSearchObject.itemType+',';
        }

        if (rmanTrxDetailReportSearchObject.po!=undefined && rmanTrxDetailReportSearchObject.po!="") {
            searchString=searchString+'po:'+rmanTrxDetailReportSearchObject.po+',';
        }
        
        if (rmanTrxDetailReportSearchObject.orderNumber!=undefined && rmanTrxDetailReportSearchObject.orderNumber!="") {
            searchString=searchString+'orderNumber:'+rmanTrxDetailReportSearchObject.orderNumber+',';
        }

        
        if (rmanTrxDetailReportSearchObject.sourceLineNumber!=undefined && rmanTrxDetailReportSearchObject.sourceLineNumber!="") {
            searchString=searchString+'sourceLineNumber:'+rmanTrxDetailReportSearchObject.sourceLineNumber+',';
        }

        if (rmanTrxDetailReportSearchObject.serviceStartDate!=undefined && rmanTrxDetailReportSearchObject.serviceStartDate!="") {
            searchString=searchString+'serviceStartDate:'+rmanTrxDetailReportSearchObject.serviceStartDate+',';
        }

        if (rmanTrxDetailReportSearchObject.serviceEndDate!=undefined && rmanTrxDetailReportSearchObject.serviceEndDate!="") {
            searchString=searchString+'serviceEndDate:'+rmanTrxDetailReportSearchObject.serviceEndDate+',';
        }

        if (rmanTrxDetailReportSearchObject.orderedQuantity!=undefined && rmanTrxDetailReportSearchObject.orderedQuantity!="") {
            searchString=searchString+'orderedQuantity:'+rmanTrxDetailReportSearchObject.orderedQuantity+',';
        }

        if (rmanTrxDetailReportSearchObject.shippedQty!=undefined && rmanTrxDetailReportSearchObject.shippedQty!="") {
            searchString=searchString+'shippedQty:'+rmanTrxDetailReportSearchObject.shippedQty+',';
        }

        if (rmanTrxDetailReportSearchObject.unitSellingPrice!=undefined && rmanTrxDetailReportSearchObject.unitSellingPrice!="") {
            searchString=searchString+'unitSellingPrice:'+rmanTrxDetailReportSearchObject.unitSellingPrice+',';
        }

        if (rmanTrxDetailReportSearchObject.unitListPrice!=undefined && rmanTrxDetailReportSearchObject.unitListPrice!="") {
            searchString=searchString+'unitListPrice:'+rmanTrxDetailReportSearchObject.unitListPrice+',';
        }

        if (rmanTrxDetailReportSearchObject.transactionPrice!=undefined && rmanTrxDetailReportSearchObject.transactionPrice!="") {
            searchString=searchString+'transactionPrice:'+rmanTrxDetailReportSearchObject.transactionPrice+',';
        }

        if (rmanTrxDetailReportSearchObject.allocatedPrice!=undefined && rmanTrxDetailReportSearchObject.allocatedPrice!="") {
            searchString=searchString+'allocatedPrice:'+rmanTrxDetailReportSearchObject.allocatedPrice+',';
        }

        if (rmanTrxDetailReportSearchObject.revenueRecognize!=undefined && rmanTrxDetailReportSearchObject.revenueRecognize!="") {
            searchString=searchString+'revenueRecognize:'+rmanTrxDetailReportSearchObject.revenueRecognize+',';
        }

        if (rmanTrxDetailReportSearchObject.billedAmount!=undefined && rmanTrxDetailReportSearchObject.billedAmount!="") {
            searchString=searchString+'billedAmount:'+rmanTrxDetailReportSearchObject.billedAmount;
        }

        if(rmanTrxDetailReportSearchObject.fromArrgId != undefined && rmanTrxDetailReportSearchObject.fromArrgId != null){
            searchString=searchString+'dealArrangementId>'+ rmanTrxDetailReportSearchObject.fromArrgId+',';
         }
        
         if(rmanTrxDetailReportSearchObject.toArrgId != undefined && rmanTrxDetailReportSearchObject.toArrgId != null){
            searchString=searchString+'dealArrangementId<'+ rmanTrxDetailReportSearchObject.toArrgId+',';
        }
       
        if(rmanTrxDetailReportSearchObject.fromPeriod != undefined && rmanTrxDetailReportSearchObject.fromPeriod != null){
            searchString=searchString+'bookedDate>'+ this.datePipe.transform(rmanTrxDetailReportSearchObject.fromPeriod,'yyyyMMdd')+',';
        }
        if(rmanTrxDetailReportSearchObject.toPeriod != undefined && rmanTrxDetailReportSearchObject.toPeriod != null){
            searchString=searchString+'bookedDate<'+ this.datePipe.transform(rmanTrxDetailReportSearchObject.toPeriod,'yyyyMMdd')+',';
        }
       	if (rmanTrxDetailReportSearchObject.periodName!=undefined && rmanTrxDetailReportSearchObject.periodName!="") {
            searchString=searchString+'periodName:'+rmanTrxDetailReportSearchObject.periodName+',';
        }
		if (rmanTrxDetailReportSearchObject.activeFlag!=undefined && rmanTrxDetailReportSearchObject.activeFlag!="") {
            searchString=searchString+'activeFlag:'+rmanTrxDetailReportSearchObject.activeFlag+',';
        }

        if (rmanTrxDetailReportSearchObject.backlog!=undefined && rmanTrxDetailReportSearchObject.backlog!="") {
            searchString=searchString+'backlog:'+rmanTrxDetailReportSearchObject.backlog+',';
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

    getAllRmanTrxDetailReport(paginationOptions: any, rmanTrxDetailReportSearchObject: any, exportCols: any): Promise<any[]> {

        let serviceUrl = this.getServiceUrl(paginationOptions, rmanTrxDetailReportSearchObject, exportCols, 0);
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
          return data;
        });
    }
    
    getPeriodNameList(periodName: any) {
        let serviceUrl = appSettings.apiUrl + '/rmanFiscalPeriodsSearch?';
        let searchString='';
        if (periodName) {
            searchString=searchString+`periodName:${periodName}`
        }
        if (searchString == '') {
            serviceUrl=serviceUrl+'search=%25';
        }
        else {
            serviceUrl=serviceUrl+'search='+searchString;
        }
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
            return data;
        });
    }

    
	searchRmanTrxDetailReport(rmanTrxDetailReport) {
        return this.http.get(appSettings.apiUrl+'/RMAN_TRX_DETAIL_REPORT/search/findBySnoAndDealArrangementIdAndDealArrangementNumberAndDealArrangementNameAndArrangementTypeAndCustomerNameAndCustomerNumberAndSalesTheaterAndRegionAndTerritoryAndDealNumberAndDealLineNumberAndProductNameAndProductDescriptionAndItemTypeAndPoAndOrderNumberAndSourceLineNumberAndServiceStartDateAndServiceEndDateAndOrderedQuantityAndShippedQtyAndUnitSellingPriceAndUnitListPriceAndTransactionPriceAndAllocatedPriceAndRevenueRecognizeAndBilledAmount?sno='+rmanTrxDetailReport.sno+'&dealArrangementId='+rmanTrxDetailReport.dealArrangementId+'&dealArrangementNumber='+rmanTrxDetailReport.dealArrangementNumber+'&dealArrangementName='+rmanTrxDetailReport.dealArrangementName+'&arrangementType='+rmanTrxDetailReport.arrangementType+'&customerName='+rmanTrxDetailReport.customerName+'&customerNumber='+rmanTrxDetailReport.customerNumber+'&salesTheater='+rmanTrxDetailReport.salesTheater+'&region='+rmanTrxDetailReport.region+'&territory='+rmanTrxDetailReport.territory+'&dealNumber='+rmanTrxDetailReport.dealNumber+'&dealLineNumber='+rmanTrxDetailReport.dealLineNumber+'&productName='+rmanTrxDetailReport.productName+'&productDescription='+rmanTrxDetailReport.productDescription+'&itemType='+rmanTrxDetailReport.itemType+'&po='+rmanTrxDetailReport.po+'&orderNumber='+rmanTrxDetailReport.orderNumber+'&sourceLineNumber='+rmanTrxDetailReport.sourceLineNumber+'&serviceStartDate='+rmanTrxDetailReport.serviceStartDate+'&serviceEndDate='+rmanTrxDetailReport.serviceEndDate+'&orderedQuantity='+rmanTrxDetailReport.orderedQuantity+'&shippedQty='+rmanTrxDetailReport.shippedQty+'&unitSellingPrice='+rmanTrxDetailReport.unitSellingPrice+'&unitListPrice='+rmanTrxDetailReport.unitListPrice+'&transactionPrice='+rmanTrxDetailReport.transactionPrice+'&allocatedPrice='+rmanTrxDetailReport.allocatedPrice+'&revenueRecognize='+rmanTrxDetailReport.revenueRecognize+'&billedAmount='+rmanTrxDetailReport.billedAmount).toPromise().then(data => {
			return data; 
			});
    }
    
    saveRmanTrxDetailReport(rmanTrxDetailReport) {
        let body = JSON.stringify(rmanTrxDetailReport);
        return this.http.post(appSettings.apiUrl+'/RMAN_TRX_DETAIL_REPORT',body,httpOptions).toPromise().then(data => {
            return data;
        });
    }
    
    updateRmanTrxDetailReport(rmanTrxDetailReport) {
        
        delete rmanTrxDetailReport._links;
        delete rmanTrxDetailReport.interests;
        let body = JSON.stringify(rmanTrxDetailReport);
      
        return this.http.put(appSettings.apiUrl+'/RMAN_TRX_DETAIL_REPORT/'+rmanTrxDetailReport.sno,body,httpOptions).toPromise().then(data => {
            return data;
        });
        
    }
    
    deleteRmanTrxDetailReport(rmanTrxDetailReport) {
        let deleteUrl=appSettings.apiUrl+'/RMAN_TRX_DETAIL_REPORT/'+rmanTrxDetailReport.sno;
        
        return this.http.delete(deleteUrl,httpOptions).toPromise().then(data => {
            return data;
        });
    }
    
    periodSet(asOfPeriod:any){
    	if(asOfPeriod!=undefined && asOfPeriod!=""){
    		return appSettings.apiUrl+'/revmantra/setcurrentPeriod?asOfPeriod='+asOfPeriod;
    	}else{
    		return appSettings.apiUrl+'/revmantra/setcurrentPeriod?asOfPeriod=';
    	}
		
    }
    
}
