import { Component } from '@angular/core';
import { Table } from 'primeng/table';
import { ConsolidatedArrgSummaryRep } from './consolidatedArrgSummaryRep';
import { ConsolidatedArrgSummaryRepLabels } from './consolidatedArrgSummaryRepLabels';
import { ConsolidatedArrgSummaryRepService } from './consolidatedArrgSummaryRepservice';
declare var require: any;
const appSettings = require('../appsettings');



declare var $: any;

@Component({
    templateUrl: './consolidatedArrgSummaryRep.component.html',
    selector: 'consolidatedArrgSummaryRep-data',
    providers: [ConsolidatedArrgSummaryRepService]
})

export class ConsolidatedArrgSummaryRepComponent {

    displayDialog: boolean;

    displaySearchDialog: boolean;

    consolidatedArrgSummaryRep: ConsolidatedArrgSummaryRep = new ConsolidatedArrgSummaryRepImpl();

    consolidatedArrgSummaryRepSearch: ConsolidatedArrgSummaryRep = new ConsolidatedArrgSummaryRepImpl();

    isSerached: number = 0;

    selectedConsolidatedArrgSummaryRep: ConsolidatedArrgSummaryRep;

    newConsolidatedArrgSummaryRep: boolean;

    consolidatedArrgSummaryRepList: ConsolidatedArrgSummaryRep[];

    cols: any[];
    columns: ILabels;

    columnOptions: any[];

    paginationOptions = {};

    pages: {};

    datasource: any[];
    pageSize: number;
    totalElements: number;
    collapsed: boolean = true;
    searchFields: any = {};
    noData = appSettings.noData;
    loading: boolean;


    constructor(private consolidatedArrgSummaryRepService: ConsolidatedArrgSummaryRepService) {
        this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    }

    ngOnInit() {

        this.getAllConsolidatedArrgSummaryRep();

        this.cols = [];
        let cols: any = [];
        cols["arrangementSource"] = "arrangementSource";
        cols["quantity"] = "quantity";
        cols["analystId"] = "analystId";
        cols["priceList"] = "priceList";
        cols["endDate"] = "endDate";
        cols["elementType"] = "elementType";
        cols["status"] = "status";
        cols["cvInOutAmount"] = "cvInOutAmount";
        cols["dealName"] = "dealName";
        cols["transactionCurrencyCode"] = "transactionCurrencyCode";
        cols["approvedBy"] = "approvedBy";
        cols["arrgLegalEntityId"] = "arrgLegalEntityId";
        cols["approvalDate"] = "approvalDate";
        cols["customerNumber"] = "customerNumber";
        cols["netPrice"] = "netPrice";
        cols["productName"] = "productName";
        cols["managerId"] = "managerId";
        cols["dealStatus"] = "dealStatus";
        cols["uomCode"] = "uomCode";
        cols["agreementCode"] = "agreementCode";
        cols["transactionSellingPrice"] = "transactionSellingPrice";
        cols["listPrice"] = "listPrice";
        cols["dealLineId"] = "dealLineId";
        cols["msaName"] = "msaName";
        cols["transactionListPrice"] = "transactionListPrice";
        cols["approvalStatus"] = "approvalStatus";
        cols["lineNumber"] = "lineNumber";
        cols["allocationAmount"] = "allocationAmount";
        cols["billToCustomerNumber"] = "billToCustomerNumber";
        cols["legalEntity"] = "legalEntity";
        cols["arrangementName"] = "arrangementName";
        cols["dealNumber"] = "dealNumber";
        cols["billToCustomerName"] = "billToCustomerName";
        cols["arrangementBasis"] = "arrangementBasis";
        cols["trxAllocUnitAmt"] = "trxAllocUnitAmt";
        cols["currency"] = "currency";
        cols["salesNodeLevel4"] = "salesNodeLevel4";
        cols["msaNumber"] = "msaNumber";
        cols["salesNodeLevel2"] = "salesNodeLevel2";
        cols["salesNodeLevel3"] = "salesNodeLevel3";
        cols["dealLineNumber"] = "dealLineNumber";
        cols["arrangementNumber"] = "arrangementNumber";
        cols["dealLineCost"] = "dealLineCost";
        cols["arrangementCreationDate"] = "arrangementCreationDate";
        cols["startDate"] = "startDate";
        cols["parentLineId"] = "parentLineId";
        cols["salesNodeLevel1"] = "salesNodeLevel1";
        cols["dealArrangementId"] = "dealArrangementId";
        cols["arrangementType"] = "arrangementType";
        cols["agreementNumber"] = "agreementNumber";
        cols["accountingScope"] = "accountingScope";
        cols["customerName"] = "customerName";
        cols["arrangementCreatedBy"] = "arrangementCreatedBy";
        let consolidatedArrgSummaryRepLabels = new ConsolidatedArrgSummaryRepLabels();
        this.columns = consolidatedArrgSummaryRepLabels.fieldLabels;
        this.columnOptions = [];
        this.cols = [];
        for (let prop in this.columns) {
            this.cols.push({ field: prop, header: this.columns[prop] });
            this.columnOptions.push({ label: this.columns[prop], value: prop });
        }

    }

    reset(dt: Table) {
        dt.reset();
        this.paginationOptions = {};
        this.searchFields = {};
        this.consolidatedArrgSummaryRep = new ConsolidatedArrgSummaryRepImpl();
        this.getAllConsolidatedArrgSummaryRep();
    }

    getAllConsolidatedArrgSummaryRep() {
        this.loading = true;
        this.consolidatedArrgSummaryRepService.getAllConsolidatedArrgSummaryRep(this.paginationOptions, this.consolidatedArrgSummaryRep, this.searchFields).then((consolidatedArrgSummaryRepList: any) => {
            this.datasource = consolidatedArrgSummaryRepList.content;
            this.consolidatedArrgSummaryRepList = consolidatedArrgSummaryRepList.content;
            this.totalElements = consolidatedArrgSummaryRepList.totalElements;
            this.pageSize = consolidatedArrgSummaryRepList.size;
            this.loading = false;
            this.displaySearchDialog = false;
        });
    }

    getConsolidatedArrgSummaryRep(event: any) {
        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.loading = true;
        this.consolidatedArrgSummaryRepService.getAllConsolidatedArrgSummaryRep(this.paginationOptions, this.consolidatedArrgSummaryRep, this.searchFields).then((consolidatedArrgSummaryRepList: any) => {
            this.datasource = consolidatedArrgSummaryRepList.content;
            this.consolidatedArrgSummaryRepList = consolidatedArrgSummaryRepList.content;
            this.totalElements = consolidatedArrgSummaryRepList.totalElements;
            this.pageSize = consolidatedArrgSummaryRepList.size;
            this.loading = false;
        });
    }


    showDialogToAdd() {
        this.newConsolidatedArrgSummaryRep = true;
        this.consolidatedArrgSummaryRep = new ConsolidatedArrgSummaryRepImpl();
        this.displayDialog = true;
    }

    save() {
        if (this.newConsolidatedArrgSummaryRep) {
            this.consolidatedArrgSummaryRepService.saveConsolidatedArrgSummaryRep(this.consolidatedArrgSummaryRep).then((response: any) => {
                this.getAllConsolidatedArrgSummaryRep();
            });
        }
        else {
            this.consolidatedArrgSummaryRepService.updateConsolidatedArrgSummaryRep(this.consolidatedArrgSummaryRep).then((response: any) => {
                this.getAllConsolidatedArrgSummaryRep();
            });
        }
        this.consolidatedArrgSummaryRep = new ConsolidatedArrgSummaryRepImpl();
        this.displayDialog = false;
    }

    delete(consolidatedArrgSummaryRep: any) {
        this.consolidatedArrgSummaryRep = consolidatedArrgSummaryRep;
        this.displayDialog = false;
        if (window.confirm('Are you sure you want to delete this record?')) {
            this.consolidatedArrgSummaryRepList.splice(this.findSelectedConsolidatedArrgSummaryRepIndex(), 1);
            this.consolidatedArrgSummaryRepService.deleteConsolidatedArrgSummaryRep(this.consolidatedArrgSummaryRep).then(response => {
                this.consolidatedArrgSummaryRep = new ConsolidatedArrgSummaryRepImpl();
                this.getAllConsolidatedArrgSummaryRep();
            });
        }

    }

    editRow(consolidatedArrgSummaryRep: any) {
        this.newConsolidatedArrgSummaryRep = false;
        this.consolidatedArrgSummaryRep = this.cloneConsolidatedArrgSummaryRep(consolidatedArrgSummaryRep);
        this.displayDialog = true;

    }

    findSelectedConsolidatedArrgSummaryRepIndex(): number {
        return this.consolidatedArrgSummaryRepList.indexOf(this.selectedConsolidatedArrgSummaryRep);
    }

    onRowSelect(event: any) {
    }

    cloneConsolidatedArrgSummaryRep(c: ConsolidatedArrgSummaryRep): ConsolidatedArrgSummaryRep {
        let consolidatedArrgSummaryRep = new ConsolidatedArrgSummaryRepImpl();
        for (let prop in c) {
            consolidatedArrgSummaryRep[prop] = c[prop];
        }
        return consolidatedArrgSummaryRep;
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
        this.consolidatedArrgSummaryRepSearch = new ConsolidatedArrgSummaryRepImpl();
        if (this.isSerached == 0) {
            this.searchFields = {};
            this.consolidatedArrgSummaryRepSearch = new ConsolidatedArrgSummaryRepImpl();
        }
        this.displaySearchDialog = true;
    }

    search() {
        this.isSerached = 1;
        this.consolidatedArrgSummaryRep = this.consolidatedArrgSummaryRepSearch;
        this.getAllConsolidatedArrgSummaryRep();
        this.displaySearchDialog = false;
    }

    onBeforeToggle(evt: any) {
        this.collapsed = evt.collapsed;
    }

    exportExcel() {
        this.loading = true;
        let serviceUrl = this.consolidatedArrgSummaryRepService.getServiceUrl(this.paginationOptions, this.consolidatedArrgSummaryRep, 1, this.searchFields);
        this.loading = false;
        window.location.href = serviceUrl;
    }
}

export class ConsolidatedArrgSummaryRepImpl implements ConsolidatedArrgSummaryRep {
    constructor(public arrangementSource?: any, public quantity?: any, public analystId?: any, public priceList?: any, public endDate?: any, public elementType?: any, public status?: any, public cvInOutAmount?: any, public dealName?: any, public transactionCurrencyCode?: any, public approvedBy?: any, public arrgLegalEntityId?: any, public approvalDate?: any, public customerNumber?: any, public netPrice?: any, public productName?: any, public managerId?: any, public dealStatus?: any, public uomCode?: any, public agreementCode?: any, public transactionSellingPrice?: any, public listPrice?: any, public dealLineId?: any, public msaName?: any, public transactionListPrice?: any, public approvalStatus?: any, public lineNumber?: any, public allocationAmount?: any, public billToCustomerNumber?: any, public legalEntity?: any, public arrangementName?: any, public dealNumber?: any, public billToCustomerName?: any, public arrangementBasis?: any, public trxAllocUnitAmt?: any, public currency?: any, public salesNodeLevel4?: any, public msaNumber?: any, public salesNodeLevel2?: any, public salesNodeLevel3?: any, public dealLineNumber?: any, public arrangementNumber?: any, public dealLineCost?: any, public arrangementCreationDate?: any, public startDate?: any, public parentLineId?: any, public salesNodeLevel1?: any, public dealArrangementId?: any, public arrangementType?: any, public agreementNumber?: any, public accountingScope?: any, public customerName?: any, public arrangementCreatedBy?: any) { }
}

interface ILabels {
    [index: string]: string;
}
