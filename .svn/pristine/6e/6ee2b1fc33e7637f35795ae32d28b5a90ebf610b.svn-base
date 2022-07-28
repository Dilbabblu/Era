import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { RmanEntityParametersV } from './rmanEntityParametersV';
import { RmanEntityParametersVLabels } from './rmanEntityParametersVLabels';
import { RmanEntityParametersVService } from './rmanEntityParametersVservice';


declare var $: any;

@Component({
    templateUrl: './rmanEntityParametersV.component.html',
    selector: 'rmanEntityParametersV-data',
    providers: [RmanEntityParametersVService]
})

export class RmanEntityParametersVComponent implements OnInit {

    displayDialog: boolean;

    displaySearchDialog: boolean;

    rmanEntityParametersV: any = new RmanEntityParametersVImpl();

    rmanEntityParametersVSearch: any = new RmanEntityParametersVImpl();

    isSerached: number = 0;

    selectedRmanEntityParametersV: RmanEntityParametersV;

    newRmanEntityParametersV: boolean;

    rmanEntityParametersVList: any[];

    cols: any[];
    columns: ILabels;

    columnOptions: any[];

    paginationOptions: any;

    pages: {};

    public items: MenuItem[];

    datasource: any[];
    pageSize: number;
    totalElements: number;




    constructor(private rmanEntityParametersVService: RmanEntityParametersVService) {
        // generate list code
        this.paginationOptions = { 'pageNumber': 0, 'pageSize': '10000' };
    }

    ngOnInit() {

        this.getAllRmanEntityParametersV();

        this.cols = [];
        let cols: any = [];
        cols["tableName"] = "tableName";
        cols["startDateActive"] = "startDateActive";
        cols["entityId"] = "entityId";
        cols["entityCategory"] = "entityCategory";
        cols["columnName"] = "columnName";
        cols["entityDescription"] = "entityDescription";
        cols["enabledFlag"] = "enabledFlag";
        cols["columnSequence"] = "columnSequence";
        cols["parameterName"] = "parameterName";
        cols["entityParameterId"] = "entityParameterId";
        cols["columnType"] = "columnType";
        cols["parameterDescription"] = "parameterDescription";
        cols["endDateActive"] = "endDateActive";
        cols["columnSize"] = "columnSize";
        cols["entityName"] = "entityName";
        let rmanEntityParametersVLabels = new RmanEntityParametersVLabels();
        this.columns = rmanEntityParametersVLabels.fieldLabels;
        this.columnOptions = [];
        this.cols = [];
        for (let prop in this.columns) {
            this.cols.push({ field: prop, header: this.columns[prop] });
            this.columnOptions.push({ label: this.columns[prop], value: prop });
        }

        this.items =
            [
                {
                    label: 'Add', icon: 'fa-plus', command: (event: any) => {
                        this.showDialogToAdd();
                    }
                },
                {
                    label: 'Columns', icon: 'fa-columns', command: (event: any) => {
                        this.toggleColumnMenu();
                    }
                },
                {
                    label: 'Search', icon: 'fa-search', command: (event: any) => {
                        this.showDialogToSearch();
                    }
                },
                {
                    label: 'Reset', icon: 'fa-refresh', command: (event: any) => {
                        this.paginationOptions = {};
                        this.rmanEntityParametersV = new RmanEntityParametersVImpl();
                        this.getAllRmanEntityParametersV();
                    }
                }
            ];
    }




    getAllRmanEntityParametersV() {
        this.rmanEntityParametersVService.getAllRmanEntityParametersV(this.paginationOptions, this.rmanEntityParametersV).then((rmanEntityParametersVList: any) => {
            this.datasource = rmanEntityParametersVList.content;
            this.rmanEntityParametersVList = rmanEntityParametersVList.content;
            this.totalElements = rmanEntityParametersVList.totalElements;
            this.pageSize = rmanEntityParametersVList.size;
            this.displaySearchDialog = false;
        });
    }


    getRmanEntityParametersV(event: any) {

        let first: number = event.first;
        let rows: number = event.rows;
        let pageNumber: number = first / rows;
        this.paginationOptions = { 'pageNumber': pageNumber, 'pageSize': this.pageSize, 'sortField': event.sortField, 'sortOrder': event.sortOrder };
        this.rmanEntityParametersVService.getAllRmanEntityParametersV(this.paginationOptions, this.rmanEntityParametersV).then((rmanEntityParametersVList: any) => {
            this.datasource = rmanEntityParametersVList.content;
            this.rmanEntityParametersVList = rmanEntityParametersVList.content;
            this.totalElements = rmanEntityParametersVList.totalElements;
            this.pageSize = rmanEntityParametersVList.size;
        });

    }


    showDialogToAdd() {

        this.newRmanEntityParametersV = true;
        this.rmanEntityParametersV = new RmanEntityParametersVImpl();
        this.displayDialog = true;

    }


    save() {

        if (this.newRmanEntityParametersV) {
            this.rmanEntityParametersVService.saveRmanEntityParametersV(this.rmanEntityParametersV).then((response: any) => {
                this.getAllRmanEntityParametersV();
            });
        }
        else {
            this.rmanEntityParametersVService.updateRmanEntityParametersV(this.rmanEntityParametersV).then((response: any) => {
                this.getAllRmanEntityParametersV();
            });
        }

        this.rmanEntityParametersV = new RmanEntityParametersVImpl();

        this.displayDialog = false;

    }


    delete(rmanEntityParametersV: any) {
        this.rmanEntityParametersV = rmanEntityParametersV;
        this.displayDialog = false;
        if (window.confirm('Are you sure you want to delete this record?')) {
            this.rmanEntityParametersVList.splice(this.findSelectedRmanEntityParametersVIndex(), 1);
            this.rmanEntityParametersVService.deleteRmanEntityParametersV(this.rmanEntityParametersV).then((response: any) => {
                this.rmanEntityParametersV = new RmanEntityParametersVImpl();
                this.getAllRmanEntityParametersV();
            });
        }

    }

    editRow(rmanEntityParametersV: any) {
        this.newRmanEntityParametersV = false;
        this.rmanEntityParametersV = this.cloneRmanEntityParametersV(rmanEntityParametersV);
        this.displayDialog = true;

    }


    findSelectedRmanEntityParametersVIndex(): number {
        return this.rmanEntityParametersVList.indexOf(this.selectedRmanEntityParametersV);
    }

    onRowSelect(event: any) {

    }

    cloneRmanEntityParametersV(c: RmanEntityParametersV): RmanEntityParametersV {
        let rmanEntityParametersV: any
            = new RmanEntityParametersVImpl();
        for (let prop in c) {
            rmanEntityParametersV[prop] = c[prop];
        }
        return rmanEntityParametersV;
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
        if (this.isSerached == 0) {
            this.rmanEntityParametersVSearch = new RmanEntityParametersVImpl();
        }
        this.displaySearchDialog = true;

    }

    search() {
        this.isSerached = 1;
        this.rmanEntityParametersV = this.rmanEntityParametersVSearch;
        this.getAllRmanEntityParametersV();
    }
}


class RmanEntityParametersVImpl {
    constructor(public tableName?: any, public startDateActive?: any, public entityId?: any, public entityCategory?: any, public columnName?: any, public entityDescription?: any, public enabledFlag?: any, public columnSequence?: any, public parameterName?: any, public entityParameterId?: any, public columnType?: any, public parameterDescription?: any, public endDateActive?: any, public columnSize?: any, public entityName?: any) { }
}

interface ILabels {
    [index: string]: string;
}
