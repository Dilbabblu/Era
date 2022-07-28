import { Component } from '@angular/core';
import { NavigationEnd, Router } from "@angular/router";
import { Table } from 'primeng/table';
import { NotificationService } from '../shared/notifications.service';
import { RmanDealRfcstV } from './rmanDealRfcstV';
import { RmanDealRfcstVService } from './rmanDealRfcstVservice';
declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');

@Component({
    templateUrl: './rmanDealRfcstV2.component.html',
    selector: 'rmanDealRfcstV-data',
    providers: [RmanDealRfcstVService]
})

export class RmanDealRfcstVComponent {

    displayDialog: boolean;

    displaySearchDialog: boolean;

    rmanDealRfcstV: any = new RmanDealRfcstVImpl();

    rmanDealRfcstVSearch: any = new RmanDealRfcstVImpl();

    isSerached: number = 0;

    selectedRmanDealRfcstV: RmanDealRfcstV;

    newRmanDealRfcstV: boolean;

    rDealFCSTViewList: any[];

    rmanDealRfcstVList: RmanDealRfcstV[];

    cols: any[];
    columns: ILabels;
    noData = appSettings.noData;
    totalRecords: any;

    columnOptions: any[];

    paginationOptions = {};

    pages: {};

    // @Input() arrId: any;

    arrIdK: any;

    datasource: any[];
    pageSize: number;
    totalElements: number;
    collapsed: boolean = true;




    loading: boolean;



    constructor(private rmanDealRfcstVService: RmanDealRfcstVService, private router: Router,
        private notificationService: NotificationService) {

        // generate list code
        this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
       
        this.router.events.subscribe((event) => {
            if (event instanceof NavigationEnd) {
                this.arrIdK = event.url.split('/')[3];
            }
        });


    }

    ngOnInit() {
        this.cols = [];
        this.getDealForecastingView();
    }


    reset(dt: Table) {
        dt.reset();
        this.paginationOptions = {};
        this.rmanDealRfcstV = new RmanDealRfcstVImpl();
        this.getDealForecastingView();
    }

    exportExcel() {
        let serviceUrl = this.rmanDealRfcstVService.getServiceUrl(this.paginationOptions, { 'arrangementId': this.arrIdK }, 1);
        window.location.href = serviceUrl;

    }

    getAllRmanDealRfcstV() {
        this.loading = true;
        this.rmanDealRfcstVService.getAllRmanDealRfcstV(this.paginationOptions, { 'arrangementId': this.arrIdK }).then((rmanDealRfcstVList: any) => {
            this.datasource = rmanDealRfcstVList.content;
            this.rmanDealRfcstVList = rmanDealRfcstVList.content;
            this.loading = false;
            this.totalElements = rmanDealRfcstVList.totalElements;
            this.pageSize = rmanDealRfcstVList.size;
            this.displaySearchDialog = false;
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
        });
    }


    getRmanDealRfcstV(event: any) {

        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.loading = true;
        this.rmanDealRfcstVService.getAllRmanDealRfcstV(this.paginationOptions, { 'arrangementId': this.arrIdK }).then((rmanDealRfcstVList: any) => {
            this.datasource = rmanDealRfcstVList.content;
            this.rmanDealRfcstVList = rmanDealRfcstVList.content;
            this.loading = false;
            this.totalElements = rmanDealRfcstVList.totalElements;
            this.pageSize = rmanDealRfcstVList.size;
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            this.loading = false;
        });

    }


    getDealForecastingView() {
        this.rmanDealRfcstVService.getRmanForecastView(this.arrIdK).then((data: any) => {
            this.rDealFCSTViewList = data.Content;
            let dTemp = this.rDealFCSTViewList[0];
            this.cols = [];
            for (let prop in dTemp) {
                if (['Element Type'].includes(prop)) {
                    this.cols.push({
                        field: prop,
                        header: prop,
                        style: { 'width': '100px', 'text-align': 'left' },
                        hide: false
                    });

                } else if (['Arrangement Number', 'SKU'].includes(prop)) {
                    this.cols.push({
                        field: prop,
                        header: prop,
                        style: { 'width': '180px' },
                        hide: false
                    });
                } else if (['Expected Booking Amount'].includes(prop)) {
                    this.cols.push({
                        field: prop,
                        header: prop,
                        style: { 'width': '180px', 'text-align': 'right' },
                        hide: false
                    });
                } else {
                    this.cols.push({
                        field: prop,
                        header: prop,
                        style: { 'width': '100px', 'text-align': 'right' },
                        hide: false
                    });
                }


            }
            this.rDealFCSTViewList = data.Content;
            this.totalRecords = this.rDealFCSTViewList.length;
            $.unblockUI();
        }).catch((err: any) => {
            this.notificationService.showError('Error occured while getting data');
            $.unblockUI();
        });

    }

    fieldType(fieldValue: any) {
        return typeof fieldValue;
    }

    showDialogToAdd() {

        this.newRmanDealRfcstV = true;
        this.rmanDealRfcstV = new RmanDealRfcstVImpl();
        this.displayDialog = true;

    }

    save() {

        if (this.newRmanDealRfcstV) {
            this.loading = true;
            this.rmanDealRfcstVService.saveRmanDealRfcstV(this.rmanDealRfcstV).then((response: any) => {
                this.getAllRmanDealRfcstV();

            }).catch((err: any) => {
                this.notificationService.showError('Error occured while saving the data');
                this.loading = false;
            });
        }
        else {
            this.loading = true;
            this.rmanDealRfcstVService.updateRmanDealRfcstV(this.rmanDealRfcstV).then((response: any) => {
                this.getAllRmanDealRfcstV();

            }).catch((err: any) => {
                this.notificationService.showError('Error occured while updating the data');
                this.loading = false;
            });
        }

        this.rmanDealRfcstV = new RmanDealRfcstVImpl();

        this.displayDialog = false;

    }


    delete(rmanDealRfcstV: any) {
        this.rmanDealRfcstV = rmanDealRfcstV;
        this.displayDialog = false;

        if (window.confirm('Are you sure you want to delete this record?')) {
            this.rmanDealRfcstVList.splice(this.findSelectedRmanDealRfcstVIndex(), 1);
            this.rmanDealRfcstVService.deleteRmanDealRfcstV(this.rmanDealRfcstV).then(response => {
                this.rmanDealRfcstV = new RmanDealRfcstVImpl();
                this.getAllRmanDealRfcstV();
            });
        }

    }

    editRow(rmanDealRfcstV: any) {
        this.newRmanDealRfcstV = false;
        this.rmanDealRfcstV = this.cloneRmanDealRfcstV(rmanDealRfcstV);
        this.displayDialog = true;

    }


    findSelectedRmanDealRfcstVIndex(): number {
        return this.rmanDealRfcstVList.indexOf(this.selectedRmanDealRfcstV);
    }

    onRowSelect(event: any) {

    }

    cloneRmanDealRfcstV(c: RmanDealRfcstV): RmanDealRfcstV {
        let rmanDealRfcstV = new RmanDealRfcstVImpl();
        for (let prop in c) {
            rmanDealRfcstV[prop] = c[prop];
        }
        return rmanDealRfcstV;
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

        this.rmanDealRfcstVSearch = new RmanDealRfcstVImpl();

        if (this.isSerached == 0) {
            this.rmanDealRfcstVSearch = new RmanDealRfcstVImpl();
        }
        this.displaySearchDialog = true;

    }

    search() {

        this.isSerached = 1;
        this.rmanDealRfcstV = this.rmanDealRfcstVSearch;
        this.getAllRmanDealRfcstV();
    }

    onBeforeToggle(evt: any) {
        this.collapsed = evt.collapsed;
    }
}


class RmanDealRfcstVImpl implements RmanDealRfcstV {
    constructor(public glPeriod?: any, public expectedBookingAmount?: any, public amount?: any, public qty?: any, public netPrice?: any, public elementType?: any, public startDate?: any, public arrangementName?: any, public sku?: any, public arrangementId?: any) { }
}

interface ILabels {
    [index: string]: string;
}
