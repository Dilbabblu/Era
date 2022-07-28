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
export class RmanIntfDealDetailsService {

    constructor(private http: HttpClient) {}

    getServiceUrl(paginationOptions: any, rmanIntfDealDetailsSearchObject: any,fetchAll?:any,exportFlag?: any){

        let serviceUrl = appSettings.apiUrl + '/rmanQuotesInterfaceExport?';
        if (exportFlag == 0) {
            serviceUrl=appSettings.apiUrl+'/rmanIntfDealDetailsSearch?';
        }
        let searchString='';

        if (rmanIntfDealDetailsSearchObject.dealNumber!=undefined && rmanIntfDealDetailsSearchObject.dealNumber!="") {
            searchString=searchString+'dealNumber:'+rmanIntfDealDetailsSearchObject.dealNumber+',';
        }

        if (rmanIntfDealDetailsSearchObject.dealName!=undefined && rmanIntfDealDetailsSearchObject.dealName!="") {
            searchString=searchString+'dealName:'+rmanIntfDealDetailsSearchObject.dealName+',';
        }

        if (rmanIntfDealDetailsSearchObject.entityName!=undefined && rmanIntfDealDetailsSearchObject.entityName!="") {
            searchString=searchString+'entityName:'+rmanIntfDealDetailsSearchObject.entityName+',';
        }

        if (rmanIntfDealDetailsSearchObject.customerName!=undefined && rmanIntfDealDetailsSearchObject.customerName!="") {
            searchString=searchString+'customerName:'+rmanIntfDealDetailsSearchObject.customerName+',';
        }

        if (rmanIntfDealDetailsSearchObject.billToCustomerName!=undefined && rmanIntfDealDetailsSearchObject.billToCustomerName!="") {
            searchString=searchString+'billToCustomerName:'+rmanIntfDealDetailsSearchObject.billToCustomerName+',';
        }

        if (rmanIntfDealDetailsSearchObject.priceList!=undefined && rmanIntfDealDetailsSearchObject.priceList!="") {
            searchString=searchString+'priceList:'+rmanIntfDealDetailsSearchObject.priceList+',';
        }

        if (rmanIntfDealDetailsSearchObject.agreementId!=undefined && rmanIntfDealDetailsSearchObject.agreementId!="") {
            searchString=searchString+'agreementId:'+rmanIntfDealDetailsSearchObject.agreementId+',';
        }

        if (rmanIntfDealDetailsSearchObject.agreementName!=undefined && rmanIntfDealDetailsSearchObject.agreementName!="") {
            searchString=searchString+'agreementName:'+rmanIntfDealDetailsSearchObject.agreementName+',';
        }

        if (rmanIntfDealDetailsSearchObject.currencyCode!=undefined && rmanIntfDealDetailsSearchObject.currencyCode!="") {
            searchString=searchString+'currencyCode:'+rmanIntfDealDetailsSearchObject.currencyCode+',';
        }

        if (rmanIntfDealDetailsSearchObject.arrangementName!=undefined && rmanIntfDealDetailsSearchObject.arrangementName!="") {
            searchString=searchString+'arrangementName:'+rmanIntfDealDetailsSearchObject.arrangementName+',';
        }

        if (rmanIntfDealDetailsSearchObject.arrangementNumber!=undefined && rmanIntfDealDetailsSearchObject.arrangementNumber!="") {
            searchString=searchString+'arrangementNumber:'+rmanIntfDealDetailsSearchObject.arrangementNumber+',';
        }

        if (rmanIntfDealDetailsSearchObject.arrangementSource!=undefined && rmanIntfDealDetailsSearchObject.arrangementSource!="") {
            searchString=searchString+'arrangementSource:'+rmanIntfDealDetailsSearchObject.arrangementSource+',';
        }

        if (rmanIntfDealDetailsSearchObject.arrangementBasis!=undefined && rmanIntfDealDetailsSearchObject.arrangementBasis!="") {
            searchString=searchString+'arrangementBasis:'+rmanIntfDealDetailsSearchObject.arrangementBasis+',';
        }

        if (rmanIntfDealDetailsSearchObject.productName!=undefined && rmanIntfDealDetailsSearchObject.productName!="") {
            searchString=searchString+'productName:'+rmanIntfDealDetailsSearchObject.productName+',';
        }

        if (rmanIntfDealDetailsSearchObject.quantity!=undefined && rmanIntfDealDetailsSearchObject.quantity!="") {
            searchString=searchString+'quantity:'+rmanIntfDealDetailsSearchObject.quantity+',';
        }

        if (rmanIntfDealDetailsSearchObject.salesNodeLevel1!=undefined && rmanIntfDealDetailsSearchObject.salesNodeLevel1!="") {
            searchString=searchString+'salesNodeLevel1:'+rmanIntfDealDetailsSearchObject.salesNodeLevel1+',';
        }

        if (rmanIntfDealDetailsSearchObject.salesNodeLevel2!=undefined && rmanIntfDealDetailsSearchObject.salesNodeLevel2!="") {
            searchString=searchString+'salesNodeLevel2:'+rmanIntfDealDetailsSearchObject.salesNodeLevel2+',';
        }

        if (rmanIntfDealDetailsSearchObject.salesNodeLevel3!=undefined && rmanIntfDealDetailsSearchObject.salesNodeLevel3!="") {
            searchString=searchString+'salesNodeLevel3:'+rmanIntfDealDetailsSearchObject.salesNodeLevel3+',';
        }

        if (rmanIntfDealDetailsSearchObject.salesNodeLevel4!=undefined && rmanIntfDealDetailsSearchObject.salesNodeLevel4!="") {
            searchString=searchString+'salesNodeLevel4:'+rmanIntfDealDetailsSearchObject.salesNodeLevel4+',';
        }

        if (rmanIntfDealDetailsSearchObject.startDate!=undefined && rmanIntfDealDetailsSearchObject.startDate!="") {
            searchString=searchString+'startDate:'+rmanIntfDealDetailsSearchObject.startDate+',';
        }

        if (rmanIntfDealDetailsSearchObject.endDate!=undefined && rmanIntfDealDetailsSearchObject.endDate!="") {
            searchString=searchString+'endDate:'+rmanIntfDealDetailsSearchObject.endDate+',';
        }

        if (rmanIntfDealDetailsSearchObject.duration!=undefined && rmanIntfDealDetailsSearchObject.duration!="") {
            searchString=searchString+'duration:'+rmanIntfDealDetailsSearchObject.duration+',';
        }

        if (rmanIntfDealDetailsSearchObject.durationUom!=undefined && rmanIntfDealDetailsSearchObject.durationUom!="") {
            searchString=searchString+'durationUom:'+rmanIntfDealDetailsSearchObject.durationUom+',';
        }

        if (rmanIntfDealDetailsSearchObject.unitCost!=undefined && rmanIntfDealDetailsSearchObject.unitCost!="") {
            searchString=searchString+'unitCost:'+rmanIntfDealDetailsSearchObject.unitCost+',';
        }

        if (rmanIntfDealDetailsSearchObject.unitSellingPrice!=undefined && rmanIntfDealDetailsSearchObject.unitSellingPrice!="") {
            searchString=searchString+'unitSellingPrice:'+rmanIntfDealDetailsSearchObject.unitSellingPrice+',';
        }

        if (rmanIntfDealDetailsSearchObject.unitListPrice!=undefined && rmanIntfDealDetailsSearchObject.unitListPrice!="") {
            searchString=searchString+'unitListPrice:'+rmanIntfDealDetailsSearchObject.unitListPrice+',';
        }

        if (rmanIntfDealDetailsSearchObject.contractUnitType!=undefined && rmanIntfDealDetailsSearchObject.contractUnitType!="") {
            searchString=searchString+'contractUnitType:'+rmanIntfDealDetailsSearchObject.contractUnitType+',';
        }

        if (rmanIntfDealDetailsSearchObject.allocationExcludeFlag!=undefined && rmanIntfDealDetailsSearchObject.allocationExcludeFlag!="") {
            searchString=searchString+'allocationExcludeFlag:'+rmanIntfDealDetailsSearchObject.allocationExcludeFlag+',';
        }

        if (rmanIntfDealDetailsSearchObject.additionalAttribute1!=undefined && rmanIntfDealDetailsSearchObject.additionalAttribute1!="") {
            searchString=searchString+'additionalAttribute1:'+rmanIntfDealDetailsSearchObject.additionalAttribute1+',';
        }

        if (rmanIntfDealDetailsSearchObject.additionalAttribute2!=undefined && rmanIntfDealDetailsSearchObject.additionalAttribute2!="") {
            searchString=searchString+'additionalAttribute2:'+rmanIntfDealDetailsSearchObject.additionalAttribute2+',';
        }

        if (rmanIntfDealDetailsSearchObject.additionalAttribute3!=undefined && rmanIntfDealDetailsSearchObject.additionalAttribute3!="") {
            searchString=searchString+'additionalAttribute3:'+rmanIntfDealDetailsSearchObject.additionalAttribute3+',';
        }

        if (rmanIntfDealDetailsSearchObject.additionalLineAttribute1!=undefined && rmanIntfDealDetailsSearchObject.additionalLineAttribute1!="") {
            searchString=searchString+'additionalLineAttribute1:'+rmanIntfDealDetailsSearchObject.additionalLineAttribute1+',';
        }

        if (rmanIntfDealDetailsSearchObject.additionalLineAttribute2!=undefined && rmanIntfDealDetailsSearchObject.additionalLineAttribute2!="") {
            searchString=searchString+'additionalLineAttribute2:'+rmanIntfDealDetailsSearchObject.additionalLineAttribute2+',';
        }

        if (rmanIntfDealDetailsSearchObject.interfaceStatus!=undefined && rmanIntfDealDetailsSearchObject.interfaceStatus!="") {
            searchString=searchString+'interfaceStatus:'+rmanIntfDealDetailsSearchObject.interfaceStatus+',';
        }

        if (rmanIntfDealDetailsSearchObject.interfaceError!=undefined && rmanIntfDealDetailsSearchObject.interfaceError!="") {
            searchString=searchString+'interfaceError:'+rmanIntfDealDetailsSearchObject.interfaceError+',';
        }

        if (rmanIntfDealDetailsSearchObject.msaNumber!=undefined && rmanIntfDealDetailsSearchObject.msaNumber!="") {
            searchString=searchString+'msaNumber:'+rmanIntfDealDetailsSearchObject.msaNumber+',';
        }

        if (rmanIntfDealDetailsSearchObject.msaName!=undefined && rmanIntfDealDetailsSearchObject.msaName!="") {
            searchString=searchString+'msaName:'+rmanIntfDealDetailsSearchObject.msaName+',';
        }

        if (rmanIntfDealDetailsSearchObject.dealLineNumber!=undefined && rmanIntfDealDetailsSearchObject.dealLineNumber!="") {
            searchString=searchString+'dealLineNumber:'+rmanIntfDealDetailsSearchObject.dealLineNumber+',';
        }

        if (rmanIntfDealDetailsSearchObject.parentLineId!=undefined && rmanIntfDealDetailsSearchObject.parentLineId!="") {
            searchString=searchString+'parentLineId:'+rmanIntfDealDetailsSearchObject.parentLineId+',';
        }

        if (rmanIntfDealDetailsSearchObject.fvPercent!=undefined && rmanIntfDealDetailsSearchObject.fvPercent!="") {
            searchString=searchString+'fvPercent:'+rmanIntfDealDetailsSearchObject.fvPercent+',';
        }

        if (rmanIntfDealDetailsSearchObject.accountingRuleName!=undefined && rmanIntfDealDetailsSearchObject.accountingRuleName!="") {
            searchString=searchString+'accountingRuleName:'+rmanIntfDealDetailsSearchObject.accountingRuleName+',';
        }

        if (rmanIntfDealDetailsSearchObject.additionalLineAttribute3!=undefined && rmanIntfDealDetailsSearchObject.additionalLineAttribute3!="") {
            searchString=searchString+'additionalLineAttribute3:'+rmanIntfDealDetailsSearchObject.additionalLineAttribute3+',';
        }

        if (rmanIntfDealDetailsSearchObject.eitfSop!=undefined && rmanIntfDealDetailsSearchObject.eitfSop!="") {
            searchString=searchString+'eitfSop:'+rmanIntfDealDetailsSearchObject.eitfSop+',';
        }

        if (rmanIntfDealDetailsSearchObject.bespPerUnit!=undefined && rmanIntfDealDetailsSearchObject.bespPerUnit!="") {
            searchString=searchString+'bespPerUnit:'+rmanIntfDealDetailsSearchObject.bespPerUnit+',';
        }

        if (rmanIntfDealDetailsSearchObject.arrgBasis!=undefined && rmanIntfDealDetailsSearchObject.arrgBasis!="") {
            searchString=searchString+'arrgBasis:'+rmanIntfDealDetailsSearchObject.arrgBasis+',';
        }

        if (rmanIntfDealDetailsSearchObject.arrgSource!=undefined && rmanIntfDealDetailsSearchObject.arrgSource!="") {
            searchString=searchString+'arrgSource:'+rmanIntfDealDetailsSearchObject.arrgSource+',';
        }

        if (rmanIntfDealDetailsSearchObject.fxDate!=undefined && rmanIntfDealDetailsSearchObject.fxDate!="") {
            searchString=searchString+'fxDate:'+rmanIntfDealDetailsSearchObject.fxDate+',';
        }

        if (rmanIntfDealDetailsSearchObject.fxRate!=undefined && rmanIntfDealDetailsSearchObject.fxRate!="") {
            searchString=searchString+'fxRate:'+rmanIntfDealDetailsSearchObject.fxRate+',';
        }

        if (rmanIntfDealDetailsSearchObject.operationCode!=undefined && rmanIntfDealDetailsSearchObject.operationCode!="") {
            searchString=searchString+'operationCode:'+rmanIntfDealDetailsSearchObject.operationCode+',';
        }

        if (rmanIntfDealDetailsSearchObject.createdBy!=undefined && rmanIntfDealDetailsSearchObject.createdBy!="") {
            searchString=searchString+'createdBy:'+rmanIntfDealDetailsSearchObject.createdBy+',';
        }

        if (rmanIntfDealDetailsSearchObject.masterArrgFlag!=undefined && rmanIntfDealDetailsSearchObject.masterArrgFlag!="") {
            searchString=searchString+'masterArrgFlag:'+rmanIntfDealDetailsSearchObject.masterArrgFlag+',';
        }

        if (rmanIntfDealDetailsSearchObject.masterArrgName!=undefined && rmanIntfDealDetailsSearchObject.masterArrgName!="") {
            searchString=searchString+'masterArrgName:'+rmanIntfDealDetailsSearchObject.masterArrgName+',';
        }

        if (rmanIntfDealDetailsSearchObject.bundleFlag!=undefined && rmanIntfDealDetailsSearchObject.bundleFlag!="") {
            searchString=searchString+'bundleFlag:'+rmanIntfDealDetailsSearchObject.bundleFlag+',';
        }

        if (rmanIntfDealDetailsSearchObject.sourceLineRefId!=undefined && rmanIntfDealDetailsSearchObject.sourceLineRefId!="") {
            searchString=searchString+'sourceLineRefId:'+rmanIntfDealDetailsSearchObject.sourceLineRefId+',';
        }

        if (rmanIntfDealDetailsSearchObject.adjustmentAmount!=undefined && rmanIntfDealDetailsSearchObject.adjustmentAmount!="") {
            searchString=searchString+'adjustmentAmount:'+rmanIntfDealDetailsSearchObject.adjustmentAmount;
        }
        if (searchString == '') {
            serviceUrl=serviceUrl+'search=%25';
        }
        else {
            serviceUrl=serviceUrl+'search='+searchString;
        }
        
        if(fetchAll=='Y') {
        	serviceUrl=serviceUrl+'&fetchAll=Y';
        }
        
        if (paginationOptions.pageNumber) {
            serviceUrl=serviceUrl+'&page='+paginationOptions.pageNumber+'&size='+paginationOptions.pageSize;
        }
        return serviceUrl;
    }

    getAllRmanIntfDealDetails(paginationOptions: any, rmanIntfDealDetailsSearchObject: any): Promise<any[]> {
        let serviceUrl = this.getServiceUrl(paginationOptions, rmanIntfDealDetailsSearchObject,'N', 0);
        return this.http.get(serviceUrl).toPromise().then((data: any) => {
          return data;
        });
    }
    
	searchRmanIntfDealDetails(rmanIntfDealDetails) {      
        return this.http.get(appSettings.apiUrl+'/RMAN_INTF_DEAL_DETAILS/search/findByDealNumberAndDealNameAndEntityNameAndCustomerNameAndBillToCustomerNameAndPriceListAndAgreementIdAndAgreementNameAndCurrencyCodeAndArrangementNameAndArrangementNumberAndArrangementSourceAndArrangementBasisAndProductNameAndQuantityAndSalesNodeLevel1AndSalesNodeLevel2AndSalesNodeLevel3AndSalesNodeLevel4AndStartDateAndEndDateAndDurationAndDurationUomAndUnitCostAndUnitSellingPriceAndUnitListPriceAndContractUnitTypeAndAllocationExcludeFlagAndAdditionalAttribute1AndAdditionalAttribute2AndAdditionalAttribute3AndAdditionalLineAttribute1AndAdditionalLineAttribute2AndInterfaceStatusAndInterfaceErrorAndMsaNumberAndMsaNameAndDealLineNumberAndParentLineIdAndFvPercentAndAccountingRuleNameAndAdditionalLineAttribute3AndEitfSopAndBespPerUnitAndArrgBasisAndArrgSourceAndFxDateAndFxRateAndOperationCodeAndCreatedByAndMasterArrgFlagAndMasterArrgNameAndBundleFlagAndSourceLineRefIdAndAdjustmentAmount?dealNumber='+rmanIntfDealDetails.dealNumber+'&dealName='+rmanIntfDealDetails.dealName+'&entityName='+rmanIntfDealDetails.entityName+'&customerName='+rmanIntfDealDetails.customerName+'&billToCustomerName='+rmanIntfDealDetails.billToCustomerName+'&priceList='+rmanIntfDealDetails.priceList+'&agreementId='+rmanIntfDealDetails.agreementId+'&agreementName='+rmanIntfDealDetails.agreementName+'&currencyCode='+rmanIntfDealDetails.currencyCode+'&arrangementName='+rmanIntfDealDetails.arrangementName+'&arrangementNumber='+rmanIntfDealDetails.arrangementNumber+'&arrangementSource='+rmanIntfDealDetails.arrangementSource+'&arrangementBasis='+rmanIntfDealDetails.arrangementBasis+'&productName='+rmanIntfDealDetails.productName+'&quantity='+rmanIntfDealDetails.quantity+'&salesNodeLevel1='+rmanIntfDealDetails.salesNodeLevel1+'&salesNodeLevel2='+rmanIntfDealDetails.salesNodeLevel2+'&salesNodeLevel3='+rmanIntfDealDetails.salesNodeLevel3+'&salesNodeLevel4='+rmanIntfDealDetails.salesNodeLevel4+'&startDate='+rmanIntfDealDetails.startDate+'&endDate='+rmanIntfDealDetails.endDate+'&duration='+rmanIntfDealDetails.duration+'&durationUom='+rmanIntfDealDetails.durationUom+'&unitCost='+rmanIntfDealDetails.unitCost+'&unitSellingPrice='+rmanIntfDealDetails.unitSellingPrice+'&unitListPrice='+rmanIntfDealDetails.unitListPrice+'&contractUnitType='+rmanIntfDealDetails.contractUnitType+'&allocationExcludeFlag='+rmanIntfDealDetails.allocationExcludeFlag+'&additionalAttribute1='+rmanIntfDealDetails.additionalAttribute1+'&additionalAttribute2='+rmanIntfDealDetails.additionalAttribute2+'&additionalAttribute3='+rmanIntfDealDetails.additionalAttribute3+'&additionalLineAttribute1='+rmanIntfDealDetails.additionalLineAttribute1+'&additionalLineAttribute2='+rmanIntfDealDetails.additionalLineAttribute2+'&interfaceStatus='+rmanIntfDealDetails.interfaceStatus+'&interfaceError='+rmanIntfDealDetails.interfaceError+'&msaNumber='+rmanIntfDealDetails.msaNumber+'&msaName='+rmanIntfDealDetails.msaName+'&dealLineNumber='+rmanIntfDealDetails.dealLineNumber+'&parentLineId='+rmanIntfDealDetails.parentLineId+'&fvPercent='+rmanIntfDealDetails.fvPercent+'&accountingRuleName='+rmanIntfDealDetails.accountingRuleName+'&additionalLineAttribute3='+rmanIntfDealDetails.additionalLineAttribute3+'&eitfSop='+rmanIntfDealDetails.eitfSop+'&bespPerUnit='+rmanIntfDealDetails.bespPerUnit+'&arrgBasis='+rmanIntfDealDetails.arrgBasis+'&arrgSource='+rmanIntfDealDetails.arrgSource+'&fxDate='+rmanIntfDealDetails.fxDate+'&fxRate='+rmanIntfDealDetails.fxRate+'&operationCode='+rmanIntfDealDetails.operationCode+'&createdBy='+rmanIntfDealDetails.createdBy+'&masterArrgFlag='+rmanIntfDealDetails.masterArrgFlag+'&masterArrgName='+rmanIntfDealDetails.masterArrgName+'&bundleFlag='+rmanIntfDealDetails.bundleFlag+'&sourceLineRefId='+rmanIntfDealDetails.sourceLineRefId+'&adjustmentAmount='+rmanIntfDealDetails.adjustmentAmount).toPromise().then(data => {
			return data;
        	});        
    }
    
    saveRmanIntfDealDetails(rmanIntfDealDetails) {
        let body = JSON.stringify(rmanIntfDealDetails);        
        return this.http.post(appSettings.apiUrl+'/saveRmanIntfDealDetails',body,httpOptions).toPromise().then((data:any) => {
            return data;            
        });        
    }
    processRmanIntfDealDetails() {
        return this.http.get(appSettings.apiUrl+'/revmantra/processcontracts').toPromise().then((data:any) => {
            return data;            
        });        
    }
    
    updateRmanIntfDealDetails(rmanIntfDealDetails) {
        
        delete rmanIntfDealDetails._links;
        delete rmanIntfDealDetails.interests;
        let body = JSON.stringify(rmanIntfDealDetails);       
        return this.http.put(appSettings.apiUrl+'/RMAN_INTF_DEAL_DETAILS/'+rmanIntfDealDetails.arrangementNumber,body,httpOptions).toPromise().then(data => {
            return data;
        });
        
    }

    deleteRmanIntfDealDetails(arrangements: any[]){
        var delstr = '';
        for(var i=0; i<arrangements.length;i++){
            delstr = delstr + "slid="+arrangements[i];
            if (i < arrangements.length - 1) {
                delstr = delstr + '&';
              }
        }
        let delUrl = appSettings.apiUrl + '/bulkDeleteQuotes?'+delstr;
     
        return this.http.delete(delUrl,{responseType: 'text'}).toPromise().then((data:any) => {
          return data;
        });
        
    }

}
