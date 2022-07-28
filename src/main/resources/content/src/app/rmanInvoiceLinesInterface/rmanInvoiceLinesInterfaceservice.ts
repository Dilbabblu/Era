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
export class RmanInvoiceLinesInterfaceService {

    constructor(private http: HttpClient) {}
    
    getServiceUrl(paginationOptions: any, rmanInvoiceLinesInterfaceSearchObject: any,fetchAll?:any,exportFlag?: any){
        let serviceUrl = appSettings.apiUrl + '/rmanBillingsInterfaceExport?';
        if (exportFlag == 0) {
            serviceUrl=appSettings.apiUrl+'/rmanInvoiceLinesInterfaceSearch?';
        }
        let searchString='';
        if (rmanInvoiceLinesInterfaceSearchObject.sourceInvoiceLineId!=undefined && rmanInvoiceLinesInterfaceSearchObject.sourceInvoiceLineId!="") {
            searchString=searchString+'sourceInvoiceLineId:'+rmanInvoiceLinesInterfaceSearchObject.sourceInvoiceLineId+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.sourceInvoiceId!=undefined && rmanInvoiceLinesInterfaceSearchObject.sourceInvoiceId!="") {
            searchString=searchString+'sourceInvoiceId:'+rmanInvoiceLinesInterfaceSearchObject.sourceInvoiceId+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.invoiceType!=undefined && rmanInvoiceLinesInterfaceSearchObject.invoiceType!="") {
            searchString=searchString+'invoiceType:'+rmanInvoiceLinesInterfaceSearchObject.invoiceType+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.invoiceSource!=undefined && rmanInvoiceLinesInterfaceSearchObject.invoiceSource!="") {
            searchString=searchString+'invoiceSource:'+rmanInvoiceLinesInterfaceSearchObject.invoiceSource+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.invoiceTrxType!=undefined && rmanInvoiceLinesInterfaceSearchObject.invoiceTrxType!="") {
            searchString=searchString+'invoiceTrxType:'+rmanInvoiceLinesInterfaceSearchObject.invoiceTrxType+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.lineType!=undefined && rmanInvoiceLinesInterfaceSearchObject.lineType!="") {
            searchString=searchString+'lineType:'+rmanInvoiceLinesInterfaceSearchObject.lineType+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.glDate!=undefined && rmanInvoiceLinesInterfaceSearchObject.glDate!="") {
            searchString=searchString+'glDate:'+rmanInvoiceLinesInterfaceSearchObject.glDate+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.invoiceNumber!=undefined && rmanInvoiceLinesInterfaceSearchObject.invoiceNumber!="") {
            searchString=searchString+'invoiceNumber:'+rmanInvoiceLinesInterfaceSearchObject.invoiceNumber+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.invoicedDate!=undefined && rmanInvoiceLinesInterfaceSearchObject.invoicedDate!="") {
            searchString=searchString+'invoicedDate:'+rmanInvoiceLinesInterfaceSearchObject.invoicedDate+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.salesOrderNumber!=undefined && rmanInvoiceLinesInterfaceSearchObject.salesOrderNumber!="") {
            searchString=searchString+'salesOrderNumber:'+rmanInvoiceLinesInterfaceSearchObject.salesOrderNumber+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.accountingRuleName!=undefined && rmanInvoiceLinesInterfaceSearchObject.accountingRuleName!="") {
            searchString=searchString+'accountingRuleName:'+rmanInvoiceLinesInterfaceSearchObject.accountingRuleName+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.rmanAcctRuleId!=undefined && rmanInvoiceLinesInterfaceSearchObject.rmanAcctRuleId!="") {
            searchString=searchString+'rmanAcctRuleId:'+rmanInvoiceLinesInterfaceSearchObject.rmanAcctRuleId+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.serviceStartDate!=undefined && rmanInvoiceLinesInterfaceSearchObject.serviceStartDate!="") {
            searchString=searchString+'serviceStartDate:'+rmanInvoiceLinesInterfaceSearchObject.serviceStartDate+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.serviceEndDate!=undefined && rmanInvoiceLinesInterfaceSearchObject.serviceEndDate!="") {
            searchString=searchString+'serviceEndDate:'+rmanInvoiceLinesInterfaceSearchObject.serviceEndDate+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.serviceDuration!=undefined && rmanInvoiceLinesInterfaceSearchObject.serviceDuration!="") {
            searchString=searchString+'serviceDuration:'+rmanInvoiceLinesInterfaceSearchObject.serviceDuration+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.servicePeriod!=undefined && rmanInvoiceLinesInterfaceSearchObject.servicePeriod!="") {
            searchString=searchString+'servicePeriod:'+rmanInvoiceLinesInterfaceSearchObject.servicePeriod+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.revenueAmount!=undefined && rmanInvoiceLinesInterfaceSearchObject.revenueAmount!="") {
            searchString=searchString+'revenueAmount:'+rmanInvoiceLinesInterfaceSearchObject.revenueAmount+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.acctdRevAmount!=undefined && rmanInvoiceLinesInterfaceSearchObject.acctdRevAmount!="") {
            searchString=searchString+'acctdRevAmount:'+rmanInvoiceLinesInterfaceSearchObject.acctdRevAmount+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.usdAmount!=undefined && rmanInvoiceLinesInterfaceSearchObject.usdAmount!="") {
            searchString=searchString+'usdAmount:'+rmanInvoiceLinesInterfaceSearchObject.usdAmount+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.errorFlag!=undefined && rmanInvoiceLinesInterfaceSearchObject.errorFlag!="") {
            searchString=searchString+'errorFlag:'+rmanInvoiceLinesInterfaceSearchObject.errorFlag+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.errorMessage!=undefined && rmanInvoiceLinesInterfaceSearchObject.errorMessage!="") {
            searchString=searchString+'errorMessage:'+rmanInvoiceLinesInterfaceSearchObject.errorMessage+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.origCreationDate!=undefined && rmanInvoiceLinesInterfaceSearchObject.origCreationDate!="") {
            searchString=searchString+'origCreationDate:'+rmanInvoiceLinesInterfaceSearchObject.origCreationDate+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.origCreatedBy!=undefined && rmanInvoiceLinesInterfaceSearchObject.origCreatedBy!="") {
            searchString=searchString+'origCreatedBy:'+rmanInvoiceLinesInterfaceSearchObject.origCreatedBy+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.origLastUpdateDate!=undefined && rmanInvoiceLinesInterfaceSearchObject.origLastUpdateDate!="") {
            searchString=searchString+'origLastUpdateDate:'+rmanInvoiceLinesInterfaceSearchObject.origLastUpdateDate+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.origLastUpdatedBy!=undefined && rmanInvoiceLinesInterfaceSearchObject.origLastUpdatedBy!="") {
            searchString=searchString+'origLastUpdatedBy:'+rmanInvoiceLinesInterfaceSearchObject.origLastUpdatedBy+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.creationDate!=undefined && rmanInvoiceLinesInterfaceSearchObject.creationDate!="") {
            searchString=searchString+'creationDate:'+rmanInvoiceLinesInterfaceSearchObject.creationDate+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.createdBy!=undefined && rmanInvoiceLinesInterfaceSearchObject.createdBy!="") {
            searchString=searchString+'createdBy:'+rmanInvoiceLinesInterfaceSearchObject.createdBy+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.lastUpdateDate!=undefined && rmanInvoiceLinesInterfaceSearchObject.lastUpdateDate!="") {
            searchString=searchString+'lastUpdateDate:'+rmanInvoiceLinesInterfaceSearchObject.lastUpdateDate+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.lastUpdatedBy!=undefined && rmanInvoiceLinesInterfaceSearchObject.lastUpdatedBy!="") {
            searchString=searchString+'lastUpdatedBy:'+rmanInvoiceLinesInterfaceSearchObject.lastUpdatedBy+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.processedDate!=undefined && rmanInvoiceLinesInterfaceSearchObject.processedDate!="") {
            searchString=searchString+'processedDate:'+rmanInvoiceLinesInterfaceSearchObject.processedDate+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.interfaceStatus!=undefined && rmanInvoiceLinesInterfaceSearchObject.interfaceStatus!="") {
            searchString=searchString+'interfaceStatus:'+rmanInvoiceLinesInterfaceSearchObject.interfaceStatus+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.interfaceProcessId!=undefined && rmanInvoiceLinesInterfaceSearchObject.interfaceProcessId!="") {
            searchString=searchString+'interfaceProcessId:'+rmanInvoiceLinesInterfaceSearchObject.interfaceProcessId+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.rmanInvoiceLineId!=undefined && rmanInvoiceLinesInterfaceSearchObject.rmanInvoiceLineId!="") {
            searchString=searchString+'rmanInvoiceLineId:'+rmanInvoiceLinesInterfaceSearchObject.rmanInvoiceLineId+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.rmanLineId!=undefined && rmanInvoiceLinesInterfaceSearchObject.rmanLineId!="") {
            searchString=searchString+'rmanLineId:'+rmanInvoiceLinesInterfaceSearchObject.rmanLineId+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.sourceOrderLineId!=undefined && rmanInvoiceLinesInterfaceSearchObject.sourceOrderLineId!="") {
            searchString=searchString+'sourceOrderLineId:'+rmanInvoiceLinesInterfaceSearchObject.sourceOrderLineId+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.invoiceLineNumber!=undefined && rmanInvoiceLinesInterfaceSearchObject.invoiceLineNumber!="") {
            searchString=searchString+'invoiceLineNumber:'+rmanInvoiceLinesInterfaceSearchObject.invoiceLineNumber+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.cogsAmount!=undefined && rmanInvoiceLinesInterfaceSearchObject.cogsAmount!="") {
            searchString=searchString+'cogsAmount:'+rmanInvoiceLinesInterfaceSearchObject.cogsAmount+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.cogsAccount!=undefined && rmanInvoiceLinesInterfaceSearchObject.cogsAccount!="") {
            searchString=searchString+'cogsAccount:'+rmanInvoiceLinesInterfaceSearchObject.cogsAccount+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.fxDate!=undefined && rmanInvoiceLinesInterfaceSearchObject.fxDate!="") {
            searchString=searchString+'fxDate:'+rmanInvoiceLinesInterfaceSearchObject.fxDate+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.fxRate!=undefined && rmanInvoiceLinesInterfaceSearchObject.fxRate!="") {
            searchString=searchString+'fxRate:'+rmanInvoiceLinesInterfaceSearchObject.fxRate+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.quantity!=undefined && rmanInvoiceLinesInterfaceSearchObject.quantity!="") {
            searchString=searchString+'quantity:'+rmanInvoiceLinesInterfaceSearchObject.quantity+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.sourceLineNumber!=undefined && rmanInvoiceLinesInterfaceSearchObject.sourceLineNumber!="") {
            searchString=searchString+'sourceLineNumber:'+rmanInvoiceLinesInterfaceSearchObject.sourceLineNumber+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.invoiceCurrency!=undefined && rmanInvoiceLinesInterfaceSearchObject.invoiceCurrency!="") {
            searchString=searchString+'invoiceCurrency:'+rmanInvoiceLinesInterfaceSearchObject.invoiceCurrency+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.actualShippedDate!=undefined && rmanInvoiceLinesInterfaceSearchObject.actualShippedDate!="") {
            searchString=searchString+'actualShippedDate:'+rmanInvoiceLinesInterfaceSearchObject.actualShippedDate+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.pid!=undefined && rmanInvoiceLinesInterfaceSearchObject.pid!="") {
            searchString=searchString+'pid:'+rmanInvoiceLinesInterfaceSearchObject.pid+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.debitAccount!=undefined && rmanInvoiceLinesInterfaceSearchObject.debitAccount!="") {
            searchString=searchString+'debitAccount:'+rmanInvoiceLinesInterfaceSearchObject.debitAccount+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.creditAccount!=undefined && rmanInvoiceLinesInterfaceSearchObject.creditAccount!="") {
            searchString=searchString+'creditAccount:'+rmanInvoiceLinesInterfaceSearchObject.creditAccount+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.unitSellingPrice!=undefined && rmanInvoiceLinesInterfaceSearchObject.unitSellingPrice!="") {
            searchString=searchString+'unitSellingPrice:'+rmanInvoiceLinesInterfaceSearchObject.unitSellingPrice+',';
        }

        if (rmanInvoiceLinesInterfaceSearchObject.acctdCurrency!=undefined && rmanInvoiceLinesInterfaceSearchObject.acctdCurrency!="") {
            searchString=searchString+'acctdCurrency:'+rmanInvoiceLinesInterfaceSearchObject.acctdCurrency;
        }


        
        if (searchString == '') {
            serviceUrl=serviceUrl+'search=%25';
        }
        else {
            serviceUrl=serviceUrl+'search='+searchString;
        }
        
        if (paginationOptions.pageNumber) {
            serviceUrl=serviceUrl+'&page='+paginationOptions.pageNumber+'&size='+paginationOptions.pageSize;
        }
        return serviceUrl;

    }
    getAllRmanInvoiceLinesInterface(paginationOptions: any, rmanInvoiceLinesInterfaceSearchObject: any): Promise<any[]> {
        let serviceUrl = this.getServiceUrl(paginationOptions, rmanInvoiceLinesInterfaceSearchObject,'N', 0);
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
          return data;
        });
      }
  
	searchRmanInvoiceLinesInterface(rmanInvoiceLinesInterface) {      
        return this.http.get(appSettings.apiUrl+'/RMAN_INVOICE_LINES_INTERFACE/search/findBySourceInvoiceLineIdAndSourceInvoiceIdAndInvoiceTypeAndInvoiceSourceAndInvoiceTrxTypeAndLineTypeAndGlDateAndInvoiceNumberAndInvoicedDateAndSalesOrderNumberAndAccountingRuleNameAndRmanAcctRuleIdAndServiceStartDateAndServiceEndDateAndServiceDurationAndServicePeriodAndRevenueAmountAndAcctdRevAmountAndUsdAmountAndErrorFlagAndErrorMessageAndOrigCreationDateAndOrigCreatedByAndOrigLastUpdateDateAndOrigLastUpdatedByAndCreationDateAndCreatedByAndLastUpdateDateAndLastUpdatedByAndProcessedDateAndInterfaceStatusAndInterfaceProcessIdAndRmanInvoiceLineIdAndRmanLineIdAndSourceOrderLineIdAndInvoiceLineNumberAndCogsAmountAndCogsAccountAndFxDateAndFxRateAndQuantityAndSourceLineNumberAndInvoiceCurrencyAndActualShippedDateAndPidAndDebitAccountAndCreditAccountAndUnitSellingPriceAndAcctdCurrency?sourceInvoiceLineId='+rmanInvoiceLinesInterface.sourceInvoiceLineId+'&sourceInvoiceId='+rmanInvoiceLinesInterface.sourceInvoiceId+'&invoiceType='+rmanInvoiceLinesInterface.invoiceType+'&invoiceSource='+rmanInvoiceLinesInterface.invoiceSource+'&invoiceTrxType='+rmanInvoiceLinesInterface.invoiceTrxType+'&lineType='+rmanInvoiceLinesInterface.lineType+'&glDate='+rmanInvoiceLinesInterface.glDate+'&invoiceNumber='+rmanInvoiceLinesInterface.invoiceNumber+'&invoicedDate='+rmanInvoiceLinesInterface.invoicedDate+'&salesOrderNumber='+rmanInvoiceLinesInterface.salesOrderNumber+'&accountingRuleName='+rmanInvoiceLinesInterface.accountingRuleName+'&rmanAcctRuleId='+rmanInvoiceLinesInterface.rmanAcctRuleId+'&serviceStartDate='+rmanInvoiceLinesInterface.serviceStartDate+'&serviceEndDate='+rmanInvoiceLinesInterface.serviceEndDate+'&serviceDuration='+rmanInvoiceLinesInterface.serviceDuration+'&servicePeriod='+rmanInvoiceLinesInterface.servicePeriod+'&revenueAmount='+rmanInvoiceLinesInterface.revenueAmount+'&acctdRevAmount='+rmanInvoiceLinesInterface.acctdRevAmount+'&usdAmount='+rmanInvoiceLinesInterface.usdAmount+'&errorFlag='+rmanInvoiceLinesInterface.errorFlag+'&errorMessage='+rmanInvoiceLinesInterface.errorMessage+'&origCreationDate='+rmanInvoiceLinesInterface.origCreationDate+'&origCreatedBy='+rmanInvoiceLinesInterface.origCreatedBy+'&origLastUpdateDate='+rmanInvoiceLinesInterface.origLastUpdateDate+'&origLastUpdatedBy='+rmanInvoiceLinesInterface.origLastUpdatedBy+'&creationDate='+rmanInvoiceLinesInterface.creationDate+'&createdBy='+rmanInvoiceLinesInterface.createdBy+'&lastUpdateDate='+rmanInvoiceLinesInterface.lastUpdateDate+'&lastUpdatedBy='+rmanInvoiceLinesInterface.lastUpdatedBy+'&processedDate='+rmanInvoiceLinesInterface.processedDate+'&interfaceStatus='+rmanInvoiceLinesInterface.interfaceStatus+'&interfaceProcessId='+rmanInvoiceLinesInterface.interfaceProcessId+'&rmanInvoiceLineId='+rmanInvoiceLinesInterface.rmanInvoiceLineId+'&rmanLineId='+rmanInvoiceLinesInterface.rmanLineId+'&sourceOrderLineId='+rmanInvoiceLinesInterface.sourceOrderLineId+'&invoiceLineNumber='+rmanInvoiceLinesInterface.invoiceLineNumber+'&cogsAmount='+rmanInvoiceLinesInterface.cogsAmount+'&cogsAccount='+rmanInvoiceLinesInterface.cogsAccount+'&fxDate='+rmanInvoiceLinesInterface.fxDate+'&fxRate='+rmanInvoiceLinesInterface.fxRate+'&quantity='+rmanInvoiceLinesInterface.quantity+'&sourceLineNumber='+rmanInvoiceLinesInterface.sourceLineNumber+'&invoiceCurrency='+rmanInvoiceLinesInterface.invoiceCurrency+'&actualShippedDate='+rmanInvoiceLinesInterface.actualShippedDate+'&pid='+rmanInvoiceLinesInterface.pid+'&debitAccount='+rmanInvoiceLinesInterface.debitAccount+'&creditAccount='+rmanInvoiceLinesInterface.creditAccount+'&unitSellingPrice='+rmanInvoiceLinesInterface.unitSellingPrice+'&acctdCurrency='+rmanInvoiceLinesInterface.acctdCurrency).toPromise().then(data => {
			return data;
        	});        
    }
    
    saveRmanInvoiceLinesInterface(rmanInvoiceLinesInterface) {
        let body = JSON.stringify(rmanInvoiceLinesInterface);        
        return this.http.post(appSettings.apiUrl+'/saveRmanInvoiceLinesInterface',body,httpOptions).toPromise().then(data => {
            return data;
        });        
    }
    processBillings(){
        return this.http.get(appSettings.apiUrl+'/revmantra/processbillings').toPromise().then((data:any) => {
            return data;            
        }); 
    }
    
    updateRmanInvoiceLinesInterface(rmanInvoiceLinesInterface) {
        
        delete rmanInvoiceLinesInterface._links;
        delete rmanInvoiceLinesInterface.interests;
        let body = JSON.stringify(rmanInvoiceLinesInterface);       
        return this.http.put(appSettings.apiUrl+'/RMAN_INVOICE_LINES_INTERFACE/'+rmanInvoiceLinesInterface.sourceInvoiceLineId,body,httpOptions).toPromise().then(data => {
            return data;
        });
        
    }
    

    deleteRmanInvLinesDetails(sourceInvoiceLineIds: any[]){
        var delstr = '';
        for(var i=0; i<sourceInvoiceLineIds.length;i++){
            delstr = delstr + "slid="+sourceInvoiceLineIds[i];
            if (i < sourceInvoiceLineIds.length - 1) {
                delstr = delstr + '&';
              }
        }
        let delUrl = appSettings.apiUrl + '/bulkDeleteBillingsExceptions?'+delstr;
     
        return this.http.delete(delUrl,{responseType: 'text'}).toPromise().then((data:any) => {
          return data;
        });
        
    }


}
