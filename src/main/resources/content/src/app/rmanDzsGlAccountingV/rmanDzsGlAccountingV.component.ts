import { Component, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Table } from 'primeng/table';
import { RmanDzsGlAccountingV } from './rmanDzsGlAccountingV';
import { RmanDzsGlAccountingVLabels } from './rmanDzsGlAccountingVLabels';
import { RmanDzsGlAccountingVService } from './rmanDzsGlAccountingVservice';
declare var require: any;
const appSettings = require('../appsettings');

declare var $: any;

@Component({
    templateUrl: './rmanDzsGlAccountingV.component.html',
    selector: 'rmanDzsGlAccountingV-data',
    providers: [RmanDzsGlAccountingVService]
})

export class RmanDzsGlAccountingVComponent {

    displayDialog: boolean;
    loading: boolean = true;

    displaySearchDialog: boolean;

    rmanDzsGlAccountingV: any = {};

    rmanDzsGlAccountingVSearch: any = {};

    isSerached: number = 0;

    @Input() arrId: any;

    selectedRmanDzsGlAccountingV: RmanDzsGlAccountingV;

    newRmanDzsGlAccountingV: boolean;

    rmanDzsGlAccountingVList: any[] = [];

    cols: any[];
    columns: ILabels;

    columnOptions: any[];

    paginationOptions = {};

    pages: {};

    datasource: any[];
    pageSize: number;
    totalElements: number;
    collapsed: boolean = true;

    noData = appSettings.noData;



    constructor(private route: ActivatedRoute, private rmanDzsGlAccountingVService: RmanDzsGlAccountingVService) {
        // generate list code
        this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    }

    ngOnInit() {
        this.route.params.subscribe(params => {
            this.arrId = params['id'];
        });
        this.cols = [];
        let cols: any = [];
        cols["dealArrangementId"] = "dealArrangementId";
        cols["accountDescription"] = "accountDescription";
        cols["amountFc"] = "amountFc";
        cols["sourceLineNumber"] = "sourceLineNumber";
        cols["drCr"] = "drCr";
        cols["postedFlag"] = "postedFlag";
        cols["lineStatus"] = "lineStatus";
        cols["glDate"] = "glDate";
        cols["currencyCode"] = "currencyCode";
        cols["periodName"] = "periodName";
        cols["account"] = "account";
        cols["amountTc"] = "amountTc";
        cols["orderNumber"] = "orderNumber";
        cols["rmanInterfaceId"] = "rmanInterfaceId";
        cols["dealArrangementNumber"] = "dealArrangementNumber";
        cols["dealArrangementName"] = "dealArrangementName";
        let rmanDzsGlAccountingVLabels = new RmanDzsGlAccountingVLabels();

        this.columns = rmanDzsGlAccountingVLabels.fieldLabels;

        this.columnOptions = [];

        this.cols = [];
        for (let prop in this.columns) {
            this.cols.push({ field: prop, header: this.columns[prop] });
            this.columnOptions.push({ label: this.columns[prop], value: prop });
        }
    }


    reset(dt: Table) {
        this.paginationOptions = {};
        this.rmanDzsGlAccountingV = {};
        this.rmanDzsGlAccountingVSearch = {};
        dt.reset();
    }

    getAllRmanDzsGlAccountingV() {
        this.loading = true;
        this.rmanDzsGlAccountingVService.getAllRmanDzsGlAccountingV(this.paginationOptions, this.rmanDzsGlAccountingV).then((rmanDzsGlAccountingVList: any) => {
            this.loading = false;
            this.datasource = rmanDzsGlAccountingVList.content;
            this.rmanDzsGlAccountingVList = rmanDzsGlAccountingVList.content;
            this.rmanDzsGlAccountingVList = this.rmanDzsGlAccountingVList.slice();
            this.totalElements = rmanDzsGlAccountingVList.totalElements;
            this.pageSize = rmanDzsGlAccountingVList.size;
            this.displaySearchDialog = false;
        });
    }


    getRmanDzsGlAccountingV(event: any) {
        this.loading = true;
        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.rmanDzsGlAccountingVService.getAllRmanDzsGlAccountingV(this.paginationOptions, this.rmanDzsGlAccountingV).then((rmanDzsGlAccountingVList: any) => {
            this.loading = false;
            this.datasource = rmanDzsGlAccountingVList.content;
            this.rmanDzsGlAccountingVList = rmanDzsGlAccountingVList.content;
            this.totalElements = rmanDzsGlAccountingVList.totalElements;
            this.pageSize = rmanDzsGlAccountingVList.size;
        });

    }

    exportExcel() {
        let serviceUrl = this.rmanDzsGlAccountingVService.getServiceUrl(this.paginationOptions, this.rmanDzsGlAccountingVSearch, 1);
        window.location.href = serviceUrl;

    }

    showDialogToAdd() {
        this.newRmanDzsGlAccountingV = true;
        this.rmanDzsGlAccountingV = new RmanDzsGlAccountingVImpl();
        this.displayDialog = true;
    }

    save() {
        if (this.newRmanDzsGlAccountingV) {
            this.rmanDzsGlAccountingVService.saveRmanDzsGlAccountingV(this.rmanDzsGlAccountingV).then((response: any) => {
                this.getAllRmanDzsGlAccountingV();
            });
        }
        else {
            this.rmanDzsGlAccountingVService.updateRmanDzsGlAccountingV(this.rmanDzsGlAccountingV).then((response: any) => {
                this.getAllRmanDzsGlAccountingV();
            });
        }
        this.rmanDzsGlAccountingV = new RmanDzsGlAccountingVImpl();
        this.displayDialog = false;
    }


    delete(rmanDzsGlAccountingV: any) {
        this.rmanDzsGlAccountingV = rmanDzsGlAccountingV;
        this.displayDialog = false;
        if (window.confirm('Are you sure you want to delete this record?')) {
            this.rmanDzsGlAccountingVList.splice(this.findSelectedRmanDzsGlAccountingVIndex(), 1);
            this.rmanDzsGlAccountingVService.deleteRmanDzsGlAccountingV(this.rmanDzsGlAccountingV).then(response => {
                this.rmanDzsGlAccountingV = new RmanDzsGlAccountingVImpl();
                this.getAllRmanDzsGlAccountingV();
            });
        }

    }

    editRow(rmanDzsGlAccountingV: any) {
        this.newRmanDzsGlAccountingV = false;
        this.rmanDzsGlAccountingV = this.cloneRmanDzsGlAccountingV(rmanDzsGlAccountingV);
        this.displayDialog = true;

    }


    findSelectedRmanDzsGlAccountingVIndex(): number {
        return this.rmanDzsGlAccountingVList.indexOf(this.selectedRmanDzsGlAccountingV);
    }

    onRowSelect(event: any) {

    }

    cloneRmanDzsGlAccountingV(c: RmanDzsGlAccountingV): RmanDzsGlAccountingV {
        let rmanDzsGlAccountingV = new RmanDzsGlAccountingVImpl();
        for (let prop in c) {
            rmanDzsGlAccountingV[prop] = c[prop];
        }
        return rmanDzsGlAccountingV;
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
        this.rmanDzsGlAccountingVSearch = {};

        if (this.isSerached == 0) {
            this.rmanDzsGlAccountingVSearch = {};
        }
        this.displaySearchDialog = true;

    }

    search() {

        this.isSerached = 1;
        this.rmanDzsGlAccountingV = this.rmanDzsGlAccountingVSearch;
        this.displaySearchDialog = false;
        this.paginationOptions = {};
        this.getAllRmanDzsGlAccountingV();
    }

    onBeforeToggle(evt: any) {
        this.collapsed = evt.collapsed;
    }
}


export class RmanDzsGlAccountingVImpl implements RmanDzsGlAccountingV {
    constructor(public dealArrangementId?: any, public accountDescription?: any, public amountFc?: any, public sourceLineNumber?: any, public drCr?: any, public postedFlag?: any, public lineStatus?: any, public glDate?: any, public currencyCode?: any, public periodName?: any, public account?: any, public amountTc?: any, public orderNumber?: any, public rmanInterfaceId?: any, public dealArrangementNumber?: any, public dealArrangementName?: any) { }
}

interface ILabels {
    [index: string]: string;
}
