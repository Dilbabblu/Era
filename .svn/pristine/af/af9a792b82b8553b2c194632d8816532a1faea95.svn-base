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
export class RmanOrdersAuditVService {

    constructor(private http: HttpClient) {}
    
    getAllRmanOrdersAuditV(paginationOptions: any,rmanOrdersAuditVSearchObject: any) {

        let serviceUrl=appSettings.apiUrl+'/rmanOrdersAuditVSearch?';
        
        let searchString='';

        if (rmanOrdersAuditVSearchObject.sno!=undefined && rmanOrdersAuditVSearchObject.sno!="") {
            searchString=searchString+'sno:'+rmanOrdersAuditVSearchObject.sno+',';
        }

        if (rmanOrdersAuditVSearchObject.rmanLineId!=undefined && rmanOrdersAuditVSearchObject.rmanLineId!="") {
            searchString=searchString+'rmanLineId:'+rmanOrdersAuditVSearchObject.rmanLineId+',';
        }

        if (rmanOrdersAuditVSearchObject.sourceHeaderId!=undefined && rmanOrdersAuditVSearchObject.sourceHeaderId!="") {
            searchString=searchString+'sourceHeaderId:'+rmanOrdersAuditVSearchObject.sourceHeaderId+',';
        }

        if (rmanOrdersAuditVSearchObject.orderNumber!=undefined && rmanOrdersAuditVSearchObject.orderNumber!="") {
            searchString=searchString+'orderNumber:'+rmanOrdersAuditVSearchObject.orderNumber+',';
        }

        if (rmanOrdersAuditVSearchObject.customerPoNum!=undefined && rmanOrdersAuditVSearchObject.customerPoNum!="") {
            searchString=searchString+'customerPoNum:'+rmanOrdersAuditVSearchObject.customerPoNum+',';
        }

        if (rmanOrdersAuditVSearchObject.orderType!=undefined && rmanOrdersAuditVSearchObject.orderType!="") {
            searchString=searchString+'orderType:'+rmanOrdersAuditVSearchObject.orderType+',';
        }

        if (rmanOrdersAuditVSearchObject.bookingEntityId!=undefined && rmanOrdersAuditVSearchObject.bookingEntityId!="") {
            searchString=searchString+'bookingEntityId:'+rmanOrdersAuditVSearchObject.bookingEntityId+',';
        }

        if (rmanOrdersAuditVSearchObject.shippingEntityId!=undefined && rmanOrdersAuditVSearchObject.shippingEntityId!="") {
            searchString=searchString+'shippingEntityId:'+rmanOrdersAuditVSearchObject.shippingEntityId+',';
        }

        if (rmanOrdersAuditVSearchObject.soldToCustomer!=undefined && rmanOrdersAuditVSearchObject.soldToCustomer!="") {
            searchString=searchString+'soldToCustomer:'+rmanOrdersAuditVSearchObject.soldToCustomer+',';
        }

        if (rmanOrdersAuditVSearchObject.billToCustomer!=undefined && rmanOrdersAuditVSearchObject.billToCustomer!="") {
            searchString=searchString+'billToCustomer:'+rmanOrdersAuditVSearchObject.billToCustomer+',';
        }

        if (rmanOrdersAuditVSearchObject.endCustomer!=undefined && rmanOrdersAuditVSearchObject.endCustomer!="") {
            searchString=searchString+'endCustomer:'+rmanOrdersAuditVSearchObject.endCustomer+',';
        }

        if (rmanOrdersAuditVSearchObject.shipToCustomer!=undefined && rmanOrdersAuditVSearchObject.shipToCustomer!="") {
            searchString=searchString+'shipToCustomer:'+rmanOrdersAuditVSearchObject.shipToCustomer+',';
        }

        if (rmanOrdersAuditVSearchObject.billToCountry!=undefined && rmanOrdersAuditVSearchObject.billToCountry!="") {
            searchString=searchString+'billToCountry:'+rmanOrdersAuditVSearchObject.billToCountry+',';
        }

        if (rmanOrdersAuditVSearchObject.shipToCountry!=undefined && rmanOrdersAuditVSearchObject.shipToCountry!="") {
            searchString=searchString+'shipToCountry:'+rmanOrdersAuditVSearchObject.shipToCountry+',';
        }

        if (rmanOrdersAuditVSearchObject.shippingOrgCode!=undefined && rmanOrdersAuditVSearchObject.shippingOrgCode!="") {
            searchString=searchString+'shippingOrgCode:'+rmanOrdersAuditVSearchObject.shippingOrgCode+',';
        }

        if (rmanOrdersAuditVSearchObject.bookedDate!=undefined && rmanOrdersAuditVSearchObject.bookedDate!="") {
            searchString=searchString+'bookedDate:'+rmanOrdersAuditVSearchObject.bookedDate+',';
        }

        if (rmanOrdersAuditVSearchObject.orderedDate!=undefined && rmanOrdersAuditVSearchObject.orderedDate!="") {
            searchString=searchString+'orderedDate:'+rmanOrdersAuditVSearchObject.orderedDate+',';
        }

        if (rmanOrdersAuditVSearchObject.scheduleShipDate!=undefined && rmanOrdersAuditVSearchObject.scheduleShipDate!="") {
            searchString=searchString+'scheduleShipDate:'+rmanOrdersAuditVSearchObject.scheduleShipDate+',';
        }

        if (rmanOrdersAuditVSearchObject.orderStatus!=undefined && rmanOrdersAuditVSearchObject.orderStatus!="") {
            searchString=searchString+'orderStatus:'+rmanOrdersAuditVSearchObject.orderStatus+',';
        }

        if (rmanOrdersAuditVSearchObject.priceList!=undefined && rmanOrdersAuditVSearchObject.priceList!="") {
            searchString=searchString+'priceList:'+rmanOrdersAuditVSearchObject.priceList+',';
        }

        if (rmanOrdersAuditVSearchObject.salesrep!=undefined && rmanOrdersAuditVSearchObject.salesrep!="") {
            searchString=searchString+'salesrep:'+rmanOrdersAuditVSearchObject.salesrep+',';
        }

        if (rmanOrdersAuditVSearchObject.bookingCurrency!=undefined && rmanOrdersAuditVSearchObject.bookingCurrency!="") {
            searchString=searchString+'bookingCurrency:'+rmanOrdersAuditVSearchObject.bookingCurrency+',';
        }

        if (rmanOrdersAuditVSearchObject.fob!=undefined && rmanOrdersAuditVSearchObject.fob!="") {
            searchString=searchString+'fob:'+rmanOrdersAuditVSearchObject.fob+',';
        }

        if (rmanOrdersAuditVSearchObject.sourceLineId!=undefined && rmanOrdersAuditVSearchObject.sourceLineId!="") {
            searchString=searchString+'sourceLineId:'+rmanOrdersAuditVSearchObject.sourceLineId+',';
        }

        if (rmanOrdersAuditVSearchObject.sourceLineNumber!=undefined && rmanOrdersAuditVSearchObject.sourceLineNumber!="") {
            searchString=searchString+'sourceLineNumber:'+rmanOrdersAuditVSearchObject.sourceLineNumber+',';
        }

        if (rmanOrdersAuditVSearchObject.productName!=undefined && rmanOrdersAuditVSearchObject.productName!="") {
            searchString=searchString+'productName:'+rmanOrdersAuditVSearchObject.productName+',';
        }

        if (rmanOrdersAuditVSearchObject.productId!=undefined && rmanOrdersAuditVSearchObject.productId!="") {
            searchString=searchString+'productId:'+rmanOrdersAuditVSearchObject.productId+',';
        }

        if (rmanOrdersAuditVSearchObject.productOrgId!=undefined && rmanOrdersAuditVSearchObject.productOrgId!="") {
            searchString=searchString+'productOrgId:'+rmanOrdersAuditVSearchObject.productOrgId+',';
        }

        if (rmanOrdersAuditVSearchObject.orderedQuantity!=undefined && rmanOrdersAuditVSearchObject.orderedQuantity!="") {
            searchString=searchString+'orderedQuantity:'+rmanOrdersAuditVSearchObject.orderedQuantity+',';
        }

        if (rmanOrdersAuditVSearchObject.shippedQuantity!=undefined && rmanOrdersAuditVSearchObject.shippedQuantity!="") {
            searchString=searchString+'shippedQuantity:'+rmanOrdersAuditVSearchObject.shippedQuantity+',';
        }

        if (rmanOrdersAuditVSearchObject.fulfilledQuantity!=undefined && rmanOrdersAuditVSearchObject.fulfilledQuantity!="") {
            searchString=searchString+'fulfilledQuantity:'+rmanOrdersAuditVSearchObject.fulfilledQuantity+',';
        }

        if (rmanOrdersAuditVSearchObject.lineType!=undefined && rmanOrdersAuditVSearchObject.lineType!="") {
            searchString=searchString+'lineType:'+rmanOrdersAuditVSearchObject.lineType+',';
        }

        if (rmanOrdersAuditVSearchObject.lineStatus!=undefined && rmanOrdersAuditVSearchObject.lineStatus!="") {
            searchString=searchString+'lineStatus:'+rmanOrdersAuditVSearchObject.lineStatus+',';
        }

        if (rmanOrdersAuditVSearchObject.unitSellingPrice!=undefined && rmanOrdersAuditVSearchObject.unitSellingPrice!="") {
            searchString=searchString+'unitSellingPrice:'+rmanOrdersAuditVSearchObject.unitSellingPrice+',';
        }

        if (rmanOrdersAuditVSearchObject.unitListPrice!=undefined && rmanOrdersAuditVSearchObject.unitListPrice!="") {
            searchString=searchString+'unitListPrice:'+rmanOrdersAuditVSearchObject.unitListPrice+',';
        }

        if (rmanOrdersAuditVSearchObject.shippableFlag!=undefined && rmanOrdersAuditVSearchObject.shippableFlag!="") {
            searchString=searchString+'shippableFlag:'+rmanOrdersAuditVSearchObject.shippableFlag+',';
        }

        if (rmanOrdersAuditVSearchObject.invoiceFlag!=undefined && rmanOrdersAuditVSearchObject.invoiceFlag!="") {
            searchString=searchString+'invoiceFlag:'+rmanOrdersAuditVSearchObject.invoiceFlag+',';
        }

        if (rmanOrdersAuditVSearchObject.orginalLineId!=undefined && rmanOrdersAuditVSearchObject.orginalLineId!="") {
            searchString=searchString+'orginalLineId:'+rmanOrdersAuditVSearchObject.orginalLineId+',';
        }

        if (rmanOrdersAuditVSearchObject.origRmanLineId!=undefined && rmanOrdersAuditVSearchObject.origRmanLineId!="") {
            searchString=searchString+'origRmanLineId:'+rmanOrdersAuditVSearchObject.origRmanLineId+',';
        }

        if (rmanOrdersAuditVSearchObject.orginalLineNumber!=undefined && rmanOrdersAuditVSearchObject.orginalLineNumber!="") {
            searchString=searchString+'orginalLineNumber:'+rmanOrdersAuditVSearchObject.orginalLineNumber+',';
        }

        if (rmanOrdersAuditVSearchObject.orginalOrderNumber!=undefined && rmanOrdersAuditVSearchObject.orginalOrderNumber!="") {
            searchString=searchString+'orginalOrderNumber:'+rmanOrdersAuditVSearchObject.orginalOrderNumber+',';
        }

        if (rmanOrdersAuditVSearchObject.accountingRuleName!=undefined && rmanOrdersAuditVSearchObject.accountingRuleName!="") {
            searchString=searchString+'accountingRuleName:'+rmanOrdersAuditVSearchObject.accountingRuleName+',';
        }

        if (rmanOrdersAuditVSearchObject.rmanAcctRuleId!=undefined && rmanOrdersAuditVSearchObject.rmanAcctRuleId!="") {
            searchString=searchString+'rmanAcctRuleId:'+rmanOrdersAuditVSearchObject.rmanAcctRuleId+',';
        }

        if (rmanOrdersAuditVSearchObject.serviceStartDate!=undefined && rmanOrdersAuditVSearchObject.serviceStartDate!="") {
            searchString=searchString+'serviceStartDate:'+rmanOrdersAuditVSearchObject.serviceStartDate+',';
        }

        if (rmanOrdersAuditVSearchObject.serviceEndDate!=undefined && rmanOrdersAuditVSearchObject.serviceEndDate!="") {
            searchString=searchString+'serviceEndDate:'+rmanOrdersAuditVSearchObject.serviceEndDate+',';
        }

        if (rmanOrdersAuditVSearchObject.serviceDuration!=undefined && rmanOrdersAuditVSearchObject.serviceDuration!="") {
            searchString=searchString+'serviceDuration:'+rmanOrdersAuditVSearchObject.serviceDuration+',';
        }

        if (rmanOrdersAuditVSearchObject.servicePeriod!=undefined && rmanOrdersAuditVSearchObject.servicePeriod!="") {
            searchString=searchString+'servicePeriod:'+rmanOrdersAuditVSearchObject.servicePeriod+',';
        }

        if (rmanOrdersAuditVSearchObject.lineAttribute1!=undefined && rmanOrdersAuditVSearchObject.lineAttribute1!="") {
            searchString=searchString+'lineAttribute1:'+rmanOrdersAuditVSearchObject.lineAttribute1+',';
        }

        if (rmanOrdersAuditVSearchObject.lineAttribute2!=undefined && rmanOrdersAuditVSearchObject.lineAttribute2!="") {
            searchString=searchString+'lineAttribute2:'+rmanOrdersAuditVSearchObject.lineAttribute2+',';
        }

        if (rmanOrdersAuditVSearchObject.lineAttribute3!=undefined && rmanOrdersAuditVSearchObject.lineAttribute3!="") {
            searchString=searchString+'lineAttribute3:'+rmanOrdersAuditVSearchObject.lineAttribute3+',';
        }

        if (rmanOrdersAuditVSearchObject.lineAttribute4!=undefined && rmanOrdersAuditVSearchObject.lineAttribute4!="") {
            searchString=searchString+'lineAttribute4:'+rmanOrdersAuditVSearchObject.lineAttribute4+',';
        }

        if (rmanOrdersAuditVSearchObject.lineAttribute5!=undefined && rmanOrdersAuditVSearchObject.lineAttribute5!="") {
            searchString=searchString+'lineAttribute5:'+rmanOrdersAuditVSearchObject.lineAttribute5+',';
        }

        if (rmanOrdersAuditVSearchObject.lineAttribute6!=undefined && rmanOrdersAuditVSearchObject.lineAttribute6!="") {
            searchString=searchString+'lineAttribute6:'+rmanOrdersAuditVSearchObject.lineAttribute6+',';
        }

        if (rmanOrdersAuditVSearchObject.lineAttribute7!=undefined && rmanOrdersAuditVSearchObject.lineAttribute7!="") {
            searchString=searchString+'lineAttribute7:'+rmanOrdersAuditVSearchObject.lineAttribute7+',';
        }

        if (rmanOrdersAuditVSearchObject.lineAttribute8!=undefined && rmanOrdersAuditVSearchObject.lineAttribute8!="") {
            searchString=searchString+'lineAttribute8:'+rmanOrdersAuditVSearchObject.lineAttribute8+',';
        }

        if (rmanOrdersAuditVSearchObject.lineAttribute9!=undefined && rmanOrdersAuditVSearchObject.lineAttribute9!="") {
            searchString=searchString+'lineAttribute9:'+rmanOrdersAuditVSearchObject.lineAttribute9+',';
        }

        if (rmanOrdersAuditVSearchObject.lineAttribute10!=undefined && rmanOrdersAuditVSearchObject.lineAttribute10!="") {
            searchString=searchString+'lineAttribute10:'+rmanOrdersAuditVSearchObject.lineAttribute10+',';
        }

        if (rmanOrdersAuditVSearchObject.lineAttribute11!=undefined && rmanOrdersAuditVSearchObject.lineAttribute11!="") {
            searchString=searchString+'lineAttribute11:'+rmanOrdersAuditVSearchObject.lineAttribute11+',';
        }

        if (rmanOrdersAuditVSearchObject.lineAttribute12!=undefined && rmanOrdersAuditVSearchObject.lineAttribute12!="") {
            searchString=searchString+'lineAttribute12:'+rmanOrdersAuditVSearchObject.lineAttribute12+',';
        }

        if (rmanOrdersAuditVSearchObject.lineAttribute13!=undefined && rmanOrdersAuditVSearchObject.lineAttribute13!="") {
            searchString=searchString+'lineAttribute13:'+rmanOrdersAuditVSearchObject.lineAttribute13+',';
        }

        if (rmanOrdersAuditVSearchObject.lineAttribute14!=undefined && rmanOrdersAuditVSearchObject.lineAttribute14!="") {
            searchString=searchString+'lineAttribute14:'+rmanOrdersAuditVSearchObject.lineAttribute14+',';
        }

        if (rmanOrdersAuditVSearchObject.lineAttribute15!=undefined && rmanOrdersAuditVSearchObject.lineAttribute15!="") {
            searchString=searchString+'lineAttribute15:'+rmanOrdersAuditVSearchObject.lineAttribute15+',';
        }

        if (rmanOrdersAuditVSearchObject.headerAttribute1!=undefined && rmanOrdersAuditVSearchObject.headerAttribute1!="") {
            searchString=searchString+'headerAttribute1:'+rmanOrdersAuditVSearchObject.headerAttribute1+',';
        }

        if (rmanOrdersAuditVSearchObject.headerAttribute2!=undefined && rmanOrdersAuditVSearchObject.headerAttribute2!="") {
            searchString=searchString+'headerAttribute2:'+rmanOrdersAuditVSearchObject.headerAttribute2+',';
        }

        if (rmanOrdersAuditVSearchObject.headerAttribute3!=undefined && rmanOrdersAuditVSearchObject.headerAttribute3!="") {
            searchString=searchString+'headerAttribute3:'+rmanOrdersAuditVSearchObject.headerAttribute3+',';
        }

        if (rmanOrdersAuditVSearchObject.headerAttribute4!=undefined && rmanOrdersAuditVSearchObject.headerAttribute4!="") {
            searchString=searchString+'headerAttribute4:'+rmanOrdersAuditVSearchObject.headerAttribute4+',';
        }

        if (rmanOrdersAuditVSearchObject.headerAttribute5!=undefined && rmanOrdersAuditVSearchObject.headerAttribute5!="") {
            searchString=searchString+'headerAttribute5:'+rmanOrdersAuditVSearchObject.headerAttribute5+',';
        }

        if (rmanOrdersAuditVSearchObject.headerAttribute6!=undefined && rmanOrdersAuditVSearchObject.headerAttribute6!="") {
            searchString=searchString+'headerAttribute6:'+rmanOrdersAuditVSearchObject.headerAttribute6+',';
        }

        if (rmanOrdersAuditVSearchObject.headerAttribute7!=undefined && rmanOrdersAuditVSearchObject.headerAttribute7!="") {
            searchString=searchString+'headerAttribute7:'+rmanOrdersAuditVSearchObject.headerAttribute7+',';
        }

        if (rmanOrdersAuditVSearchObject.headerAttribute8!=undefined && rmanOrdersAuditVSearchObject.headerAttribute8!="") {
            searchString=searchString+'headerAttribute8:'+rmanOrdersAuditVSearchObject.headerAttribute8+',';
        }

        if (rmanOrdersAuditVSearchObject.headerAttribute9!=undefined && rmanOrdersAuditVSearchObject.headerAttribute9!="") {
            searchString=searchString+'headerAttribute9:'+rmanOrdersAuditVSearchObject.headerAttribute9+',';
        }

        if (rmanOrdersAuditVSearchObject.headerAttribute10!=undefined && rmanOrdersAuditVSearchObject.headerAttribute10!="") {
            searchString=searchString+'headerAttribute10:'+rmanOrdersAuditVSearchObject.headerAttribute10+',';
        }

        if (rmanOrdersAuditVSearchObject.headerAttribute11!=undefined && rmanOrdersAuditVSearchObject.headerAttribute11!="") {
            searchString=searchString+'headerAttribute11:'+rmanOrdersAuditVSearchObject.headerAttribute11+',';
        }

        if (rmanOrdersAuditVSearchObject.headerAttribute12!=undefined && rmanOrdersAuditVSearchObject.headerAttribute12!="") {
            searchString=searchString+'headerAttribute12:'+rmanOrdersAuditVSearchObject.headerAttribute12+',';
        }

        if (rmanOrdersAuditVSearchObject.headerAttribute13!=undefined && rmanOrdersAuditVSearchObject.headerAttribute13!="") {
            searchString=searchString+'headerAttribute13:'+rmanOrdersAuditVSearchObject.headerAttribute13+',';
        }

        if (rmanOrdersAuditVSearchObject.headerAttribute14!=undefined && rmanOrdersAuditVSearchObject.headerAttribute14!="") {
            searchString=searchString+'headerAttribute14:'+rmanOrdersAuditVSearchObject.headerAttribute14+',';
        }

        if (rmanOrdersAuditVSearchObject.headerAttribute15!=undefined && rmanOrdersAuditVSearchObject.headerAttribute15!="") {
            searchString=searchString+'headerAttribute15:'+rmanOrdersAuditVSearchObject.headerAttribute15+',';
        }

        if (rmanOrdersAuditVSearchObject.creationDate!=undefined && rmanOrdersAuditVSearchObject.creationDate!="") {
            searchString=searchString+'creationDate:'+rmanOrdersAuditVSearchObject.creationDate+',';
        }

        if (rmanOrdersAuditVSearchObject.createdBy!=undefined && rmanOrdersAuditVSearchObject.createdBy!="") {
            searchString=searchString+'createdBy:'+rmanOrdersAuditVSearchObject.createdBy+',';
        }

        if (rmanOrdersAuditVSearchObject.lastUpdateDate!=undefined && rmanOrdersAuditVSearchObject.lastUpdateDate!="") {
            searchString=searchString+'lastUpdateDate:'+rmanOrdersAuditVSearchObject.lastUpdateDate+',';
        }

        if (rmanOrdersAuditVSearchObject.lastUpdatedBy!=undefined && rmanOrdersAuditVSearchObject.lastUpdatedBy!="") {
            searchString=searchString+'lastUpdatedBy:'+rmanOrdersAuditVSearchObject.lastUpdatedBy+',';
        }

        if (rmanOrdersAuditVSearchObject.arrangementId!=undefined && rmanOrdersAuditVSearchObject.arrangementId!="") {
            searchString=searchString+'arrangementId:'+rmanOrdersAuditVSearchObject.arrangementId+',';
        }

        if (rmanOrdersAuditVSearchObject.allocationAmount!=undefined && rmanOrdersAuditVSearchObject.allocationAmount!="") {
            searchString=searchString+'allocationAmount:'+rmanOrdersAuditVSearchObject.allocationAmount+',';
        }

        if (rmanOrdersAuditVSearchObject.carveInOrOut!=undefined && rmanOrdersAuditVSearchObject.carveInOrOut!="") {
            searchString=searchString+'carveInOrOut:'+rmanOrdersAuditVSearchObject.carveInOrOut+',';
        }

        if (rmanOrdersAuditVSearchObject.fmvHistoryFlag!=undefined && rmanOrdersAuditVSearchObject.fmvHistoryFlag!="") {
            searchString=searchString+'fmvHistoryFlag:'+rmanOrdersAuditVSearchObject.fmvHistoryFlag+',';
        }

        if (rmanOrdersAuditVSearchObject.eitfSop!=undefined && rmanOrdersAuditVSearchObject.eitfSop!="") {
            searchString=searchString+'eitfSop:'+rmanOrdersAuditVSearchObject.eitfSop+',';
        }

        if (rmanOrdersAuditVSearchObject.fmvRuleDefId!=undefined && rmanOrdersAuditVSearchObject.fmvRuleDefId!="") {
            searchString=searchString+'fmvRuleDefId:'+rmanOrdersAuditVSearchObject.fmvRuleDefId+',';
        }

        if (rmanOrdersAuditVSearchObject.repCurrUsp!=undefined && rmanOrdersAuditVSearchObject.repCurrUsp!="") {
            searchString=searchString+'repCurrUsp:'+rmanOrdersAuditVSearchObject.repCurrUsp+',';
        }

        if (rmanOrdersAuditVSearchObject.repCurrUlp!=undefined && rmanOrdersAuditVSearchObject.repCurrUlp!="") {
            searchString=searchString+'repCurrUlp:'+rmanOrdersAuditVSearchObject.repCurrUlp+',';
        }

        if (rmanOrdersAuditVSearchObject.repCurrExtendedAmt!=undefined && rmanOrdersAuditVSearchObject.repCurrExtendedAmt!="") {
            searchString=searchString+'repCurrExtendedAmt:'+rmanOrdersAuditVSearchObject.repCurrExtendedAmt+',';
        }

        if (rmanOrdersAuditVSearchObject.repUnitSellingPrice!=undefined && rmanOrdersAuditVSearchObject.repUnitSellingPrice!="") {
            searchString=searchString+'repUnitSellingPrice:'+rmanOrdersAuditVSearchObject.repUnitSellingPrice+',';
        }

        if (rmanOrdersAuditVSearchObject.repUnitListPrice!=undefined && rmanOrdersAuditVSearchObject.repUnitListPrice!="") {
            searchString=searchString+'repUnitListPrice:'+rmanOrdersAuditVSearchObject.repUnitListPrice+',';
        }

        if (rmanOrdersAuditVSearchObject.elementType!=undefined && rmanOrdersAuditVSearchObject.elementType!="") {
            searchString=searchString+'elementType:'+rmanOrdersAuditVSearchObject.elementType+',';
        }

        if (rmanOrdersAuditVSearchObject.deliveredFlag!=undefined && rmanOrdersAuditVSearchObject.deliveredFlag!="") {
            searchString=searchString+'deliveredFlag:'+rmanOrdersAuditVSearchObject.deliveredFlag+',';
        }

        if (rmanOrdersAuditVSearchObject.parentLineId!=undefined && rmanOrdersAuditVSearchObject.parentLineId!="") {
            searchString=searchString+'parentLineId:'+rmanOrdersAuditVSearchObject.parentLineId+',';
        }

        if (rmanOrdersAuditVSearchObject.projectName!=undefined && rmanOrdersAuditVSearchObject.projectName!="") {
            searchString=searchString+'projectName:'+rmanOrdersAuditVSearchObject.projectName+',';
        }

        if (rmanOrdersAuditVSearchObject.projectNumber!=undefined && rmanOrdersAuditVSearchObject.projectNumber!="") {
            searchString=searchString+'projectNumber:'+rmanOrdersAuditVSearchObject.projectNumber+',';
        }

        if (rmanOrdersAuditVSearchObject.projectId!=undefined && rmanOrdersAuditVSearchObject.projectId!="") {
            searchString=searchString+'projectId:'+rmanOrdersAuditVSearchObject.projectId+',';
        }

        if (rmanOrdersAuditVSearchObject.taskName!=undefined && rmanOrdersAuditVSearchObject.taskName!="") {
            searchString=searchString+'taskName:'+rmanOrdersAuditVSearchObject.taskName+',';
        }

        if (rmanOrdersAuditVSearchObject.taskNumber!=undefined && rmanOrdersAuditVSearchObject.taskNumber!="") {
            searchString=searchString+'taskNumber:'+rmanOrdersAuditVSearchObject.taskNumber+',';
        }

        if (rmanOrdersAuditVSearchObject.taskId!=undefined && rmanOrdersAuditVSearchObject.taskId!="") {
            searchString=searchString+'taskId:'+rmanOrdersAuditVSearchObject.taskId+',';
        }

        if (rmanOrdersAuditVSearchObject.dealNumber!=undefined && rmanOrdersAuditVSearchObject.dealNumber!="") {
            searchString=searchString+'dealNumber:'+rmanOrdersAuditVSearchObject.dealNumber+',';
        }

        if (rmanOrdersAuditVSearchObject.dealLineNumber!=undefined && rmanOrdersAuditVSearchObject.dealLineNumber!="") {
            searchString=searchString+'dealLineNumber:'+rmanOrdersAuditVSearchObject.dealLineNumber+',';
        }

        if (rmanOrdersAuditVSearchObject.lineCost!=undefined && rmanOrdersAuditVSearchObject.lineCost!="") {
            searchString=searchString+'lineCost:'+rmanOrdersAuditVSearchObject.lineCost+',';
        }

        if (rmanOrdersAuditVSearchObject.roleName!=undefined && rmanOrdersAuditVSearchObject.roleName!="") {
            searchString=searchString+'roleName:'+rmanOrdersAuditVSearchObject.roleName+',';
        }

        if (rmanOrdersAuditVSearchObject.revenueCategory!=undefined && rmanOrdersAuditVSearchObject.revenueCategory!="") {
            searchString=searchString+'revenueCategory:'+rmanOrdersAuditVSearchObject.revenueCategory+',';
        }

        if (rmanOrdersAuditVSearchObject.expenditureType!=undefined && rmanOrdersAuditVSearchObject.expenditureType!="") {
            searchString=searchString+'expenditureType:'+rmanOrdersAuditVSearchObject.expenditureType+',';
        }

        if (rmanOrdersAuditVSearchObject.repCurrCode!=undefined && rmanOrdersAuditVSearchObject.repCurrCode!="") {
            searchString=searchString+'repCurrCode:'+rmanOrdersAuditVSearchObject.repCurrCode+',';
        }

        if (rmanOrdersAuditVSearchObject.contingencyCode!=undefined && rmanOrdersAuditVSearchObject.contingencyCode!="") {
            searchString=searchString+'contingencyCode:'+rmanOrdersAuditVSearchObject.contingencyCode+',';
        }

        if (rmanOrdersAuditVSearchObject.subElementType!=undefined && rmanOrdersAuditVSearchObject.subElementType!="") {
            searchString=searchString+'subElementType:'+rmanOrdersAuditVSearchObject.subElementType+',';
        }

        if (rmanOrdersAuditVSearchObject.allocationFlag!=undefined && rmanOrdersAuditVSearchObject.allocationFlag!="") {
            searchString=searchString+'allocationFlag:'+rmanOrdersAuditVSearchObject.allocationFlag+',';
        }

        if (rmanOrdersAuditVSearchObject.customerPoLineNum!=undefined && rmanOrdersAuditVSearchObject.customerPoLineNum!="") {
            searchString=searchString+'customerPoLineNum:'+rmanOrdersAuditVSearchObject.customerPoLineNum+',';
        }

        if (rmanOrdersAuditVSearchObject.dealArrangementId!=undefined && rmanOrdersAuditVSearchObject.dealArrangementId!="") {
            searchString=searchString+'dealArrangementId:'+rmanOrdersAuditVSearchObject.dealArrangementId+',';
        }

        if (rmanOrdersAuditVSearchObject.poHeaderId!=undefined && rmanOrdersAuditVSearchObject.poHeaderId!="") {
            searchString=searchString+'poHeaderId:'+rmanOrdersAuditVSearchObject.poHeaderId+',';
        }

        if (rmanOrdersAuditVSearchObject.poLineId!=undefined && rmanOrdersAuditVSearchObject.poLineId!="") {
            searchString=searchString+'poLineId:'+rmanOrdersAuditVSearchObject.poLineId+',';
        }

        if (rmanOrdersAuditVSearchObject.actualFulfilledDate!=undefined && rmanOrdersAuditVSearchObject.actualFulfilledDate!="") {
            searchString=searchString+'actualFulfilledDate:'+rmanOrdersAuditVSearchObject.actualFulfilledDate+',';
        }

        if (rmanOrdersAuditVSearchObject.dealLineId!=undefined && rmanOrdersAuditVSearchObject.dealLineId!="") {
            searchString=searchString+'dealLineId:'+rmanOrdersAuditVSearchObject.dealLineId+',';
        }

        if (rmanOrdersAuditVSearchObject.billToLocation!=undefined && rmanOrdersAuditVSearchObject.billToLocation!="") {
            searchString=searchString+'billToLocation:'+rmanOrdersAuditVSearchObject.billToLocation+',';
        }

        if (rmanOrdersAuditVSearchObject.conversionRate!=undefined && rmanOrdersAuditVSearchObject.conversionRate!="") {
            searchString=searchString+'conversionRate:'+rmanOrdersAuditVSearchObject.conversionRate+',';
        }

        if (rmanOrdersAuditVSearchObject.fxDate!=undefined && rmanOrdersAuditVSearchObject.fxDate!="") {
            searchString=searchString+'fxDate:'+rmanOrdersAuditVSearchObject.fxDate+',';
        }

        if (rmanOrdersAuditVSearchObject.fxRate!=undefined && rmanOrdersAuditVSearchObject.fxRate!="") {
            searchString=searchString+'fxRate:'+rmanOrdersAuditVSearchObject.fxRate+',';
        }

        if (rmanOrdersAuditVSearchObject.revrecAccount!=undefined && rmanOrdersAuditVSearchObject.revrecAccount!="") {
            searchString=searchString+'revrecAccount:'+rmanOrdersAuditVSearchObject.revrecAccount+',';
        }

        if (rmanOrdersAuditVSearchObject.revrecAcctRule!=undefined && rmanOrdersAuditVSearchObject.revrecAcctRule!="") {
            searchString=searchString+'revrecAcctRule:'+rmanOrdersAuditVSearchObject.revrecAcctRule+',';
        }

        if (rmanOrdersAuditVSearchObject.revrecAcctScope!=undefined && rmanOrdersAuditVSearchObject.revrecAcctScope!="") {
            searchString=searchString+'revrecAcctScope:'+rmanOrdersAuditVSearchObject.revrecAcctScope+',';
        }

        if (rmanOrdersAuditVSearchObject.revrecDelay!=undefined && rmanOrdersAuditVSearchObject.revrecDelay!="") {
            searchString=searchString+'revrecDelay:'+rmanOrdersAuditVSearchObject.revrecDelay+',';
        }

        if (rmanOrdersAuditVSearchObject.revrecEndDate!=undefined && rmanOrdersAuditVSearchObject.revrecEndDate!="") {
            searchString=searchString+'revrecEndDate:'+rmanOrdersAuditVSearchObject.revrecEndDate+',';
        }

        if (rmanOrdersAuditVSearchObject.revrecStDate!=undefined && rmanOrdersAuditVSearchObject.revrecStDate!="") {
            searchString=searchString+'revrecStDate:'+rmanOrdersAuditVSearchObject.revrecStDate+',';
        }

        if (rmanOrdersAuditVSearchObject.shipToLocation!=undefined && rmanOrdersAuditVSearchObject.shipToLocation!="") {
            searchString=searchString+'shipToLocation:'+rmanOrdersAuditVSearchObject.shipToLocation+',';
        }

        if (rmanOrdersAuditVSearchObject.parentLine!=undefined && rmanOrdersAuditVSearchObject.parentLine!="") {
            searchString=searchString+'parentLine:'+rmanOrdersAuditVSearchObject.parentLine+',';
        }

        if (rmanOrdersAuditVSearchObject.bundleFlag!=undefined && rmanOrdersAuditVSearchObject.bundleFlag!="") {
            searchString=searchString+'bundleFlag:'+rmanOrdersAuditVSearchObject.bundleFlag+',';
        }

        if (rmanOrdersAuditVSearchObject.attributedListPrice!=undefined && rmanOrdersAuditVSearchObject.attributedListPrice!="") {
            searchString=searchString+'attributedListPrice:'+rmanOrdersAuditVSearchObject.attributedListPrice+',';
        }

        if (rmanOrdersAuditVSearchObject.attributedSellPrice!=undefined && rmanOrdersAuditVSearchObject.attributedSellPrice!="") {
            searchString=searchString+'attributedSellPrice:'+rmanOrdersAuditVSearchObject.attributedSellPrice+',';
        }

        if (rmanOrdersAuditVSearchObject.glUpdateDate!=undefined && rmanOrdersAuditVSearchObject.glUpdateDate!="") {
            searchString=searchString+'glUpdateDate:'+rmanOrdersAuditVSearchObject.glUpdateDate+',';
        }

        if (rmanOrdersAuditVSearchObject.glStatus!=undefined && rmanOrdersAuditVSearchObject.glStatus!="") {
            searchString=searchString+'glStatus:'+rmanOrdersAuditVSearchObject.glStatus+',';
        }

        if (rmanOrdersAuditVSearchObject.topModelLineId!=undefined && rmanOrdersAuditVSearchObject.topModelLineId!="") {
            searchString=searchString+'topModelLineId:'+rmanOrdersAuditVSearchObject.topModelLineId+',';
        }

        if (rmanOrdersAuditVSearchObject.linkToLineId!=undefined && rmanOrdersAuditVSearchObject.linkToLineId!="") {
            searchString=searchString+'linkToLineId:'+rmanOrdersAuditVSearchObject.linkToLineId+',';
        }

        if (rmanOrdersAuditVSearchObject.serviceNumber!=undefined && rmanOrdersAuditVSearchObject.serviceNumber!="") {
            searchString=searchString+'serviceNumber:'+rmanOrdersAuditVSearchObject.serviceNumber+',';
        }

        if (rmanOrdersAuditVSearchObject.lineNum!=undefined && rmanOrdersAuditVSearchObject.lineNum!="") {
            searchString=searchString+'lineNum:'+rmanOrdersAuditVSearchObject.lineNum+',';
        }

        if (rmanOrdersAuditVSearchObject.exceptionFlag!=undefined && rmanOrdersAuditVSearchObject.exceptionFlag!="") {
            searchString=searchString+'exceptionFlag:'+rmanOrdersAuditVSearchObject.exceptionFlag+',';
        }

        if (rmanOrdersAuditVSearchObject.exceptionMessage!=undefined && rmanOrdersAuditVSearchObject.exceptionMessage!="") {
            searchString=searchString+'exceptionMessage:'+rmanOrdersAuditVSearchObject.exceptionMessage+',';
        }

        if (rmanOrdersAuditVSearchObject.orderSource!=undefined && rmanOrdersAuditVSearchObject.orderSource!="") {
            searchString=searchString+'orderSource:'+rmanOrdersAuditVSearchObject.orderSource+',';
        }

        if (rmanOrdersAuditVSearchObject.refOrderNumber!=undefined && rmanOrdersAuditVSearchObject.refOrderNumber!="") {
            searchString=searchString+'refOrderNumber:'+rmanOrdersAuditVSearchObject.refOrderNumber+',';
        }

        if (rmanOrdersAuditVSearchObject.serviceRefOrder!=undefined && rmanOrdersAuditVSearchObject.serviceRefOrder!="") {
            searchString=searchString+'serviceRefOrder:'+rmanOrdersAuditVSearchObject.serviceRefOrder+',';
        }

        if (rmanOrdersAuditVSearchObject.serviceRefOrdLineNum!=undefined && rmanOrdersAuditVSearchObject.serviceRefOrdLineNum!="") {
            searchString=searchString+'serviceRefOrdLineNum:'+rmanOrdersAuditVSearchObject.serviceRefOrdLineNum+',';
        }

        if (rmanOrdersAuditVSearchObject.orderNumModifier!=undefined && rmanOrdersAuditVSearchObject.orderNumModifier!="") {
            searchString=searchString+'orderNumModifier:'+rmanOrdersAuditVSearchObject.orderNumModifier+',';
        }

        if (rmanOrdersAuditVSearchObject.objVersionNumber!=undefined && rmanOrdersAuditVSearchObject.objVersionNumber!="") {
            searchString=searchString+'objVersionNumber:'+rmanOrdersAuditVSearchObject.objVersionNumber+',';
        }

        if (rmanOrdersAuditVSearchObject.stdWarranty!=undefined && rmanOrdersAuditVSearchObject.stdWarranty!="") {
            searchString=searchString+'stdWarranty:'+rmanOrdersAuditVSearchObject.stdWarranty+',';
        }

        if (rmanOrdersAuditVSearchObject.extWarranty!=undefined && rmanOrdersAuditVSearchObject.extWarranty!="") {
            searchString=searchString+'extWarranty:'+rmanOrdersAuditVSearchObject.extWarranty+',';
        }

        if (rmanOrdersAuditVSearchObject.domesticInternational!=undefined && rmanOrdersAuditVSearchObject.domesticInternational!="") {
            searchString=searchString+'domesticInternational:'+rmanOrdersAuditVSearchObject.domesticInternational+',';
        }

        if (rmanOrdersAuditVSearchObject.region!=undefined && rmanOrdersAuditVSearchObject.region!="") {
            searchString=searchString+'region:'+rmanOrdersAuditVSearchObject.region+',';
        }

        if (rmanOrdersAuditVSearchObject.territory!=undefined && rmanOrdersAuditVSearchObject.territory!="") {
            searchString=searchString+'territory:'+rmanOrdersAuditVSearchObject.territory+',';
        }

        if (rmanOrdersAuditVSearchObject.revrecHoldType!=undefined && rmanOrdersAuditVSearchObject.revrecHoldType!="") {
            searchString=searchString+'revrecHoldType:'+rmanOrdersAuditVSearchObject.revrecHoldType+',';
        }

        if (rmanOrdersAuditVSearchObject.cancelledQty!=undefined && rmanOrdersAuditVSearchObject.cancelledQty!="") {
            searchString=searchString+'cancelledQty:'+rmanOrdersAuditVSearchObject.cancelledQty+',';
        }

        if (rmanOrdersAuditVSearchObject.cancelledDate!=undefined && rmanOrdersAuditVSearchObject.cancelledDate!="") {
            searchString=searchString+'cancelledDate:'+rmanOrdersAuditVSearchObject.cancelledDate;
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
                
        return this.http.get(serviceUrl).toPromise().then(data => {
            return data;
        });
    }
    
	searchRmanOrdersAuditV(rmanOrdersAuditV: any) {
        return this.http.get(appSettings.apiUrl+'/RMAN_ORDERS_AUDIT_V/search/findBySnoAndRmanLineIdAndSourceHeaderIdAndOrderNumberAndCustomerPoNumAndOrderTypeAndBookingEntityIdAndShippingEntityIdAndSoldToCustomerAndBillToCustomerAndEndCustomerAndShipToCustomerAndBillToCountryAndShipToCountryAndShippingOrgCodeAndBookedDateAndOrderedDateAndScheduleShipDateAndOrderStatusAndPriceListAndSalesrepAndBookingCurrencyAndFobAndSourceLineIdAndSourceLineNumberAndProductNameAndProductIdAndProductOrgIdAndOrderedQuantityAndShippedQuantityAndFulfilledQuantityAndLineTypeAndLineStatusAndUnitSellingPriceAndUnitListPriceAndShippableFlagAndInvoiceFlagAndOrginalLineIdAndOrigRmanLineIdAndOrginalLineNumberAndOrginalOrderNumberAndAccountingRuleNameAndRmanAcctRuleIdAndServiceStartDateAndServiceEndDateAndServiceDurationAndServicePeriodAndLineAttribute1AndLineAttribute2AndLineAttribute3AndLineAttribute4AndLineAttribute5AndLineAttribute6AndLineAttribute7AndLineAttribute8AndLineAttribute9AndLineAttribute10AndLineAttribute11AndLineAttribute12AndLineAttribute13AndLineAttribute14AndLineAttribute15AndHeaderAttribute1AndHeaderAttribute2AndHeaderAttribute3AndHeaderAttribute4AndHeaderAttribute5AndHeaderAttribute6AndHeaderAttribute7AndHeaderAttribute8AndHeaderAttribute9AndHeaderAttribute10AndHeaderAttribute11AndHeaderAttribute12AndHeaderAttribute13AndHeaderAttribute14AndHeaderAttribute15AndCreationDateAndCreatedByAndLastUpdateDateAndLastUpdatedByAndArrangementIdAndAllocationAmountAndCarveInOrOutAndFmvHistoryFlagAndEitfSopAndFmvRuleDefIdAndRepCurrUspAndRepCurrUlpAndRepCurrExtendedAmtAndRepUnitSellingPriceAndRepUnitListPriceAndElementTypeAndDeliveredFlagAndParentLineIdAndProjectNameAndProjectNumberAndProjectIdAndTaskNameAndTaskNumberAndTaskIdAndDealNumberAndDealLineNumberAndLineCostAndRoleNameAndRevenueCategoryAndExpenditureTypeAndRepCurrCodeAndContingencyCodeAndSubElementTypeAndAllocationFlagAndCustomerPoLineNumAndDealArrangementIdAndPoHeaderIdAndPoLineIdAndActualFulfilledDateAndDealLineIdAndBillToLocationAndConversionRateAndFxDateAndFxRateAndRevrecAccountAndRevrecAcctRuleAndRevrecAcctScopeAndRevrecDelayAndRevrecEndDateAndRevrecStDateAndShipToLocationAndParentLineAndBundleFlagAndAttributedListPriceAndAttributedSellPriceAndGlUpdateDateAndGlStatusAndTopModelLineIdAndLinkToLineIdAndServiceNumberAndLineNumAndExceptionFlagAndExceptionMessageAndOrderSourceAndRefOrderNumberAndServiceRefOrderAndServiceRefOrdLineNumAndOrderNumModifierAndObjVersionNumberAndStdWarrantyAndExtWarrantyAndDomesticInternationalAndRegionAndTerritoryAndRevrecHoldTypeAndCancelledQtyAndCancelledDate?sno='+rmanOrdersAuditV.sno+'&rmanLineId='+rmanOrdersAuditV.rmanLineId+'&sourceHeaderId='+rmanOrdersAuditV.sourceHeaderId+'&orderNumber='+rmanOrdersAuditV.orderNumber+'&customerPoNum='+rmanOrdersAuditV.customerPoNum+'&orderType='+rmanOrdersAuditV.orderType+'&bookingEntityId='+rmanOrdersAuditV.bookingEntityId+'&shippingEntityId='+rmanOrdersAuditV.shippingEntityId+'&soldToCustomer='+rmanOrdersAuditV.soldToCustomer+'&billToCustomer='+rmanOrdersAuditV.billToCustomer+'&endCustomer='+rmanOrdersAuditV.endCustomer+'&shipToCustomer='+rmanOrdersAuditV.shipToCustomer+'&billToCountry='+rmanOrdersAuditV.billToCountry+'&shipToCountry='+rmanOrdersAuditV.shipToCountry+'&shippingOrgCode='+rmanOrdersAuditV.shippingOrgCode+'&bookedDate='+rmanOrdersAuditV.bookedDate+'&orderedDate='+rmanOrdersAuditV.orderedDate+'&scheduleShipDate='+rmanOrdersAuditV.scheduleShipDate+'&orderStatus='+rmanOrdersAuditV.orderStatus+'&priceList='+rmanOrdersAuditV.priceList+'&salesrep='+rmanOrdersAuditV.salesrep+'&bookingCurrency='+rmanOrdersAuditV.bookingCurrency+'&fob='+rmanOrdersAuditV.fob+'&sourceLineId='+rmanOrdersAuditV.sourceLineId+'&sourceLineNumber='+rmanOrdersAuditV.sourceLineNumber+'&productName='+rmanOrdersAuditV.productName+'&productId='+rmanOrdersAuditV.productId+'&productOrgId='+rmanOrdersAuditV.productOrgId+'&orderedQuantity='+rmanOrdersAuditV.orderedQuantity+'&shippedQuantity='+rmanOrdersAuditV.shippedQuantity+'&fulfilledQuantity='+rmanOrdersAuditV.fulfilledQuantity+'&lineType='+rmanOrdersAuditV.lineType+'&lineStatus='+rmanOrdersAuditV.lineStatus+'&unitSellingPrice='+rmanOrdersAuditV.unitSellingPrice+'&unitListPrice='+rmanOrdersAuditV.unitListPrice+'&shippableFlag='+rmanOrdersAuditV.shippableFlag+'&invoiceFlag='+rmanOrdersAuditV.invoiceFlag+'&orginalLineId='+rmanOrdersAuditV.orginalLineId+'&origRmanLineId='+rmanOrdersAuditV.origRmanLineId+'&orginalLineNumber='+rmanOrdersAuditV.orginalLineNumber+'&orginalOrderNumber='+rmanOrdersAuditV.orginalOrderNumber+'&accountingRuleName='+rmanOrdersAuditV.accountingRuleName+'&rmanAcctRuleId='+rmanOrdersAuditV.rmanAcctRuleId+'&serviceStartDate='+rmanOrdersAuditV.serviceStartDate+'&serviceEndDate='+rmanOrdersAuditV.serviceEndDate+'&serviceDuration='+rmanOrdersAuditV.serviceDuration+'&servicePeriod='+rmanOrdersAuditV.servicePeriod+'&lineAttribute1='+rmanOrdersAuditV.lineAttribute1+'&lineAttribute2='+rmanOrdersAuditV.lineAttribute2+'&lineAttribute3='+rmanOrdersAuditV.lineAttribute3+'&lineAttribute4='+rmanOrdersAuditV.lineAttribute4+'&lineAttribute5='+rmanOrdersAuditV.lineAttribute5+'&lineAttribute6='+rmanOrdersAuditV.lineAttribute6+'&lineAttribute7='+rmanOrdersAuditV.lineAttribute7+'&lineAttribute8='+rmanOrdersAuditV.lineAttribute8+'&lineAttribute9='+rmanOrdersAuditV.lineAttribute9+'&lineAttribute10='+rmanOrdersAuditV.lineAttribute10+'&lineAttribute11='+rmanOrdersAuditV.lineAttribute11+'&lineAttribute12='+rmanOrdersAuditV.lineAttribute12+'&lineAttribute13='+rmanOrdersAuditV.lineAttribute13+'&lineAttribute14='+rmanOrdersAuditV.lineAttribute14+'&lineAttribute15='+rmanOrdersAuditV.lineAttribute15+'&headerAttribute1='+rmanOrdersAuditV.headerAttribute1+'&headerAttribute2='+rmanOrdersAuditV.headerAttribute2+'&headerAttribute3='+rmanOrdersAuditV.headerAttribute3+'&headerAttribute4='+rmanOrdersAuditV.headerAttribute4+'&headerAttribute5='+rmanOrdersAuditV.headerAttribute5+'&headerAttribute6='+rmanOrdersAuditV.headerAttribute6+'&headerAttribute7='+rmanOrdersAuditV.headerAttribute7+'&headerAttribute8='+rmanOrdersAuditV.headerAttribute8+'&headerAttribute9='+rmanOrdersAuditV.headerAttribute9+'&headerAttribute10='+rmanOrdersAuditV.headerAttribute10+'&headerAttribute11='+rmanOrdersAuditV.headerAttribute11+'&headerAttribute12='+rmanOrdersAuditV.headerAttribute12+'&headerAttribute13='+rmanOrdersAuditV.headerAttribute13+'&headerAttribute14='+rmanOrdersAuditV.headerAttribute14+'&headerAttribute15='+rmanOrdersAuditV.headerAttribute15+'&creationDate='+rmanOrdersAuditV.creationDate+'&createdBy='+rmanOrdersAuditV.createdBy+'&lastUpdateDate='+rmanOrdersAuditV.lastUpdateDate+'&lastUpdatedBy='+rmanOrdersAuditV.lastUpdatedBy+'&arrangementId='+rmanOrdersAuditV.arrangementId+'&allocationAmount='+rmanOrdersAuditV.allocationAmount+'&carveInOrOut='+rmanOrdersAuditV.carveInOrOut+'&fmvHistoryFlag='+rmanOrdersAuditV.fmvHistoryFlag+'&eitfSop='+rmanOrdersAuditV.eitfSop+'&fmvRuleDefId='+rmanOrdersAuditV.fmvRuleDefId+'&repCurrUsp='+rmanOrdersAuditV.repCurrUsp+'&repCurrUlp='+rmanOrdersAuditV.repCurrUlp+'&repCurrExtendedAmt='+rmanOrdersAuditV.repCurrExtendedAmt+'&repUnitSellingPrice='+rmanOrdersAuditV.repUnitSellingPrice+'&repUnitListPrice='+rmanOrdersAuditV.repUnitListPrice+'&elementType='+rmanOrdersAuditV.elementType+'&deliveredFlag='+rmanOrdersAuditV.deliveredFlag+'&parentLineId='+rmanOrdersAuditV.parentLineId+'&projectName='+rmanOrdersAuditV.projectName+'&projectNumber='+rmanOrdersAuditV.projectNumber+'&projectId='+rmanOrdersAuditV.projectId+'&taskName='+rmanOrdersAuditV.taskName+'&taskNumber='+rmanOrdersAuditV.taskNumber+'&taskId='+rmanOrdersAuditV.taskId+'&dealNumber='+rmanOrdersAuditV.dealNumber+'&dealLineNumber='+rmanOrdersAuditV.dealLineNumber+'&lineCost='+rmanOrdersAuditV.lineCost+'&roleName='+rmanOrdersAuditV.roleName+'&revenueCategory='+rmanOrdersAuditV.revenueCategory+'&expenditureType='+rmanOrdersAuditV.expenditureType+'&repCurrCode='+rmanOrdersAuditV.repCurrCode+'&contingencyCode='+rmanOrdersAuditV.contingencyCode+'&subElementType='+rmanOrdersAuditV.subElementType+'&allocationFlag='+rmanOrdersAuditV.allocationFlag+'&customerPoLineNum='+rmanOrdersAuditV.customerPoLineNum+'&dealArrangementId='+rmanOrdersAuditV.dealArrangementId+'&poHeaderId='+rmanOrdersAuditV.poHeaderId+'&poLineId='+rmanOrdersAuditV.poLineId+'&actualFulfilledDate='+rmanOrdersAuditV.actualFulfilledDate+'&dealLineId='+rmanOrdersAuditV.dealLineId+'&billToLocation='+rmanOrdersAuditV.billToLocation+'&conversionRate='+rmanOrdersAuditV.conversionRate+'&fxDate='+rmanOrdersAuditV.fxDate+'&fxRate='+rmanOrdersAuditV.fxRate+'&revrecAccount='+rmanOrdersAuditV.revrecAccount+'&revrecAcctRule='+rmanOrdersAuditV.revrecAcctRule+'&revrecAcctScope='+rmanOrdersAuditV.revrecAcctScope+'&revrecDelay='+rmanOrdersAuditV.revrecDelay+'&revrecEndDate='+rmanOrdersAuditV.revrecEndDate+'&revrecStDate='+rmanOrdersAuditV.revrecStDate+'&shipToLocation='+rmanOrdersAuditV.shipToLocation+'&parentLine='+rmanOrdersAuditV.parentLine+'&bundleFlag='+rmanOrdersAuditV.bundleFlag+'&attributedListPrice='+rmanOrdersAuditV.attributedListPrice+'&attributedSellPrice='+rmanOrdersAuditV.attributedSellPrice+'&glUpdateDate='+rmanOrdersAuditV.glUpdateDate+'&glStatus='+rmanOrdersAuditV.glStatus+'&topModelLineId='+rmanOrdersAuditV.topModelLineId+'&linkToLineId='+rmanOrdersAuditV.linkToLineId+'&serviceNumber='+rmanOrdersAuditV.serviceNumber+'&lineNum='+rmanOrdersAuditV.lineNum+'&exceptionFlag='+rmanOrdersAuditV.exceptionFlag+'&exceptionMessage='+rmanOrdersAuditV.exceptionMessage+'&orderSource='+rmanOrdersAuditV.orderSource+'&refOrderNumber='+rmanOrdersAuditV.refOrderNumber+'&serviceRefOrder='+rmanOrdersAuditV.serviceRefOrder+'&serviceRefOrdLineNum='+rmanOrdersAuditV.serviceRefOrdLineNum+'&orderNumModifier='+rmanOrdersAuditV.orderNumModifier+'&objVersionNumber='+rmanOrdersAuditV.objVersionNumber+'&stdWarranty='+rmanOrdersAuditV.stdWarranty+'&extWarranty='+rmanOrdersAuditV.extWarranty+'&domesticInternational='+rmanOrdersAuditV.domesticInternational+'&region='+rmanOrdersAuditV.region+'&territory='+rmanOrdersAuditV.territory+'&revrecHoldType='+rmanOrdersAuditV.revrecHoldType+'&cancelledQty='+rmanOrdersAuditV.cancelledQty+'&cancelledDate='+rmanOrdersAuditV.cancelledDate).toPromise().then(data => {
			////console.log(data);
			return data; 
			});
    }
    
    saveRmanOrdersAuditV(rmanOrdersAuditV: any) {
        let body = JSON.stringify(rmanOrdersAuditV);
      
        return this.http.post(appSettings.apiUrl+'/RMAN_ORDERS_AUDIT_V',body,httpOptions).toPromise().then(data => {
            return data;
        });
    }
    
    updateRmanOrdersAuditV(rmanOrdersAuditV: any) {
        
        delete rmanOrdersAuditV._links;
        delete rmanOrdersAuditV.interests;
        let body = JSON.stringify(rmanOrdersAuditV);
       
        return this.http.put(appSettings.apiUrl+'/RMAN_ORDERS_AUDIT_V/'+rmanOrdersAuditV.sno,body,httpOptions).toPromise().then(data => {
            return data;
        });
        
    }
    
    deleteRmanOrdersAuditV(rmanOrdersAuditV: any) {
        let deleteUrl=appSettings.apiUrl+'/RMAN_ORDERS_AUDIT_V/'+rmanOrdersAuditV.sno;
   
        return this.http.delete(deleteUrl,httpOptions).toPromise().then(data => {
            return data;
        });
    }

}
