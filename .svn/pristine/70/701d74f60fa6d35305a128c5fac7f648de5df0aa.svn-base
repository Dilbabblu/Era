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
export class RmanOrdersInterfaceService {

    constructor(private http: HttpClient) {}
    getServiceUrl(paginationOptions: any, rmanOrdersInterfaceSearchObject: any,orderType?:any,fetchAll?:any,exportFlag?: any){
        let bookedUrl=appSettings.apiUrl+'/rmanOrderBookingsInterfaceExport?';
        let shippedUrl=appSettings.apiUrl+'/rmanOrderShipmentsInterfaceExport?';
        if(exportFlag==0){
            bookedUrl=appSettings.apiUrl+'/rmanBookedOrdersInterfaceSearch?';
            shippedUrl=appSettings.apiUrl+'/rmanShippedOrdersInterfaceSearch?';
        }
        let serviceUrl='';
        let searchString='';

        if (rmanOrdersInterfaceSearchObject.orderNumber!=undefined && rmanOrdersInterfaceSearchObject.orderNumber!="") {
            searchString=searchString+'orderNumber='+rmanOrdersInterfaceSearchObject.orderNumber+'&'
        }

        if (rmanOrdersInterfaceSearchObject.sourceLineNumber!=undefined && rmanOrdersInterfaceSearchObject.sourceLineNumber!="") {
            searchString=searchString+'sourceLineNumber='+rmanOrdersInterfaceSearchObject.sourceLineNumber+'&'
        }
        
        if(orderType =='B'){
            serviceUrl=searchString==''?(bookedUrl):(bookedUrl+searchString);
        }else if(orderType=='S'){           
            serviceUrl=searchString==''?(shippedUrl):(shippedUrl+searchString);
        }
       
        if (paginationOptions.pageNumber && exportFlag==0) {
            serviceUrl=serviceUrl+'page='+paginationOptions.pageNumber+'&size='+paginationOptions.pageSize;
        }
        return serviceUrl;
    }
    getAllRmanOrdersInterface(paginationOptions: any, rmanOrdersInterfaceSearchObject: any,orderType:any): Promise<any[]> {
        let serviceUrl = this.getServiceUrl(paginationOptions, rmanOrdersInterfaceSearchObject,orderType,'N', 0);
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
          return data;
        });
    }
    
    
	searchRmanOrdersInterface(rmanOrdersInterface) {      
        return this.http.get(appSettings.apiUrl+'/RMAN_ORDERS_INTERFACE/search/findByRmanLineIdAndSourceHeaderIdAndOrderNumberAndCustomerPoNumAndOrderTypeAndBookingEntityIdAndShippingEntityIdAndSoldToCustomerAndBillToCustomerAndEndCustomerAndShipToCustomerAndBillToCountryAndShipToCountryAndShippingOrgCodeAndBookedDateAndOrderedDateAndScheduleShipDateAndOrderStatusAndPriceListAndSalesrepAndBookingCurrencyAndFobAndSourceLineIdAndSourceLineNumberAndProductNameAndProductIdAndProductOrgIdAndOrderedQuantityAndShippedQuantityAndFulfilledQuantityAndLineTypeAndLineStatusAndUnitSellingPriceAndUnitListPriceAndShippableFlagAndInvoiceFlagAndOrginalLineIdAndOrigRmanLineIdAndOrginalLineNumberAndOrginalOrderNumberAndAccountingRuleNameAndRmanAcctRuleIdAndServiceStartDateAndServiceEndDateAndServiceDurationAndServicePeriodAndLineAttribute1AndLineAttribute2AndLineAttribute3AndLineAttribute4AndLineAttribute5AndLineAttribute6AndLineAttribute7AndLineAttribute8AndLineAttribute9AndLineAttribute10AndLineAttribute11AndLineAttribute12AndLineAttribute13AndLineAttribute14AndLineAttribute15AndHeaderAttribute1AndHeaderAttribute2AndHeaderAttribute3AndHeaderAttribute4AndHeaderAttribute5AndHeaderAttribute6AndHeaderAttribute7AndHeaderAttribute8AndHeaderAttribute9AndHeaderAttribute10AndHeaderAttribute11AndHeaderAttribute12AndHeaderAttribute13AndHeaderAttribute14AndHeaderAttribute15AndFmvHistoryFlagAndOrigCreationDateAndOrigCreatedByAndOrigLastUpdateDateAndOrigLastUpdatedByAndCreationDateAndCreatedByAndLastUpdateDateAndLastUpdatedByAndErrorFlagAndErrorMessageAndProcessedDateAndInterfaceStatusAndInterfaceProcessIdAndProductOrgNameAndRepUnitSellingPriceAndRepUnitListPriceAndBookingEntityNameAndOrderSourceAndProjectNameAndProjectNumberAndTaskNameAndTaskNumberAndProjectIdAndTaskIdAndRoleNameAndRevenueCategoryAndExpenditureTypeAndLineCostAndDealNumberAndDealLineNumberAndActualFulfilledDateAndBillToLocationAndFxDateAndFxRateAndRevrecAccountAndRevrecAcctRuleAndRevrecAcctScopeAndRevrecDelayAndRevrecEndDateAndRevrecStDateAndShipToLocationAndProjectCostAndFobPointCodeAndReleasedStatusAndTopModelLineIdAndLinkToLineIdAndServiceNumberAndLineNumAndRefOrderNumberAndServiceRefOrderAndServiceRefOrdLineNumAndOrderNumModifierAndObjVersionNumberAndStdWarrantyAndExtWarrantyAndCarveOutFlagAndDomesticInternationalAndRegionAndTerritoryAndRevrecHoldTypeAndCancelledQtyAndCancelledDateAndLineCategoryCode?rmanLineId='+rmanOrdersInterface.rmanLineId+'&sourceHeaderId='+rmanOrdersInterface.sourceHeaderId+'&orderNumber='+rmanOrdersInterface.orderNumber+'&customerPoNum='+rmanOrdersInterface.customerPoNum+'&orderType='+rmanOrdersInterface.orderType+'&bookingEntityId='+rmanOrdersInterface.bookingEntityId+'&shippingEntityId='+rmanOrdersInterface.shippingEntityId+'&soldToCustomer='+rmanOrdersInterface.soldToCustomer+'&billToCustomer='+rmanOrdersInterface.billToCustomer+'&endCustomer='+rmanOrdersInterface.endCustomer+'&shipToCustomer='+rmanOrdersInterface.shipToCustomer+'&billToCountry='+rmanOrdersInterface.billToCountry+'&shipToCountry='+rmanOrdersInterface.shipToCountry+'&shippingOrgCode='+rmanOrdersInterface.shippingOrgCode+'&bookedDate='+rmanOrdersInterface.bookedDate+'&orderedDate='+rmanOrdersInterface.orderedDate+'&scheduleShipDate='+rmanOrdersInterface.scheduleShipDate+'&orderStatus='+rmanOrdersInterface.orderStatus+'&priceList='+rmanOrdersInterface.priceList+'&salesrep='+rmanOrdersInterface.salesrep+'&bookingCurrency='+rmanOrdersInterface.bookingCurrency+'&fob='+rmanOrdersInterface.fob+'&sourceLineId='+rmanOrdersInterface.sourceLineId+'&sourceLineNumber='+rmanOrdersInterface.sourceLineNumber+'&productName='+rmanOrdersInterface.productName+'&productId='+rmanOrdersInterface.productId+'&productOrgId='+rmanOrdersInterface.productOrgId+'&orderedQuantity='+rmanOrdersInterface.orderedQuantity+'&shippedQuantity='+rmanOrdersInterface.shippedQuantity+'&fulfilledQuantity='+rmanOrdersInterface.fulfilledQuantity+'&lineType='+rmanOrdersInterface.lineType+'&lineStatus='+rmanOrdersInterface.lineStatus+'&unitSellingPrice='+rmanOrdersInterface.unitSellingPrice+'&unitListPrice='+rmanOrdersInterface.unitListPrice+'&shippableFlag='+rmanOrdersInterface.shippableFlag+'&invoiceFlag='+rmanOrdersInterface.invoiceFlag+'&orginalLineId='+rmanOrdersInterface.orginalLineId+'&origRmanLineId='+rmanOrdersInterface.origRmanLineId+'&orginalLineNumber='+rmanOrdersInterface.orginalLineNumber+'&orginalOrderNumber='+rmanOrdersInterface.orginalOrderNumber+'&accountingRuleName='+rmanOrdersInterface.accountingRuleName+'&rmanAcctRuleId='+rmanOrdersInterface.rmanAcctRuleId+'&serviceStartDate='+rmanOrdersInterface.serviceStartDate+'&serviceEndDate='+rmanOrdersInterface.serviceEndDate+'&serviceDuration='+rmanOrdersInterface.serviceDuration+'&servicePeriod='+rmanOrdersInterface.servicePeriod+'&lineAttribute1='+rmanOrdersInterface.lineAttribute1+'&lineAttribute2='+rmanOrdersInterface.lineAttribute2+'&lineAttribute3='+rmanOrdersInterface.lineAttribute3+'&lineAttribute4='+rmanOrdersInterface.lineAttribute4+'&lineAttribute5='+rmanOrdersInterface.lineAttribute5+'&lineAttribute6='+rmanOrdersInterface.lineAttribute6+'&lineAttribute7='+rmanOrdersInterface.lineAttribute7+'&lineAttribute8='+rmanOrdersInterface.lineAttribute8+'&lineAttribute9='+rmanOrdersInterface.lineAttribute9+'&lineAttribute10='+rmanOrdersInterface.lineAttribute10+'&lineAttribute11='+rmanOrdersInterface.lineAttribute11+'&lineAttribute12='+rmanOrdersInterface.lineAttribute12+'&lineAttribute13='+rmanOrdersInterface.lineAttribute13+'&lineAttribute14='+rmanOrdersInterface.lineAttribute14+'&lineAttribute15='+rmanOrdersInterface.lineAttribute15+'&headerAttribute1='+rmanOrdersInterface.headerAttribute1+'&headerAttribute2='+rmanOrdersInterface.headerAttribute2+'&headerAttribute3='+rmanOrdersInterface.headerAttribute3+'&headerAttribute4='+rmanOrdersInterface.headerAttribute4+'&headerAttribute5='+rmanOrdersInterface.headerAttribute5+'&headerAttribute6='+rmanOrdersInterface.headerAttribute6+'&headerAttribute7='+rmanOrdersInterface.headerAttribute7+'&headerAttribute8='+rmanOrdersInterface.headerAttribute8+'&headerAttribute9='+rmanOrdersInterface.headerAttribute9+'&headerAttribute10='+rmanOrdersInterface.headerAttribute10+'&headerAttribute11='+rmanOrdersInterface.headerAttribute11+'&headerAttribute12='+rmanOrdersInterface.headerAttribute12+'&headerAttribute13='+rmanOrdersInterface.headerAttribute13+'&headerAttribute14='+rmanOrdersInterface.headerAttribute14+'&headerAttribute15='+rmanOrdersInterface.headerAttribute15+'&fmvHistoryFlag='+rmanOrdersInterface.fmvHistoryFlag+'&origCreationDate='+rmanOrdersInterface.origCreationDate+'&origCreatedBy='+rmanOrdersInterface.origCreatedBy+'&origLastUpdateDate='+rmanOrdersInterface.origLastUpdateDate+'&origLastUpdatedBy='+rmanOrdersInterface.origLastUpdatedBy+'&creationDate='+rmanOrdersInterface.creationDate+'&createdBy='+rmanOrdersInterface.createdBy+'&lastUpdateDate='+rmanOrdersInterface.lastUpdateDate+'&lastUpdatedBy='+rmanOrdersInterface.lastUpdatedBy+'&errorFlag='+rmanOrdersInterface.errorFlag+'&errorMessage='+rmanOrdersInterface.errorMessage+'&processedDate='+rmanOrdersInterface.processedDate+'&interfaceStatus='+rmanOrdersInterface.interfaceStatus+'&interfaceProcessId='+rmanOrdersInterface.interfaceProcessId+'&productOrgName='+rmanOrdersInterface.productOrgName+'&repUnitSellingPrice='+rmanOrdersInterface.repUnitSellingPrice+'&repUnitListPrice='+rmanOrdersInterface.repUnitListPrice+'&bookingEntityName='+rmanOrdersInterface.bookingEntityName+'&orderSource='+rmanOrdersInterface.orderSource+'&projectName='+rmanOrdersInterface.projectName+'&projectNumber='+rmanOrdersInterface.projectNumber+'&taskName='+rmanOrdersInterface.taskName+'&taskNumber='+rmanOrdersInterface.taskNumber+'&projectId='+rmanOrdersInterface.projectId+'&taskId='+rmanOrdersInterface.taskId+'&roleName='+rmanOrdersInterface.roleName+'&revenueCategory='+rmanOrdersInterface.revenueCategory+'&expenditureType='+rmanOrdersInterface.expenditureType+'&lineCost='+rmanOrdersInterface.lineCost+'&dealNumber='+rmanOrdersInterface.dealNumber+'&dealLineNumber='+rmanOrdersInterface.dealLineNumber+'&actualFulfilledDate='+rmanOrdersInterface.actualFulfilledDate+'&billToLocation='+rmanOrdersInterface.billToLocation+'&fxDate='+rmanOrdersInterface.fxDate+'&fxRate='+rmanOrdersInterface.fxRate+'&revrecAccount='+rmanOrdersInterface.revrecAccount+'&revrecAcctRule='+rmanOrdersInterface.revrecAcctRule+'&revrecAcctScope='+rmanOrdersInterface.revrecAcctScope+'&revrecDelay='+rmanOrdersInterface.revrecDelay+'&revrecEndDate='+rmanOrdersInterface.revrecEndDate+'&revrecStDate='+rmanOrdersInterface.revrecStDate+'&shipToLocation='+rmanOrdersInterface.shipToLocation+'&projectCost='+rmanOrdersInterface.projectCost+'&fobPointCode='+rmanOrdersInterface.fobPointCode+'&releasedStatus='+rmanOrdersInterface.releasedStatus+'&topModelLineId='+rmanOrdersInterface.topModelLineId+'&linkToLineId='+rmanOrdersInterface.linkToLineId+'&serviceNumber='+rmanOrdersInterface.serviceNumber+'&lineNum='+rmanOrdersInterface.lineNum+'&refOrderNumber='+rmanOrdersInterface.refOrderNumber+'&serviceRefOrder='+rmanOrdersInterface.serviceRefOrder+'&serviceRefOrdLineNum='+rmanOrdersInterface.serviceRefOrdLineNum+'&orderNumModifier='+rmanOrdersInterface.orderNumModifier+'&objVersionNumber='+rmanOrdersInterface.objVersionNumber+'&stdWarranty='+rmanOrdersInterface.stdWarranty+'&extWarranty='+rmanOrdersInterface.extWarranty+'&carveOutFlag='+rmanOrdersInterface.carveOutFlag+'&domesticInternational='+rmanOrdersInterface.domesticInternational+'&region='+rmanOrdersInterface.region+'&territory='+rmanOrdersInterface.territory+'&revrecHoldType='+rmanOrdersInterface.revrecHoldType+'&cancelledQty='+rmanOrdersInterface.cancelledQty+'&cancelledDate='+rmanOrdersInterface.cancelledDate+'&lineCategoryCode='+rmanOrdersInterface.lineCategoryCode).toPromise().then(data => {
			return data;
        	});        
    }
    
    saveRmanOrdersInterface(rmanOrdersInterface) {
        let body = JSON.stringify(rmanOrdersInterface);        
        return this.http.post(appSettings.apiUrl+'/saveRmanOrdersInterface',body,httpOptions).toPromise().then(data => {
            return data;
        });        
    }
    processOrders() {
         return this.http.get(appSettings.apiUrl+'/revmantra/importbookings').toPromise().then((data:any) => {
             return data;            
         });        
    }
    
    updateRmanOrdersInterface(rmanOrdersInterface) {
        
        delete rmanOrdersInterface._links;
        delete rmanOrdersInterface.interests;
        let body = JSON.stringify(rmanOrdersInterface);       
        return this.http.put(appSettings.apiUrl+'/RMAN_ORDERS_INTERFACE/'+rmanOrdersInterface.sourceLineId,body,httpOptions).toPromise().then(data => {
            return data;
        });
        
    }
    
    deleteRmanOrdersInterface(rmanOrdersInterface) {
        let deleteUrl=appSettings.apiUrl+'/RMAN_ORDERS_INTERFACE/'+rmanOrdersInterface.sourceLineId;               
        return this.http.delete(deleteUrl,httpOptions).toPromise().then(data => {
            return data;
        });
    }

    deleteSelectedLines(soLines: any[],fileType:any){
        var delstr = '';
        for(var i=0; i<soLines.length;i++){
            delstr = delstr + "slid="+soLines[i];
            if (i < soLines.length - 1) {
                delstr = delstr + '&';
              }
        }
        let delUrl = appSettings.apiUrl + '/bulkDelOrdersInterface?'+'fileType='+ fileType+'&'+delstr;
     
        return this.http.delete(delUrl,{responseType: 'text'}).toPromise().then((data:any) => {
          return data;
        });
        
    }

}
