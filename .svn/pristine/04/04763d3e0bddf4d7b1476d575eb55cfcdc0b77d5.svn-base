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
export class RmanArrgSummaryReportVService {

    constructor(private http: HttpClient,private datePipe: DatePipe) {}
    sDate: any;
    eDate: any;
    getServiceUrl(paginationOptions:any,rmanArrgSummaryReportVSearchObject:any,exportFlag: any,searchFields:any, exportCols: any){

        let serviceUrl = appSettings.apiUrl + '/rmanArrgSummaryReportVExport?';

        if (exportFlag == 0) {

         serviceUrl=appSettings.apiUrl+'/rmanArrgSummaryReportVSearch?';
        }
        
        let searchString='';

        if (rmanArrgSummaryReportVSearchObject.dealArrangementId!=undefined && rmanArrgSummaryReportVSearchObject.dealArrangementId!="") {
            searchString=searchString+'dealArrangementId:'+rmanArrgSummaryReportVSearchObject.dealArrangementId+',';
        }

        if (rmanArrgSummaryReportVSearchObject.dealArrangementNumber!=undefined && rmanArrgSummaryReportVSearchObject.dealArrangementNumber!="") {
            searchString=searchString+'dealArrangementNumber:'+rmanArrgSummaryReportVSearchObject.dealArrangementNumber+',';
        }

        if (rmanArrgSummaryReportVSearchObject.dealArrangementName!=undefined && rmanArrgSummaryReportVSearchObject.dealArrangementName!="") {
            searchString=searchString+'dealArrangementName:'+rmanArrgSummaryReportVSearchObject.dealArrangementName+',';
        }

        if (rmanArrgSummaryReportVSearchObject.dealArrangementStatus!=undefined && rmanArrgSummaryReportVSearchObject.dealArrangementStatus!="") {
            searchString=searchString+'dealArrangementStatus:'+rmanArrgSummaryReportVSearchObject.dealArrangementStatus+',';
        }

        if (rmanArrgSummaryReportVSearchObject.legalEntityName!=undefined && rmanArrgSummaryReportVSearchObject.legalEntityName!="") {
            searchString=searchString+'legalEntityName:'+rmanArrgSummaryReportVSearchObject.legalEntityName+',';
        }

        if (rmanArrgSummaryReportVSearchObject.dealArrangementSource!=undefined && rmanArrgSummaryReportVSearchObject.dealArrangementSource!="") {
            searchString=searchString+'dealArrangementSource:'+rmanArrgSummaryReportVSearchObject.dealArrangementSource+',';
        }

        if (rmanArrgSummaryReportVSearchObject.customerPoNum!=undefined && rmanArrgSummaryReportVSearchObject.customerPoNum!="") {
            searchString=searchString+'customerPoNum:'+rmanArrgSummaryReportVSearchObject.customerPoNum+',';
        }

        if (rmanArrgSummaryReportVSearchObject.bookingCurrency!=undefined && rmanArrgSummaryReportVSearchObject.bookingCurrency!="") {
            searchString=searchString+'bookingCurrency:'+rmanArrgSummaryReportVSearchObject.bookingCurrency+',';
        }

        if (rmanArrgSummaryReportVSearchObject.shipToCustomer!=undefined && rmanArrgSummaryReportVSearchObject.shipToCustomer!="") {
            searchString=searchString+'shipToCustomer:'+rmanArrgSummaryReportVSearchObject.shipToCustomer+',';
        }

        if (rmanArrgSummaryReportVSearchObject.shipToCustomerNumber!=undefined && rmanArrgSummaryReportVSearchObject.shipToCustomerNumber!="") {
            searchString=searchString+'shipToCustomerNumber:'+rmanArrgSummaryReportVSearchObject.shipToCustomerNumber+',';
        }

        if (rmanArrgSummaryReportVSearchObject.billToCustomer!=undefined && rmanArrgSummaryReportVSearchObject.billToCustomer!="") {
            searchString=searchString+'billToCustomer:'+rmanArrgSummaryReportVSearchObject.billToCustomer+',';
        }

        if (rmanArrgSummaryReportVSearchObject.billToCustomerNumber!=undefined && rmanArrgSummaryReportVSearchObject.billToCustomerNumber!="") {
            searchString=searchString+'billToCustomerNumber:'+rmanArrgSummaryReportVSearchObject.billToCustomerNumber+',';
        }

        if (rmanArrgSummaryReportVSearchObject.salesTheater!=undefined && rmanArrgSummaryReportVSearchObject.salesTheater!="") {
            searchString=searchString+'salesTheater:'+rmanArrgSummaryReportVSearchObject.salesTheater+',';
        }

        if (rmanArrgSummaryReportVSearchObject.salesRegion!=undefined && rmanArrgSummaryReportVSearchObject.salesRegion!="") {
            searchString=searchString+'salesRegion:'+rmanArrgSummaryReportVSearchObject.salesRegion+',';
        }

        if (rmanArrgSummaryReportVSearchObject.salesTerritory!=undefined && rmanArrgSummaryReportVSearchObject.salesTerritory!="") {
            searchString=searchString+'salesTerritory:'+rmanArrgSummaryReportVSearchObject.salesTerritory+',';
        }

        if (rmanArrgSummaryReportVSearchObject.bookedAmount!=undefined && rmanArrgSummaryReportVSearchObject.bookedAmount!="") {
            searchString=searchString+'bookedAmount:'+rmanArrgSummaryReportVSearchObject.bookedAmount+',';
        }

        if (rmanArrgSummaryReportVSearchObject.sspAmount!=undefined && rmanArrgSummaryReportVSearchObject.sspAmount!="") {
            searchString=searchString+'sspAmount:'+rmanArrgSummaryReportVSearchObject.sspAmount+',';
        }

        if (rmanArrgSummaryReportVSearchObject.allocationAmount!=undefined && rmanArrgSummaryReportVSearchObject.allocationAmount!="") {
            searchString=searchString+'allocationAmount:'+rmanArrgSummaryReportVSearchObject.allocationAmount+',';
        }

        if (rmanArrgSummaryReportVSearchObject.carveInOutAmount!=undefined && rmanArrgSummaryReportVSearchObject.carveInOutAmount!="") {
            searchString=searchString+'carveInOutAmount:'+rmanArrgSummaryReportVSearchObject.carveInOutAmount+',';
        }

        if (rmanArrgSummaryReportVSearchObject.deliveredAmount!=undefined && rmanArrgSummaryReportVSearchObject.deliveredAmount!="") {
            searchString=searchString+'deliveredAmount:'+rmanArrgSummaryReportVSearchObject.deliveredAmount+',';
        }

        if (rmanArrgSummaryReportVSearchObject.billedAmount!=undefined && rmanArrgSummaryReportVSearchObject.billedAmount!="") {
            searchString=searchString+'billedAmount:'+rmanArrgSummaryReportVSearchObject.billedAmount+',';
        }

        if (rmanArrgSummaryReportVSearchObject.deliveredAllocationAmount!=undefined && rmanArrgSummaryReportVSearchObject.deliveredAllocationAmount!="") {
            searchString=searchString+'deliveredAllocationAmount:'+rmanArrgSummaryReportVSearchObject.deliveredAllocationAmount+',';
        }

        if (rmanArrgSummaryReportVSearchObject.postBillingDeferrals!=undefined && rmanArrgSummaryReportVSearchObject.postBillingDeferrals!="") {
            searchString=searchString+'postBillingDeferrals:'+rmanArrgSummaryReportVSearchObject.postBillingDeferrals+',';
        }

        if (rmanArrgSummaryReportVSearchObject.postBillingAllocationAmount!=undefined && rmanArrgSummaryReportVSearchObject.postBillingAllocationAmount!="") {
            searchString=searchString+'postBillingAllocationAmount:'+rmanArrgSummaryReportVSearchObject.postBillingAllocationAmount+',';
        }

        if (rmanArrgSummaryReportVSearchObject.revBegBal!=undefined && rmanArrgSummaryReportVSearchObject.revBegBal!="") {
            searchString=searchString+'revBegBal:'+rmanArrgSummaryReportVSearchObject.revBegBal+',';
        }

        if (rmanArrgSummaryReportVSearchObject.revCurrBal!=undefined && rmanArrgSummaryReportVSearchObject.revCurrBal!="") {
            searchString=searchString+'revCurrBal:'+rmanArrgSummaryReportVSearchObject.revCurrBal+',';
        }

        if (rmanArrgSummaryReportVSearchObject.revEndBal!=undefined && rmanArrgSummaryReportVSearchObject.revEndBal!="") {
            searchString=searchString+'revEndBal:'+rmanArrgSummaryReportVSearchObject.revEndBal+',';
        }

        if (rmanArrgSummaryReportVSearchObject.unamortizedAmount!=undefined && rmanArrgSummaryReportVSearchObject.unamortizedAmount!="") {
            searchString=searchString+'unamortizedAmount:'+rmanArrgSummaryReportVSearchObject.unamortizedAmount+',';
        }

        if (rmanArrgSummaryReportVSearchObject.revenueUnbilled!=undefined && rmanArrgSummaryReportVSearchObject.revenueUnbilled!="") {
            searchString=searchString+'revenueUnbilled:'+rmanArrgSummaryReportVSearchObject.revenueUnbilled+',';
        }

        if (rmanArrgSummaryReportVSearchObject.allocationAmountFc!=undefined && rmanArrgSummaryReportVSearchObject.allocationAmountFc!="") {
            searchString=searchString+'allocationAmountFc:'+rmanArrgSummaryReportVSearchObject.allocationAmountFc+',';
        }

        if (rmanArrgSummaryReportVSearchObject.deliveredAllocationAmountFc!=undefined && rmanArrgSummaryReportVSearchObject.deliveredAllocationAmountFc!="") {
            searchString=searchString+'deliveredAllocationAmountFc:'+rmanArrgSummaryReportVSearchObject.deliveredAllocationAmountFc+',';
        }

        if (rmanArrgSummaryReportVSearchObject.postBillingDeferralsFc!=undefined && rmanArrgSummaryReportVSearchObject.postBillingDeferralsFc!="") {
            searchString=searchString+'postBillingDeferralsFc:'+rmanArrgSummaryReportVSearchObject.postBillingDeferralsFc+',';
        }

        if (rmanArrgSummaryReportVSearchObject.pbAllocationAmountFc!=undefined && rmanArrgSummaryReportVSearchObject.pbAllocationAmountFc!="") {
            searchString=searchString+'pbAllocationAmountFc:'+rmanArrgSummaryReportVSearchObject.pbAllocationAmountFc+',';
        }

        if (rmanArrgSummaryReportVSearchObject.revBegBalFc!=undefined && rmanArrgSummaryReportVSearchObject.revBegBalFc!="") {
            searchString=searchString+'revBegBalFc:'+rmanArrgSummaryReportVSearchObject.revBegBalFc+',';
        }

        if (rmanArrgSummaryReportVSearchObject.revCurrBalFc!=undefined && rmanArrgSummaryReportVSearchObject.revCurrBalFc!="") {
            searchString=searchString+'revCurrBalFc:'+rmanArrgSummaryReportVSearchObject.revCurrBalFc+',';
        }

        if (rmanArrgSummaryReportVSearchObject.revEndBalFc!=undefined && rmanArrgSummaryReportVSearchObject.revEndBalFc!="") {
            searchString=searchString+'revEndBalFc:'+rmanArrgSummaryReportVSearchObject.revEndBalFc+',';
        }

        if (rmanArrgSummaryReportVSearchObject.unamortizedAmountFc!=undefined && rmanArrgSummaryReportVSearchObject.unamortizedAmountFc!="") {
            searchString=searchString+'unamortizedAmountFc:'+rmanArrgSummaryReportVSearchObject.unamortizedAmountFc+',';
        }

        if (rmanArrgSummaryReportVSearchObject.totalCostFc!=undefined && rmanArrgSummaryReportVSearchObject.totalCostFc!="") {
            searchString=searchString+'totalCostFc:'+rmanArrgSummaryReportVSearchObject.totalCostFc+',';
        }

        if (rmanArrgSummaryReportVSearchObject.grossMarginFc!=undefined && rmanArrgSummaryReportVSearchObject.grossMarginFc!="") {
            searchString=searchString+'grossMarginFc:'+rmanArrgSummaryReportVSearchObject.grossMarginFc;
        }
        if(searchFields.fromPeriod != undefined && searchFields.fromPeriod != null){
            searchString=searchString+'lastArrgModifiedDate>'+ this.datePipe.transform(searchFields.fromPeriod,'yyyyMMdd')+',';
        }
        if(searchFields.toPeriod != undefined && searchFields.toPeriod != null){
            searchString=searchString+'lastArrgModifiedDate<'+ this.datePipe.transform(searchFields.toPeriod,'yyyyMMdd')+',';
        }
        if (searchFields.fromArrgId != undefined && searchFields.fromArrgId != null) {
              searchString = searchString + 'dealArrangementId>' + searchFields.fromArrgId + ',';
        }
        if (searchFields.toArrgId != undefined && searchFields.toArrgId != null) {
              searchString = searchString + 'dealArrangementId<' + searchFields.toArrgId + ',';
        }
        if (searchFields.customerPoNum!=undefined && searchFields.customerPoNum!="") {
            searchString=searchString+'customerPoNum:'+searchFields.customerPoNum+',';
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
    
    getAllRmanArrgSummaryReportV(paginationOptions:any,rmanArrgSummaryReportVSearchObject:any,searchFields:any, exportCols: any) {
        let serviceUrl = this.getServiceUrl(paginationOptions, rmanArrgSummaryReportVSearchObject, 0, searchFields, exportCols);
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
          return data;
        });
        

    }
	searchRmanArrgSummaryReportV(rmanArrgSummaryReportV:any): Promise<any[]> {
        return this.http.get(appSettings.apiUrl+'/RMAN_ARRG_SUMMARY_REPORT_V/search/findByDealArrangementIdAndDealArrangementNumberAndDealArrangementNameAndDealArrangementStatusAndLegalEntityNameAndDealArrangementSourceAndCustomerPoNumAndBookingCurrencyAndShipToCustomerAndShipToCustomerNumberAndBillToCustomerAndBillToCustomerNumberAndSalesTheaterAndSalesRegionAndSalesTerritoryAndBookedAmountAndSspAmountAndAllocationAmountAndCarveInOutAmountAndDeliveredAmountAndBilledAmountAndDeliveredAllocationAmountAndPostBillingDeferralsAndPostBillingAllocationAmountAndRevBegBalAndRevCurrBalAndRevEndBalAndUnamortizedAmountAndRevenueUnbilledAndAllocationAmountFcAndDeliveredAllocationAmountFcAndPostBillingDeferralsFcAndPbAllocationAmountFcAndRevBegBalFcAndRevCurrBalFcAndRevEndBalFcAndUnamortizedAmountFcAndTotalCostFcAndGrossMarginFc?dealArrangementId='+rmanArrgSummaryReportV.dealArrangementId+'&dealArrangementNumber='+rmanArrgSummaryReportV.dealArrangementNumber+'&dealArrangementName='+rmanArrgSummaryReportV.dealArrangementName+'&dealArrangementStatus='+rmanArrgSummaryReportV.dealArrangementStatus+'&legalEntityName='+rmanArrgSummaryReportV.legalEntityName+'&dealArrangementSource='+rmanArrgSummaryReportV.dealArrangementSource+'&customerPoNum='+rmanArrgSummaryReportV.customerPoNum+'&bookingCurrency='+rmanArrgSummaryReportV.bookingCurrency+'&shipToCustomer='+rmanArrgSummaryReportV.shipToCustomer+'&shipToCustomerNumber='+rmanArrgSummaryReportV.shipToCustomerNumber+'&billToCustomer='+rmanArrgSummaryReportV.billToCustomer+'&billToCustomerNumber='+rmanArrgSummaryReportV.billToCustomerNumber+'&salesTheater='+rmanArrgSummaryReportV.salesTheater+'&salesRegion='+rmanArrgSummaryReportV.salesRegion+'&salesTerritory='+rmanArrgSummaryReportV.salesTerritory+'&bookedAmount='+rmanArrgSummaryReportV.bookedAmount+'&sspAmount='+rmanArrgSummaryReportV.sspAmount+'&allocationAmount='+rmanArrgSummaryReportV.allocationAmount+'&carveInOutAmount='+rmanArrgSummaryReportV.carveInOutAmount+'&deliveredAmount='+rmanArrgSummaryReportV.deliveredAmount+'&billedAmount='+rmanArrgSummaryReportV.billedAmount+'&deliveredAllocationAmount='+rmanArrgSummaryReportV.deliveredAllocationAmount+'&postBillingDeferrals='+rmanArrgSummaryReportV.postBillingDeferrals+'&postBillingAllocationAmount='+rmanArrgSummaryReportV.postBillingAllocationAmount+'&revBegBal='+rmanArrgSummaryReportV.revBegBal+'&revCurrBal='+rmanArrgSummaryReportV.revCurrBal+'&revEndBal='+rmanArrgSummaryReportV.revEndBal+'&unamortizedAmount='+rmanArrgSummaryReportV.unamortizedAmount+'&revenueUnbilled='+rmanArrgSummaryReportV.revenueUnbilled+'&allocationAmountFc='+rmanArrgSummaryReportV.allocationAmountFc+'&deliveredAllocationAmountFc='+rmanArrgSummaryReportV.deliveredAllocationAmountFc+'&postBillingDeferralsFc='+rmanArrgSummaryReportV.postBillingDeferralsFc+'&pbAllocationAmountFc='+rmanArrgSummaryReportV.pbAllocationAmountFc+'&revBegBalFc='+rmanArrgSummaryReportV.revBegBalFc+'&revCurrBalFc='+rmanArrgSummaryReportV.revCurrBalFc+'&revEndBalFc='+rmanArrgSummaryReportV.revEndBalFc+'&unamortizedAmountFc='+rmanArrgSummaryReportV.unamortizedAmountFc+'&totalCostFc='+rmanArrgSummaryReportV.totalCostFc+'&grossMarginFc='+rmanArrgSummaryReportV.grossMarginFc).toPromise().then((data:any) => {
			return data; 
			});
    }
    
    saveRmanArrgSummaryReportV(rmanArrgSummaryReportV:any): Promise<any[]> {
        let body = JSON.stringify(rmanArrgSummaryReportV);
        return this.http.post(appSettings.apiUrl+'/RMAN_ARRG_SUMMARY_REPORT_V',body,httpOptions).toPromise().then((data:any) => {
            return data;
        });
    }
    
    updateRmanArrgSummaryReportV(rmanArrgSummaryReportV:any): Promise<any[]> {
        delete rmanArrgSummaryReportV._links;
        delete rmanArrgSummaryReportV.interests;
        let body = JSON.stringify(rmanArrgSummaryReportV);
        return this.http.put(appSettings.apiUrl+'/RMAN_ARRG_SUMMARY_REPORT_V/'+rmanArrgSummaryReportV.dealArrangementId,body,httpOptions).toPromise().then((data:any) => {
            return data;
        });
        
    }
    
    deleteRmanArrgSummaryReportV(rmanArrgSummaryReportV:any): Promise<any[]> {
        let deleteUrl=appSettings.apiUrl+'/RMAN_ARRG_SUMMARY_REPORT_V/'+rmanArrgSummaryReportV.dealArrangementId;
        return this.http.delete(deleteUrl,httpOptions).toPromise().then((data:any) => {
            return data;
        });
    }

}
