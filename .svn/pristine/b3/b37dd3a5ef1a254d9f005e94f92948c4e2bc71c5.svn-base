import { Component, OnInit } from '@angular/core';
import { ConfirmationService } from 'primeng/api';
import { Table } from 'primeng/table';
import { NotificationService } from 'src/app/shared/notifications.service';
import { AllExceptionsLabels } from './allExceptionLabels';
import { AllExceptionsService } from './allExceptions.service';
import { AllExceptions } from './exceptions';

declare var $: any;
declare var require: any;
const appSettings = require('../../appsettings');

@Component({
  selector: 'all-exceptions',
  templateUrl: './allExceptions.component.html',
  providers:[AllExceptionsService, ConfirmationService]
})
export class AllExceptionsComponent implements OnInit {

    displayDialog: boolean;

    displaySearchDialog: boolean;
    selectedLines: any[] = [];
    exceptionsList: any[] = [];
    allExceptions: AllExceptions = new AllExceptionsImpl();

    allExceptionsSearch: AllExceptions = new AllExceptionsImpl();

    isSearched: number = 0;
    selectedRmanOrdersInterface: AllExceptions;

    newRmanOrdersInterface: boolean;

    allExceptionsList: AllExceptions[];
    columns: ILabels;
    paginationOptions = {};
    pages: {};
    datasource: any[];
    pageSize: number;
    totalElements: number;
    hideColumnMenu: boolean = true;
    showFilter: boolean = false;
    cellEditedIntfDealDetails: any[] = [];
    collapsed: boolean = true;
    loading: boolean;
    noData = appSettings.noData;

    allExceptionsTypes: any[] = [];
    exceptionsType:any = 'QUOTE';

    quoteExportsColumns:any[] = [];
    bookExportsColumns:any[] = [];
    shipExportsColumns:any[] = [];
    invExportsColumns:any[] = [];
    vcExportsColumns:any[] = [];

    constructor(private allExceptionsService: AllExceptionsService,
        private notificationService: NotificationService, private confirmationService: ConfirmationService) {

        this.allExceptionsTypes.push({ label: 'Quotes', value: 'QUOTE' },
                { label: 'Bookings', value: 'BOOK' },
                { label: 'Shipments', value: 'SHIP' },
                { label: 'Invoices', value: 'INV' },
                { label: 'VC Release', value: 'CONT_RELEASE' });
        this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10' };
    }

    onChange(){
        if(this.exceptionsType === 'QUOTE' || this.exceptionsType === 'INV'){
            this.allExceptions.documentCategory = this.exceptionsType;
            this.allExceptions.eventType = '';
            this.getAllExceptions();
        }
        else if(this.exceptionsType === 'BOOK' || this.exceptionsType === 'SHIP' || this.exceptionsType === 'CONT_RELEASE'){
            this.allExceptions.eventType = this.exceptionsType;
            this.allExceptions.documentCategory = '';
            this.getAllExceptions();
        }
    }

    ngOnInit() {
        let allExceptionsLabels = new AllExceptionsLabels();
        this.columns = allExceptionsLabels.fieldLabels;
        this.selectedLines = [];

        this.quoteExportsColumns.push("documentCategory", "documentSource","dealNumber", 
        "projectNumber", "opportunityNumber", "opportunityName","documentNumber", 
        "documentDescription", "documentHeaderId", "entityName", "entityId", "customerName", 
        "customerNumber", "documentDate", "currencyCode", "SalesRep", "salesTheater", "region", 
        "salesTerritory", "documentLineNumber", "documentLineId", "productName", "quantity", "uom", 
        "unitListPrice", "unitSellingPrice", "parentLineNumber", "serviceStartDate", "serviceEndDate", 
        "unitCost", "contingnecyCode", "contingnecyPercentage", "revenueTemplateName", 
        "refDocumentNumber", "exceptionMessage");

        this.bookExportsColumns.push("documentCategory", "documentSource", "eventType", 
        "dealNumber", "projectNumber", "opportunityNumber", "customerPo", "documentNumber", 
        "documentHeaderId", "documentType", "entityName", "entityId", "customerName", "customerNumber", 
        "documentDate", "documentStatus", "currencyCode", "SalesRep", "salesTheater", "region",
        "salesTerritory", "documentLineId", "documentLineNumber", "productName", "inventoryItemId", 
        "quantity", "uom", "unitListPrice", "unitSellingPrice", "serviceStartDate", "serviceEndDate", 
        "unitCost", "documentLineStatus", "contingencyCode","contApplyType", "contingnecyPercentage", "revenueTemplateName", "refLineId", 
        "refLineNumber", "refDocumentNumber", "parentLineId", "exceptionMessage");

        this.shipExportsColumns.push("documentCategory", "documentSource", "eventType", 
        "documentLineId", "quantity", "documentLineStatus","documentDate", "contingencyCode","contApplyType", "contingnecyPercentage",
        "exceptionMessage");

        this.invExportsColumns.push("documentCategory", "documentSource", "documentType", "documentHeaderId", 
        "documentNumber", "documentDate", "documentLineId", "documentLineNumber", "quantity", 
        "unitSellingPrice", "currencyCode", "amount", "refDocumentNumber", "refLineNumber", "refLineId", 
        "exceptionMessage");

        this.vcExportsColumns.push("documentCategory", "documentSource", "eventType", "documentLineId","contingencyCode",
        "contReleaseType","contReleaseRevenue", "exceptionMessage");


    }
    getAllExceptions() {
        if(this.exceptionsType === undefined || this.exceptionsType === 'QUOTE'){
            this.allExceptions.documentCategory = 'QUOTE';
        }
        this.loading = true;
        this.allExceptionsService.getAllExceptions(this.paginationOptions, this.allExceptions).then((rmanOrdersInterfaceList: any) => {
            this.datasource = rmanOrdersInterfaceList.content;
            this.allExceptionsList = rmanOrdersInterfaceList.content;
            this.totalElements = rmanOrdersInterfaceList.totalElements;
            this.pageSize = rmanOrdersInterfaceList.size;
            this.displaySearchDialog = false;
            this.loading = false;
        });
    }

    getAllTypeExceptions(event: any) {
        if(this.exceptionsType === undefined || this.exceptionsType === 'QUOTE'){
            this.allExceptions.documentCategory = 'QUOTE';
        }
        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.loading = true;
        this.allExceptionsService.getAllExceptions(this.paginationOptions, this.allExceptions).then((rmanOrdersInterfaceList: any) => {
            this.allExceptionsList = rmanOrdersInterfaceList.content;
            this.totalElements = rmanOrdersInterfaceList.totalElements;
            this.pageSize = rmanOrdersInterfaceList.size;
            this.loading = false;
        });

    }


    deleteSelected(dt: Table) {

        this.exceptionsList = [];

        for (let line of this.selectedLines) {
            this.exceptionsList.push(line.trxId);
        }
        if (this.exceptionsList.length > 0) {
            
        this.confirmationService.confirm({
            message: 'Are you sure you want to delete?',
            header: 'Confirmation',
            icon: '',
            accept: () => {
              this.loading = true;
              this.allExceptionsService.deleteSelectedLines(this.exceptionsList).then((response: any) => {
                this.notificationService.showSuccess('Selected records are deleted Successfully  ');
            }).then(() => {
                this.reset(dt);
            }).catch((err: any) => {
                this.loading = false;
                this.notificationService.showError('Getting error While delete records');
            });
            },
            reject: () => {
              this.notificationService.showWarning('You have rejected');
            }
          });

        } else {
            this.notificationService.showInfo('Select at least one record to delete');
        }
    }

    exportExcel() {
        let serviceUrl = this.allExceptionsService.getServiceUrl(this.paginationOptions, this.allExceptions, 1 , 
            this.exceptionsType === 'QUOTE' ? this.quoteExportsColumns : this.exceptionsType === 'BOOK' ? this.bookExportsColumns : this.exceptionsType === 'SHIP' ? this.shipExportsColumns : this.exceptionsType === 'INV' ? this.invExportsColumns : this.exceptionsType === 'CONT_RELEASE' ? this.vcExportsColumns : '',  this.exceptionsType);
        window.location.href = serviceUrl;
    }

    showDialogToAdd() {
        this.newRmanOrdersInterface = true;
        this.allExceptions = new AllExceptionsImpl();
        this.displayDialog = true;
    }
    reset(dt: Table) {

        this.paginationOptions = {};
        this.allExceptions = new AllExceptionsImpl();
        this.onChange();
        this.selectedLines = [];
        dt.reset();
    }

    onBeforeToggle(evt: any) {
        this.collapsed = evt.collapsed;
    }

    editRow(allExceptions: any) {
        this.newRmanOrdersInterface = false;
        this.allExceptions = this.cloneRmanOrdersInterface(allExceptions);
        this.displayDialog = true;

    }
    findSelectedRmanOrdersInterfaceIndex(): number {
        return this.allExceptionsList.indexOf(this.selectedRmanOrdersInterface);
    }

    onRowSelect(event: any) {

    }
    cloneRmanOrdersInterface(c: AllExceptions): AllExceptions {
        let allExceptions = new AllExceptionsImpl();
        for (let prop in c) {
            allExceptions[prop] = c[prop];
        }
        return allExceptions;
    }

    toggleColumnMenu() {
        if (this.hideColumnMenu) {
            this.hideColumnMenu = false;
        } else {
            this.hideColumnMenu = true;
        }
    }

    toggleFilterBox() {
        if (this.showFilter) {
            this.showFilter = false;
        } else {
            this.showFilter = true;
        }
    }

    showDialogToSearch() {
        this.allExceptionsSearch = new AllExceptionsImpl();
        if (this.isSearched == 0) {
            this.allExceptionsSearch = new AllExceptionsImpl();
        }
        this.displaySearchDialog = true;

    }

    search() {
        this.isSearched = 1;
        this.allExceptions = this.allExceptionsSearch;
        this.onChange();
    }
    cancelSearch() {
        this.displaySearchDialog = false;
        this.allExceptionsSearch = new AllExceptionsImpl();
    }
}


class AllExceptionsImpl implements AllExceptions {
    constructor(public documentCategory?,public documentSource?,public dealNumber?,public projectNumber?,public opportunityNumber?,public opportunityName?,public documentNumber?,public documentDescription?,public documentHeaderId?,public entityName?,public entityId?,public customerName?,public customerNumber?,public documentDate?,public currencyCode?,public salesRep?,public salesTheater?,public region?,public salesTerritory?,public documentLineNumber?,public documentLineId?,public productName?,public quantity?,public uom?,public unitListPrice?,public unitSellingPrice?,public parentLineNumber?,public serviceStartDate?,public serviceEndDate?,public unitCost?,public contingnecyCode?,public contingnecyPercentage?,public revenueTemplateName?,public refDocumentNumber?,public processFlag?,public eventType?, public trxId?,
        public customerPo?,
        public documentType?,
        public inventoryItemId?,
        public refLineId?,
        public refLineNumber?,
        public amount?,
        public exceptionMessage?,
        public documentLineStatus?,
        public processId?,
        public documentStatus?,
        public contApplyType?,
        public contReleaseType?,
        public contReleaseRevenue?) { }
}

interface ILabels {
    [index: string]: string;
}

