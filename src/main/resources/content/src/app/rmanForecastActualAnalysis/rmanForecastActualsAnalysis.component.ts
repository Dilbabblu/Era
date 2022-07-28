import { ChangeDetectorRef, Component } from '@angular/core';
import { ActivatedRoute, NavigationEnd, Router } from "@angular/router";
//import { ToastsManager } from 'ng2-toastr/ng2-toastr';
import { RmanForecastActualsAnalysisService } from './rmanForecastActualsAnalysisservice';
declare var $: any;
declare var require: any;
const appSettings = require('../appsettings');


@Component({
    templateUrl: './rmanForecastActualsAnalysis.component.html',
    selector: 'rmanForecastActualsAnalysis-data',
    providers: [RmanForecastActualsAnalysisService]
})

export class RmanForecastActualsAnalysisComponent {
    noData = appSettings.noData;
    paginationOptions: any;
    cref: ChangeDetectorRef;
    arrIdK: any;
    rmanForecastActualsAnalysisList: any[];
    data: any[];
    pageSize: number;
    totalElements: number;

    constructor(private ref: ChangeDetectorRef, private rmanForecastActualsAnalysisService: RmanForecastActualsAnalysisService, private router: Router, private route: ActivatedRoute) {
        this.paginationOptions = { 'pageNumber': 1, 'pageSize': '100000' };
        this.router.events.subscribe((event) => {
            if (event instanceof NavigationEnd) {
                this.arrIdK = event.url.split('/')[3];
                this.cref = ref;
                this.getAllRmanForecastActualsAnalysis();
            }
        });
    }

    ngAfterViewChecked() {
        this.cref.detectChanges();
    }

    ngOnInit() {
        this.search();
    }

    private buildPivot() {
        var sum = $.pivotUtilities.aggregatorTemplates.sum;
        var numberFormat = $.pivotUtilities.numberFormat;
        var intFormat = numberFormat({ digitsAfterDecimal: 0 });
        $("#pivot").pivot(this.data,
            {
                rows: ["elementType", "recordType"],
                cols: ["quarterName"],
                aggregator: sum(intFormat)(["amount"]),
                aggregatorName: "Sum",
                rendererName: "Table",
                hideTotals: true
            });

        var i = 0;
        var labels = ["Quarters", "Element", "Record Type"];

        $(".pvtAxisLabel").each(function () {
            $(this).html(labels[i++]);
        });
        $(".pvtTotal").hide();
        $(".colTotal").hide();
        $(".pvtTotalLabel").hide();
        $(".pvtGrandTotal").hide();
    }

    search() {
        this.getAllRmanForecastActualsAnalysis();
    }

    getAllRmanForecastActualsAnalysis() {

        this.rmanForecastActualsAnalysisService.getAllRmanForecastActualsAnalysis(this.paginationOptions, { "arrangementId": this.arrIdK }).then((rmanForecastActualsAnalysisList: any) => {
            this.data = rmanForecastActualsAnalysisList.content;
            this.totalElements = rmanForecastActualsAnalysisList.totalElements;
            this.pageSize = rmanForecastActualsAnalysisList.size;
            this.buildPivot();
            this.cref.markForCheck();
            this.cref.detectChanges();
        });
    }
}

class RmanForecastActualsAnalysisImpl {
    constructor(
        arrangementId: any,
        arrangementName: any,
        sku: any,
        qty: any,
        elementType: any,
        netPrice: any,
        expectedBookingAmount: any,
        recordType: any,
        amount: any,
        quarterName: any,
        glPeriod: any,
        startDate: any
    ) { }
}

interface ILabels {
    [index: string]: string;
}
