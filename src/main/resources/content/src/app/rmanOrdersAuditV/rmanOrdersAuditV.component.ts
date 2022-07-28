import { Component, Input, OnChanges, OnInit, SimpleChange } from '@angular/core';
import { RmanOrdersAuditV } from './rmanOrdersAuditV';
import { RmanOrdersAuditVLabels } from './rmanOrdersAuditVLabels';
import { RmanOrdersAuditVService } from './rmanOrdersAuditVservice';
declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
    templateUrl: './rmanOrdersAuditV.component.html',
    selector: 'rmanOrdersAuditV-data',
    providers: [RmanOrdersAuditVService]
})

export class RmanOrdersAuditVComponent implements OnInit, OnChanges {

    displayDialog: boolean;

    displaySearchDialog: boolean;

    rmanOrdersAuditV: any = new RmanOrdersAuditVImpl();

    rmanOrdersAuditVSearch: any = new RmanOrdersAuditVImpl();

    isSerached: number = 0;

    selectedRmanOrdersAuditV: RmanOrdersAuditV;

    newRmanOrdersAuditV: boolean;

    rmanOrdersAuditVList: RmanOrdersAuditV[];

    cols: any[];
    columns: ILabels;

    columnOptions: any[];

    paginationOptions = {};

    pages: {};


    datasource: any[];
    pageSize: number;
    totalElements: number;
    @Input() sourceLineId: any;
    noData = appSettings.noData;



    constructor(private rmanOrdersAuditVService: RmanOrdersAuditVService) {

        // generate list code
        this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };



    }

    ngOnInit() {

        this.getAllRmanOrdersAuditV();

        this.cols = [];
        let cols: any = [];
        cols["origRmanLineId"] = "origRmanLineId";
        cols["sourceLineId"] = "sourceLineId";
        cols["carveInOrOut"] = "carveInOrOut";
        cols["repCurrExtendedAmt"] = "repCurrExtendedAmt";
        cols["territory"] = "territory";
        cols["lineNum"] = "lineNum";
        cols["elementType"] = "elementType";
        cols["salesrep"] = "salesrep";
        cols["shippingEntityId"] = "shippingEntityId";
        cols["productOrgId"] = "productOrgId";
        cols["billToCountry"] = "billToCountry";
        cols["cancelledQty"] = "cancelledQty";
        cols["unitSellingPrice"] = "unitSellingPrice";
        cols["topModelLineId"] = "topModelLineId";
        cols["serviceRefOrder"] = "serviceRefOrder";
        cols["billToLocation"] = "billToLocation";
        cols["glStatus"] = "glStatus";
        cols["scheduleShipDate"] = "scheduleShipDate";
        cols["customerPoNum"] = "customerPoNum";
        cols["arrangementId"] = "arrangementId";
        cols["region"] = "region";
        cols["rmanAcctRuleId"] = "rmanAcctRuleId";
        cols["fmvRuleDefId"] = "fmvRuleDefId";
        cols["orderedQuantity"] = "orderedQuantity";
        cols["glUpdateDate"] = "glUpdateDate";
        cols["shippingOrgCode"] = "shippingOrgCode";
        cols["taskId"] = "taskId";
        cols["lineAttribute6"] = "lineAttribute6";
        cols["lineAttribute5"] = "lineAttribute5";
        cols["headerAttribute10"] = "headerAttribute10";
        cols["lineAttribute8"] = "lineAttribute8";
        cols["headerAttribute11"] = "headerAttribute11";
        cols["lineAttribute7"] = "lineAttribute7";
        cols["headerAttribute12"] = "headerAttribute12";
        cols["soldToCustomer"] = "soldToCustomer";
        cols["lineAttribute2"] = "lineAttribute2";
        cols["headerAttribute13"] = "headerAttribute13";
        cols["customerPoLineNum"] = "customerPoLineNum";
        cols["lineAttribute1"] = "lineAttribute1";
        cols["headerAttribute14"] = "headerAttribute14";
        cols["lineAttribute4"] = "lineAttribute4";
        cols["headerAttribute15"] = "headerAttribute15";
        cols["repUnitSellingPrice"] = "repUnitSellingPrice";
        cols["lineAttribute3"] = "lineAttribute3";
        cols["allocationAmount"] = "allocationAmount";
        cols["lineAttribute9"] = "lineAttribute9";
        cols["contingencyCode"] = "contingencyCode";
        cols["cancelledDate"] = "cancelledDate";
        cols["fxRate"] = "fxRate";
        cols["objVersionNumber"] = "objVersionNumber";
        cols["sno"] = "sno";
        cols["lineAttribute12"] = "lineAttribute12";
        cols["shippedQuantity"] = "shippedQuantity";
        cols["lineAttribute13"] = "lineAttribute13";
        cols["lineAttribute10"] = "lineAttribute10";
        cols["lineAttribute11"] = "lineAttribute11";
        cols["shipToLocation"] = "shipToLocation";
        cols["dealNumber"] = "dealNumber";
        cols["expenditureType"] = "expenditureType";
        cols["billToCustomer"] = "billToCustomer";
        cols["lineAttribute14"] = "lineAttribute14";
        cols["projectId"] = "projectId";
        cols["lineAttribute15"] = "lineAttribute15";
        cols["shipToCustomer"] = "shipToCustomer";
        cols["refOrderNumber"] = "refOrderNumber";
        cols["dealLineNumber"] = "dealLineNumber";
        cols["bookingCurrency"] = "bookingCurrency";
        cols["lineType"] = "lineType";
        cols["projectNumber"] = "projectNumber";
        cols["orderType"] = "orderType";
        cols["revrecAcctRule"] = "revrecAcctRule";
        cols["parentLineId"] = "parentLineId";
        cols["roleName"] = "roleName";
        cols["bookedDate"] = "bookedDate";
        cols["accountingRuleName"] = "accountingRuleName";
        cols["repCurrUlp"] = "repCurrUlp";
        cols["exceptionFlag"] = "exceptionFlag";
        cols["serviceEndDate"] = "serviceEndDate";
        cols["domesticInternational"] = "domesticInternational";
        cols["poHeaderId"] = "poHeaderId";
        cols["taskNumber"] = "taskNumber";
        cols["shipToCountry"] = "shipToCountry";
        cols["revenueCategory"] = "revenueCategory";
        cols["orderNumModifier"] = "orderNumModifier";
        cols["eitfSop"] = "eitfSop";
        cols["revrecStDate"] = "revrecStDate";
        cols["bundleFlag"] = "bundleFlag";
        cols["fxDate"] = "fxDate";
        cols["revrecAcctScope"] = "revrecAcctScope";
        cols["priceList"] = "priceList";
        cols["repCurrUsp"] = "repCurrUsp";
        cols["orginalOrderNumber"] = "orginalOrderNumber";
        cols["exceptionMessage"] = "exceptionMessage";
        cols["sourceHeaderId"] = "sourceHeaderId";
        cols["lastUpdateDate"] = "lastUpdateDate";
        cols["orginalLineId"] = "orginalLineId";
        cols["fob"] = "fob";
        cols["unitListPrice"] = "unitListPrice";
        cols["allocationFlag"] = "allocationFlag";
        cols["createdBy"] = "createdBy";
        cols["lastUpdatedBy"] = "lastUpdatedBy";
        cols["revrecDelay"] = "revrecDelay";
        cols["sourceLineNumber"] = "sourceLineNumber";
        cols["taskName"] = "taskName";
        cols["creationDate"] = "creationDate";
        cols["shippableFlag"] = "shippableFlag";
        cols["productName"] = "productName";
        cols["lineStatus"] = "lineStatus";
        cols["stdWarranty"] = "stdWarranty";
        cols["linkToLineId"] = "linkToLineId";
        cols["orginalLineNumber"] = "orginalLineNumber";
        cols["repUnitListPrice"] = "repUnitListPrice";
        cols["rmanLineId"] = "rmanLineId";
        cols["deliveredFlag"] = "deliveredFlag";
        cols["attributedListPrice"] = "attributedListPrice";
        cols["dealLineId"] = "dealLineId";
        cols["headerAttribute1"] = "headerAttribute1";
        cols["headerAttribute6"] = "headerAttribute6";
        cols["headerAttribute7"] = "headerAttribute7";
        cols["headerAttribute8"] = "headerAttribute8";
        cols["headerAttribute9"] = "headerAttribute9";
        cols["headerAttribute2"] = "headerAttribute2";
        cols["fmvHistoryFlag"] = "fmvHistoryFlag";
        cols["headerAttribute3"] = "headerAttribute3";
        cols["servicePeriod"] = "servicePeriod";
        cols["headerAttribute4"] = "headerAttribute4";
        cols["projectName"] = "projectName";
        cols["headerAttribute5"] = "headerAttribute5";
        cols["serviceRefOrdLineNum"] = "serviceRefOrdLineNum";
        cols["revrecEndDate"] = "revrecEndDate";
        cols["subElementType"] = "subElementType";
        cols["fulfilledQuantity"] = "fulfilledQuantity";
        cols["orderStatus"] = "orderStatus";
        cols["serviceStartDate"] = "serviceStartDate";
        cols["endCustomer"] = "endCustomer";
        cols["revrecHoldType"] = "revrecHoldType";
        cols["repCurrCode"] = "repCurrCode";
        cols["actualFulfilledDate"] = "actualFulfilledDate";
        cols["serviceDuration"] = "serviceDuration";
        cols["conversionRate"] = "conversionRate";
        cols["serviceNumber"] = "serviceNumber";
        cols["productId"] = "productId";
        cols["invoiceFlag"] = "invoiceFlag";
        cols["dealArrangementId"] = "dealArrangementId";
        cols["bookingEntityId"] = "bookingEntityId";
        cols["attributedSellPrice"] = "attributedSellPrice";
        cols["extWarranty"] = "extWarranty";
        cols["revrecAccount"] = "revrecAccount";
        cols["orderSource"] = "orderSource";
        cols["orderNumber"] = "orderNumber";
        cols["orderedDate"] = "orderedDate";
        cols["parentLine"] = "parentLine";
        cols["lineCost"] = "lineCost";
        cols["poLineId"] = "poLineId";
        let rmanOrdersAuditVLabels = new RmanOrdersAuditVLabels();

        this.columns = rmanOrdersAuditVLabels.fieldLabels;

        this.columnOptions = [];

        this.cols = [];
        for (let prop in this.columns) {
            this.cols.push({ field: prop, header: this.columns[prop] });
            this.columnOptions.push({ label: this.columns[prop], value: prop });
        }
    }

    ngOnChanges(changes: { [propKey: string]: SimpleChange }) {
        this.sourceLineId = changes['sourceLineId'].currentValue;
        this.getAllRmanOrdersAuditV();

    }

    getAllRmanOrdersAuditV() {
        if (this.sourceLineId) {
            this.rmanOrdersAuditVService.getAllRmanOrdersAuditV(this.paginationOptions, { 'sourceLineId': this.sourceLineId }).then((rmanOrdersAuditVList: any) => {
                this.datasource = rmanOrdersAuditVList.content;
                this.rmanOrdersAuditVList = rmanOrdersAuditVList.content;
                this.totalElements = rmanOrdersAuditVList.totalElements;
                this.pageSize = rmanOrdersAuditVList.size;
                this.displaySearchDialog = false;
            });
        }
    }


    getRmanOrdersAuditV(event: any) {
        if (this.sourceLineId) {
            let first: number = event.first;
            let rows: number = event.rows;
            let pageNumber: number = first / rows;
            this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
            this.rmanOrdersAuditVService.getAllRmanOrdersAuditV(this.paginationOptions, { 'sourceLineId': this.sourceLineId }).then((rmanOrdersAuditVList: any) => {
                this.datasource = rmanOrdersAuditVList.content;
                this.rmanOrdersAuditVList = rmanOrdersAuditVList.content;
                this.totalElements = rmanOrdersAuditVList.totalElements;
                this.pageSize = rmanOrdersAuditVList.size;
            });
        }

    }


    showDialogToAdd() {

        this.newRmanOrdersAuditV = true;
        this.rmanOrdersAuditV = new RmanOrdersAuditVImpl();
        this.displayDialog = true;

    }


    save() {

        if (this.newRmanOrdersAuditV) {
            this.rmanOrdersAuditVService.saveRmanOrdersAuditV(this.rmanOrdersAuditV).then((response: any) => {
                this.getAllRmanOrdersAuditV();
            });
        }
        else {
            this.rmanOrdersAuditVService.updateRmanOrdersAuditV(this.rmanOrdersAuditV).then((response: any) => {
                this.getAllRmanOrdersAuditV();
            });
        }

        this.rmanOrdersAuditV = new RmanOrdersAuditVImpl();

        this.displayDialog = false;

    }


    delete(rmanOrdersAuditV: any) {
        this.rmanOrdersAuditV = rmanOrdersAuditV;
        this.displayDialog = false;
        if (window.confirm('Are you sure you want to delete this record?:any')) {
            this.rmanOrdersAuditVList.splice(this.findSelectedRmanOrdersAuditVIndex(), 1);
            this.rmanOrdersAuditVService.deleteRmanOrdersAuditV(this.rmanOrdersAuditV).then(response => {
                this.rmanOrdersAuditV = new RmanOrdersAuditVImpl();
                this.getAllRmanOrdersAuditV();
            });
        }

    }

    editRow(rmanOrdersAuditV: any) {
        this.newRmanOrdersAuditV = false;
        this.rmanOrdersAuditV = this.cloneRmanOrdersAuditV(rmanOrdersAuditV);
        this.displayDialog = true;

    }


    findSelectedRmanOrdersAuditVIndex(): number {
        return this.rmanOrdersAuditVList.indexOf(this.selectedRmanOrdersAuditV);
    }

    onRowSelect(event: any) {

    }

    cloneRmanOrdersAuditV(c: RmanOrdersAuditV): RmanOrdersAuditV {
        let rmanOrdersAuditV: any = new RmanOrdersAuditVImpl();
        for (let prop in c) {
            rmanOrdersAuditV[prop] = c[prop];
        }
        return rmanOrdersAuditV;
    }

    hideColumnMenu: boolean = true;

    toggleColumnMenu() {
        if (this.hideColumnMenu) {
            this.hideColumnMenu = false;
        } else {
            this.hideColumnMenu = true;
        }
    }

    showFilter: boolean = false;

    toggleFilterBox() {
        if (this.showFilter) {
            this.showFilter = false;
        } else {
            this.showFilter = true;
        }
    }

    showDialogToSearch() {

        this.rmanOrdersAuditVSearch = new RmanOrdersAuditVImpl();

        if (this.isSerached == 0) {
            this.rmanOrdersAuditVSearch = new RmanOrdersAuditVImpl();
        }
        this.displaySearchDialog = true;

    }

    search() {

        this.isSerached = 1;
        this.rmanOrdersAuditV = this.rmanOrdersAuditVSearch;
        this.getAllRmanOrdersAuditV();
    }

}


class RmanOrdersAuditVImpl {
    constructor(public origRmanLineId?: any, public sourceLineId?: any, public carveInOrOut?: any, public repCurrExtendedAmt?: any, public territory?: any, public lineNum?: any, public elementType?: any, public salesrep?: any, public shippingEntityId?: any, public productOrgId?: any, public billToCountry?: any, public cancelledQty?: any, public unitSellingPrice?: any, public topModelLineId?: any, public serviceRefOrder?: any, public billToLocation?: any, public glStatus?: any, public scheduleShipDate?: any, public customerPoNum?: any, public arrangementId?: any, public region?: any, public rmanAcctRuleId?: any, public fmvRuleDefId?: any, public orderedQuantity?: any, public glUpdateDate?: any, public shippingOrgCode?: any, public taskId?: any, public lineAttribute6?: any, public lineAttribute5?: any, public headerAttribute10?: any, public lineAttribute8?: any, public headerAttribute11?: any, public lineAttribute7?: any, public headerAttribute12?: any, public soldToCustomer?: any, public lineAttribute2?: any, public headerAttribute13?: any, public customerPoLineNum?: any, public lineAttribute1?: any, public headerAttribute14?: any, public lineAttribute4?: any, public headerAttribute15?: any, public repUnitSellingPrice?: any, public lineAttribute3?: any, public allocationAmount?: any, public lineAttribute9?: any, public contingencyCode?: any, public cancelledDate?: any, public fxRate?: any, public objVersionNumber?: any, public sno?: any, public lineAttribute12?: any, public shippedQuantity?: any, public lineAttribute13?: any, public lineAttribute10?: any, public lineAttribute11?: any, public shipToLocation?: any, public dealNumber?: any, public expenditureType?: any, public billToCustomer?: any, public lineAttribute14?: any, public projectId?: any, public lineAttribute15?: any, public shipToCustomer?: any, public refOrderNumber?: any, public dealLineNumber?: any, public bookingCurrency?: any, public lineType?: any, public projectNumber?: any, public orderType?: any, public revrecAcctRule?: any, public parentLineId?: any, public roleName?: any, public bookedDate?: any, public accountingRuleName?: any, public repCurrUlp?: any, public exceptionFlag?: any, public serviceEndDate?: any, public domesticInternational?: any, public poHeaderId?: any, public taskNumber?: any, public shipToCountry?: any, public revenueCategory?: any, public orderNumModifier?: any, public eitfSop?: any, public revrecStDate?: any, public bundleFlag?: any, public fxDate?: any, public revrecAcctScope?: any, public priceList?: any, public repCurrUsp?: any, public orginalOrderNumber?: any, public exceptionMessage?: any, public sourceHeaderId?: any, public lastUpdateDate?: any, public orginalLineId?: any, public fob?: any, public unitListPrice?: any, public allocationFlag?: any, public createdBy?: any, public lastUpdatedBy?: any, public revrecDelay?: any, public sourceLineNumber?: any, public taskName?: any, public creationDate?: any, public shippableFlag?: any, public productName?: any, public lineStatus?: any, public stdWarranty?: any, public linkToLineId?: any, public orginalLineNumber?: any, public repUnitListPrice?: any, public rmanLineId?: any, public deliveredFlag?: any, public attributedListPrice?: any, public dealLineId?: any, public headerAttribute1?: any, public headerAttribute6?: any, public headerAttribute7?: any, public headerAttribute8?: any, public headerAttribute9?: any, public headerAttribute2?: any, public fmvHistoryFlag?: any, public headerAttribute3?: any, public servicePeriod?: any, public headerAttribute4?: any, public projectName?: any, public headerAttribute5?: any, public serviceRefOrdLineNum?: any, public revrecEndDate?: any, public subElementType?: any, public fulfilledQuantity?: any, public orderStatus?: any, public serviceStartDate?: any, public endCustomer?: any, public revrecHoldType?: any, public repCurrCode?: any, public actualFulfilledDate?: any, public serviceDuration?: any, public conversionRate?: any, public serviceNumber?: any, public productId?: any, public invoiceFlag?: any, public dealArrangementId?: any, public bookingEntityId?: any, public attributedSellPrice?: any, public extWarranty?: any, public revrecAccount?: any, public orderSource?: any, public orderNumber?: any, public orderedDate?: any, public parentLine?: any, public lineCost?: any, public poLineId?: any) { }
}

interface ILabels {
    [index: string]: string;
}
