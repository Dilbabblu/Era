import { Component, Input } from '@angular/core';
import { RmanContReleaseEventsV } from './rmanContReleaseEventsV';
import { RmanContReleaseEventsVLabels } from './rmanContReleaseEventsVLabels';
import { RmanContReleaseEventsVService } from './rmanContReleaseEventsVservice';

declare var $: any;

@Component({
    templateUrl: './rmanContReleaseEventsV.component.html',
    selector: 'rmanContReleaseEventsV-data',
    providers: [RmanContReleaseEventsVService]
})

export class RmanContReleaseEventsVComponent {

    displayDialog: boolean;

    displaySearchDialog: boolean;

    rmanContReleaseEventsV: RmanContReleaseEventsV = new RmanContReleaseEventsVImpl();

    rmanContReleaseEventsVSearch: RmanContReleaseEventsV = new RmanContReleaseEventsVImpl();

    isSerached: number = 0;

    selectedRmanContReleaseEventsV: RmanContReleaseEventsV;

    @Input() pDealLineId: any;

    newRmanContReleaseEventsV: boolean;

    rmanContReleaseEventsVList: RmanContReleaseEventsV[];

    cols: any[];
    columns: ILabels;

    columnOptions: any[];

    paginationOptions = {};

    pages: {};

    datasource: any[];
    pageSize: number;
    totalElements: number;

    collapsedReleaseEvents: boolean = true;

    loading: boolean;

    constructor(private rmanContReleaseEventsVService: RmanContReleaseEventsVService) {
        // generate list code
        this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    }

    ngOnInit() {
        this.getAllRmanContReleaseEventsV();
        this.cols = [];
        let cols: any = [];
        cols["dealArrangementNumber"] = "dealArrangementNumber";
        cols["lineNum"] = "lineNum";
        cols["dealLineNumber"] = "dealLineNumber";
        cols["sourceLineId"] = "sourceLineId";
        cols["sourceLineNumber"] = "sourceLineNumber";
        cols["revenue"] = "revenue";
        cols["applyType"] = "applyType";
        cols["dealArrangementName"] = "dealArrangementName";
        cols["contingencyName"] = "contingencyName";
        cols["dealArrangementId"] = "dealArrangementId";
        cols["ranking"] = "ranking";
        cols["templateName"] = "templateName";
        cols["deferredAmount"] = "deferredAmount";
        cols["sno"] = "sno";
        cols["dealNumber"] = "dealNumber";
        cols["so"] = "so";
        cols["deferredReleaseAmount"] = "deferredReleaseAmount";
        cols["undeferredAmount"] = "undeferredAmount";
        cols["deliveredAmount"] = "deliveredAmount";
        cols["bookedAmount"] = "bookedAmount";
        cols["dealLineId"] = "dealLineId";
        cols["ruleCategory"] = "ruleCategory";
        cols["trxCurrency"] = "trxCurrency";
        let rmanContReleaseEventsVLabels = new RmanContReleaseEventsVLabels();
        this.columns = rmanContReleaseEventsVLabels.fieldLabels;
        this.columnOptions = [];
        this.cols = [];
        for (let prop in this.columns) {
            this.cols.push({ field: prop, header: this.columns[prop] });
            this.columnOptions.push({ label: this.columns[prop], value: prop });
        }
    }

    getAllRmanContReleaseEventsV() {
        this.loading = true;
        this.rmanContReleaseEventsVService.getAllRmanContReleaseEventsV(this.paginationOptions, { 'dealLineId': this.pDealLineId }).then((rmanContReleaseEventsVList: any) => {
            this.datasource = rmanContReleaseEventsVList.content;
            this.totalElements = rmanContReleaseEventsVList.totalElements;
            this.pageSize = rmanContReleaseEventsVList.size;
            this.loading = false;
            this.displaySearchDialog = false;
        });
    }


    getRmanContReleaseEventsV(event: any) {

        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.rmanContReleaseEventsVService.getAllRmanContReleaseEventsV(this.paginationOptions, { 'dealLineId': this.pDealLineId }).then((rmanContReleaseEventsVList: any) => {
            this.datasource = rmanContReleaseEventsVList.content;
            this.totalElements = rmanContReleaseEventsVList.totalElements;
            this.pageSize = rmanContReleaseEventsVList.size;
        });

    }


    showDialogToAdd() {
        this.newRmanContReleaseEventsV = true;
        this.rmanContReleaseEventsV = new RmanContReleaseEventsVImpl();
        this.displayDialog = true;
    }


    save() {
        if (this.newRmanContReleaseEventsV) {
            this.rmanContReleaseEventsVService.saveRmanContReleaseEventsV(this.rmanContReleaseEventsV).then((response: any) => {
                this.getAllRmanContReleaseEventsV();
            });
        }
        else {
            this.rmanContReleaseEventsVService.updateRmanContReleaseEventsV(this.rmanContReleaseEventsV).then((response: any) => {
                this.getAllRmanContReleaseEventsV();
            });
        }
        this.rmanContReleaseEventsV = new RmanContReleaseEventsVImpl();
        this.displayDialog = false;
    }


    delete(rmanContReleaseEventsV: any) {
        this.rmanContReleaseEventsV = rmanContReleaseEventsV;
        this.displayDialog = false;

        if (window.confirm('Are you sure you want to delete this record?')) {
            this.rmanContReleaseEventsVList.splice(this.findSelectedRmanContReleaseEventsVIndex(), 1);
            this.rmanContReleaseEventsVService.deleteRmanContReleaseEventsV(this.rmanContReleaseEventsV).then(response => {
                this.rmanContReleaseEventsV = new RmanContReleaseEventsVImpl();
                this.getAllRmanContReleaseEventsV();
            });
        }

    }

    editRow(rmanContReleaseEventsV: any) {
        this.newRmanContReleaseEventsV = false;
        this.rmanContReleaseEventsV = this.cloneRmanContReleaseEventsV(rmanContReleaseEventsV);
        this.displayDialog = true;

    }


    findSelectedRmanContReleaseEventsVIndex(): number {
        return this.rmanContReleaseEventsVList.indexOf(this.selectedRmanContReleaseEventsV);
    }

    onRowSelect(event: any) {

    }

    cloneRmanContReleaseEventsV(c: RmanContReleaseEventsV): RmanContReleaseEventsV {
        let rmanContReleaseEventsV = new RmanContReleaseEventsVImpl();
        for (let prop in c) {
            rmanContReleaseEventsV[prop] = c[prop];
        }
        return rmanContReleaseEventsV;
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

        this.rmanContReleaseEventsVSearch = new RmanContReleaseEventsVImpl();

        if (this.isSerached == 0) {
            this.rmanContReleaseEventsVSearch = new RmanContReleaseEventsVImpl();
        }
        this.displaySearchDialog = true;

    }

    search() {

        this.isSerached = 1;
        this.rmanContReleaseEventsV = this.rmanContReleaseEventsVSearch;
        this.getAllRmanContReleaseEventsV();
    }

    onBeforeToggleReleaseEvents(evt: any) {
        this.collapsedReleaseEvents = evt.collapsed;
    }
}


export class RmanContReleaseEventsVImpl implements RmanContReleaseEventsV {
    constructor(public dealArrangementNumber?: any, public lineNum?: any, public dealLineNumber?: any, public sourceLineId?: any, public sourceLineNumber?: any, public revenue?: any, public applyType?: any, public dealArrangementName?: any, public contingencyName?: any, public dealArrangementId?: any, public ranking?: any, public templateName?: any, public deferredAmount?: any, public sno?: any, public dealNumber?: any, public so?: any, public deferredReleaseAmount?: any, public undeferredAmount?: any, public deliveredAmount?: any, public bookedAmount?: any, dealLineId?: any, public ruleCategory?: any, public trxCurrency?: any) { }
}

interface ILabels {
    [index: string]: string;
}
