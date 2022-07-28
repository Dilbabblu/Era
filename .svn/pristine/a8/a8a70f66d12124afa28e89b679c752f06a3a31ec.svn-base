import { Component, Input } from '@angular/core';
import { Table } from 'primeng/table';
import { NotificationService } from '../shared/notifications.service';
import { RmanOrdersInterface } from './rmanOrdersInterface';
import { RmanOrdersInterfaceLabels } from './rmanOrdersInterfaceLabels';
import { RmanOrdersInterfaceService } from './rmanOrdersInterfaceservice';
declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
    templateUrl: './rmanOrdersInterface.component.html',
    selector: 'rmanOrdersInterface-data',
    providers: [RmanOrdersInterfaceService,]
})

export class RmanOrdersInterfaceComponent {

    displayDialog: boolean;

    displaySearchDialog: boolean;
    selectedLines: any[] = [];
    soLinesList: any[] = [];
    rmanOrdersInterface: RmanOrdersInterface = new RmanOrdersInterfaceImpl();

    rmanOrdersInterfaceSearch: RmanOrdersInterface = new RmanOrdersInterfaceImpl();

    isSearched: number = 0;
    selectedRmanOrdersInterface: RmanOrdersInterface;

    newRmanOrdersInterface: boolean;

    rmanOrdersInterfaceList: RmanOrdersInterface[];
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
    @Input() otype: string = 'B';
    constructor(private rmanOrdersInterfaceService: RmanOrdersInterfaceService,
        private notificationService: NotificationService) {
        this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10' };
    }

    ngOnInit() {
        let rmanOrdersInterfaceLabels = new RmanOrdersInterfaceLabels();
        this.columns = rmanOrdersInterfaceLabels.fieldLabels;
        this.selectedLines = [];
    }
    getAllRmanOrdersInterface() {
        this.loading = true;
        this.rmanOrdersInterfaceService.getAllRmanOrdersInterface(this.paginationOptions, this.rmanOrdersInterface, this.otype).then((rmanOrdersInterfaceList: any) => {
            this.datasource = rmanOrdersInterfaceList.content;
            this.rmanOrdersInterfaceList = rmanOrdersInterfaceList.content;
            this.totalElements = rmanOrdersInterfaceList.totalElements;
            this.pageSize = rmanOrdersInterfaceList.size;
            this.displaySearchDialog = false;
            this.loading = false;
        });
    }

    getRmanOrdersInterface(event: any) {

        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.loading = true;
        this.rmanOrdersInterfaceService.getAllRmanOrdersInterface(this.paginationOptions, this.rmanOrdersInterface, this.otype).then((rmanOrdersInterfaceList: any) => {
            this.rmanOrdersInterfaceList = rmanOrdersInterfaceList.content;
            this.totalElements = rmanOrdersInterfaceList.totalElements;
            this.pageSize = rmanOrdersInterfaceList.size;
            this.loading = false;
        });

    }

    deleteSelected(dt: Table) {

        this.soLinesList = [];

        for (let i = 0; i < this.selectedLines.length; i++) {
            this.soLinesList.push(this.selectedLines[i].sourceLineId);
        }
        if (this.soLinesList.length > 0) {
            this.loading = true;
            this.rmanOrdersInterfaceService.deleteSelectedLines(this.soLinesList, this.otype == 'B' ? 'BOOK' : 'SHIP').then((response: any) => {
                this.notificationService.showSuccess('Successfully selected records are deleted');
            }).then(() => {
                this.reset(dt);
            }).catch((err: any) => {
                this.notificationService.showError('Getting error While delete records');
            });

        } else {
            this.notificationService.showInfo('Select at least one record to delete');
        }
    }
    exportExcel() {
        let serviceUrl = this.rmanOrdersInterfaceService.getServiceUrl(this.paginationOptions, this.rmanOrdersInterface, this.otype, 'N', 1);
        window.location.href = serviceUrl;
    }

    showDialogToAdd() {
        this.newRmanOrdersInterface = true;
        this.rmanOrdersInterface = new RmanOrdersInterfaceImpl();
        this.displayDialog = true;
    }
    reset(dt: Table) {

        this.paginationOptions = {};
        this.rmanOrdersInterface = new RmanOrdersInterfaceImpl();
        this.selectedLines = [];
        dt.reset();
    }

    onBeforeToggle(evt: any) {
        this.collapsed = evt.collapsed;
    }
    saveAndProcessExceptions() {
        if (this.cellEditedIntfDealDetails && this.cellEditedIntfDealDetails.length === 0) {
            this.__processOrders();
        } else {
            this.rmanOrdersInterfaceService.saveRmanOrdersInterface(this.cellEditedIntfDealDetails).then((response: any) => {
                this.paginationOptions = {};
                this.cellEditedIntfDealDetails = [];
                this.__processOrders();
            }).catch((err: any) => {
                this.notificationService.showError('Error occured while saving exceptions');
                this.loading = false;
            });
        }
    }

    __processOrders(){
        this.rmanOrdersInterfaceService.processOrders().then((response: any) => {
            this.notificationService.showSuccess('Saved/Processed succesfully');
            this.loading = false;
            this.getAllRmanOrdersInterface();
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while saving/processing exceptions');
            this.loading = false;
        });
    }

    saveExceptions() {
        if (this.cellEditedIntfDealDetails && this.cellEditedIntfDealDetails.length === 0) {
            this.notificationService.showError('Please edit atleast one exception.');
            return;
        } else {
            this.rmanOrdersInterfaceService.saveRmanOrdersInterface(this.cellEditedIntfDealDetails).then((response: any) => {
                this.notificationService.showSuccess('Saved successfully');
                this.paginationOptions = {};
                this.cellEditedIntfDealDetails = [];
                this.getAllRmanOrdersInterface();
            }).catch((err: any) => {
                this.loading = false;
                this.notificationService.showError('Error occured while saving data');
            });
        }

    }
    onCellEditComplete(rmanIntfDealDetails: any) {
        let indexOfcurrentEditedInAlreadyEdited = this.cellEditedIntfDealDetails.findIndex(exception => exception.sourceLineId === rmanIntfDealDetails.sourceLineId);
        if (indexOfcurrentEditedInAlreadyEdited != -1) {
            this.cellEditedIntfDealDetails.splice(indexOfcurrentEditedInAlreadyEdited, 1);
        }
        rmanIntfDealDetails.errorMessage = null;
        this.cellEditedIntfDealDetails.push(rmanIntfDealDetails);
    }

    delete(rmanOrdersInterface: any) {
        this.rmanOrdersInterface = rmanOrdersInterface;
        this.displayDialog = false;
        if (window.confirm('Are you sure you want to delete this record?')) {
            this.rmanOrdersInterfaceList.splice(this.findSelectedRmanOrdersInterfaceIndex(), 1);
            this.rmanOrdersInterfaceService.deleteRmanOrdersInterface(this.rmanOrdersInterface).then(response => {
                this.rmanOrdersInterface = new RmanOrdersInterfaceImpl();
                this.getAllRmanOrdersInterface();
            });
        }
    }

    editRow(rmanOrdersInterface: any) {
        this.newRmanOrdersInterface = false;
        this.rmanOrdersInterface = this.cloneRmanOrdersInterface(rmanOrdersInterface);
        this.displayDialog = true;

    }
    findSelectedRmanOrdersInterfaceIndex(): number {
        return this.rmanOrdersInterfaceList.indexOf(this.selectedRmanOrdersInterface);
    }

    onRowSelect(event: any) {

    }
    cloneRmanOrdersInterface(c: RmanOrdersInterface): RmanOrdersInterface {
        let rmanOrdersInterface = new RmanOrdersInterfaceImpl();
        for (let prop in c) {
            rmanOrdersInterface[prop] = c[prop];
        }
        return rmanOrdersInterface;
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
        this.rmanOrdersInterfaceSearch = new RmanOrdersInterfaceImpl();
        if (this.isSearched == 0) {
            this.rmanOrdersInterfaceSearch = new RmanOrdersInterfaceImpl();
        }
        this.displaySearchDialog = true;

    }

    search() {
        this.isSearched = 1;
        this.rmanOrdersInterface = this.rmanOrdersInterfaceSearch;
        this.getAllRmanOrdersInterface();
    }
    cancelSearch() {
        this.displaySearchDialog = false;
        this.rmanOrdersInterfaceSearch = new RmanOrdersInterfaceImpl();
    }
}


class RmanOrdersInterfaceImpl implements RmanOrdersInterface {
    constructor(public origRmanLineId?, public sourceLineId?, public origLastUpdatedBy?, public territory?, public lineNum?, public salesrep?, public shippingEntityId?, public productOrgId?, public billToCountry?, public cancelledQty?, public unitSellingPrice?, public topModelLineId?, public fobPointCode?, public origCreatedBy?, public serviceRefOrder?, public billToLocation?, public scheduleShipDate?, public customerPoNum?, public interfaceProcessId?, public region?, public rmanAcctRuleId?, public orderedQuantity?, public shippingOrgCode?, public taskId?, public lineAttribute6?, public lineAttribute5?, public headerAttribute10?, public lineAttribute8?, public headerAttribute11?, public lineAttribute7?, public headerAttribute12?, public soldToCustomer?, public lineAttribute2?, public headerAttribute13?, public lineAttribute1?, public headerAttribute14?, public origCreationDate?, public lineAttribute4?, public headerAttribute15?, public repUnitSellingPrice?, public lineAttribute3?, public lineAttribute9?, public errorFlag?, public cancelledDate?, public fxRate?, public objVersionNumber?, public lineAttribute12?, public shippedQuantity?, public lineAttribute13?, public lineAttribute10?, public lineAttribute11?, public shipToLocation?, public expenditureType?, public dealNumber?, public billToCustomer?, public lineAttribute14?, public projectId?, public lineAttribute15?, public shipToCustomer?, public refOrderNumber?, public dealLineNumber?, public bookingCurrency?, public lineType?, public projectNumber?, public orderType?, public revrecAcctRule?, public roleName?, public bookedDate?, public accountingRuleName?, public serviceEndDate?, public domesticInternational?, public taskNumber?, public shipToCountry?, public revenueCategory?, public processedDate?, public orderNumModifier?, public revrecStDate?, public fxDate?, public revrecAcctScope?, public priceList?, public orginalOrderNumber?, public projectCost?, public sourceHeaderId?, public lastUpdateDate?, public orginalLineId?, public fob?, public unitListPrice?, public bookingEntityName?, public createdBy?, public lastUpdatedBy?, public revrecDelay?, public productOrgName?, public sourceLineNumber?, public taskName?, public creationDate?, public shippableFlag?, public productName?, public lineStatus?, public stdWarranty?, public origLastUpdateDate?, public linkToLineId?, public orginalLineNumber?, public repUnitListPrice?, public rmanLineId?, public headerAttribute1?, public errorMessage?, public headerAttribute6?, public headerAttribute7?, public headerAttribute8?, public headerAttribute9?, public headerAttribute2?, public fmvHistoryFlag?, public headerAttribute3?, public lineCategoryCode?, public servicePeriod?, public headerAttribute4?, public projectName?, public headerAttribute5?, public serviceRefOrdLineNum?, public interfaceStatus?, public revrecEndDate?, public fulfilledQuantity?, public orderStatus?, public serviceStartDate?, public endCustomer?, public revrecHoldType?, public actualFulfilledDate?, public carveOutFlag?, public serviceDuration?, public serviceNumber?, public productId?, public invoiceFlag?, public bookingEntityId?, public extWarranty?, public orderSource?, public revrecAccount?, public orderNumber?, public orderedDate?, public lineCost?, public releasedStatus?) { }
}

interface ILabels {
    [index: string]: string;
}
